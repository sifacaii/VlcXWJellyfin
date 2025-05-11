package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbControlTransferParams.class */
public final class UsbControlTransferParams extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public int recipient;
    public byte request;
    public short value;
    public short index;

    private UsbControlTransferParams(int version) {
        super(24, version);
    }

    public UsbControlTransferParams() {
        this(0);
    }

    public static UsbControlTransferParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UsbControlTransferParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbControlTransferParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UsbControlTransferParams result = new UsbControlTransferParams(elementsOrVersion);
            result.type = decoder0.readInt(8);
            UsbControlTransferType.validate(result.type);
            result.recipient = decoder0.readInt(12);
            UsbControlTransferRecipient.validate(result.recipient);
            result.request = decoder0.readByte(16);
            result.value = decoder0.readShort(18);
            result.index = decoder0.readShort(20);
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
        encoder0.encode(this.type, 8);
        encoder0.encode(this.recipient, 12);
        encoder0.encode(this.request, 16);
        encoder0.encode(this.value, 18);
        encoder0.encode(this.index, 20);
    }
}
