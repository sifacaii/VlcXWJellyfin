package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheResourceInfo.class */
public final class AppCacheResourceInfo extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url url;
    public long responseSize;
    public long paddingSize;
    public boolean isMaster;
    public boolean isManifest;
    public boolean isIntercept;
    public boolean isFallback;
    public boolean isForeign;
    public boolean isExplicit;
    public long responseId;

    private AppCacheResourceInfo(int version) {
        super(48, version);
    }

    public AppCacheResourceInfo() {
        this(0);
    }

    public static AppCacheResourceInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AppCacheResourceInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AppCacheResourceInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AppCacheResourceInfo result = new AppCacheResourceInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.url = Url.decode(decoder1);
            result.responseSize = decoder0.readLong(16);
            result.paddingSize = decoder0.readLong(24);
            result.isMaster = decoder0.readBoolean(32, 0);
            result.isManifest = decoder0.readBoolean(32, 1);
            result.isIntercept = decoder0.readBoolean(32, 2);
            result.isFallback = decoder0.readBoolean(32, 3);
            result.isForeign = decoder0.readBoolean(32, 4);
            result.isExplicit = decoder0.readBoolean(32, 5);
            result.responseId = decoder0.readLong(40);
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
        encoder0.encode(this.responseSize, 16);
        encoder0.encode(this.paddingSize, 24);
        encoder0.encode(this.isMaster, 32, 0);
        encoder0.encode(this.isManifest, 32, 1);
        encoder0.encode(this.isIntercept, 32, 2);
        encoder0.encode(this.isFallback, 32, 3);
        encoder0.encode(this.isForeign, 32, 4);
        encoder0.encode(this.isExplicit, 32, 5);
        encoder0.encode(this.responseId, 40);
    }
}
