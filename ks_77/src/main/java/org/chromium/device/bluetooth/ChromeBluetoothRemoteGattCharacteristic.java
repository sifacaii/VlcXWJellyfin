package org.chromium.device.bluetooth;

import android.annotation.TargetApi;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNIAdditionalImport;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.bluetooth.Wrappers;
import org.chromium.device.mojom.ConstantsConstants;

@JNIAdditionalImport({Wrappers.class})
@JNINamespace(ConstantsConstants.SERVICE_NAME)
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/ChromeBluetoothRemoteGattCharacteristic.class */
final class ChromeBluetoothRemoteGattCharacteristic {
    private static final String TAG = "Bluetooth";
    private long mNativeBluetoothRemoteGattCharacteristicAndroid;
    final Wrappers.BluetoothGattCharacteristicWrapper mCharacteristic;
    final String mInstanceId;
    final ChromeBluetoothDevice mChromeDevice;

    native void nativeOnChanged(long j, byte[] bArr);

    native void nativeOnRead(long j, int i, byte[] bArr);

    native void nativeOnWrite(long j, int i);

    private native void nativeCreateGattRemoteDescriptor(long j, String str, Wrappers.BluetoothGattDescriptorWrapper bluetoothGattDescriptorWrapper, ChromeBluetoothDevice chromeBluetoothDevice);

    private ChromeBluetoothRemoteGattCharacteristic(long nativeBluetoothRemoteGattCharacteristicAndroid, Wrappers.BluetoothGattCharacteristicWrapper characteristicWrapper, String instanceId, ChromeBluetoothDevice chromeDevice) {
        this.mNativeBluetoothRemoteGattCharacteristicAndroid = nativeBluetoothRemoteGattCharacteristicAndroid;
        this.mCharacteristic = characteristicWrapper;
        this.mInstanceId = instanceId;
        this.mChromeDevice = chromeDevice;
        this.mChromeDevice.mWrapperToChromeCharacteristicsMap.put(characteristicWrapper, this);
        Log.v(TAG, "ChromeBluetoothRemoteGattCharacteristic created.");
    }

    @CalledByNative
    private void onBluetoothRemoteGattCharacteristicAndroidDestruction() {
        Log.v(TAG, "ChromeBluetoothRemoteGattCharacteristic Destroyed.");
        if (this.mChromeDevice.mBluetoothGatt != null) {
            this.mChromeDevice.mBluetoothGatt.setCharacteristicNotification(this.mCharacteristic, false);
        }
        this.mNativeBluetoothRemoteGattCharacteristicAndroid = 0L;
        this.mChromeDevice.mWrapperToChromeCharacteristicsMap.remove(this.mCharacteristic);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCharacteristicChanged(byte[] value) {
        Log.i(TAG, "onCharacteristicChanged", new Object[0]);
        if (this.mNativeBluetoothRemoteGattCharacteristicAndroid != 0) {
            nativeOnChanged(this.mNativeBluetoothRemoteGattCharacteristicAndroid, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCharacteristicRead(int status) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(status);
        objArr[1] = status == 0 ? "OK" : "Error";
        Log.i(TAG, "onCharacteristicRead status:%d==%s", objArr);
        if (this.mNativeBluetoothRemoteGattCharacteristicAndroid != 0) {
            nativeOnRead(this.mNativeBluetoothRemoteGattCharacteristicAndroid, status, this.mCharacteristic.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCharacteristicWrite(int status) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(status);
        objArr[1] = status == 0 ? "OK" : "Error";
        Log.i(TAG, "onCharacteristicWrite status:%d==%s", objArr);
        if (this.mNativeBluetoothRemoteGattCharacteristicAndroid != 0) {
            nativeOnWrite(this.mNativeBluetoothRemoteGattCharacteristicAndroid, status);
        }
    }

    @CalledByNative
    private static ChromeBluetoothRemoteGattCharacteristic create(long nativeBluetoothRemoteGattCharacteristicAndroid, Wrappers.BluetoothGattCharacteristicWrapper characteristicWrapper, String instanceId, ChromeBluetoothDevice chromeDevice) {
        return new ChromeBluetoothRemoteGattCharacteristic(nativeBluetoothRemoteGattCharacteristicAndroid, characteristicWrapper, instanceId, chromeDevice);
    }

    @CalledByNative
    private String getUUID() {
        return this.mCharacteristic.getUuid().toString();
    }

    @CalledByNative
    private int getProperties() {
        return this.mCharacteristic.getProperties();
    }

    @CalledByNative
    private boolean readRemoteCharacteristic() {
        if (!this.mChromeDevice.mBluetoothGatt.readCharacteristic(this.mCharacteristic)) {
            Log.i(TAG, "readRemoteCharacteristic readCharacteristic failed.", new Object[0]);
            return false;
        }
        return true;
    }

    @CalledByNative
    private boolean writeRemoteCharacteristic(byte[] value) {
        if (!this.mCharacteristic.setValue(value)) {
            Log.i(TAG, "writeRemoteCharacteristic setValue failed.", new Object[0]);
            return false;
        } else if (!this.mChromeDevice.mBluetoothGatt.writeCharacteristic(this.mCharacteristic)) {
            Log.i(TAG, "writeRemoteCharacteristic writeCharacteristic failed.", new Object[0]);
            return false;
        } else {
            return true;
        }
    }

    @CalledByNative
    private boolean setCharacteristicNotification(boolean enabled) {
        return this.mChromeDevice.mBluetoothGatt.setCharacteristicNotification(this.mCharacteristic, enabled);
    }

    @CalledByNative
    private void createDescriptors() {
        List<Wrappers.BluetoothGattDescriptorWrapper> descriptors = this.mCharacteristic.getDescriptors();
        int instanceIdCounter = 0;
        for (Wrappers.BluetoothGattDescriptorWrapper descriptor : descriptors) {
            int i = instanceIdCounter;
            instanceIdCounter++;
            String descriptorInstanceId = this.mInstanceId + "/" + descriptor.getUuid().toString() + ";" + i;
            nativeCreateGattRemoteDescriptor(this.mNativeBluetoothRemoteGattCharacteristicAndroid, descriptorInstanceId, descriptor, this.mChromeDevice);
        }
    }
}
