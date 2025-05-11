package org.chromium.build;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/build/BuildHooksAndroid.class */
public abstract class BuildHooksAndroid {
    private static BuildHooksAndroid sInstance;

    protected abstract Resources getResourcesImpl(Context context);

    protected abstract AssetManager getAssetsImpl(Context context);

    protected abstract Resources.Theme getThemeImpl(Context context);

    protected abstract void setThemeImpl(Context context, int i);

    protected abstract Context createConfigurationContextImpl(Context context);

    protected abstract int getIdentifierImpl(Resources resources, String str, String str2, String str3);

    protected abstract boolean isEnabledImpl();

    protected abstract void initCustomResourcesImpl(Context context);

    protected abstract void maybeRecordResourceMetricsImpl();

    private static BuildHooksAndroid get() {
        if (sInstance == null) {
            sInstance = constructBuildHooksAndroidImpl();
        }
        return sInstance;
    }

    private static BuildHooksAndroid constructBuildHooksAndroidImpl() {
        String str;
        try {
            if (System.currentTimeMillis() > 0) {
                str = "org.chromium.build.BuildHooksAndroidImpl";
            } else {
                str = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
            }
            String implClazzName = str;
            Class<?> implClazz = Class.forName(implClazzName);
            return (BuildHooksAndroid) implClazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Resources getResources(Context context) {
        return get().getResourcesImpl(context);
    }

    public static AssetManager getAssets(Context context) {
        return get().getAssetsImpl(context);
    }

    public static Resources.Theme getTheme(Context context) {
        return get().getThemeImpl(context);
    }

    public static void setTheme(Context context, int theme) {
        get().setThemeImpl(context, theme);
    }

    public static Context createConfigurationContext(Context context) {
        return get().createConfigurationContextImpl(context);
    }

    public static int getIdentifier(Resources resources, String name, String defType, String defPackage) {
        return get().getIdentifierImpl(resources, name, defType, defPackage);
    }

    public static boolean isEnabled() {
        return get().isEnabledImpl();
    }

    public static void initCustomResources(Context context) {
        get().initCustomResourcesImpl(context);
    }

    public static void maybeRecordResourceMetrics() {
        get().maybeRecordResourceMetricsImpl();
    }
}
