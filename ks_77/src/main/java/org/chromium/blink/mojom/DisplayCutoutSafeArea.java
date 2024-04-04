package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DisplayCutoutSafeArea.class */
public final class DisplayCutoutSafeArea extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int top;
    public int left;
    public int bottom;
    public int right;

    private DisplayCutoutSafeArea(int version) {
        super(24, version);
    }

    public DisplayCutoutSafeArea() {
        this(0);
    }

    public static DisplayCutoutSafeArea deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DisplayCutoutSafeArea deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DisplayCutoutSafeArea decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DisplayCutoutSafeArea result = new DisplayCutoutSafeArea(elementsOrVersion);
            result.top = decoder0.readInt(8);
            result.left = decoder0.readInt(12);
            result.bottom = decoder0.readInt(16);
            result.right = decoder0.readInt(20);
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
