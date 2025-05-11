package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindOptions.class */
public final class FindOptions extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean forward;
    public boolean matchCase;
    public boolean findNext;
    public boolean force;
    public boolean runSynchronouslyForTesting;

    private FindOptions(int version) {
        super(16, version);
        this.forward = true;
        this.matchCase = false;
        this.findNext = false;
        this.force = false;
        this.runSynchronouslyForTesting = false;
    }

    public FindOptions() {
        this(0);
    }

    public static FindOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FindOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FindOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FindOptions result = new FindOptions(elementsOrVersion);
            result.forward = decoder0.readBoolean(8, 0);
            result.matchCase = decoder0.readBoolean(8, 1);
            result.findNext = decoder0.readBoolean(8, 2);
            result.force = decoder0.readBoolean(8, 3);
            result.runSynchronouslyForTesting = decoder0.readBoolean(8, 4);
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
        encoder0.encode(this.forward, 8, 0);
        encoder0.encode(this.matchCase, 8, 1);
        encoder0.encode(this.findNext, 8, 2);
        encoder0.encode(this.force, 8, 3);
        encoder0.encode(this.runSynchronouslyForTesting, 8, 4);
    }
}
