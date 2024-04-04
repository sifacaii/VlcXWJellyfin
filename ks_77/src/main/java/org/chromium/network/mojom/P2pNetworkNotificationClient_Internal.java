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
import org.chromium.network.mojom.P2pNetworkNotificationClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pNetworkNotificationClient_Internal.class */
class P2pNetworkNotificationClient_Internal {
    public static final Interface.Manager<P2pNetworkNotificationClient, P2pNetworkNotificationClient.Proxy> MANAGER = new Interface.Manager<P2pNetworkNotificationClient, P2pNetworkNotificationClient.Proxy>() { // from class: org.chromium.network.mojom.P2pNetworkNotificationClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.P2PNetworkNotificationClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public P2pNetworkNotificationClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, P2pNetworkNotificationClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public P2pNetworkNotificationClient[] buildArray(int size) {
            return new P2pNetworkNotificationClient[size];
        }
    };
    private static final int NETWORK_LIST_CHANGED_ORDINAL = 0;

    P2pNetworkNotificationClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pNetworkNotificationClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements P2pNetworkNotificationClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.P2pNetworkNotificationClient
        public void networkListChanged(NetworkInterface[] networks, IpAddress defaultIpv4LocalAddress, IpAddress defaultIpv6LocalAddress) {
            P2pNetworkNotificationClientNetworkListChangedParams _message = new P2pNetworkNotificationClientNetworkListChangedParams();
            _message.networks = networks;
            _message.defaultIpv4LocalAddress = defaultIpv4LocalAddress;
            _message.defaultIpv6LocalAddress = defaultIpv6LocalAddress;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pNetworkNotificationClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<P2pNetworkNotificationClient> {
        Stub(Core core, P2pNetworkNotificationClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(P2pNetworkNotificationClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        P2pNetworkNotificationClientNetworkListChangedParams data = P2pNetworkNotificationClientNetworkListChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().networkListChanged(data.networks, data.defaultIpv4LocalAddress, data.defaultIpv6LocalAddress);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), P2pNetworkNotificationClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pNetworkNotificationClient_Internal$P2pNetworkNotificationClientNetworkListChangedParams.class */
    static final class P2pNetworkNotificationClientNetworkListChangedParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkInterface[] networks;
        public IpAddress defaultIpv4LocalAddress;
        public IpAddress defaultIpv6LocalAddress;

        private P2pNetworkNotificationClientNetworkListChangedParams(int version) {
            super(32, version);
        }

        public P2pNetworkNotificationClientNetworkListChangedParams() {
            this(0);
        }

        public static P2pNetworkNotificationClientNetworkListChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static P2pNetworkNotificationClientNetworkListChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static P2pNetworkNotificationClientNetworkListChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                P2pNetworkNotificationClientNetworkListChangedParams result = new P2pNetworkNotificationClientNetworkListChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.networks = new NetworkInterface[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.networks[i1] = NetworkInterface.decode(decoder2);
                }
                result.defaultIpv4LocalAddress = IpAddress.decode(decoder0.readPointer(16, false));
                result.defaultIpv6LocalAddress = IpAddress.decode(decoder0.readPointer(24, false));
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
            if (this.networks == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.networks.length, 8, -1);
                for (int i0 = 0; i0 < this.networks.length; i0++) {
                    encoder1.encode((Struct) this.networks[i0], 8 + (8 * i0), false);
                }
            }
            encoder0.encode((Struct) this.defaultIpv4LocalAddress, 16, false);
            encoder0.encode((Struct) this.defaultIpv6LocalAddress, 24, false);
        }
    }
}
