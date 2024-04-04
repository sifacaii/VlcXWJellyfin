package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactoryParams.class */
public final class UrlLoaderFactoryParams extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int processId;
    public Origin requestInitiatorSiteLock;
    public boolean isCorbEnabled;
    public boolean disableWebSecurity;
    public int crossOriginEmbedderPolicy;
    public TrustedUrlLoaderHeaderClient headerClient;
    public CorsOriginPattern[] factoryBoundAllowPatterns;
    public NetworkIsolationKey networkIsolationKey;

    private UrlLoaderFactoryParams(int version) {
        super(56, version);
        this.processId = -1;
        this.isCorbEnabled = true;
        this.disableWebSecurity = false;
        this.crossOriginEmbedderPolicy = 0;
    }

    public UrlLoaderFactoryParams() {
        this(0);
    }

    public static UrlLoaderFactoryParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UrlLoaderFactoryParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderFactoryParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UrlLoaderFactoryParams result = new UrlLoaderFactoryParams(elementsOrVersion);
            result.processId = decoder0.readInt(8);
            result.isCorbEnabled = decoder0.readBoolean(12, 0);
            result.disableWebSecurity = decoder0.readBoolean(12, 1);
            result.requestInitiatorSiteLock = Origin.decode(decoder0.readPointer(16, true));
            result.crossOriginEmbedderPolicy = decoder0.readInt(24);
            CrossOriginEmbedderPolicy.validate(result.crossOriginEmbedderPolicy);
            result.headerClient = (TrustedUrlLoaderHeaderClient) decoder0.readServiceInterface(28, true, TrustedUrlLoaderHeaderClient.MANAGER);
            Decoder decoder1 = decoder0.readPointer(40, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.factoryBoundAllowPatterns = new CorsOriginPattern[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.factoryBoundAllowPatterns[i1] = CorsOriginPattern.decode(decoder2);
            }
            result.networkIsolationKey = NetworkIsolationKey.decode(decoder0.readPointer(48, true));
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
        encoder0.encode(this.processId, 8);
        encoder0.encode(this.isCorbEnabled, 12, 0);
        encoder0.encode(this.disableWebSecurity, 12, 1);
        encoder0.encode((Struct) this.requestInitiatorSiteLock, 16, true);
        encoder0.encode(this.crossOriginEmbedderPolicy, 24);
        encoder0.encode(this.headerClient,28,true, TrustedUrlLoaderHeaderClient.MANAGER);
        if (this.factoryBoundAllowPatterns == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.factoryBoundAllowPatterns.length, 40, -1);
            for (int i0 = 0; i0 < this.factoryBoundAllowPatterns.length; i0++) {
                encoder1.encode((Struct) this.factoryBoundAllowPatterns[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.networkIsolationKey, 48, true);
    }
}
