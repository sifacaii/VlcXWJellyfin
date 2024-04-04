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
import org.chromium.network.mojom.P2pSocketManager;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal.class */
class P2pSocketManager_Internal {
    public static final Interface.Manager<P2pSocketManager, P2pSocketManager.Proxy> MANAGER = new Interface.Manager<P2pSocketManager, P2pSocketManager.Proxy>() { // from class: org.chromium.network.mojom.P2pSocketManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.P2PSocketManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public P2pSocketManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, P2pSocketManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public P2pSocketManager[] buildArray(int size) {
            return new P2pSocketManager[size];
        }
    };
    private static final int START_NETWORK_NOTIFICATIONS_ORDINAL = 0;
    private static final int GET_HOST_ADDRESS_ORDINAL = 1;
    private static final int CREATE_SOCKET_ORDINAL = 2;

    P2pSocketManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements P2pSocketManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.P2pSocketManager
        public void startNetworkNotifications(P2pNetworkNotificationClient client) {
            P2pSocketManagerStartNetworkNotificationsParams _message = new P2pSocketManagerStartNetworkNotificationsParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.P2pSocketManager
        public void getHostAddress(String hostName, boolean enableMdns, P2pSocketManager.GetHostAddressResponse callback) {
            P2pSocketManagerGetHostAddressParams _message = new P2pSocketManagerGetHostAddressParams();
            _message.hostName = hostName;
            _message.enableMdns = enableMdns;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new P2pSocketManagerGetHostAddressResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.P2pSocketManager
        public void createSocket(int type, IpEndPoint localAddress, P2pPortRange portRange, P2pHostAndIpEndPoint remoteAddress, P2pSocketClient client, InterfaceRequest<P2pSocket> socket) {
            P2pSocketManagerCreateSocketParams _message = new P2pSocketManagerCreateSocketParams();
            _message.type = type;
            _message.localAddress = localAddress;
            _message.portRange = portRange;
            _message.remoteAddress = remoteAddress;
            _message.client = client;
            _message.socket = socket;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<P2pSocketManager> {
        Stub(Core core, P2pSocketManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(P2pSocketManager_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 1:
                    default:
                        return false;
                    case 0:
                        getImpl().startNetworkNotifications(P2pSocketManagerStartNetworkNotificationsParams.deserialize(messageWithHeader.getPayload()).client);
                        return true;
                    case 2:
                        P2pSocketManagerCreateSocketParams data = P2pSocketManagerCreateSocketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createSocket(data.type, data.localAddress, data.portRange, data.remoteAddress, data.client, data.socket);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), P2pSocketManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        P2pSocketManagerGetHostAddressParams data = P2pSocketManagerGetHostAddressParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getHostAddress(data.hostName, data.enableMdns, new P2pSocketManagerGetHostAddressResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$P2pSocketManagerStartNetworkNotificationsParams.class */
    static final class P2pSocketManagerStartNetworkNotificationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public P2pNetworkNotificationClient client;

        private P2pSocketManagerStartNetworkNotificationsParams(int version) {
            super(16, version);
        }

        public P2pSocketManagerStartNetworkNotificationsParams() {
            this(0);
        }

        public static P2pSocketManagerStartNetworkNotificationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketManagerStartNetworkNotificationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketManagerStartNetworkNotificationsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketManagerStartNetworkNotificationsParams result = new P2pSocketManagerStartNetworkNotificationsParams(elementsOrVersion);
                result.client = (P2pNetworkNotificationClient) decoder0.readServiceInterface(8, false, P2pNetworkNotificationClient.MANAGER);
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
            encoder0.encode(this.client,8,false, P2pNetworkNotificationClient.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$P2pSocketManagerGetHostAddressParams.class */
    static final class P2pSocketManagerGetHostAddressParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String hostName;
        public boolean enableMdns;

        private P2pSocketManagerGetHostAddressParams(int version) {
            super(24, version);
        }

        public P2pSocketManagerGetHostAddressParams() {
            this(0);
        }

        public static P2pSocketManagerGetHostAddressParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketManagerGetHostAddressParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketManagerGetHostAddressParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketManagerGetHostAddressParams result = new P2pSocketManagerGetHostAddressParams(elementsOrVersion);
                result.hostName = decoder0.readString(8, false);
                result.enableMdns = decoder0.readBoolean(16, 0);
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
            encoder0.encode(this.hostName, 8, false);
            encoder0.encode(this.enableMdns, 16, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$P2pSocketManagerGetHostAddressResponseParams.class */
    public static final class P2pSocketManagerGetHostAddressResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpAddress[] addresses;

        private P2pSocketManagerGetHostAddressResponseParams(int version) {
            super(16, version);
        }

        public P2pSocketManagerGetHostAddressResponseParams() {
            this(0);
        }

        public static P2pSocketManagerGetHostAddressResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketManagerGetHostAddressResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketManagerGetHostAddressResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketManagerGetHostAddressResponseParams result = new P2pSocketManagerGetHostAddressResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.addresses = new IpAddress[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.addresses[i1] = IpAddress.decode(decoder2);
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
            if (this.addresses == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.addresses.length, 8, -1);
            for (int i0 = 0; i0 < this.addresses.length; i0++) {
                encoder1.encode((Struct) this.addresses[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$P2pSocketManagerGetHostAddressResponseParamsForwardToCallback.class */
    static class P2pSocketManagerGetHostAddressResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final P2pSocketManager.GetHostAddressResponse mCallback;

        P2pSocketManagerGetHostAddressResponseParamsForwardToCallback(P2pSocketManager.GetHostAddressResponse callback) {
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
                P2pSocketManagerGetHostAddressResponseParams response = P2pSocketManagerGetHostAddressResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.addresses);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$P2pSocketManagerGetHostAddressResponseParamsProxyToResponder.class */
    static class P2pSocketManagerGetHostAddressResponseParamsProxyToResponder implements P2pSocketManager.GetHostAddressResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        P2pSocketManagerGetHostAddressResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(IpAddress[] addresses) {
            P2pSocketManagerGetHostAddressResponseParams _response = new P2pSocketManagerGetHostAddressResponseParams();
            _response.addresses = addresses;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager_Internal$P2pSocketManagerCreateSocketParams.class */
    static final class P2pSocketManagerCreateSocketParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public IpEndPoint localAddress;
        public P2pPortRange portRange;
        public P2pHostAndIpEndPoint remoteAddress;
        public P2pSocketClient client;
        public InterfaceRequest<P2pSocket> socket;

        private P2pSocketManagerCreateSocketParams(int version) {
            super(48, version);
        }

        public P2pSocketManagerCreateSocketParams() {
            this(0);
        }

        public static P2pSocketManagerCreateSocketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketManagerCreateSocketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketManagerCreateSocketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketManagerCreateSocketParams result = new P2pSocketManagerCreateSocketParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                P2pSocketType.validate(result.type);
                result.socket = decoder0.readInterfaceRequest(12, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.localAddress = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.portRange = P2pPortRange.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(32, false);
                result.remoteAddress = P2pHostAndIpEndPoint.decode(decoder13);
                result.client = (P2pSocketClient) decoder0.readServiceInterface(40, false, P2pSocketClient.MANAGER);
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
            encoder0.encode((InterfaceRequest) this.socket, 12, false);
            encoder0.encode((Struct) this.localAddress, 16, false);
            encoder0.encode((Struct) this.portRange, 24, false);
            encoder0.encode((Struct) this.remoteAddress, 32, false);
            encoder0.encode(this.client,40,false, P2pSocketClient.MANAGER);
        }
    }
}
