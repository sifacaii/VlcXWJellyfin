package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/interfacecontrol/RunInput.class */
public final class RunInput extends Union {
    private QueryVersion mQueryVersion;
    private FlushForTesting mFlushForTesting;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/interfacecontrol/RunInput$Tag.class */
    public static final class Tag {
        public static final int QueryVersion = 0;
        public static final int FlushForTesting = 1;
    }

    static {
        $assertionsDisabled = !RunInput.class.desiredAssertionStatus();
    }

    public void setQueryVersion(QueryVersion queryVersion) {
        this.mTag = 0;
        this.mQueryVersion = queryVersion;
    }

    public QueryVersion getQueryVersion() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mQueryVersion;
        }
        throw new AssertionError();
    }

    public void setFlushForTesting(FlushForTesting flushForTesting) {
        this.mTag = 1;
        this.mFlushForTesting = flushForTesting;
    }

    public FlushForTesting getFlushForTesting() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mFlushForTesting;
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
                encoder0.encode((Struct) this.mQueryVersion, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mFlushForTesting, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static RunInput deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final RunInput decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        RunInput result = new RunInput();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mQueryVersion = QueryVersion.decode(decoder1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mFlushForTesting = FlushForTesting.decode(decoder12);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
