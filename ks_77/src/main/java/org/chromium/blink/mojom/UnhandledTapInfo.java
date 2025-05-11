package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UnhandledTapInfo.class */
public final class UnhandledTapInfo extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Point tappedPositionInViewport;
    public int fontSizeInPixels;
    public int elementTextRunLength;

    private UnhandledTapInfo(int version) {
        super(24, version);
        this.fontSizeInPixels = 0;
        this.elementTextRunLength = 0;
    }

    public UnhandledTapInfo() {
        this(0);
    }

    public static UnhandledTapInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UnhandledTapInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UnhandledTapInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UnhandledTapInfo result = new UnhandledTapInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.tappedPositionInViewport = Point.decode(decoder1);
            result.fontSizeInPixels = decoder0.readInt(16);
            result.elementTextRunLength = decoder0.readInt(20);
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
        encoder0.encode((Struct) this.tappedPositionInViewport, 8, false);
        encoder0.encode(this.fontSizeInPixels, 16);
        encoder0.encode(this.elementTextRunLength, 20);
    }
}
