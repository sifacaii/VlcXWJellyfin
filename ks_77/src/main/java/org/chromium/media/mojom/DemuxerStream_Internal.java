package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.DemuxerStream;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal.class */
class DemuxerStream_Internal {
    public static final Interface.Manager<DemuxerStream, DemuxerStream.Proxy> MANAGER = new Interface.Manager<DemuxerStream, DemuxerStream.Proxy>() { // from class: org.chromium.media.mojom.DemuxerStream_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.DemuxerStream";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public DemuxerStream.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, DemuxerStream impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public DemuxerStream[] buildArray(int size) {
            return new DemuxerStream[size];
        }
    };
    private static final int INITIALIZE_ORDINAL = 0;
    private static final int READ_ORDINAL = 1;
    private static final int ENABLE_BITSTREAM_CONVERTER_ORDINAL = 2;

    DemuxerStream_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements DemuxerStream.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.DemuxerStream
        public void initialize(DemuxerStream.InitializeResponse callback) {
            DemuxerStreamInitializeParams _message = new DemuxerStreamInitializeParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new DemuxerStreamInitializeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.DemuxerStream
        public void read(DemuxerStream.ReadResponse callback) {
            DemuxerStreamReadParams _message = new DemuxerStreamReadParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new DemuxerStreamReadResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.DemuxerStream
        public void enableBitstreamConverter() {
            DemuxerStreamEnableBitstreamConverterParams _message = new DemuxerStreamEnableBitstreamConverterParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<DemuxerStream> {
        Stub(Core core, DemuxerStream impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DemuxerStream_Internal.MANAGER, messageWithHeader);
                    case 2:
                        DemuxerStreamEnableBitstreamConverterParams.deserialize(messageWithHeader.getPayload());
                        getImpl().enableBitstreamConverter();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), DemuxerStream_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        DemuxerStreamInitializeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().initialize(new DemuxerStreamInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        DemuxerStreamReadParams.deserialize(messageWithHeader.getPayload());
                        getImpl().read(new DemuxerStreamReadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamInitializeParams.class */
    static final class DemuxerStreamInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DemuxerStreamInitializeParams(int version) {
            super(8, version);
        }

        public DemuxerStreamInitializeParams() {
            this(0);
        }

        public static DemuxerStreamInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DemuxerStreamInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DemuxerStreamInitializeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DemuxerStreamInitializeParams result = new DemuxerStreamInitializeParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamInitializeResponseParams.class */
    public static final class DemuxerStreamInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public DataPipe.ConsumerHandle pipe;
        public AudioDecoderConfig audioConfig;
        public VideoDecoderConfig videoConfig;

        private DemuxerStreamInitializeResponseParams(int version) {
            super(32, version);
            this.pipe = InvalidHandle.INSTANCE;
        }

        public DemuxerStreamInitializeResponseParams() {
            this(0);
        }

        public static DemuxerStreamInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DemuxerStreamInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DemuxerStreamInitializeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DemuxerStreamInitializeResponseParams result = new DemuxerStreamInitializeResponseParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                DemuxerStream.Type.validate(result.type);
                result.pipe = decoder0.readConsumerHandle(12, false);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.audioConfig = AudioDecoderConfig.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, true);
                result.videoConfig = VideoDecoderConfig.decode(decoder12);
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
            encoder0.encode(this.type, 8);
            encoder0.encode((Handle) this.pipe, 12, false);
            encoder0.encode((Struct) this.audioConfig, 16, true);
            encoder0.encode((Struct) this.videoConfig, 24, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamInitializeResponseParamsForwardToCallback.class */
    static class DemuxerStreamInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final DemuxerStream.InitializeResponse mCallback;

        DemuxerStreamInitializeResponseParamsForwardToCallback(DemuxerStream.InitializeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                DemuxerStreamInitializeResponseParams response = DemuxerStreamInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.type), response.pipe, response.audioConfig, response.videoConfig);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamInitializeResponseParamsProxyToResponder.class */
    static class DemuxerStreamInitializeResponseParamsProxyToResponder implements DemuxerStream.InitializeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DemuxerStreamInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback4
        public void call(Integer type, DataPipe.ConsumerHandle pipe, AudioDecoderConfig audioConfig, VideoDecoderConfig videoConfig) {
            DemuxerStreamInitializeResponseParams _response = new DemuxerStreamInitializeResponseParams();
            _response.type = type.intValue();
            _response.pipe = pipe;
            _response.audioConfig = audioConfig;
            _response.videoConfig = videoConfig;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamReadParams.class */
    static final class DemuxerStreamReadParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DemuxerStreamReadParams(int version) {
            super(8, version);
        }

        public DemuxerStreamReadParams() {
            this(0);
        }

        public static DemuxerStreamReadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DemuxerStreamReadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DemuxerStreamReadParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DemuxerStreamReadParams result = new DemuxerStreamReadParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamReadResponseParams.class */
    public static final class DemuxerStreamReadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;
        public DecoderBuffer buffer;
        public AudioDecoderConfig audioConfig;
        public VideoDecoderConfig videoConfig;

        private DemuxerStreamReadResponseParams(int version) {
            super(40, version);
        }

        public DemuxerStreamReadResponseParams() {
            this(0);
        }

        public static DemuxerStreamReadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DemuxerStreamReadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DemuxerStreamReadResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DemuxerStreamReadResponseParams result = new DemuxerStreamReadResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                DemuxerStream.Status.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.buffer = DecoderBuffer.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, true);
                result.audioConfig = AudioDecoderConfig.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(32, true);
                result.videoConfig = VideoDecoderConfig.decode(decoder13);
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
            encoder0.encode(this.status, 8);
            encoder0.encode((Struct) this.buffer, 16, true);
            encoder0.encode((Struct) this.audioConfig, 24, true);
            encoder0.encode((Struct) this.videoConfig, 32, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamReadResponseParamsForwardToCallback.class */
    static class DemuxerStreamReadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final DemuxerStream.ReadResponse mCallback;

        DemuxerStreamReadResponseParamsForwardToCallback(DemuxerStream.ReadResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                DemuxerStreamReadResponseParams response = DemuxerStreamReadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.buffer, response.audioConfig, response.videoConfig);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamReadResponseParamsProxyToResponder.class */
    static class DemuxerStreamReadResponseParamsProxyToResponder implements DemuxerStream.ReadResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DemuxerStreamReadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback4
        public void call(Integer status, DecoderBuffer buffer, AudioDecoderConfig audioConfig, VideoDecoderConfig videoConfig) {
            DemuxerStreamReadResponseParams _response = new DemuxerStreamReadResponseParams();
            _response.status = status.intValue();
            _response.buffer = buffer;
            _response.audioConfig = audioConfig;
            _response.videoConfig = videoConfig;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DemuxerStream_Internal$DemuxerStreamEnableBitstreamConverterParams.class */
    static final class DemuxerStreamEnableBitstreamConverterParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DemuxerStreamEnableBitstreamConverterParams(int version) {
            super(8, version);
        }

        public DemuxerStreamEnableBitstreamConverterParams() {
            this(0);
        }

        public static DemuxerStreamEnableBitstreamConverterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DemuxerStreamEnableBitstreamConverterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DemuxerStreamEnableBitstreamConverterParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DemuxerStreamEnableBitstreamConverterParams result = new DemuxerStreamEnableBitstreamConverterParams(elementsOrVersion);
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
