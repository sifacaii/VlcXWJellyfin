package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/FileInfo.class */
public final class FileInfo extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long size;
    public boolean isDirectory;
    public boolean isSymbolicLink;
    public Time lastModified;
    public Time lastAccessed;
    public Time creationTime;

    private FileInfo(int version) {
        super(48, version);
    }

    public FileInfo() {
        this(0);
    }

    public static FileInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FileInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FileInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FileInfo result = new FileInfo(elementsOrVersion);
            result.size = decoder0.readLong(8);
            result.isDirectory = decoder0.readBoolean(16, 0);
            result.isSymbolicLink = decoder0.readBoolean(16, 1);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.lastModified = Time.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.lastAccessed = Time.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(40, false);
            result.creationTime = Time.decode(decoder13);
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
        encoder0.encode(this.size, 8);
        encoder0.encode(this.isDirectory, 16, 0);
        encoder0.encode(this.isSymbolicLink, 16, 1);
        encoder0.encode((Struct) this.lastModified, 24, false);
        encoder0.encode((Struct) this.lastAccessed, 32, false);
        encoder0.encode((Struct) this.creationTime, 40, false);
    }
}
