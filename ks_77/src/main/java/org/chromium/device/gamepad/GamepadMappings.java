package org.chromium.device.gamepad;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.InputDevice;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings.class */
abstract class GamepadMappings {
    @VisibleForTesting
    static final String NVIDIA_SHIELD_DEVICE_NAME_PREFIX = "NVIDIA Corporation NVIDIA Controller";
    @VisibleForTesting
    static final String MICROSOFT_XBOX_PAD_DEVICE_NAME = "Microsoft X-Box 360 pad";
    @VisibleForTesting
    static final String PS3_SIXAXIS_DEVICE_NAME = "Sony PLAYSTATION(R)3 Controller";
    @VisibleForTesting
    static final String SAMSUNG_EI_GP20_DEVICE_NAME = "Samsung Game Pad EI-GP20";
    @VisibleForTesting
    static final String AMAZON_FIRE_DEVICE_NAME = "Amazon Fire Game Controller";
    @VisibleForTesting
    static final int PS_DUALSHOCK_4_VENDOR_ID = 1356;
    @VisibleForTesting
    static final int PS_DUALSHOCK_4_PRODUCT_ID = 1476;
    @VisibleForTesting
    static final int PS_DUALSHOCK_4_SLIM_PRODUCT_ID = 2508;
    @VisibleForTesting
    static final int PS_DUALSHOCK_4_USB_RECEIVER_PRODUCT_ID = 2976;
    @VisibleForTesting
    static final int XBOX_ONE_S_2016_FIRMWARE_VENDOR_ID = 1118;
    @VisibleForTesting
    static final int XBOX_ONE_S_2016_FIRMWARE_PRODUCT_ID = 736;

    public abstract void mapToStandardGamepad(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    GamepadMappings() {
    }

    public static GamepadMappings getMappings(InputDevice device, int[] axes) {
        GamepadMappings mappings = null;
        if (Build.VERSION.SDK_INT >= 19) {
            mappings = getMappings(device.getProductId(), device.getVendorId());
        }
        if (mappings == null) {
            mappings = getMappings(device.getName());
        }
        if (mappings == null) {
            mappings = new UnknownGamepadMappings(axes);
        }
        return mappings;
    }

    @VisibleForTesting
    @TargetApi(19)
    static GamepadMappings getMappings(int productId, int vendorId) {
        if (vendorId == 1356 && (productId == 1476 || productId == 2508 || productId == 2976)) {
            return new PS4GamepadMappings();
        }
        if (vendorId == 1118 && productId == 736) {
            return new XboxOneS2016FirmwareMappings();
        }
        return null;
    }

    @VisibleForTesting
    static GamepadMappings getMappings(String deviceName) {
        if (deviceName.startsWith(NVIDIA_SHIELD_DEVICE_NAME_PREFIX) || deviceName.equals(MICROSOFT_XBOX_PAD_DEVICE_NAME)) {
            return new XboxCompatibleGamepadMappings();
        }
        if (deviceName.equals(PS3_SIXAXIS_DEVICE_NAME)) {
            return new PS3SixAxisGamepadMappings();
        }
        if (deviceName.equals(SAMSUNG_EI_GP20_DEVICE_NAME)) {
            return new SamsungEIGP20GamepadMappings();
        }
        if (deviceName.equals(AMAZON_FIRE_DEVICE_NAME)) {
            return new AmazonFireGamepadMappings();
        }
        return null;
    }

    @VisibleForTesting
    static GamepadMappings getUnknownGamepadMappings(int[] axes) {
        return new UnknownGamepadMappings(axes);
    }

    public boolean isStandard() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapCommonXYABButtons(float[] mappedButtons, float[] rawButtons) {
        float a = rawButtons[96];
        float b = rawButtons[97];
        float x = rawButtons[99];
        float y = rawButtons[100];
        mappedButtons[0] = a;
        mappedButtons[1] = b;
        mappedButtons[2] = x;
        mappedButtons[3] = y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapCommonStartSelectMetaButtons(float[] mappedButtons, float[] rawButtons) {
        float start = rawButtons[108];
        float select = rawButtons[109];
        float mode = rawButtons[110];
        mappedButtons[9] = start;
        mappedButtons[8] = select;
        mappedButtons[16] = mode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapCommonThumbstickButtons(float[] mappedButtons, float[] rawButtons) {
        float thumbL = rawButtons[106];
        float thumbR = rawButtons[107];
        mappedButtons[10] = thumbL;
        mappedButtons[11] = thumbR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapUpperTriggerButtonsToBottomShoulder(float[] mappedButtons, float[] rawButtons) {
        float l1 = rawButtons[102];
        float r1 = rawButtons[103];
        mappedButtons[6] = l1;
        mappedButtons[7] = r1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapTriggerButtonsToTopShoulder(float[] mappedButtons, float[] rawButtons) {
        float l1 = rawButtons[102];
        float r1 = rawButtons[103];
        mappedButtons[4] = l1;
        mappedButtons[5] = r1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapCommonDpadButtons(float[] mappedButtons, float[] rawButtons) {
        float dpadDown = rawButtons[20];
        float dpadUp = rawButtons[19];
        float dpadLeft = rawButtons[21];
        float dpadRight = rawButtons[22];
        mappedButtons[13] = dpadDown;
        mappedButtons[12] = dpadUp;
        mappedButtons[14] = dpadLeft;
        mappedButtons[15] = dpadRight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapXYAxes(float[] mappedAxes, float[] rawAxes) {
        mappedAxes[0] = rawAxes[0];
        mappedAxes[1] = rawAxes[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapRXAndRYAxesToRightStick(float[] mappedAxes, float[] rawAxes) {
        mappedAxes[2] = rawAxes[12];
        mappedAxes[3] = rawAxes[13];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapZAndRZAxesToRightStick(float[] mappedAxes, float[] rawAxes) {
        mappedAxes[2] = rawAxes[11];
        mappedAxes[3] = rawAxes[14];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapPedalAxesToBottomShoulder(float[] mappedButtons, float[] rawAxes) {
        float lTrigger = rawAxes[23];
        float rTrigger = rawAxes[22];
        mappedButtons[6] = lTrigger;
        mappedButtons[7] = rTrigger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapTriggerAxesToBottomShoulder(float[] mappedButtons, float[] rawAxes) {
        float lTrigger = rawAxes[17];
        float rTrigger = rawAxes[18];
        mappedButtons[6] = lTrigger;
        mappedButtons[7] = rTrigger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapLowerTriggerButtonsToBottomShoulder(float[] mappedButtons, float[] rawButtons) {
        float l2 = rawButtons[104];
        float r2 = rawButtons[105];
        mappedButtons[6] = l2;
        mappedButtons[7] = r2;
    }

    @VisibleForTesting
    static float negativeAxisValueAsButton(float input) {
        return input < -0.5f ? 1.0f : 0.0f;
    }

    @VisibleForTesting
    static float positiveAxisValueAsButton(float input) {
        return input > 0.5f ? 1.0f : 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mapHatAxisToDpadButtons(float[] mappedButtons, float[] rawAxes) {
        float hatX = rawAxes[15];
        float hatY = rawAxes[16];
        mappedButtons[14] = negativeAxisValueAsButton(hatX);
        mappedButtons[15] = positiveAxisValueAsButton(hatX);
        mappedButtons[12] = negativeAxisValueAsButton(hatY);
        mappedButtons[13] = positiveAxisValueAsButton(hatY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$AmazonFireGamepadMappings.class */
    public static class AmazonFireGamepadMappings extends GamepadMappings {
        private AmazonFireGamepadMappings() {
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
            GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
            GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
            GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
            GamepadMappings.mapPedalAxesToBottomShoulder(mappedButtons, rawAxes);
            GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$XboxCompatibleGamepadMappings.class */
    public static class XboxCompatibleGamepadMappings extends GamepadMappings {
        private XboxCompatibleGamepadMappings() {
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
            GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
            GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
            GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
            GamepadMappings.mapTriggerAxesToBottomShoulder(mappedButtons, rawAxes);
            GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$XboxOneS2016FirmwareMappings.class */
    public static class XboxOneS2016FirmwareMappings extends GamepadMappings {
        private boolean mLeftTriggerActivated;
        private boolean mRightTriggerActivated;

        private XboxOneS2016FirmwareMappings() {
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            mappedButtons[0] = rawButtons[96];
            mappedButtons[1] = rawButtons[97];
            mappedButtons[2] = rawButtons[98];
            mappedButtons[3] = rawButtons[99];
            mappedButtons[4] = rawButtons[100];
            mappedButtons[5] = rawButtons[101];
            mappedButtons[8] = rawButtons[102];
            mappedButtons[9] = rawButtons[103];
            mappedButtons[10] = rawButtons[104];
            mappedButtons[11] = rawButtons[105];
            if (rawAxes[11] != 0.0f) {
                this.mLeftTriggerActivated = true;
            }
            if (rawAxes[14] != 0.0f) {
                this.mRightTriggerActivated = true;
            }
            if (this.mLeftTriggerActivated) {
                mappedButtons[6] = (rawAxes[11] + 1.0f) / 2.0f;
            } else {
                mappedButtons[6] = 0.0f;
            }
            if (this.mRightTriggerActivated) {
                mappedButtons[7] = (rawAxes[14] + 1.0f) / 2.0f;
            } else {
                mappedButtons[7] = 0.0f;
            }
            GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            GamepadMappings.mapRXAndRYAxesToRightStick(mappedAxes, rawAxes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$PS3SixAxisGamepadMappings.class */
    public static class PS3SixAxisGamepadMappings extends GamepadMappings {
        private PS3SixAxisGamepadMappings() {
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            float a = rawButtons[96];
            float b = rawButtons[97];
            float x = rawButtons[99];
            float y = rawButtons[100];
            mappedButtons[0] = x;
            mappedButtons[1] = y;
            mappedButtons[2] = a;
            mappedButtons[3] = b;
            GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
            GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
            GamepadMappings.mapCommonDpadButtons(mappedButtons, rawButtons);
            GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
            GamepadMappings.mapTriggerAxesToBottomShoulder(mappedButtons, rawAxes);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$PS4GamepadMappings.class */
    public static class PS4GamepadMappings extends GamepadMappings {
        PS4GamepadMappings() {
        }

        private static float scaleRxRy(float input) {
            return 1.0f - ((1.0f - input) / 2.0f);
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            float a = rawButtons[96];
            float b = rawButtons[97];
            float c = rawButtons[98];
            float x = rawButtons[99];
            mappedButtons[0] = b;
            mappedButtons[1] = c;
            mappedButtons[2] = a;
            mappedButtons[3] = x;
            float y = rawButtons[100];
            float z = rawButtons[101];
            mappedButtons[4] = y;
            mappedButtons[5] = z;
            float rx = rawAxes[12];
            float ry = rawAxes[13];
            mappedButtons[6] = scaleRxRy(rx);
            mappedButtons[7] = scaleRxRy(ry);
            float share = rawButtons[104];
            float options = rawButtons[105];
            mappedButtons[8] = share;
            mappedButtons[9] = options;
            float thumbL = rawButtons[109];
            float thumbR = rawButtons[108];
            mappedButtons[10] = thumbL;
            mappedButtons[11] = thumbR;
            float mode = rawButtons[110];
            mappedButtons[16] = mode;
            GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            GamepadMappings.mapZAndRZAxesToRightStick(mappedAxes, rawAxes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$SamsungEIGP20GamepadMappings.class */
    public static class SamsungEIGP20GamepadMappings extends GamepadMappings {
        private SamsungEIGP20GamepadMappings() {
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
            GamepadMappings.mapUpperTriggerButtonsToBottomShoulder(mappedButtons, rawButtons);
            GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
            GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
            GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            GamepadMappings.mapRXAndRYAxesToRightStick(mappedAxes, rawAxes);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/gamepad/GamepadMappings$UnknownGamepadMappings.class */
    private static class UnknownGamepadMappings extends GamepadMappings {
        private int mLeftTriggerAxis;
        private int mRightTriggerAxis;
        private int mRightStickXAxis;
        private int mRightStickYAxis;
        private boolean mUseHatAxes;

        UnknownGamepadMappings(int[] axes) {
            this.mLeftTriggerAxis = -1;
            this.mRightTriggerAxis = -1;
            this.mRightStickXAxis = -1;
            this.mRightStickYAxis = -1;
            int hatAxesFound = 0;
            for (int axis : axes) {
                switch (axis) {
                    case 11:
                    case 12:
                        this.mRightStickXAxis = axis;
                        break;
                    case 13:
                    case 14:
                        this.mRightStickYAxis = axis;
                        break;
                    case 15:
                        hatAxesFound++;
                        break;
                    case 16:
                        hatAxesFound++;
                        break;
                    case 17:
                    case 23:
                        this.mLeftTriggerAxis = axis;
                        break;
                    case 18:
                    case 19:
                    case 22:
                        this.mRightTriggerAxis = axis;
                        break;
                }
            }
            if (hatAxesFound == 2) {
                this.mUseHatAxes = true;
            }
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public boolean isStandard() {
            return false;
        }

        @Override // org.chromium.device.gamepad.GamepadMappings
        public void mapToStandardGamepad(float[] mappedAxes, float[] mappedButtons, float[] rawAxes, float[] rawButtons) {
            GamepadMappings.mapCommonXYABButtons(mappedButtons, rawButtons);
            GamepadMappings.mapTriggerButtonsToTopShoulder(mappedButtons, rawButtons);
            GamepadMappings.mapCommonThumbstickButtons(mappedButtons, rawButtons);
            GamepadMappings.mapCommonStartSelectMetaButtons(mappedButtons, rawButtons);
            GamepadMappings.mapXYAxes(mappedAxes, rawAxes);
            if (this.mLeftTriggerAxis == -1 || this.mRightTriggerAxis == -1) {
                GamepadMappings.mapLowerTriggerButtonsToBottomShoulder(mappedButtons, rawButtons);
            } else {
                float lTrigger = rawAxes[this.mLeftTriggerAxis];
                float rTrigger = rawAxes[this.mRightTriggerAxis];
                mappedButtons[6] = lTrigger;
                mappedButtons[7] = rTrigger;
            }
            if (this.mRightStickXAxis != -1 && this.mRightStickYAxis != -1) {
                float rX = rawAxes[this.mRightStickXAxis];
                float rY = rawAxes[this.mRightStickYAxis];
                mappedAxes[2] = rX;
                mappedAxes[3] = rY;
            }
            if (this.mUseHatAxes) {
                GamepadMappings.mapHatAxisToDpadButtons(mappedButtons, rawAxes);
            } else {
                GamepadMappings.mapCommonDpadButtons(mappedButtons, rawButtons);
            }
        }
    }
}
