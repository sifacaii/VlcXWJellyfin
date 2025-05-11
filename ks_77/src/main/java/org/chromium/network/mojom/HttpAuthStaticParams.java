package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/HttpAuthStaticParams.class */
public final class HttpAuthStaticParams extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String[] supportedSchemes;
    public String gssapiLibraryName;

    private HttpAuthStaticParams(int version) {
        super(24, version);
    }

    public HttpAuthStaticParams() {
        this(0);
    }

    public static HttpAuthStaticParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static HttpAuthStaticParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpAuthStaticParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            HttpAuthStaticParams result = new HttpAuthStaticParams(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.supportedSchemes = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.supportedSchemes[i1] = decoder1.readString(8 + (8 * i1), false);
            }
            result.gssapiLibraryName = decoder0.readString(16, false);
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
        if (this.supportedSchemes == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.supportedSchemes.length, 8, -1);
            for (int i0 = 0; i0 < this.supportedSchemes.length; i0++) {
                encoder1.encode(this.supportedSchemes[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.gssapiLibraryName, 16, false);
    }
}
