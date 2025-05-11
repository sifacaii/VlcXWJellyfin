package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/InsetsF.class */
public final class InsetsF extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float top;
    public float left;
    public float bottom;
    public float right;

    private InsetsF(int version) {
        super(24, version);
    }

    public InsetsF() {
        this(0);
    }

    public static InsetsF deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static InsetsF deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static InsetsF decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            InsetsF result = new InsetsF(elementsOrVersion);
            result.top = decoder0.readFloat(8);
            result.left = decoder0.readFloat(12);
            result.bottom = decoder0.readFloat(16);
            result.right = decoder0.readFloat(20);
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
        encoder0.encode(this.top, 8);
        encoder0.encode(this.left, 12);
        encoder0.encode(this.bottom, 16);
        encoder0.encode(this.right, 20);
    }
}
