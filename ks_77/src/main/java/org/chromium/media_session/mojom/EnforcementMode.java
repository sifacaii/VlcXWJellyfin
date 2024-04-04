package org.chromium.media_session.mojom;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/EnforcementMode.class */
public final class EnforcementMode {
    private static final boolean IS_EXTENSIBLE = true;
    public static final int DEFAULT = 0;
    public static final int NONE = 1;
    public static final int SINGLE_GROUP = 2;
    public static final int SINGLE_SESSION = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
    }

    private EnforcementMode() {
    }
}
