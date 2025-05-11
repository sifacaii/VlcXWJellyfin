package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Token;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Identity.class */
public final class Identity extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String name;
    public Token instanceGroup;
    public Token instanceId;
    public Token globallyUniqueId;

    private Identity(int version) {
        super(40, version);
    }

    public Identity() {
        this(0);
    }

    public static Identity deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static Identity deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static Identity decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            Identity result = new Identity(elementsOrVersion);
            result.name = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.instanceGroup = Token.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.instanceId = Token.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.globallyUniqueId = Token.decode(decoder13);
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
        encoder0.encode(this.name, 8, false);
        encoder0.encode((Struct) this.instanceGroup, 16, false);
        encoder0.encode((Struct) this.instanceId, 24, false);
        encoder0.encode((Struct) this.globallyUniqueId, 32, false);
    }
}
