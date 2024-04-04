package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/EmeInitDataType.class */
public final class EmeInitDataType {
    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        return false;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private EmeInitDataType() {
    }
}
