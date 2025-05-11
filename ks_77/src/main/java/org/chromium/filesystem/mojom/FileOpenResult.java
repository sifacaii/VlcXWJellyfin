package org.chromium.filesystem.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FileError;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileOpenResult.class */
public final class FileOpenResult extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String path;
    public int error;
    public org.chromium.mojo_base.mojom.File fileHandle;

    private FileOpenResult(int version) {
        super(32, version);
    }

    public FileOpenResult() {
        this(0);
    }

    public static FileOpenResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FileOpenResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FileOpenResult decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FileOpenResult result = new FileOpenResult(elementsOrVersion);
            result.path = decoder0.readString(8, false);
            result.error = decoder0.readInt(16);
            FileError.validate(result.error);
            Decoder decoder1 = decoder0.readPointer(24, true);
            result.fileHandle = org.chromium.mojo_base.mojom.File.decode(decoder1);
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
        encoder0.encode(this.path, 8, false);
        encoder0.encode(this.error, 16);
        encoder0.encode((Struct) this.fileHandle, 24, true);
    }
}
