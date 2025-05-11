package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Token;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceFilter.class */
public final class ServiceFilter extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String serviceName;
    public Token instanceGroup;
    public Token instanceId;
    public Token globallyUniqueId;

    private ServiceFilter(int version) {
        super(40, version);
    }

    public ServiceFilter() {
        this(0);
    }

    public static ServiceFilter deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceFilter deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceFilter decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ServiceFilter result = new ServiceFilter(elementsOrVersion);
            result.serviceName = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, true);
            result.instanceGroup = Token.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, true);
            result.instanceId = Token.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, true);
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
        encoder0.encode(this.serviceName, 8, false);
        encoder0.encode((Struct) this.instanceGroup, 16, true);
        encoder0.encode((Struct) this.instanceId, 24, true);
        encoder0.encode((Struct) this.globallyUniqueId, 32, true);
    }
}
