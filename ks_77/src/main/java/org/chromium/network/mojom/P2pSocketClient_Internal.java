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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.network.mojom.P2pSocketClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal.class */
class P2pSocketClient_Internal {
    public static final Interface.Manager<P2pSocketClient, P2pSocketClient.Proxy> MANAGER = new Interface.Manager<P2pSocketClient, P2pSocketClient.Proxy>() { // from class: org.chromium.network.mojom.P2pSocketClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.P2PSocketClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public P2pSocketClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, P2pSocketClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public P2pSocketClient[] buildArray(int size) {
            return new P2pSocketClient[size];
        }
    };
    private static final int SOCKET_CREATED_ORDINAL = 0;
    private static final int SEND_COMPLETE_ORDINAL = 1;
    private static final int INCOMING_TCP_CONNECTION_ORDINAL = 2;
    private static final int DATA_RECEIVED_ORDINAL = 3;

    P2pSocketClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements P2pSocketClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.P2pSocketClient
        public void socketCreated(IpEndPoint localAddress, IpEndPoint remoteAddress) {
            P2pSocketClientSocketCreatedParams _message = new P2pSocketClientSocketCreatedParams();
            _message.localAddress = localAddress;
            _message.remoteAddress = remoteAddress;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.P2pSocketClient
        public void sendComplete(P2pSendPacketMetrics sendMetrics) {
            P2pSocketClientSendCompleteParams _message = new P2pSocketClientSendCompleteParams();
            _message.sendMetrics = sendMetrics;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.P2pSocketClient
        public void incomingTcpConnection(IpEndPoint socketAddress, P2pSocket socket, InterfaceRequest<P2pSocketClient> client) {
            P2pSocketClientIncomingTcpConnectionParams _message = new P2pSocketClientIncomingTcpConnectionParams();
            _message.socketAddress = socketAddress;
            _message.socket = socket;
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.network.mojom.P2pSocketClient
        public void dataReceived(IpEndPoint socketAddress, byte[] data, TimeTicks timestamp) {
            P2pSocketClientDataReceivedParams _message = new P2pSocketClientDataReceivedParams();
            _message.socketAddress = socketAddress;
            _message.data = data;
            _message.timestamp = timestamp;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<P2pSocketClient> {
        Stub(Core core, P2pSocketClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(P2pSocketClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        P2pSocketClientSocketCreatedParams data = P2pSocketClientSocketCreatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().socketCreated(data.localAddress, data.remoteAddress);
                        return true;
                    case 1:
                        getImpl().sendComplete(P2pSocketClientSendCompleteParams.deserialize(messageWithHeader.getPayload()).sendMetrics);
                        return true;
                    case 2:
                        P2pSocketClientIncomingTcpConnectionParams data2 = P2pSocketClientIncomingTcpConnectionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().incomingTcpConnection(data2.socketAddress, data2.socket, data2.client);
                        return true;
                    case 3:
                        P2pSocketClientDataReceivedParams data3 = P2pSocketClientDataReceivedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().dataReceived(data3.socketAddress, data3.data, data3.timestamp);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), P2pSocketClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal$P2pSocketClientSocketCreatedParams.class */
    static final class P2pSocketClientSocketCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint localAddress;
        public IpEndPoint remoteAddress;

        private P2pSocketClientSocketCreatedParams(int version) {
            super(24, version);
        }

        public P2pSocketClientSocketCreatedParams() {
            this(0);
        }

        public static P2pSocketClientSocketCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketClientSocketCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketClientSocketCreatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketClientSocketCreatedParams result = new P2pSocketClientSocketCreatedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.localAddress = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.remoteAddress = IpEndPoint.decode(decoder12);
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
            encoder0.encode((Struct) this.localAddress, 8, false);
            encoder0.encode((Struct) this.remoteAddress, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal$P2pSocketClientSendCompleteParams.class */
    static final class P2pSocketClientSendCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public P2pSendPacketMetrics sendMetrics;

        private P2pSocketClientSendCompleteParams(int version) {
            super(16, version);
        }

        public P2pSocketClientSendCompleteParams() {
            this(0);
        }

        public static P2pSocketClientSendCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketClientSendCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketClientSendCompleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketClientSendCompleteParams result = new P2pSocketClientSendCompleteParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.sendMetrics = P2pSendPacketMetrics.decode(decoder1);
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
            encoder0.encode((Struct) this.sendMetrics, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal$P2pSocketClientIncomingTcpConnectionParams.class */
    static final class P2pSocketClientIncomingTcpConnectionParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint socketAddress;
        public P2pSocket socket;
        public InterfaceRequest<P2pSocketClient> client;

        private P2pSocketClientIncomingTcpConnectionParams(int version) {
            super(32, version);
        }

        public P2pSocketClientIncomingTcpConnectionParams() {
            this(0);
        }

        public static P2pSocketClientIncomingTcpConnectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketClientIncomingTcpConnectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketClientIncomingTcpConnectionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketClientIncomingTcpConnectionParams result = new P2pSocketClientIncomingTcpConnectionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.socketAddress = IpEndPoint.decode(decoder1);
                result.socket = (P2pSocket) decoder0.readServiceInterface(16, false, P2pSocket.MANAGER);
                result.client = decoder0.readInterfaceRequest(24, false);
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
            encoder0.encode((Struct) this.socketAddress, 8, false);
            encoder0.encode(this.socket,16,false, P2pSocket.MANAGER);
            encoder0.encode((InterfaceRequest) this.client, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient_Internal$P2pSocketClientDataReceivedParams.class */
    static final class P2pSocketClientDataReceivedParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public IpEndPoint socketAddress;
        public byte[] data;
        public TimeTicks timestamp;

        private P2pSocketClientDataReceivedParams(int version) {
            super(32, version);
        }

        public P2pSocketClientDataReceivedParams() {
            this(0);
        }

        public static P2pSocketClientDataReceivedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketClientDataReceivedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketClientDataReceivedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketClientDataReceivedParams result = new P2pSocketClientDataReceivedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.socketAddress = IpEndPoint.decode(decoder1);
                result.data = decoder0.readBytes(16, 0, -1);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.timestamp = TimeTicks.decode(decoder12);
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
            encoder0.encode((Struct) this.socketAddress, 8, false);
            encoder0.encode(this.data, 16, 0, -1);
            encoder0.encode((Struct) this.timestamp, 24, false);
        }
    }
}
