package org.chromium.mojo.bindings.pipecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/pipecontrol/RunOrClosePipeInput.class */
public final class RunOrClosePipeInput extends Union {
    private PeerAssociatedEndpointClosedEvent mPeerAssociatedEndpointClosedEvent;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/pipecontrol/RunOrClosePipeInput$Tag.class */
    public static final class Tag {
        public static final int PeerAssociatedEndpointClosedEvent = 0;
    }

    static {
        $assertionsDisabled = !RunOrClosePipeInput.class.desiredAssertionStatus();
    }

    public void setPeerAssociatedEndpointClosedEvent(PeerAssociatedEndpointClosedEvent peerAssociatedEndpointClosedEvent) {
        this.mTag = 0;
        this.mPeerAssociatedEndpointClosedEvent = peerAssociatedEndpointClosedEvent;
    }

    public PeerAssociatedEndpointClosedEvent getPeerAssociatedEndpointClosedEvent() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mPeerAssociatedEndpointClosedEvent;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Union
    public final void encode(Encoder encoder0, int offset) {
        encoder0.encode(16, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (this.mTag) {
            case 0:
                encoder0.encode((Struct) this.mPeerAssociatedEndpointClosedEvent, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static RunOrClosePipeInput deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final RunOrClosePipeInput decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        RunOrClosePipeInput result = new RunOrClosePipeInput();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mPeerAssociatedEndpointClosedEvent = PeerAssociatedEndpointClosedEvent.decode(decoder1);
                result.mTag = 0;
                break;
        }
        return result;
    }
}
