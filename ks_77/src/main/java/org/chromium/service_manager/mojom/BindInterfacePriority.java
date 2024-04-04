package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/BindInterfacePriority.class */
public final class BindInterfacePriority {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int IMPORTANT = 0;
    public static final int BEST_EFFORT = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BindInterfacePriority() {
    }
}
