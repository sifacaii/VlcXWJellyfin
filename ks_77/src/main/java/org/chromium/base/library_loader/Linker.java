package org.chromium.base.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.Log;
import org.chromium.base.StreamUtil;
import org.chromium.base.annotations.AccessedByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/library_loader/Linker.class */
public abstract class Linker {
    private static final String TAG = "LibraryLoader";
    protected static final String LINKER_JNI_LIBRARY = "chromium_android_linker";
    protected static final boolean DEBUG = false;
    public static final String EXTRA_LINKER_SHARED_RELROS = "org.chromium.base.android.linker.shared_relros";
    private String mTestRunnerClassName;
    protected static final int ADDRESS_SPACE_RESERVATION = 201326592;
    protected static final Object sLock;
    private static Linker sSingleton;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/library_loader/Linker$TestRunner.class */
    public interface TestRunner {
        boolean runChecks(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void prepareLibraryLoad(@Nullable String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void finishLibraryLoad();

    public abstract void useSharedRelros(Bundle bundle);

    public abstract Bundle getSharedRelros();

    public abstract void disableSharedRelros();

    public abstract void initServiceProcess(long j);

    public abstract long getBaseLoadAddress();

    abstract void loadLibraryImpl(String str, boolean z);

    private static native long nativeGetRandomBaseLoadAddress();

    static {
        $assertionsDisabled = !Linker.class.desiredAssertionStatus();
        sLock = new Object();
    }

    public static Linker getInstance() {
        Linker linker;
        synchronized (sLock) {
            if (sSingleton == null) {
                sSingleton = new LegacyLinker();
                Log.i(TAG, "Using linker: LegacyLinker", new Object[0]);
            }
            linker = sSingleton;
        }
        return linker;
    }

    public static boolean areTestsEnabled() {
        return NativeLibraries.sEnableLinkerTests;
    }

    private static void assertLinkerTestsAreEnabled() {
        if (!$assertionsDisabled && !NativeLibraries.sEnableLinkerTests) {
            throw new AssertionError("Testing method called in non-testing context");
        }
    }

    public final String getTestRunnerClassNameForTesting() {
        String str;
        assertLinkerTestsAreEnabled();
        synchronized (sLock) {
            str = this.mTestRunnerClassName;
        }
        return str;
    }

    public static final void setupForTesting(String testRunnerClassName) {
        assertLinkerTestsAreEnabled();
        synchronized (sLock) {
            getInstance().mTestRunnerClassName = testRunnerClassName;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void runTestRunnerClassForTesting(boolean inBrowserProcess) {
        assertLinkerTestsAreEnabled();
        synchronized (sLock) {
            if (this.mTestRunnerClassName == null) {
                Log.wtf(TAG, "Linker runtime tests not set up for this process", new Object[0]);
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
            }
            TestRunner testRunner = null;
            try {
                testRunner = (TestRunner) Class.forName(this.mTestRunnerClassName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                Log.wtf(TAG, "Could not instantiate test runner class by name", e);
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
            }
            if (!testRunner.runChecks(inBrowserProcess)) {
                Log.wtf(TAG, "Linker runtime tests failed in this process", new Object[0]);
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
            }
            Log.i(TAG, "All linker tests passed", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isChromiumLinkerLibrary(String library) {
        return library.equals(LINKER_JNI_LIBRARY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getRandomBaseLoadAddress() {
        long address = nativeGetRandomBaseLoadAddress();
        return address;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLibrary(String libFilePath) {
        loadLibraryImpl(libFilePath, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadLibraryNoFixedAddress(String libFilePath) {
        loadLibraryImpl(libFilePath, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/library_loader/Linker$LibInfo.class */
    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new Parcelable.Creator<LibInfo>() { // from class: org.chromium.base.library_loader.Linker.LibInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LibInfo createFromParcel(Parcel in) {
                return new LibInfo(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LibInfo[] newArray(int size) {
                return new LibInfo[size];
            }
        };
        @AccessedByNative
        public long mLoadAddress;
        @AccessedByNative
        public long mLoadSize;
        @AccessedByNative
        public long mRelroStart;
        @AccessedByNative
        public long mRelroSize;
        @AccessedByNative
        public int mRelroFd;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LibInfo() {
            this.mRelroFd = -1;
        }

        LibInfo(Parcel in) {
            this.mRelroFd = -1;
            this.mLoadAddress = in.readLong();
            this.mLoadSize = in.readLong();
            this.mRelroStart = in.readLong();
            this.mRelroSize = in.readLong();
            ParcelFileDescriptor fd = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(in);
            if (fd != null) {
                this.mRelroFd = fd.detachFd();
            }
        }

        public void close() {
            if (this.mRelroFd >= 0) {
                StreamUtil.closeQuietly(ParcelFileDescriptor.adoptFd(this.mRelroFd));
                this.mRelroFd = -1;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            if (this.mRelroFd >= 0) {
                out.writeLong(this.mLoadAddress);
                out.writeLong(this.mLoadSize);
                out.writeLong(this.mRelroStart);
                out.writeLong(this.mRelroSize);
                try {
                    ParcelFileDescriptor fd = ParcelFileDescriptor.fromFd(this.mRelroFd);
                    fd.writeToParcel(out, 0);
                    fd.close();
                } catch (IOException e) {
                    Log.e(Linker.TAG, "Can't write LibInfo file descriptor to parcel", e);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle createBundleFromLibInfoMap(HashMap<String, LibInfo> map) {
        Bundle bundle = new Bundle(map.size());
        for (Map.Entry<String, LibInfo> entry : map.entrySet()) {
            bundle.putParcelable(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, LibInfo> createLibInfoMapFromBundle(Bundle bundle) {
        HashMap<String, LibInfo> map = new HashMap<>();
        for (String library : bundle.keySet()) {
            LibInfo libInfo = (LibInfo) bundle.getParcelable(library);
            map.put(library, libInfo);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeLibInfoMap(HashMap<String, LibInfo> map) {
        for (Map.Entry<String, LibInfo> entry : map.entrySet()) {
            entry.getValue().close();
        }
    }
}
