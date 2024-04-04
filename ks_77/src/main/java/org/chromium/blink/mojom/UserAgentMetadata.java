package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UserAgentMetadata.class */
public final class UserAgentMetadata extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String brand;
    public String fullVersion;
    public String majorVersion;
    public String platform;
    public String architecture;
    public String model;

    private UserAgentMetadata(int version) {
        super(56, version);
    }

    public UserAgentMetadata() {
        this(0);
    }

    public static UserAgentMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UserAgentMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UserAgentMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UserAgentMetadata result = new UserAgentMetadata(elementsOrVersion);
            result.brand = decoder0.readString(8, false);
            result.fullVersion = decoder0.readString(16, false);
            result.majorVersion = decoder0.readString(24, false);
            result.platform = decoder0.readString(32, false);
            result.architecture = decoder0.readString(40, false);
            result.model = decoder0.readString(48, false);
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
        encoder0.encode(this.brand, 8, false);
        encoder0.encode(this.fullVersion, 16, false);
        encoder0.encode(this.majorVersion, 24, false);
        encoder0.encode(this.platform, 32, false);
        encoder0.encode(this.architecture, 40, false);
        encoder0.encode(this.model, 48, false);
    }
}
