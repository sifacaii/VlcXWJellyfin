package org.chromium.device.usb;

import android.hardware.usb.UsbDeviceConnection;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/usb/ChromeUsbConnection.class */
class ChromeUsbConnection {
    private static final String TAG = "Usb";
    final UsbDeviceConnection mConnection;

    private ChromeUsbConnection(UsbDeviceConnection connection) {
        this.mConnection = connection;
        Log.v(TAG, "ChromeUsbConnection created.");
    }

    @CalledByNative
    private static ChromeUsbConnection create(UsbDeviceConnection connection) {
        return new ChromeUsbConnection(connection);
    }

    @CalledByNative
    private int getFileDescriptor() {
        return this.mConnection.getFileDescriptor();
    }

    @CalledByNative
    private void close() {
        this.mConnection.close();
    }
}
