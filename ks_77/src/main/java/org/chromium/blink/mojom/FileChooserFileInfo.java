package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooserFileInfo.class */
public final class FileChooserFileInfo extends Union {
    private NativeFileInfo mNativeFile;
    private FileSystemFileInfo mFileSystem;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FileChooserFileInfo$Tag.class */
    public static final class Tag {
        public static final int NativeFile = 0;
        public static final int FileSystem = 1;
    }

    static {
        $assertionsDisabled = !FileChooserFileInfo.class.desiredAssertionStatus();
    }

    public void setNativeFile(NativeFileInfo nativeFile) {
        this.mTag = 0;
        this.mNativeFile = nativeFile;
    }

    public NativeFileInfo getNativeFile() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mNativeFile;
        }
        throw new AssertionError();
    }

    public void setFileSystem(FileSystemFileInfo fileSystem) {
        this.mTag = 1;
        this.mFileSystem = fileSystem;
    }

    public FileSystemFileInfo getFileSystem() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mFileSystem;
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
                encoder0.encode((Struct) this.mNativeFile, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mFileSystem, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static FileChooserFileInfo deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final FileChooserFileInfo decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        FileChooserFileInfo result = new FileChooserFileInfo();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mNativeFile = NativeFileInfo.decode(decoder1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mFileSystem = FileSystemFileInfo.decode(decoder12);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
