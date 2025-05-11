package org.chromium.content_settings.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_settings/mojom/PatternParts.class */
public final class PatternParts extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String scheme;
    public boolean isSchemeWildcard;
    public String host;
    public boolean hasDomainWildcard;
    public String port;
    public boolean isPortWildcard;
    public String path;
    public boolean isPathWildcard;

    private PatternParts(int version) {
        super(48, version);
    }

    public PatternParts() {
        this(0);
    }

    public static PatternParts deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PatternParts deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PatternParts decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PatternParts result = new PatternParts(elementsOrVersion);
            result.scheme = decoder0.readString(8, false);
            result.isSchemeWildcard = decoder0.readBoolean(16, 0);
            result.hasDomainWildcard = decoder0.readBoolean(16, 1);
            result.isPortWildcard = decoder0.readBoolean(16, 2);
            result.isPathWildcard = decoder0.readBoolean(16, 3);
            result.host = decoder0.readString(24, false);
            result.port = decoder0.readString(32, false);
            result.path = decoder0.readString(40, false);
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
        encoder0.encode(this.scheme, 8, false);
        encoder0.encode(this.isSchemeWildcard, 16, 0);
        encoder0.encode(this.hasDomainWildcard, 16, 1);
        encoder0.encode(this.isPortWildcard, 16, 2);
        encoder0.encode(this.isPathWildcard, 16, 3);
        encoder0.encode(this.host, 24, false);
        encoder0.encode(this.port, 32, false);
        encoder0.encode(this.path, 40, false);
    }
}
