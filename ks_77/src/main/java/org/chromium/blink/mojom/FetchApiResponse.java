package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.network.mojom.FetchResponseSource;
import org.chromium.network.mojom.FetchResponseType;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FetchApiResponse.class */
public final class FetchApiResponse extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url[] urlList;
    public short statusCode;
    public String statusText;
    public int responseType;
    public int responseSource;
    public Map<String, String> headers;
    public SerializedBlob blob;
    public int error;
    public Time responseTime;
    public String cacheStorageCacheName;
    public String[] corsExposedHeaderNames;
    public SerializedBlob sideDataBlob;

    private FetchApiResponse(int version) {
        super(88, version);
        this.statusCode = (short) 0;
        this.responseType = 2;
        this.responseSource = 0;
        this.error = 0;
    }

    public FetchApiResponse() {
        this(0);
    }

    public static FetchApiResponse deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FetchApiResponse deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FetchApiResponse decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FetchApiResponse result = new FetchApiResponse(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.urlList = new Url[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.urlList[i1] = Url.decode(decoder1.readPointer(8 + (8 * i1), false));
            }
            result.statusCode = decoder0.readShort(16);
            result.responseType = decoder0.readInt(20);
            FetchResponseType.validate(result.responseType);
            result.statusText = decoder0.readString(24, false);
            result.responseSource = decoder0.readInt(32);
            FetchResponseSource.validate(result.responseSource);
            result.error = decoder0.readInt(36);
            ServiceWorkerResponseError.validate(result.error);
            Decoder decoder12 = decoder0.readPointer(40, false);
            decoder12.readDataHeaderForMap();
            Decoder decoder2 = decoder12.readPointer(8, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
            String[] keys0 = new String[si2.elementsOrVersion];
            for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                keys0[i2] = decoder2.readString(8 + (8 * i2), false);
            }
            Decoder decoder22 = decoder12.readPointer(16, false);
            DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
            String[] values0 = new String[si22.elementsOrVersion];
            for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
                values0[i22] = decoder22.readString(8 + (8 * i22), false);
            }
            result.headers = new HashMap();
            for (int index0 = 0; index0 < keys0.length; index0++) {
                result.headers.put(keys0[index0], values0[index0]);
            }
            result.blob = SerializedBlob.decode(decoder0.readPointer(48, true));
            result.responseTime = Time.decode(decoder0.readPointer(56, false));
            result.cacheStorageCacheName = decoder0.readString(64, true);
            Decoder decoder13 = decoder0.readPointer(72, false);
            DataHeader si12 = decoder13.readDataHeaderForPointerArray(-1);
            result.corsExposedHeaderNames = new String[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                result.corsExposedHeaderNames[i12] = decoder13.readString(8 + (8 * i12), false);
            }
            result.sideDataBlob = SerializedBlob.decode(decoder0.readPointer(80, true));
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
        if (this.urlList == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.urlList.length, 8, -1);
            for (int i0 = 0; i0 < this.urlList.length; i0++) {
                encoder1.encode((Struct) this.urlList[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.statusCode, 16);
        encoder0.encode(this.responseType, 20);
        encoder0.encode(this.statusText, 24, false);
        encoder0.encode(this.responseSource, 32);
        encoder0.encode(this.error, 36);
        if (this.headers == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder12 = encoder0.encoderForMap(40);
            int size0 = this.headers.size();
            String[] keys0 = new String[size0];
            String[] values0 = new String[size0];
            int index0 = 0;
            for (Map.Entry<String, String> entry0 : this.headers.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                index0++;
            }
            Encoder encoder2 = encoder12.encodePointerArray(keys0.length, 8, -1);
            for (int i1 = 0; i1 < keys0.length; i1++) {
                encoder2.encode(keys0[i1], 8 + (8 * i1), false);
            }
            Encoder encoder22 = encoder12.encodePointerArray(values0.length, 16, -1);
            for (int i12 = 0; i12 < values0.length; i12++) {
                encoder22.encode(values0[i12], 8 + (8 * i12), false);
            }
        }
        encoder0.encode((Struct) this.blob, 48, true);
        encoder0.encode((Struct) this.responseTime, 56, false);
        encoder0.encode(this.cacheStorageCacheName, 64, true);
        if (this.corsExposedHeaderNames == null) {
            encoder0.encodeNullPointer(72, false);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.corsExposedHeaderNames.length, 72, -1);
            for (int i02 = 0; i02 < this.corsExposedHeaderNames.length; i02++) {
                encoder13.encode(this.corsExposedHeaderNames[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode((Struct) this.sideDataBlob, 80, true);
    }
}
