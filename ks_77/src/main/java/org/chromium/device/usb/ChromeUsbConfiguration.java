package org.chromium.device.usb;

import android.annotation.TargetApi;
import android.hardware.usb.UsbConfiguration;
import android.hardware.usb.UsbInterface;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
@TargetApi(21)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/usb/ChromeUsbConfiguration.class */
final class ChromeUsbConfiguration {
    private static final String TAG = "Usb";
    final UsbConfiguration mConfiguration;

    private ChromeUsbConfiguration(UsbConfiguration configuration) {
        this.mConfiguration = configuration;
        Log.v(TAG, "ChromeUsbConfiguration created.");
    }

    @CalledByNative
    private static ChromeUsbConfiguration create(UsbConfiguration configuration) {
        return new ChromeUsbConfiguration(configuration);
    }

    @CalledByNative
    private int getConfigurationValue() {
        return this.mConfiguration.getId();
    }

    @CalledByNative
    private boolean isSelfPowered() {
        return this.mConfiguration.isSelfPowered();
    }

    @CalledByNative
    private boolean isRemoteWakeup() {
        return this.mConfiguration.isRemoteWakeup();
    }

    @CalledByNative
    private int getMaxPower() {
        return this.mConfiguration.getMaxPower();
    }

    @CalledByNative
    private UsbInterface[] getInterfaces() {
        int count = this.mConfiguration.getInterfaceCount();
        UsbInterface[] interfaces = new UsbInterface[count];
        for (int i = 0; i < count; i++) {
            interfaces[i] = this.mConfiguration.getInterface(i);
        }
        return interfaces;
    }
}
