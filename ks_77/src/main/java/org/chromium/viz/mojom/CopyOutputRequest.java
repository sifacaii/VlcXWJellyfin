package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Vector2d;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CopyOutputRequest.class */
public final class CopyOutputRequest extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int resultFormat;
    public Vector2d scaleFrom;
    public Vector2d scaleTo;
    public UnguessableToken source;
    public Rect area;
    public Rect resultSelection;
    public CopyOutputResultSender resultSender;

    private CopyOutputRequest(int version) {
        super(64, version);
    }

    public CopyOutputRequest() {
        this(0);
    }

    public static CopyOutputRequest deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CopyOutputRequest deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CopyOutputRequest decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CopyOutputRequest result = new CopyOutputRequest(elementsOrVersion);
            result.resultFormat = decoder0.readInt(8);
            CopyOutputResultFormat.validate(result.resultFormat);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.scaleFrom = Vector2d.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.scaleTo = Vector2d.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, true);
            result.source = UnguessableToken.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, true);
            result.area = Rect.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(48, true);
            result.resultSelection = Rect.decode(decoder15);
            result.resultSender = (CopyOutputResultSender) decoder0.readServiceInterface(56, false, CopyOutputResultSender.MANAGER);
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
        encoder0.encode(this.resultFormat, 8);
        encoder0.encode((Struct) this.scaleFrom, 16, false);
        encoder0.encode((Struct) this.scaleTo, 24, false);
        encoder0.encode((Struct) this.source, 32, true);
        encoder0.encode((Struct) this.area, 40, true);
        encoder0.encode((Struct) this.resultSelection, 48, true);
        encoder0.encode(this.resultSender, 56, false, CopyOutputResultSender.MANAGER);
    }
}
