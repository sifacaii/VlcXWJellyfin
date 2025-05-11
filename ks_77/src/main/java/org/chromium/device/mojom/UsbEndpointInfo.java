package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbEndpointInfo.class */
public final class UsbEndpointInfo extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public byte endpointNumber;
    public int direction;
    public int type;
    public int packetSize;
    public int synchronizationType;
    public int usageType;
    public byte pollingInterval;
    public byte[] extraData;

    private UsbEndpointInfo(int version) {
        super(40, version);
    }

    public UsbEndpointInfo() {
        this(0);
    }

    public static UsbEndpointInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UsbEndpointInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbEndpointInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UsbEndpointInfo result = new UsbEndpointInfo(elementsOrVersion);
            result.endpointNumber = decoder0.readByte(8);
            result.pollingInterval = decoder0.readByte(9);
            result.direction = decoder0.readInt(12);
            UsbTransferDirection.validate(result.direction);
            result.type = decoder0.readInt(16);
            UsbTransferType.validate(result.type);
            result.packetSize = decoder0.readInt(20);
            result.synchronizationType = decoder0.readInt(24);
            UsbSynchronizationType.validate(result.synchronizationType);
            result.usageType = decoder0.readInt(28);
            UsbUsageType.validate(result.usageType);
            result.extraData = decoder0.readBytes(32, 0, -1);
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
        encoder0.encode(this.endpointNumber, 8);
        encoder0.encode(this.pollingInterval, 9);
        encoder0.encode(this.direction, 12);
        encoder0.encode(this.type, 16);
        encoder0.encode(this.packetSize, 20);
        encoder0.encode(this.synchronizationType, 24);
        encoder0.encode(this.usageType, 28);
        encoder0.encode(this.extraData, 32, 0, -1);
    }
}
