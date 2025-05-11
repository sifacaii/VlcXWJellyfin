package org.chromium.content_public.browser;

import android.view.View;
import org.chromium.content.browser.MotionEventSynthesizerImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/MotionEventSynthesizer.class */
public interface MotionEventSynthesizer {
    void setPointer(int i, int i2, int i3, int i4, int i5);

    void inject(int i, int i2, long j);

    static MotionEventSynthesizer create(View target) {
        return MotionEventSynthesizerImpl.create(target);
    }
}
