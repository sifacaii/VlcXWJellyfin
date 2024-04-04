package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DisplayMediaInformation.class */
public final class DisplayMediaInformation extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int displaySurface;
    public boolean logicalSurface;
    public int cursor;

    private DisplayMediaInformation(int version) {
        super(24, version);
    }

    public DisplayMediaInformation() {
        this(0);
    }

    public static DisplayMediaInformation deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DisplayMediaInformation deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DisplayMediaInformation decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DisplayMediaInformation result = new DisplayMediaInformation(elementsOrVersion);
            result.displaySurface = decoder0.readInt(8);
            DisplayCaptureSurfaceType.validate(result.displaySurface);
            result.logicalSurface = decoder0.readBoolean(12, 0);
            result.cursor = decoder0.readInt(16);
            CursorCaptureType.validate(result.cursor);
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
        encoder0.encode(this.displaySurface, 8);
        encoder0.encode(this.logicalSurface, 12, 0);
        encoder0.encode(this.cursor, 16);
    }
}
