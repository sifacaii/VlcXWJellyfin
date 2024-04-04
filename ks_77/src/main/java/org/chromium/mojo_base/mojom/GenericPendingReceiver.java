package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/GenericPendingReceiver.class */
public final class GenericPendingReceiver extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String interfaceName;
    public MessagePipeHandle receivingPipe;

    private GenericPendingReceiver(int version) {
        super(24, version);
        this.receivingPipe = InvalidHandle.INSTANCE;
    }

    public GenericPendingReceiver() {
        this(0);
    }

    public static GenericPendingReceiver deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GenericPendingReceiver deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GenericPendingReceiver decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GenericPendingReceiver result = new GenericPendingReceiver(elementsOrVersion);
            result.interfaceName = decoder0.readString(8, false);
            result.receivingPipe = decoder0.readMessagePipeHandle(16, false);
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
        encoder0.encode(this.interfaceName, 8, false);
        encoder0.encode((Handle) this.receivingPipe, 16, false);
    }
}
