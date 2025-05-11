package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaMetadata.class */
public final class MediaMetadata extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String16 title;
    public String16 artist;
    public String16 album;
    public String16 sourceTitle;

    private MediaMetadata(int version) {
        super(40, version);
    }

    public MediaMetadata() {
        this(0);
    }

    public static MediaMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaMetadata result = new MediaMetadata(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.title = String16.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.artist = String16.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.album = String16.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, false);
            result.sourceTitle = String16.decode(decoder14);
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
        encoder0.encode((Struct) this.title, 8, false);
        encoder0.encode((Struct) this.artist, 16, false);
        encoder0.encode((Struct) this.album, 24, false);
        encoder0.encode((Struct) this.sourceTitle, 32, false);
    }
}
