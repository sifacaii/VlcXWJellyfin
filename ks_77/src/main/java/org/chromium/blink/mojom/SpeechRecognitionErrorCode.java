package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpeechRecognitionErrorCode.class */
public final class SpeechRecognitionErrorCode {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NONE = 0;
    public static final int NO_SPEECH = 1;
    public static final int ABORTED = 2;
    public static final int AUDIO_CAPTURE = 3;
    public static final int NETWORK = 4;
    public static final int NOT_ALLOWED = 5;
    public static final int SERVICE_NOT_ALLOWED = 6;
    public static final int BAD_GRAMMAR = 7;
    public static final int LANGUAGE_NOT_SUPPORTED = 8;
    public static final int NO_MATCH = 9;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 9;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SpeechRecognitionErrorCode() {
    }
}
