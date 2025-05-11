package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceFilter.class */
public final class UsbDeviceFilter extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean hasVendorId;
    public short vendorId;
    public boolean hasProductId;
    public short productId;
    public boolean hasClassCode;
    public byte classCode;
    public boolean hasSubclassCode;
    public byte subclassCode;
    public boolean hasProtocolCode;
    public byte protocolCode;
    public String16 serialNumber;

    private UsbDeviceFilter(int version) {
        super(24, version);
    }

    public UsbDeviceFilter() {
        this(0);
    }

    public static UsbDeviceFilter deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UsbDeviceFilter deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbDeviceFilter decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UsbDeviceFilter result = new UsbDeviceFilter(elementsOrVersion);
            result.hasVendorId = decoder0.readBoolean(8, 0);
            result.hasProductId = decoder0.readBoolean(8, 1);
            result.hasClassCode = decoder0.readBoolean(8, 2);
            result.hasSubclassCode = decoder0.readBoolean(8, 3);
            result.hasProtocolCode = decoder0.readBoolean(8, 4);
            result.classCode = decoder0.readByte(9);
            result.vendorId = decoder0.readShort(10);
            result.productId = decoder0.readShort(12);
            result.subclassCode = decoder0.readByte(14);
            result.protocolCode = decoder0.readByte(15);
            Decoder decoder1 = decoder0.readPointer(16, true);
            result.serialNumber = String16.decode(decoder1);
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
        encoder0.encode(this.hasVendorId, 8, 0);
        encoder0.encode(this.hasProductId, 8, 1);
        encoder0.encode(this.hasClassCode, 8, 2);
        encoder0.encode(this.hasSubclassCode, 8, 3);
        encoder0.encode(this.hasProtocolCode, 8, 4);
        encoder0.encode(this.classCode, 9);
        encoder0.encode(this.vendorId, 10);
        encoder0.encode(this.productId, 12);
        encoder0.encode(this.subclassCode, 14);
        encoder0.encode(this.protocolCode, 15);
        encoder0.encode((Struct) this.serialNumber, 16, true);
    }
}
