package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheKeysResult.class */
public final class CacheKeysResult extends Union {
    private int mStatus;
    private FetchApiRequest[] mKeys;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheKeysResult$Tag.class */
    public static final class Tag {
        public static final int Status = 0;
        public static final int Keys = 1;
    }

    static {
        $assertionsDisabled = !CacheKeysResult.class.desiredAssertionStatus();
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

    public void setKeys(FetchApiRequest[] keys) {
        this.mTag = 1;
        this.mKeys = keys;
    }

    public FetchApiRequest[] getKeys() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mKeys;
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
                if (this.mKeys == null) {
                    encoder0.encodeNullPointer(offset + 8, false);
                    return;
                }
                Encoder encoder1 = encoder0.encodePointerArray(this.mKeys.length, offset + 8, -1);
                for (int i0 = 0; i0 < this.mKeys.length; i0++) {
                    encoder1.encode((Struct) this.mKeys[i0], 8 + (8 * i0), false);
                }
                return;
            default:
                return;
        }
    }

    public static CacheKeysResult deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final CacheKeysResult decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        CacheKeysResult result = new CacheKeysResult();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mStatus = decoder0.readInt(offset + 8);
                CacheStorageError.validate(result.mStatus);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.mKeys = new FetchApiRequest[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.mKeys[i1] = FetchApiRequest.decode(decoder2);
                }
                result.mTag = 1;
                break;
        }
        return result;
    }
}
