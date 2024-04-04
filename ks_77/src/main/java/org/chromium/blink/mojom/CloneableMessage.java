package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CloneableMessage.class */
public final class CloneableMessage extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public BigBuffer encodedMessage;
    public SerializedBlob[] blobs;
    public long stackTraceId;
    public long stackTraceDebuggerIdFirst;
    public long stackTraceDebuggerIdSecond;
    public UnguessableToken lockedAgentClusterId;

    private CloneableMessage(int version) {
        super(64, version);
    }

    public CloneableMessage() {
        this(0);
    }

    public static CloneableMessage deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CloneableMessage deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CloneableMessage decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CloneableMessage result = new CloneableMessage(elementsOrVersion);
            result.encodedMessage = BigBuffer.decode(decoder0, 8);
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.blobs = new SerializedBlob[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.blobs[i1] = SerializedBlob.decode(decoder2);
            }
            result.stackTraceId = decoder0.readLong(32);
            result.stackTraceDebuggerIdFirst = decoder0.readLong(40);
            result.stackTraceDebuggerIdSecond = decoder0.readLong(48);
            result.lockedAgentClusterId = UnguessableToken.decode(decoder0.readPointer(56, true));
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
        encoder0.encode((Union) this.encodedMessage, 8, false);
        if (this.blobs == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.blobs.length, 24, -1);
            for (int i0 = 0; i0 < this.blobs.length; i0++) {
                encoder1.encode((Struct) this.blobs[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.stackTraceId, 32);
        encoder0.encode(this.stackTraceDebuggerIdFirst, 40);
        encoder0.encode(this.stackTraceDebuggerIdSecond, 48);
        encoder0.encode((Struct) this.lockedAgentClusterId, 56, true);
    }
}
