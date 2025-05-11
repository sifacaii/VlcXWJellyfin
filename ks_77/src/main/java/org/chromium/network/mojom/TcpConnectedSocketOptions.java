package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocketOptions.class */
public final class TcpConnectedSocketOptions extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int sendBufferSize;
    public int receiveBufferSize;
    public boolean noDelay;

    private TcpConnectedSocketOptions(int version) {
        super(24, version);
        this.sendBufferSize = 0;
        this.receiveBufferSize = 0;
        this.noDelay = true;
    }

    public TcpConnectedSocketOptions() {
        this(0);
    }

    public static TcpConnectedSocketOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TcpConnectedSocketOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TcpConnectedSocketOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TcpConnectedSocketOptions result = new TcpConnectedSocketOptions(elementsOrVersion);
            result.sendBufferSize = decoder0.readInt(8);
            result.receiveBufferSize = decoder0.readInt(12);
            result.noDelay = decoder0.readBoolean(16, 0);
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
        encoder0.encode(this.sendBufferSize, 8);
        encoder0.encode(this.receiveBufferSize, 12);
        encoder0.encode(this.noDelay, 16, 0);
    }
}
