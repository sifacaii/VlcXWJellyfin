package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RequestContextType.class */
public final class RequestContextType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNSPECIFIED = 0;
    public static final int AUDIO = 1;
    public static final int BEACON = 2;
    public static final int CSP_REPORT = 3;
    public static final int DOWNLOAD = 4;
    public static final int EMBED = 5;
    public static final int EVENT_SOURCE = 6;
    public static final int FAVICON = 7;
    public static final int FETCH = 8;
    public static final int FONT = 9;
    public static final int FORM = 10;
    public static final int FRAME = 11;
    public static final int HYPERLINK = 12;
    public static final int IFRAME = 13;
    public static final int IMAGE = 14;
    public static final int IMAGE_SET = 15;
    public static final int IMPORT = 16;
    public static final int INTERNAL = 17;
    public static final int LOCATION = 18;
    public static final int MANIFEST = 19;
    public static final int OBJECT = 20;
    public static final int PING = 21;
    public static final int PLUGIN = 22;
    public static final int PREFETCH = 23;
    public static final int SCRIPT = 24;
    public static final int SERVICE_WORKER = 25;
    public static final int SHARED_WORKER = 26;
    public static final int SUBRESOURCE = 27;
    public static final int STYLE = 28;
    public static final int TRACK = 29;
    public static final int VIDEO = 30;
    public static final int WORKER = 31;
    public static final int XML_HTTP_REQUEST = 32;
    public static final int XSLT = 33;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 33;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private RequestContextType() {
    }
}
