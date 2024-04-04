package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CustomProxyConfig.class */
public final class CustomProxyConfig extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ProxyRules rules;
    public boolean shouldOverrideExistingConfig;
    public boolean allowNonIdempotentMethods;
    public boolean assumeHttpsProxiesSupportQuic;
    public boolean canUseProxyOnHttpUrlRedirectCycles;
    public HttpRequestHeaders preCacheHeaders;
    public HttpRequestHeaders postCacheHeaders;
    public HttpRequestHeaders connectTunnelHeaders;

    private CustomProxyConfig(int version) {
        super(48, version);
        this.shouldOverrideExistingConfig = false;
        this.allowNonIdempotentMethods = false;
        this.assumeHttpsProxiesSupportQuic = false;
        this.canUseProxyOnHttpUrlRedirectCycles = true;
    }

    public CustomProxyConfig() {
        this(0);
    }

    public static CustomProxyConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CustomProxyConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CustomProxyConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CustomProxyConfig result = new CustomProxyConfig(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.rules = ProxyRules.decode(decoder1);
            result.shouldOverrideExistingConfig = decoder0.readBoolean(16, 0);
            result.allowNonIdempotentMethods = decoder0.readBoolean(16, 1);
            result.assumeHttpsProxiesSupportQuic = decoder0.readBoolean(16, 2);
            result.canUseProxyOnHttpUrlRedirectCycles = decoder0.readBoolean(16, 3);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.preCacheHeaders = HttpRequestHeaders.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.postCacheHeaders = HttpRequestHeaders.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, false);
            result.connectTunnelHeaders = HttpRequestHeaders.decode(decoder14);
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
        encoder0.encode((Struct) this.rules, 8, false);
        encoder0.encode(this.shouldOverrideExistingConfig, 16, 0);
        encoder0.encode(this.allowNonIdempotentMethods, 16, 1);
        encoder0.encode(this.assumeHttpsProxiesSupportQuic, 16, 2);
        encoder0.encode(this.canUseProxyOnHttpUrlRedirectCycles, 16, 3);
        encoder0.encode((Struct) this.preCacheHeaders, 24, false);
        encoder0.encode((Struct) this.postCacheHeaders, 32, false);
        encoder0.encode((Struct) this.connectTunnelHeaders, 40, false);
    }
}
