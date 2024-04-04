package org.chromium.midi;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.os.Handler;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("midi")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/midi/UsbMidiDeviceAndroid.class */
class UsbMidiDeviceAndroid {
    private final UsbDeviceConnection mConnection;
    private final SparseArray<UsbEndpoint> mEndpointMap = new SparseArray<>();
    private final Map<UsbEndpoint, UsbRequest> mRequestMap = new HashMap();
    private final Handler mHandler = new Handler();
    private boolean mIsClosed = false;
    private boolean mHasInputThread = false;
    private long mNativePointer = 0;
    private UsbDevice mUsbDevice;
    static final int MIDI_SUBCLASS = 3;
    static final int REQUEST_GET_DESCRIPTOR = 6;
    static final int STRING_DESCRIPTOR_TYPE = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnData(long j, int i, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public UsbMidiDeviceAndroid(UsbManager manager, UsbDevice device) {
        this.mConnection = manager.openDevice(device);
        this.mUsbDevice = device;
        for (int i = 0; i < device.getInterfaceCount(); i++) {
            UsbInterface iface = device.getInterface(i);
            if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 3) {
                this.mConnection.claimInterface(iface, true);
                for (int j = 0; j < iface.getEndpointCount(); j++) {
                    UsbEndpoint endpoint = iface.getEndpoint(j);
                    if (endpoint.getDirection() == 0) {
                        this.mEndpointMap.put(endpoint.getEndpointNumber(), endpoint);
                    }
                }
            }
        }
        startListen(device);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [org.chromium.midi.UsbMidiDeviceAndroid$1] */
    private void startListen(UsbDevice device) {
        final Map<UsbEndpoint, ByteBuffer> bufferForEndpoints = new HashMap<>();
        for (int i = 0; i < device.getInterfaceCount(); i++) {
            UsbInterface iface = device.getInterface(i);
            if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 3) {
                for (int j = 0; j < iface.getEndpointCount(); j++) {
                    UsbEndpoint endpoint = iface.getEndpoint(j);
                    if (endpoint.getDirection() == 128) {
                        ByteBuffer buffer = ByteBuffer.allocate(endpoint.getMaxPacketSize());
                        UsbRequest request = new UsbRequest();
                        request.initialize(this.mConnection, endpoint);
                        request.queue(buffer, buffer.remaining());
                        bufferForEndpoints.put(endpoint, buffer);
                    }
                }
            }
        }
        if (bufferForEndpoints.isEmpty()) {
            return;
        }
        this.mHasInputThread = true;
        new Thread() { // from class: org.chromium.midi.UsbMidiDeviceAndroid.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (true) {
                    UsbRequest request2 = UsbMidiDeviceAndroid.this.mConnection.requestWait();
                    if (request2 != null) {
                        UsbEndpoint endpoint2 = request2.getEndpoint();
                        if (endpoint2.getDirection() == 128) {
                            ByteBuffer buffer2 = (ByteBuffer) bufferForEndpoints.get(endpoint2);
                            int length = UsbMidiDeviceAndroid.getInputDataLength(buffer2);
                            if (length > 0) {
                                buffer2.rewind();
                                byte[] bs = new byte[length];
                                buffer2.get(bs, 0, length);
                                UsbMidiDeviceAndroid.this.postOnDataEvent(endpoint2.getEndpointNumber(), bs);
                            }
                            buffer2.rewind();
                            request2.queue(buffer2, buffer2.capacity());
                        }
                    } else {
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnDataEvent(final int endpointNumber, final byte[] bs) {
        this.mHandler.post(new Runnable() { // from class: org.chromium.midi.UsbMidiDeviceAndroid.2
            @Override // java.lang.Runnable
            public void run() {
                if (!UsbMidiDeviceAndroid.this.mIsClosed) {
                    UsbMidiDeviceAndroid.nativeOnData(UsbMidiDeviceAndroid.this.mNativePointer, endpointNumber, bs);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UsbDevice getUsbDevice() {
        return this.mUsbDevice;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.mIsClosed;
    }

    @CalledByNative
    void registerSelf(long nativePointer) {
        this.mNativePointer = nativePointer;
    }

    @CalledByNative
    void send(int endpointNumber, byte[] bs) {
        UsbEndpoint endpoint;
        if (this.mIsClosed || (endpoint = this.mEndpointMap.get(endpointNumber)) == null) {
            return;
        }
        if (shouldUseBulkTransfer()) {
            this.mConnection.bulkTransfer(endpoint, bs, bs.length, 100);
            return;
        }
        UsbRequest request = this.mRequestMap.get(endpoint);
        if (request == null) {
            request = new UsbRequest();
            request.initialize(this.mConnection, endpoint);
            this.mRequestMap.put(endpoint, request);
        }
        request.queue(ByteBuffer.wrap(bs), bs.length);
    }

    private boolean shouldUseBulkTransfer() {
        return this.mHasInputThread;
    }

    @CalledByNative
    byte[] getDescriptors() {
        if (this.mConnection == null) {
            return new byte[0];
        }
        return this.mConnection.getRawDescriptors();
    }

    @CalledByNative
    byte[] getStringDescriptor(int index) {
        if (this.mConnection == null) {
            return new byte[0];
        }
        byte[] buffer = new byte[255];
        int value = 768 | index;
        int read = this.mConnection.controlTransfer(128, 6, value, 0, buffer, buffer.length, 0);
        if (read < 0) {
            return new byte[0];
        }
        return Arrays.copyOf(buffer, read);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CalledByNative
    public void close() {
        this.mEndpointMap.clear();
        for (UsbRequest request : this.mRequestMap.values()) {
            request.close();
        }
        this.mRequestMap.clear();
        this.mConnection.close();
        this.mNativePointer = 0L;
        this.mIsClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getInputDataLength(ByteBuffer buffer) {
        int position = buffer.position();
        for (int i = 0; i < position; i += 4) {
            if (buffer.get(i) == 0) {
                return i;
            }
        }
        return position;
    }
}
