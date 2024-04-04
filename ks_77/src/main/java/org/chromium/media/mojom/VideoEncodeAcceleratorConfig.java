package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorConfig.class */
public final class VideoEncodeAcceleratorConfig extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int inputFormat;
    public Size inputVisibleSize;
    public int outputProfile;
    public int initialBitrate;
    public int initialFramerate;
    public boolean hasInitialFramerate;
    public int gopLength;
    public boolean hasGopLength;
    public byte h264OutputLevel;
    public boolean hasH264OutputLevel;
    public int storageType;
    public boolean hasStorageType;
    public int contentType;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorConfig$ContentType.class */
    public static final class ContentType {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int CAMERA = 0;
        public static final int DISPLAY = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private ContentType() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorConfig$StorageType.class */
    public static final class StorageType {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int SHMEM = 0;
        public static final int DMABUF = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private StorageType() {
        }
    }

    private VideoEncodeAcceleratorConfig(int version) {
        super(48, version);
    }

    public VideoEncodeAcceleratorConfig() {
        this(0);
    }

    public static VideoEncodeAcceleratorConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoEncodeAcceleratorConfig result = new VideoEncodeAcceleratorConfig(elementsOrVersion);
            result.inputFormat = decoder0.readInt(8);
            VideoPixelFormat.validate(result.inputFormat);
            result.outputProfile = decoder0.readInt(12);
            VideoCodecProfile.validate(result.outputProfile);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.inputVisibleSize = Size.decode(decoder1);
            result.initialBitrate = decoder0.readInt(24);
            result.initialFramerate = decoder0.readInt(28);
            result.hasInitialFramerate = decoder0.readBoolean(32, 0);
            result.hasGopLength = decoder0.readBoolean(32, 1);
            result.hasH264OutputLevel = decoder0.readBoolean(32, 2);
            result.hasStorageType = decoder0.readBoolean(32, 3);
            result.h264OutputLevel = decoder0.readByte(33);
            result.gopLength = decoder0.readInt(36);
            result.storageType = decoder0.readInt(40);
            StorageType.validate(result.storageType);
            result.contentType = decoder0.readInt(44);
            ContentType.validate(result.contentType);
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
        encoder0.encode(this.inputFormat, 8);
        encoder0.encode(this.outputProfile, 12);
        encoder0.encode((Struct) this.inputVisibleSize, 16, false);
        encoder0.encode(this.initialBitrate, 24);
        encoder0.encode(this.initialFramerate, 28);
        encoder0.encode(this.hasInitialFramerate, 32, 0);
        encoder0.encode(this.hasGopLength, 32, 1);
        encoder0.encode(this.hasH264OutputLevel, 32, 2);
        encoder0.encode(this.hasStorageType, 32, 3);
        encoder0.encode(this.h264OutputLevel, 33);
        encoder0.encode(this.gopLength, 36);
        encoder0.encode(this.storageType, 40);
        encoder0.encode(this.contentType, 44);
    }
}
