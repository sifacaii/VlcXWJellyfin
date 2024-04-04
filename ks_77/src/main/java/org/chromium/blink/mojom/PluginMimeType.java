package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PluginMimeType.class */
public final class PluginMimeType extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String mimeType;
    public String16 description;
    public String[] fileExtensions;

    private PluginMimeType(int version) {
        super(32, version);
    }

    public PluginMimeType() {
        this(0);
    }

    public static PluginMimeType deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PluginMimeType deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PluginMimeType decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PluginMimeType result = new PluginMimeType(elementsOrVersion);
            result.mimeType = decoder0.readString(8, false);
            result.description = String16.decode(decoder0.readPointer(16, false));
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.fileExtensions = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.fileExtensions[i1] = decoder1.readString(8 + (8 * i1), false);
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
        encoder0.encode(this.mimeType, 8, false);
        encoder0.encode((Struct) this.description, 16, false);
        if (this.fileExtensions == null) {
            encoder0.encodeNullPointer(24, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.fileExtensions.length, 24, -1);
        for (int i0 = 0; i0 < this.fileExtensions.length; i0++) {
            encoder1.encode(this.fileExtensions[i0], 8 + (8 * i0), false);
        }
    }
}
