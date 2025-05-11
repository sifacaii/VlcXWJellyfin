package org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ContextUtils.class */
public class ContextUtils {
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;
    private static String sProcessName;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ContextUtils.class.desiredAssertionStatus();
    }

    static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ContextUtils$Holder.class */
    private static class Holder {
        private static SharedPreferences sSharedPreferences = ContextUtils.access$000();

        private Holder() {
        }
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    @MainDex
    public static void initApplicationContext(Context appContext) {
        if (!$assertionsDisabled && sApplicationContext != null && sApplicationContext != appContext && ((ContextWrapper) sApplicationContext).getBaseContext() != appContext) {
            throw new AssertionError();
        }
        initJavaSideApplicationContext(appContext);
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sApplicationContext);
    }

    public static SharedPreferences getAppSharedPreferences() {
        return Holder.sSharedPreferences;
    }

    @VisibleForTesting
    public static void initApplicationContextForTests(Context appContext) {
        initJavaSideApplicationContext(appContext);
        SharedPreferences unused = Holder.sSharedPreferences = fetchAppSharedPreferences();
    }

    private static void initJavaSideApplicationContext(Context appContext) {
        if (!$assertionsDisabled && appContext == null) {
            throw new AssertionError();
        }
        if (BuildConfig.DCHECK_IS_ON && (appContext instanceof Application)) {
            appContext = new ContextWrapper(appContext);
        }
        sApplicationContext = appContext;
    }

    public static AssetManager getApplicationAssets() {
        Context applicationContext = getApplicationContext();
        while (true) {
            Context context = applicationContext;
            if (context instanceof ContextWrapper) {
                applicationContext = ((ContextWrapper) context).getBaseContext();
            } else {
                return context.getAssets();
            }
        }
    }

    public static boolean isIsolatedProcess() {
        try {
            return ((Boolean) Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProcessName() {
        if (sProcessName != null) {
            return sProcessName;
        }
        try {
            Class<?> activityThreadClazz = Class.forName("android.app.ActivityThread");
            Object activityThread = activityThreadClazz.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            sProcessName = (String) activityThreadClazz.getMethod("getProcessName", new Class[0]).invoke(activityThread, new Object[0]);
            return sProcessName;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
