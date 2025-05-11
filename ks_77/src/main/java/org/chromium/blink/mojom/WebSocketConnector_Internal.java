package org.chromium.blink.mojom;

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
import org.chromium.network.mojom.WebSocketClient;
import org.chromium.network.mojom.WebSocketHandshakeClient;
import org.chromium.url.mojom.Url;

class WebSocketConnector_Internal {
    public static final Interface.Manager<WebSocketConnector, WebSocketConnector.Proxy> MANAGER = new Interface.Manager<WebSocketConnector, WebSocketConnector.Proxy>() {
        public String getName() {
            return "blink.mojom.WebSocketConnector";
        }

        public int getVersion() {
            return 0;
        }

        public WebSocketConnector_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WebSocketConnector_Internal.Proxy(core, messageReceiver);
        }

        public WebSocketConnector_Internal.Stub buildStub(Core core, WebSocketConnector impl) {
            return new WebSocketConnector_Internal.Stub(core, impl);
        }

        public WebSocketConnector[] buildArray(int size) {
            return new WebSocketConnector[size];
        }
    };

    private static final int CONNECT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements WebSocketConnector.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void connect(Url url, String[] requestedProtocols, Url siteForCookies, String userAgent, WebSocketHandshakeClient handshakeClient, WebSocketClient connectionClient) {
            WebSocketConnector_Internal.WebSocketConnectorConnectParams _message = new WebSocketConnector_Internal.WebSocketConnectorConnectParams();
            _message.url = url;
            _message.requestedProtocols = requestedProtocols;
            _message.siteForCookies = siteForCookies;
            _message.userAgent = userAgent;
            _message.handshakeClient = handshakeClient;
            _message.connectionClient = connectionClient;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<WebSocketConnector> {
        Stub(Core core, WebSocketConnector impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WebSocketConnector_Internal.WebSocketConnectorConnectParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebSocketConnector_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = WebSocketConnector_Internal.WebSocketConnectorConnectParams.deserialize(messageWithHeader.getPayload());
                        ((WebSocketConnector)getImpl()).connect(data.url, data.requestedProtocols, data.siteForCookies, data.userAgent, data.handshakeClient, data.connectionClient);
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), WebSocketConnector_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WebSocketConnectorConnectParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public String[] requestedProtocols;

        public Url siteForCookies;

        public String userAgent;

        public WebSocketHandshakeClient handshakeClient;

        public WebSocketClient connectionClient;

        private WebSocketConnectorConnectParams(int version) {
            super(56, version);
        }

        public WebSocketConnectorConnectParams() {
            this(0);
        }

        public static WebSocketConnectorConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebSocketConnectorConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebSocketConnectorConnectParams decode(Decoder decoder0) {
            WebSocketConnectorConnectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebSocketConnectorConnectParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.requestedProtocols = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.requestedProtocols[i1] = decoder1.readString(8 + 8 * i1, false);
                decoder1 = decoder0.readPointer(24, false);
                result.siteForCookies = Url.decode(decoder1);
                result.userAgent = decoder0.readString(32, true);
                result.handshakeClient = (WebSocketHandshakeClient)decoder0.readServiceInterface(40, false, WebSocketHandshakeClient.MANAGER);
                result.connectionClient = (WebSocketClient)decoder0.readServiceInterface(48, false, WebSocketClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            if (this.requestedProtocols == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.requestedProtocols.length, 16, -1);
                for (int i0 = 0; i0 < this.requestedProtocols.length; i0++)
                    encoder1.encode(this.requestedProtocols[i0], 8 + 8 * i0, false);
            }
            encoder0.encode((Struct)this.siteForCookies, 24, false);
            encoder0.encode(this.userAgent, 32, true);
            encoder0.encode(this.handshakeClient, 40, false, WebSocketHandshakeClient.MANAGER);
            encoder0.encode(this.connectionClient, 48, false, WebSocketClient.MANAGER);
        }
    }
}
