package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import android.media.midi.MidiOutputPort;
import android.media.midi.MidiReceiver;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("midi")
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/midi/MidiInputPortAndroid.class */
class MidiInputPortAndroid {
    private MidiOutputPort mPort;
    private long mNativeReceiverPointer;
    private final MidiDevice mDevice;
    private final int mIndex;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnData(long j, byte[] bArr, int i, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public MidiInputPortAndroid(MidiDevice device, int index) {
        this.mDevice = device;
        this.mIndex = index;
    }

    @CalledByNative
    boolean open(long nativeReceiverPointer) {
        if (this.mPort != null) {
            return true;
        }
        this.mPort = this.mDevice.openOutputPort(this.mIndex);
        if (this.mPort == null) {
            return false;
        }
        this.mNativeReceiverPointer = nativeReceiverPointer;
        this.mPort.connect(new MidiReceiver() { // from class: org.chromium.midi.MidiInputPortAndroid.1
            @Override // android.media.midi.MidiReceiver
            public void onSend(byte[] bs, int offset, int count, long timestamp) {
                synchronized (MidiInputPortAndroid.this) {
                    if (MidiInputPortAndroid.this.mPort == null) {
                        return;
                    }
                    MidiInputPortAndroid.nativeOnData(MidiInputPortAndroid.this.mNativeReceiverPointer, bs, offset, count, timestamp);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CalledByNative
    public synchronized void close() {
        if (this.mPort == null) {
            return;
        }
        try {
            this.mPort.close();
        } catch (IOException e) {
        }
        this.mNativeReceiverPointer = 0L;
        this.mPort = null;
    }
}
