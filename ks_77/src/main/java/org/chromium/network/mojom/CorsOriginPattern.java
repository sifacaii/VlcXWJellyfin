package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CorsOriginPattern.class */
public final class CorsOriginPattern extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String protocol;
    public String domain;
    public short port;
    public int domainMatchMode;
    public int portMatchMode;
    public int priority;

    private CorsOriginPattern(int version) {
        super(40, version);
    }

    public CorsOriginPattern() {
        this(0);
    }

    public static CorsOriginPattern deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CorsOriginPattern deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CorsOriginPattern decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CorsOriginPattern result = new CorsOriginPattern(elementsOrVersion);
            result.protocol = decoder0.readString(8, false);
            result.domain = decoder0.readString(16, false);
            result.port = decoder0.readShort(24);
            result.domainMatchMode = decoder0.readInt(28);
            CorsDomainMatchMode.validate(result.domainMatchMode);
            result.portMatchMode = decoder0.readInt(32);
            CorsPortMatchMode.validate(result.portMatchMode);
            result.priority = decoder0.readInt(36);
            CorsOriginAccessMatchPriority.validate(result.priority);
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
        encoder0.encode(this.protocol, 8, false);
        encoder0.encode(this.domain, 16, false);
        encoder0.encode(this.port, 24);
        encoder0.encode(this.domainMatchMode, 28);
        encoder0.encode(this.portMatchMode, 32);
        encoder0.encode(this.priority, 36);
    }
}
