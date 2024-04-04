package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaUrlScheme.class */
public final class MediaUrlScheme {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int MISSING = 1;
    public static final int HTTP = 2;
    public static final int HTTPS = 3;
    public static final int FTP = 4;
    public static final int CHROME_EXTENSION = 5;
    public static final int JAVASCRIPT = 6;
    public static final int FILE = 7;
    public static final int BLOB = 8;
    public static final int DATA = 9;
    public static final int FILE_SYSTEM = 10;
    public static final int CHROME = 11;
    public static final int CONTENT = 12;
    public static final int CONTENT_ID = 13;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 13;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private MediaUrlScheme() {
    }
}
