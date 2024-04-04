package org.chromium.device.usb;

import android.annotation.TargetApi;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/usb/ChromeUsbInterface.class */
final class ChromeUsbInterface {
    private static final String TAG = "Usb";
    final UsbInterface mInterface;

    private ChromeUsbInterface(UsbInterface iface) {
        this.mInterface = iface;
        Log.v(TAG, "ChromeUsbInterface created.");
    }

    @CalledByNative
    private static ChromeUsbInterface create(UsbInterface iface) {
        return new ChromeUsbInterface(iface);
    }

    @CalledByNative
    private int getInterfaceNumber() {
        return this.mInterface.getId();
    }

    @TargetApi(21)
    @CalledByNative
    private int getAlternateSetting() {
        return this.mInterface.getAlternateSetting();
    }

    @CalledByNative
    private int getInterfaceClass() {
        return this.mInterface.getInterfaceClass();
    }

    @CalledByNative
    private int getInterfaceSubclass() {
        return this.mInterface.getInterfaceSubclass();
    }

    @CalledByNative
    private int getInterfaceProtocol() {
        return this.mInterface.getInterfaceProtocol();
    }

    @CalledByNative
    private UsbEndpoint[] getEndpoints() {
        int count = this.mInterface.getEndpointCount();
        UsbEndpoint[] endpoints = new UsbEndpoint[count];
        for (int i = 0; i < count; i++) {
            endpoints[i] = this.mInterface.getEndpoint(i);
        }
        return endpoints;
    }
}
