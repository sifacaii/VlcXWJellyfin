package org.chromium.device.bluetooth;

import android.annotation.TargetApi;
import java.util.HashMap;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNIAdditionalImport;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.device.bluetooth.Wrappers;
import org.chromium.device.mojom.ConstantsConstants;

/* JADX INFO: Access modifiers changed from: package-private */
@JNIAdditionalImport({Wrappers.class})
@JNINamespace(ConstantsConstants.SERVICE_NAME)
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/ChromeBluetoothDevice.class */
public final class ChromeBluetoothDevice {
    private static final String TAG = "Bluetooth";
    private long mNativeBluetoothDeviceAndroid;
    final Wrappers.BluetoothDeviceWrapper mDevice;
    Wrappers.BluetoothGattWrapper mBluetoothGatt;
    private final BluetoothGattCallbackImpl mBluetoothGattCallbackImpl = new BluetoothGattCallbackImpl();
    final HashMap<Wrappers.BluetoothGattCharacteristicWrapper, ChromeBluetoothRemoteGattCharacteristic> mWrapperToChromeCharacteristicsMap = new HashMap<>();
    final HashMap<Wrappers.BluetoothGattDescriptorWrapper, ChromeBluetoothRemoteGattDescriptor> mWrapperToChromeDescriptorsMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnConnectionStateChange(long j, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCreateGattRemoteService(long j, String str, Wrappers.BluetoothGattServiceWrapper bluetoothGattServiceWrapper);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnGattServicesDiscovered(long j);

    private ChromeBluetoothDevice(long nativeBluetoothDeviceAndroid, Wrappers.BluetoothDeviceWrapper deviceWrapper) {
        this.mNativeBluetoothDeviceAndroid = nativeBluetoothDeviceAndroid;
        this.mDevice = deviceWrapper;
        Log.v(TAG, "ChromeBluetoothDevice created.");
    }

    @CalledByNative
    private void onBluetoothDeviceAndroidDestruction() {
        if (this.mBluetoothGatt != null) {
            this.mBluetoothGatt.close();
            this.mBluetoothGatt = null;
        }
        this.mNativeBluetoothDeviceAndroid = 0L;
    }

    @CalledByNative
    private static ChromeBluetoothDevice create(long nativeBluetoothDeviceAndroid, Wrappers.BluetoothDeviceWrapper deviceWrapper) {
        return new ChromeBluetoothDevice(nativeBluetoothDeviceAndroid, deviceWrapper);
    }

    @CalledByNative
    private int getBluetoothClass() {
        return this.mDevice.getBluetoothClass_getDeviceClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CalledByNative
    public String getAddress() {
        return this.mDevice.getAddress();
    }

    @CalledByNative
    private String getName() {
        return this.mDevice.getName();
    }

    @CalledByNative
    private boolean isPaired() {
        return this.mDevice.getBondState() == 12;
    }

    @CalledByNative
    private void createGattConnectionImpl() {
        Log.i(TAG, "connectGatt", new Object[0]);
        if (this.mBluetoothGatt != null) {
            this.mBluetoothGatt.close();
        }
        this.mBluetoothGatt = this.mDevice.connectGatt(ContextUtils.getApplicationContext(), false, this.mBluetoothGattCallbackImpl, 2);
    }

    @CalledByNative
    private void disconnectGatt() {
        Log.i(TAG, "BluetoothGatt.disconnect", new Object[0]);
        if (this.mBluetoothGatt != null) {
            this.mBluetoothGatt.disconnect();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/ChromeBluetoothDevice$BluetoothGattCallbackImpl.class */
    private class BluetoothGattCallbackImpl extends Wrappers.BluetoothGattCallbackWrapper {
        private BluetoothGattCallbackImpl() {
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onConnectionStateChange(final int status, final int newState) {
            String str;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(status);
            if (newState == 2) {
                str = "Connected";
            } else {
                str = "Disconnected";
            }
            objArr[1] = str;
            Log.i(ChromeBluetoothDevice.TAG, "onConnectionStateChange status:%d newState:%s", objArr);
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (newState == 2) {
                        RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onConnectionStateChange.Status.Connected", status);
                        ChromeBluetoothDevice.this.mBluetoothGatt.discoverServices();
                    } else if (newState == 0) {
                        RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onConnectionStateChange.Status.Disconnected", status);
                        if (ChromeBluetoothDevice.this.mBluetoothGatt != null) {
                            ChromeBluetoothDevice.this.mBluetoothGatt.close();
                            ChromeBluetoothDevice.this.mBluetoothGatt = null;
                        }
                    } else {
                        RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onConnectionStateChange.Status.InvalidState", status);
                    }
                    if (ChromeBluetoothDevice.this.mNativeBluetoothDeviceAndroid != 0) {
                        ChromeBluetoothDevice.this.nativeOnConnectionStateChange(ChromeBluetoothDevice.this.mNativeBluetoothDeviceAndroid, status, newState == 2);
                    }
                }
            });
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onServicesDiscovered(final int status) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(status);
            objArr[1] = status == 0 ? "OK" : "Error";
            Log.i(ChromeBluetoothDevice.TAG, "onServicesDiscovered status:%d==%s", objArr);
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ChromeBluetoothDevice.this.mNativeBluetoothDeviceAndroid != 0) {
                        if (ChromeBluetoothDevice.this.mBluetoothGatt == null) {
                            RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onServicesDiscovered.Status.Disconnected", status);
                            return;
                        }
                        RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onServicesDiscovered.Status.Connected", status);
                        for (Wrappers.BluetoothGattServiceWrapper service : ChromeBluetoothDevice.this.mBluetoothGatt.getServices()) {
                            String serviceInstanceId = ChromeBluetoothDevice.this.getAddress() + "/" + service.getUuid().toString() + "," + service.getInstanceId();
                            ChromeBluetoothDevice.this.nativeCreateGattRemoteService(ChromeBluetoothDevice.this.mNativeBluetoothDeviceAndroid, serviceInstanceId, service);
                        }
                        ChromeBluetoothDevice.this.nativeOnGattServicesDiscovered(ChromeBluetoothDevice.this.mNativeBluetoothDeviceAndroid);
                    }
                }
            });
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onCharacteristicChanged(final Wrappers.BluetoothGattCharacteristicWrapper characteristic) {
            Log.i(ChromeBluetoothDevice.TAG, "device onCharacteristicChanged.", new Object[0]);
            final byte[] value = characteristic.getValue();
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ChromeBluetoothRemoteGattCharacteristic chromeCharacteristic = ChromeBluetoothDevice.this.mWrapperToChromeCharacteristicsMap.get(characteristic);
                    if (chromeCharacteristic == null) {
                        Log.v(ChromeBluetoothDevice.TAG, "onCharacteristicChanged when chromeCharacteristic == null.");
                    } else {
                        chromeCharacteristic.onCharacteristicChanged(value);
                    }
                }
            });
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onCharacteristicRead(final Wrappers.BluetoothGattCharacteristicWrapper characteristic, final int status) {
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ChromeBluetoothRemoteGattCharacteristic chromeCharacteristic = ChromeBluetoothDevice.this.mWrapperToChromeCharacteristicsMap.get(characteristic);
                    if (chromeCharacteristic == null) {
                        Log.v(ChromeBluetoothDevice.TAG, "onCharacteristicRead when chromeCharacteristic == null.");
                        return;
                    }
                    RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onCharacteristicRead.Status", status);
                    chromeCharacteristic.onCharacteristicRead(status);
                }
            });
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onCharacteristicWrite(final Wrappers.BluetoothGattCharacteristicWrapper characteristic, final int status) {
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ChromeBluetoothRemoteGattCharacteristic chromeCharacteristic = ChromeBluetoothDevice.this.mWrapperToChromeCharacteristicsMap.get(characteristic);
                    if (chromeCharacteristic == null) {
                        Log.v(ChromeBluetoothDevice.TAG, "onCharacteristicWrite when chromeCharacteristic == null.");
                        return;
                    }
                    RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onCharacteristicWrite.Status", status);
                    chromeCharacteristic.onCharacteristicWrite(status);
                }
            });
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onDescriptorRead(final Wrappers.BluetoothGattDescriptorWrapper descriptor, final int status) {
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    ChromeBluetoothRemoteGattDescriptor chromeDescriptor = ChromeBluetoothDevice.this.mWrapperToChromeDescriptorsMap.get(descriptor);
                    if (chromeDescriptor == null) {
                        Log.v(ChromeBluetoothDevice.TAG, "onDescriptorRead when chromeDescriptor == null.");
                        return;
                    }
                    RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onDescriptorRead.Status", status);
                    chromeDescriptor.onDescriptorRead(status);
                }
            });
        }

        @Override // org.chromium.device.bluetooth.Wrappers.BluetoothGattCallbackWrapper
        public void onDescriptorWrite(final Wrappers.BluetoothGattDescriptorWrapper descriptor, final int status) {
            Wrappers.ThreadUtilsWrapper.getInstance().runOnUiThread(new Runnable() { // from class: org.chromium.device.bluetooth.ChromeBluetoothDevice.BluetoothGattCallbackImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    ChromeBluetoothRemoteGattDescriptor chromeDescriptor = ChromeBluetoothDevice.this.mWrapperToChromeDescriptorsMap.get(descriptor);
                    if (chromeDescriptor == null) {
                        Log.v(ChromeBluetoothDevice.TAG, "onDescriptorWrite when chromeDescriptor == null.");
                        return;
                    }
                    RecordHistogram.recordSparseHistogram("Bluetooth.Web.Android.onDescriptorWrite.Status", status);
                    chromeDescriptor.onDescriptorWrite(status);
                }
            });
        }
    }
}
