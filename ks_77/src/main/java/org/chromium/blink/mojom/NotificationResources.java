package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NotificationResources.class */
public final class NotificationResources extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Bitmap image;
    public Bitmap icon;
    public Bitmap badge;
    public Bitmap[] actionIcons;

    private NotificationResources(int version) {
        super(40, version);
    }

    public NotificationResources() {
        this(0);
    }

    public static NotificationResources deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NotificationResources deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NotificationResources decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NotificationResources result = new NotificationResources(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            result.image = Bitmap.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, true);
            result.icon = Bitmap.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, true);
            result.badge = Bitmap.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, true);
            if (decoder14 == null) {
                result.actionIcons = null;
            } else {
                DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
                result.actionIcons = new Bitmap[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder14.readPointer(8 + (8 * i1), true);
                    result.actionIcons[i1] = Bitmap.decode(decoder2);
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
        encoder0.encode((Struct) this.image, 8, true);
        encoder0.encode((Struct) this.icon, 16, true);
        encoder0.encode((Struct) this.badge, 24, true);
        if (this.actionIcons == null) {
            encoder0.encodeNullPointer(32, true);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.actionIcons.length, 32, -1);
        for (int i0 = 0; i0 < this.actionIcons.length; i0++) {
            encoder1.encode((Struct) this.actionIcons[i0], 8 + (8 * i0), true);
        }
    }
}
