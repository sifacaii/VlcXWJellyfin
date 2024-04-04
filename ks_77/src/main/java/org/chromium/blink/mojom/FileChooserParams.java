package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooserParams.class */
public final class FileChooserParams extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int mode;
    public String16 title;
    public FilePath defaultFileName;
    public FilePath[] selectedFiles;
    public String16[] acceptTypes;
    public boolean needLocalPath;
    public boolean useMediaCapture;
    public Url requestor;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooserParams$Mode.class */
    public static final class Mode {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int OPEN = 0;
        public static final int OPEN_MULTIPLE = 1;
        public static final int UPLOAD_FOLDER = 2;
        public static final int SAVE = 3;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 3;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Mode() {
        }
    }

    private FileChooserParams(int version) {
        super(56, version);
        this.mode = 0;
        this.needLocalPath = true;
        this.useMediaCapture = false;
    }

    public FileChooserParams() {
        this(0);
    }

    public static FileChooserParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FileChooserParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FileChooserParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FileChooserParams result = new FileChooserParams(elementsOrVersion);
            result.mode = decoder0.readInt(8);
            Mode.validate(result.mode);
            result.needLocalPath = decoder0.readBoolean(12, 0);
            result.useMediaCapture = decoder0.readBoolean(12, 1);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.title = String16.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.defaultFileName = FilePath.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.selectedFiles = new FilePath[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.selectedFiles[i1] = FilePath.decode(decoder2);
            }
            Decoder decoder14 = decoder0.readPointer(40, false);
            DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
            result.acceptTypes = new String16[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder14.readPointer(8 + (8 * i12), false);
                result.acceptTypes[i12] = String16.decode(decoder22);
            }
            Decoder decoder15 = decoder0.readPointer(48, false);
            result.requestor = Url.decode(decoder15);
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
        encoder0.encode(this.mode, 8);
        encoder0.encode(this.needLocalPath, 12, 0);
        encoder0.encode(this.useMediaCapture, 12, 1);
        encoder0.encode((Struct) this.title, 16, false);
        encoder0.encode((Struct) this.defaultFileName, 24, false);
        if (this.selectedFiles == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.selectedFiles.length, 32, -1);
            for (int i0 = 0; i0 < this.selectedFiles.length; i0++) {
                encoder1.encode((Struct) this.selectedFiles[i0], 8 + (8 * i0), false);
            }
        }
        if (this.acceptTypes == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.acceptTypes.length, 40, -1);
            for (int i02 = 0; i02 < this.acceptTypes.length; i02++) {
                encoder12.encode((Struct) this.acceptTypes[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode((Struct) this.requestor, 48, false);
    }
}
