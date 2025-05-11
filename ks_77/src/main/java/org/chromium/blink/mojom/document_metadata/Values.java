package org.chromium.blink.mojom.document_metadata;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/document_metadata/Values.class */
public final class Values extends Union {
    private boolean[] mBoolValues;
    private long[] mLongValues;
    private String[] mStringValues;
    private Entity[] mEntityValues;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/document_metadata/Values$Tag.class */
    public static final class Tag {
        public static final int BoolValues = 0;
        public static final int LongValues = 1;
        public static final int StringValues = 2;
        public static final int EntityValues = 3;
    }

    static {
        $assertionsDisabled = !Values.class.desiredAssertionStatus();
    }

    public void setBoolValues(boolean[] boolValues) {
        this.mTag = 0;
        this.mBoolValues = boolValues;
    }

    public boolean[] getBoolValues() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mBoolValues;
        }
        throw new AssertionError();
    }

    public void setLongValues(long[] longValues) {
        this.mTag = 1;
        this.mLongValues = longValues;
    }

    public long[] getLongValues() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mLongValues;
        }
        throw new AssertionError();
    }

    public void setStringValues(String[] stringValues) {
        this.mTag = 2;
        this.mStringValues = stringValues;
    }

    public String[] getStringValues() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mStringValues;
        }
        throw new AssertionError();
    }

    public void setEntityValues(Entity[] entityValues) {
        this.mTag = 3;
        this.mEntityValues = entityValues;
    }

    public Entity[] getEntityValues() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mEntityValues;
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
                encoder0.encode(this.mBoolValues, offset + 8, 0, -1);
                return;
            case 1:
                encoder0.encode(this.mLongValues, offset + 8, 0, -1);
                return;
            case 2:
                if (this.mStringValues == null) {
                    encoder0.encodeNullPointer(offset + 8, false);
                    return;
                }
                Encoder encoder1 = encoder0.encodePointerArray(this.mStringValues.length, offset + 8, -1);
                for (int i0 = 0; i0 < this.mStringValues.length; i0++) {
                    encoder1.encode(this.mStringValues[i0], 8 + (8 * i0), false);
                }
                return;
            case 3:
                if (this.mEntityValues == null) {
                    encoder0.encodeNullPointer(offset + 8, false);
                    return;
                }
                Encoder encoder12 = encoder0.encodePointerArray(this.mEntityValues.length, offset + 8, -1);
                for (int i02 = 0; i02 < this.mEntityValues.length; i02++) {
                    encoder12.encode((Struct) this.mEntityValues[i02], 8 + (8 * i02), false);
                }
                return;
            default:
                return;
        }
    }

    public static Values deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final Values decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        Values result = new Values();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mBoolValues = decoder0.readBooleans(offset + 8, 0, -1);
                result.mTag = 0;
                break;
            case 1:
                result.mLongValues = decoder0.readLongs(offset + 8, 0, -1);
                result.mTag = 1;
                break;
            case 2:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.mStringValues = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.mStringValues[i1] = decoder1.readString(8 + (8 * i1), false);
                }
                result.mTag = 2;
                break;
            case 3:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.mEntityValues = new Entity[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder2 = decoder12.readPointer(8 + (8 * i12), false);
                    result.mEntityValues[i12] = Entity.decode(decoder2);
                }
                result.mTag = 3;
                break;
        }
        return result;
    }
}
