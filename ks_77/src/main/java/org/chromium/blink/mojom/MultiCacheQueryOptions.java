package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MultiCacheQueryOptions.class */
public final class MultiCacheQueryOptions extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CacheQueryOptions queryOptions;
    public String16 cacheName;

    private MultiCacheQueryOptions(int version) {
        super(24, version);
    }

    public MultiCacheQueryOptions() {
        this(0);
    }

    public static MultiCacheQueryOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MultiCacheQueryOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MultiCacheQueryOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MultiCacheQueryOptions result = new MultiCacheQueryOptions(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.queryOptions = CacheQueryOptions.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, true);
            result.cacheName = String16.decode(decoder12);
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
        encoder0.encode((Struct) this.queryOptions, 8, false);
        encoder0.encode((Struct) this.cacheName, 16, true);
    }
}
