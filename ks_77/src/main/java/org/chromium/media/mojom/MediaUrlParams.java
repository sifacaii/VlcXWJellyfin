package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaUrlParams.class */
public final class MediaUrlParams extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url mediaUrl;
    public Url siteForCookies;
    public boolean allowCredentials;
    public boolean isHls;

    private MediaUrlParams(int version) {
        super(32, version);
    }

    public MediaUrlParams() {
        this(0);
    }

    public static MediaUrlParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaUrlParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaUrlParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaUrlParams result = new MediaUrlParams(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.mediaUrl = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.siteForCookies = Url.decode(decoder12);
            result.allowCredentials = decoder0.readBoolean(24, 0);
            result.isHls = decoder0.readBoolean(24, 1);
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
        encoder0.encode((Struct) this.mediaUrl, 8, false);
        encoder0.encode((Struct) this.siteForCookies, 16, false);
        encoder0.encode(this.allowCredentials, 24, 0);
        encoder0.encode(this.isHls, 24, 1);
    }
}
