package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/LocalSurfaceId.class */
public final class LocalSurfaceId extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int parentSequenceNumber;
    public int childSequenceNumber;
    public UnguessableToken embedToken;

    private LocalSurfaceId(int version) {
        super(24, version);
    }

    public LocalSurfaceId() {
        this(0);
    }

    public static LocalSurfaceId deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static LocalSurfaceId deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalSurfaceId decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            LocalSurfaceId result = new LocalSurfaceId(elementsOrVersion);
            result.parentSequenceNumber = decoder0.readInt(8);
            result.childSequenceNumber = decoder0.readInt(12);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.embedToken = UnguessableToken.decode(decoder1);
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
        encoder0.encode(this.parentSequenceNumber, 8);
        encoder0.encode(this.childSequenceNumber, 12);
        encoder0.encode((Struct) this.embedToken, 16, false);
    }
}
