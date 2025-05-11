package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationConnectionMessage.class */
public final class PresentationConnectionMessage extends Union {
    private String mMessage;
    private byte[] mData;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationConnectionMessage$Tag.class */
    public static final class Tag {
        public static final int Message = 0;
        public static final int Data = 1;
    }

    static {
        $assertionsDisabled = !PresentationConnectionMessage.class.desiredAssertionStatus();
    }

    public void setMessage(String message) {
        this.mTag = 0;
        this.mMessage = message;
    }

    public String getMessage() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mMessage;
        }
        throw new AssertionError();
    }

    public void setData(byte[] data) {
        this.mTag = 1;
        this.mData = data;
    }

    public byte[] getData() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mData;
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
                encoder0.encode(this.mMessage, offset + 8, false);
                return;
            case 1:
                encoder0.encode(this.mData, offset + 8, 0, -1);
                return;
            default:
                return;
        }
    }

    public static PresentationConnectionMessage deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final PresentationConnectionMessage decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        PresentationConnectionMessage result = new PresentationConnectionMessage();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mMessage = decoder0.readString(offset + 8, false);
                result.mTag = 0;
                break;
            case 1:
                result.mData = decoder0.readBytes(offset + 8, 0, -1);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
