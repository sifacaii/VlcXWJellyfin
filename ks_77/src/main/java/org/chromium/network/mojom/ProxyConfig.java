package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.BigString;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfig.class */
public final class ProxyConfig extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean autoDetect;
    public BigString pacUrl;
    public boolean pacMandatory;
    public ProxyRules proxyRules;

    private ProxyConfig(int version) {
        super(32, version);
    }

    public ProxyConfig() {
        this(0);
    }

    public static ProxyConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ProxyConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ProxyConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ProxyConfig result = new ProxyConfig(elementsOrVersion);
            result.autoDetect = decoder0.readBoolean(8, 0);
            result.pacMandatory = decoder0.readBoolean(8, 1);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.pacUrl = BigString.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.proxyRules = ProxyRules.decode(decoder12);
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
        encoder0.encode(this.autoDetect, 8, 0);
        encoder0.encode(this.pacMandatory, 8, 1);
        encoder0.encode((Struct) this.pacUrl, 16, false);
        encoder0.encode((Struct) this.proxyRules, 24, false);
    }
}
