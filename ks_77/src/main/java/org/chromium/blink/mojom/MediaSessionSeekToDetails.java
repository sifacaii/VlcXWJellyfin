package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionSeekToDetails.class */
public final class MediaSessionSeekToDetails extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TimeDelta seekTime;
    public boolean fastSeek;

    private MediaSessionSeekToDetails(int version) {
        super(24, version);
    }

    public MediaSessionSeekToDetails() {
        this(0);
    }

    public static MediaSessionSeekToDetails deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaSessionSeekToDetails deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionSeekToDetails decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaSessionSeekToDetails result = new MediaSessionSeekToDetails(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.seekTime = TimeDelta.decode(decoder1);
            result.fastSeek = decoder0.readBoolean(16, 0);
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
        encoder0.encode((Struct) this.seekTime, 8, false);
        encoder0.encode(this.fastSeek, 16, 0);
    }
}
