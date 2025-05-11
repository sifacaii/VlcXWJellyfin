package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataElementType.class */
public final class DataElementType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = -1;
    public static final int DATA_PIPE = 0;
    public static final int CHUNKED_DATA_PIPE = 1;
    public static final int RAW_FILE = 2;
    public static final int BLOB = 3;
    public static final int FILE = 4;
    public static final int BYTES = 5;

    public static boolean isKnownValue(int value) {
        return value >= -1 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private DataElementType() {
    }
}
