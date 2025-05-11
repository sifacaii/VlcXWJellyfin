package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.MediaService;
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
import org.chromium.service_manager.mojom.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaService_Internal.class */
class MediaService_Internal {
    public static final Interface.Manager<MediaService, MediaService.Proxy> MANAGER = new Interface.Manager<MediaService, MediaService.Proxy>() { // from class: org.chromium.media.mojom.MediaService_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.MediaService";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaService.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaService impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaService[] buildArray(int size) {
            return new MediaService[size];
        }
    };
    private static final int CREATE_INTERFACE_FACTORY_ORDINAL = 0;

    MediaService_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaService_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.MediaService
        public void createInterfaceFactory(InterfaceRequest<InterfaceFactory> factory, InterfaceProvider hostInterfaces) {
            MediaServiceCreateInterfaceFactoryParams _message = new MediaServiceCreateInterfaceFactoryParams();
            _message.factory = factory;
            _message.hostInterfaces = hostInterfaces;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaService_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaService> {
        Stub(Core core, MediaService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        MediaServiceCreateInterfaceFactoryParams data = MediaServiceCreateInterfaceFactoryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createInterfaceFactory(data.factory, data.hostInterfaces);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaService_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaService_Internal$MediaServiceCreateInterfaceFactoryParams.class */
    static final class MediaServiceCreateInterfaceFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<InterfaceFactory> factory;
        public InterfaceProvider hostInterfaces;

        private MediaServiceCreateInterfaceFactoryParams(int version) {
            super(24, version);
        }

        public MediaServiceCreateInterfaceFactoryParams() {
            this(0);
        }

        public static MediaServiceCreateInterfaceFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaServiceCreateInterfaceFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaServiceCreateInterfaceFactoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaServiceCreateInterfaceFactoryParams result = new MediaServiceCreateInterfaceFactoryParams(elementsOrVersion);
                result.factory = decoder0.readInterfaceRequest(8, false);
                result.hostInterfaces = (InterfaceProvider) decoder0.readServiceInterface(12, true, InterfaceProvider.MANAGER);
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
            encoder0.encode( this.hostInterfaces, 12, true, InterfaceProvider.MANAGER);
        }
    }
}
