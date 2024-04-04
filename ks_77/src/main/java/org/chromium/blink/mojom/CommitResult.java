package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CommitResult.class */
public final class CommitResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int OK = 0;
    public static final int ABORTED = 1;
    public static final int RESTART_CROSS_DOCUMENT = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CommitResult() {
    }
}
