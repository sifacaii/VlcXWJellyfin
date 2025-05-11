package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.device.mojom.HidConstants;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.proxy_resolver.mojom.ProxyResolverFactory;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextParams.class */
public final class NetworkContextParams extends Struct {
    private static final int STRUCT_SIZE = 192;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(192, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String contextName;
    public String userAgent;
    public String acceptLanguage;
    public boolean enableBrotli;
    public String quicUserAgentId;
    public boolean enableReferrers;
    public boolean validateReferrerPolicyOnInitialRequest;
    public ProxyResolverFactory proxyResolverFactory;
    public FilePath cookiePath;
    public boolean enableEncryptedCookies;
    public boolean restoreOldSessionCookies;
    public boolean persistSessionCookies;
    public boolean httpCacheEnabled;
    public int httpCacheMaxSize;
    public FilePath httpCachePath;
    public FilePath httpServerPropertiesPath;
    public FilePath transportSecurityPersisterPath;
    public boolean enableFtpUrlSupport;
    public boolean checkClearTextPermitted;
    public boolean enforceChromeCtPolicy;
    public boolean http09OnNonDefaultPortsEnabled;
    public boolean disableIdleSocketsCloseOnMemoryPressure;
    public SslConfig initialSslConfig;
    public InterfaceRequest<SslConfigClient> sslConfigClientRequest;
    public ProxyConfigWithAnnotation initialProxyConfig;
    public InterfaceRequest<ProxyConfigClient> proxyConfigClientRequest;
    public CustomProxyConfig initialCustomProxyConfig;
    public InterfaceRequest<CustomProxyConfigClient> customProxyConfigClientRequest;
    public ProxyConfigPollerClient proxyConfigPollerClient;
    public ProxyErrorClient proxyErrorClient;
    public boolean pacQuickCheckEnabled;
    public boolean enableCertificateReporting;
    public boolean enableExpectCtReporting;
    public CtLogInfo[] ctLogs;
    public CookieManagerParams cookieManagerParams;
    public boolean enableDomainReliability;
    public String domainReliabilityUploadReporter;
    public boolean discardDomainReliablityUploads;
    public TimeDelta reportingDeliveryInterval;
    public boolean skipReportingSendPermissionCheck;
    public boolean primaryNetworkContext;
    public CorsOriginAccessPatterns[] corsOriginAccessList;
    public String[] corsExemptHeaderList;

    private NetworkContextParams(int version) {
        super(192, version);
        this.enableBrotli = true;
        this.enableReferrers = true;
        this.validateReferrerPolicyOnInitialRequest = true;
        this.enableEncryptedCookies = true;
        this.restoreOldSessionCookies = false;
        this.persistSessionCookies = false;
        this.httpCacheEnabled = true;
        this.httpCacheMaxSize = 0;
        this.enableFtpUrlSupport = false;
        this.checkClearTextPermitted = false;
        this.enforceChromeCtPolicy = false;
        this.http09OnNonDefaultPortsEnabled = false;
        this.disableIdleSocketsCloseOnMemoryPressure = false;
        this.pacQuickCheckEnabled = true;
        this.enableCertificateReporting = false;
        this.enableExpectCtReporting = false;
        this.enableDomainReliability = false;
        this.discardDomainReliablityUploads = false;
        this.skipReportingSendPermissionCheck = false;
        this.primaryNetworkContext = false;
    }

    public NetworkContextParams() {
        this(0);
    }

    public static NetworkContextParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NetworkContextParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkContextParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NetworkContextParams result = new NetworkContextParams(elementsOrVersion);
            result.contextName = decoder0.readString(8, true);
            result.userAgent = decoder0.readString(16, false);
            result.acceptLanguage = decoder0.readString(24, false);
            result.enableBrotli = decoder0.readBoolean(32, 0);
            result.enableReferrers = decoder0.readBoolean(32, 1);
            result.validateReferrerPolicyOnInitialRequest = decoder0.readBoolean(32, 2);
            result.enableEncryptedCookies = decoder0.readBoolean(32, 3);
            result.restoreOldSessionCookies = decoder0.readBoolean(32, 4);
            result.persistSessionCookies = decoder0.readBoolean(32, 5);
            result.httpCacheEnabled = decoder0.readBoolean(32, 6);
            result.enableFtpUrlSupport = decoder0.readBoolean(32, 7);
            result.checkClearTextPermitted = decoder0.readBoolean(33, 0);
            result.enforceChromeCtPolicy = decoder0.readBoolean(33, 1);
            result.http09OnNonDefaultPortsEnabled = decoder0.readBoolean(33, 2);
            result.disableIdleSocketsCloseOnMemoryPressure = decoder0.readBoolean(33, 3);
            result.pacQuickCheckEnabled = decoder0.readBoolean(33, 4);
            result.enableCertificateReporting = decoder0.readBoolean(33, 5);
            result.enableExpectCtReporting = decoder0.readBoolean(33, 6);
            result.enableDomainReliability = decoder0.readBoolean(33, 7);
            result.discardDomainReliablityUploads = decoder0.readBoolean(34, 0);
            result.skipReportingSendPermissionCheck = decoder0.readBoolean(34, 1);
            result.primaryNetworkContext = decoder0.readBoolean(34, 2);
            result.httpCacheMaxSize = decoder0.readInt(36);
            result.quicUserAgentId = decoder0.readString(40, false);
            result.proxyResolverFactory = (ProxyResolverFactory) decoder0.readServiceInterface(48, true, ProxyResolverFactory.MANAGER);
            Decoder decoder1 = decoder0.readPointer(56, true);
            result.cookiePath = FilePath.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(64, true);
            result.httpCachePath = FilePath.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(72, true);
            result.httpServerPropertiesPath = FilePath.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(80, true);
            result.transportSecurityPersisterPath = FilePath.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(88, true);
            result.initialSslConfig = SslConfig.decode(decoder15);
            result.sslConfigClientRequest = decoder0.readInterfaceRequest(96, true);
            result.proxyConfigClientRequest = decoder0.readInterfaceRequest(100, true);
            Decoder decoder16 = decoder0.readPointer(104, true);
            result.initialProxyConfig = ProxyConfigWithAnnotation.decode(decoder16);
            Decoder decoder17 = decoder0.readPointer(112, true);
            result.initialCustomProxyConfig = CustomProxyConfig.decode(decoder17);
            result.customProxyConfigClientRequest = decoder0.readInterfaceRequest(120, true);
            result.proxyConfigPollerClient = (ProxyConfigPollerClient) decoder0.readServiceInterface(WebFeature.NAVIGATOR_VENDOR, true, ProxyConfigPollerClient.MANAGER);
            result.proxyErrorClient = (ProxyErrorClient) decoder0.readServiceInterface(132, true, ProxyErrorClient.MANAGER);
            Decoder decoder18 = decoder0.readPointer(144, false);
            DataHeader si1 = decoder18.readDataHeaderForPointerArray(-1);
            result.ctLogs = new CtLogInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder18.readPointer(8 + (8 * i1), false);
                result.ctLogs[i1] = CtLogInfo.decode(decoder2);
            }
            Decoder decoder19 = decoder0.readPointer(152, true);
            result.cookieManagerParams = CookieManagerParams.decode(decoder19);
            result.domainReliabilityUploadReporter = decoder0.readString(HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK, false);
            Decoder decoder110 = decoder0.readPointer(168, true);
            result.reportingDeliveryInterval = TimeDelta.decode(decoder110);
            Decoder decoder111 = decoder0.readPointer(176, false);
            DataHeader si12 = decoder111.readDataHeaderForPointerArray(-1);
            result.corsOriginAccessList = new CorsOriginAccessPatterns[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder111.readPointer(8 + (8 * i12), false);
                result.corsOriginAccessList[i12] = CorsOriginAccessPatterns.decode(decoder22);
            }
            Decoder decoder112 = decoder0.readPointer(WebFeature.INPUT_TYPE_EMAIL_MULTIPLE, false);
            DataHeader si13 = decoder112.readDataHeaderForPointerArray(-1);
            result.corsExemptHeaderList = new String[si13.elementsOrVersion];
            for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                result.corsExemptHeaderList[i13] = decoder112.readString(8 + (8 * i13), false);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.contextName, 8, true);
        encoder0.encode(this.userAgent, 16, false);
        encoder0.encode(this.acceptLanguage, 24, false);
        encoder0.encode(this.enableBrotli, 32, 0);
        encoder0.encode(this.enableReferrers, 32, 1);
        encoder0.encode(this.validateReferrerPolicyOnInitialRequest, 32, 2);
        encoder0.encode(this.enableEncryptedCookies, 32, 3);
        encoder0.encode(this.restoreOldSessionCookies, 32, 4);
        encoder0.encode(this.persistSessionCookies, 32, 5);
        encoder0.encode(this.httpCacheEnabled, 32, 6);
        encoder0.encode(this.enableFtpUrlSupport, 32, 7);
        encoder0.encode(this.checkClearTextPermitted, 33, 0);
        encoder0.encode(this.enforceChromeCtPolicy, 33, 1);
        encoder0.encode(this.http09OnNonDefaultPortsEnabled, 33, 2);
        encoder0.encode(this.disableIdleSocketsCloseOnMemoryPressure, 33, 3);
        encoder0.encode(this.pacQuickCheckEnabled, 33, 4);
        encoder0.encode(this.enableCertificateReporting, 33, 5);
        encoder0.encode(this.enableExpectCtReporting, 33, 6);
        encoder0.encode(this.enableDomainReliability, 33, 7);
        encoder0.encode(this.discardDomainReliablityUploads, 34, 0);
        encoder0.encode(this.skipReportingSendPermissionCheck, 34, 1);
        encoder0.encode(this.primaryNetworkContext, 34, 2);
        encoder0.encode(this.httpCacheMaxSize, 36);
        encoder0.encode(this.quicUserAgentId, 40, false);
        encoder0.encode(this.proxyResolverFactory,48,true, ProxyResolverFactory.MANAGER);
        encoder0.encode((Struct) this.cookiePath, 56, true);
        encoder0.encode((Struct) this.httpCachePath, 64, true);
        encoder0.encode((Struct) this.httpServerPropertiesPath, 72, true);
        encoder0.encode((Struct) this.transportSecurityPersisterPath, 80, true);
        encoder0.encode((Struct) this.initialSslConfig, 88, true);
        encoder0.encode((InterfaceRequest) this.sslConfigClientRequest, 96, true);
        encoder0.encode((InterfaceRequest) this.proxyConfigClientRequest, 100, true);
        encoder0.encode((Struct) this.initialProxyConfig, 104, true);
        encoder0.encode((Struct) this.initialCustomProxyConfig, 112, true);
        encoder0.encode((InterfaceRequest) this.customProxyConfigClientRequest, 120, true);
        encoder0.encode(this.proxyConfigPollerClient, WebFeature.NAVIGATOR_VENDOR, true, ProxyConfigPollerClient.MANAGER);
        encoder0.encode(this.proxyErrorClient,132,true, ProxyErrorClient.MANAGER);
        if (this.ctLogs == null) {
            encoder0.encodeNullPointer(144, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.ctLogs.length, 144, -1);
            for (int i0 = 0; i0 < this.ctLogs.length; i0++) {
                encoder1.encode((Struct) this.ctLogs[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.cookieManagerParams, 152, true);
        encoder0.encode(this.domainReliabilityUploadReporter, HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK, false);
        encoder0.encode((Struct) this.reportingDeliveryInterval, 168, true);
        if (this.corsOriginAccessList == null) {
            encoder0.encodeNullPointer(176, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.corsOriginAccessList.length, 176, -1);
            for (int i02 = 0; i02 < this.corsOriginAccessList.length; i02++) {
                encoder12.encode((Struct) this.corsOriginAccessList[i02], 8 + (8 * i02), false);
            }
        }
        if (this.corsExemptHeaderList == null) {
            encoder0.encodeNullPointer(WebFeature.INPUT_TYPE_EMAIL_MULTIPLE, false);
            return;
        }
        Encoder encoder13 = encoder0.encodePointerArray(this.corsExemptHeaderList.length, WebFeature.INPUT_TYPE_EMAIL_MULTIPLE, -1);
        for (int i03 = 0; i03 < this.corsExemptHeaderList.length; i03++) {
            encoder13.encode(this.corsExemptHeaderList[i03], 8 + (8 * i03), false);
        }
    }
}
