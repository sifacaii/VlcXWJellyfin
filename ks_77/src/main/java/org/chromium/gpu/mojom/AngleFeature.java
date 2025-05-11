package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/AngleFeature.class */
public final class AngleFeature extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String name;
    public String category;
    public String description;
    public String bug;
    public String status;

    private AngleFeature(int version) {
        super(48, version);
    }

    public AngleFeature() {
        this(0);
    }

    public static AngleFeature deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AngleFeature deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AngleFeature decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AngleFeature result = new AngleFeature(elementsOrVersion);
            result.name = decoder0.readString(8, false);
            result.category = decoder0.readString(16, false);
            result.description = decoder0.readString(24, false);
            result.bug = decoder0.readString(32, false);
            result.status = decoder0.readString(40, false);
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
        encoder0.encode(this.name, 8, false);
        encoder0.encode(this.category, 16, false);
        encoder0.encode(this.description, 24, false);
        encoder0.encode(this.bug, 32, false);
        encoder0.encode(this.status, 40, false);
    }
}
