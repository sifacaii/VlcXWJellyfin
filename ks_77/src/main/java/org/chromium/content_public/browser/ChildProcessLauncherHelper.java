package org.chromium.content_public.browser;

import android.content.Context;
import org.chromium.content.browser.ChildProcessLauncherHelperImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ChildProcessLauncherHelper.class */
public final class ChildProcessLauncherHelper {
    private ChildProcessLauncherHelper() {
    }

    public static void warmUp(Context context, boolean sandboxed) {
        ChildProcessLauncherHelperImpl.warmUp(context, sandboxed);
    }

    public static void startModerateBindingManagement(Context context) {
        ChildProcessLauncherHelperImpl.startModerateBindingManagement(context);
    }
}
