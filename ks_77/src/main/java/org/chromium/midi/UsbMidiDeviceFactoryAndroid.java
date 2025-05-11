package org.chromium.midi;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace("midi")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/midi/UsbMidiDeviceFactoryAndroid.class */
class UsbMidiDeviceFactoryAndroid {
    private Set<UsbDevice> mRequestedDevices;
    private boolean mIsEnumeratingDevices;
    private long mNativePointer;
    private static final String ACTION_USB_PERMISSION = "org.chromium.midi.USB_PERMISSION";
    static final /* synthetic */ boolean $assertionsDisabled;
    private final List<UsbMidiDeviceAndroid> mDevices = new ArrayList();
    private UsbManager mUsbManager = (UsbManager) ContextUtils.getApplicationContext().getSystemService("usb");
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: org.chromium.midi.UsbMidiDeviceFactoryAndroid.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Parcelable extra = intent.getParcelableExtra(ConstantsConstants.SERVICE_NAME);
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
                UsbMidiDeviceFactoryAndroid.this.requestDevicePermissionIfNecessary((UsbDevice) extra);
            }
            if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction())) {
                UsbMidiDeviceFactoryAndroid.this.onUsbDeviceDetached((UsbDevice) extra);
            }
            if (UsbMidiDeviceFactoryAndroid.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                UsbMidiDeviceFactoryAndroid.this.onUsbDevicePermissionRequestDone(context, intent);
            }
        }
    };

    private static native void nativeOnUsbMidiDeviceRequestDone(long j, Object[] objArr);

    private static native void nativeOnUsbMidiDeviceAttached(long j, Object obj);

    private static native void nativeOnUsbMidiDeviceDetached(long j, int i);

    static {
        $assertionsDisabled = !UsbMidiDeviceFactoryAndroid.class.desiredAssertionStatus();
    }

    UsbMidiDeviceFactoryAndroid(long nativePointer) {
        this.mNativePointer = nativePointer;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        filter.addAction(ACTION_USB_PERMISSION);
        ContextUtils.getApplicationContext().registerReceiver(this.mReceiver, filter);
        this.mRequestedDevices = new HashSet();
    }

    @CalledByNative
    static UsbMidiDeviceFactoryAndroid create(long nativePointer) {
        return new UsbMidiDeviceFactoryAndroid(nativePointer);
    }

    @CalledByNative
    boolean enumerateDevices() {
        if ($assertionsDisabled || !this.mIsEnumeratingDevices) {
            this.mIsEnumeratingDevices = true;
            Map<String, UsbDevice> devices = this.mUsbManager.getDeviceList();
            if (devices.isEmpty()) {
                this.mIsEnumeratingDevices = false;
                return false;
            }
            for (UsbDevice device : devices.values()) {
                requestDevicePermissionIfNecessary(device);
            }
            return !this.mRequestedDevices.isEmpty();
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestDevicePermissionIfNecessary(UsbDevice device) {
        for (UsbDevice d : this.mRequestedDevices) {
            if (d.getDeviceId() == device.getDeviceId()) {
                return;
            }
        }
        for (int i = 0; i < device.getInterfaceCount(); i++) {
            UsbInterface iface = device.getInterface(i);
            if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 3) {
                this.mUsbManager.requestPermission(device, PendingIntent.getBroadcast(ContextUtils.getApplicationContext(), 0, new Intent(ACTION_USB_PERMISSION), 0));
                this.mRequestedDevices.add(device);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUsbDeviceDetached(UsbDevice device) {
        Iterator<UsbDevice> it = this.mRequestedDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UsbDevice usbDevice = it.next();
            if (usbDevice.getDeviceId() == device.getDeviceId()) {
                this.mRequestedDevices.remove(usbDevice);
                break;
            }
        }
        for (int i = 0; i < this.mDevices.size(); i++) {
            UsbMidiDeviceAndroid midiDevice = this.mDevices.get(i);
            if (!midiDevice.isClosed() && midiDevice.getUsbDevice().getDeviceId() == device.getDeviceId()) {
                midiDevice.close();
                if (this.mIsEnumeratingDevices) {
                    this.mDevices.remove(i);
                    return;
                } else if (this.mNativePointer != 0) {
                    nativeOnUsbMidiDeviceDetached(this.mNativePointer, i);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUsbDevicePermissionRequestDone(Context context, Intent intent) {
        UsbDevice device = (UsbDevice) intent.getParcelableExtra(ConstantsConstants.SERVICE_NAME);
        UsbMidiDeviceAndroid midiDevice = null;
        if (this.mRequestedDevices.contains(device)) {
            this.mRequestedDevices.remove(device);
            if (!intent.getBooleanExtra("permission", false)) {
                device = null;
            }
        } else {
            device = null;
        }
        if (device != null) {
            Iterator<UsbMidiDeviceAndroid> it = this.mDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UsbMidiDeviceAndroid registered = it.next();
                if (!registered.isClosed() && registered.getUsbDevice().getDeviceId() == device.getDeviceId()) {
                    device = null;
                    break;
                }
            }
        }
        if (device != null) {
            midiDevice = new UsbMidiDeviceAndroid(this.mUsbManager, device);
            this.mDevices.add(midiDevice);
        }
        if (!this.mRequestedDevices.isEmpty() || this.mNativePointer == 0) {
            return;
        }
        if (this.mIsEnumeratingDevices) {
            nativeOnUsbMidiDeviceRequestDone(this.mNativePointer, this.mDevices.toArray());
            this.mIsEnumeratingDevices = false;
        } else if (midiDevice != null) {
            nativeOnUsbMidiDeviceAttached(this.mNativePointer, midiDevice);
        }
    }

    @CalledByNative
    void close() {
        this.mNativePointer = 0L;
        ContextUtils.getApplicationContext().unregisterReceiver(this.mReceiver);
    }
}
