package org.chromium.content.browser.accessibility;

import android.annotation.TargetApi;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.metrics.RecordHistogram;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/BrowserAccessibilityState.class */
public class BrowserAccessibilityState {
    static final int ANIMATIONS_STATE_DEFAULT_VALUE = 0;
    static final int ANIMATIONS_STATE_DISABLED = 1;
    static final int ANIMATIONS_STATE_ENABLED = 2;
    static final int ANIMATIONS_STATE_COUNT = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnAnimatorDurationScaleChanged();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/BrowserAccessibilityState$AnimatorDurationScaleObserver.class */
    private static class AnimatorDurationScaleObserver extends ContentObserver {
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !BrowserAccessibilityState.class.desiredAssertionStatus();
        }

        public AnimatorDurationScaleObserver(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (!$assertionsDisabled && !ThreadUtils.runningOnUiThread()) {
                throw new AssertionError();
            }
            BrowserAccessibilityState.nativeOnAnimatorDurationScaleChanged();
        }
    }

    @CalledByNative
    @TargetApi(17)
    static void registerAnimatorDurationScaleObserver() {
        Handler handler = new Handler(ThreadUtils.getUiThreadLooper());
        Uri uri = Settings.Global.getUriFor("animator_duration_scale");
        ContextUtils.getApplicationContext().getContentResolver().registerContentObserver(uri, false, new AnimatorDurationScaleObserver(handler));
    }

    @VisibleForTesting
    @CalledByNative
    @TargetApi(17)
    static void recordAccessibilityHistograms() {
        int i;
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        float durationScale = Settings.Global.getFloat(ContextUtils.getApplicationContext().getContentResolver(), "animator_duration_scale", -1.0f);
        if (durationScale < 0.0f) {
            i = 0;
        } else {
            i = durationScale > 0.0f ? 2 : 1;
        }
        int histogramValue = i;
        RecordHistogram.recordEnumeratedHistogram("Accessibility.Android.AnimationsEnabled2", histogramValue, 3);
    }
}
