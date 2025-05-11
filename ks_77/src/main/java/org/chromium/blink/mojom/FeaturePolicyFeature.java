package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FeaturePolicyFeature.class */
public final class FeaturePolicyFeature {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NOT_FOUND = 0;
    public static final int AUTOPLAY = 1;
    public static final int CAMERA = 2;
    public static final int ENCRYPTED_MEDIA = 3;
    public static final int FULLSCREEN = 4;
    public static final int GEOLOCATION = 5;
    public static final int MICROPHONE = 6;
    public static final int MIDI_FEATURE = 7;
    public static final int PAYMENT = 8;
    public static final int DOCUMENT_COOKIE = 10;
    public static final int DOCUMENT_DOMAIN = 11;
    public static final int SYNC_SCRIPT = 12;
    public static final int SYNC_XHR = 13;
    public static final int USB = 14;
    public static final int ACCESSIBILITY_EVENTS = 15;
    public static final int WEB_VR = 16;
    public static final int ACCELEROMETER = 17;
    public static final int AMBIENT_LIGHT_SENSOR = 18;
    public static final int GYROSCOPE = 19;
    public static final int MAGNETOMETER = 20;
    public static final int UNSIZED_MEDIA = 21;
    public static final int OVERSIZED_IMAGES = 25;
    public static final int PICTURE_IN_PICTURE = 26;
    public static final int VERTICAL_SCROLL = 27;
    public static final int DOCUMENT_WRITE = 28;
    public static final int LAZY_LOAD = 29;
    public static final int LAYOUT_ANIMATIONS = 30;
    public static final int WAKE_LOCK = 31;
    public static final int FONT_DISPLAY = 32;
    public static final int TOP_NAVIGATION = 33;
    public static final int FORM_SUBMISSION = 34;
    public static final int SCRIPT = 35;
    public static final int POPUPS = 36;
    public static final int POINTER_LOCK = 37;
    public static final int MODALS = 38;
    public static final int ORIENTATION_LOCK = 39;
    public static final int PRESENTATION = 40;
    public static final int FROBULATE = 41;
    public static final int SERIAL = 42;
    public static final int HID = 43;
    public static final int IDLE_DETECTION = 44;
    public static final int UNOPTIMIZED_LOSSY_IMAGES = 45;
    public static final int UNOPTIMIZED_LOSSLESS_IMAGES = 46;
    public static final int UNOPTIMIZED_LOSSLESS_IMAGES_STRICT = 47;
    public static final int LOADING_FRAME_DEFAULT_EAGER = 48;
    public static final int DOWNLOADS_WITHOUT_USER_ACTIVATION = 49;
    public static final int EXECUTION_WHILE_OUT_OF_VIEWPORT = 50;
    public static final int EXECUTION_WHILE_NOT_RENDERED = 51;
    public static final int FOCUS_WITHOUT_USER_ACTIVATION = 52;
    public static final int CLIENT_HINT_DPR = 53;
    public static final int CLIENT_HINT_DEVICE_MEMORY = 54;
    public static final int CLIENT_HINT_DOWNLINK = 55;
    public static final int CLIENT_HINT_ECT = 56;
    public static final int CLIENT_HINT_LANG = 57;
    public static final int CLIENT_HINT_RTT = 58;
    public static final int CLIENT_HINT_UA = 59;
    public static final int CLIENT_HINT_UA_ARCH = 60;
    public static final int CLIENT_HINT_UA_MODEL = 61;
    public static final int CLIENT_HINT_UA_PLATFORM = 62;
    public static final int CLIENT_HINT_VIEWPORT_WIDTH = 63;
    public static final int CLIENT_HINT_WIDTH = 64;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
                return true;
            case 9:
            case 22:
            case 23:
            case 24:
            default:
                return false;
        }
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private FeaturePolicyFeature() {
    }
}
