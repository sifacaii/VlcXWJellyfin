package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeResponse.class */
public final class WebSocketHandshakeResponse extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url url;
    public HttpVersion httpVersion;
    public int statusCode;
    public String statusText;
    public IpEndPoint remoteEndpoint;
    public HttpHeader[] headers;
    public String headersText;

    private WebSocketHandshakeResponse(int version) {
        super(64, version);
    }

    public WebSocketHandshakeResponse() {
        this(0);
    }

    public static WebSocketHandshakeResponse deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static WebSocketHandshakeResponse deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static WebSocketHandshakeResponse decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            WebSocketHandshakeResponse result = new WebSocketHandshakeResponse(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.url = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.httpVersion = HttpVersion.decode(decoder12);
            result.statusCode = decoder0.readInt(24);
            result.statusText = decoder0.readString(32, false);
            Decoder decoder13 = decoder0.readPointer(40, false);
            result.remoteEndpoint = IpEndPoint.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(48, false);
            DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
            result.headers = new HttpHeader[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder14.readPointer(8 + (8 * i1), false);
                result.headers[i1] = HttpHeader.decode(decoder2);
            }
            result.headersText = decoder0.readString(56, false);
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
        encoder0.encode((Struct) this.url, 8, false);
        encoder0.encode((Struct) this.httpVersion, 16, false);
        encoder0.encode(this.statusCode, 24);
        encoder0.encode(this.statusText, 32, false);
        encoder0.encode((Struct) this.remoteEndpoint, 40, false);
        if (this.headers == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.headers.length, 48, -1);
            for (int i0 = 0; i0 < this.headers.length; i0++) {
                encoder1.encode((Struct) this.headers[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.headersText, 56, false);
    }
}
