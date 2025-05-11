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
import org.chromium.network.mojom.P2pSocket;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket_Internal.class */
class P2pSocket_Internal {
    public static final Interface.Manager<P2pSocket, P2pSocket.Proxy> MANAGER = new Interface.Manager<P2pSocket, P2pSocket.Proxy>() { // from class: org.chromium.network.mojom.P2pSocket_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.P2PSocket";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public P2pSocket.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, P2pSocket impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public P2pSocket[] buildArray(int size) {
            return new P2pSocket[size];
        }
    };
    private static final int SEND_ORDINAL = 0;
    private static final int SET_OPTION_ORDINAL = 1;

    P2pSocket_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements P2pSocket.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.P2pSocket
        public void send(byte[] data, P2pPacketInfo packetInfo, MutableNetworkTrafficAnnotationTag trafficAnnotation) {
            P2pSocketSendParams _message = new P2pSocketSendParams();
            _message.data = data;
            _message.packetInfo = packetInfo;
            _message.trafficAnnotation = trafficAnnotation;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.P2pSocket
        public void setOption(int option, int value) {
            P2pSocketSetOptionParams _message = new P2pSocketSetOptionParams();
            _message.option = option;
            _message.value = value;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<P2pSocket> {
        Stub(Core core, P2pSocket impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(P2pSocket_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        P2pSocketSendParams data = P2pSocketSendParams.deserialize(messageWithHeader.getPayload());
                        getImpl().send(data.data, data.packetInfo, data.trafficAnnotation);
                        return true;
                    case 1:
                        P2pSocketSetOptionParams data2 = P2pSocketSetOptionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setOption(data2.option, data2.value);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), P2pSocket_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket_Internal$P2pSocketSendParams.class */
    static final class P2pSocketSendParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public byte[] data;
        public P2pPacketInfo packetInfo;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;

        private P2pSocketSendParams(int version) {
            super(32, version);
        }

        public P2pSocketSendParams() {
            this(0);
        }

        public static P2pSocketSendParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketSendParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketSendParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketSendParams result = new P2pSocketSendParams(elementsOrVersion);
                result.data = decoder0.readBytes(8, 0, -1);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.packetInfo = P2pPacketInfo.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
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
            encoder0.encode(this.data, 8, 0, -1);
            encoder0.encode((Struct) this.packetInfo, 16, false);
            encoder0.encode((Struct) this.trafficAnnotation, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket_Internal$P2pSocketSetOptionParams.class */
    static final class P2pSocketSetOptionParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int option;
        public int value;

        private P2pSocketSetOptionParams(int version) {
            super(16, version);
        }

        public P2pSocketSetOptionParams() {
            this(0);
        }

        public static P2pSocketSetOptionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pSocketSetOptionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pSocketSetOptionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pSocketSetOptionParams result = new P2pSocketSetOptionParams(elementsOrVersion);
                result.option = decoder0.readInt(8);
                P2pSocketOption.validate(result.option);
                result.value = decoder0.readInt(12);
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
            encoder0.encode(this.option, 8);
            encoder0.encode(this.value, 12);
        }
    }
}
