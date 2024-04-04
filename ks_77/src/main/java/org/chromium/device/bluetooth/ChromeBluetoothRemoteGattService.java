package org.chromium.device.bluetooth;

import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNIAdditionalImport;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.bluetooth.Wrappers;
import org.chromium.device.mojom.ConstantsConstants;

@JNIAdditionalImport({Wrappers.class})
@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/ChromeBluetoothRemoteGattService.class */
final class ChromeBluetoothRemoteGattService {
    private static final String TAG = "Bluetooth";
    private long mNativeBluetoothRemoteGattServiceAndroid;
    final Wrappers.BluetoothGattServiceWrapper mService;
    final String mInstanceId;
    ChromeBluetoothDevice mChromeDevice;

    private native void nativeCreateGattRemoteCharacteristic(long j, String str, Wrappers.BluetoothGattCharacteristicWrapper bluetoothGattCharacteristicWrapper, ChromeBluetoothDevice chromeBluetoothDevice);

    private ChromeBluetoothRemoteGattService(long nativeBluetoothRemoteGattServiceAndroid, Wrappers.BluetoothGattServiceWrapper serviceWrapper, String instanceId, ChromeBluetoothDevice chromeDevice) {
        this.mNativeBluetoothRemoteGattServiceAndroid = nativeBluetoothRemoteGattServiceAndroid;
        this.mService = serviceWrapper;
        this.mInstanceId = instanceId;
        this.mChromeDevice = chromeDevice;
        Log.v(TAG, "ChromeBluetoothRemoteGattService created.");
    }

    @CalledByNative
    private void onBluetoothRemoteGattServiceAndroidDestruction() {
        this.mNativeBluetoothRemoteGattServiceAndroid = 0L;
    }

    @CalledByNative
    private static ChromeBluetoothRemoteGattService create(long nativeBluetoothRemoteGattServiceAndroid, Wrappers.BluetoothGattServiceWrapper serviceWrapper, String instanceId, ChromeBluetoothDevice chromeDevice) {
        return new ChromeBluetoothRemoteGattService(nativeBluetoothRemoteGattServiceAndroid, serviceWrapper, instanceId, chromeDevice);
    }

    @CalledByNative
    private String getUUID() {
        return this.mService.getUuid().toString();
    }

    @CalledByNative
    private void createCharacteristics() {
        List<Wrappers.BluetoothGattCharacteristicWrapper> characteristics = this.mService.getCharacteristics();
        for (Wrappers.BluetoothGattCharacteristicWrapper characteristic : characteristics) {
            String characteristicInstanceId = this.mInstanceId + "/" + characteristic.getUuid().toString() + "," + characteristic.getInstanceId();
            nativeCreateGattRemoteCharacteristic(this.mNativeBluetoothRemoteGattServiceAndroid, characteristicInstanceId, characteristic, this.mChromeDevice);
        }
    }
}
