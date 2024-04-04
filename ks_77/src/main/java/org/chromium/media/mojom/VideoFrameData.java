package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameData.class */
public final class VideoFrameData extends Union {
    private EosVideoFrameData mEosData;
    private SharedBufferVideoFrameData mSharedBufferData;
    private DmabufVideoFrameData mDmabufData;
    private MailboxVideoFrameData mMailboxData;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameData$Tag.class */
    public static final class Tag {
        public static final int EosData = 0;
        public static final int SharedBufferData = 1;
        public static final int DmabufData = 2;
        public static final int MailboxData = 3;
    }

    static {
        $assertionsDisabled = !VideoFrameData.class.desiredAssertionStatus();
    }

    public void setEosData(EosVideoFrameData eosData) {
        this.mTag = 0;
        this.mEosData = eosData;
    }

    public EosVideoFrameData getEosData() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mEosData;
        }
        throw new AssertionError();
    }

    public void setSharedBufferData(SharedBufferVideoFrameData sharedBufferData) {
        this.mTag = 1;
        this.mSharedBufferData = sharedBufferData;
    }

    public SharedBufferVideoFrameData getSharedBufferData() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mSharedBufferData;
        }
        throw new AssertionError();
    }

    public void setDmabufData(DmabufVideoFrameData dmabufData) {
        this.mTag = 2;
        this.mDmabufData = dmabufData;
    }

    public DmabufVideoFrameData getDmabufData() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mDmabufData;
        }
        throw new AssertionError();
    }

    public void setMailboxData(MailboxVideoFrameData mailboxData) {
        this.mTag = 3;
        this.mMailboxData = mailboxData;
    }

    public MailboxVideoFrameData getMailboxData() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mMailboxData;
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
                encoder0.encode((Struct) this.mEosData, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mSharedBufferData, offset + 8, false);
                return;
            case 2:
                encoder0.encode((Struct) this.mDmabufData, offset + 8, false);
                return;
            case 3:
                encoder0.encode((Struct) this.mMailboxData, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static VideoFrameData deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final VideoFrameData decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        VideoFrameData result = new VideoFrameData();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mEosData = EosVideoFrameData.decode(decoder1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mSharedBufferData = SharedBufferVideoFrameData.decode(decoder12);
                result.mTag = 1;
                break;
            case 2:
                Decoder decoder13 = decoder0.readPointer(offset + 8, false);
                result.mDmabufData = DmabufVideoFrameData.decode(decoder13);
                result.mTag = 2;
                break;
            case 3:
                Decoder decoder14 = decoder0.readPointer(offset + 8, false);
                result.mMailboxData = MailboxVideoFrameData.decode(decoder14);
                result.mTag = 3;
                break;
        }
        return result;
    }
}
