package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.device.mojom.HidConstants;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlRequest.class */
public final class UrlRequest extends Struct {
    private static final int STRUCT_SIZE = 208;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(STRUCT_SIZE, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String method;
    public Url url;
    public Url siteForCookies;
    public Origin topFrameOrigin;
    public NetworkIsolationKey trustedNetworkIsolationKey;
    public int updateNetworkIsolationKeyOnRedirect;
    public boolean attachSameSiteCookies;
    public boolean updateFirstPartyUrlOnRedirect;
    public Origin requestInitiator;
    public Url referrer;
    public int referrerPolicy;
    public boolean isPrerendering;
    public HttpRequestHeaders headers;
    public HttpRequestHeaders corsExemptHeaders;
    public int loadFlags;
    public boolean allowCredentials;
    public int pluginChildId;
    public int resourceType;
    public int priority;
    public UnguessableToken appcacheHostId;
    public boolean shouldResetAppcache;
    public boolean isExternalRequest;
    public int corsPreflightPolicy;
    public boolean originatedFromServiceWorker;
    public boolean skipServiceWorker;
    public boolean corbDetachable;
    public boolean corbExcluded;
    public int mode;
    public int credentialsMode;
    public int redirectMode;
    public String fetchIntegrity;
    public int fetchRequestContextType;
    public UrlRequestBody requestBody;
    public boolean keepalive;
    public boolean hasUserGesture;
    public boolean enableLoadTiming;
    public boolean enableUploadProgress;
    public boolean doNotPromptForLogin;
    public int renderFrameId;
    public boolean isMainFrame;
    public int transitionType;
    public boolean allowDownload;
    public boolean reportRawHeaders;
    public int previewsState;
    public boolean initiatedInSecureContext;
    public boolean upgradeIfInsecure;
    public boolean isRevalidating;
    public boolean shouldAlsoUseFactoryBoundOriginForCors;
    public UnguessableToken throttlingProfileId;
    public HttpRequestHeaders customProxyPreCacheHeaders;
    public HttpRequestHeaders customProxyPostCacheHeaders;
    public UnguessableToken fetchWindowId;
    public String devtoolsRequestId;
    public boolean isSignedExchangePrefetchCacheEnabled;

    private UrlRequest(int version) {
        super(STRUCT_SIZE, version);
        this.corbDetachable = false;
        this.corbExcluded = false;
    }

    public UrlRequest() {
        this(0);
    }

    public static UrlRequest deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UrlRequest deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlRequest decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UrlRequest result = new UrlRequest(elementsOrVersion);
            result.method = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.url = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.siteForCookies = Url.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, true);
            result.topFrameOrigin = Origin.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, true);
            result.trustedNetworkIsolationKey = NetworkIsolationKey.decode(decoder14);
            result.updateNetworkIsolationKeyOnRedirect = decoder0.readInt(48);
            UpdateNetworkIsolationKeyOnRedirect.validate(result.updateNetworkIsolationKeyOnRedirect);
            result.attachSameSiteCookies = decoder0.readBoolean(52, 0);
            result.updateFirstPartyUrlOnRedirect = decoder0.readBoolean(52, 1);
            result.isPrerendering = decoder0.readBoolean(52, 2);
            result.allowCredentials = decoder0.readBoolean(52, 3);
            result.shouldResetAppcache = decoder0.readBoolean(52, 4);
            result.isExternalRequest = decoder0.readBoolean(52, 5);
            result.originatedFromServiceWorker = decoder0.readBoolean(52, 6);
            result.skipServiceWorker = decoder0.readBoolean(52, 7);
            result.corbDetachable = decoder0.readBoolean(53, 0);
            result.corbExcluded = decoder0.readBoolean(53, 1);
            result.keepalive = decoder0.readBoolean(53, 2);
            result.hasUserGesture = decoder0.readBoolean(53, 3);
            result.enableLoadTiming = decoder0.readBoolean(53, 4);
            result.enableUploadProgress = decoder0.readBoolean(53, 5);
            result.doNotPromptForLogin = decoder0.readBoolean(53, 6);
            result.isMainFrame = decoder0.readBoolean(53, 7);
            result.allowDownload = decoder0.readBoolean(54, 0);
            result.reportRawHeaders = decoder0.readBoolean(54, 1);
            result.initiatedInSecureContext = decoder0.readBoolean(54, 2);
            result.upgradeIfInsecure = decoder0.readBoolean(54, 3);
            result.isRevalidating = decoder0.readBoolean(54, 4);
            result.shouldAlsoUseFactoryBoundOriginForCors = decoder0.readBoolean(54, 5);
            result.isSignedExchangePrefetchCacheEnabled = decoder0.readBoolean(54, 6);
            Decoder decoder15 = decoder0.readPointer(56, true);
            result.requestInitiator = Origin.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(64, false);
            result.referrer = Url.decode(decoder16);
            result.referrerPolicy = decoder0.readInt(72);
            UrlRequestReferrerPolicy.validate(result.referrerPolicy);
            result.loadFlags = decoder0.readInt(76);
            Decoder decoder17 = decoder0.readPointer(80, false);
            result.headers = HttpRequestHeaders.decode(decoder17);
            Decoder decoder18 = decoder0.readPointer(88, false);
            result.corsExemptHeaders = HttpRequestHeaders.decode(decoder18);
            result.pluginChildId = decoder0.readInt(96);
            result.resourceType = decoder0.readInt(100);
            result.priority = decoder0.readInt(104);
            RequestPriority.validate(result.priority);
            result.corsPreflightPolicy = decoder0.readInt(108);
            CorsPreflightPolicy.validate(result.corsPreflightPolicy);
            Decoder decoder19 = decoder0.readPointer(112, true);
            result.appcacheHostId = UnguessableToken.decode(decoder19);
            result.mode = decoder0.readInt(120);
            RequestMode.validate(result.mode);
            result.credentialsMode = decoder0.readInt(WebFeature.NAVIGATOR_VENDOR);
            CredentialsMode.validate(result.credentialsMode);
            result.redirectMode = decoder0.readInt(128);
            RedirectMode.validate(result.redirectMode);
            result.fetchRequestContextType = decoder0.readInt(132);
            result.fetchIntegrity = decoder0.readString(136, false);
            Decoder decoder110 = decoder0.readPointer(144, true);
            result.requestBody = UrlRequestBody.decode(decoder110);
            result.renderFrameId = decoder0.readInt(152);
            result.transitionType = decoder0.readInt(156);
            result.previewsState = decoder0.readInt(HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK);
            Decoder decoder111 = decoder0.readPointer(168, true);
            result.throttlingProfileId = UnguessableToken.decode(decoder111);
            Decoder decoder112 = decoder0.readPointer(176, false);
            result.customProxyPreCacheHeaders = HttpRequestHeaders.decode(decoder112);
            Decoder decoder113 = decoder0.readPointer(WebFeature.INPUT_TYPE_EMAIL_MULTIPLE, false);
            result.customProxyPostCacheHeaders = HttpRequestHeaders.decode(decoder113);
            Decoder decoder114 = decoder0.readPointer(WebFeature.INPUT_TYPE_PASSWORD, true);
            result.fetchWindowId = UnguessableToken.decode(decoder114);
            result.devtoolsRequestId = decoder0.readString(200, true);
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
        encoder0.encode(this.method, 8, false);
        encoder0.encode((Struct) this.url, 16, false);
        encoder0.encode((Struct) this.siteForCookies, 24, false);
        encoder0.encode((Struct) this.topFrameOrigin, 32, true);
        encoder0.encode((Struct) this.trustedNetworkIsolationKey, 40, true);
        encoder0.encode(this.updateNetworkIsolationKeyOnRedirect, 48);
        encoder0.encode(this.attachSameSiteCookies, 52, 0);
        encoder0.encode(this.updateFirstPartyUrlOnRedirect, 52, 1);
        encoder0.encode(this.isPrerendering, 52, 2);
        encoder0.encode(this.allowCredentials, 52, 3);
        encoder0.encode(this.shouldResetAppcache, 52, 4);
        encoder0.encode(this.isExternalRequest, 52, 5);
        encoder0.encode(this.originatedFromServiceWorker, 52, 6);
        encoder0.encode(this.skipServiceWorker, 52, 7);
        encoder0.encode(this.corbDetachable, 53, 0);
        encoder0.encode(this.corbExcluded, 53, 1);
        encoder0.encode(this.keepalive, 53, 2);
        encoder0.encode(this.hasUserGesture, 53, 3);
        encoder0.encode(this.enableLoadTiming, 53, 4);
        encoder0.encode(this.enableUploadProgress, 53, 5);
        encoder0.encode(this.doNotPromptForLogin, 53, 6);
        encoder0.encode(this.isMainFrame, 53, 7);
        encoder0.encode(this.allowDownload, 54, 0);
        encoder0.encode(this.reportRawHeaders, 54, 1);
        encoder0.encode(this.initiatedInSecureContext, 54, 2);
        encoder0.encode(this.upgradeIfInsecure, 54, 3);
        encoder0.encode(this.isRevalidating, 54, 4);
        encoder0.encode(this.shouldAlsoUseFactoryBoundOriginForCors, 54, 5);
        encoder0.encode(this.isSignedExchangePrefetchCacheEnabled, 54, 6);
        encoder0.encode((Struct) this.requestInitiator, 56, true);
        encoder0.encode((Struct) this.referrer, 64, false);
        encoder0.encode(this.referrerPolicy, 72);
        encoder0.encode(this.loadFlags, 76);
        encoder0.encode((Struct) this.headers, 80, false);
        encoder0.encode((Struct) this.corsExemptHeaders, 88, false);
        encoder0.encode(this.pluginChildId, 96);
        encoder0.encode(this.resourceType, 100);
        encoder0.encode(this.priority, 104);
        encoder0.encode(this.corsPreflightPolicy, 108);
        encoder0.encode((Struct) this.appcacheHostId, 112, true);
        encoder0.encode(this.mode, 120);
        encoder0.encode(this.credentialsMode, WebFeature.NAVIGATOR_VENDOR);
        encoder0.encode(this.redirectMode, 128);
        encoder0.encode(this.fetchRequestContextType, 132);
        encoder0.encode(this.fetchIntegrity, 136, false);
        encoder0.encode((Struct) this.requestBody, 144, true);
        encoder0.encode(this.renderFrameId, 152);
        encoder0.encode(this.transitionType, 156);
        encoder0.encode(this.previewsState, HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK);
        encoder0.encode((Struct) this.throttlingProfileId, 168, true);
        encoder0.encode((Struct) this.customProxyPreCacheHeaders, 176, false);
        encoder0.encode((Struct) this.customProxyPostCacheHeaders, WebFeature.INPUT_TYPE_EMAIL_MULTIPLE, false);
        encoder0.encode((Struct) this.fetchWindowId, WebFeature.INPUT_TYPE_PASSWORD, true);
        encoder0.encode(this.devtoolsRequestId, 200, true);
    }
}
