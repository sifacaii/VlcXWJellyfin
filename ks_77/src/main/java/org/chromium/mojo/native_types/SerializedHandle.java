package org.chromium.mojo.native_types;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.UntypedHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/native_types/SerializedHandle.class */
public final class SerializedHandle extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public UntypedHandle theHandle;
    public int type;

    private SerializedHandle(int version) {
        super(16, version);
        this.theHandle = InvalidHandle.INSTANCE;
    }

    public SerializedHandle() {
        this(0);
    }

    public static SerializedHandle deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SerializedHandle deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SerializedHandle decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SerializedHandle result = new SerializedHandle(elementsOrVersion);
            result.theHandle = decoder0.readUntypedHandle(8, false);
            result.type = decoder0.readInt(12);
            SerializedHandleType.validate(result.type);
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
        encoder0.encode((Handle) this.theHandle, 8, false);
        encoder0.encode(this.type, 12);
    }
}
