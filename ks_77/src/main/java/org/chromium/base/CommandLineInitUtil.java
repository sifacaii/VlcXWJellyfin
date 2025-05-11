package org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/CommandLineInitUtil.class */
public final class CommandLineInitUtil {
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !CommandLineInitUtil.class.desiredAssertionStatus();
    }

    private CommandLineInitUtil() {
    }

    public static void initCommandLine(String fileName) {
        initCommandLine(fileName, null);
    }

    public static void initCommandLine(String fileName, @Nullable Supplier<Boolean> shouldUseDebugFlags) {
        if (!$assertionsDisabled && CommandLine.isInitialized()) {
            throw new AssertionError();
        }
        File commandLineFile = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, fileName);
        boolean debugFlagsExist = commandLineFile.exists();
        if (!debugFlagsExist || !shouldUseDebugCommandLine(shouldUseDebugFlags)) {
            commandLineFile = new File(COMMAND_LINE_FILE_PATH, fileName);
        }
        CommandLine.initFromFile(commandLineFile.getPath());
    }

    private static boolean shouldUseDebugCommandLine(@Nullable Supplier<Boolean> shouldUseDebugFlags) {
        String debugAppJBMR1;
        if (shouldUseDebugFlags == null || !shouldUseDebugFlags.get().booleanValue()) {
            Context context = ContextUtils.getApplicationContext();
            if (Build.VERSION.SDK_INT < 17) {
                debugAppJBMR1 = getDebugAppPreJBMR1(context);
            } else {
                debugAppJBMR1 = getDebugAppJBMR1(context);
            }
            String debugApp = debugAppJBMR1;
            return context.getPackageName().equals(debugApp) || BuildInfo.isDebugAndroid();
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private static String getDebugAppJBMR1(Context context) {
        boolean adbEnabled = Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1;
        if (adbEnabled) {
            return Settings.Global.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }

    private static String getDebugAppPreJBMR1(Context context) {
        boolean adbEnabled = Settings.System.getInt(context.getContentResolver(), "adb_enabled", 0) == 1;
        if (adbEnabled) {
            return Settings.System.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }
}
