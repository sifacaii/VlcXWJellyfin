package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.InterfaceFactory;
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
import org.chromium.mojo_base.mojom.Token;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal.class */
class InterfaceFactory_Internal {
    public static final Interface.Manager<InterfaceFactory, InterfaceFactory.Proxy> MANAGER = new Interface.Manager<InterfaceFactory, InterfaceFactory.Proxy>() { // from class: org.chromium.media.mojom.InterfaceFactory_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.InterfaceFactory";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public InterfaceFactory.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, InterfaceFactory impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public InterfaceFactory[] buildArray(int size) {
            return new InterfaceFactory[size];
        }
    };
    private static final int CREATE_AUDIO_DECODER_ORDINAL = 0;
    private static final int CREATE_VIDEO_DECODER_ORDINAL = 1;
    private static final int CREATE_DEFAULT_RENDERER_ORDINAL = 2;
    private static final int CREATE_MEDIA_PLAYER_RENDERER_ORDINAL = 3;
    private static final int CREATE_FLINGING_RENDERER_ORDINAL = 4;
    private static final int CREATE_CDM_ORDINAL = 5;
    private static final int CREATE_DECRYPTOR_ORDINAL = 6;
    private static final int CREATE_CDM_PROXY_ORDINAL = 7;

    InterfaceFactory_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements InterfaceFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createAudioDecoder(InterfaceRequest<AudioDecoder> audioDecoder) {
            InterfaceFactoryCreateAudioDecoderParams _message = new InterfaceFactoryCreateAudioDecoderParams();
            _message.audioDecoder = audioDecoder;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createVideoDecoder(InterfaceRequest<VideoDecoder> videoDecoder) {
            InterfaceFactoryCreateVideoDecoderParams _message = new InterfaceFactoryCreateVideoDecoderParams();
            _message.videoDecoder = videoDecoder;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createDefaultRenderer(String audioDeviceId, InterfaceRequest<Renderer> renderer) {
            InterfaceFactoryCreateDefaultRendererParams _message = new InterfaceFactoryCreateDefaultRendererParams();
            _message.audioDeviceId = audioDeviceId;
            _message.renderer = renderer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createMediaPlayerRenderer(MediaPlayerRendererClientExtension clientExtension, InterfaceRequest<Renderer> renderer, InterfaceRequest<MediaPlayerRendererExtension> rendererExtension) {
            InterfaceFactoryCreateMediaPlayerRendererParams _message = new InterfaceFactoryCreateMediaPlayerRendererParams();
            _message.clientExtension = clientExtension;
            _message.renderer = renderer;
            _message.rendererExtension = rendererExtension;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createFlingingRenderer(String presentationId, FlingingRendererClientExtension clientExtension, InterfaceRequest<Renderer> renderer) {
            InterfaceFactoryCreateFlingingRendererParams _message = new InterfaceFactoryCreateFlingingRendererParams();
            _message.presentationId = presentationId;
            _message.clientExtension = clientExtension;
            _message.renderer = renderer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createCdm(String keySystem, InterfaceRequest<ContentDecryptionModule> cdm) {
            InterfaceFactoryCreateCdmParams _message = new InterfaceFactoryCreateCdmParams();
            _message.keySystem = keySystem;
            _message.cdm = cdm;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createDecryptor(int cdmId, InterfaceRequest<Decryptor> decryptor) {
            InterfaceFactoryCreateDecryptorParams _message = new InterfaceFactoryCreateDecryptorParams();
            _message.cdmId = cdmId;
            _message.decryptor = decryptor;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.media.mojom.InterfaceFactory
        public void createCdmProxy(Token cdmGuid, InterfaceRequest<CdmProxy> cdmProxy) {
            InterfaceFactoryCreateCdmProxyParams _message = new InterfaceFactoryCreateCdmProxyParams();
            _message.cdmGuid = cdmGuid;
            _message.cdmProxy = cdmProxy;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<InterfaceFactory> {
        Stub(Core core, InterfaceFactory impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InterfaceFactory_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        getImpl().createAudioDecoder(InterfaceFactoryCreateAudioDecoderParams.deserialize(messageWithHeader.getPayload()).audioDecoder);
                        return true;
                    case 1:
                        getImpl().createVideoDecoder(InterfaceFactoryCreateVideoDecoderParams.deserialize(messageWithHeader.getPayload()).videoDecoder);
                        return true;
                    case 2:
                        InterfaceFactoryCreateDefaultRendererParams data = InterfaceFactoryCreateDefaultRendererParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createDefaultRenderer(data.audioDeviceId, data.renderer);
                        return true;
                    case 3:
                        InterfaceFactoryCreateMediaPlayerRendererParams data2 = InterfaceFactoryCreateMediaPlayerRendererParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createMediaPlayerRenderer(data2.clientExtension, data2.renderer, data2.rendererExtension);
                        return true;
                    case 4:
                        InterfaceFactoryCreateFlingingRendererParams data3 = InterfaceFactoryCreateFlingingRendererParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createFlingingRenderer(data3.presentationId, data3.clientExtension, data3.renderer);
                        return true;
                    case 5:
                        InterfaceFactoryCreateCdmParams data4 = InterfaceFactoryCreateCdmParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createCdm(data4.keySystem, data4.cdm);
                        return true;
                    case 6:
                        InterfaceFactoryCreateDecryptorParams data5 = InterfaceFactoryCreateDecryptorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createDecryptor(data5.cdmId, data5.decryptor);
                        return true;
                    case 7:
                        InterfaceFactoryCreateCdmProxyParams data6 = InterfaceFactoryCreateCdmProxyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createCdmProxy(data6.cdmGuid, data6.cdmProxy);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), InterfaceFactory_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateAudioDecoderParams.class */
    static final class InterfaceFactoryCreateAudioDecoderParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<AudioDecoder> audioDecoder;

        private InterfaceFactoryCreateAudioDecoderParams(int version) {
            super(16, version);
        }

        public InterfaceFactoryCreateAudioDecoderParams() {
            this(0);
        }

        public static InterfaceFactoryCreateAudioDecoderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateAudioDecoderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateAudioDecoderParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateAudioDecoderParams result = new InterfaceFactoryCreateAudioDecoderParams(elementsOrVersion);
                result.audioDecoder = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.audioDecoder, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateVideoDecoderParams.class */
    static final class InterfaceFactoryCreateVideoDecoderParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<VideoDecoder> videoDecoder;

        private InterfaceFactoryCreateVideoDecoderParams(int version) {
            super(16, version);
        }

        public InterfaceFactoryCreateVideoDecoderParams() {
            this(0);
        }

        public static InterfaceFactoryCreateVideoDecoderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateVideoDecoderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateVideoDecoderParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateVideoDecoderParams result = new InterfaceFactoryCreateVideoDecoderParams(elementsOrVersion);
                result.videoDecoder = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.videoDecoder, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateDefaultRendererParams.class */
    static final class InterfaceFactoryCreateDefaultRendererParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String audioDeviceId;
        public InterfaceRequest<Renderer> renderer;

        private InterfaceFactoryCreateDefaultRendererParams(int version) {
            super(24, version);
        }

        public InterfaceFactoryCreateDefaultRendererParams() {
            this(0);
        }

        public static InterfaceFactoryCreateDefaultRendererParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateDefaultRendererParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateDefaultRendererParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateDefaultRendererParams result = new InterfaceFactoryCreateDefaultRendererParams(elementsOrVersion);
                result.audioDeviceId = decoder0.readString(8, false);
                result.renderer = decoder0.readInterfaceRequest(16, false);
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
            encoder0.encode(this.audioDeviceId, 8, false);
            encoder0.encode((InterfaceRequest) this.renderer, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateMediaPlayerRendererParams.class */
    static final class InterfaceFactoryCreateMediaPlayerRendererParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaPlayerRendererClientExtension clientExtension;
        public InterfaceRequest<Renderer> renderer;
        public InterfaceRequest<MediaPlayerRendererExtension> rendererExtension;

        private InterfaceFactoryCreateMediaPlayerRendererParams(int version) {
            super(24, version);
        }

        public InterfaceFactoryCreateMediaPlayerRendererParams() {
            this(0);
        }

        public static InterfaceFactoryCreateMediaPlayerRendererParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateMediaPlayerRendererParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateMediaPlayerRendererParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateMediaPlayerRendererParams result = new InterfaceFactoryCreateMediaPlayerRendererParams(elementsOrVersion);
                result.clientExtension = (MediaPlayerRendererClientExtension) decoder0.readServiceInterface(8, false, MediaPlayerRendererClientExtension.MANAGER);
                result.renderer = decoder0.readInterfaceRequest(16, false);
                result.rendererExtension = decoder0.readInterfaceRequest(20, false);
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
            encoder0.encode( this.clientExtension, 8, false, MediaPlayerRendererClientExtension.MANAGER);
            encoder0.encode((InterfaceRequest) this.renderer, 16, false);
            encoder0.encode((InterfaceRequest) this.rendererExtension, 20, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateFlingingRendererParams.class */
    static final class InterfaceFactoryCreateFlingingRendererParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String presentationId;
        public FlingingRendererClientExtension clientExtension;
        public InterfaceRequest<Renderer> renderer;

        private InterfaceFactoryCreateFlingingRendererParams(int version) {
            super(32, version);
        }

        public InterfaceFactoryCreateFlingingRendererParams() {
            this(0);
        }

        public static InterfaceFactoryCreateFlingingRendererParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateFlingingRendererParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateFlingingRendererParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateFlingingRendererParams result = new InterfaceFactoryCreateFlingingRendererParams(elementsOrVersion);
                result.presentationId = decoder0.readString(8, false);
                result.clientExtension = (FlingingRendererClientExtension) decoder0.readServiceInterface(16, false, FlingingRendererClientExtension.MANAGER);
                result.renderer = decoder0.readInterfaceRequest(24, false);
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
            encoder0.encode(this.presentationId, 8, false);
            encoder0.encode(this.clientExtension, 16, false, FlingingRendererClientExtension.MANAGER);
            encoder0.encode((InterfaceRequest) this.renderer, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateCdmParams.class */
    static final class InterfaceFactoryCreateCdmParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String keySystem;
        public InterfaceRequest<ContentDecryptionModule> cdm;

        private InterfaceFactoryCreateCdmParams(int version) {
            super(24, version);
        }

        public InterfaceFactoryCreateCdmParams() {
            this(0);
        }

        public static InterfaceFactoryCreateCdmParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateCdmParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateCdmParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateCdmParams result = new InterfaceFactoryCreateCdmParams(elementsOrVersion);
                result.keySystem = decoder0.readString(8, false);
                result.cdm = decoder0.readInterfaceRequest(16, false);
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
            encoder0.encode(this.keySystem, 8, false);
            encoder0.encode((InterfaceRequest) this.cdm, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateDecryptorParams.class */
    static final class InterfaceFactoryCreateDecryptorParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int cdmId;
        public InterfaceRequest<Decryptor> decryptor;

        private InterfaceFactoryCreateDecryptorParams(int version) {
            super(16, version);
        }

        public InterfaceFactoryCreateDecryptorParams() {
            this(0);
        }

        public static InterfaceFactoryCreateDecryptorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateDecryptorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateDecryptorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateDecryptorParams result = new InterfaceFactoryCreateDecryptorParams(elementsOrVersion);
                result.cdmId = decoder0.readInt(8);
                result.decryptor = decoder0.readInterfaceRequest(12, false);
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
            encoder0.encode(this.cdmId, 8);
            encoder0.encode((InterfaceRequest) this.decryptor, 12, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/InterfaceFactory_Internal$InterfaceFactoryCreateCdmProxyParams.class */
    static final class InterfaceFactoryCreateCdmProxyParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Token cdmGuid;
        public InterfaceRequest<CdmProxy> cdmProxy;

        private InterfaceFactoryCreateCdmProxyParams(int version) {
            super(24, version);
        }

        public InterfaceFactoryCreateCdmProxyParams() {
            this(0);
        }

        public static InterfaceFactoryCreateCdmProxyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceFactoryCreateCdmProxyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceFactoryCreateCdmProxyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceFactoryCreateCdmProxyParams result = new InterfaceFactoryCreateCdmProxyParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cdmGuid = Token.decode(decoder1);
                result.cdmProxy = decoder0.readInterfaceRequest(16, false);
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
            encoder0.encode((Struct) this.cdmGuid, 8, false);
            encoder0.encode((InterfaceRequest) this.cdmProxy, 16, false);
        }
    }
}
