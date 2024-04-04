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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.network.mojom.TcpServerSocket;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal.class */
class TcpServerSocket_Internal {
    public static final Interface.Manager<TcpServerSocket, TcpServerSocket.Proxy> MANAGER = new Interface.Manager<TcpServerSocket, TcpServerSocket.Proxy>() { // from class: org.chromium.network.mojom.TcpServerSocket_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.TCPServerSocket";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public TcpServerSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, TcpServerSocket impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public TcpServerSocket[] buildArray(int size) {
            return new TcpServerSocket[size];
        }
    };
    private static final int ACCEPT_ORDINAL = 0;

    TcpServerSocket_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements TcpServerSocket.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.TcpServerSocket
        public void accept(SocketObserver observer, TcpServerSocket.AcceptResponse callback) {
            TcpServerSocketAcceptParams _message = new TcpServerSocketAcceptParams();
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new TcpServerSocketAcceptResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<TcpServerSocket> {
        Stub(Core core, TcpServerSocket impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TcpServerSocket_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), TcpServerSocket_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        TcpServerSocketAcceptParams data = TcpServerSocketAcceptParams.deserialize(messageWithHeader.getPayload());
                        getImpl().accept(data.observer, new TcpServerSocketAcceptResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal$TcpServerSocketAcceptParams.class */
    static final class TcpServerSocketAcceptParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SocketObserver observer;

        private TcpServerSocketAcceptParams(int version) {
            super(16, version);
        }

        public TcpServerSocketAcceptParams() {
            this(0);
        }

        public static TcpServerSocketAcceptParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TcpServerSocketAcceptParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TcpServerSocketAcceptParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TcpServerSocketAcceptParams result = new TcpServerSocketAcceptParams(elementsOrVersion);
                result.observer = (SocketObserver) decoder0.readServiceInterface(8, true, SocketObserver.MANAGER);
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
            encoder0.encode(this.observer,8,true, SocketObserver.MANAGER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal$TcpServerSocketAcceptResponseParams.class */
    public static final class TcpServerSocketAcceptResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public IpEndPoint remoteAddr;
        public TcpConnectedSocket connectedSocket;
        public DataPipe.ConsumerHandle sendStream;
        public DataPipe.ProducerHandle receiveStream;

        private TcpServerSocketAcceptResponseParams(int version) {
            super(40, version);
            this.sendStream = InvalidHandle.INSTANCE;
            this.receiveStream = InvalidHandle.INSTANCE;
        }

        public TcpServerSocketAcceptResponseParams() {
            this(0);
        }

        public static TcpServerSocketAcceptResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TcpServerSocketAcceptResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TcpServerSocketAcceptResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TcpServerSocketAcceptResponseParams result = new TcpServerSocketAcceptResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
                result.sendStream = decoder0.readConsumerHandle(12, true);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.remoteAddr = IpEndPoint.decode(decoder1);
                result.connectedSocket = (TcpConnectedSocket) decoder0.readServiceInterface(24, true, TcpConnectedSocket.MANAGER);
                result.receiveStream = decoder0.readProducerHandle(32, true);
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
            encoder0.encode((Handle) this.sendStream, 12, true);
            encoder0.encode((Struct) this.remoteAddr, 16, true);
            encoder0.encode(this.connectedSocket,24,true, TcpConnectedSocket.MANAGER);
            encoder0.encode((Handle) this.receiveStream, 32, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal$TcpServerSocketAcceptResponseParamsForwardToCallback.class */
    static class TcpServerSocketAcceptResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final TcpServerSocket.AcceptResponse mCallback;

        TcpServerSocketAcceptResponseParamsForwardToCallback(TcpServerSocket.AcceptResponse callback) {
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
                TcpServerSocketAcceptResponseParams response = TcpServerSocketAcceptResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError), response.remoteAddr, response.connectedSocket, response.sendStream, response.receiveStream);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket_Internal$TcpServerSocketAcceptResponseParamsProxyToResponder.class */
    static class TcpServerSocketAcceptResponseParamsProxyToResponder implements TcpServerSocket.AcceptResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpServerSocketAcceptResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback5
        public void call(Integer netError, IpEndPoint remoteAddr, TcpConnectedSocket connectedSocket, DataPipe.ConsumerHandle sendStream, DataPipe.ProducerHandle receiveStream) {
            TcpServerSocketAcceptResponseParams _response = new TcpServerSocketAcceptResponseParams();
            _response.netError = netError.intValue();
            _response.remoteAddr = remoteAddr;
            _response.connectedSocket = connectedSocket;
            _response.sendStream = sendStream;
            _response.receiveStream = receiveStream;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
