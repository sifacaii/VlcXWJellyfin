package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import android.media.midi.MidiManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("midi")
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/midi/MidiManagerAndroid.class */
class MidiManagerAndroid {
    private boolean mIsInitialized;
    private final List<MidiDeviceAndroid> mDevices = new ArrayList();
    private final Set<MidiDeviceInfo> mPendingDevices = new HashSet();
    private final MidiManager mManager;
    private final Handler mHandler;
    private final long mNativeManagerPointer;
    private boolean mStopped;
    static final /* synthetic */ boolean $assertionsDisabled;

    static native void nativeOnInitialized(long j, MidiDeviceAndroid[] midiDeviceAndroidArr);

    static native void nativeOnInitializationFailed(long j);

    static native void nativeOnAttached(long j, MidiDeviceAndroid midiDeviceAndroid);

    static native void nativeOnDetached(long j, MidiDeviceAndroid midiDeviceAndroid);

    static {
        $assertionsDisabled = !MidiManagerAndroid.class.desiredAssertionStatus();
    }

    @CalledByNative
    static boolean hasSystemFeatureMidi() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.software.midi");
    }

    @CalledByNative
    static MidiManagerAndroid create(long nativeManagerPointer) {
        return new MidiManagerAndroid(nativeManagerPointer);
    }

    private MidiManagerAndroid(long nativeManagerPointer) {
        if (!$assertionsDisabled && ThreadUtils.runningOnUiThread()) {
            throw new AssertionError();
        }
        this.mManager = (MidiManager) ContextUtils.getApplicationContext().getSystemService("midi");
        this.mHandler = new Handler(ThreadUtils.getUiThreadLooper());
        this.mNativeManagerPointer = nativeManagerPointer;
    }

    @CalledByNative
    void initialize() {
        if (this.mManager == null) {
            this.mHandler.post(new Runnable() { // from class: org.chromium.midi.MidiManagerAndroid.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (MidiManagerAndroid.this) {
                        if (MidiManagerAndroid.this.mStopped) {
                            return;
                        }
                        MidiManagerAndroid.nativeOnInitializationFailed(MidiManagerAndroid.this.mNativeManagerPointer);
                    }
                }
            });
            return;
        }
        this.mManager.registerDeviceCallback(new MidiManager.DeviceCallback() { // from class: org.chromium.midi.MidiManagerAndroid.2
            @Override // android.media.midi.MidiManager.DeviceCallback
            public void onDeviceAdded(MidiDeviceInfo device) {
                MidiManagerAndroid.this.onDeviceAdded(device);
            }

            @Override // android.media.midi.MidiManager.DeviceCallback
            public void onDeviceRemoved(MidiDeviceInfo device) {
                MidiManagerAndroid.this.onDeviceRemoved(device);
            }
        }, this.mHandler);
        MidiDeviceInfo[] infos = this.mManager.getDevices();
        for (MidiDeviceInfo info : infos) {
            this.mPendingDevices.add(info);
            openDevice(info);
        }
        this.mHandler.post(new Runnable() { // from class: org.chromium.midi.MidiManagerAndroid.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (MidiManagerAndroid.this) {
                    if (MidiManagerAndroid.this.mStopped) {
                        return;
                    }
                    if (MidiManagerAndroid.this.mPendingDevices.isEmpty() && !MidiManagerAndroid.this.mIsInitialized) {
                        MidiManagerAndroid.nativeOnInitialized(MidiManagerAndroid.this.mNativeManagerPointer, (MidiDeviceAndroid[]) MidiManagerAndroid.this.mDevices.toArray(new MidiDeviceAndroid[0]));
                        MidiManagerAndroid.this.mIsInitialized = true;
                    }
                }
            }
        });
    }

    @CalledByNative
    synchronized void stop() {
        this.mStopped = true;
    }

    private void openDevice(final MidiDeviceInfo info) {
        this.mManager.openDevice(info, new MidiManager.OnDeviceOpenedListener() { // from class: org.chromium.midi.MidiManagerAndroid.4
            @Override // android.media.midi.MidiManager.OnDeviceOpenedListener
            public void onDeviceOpened(MidiDevice device) {
                MidiManagerAndroid.this.onDeviceOpened(device, info);
            }
        }, this.mHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceAdded(MidiDeviceInfo info) {
        if (!this.mIsInitialized) {
            this.mPendingDevices.add(info);
        }
        openDevice(info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onDeviceRemoved(MidiDeviceInfo info) {
        if (this.mStopped) {
            return;
        }
        for (MidiDeviceAndroid device : this.mDevices) {
            if (device.isOpen() && device.getInfo().getId() == info.getId()) {
                device.close();
                nativeOnDetached(this.mNativeManagerPointer, device);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onDeviceOpened(MidiDevice device, MidiDeviceInfo info) {
        if (this.mStopped) {
            return;
        }
        this.mPendingDevices.remove(info);
        if (device != null) {
            MidiDeviceAndroid xdevice = new MidiDeviceAndroid(device);
            this.mDevices.add(xdevice);
            if (this.mIsInitialized) {
                nativeOnAttached(this.mNativeManagerPointer, xdevice);
            }
        }
        if (!this.mIsInitialized && this.mPendingDevices.isEmpty()) {
            nativeOnInitialized(this.mNativeManagerPointer, (MidiDeviceAndroid[]) this.mDevices.toArray(new MidiDeviceAndroid[0]));
            this.mIsInitialized = true;
        }
    }
}
