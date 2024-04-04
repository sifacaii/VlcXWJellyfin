package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationOptions.class */
public final class ServiceWorkerRegistrationOptions extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url scope;
    public int type;
    public int updateViaCache;

    private ServiceWorkerRegistrationOptions(int version) {
        super(24, version);
        this.type = 0;
        this.updateViaCache = 0;
    }

    public ServiceWorkerRegistrationOptions() {
        this(0);
    }

    public static ServiceWorkerRegistrationOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerRegistrationOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerRegistrationOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ServiceWorkerRegistrationOptions result = new ServiceWorkerRegistrationOptions(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.scope = Url.decode(decoder1);
            result.type = decoder0.readInt(16);
            ScriptType.validate(result.type);
            result.updateViaCache = decoder0.readInt(20);
            ServiceWorkerUpdateViaCache.validate(result.updateViaCache);
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
        encoder0.encode((Struct) this.scope, 8, false);
        encoder0.encode(this.type, 16);
        encoder0.encode(this.updateViaCache, 20);
    }
}
