package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaPosition.class */
public final class MediaPosition extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public double playbackRate;
    public TimeDelta duration;
    public TimeDelta position;
    public TimeTicks lastUpdatedTime;

    private MediaPosition(int version) {
        super(40, version);
    }

    public MediaPosition() {
        this(0);
    }

    public static MediaPosition deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaPosition deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaPosition decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaPosition result = new MediaPosition(elementsOrVersion);
            result.playbackRate = decoder0.readDouble(8);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.duration = TimeDelta.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.position = TimeDelta.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.lastUpdatedTime = TimeTicks.decode(decoder13);
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
        encoder0.encode(this.playbackRate, 8);
        encoder0.encode((Struct) this.duration, 16, false);
        encoder0.encode((Struct) this.position, 24, false);
        encoder0.encode((Struct) this.lastUpdatedTime, 32, false);
    }
}
