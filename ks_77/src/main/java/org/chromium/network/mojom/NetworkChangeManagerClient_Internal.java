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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.NetworkChangeManagerClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient_Internal.class */
class NetworkChangeManagerClient_Internal {
    public static final Interface.Manager<NetworkChangeManagerClient, NetworkChangeManagerClient.Proxy> MANAGER = new Interface.Manager<NetworkChangeManagerClient, NetworkChangeManagerClient.Proxy>() { // from class: org.chromium.network.mojom.NetworkChangeManagerClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkChangeManagerClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkChangeManagerClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkChangeManagerClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkChangeManagerClient[] buildArray(int size) {
            return new NetworkChangeManagerClient[size];
        }
    };
    private static final int ON_INITIAL_CONNECTION_TYPE_ORDINAL = 0;
    private static final int ON_NETWORK_CHANGED_ORDINAL = 1;

    NetworkChangeManagerClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkChangeManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkChangeManagerClient
        public void onInitialConnectionType(int type) {
            NetworkChangeManagerClientOnInitialConnectionTypeParams _message = new NetworkChangeManagerClientOnInitialConnectionTypeParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.NetworkChangeManagerClient
        public void onNetworkChanged(int type) {
            NetworkChangeManagerClientOnNetworkChangedParams _message = new NetworkChangeManagerClientOnNetworkChangedParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkChangeManagerClient> {
        Stub(Core core, NetworkChangeManagerClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkChangeManagerClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        NetworkChangeManagerClientOnInitialConnectionTypeParams data = NetworkChangeManagerClientOnInitialConnectionTypeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onInitialConnectionType(data.type);
                        return true;
                    case 1:
                        NetworkChangeManagerClientOnNetworkChangedParams data2 = NetworkChangeManagerClientOnNetworkChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onNetworkChanged(data2.type);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkChangeManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient_Internal$NetworkChangeManagerClientOnInitialConnectionTypeParams.class */
    static final class NetworkChangeManagerClientOnInitialConnectionTypeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;

        private NetworkChangeManagerClientOnInitialConnectionTypeParams(int version) {
            super(16, version);
        }

        public NetworkChangeManagerClientOnInitialConnectionTypeParams() {
            this(0);
        }

        public static NetworkChangeManagerClientOnInitialConnectionTypeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkChangeManagerClientOnInitialConnectionTypeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkChangeManagerClientOnInitialConnectionTypeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkChangeManagerClientOnInitialConnectionTypeParams result = new NetworkChangeManagerClientOnInitialConnectionTypeParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient_Internal$NetworkChangeManagerClientOnNetworkChangedParams.class */
    static final class NetworkChangeManagerClientOnNetworkChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;

        private NetworkChangeManagerClientOnNetworkChangedParams(int version) {
            super(16, version);
        }

        public NetworkChangeManagerClientOnNetworkChangedParams() {
            this(0);
        }

        public static NetworkChangeManagerClientOnNetworkChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkChangeManagerClientOnNetworkChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkChangeManagerClientOnNetworkChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkChangeManagerClientOnNetworkChangedParams result = new NetworkChangeManagerClientOnNetworkChangedParams(elementsOrVersion);
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
}
