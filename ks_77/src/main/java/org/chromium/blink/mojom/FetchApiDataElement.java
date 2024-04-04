//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.network.mojom.ChunkedDataPipeGetter;
import org.chromium.network.mojom.DataElementType;
import org.chromium.network.mojom.DataPipeGetter;

public final class FetchApiDataElement extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO;
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

    private FetchApiDataElement(int version) {
        super(88, version);
    }

    public FetchApiDataElement() {
        this(0);
    }

    public static FetchApiDataElement deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FetchApiDataElement deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FetchApiDataElement decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        } else {
            decoder0.increaseStackDepth();

            FetchApiDataElement result;
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FetchApiDataElement(elementsOrVersion);
                result.type = decoder0.readInt(8);
                DataElementType.validate(result.type);
                result.buf = decoder0.readBytes(16, 0, -1);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.path = FilePath.decode(decoder1);
                decoder1 = decoder0.readPointer(32, true);
                result.file = File.decode(decoder1);
                result.blobUuid = decoder0.readString(40, true);
                result.dataPipeGetter = (DataPipeGetter)decoder0.readServiceInterface(48, true, DataPipeGetter.MANAGER);
                result.chunkedDataPipeGetter = (ChunkedDataPipeGetter)decoder0.readServiceInterface(56, true, ChunkedDataPipeGetter.MANAGER);
                result.offset = decoder0.readLong(64);
                result.length = decoder0.readLong(72);
                decoder1 = decoder0.readPointer(80, false);
                result.expectedModificationTime = Time.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }

            return result;
        }
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.type, 8);
        encoder0.encode(this.buf, 16, 0, -1);
        encoder0.encode(this.path, 24, false);
        encoder0.encode(this.file, 32, true);
        encoder0.encode(this.blobUuid, 40, true);
        encoder0.encode(this.dataPipeGetter, 48, true, DataPipeGetter.MANAGER);
        encoder0.encode(this.chunkedDataPipeGetter, 56, true, ChunkedDataPipeGetter.MANAGER);
        encoder0.encode(this.offset, 64);
        encoder0.encode(this.length, 72);
        encoder0.encode(this.expectedModificationTime, 80, false);
    }

    static {
        DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    }
}
