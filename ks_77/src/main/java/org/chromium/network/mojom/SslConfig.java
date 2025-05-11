package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfig.class */
public final class SslConfig extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean revCheckingEnabled;
    public boolean revCheckingRequiredLocalAnchors;
    public boolean sha1LocalAnchorsEnabled;
    public boolean symantecEnforcementDisabled;
    public int versionMin;
    public int versionMax;
    public short[] disabledCipherSuites;
    public String[] clientCertPoolingPolicy;

    private SslConfig(int version) {
        super(40, version);
        this.revCheckingEnabled = false;
        this.revCheckingRequiredLocalAnchors = false;
        this.sha1LocalAnchorsEnabled = false;
        this.symantecEnforcementDisabled = false;
        this.versionMin = 0;
        this.versionMax = 3;
    }

    public SslConfig() {
        this(0);
    }

    public static SslConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SslConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SslConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SslConfig result = new SslConfig(elementsOrVersion);
            result.revCheckingEnabled = decoder0.readBoolean(8, 0);
            result.revCheckingRequiredLocalAnchors = decoder0.readBoolean(8, 1);
            result.sha1LocalAnchorsEnabled = decoder0.readBoolean(8, 2);
            result.symantecEnforcementDisabled = decoder0.readBoolean(8, 3);
            result.versionMin = decoder0.readInt(12);
            SslVersion.validate(result.versionMin);
            result.versionMax = decoder0.readInt(16);
            SslVersion.validate(result.versionMax);
            result.disabledCipherSuites = decoder0.readShorts(24, 0, -1);
            Decoder decoder1 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.clientCertPoolingPolicy = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.clientCertPoolingPolicy[i1] = decoder1.readString(8 + (8 * i1), false);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.revCheckingEnabled, 8, 0);
        encoder0.encode(this.revCheckingRequiredLocalAnchors, 8, 1);
        encoder0.encode(this.sha1LocalAnchorsEnabled, 8, 2);
        encoder0.encode(this.symantecEnforcementDisabled, 8, 3);
        encoder0.encode(this.versionMin, 12);
        encoder0.encode(this.versionMax, 16);
        encoder0.encode(this.disabledCipherSuites, 24, 0, -1);
        if (this.clientCertPoolingPolicy == null) {
            encoder0.encodeNullPointer(32, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.clientCertPoolingPolicy.length, 32, -1);
        for (int i0 = 0; i0 < this.clientCertPoolingPolicy.length; i0++) {
            encoder1.encode(this.clientCertPoolingPolicy[i0], 8 + (8 * i0), false);
        }
    }
}
