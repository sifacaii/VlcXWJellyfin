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
import org.chromium.network.mojom.P2pTrustedSocketManagerClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient_Internal.class */
class P2pTrustedSocketManagerClient_Internal {
    public static final Interface.Manager<P2pTrustedSocketManagerClient, P2pTrustedSocketManagerClient.Proxy> MANAGER = new Interface.Manager<P2pTrustedSocketManagerClient, P2pTrustedSocketManagerClient.Proxy>() { // from class: org.chromium.network.mojom.P2pTrustedSocketManagerClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.P2PTrustedSocketManagerClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public P2pTrustedSocketManagerClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, P2pTrustedSocketManagerClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public P2pTrustedSocketManagerClient[] buildArray(int size) {
            return new P2pTrustedSocketManagerClient[size];
        }
    };
    private static final int INVALID_SOCKET_PORT_RANGE_REQUESTED_ORDINAL = 0;
    private static final int DUMP_PACKET_ORDINAL = 1;

    P2pTrustedSocketManagerClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements P2pTrustedSocketManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.P2pTrustedSocketManagerClient
        public void invalidSocketPortRangeRequested() {
            P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams _message = new P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.P2pTrustedSocketManagerClient
        public void dumpPacket(byte[] packetHeader, long packetLength, boolean incoming) {
            P2pTrustedSocketManagerClientDumpPacketParams _message = new P2pTrustedSocketManagerClientDumpPacketParams();
            _message.packetHeader = packetHeader;
            _message.packetLength = packetLength;
            _message.incoming = incoming;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<P2pTrustedSocketManagerClient> {
        Stub(Core core, P2pTrustedSocketManagerClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(P2pTrustedSocketManagerClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().invalidSocketPortRangeRequested();
                        return true;
                    case 1:
                        P2pTrustedSocketManagerClientDumpPacketParams data = P2pTrustedSocketManagerClientDumpPacketParams.deserialize(messageWithHeader.getPayload());
                        getImpl().dumpPacket(data.packetHeader, data.packetLength, data.incoming);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), P2pTrustedSocketManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient_Internal$P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams.class */
    static final class P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams(int version) {
            super(8, version);
        }

        public P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams() {
            this(0);
        }

        public static P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams result = new P2pTrustedSocketManagerClientInvalidSocketPortRangeRequestedParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient_Internal$P2pTrustedSocketManagerClientDumpPacketParams.class */
    static final class P2pTrustedSocketManagerClientDumpPacketParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public byte[] packetHeader;
        public long packetLength;
        public boolean incoming;

        private P2pTrustedSocketManagerClientDumpPacketParams(int version) {
            super(32, version);
        }

        public P2pTrustedSocketManagerClientDumpPacketParams() {
            this(0);
        }

        public static P2pTrustedSocketManagerClientDumpPacketParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pTrustedSocketManagerClientDumpPacketParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pTrustedSocketManagerClientDumpPacketParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pTrustedSocketManagerClientDumpPacketParams result = new P2pTrustedSocketManagerClientDumpPacketParams(elementsOrVersion);
                result.packetHeader = decoder0.readBytes(8, 0, -1);
                result.packetLength = decoder0.readLong(16);
                result.incoming = decoder0.readBoolean(24, 0);
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
            encoder0.encode(this.packetHeader, 8, 0, -1);
            encoder0.encode(this.packetLength, 16);
            encoder0.encode(this.incoming, 24, 0);
        }
    }
}
