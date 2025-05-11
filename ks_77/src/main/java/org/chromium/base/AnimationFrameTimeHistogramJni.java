package org.chromium.base;

import J.N;
import org.chromium.base.AnimationFrameTimeHistogram;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/AnimationFrameTimeHistogramJni.class */
public final class AnimationFrameTimeHistogramJni implements AnimationFrameTimeHistogram.Natives {
    private static AnimationFrameTimeHistogram.Natives testInstance;
    public static final JniStaticTestMocker<AnimationFrameTimeHistogram.Natives> TEST_HOOKS = new JniStaticTestMocker<AnimationFrameTimeHistogram.Natives>() { // from class: org.chromium.base.AnimationFrameTimeHistogramJni.1
        @Override // org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(AnimationFrameTimeHistogram.Natives instance) {
            AnimationFrameTimeHistogram.Natives unused = AnimationFrameTimeHistogramJni.testInstance = instance;
        }
    };

    AnimationFrameTimeHistogramJni() {
    }

    @Override // org.chromium.base.AnimationFrameTimeHistogram.Natives
    public void saveHistogram(String histogramName, long[] frameTimesMs, int count) {
        N.M7xB0tc0(histogramName, frameTimesMs, count);
    }

    public static AnimationFrameTimeHistogram.Natives get() {
        if (N.TESTING_ENABLED) {
            if (testInstance != null) {
                return testInstance;
            }
            if (N.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.base.AnimationFrameTimeHistogram.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        return new AnimationFrameTimeHistogramJni();
    }
}
