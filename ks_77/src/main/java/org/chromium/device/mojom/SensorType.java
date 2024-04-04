package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SensorType.class */
public final class SensorType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int AMBIENT_LIGHT = 0;
    public static final int PROXIMITY = 1;
    public static final int ACCELEROMETER = 2;
    public static final int LINEAR_ACCELERATION = 3;
    public static final int GYROSCOPE = 4;
    public static final int MAGNETOMETER = 5;
    public static final int PRESSURE = 6;
    public static final int ABSOLUTE_ORIENTATION_EULER_ANGLES = 7;
    public static final int ABSOLUTE_ORIENTATION_QUATERNION = 8;
    public static final int RELATIVE_ORIENTATION_EULER_ANGLES = 9;
    public static final int RELATIVE_ORIENTATION_QUATERNION = 10;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 10;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SensorType() {
    }
}
