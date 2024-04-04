package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.MemoryPressureLevel;
import org.chromium.network.mojom.NetworkServiceTest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal.class */
class NetworkServiceTest_Internal {
    public static final Interface.Manager<NetworkServiceTest, NetworkServiceTest.Proxy> MANAGER = new Interface.Manager<NetworkServiceTest, NetworkServiceTest.Proxy>() { // from class: org.chromium.network.mojom.NetworkServiceTest_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkServiceTest";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkServiceTest.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkServiceTest impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkServiceTest[] buildArray(int size) {
            return new NetworkServiceTest[size];
        }
    };
    private static final int ADD_RULES_ORDINAL = 0;
    private static final int SIMULATE_NETWORK_CHANGE_ORDINAL = 1;
    private static final int SIMULATE_NETWORK_QUALITY_CHANGE_ORDINAL = 2;
    private static final int SIMULATE_CRASH_ORDINAL = 3;
    private static final int MOCK_CERT_VERIFIER_SET_DEFAULT_RESULT_ORDINAL = 4;
    private static final int MOCK_CERT_VERIFIER_ADD_RESULT_FOR_CERT_AND_HOST_ORDINAL = 5;
    private static final int SET_SHOULD_REQUIRE_CT_ORDINAL = 6;
    private static final int SET_TRANSPORT_SECURITY_STATE_SOURCE_ORDINAL = 7;
    private static final int CRASH_ON_RESOLVE_HOST_ORDINAL = 8;
    private static final int CRASH_ON_GET_COOKIE_LIST_ORDINAL = 9;
    private static final int GET_LATEST_MEMORY_PRESSURE_LEVEL_ORDINAL = 10;
    private static final int GET_PEER_TO_PEER_CONNECTIONS_COUNT_CHANGE_ORDINAL = 11;
    private static final int GET_ENVIRONMENT_VARIABLE_VALUE_ORDINAL = 12;

    NetworkServiceTest_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkServiceTest.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void addRules(Rule[] rules, NetworkServiceTest.AddRulesResponse callback) {
            NetworkServiceTestAddRulesParams _message = new NetworkServiceTestAddRulesParams();
            _message.rules = rules;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NetworkServiceTestAddRulesResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void simulateNetworkChange(int type, NetworkServiceTest.SimulateNetworkChangeResponse callback) {
            NetworkServiceTestSimulateNetworkChangeParams _message = new NetworkServiceTestSimulateNetworkChangeParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void simulateNetworkQualityChange(int type, NetworkServiceTest.SimulateNetworkQualityChangeResponse callback) {
            NetworkServiceTestSimulateNetworkQualityChangeParams _message = new NetworkServiceTestSimulateNetworkQualityChangeParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void simulateCrash() {
            NetworkServiceTestSimulateCrashParams _message = new NetworkServiceTestSimulateCrashParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void mockCertVerifierSetDefaultResult(int defaultResult, NetworkServiceTest.MockCertVerifierSetDefaultResultResponse callback) {
            NetworkServiceTestMockCertVerifierSetDefaultResultParams _message = new NetworkServiceTestMockCertVerifierSetDefaultResultParams();
            _message.defaultResult = defaultResult;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void mockCertVerifierAddResultForCertAndHost(X509Certificate cert, String hostPattern, CertVerifyResult verifyResult, int rv, NetworkServiceTest.MockCertVerifierAddResultForCertAndHostResponse callback) {
            NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams _message = new NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams();
            _message.cert = cert;
            _message.hostPattern = hostPattern;
            _message.verifyResult = verifyResult;
            _message.rv = rv;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void setShouldRequireCt(int required, NetworkServiceTest.SetShouldRequireCtResponse callback) {
            NetworkServiceTestSetShouldRequireCtParams _message = new NetworkServiceTestSetShouldRequireCtParams();
            _message.required = required;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new NetworkServiceTestSetShouldRequireCtResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void setTransportSecurityStateSource(short reportingPort, NetworkServiceTest.SetTransportSecurityStateSourceResponse callback) {
            NetworkServiceTestSetTransportSecurityStateSourceParams _message = new NetworkServiceTestSetTransportSecurityStateSourceParams();
            _message.reportingPort = reportingPort;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void crashOnResolveHost(String host) {
            NetworkServiceTestCrashOnResolveHostParams _message = new NetworkServiceTestCrashOnResolveHostParams();
            _message.host = host;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void crashOnGetCookieList() {
            NetworkServiceTestCrashOnGetCookieListParams _message = new NetworkServiceTestCrashOnGetCookieListParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void getLatestMemoryPressureLevel(NetworkServiceTest.GetLatestMemoryPressureLevelResponse callback) {
            NetworkServiceTestGetLatestMemoryPressureLevelParams _message = new NetworkServiceTestGetLatestMemoryPressureLevelParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void getPeerToPeerConnectionsCountChange(NetworkServiceTest.GetPeerToPeerConnectionsCountChangeResponse callback) {
            NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams _message = new NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)), new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceTest
        public void getEnvironmentVariableValue(String name, NetworkServiceTest.GetEnvironmentVariableValueResponse callback) {
            NetworkServiceTestGetEnvironmentVariableValueParams _message = new NetworkServiceTestGetEnvironmentVariableValueParams();
            _message.name = name;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)), new NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkServiceTest> {
        Stub(Core core, NetworkServiceTest impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkServiceTest_Internal.MANAGER, messageWithHeader);
                    case 3:
                        NetworkServiceTestSimulateCrashParams.deserialize(messageWithHeader.getPayload());
                        getImpl().simulateCrash();
                        return true;
                    case 8:
                        NetworkServiceTestCrashOnResolveHostParams data = NetworkServiceTestCrashOnResolveHostParams.deserialize(messageWithHeader.getPayload());
                        getImpl().crashOnResolveHost(data.host);
                        return true;
                    case 9:
                        NetworkServiceTestCrashOnGetCookieListParams.deserialize(messageWithHeader.getPayload());
                        getImpl().crashOnGetCookieList();
                        return true;
                    default:
                        return false;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkServiceTest_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        NetworkServiceTestAddRulesParams data = NetworkServiceTestAddRulesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addRules(data.rules, new NetworkServiceTestAddRulesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        NetworkServiceTestSimulateNetworkChangeParams data2 = NetworkServiceTestSimulateNetworkChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().simulateNetworkChange(data2.type, new NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        NetworkServiceTestSimulateNetworkQualityChangeParams data3 = NetworkServiceTestSimulateNetworkQualityChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().simulateNetworkQualityChange(data3.type, new NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                    case 8:
                    case 9:
                    default:
                        return false;
                    case 4:
                        NetworkServiceTestMockCertVerifierSetDefaultResultParams data4 = NetworkServiceTestMockCertVerifierSetDefaultResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().mockCertVerifierSetDefaultResult(data4.defaultResult, new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams data5 = NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams.deserialize(messageWithHeader.getPayload());
                        getImpl().mockCertVerifierAddResultForCertAndHost(data5.cert, data5.hostPattern, data5.verifyResult, data5.rv, new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        NetworkServiceTestSetShouldRequireCtParams data6 = NetworkServiceTestSetShouldRequireCtParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setShouldRequireCt(data6.required, new NetworkServiceTestSetShouldRequireCtResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        NetworkServiceTestSetTransportSecurityStateSourceParams data7 = NetworkServiceTestSetTransportSecurityStateSourceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setTransportSecurityStateSource(data7.reportingPort, new NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        NetworkServiceTestGetLatestMemoryPressureLevelParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getLatestMemoryPressureLevel(new NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 11:
                        NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getPeerToPeerConnectionsCountChange(new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                        NetworkServiceTestGetEnvironmentVariableValueParams data8 = NetworkServiceTestGetEnvironmentVariableValueParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getEnvironmentVariableValue(data8.name, new NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestAddRulesParams.class */
    static final class NetworkServiceTestAddRulesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Rule[] rules;

        private NetworkServiceTestAddRulesParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestAddRulesParams() {
            this(0);
        }

        public static NetworkServiceTestAddRulesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestAddRulesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestAddRulesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestAddRulesParams result = new NetworkServiceTestAddRulesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.rules = new Rule[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.rules[i1] = Rule.decode(decoder2);
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
            if (this.rules == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.rules.length, 8, -1);
            for (int i0 = 0; i0 < this.rules.length; i0++) {
                encoder1.encode((Struct) this.rules[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestAddRulesResponseParams.class */
    static final class NetworkServiceTestAddRulesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestAddRulesResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestAddRulesResponseParams() {
            this(0);
        }

        public static NetworkServiceTestAddRulesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestAddRulesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestAddRulesResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestAddRulesResponseParams result = new NetworkServiceTestAddRulesResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestAddRulesResponseParamsForwardToCallback.class */
    static class NetworkServiceTestAddRulesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.AddRulesResponse mCallback;

        NetworkServiceTestAddRulesResponseParamsForwardToCallback(NetworkServiceTest.AddRulesResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestAddRulesResponseParamsProxyToResponder.class */
    static class NetworkServiceTestAddRulesResponseParamsProxyToResponder implements NetworkServiceTest.AddRulesResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestAddRulesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestAddRulesResponseParams _response = new NetworkServiceTestAddRulesResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkChangeParams.class */
    static final class NetworkServiceTestSimulateNetworkChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;

        private NetworkServiceTestSimulateNetworkChangeParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestSimulateNetworkChangeParams() {
            this(0);
        }

        public static NetworkServiceTestSimulateNetworkChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSimulateNetworkChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSimulateNetworkChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSimulateNetworkChangeParams result = new NetworkServiceTestSimulateNetworkChangeParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                ConnectionType.validate(result.type);
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
            encoder0.encode(this.type, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkChangeResponseParams.class */
    static final class NetworkServiceTestSimulateNetworkChangeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestSimulateNetworkChangeResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestSimulateNetworkChangeResponseParams() {
            this(0);
        }

        public static NetworkServiceTestSimulateNetworkChangeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSimulateNetworkChangeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSimulateNetworkChangeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSimulateNetworkChangeResponseParams result = new NetworkServiceTestSimulateNetworkChangeResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback.class */
    static class NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.SimulateNetworkChangeResponse mCallback;

        NetworkServiceTestSimulateNetworkChangeResponseParamsForwardToCallback(NetworkServiceTest.SimulateNetworkChangeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder.class */
    static class NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder implements NetworkServiceTest.SimulateNetworkChangeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestSimulateNetworkChangeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestSimulateNetworkChangeResponseParams _response = new NetworkServiceTestSimulateNetworkChangeResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkQualityChangeParams.class */
    static final class NetworkServiceTestSimulateNetworkQualityChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;

        private NetworkServiceTestSimulateNetworkQualityChangeParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestSimulateNetworkQualityChangeParams() {
            this(0);
        }

        public static NetworkServiceTestSimulateNetworkQualityChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSimulateNetworkQualityChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSimulateNetworkQualityChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSimulateNetworkQualityChangeParams result = new NetworkServiceTestSimulateNetworkQualityChangeParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                EffectiveConnectionType.validate(result.type);
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
            encoder0.encode(this.type, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkQualityChangeResponseParams.class */
    static final class NetworkServiceTestSimulateNetworkQualityChangeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestSimulateNetworkQualityChangeResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestSimulateNetworkQualityChangeResponseParams() {
            this(0);
        }

        public static NetworkServiceTestSimulateNetworkQualityChangeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSimulateNetworkQualityChangeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSimulateNetworkQualityChangeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSimulateNetworkQualityChangeResponseParams result = new NetworkServiceTestSimulateNetworkQualityChangeResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback.class */
    static class NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.SimulateNetworkQualityChangeResponse mCallback;

        NetworkServiceTestSimulateNetworkQualityChangeResponseParamsForwardToCallback(NetworkServiceTest.SimulateNetworkQualityChangeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder.class */
    static class NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder implements NetworkServiceTest.SimulateNetworkQualityChangeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestSimulateNetworkQualityChangeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestSimulateNetworkQualityChangeResponseParams _response = new NetworkServiceTestSimulateNetworkQualityChangeResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSimulateCrashParams.class */
    static final class NetworkServiceTestSimulateCrashParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestSimulateCrashParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestSimulateCrashParams() {
            this(0);
        }

        public static NetworkServiceTestSimulateCrashParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSimulateCrashParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSimulateCrashParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSimulateCrashParams result = new NetworkServiceTestSimulateCrashParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierSetDefaultResultParams.class */
    static final class NetworkServiceTestMockCertVerifierSetDefaultResultParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int defaultResult;

        private NetworkServiceTestMockCertVerifierSetDefaultResultParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestMockCertVerifierSetDefaultResultParams() {
            this(0);
        }

        public static NetworkServiceTestMockCertVerifierSetDefaultResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestMockCertVerifierSetDefaultResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestMockCertVerifierSetDefaultResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestMockCertVerifierSetDefaultResultParams result = new NetworkServiceTestMockCertVerifierSetDefaultResultParams(elementsOrVersion);
                result.defaultResult = decoder0.readInt(8);
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
            encoder0.encode(this.defaultResult, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams.class */
    static final class NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams() {
            this(0);
        }

        public static NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams result = new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback.class */
    static class NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.MockCertVerifierSetDefaultResultResponse mCallback;

        NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsForwardToCallback(NetworkServiceTest.MockCertVerifierSetDefaultResultResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder.class */
    static class NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder implements NetworkServiceTest.MockCertVerifierSetDefaultResultResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestMockCertVerifierSetDefaultResultResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams _response = new NetworkServiceTestMockCertVerifierSetDefaultResultResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams.class */
    static final class NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public X509Certificate cert;
        public String hostPattern;
        public CertVerifyResult verifyResult;
        public int rv;

        private NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams(int version) {
            super(40, version);
        }

        public NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams() {
            this(0);
        }

        public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams result = new NetworkServiceTestMockCertVerifierAddResultForCertAndHostParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cert = X509Certificate.decode(decoder1);
                result.hostPattern = decoder0.readString(16, false);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.verifyResult = CertVerifyResult.decode(decoder12);
                result.rv = decoder0.readInt(32);
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
            encoder0.encode((Struct) this.cert, 8, false);
            encoder0.encode(this.hostPattern, 16, false);
            encoder0.encode((Struct) this.verifyResult, 24, false);
            encoder0.encode(this.rv, 32);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams.class */
    static final class NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams() {
            this(0);
        }

        public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams result = new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback.class */
    static class NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.MockCertVerifierAddResultForCertAndHostResponse mCallback;

        NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsForwardToCallback(NetworkServiceTest.MockCertVerifierAddResultForCertAndHostResponse callback) {
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder.class */
    static class NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder implements NetworkServiceTest.MockCertVerifierAddResultForCertAndHostResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams _response = new NetworkServiceTestMockCertVerifierAddResultForCertAndHostResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetShouldRequireCtParams.class */
    static final class NetworkServiceTestSetShouldRequireCtParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int required;

        private NetworkServiceTestSetShouldRequireCtParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestSetShouldRequireCtParams() {
            this(0);
        }

        public static NetworkServiceTestSetShouldRequireCtParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSetShouldRequireCtParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSetShouldRequireCtParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSetShouldRequireCtParams result = new NetworkServiceTestSetShouldRequireCtParams(elementsOrVersion);
                result.required = decoder0.readInt(8);
                NetworkServiceTest.ShouldRequireCt.validate(result.required);
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
            encoder0.encode(this.required, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetShouldRequireCtResponseParams.class */
    static final class NetworkServiceTestSetShouldRequireCtResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestSetShouldRequireCtResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestSetShouldRequireCtResponseParams() {
            this(0);
        }

        public static NetworkServiceTestSetShouldRequireCtResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSetShouldRequireCtResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSetShouldRequireCtResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSetShouldRequireCtResponseParams result = new NetworkServiceTestSetShouldRequireCtResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetShouldRequireCtResponseParamsForwardToCallback.class */
    static class NetworkServiceTestSetShouldRequireCtResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.SetShouldRequireCtResponse mCallback;

        NetworkServiceTestSetShouldRequireCtResponseParamsForwardToCallback(NetworkServiceTest.SetShouldRequireCtResponse callback) {
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetShouldRequireCtResponseParamsProxyToResponder.class */
    static class NetworkServiceTestSetShouldRequireCtResponseParamsProxyToResponder implements NetworkServiceTest.SetShouldRequireCtResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestSetShouldRequireCtResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestSetShouldRequireCtResponseParams _response = new NetworkServiceTestSetShouldRequireCtResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetTransportSecurityStateSourceParams.class */
    static final class NetworkServiceTestSetTransportSecurityStateSourceParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public short reportingPort;

        private NetworkServiceTestSetTransportSecurityStateSourceParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestSetTransportSecurityStateSourceParams() {
            this(0);
        }

        public static NetworkServiceTestSetTransportSecurityStateSourceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSetTransportSecurityStateSourceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSetTransportSecurityStateSourceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSetTransportSecurityStateSourceParams result = new NetworkServiceTestSetTransportSecurityStateSourceParams(elementsOrVersion);
                result.reportingPort = decoder0.readShort(8);
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
            encoder0.encode(this.reportingPort, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetTransportSecurityStateSourceResponseParams.class */
    static final class NetworkServiceTestSetTransportSecurityStateSourceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestSetTransportSecurityStateSourceResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestSetTransportSecurityStateSourceResponseParams() {
            this(0);
        }

        public static NetworkServiceTestSetTransportSecurityStateSourceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestSetTransportSecurityStateSourceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestSetTransportSecurityStateSourceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestSetTransportSecurityStateSourceResponseParams result = new NetworkServiceTestSetTransportSecurityStateSourceResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback.class */
    static class NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.SetTransportSecurityStateSourceResponse mCallback;

        NetworkServiceTestSetTransportSecurityStateSourceResponseParamsForwardToCallback(NetworkServiceTest.SetTransportSecurityStateSourceResponse callback) {
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
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder.class */
    static class NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder implements NetworkServiceTest.SetTransportSecurityStateSourceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestSetTransportSecurityStateSourceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceTestSetTransportSecurityStateSourceResponseParams _response = new NetworkServiceTestSetTransportSecurityStateSourceResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestCrashOnResolveHostParams.class */
    static final class NetworkServiceTestCrashOnResolveHostParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;

        private NetworkServiceTestCrashOnResolveHostParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestCrashOnResolveHostParams() {
            this(0);
        }

        public static NetworkServiceTestCrashOnResolveHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestCrashOnResolveHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestCrashOnResolveHostParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestCrashOnResolveHostParams result = new NetworkServiceTestCrashOnResolveHostParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestCrashOnGetCookieListParams.class */
    static final class NetworkServiceTestCrashOnGetCookieListParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestCrashOnGetCookieListParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestCrashOnGetCookieListParams() {
            this(0);
        }

        public static NetworkServiceTestCrashOnGetCookieListParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestCrashOnGetCookieListParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestCrashOnGetCookieListParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestCrashOnGetCookieListParams result = new NetworkServiceTestCrashOnGetCookieListParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetLatestMemoryPressureLevelParams.class */
    static final class NetworkServiceTestGetLatestMemoryPressureLevelParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestGetLatestMemoryPressureLevelParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestGetLatestMemoryPressureLevelParams() {
            this(0);
        }

        public static NetworkServiceTestGetLatestMemoryPressureLevelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestGetLatestMemoryPressureLevelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestGetLatestMemoryPressureLevelParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestGetLatestMemoryPressureLevelParams result = new NetworkServiceTestGetLatestMemoryPressureLevelParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetLatestMemoryPressureLevelResponseParams.class */
    public static final class NetworkServiceTestGetLatestMemoryPressureLevelResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int memoryPressureLevel;

        private NetworkServiceTestGetLatestMemoryPressureLevelResponseParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestGetLatestMemoryPressureLevelResponseParams() {
            this(0);
        }

        public static NetworkServiceTestGetLatestMemoryPressureLevelResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestGetLatestMemoryPressureLevelResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestGetLatestMemoryPressureLevelResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestGetLatestMemoryPressureLevelResponseParams result = new NetworkServiceTestGetLatestMemoryPressureLevelResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback.class */
    static class NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.GetLatestMemoryPressureLevelResponse mCallback;

        NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsForwardToCallback(NetworkServiceTest.GetLatestMemoryPressureLevelResponse callback) {
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
                NetworkServiceTestGetLatestMemoryPressureLevelResponseParams response = NetworkServiceTestGetLatestMemoryPressureLevelResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.memoryPressureLevel));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder.class */
    static class NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder implements NetworkServiceTest.GetLatestMemoryPressureLevelResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestGetLatestMemoryPressureLevelResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer memoryPressureLevel) {
            NetworkServiceTestGetLatestMemoryPressureLevelResponseParams _response = new NetworkServiceTestGetLatestMemoryPressureLevelResponseParams();
            _response.memoryPressureLevel = memoryPressureLevel.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams.class */
    static final class NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams(int version) {
            super(8, version);
        }

        public NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams() {
            this(0);
        }

        public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams result = new NetworkServiceTestGetPeerToPeerConnectionsCountChangeParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams.class */
    public static final class NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int connectionCount;

        private NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams() {
            this(0);
        }

        public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams result = new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams(elementsOrVersion);
                result.connectionCount = decoder0.readInt(8);
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
            encoder0.encode(this.connectionCount, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback.class */
    static class NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.GetPeerToPeerConnectionsCountChangeResponse mCallback;

        NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsForwardToCallback(NetworkServiceTest.GetPeerToPeerConnectionsCountChangeResponse callback) {
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
                NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams response = NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.connectionCount));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder.class */
    static class NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder implements NetworkServiceTest.GetPeerToPeerConnectionsCountChangeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer connectionCount) {
            NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams _response = new NetworkServiceTestGetPeerToPeerConnectionsCountChangeResponseParams();
            _response.connectionCount = connectionCount.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetEnvironmentVariableValueParams.class */
    static final class NetworkServiceTestGetEnvironmentVariableValueParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String name;

        private NetworkServiceTestGetEnvironmentVariableValueParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestGetEnvironmentVariableValueParams() {
            this(0);
        }

        public static NetworkServiceTestGetEnvironmentVariableValueParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestGetEnvironmentVariableValueParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestGetEnvironmentVariableValueParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestGetEnvironmentVariableValueParams result = new NetworkServiceTestGetEnvironmentVariableValueParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
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
            encoder0.encode(this.name, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetEnvironmentVariableValueResponseParams.class */
    public static final class NetworkServiceTestGetEnvironmentVariableValueResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String value;

        private NetworkServiceTestGetEnvironmentVariableValueResponseParams(int version) {
            super(16, version);
        }

        public NetworkServiceTestGetEnvironmentVariableValueResponseParams() {
            this(0);
        }

        public static NetworkServiceTestGetEnvironmentVariableValueResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceTestGetEnvironmentVariableValueResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceTestGetEnvironmentVariableValueResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceTestGetEnvironmentVariableValueResponseParams result = new NetworkServiceTestGetEnvironmentVariableValueResponseParams(elementsOrVersion);
                result.value = decoder0.readString(8, false);
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
            encoder0.encode(this.value, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback.class */
    static class NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceTest.GetEnvironmentVariableValueResponse mCallback;

        NetworkServiceTestGetEnvironmentVariableValueResponseParamsForwardToCallback(NetworkServiceTest.GetEnvironmentVariableValueResponse callback) {
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
                NetworkServiceTestGetEnvironmentVariableValueResponseParams response = NetworkServiceTestGetEnvironmentVariableValueResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.value);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceTest_Internal$NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder.class */
    static class NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder implements NetworkServiceTest.GetEnvironmentVariableValueResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceTestGetEnvironmentVariableValueResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(String value) {
            NetworkServiceTestGetEnvironmentVariableValueResponseParams _response = new NetworkServiceTestGetEnvironmentVariableValueResponseParams();
            _response.value = value;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
