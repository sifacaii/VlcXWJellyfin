package org.chromium.device.bluetooth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers.class */
class Wrappers {
    private static final String TAG = "Bluetooth";
    public static final int DEVICE_CLASS_UNSPECIFIED = 7936;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothGattCallbackWrapper.class */
    static abstract class BluetoothGattCallbackWrapper {
        public abstract void onCharacteristicChanged(BluetoothGattCharacteristicWrapper bluetoothGattCharacteristicWrapper);

        public abstract void onCharacteristicRead(BluetoothGattCharacteristicWrapper bluetoothGattCharacteristicWrapper, int i);

        public abstract void onCharacteristicWrite(BluetoothGattCharacteristicWrapper bluetoothGattCharacteristicWrapper, int i);

        public abstract void onDescriptorRead(BluetoothGattDescriptorWrapper bluetoothGattDescriptorWrapper, int i);

        public abstract void onDescriptorWrite(BluetoothGattDescriptorWrapper bluetoothGattDescriptorWrapper, int i);

        public abstract void onConnectionStateChange(int i, int i2);

        public abstract void onServicesDiscovered(int i);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$ScanCallbackWrapper.class */
    static abstract class ScanCallbackWrapper {
        public abstract void onBatchScanResult(List<ScanResultWrapper> list);

        public abstract void onScanResult(int i, ScanResultWrapper scanResultWrapper);

        public abstract void onScanFailed(int i);
    }

    Wrappers() {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$ThreadUtilsWrapper.class */
    static class ThreadUtilsWrapper {
        private static Factory sFactory;
        private static ThreadUtilsWrapper sInstance;

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$ThreadUtilsWrapper$Factory.class */
        public interface Factory {
            ThreadUtilsWrapper create();
        }

        protected ThreadUtilsWrapper() {
        }

        public static ThreadUtilsWrapper getInstance() {
            if (sInstance == null) {
                if (sFactory == null) {
                    sInstance = new ThreadUtilsWrapper();
                } else {
                    sInstance = sFactory.create();
                }
            }
            return sInstance;
        }

        public void runOnUiThread(Runnable r) {
            ThreadUtils.runOnUiThread(r);
        }

        public static void setFactory(Factory factory) {
            sFactory = factory;
            sInstance = null;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothAdapterWrapper.class */
    static class BluetoothAdapterWrapper {
        private final BluetoothAdapter mAdapter;
        protected final Context mContext;
        protected BluetoothLeScannerWrapper mScannerWrapper;

        @CalledByNative("BluetoothAdapterWrapper")
        public static BluetoothAdapterWrapper createWithDefaultAdapter() {
            boolean hasMinAPI = Build.VERSION.SDK_INT >= 23;
            if (!hasMinAPI) {
                Log.i(Wrappers.TAG, "BluetoothAdapterWrapper.create failed: SDK version (%d) too low.", Integer.valueOf(Build.VERSION.SDK_INT));
                return null;
            }
            boolean hasPermissions = ContextUtils.getApplicationContext().checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0 && ContextUtils.getApplicationContext().checkCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN") == 0;
            if (!hasPermissions) {
                Log.w(Wrappers.TAG, "BluetoothAdapterWrapper.create failed: Lacking Bluetooth permissions.", new Object[0]);
                return null;
            }
            boolean hasLowEnergyFeature = Build.VERSION.SDK_INT >= 18 && ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            if (!hasLowEnergyFeature) {
                Log.i(Wrappers.TAG, "BluetoothAdapterWrapper.create failed: No Low Energy support.", new Object[0]);
                return null;
            }
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter == null) {
                Log.i(Wrappers.TAG, "BluetoothAdapterWrapper.create failed: Default adapter not found.", new Object[0]);
                return null;
            }
            return new BluetoothAdapterWrapper(adapter, ContextUtils.getApplicationContext());
        }

        public BluetoothAdapterWrapper(BluetoothAdapter adapter, Context context) {
            this.mAdapter = adapter;
            this.mContext = context;
        }

        public boolean disable() {
            return this.mAdapter.disable();
        }

        public boolean enable() {
            return this.mAdapter.enable();
        }

        @SuppressLint({"HardwareIds"})
        public String getAddress() {
            return this.mAdapter.getAddress();
        }

        public BluetoothLeScannerWrapper getBluetoothLeScanner() {
            BluetoothLeScanner scanner = this.mAdapter.getBluetoothLeScanner();
            if (scanner == null) {
                return null;
            }
            if (this.mScannerWrapper == null) {
                this.mScannerWrapper = new BluetoothLeScannerWrapper(scanner);
            }
            return this.mScannerWrapper;
        }

        public Context getContext() {
            return this.mContext;
        }

        public String getName() {
            return this.mAdapter.getName();
        }

        public int getScanMode() {
            return this.mAdapter.getScanMode();
        }

        public boolean isDiscovering() {
            return this.mAdapter.isDiscovering();
        }

        public boolean isEnabled() {
            return this.mAdapter.isEnabled();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothLeScannerWrapper.class */
    static class BluetoothLeScannerWrapper {
        protected final BluetoothLeScanner mScanner;
        private final HashMap<ScanCallbackWrapper, ForwardScanCallbackToWrapper> mCallbacks = new HashMap<>();

        public BluetoothLeScannerWrapper(BluetoothLeScanner scanner) {
            this.mScanner = scanner;
        }

        public void startScan(List<ScanFilter> filters, int scanSettingsScanMode, ScanCallbackWrapper callback) {
            ScanSettings settings = new ScanSettings.Builder().setScanMode(scanSettingsScanMode).build();
            ForwardScanCallbackToWrapper callbackForwarder = new ForwardScanCallbackToWrapper(callback);
            this.mCallbacks.put(callback, callbackForwarder);
            this.mScanner.startScan(filters, settings, callbackForwarder);
        }

        public void stopScan(ScanCallbackWrapper callback) {
            ForwardScanCallbackToWrapper callbackForwarder = this.mCallbacks.remove(callback);
            this.mScanner.stopScan(callbackForwarder);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$ForwardScanCallbackToWrapper.class */
    static class ForwardScanCallbackToWrapper extends ScanCallback {
        final ScanCallbackWrapper mWrapperCallback;

        ForwardScanCallbackToWrapper(ScanCallbackWrapper wrapperCallback) {
            this.mWrapperCallback = wrapperCallback;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            ArrayList<ScanResultWrapper> resultsWrapped = new ArrayList<>(results.size());
            for (ScanResult result : results) {
                resultsWrapped.add(new ScanResultWrapper(result));
            }
            this.mWrapperCallback.onBatchScanResult(resultsWrapped);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int callbackType, ScanResult result) {
            this.mWrapperCallback.onScanResult(callbackType, new ScanResultWrapper(result));
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int errorCode) {
            this.mWrapperCallback.onScanFailed(errorCode);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$ScanResultWrapper.class */
    static class ScanResultWrapper {
        private final ScanResult mScanResult;

        public ScanResultWrapper(ScanResult scanResult) {
            this.mScanResult = scanResult;
        }

        public BluetoothDeviceWrapper getDevice() {
            return new BluetoothDeviceWrapper(this.mScanResult.getDevice());
        }

        public int getRssi() {
            return this.mScanResult.getRssi();
        }

        public List<ParcelUuid> getScanRecord_getServiceUuids() {
            return this.mScanResult.getScanRecord().getServiceUuids();
        }

        public Map<ParcelUuid, byte[]> getScanRecord_getServiceData() {
            return this.mScanResult.getScanRecord().getServiceData();
        }

        public SparseArray<byte[]> getScanRecord_getManufacturerSpecificData() {
            return this.mScanResult.getScanRecord().getManufacturerSpecificData();
        }

        public int getScanRecord_getTxPowerLevel() {
            return this.mScanResult.getScanRecord().getTxPowerLevel();
        }

        public String getScanRecord_getDeviceName() {
            return this.mScanResult.getScanRecord().getDeviceName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothDeviceWrapper.class */
    public static class BluetoothDeviceWrapper {
        private final BluetoothDevice mDevice;
        private final HashMap<BluetoothGattCharacteristic, BluetoothGattCharacteristicWrapper> mCharacteristicsToWrappers = new HashMap<>();
        private final HashMap<BluetoothGattDescriptor, BluetoothGattDescriptorWrapper> mDescriptorsToWrappers = new HashMap<>();

        public BluetoothDeviceWrapper(BluetoothDevice device) {
            this.mDevice = device;
        }

        public BluetoothGattWrapper connectGatt(Context context, boolean autoConnect, BluetoothGattCallbackWrapper callback, int transport) {
            return new BluetoothGattWrapper(this.mDevice.connectGatt(context, autoConnect, new ForwardBluetoothGattCallbackToWrapper(callback, this), transport), this);
        }

        public String getAddress() {
            return this.mDevice.getAddress();
        }

        public int getBluetoothClass_getDeviceClass() {
            if (this.mDevice == null || this.mDevice.getBluetoothClass() == null) {
                return Wrappers.DEVICE_CLASS_UNSPECIFIED;
            }
            return this.mDevice.getBluetoothClass().getDeviceClass();
        }

        public int getBondState() {
            return this.mDevice.getBondState();
        }

        public String getName() {
            return this.mDevice.getName();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothGattWrapper.class */
    static class BluetoothGattWrapper {
        private final BluetoothGatt mGatt;
        private final BluetoothDeviceWrapper mDeviceWrapper;

        BluetoothGattWrapper(BluetoothGatt gatt, BluetoothDeviceWrapper deviceWrapper) {
            this.mGatt = gatt;
            this.mDeviceWrapper = deviceWrapper;
        }

        public void disconnect() {
            this.mGatt.disconnect();
        }

        public void close() {
            this.mGatt.close();
        }

        public void discoverServices() {
            this.mGatt.discoverServices();
        }

        public List<BluetoothGattServiceWrapper> getServices() {
            List<BluetoothGattService> services = this.mGatt.getServices();
            ArrayList<BluetoothGattServiceWrapper> servicesWrapped = new ArrayList<>(services.size());
            for (BluetoothGattService service : services) {
                servicesWrapped.add(new BluetoothGattServiceWrapper(service, this.mDeviceWrapper));
            }
            return servicesWrapped;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean readCharacteristic(BluetoothGattCharacteristicWrapper characteristic) {
            return this.mGatt.readCharacteristic(characteristic.mCharacteristic);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean setCharacteristicNotification(BluetoothGattCharacteristicWrapper characteristic, boolean enable) {
            return this.mGatt.setCharacteristicNotification(characteristic.mCharacteristic, enable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean writeCharacteristic(BluetoothGattCharacteristicWrapper characteristic) {
            return this.mGatt.writeCharacteristic(characteristic.mCharacteristic);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean readDescriptor(BluetoothGattDescriptorWrapper descriptor) {
            return this.mGatt.readDescriptor(descriptor.mDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean writeDescriptor(BluetoothGattDescriptorWrapper descriptor) {
            return this.mGatt.writeDescriptor(descriptor.mDescriptor);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$ForwardBluetoothGattCallbackToWrapper.class */
    static class ForwardBluetoothGattCallbackToWrapper extends BluetoothGattCallback {
        final BluetoothGattCallbackWrapper mWrapperCallback;
        final BluetoothDeviceWrapper mDeviceWrapper;

        ForwardBluetoothGattCallbackToWrapper(BluetoothGattCallbackWrapper wrapperCallback, BluetoothDeviceWrapper deviceWrapper) {
            this.mWrapperCallback = wrapperCallback;
            this.mDeviceWrapper = deviceWrapper;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            Log.i(Wrappers.TAG, "wrapper onCharacteristicChanged.", new Object[0]);
            this.mWrapperCallback.onCharacteristicChanged((BluetoothGattCharacteristicWrapper) this.mDeviceWrapper.mCharacteristicsToWrappers.get(characteristic));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            this.mWrapperCallback.onCharacteristicRead((BluetoothGattCharacteristicWrapper) this.mDeviceWrapper.mCharacteristicsToWrappers.get(characteristic), status);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            this.mWrapperCallback.onCharacteristicWrite((BluetoothGattCharacteristicWrapper) this.mDeviceWrapper.mCharacteristicsToWrappers.get(characteristic), status);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            this.mWrapperCallback.onDescriptorRead((BluetoothGattDescriptorWrapper) this.mDeviceWrapper.mDescriptorsToWrappers.get(descriptor), status);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            this.mWrapperCallback.onDescriptorWrite((BluetoothGattDescriptorWrapper) this.mDeviceWrapper.mDescriptorsToWrappers.get(descriptor), status);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            this.mWrapperCallback.onConnectionStateChange(status, newState);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            this.mWrapperCallback.onServicesDiscovered(status);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothGattServiceWrapper.class */
    public static class BluetoothGattServiceWrapper {
        private final BluetoothGattService mService;
        private final BluetoothDeviceWrapper mDeviceWrapper;

        public BluetoothGattServiceWrapper(BluetoothGattService service, BluetoothDeviceWrapper deviceWrapper) {
            this.mService = service;
            this.mDeviceWrapper = deviceWrapper;
        }

        public List<BluetoothGattCharacteristicWrapper> getCharacteristics() {
            List<BluetoothGattCharacteristic> characteristics = this.mService.getCharacteristics();
            ArrayList<BluetoothGattCharacteristicWrapper> characteristicsWrapped = new ArrayList<>(characteristics.size());
            for (BluetoothGattCharacteristic characteristic : characteristics) {
                BluetoothGattCharacteristicWrapper characteristicWrapper = (BluetoothGattCharacteristicWrapper) this.mDeviceWrapper.mCharacteristicsToWrappers.get(characteristic);
                if (characteristicWrapper == null) {
                    characteristicWrapper = new BluetoothGattCharacteristicWrapper(characteristic, this.mDeviceWrapper);
                    this.mDeviceWrapper.mCharacteristicsToWrappers.put(characteristic, characteristicWrapper);
                }
                characteristicsWrapped.add(characteristicWrapper);
            }
            return characteristicsWrapped;
        }

        public int getInstanceId() {
            return this.mService.getInstanceId();
        }

        public UUID getUuid() {
            return this.mService.getUuid();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothGattCharacteristicWrapper.class */
    static class BluetoothGattCharacteristicWrapper {
        final BluetoothGattCharacteristic mCharacteristic;
        final BluetoothDeviceWrapper mDeviceWrapper;

        public BluetoothGattCharacteristicWrapper(BluetoothGattCharacteristic characteristic, BluetoothDeviceWrapper deviceWrapper) {
            this.mCharacteristic = characteristic;
            this.mDeviceWrapper = deviceWrapper;
        }

        public List<BluetoothGattDescriptorWrapper> getDescriptors() {
            List<BluetoothGattDescriptor> descriptors = this.mCharacteristic.getDescriptors();
            ArrayList<BluetoothGattDescriptorWrapper> descriptorsWrapped = new ArrayList<>(descriptors.size());
            for (BluetoothGattDescriptor descriptor : descriptors) {
                BluetoothGattDescriptorWrapper descriptorWrapper = (BluetoothGattDescriptorWrapper) this.mDeviceWrapper.mDescriptorsToWrappers.get(descriptor);
                if (descriptorWrapper == null) {
                    descriptorWrapper = new BluetoothGattDescriptorWrapper(descriptor, this.mDeviceWrapper);
                    this.mDeviceWrapper.mDescriptorsToWrappers.put(descriptor, descriptorWrapper);
                }
                descriptorsWrapped.add(descriptorWrapper);
            }
            return descriptorsWrapped;
        }

        public int getInstanceId() {
            return this.mCharacteristic.getInstanceId();
        }

        public int getProperties() {
            return this.mCharacteristic.getProperties();
        }

        public UUID getUuid() {
            return this.mCharacteristic.getUuid();
        }

        public byte[] getValue() {
            return this.mCharacteristic.getValue();
        }

        public boolean setValue(byte[] value) {
            return this.mCharacteristic.setValue(value);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/bluetooth/Wrappers$BluetoothGattDescriptorWrapper.class */
    static class BluetoothGattDescriptorWrapper {
        private final BluetoothGattDescriptor mDescriptor;
        final BluetoothDeviceWrapper mDeviceWrapper;

        public BluetoothGattDescriptorWrapper(BluetoothGattDescriptor descriptor, BluetoothDeviceWrapper deviceWrapper) {
            this.mDescriptor = descriptor;
            this.mDeviceWrapper = deviceWrapper;
        }

        public BluetoothGattCharacteristicWrapper getCharacteristic() {
            return (BluetoothGattCharacteristicWrapper) this.mDeviceWrapper.mCharacteristicsToWrappers.get(this.mDescriptor.getCharacteristic());
        }

        public UUID getUuid() {
            return this.mDescriptor.getUuid();
        }

        public byte[] getValue() {
            return this.mDescriptor.getValue();
        }

        public boolean setValue(byte[] value) {
            return this.mDescriptor.setValue(value);
        }
    }
}
