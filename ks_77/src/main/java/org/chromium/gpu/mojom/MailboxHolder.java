package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/MailboxHolder.class */
public final class MailboxHolder extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Mailbox mailbox;
    public SyncToken syncToken;
    public int textureTarget;

    private MailboxHolder(int version) {
        super(32, version);
    }

    public MailboxHolder() {
        this(0);
    }

    public static MailboxHolder deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MailboxHolder deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MailboxHolder decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MailboxHolder result = new MailboxHolder(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.mailbox = Mailbox.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.syncToken = SyncToken.decode(decoder12);
            result.textureTarget = decoder0.readInt(24);
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
        encoder0.encode((Struct) this.mailbox, 8, false);
        encoder0.encode((Struct) this.syncToken, 16, false);
        encoder0.encode(this.textureTarget, 24);
    }
}
