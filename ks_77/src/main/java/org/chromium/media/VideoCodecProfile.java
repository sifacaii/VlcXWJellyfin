package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCodecProfile.class */
public @interface VideoCodecProfile {
    public static final int VIDEO_CODEC_PROFILE_UNKNOWN = -1;
    public static final int VIDEO_CODEC_PROFILE_MIN = -1;
    public static final int H264PROFILE_MIN = 0;
    public static final int H264PROFILE_BASELINE = 0;
    public static final int H264PROFILE_MAIN = 1;
    public static final int H264PROFILE_EXTENDED = 2;
    public static final int H264PROFILE_HIGH = 3;
    public static final int H264PROFILE_HIGH10PROFILE = 4;
    public static final int H264PROFILE_HIGH422PROFILE = 5;
    public static final int H264PROFILE_HIGH444PREDICTIVEPROFILE = 6;
    public static final int H264PROFILE_SCALABLEBASELINE = 7;
    public static final int H264PROFILE_SCALABLEHIGH = 8;
    public static final int H264PROFILE_STEREOHIGH = 9;
    public static final int H264PROFILE_MULTIVIEWHIGH = 10;
    public static final int H264PROFILE_MAX = 10;
    public static final int VP8PROFILE_MIN = 11;
    public static final int VP8PROFILE_ANY = 11;
    public static final int VP8PROFILE_MAX = 11;
    public static final int VP9PROFILE_MIN = 12;
    public static final int VP9PROFILE_PROFILE0 = 12;
    public static final int VP9PROFILE_PROFILE1 = 13;
    public static final int VP9PROFILE_PROFILE2 = 14;
    public static final int VP9PROFILE_PROFILE3 = 15;
    public static final int VP9PROFILE_MAX = 15;
    public static final int HEVCPROFILE_MIN = 16;
    public static final int HEVCPROFILE_MAIN = 16;
    public static final int HEVCPROFILE_MAIN10 = 17;
    public static final int HEVCPROFILE_MAIN_STILL_PICTURE = 18;
    public static final int HEVCPROFILE_MAX = 18;
    public static final int DOLBYVISION_PROFILE0 = 19;
    public static final int DOLBYVISION_PROFILE4 = 20;
    public static final int DOLBYVISION_PROFILE5 = 21;
    public static final int DOLBYVISION_PROFILE7 = 22;
    public static final int THEORAPROFILE_MIN = 23;
    public static final int THEORAPROFILE_ANY = 23;
    public static final int THEORAPROFILE_MAX = 23;
    public static final int AV1PROFILE_MIN = 24;
    public static final int AV1PROFILE_PROFILE_MAIN = 24;
    public static final int AV1PROFILE_PROFILE_HIGH = 25;
    public static final int AV1PROFILE_PROFILE_PRO = 26;
    public static final int AV1PROFILE_MAX = 26;
    public static final int DOLBYVISION_PROFILE8 = 27;
    public static final int DOLBYVISION_PROFILE9 = 28;
    public static final int VIDEO_CODEC_PROFILE_MAX = 28;
}
