package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/MessageLoopType.class */
public final class MessageLoopType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int DEFAULT = 0;
    public static final int UI = 1;
    public static final int CUSTOM = 2;
    public static final int IO = 3;
    public static final int JAVA = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private MessageLoopType() {
    }
}
