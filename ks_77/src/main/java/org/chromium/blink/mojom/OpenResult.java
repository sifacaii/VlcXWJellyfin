package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OpenResult.class */
public final class OpenResult extends Union {
    private int mStatus;
    private AssociatedInterfaceNotSupported mCache;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OpenResult$Tag.class */
    public static final class Tag {
        public static final int Status = 0;
        public static final int Cache = 1;
    }

    static {
        $assertionsDisabled = !OpenResult.class.desiredAssertionStatus();
    }

    public void setStatus(int status) {
        this.mTag = 0;
        this.mStatus = status;
    }

    public int getStatus() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mStatus;
        }
        throw new AssertionError();
    }

    public void setCache(AssociatedInterfaceNotSupported cache) {
        this.mTag = 1;
        this.mCache = cache;
    }

    public AssociatedInterfaceNotSupported getCache() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mCache;
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
                encoder0.encode(this.mStatus, offset + 8);
                return;
            case 1:
                encoder0.encode(this.mCache, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static OpenResult deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final OpenResult decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        OpenResult result = new OpenResult();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mStatus = decoder0.readInt(offset + 8);
                CacheStorageError.validate(result.mStatus);
                result.mTag = 0;
                break;
            case 1:
                result.mCache = decoder0.readAssociatedServiceInterfaceNotSupported(offset + 8, false);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
