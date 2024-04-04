package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DataElement.class */
public final class DataElement extends Union {
    private DataElementBytes mBytes;
    private DataElementFile mFile;
    private DataElementFilesystemUrl mFileFilesystem;
    private DataElementBlob mBlob;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DataElement$Tag.class */
    public static final class Tag {
        public static final int Bytes = 0;
        public static final int File = 1;
        public static final int FileFilesystem = 2;
        public static final int Blob = 3;
    }

    static {
        $assertionsDisabled = !DataElement.class.desiredAssertionStatus();
    }

    public void setBytes(DataElementBytes bytes) {
        this.mTag = 0;
        this.mBytes = bytes;
    }

    public DataElementBytes getBytes() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mBytes;
        }
        throw new AssertionError();
    }

    public void setFile(DataElementFile file) {
        this.mTag = 1;
        this.mFile = file;
    }

    public DataElementFile getFile() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mFile;
        }
        throw new AssertionError();
    }

    public void setFileFilesystem(DataElementFilesystemUrl fileFilesystem) {
        this.mTag = 2;
        this.mFileFilesystem = fileFilesystem;
    }

    public DataElementFilesystemUrl getFileFilesystem() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mFileFilesystem;
        }
        throw new AssertionError();
    }

    public void setBlob(DataElementBlob blob) {
        this.mTag = 3;
        this.mBlob = blob;
    }

    public DataElementBlob getBlob() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mBlob;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Union
    public final void encode(Encoder encoder0, int offset) {
        encoder0.encode(16, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (this.mTag) {
            case 0:
                encoder0.encode((Struct) this.mBytes, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mFile, offset + 8, false);
                return;
            case 2:
                encoder0.encode((Struct) this.mFileFilesystem, offset + 8, false);
                return;
            case 3:
                encoder0.encode((Struct) this.mBlob, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static DataElement deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final DataElement decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        DataElement result = new DataElement();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mBytes = DataElementBytes.decode(decoder1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mFile = DataElementFile.decode(decoder12);
                result.mTag = 1;
                break;
            case 2:
                Decoder decoder13 = decoder0.readPointer(offset + 8, false);
                result.mFileFilesystem = DataElementFilesystemUrl.decode(decoder13);
                result.mTag = 2;
                break;
            case 3:
                Decoder decoder14 = decoder0.readPointer(offset + 8, false);
                result.mBlob = DataElementBlob.decode(decoder14);
                result.mTag = 3;
                break;
        }
        return result;
    }
}
