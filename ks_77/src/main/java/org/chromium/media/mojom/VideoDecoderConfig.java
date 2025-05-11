package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderConfig.class */
public final class VideoDecoderConfig extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int codec;
    public int profile;
    public boolean hasAlpha;
    public VideoTransformation transformation;
    public Size codedSize;
    public Rect visibleRect;
    public Size naturalSize;
    public byte[] extraData;
    public EncryptionScheme encryptionScheme;
    public VideoColorSpace colorSpaceInfo;
    public HdrMetadata hdrMetadata;

    private VideoDecoderConfig(int version) {
        super(88, version);
    }

    public VideoDecoderConfig() {
        this(0);
    }

    public static VideoDecoderConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoDecoderConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoDecoderConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoDecoderConfig result = new VideoDecoderConfig(elementsOrVersion);
            result.codec = decoder0.readInt(8);
            VideoCodec.validate(result.codec);
            result.profile = decoder0.readInt(12);
            VideoCodecProfile.validate(result.profile);
            result.hasAlpha = decoder0.readBoolean(16, 0);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.transformation = VideoTransformation.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.codedSize = Size.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(40, false);
            result.visibleRect = Rect.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(48, false);
            result.naturalSize = Size.decode(decoder14);
            result.extraData = decoder0.readBytes(56, 0, -1);
            Decoder decoder15 = decoder0.readPointer(64, false);
            result.encryptionScheme = EncryptionScheme.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(72, false);
            result.colorSpaceInfo = VideoColorSpace.decode(decoder16);
            Decoder decoder17 = decoder0.readPointer(80, true);
            result.hdrMetadata = HdrMetadata.decode(decoder17);
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
        encoder0.encode(this.codec, 8);
        encoder0.encode(this.profile, 12);
        encoder0.encode(this.hasAlpha, 16, 0);
        encoder0.encode((Struct) this.transformation, 24, false);
        encoder0.encode((Struct) this.codedSize, 32, false);
        encoder0.encode((Struct) this.visibleRect, 40, false);
        encoder0.encode((Struct) this.naturalSize, 48, false);
        encoder0.encode(this.extraData, 56, 0, -1);
        encoder0.encode((Struct) this.encryptionScheme, 64, false);
        encoder0.encode((Struct) this.colorSpaceInfo, 72, false);
        encoder0.encode((Struct) this.hdrMetadata, 80, true);
    }
}
