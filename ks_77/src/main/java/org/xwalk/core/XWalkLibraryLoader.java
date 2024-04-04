package org.xwalk.core;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"NoAndroidAsyncTaskCheck"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader.class */
public class XWalkLibraryLoader {
    private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
    private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
    private static final String TAG = "XWalkLibraryLoader";
    private static AsyncTask<Void, Integer, Integer> sActiveTask;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$ActivateListener.class */
    public interface ActivateListener {
        void onActivateStarted();

        void onActivateFailed();

        void onActivateCompleted();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$DecompressListener.class */
    public interface DecompressListener {
        void onDecompressStarted();

        void onDecompressCancelled();

        void onDecompressCompleted();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$DownloadListener.class */
    public interface DownloadListener {
        void onDownloadStarted();

        void onDownloadUpdated(int i);

        void onDownloadCancelled();

        void onDownloadCompleted(Uri uri);

        void onDownloadFailed(int i, int i2);
    }

    XWalkLibraryLoader() {
    }

    public static boolean isInitializing() {
        return sActiveTask != null && ((sActiveTask instanceof DecompressTask) || (sActiveTask instanceof ActivateTask));
    }

    public static boolean isDownloading() {
        return sActiveTask != null && ((sActiveTask instanceof DownloadManagerTask) || (sActiveTask instanceof HttpDownloadTask));
    }

    public static boolean isSharedLibrary() {
        return XWalkCoreWrapper.getInstance().isSharedMode();
    }

    public static boolean isLibraryReady() {
        return XWalkCoreWrapper.getInstance() != null;
    }

    public static int getLibraryStatus() {
        return XWalkCoreWrapper.getCoreStatus();
    }

    public static void prepareToInit(Context context) {
        XWalkEnvironment.init(context);
        XWalkCoreWrapper.handlePreInit(context.getClass().getName());
    }

    public static void finishInit(Context context) {
        XWalkCoreWrapper.handlePostInit(context.getClass().getName());
    }

    public static void startDecompress(DecompressListener listener) {
        new DecompressTask(listener).execute(new Void[0]);
    }

    public static boolean cancelDecompress() {
        return sActiveTask != null && (sActiveTask instanceof DecompressTask) && sActiveTask.cancel(true);
    }

    public static void startActivate(ActivateListener listener) {
        new ActivateTask(listener).execute(new Void[0]);
    }

    public static void startDownloadManager(DownloadListener listener, Context context, String url) {
        new DownloadManagerTask(listener, context, url).execute(new Void[0]);
    }

    public static boolean cancelDownloadManager() {
        return sActiveTask != null && (sActiveTask instanceof DownloadManagerTask) && sActiveTask.cancel(true);
    }

    public static void startHttpDownload(DownloadListener listener, Context context, String url) {
        new HttpDownloadTask(listener, context, url).execute(new Void[0]);
    }

    public static boolean cancelHttpDownload() {
        return sActiveTask != null && (sActiveTask instanceof HttpDownloadTask) && sActiveTask.cancel(true);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$DecompressTask.class */
    private static class DecompressTask extends AsyncTask<Void, Integer, Integer> {
        DecompressListener mListener;
        boolean mIsCompressed;
        boolean mIsDecompressed;

        DecompressTask(DecompressListener listener) {
            this.mListener = listener;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Log.d(XWalkLibraryLoader.TAG, "DecompressTask started");
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = this;
            this.mIsCompressed = XWalkDecompressor.isLibraryCompressed();
            if (this.mIsCompressed) {
                SharedPreferences sp = XWalkEnvironment.getSharedPreferences();
                int version = sp.getInt("version", 0);
                this.mIsDecompressed = version > 0 && version == 8;
            }
            if (!this.mIsCompressed || this.mIsDecompressed) {
                return;
            }
            this.mListener.onDecompressStarted();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... params) {
            if (!this.mIsCompressed || this.mIsDecompressed) {
                return 0;
            }
            if (XWalkDecompressor.decompressLibrary()) {
                SharedPreferences sp = XWalkEnvironment.getSharedPreferences();
                SharedPreferences.Editor spe = sp.edit();
                spe.putInt("version", 8);
                spe.apply();
                return 0;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(Integer result) {
            Log.d(XWalkLibraryLoader.TAG, "DecompressTask cancelled");
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
            this.mListener.onDecompressCancelled();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer result) {
            Log.d(XWalkLibraryLoader.TAG, "DecompressTask finished, " + result);
            if (result.intValue() == 0) {
                AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
                this.mListener.onDecompressCompleted();
                return;
            }
            throw new RuntimeException("Decompression Failed");
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$ActivateTask.class */
    private static class ActivateTask extends AsyncTask<Void, Integer, Integer> {
        ActivateListener mListener;

        ActivateTask(ActivateListener listener) {
            this.mListener = listener;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Log.d(XWalkLibraryLoader.TAG, "ActivateTask started");
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = this;
            this.mListener.onActivateStarted();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... params) {
            if (XWalkCoreWrapper.getInstance() != null) {
                return -1;
            }
            return Integer.valueOf(XWalkCoreWrapper.attachXWalkCore());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer result) {
            if (result.intValue() == 1) {
                XWalkCoreWrapper.dockXWalkCore();
            }
            Log.d(XWalkLibraryLoader.TAG, "ActivateTask finished, " + result);
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
            if (result.intValue() > 1) {
                this.mListener.onActivateFailed();
            } else {
                this.mListener.onActivateCompleted();
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$DownloadManagerTask.class */
    private static class DownloadManagerTask extends AsyncTask<Void, Integer, Integer> {
        private static final int QUERY_INTERVAL_MS = 100;
        private static final int MAX_PAUSED_COUNT = 6000;
        private DownloadListener mListener;
        private Context mContext;
        private String mDownloadUrl;
        private DownloadManager mDownloadManager;
        private long mDownloadId;

        DownloadManagerTask(DownloadListener listener, Context context, String url) {
            this.mListener = listener;
            this.mContext = context;
            this.mDownloadUrl = url;
            this.mDownloadManager = (DownloadManager) context.getSystemService("download");
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Log.d(XWalkLibraryLoader.TAG, "DownloadManagerTask started, " + this.mDownloadUrl);
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = this;
            String savedFile = XWalkLibraryLoader.DEFAULT_DOWNLOAD_FILE_NAME;
            try {
                String name = new File(new URL(this.mDownloadUrl).getPath()).getName();
                if (!name.isEmpty()) {
                    savedFile = name;
                }
                File downloadDir = this.mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                File downloadFile = new File(downloadDir, savedFile);
                if (downloadFile.isFile()) {
                    downloadFile.delete();
                }
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.mDownloadUrl));
                request.setDestinationInExternalFilesDir(this.mContext, Environment.DIRECTORY_DOWNLOADS, savedFile);
                if (isSilentDownload()) {
                    request.setNotificationVisibility(2);
                }
                this.mDownloadId = this.mDownloadManager.enqueue(request);
                this.mListener.onDownloadStarted();
            } catch (NullPointerException | MalformedURLException e) {
                Log.e(XWalkLibraryLoader.TAG, "Invalid download URL " + this.mDownloadUrl);
                this.mDownloadUrl = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... params) {
            if (this.mDownloadUrl == null) {
                return 16;
            }
            DownloadManager.Query query = new DownloadManager.Query().setFilterById(this.mDownloadId);
            int pausedCount = 0;
            while (!isCancelled()) {
                try {
                    Thread.sleep(100L);
                    Cursor cursor = this.mDownloadManager.query(query);
                    if (cursor != null && cursor.moveToFirst()) {
                        int totalIdx = cursor.getColumnIndex("total_size");
                        int downloadIdx = cursor.getColumnIndex("bytes_so_far");
                        int totalSize = cursor.getInt(totalIdx);
                        int downloadSize = cursor.getInt(downloadIdx);
                        if (totalSize > 0) {
                            publishProgress(Integer.valueOf(downloadSize), Integer.valueOf(totalSize));
                        }
                        int statusIdx = cursor.getColumnIndex("status");
                        int status = cursor.getInt(statusIdx);
                        if (status == 16 || status == 8) {
                            return Integer.valueOf(status);
                        }
                        if (status == 4) {
                            pausedCount++;
                            if (pausedCount == MAX_PAUSED_COUNT) {
                                return Integer.valueOf(status);
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
            return 2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            Log.d(XWalkLibraryLoader.TAG, "DownloadManagerTask updated: " + progress[0] + "/" + progress[1]);
            int percentage = 0;
            if (progress[1].intValue() > 0) {
                percentage = (int) ((progress[0].intValue() * 100.0d) / progress[1].intValue());
            }
            this.mListener.onDownloadUpdated(percentage);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(Integer result) {
            this.mDownloadManager.remove(this.mDownloadId);
            Log.d(XWalkLibraryLoader.TAG, "DownloadManagerTask cancelled");
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
            this.mListener.onDownloadCancelled();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer result) {
            Log.d(XWalkLibraryLoader.TAG, "DownloadManagerTask finished, " + result);
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
            if (result.intValue() == 8) {
                Uri uri = this.mDownloadManager.getUriForDownloadedFile(this.mDownloadId);
                Log.d(XWalkLibraryLoader.TAG, "Uri for downloaded file:" + uri.toString());
                if (uri.getScheme().equals("content")) {
                    DownloadManager.Query query = new DownloadManager.Query().setFilterById(this.mDownloadId);
                    Cursor cursor = this.mDownloadManager.query(query);
                    if (cursor != null && cursor.moveToFirst()) {
                        int index = cursor.getColumnIndex("local_filename");
                        uri = Uri.parse("file://" + cursor.getString(index));
                    }
                }
                this.mListener.onDownloadCompleted(uri);
                return;
            }
            int error = 1000;
            if (result.intValue() == 16) {
                DownloadManager.Query query2 = new DownloadManager.Query().setFilterById(this.mDownloadId);
                Cursor cursor2 = this.mDownloadManager.query(query2);
                if (cursor2 != null && cursor2.moveToFirst()) {
                    int reasonIdx = cursor2.getColumnIndex("reason");
                    error = cursor2.getInt(reasonIdx);
                }
            }
            this.mListener.onDownloadFailed(result.intValue(), error);
        }

        private boolean isSilentDownload() {
            try {
                PackageManager packageManager = this.mContext.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 4096);
                return Arrays.asList(packageInfo.requestedPermissions).contains(XWalkLibraryLoader.DOWNLOAD_WITHOUT_NOTIFICATION);
            } catch (PackageManager.NameNotFoundException | NullPointerException e) {
                return false;
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/xwalk/core/XWalkLibraryLoader$HttpDownloadTask.class */
    private static class HttpDownloadTask extends AsyncTask<Void, Integer, Integer> {
        private static final String XWALK_DOWNLOAD_DIR = "xwalk_download";
        private static final int UPDATE_INTERVAL_MS = 500;
        private static final int DOWNLOAD_SUCCESS = 0;
        private static final int DOWNLOAD_FAILED = -1;
        private DownloadListener mListener;
        private Context mContext;
        private String mDownloadUrl;
        private File mDownloadedFile;
        private long mProgressUpdateTime;

        HttpDownloadTask(DownloadListener listener, Context context, String url) {
            this.mListener = listener;
            this.mContext = context;
            this.mDownloadUrl = url;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask started, " + this.mDownloadUrl);
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = this;
            String savedFile = XWalkLibraryLoader.DEFAULT_DOWNLOAD_FILE_NAME;
            try {
                String name = new File(new URL(this.mDownloadUrl).getPath()).getName();
                if (!name.isEmpty()) {
                    savedFile = name;
                }
                this.mDownloadedFile = new File(this.mContext.getDir(XWALK_DOWNLOAD_DIR, 0), savedFile);
                this.mListener.onDownloadStarted();
            } catch (NullPointerException | MalformedURLException e) {
                Log.e(XWalkLibraryLoader.TAG, "Invalid download URL " + this.mDownloadUrl);
                this.mDownloadUrl = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:73:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01af  */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Integer doInBackground(java.lang.Void... r8) {
            /*
                Method dump skipped, instructions count: 444
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... progress) {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask updated: " + progress[0] + "/" + progress[1]);
            int percentage = 0;
            if (progress[1].intValue() > 0) {
                percentage = (int) ((progress[0].intValue() * 100.0d) / progress[1].intValue());
            }
            this.mListener.onDownloadUpdated(percentage);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled(Integer result) {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask cancelled");
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
            this.mListener.onDownloadCancelled();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer result) {
            Log.d(XWalkLibraryLoader.TAG, "HttpDownloadTask finished, " + result);
            AsyncTask unused = XWalkLibraryLoader.sActiveTask = null;
            if (result.intValue() == 0) {
                this.mListener.onDownloadCompleted(Uri.fromFile(this.mDownloadedFile));
            } else {
                this.mListener.onDownloadFailed(-1, 0);
            }
        }
    }
}
