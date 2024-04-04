package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PolicyValueData.class */
public final class PolicyValueData extends Union {
    private boolean mNullValue;
    private boolean mBoolValue;
    private double mDecDoubleValue;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PolicyValueData$Tag.class */
    public static final class Tag {
        public static final int NullValue = 0;
        public static final int BoolValue = 1;
        public static final int DecDoubleValue = 2;
    }

    static {
        $assertionsDisabled = !PolicyValueData.class.desiredAssertionStatus();
    }

    public void setNullValue(boolean nullValue) {
        this.mTag = 0;
        this.mNullValue = nullValue;
    }

    public boolean getNullValue() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mNullValue;
        }
        throw new AssertionError();
    }

    public void setBoolValue(boolean boolValue) {
        this.mTag = 1;
        this.mBoolValue = boolValue;
    }

    public boolean getBoolValue() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mBoolValue;
        }
        throw new AssertionError();
    }

    public void setDecDoubleValue(double decDoubleValue) {
        this.mTag = 2;
        this.mDecDoubleValue = decDoubleValue;
    }

    public double getDecDoubleValue() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mDecDoubleValue;
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
                encoder0.encode(this.mNullValue, offset + 8, 0);
                return;
            case 1:
                encoder0.encode(this.mBoolValue, offset + 8, 0);
                return;
            case 2:
                encoder0.encode(this.mDecDoubleValue, offset + 8);
                return;
            default:
                return;
        }
    }

    public static PolicyValueData deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final PolicyValueData decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        PolicyValueData result = new PolicyValueData();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mNullValue = decoder0.readBoolean(offset + 8, 0);
                result.mTag = 0;
                break;
            case 1:
                result.mBoolValue = decoder0.readBoolean(offset + 8, 0);
                result.mTag = 1;
                break;
            case 2:
                result.mDecDoubleValue = decoder0.readDouble(offset + 8);
                result.mTag = 2;
                break;
        }
        return result;
    }
}
