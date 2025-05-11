package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/Value.class */
public final class Value extends Union {
    private byte mNullValue;
    private boolean mBoolValue;
    private int mIntValue;
    private double mDoubleValue;
    private String mStringValue;
    private byte[] mBinaryValue;
    private DictionaryValue mDictionaryValue;
    private ListValue mListValue;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/Value$Tag.class */
    public static final class Tag {
        public static final int NullValue = 0;
        public static final int BoolValue = 1;
        public static final int IntValue = 2;
        public static final int DoubleValue = 3;
        public static final int StringValue = 4;
        public static final int BinaryValue = 5;
        public static final int DictionaryValue = 6;
        public static final int ListValue = 7;
    }

    static {
        $assertionsDisabled = !Value.class.desiredAssertionStatus();
    }

    public void setNullValue(byte nullValue) {
        this.mTag = 0;
        this.mNullValue = nullValue;
    }

    public byte getNullValue() {
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

    public void setIntValue(int intValue) {
        this.mTag = 2;
        this.mIntValue = intValue;
    }

    public int getIntValue() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mIntValue;
        }
        throw new AssertionError();
    }

    public void setDoubleValue(double doubleValue) {
        this.mTag = 3;
        this.mDoubleValue = doubleValue;
    }

    public double getDoubleValue() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mDoubleValue;
        }
        throw new AssertionError();
    }

    public void setStringValue(String stringValue) {
        this.mTag = 4;
        this.mStringValue = stringValue;
    }

    public String getStringValue() {
        if ($assertionsDisabled || this.mTag == 4) {
            return this.mStringValue;
        }
        throw new AssertionError();
    }

    public void setBinaryValue(byte[] binaryValue) {
        this.mTag = 5;
        this.mBinaryValue = binaryValue;
    }

    public byte[] getBinaryValue() {
        if ($assertionsDisabled || this.mTag == 5) {
            return this.mBinaryValue;
        }
        throw new AssertionError();
    }

    public void setDictionaryValue(DictionaryValue dictionaryValue) {
        this.mTag = 6;
        this.mDictionaryValue = dictionaryValue;
    }

    public DictionaryValue getDictionaryValue() {
        if ($assertionsDisabled || this.mTag == 6) {
            return this.mDictionaryValue;
        }
        throw new AssertionError();
    }

    public void setListValue(ListValue listValue) {
        this.mTag = 7;
        this.mListValue = listValue;
    }

    public ListValue getListValue() {
        if ($assertionsDisabled || this.mTag == 7) {
            return this.mListValue;
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
                encoder0.encode(this.mNullValue, offset + 8);
                return;
            case 1:
                encoder0.encode(this.mBoolValue, offset + 8, 0);
                return;
            case 2:
                encoder0.encode(this.mIntValue, offset + 8);
                return;
            case 3:
                encoder0.encode(this.mDoubleValue, offset + 8);
                return;
            case 4:
                encoder0.encode(this.mStringValue, offset + 8, false);
                return;
            case 5:
                encoder0.encode(this.mBinaryValue, offset + 8, 0, -1);
                return;
            case 6:
                encoder0.encode((Struct) this.mDictionaryValue, offset + 8, false);
                return;
            case 7:
                encoder0.encode((Struct) this.mListValue, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static Value deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final Value decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        Value result = new Value();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mNullValue = decoder0.readByte(offset + 8);
                result.mTag = 0;
                break;
            case 1:
                result.mBoolValue = decoder0.readBoolean(offset + 8, 0);
                result.mTag = 1;
                break;
            case 2:
                result.mIntValue = decoder0.readInt(offset + 8);
                result.mTag = 2;
                break;
            case 3:
                result.mDoubleValue = decoder0.readDouble(offset + 8);
                result.mTag = 3;
                break;
            case 4:
                result.mStringValue = decoder0.readString(offset + 8, false);
                result.mTag = 4;
                break;
            case 5:
                result.mBinaryValue = decoder0.readBytes(offset + 8, 0, -1);
                result.mTag = 5;
                break;
            case 6:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mDictionaryValue = DictionaryValue.decode(decoder1);
                result.mTag = 6;
                break;
            case 7:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mListValue = ListValue.decode(decoder12);
                result.mTag = 7;
                break;
        }
        return result;
    }
}
