package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ConsoleMessageSource.class */
public final class ConsoleMessageSource {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int XML = 0;
    public static final int JAVA_SCRIPT = 1;
    public static final int NETWORK = 2;
    public static final int CONSOLE_API = 3;
    public static final int STORAGE = 4;
    public static final int APP_CACHE = 5;
    public static final int RENDERING = 6;
    public static final int SECURITY = 7;
    public static final int OTHER = 8;
    public static final int DEPRECATION = 9;
    public static final int WORKER = 10;
    public static final int VIOLATION = 11;
    public static final int INTERVENTION = 12;
    public static final int RECOMMENDATION = 13;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 13;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ConsoleMessageSource() {
    }
}
