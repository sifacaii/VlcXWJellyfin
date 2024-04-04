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
import org.chromium.network.mojom.ProxyResolvingSocket;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal.class */
class ProxyResolvingSocket_Internal {
    public static final Interface.Manager<ProxyResolvingSocket, ProxyResolvingSocket.Proxy> MANAGER = new Interface.Manager<ProxyResolvingSocket, ProxyResolvingSocket.Proxy>() { // from class: org.chromium.network.mojom.ProxyResolvingSocket_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.ProxyResolvingSocket";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProxyResolvingSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProxyResolvingSocket impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProxyResolvingSocket[] buildArray(int size) {
            return new ProxyResolvingSocket[size];
        }
    };
    private static final int UPGRADE_TO_TLS_ORDINAL = 0;

    ProxyResolvingSocket_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProxyResolvingSocket.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.ProxyResolvingSocket
        public void upgradeToTls(HostPortPair hostPortPair, MutableNetworkTrafficAnnotationTag trafficAnnotation, InterfaceRequest<TlsClientSocket> request, SocketObserver observer, ProxyResolvingSocket.UpgradeToTlsResponse callback) {
            ProxyResolvingSocketUpgradeToTlsParams _message = new ProxyResolvingSocketUpgradeToTlsParams();
            _message.hostPortPair = hostPortPair;
            _message.trafficAnnotation = trafficAnnotation;
            _message.request = request;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ProxyResolvingSocketUpgradeToTlsResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProxyResolvingSocket> {
        Stub(Core core, ProxyResolvingSocket impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProxyResolvingSocket_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProxyResolvingSocket_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ProxyResolvingSocketUpgradeToTlsParams data = ProxyResolvingSocketUpgradeToTlsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().upgradeToTls(data.hostPortPair, data.trafficAnnotation, data.request, data.observer, new ProxyResolvingSocketUpgradeToTlsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal$ProxyResolvingSocketUpgradeToTlsParams.class */
    static final class ProxyResolvingSocketUpgradeToTlsParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HostPortPair hostPortPair;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;
        public InterfaceRequest<TlsClientSocket> request;
        public SocketObserver observer;

        private ProxyResolvingSocketUpgradeToTlsParams(int version) {
            super(40, version);
        }

        public ProxyResolvingSocketUpgradeToTlsParams() {
            this(0);
        }

        public static ProxyResolvingSocketUpgradeToTlsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolvingSocketUpgradeToTlsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolvingSocketUpgradeToTlsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolvingSocketUpgradeToTlsParams result = new ProxyResolvingSocketUpgradeToTlsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.hostPortPair = HostPortPair.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
                result.request = decoder0.readInterfaceRequest(24, false);
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
            encoder0.encode((Struct) this.hostPortPair, 8, false);
            encoder0.encode((Struct) this.trafficAnnotation, 16, false);
            encoder0.encode((InterfaceRequest) this.request, 24, false);
            encoder0.encode(this.observer,28,true, SocketObserver.MANAGER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal$ProxyResolvingSocketUpgradeToTlsResponseParams.class */
    public static final class ProxyResolvingSocketUpgradeToTlsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public DataPipe.ConsumerHandle receiveStream;
        public DataPipe.ProducerHandle sendStream;

        private ProxyResolvingSocketUpgradeToTlsResponseParams(int version) {
            super(24, version);
            this.receiveStream = InvalidHandle.INSTANCE;
            this.sendStream = InvalidHandle.INSTANCE;
        }

        public ProxyResolvingSocketUpgradeToTlsResponseParams() {
            this(0);
        }

        public static ProxyResolvingSocketUpgradeToTlsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolvingSocketUpgradeToTlsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolvingSocketUpgradeToTlsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolvingSocketUpgradeToTlsResponseParams result = new ProxyResolvingSocketUpgradeToTlsResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
                result.receiveStream = decoder0.readConsumerHandle(12, true);
                result.sendStream = decoder0.readProducerHandle(16, true);
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
            encoder0.encode((Handle) this.sendStream, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal$ProxyResolvingSocketUpgradeToTlsResponseParamsForwardToCallback.class */
    static class ProxyResolvingSocketUpgradeToTlsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ProxyResolvingSocket.UpgradeToTlsResponse mCallback;

        ProxyResolvingSocketUpgradeToTlsResponseParamsForwardToCallback(ProxyResolvingSocket.UpgradeToTlsResponse callback) {
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
                ProxyResolvingSocketUpgradeToTlsResponseParams response = ProxyResolvingSocketUpgradeToTlsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError), response.receiveStream, response.sendStream);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket_Internal$ProxyResolvingSocketUpgradeToTlsResponseParamsProxyToResponder.class */
    static class ProxyResolvingSocketUpgradeToTlsResponseParamsProxyToResponder implements ProxyResolvingSocket.UpgradeToTlsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ProxyResolvingSocketUpgradeToTlsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback3
        public void call(Integer netError, DataPipe.ConsumerHandle receiveStream, DataPipe.ProducerHandle sendStream) {
            ProxyResolvingSocketUpgradeToTlsResponseParams _response = new ProxyResolvingSocketUpgradeToTlsResponseParams();
            _response.netError = netError.intValue();
            _response.receiveStream = receiveStream;
            _response.sendStream = sendStream;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
