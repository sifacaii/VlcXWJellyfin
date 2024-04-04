package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebContentSecurityPolicyType.class */
public final class WebContentSecurityPolicyType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int WEB_CONTENT_SECURITY_POLICY_TYPE_REPORT = 0;
    public static final int WEB_CONTENT_SECURITY_POLICY_TYPE_ENFORCE = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private WebContentSecurityPolicyType() {
    }
}
