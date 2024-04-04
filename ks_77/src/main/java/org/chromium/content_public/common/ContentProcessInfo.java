package org.chromium.content_public.common;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/common/ContentProcessInfo.class */
public final class ContentProcessInfo {
    private static boolean sIsChildProcess;

    private ContentProcessInfo() {
    }

    public static void setInChildProcess(boolean inChildProcess) {
        sIsChildProcess = inChildProcess;
    }

    public static boolean inChildProcess() {
        return sIsChildProcess;
    }
}
