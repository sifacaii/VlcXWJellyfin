package org.chromium.ui.touchless;

import android.os.StrictMode;
import org.chromium.base.BuildInfo;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/touchless/TouchlessEventHandler.class */
public class TouchlessEventHandler {
    private static final String EVENT_HANDLER_INTERNAL = "org.chromium.ui.touchless.TouchlessEventHandlerInternal";
    private static TouchlessEventHandler sInstance;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/touchless/TouchlessEventHandler$TouchlessZoomCallback.class */
    public interface TouchlessZoomCallback {
        void onZoomInRequested();

        void onZoomOutRequested();
    }

    static {
        $assertionsDisabled = !TouchlessEventHandler.class.desiredAssertionStatus();
        StrictMode.ThreadPolicy oldPolicy = null;
        if (!BuildInfo.isAtLeastQ()) {
            oldPolicy = StrictMode.allowThreadDiskReads();
        }
        try {
            try {
                sInstance = (TouchlessEventHandler) Class.forName(EVENT_HANDLER_INTERNAL).newInstance();
                if (oldPolicy != null) {
                    StrictMode.setThreadPolicy(oldPolicy);
                }
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException e) {
                sInstance = null;
                if (oldPolicy != null) {
                    StrictMode.setThreadPolicy(oldPolicy);
                }
            }
        } catch (Throwable th) {
            if (oldPolicy != null) {
                StrictMode.setThreadPolicy(oldPolicy);
            }
            throw th;
        }
    }

    public static boolean hasTouchlessEventHandler() {
        return sInstance != null;
    }

    public static boolean onUnconsumedKeyboardEventAck(int nativeCode) {
        if ($assertionsDisabled || sInstance != null) {
            return sInstance.onUnconsumedKeyboardEventAckInternal(nativeCode);
        }
        throw new AssertionError();
    }

    public static void addCursorObserver(CursorObserver observer) {
        if (sInstance != null) {
            sInstance.addCursorObserverInternal(observer);
        }
    }

    public static void removeCursorObserver(CursorObserver observer) {
        if (sInstance != null) {
            sInstance.removeCursorObserverInternal(observer);
        }
    }

    public static void setZoomCallback(TouchlessZoomCallback callback) {
        if (sInstance != null) {
            sInstance.setZoomCallbackInternal(callback);
        }
    }

    public static void removeZoomCallback(TouchlessZoomCallback callback) {
        if (sInstance != null) {
            sInstance.removeZoomCallbackInternal(callback);
        }
    }

    public static void onDidFinishNavigation() {
        if (sInstance != null) {
            sInstance.onDidFinishNavigationInternal();
        }
    }

    public static void onActivityHidden() {
        if (sInstance != null) {
            sInstance.onActivityHiddenInternal();
        }
    }

    public static void fallbackCursorModeLockCursor(boolean left, boolean right, boolean up, boolean down) {
        sInstance.fallbackCursorModeLockCursorInternal(left, right, up, down);
    }

    public static void fallbackCursorModeSetCursorVisibility(boolean visible) {
        sInstance.fallbackCursorModeSetCursorVisibilityInternal(visible);
    }

    protected boolean onUnconsumedKeyboardEventAckInternal(int nativeCode) {
        return false;
    }

    protected void addCursorObserverInternal(CursorObserver observer) {
    }

    protected void removeCursorObserverInternal(CursorObserver observer) {
    }

    protected void setZoomCallbackInternal(TouchlessZoomCallback callback) {
    }

    protected void removeZoomCallbackInternal(TouchlessZoomCallback callback) {
    }

    protected void onDidFinishNavigationInternal() {
    }

    protected void onActivityHiddenInternal() {
    }

    protected void fallbackCursorModeLockCursorInternal(boolean left, boolean right, boolean up, boolean down) {
    }

    protected void fallbackCursorModeSetCursorVisibilityInternal(boolean visible) {
    }
}
