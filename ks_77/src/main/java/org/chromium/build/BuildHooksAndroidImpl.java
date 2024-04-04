package org.chromium.build;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/build/BuildHooksAndroidImpl.class */
public class BuildHooksAndroidImpl extends BuildHooksAndroid {
    @Override // org.chromium.build.BuildHooksAndroid
    protected final Resources getResourcesImpl(Context context) {
        return null;
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected AssetManager getAssetsImpl(Context context) {
        return null;
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected Resources.Theme getThemeImpl(Context context) {
        return null;
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected void setThemeImpl(Context context, int theme) {
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected Context createConfigurationContextImpl(Context context) {
        return null;
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected int getIdentifierImpl(Resources resources, String name, String defType, String defPackage) {
        return resources.getIdentifier(name, defType, defPackage);
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected boolean isEnabledImpl() {
        return false;
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected void initCustomResourcesImpl(Context context) {
    }

    @Override // org.chromium.build.BuildHooksAndroid
    protected void maybeRecordResourceMetricsImpl() {
    }
}
