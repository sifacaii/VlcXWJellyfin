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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerScriptInfo.class */
public final class ServiceWorkerScriptInfo extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url scriptUrl;
    public String encoding;
    public Map<String, String> headers;
    public DataPipe.ConsumerHandle body;
    public long bodySize;
    public DataPipe.ConsumerHandle metaData;
    public long metaDataSize;

    private ServiceWorkerScriptInfo(int version) {
        super(56, version);
        this.body = InvalidHandle.INSTANCE;
        this.metaData = InvalidHandle.INSTANCE;
    }

    public ServiceWorkerScriptInfo() {
        this(0);
    }

    public static ServiceWorkerScriptInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerScriptInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerScriptInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ServiceWorkerScriptInfo result = new ServiceWorkerScriptInfo(elementsOrVersion);
            result.scriptUrl = Url.decode(decoder0.readPointer(8, false));
            result.encoding = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, false);
            decoder1.readDataHeaderForMap();
            Decoder decoder2 = decoder1.readPointer(8, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
            String[] keys0 = new String[si2.elementsOrVersion];
            for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                keys0[i2] = decoder2.readString(8 + (8 * i2), false);
            }
            Decoder decoder22 = decoder1.readPointer(16, false);
            DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
            String[] values0 = new String[si22.elementsOrVersion];
            for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
                values0[i22] = decoder22.readString(8 + (8 * i22), false);
            }
            result.headers = new HashMap();
            for (int index0 = 0; index0 < keys0.length; index0++) {
                result.headers.put(keys0[index0], values0[index0]);
            }
            result.body = decoder0.readConsumerHandle(32, false);
            result.metaData = decoder0.readConsumerHandle(36, true);
            result.bodySize = decoder0.readLong(40);
            result.metaDataSize = decoder0.readLong(48);
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
        encoder0.encode((Struct) this.scriptUrl, 8, false);
        encoder0.encode(this.encoding, 16, false);
        if (this.headers == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(24);
            int size0 = this.headers.size();
            String[] keys0 = new String[size0];
            String[] values0 = new String[size0];
            int index0 = 0;
            for (Map.Entry<String, String> entry0 : this.headers.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                index0++;
            }
            Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
            for (int i1 = 0; i1 < keys0.length; i1++) {
                encoder2.encode(keys0[i1], 8 + (8 * i1), false);
            }
            Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
            for (int i12 = 0; i12 < values0.length; i12++) {
                encoder22.encode(values0[i12], 8 + (8 * i12), false);
            }
        }
        encoder0.encode((Handle) this.body, 32, false);
        encoder0.encode((Handle) this.metaData, 36, true);
        encoder0.encode(this.bodySize, 40);
        encoder0.encode(this.metaDataSize, 48);
    }
}
