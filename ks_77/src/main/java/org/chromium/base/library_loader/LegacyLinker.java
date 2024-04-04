package org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.library_loader.Linker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/library_loader/LegacyLinker.class */
public class LegacyLinker extends Linker {
    private static final String TAG = "LegacyLinker";
    private boolean mInitialized;
    private boolean mWaitForSharedRelros;
    private Bundle mSharedRelros;
    private HashMap<String, Linker.LibInfo> mLoadedLibraries;
    static final /* synthetic */ boolean $assertionsDisabled;
    private boolean mInBrowserProcess = true;
    private long mBaseLoadAddress = -1;
    private long mCurrentLoadAddress = -1;

    private static native boolean nativeLoadLibrary(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeAddZipArchivePath(String str);

    private static native boolean nativeCreateSharedRelro(String str, long j, Linker.LibInfo libInfo);

    private static native boolean nativeUseSharedRelro(String str, Linker.LibInfo libInfo);

    static {
        $assertionsDisabled = !LegacyLinker.class.desiredAssertionStatus();
    }

    @GuardedBy("sLock")
    private void ensureInitializedLocked() {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        if (this.mInitialized) {
            return;
        }
        loadLinkerJniLibrary();
        this.mInitialized = true;
    }

    @Override // org.chromium.base.library_loader.Linker
    public void prepareLibraryLoad(@Nullable String apkFilePath) {
        synchronized (sLock) {
            ensureInitializedLocked();
            if (apkFilePath != null) {
                nativeAddZipArchivePath(apkFilePath);
            }
            if (this.mInBrowserProcess) {
                setupBaseLoadAddressLocked();
            }
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    public void finishLibraryLoad() {
        synchronized (sLock) {
            ensureInitializedLocked();
            if (this.mLoadedLibraries != null) {
                if (this.mInBrowserProcess) {
                    this.mSharedRelros = createBundleFromLibInfoMap(this.mLoadedLibraries);
                    useSharedRelrosLocked(this.mSharedRelros);
                }
                if (this.mWaitForSharedRelros) {
                    if (!$assertionsDisabled && this.mInBrowserProcess) {
                        throw new AssertionError();
                    }
                    while (this.mSharedRelros == null) {
                        try {
                            sLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    useSharedRelrosLocked(this.mSharedRelros);
                    this.mSharedRelros.clear();
                    this.mSharedRelros = null;
                }
            }
            if (NativeLibraries.sEnableLinkerTests) {
                runTestRunnerClassForTesting(this.mInBrowserProcess);
            }
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    public void useSharedRelros(Bundle bundle) {
        Bundle clonedBundle = null;
        if (bundle != null) {
            bundle.setClassLoader(Linker.LibInfo.class.getClassLoader());
            clonedBundle = new Bundle(Linker.LibInfo.class.getClassLoader());
            Parcel parcel = Parcel.obtain();
            bundle.writeToParcel(parcel, 0);
            parcel.setDataPosition(0);
            clonedBundle.readFromParcel(parcel);
            parcel.recycle();
        }
        synchronized (sLock) {
            this.mSharedRelros = clonedBundle;
            sLock.notifyAll();
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    public Bundle getSharedRelros() {
        synchronized (sLock) {
            if (!this.mInBrowserProcess) {
                return null;
            }
            return this.mSharedRelros;
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    public void disableSharedRelros() {
        synchronized (sLock) {
            ensureInitializedLocked();
            this.mInBrowserProcess = false;
            this.mWaitForSharedRelros = false;
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    public void initServiceProcess(long baseLoadAddress) {
        synchronized (sLock) {
            ensureInitializedLocked();
            this.mInBrowserProcess = false;
            this.mWaitForSharedRelros = true;
            this.mBaseLoadAddress = baseLoadAddress;
            this.mCurrentLoadAddress = baseLoadAddress;
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    public long getBaseLoadAddress() {
        synchronized (sLock) {
            ensureInitializedLocked();
            if (!this.mInBrowserProcess) {
                Log.w(TAG, "Shared RELRO sections are disabled in this process!", new Object[0]);
                return 0L;
            }
            setupBaseLoadAddressLocked();
            return this.mBaseLoadAddress;
        }
    }

    @GuardedBy("sLock")
    private void setupBaseLoadAddressLocked() {
        if (this.mBaseLoadAddress == -1) {
            this.mBaseLoadAddress = getRandomBaseLoadAddress();
            this.mCurrentLoadAddress = this.mBaseLoadAddress;
            if (this.mBaseLoadAddress == 0) {
                Log.w(TAG, "Disabling shared RELROs due address space pressure", new Object[0]);
                this.mWaitForSharedRelros = false;
            }
        }
    }

    private void dumpBundle(Bundle bundle) {
    }

    @GuardedBy("sLock")
    private void useSharedRelrosLocked(Bundle bundle) {
        if (!$assertionsDisabled && !Thread.holdsLock(sLock)) {
            throw new AssertionError();
        }
        if (bundle == null || this.mLoadedLibraries == null) {
            return;
        }
        HashMap<String, Linker.LibInfo> relroMap = createLibInfoMapFromBundle(bundle);
        for (Map.Entry<String, Linker.LibInfo> entry : relroMap.entrySet()) {
            String libName = entry.getKey();
            Linker.LibInfo libInfo = entry.getValue();
            if (!nativeUseSharedRelro(libName, libInfo)) {
                Log.w(TAG, "Could not use shared RELRO section for %s", libName);
            }
        }
        if (!this.mInBrowserProcess) {
            closeLibInfoMap(relroMap);
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    protected static void loadLinkerJniLibrary() {
        LibraryLoader.setEnvForNative();
        try {
            System.loadLibrary("chromium_android_linker");
        } catch (UnsatisfiedLinkError e) {
            if (LibraryLoader.PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION) {
                System.load(LibraryLoader.getExtractedLibraryPath(ContextUtils.getApplicationContext().getApplicationInfo(), "chromium_android_linker"));
            }
        }
    }

    @Override // org.chromium.base.library_loader.Linker
    void loadLibraryImpl(String libFilePath, boolean isFixedAddressPermitted) {
        synchronized (sLock) {
            ensureInitializedLocked();
            if (this.mLoadedLibraries == null) {
                this.mLoadedLibraries = new HashMap<>();
            }
            if (this.mLoadedLibraries.containsKey(libFilePath)) {
                return;
            }
            Linker.LibInfo libInfo = new Linker.LibInfo();
            long loadAddress = 0;
            if (isFixedAddressPermitted && (this.mInBrowserProcess || this.mWaitForSharedRelros)) {
                loadAddress = this.mCurrentLoadAddress;
                if (loadAddress > this.mBaseLoadAddress + 201326592) {
                    String errorMessage = "Load address outside reservation, for: " + libFilePath;
                    Log.e(TAG, errorMessage, new Object[0]);
                    throw new UnsatisfiedLinkError(errorMessage);
                }
            }
            if (!nativeLoadLibrary(libFilePath, loadAddress, libInfo)) {
                String errorMessage2 = "Unable to load library: " + libFilePath;
                Log.e(TAG, errorMessage2, new Object[0]);
                throw new UnsatisfiedLinkError(errorMessage2);
            }
            if (NativeLibraries.sEnableLinkerTests) {
                String tag = this.mInBrowserProcess ? "BROWSER_LIBRARY_ADDRESS" : "RENDERER_LIBRARY_ADDRESS";
                Log.i(TAG, String.format(Locale.US, "%s: %s %x", tag, libFilePath, Long.valueOf(libInfo.mLoadAddress)), new Object[0]);
            }
            if (this.mInBrowserProcess && !nativeCreateSharedRelro(libFilePath, this.mCurrentLoadAddress, libInfo)) {
                Log.w(TAG, String.format(Locale.US, "Could not create shared RELRO for %s at %x", libFilePath, Long.valueOf(this.mCurrentLoadAddress)), new Object[0]);
            }
            if (loadAddress != 0 && this.mCurrentLoadAddress != 0) {
                this.mCurrentLoadAddress = libInfo.mLoadAddress + libInfo.mLoadSize;
            }
            this.mLoadedLibraries.put(libFilePath, libInfo);
        }
    }
}
