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
import org.chromium.network.mojom.UdpSocketReceiver;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketReceiver_Internal.class */
class UdpSocketReceiver_Internal {
    public static final Interface.Manager<UdpSocketReceiver, UdpSocketReceiver.Proxy> MANAGER = new Interface.Manager<UdpSocketReceiver, UdpSocketReceiver.Proxy>() { // from class: org.chromium.network.mojom.UdpSocketReceiver_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.UDPSocketReceiver";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public UdpSocketReceiver.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, UdpSocketReceiver impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public UdpSocketReceiver[] buildArray(int size) {
            return new UdpSocketReceiver[size];
        }
    };
    private static final int ON_RECEIVED_ORDINAL = 0;

    UdpSocketReceiver_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketReceiver_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements UdpSocketReceiver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.UdpSocketReceiver
        public void onReceived(int result, IpEndPoint srcAddr, ReadOnlyBuffer data) {
            UdpSocketReceiverOnReceivedParams _message = new UdpSocketReceiverOnReceivedParams();
            _message.result = result;
            _message.srcAddr = srcAddr;
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketReceiver_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<UdpSocketReceiver> {
        Stub(Core core, UdpSocketReceiver impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UdpSocketReceiver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        UdpSocketReceiverOnReceivedParams data = UdpSocketReceiverOnReceivedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onReceived(data.result, data.srcAddr, data.data);
                        return true;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), UdpSocketReceiver_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketReceiver_Internal$UdpSocketReceiverOnReceivedParams.class */
    static final class UdpSocketReceiverOnReceivedParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public IpEndPoint srcAddr;
        public ReadOnlyBuffer data;

        private UdpSocketReceiverOnReceivedParams(int version) {
            super(32, version);
        }

        public UdpSocketReceiverOnReceivedParams() {
            this(0);
        }

        public static UdpSocketReceiverOnReceivedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UdpSocketReceiverOnReceivedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UdpSocketReceiverOnReceivedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UdpSocketReceiverOnReceivedParams result = new UdpSocketReceiverOnReceivedParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.srcAddr = IpEndPoint.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, true);
                result.data = ReadOnlyBuffer.decode(decoder12);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.srcAddr, 16, true);
            encoder0.encode((Struct) this.data, 24, true);
        }
    }
}
