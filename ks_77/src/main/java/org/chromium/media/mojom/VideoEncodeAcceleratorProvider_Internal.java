package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoEncodeAcceleratorProvider;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorProvider_Internal.class */
class VideoEncodeAcceleratorProvider_Internal {
    public static final Interface.Manager<VideoEncodeAcceleratorProvider, VideoEncodeAcceleratorProvider.Proxy> MANAGER = new Interface.Manager<VideoEncodeAcceleratorProvider, VideoEncodeAcceleratorProvider.Proxy>() { // from class: org.chromium.media.mojom.VideoEncodeAcceleratorProvider_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoEncodeAcceleratorProvider";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoEncodeAcceleratorProvider.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoEncodeAcceleratorProvider impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoEncodeAcceleratorProvider[] buildArray(int size) {
            return new VideoEncodeAcceleratorProvider[size];
        }
    };
    private static final int CREATE_VIDEO_ENCODE_ACCELERATOR_ORDINAL = 0;

    VideoEncodeAcceleratorProvider_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorProvider_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoEncodeAcceleratorProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoEncodeAcceleratorProvider
        public void createVideoEncodeAccelerator(InterfaceRequest<VideoEncodeAccelerator> request) {
            VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams _message = new VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams();
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorProvider_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoEncodeAcceleratorProvider> {
        Stub(Core core, VideoEncodeAcceleratorProvider impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoEncodeAcceleratorProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams data = VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createVideoEncodeAccelerator(data.request);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoEncodeAcceleratorProvider_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorProvider_Internal$VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams.class */
    static final class VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<VideoEncodeAccelerator> request;

        private VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams(int version) {
            super(16, version);
        }

        public VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams result = new VideoEncodeAcceleratorProviderCreateVideoEncodeAcceleratorParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.request, 8, false);
        }
    }
}
