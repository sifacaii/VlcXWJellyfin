package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkConditions.class */
public final class NetworkConditions extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean offline;
    public TimeDelta latency;
    public double downloadThroughput;
    public double uploadThroughput;

    private NetworkConditions(int version) {
        super(40, version);
    }

    public NetworkConditions() {
        this(0);
    }

    public static NetworkConditions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NetworkConditions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkConditions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NetworkConditions result = new NetworkConditions(elementsOrVersion);
            result.offline = decoder0.readBoolean(8, 0);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.latency = TimeDelta.decode(decoder1);
            result.downloadThroughput = decoder0.readDouble(24);
            result.uploadThroughput = decoder0.readDouble(32);
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
        encoder0.encode(this.offline, 8, 0);
        encoder0.encode((Struct) this.latency, 16, false);
        encoder0.encode(this.downloadThroughput, 24);
        encoder0.encode(this.uploadThroughput, 32);
    }
}
