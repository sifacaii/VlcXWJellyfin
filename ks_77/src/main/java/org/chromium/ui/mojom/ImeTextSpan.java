package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/mojom/ImeTextSpan.class */
public final class ImeTextSpan extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public int startOffset;
    public int endOffset;
    public int underlineColor;
    public int thickness;
    public int backgroundColor;
    public int suggestionHighlightColor;
    public boolean removeOnFinishComposing;
    public String[] suggestions;

    private ImeTextSpan(int version) {
        super(48, version);
    }

    public ImeTextSpan() {
        this(0);
    }

    public static ImeTextSpan deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ImeTextSpan deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ImeTextSpan decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ImeTextSpan result = new ImeTextSpan(elementsOrVersion);
            result.type = decoder0.readInt(8);
            ImeTextSpanType.validate(result.type);
            result.startOffset = decoder0.readInt(12);
            result.endOffset = decoder0.readInt(16);
            result.underlineColor = decoder0.readInt(20);
            result.thickness = decoder0.readInt(24);
            ImeTextSpanThickness.validate(result.thickness);
            result.backgroundColor = decoder0.readInt(28);
            result.suggestionHighlightColor = decoder0.readInt(32);
            result.removeOnFinishComposing = decoder0.readBoolean(36, 0);
            Decoder decoder1 = decoder0.readPointer(40, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.suggestions = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.suggestions[i1] = decoder1.readString(8 + (8 * i1), false);
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
        encoder0.encode(this.type, 8);
        encoder0.encode(this.startOffset, 12);
        encoder0.encode(this.endOffset, 16);
        encoder0.encode(this.underlineColor, 20);
        encoder0.encode(this.thickness, 24);
        encoder0.encode(this.backgroundColor, 28);
        encoder0.encode(this.suggestionHighlightColor, 32);
        encoder0.encode(this.removeOnFinishComposing, 36, 0);
        if (this.suggestions == null) {
            encoder0.encodeNullPointer(40, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 40, -1);
        for (int i0 = 0; i0 < this.suggestions.length; i0++) {
            encoder1.encode(this.suggestions[i0], 8 + (8 * i0), false);
        }
    }
}
