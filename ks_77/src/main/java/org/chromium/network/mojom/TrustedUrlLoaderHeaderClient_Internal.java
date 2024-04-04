package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.TrustedUrlLoaderHeaderClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedUrlLoaderHeaderClient_Internal.class */
class TrustedUrlLoaderHeaderClient_Internal {
    public static final Interface.Manager<TrustedUrlLoaderHeaderClient, TrustedUrlLoaderHeaderClient.Proxy> MANAGER = new Interface.Manager<TrustedUrlLoaderHeaderClient, TrustedUrlLoaderHeaderClient.Proxy>() { // from class: org.chromium.network.mojom.TrustedUrlLoaderHeaderClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.TrustedURLLoaderHeaderClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public TrustedUrlLoaderHeaderClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, TrustedUrlLoaderHeaderClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public TrustedUrlLoaderHeaderClient[] buildArray(int size) {
            return new TrustedUrlLoaderHeaderClient[size];
        }
    };
    private static final int ON_LOADER_CREATED_ORDINAL = 0;

    TrustedUrlLoaderHeaderClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedUrlLoaderHeaderClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements TrustedUrlLoaderHeaderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.TrustedUrlLoaderHeaderClient
        public void onLoaderCreated(int requestId, InterfaceRequest<TrustedHeaderClient> headerClient) {
            TrustedUrlLoaderHeaderClientOnLoaderCreatedParams _message = new TrustedUrlLoaderHeaderClientOnLoaderCreatedParams();
            _message.requestId = requestId;
            _message.headerClient = headerClient;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedUrlLoaderHeaderClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<TrustedUrlLoaderHeaderClient> {
        Stub(Core core, TrustedUrlLoaderHeaderClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TrustedUrlLoaderHeaderClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        TrustedUrlLoaderHeaderClientOnLoaderCreatedParams data = TrustedUrlLoaderHeaderClientOnLoaderCreatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onLoaderCreated(data.requestId, data.headerClient);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), TrustedUrlLoaderHeaderClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedUrlLoaderHeaderClient_Internal$TrustedUrlLoaderHeaderClientOnLoaderCreatedParams.class */
    static final class TrustedUrlLoaderHeaderClientOnLoaderCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int requestId;
        public InterfaceRequest<TrustedHeaderClient> headerClient;

        private TrustedUrlLoaderHeaderClientOnLoaderCreatedParams(int version) {
            super(16, version);
        }

        public TrustedUrlLoaderHeaderClientOnLoaderCreatedParams() {
            this(0);
        }

        public static TrustedUrlLoaderHeaderClientOnLoaderCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TrustedUrlLoaderHeaderClientOnLoaderCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TrustedUrlLoaderHeaderClientOnLoaderCreatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TrustedUrlLoaderHeaderClientOnLoaderCreatedParams result = new TrustedUrlLoaderHeaderClientOnLoaderCreatedParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                result.headerClient = decoder0.readInterfaceRequest(12, false);
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
            encoder0.encode(this.requestId, 8);
            encoder0.encode((InterfaceRequest) this.headerClient, 12, false);
        }
    }
}
