package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.Size;
import org.chromium.gpu.mojom.MailboxHolder;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/TransferableResource.class */
public final class TransferableResource extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int id;
    public int format;
    public int filter;
    public Size size;
    public MailboxHolder mailboxHolder;
    public boolean readLockFencesEnabled;
    public boolean isSoftware;
    public boolean isOverlayCandidate;
    public boolean isBackedBySurfaceTexture;
    public boolean wantsPromotionHint;
    public ColorSpace colorSpace;

    private TransferableResource(int version) {
        super(48, version);
    }

    public TransferableResource() {
        this(0);
    }

    public static TransferableResource deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TransferableResource deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TransferableResource decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TransferableResource result = new TransferableResource(elementsOrVersion);
            result.id = decoder0.readInt(8);
            result.format = decoder0.readInt(12);
            ResourceFormat.validate(result.format);
            result.filter = decoder0.readInt(16);
            result.readLockFencesEnabled = decoder0.readBoolean(20, 0);
            result.isSoftware = decoder0.readBoolean(20, 1);
            result.isOverlayCandidate = decoder0.readBoolean(20, 2);
            result.isBackedBySurfaceTexture = decoder0.readBoolean(20, 3);
            result.wantsPromotionHint = decoder0.readBoolean(20, 4);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.size = Size.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.mailboxHolder = MailboxHolder.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(40, false);
            result.colorSpace = ColorSpace.decode(decoder13);
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
        encoder0.encode(this.id, 8);
        encoder0.encode(this.format, 12);
        encoder0.encode(this.filter, 16);
        encoder0.encode(this.readLockFencesEnabled, 20, 0);
        encoder0.encode(this.isSoftware, 20, 1);
        encoder0.encode(this.isOverlayCandidate, 20, 2);
        encoder0.encode(this.isBackedBySurfaceTexture, 20, 3);
        encoder0.encode(this.wantsPromotionHint, 20, 4);
        encoder0.encode((Struct) this.size, 24, false);
        encoder0.encode((Struct) this.mailboxHolder, 32, false);
        encoder0.encode((Struct) this.colorSpace, 40, false);
    }
}
