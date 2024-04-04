package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlRequestBody.class */
public final class UrlRequestBody extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public DataElement[] elements;
    public long identifier;
    public boolean containsSensitiveInfo;

    private UrlRequestBody(int version) {
        super(32, version);
    }

    public UrlRequestBody() {
        this(0);
    }

    public static UrlRequestBody deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UrlRequestBody deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlRequestBody decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UrlRequestBody result = new UrlRequestBody(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.elements = new DataElement[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.elements[i1] = DataElement.decode(decoder2);
            }
            result.identifier = decoder0.readLong(16);
            result.containsSensitiveInfo = decoder0.readBoolean(24, 0);
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
        if (this.elements == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.elements.length, 8, -1);
            for (int i0 = 0; i0 < this.elements.length; i0++) {
                encoder1.encode((Struct) this.elements[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.identifier, 16);
        encoder0.encode(this.containsSensitiveInfo, 24, 0);
    }
}
