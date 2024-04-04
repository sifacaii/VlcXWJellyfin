package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/HttpRequestHeaderKeyValuePair.class */
public final class HttpRequestHeaderKeyValuePair extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String key;
    public String value;

    private HttpRequestHeaderKeyValuePair(int version) {
        super(24, version);
    }

    public HttpRequestHeaderKeyValuePair() {
        this(0);
    }

    public static HttpRequestHeaderKeyValuePair deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static HttpRequestHeaderKeyValuePair deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static HttpRequestHeaderKeyValuePair decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            HttpRequestHeaderKeyValuePair result = new HttpRequestHeaderKeyValuePair(elementsOrVersion);
            result.key = decoder0.readString(8, false);
            result.value = decoder0.readString(16, false);
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
        encoder0.encode(this.key, 8, false);
        encoder0.encode(this.value, 16, false);
    }
}
