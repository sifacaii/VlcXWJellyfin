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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.network.mojom.TcpBoundSocket;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal.class */
class TcpBoundSocket_Internal {
    public static final Interface.Manager<TcpBoundSocket, TcpBoundSocket.Proxy> MANAGER = new Interface.Manager<TcpBoundSocket, TcpBoundSocket.Proxy>() { // from class: org.chromium.network.mojom.TcpBoundSocket_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.TCPBoundSocket";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public TcpBoundSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, TcpBoundSocket impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public TcpBoundSocket[] buildArray(int size) {
            return new TcpBoundSocket[size];
        }
    };
    private static final int LISTEN_ORDINAL = 0;
    private static final int CONNECT_ORDINAL = 1;

    TcpBoundSocket_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements TcpBoundSocket.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.TcpBoundSocket
        public void listen(int backlog, InterfaceRequest<TcpServerSocket> socket, TcpBoundSocket.ListenResponse callback) {
            TcpBoundSocketListenParams _message = new TcpBoundSocketListenParams();
            _message.backlog = backlog;
            _message.socket = socket;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new TcpBoundSocketListenResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.TcpBoundSocket
        public void connect(AddressList remoteAddrList, TcpConnectedSocketOptions tcpConnectedSocketOptions, InterfaceRequest<TcpConnectedSocket> socket, SocketObserver observer, TcpBoundSocket.ConnectResponse callback) {
            TcpBoundSocketConnectParams _message = new TcpBoundSocketConnectParams();
            _message.remoteAddrList = remoteAddrList;
            _message.tcpConnectedSocketOptions = tcpConnectedSocketOptions;
            _message.socket = socket;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new TcpBoundSocketConnectResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<TcpBoundSocket> {
        Stub(Core core, TcpBoundSocket impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TcpBoundSocket_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), TcpBoundSocket_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        TcpBoundSocketListenParams data = TcpBoundSocketListenParams.deserialize(messageWithHeader.getPayload());
                        getImpl().listen(data.backlog, data.socket, new TcpBoundSocketListenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        TcpBoundSocketConnectParams data2 = TcpBoundSocketConnectParams.deserialize(messageWithHeader.getPayload());
                        getImpl().connect(data2.remoteAddrList, data2.tcpConnectedSocketOptions, data2.socket, data2.observer, new TcpBoundSocketConnectResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketListenParams.class */
    static final class TcpBoundSocketListenParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int backlog;
        public InterfaceRequest<TcpServerSocket> socket;

        private TcpBoundSocketListenParams(int version) {
            super(16, version);
        }

        public TcpBoundSocketListenParams() {
            this(0);
        }

        public static TcpBoundSocketListenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TcpBoundSocketListenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TcpBoundSocketListenParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TcpBoundSocketListenParams result = new TcpBoundSocketListenParams(elementsOrVersion);
                result.backlog = decoder0.readInt(8);
                result.socket = decoder0.readInterfaceRequest(12, false);
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
            encoder0.encode(this.backlog, 8);
            encoder0.encode((InterfaceRequest) this.socket, 12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketListenResponseParams.class */
    public static final class TcpBoundSocketListenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;

        private TcpBoundSocketListenResponseParams(int version) {
            super(16, version);
        }

        public TcpBoundSocketListenResponseParams() {
            this(0);
        }

        public static TcpBoundSocketListenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TcpBoundSocketListenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TcpBoundSocketListenResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TcpBoundSocketListenResponseParams result = new TcpBoundSocketListenResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
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
            encoder0.encode(this.netError, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketListenResponseParamsForwardToCallback.class */
    static class TcpBoundSocketListenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final TcpBoundSocket.ListenResponse mCallback;

        TcpBoundSocketListenResponseParamsForwardToCallback(TcpBoundSocket.ListenResponse callback) {
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
                TcpBoundSocketListenResponseParams response = TcpBoundSocketListenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketListenResponseParamsProxyToResponder.class */
    static class TcpBoundSocketListenResponseParamsProxyToResponder implements TcpBoundSocket.ListenResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpBoundSocketListenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer netError) {
            TcpBoundSocketListenResponseParams _response = new TcpBoundSocketListenResponseParams();
            _response.netError = netError.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketConnectParams.class */
    static final class TcpBoundSocketConnectParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AddressList remoteAddrList;
        public TcpConnectedSocketOptions tcpConnectedSocketOptions;
        public InterfaceRequest<TcpConnectedSocket> socket;
        public SocketObserver observer;

        private TcpBoundSocketConnectParams(int version) {
            super(40, version);
        }

        public TcpBoundSocketConnectParams() {
            this(0);
        }

        public static TcpBoundSocketConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TcpBoundSocketConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TcpBoundSocketConnectParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TcpBoundSocketConnectParams result = new TcpBoundSocketConnectParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.remoteAddrList = AddressList.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, true);
                result.tcpConnectedSocketOptions = TcpConnectedSocketOptions.decode(decoder12);
                result.socket = decoder0.readInterfaceRequest(24, false);
                result.observer = (SocketObserver) decoder0.readServiceInterface(28, true, SocketObserver.MANAGER);
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
            encoder0.encode((Struct) this.remoteAddrList, 8, false);
            encoder0.encode((Struct) this.tcpConnectedSocketOptions, 16, true);
            encoder0.encode((InterfaceRequest) this.socket, 24, false);
            encoder0.encode(this.observer,28,true, SocketObserver.MANAGER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketConnectResponseParams.class */
    public static final class TcpBoundSocketConnectResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public IpEndPoint localAddr;
        public IpEndPoint peerAddr;
        public DataPipe.ConsumerHandle receiveStream;
        public DataPipe.ProducerHandle sendStream;

        private TcpBoundSocketConnectResponseParams(int version) {
            super(40, version);
            this.receiveStream = InvalidHandle.INSTANCE;
            this.sendStream = InvalidHandle.INSTANCE;
        }

        public TcpBoundSocketConnectResponseParams() {
            this(0);
        }

        public static TcpBoundSocketConnectResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TcpBoundSocketConnectResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TcpBoundSocketConnectResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TcpBoundSocketConnectResponseParams result = new TcpBoundSocketConnectResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
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
            encoder0.encode(this.netError, 8);
            encoder0.encode((Handle) this.receiveStream, 12, true);
            encoder0.encode((Struct) this.localAddr, 16, true);
            encoder0.encode((Struct) this.peerAddr, 24, true);
            encoder0.encode((Handle) this.sendStream, 32, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketConnectResponseParamsForwardToCallback.class */
    static class TcpBoundSocketConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final TcpBoundSocket.ConnectResponse mCallback;

        TcpBoundSocketConnectResponseParamsForwardToCallback(TcpBoundSocket.ConnectResponse callback) {
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
                TcpBoundSocketConnectResponseParams response = TcpBoundSocketConnectResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError), response.localAddr, response.peerAddr, response.receiveStream, response.sendStream);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket_Internal$TcpBoundSocketConnectResponseParamsProxyToResponder.class */
    static class TcpBoundSocketConnectResponseParamsProxyToResponder implements TcpBoundSocket.ConnectResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpBoundSocketConnectResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback5
        public void call(Integer netError, IpEndPoint localAddr, IpEndPoint peerAddr, DataPipe.ConsumerHandle receiveStream, DataPipe.ProducerHandle sendStream) {
            TcpBoundSocketConnectResponseParams _response = new TcpBoundSocketConnectResponseParams();
            _response.netError = netError.intValue();
            _response.localAddr = localAddr;
            _response.peerAddr = peerAddr;
            _response.receiveStream = receiveStream;
            _response.sendStream = sendStream;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
