package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ViewportFit.class */
public final class ViewportFit {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int AUTO = 0;
    public static final int CONTAIN = 1;
    public static final int COVER = 2;
    public static final int COVER_FORCED_BY_USER_AGENT = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ViewportFit() {
    }
}
