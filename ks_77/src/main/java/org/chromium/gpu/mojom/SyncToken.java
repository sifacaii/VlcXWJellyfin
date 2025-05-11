package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/SyncToken.class */
public final class SyncToken extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean verifiedFlush;
    public int namespaceId;
    public long commandBufferId;
    public long releaseCount;

    private SyncToken(int version) {
        super(32, version);
    }

    public SyncToken() {
        this(0);
    }

    public static SyncToken deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SyncToken deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SyncToken decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SyncToken result = new SyncToken(elementsOrVersion);
            result.verifiedFlush = decoder0.readBoolean(8, 0);
            result.namespaceId = decoder0.readInt(12);
            CommandBufferNamespace.validate(result.namespaceId);
            result.commandBufferId = decoder0.readLong(16);
            result.releaseCount = decoder0.readLong(24);
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
        encoder0.encode(this.verifiedFlush, 8, 0);
        encoder0.encode(this.namespaceId, 12);
        encoder0.encode(this.commandBufferId, 16);
        encoder0.encode(this.releaseCount, 24);
    }
}
