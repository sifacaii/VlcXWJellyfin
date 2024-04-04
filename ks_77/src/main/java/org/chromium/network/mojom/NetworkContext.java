package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.mojo_base.mojom.Value;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext.class */
public interface NetworkContext extends Interface {
    public static final Interface.Manager<NetworkContext, Proxy> MANAGER = NetworkContext_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$AddAuthCacheEntryResponse.class */
    public interface AddAuthCacheEntryResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$AddDomainReliabilityContextForTestingResponse.class */
    public interface AddDomainReliabilityContextForTestingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$AddExpectCtResponse.class */
    public interface AddExpectCtResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$AddHstsResponse.class */
    public interface AddHstsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearBadProxiesCacheResponse.class */
    public interface ClearBadProxiesCacheResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearDomainReliabilityResponse.class */
    public interface ClearDomainReliabilityResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearHostCacheResponse.class */
    public interface ClearHostCacheResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearHttpAuthCacheResponse.class */
    public interface ClearHttpAuthCacheResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearHttpCacheResponse.class */
    public interface ClearHttpCacheResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearNetworkErrorLoggingResponse.class */
    public interface ClearNetworkErrorLoggingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearNetworkingHistorySinceResponse.class */
    public interface ClearNetworkingHistorySinceResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearReportingCacheClientsResponse.class */
    public interface ClearReportingCacheClientsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ClearReportingCacheReportsResponse.class */
    public interface ClearReportingCacheReportsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$CloseAllConnectionsResponse.class */
    public interface CloseAllConnectionsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$CloseIdleConnectionsResponse.class */
    public interface CloseIdleConnectionsResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ComputeHttpCacheSizeResponse.class */
    public interface ComputeHttpCacheSizeResponse extends Callbacks.Callback2<Boolean, Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$CreateTcpBoundSocketResponse.class */
    public interface CreateTcpBoundSocketResponse extends Callbacks.Callback2<Integer, IpEndPoint> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$CreateTcpConnectedSocketResponse.class */
    public interface CreateTcpConnectedSocketResponse extends Callbacks.Callback5<Integer, IpEndPoint, IpEndPoint, DataPipe.ConsumerHandle, DataPipe.ProducerHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$CreateTcpServerSocketResponse.class */
    public interface CreateTcpServerSocketResponse extends Callbacks.Callback2<Integer, IpEndPoint> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$DeleteDynamicDataForHostResponse.class */
    public interface DeleteDynamicDataForHostResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$EnableStaticKeyPinningForTestingResponse.class */
    public interface EnableStaticKeyPinningForTestingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ForceDomainReliabilityUploadsForTestingResponse.class */
    public interface ForceDomainReliabilityUploadsForTestingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$ForceReloadProxyConfigResponse.class */
    public interface ForceReloadProxyConfigResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$GetDomainReliabilityJsonResponse.class */
    public interface GetDomainReliabilityJsonResponse extends Callbacks.Callback1<Value> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$GetExpectCtStateResponse.class */
    public interface GetExpectCtStateResponse extends Callbacks.Callback1<DictionaryValue> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$GetHstsStateResponse.class */
    public interface GetHstsStateResponse extends Callbacks.Callback1<DictionaryValue> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$IsHstsActiveForHostResponse.class */
    public interface IsHstsActiveForHostResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$LoadHttpAuthCacheResponse.class */
    public interface LoadHttpAuthCacheResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$LookupBasicAuthCredentialsResponse.class */
    public interface LookupBasicAuthCredentialsResponse extends Callbacks.Callback1<AuthCredentials> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$Proxy.class */
    public interface Proxy extends NetworkContext, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$SaveHttpAuthCacheResponse.class */
    public interface SaveHttpAuthCacheResponse extends Callbacks.Callback1<UnguessableToken> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$SetCorsOriginAccessListsForOriginResponse.class */
    public interface SetCorsOriginAccessListsForOriginResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$SetExpectCtTestReportResponse.class */
    public interface SetExpectCtTestReportResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$SetFailingHttpTransactionForTestingResponse.class */
    public interface SetFailingHttpTransactionForTestingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$VerifyCertForSignedExchangeResponse.class */
    public interface VerifyCertForSignedExchangeResponse extends Callbacks.Callback3<Integer, CertVerifyResult, CtVerifyResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$VerifyCertificateForTestingResponse.class */
    public interface VerifyCertificateForTestingResponse extends Callbacks.Callback1<Integer> {
    }

    void setClient(NetworkContextClient networkContextClient);

    void createUrlLoaderFactory(InterfaceRequest<UrlLoaderFactory> interfaceRequest, UrlLoaderFactoryParams urlLoaderFactoryParams);

    void resetUrlLoaderFactories();

    void getCookieManager(InterfaceRequest<CookieManager> interfaceRequest);

    void getRestrictedCookieManager(InterfaceRequest<RestrictedCookieManager> interfaceRequest, int i, Origin origin, boolean z, int i2, int i3);

    void clearNetworkingHistorySince(Time time, ClearNetworkingHistorySinceResponse clearNetworkingHistorySinceResponse);

    void clearHttpCache(Time time, Time time2, ClearDataFilter clearDataFilter, ClearHttpCacheResponse clearHttpCacheResponse);

    void computeHttpCacheSize(Time time, Time time2, ComputeHttpCacheSizeResponse computeHttpCacheSizeResponse);

    void notifyExternalCacheHit(Url url, String str, Origin origin, Origin origin2);

    void clearHostCache(ClearDataFilter clearDataFilter, ClearHostCacheResponse clearHostCacheResponse);

    void clearHttpAuthCache(Time time, ClearHttpAuthCacheResponse clearHttpAuthCacheResponse);

    void clearReportingCacheReports(ClearDataFilter clearDataFilter, ClearReportingCacheReportsResponse clearReportingCacheReportsResponse);

    void clearReportingCacheClients(ClearDataFilter clearDataFilter, ClearReportingCacheClientsResponse clearReportingCacheClientsResponse);

    void clearNetworkErrorLogging(ClearDataFilter clearDataFilter, ClearNetworkErrorLoggingResponse clearNetworkErrorLoggingResponse);

    void clearDomainReliability(ClearDataFilter clearDataFilter, int i, ClearDomainReliabilityResponse clearDomainReliabilityResponse);

    void getDomainReliabilityJson(GetDomainReliabilityJsonResponse getDomainReliabilityJsonResponse);

    void queueReport(String str, String str2, Url url, String str3, DictionaryValue dictionaryValue);

    void queueSignedExchangeReport(SignedExchangeReport signedExchangeReport);

    void closeAllConnections(CloseAllConnectionsResponse closeAllConnectionsResponse);

    void closeIdleConnections(CloseIdleConnectionsResponse closeIdleConnectionsResponse);

    void setNetworkConditions(UnguessableToken unguessableToken, NetworkConditions networkConditions);

    void setAcceptLanguage(String str);

    void setEnableReferrers(boolean z);

    void setCtPolicy(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4);

    void addExpectCt(String str, Time time, boolean z, Url url, AddExpectCtResponse addExpectCtResponse);

    void setExpectCtTestReport(Url url, SetExpectCtTestReportResponse setExpectCtTestReportResponse);

    void getExpectCtState(String str, GetExpectCtStateResponse getExpectCtStateResponse);

    void createUdpSocket(InterfaceRequest<UdpSocket> interfaceRequest, UdpSocketReceiver udpSocketReceiver);

    void createTcpServerSocket(IpEndPoint ipEndPoint, int i, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, InterfaceRequest<TcpServerSocket> interfaceRequest, CreateTcpServerSocketResponse createTcpServerSocketResponse);

    void createTcpConnectedSocket(IpEndPoint ipEndPoint, AddressList addressList, TcpConnectedSocketOptions tcpConnectedSocketOptions, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, InterfaceRequest<TcpConnectedSocket> interfaceRequest, SocketObserver socketObserver, CreateTcpConnectedSocketResponse createTcpConnectedSocketResponse);

    void createTcpBoundSocket(IpEndPoint ipEndPoint, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, InterfaceRequest<TcpBoundSocket> interfaceRequest, CreateTcpBoundSocketResponse createTcpBoundSocketResponse);

    void createProxyResolvingSocketFactory(InterfaceRequest<ProxyResolvingSocketFactory> interfaceRequest);

    void lookUpProxyForUrl(Url url, ProxyLookupClient proxyLookupClient);

    void forceReloadProxyConfig(ForceReloadProxyConfigResponse forceReloadProxyConfigResponse);

    void clearBadProxiesCache(ClearBadProxiesCacheResponse clearBadProxiesCacheResponse);

    void createWebSocket(Url url, String[] strArr, Url url2, HttpHeader[] httpHeaderArr, int i, int i2, Origin origin, int i3, WebSocketHandshakeClient webSocketHandshakeClient, WebSocketClient webSocketClient, AuthenticationHandler authenticationHandler, TrustedHeaderClient trustedHeaderClient);

    void createNetLogExporter(InterfaceRequest<NetLogExporter> interfaceRequest);

    void preconnectSockets(int i, Url url, int i2, boolean z, NetworkIsolationKey networkIsolationKey);

    void createP2pSocketManager(P2pTrustedSocketManagerClient p2pTrustedSocketManagerClient, InterfaceRequest<P2pTrustedSocketManager> interfaceRequest, InterfaceRequest<P2pSocketManager> interfaceRequest2);

    void createMdnsResponder(InterfaceRequest<MdnsResponder> interfaceRequest);

    void resolveHost(HostPortPair hostPortPair, ResolveHostParameters resolveHostParameters, ResolveHostClient resolveHostClient);

    void createHostResolver(DnsConfigOverrides dnsConfigOverrides, InterfaceRequest<HostResolver> interfaceRequest);

    void verifyCertForSignedExchange(X509Certificate x509Certificate, Url url, String str, String str2, VerifyCertForSignedExchangeResponse verifyCertForSignedExchangeResponse);

    void addHsts(String str, Time time, boolean z, AddHstsResponse addHstsResponse);

    void isHstsActiveForHost(String str, IsHstsActiveForHostResponse isHstsActiveForHostResponse);

    void getHstsState(String str, GetHstsStateResponse getHstsStateResponse);

    void setCorsOriginAccessListsForOrigin(Origin origin, CorsOriginPattern[] corsOriginPatternArr, CorsOriginPattern[] corsOriginPatternArr2, SetCorsOriginAccessListsForOriginResponse setCorsOriginAccessListsForOriginResponse);

    void deleteDynamicDataForHost(String str, DeleteDynamicDataForHostResponse deleteDynamicDataForHostResponse);

    void saveHttpAuthCache(SaveHttpAuthCacheResponse saveHttpAuthCacheResponse);

    void loadHttpAuthCache(UnguessableToken unguessableToken, LoadHttpAuthCacheResponse loadHttpAuthCacheResponse);

    void addAuthCacheEntry(AuthChallengeInfo authChallengeInfo, AuthCredentials authCredentials, AddAuthCacheEntryResponse addAuthCacheEntryResponse);

    void lookupBasicAuthCredentials(Url url, LookupBasicAuthCredentialsResponse lookupBasicAuthCredentialsResponse);

    void enableStaticKeyPinningForTesting(EnableStaticKeyPinningForTestingResponse enableStaticKeyPinningForTestingResponse);

    void setFailingHttpTransactionForTesting(int i, SetFailingHttpTransactionForTestingResponse setFailingHttpTransactionForTestingResponse);

    void verifyCertificateForTesting(X509Certificate x509Certificate, String str, String str2, String str3, VerifyCertificateForTestingResponse verifyCertificateForTestingResponse);

    void addDomainReliabilityContextForTesting(Url url, Url url2, AddDomainReliabilityContextForTestingResponse addDomainReliabilityContextForTestingResponse);

    void forceDomainReliabilityUploadsForTesting(ForceDomainReliabilityUploadsForTestingResponse forceDomainReliabilityUploadsForTestingResponse);

    void getOriginPolicyManager(InterfaceRequest<OriginPolicyManager> interfaceRequest);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext$DomainReliabilityClearMode.class */
    public static final class DomainReliabilityClearMode {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int CLEAR_CONTEXTS = 0;
        public static final int CLEAR_BEACONS = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private DomainReliabilityClearMode() {
        }
    }
}
