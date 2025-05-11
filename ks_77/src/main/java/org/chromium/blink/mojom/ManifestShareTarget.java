package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestShareTarget.class */
public final class ManifestShareTarget extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url action;
    public int method;
    public int enctype;
    public ManifestShareTargetParams params;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestShareTarget$Method.class */
    public static final class Method {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int GET = 0;
        public static final int POST = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Method() {
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestShareTarget$Enctype.class */
    public static final class Enctype {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int FORM_URL_ENCODED = 0;
        public static final int MULTIPART_FORM_DATA = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Enctype() {
        }
    }

    private ManifestShareTarget(int version) {
        super(32, version);
    }

    public ManifestShareTarget() {
        this(0);
    }

    public static ManifestShareTarget deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ManifestShareTarget deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestShareTarget decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ManifestShareTarget result = new ManifestShareTarget(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.action = Url.decode(decoder1);
            result.method = decoder0.readInt(16);
            Method.validate(result.method);
            result.enctype = decoder0.readInt(20);
            Enctype.validate(result.enctype);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.params = ManifestShareTargetParams.decode(decoder12);
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
        encoder0.encode((Struct) this.action, 8, false);
        encoder0.encode(this.method, 16);
        encoder0.encode(this.enctype, 20);
        encoder0.encode((Struct) this.params, 24, false);
    }
}
