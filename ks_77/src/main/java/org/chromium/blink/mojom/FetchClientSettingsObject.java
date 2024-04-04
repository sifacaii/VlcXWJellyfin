package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.ReferrerPolicy;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FetchClientSettingsObject.class */
public final class FetchClientSettingsObject extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int referrerPolicy;
    public Url outgoingReferrer;

    private FetchClientSettingsObject(int version) {
        super(24, version);
    }

    public FetchClientSettingsObject() {
        this(0);
    }

    public static FetchClientSettingsObject deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FetchClientSettingsObject deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FetchClientSettingsObject decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FetchClientSettingsObject result = new FetchClientSettingsObject(elementsOrVersion);
            result.referrerPolicy = decoder0.readInt(8);
            ReferrerPolicy.validate(result.referrerPolicy);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.outgoingReferrer = Url.decode(decoder1);
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
        encoder0.encode(this.referrerPolicy, 8);
        encoder0.encode((Struct) this.outgoingReferrer, 16, false);
    }
}
