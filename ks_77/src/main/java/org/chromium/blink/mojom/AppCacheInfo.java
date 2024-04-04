package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheInfo.class */
public final class AppCacheInfo extends Struct {
    private static final int STRUCT_SIZE = 80;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(80, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url manifestUrl;
    public Time creationTime;
    public Time lastUpdateTime;
    public Time lastAccessTime;
    public long cacheId;
    public long groupId;
    public int status;
    public long responseSizes;
    public long paddingSizes;
    public boolean isComplete;

    private AppCacheInfo(int version) {
        super(80, version);
    }

    public AppCacheInfo() {
        this(0);
    }

    public static AppCacheInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AppCacheInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AppCacheInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AppCacheInfo result = new AppCacheInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.manifestUrl = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.creationTime = Time.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.lastUpdateTime = Time.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, false);
            result.lastAccessTime = Time.decode(decoder14);
            result.cacheId = decoder0.readLong(40);
            result.groupId = decoder0.readLong(48);
            result.status = decoder0.readInt(56);
            AppCacheStatus.validate(result.status);
            result.isComplete = decoder0.readBoolean(60, 0);
            result.responseSizes = decoder0.readLong(64);
            result.paddingSizes = decoder0.readLong(72);
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
        encoder0.encode((Struct) this.manifestUrl, 8, false);
        encoder0.encode((Struct) this.creationTime, 16, false);
        encoder0.encode((Struct) this.lastUpdateTime, 24, false);
        encoder0.encode((Struct) this.lastAccessTime, 32, false);
        encoder0.encode(this.cacheId, 40);
        encoder0.encode(this.groupId, 48);
        encoder0.encode(this.status, 56);
        encoder0.encode(this.isComplete, 60, 0);
        encoder0.encode(this.responseSizes, 64);
        encoder0.encode(this.paddingSizes, 72);
    }
}
