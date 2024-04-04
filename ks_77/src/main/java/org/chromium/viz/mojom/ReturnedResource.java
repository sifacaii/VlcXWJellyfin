package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/ReturnedResource.class */
public final class ReturnedResource extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int id;
    public SyncToken syncToken;
    public int count;
    public boolean lost;

    private ReturnedResource(int version) {
        super(32, version);
    }

    public ReturnedResource() {
        this(0);
    }

    public static ReturnedResource deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ReturnedResource deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ReturnedResource decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ReturnedResource result = new ReturnedResource(elementsOrVersion);
            result.id = decoder0.readInt(8);
            result.count = decoder0.readInt(12);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.syncToken = SyncToken.decode(decoder1);
            result.lost = decoder0.readBoolean(24, 0);
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
        encoder0.encode(this.id, 8);
        encoder0.encode(this.count, 12);
        encoder0.encode((Struct) this.syncToken, 16, false);
        encoder0.encode(this.lost, 24, 0);
    }
}
