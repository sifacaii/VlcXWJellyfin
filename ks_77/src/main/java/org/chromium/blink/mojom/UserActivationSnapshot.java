package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UserActivationSnapshot.class */
public final class UserActivationSnapshot extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean hasBeenActive;
    public boolean wasActive;

    private UserActivationSnapshot(int version) {
        super(16, version);
    }

    public UserActivationSnapshot() {
        this(0);
    }

    public static UserActivationSnapshot deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UserActivationSnapshot deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UserActivationSnapshot decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UserActivationSnapshot result = new UserActivationSnapshot(elementsOrVersion);
            result.hasBeenActive = decoder0.readBoolean(8, 0);
            result.wasActive = decoder0.readBoolean(8, 1);
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
        encoder0.encode(this.hasBeenActive, 8, 0);
        encoder0.encode(this.wasActive, 8, 1);
    }
}
