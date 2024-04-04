package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteInvocationArgument.class */
public final class RemoteInvocationArgument extends Union {
    private double mNumberValue;
    private boolean mBooleanValue;
    private String16 mStringValue;
    private int mSingletonValue;
    private RemoteInvocationArgument[] mArrayValue;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteInvocationArgument$Tag.class */
    public static final class Tag {
        public static final int NumberValue = 0;
        public static final int BooleanValue = 1;
        public static final int StringValue = 2;
        public static final int SingletonValue = 3;
        public static final int ArrayValue = 4;
    }

    static {
        $assertionsDisabled = !RemoteInvocationArgument.class.desiredAssertionStatus();
    }

    public void setNumberValue(double numberValue) {
        this.mTag = 0;
        this.mNumberValue = numberValue;
    }

    public double getNumberValue() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mNumberValue;
        }
        throw new AssertionError();
    }

    public void setBooleanValue(boolean booleanValue) {
        this.mTag = 1;
        this.mBooleanValue = booleanValue;
    }

    public boolean getBooleanValue() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mBooleanValue;
        }
        throw new AssertionError();
    }

    public void setStringValue(String16 stringValue) {
        this.mTag = 2;
        this.mStringValue = stringValue;
    }

    public String16 getStringValue() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mStringValue;
        }
        throw new AssertionError();
    }

    public void setSingletonValue(int singletonValue) {
        this.mTag = 3;
        this.mSingletonValue = singletonValue;
    }

    public int getSingletonValue() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mSingletonValue;
        }
        throw new AssertionError();
    }

    public void setArrayValue(RemoteInvocationArgument[] arrayValue) {
        this.mTag = 4;
        this.mArrayValue = arrayValue;
    }

    public RemoteInvocationArgument[] getArrayValue() {
        if ($assertionsDisabled || this.mTag == 4) {
            return this.mArrayValue;
        }
        throw new AssertionError();
    }

    @Override // org.chromium.mojo.bindings.Union
    public final void encode(Encoder encoder0, int offset) {
        encoder0.encode(16, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (this.mTag) {
            case 0:
                encoder0.encode(this.mNumberValue, offset + 8);
                return;
            case 1:
                encoder0.encode(this.mBooleanValue, offset + 8, 0);
                return;
            case 2:
                encoder0.encode((Struct) this.mStringValue, offset + 8, false);
                return;
            case 3:
                encoder0.encode(this.mSingletonValue, offset + 8);
                return;
            case 4:
                if (this.mArrayValue == null) {
                    encoder0.encodeNullPointer(offset + 8, false);
                    return;
                }
                Encoder encoder1 = encoder0.encodeUnionArray(this.mArrayValue.length, offset + 8, -1);
                for (int i0 = 0; i0 < this.mArrayValue.length; i0++) {
                    encoder1.encode((Union) this.mArrayValue[i0], 8 + (16 * i0), false);
                }
                return;
            default:
                return;
        }
    }

    public static RemoteInvocationArgument deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final RemoteInvocationArgument decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        RemoteInvocationArgument result = new RemoteInvocationArgument();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mNumberValue = decoder0.readDouble(offset + 8);
                result.mTag = 0;
                break;
            case 1:
                result.mBooleanValue = decoder0.readBoolean(offset + 8, 0);
                result.mTag = 1;
                break;
            case 2:
                result.mStringValue = String16.decode(decoder0.readPointer(offset + 8, false));
                result.mTag = 2;
                break;
            case 3:
                result.mSingletonValue = decoder0.readInt(offset + 8);
                SingletonJavaScriptValue.validate(result.mSingletonValue);
                result.mTag = 3;
                break;
            case 4:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.mArrayValue = new RemoteInvocationArgument[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.mArrayValue[i1] = decode(decoder1, 8 + (16 * i1));
                }
                result.mTag = 4;
                break;
        }
        return result;
    }
}
