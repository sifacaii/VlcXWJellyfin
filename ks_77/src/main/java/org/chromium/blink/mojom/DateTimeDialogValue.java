package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.ui.mojom.TextInputType;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DateTimeDialogValue.class */
public final class DateTimeDialogValue extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int dialogType;
    public double dialogValue;
    public double minimum;
    public double maximum;
    public double step;
    public DateTimeSuggestion[] suggestions;

    private DateTimeDialogValue(int version) {
        super(56, version);
    }

    public DateTimeDialogValue() {
        this(0);
    }

    public static DateTimeDialogValue deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DateTimeDialogValue deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DateTimeDialogValue decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DateTimeDialogValue result = new DateTimeDialogValue(elementsOrVersion);
            result.dialogType = decoder0.readInt(8);
            TextInputType.validate(result.dialogType);
            result.dialogValue = decoder0.readDouble(16);
            result.minimum = decoder0.readDouble(24);
            result.maximum = decoder0.readDouble(32);
            result.step = decoder0.readDouble(40);
            Decoder decoder1 = decoder0.readPointer(48, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.suggestions = new DateTimeSuggestion[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.suggestions[i1] = DateTimeSuggestion.decode(decoder2);
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
        encoder0.encode(this.dialogType, 8);
        encoder0.encode(this.dialogValue, 16);
        encoder0.encode(this.minimum, 24);
        encoder0.encode(this.maximum, 32);
        encoder0.encode(this.step, 40);
        if (this.suggestions == null) {
            encoder0.encodeNullPointer(48, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 48, -1);
        for (int i0 = 0; i0 < this.suggestions.length; i0++) {
            encoder1.encode((Struct) this.suggestions[i0], 8 + (8 * i0), false);
        }
    }
}
