package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerInfo.class */
public final class SharedWorkerInfo extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url url;
    public String name;
    public String contentSecurityPolicy;
    public int contentSecurityPolicyType;
    public int creationAddressSpace;

    private SharedWorkerInfo(int version) {
        super(40, version);
    }

    public SharedWorkerInfo() {
        this(0);
    }

    public static SharedWorkerInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SharedWorkerInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedWorkerInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SharedWorkerInfo result = new SharedWorkerInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.url = Url.decode(decoder1);
            result.name = decoder0.readString(16, false);
            result.contentSecurityPolicy = decoder0.readString(24, false);
            result.contentSecurityPolicyType = decoder0.readInt(32);
            ContentSecurityPolicyType.validate(result.contentSecurityPolicyType);
            result.creationAddressSpace = decoder0.readInt(36);
            IpAddressSpace.validate(result.creationAddressSpace);
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
        encoder0.encode(this.name, 16, false);
        encoder0.encode(this.contentSecurityPolicy, 24, false);
        encoder0.encode(this.contentSecurityPolicyType, 32);
        encoder0.encode(this.creationAddressSpace, 36);
    }
}
