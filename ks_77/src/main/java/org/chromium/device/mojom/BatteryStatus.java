package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BatteryStatus.class */
public final class BatteryStatus extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean charging;
    public double chargingTime;
    public double dischargingTime;
    public double level;

    private BatteryStatus(int version) {
        super(40, version);
        this.charging = true;
        this.chargingTime = 0.0d;
        this.dischargingTime = Double.POSITIVE_INFINITY;
        this.level = 1.0d;
    }

    public BatteryStatus() {
        this(0);
    }

    public static BatteryStatus deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BatteryStatus deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BatteryStatus decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BatteryStatus result = new BatteryStatus(elementsOrVersion);
            result.charging = decoder0.readBoolean(8, 0);
            result.chargingTime = decoder0.readDouble(16);
            result.dischargingTime = decoder0.readDouble(24);
            result.level = decoder0.readDouble(32);
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
        encoder0.encode(this.charging, 8, 0);
        encoder0.encode(this.chargingTime, 16);
        encoder0.encode(this.dischargingTime, 24);
        encoder0.encode(this.level, 32);
    }
}
