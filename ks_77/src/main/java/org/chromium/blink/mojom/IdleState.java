package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/IdleState.class */
public final class IdleState extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int user;
    public int screen;

    private IdleState(int version) {
        super(16, version);
    }

    public IdleState() {
        this(0);
    }

    public static IdleState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static IdleState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static IdleState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            IdleState result = new IdleState(elementsOrVersion);
            result.user = decoder0.readInt(8);
            UserIdleState.validate(result.user);
            result.screen = decoder0.readInt(12);
            ScreenIdleState.validate(result.screen);
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
        encoder0.encode(this.user, 8);
        encoder0.encode(this.screen, 12);
    }
}
