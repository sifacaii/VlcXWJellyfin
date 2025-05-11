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
import org.chromium.network.mojom.NetworkChangeManager;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager_Internal.class */
class NetworkChangeManager_Internal {
    public static final Interface.Manager<NetworkChangeManager, NetworkChangeManager.Proxy> MANAGER = new Interface.Manager<NetworkChangeManager, NetworkChangeManager.Proxy>() { // from class: org.chromium.network.mojom.NetworkChangeManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkChangeManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkChangeManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkChangeManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkChangeManager[] buildArray(int size) {
            return new NetworkChangeManager[size];
        }
    };
    private static final int REQUEST_NOTIFICATIONS_ORDINAL = 0;
    private static final int ON_NETWORK_CHANGED_ORDINAL = 1;

    NetworkChangeManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkChangeManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkChangeManager
        public void requestNotifications(NetworkChangeManagerClient clientPtr) {
            NetworkChangeManagerRequestNotificationsParams _message = new NetworkChangeManagerRequestNotificationsParams();
            _message.clientPtr = clientPtr;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.NetworkChangeManager
        public void onNetworkChanged(boolean dnsChanged, boolean ipAddressChanged, boolean connectionTypeChanged, int newConnectionType, boolean connectionSubtypeChanged, int newConnectionSubtype) {
            NetworkChangeManagerOnNetworkChangedParams _message = new NetworkChangeManagerOnNetworkChangedParams();
            _message.dnsChanged = dnsChanged;
            _message.ipAddressChanged = ipAddressChanged;
            _message.connectionTypeChanged = connectionTypeChanged;
            _message.newConnectionType = newConnectionType;
            _message.connectionSubtypeChanged = connectionSubtypeChanged;
            _message.newConnectionSubtype = newConnectionSubtype;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkChangeManager> {
        Stub(Core core, NetworkChangeManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkChangeManager_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        getImpl().requestNotifications(NetworkChangeManagerRequestNotificationsParams.deserialize(messageWithHeader.getPayload()).clientPtr);
                        return true;
                    case 1:
                        NetworkChangeManagerOnNetworkChangedParams data = NetworkChangeManagerOnNetworkChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onNetworkChanged(data.dnsChanged, data.ipAddressChanged, data.connectionTypeChanged, data.newConnectionType, data.connectionSubtypeChanged, data.newConnectionSubtype);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkChangeManager_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager_Internal$NetworkChangeManagerRequestNotificationsParams.class */
    static final class NetworkChangeManagerRequestNotificationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkChangeManagerClient clientPtr;

        private NetworkChangeManagerRequestNotificationsParams(int version) {
            super(16, version);
        }

        public NetworkChangeManagerRequestNotificationsParams() {
            this(0);
        }

        public static NetworkChangeManagerRequestNotificationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkChangeManagerRequestNotificationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkChangeManagerRequestNotificationsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkChangeManagerRequestNotificationsParams result = new NetworkChangeManagerRequestNotificationsParams(elementsOrVersion);
                result.clientPtr = (NetworkChangeManagerClient) decoder0.readServiceInterface(8, false, NetworkChangeManagerClient.MANAGER);
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
            encoder0.encode(this.clientPtr,8,false, NetworkChangeManagerClient.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager_Internal$NetworkChangeManagerOnNetworkChangedParams.class */
    static final class NetworkChangeManagerOnNetworkChangedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean dnsChanged;
        public boolean ipAddressChanged;
        public boolean connectionTypeChanged;
        public int newConnectionType;
        public boolean connectionSubtypeChanged;
        public int newConnectionSubtype;

        private NetworkChangeManagerOnNetworkChangedParams(int version) {
            super(24, version);
        }

        public NetworkChangeManagerOnNetworkChangedParams() {
            this(0);
        }

        public static NetworkChangeManagerOnNetworkChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkChangeManagerOnNetworkChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkChangeManagerOnNetworkChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkChangeManagerOnNetworkChangedParams result = new NetworkChangeManagerOnNetworkChangedParams(elementsOrVersion);
                result.dnsChanged = decoder0.readBoolean(8, 0);
                result.ipAddressChanged = decoder0.readBoolean(8, 1);
                result.connectionTypeChanged = decoder0.readBoolean(8, 2);
                result.connectionSubtypeChanged = decoder0.readBoolean(8, 3);
                result.newConnectionType = decoder0.readInt(12);
                ConnectionType.validate(result.newConnectionType);
                result.newConnectionSubtype = decoder0.readInt(16);
                ConnectionSubtype.validate(result.newConnectionSubtype);
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
            encoder0.encode(this.dnsChanged, 8, 0);
            encoder0.encode(this.ipAddressChanged, 8, 1);
            encoder0.encode(this.connectionTypeChanged, 8, 2);
            encoder0.encode(this.connectionSubtypeChanged, 8, 3);
            encoder0.encode(this.newConnectionType, 12);
            encoder0.encode(this.newConnectionSubtype, 16);
        }
    }
}
