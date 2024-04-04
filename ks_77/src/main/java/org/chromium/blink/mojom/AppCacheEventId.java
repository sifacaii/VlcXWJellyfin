package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheEventId.class */
public final class AppCacheEventId {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int APPCACHE_CHECKING_EVENT = 0;
    public static final int APPCACHE_ERROR_EVENT = 1;
    public static final int APPCACHE_NO_UPDATE_EVENT = 2;
    public static final int APPCACHE_DOWNLOADING_EVENT = 3;
    public static final int APPCACHE_PROGRESS_EVENT = 4;
    public static final int APPCACHE_UPDATE_READY_EVENT = 5;
    public static final int APPCACHE_CACHED_EVENT = 6;
    public static final int APPCACHE_OBSOLETE_EVENT = 7;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 7;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private AppCacheEventId() {
    }
}
