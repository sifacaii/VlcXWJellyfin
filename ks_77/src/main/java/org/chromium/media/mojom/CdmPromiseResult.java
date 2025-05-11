package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmPromiseResult.class */
public final class CdmPromiseResult extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean success;
    public int exception;
    public int systemCode;
    public String errorMessage;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmPromiseResult$Exception.class */
    public static final class Exception {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Exception() {
        }
    }

    private CdmPromiseResult(int version) {
        super(32, version);
    }

    public CdmPromiseResult() {
        this(0);
    }

    public static CdmPromiseResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CdmPromiseResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CdmPromiseResult decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CdmPromiseResult result = new CdmPromiseResult(elementsOrVersion);
            result.success = decoder0.readBoolean(8, 0);
            result.exception = decoder0.readInt(12);
            Exception.validate(result.exception);
            result.systemCode = decoder0.readInt(16);
            result.errorMessage = decoder0.readString(24, false);
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
        encoder0.encode(this.success, 8, 0);
        encoder0.encode(this.exception, 12);
        encoder0.encode(this.systemCode, 16);
        encoder0.encode(this.errorMessage, 24, false);
    }
}
