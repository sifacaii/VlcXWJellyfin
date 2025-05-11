package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TlsClientSocketOptions.class */
public final class TlsClientSocketOptions extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int versionMin;
    public int versionMax;
    public boolean sendSslInfo;
    public boolean unsafelySkipCertVerification;

    private TlsClientSocketOptions(int version) {
        super(24, version);
        this.versionMin = 0;
        this.versionMax = 3;
        this.sendSslInfo = false;
        this.unsafelySkipCertVerification = false;
    }

    public TlsClientSocketOptions() {
        this(0);
    }

    public static TlsClientSocketOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TlsClientSocketOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TlsClientSocketOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TlsClientSocketOptions result = new TlsClientSocketOptions(elementsOrVersion);
            result.versionMin = decoder0.readInt(8);
            SslVersion.validate(result.versionMin);
            result.versionMax = decoder0.readInt(12);
            SslVersion.validate(result.versionMax);
            result.sendSslInfo = decoder0.readBoolean(16, 0);
            result.unsafelySkipCertVerification = decoder0.readBoolean(16, 1);
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
        encoder0.encode(this.versionMin, 8);
        encoder0.encode(this.versionMax, 12);
        encoder0.encode(this.sendSslInfo, 16, 0);
        encoder0.encode(this.unsafelySkipCertVerification, 16, 1);
    }
}
