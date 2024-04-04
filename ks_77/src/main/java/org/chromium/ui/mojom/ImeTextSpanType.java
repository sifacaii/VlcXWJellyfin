package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/mojom/ImeTextSpanType.class */
public final class ImeTextSpanType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int COMPOSITION = 0;
    public static final int SUGGESTION = 1;
    public static final int MISSPELLING_SUGGESTION = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ImeTextSpanType() {
    }
}
