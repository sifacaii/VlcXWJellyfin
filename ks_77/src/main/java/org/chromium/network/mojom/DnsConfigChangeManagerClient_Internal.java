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
import org.chromium.network.mojom.DnsConfigChangeManagerClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManagerClient_Internal.class */
class DnsConfigChangeManagerClient_Internal {
    public static final Interface.Manager<DnsConfigChangeManagerClient, DnsConfigChangeManagerClient.Proxy> MANAGER = new Interface.Manager<DnsConfigChangeManagerClient, DnsConfigChangeManagerClient.Proxy>() { // from class: org.chromium.network.mojom.DnsConfigChangeManagerClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.DnsConfigChangeManagerClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public DnsConfigChangeManagerClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, DnsConfigChangeManagerClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public DnsConfigChangeManagerClient[] buildArray(int size) {
            return new DnsConfigChangeManagerClient[size];
        }
    };
    private static final int ON_SYSTEM_DNS_CONFIG_CHANGED_ORDINAL = 0;

    DnsConfigChangeManagerClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManagerClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements DnsConfigChangeManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.DnsConfigChangeManagerClient
        public void onSystemDnsConfigChanged() {
            DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams _message = new DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManagerClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<DnsConfigChangeManagerClient> {
        Stub(Core core, DnsConfigChangeManagerClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DnsConfigChangeManagerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onSystemDnsConfigChanged();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), DnsConfigChangeManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManagerClient_Internal$DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams.class */
    static final class DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams(int version) {
            super(8, version);
        }

        public DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams() {
            this(0);
        }

        public static DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams result = new DnsConfigChangeManagerClientOnSystemDnsConfigChangedParams(elementsOrVersion);
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
