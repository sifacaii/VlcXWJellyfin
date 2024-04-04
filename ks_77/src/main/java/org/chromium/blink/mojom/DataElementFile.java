package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DataElementFile.class */
public final class DataElementFile extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public FilePath path;
    public long offset;
    public long length;
    public Time expectedModificationTime;

    private DataElementFile(int version) {
        super(40, version);
    }

    public DataElementFile() {
        this(0);
    }

    public static DataElementFile deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DataElementFile deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DataElementFile decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DataElementFile result = new DataElementFile(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.path = FilePath.decode(decoder1);
            result.offset = decoder0.readLong(16);
            result.length = decoder0.readLong(24);
            Decoder decoder12 = decoder0.readPointer(32, true);
            result.expectedModificationTime = Time.decode(decoder12);
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
        encoder0.encode((Struct) this.path, 8, false);
        encoder0.encode(this.offset, 16);
        encoder0.encode(this.length, 24);
        encoder0.encode((Struct) this.expectedModificationTime, 32, true);
    }
}
