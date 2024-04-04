package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcReaderOptions.class */
public final class NfcReaderOptions extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String url;
    public NdefRecordTypeFilter recordFilter;
    public String mediaType;
    public int compatibility;

    private NfcReaderOptions(int version) {
        super(40, version);
    }

    public NfcReaderOptions() {
        this(0);
    }

    public static NfcReaderOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NfcReaderOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NfcReaderOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NfcReaderOptions result = new NfcReaderOptions(elementsOrVersion);
            result.url = decoder0.readString(8, true);
            Decoder decoder1 = decoder0.readPointer(16, true);
            result.recordFilter = NdefRecordTypeFilter.decode(decoder1);
            result.mediaType = decoder0.readString(24, true);
            result.compatibility = decoder0.readInt(32);
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
        encoder0.encode(this.url, 8, true);
        encoder0.encode((Struct) this.recordFilter, 16, true);
        encoder0.encode(this.mediaType, 24, true);
        encoder0.encode(this.compatibility, 32);
    }
}
