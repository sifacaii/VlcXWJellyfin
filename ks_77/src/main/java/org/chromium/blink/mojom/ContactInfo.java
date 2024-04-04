package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContactInfo.class */
public final class ContactInfo extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String[] name;
    public String[] email;
    public String[] tel;

    private ContactInfo(int version) {
        super(32, version);
    }

    public ContactInfo() {
        this(0);
    }

    public static ContactInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ContactInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ContactInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ContactInfo result = new ContactInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            if (decoder1 == null) {
                result.name = null;
            } else {
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.name = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.name[i1] = decoder1.readString(8 + (8 * i1), false);
                }
            }
            Decoder decoder12 = decoder0.readPointer(16, true);
            if (decoder12 == null) {
                result.email = null;
            } else {
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.email = new String[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    result.email[i12] = decoder12.readString(8 + (8 * i12), false);
                }
            }
            Decoder decoder13 = decoder0.readPointer(24, true);
            if (decoder13 == null) {
                result.tel = null;
            } else {
                DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
                result.tel = new String[si13.elementsOrVersion];
                for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                    result.tel[i13] = decoder13.readString(8 + (8 * i13), false);
                }
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        if (this.name == null) {
            encoder0.encodeNullPointer(8, true);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.name.length, 8, -1);
            for (int i0 = 0; i0 < this.name.length; i0++) {
                encoder1.encode(this.name[i0], 8 + (8 * i0), false);
            }
        }
        if (this.email == null) {
            encoder0.encodeNullPointer(16, true);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.email.length, 16, -1);
            for (int i02 = 0; i02 < this.email.length; i02++) {
                encoder12.encode(this.email[i02], 8 + (8 * i02), false);
            }
        }
        if (this.tel == null) {
            encoder0.encodeNullPointer(24, true);
            return;
        }
        Encoder encoder13 = encoder0.encodePointerArray(this.tel.length, 24, -1);
        for (int i03 = 0; i03 < this.tel.length; i03++) {
            encoder13.encode(this.tel[i03], 8 + (8 * i03), false);
        }
    }
}
