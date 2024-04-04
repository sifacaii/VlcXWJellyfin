package org.chromium.blink.mojom;

import org.chromium.device.mojom.HidUsageAndPage;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UsageFilter.class */
public final class UsageFilter extends Union {
    private short mPage;
    private HidUsageAndPage mUsageAndPage;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/UsageFilter$Tag.class */
    public static final class Tag {
        public static final int Page = 0;
        public static final int UsageAndPage = 1;
    }

    static {
        $assertionsDisabled = !UsageFilter.class.desiredAssertionStatus();
    }

    public void setPage(short page) {
        this.mTag = 0;
        this.mPage = page;
    }

    public short getPage() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mPage;
        }
        throw new AssertionError();
    }

    public void setUsageAndPage(HidUsageAndPage usageAndPage) {
        this.mTag = 1;
        this.mUsageAndPage = usageAndPage;
    }

    public HidUsageAndPage getUsageAndPage() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mUsageAndPage;
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
                encoder0.encode(this.mPage, offset + 8);
                return;
            case 1:
                encoder0.encode((Struct) this.mUsageAndPage, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static UsageFilter deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final UsageFilter decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        UsageFilter result = new UsageFilter();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mPage = decoder0.readShort(offset + 8);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mUsageAndPage = HidUsageAndPage.decode(decoder1);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
