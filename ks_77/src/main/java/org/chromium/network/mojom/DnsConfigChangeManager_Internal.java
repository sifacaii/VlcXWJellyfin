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
import org.chromium.network.mojom.DnsConfigChangeManager;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManager_Internal.class */
class DnsConfigChangeManager_Internal {
    public static final Interface.Manager<DnsConfigChangeManager, DnsConfigChangeManager.Proxy> MANAGER = new Interface.Manager<DnsConfigChangeManager, DnsConfigChangeManager.Proxy>() { // from class: org.chromium.network.mojom.DnsConfigChangeManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.DnsConfigChangeManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public DnsConfigChangeManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, DnsConfigChangeManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public DnsConfigChangeManager[] buildArray(int size) {
            return new DnsConfigChangeManager[size];
        }
    };
    private static final int REQUEST_NOTIFICATIONS_ORDINAL = 0;

    DnsConfigChangeManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements DnsConfigChangeManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.DnsConfigChangeManager
        public void requestNotifications(DnsConfigChangeManagerClient clientPtr) {
            DnsConfigChangeManagerRequestNotificationsParams _message = new DnsConfigChangeManagerRequestNotificationsParams();
            _message.clientPtr = clientPtr;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<DnsConfigChangeManager> {
        Stub(Core core, DnsConfigChangeManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DnsConfigChangeManager_Internal.MANAGER, messageWithHeader);
                    case 0:
                        DnsConfigChangeManagerRequestNotificationsParams data = DnsConfigChangeManagerRequestNotificationsParams.deserialize(messageWithHeader.getPayload());
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), DnsConfigChangeManager_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManager_Internal$DnsConfigChangeManagerRequestNotificationsParams.class */
    static final class DnsConfigChangeManagerRequestNotificationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DnsConfigChangeManagerClient clientPtr;

        private DnsConfigChangeManagerRequestNotificationsParams(int version) {
            super(16, version);
        }

        public DnsConfigChangeManagerRequestNotificationsParams() {
            this(0);
        }

        public static DnsConfigChangeManagerRequestNotificationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DnsConfigChangeManagerRequestNotificationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DnsConfigChangeManagerRequestNotificationsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DnsConfigChangeManagerRequestNotificationsParams result = new DnsConfigChangeManagerRequestNotificationsParams(elementsOrVersion);
                result.clientPtr = (DnsConfigChangeManagerClient) decoder0.readServiceInterface(8, false, DnsConfigChangeManagerClient.MANAGER);
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
            encoder0.encode(this.clientPtr,8,false, DnsConfigChangeManagerClient.MANAGER);
        }
    }
}
