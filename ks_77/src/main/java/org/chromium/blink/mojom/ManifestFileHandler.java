package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestFileHandler.class */
public final class ManifestFileHandler extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url action;
    public ManifestFileFilter[] files;

    private ManifestFileHandler(int version) {
        super(24, version);
    }

    public ManifestFileHandler() {
        this(0);
    }

    public static ManifestFileHandler deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ManifestFileHandler deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestFileHandler decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ManifestFileHandler result = new ManifestFileHandler(elementsOrVersion);
            result.action = Url.decode(decoder0.readPointer(8, false));
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.files = new ManifestFileFilter[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.files[i1] = ManifestFileFilter.decode(decoder2);
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
        encoder0.encode((Struct) this.action, 8, false);
        if (this.files == null) {
            encoder0.encodeNullPointer(16, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.files.length, 16, -1);
        for (int i0 = 0; i0 < this.files.length; i0++) {
            encoder1.encode((Struct) this.files[i0], 8 + (8 * i0), false);
        }
    }
}
