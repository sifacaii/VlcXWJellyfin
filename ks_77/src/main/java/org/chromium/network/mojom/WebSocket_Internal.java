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
import org.chromium.network.mojom.WebSocket;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket_Internal.class */
class WebSocket_Internal {
    public static final Interface.Manager<WebSocket, WebSocket.Proxy> MANAGER = new Interface.Manager<WebSocket, WebSocket.Proxy>() { // from class: org.chromium.network.mojom.WebSocket_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.WebSocket";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public WebSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, WebSocket impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public WebSocket[] buildArray(int size) {
            return new WebSocket[size];
        }
    };
    private static final int SEND_FRAME_ORDINAL = 0;
    private static final int ADD_RECEIVE_FLOW_CONTROL_QUOTA_ORDINAL = 1;
    private static final int START_CLOSING_HANDSHAKE_ORDINAL = 2;

    WebSocket_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements WebSocket.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.WebSocket
        public void sendFrame(boolean fin, int type, byte[] data) {
            WebSocketSendFrameParams _message = new WebSocketSendFrameParams();
            _message.fin = fin;
            _message.type = type;
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.WebSocket
        public void addReceiveFlowControlQuota(long quota) {
            WebSocketAddReceiveFlowControlQuotaParams _message = new WebSocketAddReceiveFlowControlQuotaParams();
            _message.quota = quota;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.WebSocket
        public void startClosingHandshake(short code, String reason) {
            WebSocketStartClosingHandshakeParams _message = new WebSocketStartClosingHandshakeParams();
            _message.code = code;
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<WebSocket> {
        Stub(Core core, WebSocket impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebSocket_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        WebSocketSendFrameParams data = WebSocketSendFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().sendFrame(data.fin, data.type, data.data);
                        return true;
                    case 1:
                        getImpl().addReceiveFlowControlQuota(WebSocketAddReceiveFlowControlQuotaParams.deserialize(messageWithHeader.getPayload()).quota);
                        return true;
                    case 2:
                        WebSocketStartClosingHandshakeParams data2 = WebSocketStartClosingHandshakeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().startClosingHandshake(data2.code, data2.reason);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), WebSocket_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket_Internal$WebSocketSendFrameParams.class */
    static final class WebSocketSendFrameParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean fin;
        public int type;
        public byte[] data;

        private WebSocketSendFrameParams(int version) {
            super(24, version);
        }

        public WebSocketSendFrameParams() {
            this(0);
        }

        public static WebSocketSendFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketSendFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketSendFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketSendFrameParams result = new WebSocketSendFrameParams(elementsOrVersion);
                result.fin = decoder0.readBoolean(8, 0);
                result.type = decoder0.readInt(12);
                WebSocketMessageType.validate(result.type);
                result.data = decoder0.readBytes(16, 0, -1);
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
            encoder0.encode(this.fin, 8, 0);
            encoder0.encode(this.type, 12);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket_Internal$WebSocketAddReceiveFlowControlQuotaParams.class */
    static final class WebSocketAddReceiveFlowControlQuotaParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public long quota;

        private WebSocketAddReceiveFlowControlQuotaParams(int version) {
            super(16, version);
        }

        public WebSocketAddReceiveFlowControlQuotaParams() {
            this(0);
        }

        public static WebSocketAddReceiveFlowControlQuotaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketAddReceiveFlowControlQuotaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketAddReceiveFlowControlQuotaParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketAddReceiveFlowControlQuotaParams result = new WebSocketAddReceiveFlowControlQuotaParams(elementsOrVersion);
                result.quota = decoder0.readLong(8);
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
            encoder0.encode(this.quota, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocket_Internal$WebSocketStartClosingHandshakeParams.class */
    static final class WebSocketStartClosingHandshakeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public short code;
        public String reason;

        private WebSocketStartClosingHandshakeParams(int version) {
            super(24, version);
        }

        public WebSocketStartClosingHandshakeParams() {
            this(0);
        }

        public static WebSocketStartClosingHandshakeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketStartClosingHandshakeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketStartClosingHandshakeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketStartClosingHandshakeParams result = new WebSocketStartClosingHandshakeParams(elementsOrVersion);
                result.code = decoder0.readShort(8);
                result.reason = decoder0.readString(16, false);
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
            encoder0.encode(this.code, 8);
            encoder0.encode(this.reason, 16, false);
        }
    }
}
