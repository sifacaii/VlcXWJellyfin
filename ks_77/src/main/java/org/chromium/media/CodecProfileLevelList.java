package org.chromium.media;

import android.media.MediaCodecInfo;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.blink_public.web.WebInputEventModifier;
import org.chromium.ui.base.PageTransition;

@JNINamespace("media")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/CodecProfileLevelList.class */
class CodecProfileLevelList {
    private static final String TAG = "CodecProfileLevelList";
    private final List<CodecProfileLevelAdapter> mList = new ArrayList();

    public boolean addCodecProfileLevel(String mime, MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
        try {
            int codec = getCodecFromMime(mime);
            this.mList.add(new CodecProfileLevelAdapter(codec, mediaCodecProfileToChromiumMediaProfile(codec, codecProfileLevel.profile), mediaCodecLevelToChromiumMediaLevel(codec, codecProfileLevel.level)));
            return true;
        } catch (UnsupportedCodecProfileException e) {
            return false;
        }
    }

    public boolean addCodecProfileLevel(int codec, int profile, int level) {
        this.mList.add(new CodecProfileLevelAdapter(codec, profile, level));
        return true;
    }

    public Object[] toArray() {
        return this.mList.toArray();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/CodecProfileLevelList$CodecProfileLevelAdapter.class */
    static class CodecProfileLevelAdapter {
        private final int mCodec;
        private final int mProfile;
        private final int mLevel;

        public CodecProfileLevelAdapter(int codec, int profile, int level) {
            this.mCodec = codec;
            this.mProfile = profile;
            this.mLevel = level;
        }

        @CalledByNative("CodecProfileLevelAdapter")
        public int getCodec() {
            return this.mCodec;
        }

        @CalledByNative("CodecProfileLevelAdapter")
        public int getProfile() {
            return this.mProfile;
        }

        @CalledByNative("CodecProfileLevelAdapter")
        public int getLevel() {
            return this.mLevel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/CodecProfileLevelList$UnsupportedCodecProfileException.class */
    public static class UnsupportedCodecProfileException extends RuntimeException {
        private UnsupportedCodecProfileException() {
        }
    }

    private static int getCodecFromMime(String mime) {
        if (mime.endsWith("vp9")) {
            return 7;
        }
        if (mime.endsWith("vp8")) {
            return 6;
        }
        if (mime.endsWith("avc")) {
            return 1;
        }
        if (mime.endsWith("hevc")) {
            return 8;
        }
        throw new UnsupportedCodecProfileException();
    }

    private static int mediaCodecProfileToChromiumMediaProfile(int codec, int profile) {
        switch (codec) {
            case 1:
                switch (profile) {
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 4:
                        return 2;
                    case 8:
                        return 3;
                    case 16:
                        return 4;
                    case 32:
                        return 5;
                    case 64:
                        return 6;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                throw new UnsupportedCodecProfileException();
            case 6:
                switch (profile) {
                    case 1:
                        return 11;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
            case 7:
                switch (profile) {
                    case 1:
                        return 12;
                    case 2:
                        return 13;
                    case 4:
                    case 4096:
                        return 14;
                    case 8:
                    case 8192:
                        return 15;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
            case 8:
                switch (profile) {
                    case 1:
                        return 16;
                    case 2:
                    case 4096:
                        return 17;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
        }
    }

    private static int mediaCodecLevelToChromiumMediaLevel(int codec, int level) {
        switch (codec) {
            case 1:
                switch (level) {
                    case 1:
                        return 10;
                    case 4:
                        return 11;
                    case 8:
                        return 12;
                    case 16:
                        return 13;
                    case 32:
                        return 20;
                    case 64:
                        return 21;
                    case 128:
                        return 22;
                    case 256:
                        return 30;
                    case 512:
                        return 31;
                    case 1024:
                        return 32;
                    case 2048:
                        return 40;
                    case 4096:
                        return 41;
                    case 8192:
                        return 42;
                    case 16384:
                        return 50;
                    case 32768:
                        return 51;
                    case 65536:
                        return 52;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                throw new UnsupportedCodecProfileException();
            case 6:
                switch (level) {
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        throw new UnsupportedCodecProfileException();
                    case 4:
                        return 2;
                    case 8:
                        return 3;
                }
            case 7:
                switch (level) {
                    case 1:
                        return 10;
                    case 2:
                        return 11;
                    case 4:
                        return 20;
                    case 8:
                        return 21;
                    case 16:
                        return 30;
                    case 32:
                        return 31;
                    case 64:
                        return 40;
                    case 128:
                        return 41;
                    case 256:
                        return 50;
                    case 512:
                        return 51;
                    case 1024:
                        return 52;
                    case 2048:
                        return 60;
                    case 4096:
                        return 61;
                    case 8192:
                        return 62;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
            case 8:
                switch (level) {
                    case 1:
                    case 2:
                        return 30;
                    case 4:
                    case 8:
                        return 60;
                    case 16:
                    case 32:
                        return 63;
                    case 64:
                    case 128:
                        return 90;
                    case 256:
                    case 512:
                        return 93;
                    case 1024:
                    case 2048:
                        return 120;
                    case 4096:
                    case 8192:
                        return WebFeature.NAVIGATOR_PRODUCT_SUB;
                    case 16384:
                    case 32768:
                        return 150;
                    case 65536:
                    case WebInputEventModifier.SYMBOL_KEY /* 131072 */:
                        return 153;
                    case WebInputEventModifier.SCROLL_LOCK_ON /* 262144 */:
                    case WebInputEventModifier.IS_COMPATIBILITY_EVENT_FOR_TOUCH /* 524288 */:
                        return 156;
                    case WebInputEventModifier.BACK_BUTTON_DOWN /* 1048576 */:
                    case WebInputEventModifier.FORWARD_BUTTON_DOWN /* 2097152 */:
                        return 180;
                    case WebInputEventModifier.RELATIVE_MOTION_EVENT /* 4194304 */:
                    case 8388608:
                        return WebFeature.BAR_PROP_TOOLBAR;
                    case 16777216:
                    case PageTransition.FROM_ADDRESS_BAR /* 33554432 */:
                        return WebFeature.INPUT_TYPE_EMAIL_MULTIPLE_MAX_LENGTH;
                    default:
                        throw new UnsupportedCodecProfileException();
                }
        }
    }
}
