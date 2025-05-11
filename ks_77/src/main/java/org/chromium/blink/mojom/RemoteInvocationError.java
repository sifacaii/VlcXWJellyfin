package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteInvocationError.class */
public final class RemoteInvocationError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int OK = 0;
    public static final int METHOD_NOT_FOUND = 1;
    public static final int OBJECT_GET_CLASS_BLOCKED = 2;
    public static final int EXCEPTION_THROWN = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private RemoteInvocationError() {
    }
}
