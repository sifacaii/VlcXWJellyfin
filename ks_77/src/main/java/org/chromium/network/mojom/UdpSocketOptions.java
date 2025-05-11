package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketOptions.class */
public final class UdpSocketOptions extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean allowAddressReuse;
    public boolean allowBroadcast;
    public boolean allowAddressSharingForMulticast;
    public int multicastInterface;
    public int multicastTimeToLive;
    public boolean multicastLoopbackMode;
    public int sendBufferSize;
    public int receiveBufferSize;

    private UdpSocketOptions(int version) {
        super(32, version);
        this.allowAddressReuse = false;
        this.allowBroadcast = false;
        this.allowAddressSharingForMulticast = false;
        this.multicastInterface = 0;
        this.multicastTimeToLive = 1;
        this.multicastLoopbackMode = true;
        this.sendBufferSize = 0;
        this.receiveBufferSize = 0;
    }

    public UdpSocketOptions() {
        this(0);
    }

    public static UdpSocketOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UdpSocketOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UdpSocketOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UdpSocketOptions result = new UdpSocketOptions(elementsOrVersion);
            result.allowAddressReuse = decoder0.readBoolean(8, 0);
            result.allowBroadcast = decoder0.readBoolean(8, 1);
            result.allowAddressSharingForMulticast = decoder0.readBoolean(8, 2);
            result.multicastLoopbackMode = decoder0.readBoolean(8, 3);
            result.multicastInterface = decoder0.readInt(12);
            result.multicastTimeToLive = decoder0.readInt(16);
            result.sendBufferSize = decoder0.readInt(20);
            result.receiveBufferSize = decoder0.readInt(24);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.allowAddressReuse, 8, 0);
        encoder0.encode(this.allowBroadcast, 8, 1);
        encoder0.encode(this.allowAddressSharingForMulticast, 8, 2);
        encoder0.encode(this.multicastLoopbackMode, 8, 3);
        encoder0.encode(this.multicastInterface, 12);
        encoder0.encode(this.multicastTimeToLive, 16);
        encoder0.encode(this.sendBufferSize, 20);
        encoder0.encode(this.receiveBufferSize, 24);
    }
}
