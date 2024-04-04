package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcPushOptions.class */
public final class NfcPushOptions extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int target;
    public double timeout;
    public boolean ignoreRead;
    public int compatibility;

    private NfcPushOptions(int version) {
        super(32, version);
    }

    public NfcPushOptions() {
        this(0);
    }

    public static NfcPushOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NfcPushOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcPushOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NfcPushOptions result = new NfcPushOptions(elementsOrVersion);
            result.target = decoder0.readInt(8);
            NfcPushTarget.validate(result.target);
            result.ignoreRead = decoder0.readBoolean(12, 0);
            result.timeout = decoder0.readDouble(16);
            result.compatibility = decoder0.readInt(24);
            NdefCompatibility.validate(result.compatibility);
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
        encoder0.encode(this.target, 8);
        encoder0.encode(this.ignoreRead, 12, 0);
        encoder0.encode(this.timeout, 16);
        encoder0.encode(this.compatibility, 24);
    }
}
