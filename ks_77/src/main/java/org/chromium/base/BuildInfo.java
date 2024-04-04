package org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.compat.ApiHelperForP;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/BuildInfo.class */
public class BuildInfo {
    private static final String TAG = "BuildInfo";
    private static final int MAX_FINGERPRINT_LENGTH = 128;
    private static PackageInfo sBrowserPackageInfo;
    private static boolean sInitialized;
    private static String sFirebaseAppId;
    public final String hostPackageLabel;
    public final long hostVersionCode;
    public final String packageName;
    public final long versionCode;
    public final String versionName;
    public final String installerPackageName;
    public final String gmsVersionCode;
    public final String abiString;
    public final String androidBuildFingerprint;
    public final String extractedFileSuffix;
    public final String customThemes;
    public final String resourcesVersion;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !BuildInfo.class.desiredAssertionStatus();
        sFirebaseAppId = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/BuildInfo$Holder.class */
    public static class Holder {
        private static BuildInfo sInstance = new BuildInfo();

        private Holder() {
        }
    }

    @CalledByNative
    private static String[] getAll() {
        BuildInfo buildInfo = getInstance();
        String hostPackageName = ContextUtils.getApplicationContext().getPackageName();
        String[] strArr = new String[24];
        strArr[0] = Build.BRAND;
        strArr[1] = Build.DEVICE;
        strArr[2] = Build.ID;
        strArr[3] = Build.MANUFACTURER;
        strArr[4] = Build.MODEL;
        strArr[5] = String.valueOf(Build.VERSION.SDK_INT);
        strArr[6] = Build.TYPE;
        strArr[7] = Build.BOARD;
        strArr[8] = hostPackageName;
        strArr[9] = String.valueOf(buildInfo.hostVersionCode);
        strArr[10] = buildInfo.hostPackageLabel;
        strArr[11] = buildInfo.packageName;
        strArr[12] = String.valueOf(buildInfo.versionCode);
        strArr[13] = buildInfo.versionName;
        strArr[14] = buildInfo.androidBuildFingerprint;
        strArr[15] = buildInfo.gmsVersionCode;
        strArr[16] = buildInfo.installerPackageName;
        strArr[17] = buildInfo.abiString;
        strArr[18] = sFirebaseAppId;
        strArr[19] = buildInfo.customThemes;
        strArr[20] = buildInfo.resourcesVersion;
        strArr[21] = buildInfo.extractedFileSuffix;
        strArr[22] = isAtLeastQ() ? "1" : "0";
        strArr[23] = isDebugAndroid() ? "1" : "0";
        return strArr;
    }

    private static String nullToEmpty(CharSequence seq) {
        return seq == null ? CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE : seq.toString();
    }

    private static long packageVersionCode(PackageInfo pi) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.getLongVersionCode(pi);
        }
        return pi.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo packageInfo) {
        if (!$assertionsDisabled && sInitialized) {
            throw new AssertionError();
        }
        sBrowserPackageInfo = packageInfo;
    }

    public static BuildInfo getInstance() {
        return Holder.sInstance;
    }

    private BuildInfo() {
        String str;
        sInitialized = true;
        try {
            Context appContext = ContextUtils.getApplicationContext();
            String hostPackageName = appContext.getPackageName();
            PackageManager pm = appContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(hostPackageName, 0);
            this.hostVersionCode = packageVersionCode(pi);
            if (sBrowserPackageInfo != null) {
                this.packageName = sBrowserPackageInfo.packageName;
                this.versionCode = packageVersionCode(sBrowserPackageInfo);
                this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);
                sBrowserPackageInfo = null;
            } else {
                this.packageName = hostPackageName;
                this.versionCode = this.hostVersionCode;
                this.versionName = nullToEmpty(pi.versionName);
            }
            this.hostPackageLabel = nullToEmpty(pm.getApplicationLabel(pi.applicationInfo));
            this.installerPackageName = nullToEmpty(pm.getInstallerPackageName(this.packageName));
            PackageInfo gmsPackageInfo = null;
            try {
                gmsPackageInfo = pm.getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e) {
                Log.d(TAG, "GMS package is not found.", e);
            }
            if (gmsPackageInfo != null) {
                str = String.valueOf(packageVersionCode(gmsPackageInfo));
            } else {
                str = "gms versionCode not available.";
            }
            this.gmsVersionCode = str;
            String hasCustomThemes = "true";
            try {
                pm.getPackageInfo("projekt.substratum", 0);
            } catch (PackageManager.NameNotFoundException e2) {
                hasCustomThemes = "false";
            }
            this.customThemes = hasCustomThemes;
            String currentResourcesVersion = "Not Enabled";
            if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) {
                try {
                    currentResourcesVersion = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);
                } catch (Exception e3) {
                    currentResourcesVersion = "Not found";
                }
            }
            this.resourcesVersion = currentResourcesVersion;
            if (Build.VERSION.SDK_INT >= 21) {
                this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);
            } else {
                this.abiString = String.format("ABI1: %s, ABI2: %s", Build.CPU_ABI, Build.CPU_ABI2);
            }
            this.extractedFileSuffix = String.format("@%x_%x", Long.valueOf(this.versionCode), Long.valueOf(pi.lastUpdateTime));
            this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static boolean isDebugAndroid() {
        return "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
    }

    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean targetsAtLeastQ() {
        return ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion >= 29;
    }

    public static void setFirebaseAppId(String id) {
        if (!$assertionsDisabled && !sFirebaseAppId.equals(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE)) {
            throw new AssertionError();
        }
        sFirebaseAppId = id;
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }
}
