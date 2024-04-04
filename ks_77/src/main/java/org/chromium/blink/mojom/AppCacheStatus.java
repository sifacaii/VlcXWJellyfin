package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheStatus.class */
public final class AppCacheStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int APPCACHE_STATUS_UNCACHED = 0;
    public static final int APPCACHE_STATUS_IDLE = 1;
    public static final int APPCACHE_STATUS_CHECKING = 2;
    public static final int APPCACHE_STATUS_DOWNLOADING = 3;
    public static final int APPCACHE_STATUS_UPDATE_READY = 4;
    public static final int APPCACHE_STATUS_OBSOLETE = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private AppCacheStatus() {
    }
}
