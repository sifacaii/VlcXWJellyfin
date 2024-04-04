package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionName.class */
public final class PermissionName {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int GEOLOCATION = 0;
    public static final int NOTIFICATIONS = 1;
    public static final int MIDI = 2;
    public static final int PROTECTED_MEDIA_IDENTIFIER = 3;
    public static final int DURABLE_STORAGE = 4;
    public static final int AUDIO_CAPTURE = 5;
    public static final int VIDEO_CAPTURE = 6;
    public static final int BACKGROUND_SYNC = 7;
    public static final int SENSORS = 8;
    public static final int ACCESSIBILITY_EVENTS = 9;
    public static final int CLIPBOARD_READ = 10;
    public static final int CLIPBOARD_WRITE = 11;
    public static final int PAYMENT_HANDLER = 12;
    public static final int BACKGROUND_FETCH = 13;
    public static final int IDLE_DETECTION = 14;
    public static final int PERIODIC_BACKGROUND_SYNC = 15;
    public static final int WAKE_LOCK = 16;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 16;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PermissionName() {
    }
}
