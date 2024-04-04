package org.chromium.blink.mojom;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebSandboxFlags.class */
public final class WebSandboxFlags {
    private static final boolean IS_EXTENSIBLE = true;
    public static final int NONE = 0;
    public static final int NAVIGATION = 1;
    public static final int PLUGINS = 2;
    public static final int ORIGIN = 4;
    public static final int FORMS = 8;
    public static final int SCRIPTS = 16;
    public static final int TOP_NAVIGATION = 32;
    public static final int POPUPS = 64;
    public static final int AUTOMATIC_FEATURES = 128;
    public static final int POINTER_LOCK = 256;
    public static final int DOCUMENT_DOMAIN = 512;
    public static final int ORIENTATION_LOCK = 1024;
    public static final int PROPAGATES_TO_AUXILIARY_BROWSING_CONTEXTS = 2048;
    public static final int MODALS = 4096;
    public static final int PRESENTATION_CONTROLLER = 8192;
    public static final int TOP_NAVIGATION_BY_USER_ACTIVATION = 16384;
    public static final int DOWNLOADS = 32768;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256:
            case 512:
            case 1024:
            case 2048:
            case 4096:
            case 8192:
            case 16384:
            case 32768:
                return true;
            default:
                return false;
        }
    }

    public static void validate(int value) {
    }

    private WebSandboxFlags() {
    }
}
