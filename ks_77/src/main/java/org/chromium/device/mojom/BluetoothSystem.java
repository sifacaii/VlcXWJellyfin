package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem.class */
public interface BluetoothSystem extends Interface {
    public static final Interface.Manager<BluetoothSystem, Proxy> MANAGER = BluetoothSystem_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$GetAvailableDevicesResponse.class */
    public interface GetAvailableDevicesResponse extends Callbacks.Callback1<BluetoothDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$GetScanStateResponse.class */
    public interface GetScanStateResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$GetStateResponse.class */
    public interface GetStateResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$Proxy.class */
    public interface Proxy extends BluetoothSystem, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$SetPoweredResponse.class */
    public interface SetPoweredResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$StartScanResponse.class */
    public interface StartScanResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$StopScanResponse.class */
    public interface StopScanResponse extends Callbacks.Callback1<Integer> {
    }

    void getState(GetStateResponse getStateResponse);

    void setPowered(boolean z, SetPoweredResponse setPoweredResponse);

    void getScanState(GetScanStateResponse getScanStateResponse);

    void startScan(StartScanResponse startScanResponse);

    void stopScan(StopScanResponse stopScanResponse);

    void getAvailableDevices(GetAvailableDevicesResponse getAvailableDevicesResponse);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$State.class */
    public static final class State {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int UNSUPPORTED = 0;
        public static final int UNAVAILABLE = 1;
        public static final int POWERED_OFF = 2;
        public static final int TRANSITIONING = 3;
        public static final int POWERED_ON = 4;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 4;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private State() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$SetPoweredResult.class */
    public static final class SetPoweredResult {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int SUCCESS = 0;
        public static final int FAILED_UNKNOWN_REASON = 1;
        public static final int FAILED_BLUETOOTH_UNAVAILABLE = 2;
        public static final int FAILED_IN_PROGRESS = 3;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 3;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private SetPoweredResult() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$ScanState.class */
    public static final class ScanState {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int NOT_SCANNING = 0;
        public static final int TRANSITIONING = 1;
        public static final int SCANNING = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private ScanState() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$StartScanResult.class */
    public static final class StartScanResult {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int SUCCESS = 0;
        public static final int FAILED_UNKNOWN_REASON = 1;
        public static final int FAILED_BLUETOOTH_UNAVAILABLE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private StartScanResult() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystem$StopScanResult.class */
    public static final class StopScanResult {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int SUCCESS = 0;
        public static final int FAILED_UNKNOWN_REASON = 1;
        public static final int FAILED_BLUETOOTH_UNAVAILABLE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private StopScanResult() {
        }
    }
}
