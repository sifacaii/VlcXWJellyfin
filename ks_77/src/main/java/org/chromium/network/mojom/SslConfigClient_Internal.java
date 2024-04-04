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
import org.chromium.network.mojom.SslConfigClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfigClient_Internal.class */
class SslConfigClient_Internal {
    public static final Interface.Manager<SslConfigClient, SslConfigClient.Proxy> MANAGER = new Interface.Manager<SslConfigClient, SslConfigClient.Proxy>() { // from class: org.chromium.network.mojom.SslConfigClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.SSLConfigClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public SslConfigClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, SslConfigClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public SslConfigClient[] buildArray(int size) {
            return new SslConfigClient[size];
        }
    };
    private static final int ON_SSL_CONFIG_UPDATED_ORDINAL = 0;

    SslConfigClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfigClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements SslConfigClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.SslConfigClient
        public void onSslConfigUpdated(SslConfig sslConfig) {
            SslConfigClientOnSslConfigUpdatedParams _message = new SslConfigClientOnSslConfigUpdatedParams();
            _message.sslConfig = sslConfig;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfigClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<SslConfigClient> {
        Stub(Core core, SslConfigClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SslConfigClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        SslConfigClientOnSslConfigUpdatedParams data = SslConfigClientOnSslConfigUpdatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onSslConfigUpdated(data.sslConfig);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), SslConfigClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfigClient_Internal$SslConfigClientOnSslConfigUpdatedParams.class */
    static final class SslConfigClientOnSslConfigUpdatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SslConfig sslConfig;

        private SslConfigClientOnSslConfigUpdatedParams(int version) {
            super(16, version);
        }

        public SslConfigClientOnSslConfigUpdatedParams() {
            this(0);
        }

        public static SslConfigClientOnSslConfigUpdatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SslConfigClientOnSslConfigUpdatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SslConfigClientOnSslConfigUpdatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                SslConfigClientOnSslConfigUpdatedParams result = new SslConfigClientOnSslConfigUpdatedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.sslConfig = SslConfig.decode(decoder1);
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
            encoder0.encode((Struct) this.sslConfig, 8, false);
        }
    }
}
