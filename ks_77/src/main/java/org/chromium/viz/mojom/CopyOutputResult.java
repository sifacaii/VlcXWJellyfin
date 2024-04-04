package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gpu.mojom.Mailbox;
import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CopyOutputResult.class */
public final class CopyOutputResult extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int format;
    public Rect rect;
    public Bitmap bitmap;
    public Mailbox mailbox;
    public SyncToken syncToken;
    public ColorSpace colorSpace;
    public TextureReleaser releaser;

    private CopyOutputResult(int version) {
        super(64, version);
    }

    public CopyOutputResult() {
        this(0);
    }

    public static CopyOutputResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CopyOutputResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CopyOutputResult decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CopyOutputResult result = new CopyOutputResult(elementsOrVersion);
            result.format = decoder0.readInt(8);
            CopyOutputResultFormat.validate(result.format);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.rect = Rect.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, true);
            result.bitmap = Bitmap.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, true);
            result.mailbox = Mailbox.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, true);
            result.syncToken = SyncToken.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(48, true);
            result.colorSpace = ColorSpace.decode(decoder15);
            result.releaser = (TextureReleaser) decoder0.readServiceInterface(56, true, TextureReleaser.MANAGER);
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
        encoder0.encode(this.format, 8);
        encoder0.encode((Struct) this.rect, 16, false);
        encoder0.encode((Struct) this.bitmap, 24, true);
        encoder0.encode((Struct) this.mailbox, 32, true);
        encoder0.encode((Struct) this.syncToken, 40, true);
        encoder0.encode((Struct) this.colorSpace, 48, true);
        encoder0.encode(this.releaser, 56, true,TextureReleaser.MANAGER);
    }
}
