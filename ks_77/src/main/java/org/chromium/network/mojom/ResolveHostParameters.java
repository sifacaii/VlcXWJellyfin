package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostParameters.class */
public final class ResolveHostParameters extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int dnsQueryType;
    public int initialPriority;
    public int source;
    public boolean allowCachedResponse;
    public InterfaceRequest<ResolveHostHandle> controlHandle;
    public boolean includeCanonicalName;
    public boolean loopbackOnly;
    public boolean isSpeculative;
    public int secureDnsModeOverride;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostParameters$Source.class */
    public static final class Source {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int ANY = 0;
        public static final int SYSTEM = 1;
        public static final int DNS = 2;
        public static final int MULTICAST_DNS = 3;
        public static final int LOCAL_ONLY = 4;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 4;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Source() {
        }
    }

    private ResolveHostParameters(int version) {
        super(32, version);
        this.dnsQueryType = 0;
        this.initialPriority = 2;
        this.source = 0;
        this.allowCachedResponse = true;
        this.includeCanonicalName = false;
        this.loopbackOnly = false;
        this.isSpeculative = false;
        this.secureDnsModeOverride = 0;
    }

    public ResolveHostParameters() {
        this(0);
    }

    public static ResolveHostParameters deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ResolveHostParameters deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ResolveHostParameters decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ResolveHostParameters result = new ResolveHostParameters(elementsOrVersion);
            result.dnsQueryType = decoder0.readInt(8);
            DnsQueryType.validate(result.dnsQueryType);
            result.initialPriority = decoder0.readInt(12);
            RequestPriority.validate(result.initialPriority);
            result.source = decoder0.readInt(16);
            Source.validate(result.source);
            result.allowCachedResponse = decoder0.readBoolean(20, 0);
            result.includeCanonicalName = decoder0.readBoolean(20, 1);
            result.loopbackOnly = decoder0.readBoolean(20, 2);
            result.isSpeculative = decoder0.readBoolean(20, 3);
            result.controlHandle = decoder0.readInterfaceRequest(24, true);
            result.secureDnsModeOverride = decoder0.readInt(28);
            OptionalSecureDnsMode.validate(result.secureDnsModeOverride);
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
        encoder0.encode(this.dnsQueryType, 8);
        encoder0.encode(this.initialPriority, 12);
        encoder0.encode(this.source, 16);
        encoder0.encode(this.allowCachedResponse, 20, 0);
        encoder0.encode(this.includeCanonicalName, 20, 1);
        encoder0.encode(this.loopbackOnly, 20, 2);
        encoder0.encode(this.isSpeculative, 20, 3);
        encoder0.encode((InterfaceRequest) this.controlHandle, 24, true);
        encoder0.encode(this.secureDnsModeOverride, 28);
    }
}
