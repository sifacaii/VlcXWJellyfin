package org.xwalk.core;

import SevenZip.Compression.LZMA.Decoder;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkDecompressor.class */
public class XWalkDecompressor {
    private static final String[] MANDATORY_LIBRARIES = {"libxwalkcore.so"};
    private static final String[] MANDATORY_RESOURCES = {"libxwalkcore.so", "classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak"};
    private static final String TAG = "XWalkDecompressor";
    private static final int STREAM_BUFFER_SIZE = 4096;
    private static final int LZMA_PROP_SIZE = 5;
    private static final int LZMA_OUTSIZE = 8;

    XWalkDecompressor() {
    }

    public static boolean isLibraryCompressed() {
        String[] strArr;
        for (String library : MANDATORY_LIBRARIES) {
            try {
                InputStream input = openRawResource(library);
                try {
                    input.close();
                } catch (IOException e) {
                }
            } catch (Resources.NotFoundException e2) {
                return false;
            }
        }
        return true;
    }

    public static boolean decompressLibrary() {
        String[] strArr;
        String libDir = XWalkEnvironment.getPrivateDataDir();
        File f = new File(libDir);
        if (f.exists() && f.isFile()) {
            f.delete();
        }
        if (f.exists() || f.mkdirs()) {
            long start = SystemClock.uptimeMillis();
            for (String library : MANDATORY_LIBRARIES) {
                try {
                    Log.d(TAG, "Decompressing " + library);
                    InputStream input = openRawResource(library);
                    extractLzmaToFile(input, new File(libDir, library));
                } catch (Resources.NotFoundException e) {
                    Log.d(TAG, library + " not found");
                    return false;
                } catch (IOException e2) {
                    Log.e(TAG, e2.getLocalizedMessage());
                    return false;
                }
            }
            Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - start) + " ms");
            return true;
        }
        return false;
    }

    public static boolean isResourceCompressed(String libFile) {
        String[] strArr;
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(libFile);
            for (String resource : MANDATORY_RESOURCES) {
                ZipEntry entry = zipFile.getEntry("assets" + File.separator + resource + ".lzma");
                if (entry == null) {
                    try {
                        zipFile.close();
                    } catch (IOException | NullPointerException e) {
                    }
                    return false;
                }
            }
            try {
                zipFile.close();
                return true;
            } catch (IOException | NullPointerException e2) {
                return true;
            }
        } catch (IOException e3) {
            try {
                zipFile.close();
            } catch (IOException | NullPointerException e4) {
            }
            return false;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException | NullPointerException e5) {
            }
            throw th;
        }
    }

    public static boolean extractResource(String libFile, String destDir) {
        String[] strArr;
        ZipEntry entry;
        Log.d(TAG, "Extract resource from Apk " + libFile);
        long start = SystemClock.uptimeMillis();
        ZipFile zipFile = null;
        try {
            try {
                zipFile = new ZipFile(libFile);
                for (String resource : MANDATORY_RESOURCES) {
                    if (isNativeLibrary(resource)) {
                        String abi = XWalkEnvironment.getDeviceAbi();
                        String path = "lib" + File.separator + abi + File.separator + resource;
                        entry = zipFile.getEntry(path);
                        if (entry == null && XWalkEnvironment.is64bitDevice()) {
                            if (abi.equals("arm64-v8a")) {
                                abi = "armeabi-v7a";
                            } else if (abi.equals("x86_64")) {
                                abi = "x86";
                            }
                            String path2 = "lib" + File.separator + abi + File.separator + resource;
                            entry = zipFile.getEntry(path2);
                        }
                    } else if (isAsset(resource)) {
                        String path3 = "assets" + File.separator + resource;
                        entry = zipFile.getEntry(path3);
                    } else {
                        entry = zipFile.getEntry(resource);
                    }
                    if (entry == null) {
                        Log.e(TAG, resource + " not found");
                        try {
                            zipFile.close();
                        } catch (IOException | NullPointerException e) {
                        }
                        return false;
                    }
                    Log.d(TAG, "Extracting " + resource);
                    extractStreamToFile(zipFile.getInputStream(entry), new File(destDir, resource));
                }
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e2) {
                }
                Log.d(TAG, "Time to extract : " + (SystemClock.uptimeMillis() - start) + " ms");
                return true;
            } catch (IOException e3) {
                Log.d(TAG, e3.getLocalizedMessage());
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e4) {
                }
                return false;
            }
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException | NullPointerException e5) {
            }
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static boolean decompressResource(String libFile, String destDir) {
        String[] strArr;
        Log.d(TAG, "Decompress resource from Apk " + libFile);
        long start = SystemClock.uptimeMillis();
        ArrayList arrayList = new ArrayList(MANDATORY_RESOURCES.length);
        ExecutorService pool = Executors.newFixedThreadPool(MANDATORY_RESOURCES.length);
        ZipFile zipFile = null;
        boolean success = true;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(libFile);
                for (String resource : MANDATORY_RESOURCES) {
                    try {
                        ZipEntry entry = zipFile2.getEntry("assets" + File.separator + resource + ".lzma");
                        if (entry == null) {
                            Log.e(TAG, resource + " not found");
                            try {
                                zipFile2.close();
                            } catch (IOException | NullPointerException e) {
                            }
                            return false;
                        }
                        File destFile = new File(destDir, resource);
                        arrayList.add(new DecompressResourceTask(zipFile2, entry, destFile));
                    } catch (Throwable th) {
                        pool.shutdown();
                        throw th;
                    }
                }
                try {
                    List<Future<Boolean>> futureList = pool.invokeAll(arrayList);
                    for (Future<Boolean> f : futureList) {
                        success &= f.get().booleanValue();
                    }
                    pool.shutdown();
                    try {
                        zipFile2.close();
                    } catch (IOException | NullPointerException e2) {
                    }
                    Log.d(TAG, "Time to decompress : " + (SystemClock.uptimeMillis() - start) + " ms");
                    return success;
                } catch (InterruptedException | ExecutionException | RejectedExecutionException e3) {
                    Log.d(TAG, "Failed to execute decompression");
                    pool.shutdown();
                    try {
                        zipFile2.close();
                    } catch (IOException | NullPointerException e4) {
                    }
                    return false;
                }
            } catch (IOException e5) {
                Log.d(TAG, e5.getLocalizedMessage());
                try {
                    zipFile.close();
                } catch (IOException | NullPointerException e6) {
                }
                return false;
            }
        } catch (Throwable th2) {
            try {
                zipFile.close();
            } catch (IOException | NullPointerException e7) {
            }
            throw th2;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkDecompressor$DecompressResourceTask.class */
    private static class DecompressResourceTask implements Callable<Boolean> {
        ZipFile mZipFile;
        ZipEntry mZipEntry;
        File mDestFile;

        DecompressResourceTask(ZipFile zipFile, ZipEntry zipEntry, File destFile) {
            this.mZipFile = zipFile;
            this.mZipEntry = zipEntry;
            this.mDestFile = destFile;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            try {
                Log.d(XWalkDecompressor.TAG, "Decompressing " + this.mZipEntry.getName());
                XWalkDecompressor.extractLzmaToFile(this.mZipFile.getInputStream(this.mZipEntry), this.mDestFile);
                return true;
            } catch (IOException e) {
                Log.e(XWalkDecompressor.TAG, e.getLocalizedMessage());
                return false;
            }
        }
    }

    private static boolean isNativeLibrary(String resource) {
        return resource.endsWith(".so");
    }

    private static boolean isAsset(String resource) {
        return resource.endsWith(".dat") || resource.endsWith(".pak");
    }

    private static InputStream openRawResource(String library) throws Resources.NotFoundException {
        Context context = XWalkEnvironment.getApplicationContext();
        Resources res = context.getResources();
        String libraryName = library.split("\\.")[0];
        int id = res.getIdentifier(libraryName, "raw", context.getPackageName());
        return res.openRawResource(id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extractLzmaToFile(InputStream srcStream, File destFile) throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            try {
                input = new BufferedInputStream(srcStream);
                output = new BufferedOutputStream(new FileOutputStream(destFile));
                byte[] properties = new byte[5];
                if (input.read(properties, 0, 5) != 5) {
                    throw new IOException("Input lzma file is too short");
                }
                Decoder decoder = new Decoder();
                if (!decoder.SetDecoderProperties(properties)) {
                    throw new IOException("Incorrect lzma properties");
                }
                long outSize = 0;
                for (int i = 0; i < 8; i++) {
                    int v = input.read();
                    if (v < 0) {
                        Log.w(TAG, "Can't read stream size");
                    }
                    outSize |= v << (8 * i);
                }
                if (!decoder.Code(input, output, outSize)) {
                    throw new IOException("Error in data stream");
                }
            } catch (IOException e) {
                if (destFile.isFile()) {
                    destFile.delete();
                }
                throw e;
            }
        } finally {
            try {
                output.flush();
            } catch (IOException | NullPointerException e2) {
            }
            try {
                output.close();
            } catch (IOException | NullPointerException e3) {
            }
            try {
                input.close();
            } catch (IOException | NullPointerException e4) {
            }
        }
    }

    private static void extractStreamToFile(InputStream input, File file) throws IOException {
        OutputStream output = null;
        try {
            try {
                input.available();
                output = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                while (true) {
                    int len = input.read(buffer);
                    if (len < 0) {
                        break;
                    }
                    output.write(buffer, 0, len);
                }
                try {
                    output.flush();
                } catch (IOException | NullPointerException e) {
                }
                try {
                    output.close();
                } catch (IOException | NullPointerException e2) {
                }
                try {
                    input.close();
                } catch (IOException | NullPointerException e3) {
                }
            } catch (Throwable th) {
                try {
                    output.flush();
                } catch (IOException | NullPointerException e4) {
                }
                try {
                    output.close();
                } catch (IOException | NullPointerException e5) {
                }
                try {
                    input.close();
                } catch (IOException | NullPointerException e6) {
                }
                throw th;
            }
        } catch (IOException e7) {
            if (file.isFile()) {
                file.delete();
            }
            throw e7;
        }
    }
}
