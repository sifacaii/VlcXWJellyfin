package org.chromium.device.bluetooth;

import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNIAdditionalImport;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.bluetooth.Wrappers;
import org.chromium.device.mojom.ConstantsConstants;

@JNIAdditionalImport({Wrappers.class})
@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/ChromeBluetoothRemoteGattDescriptor.class */
final class ChromeBluetoothRemoteGattDescriptor {
    private static final String TAG = "Bluetooth";
    private long mNativeBluetoothRemoteGattDescriptorAndroid;
    final Wrappers.BluetoothGattDescriptorWrapper mDescriptor;
    final ChromeBluetoothDevice mChromeDevice;

    native void nativeOnRead(long j, int i, byte[] bArr);

    native void nativeOnWrite(long j, int i);

    private ChromeBluetoothRemoteGattDescriptor(long nativeBluetoothRemoteGattDescriptorAndroid, Wrappers.BluetoothGattDescriptorWrapper descriptorWrapper, ChromeBluetoothDevice chromeDevice) {
        this.mNativeBluetoothRemoteGattDescriptorAndroid = nativeBluetoothRemoteGattDescriptorAndroid;
        this.mDescriptor = descriptorWrapper;
        this.mChromeDevice = chromeDevice;
        this.mChromeDevice.mWrapperToChromeDescriptorsMap.put(descriptorWrapper, this);
        Log.v(TAG, "ChromeBluetoothRemoteGattDescriptor created.");
    }

    @CalledByNative
    private void onBluetoothRemoteGattDescriptorAndroidDestruction() {
        Log.v(TAG, "ChromeBluetoothRemoteGattDescriptor Destroyed.");
        this.mNativeBluetoothRemoteGattDescriptorAndroid = 0L;
        this.mChromeDevice.mWrapperToChromeDescriptorsMap.remove(this.mDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDescriptorRead(int status) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(status);
        objArr[1] = status == 0 ? "OK" : "Error";
        Log.i(TAG, "onDescriptorRead status:%d==%s", objArr);
        if (this.mNativeBluetoothRemoteGattDescriptorAndroid != 0) {
            nativeOnRead(this.mNativeBluetoothRemoteGattDescriptorAndroid, status, this.mDescriptor.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDescriptorWrite(int status) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(status);
        objArr[1] = status == 0 ? "OK" : "Error";
        Log.i(TAG, "onDescriptorWrite status:%d==%s", objArr);
        if (this.mNativeBluetoothRemoteGattDescriptorAndroid != 0) {
            nativeOnWrite(this.mNativeBluetoothRemoteGattDescriptorAndroid, status);
        }
    }

    @CalledByNative
    private static ChromeBluetoothRemoteGattDescriptor create(long nativeBluetoothRemoteGattDescriptorAndroid, Wrappers.BluetoothGattDescriptorWrapper descriptorWrapper, ChromeBluetoothDevice chromeDevice) {
        return new ChromeBluetoothRemoteGattDescriptor(nativeBluetoothRemoteGattDescriptorAndroid, descriptorWrapper, chromeDevice);
    }

    @CalledByNative
    private String getUUID() {
        return this.mDescriptor.getUuid().toString();
    }

    @CalledByNative
    private boolean readRemoteDescriptor() {
        if (!this.mChromeDevice.mBluetoothGatt.readDescriptor(this.mDescriptor)) {
            Log.i(TAG, "readRemoteDescriptor readDescriptor failed.", new Object[0]);
            return false;
        }
        return true;
    }

    @CalledByNative
    private boolean writeRemoteDescriptor(byte[] value) {
        if (!this.mDescriptor.setValue(value)) {
            Log.i(TAG, "writeRemoteDescriptor setValue failed.", new Object[0]);
            return false;
        } else if (!this.mChromeDevice.mBluetoothGatt.writeDescriptor(this.mDescriptor)) {
            Log.i(TAG, "writeRemoteDescriptor writeDescriptor failed.", new Object[0]);
            return false;
        } else {
            return true;
        }
    }
}
