package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushSubscription.class */
public final class PushSubscription extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url endpoint;
    public PushSubscriptionOptions options;
    public byte[] p256dh;
    public byte[] auth;

    private PushSubscription(int version) {
        super(40, version);
    }

    public PushSubscription() {
        this(0);
    }

    public static PushSubscription deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PushSubscription deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PushSubscription decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PushSubscription result = new PushSubscription(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.endpoint = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.options = PushSubscriptionOptions.decode(decoder12);
            result.p256dh = decoder0.readBytes(24, 0, -1);
            result.auth = decoder0.readBytes(32, 0, -1);
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
        encoder0.encode((Struct) this.endpoint, 8, false);
        encoder0.encode((Struct) this.options, 16, false);
        encoder0.encode(this.p256dh, 24, 0, -1);
        encoder0.encode(this.auth, 32, 0, -1);
    }
}
