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
import org.chromium.network.mojom.NetworkQualityEstimatorManager;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManager_Internal.class */
class NetworkQualityEstimatorManager_Internal {
    public static final Interface.Manager<NetworkQualityEstimatorManager, NetworkQualityEstimatorManager.Proxy> MANAGER = new Interface.Manager<NetworkQualityEstimatorManager, NetworkQualityEstimatorManager.Proxy>() { // from class: org.chromium.network.mojom.NetworkQualityEstimatorManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkQualityEstimatorManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkQualityEstimatorManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkQualityEstimatorManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkQualityEstimatorManager[] buildArray(int size) {
            return new NetworkQualityEstimatorManager[size];
        }
    };
    private static final int REQUEST_NOTIFICATIONS_ORDINAL = 0;

    NetworkQualityEstimatorManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkQualityEstimatorManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkQualityEstimatorManager
        public void requestNotifications(NetworkQualityEstimatorManagerClient clientPtr) {
            NetworkQualityEstimatorManagerRequestNotificationsParams _message = new NetworkQualityEstimatorManagerRequestNotificationsParams();
            _message.clientPtr = clientPtr;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkQualityEstimatorManager> {
        Stub(Core core, NetworkQualityEstimatorManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkQualityEstimatorManager_Internal.MANAGER, messageWithHeader);
                    case 0:
                        NetworkQualityEstimatorManagerRequestNotificationsParams data = NetworkQualityEstimatorManagerRequestNotificationsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().requestNotifications(data.clientPtr);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkQualityEstimatorManager_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManager_Internal$NetworkQualityEstimatorManagerRequestNotificationsParams.class */
    static final class NetworkQualityEstimatorManagerRequestNotificationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkQualityEstimatorManagerClient clientPtr;

        private NetworkQualityEstimatorManagerRequestNotificationsParams(int version) {
            super(16, version);
        }

        public NetworkQualityEstimatorManagerRequestNotificationsParams() {
            this(0);
        }

        public static NetworkQualityEstimatorManagerRequestNotificationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkQualityEstimatorManagerRequestNotificationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkQualityEstimatorManagerRequestNotificationsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkQualityEstimatorManagerRequestNotificationsParams result = new NetworkQualityEstimatorManagerRequestNotificationsParams(elementsOrVersion);
                result.clientPtr = (NetworkQualityEstimatorManagerClient) decoder0.readServiceInterface(8, false, NetworkQualityEstimatorManagerClient.MANAGER);
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
            encoder0.encode(this.clientPtr,8,false, NetworkQualityEstimatorManagerClient.MANAGER);
        }
    }
}
