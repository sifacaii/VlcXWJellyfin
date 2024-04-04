package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NativeFileSystemEntry.class */
public final class NativeFileSystemEntry extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public NativeFileSystemHandle entryHandle;
    public String name;

    private NativeFileSystemEntry(int version) {
        super(32, version);
    }

    public NativeFileSystemEntry() {
        this(0);
    }

    public static NativeFileSystemEntry deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NativeFileSystemEntry deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NativeFileSystemEntry decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NativeFileSystemEntry result = new NativeFileSystemEntry(elementsOrVersion);
            result.entryHandle = NativeFileSystemHandle.decode(decoder0, 8);
            result.name = decoder0.readString(24, false);
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
        encoder0.encode((Union) this.entryHandle, 8, false);
        encoder0.encode(this.name, 24, false);
    }
}
