package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.mojo_base.mojom.Value;
import org.chromium.network.mojom.NetworkContext;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal.class */
class NetworkContext_Internal {
    public static final Interface.Manager<NetworkContext, NetworkContext.Proxy> MANAGER = new Interface.Manager<NetworkContext, NetworkContext.Proxy>() { // from class: org.chromium.network.mojom.NetworkContext_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkContext";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkContext.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkContext impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkContext[] buildArray(int size) {
            return new NetworkContext[size];
        }
    };
    private static final int SET_CLIENT_ORDINAL = 0;
    private static final int CREATE_URL_LOADER_FACTORY_ORDINAL = 1;
    private static final int RESET_URL_LOADER_FACTORIES_ORDINAL = 2;
    private static final int GET_COOKIE_MANAGER_ORDINAL = 3;
    private static final int GET_RESTRICTED_COOKIE_MANAGER_ORDINAL = 4;
    private static final int CLEAR_NETWORKING_HISTORY_SINCE_ORDINAL = 5;
    private static final int CLEAR_HTTP_CACHE_ORDINAL = 6;
    private static final int COMPUTE_HTTP_CACHE_SIZE_ORDINAL = 7;
    private static final int NOTIFY_EXTERNAL_CACHE_HIT_ORDINAL = 8;
    private static final int CLEAR_HOST_CACHE_ORDINAL = 9;
    private static final int CLEAR_HTTP_AUTH_CACHE_ORDINAL = 10;
    private static final int CLEAR_REPORTING_CACHE_REPORTS_ORDINAL = 11;
    private static final int CLEAR_REPORTING_CACHE_CLIENTS_ORDINAL = 12;
    private static final int CLEAR_NETWORK_ERROR_LOGGING_ORDINAL = 13;
    private static final int CLEAR_DOMAIN_RELIABILITY_ORDINAL = 14;
    private static final int GET_DOMAIN_RELIABILITY_JSON_ORDINAL = 15;
    private static final int QUEUE_REPORT_ORDINAL = 16;
    private static final int QUEUE_SIGNED_EXCHANGE_REPORT_ORDINAL = 17;
    private static final int CLOSE_ALL_CONNECTIONS_ORDINAL = 18;
    private static final int CLOSE_IDLE_CONNECTIONS_ORDINAL = 19;
    private static final int SET_NETWORK_CONDITIONS_ORDINAL = 20;
    private static final int SET_ACCEPT_LANGUAGE_ORDINAL = 21;
    private static final int SET_ENABLE_REFERRERS_ORDINAL = 22;
    private static final int SET_CT_POLICY_ORDINAL = 23;
    private static final int ADD_EXPECT_CT_ORDINAL = 24;
    private static final int SET_EXPECT_CT_TEST_REPORT_ORDINAL = 25;
    private static final int GET_EXPECT_CT_STATE_ORDINAL = 26;
    private static final int CREATE_UDP_SOCKET_ORDINAL = 27;
    private static final int CREATE_TCP_SERVER_SOCKET_ORDINAL = 28;
    private static final int CREATE_TCP_CONNECTED_SOCKET_ORDINAL = 29;
    private static final int CREATE_TCP_BOUND_SOCKET_ORDINAL = 30;
    private static final int CREATE_PROXY_RESOLVING_SOCKET_FACTORY_ORDINAL = 31;
    private static final int LOOK_UP_PROXY_FOR_URL_ORDINAL = 32;
    private static final int FORCE_RELOAD_PROXY_CONFIG_ORDINAL = 33;
    private static final int CLEAR_BAD_PROXIES_CACHE_ORDINAL = 34;
    private static final int CREATE_WEB_SOCKET_ORDINAL = 35;
    private static final int CREATE_NET_LOG_EXPORTER_ORDINAL = 36;
    private static final int PRECONNECT_SOCKETS_ORDINAL = 37;
    private static final int CREATE_P2P_SOCKET_MANAGER_ORDINAL = 38;
    private static final int CREATE_MDNS_RESPONDER_ORDINAL = 39;
    private static final int RESOLVE_HOST_ORDINAL = 40;
    private static final int CREATE_HOST_RESOLVER_ORDINAL = 41;
    private static final int VERIFY_CERT_FOR_SIGNED_EXCHANGE_ORDINAL = 42;
    private static final int ADD_HSTS_ORDINAL = 43;
    private static final int IS_HSTS_ACTIVE_FOR_HOST_ORDINAL = 44;
    private static final int GET_HSTS_STATE_ORDINAL = 45;
    private static final int SET_CORS_ORIGIN_ACCESS_LISTS_FOR_ORIGIN_ORDINAL = 46;
    private static final int DELETE_DYNAMIC_DATA_FOR_HOST_ORDINAL = 47;
    private static final int SAVE_HTTP_AUTH_CACHE_ORDINAL = 48;
    private static final int LOAD_HTTP_AUTH_CACHE_ORDINAL = 49;
    private static final int ADD_AUTH_CACHE_ENTRY_ORDINAL = 50;
    private static final int LOOKUP_BASIC_AUTH_CREDENTIALS_ORDINAL = 51;
    private static final int ENABLE_STATIC_KEY_PINNING_FOR_TESTING_ORDINAL = 52;
    private static final int SET_FAILING_HTTP_TRANSACTION_FOR_TESTING_ORDINAL = 53;
    private static final int VERIFY_CERTIFICATE_FOR_TESTING_ORDINAL = 54;
    private static final int ADD_DOMAIN_RELIABILITY_CONTEXT_FOR_TESTING_ORDINAL = 55;
    private static final int FORCE_DOMAIN_RELIABILITY_UPLOADS_FOR_TESTING_ORDINAL = 56;
    private static final int GET_ORIGIN_POLICY_MANAGER_ORDINAL = 57;

    NetworkContext_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkContext.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setClient(NetworkContextClient client) {
            NetworkContextSetClientParams _message = new NetworkContextSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createUrlLoaderFactory(InterfaceRequest<UrlLoaderFactory> urlLoaderFactory, UrlLoaderFactoryParams params) {
            NetworkContextCreateUrlLoaderFactoryParams _message = new NetworkContextCreateUrlLoaderFactoryParams();
            _message.urlLoaderFactory = urlLoaderFactory;
            _message.params = params;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void resetUrlLoaderFactories() {
            NetworkContextResetUrlLoaderFactoriesParams _message = new NetworkContextResetUrlLoaderFactoriesParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void getCookieManager(InterfaceRequest<CookieManager> cookieManager) {
            NetworkContextGetCookieManagerParams _message = new NetworkContextGetCookieManagerParams();
            _message.cookieManager = cookieManager;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void getRestrictedCookieManager(InterfaceRequest<RestrictedCookieManager> restrictedCookieManager, int role, Origin origin, boolean isServiceWorker, int processId, int routingId) {
            NetworkContextGetRestrictedCookieManagerParams _message = new NetworkContextGetRestrictedCookieManagerParams();
            _message.restrictedCookieManager = restrictedCookieManager;
            _message.role = role;
            _message.origin = origin;
            _message.isServiceWorker = isServiceWorker;
            _message.processId = processId;
            _message.routingId = routingId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearNetworkingHistorySince(Time startTime, NetworkContext.ClearNetworkingHistorySinceResponse callback) {
            NetworkContextClearNetworkingHistorySinceParams _message = new NetworkContextClearNetworkingHistorySinceParams();
            _message.startTime = startTime;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new NetworkContextClearNetworkingHistorySinceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearHttpCache(Time startTime, Time endTime, ClearDataFilter filter, NetworkContext.ClearHttpCacheResponse callback) {
            NetworkContextClearHttpCacheParams _message = new NetworkContextClearHttpCacheParams();
            _message.startTime = startTime;
            _message.endTime = endTime;
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new NetworkContextClearHttpCacheResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void computeHttpCacheSize(Time startTime, Time endTime, NetworkContext.ComputeHttpCacheSizeResponse callback) {
            NetworkContextComputeHttpCacheSizeParams _message = new NetworkContextComputeHttpCacheSizeParams();
            _message.startTime = startTime;
            _message.endTime = endTime;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void notifyExternalCacheHit(Url url, String httpMethod, Origin topFrameOrigin, Origin frameOrigin) {
            NetworkContextNotifyExternalCacheHitParams _message = new NetworkContextNotifyExternalCacheHitParams();
            _message.url = url;
            _message.httpMethod = httpMethod;
            _message.topFrameOrigin = topFrameOrigin;
            _message.frameOrigin = frameOrigin;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearHostCache(ClearDataFilter filter, NetworkContext.ClearHostCacheResponse callback) {
            NetworkContextClearHostCacheParams _message = new NetworkContextClearHostCacheParams();
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new NetworkContextClearHostCacheResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearHttpAuthCache(Time startTime, NetworkContext.ClearHttpAuthCacheResponse callback) {
            NetworkContextClearHttpAuthCacheParams _message = new NetworkContextClearHttpAuthCacheParams();
            _message.startTime = startTime;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearReportingCacheReports(ClearDataFilter filter, NetworkContext.ClearReportingCacheReportsResponse callback) {
            NetworkContextClearReportingCacheReportsParams _message = new NetworkContextClearReportingCacheReportsParams();
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)), new NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearReportingCacheClients(ClearDataFilter filter, NetworkContext.ClearReportingCacheClientsResponse callback) {
            NetworkContextClearReportingCacheClientsParams _message = new NetworkContextClearReportingCacheClientsParams();
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)), new NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearNetworkErrorLogging(ClearDataFilter filter, NetworkContext.ClearNetworkErrorLoggingResponse callback) {
            NetworkContextClearNetworkErrorLoggingParams _message = new NetworkContextClearNetworkErrorLoggingParams();
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)), new NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearDomainReliability(ClearDataFilter filter, int mode, NetworkContext.ClearDomainReliabilityResponse callback) {
            NetworkContextClearDomainReliabilityParams _message = new NetworkContextClearDomainReliabilityParams();
            _message.filter = filter;
            _message.mode = mode;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)), new NetworkContextClearDomainReliabilityResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void getDomainReliabilityJson(NetworkContext.GetDomainReliabilityJsonResponse callback) {
            NetworkContextGetDomainReliabilityJsonParams _message = new NetworkContextGetDomainReliabilityJsonParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15, 1, 0L)), new NetworkContextGetDomainReliabilityJsonResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void queueReport(String type, String group, Url url, String userAgent, DictionaryValue body) {
            NetworkContextQueueReportParams _message = new NetworkContextQueueReportParams();
            _message.type = type;
            _message.group = group;
            _message.url = url;
            _message.userAgent = userAgent;
            _message.body = body;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void queueSignedExchangeReport(SignedExchangeReport report) {
            NetworkContextQueueSignedExchangeReportParams _message = new NetworkContextQueueSignedExchangeReportParams();
            _message.report = report;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(17)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void closeAllConnections(NetworkContext.CloseAllConnectionsResponse callback) {
            NetworkContextCloseAllConnectionsParams _message = new NetworkContextCloseAllConnectionsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18, 1, 0L)), new NetworkContextCloseAllConnectionsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void closeIdleConnections(NetworkContext.CloseIdleConnectionsResponse callback) {
            NetworkContextCloseIdleConnectionsParams _message = new NetworkContextCloseIdleConnectionsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(19, 1, 0L)), new NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setNetworkConditions(UnguessableToken throttlingProfileId, NetworkConditions conditions) {
            NetworkContextSetNetworkConditionsParams _message = new NetworkContextSetNetworkConditionsParams();
            _message.throttlingProfileId = throttlingProfileId;
            _message.conditions = conditions;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(20)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setAcceptLanguage(String newAcceptLanguage) {
            NetworkContextSetAcceptLanguageParams _message = new NetworkContextSetAcceptLanguageParams();
            _message.newAcceptLanguage = newAcceptLanguage;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(21)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setEnableReferrers(boolean enableReferrers) {
            NetworkContextSetEnableReferrersParams _message = new NetworkContextSetEnableReferrersParams();
            _message.enableReferrers = enableReferrers;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(22)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setCtPolicy(String[] requiredHosts, String[] excludedHosts, String[] excludedSpkis, String[] excludedLegacySpkis) {
            NetworkContextSetCtPolicyParams _message = new NetworkContextSetCtPolicyParams();
            _message.requiredHosts = requiredHosts;
            _message.excludedHosts = excludedHosts;
            _message.excludedSpkis = excludedSpkis;
            _message.excludedLegacySpkis = excludedLegacySpkis;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(23)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void addExpectCt(String host, Time expiry, boolean enforce, Url reportUri, NetworkContext.AddExpectCtResponse callback) {
            NetworkContextAddExpectCtParams _message = new NetworkContextAddExpectCtParams();
            _message.host = host;
            _message.expiry = expiry;
            _message.enforce = enforce;
            _message.reportUri = reportUri;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(24, 1, 0L)), new NetworkContextAddExpectCtResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setExpectCtTestReport(Url reportUri, NetworkContext.SetExpectCtTestReportResponse callback) {
            NetworkContextSetExpectCtTestReportParams _message = new NetworkContextSetExpectCtTestReportParams();
            _message.reportUri = reportUri;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(25, 1, 0L)), new NetworkContextSetExpectCtTestReportResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void getExpectCtState(String domain, NetworkContext.GetExpectCtStateResponse callback) {
            NetworkContextGetExpectCtStateParams _message = new NetworkContextGetExpectCtStateParams();
            _message.domain = domain;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(26, 1, 0L)), new NetworkContextGetExpectCtStateResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createUdpSocket(InterfaceRequest<UdpSocket> request, UdpSocketReceiver receiver) {
            NetworkContextCreateUdpSocketParams _message = new NetworkContextCreateUdpSocketParams();
            _message.request = request;
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(27)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createTcpServerSocket(IpEndPoint localAddr, int backlog, MutableNetworkTrafficAnnotationTag trafficAnnotation, InterfaceRequest<TcpServerSocket> socket, NetworkContext.CreateTcpServerSocketResponse callback) {
            NetworkContextCreateTcpServerSocketParams _message = new NetworkContextCreateTcpServerSocketParams();
            _message.localAddr = localAddr;
            _message.backlog = backlog;
            _message.trafficAnnotation = trafficAnnotation;
            _message.socket = socket;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(28, 1, 0L)), new NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createTcpConnectedSocket(IpEndPoint localAddr, AddressList remoteAddrList, TcpConnectedSocketOptions tcpConnectedSocketOptions, MutableNetworkTrafficAnnotationTag trafficAnnotation, InterfaceRequest<TcpConnectedSocket> socket, SocketObserver observer, NetworkContext.CreateTcpConnectedSocketResponse callback) {
            NetworkContextCreateTcpConnectedSocketParams _message = new NetworkContextCreateTcpConnectedSocketParams();
            _message.localAddr = localAddr;
            _message.remoteAddrList = remoteAddrList;
            _message.tcpConnectedSocketOptions = tcpConnectedSocketOptions;
            _message.trafficAnnotation = trafficAnnotation;
            _message.socket = socket;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(29, 1, 0L)), new NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createTcpBoundSocket(IpEndPoint localAddr, MutableNetworkTrafficAnnotationTag trafficAnnotation, InterfaceRequest<TcpBoundSocket> socket, NetworkContext.CreateTcpBoundSocketResponse callback) {
            NetworkContextCreateTcpBoundSocketParams _message = new NetworkContextCreateTcpBoundSocketParams();
            _message.localAddr = localAddr;
            _message.trafficAnnotation = trafficAnnotation;
            _message.socket = socket;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(30, 1, 0L)), new NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createProxyResolvingSocketFactory(InterfaceRequest<ProxyResolvingSocketFactory> factory) {
            NetworkContextCreateProxyResolvingSocketFactoryParams _message = new NetworkContextCreateProxyResolvingSocketFactoryParams();
            _message.factory = factory;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(31)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void lookUpProxyForUrl(Url url, ProxyLookupClient proxyLookupClient) {
            NetworkContextLookUpProxyForUrlParams _message = new NetworkContextLookUpProxyForUrlParams();
            _message.url = url;
            _message.proxyLookupClient = proxyLookupClient;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(32)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void forceReloadProxyConfig(NetworkContext.ForceReloadProxyConfigResponse callback) {
            NetworkContextForceReloadProxyConfigParams _message = new NetworkContextForceReloadProxyConfigParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(33, 1, 0L)), new NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void clearBadProxiesCache(NetworkContext.ClearBadProxiesCacheResponse callback) {
            NetworkContextClearBadProxiesCacheParams _message = new NetworkContextClearBadProxiesCacheParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(34, 1, 0L)), new NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createWebSocket(Url url, String[] requestedProtocols, Url siteForCookies, HttpHeader[] additionalHeaders, int processId, int renderFrameId, Origin origin, int options, WebSocketHandshakeClient handshakeClient, WebSocketClient connectionClient, AuthenticationHandler authHandler, TrustedHeaderClient headerClient) {
            NetworkContextCreateWebSocketParams _message = new NetworkContextCreateWebSocketParams();
            _message.url = url;
            _message.requestedProtocols = requestedProtocols;
            _message.siteForCookies = siteForCookies;
            _message.additionalHeaders = additionalHeaders;
            _message.processId = processId;
            _message.renderFrameId = renderFrameId;
            _message.origin = origin;
            _message.options = options;
            _message.handshakeClient = handshakeClient;
            _message.connectionClient = connectionClient;
            _message.authHandler = authHandler;
            _message.headerClient = headerClient;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(35)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createNetLogExporter(InterfaceRequest<NetLogExporter> exporter) {
            NetworkContextCreateNetLogExporterParams _message = new NetworkContextCreateNetLogExporterParams();
            _message.exporter = exporter;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(36)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void preconnectSockets(int numStreams, Url url, int loadFlags, boolean privacyModeEnabled, NetworkIsolationKey networkIsolationKey) {
            NetworkContextPreconnectSocketsParams _message = new NetworkContextPreconnectSocketsParams();
            _message.numStreams = numStreams;
            _message.url = url;
            _message.loadFlags = loadFlags;
            _message.privacyModeEnabled = privacyModeEnabled;
            _message.networkIsolationKey = networkIsolationKey;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(37)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createP2pSocketManager(P2pTrustedSocketManagerClient client, InterfaceRequest<P2pTrustedSocketManager> trustedSocketManager, InterfaceRequest<P2pSocketManager> socketManager) {
            NetworkContextCreateP2pSocketManagerParams _message = new NetworkContextCreateP2pSocketManagerParams();
            _message.client = client;
            _message.trustedSocketManager = trustedSocketManager;
            _message.socketManager = socketManager;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(38)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createMdnsResponder(InterfaceRequest<MdnsResponder> responderRequest) {
            NetworkContextCreateMdnsResponderParams _message = new NetworkContextCreateMdnsResponderParams();
            _message.responderRequest = responderRequest;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(39)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void resolveHost(HostPortPair host, ResolveHostParameters optionalParameters, ResolveHostClient responseClient) {
            NetworkContextResolveHostParams _message = new NetworkContextResolveHostParams();
            _message.host = host;
            _message.optionalParameters = optionalParameters;
            _message.responseClient = responseClient;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(40)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void createHostResolver(DnsConfigOverrides configOverrides, InterfaceRequest<HostResolver> hostResolver) {
            NetworkContextCreateHostResolverParams _message = new NetworkContextCreateHostResolverParams();
            _message.configOverrides = configOverrides;
            _message.hostResolver = hostResolver;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(41)));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void verifyCertForSignedExchange(X509Certificate certificate, Url url, String ocspResponse, String sctList, NetworkContext.VerifyCertForSignedExchangeResponse callback) {
            NetworkContextVerifyCertForSignedExchangeParams _message = new NetworkContextVerifyCertForSignedExchangeParams();
            _message.certificate = certificate;
            _message.url = url;
            _message.ocspResponse = ocspResponse;
            _message.sctList = sctList;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(42, 1, 0L)), new NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void addHsts(String host, Time expiry, boolean includeSubdomains, NetworkContext.AddHstsResponse callback) {
            NetworkContextAddHstsParams _message = new NetworkContextAddHstsParams();
            _message.host = host;
            _message.expiry = expiry;
            _message.includeSubdomains = includeSubdomains;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(43, 1, 0L)), new NetworkContextAddHstsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void isHstsActiveForHost(String host, NetworkContext.IsHstsActiveForHostResponse callback) {
            NetworkContextIsHstsActiveForHostParams _message = new NetworkContextIsHstsActiveForHostParams();
            _message.host = host;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(44, 1, 0L)), new NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void getHstsState(String domain, NetworkContext.GetHstsStateResponse callback) {
            NetworkContextGetHstsStateParams _message = new NetworkContextGetHstsStateParams();
            _message.domain = domain;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(45, 1, 0L)), new NetworkContextGetHstsStateResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setCorsOriginAccessListsForOrigin(Origin sourceOrigin, CorsOriginPattern[] allowPatterns, CorsOriginPattern[] blockPatterns, NetworkContext.SetCorsOriginAccessListsForOriginResponse callback) {
            NetworkContextSetCorsOriginAccessListsForOriginParams _message = new NetworkContextSetCorsOriginAccessListsForOriginParams();
            _message.sourceOrigin = sourceOrigin;
            _message.allowPatterns = allowPatterns;
            _message.blockPatterns = blockPatterns;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(46, 1, 0L)), new NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void deleteDynamicDataForHost(String host, NetworkContext.DeleteDynamicDataForHostResponse callback) {
            NetworkContextDeleteDynamicDataForHostParams _message = new NetworkContextDeleteDynamicDataForHostParams();
            _message.host = host;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(47, 1, 0L)), new NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void saveHttpAuthCache(NetworkContext.SaveHttpAuthCacheResponse callback) {
            NetworkContextSaveHttpAuthCacheParams _message = new NetworkContextSaveHttpAuthCacheParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(48, 1, 0L)), new NetworkContextSaveHttpAuthCacheResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void loadHttpAuthCache(UnguessableToken cacheKey, NetworkContext.LoadHttpAuthCacheResponse callback) {
            NetworkContextLoadHttpAuthCacheParams _message = new NetworkContextLoadHttpAuthCacheParams();
            _message.cacheKey = cacheKey;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(49, 1, 0L)), new NetworkContextLoadHttpAuthCacheResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void addAuthCacheEntry(AuthChallengeInfo challenge, AuthCredentials credentials, NetworkContext.AddAuthCacheEntryResponse callback) {
            NetworkContextAddAuthCacheEntryParams _message = new NetworkContextAddAuthCacheEntryParams();
            _message.challenge = challenge;
            _message.credentials = credentials;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(50, 1, 0L)), new NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void lookupBasicAuthCredentials(Url url, NetworkContext.LookupBasicAuthCredentialsResponse callback) {
            NetworkContextLookupBasicAuthCredentialsParams _message = new NetworkContextLookupBasicAuthCredentialsParams();
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(51, 1, 0L)), new NetworkContextLookupBasicAuthCredentialsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void enableStaticKeyPinningForTesting(NetworkContext.EnableStaticKeyPinningForTestingResponse callback) {
            NetworkContextEnableStaticKeyPinningForTestingParams _message = new NetworkContextEnableStaticKeyPinningForTestingParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(52, 1, 0L)), new NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void setFailingHttpTransactionForTesting(int rv, NetworkContext.SetFailingHttpTransactionForTestingResponse callback) {
            NetworkContextSetFailingHttpTransactionForTestingParams _message = new NetworkContextSetFailingHttpTransactionForTestingParams();
            _message.rv = rv;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(53, 1, 0L)), new NetworkContextSetFailingHttpTransactionForTestingResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void verifyCertificateForTesting(X509Certificate certificate, String hostname, String ocspResponse, String sctList, NetworkContext.VerifyCertificateForTestingResponse callback) {
            NetworkContextVerifyCertificateForTestingParams _message = new NetworkContextVerifyCertificateForTestingParams();
            _message.certificate = certificate;
            _message.hostname = hostname;
            _message.ocspResponse = ocspResponse;
            _message.sctList = sctList;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(54, 1, 0L)), new NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void addDomainReliabilityContextForTesting(Url origin, Url uploadUrl, NetworkContext.AddDomainReliabilityContextForTestingResponse callback) {
            NetworkContextAddDomainReliabilityContextForTestingParams _message = new NetworkContextAddDomainReliabilityContextForTestingParams();
            _message.origin = origin;
            _message.uploadUrl = uploadUrl;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(55, 1, 0L)), new NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void forceDomainReliabilityUploadsForTesting(NetworkContext.ForceDomainReliabilityUploadsForTestingResponse callback) {
            NetworkContextForceDomainReliabilityUploadsForTestingParams _message = new NetworkContextForceDomainReliabilityUploadsForTestingParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(56, 1, 0L)), new NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContext
        public void getOriginPolicyManager(InterfaceRequest<OriginPolicyManager> originPolicyManager) {
            NetworkContextGetOriginPolicyManagerParams _message = new NetworkContextGetOriginPolicyManagerParams();
            _message.originPolicyManager = originPolicyManager;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(57)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkContext> {
        Stub(Core core, NetworkContext impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkContext_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 5:
                    case 6:
                    case 7:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 18:
                    case 19:
                    case 24:
                    case 25:
                    case 26:
                    case 28:
                    case 29:
                    case 30:
                    case 33:
                    case 34:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    default:
                        return false;
                    case 0:
                        NetworkContextSetClientParams data = NetworkContextSetClientParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setClient(data.client);
                        return true;
                    case 1:
                        NetworkContextCreateUrlLoaderFactoryParams data2 = NetworkContextCreateUrlLoaderFactoryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createUrlLoaderFactory(data2.urlLoaderFactory, data2.params);
                        return true;
                    case 2:
                        NetworkContextResetUrlLoaderFactoriesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resetUrlLoaderFactories();
                        return true;
                    case 3:
                        NetworkContextGetCookieManagerParams data3 = NetworkContextGetCookieManagerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getCookieManager(data3.cookieManager);
                        return true;
                    case 4:
                        NetworkContextGetRestrictedCookieManagerParams data4 = NetworkContextGetRestrictedCookieManagerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getRestrictedCookieManager(data4.restrictedCookieManager, data4.role, data4.origin, data4.isServiceWorker, data4.processId, data4.routingId);
                        return true;
                    case 8:
                        NetworkContextNotifyExternalCacheHitParams data5 = NetworkContextNotifyExternalCacheHitParams.deserialize(messageWithHeader.getPayload());
                        getImpl().notifyExternalCacheHit(data5.url, data5.httpMethod, data5.topFrameOrigin, data5.frameOrigin);
                        return true;
                    case 16:
                        NetworkContextQueueReportParams data6 = NetworkContextQueueReportParams.deserialize(messageWithHeader.getPayload());
                        getImpl().queueReport(data6.type, data6.group, data6.url, data6.userAgent, data6.body);
                        return true;
                    case 17:
                        NetworkContextQueueSignedExchangeReportParams data7 = NetworkContextQueueSignedExchangeReportParams.deserialize(messageWithHeader.getPayload());
                        getImpl().queueSignedExchangeReport(data7.report);
                        return true;
                    case 20:
                        NetworkContextSetNetworkConditionsParams data8 = NetworkContextSetNetworkConditionsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setNetworkConditions(data8.throttlingProfileId, data8.conditions);
                        return true;
                    case 21:
                        NetworkContextSetAcceptLanguageParams data9 = NetworkContextSetAcceptLanguageParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setAcceptLanguage(data9.newAcceptLanguage);
                        return true;
                    case 22:
                        NetworkContextSetEnableReferrersParams data10 = NetworkContextSetEnableReferrersParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setEnableReferrers(data10.enableReferrers);
                        return true;
                    case 23:
                        NetworkContextSetCtPolicyParams data11 = NetworkContextSetCtPolicyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setCtPolicy(data11.requiredHosts, data11.excludedHosts, data11.excludedSpkis, data11.excludedLegacySpkis);
                        return true;
                    case 27:
                        NetworkContextCreateUdpSocketParams data12 = NetworkContextCreateUdpSocketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createUdpSocket(data12.request, data12.receiver);
                        return true;
                    case 31:
                        NetworkContextCreateProxyResolvingSocketFactoryParams data13 = NetworkContextCreateProxyResolvingSocketFactoryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createProxyResolvingSocketFactory(data13.factory);
                        return true;
                    case 32:
                        NetworkContextLookUpProxyForUrlParams data14 = NetworkContextLookUpProxyForUrlParams.deserialize(messageWithHeader.getPayload());
                        getImpl().lookUpProxyForUrl(data14.url, data14.proxyLookupClient);
                        return true;
                    case 35:
                        NetworkContextCreateWebSocketParams data15 = NetworkContextCreateWebSocketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createWebSocket(data15.url, data15.requestedProtocols, data15.siteForCookies, data15.additionalHeaders, data15.processId, data15.renderFrameId, data15.origin, data15.options, data15.handshakeClient, data15.connectionClient, data15.authHandler, data15.headerClient);
                        return true;
                    case 36:
                        NetworkContextCreateNetLogExporterParams data16 = NetworkContextCreateNetLogExporterParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createNetLogExporter(data16.exporter);
                        return true;
                    case 37:
                        NetworkContextPreconnectSocketsParams data17 = NetworkContextPreconnectSocketsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().preconnectSockets(data17.numStreams, data17.url, data17.loadFlags, data17.privacyModeEnabled, data17.networkIsolationKey);
                        return true;
                    case 38:
                        NetworkContextCreateP2pSocketManagerParams data18 = NetworkContextCreateP2pSocketManagerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createP2pSocketManager(data18.client, data18.trustedSocketManager, data18.socketManager);
                        return true;
                    case 39:
                        NetworkContextCreateMdnsResponderParams data19 = NetworkContextCreateMdnsResponderParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createMdnsResponder(data19.responderRequest);
                        return true;
                    case 40:
                        NetworkContextResolveHostParams data20 = NetworkContextResolveHostParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resolveHost(data20.host, data20.optionalParameters, data20.responseClient);
                        return true;
                    case 41:
                        NetworkContextCreateHostResolverParams data21 = NetworkContextCreateHostResolverParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createHostResolver(data21.configOverrides, data21.hostResolver);
                        return true;
                    case 57:
                        getImpl().getOriginPolicyManager(NetworkContextGetOriginPolicyManagerParams.deserialize(messageWithHeader.getPayload()).originPolicyManager);
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkContext_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 8:
                    case 16:
                    case 17:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 27:
                    case 31:
                    case 32:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    default:
                        return false;
                    case 5:
                        getImpl().clearNetworkingHistorySince(NetworkContextClearNetworkingHistorySinceParams.deserialize(messageWithHeader.getPayload()).startTime, new NetworkContextClearNetworkingHistorySinceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        NetworkContextClearHttpCacheParams data = NetworkContextClearHttpCacheParams.deserialize(messageWithHeader.getPayload());
                        getImpl().clearHttpCache(data.startTime, data.endTime, data.filter, new NetworkContextClearHttpCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        NetworkContextComputeHttpCacheSizeParams data2 = NetworkContextComputeHttpCacheSizeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().computeHttpCacheSize(data2.startTime, data2.endTime, new NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        getImpl().clearHostCache(NetworkContextClearHostCacheParams.deserialize(messageWithHeader.getPayload()).filter, new NetworkContextClearHostCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        getImpl().clearHttpAuthCache(NetworkContextClearHttpAuthCacheParams.deserialize(messageWithHeader.getPayload()).startTime, new NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 11:
                        getImpl().clearReportingCacheReports(NetworkContextClearReportingCacheReportsParams.deserialize(messageWithHeader.getPayload()).filter, new NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                        getImpl().clearReportingCacheClients(NetworkContextClearReportingCacheClientsParams.deserialize(messageWithHeader.getPayload()).filter, new NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 13:
                        getImpl().clearNetworkErrorLogging(NetworkContextClearNetworkErrorLoggingParams.deserialize(messageWithHeader.getPayload()).filter, new NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 14:
                        NetworkContextClearDomainReliabilityParams data3 = NetworkContextClearDomainReliabilityParams.deserialize(messageWithHeader.getPayload());
                        getImpl().clearDomainReliability(data3.filter, data3.mode, new NetworkContextClearDomainReliabilityResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 15:
                        NetworkContextGetDomainReliabilityJsonParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getDomainReliabilityJson(new NetworkContextGetDomainReliabilityJsonResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 18:
                        NetworkContextCloseAllConnectionsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().closeAllConnections(new NetworkContextCloseAllConnectionsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 19:
                        NetworkContextCloseIdleConnectionsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().closeIdleConnections(new NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 24:
                        NetworkContextAddExpectCtParams data4 = NetworkContextAddExpectCtParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addExpectCt(data4.host, data4.expiry, data4.enforce, data4.reportUri, new NetworkContextAddExpectCtResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 25:
                        getImpl().setExpectCtTestReport(NetworkContextSetExpectCtTestReportParams.deserialize(messageWithHeader.getPayload()).reportUri, new NetworkContextSetExpectCtTestReportResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 26:
                        getImpl().getExpectCtState(NetworkContextGetExpectCtStateParams.deserialize(messageWithHeader.getPayload()).domain, new NetworkContextGetExpectCtStateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 28:
                        NetworkContextCreateTcpServerSocketParams data5 = NetworkContextCreateTcpServerSocketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createTcpServerSocket(data5.localAddr, data5.backlog, data5.trafficAnnotation, data5.socket, new NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 29:
                        NetworkContextCreateTcpConnectedSocketParams data6 = NetworkContextCreateTcpConnectedSocketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createTcpConnectedSocket(data6.localAddr, data6.remoteAddrList, data6.tcpConnectedSocketOptions, data6.trafficAnnotation, data6.socket, data6.observer, new NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 30:
                        NetworkContextCreateTcpBoundSocketParams data7 = NetworkContextCreateTcpBoundSocketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createTcpBoundSocket(data7.localAddr, data7.trafficAnnotation, data7.socket, new NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 33:
                        NetworkContextForceReloadProxyConfigParams.deserialize(messageWithHeader.getPayload());
                        getImpl().forceReloadProxyConfig(new NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 34:
                        NetworkContextClearBadProxiesCacheParams.deserialize(messageWithHeader.getPayload());
                        getImpl().clearBadProxiesCache(new NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 42:
                        NetworkContextVerifyCertForSignedExchangeParams data8 = NetworkContextVerifyCertForSignedExchangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().verifyCertForSignedExchange(data8.certificate, data8.url, data8.ocspResponse, data8.sctList, new NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 43:
                        NetworkContextAddHstsParams data9 = NetworkContextAddHstsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addHsts(data9.host, data9.expiry, data9.includeSubdomains, new NetworkContextAddHstsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 44:
                        getImpl().isHstsActiveForHost(NetworkContextIsHstsActiveForHostParams.deserialize(messageWithHeader.getPayload()).host, new NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 45:
                        getImpl().getHstsState(NetworkContextGetHstsStateParams.deserialize(messageWithHeader.getPayload()).domain, new NetworkContextGetHstsStateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 46:
                        NetworkContextSetCorsOriginAccessListsForOriginParams data10 = NetworkContextSetCorsOriginAccessListsForOriginParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setCorsOriginAccessListsForOrigin(data10.sourceOrigin, data10.allowPatterns, data10.blockPatterns, new NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 47:
                        getImpl().deleteDynamicDataForHost(NetworkContextDeleteDynamicDataForHostParams.deserialize(messageWithHeader.getPayload()).host, new NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 48:
                        NetworkContextSaveHttpAuthCacheParams.deserialize(messageWithHeader.getPayload());
                        getImpl().saveHttpAuthCache(new NetworkContextSaveHttpAuthCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 49:
                        getImpl().loadHttpAuthCache(NetworkContextLoadHttpAuthCacheParams.deserialize(messageWithHeader.getPayload()).cacheKey, new NetworkContextLoadHttpAuthCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 50:
                        NetworkContextAddAuthCacheEntryParams data11 = NetworkContextAddAuthCacheEntryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addAuthCacheEntry(data11.challenge, data11.credentials, new NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 51:
                        getImpl().lookupBasicAuthCredentials(NetworkContextLookupBasicAuthCredentialsParams.deserialize(messageWithHeader.getPayload()).url, new NetworkContextLookupBasicAuthCredentialsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 52:
                        NetworkContextEnableStaticKeyPinningForTestingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().enableStaticKeyPinningForTesting(new NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 53:
                        getImpl().setFailingHttpTransactionForTesting(NetworkContextSetFailingHttpTransactionForTestingParams.deserialize(messageWithHeader.getPayload()).rv, new NetworkContextSetFailingHttpTransactionForTestingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 54:
                        NetworkContextVerifyCertificateForTestingParams data12 = NetworkContextVerifyCertificateForTestingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().verifyCertificateForTesting(data12.certificate, data12.hostname, data12.ocspResponse, data12.sctList, new NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 55:
                        NetworkContextAddDomainReliabilityContextForTestingParams data13 = NetworkContextAddDomainReliabilityContextForTestingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addDomainReliabilityContextForTesting(data13.origin, data13.uploadUrl, new NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 56:
                        NetworkContextForceDomainReliabilityUploadsForTestingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().forceDomainReliabilityUploadsForTesting(new NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetClientParams.class */
    static final class NetworkContextSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkContextClient client;

        private NetworkContextSetClientParams(int version) {
            super(16, version);
        }

        public NetworkContextSetClientParams() {
            this(0);
        }

        public static NetworkContextSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetClientParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetClientParams result = new NetworkContextSetClientParams(elementsOrVersion);
                result.client = (NetworkContextClient) decoder0.readServiceInterface(8, false, NetworkContextClient.MANAGER);
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
            encoder0.encode(this.client,8,false, NetworkContextClient.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateUrlLoaderFactoryParams.class */
    static final class NetworkContextCreateUrlLoaderFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<UrlLoaderFactory> urlLoaderFactory;
        public UrlLoaderFactoryParams params;

        private NetworkContextCreateUrlLoaderFactoryParams(int version) {
            super(24, version);
        }

        public NetworkContextCreateUrlLoaderFactoryParams() {
            this(0);
        }

        public static NetworkContextCreateUrlLoaderFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateUrlLoaderFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateUrlLoaderFactoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateUrlLoaderFactoryParams result = new NetworkContextCreateUrlLoaderFactoryParams(elementsOrVersion);
                result.urlLoaderFactory = decoder0.readInterfaceRequest(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.params = UrlLoaderFactoryParams.decode(decoder1);
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
            encoder0.encode((InterfaceRequest) this.urlLoaderFactory, 8, false);
            encoder0.encode((Struct) this.params, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextResetUrlLoaderFactoriesParams.class */
    static final class NetworkContextResetUrlLoaderFactoriesParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextResetUrlLoaderFactoriesParams(int version) {
            super(8, version);
        }

        public NetworkContextResetUrlLoaderFactoriesParams() {
            this(0);
        }

        public static NetworkContextResetUrlLoaderFactoriesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextResetUrlLoaderFactoriesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextResetUrlLoaderFactoriesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextResetUrlLoaderFactoriesParams result = new NetworkContextResetUrlLoaderFactoriesParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetCookieManagerParams.class */
    static final class NetworkContextGetCookieManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<CookieManager> cookieManager;

        private NetworkContextGetCookieManagerParams(int version) {
            super(16, version);
        }

        public NetworkContextGetCookieManagerParams() {
            this(0);
        }

        public static NetworkContextGetCookieManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetCookieManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetCookieManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetCookieManagerParams result = new NetworkContextGetCookieManagerParams(elementsOrVersion);
                result.cookieManager = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.cookieManager, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetRestrictedCookieManagerParams.class */
    static final class NetworkContextGetRestrictedCookieManagerParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<RestrictedCookieManager> restrictedCookieManager;
        public int role;
        public Origin origin;
        public boolean isServiceWorker;
        public int processId;
        public int routingId;

        private NetworkContextGetRestrictedCookieManagerParams(int version) {
            super(40, version);
        }

        public NetworkContextGetRestrictedCookieManagerParams() {
            this(0);
        }

        public static NetworkContextGetRestrictedCookieManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetRestrictedCookieManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetRestrictedCookieManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetRestrictedCookieManagerParams result = new NetworkContextGetRestrictedCookieManagerParams(elementsOrVersion);
                result.restrictedCookieManager = decoder0.readInterfaceRequest(8, false);
                result.role = decoder0.readInt(12);
                RestrictedCookieManagerRole.validate(result.role);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.origin = Origin.decode(decoder1);
                result.isServiceWorker = decoder0.readBoolean(24, 0);
                result.processId = decoder0.readInt(28);
                result.routingId = decoder0.readInt(32);
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
            encoder0.encode((InterfaceRequest) this.restrictedCookieManager, 8, false);
            encoder0.encode(this.role, 12);
            encoder0.encode((Struct) this.origin, 16, false);
            encoder0.encode(this.isServiceWorker, 24, 0);
            encoder0.encode(this.processId, 28);
            encoder0.encode(this.routingId, 32);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkingHistorySinceParams.class */
    static final class NetworkContextClearNetworkingHistorySinceParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Time startTime;

        private NetworkContextClearNetworkingHistorySinceParams(int version) {
            super(16, version);
        }

        public NetworkContextClearNetworkingHistorySinceParams() {
            this(0);
        }

        public static NetworkContextClearNetworkingHistorySinceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearNetworkingHistorySinceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearNetworkingHistorySinceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearNetworkingHistorySinceParams result = new NetworkContextClearNetworkingHistorySinceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.startTime = Time.decode(decoder1);
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
            encoder0.encode((Struct) this.startTime, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkingHistorySinceResponseParams.class */
    static final class NetworkContextClearNetworkingHistorySinceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearNetworkingHistorySinceResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearNetworkingHistorySinceResponseParams() {
            this(0);
        }

        public static NetworkContextClearNetworkingHistorySinceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearNetworkingHistorySinceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearNetworkingHistorySinceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearNetworkingHistorySinceResponseParams result = new NetworkContextClearNetworkingHistorySinceResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkingHistorySinceResponseParamsForwardToCallback.class */
    static class NetworkContextClearNetworkingHistorySinceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearNetworkingHistorySinceResponse mCallback;

        NetworkContextClearNetworkingHistorySinceResponseParamsForwardToCallback(NetworkContext.ClearNetworkingHistorySinceResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkingHistorySinceResponseParamsProxyToResponder.class */
    static class NetworkContextClearNetworkingHistorySinceResponseParamsProxyToResponder implements NetworkContext.ClearNetworkingHistorySinceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearNetworkingHistorySinceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearNetworkingHistorySinceResponseParams _response = new NetworkContextClearNetworkingHistorySinceResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpCacheParams.class */
    static final class NetworkContextClearHttpCacheParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Time startTime;
        public Time endTime;
        public ClearDataFilter filter;

        private NetworkContextClearHttpCacheParams(int version) {
            super(32, version);
        }

        public NetworkContextClearHttpCacheParams() {
            this(0);
        }

        public static NetworkContextClearHttpCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearHttpCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearHttpCacheParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearHttpCacheParams result = new NetworkContextClearHttpCacheParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.startTime = Time.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.endTime = Time.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, true);
                result.filter = ClearDataFilter.decode(decoder13);
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
            encoder0.encode((Struct) this.startTime, 8, false);
            encoder0.encode((Struct) this.endTime, 16, false);
            encoder0.encode((Struct) this.filter, 24, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpCacheResponseParams.class */
    static final class NetworkContextClearHttpCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearHttpCacheResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearHttpCacheResponseParams() {
            this(0);
        }

        public static NetworkContextClearHttpCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearHttpCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearHttpCacheResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearHttpCacheResponseParams result = new NetworkContextClearHttpCacheResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpCacheResponseParamsForwardToCallback.class */
    static class NetworkContextClearHttpCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearHttpCacheResponse mCallback;

        NetworkContextClearHttpCacheResponseParamsForwardToCallback(NetworkContext.ClearHttpCacheResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpCacheResponseParamsProxyToResponder.class */
    static class NetworkContextClearHttpCacheResponseParamsProxyToResponder implements NetworkContext.ClearHttpCacheResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearHttpCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearHttpCacheResponseParams _response = new NetworkContextClearHttpCacheResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextComputeHttpCacheSizeParams.class */
    static final class NetworkContextComputeHttpCacheSizeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Time startTime;
        public Time endTime;

        private NetworkContextComputeHttpCacheSizeParams(int version) {
            super(24, version);
        }

        public NetworkContextComputeHttpCacheSizeParams() {
            this(0);
        }

        public static NetworkContextComputeHttpCacheSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextComputeHttpCacheSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextComputeHttpCacheSizeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextComputeHttpCacheSizeParams result = new NetworkContextComputeHttpCacheSizeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.startTime = Time.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.endTime = Time.decode(decoder12);
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
            encoder0.encode((Struct) this.startTime, 8, false);
            encoder0.encode((Struct) this.endTime, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextComputeHttpCacheSizeResponseParams.class */
    public static final class NetworkContextComputeHttpCacheSizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isUpperBound;
        public long sizeOrError;

        private NetworkContextComputeHttpCacheSizeResponseParams(int version) {
            super(24, version);
        }

        public NetworkContextComputeHttpCacheSizeResponseParams() {
            this(0);
        }

        public static NetworkContextComputeHttpCacheSizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextComputeHttpCacheSizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextComputeHttpCacheSizeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextComputeHttpCacheSizeResponseParams result = new NetworkContextComputeHttpCacheSizeResponseParams(elementsOrVersion);
                result.isUpperBound = decoder0.readBoolean(8, 0);
                result.sizeOrError = decoder0.readLong(16);
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
            encoder0.encode(this.isUpperBound, 8, 0);
            encoder0.encode(this.sizeOrError, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback.class */
    static class NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ComputeHttpCacheSizeResponse mCallback;

        NetworkContextComputeHttpCacheSizeResponseParamsForwardToCallback(NetworkContext.ComputeHttpCacheSizeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2)) {
                    return false;
                }
                NetworkContextComputeHttpCacheSizeResponseParams response = NetworkContextComputeHttpCacheSizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.isUpperBound), Long.valueOf(response.sizeOrError));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder.class */
    static class NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder implements NetworkContext.ComputeHttpCacheSizeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextComputeHttpCacheSizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Boolean isUpperBound, Long sizeOrError) {
            NetworkContextComputeHttpCacheSizeResponseParams _response = new NetworkContextComputeHttpCacheSizeResponseParams();
            _response.isUpperBound = isUpperBound.booleanValue();
            _response.sizeOrError = sizeOrError.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextNotifyExternalCacheHitParams.class */
    static final class NetworkContextNotifyExternalCacheHitParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public String httpMethod;
        public Origin topFrameOrigin;
        public Origin frameOrigin;

        private NetworkContextNotifyExternalCacheHitParams(int version) {
            super(40, version);
        }

        public NetworkContextNotifyExternalCacheHitParams() {
            this(0);
        }

        public static NetworkContextNotifyExternalCacheHitParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextNotifyExternalCacheHitParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextNotifyExternalCacheHitParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextNotifyExternalCacheHitParams result = new NetworkContextNotifyExternalCacheHitParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.httpMethod = decoder0.readString(16, false);
                Decoder decoder12 = decoder0.readPointer(24, true);
                result.topFrameOrigin = Origin.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(32, false);
                result.frameOrigin = Origin.decode(decoder13);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode(this.httpMethod, 16, false);
            encoder0.encode((Struct) this.topFrameOrigin, 24, true);
            encoder0.encode((Struct) this.frameOrigin, 32, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHostCacheParams.class */
    static final class NetworkContextClearHostCacheParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ClearDataFilter filter;

        private NetworkContextClearHostCacheParams(int version) {
            super(16, version);
        }

        public NetworkContextClearHostCacheParams() {
            this(0);
        }

        public static NetworkContextClearHostCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearHostCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearHostCacheParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearHostCacheParams result = new NetworkContextClearHostCacheParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.filter = ClearDataFilter.decode(decoder1);
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
            encoder0.encode((Struct) this.filter, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHostCacheResponseParams.class */
    static final class NetworkContextClearHostCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearHostCacheResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearHostCacheResponseParams() {
            this(0);
        }

        public static NetworkContextClearHostCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearHostCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearHostCacheResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearHostCacheResponseParams result = new NetworkContextClearHostCacheResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHostCacheResponseParamsForwardToCallback.class */
    static class NetworkContextClearHostCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearHostCacheResponse mCallback;

        NetworkContextClearHostCacheResponseParamsForwardToCallback(NetworkContext.ClearHostCacheResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHostCacheResponseParamsProxyToResponder.class */
    static class NetworkContextClearHostCacheResponseParamsProxyToResponder implements NetworkContext.ClearHostCacheResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearHostCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearHostCacheResponseParams _response = new NetworkContextClearHostCacheResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpAuthCacheParams.class */
    static final class NetworkContextClearHttpAuthCacheParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Time startTime;

        private NetworkContextClearHttpAuthCacheParams(int version) {
            super(16, version);
        }

        public NetworkContextClearHttpAuthCacheParams() {
            this(0);
        }

        public static NetworkContextClearHttpAuthCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearHttpAuthCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearHttpAuthCacheParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearHttpAuthCacheParams result = new NetworkContextClearHttpAuthCacheParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.startTime = Time.decode(decoder1);
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
            encoder0.encode((Struct) this.startTime, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpAuthCacheResponseParams.class */
    static final class NetworkContextClearHttpAuthCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearHttpAuthCacheResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearHttpAuthCacheResponseParams() {
            this(0);
        }

        public static NetworkContextClearHttpAuthCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearHttpAuthCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearHttpAuthCacheResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearHttpAuthCacheResponseParams result = new NetworkContextClearHttpAuthCacheResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback.class */
    static class NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearHttpAuthCacheResponse mCallback;

        NetworkContextClearHttpAuthCacheResponseParamsForwardToCallback(NetworkContext.ClearHttpAuthCacheResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder.class */
    static class NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder implements NetworkContext.ClearHttpAuthCacheResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearHttpAuthCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearHttpAuthCacheResponseParams _response = new NetworkContextClearHttpAuthCacheResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheReportsParams.class */
    static final class NetworkContextClearReportingCacheReportsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ClearDataFilter filter;

        private NetworkContextClearReportingCacheReportsParams(int version) {
            super(16, version);
        }

        public NetworkContextClearReportingCacheReportsParams() {
            this(0);
        }

        public static NetworkContextClearReportingCacheReportsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearReportingCacheReportsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearReportingCacheReportsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearReportingCacheReportsParams result = new NetworkContextClearReportingCacheReportsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.filter = ClearDataFilter.decode(decoder1);
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
            encoder0.encode((Struct) this.filter, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheReportsResponseParams.class */
    static final class NetworkContextClearReportingCacheReportsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearReportingCacheReportsResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearReportingCacheReportsResponseParams() {
            this(0);
        }

        public static NetworkContextClearReportingCacheReportsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearReportingCacheReportsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearReportingCacheReportsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearReportingCacheReportsResponseParams result = new NetworkContextClearReportingCacheReportsResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback.class */
    static class NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearReportingCacheReportsResponse mCallback;

        NetworkContextClearReportingCacheReportsResponseParamsForwardToCallback(NetworkContext.ClearReportingCacheReportsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(11, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder.class */
    static class NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder implements NetworkContext.ClearReportingCacheReportsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearReportingCacheReportsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearReportingCacheReportsResponseParams _response = new NetworkContextClearReportingCacheReportsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheClientsParams.class */
    static final class NetworkContextClearReportingCacheClientsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ClearDataFilter filter;

        private NetworkContextClearReportingCacheClientsParams(int version) {
            super(16, version);
        }

        public NetworkContextClearReportingCacheClientsParams() {
            this(0);
        }

        public static NetworkContextClearReportingCacheClientsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearReportingCacheClientsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearReportingCacheClientsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearReportingCacheClientsParams result = new NetworkContextClearReportingCacheClientsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.filter = ClearDataFilter.decode(decoder1);
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
            encoder0.encode((Struct) this.filter, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheClientsResponseParams.class */
    static final class NetworkContextClearReportingCacheClientsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearReportingCacheClientsResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearReportingCacheClientsResponseParams() {
            this(0);
        }

        public static NetworkContextClearReportingCacheClientsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearReportingCacheClientsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearReportingCacheClientsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearReportingCacheClientsResponseParams result = new NetworkContextClearReportingCacheClientsResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback.class */
    static class NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearReportingCacheClientsResponse mCallback;

        NetworkContextClearReportingCacheClientsResponseParamsForwardToCallback(NetworkContext.ClearReportingCacheClientsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(12, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder.class */
    static class NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder implements NetworkContext.ClearReportingCacheClientsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearReportingCacheClientsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearReportingCacheClientsResponseParams _response = new NetworkContextClearReportingCacheClientsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkErrorLoggingParams.class */
    static final class NetworkContextClearNetworkErrorLoggingParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ClearDataFilter filter;

        private NetworkContextClearNetworkErrorLoggingParams(int version) {
            super(16, version);
        }

        public NetworkContextClearNetworkErrorLoggingParams() {
            this(0);
        }

        public static NetworkContextClearNetworkErrorLoggingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearNetworkErrorLoggingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearNetworkErrorLoggingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearNetworkErrorLoggingParams result = new NetworkContextClearNetworkErrorLoggingParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.filter = ClearDataFilter.decode(decoder1);
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
            encoder0.encode((Struct) this.filter, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkErrorLoggingResponseParams.class */
    static final class NetworkContextClearNetworkErrorLoggingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearNetworkErrorLoggingResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearNetworkErrorLoggingResponseParams() {
            this(0);
        }

        public static NetworkContextClearNetworkErrorLoggingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearNetworkErrorLoggingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearNetworkErrorLoggingResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearNetworkErrorLoggingResponseParams result = new NetworkContextClearNetworkErrorLoggingResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback.class */
    static class NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearNetworkErrorLoggingResponse mCallback;

        NetworkContextClearNetworkErrorLoggingResponseParamsForwardToCallback(NetworkContext.ClearNetworkErrorLoggingResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(13, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder.class */
    static class NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder implements NetworkContext.ClearNetworkErrorLoggingResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearNetworkErrorLoggingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearNetworkErrorLoggingResponseParams _response = new NetworkContextClearNetworkErrorLoggingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearDomainReliabilityParams.class */
    static final class NetworkContextClearDomainReliabilityParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ClearDataFilter filter;
        public int mode;

        private NetworkContextClearDomainReliabilityParams(int version) {
            super(24, version);
        }

        public NetworkContextClearDomainReliabilityParams() {
            this(0);
        }

        public static NetworkContextClearDomainReliabilityParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearDomainReliabilityParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearDomainReliabilityParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearDomainReliabilityParams result = new NetworkContextClearDomainReliabilityParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.filter = ClearDataFilter.decode(decoder1);
                result.mode = decoder0.readInt(16);
                NetworkContext.DomainReliabilityClearMode.validate(result.mode);
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
            encoder0.encode((Struct) this.filter, 8, true);
            encoder0.encode(this.mode, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearDomainReliabilityResponseParams.class */
    static final class NetworkContextClearDomainReliabilityResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearDomainReliabilityResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearDomainReliabilityResponseParams() {
            this(0);
        }

        public static NetworkContextClearDomainReliabilityResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearDomainReliabilityResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearDomainReliabilityResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearDomainReliabilityResponseParams result = new NetworkContextClearDomainReliabilityResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearDomainReliabilityResponseParamsForwardToCallback.class */
    static class NetworkContextClearDomainReliabilityResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearDomainReliabilityResponse mCallback;

        NetworkContextClearDomainReliabilityResponseParamsForwardToCallback(NetworkContext.ClearDomainReliabilityResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(14, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearDomainReliabilityResponseParamsProxyToResponder.class */
    static class NetworkContextClearDomainReliabilityResponseParamsProxyToResponder implements NetworkContext.ClearDomainReliabilityResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearDomainReliabilityResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearDomainReliabilityResponseParams _response = new NetworkContextClearDomainReliabilityResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetDomainReliabilityJsonParams.class */
    static final class NetworkContextGetDomainReliabilityJsonParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextGetDomainReliabilityJsonParams(int version) {
            super(8, version);
        }

        public NetworkContextGetDomainReliabilityJsonParams() {
            this(0);
        }

        public static NetworkContextGetDomainReliabilityJsonParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetDomainReliabilityJsonParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetDomainReliabilityJsonParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetDomainReliabilityJsonParams result = new NetworkContextGetDomainReliabilityJsonParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetDomainReliabilityJsonResponseParams.class */
    public static final class NetworkContextGetDomainReliabilityJsonResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Value data;

        private NetworkContextGetDomainReliabilityJsonResponseParams(int version) {
            super(24, version);
        }

        public NetworkContextGetDomainReliabilityJsonResponseParams() {
            this(0);
        }

        public static NetworkContextGetDomainReliabilityJsonResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetDomainReliabilityJsonResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetDomainReliabilityJsonResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetDomainReliabilityJsonResponseParams result = new NetworkContextGetDomainReliabilityJsonResponseParams(elementsOrVersion);
                result.data = Value.decode(decoder0, 8);
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
            encoder0.encode((Union) this.data, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetDomainReliabilityJsonResponseParamsForwardToCallback.class */
    static class NetworkContextGetDomainReliabilityJsonResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.GetDomainReliabilityJsonResponse mCallback;

        NetworkContextGetDomainReliabilityJsonResponseParamsForwardToCallback(NetworkContext.GetDomainReliabilityJsonResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(15, 2)) {
                    return false;
                }
                NetworkContextGetDomainReliabilityJsonResponseParams response = NetworkContextGetDomainReliabilityJsonResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetDomainReliabilityJsonResponseParamsProxyToResponder.class */
    static class NetworkContextGetDomainReliabilityJsonResponseParamsProxyToResponder implements NetworkContext.GetDomainReliabilityJsonResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextGetDomainReliabilityJsonResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Value data) {
            NetworkContextGetDomainReliabilityJsonResponseParams _response = new NetworkContextGetDomainReliabilityJsonResponseParams();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(15, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextQueueReportParams.class */
    static final class NetworkContextQueueReportParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String type;
        public String group;
        public Url url;
        public String userAgent;
        public DictionaryValue body;

        private NetworkContextQueueReportParams(int version) {
            super(48, version);
        }

        public NetworkContextQueueReportParams() {
            this(0);
        }

        public static NetworkContextQueueReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextQueueReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextQueueReportParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextQueueReportParams result = new NetworkContextQueueReportParams(elementsOrVersion);
                result.type = decoder0.readString(8, false);
                result.group = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.url = Url.decode(decoder1);
                result.userAgent = decoder0.readString(32, true);
                Decoder decoder12 = decoder0.readPointer(40, false);
                result.body = DictionaryValue.decode(decoder12);
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
            encoder0.encode(this.type, 8, false);
            encoder0.encode(this.group, 16, false);
            encoder0.encode((Struct) this.url, 24, false);
            encoder0.encode(this.userAgent, 32, true);
            encoder0.encode((Struct) this.body, 40, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextQueueSignedExchangeReportParams.class */
    static final class NetworkContextQueueSignedExchangeReportParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SignedExchangeReport report;

        private NetworkContextQueueSignedExchangeReportParams(int version) {
            super(16, version);
        }

        public NetworkContextQueueSignedExchangeReportParams() {
            this(0);
        }

        public static NetworkContextQueueSignedExchangeReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextQueueSignedExchangeReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextQueueSignedExchangeReportParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextQueueSignedExchangeReportParams result = new NetworkContextQueueSignedExchangeReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.report = SignedExchangeReport.decode(decoder1);
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
            encoder0.encode((Struct) this.report, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseAllConnectionsParams.class */
    static final class NetworkContextCloseAllConnectionsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextCloseAllConnectionsParams(int version) {
            super(8, version);
        }

        public NetworkContextCloseAllConnectionsParams() {
            this(0);
        }

        public static NetworkContextCloseAllConnectionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCloseAllConnectionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCloseAllConnectionsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCloseAllConnectionsParams result = new NetworkContextCloseAllConnectionsParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseAllConnectionsResponseParams.class */
    static final class NetworkContextCloseAllConnectionsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextCloseAllConnectionsResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextCloseAllConnectionsResponseParams() {
            this(0);
        }

        public static NetworkContextCloseAllConnectionsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCloseAllConnectionsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCloseAllConnectionsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCloseAllConnectionsResponseParams result = new NetworkContextCloseAllConnectionsResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseAllConnectionsResponseParamsForwardToCallback.class */
    static class NetworkContextCloseAllConnectionsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.CloseAllConnectionsResponse mCallback;

        NetworkContextCloseAllConnectionsResponseParamsForwardToCallback(NetworkContext.CloseAllConnectionsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(18, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseAllConnectionsResponseParamsProxyToResponder.class */
    static class NetworkContextCloseAllConnectionsResponseParamsProxyToResponder implements NetworkContext.CloseAllConnectionsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextCloseAllConnectionsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextCloseAllConnectionsResponseParams _response = new NetworkContextCloseAllConnectionsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(18, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseIdleConnectionsParams.class */
    static final class NetworkContextCloseIdleConnectionsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextCloseIdleConnectionsParams(int version) {
            super(8, version);
        }

        public NetworkContextCloseIdleConnectionsParams() {
            this(0);
        }

        public static NetworkContextCloseIdleConnectionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCloseIdleConnectionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCloseIdleConnectionsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCloseIdleConnectionsParams result = new NetworkContextCloseIdleConnectionsParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseIdleConnectionsResponseParams.class */
    static final class NetworkContextCloseIdleConnectionsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextCloseIdleConnectionsResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextCloseIdleConnectionsResponseParams() {
            this(0);
        }

        public static NetworkContextCloseIdleConnectionsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCloseIdleConnectionsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCloseIdleConnectionsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCloseIdleConnectionsResponseParams result = new NetworkContextCloseIdleConnectionsResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback.class */
    static class NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.CloseIdleConnectionsResponse mCallback;

        NetworkContextCloseIdleConnectionsResponseParamsForwardToCallback(NetworkContext.CloseIdleConnectionsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(19, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder.class */
    static class NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder implements NetworkContext.CloseIdleConnectionsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextCloseIdleConnectionsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextCloseIdleConnectionsResponseParams _response = new NetworkContextCloseIdleConnectionsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(19, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetNetworkConditionsParams.class */
    static final class NetworkContextSetNetworkConditionsParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken throttlingProfileId;
        public NetworkConditions conditions;

        private NetworkContextSetNetworkConditionsParams(int version) {
            super(24, version);
        }

        public NetworkContextSetNetworkConditionsParams() {
            this(0);
        }

        public static NetworkContextSetNetworkConditionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetNetworkConditionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetNetworkConditionsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetNetworkConditionsParams result = new NetworkContextSetNetworkConditionsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.throttlingProfileId = UnguessableToken.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, true);
                result.conditions = NetworkConditions.decode(decoder12);
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
            encoder0.encode((Struct) this.throttlingProfileId, 8, false);
            encoder0.encode((Struct) this.conditions, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetAcceptLanguageParams.class */
    static final class NetworkContextSetAcceptLanguageParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String newAcceptLanguage;

        private NetworkContextSetAcceptLanguageParams(int version) {
            super(16, version);
        }

        public NetworkContextSetAcceptLanguageParams() {
            this(0);
        }

        public static NetworkContextSetAcceptLanguageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetAcceptLanguageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetAcceptLanguageParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetAcceptLanguageParams result = new NetworkContextSetAcceptLanguageParams(elementsOrVersion);
                result.newAcceptLanguage = decoder0.readString(8, false);
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
            encoder0.encode(this.newAcceptLanguage, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetEnableReferrersParams.class */
    static final class NetworkContextSetEnableReferrersParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean enableReferrers;

        private NetworkContextSetEnableReferrersParams(int version) {
            super(16, version);
        }

        public NetworkContextSetEnableReferrersParams() {
            this(0);
        }

        public static NetworkContextSetEnableReferrersParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetEnableReferrersParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetEnableReferrersParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetEnableReferrersParams result = new NetworkContextSetEnableReferrersParams(elementsOrVersion);
                result.enableReferrers = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.enableReferrers, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetCtPolicyParams.class */
    static final class NetworkContextSetCtPolicyParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String[] requiredHosts;
        public String[] excludedHosts;
        public String[] excludedSpkis;
        public String[] excludedLegacySpkis;

        private NetworkContextSetCtPolicyParams(int version) {
            super(40, version);
        }

        public NetworkContextSetCtPolicyParams() {
            this(0);
        }

        public static NetworkContextSetCtPolicyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetCtPolicyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetCtPolicyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetCtPolicyParams result = new NetworkContextSetCtPolicyParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.requiredHosts = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.requiredHosts[i1] = decoder1.readString(8 + (8 * i1), false);
                }
                Decoder decoder12 = decoder0.readPointer(16, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.excludedHosts = new String[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    result.excludedHosts[i12] = decoder12.readString(8 + (8 * i12), false);
                }
                Decoder decoder13 = decoder0.readPointer(24, false);
                DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
                result.excludedSpkis = new String[si13.elementsOrVersion];
                for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                    result.excludedSpkis[i13] = decoder13.readString(8 + (8 * i13), false);
                }
                Decoder decoder14 = decoder0.readPointer(32, false);
                DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
                result.excludedLegacySpkis = new String[si14.elementsOrVersion];
                for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
                    result.excludedLegacySpkis[i14] = decoder14.readString(8 + (8 * i14), false);
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
            if (this.requiredHosts == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.requiredHosts.length, 8, -1);
                for (int i0 = 0; i0 < this.requiredHosts.length; i0++) {
                    encoder1.encode(this.requiredHosts[i0], 8 + (8 * i0), false);
                }
            }
            if (this.excludedHosts == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder12 = encoder0.encodePointerArray(this.excludedHosts.length, 16, -1);
                for (int i02 = 0; i02 < this.excludedHosts.length; i02++) {
                    encoder12.encode(this.excludedHosts[i02], 8 + (8 * i02), false);
                }
            }
            if (this.excludedSpkis == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder13 = encoder0.encodePointerArray(this.excludedSpkis.length, 24, -1);
                for (int i03 = 0; i03 < this.excludedSpkis.length; i03++) {
                    encoder13.encode(this.excludedSpkis[i03], 8 + (8 * i03), false);
                }
            }
            if (this.excludedLegacySpkis == null) {
                encoder0.encodeNullPointer(32, false);
                return;
            }
            Encoder encoder14 = encoder0.encodePointerArray(this.excludedLegacySpkis.length, 32, -1);
            for (int i04 = 0; i04 < this.excludedLegacySpkis.length; i04++) {
                encoder14.encode(this.excludedLegacySpkis[i04], 8 + (8 * i04), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddExpectCtParams.class */
    static final class NetworkContextAddExpectCtParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;
        public Time expiry;
        public boolean enforce;
        public Url reportUri;

        private NetworkContextAddExpectCtParams(int version) {
            super(40, version);
        }

        public NetworkContextAddExpectCtParams() {
            this(0);
        }

        public static NetworkContextAddExpectCtParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddExpectCtParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddExpectCtParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddExpectCtParams result = new NetworkContextAddExpectCtParams(elementsOrVersion);
                result.host = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.expiry = Time.decode(decoder1);
                result.enforce = decoder0.readBoolean(24, 0);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.reportUri = Url.decode(decoder12);
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
            encoder0.encode(this.host, 8, false);
            encoder0.encode((Struct) this.expiry, 16, false);
            encoder0.encode(this.enforce, 24, 0);
            encoder0.encode((Struct) this.reportUri, 32, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddExpectCtResponseParams.class */
    public static final class NetworkContextAddExpectCtResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private NetworkContextAddExpectCtResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextAddExpectCtResponseParams() {
            this(0);
        }

        public static NetworkContextAddExpectCtResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddExpectCtResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddExpectCtResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddExpectCtResponseParams result = new NetworkContextAddExpectCtResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddExpectCtResponseParamsForwardToCallback.class */
    static class NetworkContextAddExpectCtResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.AddExpectCtResponse mCallback;

        NetworkContextAddExpectCtResponseParamsForwardToCallback(NetworkContext.AddExpectCtResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(24, 2)) {
                    return false;
                }
                NetworkContextAddExpectCtResponseParams response = NetworkContextAddExpectCtResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddExpectCtResponseParamsProxyToResponder.class */
    static class NetworkContextAddExpectCtResponseParamsProxyToResponder implements NetworkContext.AddExpectCtResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextAddExpectCtResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            NetworkContextAddExpectCtResponseParams _response = new NetworkContextAddExpectCtResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(24, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetExpectCtTestReportParams.class */
    static final class NetworkContextSetExpectCtTestReportParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url reportUri;

        private NetworkContextSetExpectCtTestReportParams(int version) {
            super(16, version);
        }

        public NetworkContextSetExpectCtTestReportParams() {
            this(0);
        }

        public static NetworkContextSetExpectCtTestReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetExpectCtTestReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetExpectCtTestReportParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetExpectCtTestReportParams result = new NetworkContextSetExpectCtTestReportParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.reportUri = Url.decode(decoder1);
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
            encoder0.encode((Struct) this.reportUri, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetExpectCtTestReportResponseParams.class */
    public static final class NetworkContextSetExpectCtTestReportResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private NetworkContextSetExpectCtTestReportResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextSetExpectCtTestReportResponseParams() {
            this(0);
        }

        public static NetworkContextSetExpectCtTestReportResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetExpectCtTestReportResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetExpectCtTestReportResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetExpectCtTestReportResponseParams result = new NetworkContextSetExpectCtTestReportResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetExpectCtTestReportResponseParamsForwardToCallback.class */
    static class NetworkContextSetExpectCtTestReportResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.SetExpectCtTestReportResponse mCallback;

        NetworkContextSetExpectCtTestReportResponseParamsForwardToCallback(NetworkContext.SetExpectCtTestReportResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(25, 2)) {
                    return false;
                }
                NetworkContextSetExpectCtTestReportResponseParams response = NetworkContextSetExpectCtTestReportResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetExpectCtTestReportResponseParamsProxyToResponder.class */
    static class NetworkContextSetExpectCtTestReportResponseParamsProxyToResponder implements NetworkContext.SetExpectCtTestReportResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextSetExpectCtTestReportResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            NetworkContextSetExpectCtTestReportResponseParams _response = new NetworkContextSetExpectCtTestReportResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(25, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetExpectCtStateParams.class */
    static final class NetworkContextGetExpectCtStateParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String domain;

        private NetworkContextGetExpectCtStateParams(int version) {
            super(16, version);
        }

        public NetworkContextGetExpectCtStateParams() {
            this(0);
        }

        public static NetworkContextGetExpectCtStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetExpectCtStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetExpectCtStateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetExpectCtStateParams result = new NetworkContextGetExpectCtStateParams(elementsOrVersion);
                result.domain = decoder0.readString(8, false);
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
            encoder0.encode(this.domain, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetExpectCtStateResponseParams.class */
    public static final class NetworkContextGetExpectCtStateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DictionaryValue state;

        private NetworkContextGetExpectCtStateResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextGetExpectCtStateResponseParams() {
            this(0);
        }

        public static NetworkContextGetExpectCtStateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetExpectCtStateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetExpectCtStateResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetExpectCtStateResponseParams result = new NetworkContextGetExpectCtStateResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.state = DictionaryValue.decode(decoder1);
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
            encoder0.encode((Struct) this.state, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetExpectCtStateResponseParamsForwardToCallback.class */
    static class NetworkContextGetExpectCtStateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.GetExpectCtStateResponse mCallback;

        NetworkContextGetExpectCtStateResponseParamsForwardToCallback(NetworkContext.GetExpectCtStateResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(26, 2)) {
                    return false;
                }
                NetworkContextGetExpectCtStateResponseParams response = NetworkContextGetExpectCtStateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.state);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetExpectCtStateResponseParamsProxyToResponder.class */
    static class NetworkContextGetExpectCtStateResponseParamsProxyToResponder implements NetworkContext.GetExpectCtStateResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextGetExpectCtStateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(DictionaryValue state) {
            NetworkContextGetExpectCtStateResponseParams _response = new NetworkContextGetExpectCtStateResponseParams();
            _response.state = state;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(26, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateUdpSocketParams.class */
    static final class NetworkContextCreateUdpSocketParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<UdpSocket> request;
        public UdpSocketReceiver receiver;

        private NetworkContextCreateUdpSocketParams(int version) {
            super(24, version);
        }

        public NetworkContextCreateUdpSocketParams() {
            this(0);
        }

        public static NetworkContextCreateUdpSocketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateUdpSocketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateUdpSocketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateUdpSocketParams result = new NetworkContextCreateUdpSocketParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
                result.receiver = (UdpSocketReceiver) decoder0.readServiceInterface(12, true, UdpSocketReceiver.MANAGER);
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
            encoder0.encode((InterfaceRequest) this.request, 8, false);
            encoder0.encode(this.receiver,12,true, UdpSocketReceiver.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpServerSocketParams.class */
    static final class NetworkContextCreateTcpServerSocketParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint localAddr;
        public int backlog;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;
        public InterfaceRequest<TcpServerSocket> socket;

        private NetworkContextCreateTcpServerSocketParams(int version) {
            super(32, version);
        }

        public NetworkContextCreateTcpServerSocketParams() {
            this(0);
        }

        public static NetworkContextCreateTcpServerSocketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateTcpServerSocketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateTcpServerSocketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateTcpServerSocketParams result = new NetworkContextCreateTcpServerSocketParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.localAddr = IpEndPoint.decode(decoder1);
                result.backlog = decoder0.readInt(16);
                result.socket = decoder0.readInterfaceRequest(20, false);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
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
            encoder0.encode((Struct) this.localAddr, 8, false);
            encoder0.encode(this.backlog, 16);
            encoder0.encode((InterfaceRequest) this.socket, 20, false);
            encoder0.encode((Struct) this.trafficAnnotation, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpServerSocketResponseParams.class */
    public static final class NetworkContextCreateTcpServerSocketResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public IpEndPoint localAddrOut;

        private NetworkContextCreateTcpServerSocketResponseParams(int version) {
            super(24, version);
        }

        public NetworkContextCreateTcpServerSocketResponseParams() {
            this(0);
        }

        public static NetworkContextCreateTcpServerSocketResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateTcpServerSocketResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateTcpServerSocketResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateTcpServerSocketResponseParams result = new NetworkContextCreateTcpServerSocketResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.localAddrOut = IpEndPoint.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.localAddrOut, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback.class */
    static class NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.CreateTcpServerSocketResponse mCallback;

        NetworkContextCreateTcpServerSocketResponseParamsForwardToCallback(NetworkContext.CreateTcpServerSocketResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(28, 2)) {
                    return false;
                }
                NetworkContextCreateTcpServerSocketResponseParams response = NetworkContextCreateTcpServerSocketResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.localAddrOut);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder.class */
    static class NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder implements NetworkContext.CreateTcpServerSocketResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextCreateTcpServerSocketResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, IpEndPoint localAddrOut) {
            NetworkContextCreateTcpServerSocketResponseParams _response = new NetworkContextCreateTcpServerSocketResponseParams();
            _response.result = result.intValue();
            _response.localAddrOut = localAddrOut;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(28, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpConnectedSocketParams.class */
    static final class NetworkContextCreateTcpConnectedSocketParams extends Struct {
        private static final int STRUCT_SIZE = 56;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint localAddr;
        public AddressList remoteAddrList;
        public TcpConnectedSocketOptions tcpConnectedSocketOptions;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;
        public InterfaceRequest<TcpConnectedSocket> socket;
        public SocketObserver observer;

        private NetworkContextCreateTcpConnectedSocketParams(int version) {
            super(56, version);
        }

        public NetworkContextCreateTcpConnectedSocketParams() {
            this(0);
        }

        public static NetworkContextCreateTcpConnectedSocketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateTcpConnectedSocketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateTcpConnectedSocketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateTcpConnectedSocketParams result = new NetworkContextCreateTcpConnectedSocketParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.localAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.remoteAddrList = AddressList.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, true);
                result.tcpConnectedSocketOptions = TcpConnectedSocketOptions.decode(decoder13);
                Decoder decoder14 = decoder0.readPointer(32, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder14);
                result.socket = decoder0.readInterfaceRequest(40, false);
                result.observer = (SocketObserver) decoder0.readServiceInterface(44, true, SocketObserver.MANAGER);
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
            encoder0.encode((Struct) this.localAddr, 8, true);
            encoder0.encode((Struct) this.remoteAddrList, 16, false);
            encoder0.encode((Struct) this.tcpConnectedSocketOptions, 24, true);
            encoder0.encode((Struct) this.trafficAnnotation, 32, false);
            encoder0.encode((InterfaceRequest) this.socket, 40, false);
            encoder0.encode(this.observer,44,true, SocketObserver.MANAGER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpConnectedSocketResponseParams.class */
    public static final class NetworkContextCreateTcpConnectedSocketResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public IpEndPoint localAddr;
        public IpEndPoint peerAddr;
        public DataPipe.ConsumerHandle receiveStream;
        public DataPipe.ProducerHandle sendStream;

        private NetworkContextCreateTcpConnectedSocketResponseParams(int version) {
            super(40, version);
            this.receiveStream = InvalidHandle.INSTANCE;
            this.sendStream = InvalidHandle.INSTANCE;
        }

        public NetworkContextCreateTcpConnectedSocketResponseParams() {
            this(0);
        }

        public static NetworkContextCreateTcpConnectedSocketResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateTcpConnectedSocketResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateTcpConnectedSocketResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateTcpConnectedSocketResponseParams result = new NetworkContextCreateTcpConnectedSocketResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                result.receiveStream = decoder0.readConsumerHandle(12, true);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.localAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, true);
                result.peerAddr = IpEndPoint.decode(decoder12);
                result.sendStream = decoder0.readProducerHandle(32, true);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Handle) this.receiveStream, 12, true);
            encoder0.encode((Struct) this.localAddr, 16, true);
            encoder0.encode((Struct) this.peerAddr, 24, true);
            encoder0.encode((Handle) this.sendStream, 32, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback.class */
    static class NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.CreateTcpConnectedSocketResponse mCallback;

        NetworkContextCreateTcpConnectedSocketResponseParamsForwardToCallback(NetworkContext.CreateTcpConnectedSocketResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(29, 2)) {
                    return false;
                }
                NetworkContextCreateTcpConnectedSocketResponseParams response = NetworkContextCreateTcpConnectedSocketResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.localAddr, response.peerAddr, response.receiveStream, response.sendStream);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder.class */
    static class NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder implements NetworkContext.CreateTcpConnectedSocketResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextCreateTcpConnectedSocketResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback5
        public void call(Integer result, IpEndPoint localAddr, IpEndPoint peerAddr, DataPipe.ConsumerHandle receiveStream, DataPipe.ProducerHandle sendStream) {
            NetworkContextCreateTcpConnectedSocketResponseParams _response = new NetworkContextCreateTcpConnectedSocketResponseParams();
            _response.result = result.intValue();
            _response.localAddr = localAddr;
            _response.peerAddr = peerAddr;
            _response.receiveStream = receiveStream;
            _response.sendStream = sendStream;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(29, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpBoundSocketParams.class */
    static final class NetworkContextCreateTcpBoundSocketParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint localAddr;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;
        public InterfaceRequest<TcpBoundSocket> socket;

        private NetworkContextCreateTcpBoundSocketParams(int version) {
            super(32, version);
        }

        public NetworkContextCreateTcpBoundSocketParams() {
            this(0);
        }

        public static NetworkContextCreateTcpBoundSocketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateTcpBoundSocketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateTcpBoundSocketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateTcpBoundSocketParams result = new NetworkContextCreateTcpBoundSocketParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.localAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
                result.socket = decoder0.readInterfaceRequest(24, false);
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
            encoder0.encode((Struct) this.localAddr, 8, false);
            encoder0.encode((Struct) this.trafficAnnotation, 16, false);
            encoder0.encode((InterfaceRequest) this.socket, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpBoundSocketResponseParams.class */
    public static final class NetworkContextCreateTcpBoundSocketResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public IpEndPoint localAddr;

        private NetworkContextCreateTcpBoundSocketResponseParams(int version) {
            super(24, version);
        }

        public NetworkContextCreateTcpBoundSocketResponseParams() {
            this(0);
        }

        public static NetworkContextCreateTcpBoundSocketResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateTcpBoundSocketResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateTcpBoundSocketResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateTcpBoundSocketResponseParams result = new NetworkContextCreateTcpBoundSocketResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.localAddr = IpEndPoint.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.localAddr, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback.class */
    static class NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.CreateTcpBoundSocketResponse mCallback;

        NetworkContextCreateTcpBoundSocketResponseParamsForwardToCallback(NetworkContext.CreateTcpBoundSocketResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(30, 2)) {
                    return false;
                }
                NetworkContextCreateTcpBoundSocketResponseParams response = NetworkContextCreateTcpBoundSocketResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.localAddr);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder.class */
    static class NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder implements NetworkContext.CreateTcpBoundSocketResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextCreateTcpBoundSocketResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, IpEndPoint localAddr) {
            NetworkContextCreateTcpBoundSocketResponseParams _response = new NetworkContextCreateTcpBoundSocketResponseParams();
            _response.result = result.intValue();
            _response.localAddr = localAddr;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(30, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateProxyResolvingSocketFactoryParams.class */
    static final class NetworkContextCreateProxyResolvingSocketFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<ProxyResolvingSocketFactory> factory;

        private NetworkContextCreateProxyResolvingSocketFactoryParams(int version) {
            super(16, version);
        }

        public NetworkContextCreateProxyResolvingSocketFactoryParams() {
            this(0);
        }

        public static NetworkContextCreateProxyResolvingSocketFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateProxyResolvingSocketFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateProxyResolvingSocketFactoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateProxyResolvingSocketFactoryParams result = new NetworkContextCreateProxyResolvingSocketFactoryParams(elementsOrVersion);
                result.factory = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.factory, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLookUpProxyForUrlParams.class */
    static final class NetworkContextLookUpProxyForUrlParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public ProxyLookupClient proxyLookupClient;

        private NetworkContextLookUpProxyForUrlParams(int version) {
            super(24, version);
        }

        public NetworkContextLookUpProxyForUrlParams() {
            this(0);
        }

        public static NetworkContextLookUpProxyForUrlParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextLookUpProxyForUrlParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextLookUpProxyForUrlParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextLookUpProxyForUrlParams result = new NetworkContextLookUpProxyForUrlParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.proxyLookupClient = (ProxyLookupClient) decoder0.readServiceInterface(16, false, ProxyLookupClient.MANAGER);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode(this.proxyLookupClient,16,false, ProxyLookupClient.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceReloadProxyConfigParams.class */
    static final class NetworkContextForceReloadProxyConfigParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextForceReloadProxyConfigParams(int version) {
            super(8, version);
        }

        public NetworkContextForceReloadProxyConfigParams() {
            this(0);
        }

        public static NetworkContextForceReloadProxyConfigParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextForceReloadProxyConfigParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextForceReloadProxyConfigParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextForceReloadProxyConfigParams result = new NetworkContextForceReloadProxyConfigParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceReloadProxyConfigResponseParams.class */
    static final class NetworkContextForceReloadProxyConfigResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextForceReloadProxyConfigResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextForceReloadProxyConfigResponseParams() {
            this(0);
        }

        public static NetworkContextForceReloadProxyConfigResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextForceReloadProxyConfigResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextForceReloadProxyConfigResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextForceReloadProxyConfigResponseParams result = new NetworkContextForceReloadProxyConfigResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback.class */
    static class NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ForceReloadProxyConfigResponse mCallback;

        NetworkContextForceReloadProxyConfigResponseParamsForwardToCallback(NetworkContext.ForceReloadProxyConfigResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(33, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder.class */
    static class NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder implements NetworkContext.ForceReloadProxyConfigResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextForceReloadProxyConfigResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextForceReloadProxyConfigResponseParams _response = new NetworkContextForceReloadProxyConfigResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(33, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearBadProxiesCacheParams.class */
    static final class NetworkContextClearBadProxiesCacheParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearBadProxiesCacheParams(int version) {
            super(8, version);
        }

        public NetworkContextClearBadProxiesCacheParams() {
            this(0);
        }

        public static NetworkContextClearBadProxiesCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearBadProxiesCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearBadProxiesCacheParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearBadProxiesCacheParams result = new NetworkContextClearBadProxiesCacheParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearBadProxiesCacheResponseParams.class */
    static final class NetworkContextClearBadProxiesCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClearBadProxiesCacheResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClearBadProxiesCacheResponseParams() {
            this(0);
        }

        public static NetworkContextClearBadProxiesCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClearBadProxiesCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClearBadProxiesCacheResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClearBadProxiesCacheResponseParams result = new NetworkContextClearBadProxiesCacheResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback.class */
    static class NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ClearBadProxiesCacheResponse mCallback;

        NetworkContextClearBadProxiesCacheResponseParamsForwardToCallback(NetworkContext.ClearBadProxiesCacheResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(34, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder.class */
    static class NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder implements NetworkContext.ClearBadProxiesCacheResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClearBadProxiesCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClearBadProxiesCacheResponseParams _response = new NetworkContextClearBadProxiesCacheResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(34, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateWebSocketParams.class */
    static final class NetworkContextCreateWebSocketParams extends Struct {
        private static final int STRUCT_SIZE = 96;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(96, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public String[] requestedProtocols;
        public Url siteForCookies;
        public HttpHeader[] additionalHeaders;
        public int processId;
        public int renderFrameId;
        public Origin origin;
        public int options;
        public WebSocketHandshakeClient handshakeClient;
        public WebSocketClient connectionClient;
        public AuthenticationHandler authHandler;
        public TrustedHeaderClient headerClient;

        private NetworkContextCreateWebSocketParams(int version) {
            super(96, version);
        }

        public NetworkContextCreateWebSocketParams() {
            this(0);
        }

        public static NetworkContextCreateWebSocketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateWebSocketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateWebSocketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateWebSocketParams result = new NetworkContextCreateWebSocketParams(elementsOrVersion);
                result.url = Url.decode(decoder0.readPointer(8, false));
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.requestedProtocols = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.requestedProtocols[i1] = decoder1.readString(8 + (8 * i1), false);
                }
                result.siteForCookies = Url.decode(decoder0.readPointer(24, false));
                Decoder decoder12 = decoder0.readPointer(32, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.additionalHeaders = new HttpHeader[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder2 = decoder12.readPointer(8 + (8 * i12), false);
                    result.additionalHeaders[i12] = HttpHeader.decode(decoder2);
                }
                result.processId = decoder0.readInt(40);
                result.renderFrameId = decoder0.readInt(44);
                result.origin = Origin.decode(decoder0.readPointer(48, false));
                result.options = decoder0.readInt(56);
                result.handshakeClient = (WebSocketHandshakeClient) decoder0.readServiceInterface(60, false, WebSocketHandshakeClient.MANAGER);
                result.connectionClient = (WebSocketClient) decoder0.readServiceInterface(68, false, WebSocketClient.MANAGER);
                result.authHandler = (AuthenticationHandler) decoder0.readServiceInterface(76, true, AuthenticationHandler.MANAGER);
                result.headerClient = (TrustedHeaderClient) decoder0.readServiceInterface(84, true, TrustedHeaderClient.MANAGER);
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
            encoder0.encode((Struct) this.url, 8, false);
            if (this.requestedProtocols == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.requestedProtocols.length, 16, -1);
                for (int i0 = 0; i0 < this.requestedProtocols.length; i0++) {
                    encoder1.encode(this.requestedProtocols[i0], 8 + (8 * i0), false);
                }
            }
            encoder0.encode((Struct) this.siteForCookies, 24, false);
            if (this.additionalHeaders == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                Encoder encoder12 = encoder0.encodePointerArray(this.additionalHeaders.length, 32, -1);
                for (int i02 = 0; i02 < this.additionalHeaders.length; i02++) {
                    encoder12.encode((Struct) this.additionalHeaders[i02], 8 + (8 * i02), false);
                }
            }
            encoder0.encode(this.processId, 40);
            encoder0.encode(this.renderFrameId, 44);
            encoder0.encode((Struct) this.origin, 48, false);
            encoder0.encode(this.options, 56);
            encoder0.encode(this.handshakeClient,60,false, WebSocketHandshakeClient.MANAGER);
            encoder0.encode(this.connectionClient,68,false, WebSocketClient.MANAGER);
            encoder0.encode(this.authHandler,76,true, AuthenticationHandler.MANAGER);
            encoder0.encode(this.headerClient,84,true, TrustedHeaderClient.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateNetLogExporterParams.class */
    static final class NetworkContextCreateNetLogExporterParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<NetLogExporter> exporter;

        private NetworkContextCreateNetLogExporterParams(int version) {
            super(16, version);
        }

        public NetworkContextCreateNetLogExporterParams() {
            this(0);
        }

        public static NetworkContextCreateNetLogExporterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateNetLogExporterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateNetLogExporterParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateNetLogExporterParams result = new NetworkContextCreateNetLogExporterParams(elementsOrVersion);
                result.exporter = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.exporter, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextPreconnectSocketsParams.class */
    static final class NetworkContextPreconnectSocketsParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int numStreams;
        public Url url;
        public int loadFlags;
        public boolean privacyModeEnabled;
        public NetworkIsolationKey networkIsolationKey;

        private NetworkContextPreconnectSocketsParams(int version) {
            super(40, version);
        }

        public NetworkContextPreconnectSocketsParams() {
            this(0);
        }

        public static NetworkContextPreconnectSocketsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextPreconnectSocketsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextPreconnectSocketsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextPreconnectSocketsParams result = new NetworkContextPreconnectSocketsParams(elementsOrVersion);
                result.numStreams = decoder0.readInt(8);
                result.loadFlags = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
                result.privacyModeEnabled = decoder0.readBoolean(24, 0);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.networkIsolationKey = NetworkIsolationKey.decode(decoder12);
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
            encoder0.encode(this.numStreams, 8);
            encoder0.encode(this.loadFlags, 12);
            encoder0.encode((Struct) this.url, 16, false);
            encoder0.encode(this.privacyModeEnabled, 24, 0);
            encoder0.encode((Struct) this.networkIsolationKey, 32, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateP2pSocketManagerParams.class */
    static final class NetworkContextCreateP2pSocketManagerParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public P2pTrustedSocketManagerClient client;
        public InterfaceRequest<P2pTrustedSocketManager> trustedSocketManager;
        public InterfaceRequest<P2pSocketManager> socketManager;

        private NetworkContextCreateP2pSocketManagerParams(int version) {
            super(24, version);
        }

        public NetworkContextCreateP2pSocketManagerParams() {
            this(0);
        }

        public static NetworkContextCreateP2pSocketManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateP2pSocketManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateP2pSocketManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateP2pSocketManagerParams result = new NetworkContextCreateP2pSocketManagerParams(elementsOrVersion);
                result.client = (P2pTrustedSocketManagerClient) decoder0.readServiceInterface(8, false, P2pTrustedSocketManagerClient.MANAGER);
                result.trustedSocketManager = decoder0.readInterfaceRequest(16, false);
                result.socketManager = decoder0.readInterfaceRequest(20, false);
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
            encoder0.encode(this.client,8,false, P2pTrustedSocketManagerClient.MANAGER);
            encoder0.encode((InterfaceRequest) this.trustedSocketManager, 16, false);
            encoder0.encode((InterfaceRequest) this.socketManager, 20, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateMdnsResponderParams.class */
    static final class NetworkContextCreateMdnsResponderParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<MdnsResponder> responderRequest;

        private NetworkContextCreateMdnsResponderParams(int version) {
            super(16, version);
        }

        public NetworkContextCreateMdnsResponderParams() {
            this(0);
        }

        public static NetworkContextCreateMdnsResponderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateMdnsResponderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateMdnsResponderParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateMdnsResponderParams result = new NetworkContextCreateMdnsResponderParams(elementsOrVersion);
                result.responderRequest = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.responderRequest, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextResolveHostParams.class */
    static final class NetworkContextResolveHostParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HostPortPair host;
        public ResolveHostParameters optionalParameters;
        public ResolveHostClient responseClient;

        private NetworkContextResolveHostParams(int version) {
            super(32, version);
        }

        public NetworkContextResolveHostParams() {
            this(0);
        }

        public static NetworkContextResolveHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextResolveHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextResolveHostParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextResolveHostParams result = new NetworkContextResolveHostParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.host = HostPortPair.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, true);
                result.optionalParameters = ResolveHostParameters.decode(decoder12);
                result.responseClient = (ResolveHostClient) decoder0.readServiceInterface(24, false, ResolveHostClient.MANAGER);
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
            encoder0.encode((Struct) this.host, 8, false);
            encoder0.encode((Struct) this.optionalParameters, 16, true);
            encoder0.encode(this.responseClient,24,false, ResolveHostClient.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextCreateHostResolverParams.class */
    static final class NetworkContextCreateHostResolverParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DnsConfigOverrides configOverrides;
        public InterfaceRequest<HostResolver> hostResolver;

        private NetworkContextCreateHostResolverParams(int version) {
            super(24, version);
        }

        public NetworkContextCreateHostResolverParams() {
            this(0);
        }

        public static NetworkContextCreateHostResolverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextCreateHostResolverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextCreateHostResolverParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextCreateHostResolverParams result = new NetworkContextCreateHostResolverParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.configOverrides = DnsConfigOverrides.decode(decoder1);
                result.hostResolver = decoder0.readInterfaceRequest(16, false);
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
            encoder0.encode((Struct) this.configOverrides, 8, true);
            encoder0.encode((InterfaceRequest) this.hostResolver, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertForSignedExchangeParams.class */
    static final class NetworkContextVerifyCertForSignedExchangeParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public X509Certificate certificate;
        public Url url;
        public String ocspResponse;
        public String sctList;

        private NetworkContextVerifyCertForSignedExchangeParams(int version) {
            super(40, version);
        }

        public NetworkContextVerifyCertForSignedExchangeParams() {
            this(0);
        }

        public static NetworkContextVerifyCertForSignedExchangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextVerifyCertForSignedExchangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextVerifyCertForSignedExchangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextVerifyCertForSignedExchangeParams result = new NetworkContextVerifyCertForSignedExchangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.certificate = X509Certificate.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder12);
                result.ocspResponse = decoder0.readString(24, false);
                result.sctList = decoder0.readString(32, false);
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
            encoder0.encode((Struct) this.certificate, 8, false);
            encoder0.encode((Struct) this.url, 16, false);
            encoder0.encode(this.ocspResponse, 24, false);
            encoder0.encode(this.sctList, 32, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertForSignedExchangeResponseParams.class */
    public static final class NetworkContextVerifyCertForSignedExchangeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int errorCode;
        public CertVerifyResult cvResult;
        public CtVerifyResult ctResult;

        private NetworkContextVerifyCertForSignedExchangeResponseParams(int version) {
            super(32, version);
        }

        public NetworkContextVerifyCertForSignedExchangeResponseParams() {
            this(0);
        }

        public static NetworkContextVerifyCertForSignedExchangeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextVerifyCertForSignedExchangeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextVerifyCertForSignedExchangeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextVerifyCertForSignedExchangeResponseParams result = new NetworkContextVerifyCertForSignedExchangeResponseParams(elementsOrVersion);
                result.errorCode = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.cvResult = CertVerifyResult.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.ctResult = CtVerifyResult.decode(decoder12);
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
            encoder0.encode(this.errorCode, 8);
            encoder0.encode((Struct) this.cvResult, 16, false);
            encoder0.encode((Struct) this.ctResult, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback.class */
    static class NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.VerifyCertForSignedExchangeResponse mCallback;

        NetworkContextVerifyCertForSignedExchangeResponseParamsForwardToCallback(NetworkContext.VerifyCertForSignedExchangeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(42, 2)) {
                    return false;
                }
                NetworkContextVerifyCertForSignedExchangeResponseParams response = NetworkContextVerifyCertForSignedExchangeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode), response.cvResult, response.ctResult);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder.class */
    static class NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder implements NetworkContext.VerifyCertForSignedExchangeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextVerifyCertForSignedExchangeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback3
        public void call(Integer errorCode, CertVerifyResult cvResult, CtVerifyResult ctResult) {
            NetworkContextVerifyCertForSignedExchangeResponseParams _response = new NetworkContextVerifyCertForSignedExchangeResponseParams();
            _response.errorCode = errorCode.intValue();
            _response.cvResult = cvResult;
            _response.ctResult = ctResult;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(42, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddHstsParams.class */
    static final class NetworkContextAddHstsParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;
        public Time expiry;
        public boolean includeSubdomains;

        private NetworkContextAddHstsParams(int version) {
            super(32, version);
        }

        public NetworkContextAddHstsParams() {
            this(0);
        }

        public static NetworkContextAddHstsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddHstsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddHstsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddHstsParams result = new NetworkContextAddHstsParams(elementsOrVersion);
                result.host = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.expiry = Time.decode(decoder1);
                result.includeSubdomains = decoder0.readBoolean(24, 0);
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
            encoder0.encode(this.host, 8, false);
            encoder0.encode((Struct) this.expiry, 16, false);
            encoder0.encode(this.includeSubdomains, 24, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddHstsResponseParams.class */
    static final class NetworkContextAddHstsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextAddHstsResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextAddHstsResponseParams() {
            this(0);
        }

        public static NetworkContextAddHstsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddHstsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddHstsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddHstsResponseParams result = new NetworkContextAddHstsResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddHstsResponseParamsForwardToCallback.class */
    static class NetworkContextAddHstsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.AddHstsResponse mCallback;

        NetworkContextAddHstsResponseParamsForwardToCallback(NetworkContext.AddHstsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(43, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddHstsResponseParamsProxyToResponder.class */
    static class NetworkContextAddHstsResponseParamsProxyToResponder implements NetworkContext.AddHstsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextAddHstsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextAddHstsResponseParams _response = new NetworkContextAddHstsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(43, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextIsHstsActiveForHostParams.class */
    static final class NetworkContextIsHstsActiveForHostParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;

        private NetworkContextIsHstsActiveForHostParams(int version) {
            super(16, version);
        }

        public NetworkContextIsHstsActiveForHostParams() {
            this(0);
        }

        public static NetworkContextIsHstsActiveForHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextIsHstsActiveForHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextIsHstsActiveForHostParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextIsHstsActiveForHostParams result = new NetworkContextIsHstsActiveForHostParams(elementsOrVersion);
                result.host = decoder0.readString(8, false);
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
            encoder0.encode(this.host, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextIsHstsActiveForHostResponseParams.class */
    public static final class NetworkContextIsHstsActiveForHostResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean result;

        private NetworkContextIsHstsActiveForHostResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextIsHstsActiveForHostResponseParams() {
            this(0);
        }

        public static NetworkContextIsHstsActiveForHostResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextIsHstsActiveForHostResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextIsHstsActiveForHostResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextIsHstsActiveForHostResponseParams result = new NetworkContextIsHstsActiveForHostResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.result, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback.class */
    static class NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.IsHstsActiveForHostResponse mCallback;

        NetworkContextIsHstsActiveForHostResponseParamsForwardToCallback(NetworkContext.IsHstsActiveForHostResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(44, 2)) {
                    return false;
                }
                NetworkContextIsHstsActiveForHostResponseParams response = NetworkContextIsHstsActiveForHostResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder.class */
    static class NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder implements NetworkContext.IsHstsActiveForHostResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextIsHstsActiveForHostResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean result) {
            NetworkContextIsHstsActiveForHostResponseParams _response = new NetworkContextIsHstsActiveForHostResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(44, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetHstsStateParams.class */
    static final class NetworkContextGetHstsStateParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String domain;

        private NetworkContextGetHstsStateParams(int version) {
            super(16, version);
        }

        public NetworkContextGetHstsStateParams() {
            this(0);
        }

        public static NetworkContextGetHstsStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetHstsStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetHstsStateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetHstsStateParams result = new NetworkContextGetHstsStateParams(elementsOrVersion);
                result.domain = decoder0.readString(8, false);
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
            encoder0.encode(this.domain, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetHstsStateResponseParams.class */
    public static final class NetworkContextGetHstsStateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DictionaryValue state;

        private NetworkContextGetHstsStateResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextGetHstsStateResponseParams() {
            this(0);
        }

        public static NetworkContextGetHstsStateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetHstsStateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetHstsStateResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetHstsStateResponseParams result = new NetworkContextGetHstsStateResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.state = DictionaryValue.decode(decoder1);
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
            encoder0.encode((Struct) this.state, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetHstsStateResponseParamsForwardToCallback.class */
    static class NetworkContextGetHstsStateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.GetHstsStateResponse mCallback;

        NetworkContextGetHstsStateResponseParamsForwardToCallback(NetworkContext.GetHstsStateResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(45, 2)) {
                    return false;
                }
                NetworkContextGetHstsStateResponseParams response = NetworkContextGetHstsStateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.state);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetHstsStateResponseParamsProxyToResponder.class */
    static class NetworkContextGetHstsStateResponseParamsProxyToResponder implements NetworkContext.GetHstsStateResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextGetHstsStateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(DictionaryValue state) {
            NetworkContextGetHstsStateResponseParams _response = new NetworkContextGetHstsStateResponseParams();
            _response.state = state;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(45, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetCorsOriginAccessListsForOriginParams.class */
    static final class NetworkContextSetCorsOriginAccessListsForOriginParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Origin sourceOrigin;
        public CorsOriginPattern[] allowPatterns;
        public CorsOriginPattern[] blockPatterns;

        private NetworkContextSetCorsOriginAccessListsForOriginParams(int version) {
            super(32, version);
        }

        public NetworkContextSetCorsOriginAccessListsForOriginParams() {
            this(0);
        }

        public static NetworkContextSetCorsOriginAccessListsForOriginParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetCorsOriginAccessListsForOriginParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetCorsOriginAccessListsForOriginParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetCorsOriginAccessListsForOriginParams result = new NetworkContextSetCorsOriginAccessListsForOriginParams(elementsOrVersion);
                result.sourceOrigin = Origin.decode(decoder0.readPointer(8, false));
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.allowPatterns = new CorsOriginPattern[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.allowPatterns[i1] = CorsOriginPattern.decode(decoder2);
                }
                Decoder decoder12 = decoder0.readPointer(24, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.blockPatterns = new CorsOriginPattern[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                    result.blockPatterns[i12] = CorsOriginPattern.decode(decoder22);
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
            encoder0.encode((Struct) this.sourceOrigin, 8, false);
            if (this.allowPatterns == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.allowPatterns.length, 16, -1);
                for (int i0 = 0; i0 < this.allowPatterns.length; i0++) {
                    encoder1.encode((Struct) this.allowPatterns[i0], 8 + (8 * i0), false);
                }
            }
            if (this.blockPatterns == null) {
                encoder0.encodeNullPointer(24, false);
                return;
            }
            Encoder encoder12 = encoder0.encodePointerArray(this.blockPatterns.length, 24, -1);
            for (int i02 = 0; i02 < this.blockPatterns.length; i02++) {
                encoder12.encode((Struct) this.blockPatterns[i02], 8 + (8 * i02), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetCorsOriginAccessListsForOriginResponseParams.class */
    static final class NetworkContextSetCorsOriginAccessListsForOriginResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextSetCorsOriginAccessListsForOriginResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextSetCorsOriginAccessListsForOriginResponseParams() {
            this(0);
        }

        public static NetworkContextSetCorsOriginAccessListsForOriginResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetCorsOriginAccessListsForOriginResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetCorsOriginAccessListsForOriginResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetCorsOriginAccessListsForOriginResponseParams result = new NetworkContextSetCorsOriginAccessListsForOriginResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback.class */
    static class NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.SetCorsOriginAccessListsForOriginResponse mCallback;

        NetworkContextSetCorsOriginAccessListsForOriginResponseParamsForwardToCallback(NetworkContext.SetCorsOriginAccessListsForOriginResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(46, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder.class */
    static class NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder implements NetworkContext.SetCorsOriginAccessListsForOriginResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextSetCorsOriginAccessListsForOriginResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextSetCorsOriginAccessListsForOriginResponseParams _response = new NetworkContextSetCorsOriginAccessListsForOriginResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(46, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextDeleteDynamicDataForHostParams.class */
    static final class NetworkContextDeleteDynamicDataForHostParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;

        private NetworkContextDeleteDynamicDataForHostParams(int version) {
            super(16, version);
        }

        public NetworkContextDeleteDynamicDataForHostParams() {
            this(0);
        }

        public static NetworkContextDeleteDynamicDataForHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextDeleteDynamicDataForHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextDeleteDynamicDataForHostParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextDeleteDynamicDataForHostParams result = new NetworkContextDeleteDynamicDataForHostParams(elementsOrVersion);
                result.host = decoder0.readString(8, false);
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
            encoder0.encode(this.host, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextDeleteDynamicDataForHostResponseParams.class */
    public static final class NetworkContextDeleteDynamicDataForHostResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean result;

        private NetworkContextDeleteDynamicDataForHostResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextDeleteDynamicDataForHostResponseParams() {
            this(0);
        }

        public static NetworkContextDeleteDynamicDataForHostResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextDeleteDynamicDataForHostResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextDeleteDynamicDataForHostResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextDeleteDynamicDataForHostResponseParams result = new NetworkContextDeleteDynamicDataForHostResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.result, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback.class */
    static class NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.DeleteDynamicDataForHostResponse mCallback;

        NetworkContextDeleteDynamicDataForHostResponseParamsForwardToCallback(NetworkContext.DeleteDynamicDataForHostResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(47, 2)) {
                    return false;
                }
                NetworkContextDeleteDynamicDataForHostResponseParams response = NetworkContextDeleteDynamicDataForHostResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder.class */
    static class NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder implements NetworkContext.DeleteDynamicDataForHostResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextDeleteDynamicDataForHostResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean result) {
            NetworkContextDeleteDynamicDataForHostResponseParams _response = new NetworkContextDeleteDynamicDataForHostResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(47, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSaveHttpAuthCacheParams.class */
    static final class NetworkContextSaveHttpAuthCacheParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextSaveHttpAuthCacheParams(int version) {
            super(8, version);
        }

        public NetworkContextSaveHttpAuthCacheParams() {
            this(0);
        }

        public static NetworkContextSaveHttpAuthCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSaveHttpAuthCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSaveHttpAuthCacheParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSaveHttpAuthCacheParams result = new NetworkContextSaveHttpAuthCacheParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSaveHttpAuthCacheResponseParams.class */
    public static final class NetworkContextSaveHttpAuthCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken cacheKey;

        private NetworkContextSaveHttpAuthCacheResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextSaveHttpAuthCacheResponseParams() {
            this(0);
        }

        public static NetworkContextSaveHttpAuthCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSaveHttpAuthCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSaveHttpAuthCacheResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSaveHttpAuthCacheResponseParams result = new NetworkContextSaveHttpAuthCacheResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cacheKey = UnguessableToken.decode(decoder1);
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
            encoder0.encode((Struct) this.cacheKey, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSaveHttpAuthCacheResponseParamsForwardToCallback.class */
    static class NetworkContextSaveHttpAuthCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.SaveHttpAuthCacheResponse mCallback;

        NetworkContextSaveHttpAuthCacheResponseParamsForwardToCallback(NetworkContext.SaveHttpAuthCacheResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(48, 2)) {
                    return false;
                }
                NetworkContextSaveHttpAuthCacheResponseParams response = NetworkContextSaveHttpAuthCacheResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.cacheKey);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSaveHttpAuthCacheResponseParamsProxyToResponder.class */
    static class NetworkContextSaveHttpAuthCacheResponseParamsProxyToResponder implements NetworkContext.SaveHttpAuthCacheResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextSaveHttpAuthCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(UnguessableToken cacheKey) {
            NetworkContextSaveHttpAuthCacheResponseParams _response = new NetworkContextSaveHttpAuthCacheResponseParams();
            _response.cacheKey = cacheKey;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(48, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLoadHttpAuthCacheParams.class */
    static final class NetworkContextLoadHttpAuthCacheParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken cacheKey;

        private NetworkContextLoadHttpAuthCacheParams(int version) {
            super(16, version);
        }

        public NetworkContextLoadHttpAuthCacheParams() {
            this(0);
        }

        public static NetworkContextLoadHttpAuthCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextLoadHttpAuthCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextLoadHttpAuthCacheParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextLoadHttpAuthCacheParams result = new NetworkContextLoadHttpAuthCacheParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cacheKey = UnguessableToken.decode(decoder1);
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
            encoder0.encode((Struct) this.cacheKey, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLoadHttpAuthCacheResponseParams.class */
    static final class NetworkContextLoadHttpAuthCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextLoadHttpAuthCacheResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextLoadHttpAuthCacheResponseParams() {
            this(0);
        }

        public static NetworkContextLoadHttpAuthCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextLoadHttpAuthCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextLoadHttpAuthCacheResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextLoadHttpAuthCacheResponseParams result = new NetworkContextLoadHttpAuthCacheResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLoadHttpAuthCacheResponseParamsForwardToCallback.class */
    static class NetworkContextLoadHttpAuthCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.LoadHttpAuthCacheResponse mCallback;

        NetworkContextLoadHttpAuthCacheResponseParamsForwardToCallback(NetworkContext.LoadHttpAuthCacheResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(49, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLoadHttpAuthCacheResponseParamsProxyToResponder.class */
    static class NetworkContextLoadHttpAuthCacheResponseParamsProxyToResponder implements NetworkContext.LoadHttpAuthCacheResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextLoadHttpAuthCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextLoadHttpAuthCacheResponseParams _response = new NetworkContextLoadHttpAuthCacheResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(49, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddAuthCacheEntryParams.class */
    static final class NetworkContextAddAuthCacheEntryParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AuthChallengeInfo challenge;
        public AuthCredentials credentials;

        private NetworkContextAddAuthCacheEntryParams(int version) {
            super(24, version);
        }

        public NetworkContextAddAuthCacheEntryParams() {
            this(0);
        }

        public static NetworkContextAddAuthCacheEntryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddAuthCacheEntryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddAuthCacheEntryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddAuthCacheEntryParams result = new NetworkContextAddAuthCacheEntryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.challenge = AuthChallengeInfo.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.credentials = AuthCredentials.decode(decoder12);
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
            encoder0.encode((Struct) this.challenge, 8, false);
            encoder0.encode((Struct) this.credentials, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddAuthCacheEntryResponseParams.class */
    static final class NetworkContextAddAuthCacheEntryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextAddAuthCacheEntryResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextAddAuthCacheEntryResponseParams() {
            this(0);
        }

        public static NetworkContextAddAuthCacheEntryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddAuthCacheEntryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddAuthCacheEntryResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddAuthCacheEntryResponseParams result = new NetworkContextAddAuthCacheEntryResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback.class */
    static class NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.AddAuthCacheEntryResponse mCallback;

        NetworkContextAddAuthCacheEntryResponseParamsForwardToCallback(NetworkContext.AddAuthCacheEntryResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(50, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder.class */
    static class NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder implements NetworkContext.AddAuthCacheEntryResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextAddAuthCacheEntryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextAddAuthCacheEntryResponseParams _response = new NetworkContextAddAuthCacheEntryResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(50, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLookupBasicAuthCredentialsParams.class */
    static final class NetworkContextLookupBasicAuthCredentialsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;

        private NetworkContextLookupBasicAuthCredentialsParams(int version) {
            super(16, version);
        }

        public NetworkContextLookupBasicAuthCredentialsParams() {
            this(0);
        }

        public static NetworkContextLookupBasicAuthCredentialsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextLookupBasicAuthCredentialsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextLookupBasicAuthCredentialsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextLookupBasicAuthCredentialsParams result = new NetworkContextLookupBasicAuthCredentialsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
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
            encoder0.encode((Struct) this.url, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLookupBasicAuthCredentialsResponseParams.class */
    public static final class NetworkContextLookupBasicAuthCredentialsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AuthCredentials credentials;

        private NetworkContextLookupBasicAuthCredentialsResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextLookupBasicAuthCredentialsResponseParams() {
            this(0);
        }

        public static NetworkContextLookupBasicAuthCredentialsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextLookupBasicAuthCredentialsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextLookupBasicAuthCredentialsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextLookupBasicAuthCredentialsResponseParams result = new NetworkContextLookupBasicAuthCredentialsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.credentials = AuthCredentials.decode(decoder1);
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
            encoder0.encode((Struct) this.credentials, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLookupBasicAuthCredentialsResponseParamsForwardToCallback.class */
    static class NetworkContextLookupBasicAuthCredentialsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.LookupBasicAuthCredentialsResponse mCallback;

        NetworkContextLookupBasicAuthCredentialsResponseParamsForwardToCallback(NetworkContext.LookupBasicAuthCredentialsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(51, 2)) {
                    return false;
                }
                NetworkContextLookupBasicAuthCredentialsResponseParams response = NetworkContextLookupBasicAuthCredentialsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.credentials);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextLookupBasicAuthCredentialsResponseParamsProxyToResponder.class */
    static class NetworkContextLookupBasicAuthCredentialsResponseParamsProxyToResponder implements NetworkContext.LookupBasicAuthCredentialsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextLookupBasicAuthCredentialsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(AuthCredentials credentials) {
            NetworkContextLookupBasicAuthCredentialsResponseParams _response = new NetworkContextLookupBasicAuthCredentialsResponseParams();
            _response.credentials = credentials;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(51, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextEnableStaticKeyPinningForTestingParams.class */
    static final class NetworkContextEnableStaticKeyPinningForTestingParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextEnableStaticKeyPinningForTestingParams(int version) {
            super(8, version);
        }

        public NetworkContextEnableStaticKeyPinningForTestingParams() {
            this(0);
        }

        public static NetworkContextEnableStaticKeyPinningForTestingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextEnableStaticKeyPinningForTestingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextEnableStaticKeyPinningForTestingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextEnableStaticKeyPinningForTestingParams result = new NetworkContextEnableStaticKeyPinningForTestingParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextEnableStaticKeyPinningForTestingResponseParams.class */
    static final class NetworkContextEnableStaticKeyPinningForTestingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextEnableStaticKeyPinningForTestingResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextEnableStaticKeyPinningForTestingResponseParams() {
            this(0);
        }

        public static NetworkContextEnableStaticKeyPinningForTestingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextEnableStaticKeyPinningForTestingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextEnableStaticKeyPinningForTestingResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextEnableStaticKeyPinningForTestingResponseParams result = new NetworkContextEnableStaticKeyPinningForTestingResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback.class */
    static class NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.EnableStaticKeyPinningForTestingResponse mCallback;

        NetworkContextEnableStaticKeyPinningForTestingResponseParamsForwardToCallback(NetworkContext.EnableStaticKeyPinningForTestingResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(52, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder.class */
    static class NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder implements NetworkContext.EnableStaticKeyPinningForTestingResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextEnableStaticKeyPinningForTestingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextEnableStaticKeyPinningForTestingResponseParams _response = new NetworkContextEnableStaticKeyPinningForTestingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(52, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetFailingHttpTransactionForTestingParams.class */
    static final class NetworkContextSetFailingHttpTransactionForTestingParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int rv;

        private NetworkContextSetFailingHttpTransactionForTestingParams(int version) {
            super(16, version);
        }

        public NetworkContextSetFailingHttpTransactionForTestingParams() {
            this(0);
        }

        public static NetworkContextSetFailingHttpTransactionForTestingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetFailingHttpTransactionForTestingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetFailingHttpTransactionForTestingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetFailingHttpTransactionForTestingParams result = new NetworkContextSetFailingHttpTransactionForTestingParams(elementsOrVersion);
                result.rv = decoder0.readInt(8);
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
            encoder0.encode(this.rv, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetFailingHttpTransactionForTestingResponseParams.class */
    static final class NetworkContextSetFailingHttpTransactionForTestingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextSetFailingHttpTransactionForTestingResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextSetFailingHttpTransactionForTestingResponseParams() {
            this(0);
        }

        public static NetworkContextSetFailingHttpTransactionForTestingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextSetFailingHttpTransactionForTestingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextSetFailingHttpTransactionForTestingResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextSetFailingHttpTransactionForTestingResponseParams result = new NetworkContextSetFailingHttpTransactionForTestingResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetFailingHttpTransactionForTestingResponseParamsForwardToCallback.class */
    static class NetworkContextSetFailingHttpTransactionForTestingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.SetFailingHttpTransactionForTestingResponse mCallback;

        NetworkContextSetFailingHttpTransactionForTestingResponseParamsForwardToCallback(NetworkContext.SetFailingHttpTransactionForTestingResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(53, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextSetFailingHttpTransactionForTestingResponseParamsProxyToResponder.class */
    static class NetworkContextSetFailingHttpTransactionForTestingResponseParamsProxyToResponder implements NetworkContext.SetFailingHttpTransactionForTestingResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextSetFailingHttpTransactionForTestingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextSetFailingHttpTransactionForTestingResponseParams _response = new NetworkContextSetFailingHttpTransactionForTestingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(53, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertificateForTestingParams.class */
    static final class NetworkContextVerifyCertificateForTestingParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public X509Certificate certificate;
        public String hostname;
        public String ocspResponse;
        public String sctList;

        private NetworkContextVerifyCertificateForTestingParams(int version) {
            super(40, version);
        }

        public NetworkContextVerifyCertificateForTestingParams() {
            this(0);
        }

        public static NetworkContextVerifyCertificateForTestingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextVerifyCertificateForTestingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextVerifyCertificateForTestingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextVerifyCertificateForTestingParams result = new NetworkContextVerifyCertificateForTestingParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.certificate = X509Certificate.decode(decoder1);
                result.hostname = decoder0.readString(16, false);
                result.ocspResponse = decoder0.readString(24, false);
                result.sctList = decoder0.readString(32, false);
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
            encoder0.encode((Struct) this.certificate, 8, false);
            encoder0.encode(this.hostname, 16, false);
            encoder0.encode(this.ocspResponse, 24, false);
            encoder0.encode(this.sctList, 32, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertificateForTestingResponseParams.class */
    public static final class NetworkContextVerifyCertificateForTestingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int errorCode;

        private NetworkContextVerifyCertificateForTestingResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextVerifyCertificateForTestingResponseParams() {
            this(0);
        }

        public static NetworkContextVerifyCertificateForTestingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextVerifyCertificateForTestingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextVerifyCertificateForTestingResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextVerifyCertificateForTestingResponseParams result = new NetworkContextVerifyCertificateForTestingResponseParams(elementsOrVersion);
                result.errorCode = decoder0.readInt(8);
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
            encoder0.encode(this.errorCode, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback.class */
    static class NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.VerifyCertificateForTestingResponse mCallback;

        NetworkContextVerifyCertificateForTestingResponseParamsForwardToCallback(NetworkContext.VerifyCertificateForTestingResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(54, 2)) {
                    return false;
                }
                NetworkContextVerifyCertificateForTestingResponseParams response = NetworkContextVerifyCertificateForTestingResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder.class */
    static class NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder implements NetworkContext.VerifyCertificateForTestingResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextVerifyCertificateForTestingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer errorCode) {
            NetworkContextVerifyCertificateForTestingResponseParams _response = new NetworkContextVerifyCertificateForTestingResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(54, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddDomainReliabilityContextForTestingParams.class */
    static final class NetworkContextAddDomainReliabilityContextForTestingParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url origin;
        public Url uploadUrl;

        private NetworkContextAddDomainReliabilityContextForTestingParams(int version) {
            super(24, version);
        }

        public NetworkContextAddDomainReliabilityContextForTestingParams() {
            this(0);
        }

        public static NetworkContextAddDomainReliabilityContextForTestingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddDomainReliabilityContextForTestingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddDomainReliabilityContextForTestingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddDomainReliabilityContextForTestingParams result = new NetworkContextAddDomainReliabilityContextForTestingParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.uploadUrl = Url.decode(decoder12);
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
            encoder0.encode((Struct) this.origin, 8, false);
            encoder0.encode((Struct) this.uploadUrl, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddDomainReliabilityContextForTestingResponseParams.class */
    static final class NetworkContextAddDomainReliabilityContextForTestingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextAddDomainReliabilityContextForTestingResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextAddDomainReliabilityContextForTestingResponseParams() {
            this(0);
        }

        public static NetworkContextAddDomainReliabilityContextForTestingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextAddDomainReliabilityContextForTestingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextAddDomainReliabilityContextForTestingResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextAddDomainReliabilityContextForTestingResponseParams result = new NetworkContextAddDomainReliabilityContextForTestingResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback.class */
    static class NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.AddDomainReliabilityContextForTestingResponse mCallback;

        NetworkContextAddDomainReliabilityContextForTestingResponseParamsForwardToCallback(NetworkContext.AddDomainReliabilityContextForTestingResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(55, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder.class */
    static class NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder implements NetworkContext.AddDomainReliabilityContextForTestingResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextAddDomainReliabilityContextForTestingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextAddDomainReliabilityContextForTestingResponseParams _response = new NetworkContextAddDomainReliabilityContextForTestingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(55, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceDomainReliabilityUploadsForTestingParams.class */
    static final class NetworkContextForceDomainReliabilityUploadsForTestingParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextForceDomainReliabilityUploadsForTestingParams(int version) {
            super(8, version);
        }

        public NetworkContextForceDomainReliabilityUploadsForTestingParams() {
            this(0);
        }

        public static NetworkContextForceDomainReliabilityUploadsForTestingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextForceDomainReliabilityUploadsForTestingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextForceDomainReliabilityUploadsForTestingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextForceDomainReliabilityUploadsForTestingParams result = new NetworkContextForceDomainReliabilityUploadsForTestingParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceDomainReliabilityUploadsForTestingResponseParams.class */
    static final class NetworkContextForceDomainReliabilityUploadsForTestingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextForceDomainReliabilityUploadsForTestingResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextForceDomainReliabilityUploadsForTestingResponseParams() {
            this(0);
        }

        public static NetworkContextForceDomainReliabilityUploadsForTestingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextForceDomainReliabilityUploadsForTestingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextForceDomainReliabilityUploadsForTestingResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextForceDomainReliabilityUploadsForTestingResponseParams result = new NetworkContextForceDomainReliabilityUploadsForTestingResponseParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback.class */
    static class NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContext.ForceDomainReliabilityUploadsForTestingResponse mCallback;

        NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsForwardToCallback(NetworkContext.ForceDomainReliabilityUploadsForTestingResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(56, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder.class */
    static class NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder implements NetworkContext.ForceDomainReliabilityUploadsForTestingResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextForceDomainReliabilityUploadsForTestingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextForceDomainReliabilityUploadsForTestingResponseParams _response = new NetworkContextForceDomainReliabilityUploadsForTestingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(56, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContext_Internal$NetworkContextGetOriginPolicyManagerParams.class */
    static final class NetworkContextGetOriginPolicyManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<OriginPolicyManager> originPolicyManager;

        private NetworkContextGetOriginPolicyManagerParams(int version) {
            super(16, version);
        }

        public NetworkContextGetOriginPolicyManagerParams() {
            this(0);
        }

        public static NetworkContextGetOriginPolicyManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextGetOriginPolicyManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextGetOriginPolicyManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextGetOriginPolicyManagerParams result = new NetworkContextGetOriginPolicyManagerParams(elementsOrVersion);
                result.originPolicyManager = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.originPolicyManager, 8, false);
        }
    }
}
