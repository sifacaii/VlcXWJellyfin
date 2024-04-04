package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/BindSourceInfo.class */
public final class BindSourceInfo extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Identity identity;
    public CapabilitySet requiredCapabilities;

    private BindSourceInfo(int version) {
        super(24, version);
    }

    public BindSourceInfo() {
        this(0);
    }

    public static BindSourceInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BindSourceInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BindSourceInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BindSourceInfo result = new BindSourceInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.identity = Identity.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.requiredCapabilities = CapabilitySet.decode(decoder12);
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
        encoder0.encode((Struct) this.identity, 8, false);
        encoder0.encode((Struct) this.requiredCapabilities, 16, false);
    }
}
