package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialHostControlSignals.class */
public final class SerialHostControlSignals extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean dtr;
    public boolean hasDtr;
    public boolean rts;
    public boolean hasRts;

    private SerialHostControlSignals(int version) {
        super(16, version);
        this.hasDtr = false;
        this.hasRts = false;
    }

    public SerialHostControlSignals() {
        this(0);
    }

    public static SerialHostControlSignals deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SerialHostControlSignals deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialHostControlSignals decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SerialHostControlSignals result = new SerialHostControlSignals(elementsOrVersion);
            result.dtr = decoder0.readBoolean(8, 0);
            result.hasDtr = decoder0.readBoolean(8, 1);
            result.rts = decoder0.readBoolean(8, 2);
            result.hasRts = decoder0.readBoolean(8, 3);
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
        encoder0.encode(this.dtr, 8, 0);
        encoder0.encode(this.hasDtr, 8, 1);
        encoder0.encode(this.rts, 8, 2);
        encoder0.encode(this.hasRts, 8, 3);
    }
}
