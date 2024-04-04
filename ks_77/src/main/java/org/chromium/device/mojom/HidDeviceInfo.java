package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidDeviceInfo.class */
public final class HidDeviceInfo extends Struct {
    private static final int STRUCT_SIZE = 96;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(96, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String guid;
    public short vendorId;
    public short productId;
    public String productName;
    public String serialNumber;
    public int busType;
    public byte[] reportDescriptor;
    public HidCollectionInfo[] collections;
    public boolean hasReportId;
    public long maxInputReportSize;
    public long maxOutputReportSize;
    public long maxFeatureReportSize;
    public String deviceNode;

    private HidDeviceInfo(int version) {
        super(96, version);
    }

    public HidDeviceInfo() {
        this(0);
    }

    public static HidDeviceInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static HidDeviceInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static HidDeviceInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            HidDeviceInfo result = new HidDeviceInfo(elementsOrVersion);
            result.guid = decoder0.readString(8, false);
            result.vendorId = decoder0.readShort(16);
            result.productId = decoder0.readShort(18);
            result.busType = decoder0.readInt(20);
            HidBusType.validate(result.busType);
            result.productName = decoder0.readString(24, false);
            result.serialNumber = decoder0.readString(32, false);
            result.reportDescriptor = decoder0.readBytes(40, 0, -1);
            Decoder decoder1 = decoder0.readPointer(48, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.collections = new HidCollectionInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.collections[i1] = HidCollectionInfo.decode(decoder2);
            }
            result.hasReportId = decoder0.readBoolean(56, 0);
            result.maxInputReportSize = decoder0.readLong(64);
            result.maxOutputReportSize = decoder0.readLong(72);
            result.maxFeatureReportSize = decoder0.readLong(80);
            result.deviceNode = decoder0.readString(88, false);
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
        encoder0.encode(this.guid, 8, false);
        encoder0.encode(this.vendorId, 16);
        encoder0.encode(this.productId, 18);
        encoder0.encode(this.busType, 20);
        encoder0.encode(this.productName, 24, false);
        encoder0.encode(this.serialNumber, 32, false);
        encoder0.encode(this.reportDescriptor, 40, 0, -1);
        if (this.collections == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.collections.length, 48, -1);
            for (int i0 = 0; i0 < this.collections.length; i0++) {
                encoder1.encode((Struct) this.collections[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.hasReportId, 56, 0);
        encoder0.encode(this.maxInputReportSize, 64);
        encoder0.encode(this.maxOutputReportSize, 72);
        encoder0.encode(this.maxFeatureReportSize, 80);
        encoder0.encode(this.deviceNode, 88, false);
    }
}
