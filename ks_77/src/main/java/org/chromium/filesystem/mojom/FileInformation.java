package org.chromium.filesystem.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileInformation.class */
public final class FileInformation extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public long size;
    public double atime;
    public double mtime;
    public double ctime;

    private FileInformation(int version) {
        super(48, version);
    }

    public FileInformation() {
        this(0);
    }

    public static FileInformation deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FileInformation deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FileInformation decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FileInformation result = new FileInformation(elementsOrVersion);
            result.type = decoder0.readInt(8);
            FsFileType.validate(result.type);
            result.size = decoder0.readLong(16);
            result.atime = decoder0.readDouble(24);
            result.mtime = decoder0.readDouble(32);
            result.ctime = decoder0.readDouble(40);
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
        encoder0.encode(this.size, 16);
        encoder0.encode(this.atime, 24);
        encoder0.encode(this.mtime, 32);
        encoder0.encode(this.ctime, 40);
    }
}
