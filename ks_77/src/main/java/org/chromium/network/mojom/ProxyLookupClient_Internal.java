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
import org.chromium.network.mojom.ProxyLookupClient;
import org.chromium.proxy_resolver.mojom.ProxyInfo;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyLookupClient_Internal.class */
class ProxyLookupClient_Internal {
    public static final Interface.Manager<ProxyLookupClient, ProxyLookupClient.Proxy> MANAGER = new Interface.Manager<ProxyLookupClient, ProxyLookupClient.Proxy>() { // from class: org.chromium.network.mojom.ProxyLookupClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.ProxyLookupClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProxyLookupClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProxyLookupClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProxyLookupClient[] buildArray(int size) {
            return new ProxyLookupClient[size];
        }
    };
    private static final int ON_PROXY_LOOKUP_COMPLETE_ORDINAL = 0;

    ProxyLookupClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyLookupClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProxyLookupClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.ProxyLookupClient
        public void onProxyLookupComplete(int netError, ProxyInfo proxyInfo) {
            ProxyLookupClientOnProxyLookupCompleteParams _message = new ProxyLookupClientOnProxyLookupCompleteParams();
            _message.netError = netError;
            _message.proxyInfo = proxyInfo;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyLookupClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProxyLookupClient> {
        Stub(Core core, ProxyLookupClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProxyLookupClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        ProxyLookupClientOnProxyLookupCompleteParams data = ProxyLookupClientOnProxyLookupCompleteParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onProxyLookupComplete(data.netError, data.proxyInfo);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProxyLookupClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyLookupClient_Internal$ProxyLookupClientOnProxyLookupCompleteParams.class */
    static final class ProxyLookupClientOnProxyLookupCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public ProxyInfo proxyInfo;

        private ProxyLookupClientOnProxyLookupCompleteParams(int version) {
            super(24, version);
        }

        public ProxyLookupClientOnProxyLookupCompleteParams() {
            this(0);
        }

        public static ProxyLookupClientOnProxyLookupCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyLookupClientOnProxyLookupCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyLookupClientOnProxyLookupCompleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyLookupClientOnProxyLookupCompleteParams result = new ProxyLookupClientOnProxyLookupCompleteParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.proxyInfo = ProxyInfo.decode(decoder1);
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
            encoder0.encode(this.netError, 8);
            encoder0.encode((Struct) this.proxyInfo, 16, true);
        }
    }
}
