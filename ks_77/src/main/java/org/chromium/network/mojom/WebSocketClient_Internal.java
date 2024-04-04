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
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;
import org.chromium.network.mojom.WebSocketClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal.class */
class WebSocketClient_Internal {
    public static final Interface.Manager<WebSocketClient, WebSocketClient.Proxy> MANAGER = new Interface.Manager<WebSocketClient, WebSocketClient.Proxy>() { // from class: org.chromium.network.mojom.WebSocketClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.WebSocketClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public WebSocketClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, WebSocketClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public WebSocketClient[] buildArray(int size) {
            return new WebSocketClient[size];
        }
    };
    private static final int ON_DATA_FRAME_ORDINAL = 0;
    private static final int ADD_SEND_FLOW_CONTROL_QUOTA_ORDINAL = 1;
    private static final int ON_DROP_CHANNEL_ORDINAL = 2;
    private static final int ON_CLOSING_HANDSHAKE_ORDINAL = 3;

    WebSocketClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements WebSocketClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.WebSocketClient
        public void onDataFrame(boolean fin, int type, ReadOnlyBuffer data) {
            WebSocketClientOnDataFrameParams _message = new WebSocketClientOnDataFrameParams();
            _message.fin = fin;
            _message.type = type;
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.WebSocketClient
        public void addSendFlowControlQuota(long quota) {
            WebSocketClientAddSendFlowControlQuotaParams _message = new WebSocketClientAddSendFlowControlQuotaParams();
            _message.quota = quota;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.WebSocketClient
        public void onDropChannel(boolean wasClean, short code, String reason) {
            WebSocketClientOnDropChannelParams _message = new WebSocketClientOnDropChannelParams();
            _message.wasClean = wasClean;
            _message.code = code;
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.network.mojom.WebSocketClient
        public void onClosingHandshake() {
            WebSocketClientOnClosingHandshakeParams _message = new WebSocketClientOnClosingHandshakeParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<WebSocketClient> {
        Stub(Core core, WebSocketClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebSocketClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        WebSocketClientOnDataFrameParams data = WebSocketClientOnDataFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onDataFrame(data.fin, data.type, data.data);
                        return true;
                    case 1:
                        getImpl().addSendFlowControlQuota(WebSocketClientAddSendFlowControlQuotaParams.deserialize(messageWithHeader.getPayload()).quota);
                        return true;
                    case 2:
                        WebSocketClientOnDropChannelParams data2 = WebSocketClientOnDropChannelParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onDropChannel(data2.wasClean, data2.code, data2.reason);
                        return true;
                    case 3:
                        WebSocketClientOnClosingHandshakeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onClosingHandshake();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), WebSocketClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal$WebSocketClientOnDataFrameParams.class */
    static final class WebSocketClientOnDataFrameParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean fin;
        public int type;
        public ReadOnlyBuffer data;

        private WebSocketClientOnDataFrameParams(int version) {
            super(24, version);
        }

        public WebSocketClientOnDataFrameParams() {
            this(0);
        }

        public static WebSocketClientOnDataFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketClientOnDataFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketClientOnDataFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketClientOnDataFrameParams result = new WebSocketClientOnDataFrameParams(elementsOrVersion);
                result.fin = decoder0.readBoolean(8, 0);
                result.type = decoder0.readInt(12);
                WebSocketMessageType.validate(result.type);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.data = ReadOnlyBuffer.decode(decoder1);
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
            encoder0.encode((Struct) this.data, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal$WebSocketClientAddSendFlowControlQuotaParams.class */
    static final class WebSocketClientAddSendFlowControlQuotaParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public long quota;

        private WebSocketClientAddSendFlowControlQuotaParams(int version) {
            super(16, version);
        }

        public WebSocketClientAddSendFlowControlQuotaParams() {
            this(0);
        }

        public static WebSocketClientAddSendFlowControlQuotaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketClientAddSendFlowControlQuotaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketClientAddSendFlowControlQuotaParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketClientAddSendFlowControlQuotaParams result = new WebSocketClientAddSendFlowControlQuotaParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal$WebSocketClientOnDropChannelParams.class */
    static final class WebSocketClientOnDropChannelParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean wasClean;
        public short code;
        public String reason;

        private WebSocketClientOnDropChannelParams(int version) {
            super(24, version);
        }

        public WebSocketClientOnDropChannelParams() {
            this(0);
        }

        public static WebSocketClientOnDropChannelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketClientOnDropChannelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketClientOnDropChannelParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketClientOnDropChannelParams result = new WebSocketClientOnDropChannelParams(elementsOrVersion);
                result.wasClean = decoder0.readBoolean(8, 0);
                result.code = decoder0.readShort(10);
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
            encoder0.encode(this.wasClean, 8, 0);
            encoder0.encode(this.code, 10);
            encoder0.encode(this.reason, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/WebSocketClient_Internal$WebSocketClientOnClosingHandshakeParams.class */
    static final class WebSocketClientOnClosingHandshakeParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WebSocketClientOnClosingHandshakeParams(int version) {
            super(8, version);
        }

        public WebSocketClientOnClosingHandshakeParams() {
            this(0);
        }

        public static WebSocketClientOnClosingHandshakeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketClientOnClosingHandshakeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketClientOnClosingHandshakeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                WebSocketClientOnClosingHandshakeParams result = new WebSocketClientOnClosingHandshakeParams(elementsOrVersion);
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
}
