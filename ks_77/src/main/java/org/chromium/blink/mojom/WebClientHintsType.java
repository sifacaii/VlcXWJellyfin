package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebClientHintsType.class */
public final class WebClientHintsType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int DEVICE_MEMORY = 0;
    public static final int DPR = 1;
    public static final int RESOURCE_WIDTH = 2;
    public static final int VIEWPORT_WIDTH = 3;
    public static final int RTT = 4;
    public static final int DOWNLINK = 5;
    public static final int ECT = 6;
    public static final int LANG = 7;
    public static final int UA = 8;
    public static final int UA_ARCH = 9;
    public static final int UA_PLATFORM = 10;
    public static final int UA_MODEL = 11;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 11;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private WebClientHintsType() {
    }
}
