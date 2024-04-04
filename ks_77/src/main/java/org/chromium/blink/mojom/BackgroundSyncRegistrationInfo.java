package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundSyncRegistrationInfo.class */
public final class BackgroundSyncRegistrationInfo extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long serviceWorkerRegistrationId;
    public String tag;
    public int syncType;

    private BackgroundSyncRegistrationInfo(int version) {
        super(32, version);
        this.serviceWorkerRegistrationId = -1L;
    }

    public BackgroundSyncRegistrationInfo() {
        this(0);
    }

    public static BackgroundSyncRegistrationInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BackgroundSyncRegistrationInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BackgroundSyncRegistrationInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BackgroundSyncRegistrationInfo result = new BackgroundSyncRegistrationInfo(elementsOrVersion);
            result.serviceWorkerRegistrationId = decoder0.readLong(8);
            result.tag = decoder0.readString(16, false);
            result.syncType = decoder0.readInt(24);
            BackgroundSyncType.validate(result.syncType);
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
        encoder0.encode(this.serviceWorkerRegistrationId, 8);
        encoder0.encode(this.tag, 16, false);
        encoder0.encode(this.syncType, 24);
    }
}
