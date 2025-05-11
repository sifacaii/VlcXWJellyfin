package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.Core;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/Struct.class */
public abstract class Struct {
    private final int mEncodedBaseSize;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void encode(Encoder encoder);

    /* JADX INFO: Access modifiers changed from: protected */
    public Struct(int encodedBaseSize, int version) {
        this.mEncodedBaseSize = encodedBaseSize;
        this.mVersion = version;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public Message serialize(Core core) {
        Encoder encoder = new Encoder(core, this.mEncodedBaseSize);
        encode(encoder);
        return encoder.getMessage();
    }

    public ByteBuffer serialize() {
        Message message = serialize(null);
        if (!message.getHandles().isEmpty()) {
            throw new UnsupportedOperationException("Handles are discarded.");
        }
        return message.getData();
    }

    public ServiceMessage serializeWithHeader(Core core, MessageHeader header) {
        Encoder encoder = new Encoder(core, this.mEncodedBaseSize + header.getSize());
        header.encode(encoder);
        encode(encoder);
        return new ServiceMessage(encoder.getMessage(), header);
    }
}
