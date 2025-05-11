package org.chromium.base.metrics;

import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/RecordUserAction.class */
public class RecordUserAction {
    private static Throwable sDisabledBy;
    private static long sNativeActionCallback;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/RecordUserAction$UserActionCallback.class */
    public interface UserActionCallback {
        @CalledByNative("UserActionCallback")
        void onActionRecorded(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRecordUserAction(String str);

    private static native long nativeAddActionCallbackForTesting(UserActionCallback userActionCallback);

    private static native void nativeRemoveActionCallbackForTesting(long j);

    static {
        $assertionsDisabled = !RecordUserAction.class.desiredAssertionStatus();
    }

    @VisibleForTesting
    public static void setDisabledForTests(boolean disabled) {
        if (disabled && sDisabledBy != null) {
            throw new IllegalStateException("UserActions are already disabled.", sDisabledBy);
        }
        sDisabledBy = disabled ? new Throwable() : null;
    }

    public static void record(final String action) {
        if (sDisabledBy != null) {
            return;
        }
        if (ThreadUtils.runningOnUiThread()) {
            nativeRecordUserAction(action);
        } else {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: org.chromium.base.metrics.RecordUserAction.1
                @Override // java.lang.Runnable
                public void run() {
                    RecordUserAction.nativeRecordUserAction(action);
                }
            });
        }
    }

    public static void setActionCallbackForTesting(UserActionCallback callback) {
        if (!$assertionsDisabled && sNativeActionCallback != 0) {
            throw new AssertionError();
        }
        sNativeActionCallback = nativeAddActionCallbackForTesting(callback);
    }

    public static void removeActionCallbackForTesting() {
        if (!$assertionsDisabled && sNativeActionCallback == 0) {
            throw new AssertionError();
        }
        nativeRemoveActionCallbackForTesting(sNativeActionCallback);
        sNativeActionCallback = 0L;
    }
}
