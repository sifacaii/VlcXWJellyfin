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
import org.chromium.network.mojom.WebSocketHandshakeClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient_Internal.class */
class WebSocketHandshakeClient_Internal {
    public static final Interface.Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy> MANAGER = new Interface.Manager<WebSocketHandshakeClient, WebSocketHandshakeClient.Proxy>() { // from class: org.chromium.network.mojom.WebSocketHandshakeClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.WebSocketHandshakeClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public WebSocketHandshakeClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, WebSocketHandshakeClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public WebSocketHandshakeClient[] buildArray(int size) {
            return new WebSocketHandshakeClient[size];
        }
    };
    private static final int ON_OPENING_HANDSHAKE_STARTED_ORDINAL = 0;
    private static final int ON_RESPONSE_RECEIVED_ORDINAL = 1;
    private static final int ON_CONNECTION_ESTABLISHED_ORDINAL = 2;

    WebSocketHandshakeClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements WebSocketHandshakeClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.WebSocketHandshakeClient
        public void onOpeningHandshakeStarted(WebSocketHandshakeRequest request) {
            WebSocketHandshakeClientOnOpeningHandshakeStartedParams _message = new WebSocketHandshakeClientOnOpeningHandshakeStartedParams();
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.WebSocketHandshakeClient
        public void onResponseReceived(WebSocketHandshakeResponse response) {
            WebSocketHandshakeClientOnResponseReceivedParams _message = new WebSocketHandshakeClientOnResponseReceivedParams();
            _message.response = response;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.WebSocketHandshakeClient
        public void onConnectionEstablished(WebSocket socket, String selectedProtocol, String extensions, long receiveQuotaThreshold) {
            WebSocketHandshakeClientOnConnectionEstablishedParams _message = new WebSocketHandshakeClientOnConnectionEstablishedParams();
            _message.socket = socket;
            _message.selectedProtocol = selectedProtocol;
            _message.extensions = extensions;
            _message.receiveQuotaThreshold = receiveQuotaThreshold;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<WebSocketHandshakeClient> {
        Stub(Core core, WebSocketHandshakeClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebSocketHandshakeClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        getImpl().onOpeningHandshakeStarted(WebSocketHandshakeClientOnOpeningHandshakeStartedParams.deserialize(messageWithHeader.getPayload()).request);
                        return true;
                    case 1:
                        getImpl().onResponseReceived(WebSocketHandshakeClientOnResponseReceivedParams.deserialize(messageWithHeader.getPayload()).response);
                        return true;
                    case 2:
                        WebSocketHandshakeClientOnConnectionEstablishedParams data = WebSocketHandshakeClientOnConnectionEstablishedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onConnectionEstablished(data.socket, data.selectedProtocol, data.extensions, data.receiveQuotaThreshold);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), WebSocketHandshakeClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient_Internal$WebSocketHandshakeClientOnOpeningHandshakeStartedParams.class */
    static final class WebSocketHandshakeClientOnOpeningHandshakeStartedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public WebSocketHandshakeRequest request;

        private WebSocketHandshakeClientOnOpeningHandshakeStartedParams(int version) {
            super(16, version);
        }

        public WebSocketHandshakeClientOnOpeningHandshakeStartedParams() {
            this(0);
        }

        public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketHandshakeClientOnOpeningHandshakeStartedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketHandshakeClientOnOpeningHandshakeStartedParams result = new WebSocketHandshakeClientOnOpeningHandshakeStartedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.request = WebSocketHandshakeRequest.decode(decoder1);
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
            encoder0.encode((Struct) this.request, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient_Internal$WebSocketHandshakeClientOnResponseReceivedParams.class */
    static final class WebSocketHandshakeClientOnResponseReceivedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public WebSocketHandshakeResponse response;

        private WebSocketHandshakeClientOnResponseReceivedParams(int version) {
            super(16, version);
        }

        public WebSocketHandshakeClientOnResponseReceivedParams() {
            this(0);
        }

        public static WebSocketHandshakeClientOnResponseReceivedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketHandshakeClientOnResponseReceivedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketHandshakeClientOnResponseReceivedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketHandshakeClientOnResponseReceivedParams result = new WebSocketHandshakeClientOnResponseReceivedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.response = WebSocketHandshakeResponse.decode(decoder1);
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
            encoder0.encode((Struct) this.response, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketHandshakeClient_Internal$WebSocketHandshakeClientOnConnectionEstablishedParams.class */
    static final class WebSocketHandshakeClientOnConnectionEstablishedParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public WebSocket socket;
        public String selectedProtocol;
        public String extensions;
        public long receiveQuotaThreshold;

        private WebSocketHandshakeClientOnConnectionEstablishedParams(int version) {
            super(40, version);
        }

        public WebSocketHandshakeClientOnConnectionEstablishedParams() {
            this(0);
        }

        public static WebSocketHandshakeClientOnConnectionEstablishedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketHandshakeClientOnConnectionEstablishedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketHandshakeClientOnConnectionEstablishedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketHandshakeClientOnConnectionEstablishedParams result = new WebSocketHandshakeClientOnConnectionEstablishedParams(elementsOrVersion);
                result.socket = (WebSocket) decoder0.readServiceInterface(8, false, WebSocket.MANAGER);
                result.selectedProtocol = decoder0.readString(16, false);
                result.extensions = decoder0.readString(24, false);
                result.receiveQuotaThreshold = decoder0.readLong(32);
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
            encoder0.encode(this.socket,8,false, WebSocket.MANAGER);
            encoder0.encode(this.selectedProtocol, 16, false);
            encoder0.encode(this.extensions, 24, false);
            encoder0.encode(this.receiveQuotaThreshold, 32);
        }
    }
}
