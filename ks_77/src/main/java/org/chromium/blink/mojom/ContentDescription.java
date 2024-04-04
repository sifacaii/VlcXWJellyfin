package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ContentDescription.class */
public final class ContentDescription extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String id;
    public String title;
    public String description;
    public int category;
    public String iconUrl;
    public String launchUrl;

    private ContentDescription(int version) {
        super(56, version);
    }

    public ContentDescription() {
        this(0);
    }

    public static ContentDescription deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ContentDescription deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentDescription decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ContentDescription result = new ContentDescription(elementsOrVersion);
            result.id = decoder0.readString(8, false);
            result.title = decoder0.readString(16, false);
            result.description = decoder0.readString(24, false);
            result.category = decoder0.readInt(32);
            ContentCategory.validate(result.category);
            result.iconUrl = decoder0.readString(40, false);
            result.launchUrl = decoder0.readString(48, false);
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
        encoder0.encode(this.id, 8, false);
        encoder0.encode(this.title, 16, false);
        encoder0.encode(this.description, 24, false);
        encoder0.encode(this.category, 32);
        encoder0.encode(this.iconUrl, 40, false);
        encoder0.encode(this.launchUrl, 48, false);
    }
}
