package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPortInfo.class */
public final class SerialPortInfo extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public UnguessableToken token;
    public FilePath path;
    public short vendorId;
    public boolean hasVendorId;
    public short productId;
    public boolean hasProductId;
    public String displayName;

    private SerialPortInfo(int version) {
        super(40, version);
        this.hasVendorId = false;
        this.hasProductId = false;
    }

    public SerialPortInfo() {
        this(0);
    }

    public static SerialPortInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SerialPortInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SerialPortInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SerialPortInfo result = new SerialPortInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.token = UnguessableToken.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.path = FilePath.decode(decoder12);
            result.vendorId = decoder0.readShort(24);
            result.hasVendorId = decoder0.readBoolean(26, 0);
            result.hasProductId = decoder0.readBoolean(26, 1);
            result.productId = decoder0.readShort(28);
            result.displayName = decoder0.readString(32, true);
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
        encoder0.encode((Struct) this.token, 8, false);
        encoder0.encode((Struct) this.path, 16, false);
        encoder0.encode(this.vendorId, 24);
        encoder0.encode(this.hasVendorId, 26, 0);
        encoder0.encode(this.hasProductId, 26, 1);
        encoder0.encode(this.productId, 28);
        encoder0.encode(this.displayName, 32, true);
    }
}
