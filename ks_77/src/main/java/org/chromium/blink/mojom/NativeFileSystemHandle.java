package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class NativeFileSystemHandle extends Union {
    private NativeFileSystemFileHandle mFile;

    private NativeFileSystemDirectoryHandle mDirectory;

    public static final class Tag {
        public static final int File = 0;

        public static final int Directory = 1;
    }

    public void setFile(NativeFileSystemFileHandle file) {
        this.mTag = 0;
        this.mFile = file;
    }

    public NativeFileSystemFileHandle getFile() {
        assert this.mTag == 0;
        return this.mFile;
    }

    public void setDirectory(NativeFileSystemDirectoryHandle directory) {
        this.mTag = 1;
        this.mDirectory = directory;
    }

    public NativeFileSystemDirectoryHandle getDirectory() {
        assert this.mTag == 1;
        return this.mDirectory;
    }

    public final void encode(Encoder encoder0, int offset) {
        encoder0.encode(16, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (this.mTag) {
            case 0:
                encoder0.encode(this.mFile, offset + 8, false, NativeFileSystemFileHandle.MANAGER);
                break;
            case 1:
                encoder0.encode(this.mDirectory, offset + 8, false, NativeFileSystemDirectoryHandle.MANAGER);
                break;
        }
    }

    public static NativeFileSystemHandle deserialize(Message message) {
        return decode((new Decoder(message)).decoderForSerializedUnion(), 0);
    }

    public static final NativeFileSystemHandle decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0)
            return null;
        NativeFileSystemHandle result = new NativeFileSystemHandle();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mFile = (NativeFileSystemFileHandle)decoder0.readServiceInterface(offset + 8, false, NativeFileSystemFileHandle.MANAGER);
                result.mTag = 0;
                break;
            case 1:
                result.mDirectory = (NativeFileSystemDirectoryHandle)decoder0.readServiceInterface(offset + 8, false, NativeFileSystemDirectoryHandle.MANAGER);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
