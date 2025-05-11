package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataElement.class */
public final class DataElement extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public byte[] buf;
    public FilePath path;
    public File file;
    public String blobUuid;
    public DataPipeGetter dataPipeGetter;
    public ChunkedDataPipeGetter chunkedDataPipeGetter;
    public long offset;
    public long length;
    public Time expectedModificationTime;

    private DataElement(int version) {
        super(88, version);
    }

    public DataElement() {
        this(0);
    }

    public static DataElement deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DataElement deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DataElement decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DataElement result = new DataElement(elementsOrVersion);
            result.type = decoder0.readInt(8);
            DataElementType.validate(result.type);
            result.buf = decoder0.readBytes(16, 0, -1);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.path = FilePath.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, true);
            result.file = File.decode(decoder12);
            result.blobUuid = decoder0.readString(40, true);
            result.dataPipeGetter = (DataPipeGetter) decoder0.readServiceInterface(48, true, DataPipeGetter.MANAGER);
            result.chunkedDataPipeGetter = (ChunkedDataPipeGetter) decoder0.readServiceInterface(56, true, ChunkedDataPipeGetter.MANAGER);
            result.offset = decoder0.readLong(64);
            result.length = decoder0.readLong(72);
            Decoder decoder13 = decoder0.readPointer(80, false);
            result.expectedModificationTime = Time.decode(decoder13);
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
        encoder0.encode(this.buf, 16, 0, -1);
        encoder0.encode((Struct) this.path, 24, false);
        encoder0.encode((Struct) this.file, 32, true);
        encoder0.encode(this.blobUuid, 40, true);
        encoder0.encode(this.dataPipeGetter,48,true, DataPipeGetter.MANAGER);
        encoder0.encode(this.chunkedDataPipeGetter,56,true, ChunkedDataPipeGetter.MANAGER);
        encoder0.encode(this.offset, 64);
        encoder0.encode(this.length, 72);
        encoder0.encode((Struct) this.expectedModificationTime, 80, false);
    }
}
