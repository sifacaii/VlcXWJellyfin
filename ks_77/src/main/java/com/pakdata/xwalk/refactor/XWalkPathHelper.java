package com.pakdata.xwalk.refactor;

import android.os.Environment;
import java.io.File;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkPathHelper.class */
public class XWalkPathHelper {
    private static final String TAG = "XWalkPathHelper";

    private static native void nativeSetDirectory(String str, String str2);

    public static void initialize() {
        nativeSetDirectory("EXTERNAL", Environment.getExternalStorageDirectory().getPath());
        String[] names = {"ALARMS", "DCIM", "DOWNLOADS", "MOVIES", "MUSIC", "NOTIFICATIONS", "PICTURES", "PODCASTS", "RINGTONES"};
        String[] dirs = {Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_DCIM, Environment.DIRECTORY_DOWNLOADS, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_PODCASTS, Environment.DIRECTORY_RINGTONES};
        for (int i = 0; i < names.length; i++) {
            File dir = Environment.getExternalStoragePublicDirectory(dirs[i]);
            if (null != dir) {
                nativeSetDirectory(names[i], dir.getPath());
            }
        }
    }

    public static void setCacheDirectory(String path) {
        nativeSetDirectory("CACHEDIR", path);
    }

    public static void setExternalCacheDirectory(String path) {
        nativeSetDirectory("EXTERNAL_CACHEDIR", path);
    }
}
