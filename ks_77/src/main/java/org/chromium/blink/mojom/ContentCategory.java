package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentCategory.class */
public final class ContentCategory {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int HOME_PAGE = 1;
    public static final int ARTICLE = 2;
    public static final int VIDEO = 3;
    public static final int AUDIO = 4;

    public static boolean isKnownValue(int value) {
        return value >= 1 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ContentCategory() {
    }
}
