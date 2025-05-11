package org.chromium.device.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import java.util.HashMap;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/usb/ChromeUsbService.class */
final class ChromeUsbService {
    private static final String TAG = "Usb";
    private static final String ACTION_USB_PERMISSION = "org.chromium.device.ACTION_USB_PERMISSION";
    long mUsbServiceAndroid;
    UsbManager mUsbManager = (UsbManager) ContextUtils.getApplicationContext().getSystemService("usb");
    BroadcastReceiver mUsbDeviceReceiver;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDeviceAttached(long j, UsbDevice usbDevice);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDeviceDetached(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDevicePermissionRequestComplete(long j, int i, boolean z);

    private ChromeUsbService(long usbServiceAndroid) {
        this.mUsbServiceAndroid = usbServiceAndroid;
        registerForUsbDeviceIntentBroadcast();
        Log.v(TAG, "ChromeUsbService created.");
    }

    @CalledByNative
    private static ChromeUsbService create(long usbServiceAndroid) {
        return new ChromeUsbService(usbServiceAndroid);
    }

    @CalledByNative
    private Object[] getDevices() {
        HashMap<String, UsbDevice> deviceList = this.mUsbManager.getDeviceList();
        return deviceList.values().toArray();
    }

    @CalledByNative
    private UsbDeviceConnection openDevice(ChromeUsbDevice wrapper) {
        UsbDevice device = wrapper.getDevice();
        return this.mUsbManager.openDevice(device);
    }

    @CalledByNative
    private boolean hasDevicePermission(ChromeUsbDevice wrapper) {
        UsbDevice device = wrapper.getDevice();
        return this.mUsbManager.hasPermission(device);
    }

    @CalledByNative
    private void requestDevicePermission(ChromeUsbDevice wrapper) {
        UsbDevice device = wrapper.getDevice();
        if (this.mUsbManager.hasPermission(device)) {
            nativeDevicePermissionRequestComplete(this.mUsbServiceAndroid, device.getDeviceId(), true);
            return;
        }
        PendingIntent intent = PendingIntent.getBroadcast(ContextUtils.getApplicationContext(), 0, new Intent(ACTION_USB_PERMISSION), 0);
        this.mUsbManager.requestPermission(wrapper.getDevice(), intent);
    }

    @CalledByNative
    private void close() {
        unregisterForUsbDeviceIntentBroadcast();
    }

    private void registerForUsbDeviceIntentBroadcast() {
        this.mUsbDeviceReceiver = new BroadcastReceiver() { // from class: org.chromium.device.usb.ChromeUsbService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                UsbDevice device = (UsbDevice) intent.getParcelableExtra(ConstantsConstants.SERVICE_NAME);
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
                    ChromeUsbService.this.nativeDeviceAttached(ChromeUsbService.this.mUsbServiceAndroid, device);
                } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction())) {
                    ChromeUsbService.this.nativeDeviceDetached(ChromeUsbService.this.mUsbServiceAndroid, device.getDeviceId());
                } else if (ChromeUsbService.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                    ChromeUsbService.this.nativeDevicePermissionRequestComplete(ChromeUsbService.this.mUsbServiceAndroid, device.getDeviceId(), intent.getBooleanExtra("permission", false));
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        filter.addAction(ACTION_USB_PERMISSION);
        ContextUtils.getApplicationContext().registerReceiver(this.mUsbDeviceReceiver, filter);
    }

    private void unregisterForUsbDeviceIntentBroadcast() {
        ContextUtils.getApplicationContext().unregisterReceiver(this.mUsbDeviceReceiver);
        this.mUsbDeviceReceiver = null;
    }
}
