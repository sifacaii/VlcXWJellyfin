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
import org.chromium.network.mojom.P2pTrustedSocketManager;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager_Internal.class */
class P2pTrustedSocketManager_Internal {
    public static final Interface.Manager<P2pTrustedSocketManager, P2pTrustedSocketManager.Proxy> MANAGER = new Interface.Manager<P2pTrustedSocketManager, P2pTrustedSocketManager.Proxy>() { // from class: org.chromium.network.mojom.P2pTrustedSocketManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.P2PTrustedSocketManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public P2pTrustedSocketManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, P2pTrustedSocketManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public P2pTrustedSocketManager[] buildArray(int size) {
            return new P2pTrustedSocketManager[size];
        }
    };
    private static final int START_RTP_DUMP_ORDINAL = 0;
    private static final int STOP_RTP_DUMP_ORDINAL = 1;

    P2pTrustedSocketManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements P2pTrustedSocketManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.P2pTrustedSocketManager
        public void startRtpDump(boolean incoming, boolean outgoing) {
            P2pTrustedSocketManagerStartRtpDumpParams _message = new P2pTrustedSocketManagerStartRtpDumpParams();
            _message.incoming = incoming;
            _message.outgoing = outgoing;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.P2pTrustedSocketManager
        public void stopRtpDump(boolean incoming, boolean outgoing) {
            P2pTrustedSocketManagerStopRtpDumpParams _message = new P2pTrustedSocketManagerStopRtpDumpParams();
            _message.incoming = incoming;
            _message.outgoing = outgoing;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<P2pTrustedSocketManager> {
        Stub(Core core, P2pTrustedSocketManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(P2pTrustedSocketManager_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        P2pTrustedSocketManagerStartRtpDumpParams data = P2pTrustedSocketManagerStartRtpDumpParams.deserialize(messageWithHeader.getPayload());
                        getImpl().startRtpDump(data.incoming, data.outgoing);
                        return true;
                    case 1:
                        P2pTrustedSocketManagerStopRtpDumpParams data2 = P2pTrustedSocketManagerStopRtpDumpParams.deserialize(messageWithHeader.getPayload());
                        getImpl().stopRtpDump(data2.incoming, data2.outgoing);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), P2pTrustedSocketManager_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager_Internal$P2pTrustedSocketManagerStartRtpDumpParams.class */
    static final class P2pTrustedSocketManagerStartRtpDumpParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean incoming;
        public boolean outgoing;

        private P2pTrustedSocketManagerStartRtpDumpParams(int version) {
            super(16, version);
        }

        public P2pTrustedSocketManagerStartRtpDumpParams() {
            this(0);
        }

        public static P2pTrustedSocketManagerStartRtpDumpParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pTrustedSocketManagerStartRtpDumpParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pTrustedSocketManagerStartRtpDumpParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pTrustedSocketManagerStartRtpDumpParams result = new P2pTrustedSocketManagerStartRtpDumpParams(elementsOrVersion);
                result.incoming = decoder0.readBoolean(8, 0);
                result.outgoing = decoder0.readBoolean(8, 1);
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
            encoder0.encode(this.incoming, 8, 0);
            encoder0.encode(this.outgoing, 8, 1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager_Internal$P2pTrustedSocketManagerStopRtpDumpParams.class */
    static final class P2pTrustedSocketManagerStopRtpDumpParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean incoming;
        public boolean outgoing;

        private P2pTrustedSocketManagerStopRtpDumpParams(int version) {
            super(16, version);
        }

        public P2pTrustedSocketManagerStopRtpDumpParams() {
            this(0);
        }

        public static P2pTrustedSocketManagerStopRtpDumpParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pTrustedSocketManagerStopRtpDumpParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pTrustedSocketManagerStopRtpDumpParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pTrustedSocketManagerStopRtpDumpParams result = new P2pTrustedSocketManagerStopRtpDumpParams(elementsOrVersion);
                result.incoming = decoder0.readBoolean(8, 0);
                result.outgoing = decoder0.readBoolean(8, 1);
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
            encoder0.encode(this.incoming, 8, 0);
            encoder0.encode(this.outgoing, 8, 1);
        }
    }
}
