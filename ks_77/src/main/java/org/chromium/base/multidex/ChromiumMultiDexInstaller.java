package org.chromium.base.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.multidex.MultiDex;

import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/multidex/ChromiumMultiDexInstaller.class */
public class ChromiumMultiDexInstaller {
    private static final String TAG = "base_multidex";
    private static final String IGNORE_MULTIDEX_KEY = ".ignore_multidex";

    @VisibleForTesting
    public static void install(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (!shouldInstallMultiDex(context)) {
            Log.i(TAG, "Skipping multidex installation: not needed for process.", new Object[0]);
            return;
        }
        MultiDex.install(context);
        Log.i(TAG, "Completed multidex installation.", new Object[0]);
    }

    private static boolean shouldInstallMultiDex(Context context) {
        if (ContextUtils.isIsolatedProcess()) {
            return false;
        }
        String currentProcessName = ContextUtils.getProcessName();
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo appInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (appInfo == null || appInfo.metaData == null) {
                return true;
            }
            return !appInfo.metaData.getBoolean(new StringBuilder().append(currentProcessName).append(IGNORE_MULTIDEX_KEY).toString(), false);
        } catch (PackageManager.NameNotFoundException e) {
            return true;
        }
    }
}
