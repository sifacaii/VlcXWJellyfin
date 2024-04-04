package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/BitrateAdjuster.class */
class BitrateAdjuster {
    private static final int FRAMERATE_ADJUSTMENT_BITRATE_ADJUSTMENT_FPS = 30;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/BitrateAdjuster$Type.class */
    public @interface Type {
        public static final int NO_ADJUSTMENT = 0;
        public static final int FRAMERATE_ADJUSTMENT = 1;
    }

    BitrateAdjuster() {
    }

    public static int getTargetBitrate(int type, int bps, int frameRate) {
        switch (type) {
            case 0:
                return bps;
            case 1:
                if (frameRate == 0) {
                    return bps;
                }
                return (30 * bps) / frameRate;
            default:
                return 0;
        }
    }

    public static int getInitialFrameRate(int type, int frameRateHint) {
        switch (type) {
            case 0:
                return Math.min(frameRateHint, 30);
            case 1:
                return 30;
            default:
                return 0;
        }
    }
}
