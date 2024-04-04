package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoColorSpace.class */
public final class VideoColorSpace extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int primaries;
    public int transfer;
    public int matrix;
    public int range;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoColorSpace$PrimaryId.class */
    public static final class PrimaryId {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private PrimaryId() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoColorSpace$TransferId.class */
    public static final class TransferId {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private TransferId() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoColorSpace$MatrixId.class */
    public static final class MatrixId {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private MatrixId() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoColorSpace$RangeId.class */
    public static final class RangeId {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private RangeId() {
        }
    }

    private VideoColorSpace(int version) {
        super(24, version);
    }

    public VideoColorSpace() {
        this(0);
    }

    public static VideoColorSpace deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoColorSpace deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoColorSpace decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoColorSpace result = new VideoColorSpace(elementsOrVersion);
            result.primaries = decoder0.readInt(8);
            PrimaryId.validate(result.primaries);
            result.transfer = decoder0.readInt(12);
            TransferId.validate(result.transfer);
            result.matrix = decoder0.readInt(16);
            MatrixId.validate(result.matrix);
            result.range = decoder0.readInt(20);
            RangeId.validate(result.range);
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
        encoder0.encode(this.primaries, 8);
        encoder0.encode(this.transfer, 12);
        encoder0.encode(this.matrix, 16);
        encoder0.encode(this.range, 20);
    }
}
