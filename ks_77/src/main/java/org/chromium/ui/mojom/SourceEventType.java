package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/mojom/SourceEventType.class */
public final class SourceEventType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int WHEEL = 1;
    public static final int MOUSE = 2;
    public static final int TOUCH = 3;
    public static final int INERTIAL = 4;
    public static final int KEY_PRESS = 5;
    public static final int TOUCHPAD = 6;
    public static final int FRAME = 7;
    public static final int SCROLLBAR = 8;
    public static final int OTHER = 9;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 9;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SourceEventType() {
    }
}
