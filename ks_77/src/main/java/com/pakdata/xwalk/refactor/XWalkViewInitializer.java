package com.pakdata.xwalk.refactor;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkViewInitializer.class */
public class XWalkViewInitializer {
    public static void DoInit(Context context) {
        File extCacheDir;
        XWalkViewDelegate.init(null, context);
        XWalkPreferences.setValue(XWalkPreferences.ENABLE_EXTENSIONS, false);
        XWalkPathHelper.initialize();
        XWalkPathHelper.setCacheDirectory(context.getApplicationContext().getCacheDir().getPath());
        String state = Environment.getExternalStorageState();
        if (("mounted".equals(state) || "mounted_ro".equals(state)) && null != (extCacheDir = context.getApplicationContext().getExternalCacheDir())) {
            XWalkPathHelper.setExternalCacheDirectory(extCacheDir.getPath());
        }
    }
}
