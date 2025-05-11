package org.chromium.midi;

import android.annotation.TargetApi;
import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace("midi")
@TargetApi(23)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/midi/MidiDeviceAndroid.class */
public class MidiDeviceAndroid {
    private final MidiDevice mDevice;
    private final MidiInputPortAndroid[] mInputPorts;
    private boolean mIsOpen = true;
    private final MidiOutputPortAndroid[] mOutputPorts = new MidiOutputPortAndroid[getInfo().getInputPortCount()];

    /* JADX INFO: Access modifiers changed from: package-private */
    public MidiDeviceAndroid(MidiDevice device) {
        this.mDevice = device;
        for (int i = 0; i < this.mOutputPorts.length; i++) {
            this.mOutputPorts[i] = new MidiOutputPortAndroid(device, i);
        }
        this.mInputPorts = new MidiInputPortAndroid[getInfo().getOutputPortCount()];
        for (int i2 = 0; i2 < this.mInputPorts.length; i2++) {
            this.mInputPorts[i2] = new MidiInputPortAndroid(device, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOpen() {
        return this.mIsOpen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        MidiInputPortAndroid[] midiInputPortAndroidArr;
        MidiOutputPortAndroid[] midiOutputPortAndroidArr;
        this.mIsOpen = false;
        for (MidiInputPortAndroid port : this.mInputPorts) {
            port.close();
        }
        for (MidiOutputPortAndroid port2 : this.mOutputPorts) {
            port2.close();
        }
    }

    MidiDevice getDevice() {
        return this.mDevice;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MidiDeviceInfo getInfo() {
        return this.mDevice.getInfo();
    }

    @CalledByNative
    String getManufacturer() {
        return getProperty("manufacturer");
    }

    @CalledByNative
    String getProduct() {
        String product = getProperty("product");
        if (product == null || product.isEmpty()) {
            return getProperty("name");
        }
        return product;
    }

    @CalledByNative
    String getVersion() {
        return getProperty("version");
    }

    @CalledByNative
    MidiInputPortAndroid[] getInputPorts() {
        return this.mInputPorts;
    }

    @CalledByNative
    MidiOutputPortAndroid[] getOutputPorts() {
        return this.mOutputPorts;
    }

    private String getProperty(String name) {
        return this.mDevice.getInfo().getProperties().getString(name);
    }
}
