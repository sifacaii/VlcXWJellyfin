package org.chromium.installedapp.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/installedapp/mojom/RelatedApplication.class */
public final class RelatedApplication extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String platform;
    public String url;
    public String id;

    private RelatedApplication(int version) {
        super(32, version);
    }

    public RelatedApplication() {
        this(0);
    }

    public static RelatedApplication deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static RelatedApplication deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static RelatedApplication decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            RelatedApplication result = new RelatedApplication(elementsOrVersion);
            result.platform = decoder0.readString(8, false);
            result.url = decoder0.readString(16, true);
            result.id = decoder0.readString(24, true);
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
        encoder0.encode(this.platform, 8, false);
        encoder0.encode(this.url, 16, true);
        encoder0.encode(this.id, 24, true);
    }
}
