package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/interfacecontrol/RunOrClosePipeInput.class */
public final class RunOrClosePipeInput extends Union {
    private RequireVersion mRequireVersion;
    private EnableIdleTracking mEnableIdleTracking;
    private MessageAck mMessageAck;
    private NotifyIdle mNotifyIdle;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/interfacecontrol/RunOrClosePipeInput$Tag.class */
    public static final class Tag {
        public static final int RequireVersion = 0;
        public static final int EnableIdleTracking = 1;
        public static final int MessageAck = 2;
        public static final int NotifyIdle = 3;
    }

    static {
        $assertionsDisabled = !RunOrClosePipeInput.class.desiredAssertionStatus();
    }

    public void setRequireVersion(RequireVersion requireVersion) {
        this.mTag = 0;
        this.mRequireVersion = requireVersion;
    }

    public RequireVersion getRequireVersion() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mRequireVersion;
        }
        throw new AssertionError();
    }

    public void setEnableIdleTracking(EnableIdleTracking enableIdleTracking) {
        this.mTag = 1;
        this.mEnableIdleTracking = enableIdleTracking;
    }

    public EnableIdleTracking getEnableIdleTracking() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mEnableIdleTracking;
        }
        throw new AssertionError();
    }

    public void setMessageAck(MessageAck messageAck) {
        this.mTag = 2;
        this.mMessageAck = messageAck;
    }

    public MessageAck getMessageAck() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mMessageAck;
        }
        throw new AssertionError();
    }

    public void setNotifyIdle(NotifyIdle notifyIdle) {
        this.mTag = 3;
        this.mNotifyIdle = notifyIdle;
    }

    public NotifyIdle getNotifyIdle() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mNotifyIdle;
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
                encoder0.encode((Struct) this.mRequireVersion, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mEnableIdleTracking, offset + 8, false);
                return;
            case 2:
                encoder0.encode((Struct) this.mMessageAck, offset + 8, false);
                return;
            case 3:
                encoder0.encode((Struct) this.mNotifyIdle, offset + 8, false);
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
                result.mRequireVersion = RequireVersion.decode(decoder1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mEnableIdleTracking = EnableIdleTracking.decode(decoder12);
                result.mTag = 1;
                break;
            case 2:
                Decoder decoder13 = decoder0.readPointer(offset + 8, false);
                result.mMessageAck = MessageAck.decode(decoder13);
                result.mTag = 2;
                break;
            case 3:
                Decoder decoder14 = decoder0.readPointer(offset + 8, false);
                result.mNotifyIdle = NotifyIdle.decode(decoder14);
                result.mTag = 3;
                break;
        }
        return result;
    }
}
