package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionActionDetails.class */
public final class MediaSessionActionDetails extends Union {
    private MediaSessionSeekToDetails mSeekTo;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionActionDetails$Tag.class */
    public static final class Tag {
        public static final int SeekTo = 0;
    }

    static {
        $assertionsDisabled = !MediaSessionActionDetails.class.desiredAssertionStatus();
    }

    public void setSeekTo(MediaSessionSeekToDetails seekTo) {
        this.mTag = 0;
        this.mSeekTo = seekTo;
    }

    public MediaSessionSeekToDetails getSeekTo() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mSeekTo;
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
                encoder0.encode((Struct) this.mSeekTo, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static MediaSessionActionDetails deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final MediaSessionActionDetails decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        MediaSessionActionDetails result = new MediaSessionActionDetails();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mSeekTo = MediaSessionSeekToDetails.decode(decoder1);
                result.mTag = 0;
                break;
        }
        return result;
    }
}
