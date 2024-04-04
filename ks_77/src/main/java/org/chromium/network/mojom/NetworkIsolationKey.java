package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkIsolationKey.class */
public final class NetworkIsolationKey extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Origin topFrameOrigin;
    public Origin frameOrigin;

    private NetworkIsolationKey(int version) {
        super(24, version);
    }

    public NetworkIsolationKey() {
        this(0);
    }

    public static NetworkIsolationKey deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NetworkIsolationKey deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkIsolationKey decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NetworkIsolationKey result = new NetworkIsolationKey(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            result.topFrameOrigin = Origin.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, true);
            result.frameOrigin = Origin.decode(decoder12);
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
        encoder0.encode((Struct) this.topFrameOrigin, 8, true);
        encoder0.encode((Struct) this.frameOrigin, 16, true);
    }
}
