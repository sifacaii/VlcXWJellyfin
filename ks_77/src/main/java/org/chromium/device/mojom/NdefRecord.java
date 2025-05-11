package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NdefRecord.class */
public final class NdefRecord extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int recordType;
    public String mediaType;
    public byte[] data;

    private NdefRecord(int version) {
        super(32, version);
    }

    public NdefRecord() {
        this(0);
    }

    public static NdefRecord deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NdefRecord deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NdefRecord decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NdefRecord result = new NdefRecord(elementsOrVersion);
            result.recordType = decoder0.readInt(8);
            NdefRecordType.validate(result.recordType);
            result.mediaType = decoder0.readString(16, true);
            result.data = decoder0.readBytes(24, 0, -1);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.recordType, 8);
        encoder0.encode(this.mediaType, 16, true);
        encoder0.encode(this.data, 24, 0, -1);
    }
}
