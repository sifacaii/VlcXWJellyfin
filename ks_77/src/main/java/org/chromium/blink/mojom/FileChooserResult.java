package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.FilePath;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooserResult.class */
public final class FileChooserResult extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public FileChooserFileInfo[] files;
    public FilePath baseDirectory;

    private FileChooserResult(int version) {
        super(24, version);
    }

    public FileChooserResult() {
        this(0);
    }

    public static FileChooserResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FileChooserResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FileChooserResult decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FileChooserResult result = new FileChooserResult(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.files = new FileChooserFileInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.files[i1] = FileChooserFileInfo.decode(decoder1, 8 + (16 * i1));
            }
            result.baseDirectory = FilePath.decode(decoder0.readPointer(16, false));
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
        if (this.files == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodeUnionArray(this.files.length, 8, -1);
            for (int i0 = 0; i0 < this.files.length; i0++) {
                encoder1.encode((Union) this.files[i0], 8 + (16 * i0), false);
            }
        }
        encoder0.encode((Struct) this.baseDirectory, 16, false);
    }
}
