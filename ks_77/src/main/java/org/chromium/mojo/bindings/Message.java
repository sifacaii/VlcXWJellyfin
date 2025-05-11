package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.util.List;
import org.chromium.mojo.system.Handle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/Message.class */
public class Message {
    private final ByteBuffer mBuffer;
    private final List<? extends Handle> mHandles;
    private ServiceMessage mWithHeader;

    public Message(ByteBuffer buffer, List<? extends Handle> handles) {
        this.mBuffer = buffer;
        this.mHandles = handles;
    }

    public ByteBuffer getData() {
        return this.mBuffer;
    }

    public List<? extends Handle> getHandles() {
        return this.mHandles;
    }

    public ServiceMessage asServiceMessage() {
        if (this.mWithHeader == null) {
            this.mWithHeader = new ServiceMessage(this);
        }
        return this.mWithHeader;
    }
}
