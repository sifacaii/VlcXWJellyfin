package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestFileFilter.class */
public final class ManifestFileFilter extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String16 name;
    public String16[] accept;

    private ManifestFileFilter(int version) {
        super(24, version);
    }

    public ManifestFileFilter() {
        this(0);
    }

    public static ManifestFileFilter deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ManifestFileFilter deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestFileFilter decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ManifestFileFilter result = new ManifestFileFilter(elementsOrVersion);
            result.name = String16.decode(decoder0.readPointer(8, true));
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.accept = new String16[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.accept[i1] = String16.decode(decoder2);
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
        encoder0.encode((Struct) this.name, 8, true);
        if (this.accept == null) {
            encoder0.encodeNullPointer(16, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.accept.length, 16, -1);
        for (int i0 = 0; i0 < this.accept.length; i0++) {
            encoder1.encode((Struct) this.accept[i0], 8 + (8 * i0), false);
        }
    }
}
