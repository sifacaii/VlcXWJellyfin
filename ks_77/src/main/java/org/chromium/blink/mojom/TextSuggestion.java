package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/TextSuggestion.class */
public final class TextSuggestion extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int markerTag;
    public int suggestionIndex;
    public String prefix;
    public String suggestion;
    public String suffix;

    private TextSuggestion(int version) {
        super(40, version);
    }

    public TextSuggestion() {
        this(0);
    }

    public static TextSuggestion deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TextSuggestion deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TextSuggestion decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TextSuggestion result = new TextSuggestion(elementsOrVersion);
            result.markerTag = decoder0.readInt(8);
            result.suggestionIndex = decoder0.readInt(12);
            result.prefix = decoder0.readString(16, false);
            result.suggestion = decoder0.readString(24, false);
            result.suffix = decoder0.readString(32, false);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.markerTag, 8);
        encoder0.encode(this.suggestionIndex, 12);
        encoder0.encode(this.prefix, 16, false);
        encoder0.encode(this.suggestion, 24, false);
        encoder0.encode(this.suffix, 32, false);
    }
}
