package org.chromium.device.usb;

import android.annotation.TargetApi;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/usb/ChromeUsbDevice.class */
final class ChromeUsbDevice {
    private static final String TAG = "Usb";
    final UsbDevice mDevice;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ChromeUsbDevice.class.desiredAssertionStatus();
    }

    private ChromeUsbDevice(UsbDevice device) {
        this.mDevice = device;
        Log.v(TAG, "ChromeUsbDevice created.");
    }

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    @CalledByNative
    private static ChromeUsbDevice create(UsbDevice device) {
        return new ChromeUsbDevice(device);
    }

    @CalledByNative
    private int getDeviceId() {
        return this.mDevice.getDeviceId();
    }

    @CalledByNative
    private int getDeviceClass() {
        return this.mDevice.getDeviceClass();
    }

    @CalledByNative
    private int getDeviceSubclass() {
        return this.mDevice.getDeviceSubclass();
    }

    @CalledByNative
    private int getDeviceProtocol() {
        return this.mDevice.getDeviceProtocol();
    }

    @CalledByNative
    private int getVendorId() {
        return this.mDevice.getVendorId();
    }

    @CalledByNative
    private int getProductId() {
        return this.mDevice.getProductId();
    }

    @TargetApi(23)
    @CalledByNative
    private int getDeviceVersion() {
        String[] parts = this.mDevice.getVersion().split("\\.");
        if ($assertionsDisabled || parts.length == 2) {
            return (Integer.parseInt(parts[0]) << 8) | Integer.parseInt(parts[1]);
        }
        throw new AssertionError();
    }

    @TargetApi(21)
    @CalledByNative
    private String getManufacturerName() {
        return this.mDevice.getManufacturerName();
    }

    @TargetApi(21)
    @CalledByNative
    private String getProductName() {
        return this.mDevice.getProductName();
    }

    @TargetApi(21)
    @CalledByNative
    private String getSerialNumber() {
        return this.mDevice.getSerialNumber();
    }

    @TargetApi(21)
    @CalledByNative
    private UsbConfiguration[] getConfigurations() {
        int count = this.mDevice.getConfigurationCount();
        UsbConfiguration[] configurations = new UsbConfiguration[count];
        for (int i = 0; i < count; i++) {
            configurations[i] = this.mDevice.getConfiguration(i);
        }
        return configurations;
    }

    @CalledByNative
    private UsbInterface[] getInterfaces() {
        int count = this.mDevice.getInterfaceCount();
        UsbInterface[] interfaces = new UsbInterface[count];
        for (int i = 0; i < count; i++) {
            interfaces[i] = this.mDevice.getInterface(i);
        }
        return interfaces;
    }
}
