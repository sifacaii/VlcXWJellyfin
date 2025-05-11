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
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ApplicationState;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.MemoryPressureLevel;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.network.mojom.NetworkService;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal.class */
class NetworkService_Internal {
    public static final Interface.Manager<NetworkService, NetworkService.Proxy> MANAGER = new Interface.Manager<NetworkService, NetworkService.Proxy>() { // from class: org.chromium.network.mojom.NetworkService_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkService";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkService.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkService impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkService[] buildArray(int size) {
            return new NetworkService[size];
        }
    };
    private static final int SET_CLIENT_ORDINAL = 0;
    private static final int START_NET_LOG_ORDINAL = 1;
    private static final int SET_SSL_KEY_LOG_FILE_ORDINAL = 2;
    private static final int CREATE_NETWORK_CONTEXT_ORDINAL = 3;
    private static final int CONFIGURE_STUB_HOST_RESOLVER_ORDINAL = 4;
    private static final int DISABLE_QUIC_ORDINAL = 5;
    private static final int SET_UP_HTTP_AUTH_ORDINAL = 6;
    private static final int CONFIGURE_HTTP_AUTH_PREFS_ORDINAL = 7;
    private static final int SET_RAW_HEADERS_ACCESS_ORDINAL = 8;
    private static final int SET_MAX_CONNECTIONS_PER_PROXY_ORDINAL = 9;
    private static final int GET_NETWORK_CHANGE_MANAGER_ORDINAL = 10;
    private static final int GET_NETWORK_QUALITY_ESTIMATOR_MANAGER_ORDINAL = 11;
    private static final int GET_DNS_CONFIG_CHANGE_MANAGER_ORDINAL = 12;
    private static final int GET_TOTAL_NETWORK_USAGES_ORDINAL = 13;
    private static final int GET_NETWORK_LIST_ORDINAL = 14;
    private static final int UPDATE_CRL_SET_ORDINAL = 15;
    private static final int ON_CERT_DB_CHANGED_ORDINAL = 16;
    private static final int ADD_CORB_EXCEPTION_FOR_PLUGIN_ORDINAL = 17;
    private static final int REMOVE_CORB_EXCEPTION_FOR_PLUGIN_ORDINAL = 18;
    private static final int ADD_EXTRA_MIME_TYPES_FOR_CORB_ORDINAL = 19;
    private static final int ON_MEMORY_PRESSURE_ORDINAL = 20;
    private static final int ON_PEER_TO_PEER_CONNECTIONS_COUNT_CHANGE_ORDINAL = 21;
    private static final int ON_APPLICATION_STATE_CHANGE_ORDINAL = 22;
    private static final int SET_ENVIRONMENT_ORDINAL = 23;
    private static final int DUMP_WITHOUT_CRASHING_ORDINAL = 24;

    NetworkService_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void setClient(NetworkServiceClient client, NetworkServiceParams params) {
            NetworkServiceSetClientParams _message = new NetworkServiceSetClientParams();
            _message.client = client;
            _message.params = params;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void startNetLog(File file, int captureMode, DictionaryValue constants) {
            NetworkServiceStartNetLogParams _message = new NetworkServiceStartNetLogParams();
            _message.file = file;
            _message.captureMode = captureMode;
            _message.constants = constants;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void setSslKeyLogFile(FilePath file) {
            NetworkServiceSetSslKeyLogFileParams _message = new NetworkServiceSetSslKeyLogFileParams();
            _message.file = file;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void createNetworkContext(InterfaceRequest<NetworkContext> context, NetworkContextParams params) {
            NetworkServiceCreateNetworkContextParams _message = new NetworkServiceCreateNetworkContextParams();
            _message.context = context;
            _message.params = params;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void configureStubHostResolver(boolean stubResolverEnabled, DnsOverHttpsServer[] dnsOverHttpsServers) {
            NetworkServiceConfigureStubHostResolverParams _message = new NetworkServiceConfigureStubHostResolverParams();
            _message.stubResolverEnabled = stubResolverEnabled;
            _message.dnsOverHttpsServers = dnsOverHttpsServers;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void disableQuic() {
            NetworkServiceDisableQuicParams _message = new NetworkServiceDisableQuicParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void setUpHttpAuth(HttpAuthStaticParams httpAuthStaticParams) {
            NetworkServiceSetUpHttpAuthParams _message = new NetworkServiceSetUpHttpAuthParams();
            _message.httpAuthStaticParams = httpAuthStaticParams;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void configureHttpAuthPrefs(HttpAuthDynamicParams httpAuthDynamicParams) {
            NetworkServiceConfigureHttpAuthPrefsParams _message = new NetworkServiceConfigureHttpAuthPrefsParams();
            _message.httpAuthDynamicParams = httpAuthDynamicParams;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void setRawHeadersAccess(int processId, Origin[] origins) {
            NetworkServiceSetRawHeadersAccessParams _message = new NetworkServiceSetRawHeadersAccessParams();
            _message.processId = processId;
            _message.origins = origins;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void setMaxConnectionsPerProxy(int maxConnections) {
            NetworkServiceSetMaxConnectionsPerProxyParams _message = new NetworkServiceSetMaxConnectionsPerProxyParams();
            _message.maxConnections = maxConnections;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void getNetworkChangeManager(InterfaceRequest<NetworkChangeManager> networkChangeManager) {
            NetworkServiceGetNetworkChangeManagerParams _message = new NetworkServiceGetNetworkChangeManagerParams();
            _message.networkChangeManager = networkChangeManager;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void getNetworkQualityEstimatorManager(InterfaceRequest<NetworkQualityEstimatorManager> networkQualityEstimatorManager) {
            NetworkServiceGetNetworkQualityEstimatorManagerParams _message = new NetworkServiceGetNetworkQualityEstimatorManagerParams();
            _message.networkQualityEstimatorManager = networkQualityEstimatorManager;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void getDnsConfigChangeManager(InterfaceRequest<DnsConfigChangeManager> dnsConfigChangeManager) {
            NetworkServiceGetDnsConfigChangeManagerParams _message = new NetworkServiceGetDnsConfigChangeManagerParams();
            _message.dnsConfigChangeManager = dnsConfigChangeManager;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void getTotalNetworkUsages(NetworkService.GetTotalNetworkUsagesResponse callback) {
            NetworkServiceGetTotalNetworkUsagesParams _message = new NetworkServiceGetTotalNetworkUsagesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)), new NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void getNetworkList(int policy, NetworkService.GetNetworkListResponse callback) {
            NetworkServiceGetNetworkListParams _message = new NetworkServiceGetNetworkListParams();
            _message.policy = policy;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)), new NetworkServiceGetNetworkListResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void updateCrlSet(ReadOnlyBuffer crlSet) {
            NetworkServiceUpdateCrlSetParams _message = new NetworkServiceUpdateCrlSetParams();
            _message.crlSet = crlSet;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void onCertDbChanged() {
            NetworkServiceOnCertDbChangedParams _message = new NetworkServiceOnCertDbChangedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void addCorbExceptionForPlugin(int processId) {
            NetworkServiceAddCorbExceptionForPluginParams _message = new NetworkServiceAddCorbExceptionForPluginParams();
            _message.processId = processId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(17)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void removeCorbExceptionForPlugin(int processId) {
            NetworkServiceRemoveCorbExceptionForPluginParams _message = new NetworkServiceRemoveCorbExceptionForPluginParams();
            _message.processId = processId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void addExtraMimeTypesForCorb(String[] mimeTypes) {
            NetworkServiceAddExtraMimeTypesForCorbParams _message = new NetworkServiceAddExtraMimeTypesForCorbParams();
            _message.mimeTypes = mimeTypes;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(19)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void onMemoryPressure(int memoryPressureLevel) {
            NetworkServiceOnMemoryPressureParams _message = new NetworkServiceOnMemoryPressureParams();
            _message.memoryPressureLevel = memoryPressureLevel;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(20)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void onPeerToPeerConnectionsCountChange(int count) {
            NetworkServiceOnPeerToPeerConnectionsCountChangeParams _message = new NetworkServiceOnPeerToPeerConnectionsCountChangeParams();
            _message.count = count;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(21)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void onApplicationStateChange(int state) {
            NetworkServiceOnApplicationStateChangeParams _message = new NetworkServiceOnApplicationStateChangeParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(22)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void setEnvironment(EnvironmentVariable[] environment) {
            NetworkServiceSetEnvironmentParams _message = new NetworkServiceSetEnvironmentParams();
            _message.environment = environment;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(23)));
        }

        @Override // org.chromium.network.mojom.NetworkService
        public void dumpWithoutCrashing(Time dumpRequestTime) {
            NetworkServiceDumpWithoutCrashingParams _message = new NetworkServiceDumpWithoutCrashingParams();
            _message.dumpRequestTime = dumpRequestTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(24)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkService> {
        Stub(Core core, NetworkService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkService_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 13:
                    case 14:
                    default:
                        return false;
                    case 0:
                        NetworkServiceSetClientParams data = NetworkServiceSetClientParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setClient(data.client, data.params);
                        return true;
                    case 1:
                        NetworkServiceStartNetLogParams data2 = NetworkServiceStartNetLogParams.deserialize(messageWithHeader.getPayload());
                        getImpl().startNetLog(data2.file, data2.captureMode, data2.constants);
                        return true;
                    case 2:
                        NetworkServiceSetSslKeyLogFileParams data3 = NetworkServiceSetSslKeyLogFileParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setSslKeyLogFile(data3.file);
                        return true;
                    case 3:
                        NetworkServiceCreateNetworkContextParams data4 = NetworkServiceCreateNetworkContextParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createNetworkContext(data4.context, data4.params);
                        return true;
                    case 4:
                        NetworkServiceConfigureStubHostResolverParams data5 = NetworkServiceConfigureStubHostResolverParams.deserialize(messageWithHeader.getPayload());
                        getImpl().configureStubHostResolver(data5.stubResolverEnabled, data5.dnsOverHttpsServers);
                        return true;
                    case 5:
                        NetworkServiceDisableQuicParams.deserialize(messageWithHeader.getPayload());
                        getImpl().disableQuic();
                        return true;
                    case 6:
                        NetworkServiceSetUpHttpAuthParams data6 = NetworkServiceSetUpHttpAuthParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setUpHttpAuth(data6.httpAuthStaticParams);
                        return true;
                    case 7:
                        NetworkServiceConfigureHttpAuthPrefsParams data7 = NetworkServiceConfigureHttpAuthPrefsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().configureHttpAuthPrefs(data7.httpAuthDynamicParams);
                        return true;
                    case 8:
                        NetworkServiceSetRawHeadersAccessParams data8 = NetworkServiceSetRawHeadersAccessParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setRawHeadersAccess(data8.processId, data8.origins);
                        return true;
                    case 9:
                        NetworkServiceSetMaxConnectionsPerProxyParams data9 = NetworkServiceSetMaxConnectionsPerProxyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setMaxConnectionsPerProxy(data9.maxConnections);
                        return true;
                    case 10:
                        NetworkServiceGetNetworkChangeManagerParams data10 = NetworkServiceGetNetworkChangeManagerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getNetworkChangeManager(data10.networkChangeManager);
                        return true;
                    case 11:
                        NetworkServiceGetNetworkQualityEstimatorManagerParams data11 = NetworkServiceGetNetworkQualityEstimatorManagerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getNetworkQualityEstimatorManager(data11.networkQualityEstimatorManager);
                        return true;
                    case 12:
                        NetworkServiceGetDnsConfigChangeManagerParams data12 = NetworkServiceGetDnsConfigChangeManagerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getDnsConfigChangeManager(data12.dnsConfigChangeManager);
                        return true;
                    case 15:
                        NetworkServiceUpdateCrlSetParams data13 = NetworkServiceUpdateCrlSetParams.deserialize(messageWithHeader.getPayload());
                        getImpl().updateCrlSet(data13.crlSet);
                        return true;
                    case 16:
                        NetworkServiceOnCertDbChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onCertDbChanged();
                        return true;
                    case 17:
                        NetworkServiceAddCorbExceptionForPluginParams data14 = NetworkServiceAddCorbExceptionForPluginParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addCorbExceptionForPlugin(data14.processId);
                        return true;
                    case 18:
                        NetworkServiceRemoveCorbExceptionForPluginParams data15 = NetworkServiceRemoveCorbExceptionForPluginParams.deserialize(messageWithHeader.getPayload());
                        getImpl().removeCorbExceptionForPlugin(data15.processId);
                        return true;
                    case 19:
                        NetworkServiceAddExtraMimeTypesForCorbParams data16 = NetworkServiceAddExtraMimeTypesForCorbParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addExtraMimeTypesForCorb(data16.mimeTypes);
                        return true;
                    case 20:
                        NetworkServiceOnMemoryPressureParams data17 = NetworkServiceOnMemoryPressureParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onMemoryPressure(data17.memoryPressureLevel);
                        return true;
                    case 21:
                        NetworkServiceOnPeerToPeerConnectionsCountChangeParams data18 = NetworkServiceOnPeerToPeerConnectionsCountChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onPeerToPeerConnectionsCountChange(data18.count);
                        return true;
                    case 22:
                        NetworkServiceOnApplicationStateChangeParams data19 = NetworkServiceOnApplicationStateChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onApplicationStateChange(data19.state);
                        return true;
                    case 23:
                        NetworkServiceSetEnvironmentParams data20 = NetworkServiceSetEnvironmentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setEnvironment(data20.environment);
                        return true;
                    case 24:
                        NetworkServiceDumpWithoutCrashingParams data21 = NetworkServiceDumpWithoutCrashingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().dumpWithoutCrashing(data21.dumpRequestTime);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkService_Internal.MANAGER, messageWithHeader, receiver);
                    case 13:
                        NetworkServiceGetTotalNetworkUsagesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getTotalNetworkUsages(new NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 14:
                        NetworkServiceGetNetworkListParams data = NetworkServiceGetNetworkListParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getNetworkList(data.policy, new NetworkServiceGetNetworkListResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceSetClientParams.class */
    static final class NetworkServiceSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkServiceClient client;
        public NetworkServiceParams params;

        private NetworkServiceSetClientParams(int version) {
            super(24, version);
        }

        public NetworkServiceSetClientParams() {
            this(0);
        }

        public static NetworkServiceSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceSetClientParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceSetClientParams result = new NetworkServiceSetClientParams(elementsOrVersion);
                result.client = (NetworkServiceClient) decoder0.readServiceInterface(8, false, NetworkServiceClient.MANAGER);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.params = NetworkServiceParams.decode(decoder1);
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
            encoder0.encode(this.client,8,false, NetworkServiceClient.MANAGER);
            encoder0.encode((Struct) this.params, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceStartNetLogParams.class */
    static final class NetworkServiceStartNetLogParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public File file;
        public int captureMode;
        public DictionaryValue constants;

        private NetworkServiceStartNetLogParams(int version) {
            super(32, version);
        }

        public NetworkServiceStartNetLogParams() {
            this(0);
        }

        public static NetworkServiceStartNetLogParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceStartNetLogParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceStartNetLogParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceStartNetLogParams result = new NetworkServiceStartNetLogParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.file = File.decode(decoder1);
                result.captureMode = decoder0.readInt(16);
                NetLogCaptureMode.validate(result.captureMode);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.constants = DictionaryValue.decode(decoder12);
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
            encoder0.encode((Struct) this.file, 8, false);
            encoder0.encode(this.captureMode, 16);
            encoder0.encode((Struct) this.constants, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceSetSslKeyLogFileParams.class */
    static final class NetworkServiceSetSslKeyLogFileParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public FilePath file;

        private NetworkServiceSetSslKeyLogFileParams(int version) {
            super(16, version);
        }

        public NetworkServiceSetSslKeyLogFileParams() {
            this(0);
        }

        public static NetworkServiceSetSslKeyLogFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceSetSslKeyLogFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceSetSslKeyLogFileParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceSetSslKeyLogFileParams result = new NetworkServiceSetSslKeyLogFileParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.file = FilePath.decode(decoder1);
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
            encoder0.encode((Struct) this.file, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceCreateNetworkContextParams.class */
    static final class NetworkServiceCreateNetworkContextParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<NetworkContext> context;
        public NetworkContextParams params;

        private NetworkServiceCreateNetworkContextParams(int version) {
            super(24, version);
        }

        public NetworkServiceCreateNetworkContextParams() {
            this(0);
        }

        public static NetworkServiceCreateNetworkContextParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceCreateNetworkContextParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceCreateNetworkContextParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceCreateNetworkContextParams result = new NetworkServiceCreateNetworkContextParams(elementsOrVersion);
                result.context = decoder0.readInterfaceRequest(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.params = NetworkContextParams.decode(decoder1);
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
            encoder0.encode((InterfaceRequest) this.context, 8, false);
            encoder0.encode((Struct) this.params, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceConfigureStubHostResolverParams.class */
    static final class NetworkServiceConfigureStubHostResolverParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean stubResolverEnabled;
        public DnsOverHttpsServer[] dnsOverHttpsServers;

        private NetworkServiceConfigureStubHostResolverParams(int version) {
            super(24, version);
        }

        public NetworkServiceConfigureStubHostResolverParams() {
            this(0);
        }

        public static NetworkServiceConfigureStubHostResolverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceConfigureStubHostResolverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceConfigureStubHostResolverParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceConfigureStubHostResolverParams result = new NetworkServiceConfigureStubHostResolverParams(elementsOrVersion);
                result.stubResolverEnabled = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, true);
                if (decoder1 == null) {
                    result.dnsOverHttpsServers = null;
                } else {
                    DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                    result.dnsOverHttpsServers = new DnsOverHttpsServer[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                        Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                        result.dnsOverHttpsServers[i1] = DnsOverHttpsServer.decode(decoder2);
                    }
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
            encoder0.encode(this.stubResolverEnabled, 8, 0);
            if (this.dnsOverHttpsServers == null) {
                encoder0.encodeNullPointer(16, true);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.dnsOverHttpsServers.length, 16, -1);
            for (int i0 = 0; i0 < this.dnsOverHttpsServers.length; i0++) {
                encoder1.encode((Struct) this.dnsOverHttpsServers[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceDisableQuicParams.class */
    static final class NetworkServiceDisableQuicParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceDisableQuicParams(int version) {
            super(8, version);
        }

        public NetworkServiceDisableQuicParams() {
            this(0);
        }

        public static NetworkServiceDisableQuicParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceDisableQuicParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceDisableQuicParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceDisableQuicParams result = new NetworkServiceDisableQuicParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceSetUpHttpAuthParams.class */
    static final class NetworkServiceSetUpHttpAuthParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HttpAuthStaticParams httpAuthStaticParams;

        private NetworkServiceSetUpHttpAuthParams(int version) {
            super(16, version);
        }

        public NetworkServiceSetUpHttpAuthParams() {
            this(0);
        }

        public static NetworkServiceSetUpHttpAuthParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceSetUpHttpAuthParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceSetUpHttpAuthParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceSetUpHttpAuthParams result = new NetworkServiceSetUpHttpAuthParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.httpAuthStaticParams = HttpAuthStaticParams.decode(decoder1);
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
            encoder0.encode((Struct) this.httpAuthStaticParams, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceConfigureHttpAuthPrefsParams.class */
    static final class NetworkServiceConfigureHttpAuthPrefsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HttpAuthDynamicParams httpAuthDynamicParams;

        private NetworkServiceConfigureHttpAuthPrefsParams(int version) {
            super(16, version);
        }

        public NetworkServiceConfigureHttpAuthPrefsParams() {
            this(0);
        }

        public static NetworkServiceConfigureHttpAuthPrefsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceConfigureHttpAuthPrefsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceConfigureHttpAuthPrefsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceConfigureHttpAuthPrefsParams result = new NetworkServiceConfigureHttpAuthPrefsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.httpAuthDynamicParams = HttpAuthDynamicParams.decode(decoder1);
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
            encoder0.encode((Struct) this.httpAuthDynamicParams, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceSetRawHeadersAccessParams.class */
    static final class NetworkServiceSetRawHeadersAccessParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public Origin[] origins;

        private NetworkServiceSetRawHeadersAccessParams(int version) {
            super(24, version);
        }

        public NetworkServiceSetRawHeadersAccessParams() {
            this(0);
        }

        public static NetworkServiceSetRawHeadersAccessParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceSetRawHeadersAccessParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceSetRawHeadersAccessParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceSetRawHeadersAccessParams result = new NetworkServiceSetRawHeadersAccessParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.origins = new Origin[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.origins[i1] = Origin.decode(decoder2);
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
            encoder0.encode(this.processId, 8);
            if (this.origins == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.origins.length, 16, -1);
            for (int i0 = 0; i0 < this.origins.length; i0++) {
                encoder1.encode((Struct) this.origins[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceSetMaxConnectionsPerProxyParams.class */
    static final class NetworkServiceSetMaxConnectionsPerProxyParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int maxConnections;

        private NetworkServiceSetMaxConnectionsPerProxyParams(int version) {
            super(16, version);
        }

        public NetworkServiceSetMaxConnectionsPerProxyParams() {
            this(0);
        }

        public static NetworkServiceSetMaxConnectionsPerProxyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceSetMaxConnectionsPerProxyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceSetMaxConnectionsPerProxyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceSetMaxConnectionsPerProxyParams result = new NetworkServiceSetMaxConnectionsPerProxyParams(elementsOrVersion);
                result.maxConnections = decoder0.readInt(8);
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
            encoder0.encode(this.maxConnections, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetNetworkChangeManagerParams.class */
    static final class NetworkServiceGetNetworkChangeManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<NetworkChangeManager> networkChangeManager;

        private NetworkServiceGetNetworkChangeManagerParams(int version) {
            super(16, version);
        }

        public NetworkServiceGetNetworkChangeManagerParams() {
            this(0);
        }

        public static NetworkServiceGetNetworkChangeManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetNetworkChangeManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetNetworkChangeManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetNetworkChangeManagerParams result = new NetworkServiceGetNetworkChangeManagerParams(elementsOrVersion);
                result.networkChangeManager = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.networkChangeManager, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetNetworkQualityEstimatorManagerParams.class */
    static final class NetworkServiceGetNetworkQualityEstimatorManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<NetworkQualityEstimatorManager> networkQualityEstimatorManager;

        private NetworkServiceGetNetworkQualityEstimatorManagerParams(int version) {
            super(16, version);
        }

        public NetworkServiceGetNetworkQualityEstimatorManagerParams() {
            this(0);
        }

        public static NetworkServiceGetNetworkQualityEstimatorManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetNetworkQualityEstimatorManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetNetworkQualityEstimatorManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetNetworkQualityEstimatorManagerParams result = new NetworkServiceGetNetworkQualityEstimatorManagerParams(elementsOrVersion);
                result.networkQualityEstimatorManager = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.networkQualityEstimatorManager, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetDnsConfigChangeManagerParams.class */
    static final class NetworkServiceGetDnsConfigChangeManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<DnsConfigChangeManager> dnsConfigChangeManager;

        private NetworkServiceGetDnsConfigChangeManagerParams(int version) {
            super(16, version);
        }

        public NetworkServiceGetDnsConfigChangeManagerParams() {
            this(0);
        }

        public static NetworkServiceGetDnsConfigChangeManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetDnsConfigChangeManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetDnsConfigChangeManagerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetDnsConfigChangeManagerParams result = new NetworkServiceGetDnsConfigChangeManagerParams(elementsOrVersion);
                result.dnsConfigChangeManager = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.dnsConfigChangeManager, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetTotalNetworkUsagesParams.class */
    static final class NetworkServiceGetTotalNetworkUsagesParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceGetTotalNetworkUsagesParams(int version) {
            super(8, version);
        }

        public NetworkServiceGetTotalNetworkUsagesParams() {
            this(0);
        }

        public static NetworkServiceGetTotalNetworkUsagesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetTotalNetworkUsagesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetTotalNetworkUsagesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetTotalNetworkUsagesParams result = new NetworkServiceGetTotalNetworkUsagesParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetTotalNetworkUsagesResponseParams.class */
    public static final class NetworkServiceGetTotalNetworkUsagesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkUsage[] totalNetworkUsages;

        private NetworkServiceGetTotalNetworkUsagesResponseParams(int version) {
            super(16, version);
        }

        public NetworkServiceGetTotalNetworkUsagesResponseParams() {
            this(0);
        }

        public static NetworkServiceGetTotalNetworkUsagesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetTotalNetworkUsagesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetTotalNetworkUsagesResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetTotalNetworkUsagesResponseParams result = new NetworkServiceGetTotalNetworkUsagesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.totalNetworkUsages = new NetworkUsage[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.totalNetworkUsages[i1] = NetworkUsage.decode(decoder2);
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
            if (this.totalNetworkUsages == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.totalNetworkUsages.length, 8, -1);
            for (int i0 = 0; i0 < this.totalNetworkUsages.length; i0++) {
                encoder1.encode((Struct) this.totalNetworkUsages[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback.class */
    static class NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkService.GetTotalNetworkUsagesResponse mCallback;

        NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback(NetworkService.GetTotalNetworkUsagesResponse callback) {
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
                NetworkServiceGetTotalNetworkUsagesResponseParams response = NetworkServiceGetTotalNetworkUsagesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.totalNetworkUsages);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder.class */
    static class NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder implements NetworkService.GetTotalNetworkUsagesResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(NetworkUsage[] totalNetworkUsages) {
            NetworkServiceGetTotalNetworkUsagesResponseParams _response = new NetworkServiceGetTotalNetworkUsagesResponseParams();
            _response.totalNetworkUsages = totalNetworkUsages;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetNetworkListParams.class */
    static final class NetworkServiceGetNetworkListParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int policy;

        private NetworkServiceGetNetworkListParams(int version) {
            super(16, version);
        }

        public NetworkServiceGetNetworkListParams() {
            this(0);
        }

        public static NetworkServiceGetNetworkListParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetNetworkListParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetNetworkListParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetNetworkListParams result = new NetworkServiceGetNetworkListParams(elementsOrVersion);
                result.policy = decoder0.readInt(8);
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
            encoder0.encode(this.policy, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetNetworkListResponseParams.class */
    public static final class NetworkServiceGetNetworkListResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkInterface[] networks;

        private NetworkServiceGetNetworkListResponseParams(int version) {
            super(16, version);
        }

        public NetworkServiceGetNetworkListResponseParams() {
            this(0);
        }

        public static NetworkServiceGetNetworkListResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceGetNetworkListResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceGetNetworkListResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceGetNetworkListResponseParams result = new NetworkServiceGetNetworkListResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                if (decoder1 == null) {
                    result.networks = null;
                } else {
                    DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                    result.networks = new NetworkInterface[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                        Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                        result.networks[i1] = NetworkInterface.decode(decoder2);
                    }
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
            if (this.networks == null) {
                encoder0.encodeNullPointer(8, true);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.networks.length, 8, -1);
            for (int i0 = 0; i0 < this.networks.length; i0++) {
                encoder1.encode((Struct) this.networks[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetNetworkListResponseParamsForwardToCallback.class */
    static class NetworkServiceGetNetworkListResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkService.GetNetworkListResponse mCallback;

        NetworkServiceGetNetworkListResponseParamsForwardToCallback(NetworkService.GetNetworkListResponse callback) {
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
                NetworkServiceGetNetworkListResponseParams response = NetworkServiceGetNetworkListResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.networks);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceGetNetworkListResponseParamsProxyToResponder.class */
    static class NetworkServiceGetNetworkListResponseParamsProxyToResponder implements NetworkService.GetNetworkListResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceGetNetworkListResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(NetworkInterface[] networks) {
            NetworkServiceGetNetworkListResponseParams _response = new NetworkServiceGetNetworkListResponseParams();
            _response.networks = networks;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceUpdateCrlSetParams.class */
    static final class NetworkServiceUpdateCrlSetParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ReadOnlyBuffer crlSet;

        private NetworkServiceUpdateCrlSetParams(int version) {
            super(16, version);
        }

        public NetworkServiceUpdateCrlSetParams() {
            this(0);
        }

        public static NetworkServiceUpdateCrlSetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceUpdateCrlSetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceUpdateCrlSetParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceUpdateCrlSetParams result = new NetworkServiceUpdateCrlSetParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.crlSet = ReadOnlyBuffer.decode(decoder1);
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
            encoder0.encode((Struct) this.crlSet, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceOnCertDbChangedParams.class */
    static final class NetworkServiceOnCertDbChangedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceOnCertDbChangedParams(int version) {
            super(8, version);
        }

        public NetworkServiceOnCertDbChangedParams() {
            this(0);
        }

        public static NetworkServiceOnCertDbChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceOnCertDbChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceOnCertDbChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceOnCertDbChangedParams result = new NetworkServiceOnCertDbChangedParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceAddCorbExceptionForPluginParams.class */
    static final class NetworkServiceAddCorbExceptionForPluginParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;

        private NetworkServiceAddCorbExceptionForPluginParams(int version) {
            super(16, version);
        }

        public NetworkServiceAddCorbExceptionForPluginParams() {
            this(0);
        }

        public static NetworkServiceAddCorbExceptionForPluginParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceAddCorbExceptionForPluginParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceAddCorbExceptionForPluginParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceAddCorbExceptionForPluginParams result = new NetworkServiceAddCorbExceptionForPluginParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceRemoveCorbExceptionForPluginParams.class */
    static final class NetworkServiceRemoveCorbExceptionForPluginParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;

        private NetworkServiceRemoveCorbExceptionForPluginParams(int version) {
            super(16, version);
        }

        public NetworkServiceRemoveCorbExceptionForPluginParams() {
            this(0);
        }

        public static NetworkServiceRemoveCorbExceptionForPluginParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceRemoveCorbExceptionForPluginParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceRemoveCorbExceptionForPluginParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceRemoveCorbExceptionForPluginParams result = new NetworkServiceRemoveCorbExceptionForPluginParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceAddExtraMimeTypesForCorbParams.class */
    static final class NetworkServiceAddExtraMimeTypesForCorbParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String[] mimeTypes;

        private NetworkServiceAddExtraMimeTypesForCorbParams(int version) {
            super(16, version);
        }

        public NetworkServiceAddExtraMimeTypesForCorbParams() {
            this(0);
        }

        public static NetworkServiceAddExtraMimeTypesForCorbParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceAddExtraMimeTypesForCorbParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceAddExtraMimeTypesForCorbParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceAddExtraMimeTypesForCorbParams result = new NetworkServiceAddExtraMimeTypesForCorbParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.mimeTypes = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.mimeTypes[i1] = decoder1.readString(8 + (8 * i1), false);
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
            if (this.mimeTypes == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.mimeTypes.length, 8, -1);
            for (int i0 = 0; i0 < this.mimeTypes.length; i0++) {
                encoder1.encode(this.mimeTypes[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceOnMemoryPressureParams.class */
    static final class NetworkServiceOnMemoryPressureParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int memoryPressureLevel;

        private NetworkServiceOnMemoryPressureParams(int version) {
            super(16, version);
        }

        public NetworkServiceOnMemoryPressureParams() {
            this(0);
        }

        public static NetworkServiceOnMemoryPressureParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceOnMemoryPressureParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceOnMemoryPressureParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceOnMemoryPressureParams result = new NetworkServiceOnMemoryPressureParams(elementsOrVersion);
                result.memoryPressureLevel = decoder0.readInt(8);
                MemoryPressureLevel.validate(result.memoryPressureLevel);
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
            encoder0.encode(this.memoryPressureLevel, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceOnPeerToPeerConnectionsCountChangeParams.class */
    static final class NetworkServiceOnPeerToPeerConnectionsCountChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int count;

        private NetworkServiceOnPeerToPeerConnectionsCountChangeParams(int version) {
            super(16, version);
        }

        public NetworkServiceOnPeerToPeerConnectionsCountChangeParams() {
            this(0);
        }

        public static NetworkServiceOnPeerToPeerConnectionsCountChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceOnPeerToPeerConnectionsCountChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceOnPeerToPeerConnectionsCountChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceOnPeerToPeerConnectionsCountChangeParams result = new NetworkServiceOnPeerToPeerConnectionsCountChangeParams(elementsOrVersion);
                result.count = decoder0.readInt(8);
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
            encoder0.encode(this.count, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceOnApplicationStateChangeParams.class */
    static final class NetworkServiceOnApplicationStateChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int state;

        private NetworkServiceOnApplicationStateChangeParams(int version) {
            super(16, version);
        }

        public NetworkServiceOnApplicationStateChangeParams() {
            this(0);
        }

        public static NetworkServiceOnApplicationStateChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceOnApplicationStateChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceOnApplicationStateChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceOnApplicationStateChangeParams result = new NetworkServiceOnApplicationStateChangeParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                ApplicationState.validate(result.state);
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
            encoder0.encode(this.state, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceSetEnvironmentParams.class */
    static final class NetworkServiceSetEnvironmentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public EnvironmentVariable[] environment;

        private NetworkServiceSetEnvironmentParams(int version) {
            super(16, version);
        }

        public NetworkServiceSetEnvironmentParams() {
            this(0);
        }

        public static NetworkServiceSetEnvironmentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceSetEnvironmentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceSetEnvironmentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceSetEnvironmentParams result = new NetworkServiceSetEnvironmentParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.environment = new EnvironmentVariable[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.environment[i1] = EnvironmentVariable.decode(decoder2);
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
            if (this.environment == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.environment.length, 8, -1);
            for (int i0 = 0; i0 < this.environment.length; i0++) {
                encoder1.encode((Struct) this.environment[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkService_Internal$NetworkServiceDumpWithoutCrashingParams.class */
    static final class NetworkServiceDumpWithoutCrashingParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Time dumpRequestTime;

        private NetworkServiceDumpWithoutCrashingParams(int version) {
            super(16, version);
        }

        public NetworkServiceDumpWithoutCrashingParams() {
            this(0);
        }

        public static NetworkServiceDumpWithoutCrashingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceDumpWithoutCrashingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceDumpWithoutCrashingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceDumpWithoutCrashingParams result = new NetworkServiceDumpWithoutCrashingParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.dumpRequestTime = Time.decode(decoder1);
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
            encoder0.encode((Struct) this.dumpRequestTime, 8, false);
        }
    }
}
