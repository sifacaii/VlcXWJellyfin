package org.chromium.blink.mojom.document_metadata;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/document_metadata/WebPage.class */
public final class WebPage extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url url;
    public String title;
    public Entity[] entities;

    private WebPage(int version) {
        super(32, version);
    }

    public WebPage() {
        this(0);
    }

    public static WebPage deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static WebPage deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static WebPage decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            WebPage result = new WebPage(elementsOrVersion);
            result.url = Url.decode(decoder0.readPointer(8, false));
            result.title = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.entities = new Entity[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.entities[i1] = Entity.decode(decoder2);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode((Struct) this.url, 8, false);
        encoder0.encode(this.title, 16, false);
        if (this.entities == null) {
            encoder0.encodeNullPointer(24, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.entities.length, 24, -1);
        for (int i0 = 0; i0 < this.entities.length; i0++) {
            encoder1.encode((Struct) this.entities[i0], 8 + (8 * i0), false);
        }
    }
}
