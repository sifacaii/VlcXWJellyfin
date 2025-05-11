package org.chromium.content.browser;

import android.view.View;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/SyntheticGestureTarget.class */
public class SyntheticGestureTarget {
    private final MotionEventSynthesizerImpl mMotionEventSynthesizer;

    @CalledByNative
    private static SyntheticGestureTarget create(View target) {
        return new SyntheticGestureTarget(target);
    }

    private SyntheticGestureTarget(View target) {
        this.mMotionEventSynthesizer = MotionEventSynthesizerImpl.create(target);
    }

    @CalledByNative
    private void inject(int action, int pointerCount, long timeInMs) {
        this.mMotionEventSynthesizer.inject(action, pointerCount, timeInMs);
    }

    @CalledByNative
    private void setPointer(int index, int x, int y, int id) {
        this.mMotionEventSynthesizer.setPointer(index, x, y, id);
    }

    @CalledByNative
    private void setScrollDeltas(int x, int y, int dx, int dy) {
        this.mMotionEventSynthesizer.setScrollDeltas(x, y, dx, dy);
    }
}
