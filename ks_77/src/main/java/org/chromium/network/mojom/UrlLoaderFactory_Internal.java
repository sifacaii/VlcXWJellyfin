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
import org.chromium.network.mojom.UrlLoaderFactory;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory_Internal.class */
class UrlLoaderFactory_Internal {
    public static final Interface.Manager<UrlLoaderFactory, UrlLoaderFactory.Proxy> MANAGER = new Interface.Manager<UrlLoaderFactory, UrlLoaderFactory.Proxy>() { // from class: org.chromium.network.mojom.UrlLoaderFactory_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.URLLoaderFactory";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public UrlLoaderFactory.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, UrlLoaderFactory impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public UrlLoaderFactory[] buildArray(int size) {
            return new UrlLoaderFactory[size];
        }
    };
    private static final int CREATE_LOADER_AND_START_ORDINAL = 0;
    private static final int CLONE_ORDINAL = 1;

    UrlLoaderFactory_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements UrlLoaderFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.UrlLoaderFactory
        public void createLoaderAndStart(InterfaceRequest<UrlLoader> loader, int routingId, int requestId, int options, UrlRequest request, UrlLoaderClient client, MutableNetworkTrafficAnnotationTag trafficAnnotation) {
            UrlLoaderFactoryCreateLoaderAndStartParams _message = new UrlLoaderFactoryCreateLoaderAndStartParams();
            _message.loader = loader;
            _message.routingId = routingId;
            _message.requestId = requestId;
            _message.options = options;
            _message.request = request;
            _message.client = client;
            _message.trafficAnnotation = trafficAnnotation;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.UrlLoaderFactory
        public void clone(InterfaceRequest<UrlLoaderFactory> factory) {
            UrlLoaderFactoryCloneParams _message = new UrlLoaderFactoryCloneParams();
            _message.factory = factory;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<UrlLoaderFactory> {
        Stub(Core core, UrlLoaderFactory impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UrlLoaderFactory_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        UrlLoaderFactoryCreateLoaderAndStartParams data = UrlLoaderFactoryCreateLoaderAndStartParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createLoaderAndStart(data.loader, data.routingId, data.requestId, data.options, data.request, data.client, data.trafficAnnotation);
                        return true;
                    case 1:
                        getImpl().clone(UrlLoaderFactoryCloneParams.deserialize(messageWithHeader.getPayload()).factory);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), UrlLoaderFactory_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory_Internal$UrlLoaderFactoryCreateLoaderAndStartParams.class */
    static final class UrlLoaderFactoryCreateLoaderAndStartParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<UrlLoader> loader;
        public int routingId;
        public int requestId;
        public int options;
        public UrlRequest request;
        public UrlLoaderClient client;
        public MutableNetworkTrafficAnnotationTag trafficAnnotation;

        private UrlLoaderFactoryCreateLoaderAndStartParams(int version) {
            super(48, version);
        }

        public UrlLoaderFactoryCreateLoaderAndStartParams() {
            this(0);
        }

        public static UrlLoaderFactoryCreateLoaderAndStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderFactoryCreateLoaderAndStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderFactoryCreateLoaderAndStartParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderFactoryCreateLoaderAndStartParams result = new UrlLoaderFactoryCreateLoaderAndStartParams(elementsOrVersion);
                result.loader = decoder0.readInterfaceRequest(8, false);
                result.routingId = decoder0.readInt(12);
                result.requestId = decoder0.readInt(16);
                result.options = decoder0.readInt(20);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.request = UrlRequest.decode(decoder1);
                result.client = (UrlLoaderClient) decoder0.readServiceInterface(32, false, UrlLoaderClient.MANAGER);
                Decoder decoder12 = decoder0.readPointer(40, false);
                result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
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
            encoder0.encode((InterfaceRequest) this.loader, 8, false);
            encoder0.encode(this.routingId, 12);
            encoder0.encode(this.requestId, 16);
            encoder0.encode(this.options, 20);
            encoder0.encode((Struct) this.request, 24, false);
            encoder0.encode(this.client,32,false, UrlLoaderClient.MANAGER);
            encoder0.encode((Struct) this.trafficAnnotation, 40, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderFactory_Internal$UrlLoaderFactoryCloneParams.class */
    static final class UrlLoaderFactoryCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<UrlLoaderFactory> factory;

        private UrlLoaderFactoryCloneParams(int version) {
            super(16, version);
        }

        public UrlLoaderFactoryCloneParams() {
            this(0);
        }

        public static UrlLoaderFactoryCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderFactoryCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderFactoryCloneParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderFactoryCloneParams result = new UrlLoaderFactoryCloneParams(elementsOrVersion);
                result.factory = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.factory, 8, false);
        }
    }
}
