package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCodec.class */
public @interface VideoCodec {
    public static final int UNKNOWN_VIDEO_CODEC = 0;
    public static final int CODEC_H264 = 1;
    public static final int CODEC_VC1 = 2;
    public static final int CODEC_MPEG2 = 3;
    public static final int CODEC_MPEG4 = 4;
    public static final int CODEC_THEORA = 5;
    public static final int CODEC_VP8 = 6;
    public static final int CODEC_VP9 = 7;
    public static final int CODEC_HEVC = 8;
    public static final int CODEC_DOLBY_VISION = 9;
    public static final int CODEC_AV1 = 10;
    public static final int VIDEO_CODEC_MAX = 10;
}
