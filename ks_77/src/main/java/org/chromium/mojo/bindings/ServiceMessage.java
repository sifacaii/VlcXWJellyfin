package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ServiceMessage.class */
public class ServiceMessage extends Message {
    private final MessageHeader mHeader;
    private Message mPayload;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ServiceMessage.class.desiredAssertionStatus();
    }

    public ServiceMessage(Message baseMessage, MessageHeader header) {
        super(baseMessage.getData(), baseMessage.getHandles());
        if (!$assertionsDisabled && !header.equals(new MessageHeader(baseMessage))) {
            throw new AssertionError();
        }
        this.mHeader = header;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceMessage(Message baseMessage) {
        this(baseMessage, new MessageHeader(baseMessage));
    }

    @Override // org.chromium.mojo.bindings.Message
    public ServiceMessage asServiceMessage() {
        return this;
    }

    public MessageHeader getHeader() {
        return this.mHeader;
    }

    public Message getPayload() {
        if (this.mPayload == null) {
            ByteBuffer truncatedBuffer = ((ByteBuffer) getData().position(getHeader().getSize())).slice();
            truncatedBuffer.order(ByteOrder.LITTLE_ENDIAN);
            this.mPayload = new Message(truncatedBuffer, getHandles());
        }
        return this.mPayload;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRequestId(long requestId) {
        this.mHeader.setRequestId(getData(), requestId);
    }
}
