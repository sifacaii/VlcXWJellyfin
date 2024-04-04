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
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.network.mojom.NetworkQualityEstimatorManagerClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManagerClient_Internal.class */
class NetworkQualityEstimatorManagerClient_Internal {
    public static final Interface.Manager<NetworkQualityEstimatorManagerClient, NetworkQualityEstimatorManagerClient.Proxy> MANAGER = new Interface.Manager<NetworkQualityEstimatorManagerClient, NetworkQualityEstimatorManagerClient.Proxy>() { // from class: org.chromium.network.mojom.NetworkQualityEstimatorManagerClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkQualityEstimatorManagerClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkQualityEstimatorManagerClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkQualityEstimatorManagerClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkQualityEstimatorManagerClient[] buildArray(int size) {
            return new NetworkQualityEstimatorManagerClient[size];
        }
    };
    private static final int ON_NETWORK_QUALITY_CHANGED_ORDINAL = 0;

    NetworkQualityEstimatorManagerClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManagerClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkQualityEstimatorManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkQualityEstimatorManagerClient
        public void onNetworkQualityChanged(int type, TimeDelta httpRtt, TimeDelta transportRtt, int downlinkBandwidthKbps) {
            NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams _message = new NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams();
            _message.type = type;
            _message.httpRtt = httpRtt;
            _message.transportRtt = transportRtt;
            _message.downlinkBandwidthKbps = downlinkBandwidthKbps;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManagerClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkQualityEstimatorManagerClient> {
        Stub(Core core, NetworkQualityEstimatorManagerClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkQualityEstimatorManagerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams data = NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onNetworkQualityChanged(data.type, data.httpRtt, data.transportRtt, data.downlinkBandwidthKbps);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkQualityEstimatorManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManagerClient_Internal$NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams.class */
    static final class NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public TimeDelta httpRtt;
        public TimeDelta transportRtt;
        public int downlinkBandwidthKbps;

        private NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams(int version) {
            super(32, version);
        }

        public NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams() {
            this(0);
        }

        public static NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams result = new NetworkQualityEstimatorManagerClientOnNetworkQualityChangedParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                EffectiveConnectionType.validate(result.type);
                result.downlinkBandwidthKbps = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.httpRtt = TimeDelta.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.transportRtt = TimeDelta.decode(decoder12);
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
            encoder0.encode(this.type, 8);
            encoder0.encode(this.downlinkBandwidthKbps, 12);
            encoder0.encode((Struct) this.httpRtt, 16, false);
            encoder0.encode((Struct) this.transportRtt, 24, false);
        }
    }
}
