package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.Renderer;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal.class */
class Renderer_Internal {
    public static final Interface.Manager<Renderer, Renderer.Proxy> MANAGER = new Interface.Manager<Renderer, Renderer.Proxy>() { // from class: org.chromium.media.mojom.Renderer_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.Renderer";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public Renderer.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, Renderer impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Renderer[] buildArray(int size) {
            return new Renderer[size];
        }
    };
    private static final int INITIALIZE_ORDINAL = 0;
    private static final int FLUSH_ORDINAL = 1;
    private static final int START_PLAYING_FROM_ORDINAL = 2;
    private static final int SET_PLAYBACK_RATE_ORDINAL = 3;
    private static final int SET_VOLUME_ORDINAL = 4;
    private static final int SET_CDM_ORDINAL = 5;

    Renderer_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements Renderer.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.Renderer
        public void initialize(AssociatedInterfaceNotSupported client, DemuxerStream[] streams, MediaUrlParams mediaUrlParams, Renderer.InitializeResponse callback) {
            RendererInitializeParams _message = new RendererInitializeParams();
            _message.client = client;
            _message.streams = streams;
            _message.mediaUrlParams = mediaUrlParams;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new RendererInitializeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.Renderer
        public void flush(Renderer.FlushResponse callback) {
            RendererFlushParams _message = new RendererFlushParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new RendererFlushResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.Renderer
        public void startPlayingFrom(TimeDelta time) {
            RendererStartPlayingFromParams _message = new RendererStartPlayingFromParams();
            _message.time = time;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.Renderer
        public void setPlaybackRate(double playbackRate) {
            RendererSetPlaybackRateParams _message = new RendererSetPlaybackRateParams();
            _message.playbackRate = playbackRate;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media.mojom.Renderer
        public void setVolume(float volume) {
            RendererSetVolumeParams _message = new RendererSetVolumeParams();
            _message.volume = volume;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media.mojom.Renderer
        public void setCdm(int cdmId, Renderer.SetCdmResponse callback) {
            RendererSetCdmParams _message = new RendererSetCdmParams();
            _message.cdmId = cdmId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new RendererSetCdmResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<Renderer> {
        Stub(Core core, Renderer impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Renderer_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 0:
                    case 1:
                    default:
                        return false;
                    case 2:
                        RendererStartPlayingFromParams data = RendererStartPlayingFromParams.deserialize(messageWithHeader.getPayload());
                        getImpl().startPlayingFrom(data.time);
                        return true;
                    case 3:
                        RendererSetPlaybackRateParams data2 = RendererSetPlaybackRateParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setPlaybackRate(data2.playbackRate);
                        return true;
                    case 4:
                        RendererSetVolumeParams data3 = RendererSetVolumeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setVolume(data3.volume);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), Renderer_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        RendererInitializeParams data = RendererInitializeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().initialize(data.client, data.streams, data.mediaUrlParams, new RendererInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        RendererFlushParams.deserialize(messageWithHeader.getPayload());
                        getImpl().flush(new RendererFlushResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                    case 3:
                    case 4:
                    default:
                        return false;
                    case 5:
                        getImpl().setCdm(RendererSetCdmParams.deserialize(messageWithHeader.getPayload()).cdmId, new RendererSetCdmResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererInitializeParams.class */
    static final class RendererInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AssociatedInterfaceNotSupported client;
        public DemuxerStream[] streams;
        public MediaUrlParams mediaUrlParams;

        private RendererInitializeParams(int version) {
            super(32, version);
        }

        public RendererInitializeParams() {
            this(0);
        }

        public static RendererInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererInitializeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererInitializeParams result = new RendererInitializeParams(elementsOrVersion);
                result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
                result.streams = (DemuxerStream[]) decoder0.readServiceInterfaces(16, 1, -1, DemuxerStream.MANAGER);
                Decoder decoder1 = decoder0.readPointer(24, true);
                result.mediaUrlParams = MediaUrlParams.decode(decoder1);
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
            encoder0.encode(this.client, 8, false);
            encoder0.encode(this.streams, 16, 1, -1, DemuxerStream.MANAGER);
            encoder0.encode((Struct) this.mediaUrlParams, 24, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererInitializeResponseParams.class */
    public static final class RendererInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private RendererInitializeResponseParams(int version) {
            super(16, version);
        }

        public RendererInitializeResponseParams() {
            this(0);
        }

        public static RendererInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererInitializeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererInitializeResponseParams result = new RendererInitializeResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.success, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererInitializeResponseParamsForwardToCallback.class */
    static class RendererInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Renderer.InitializeResponse mCallback;

        RendererInitializeResponseParamsForwardToCallback(Renderer.InitializeResponse callback) {
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
                RendererInitializeResponseParams response = RendererInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererInitializeResponseParamsProxyToResponder.class */
    static class RendererInitializeResponseParamsProxyToResponder implements Renderer.InitializeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RendererInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            RendererInitializeResponseParams _response = new RendererInitializeResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererFlushParams.class */
    static final class RendererFlushParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RendererFlushParams(int version) {
            super(8, version);
        }

        public RendererFlushParams() {
            this(0);
        }

        public static RendererFlushParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererFlushParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererFlushParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererFlushParams result = new RendererFlushParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererFlushResponseParams.class */
    static final class RendererFlushResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RendererFlushResponseParams(int version) {
            super(8, version);
        }

        public RendererFlushResponseParams() {
            this(0);
        }

        public static RendererFlushResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererFlushResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererFlushResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererFlushResponseParams result = new RendererFlushResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererFlushResponseParamsForwardToCallback.class */
    static class RendererFlushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Renderer.FlushResponse mCallback;

        RendererFlushResponseParamsForwardToCallback(Renderer.FlushResponse callback) {
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
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererFlushResponseParamsProxyToResponder.class */
    static class RendererFlushResponseParamsProxyToResponder implements Renderer.FlushResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RendererFlushResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            RendererFlushResponseParams _response = new RendererFlushResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererStartPlayingFromParams.class */
    static final class RendererStartPlayingFromParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta time;

        private RendererStartPlayingFromParams(int version) {
            super(16, version);
        }

        public RendererStartPlayingFromParams() {
            this(0);
        }

        public static RendererStartPlayingFromParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererStartPlayingFromParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererStartPlayingFromParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererStartPlayingFromParams result = new RendererStartPlayingFromParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.time = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.time, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererSetPlaybackRateParams.class */
    static final class RendererSetPlaybackRateParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public double playbackRate;

        private RendererSetPlaybackRateParams(int version) {
            super(16, version);
        }

        public RendererSetPlaybackRateParams() {
            this(0);
        }

        public static RendererSetPlaybackRateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererSetPlaybackRateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererSetPlaybackRateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererSetPlaybackRateParams result = new RendererSetPlaybackRateParams(elementsOrVersion);
                result.playbackRate = decoder0.readDouble(8);
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
            encoder0.encode(this.playbackRate, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererSetVolumeParams.class */
    static final class RendererSetVolumeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public float volume;

        private RendererSetVolumeParams(int version) {
            super(16, version);
        }

        public RendererSetVolumeParams() {
            this(0);
        }

        public static RendererSetVolumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererSetVolumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererSetVolumeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererSetVolumeParams result = new RendererSetVolumeParams(elementsOrVersion);
                result.volume = decoder0.readFloat(8);
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
            encoder0.encode(this.volume, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererSetCdmParams.class */
    static final class RendererSetCdmParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int cdmId;

        private RendererSetCdmParams(int version) {
            super(16, version);
        }

        public RendererSetCdmParams() {
            this(0);
        }

        public static RendererSetCdmParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererSetCdmParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererSetCdmParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererSetCdmParams result = new RendererSetCdmParams(elementsOrVersion);
                result.cdmId = decoder0.readInt(8);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererSetCdmResponseParams.class */
    public static final class RendererSetCdmResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private RendererSetCdmResponseParams(int version) {
            super(16, version);
        }

        public RendererSetCdmResponseParams() {
            this(0);
        }

        public static RendererSetCdmResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererSetCdmResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererSetCdmResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererSetCdmResponseParams result = new RendererSetCdmResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.success, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererSetCdmResponseParamsForwardToCallback.class */
    static class RendererSetCdmResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Renderer.SetCdmResponse mCallback;

        RendererSetCdmResponseParamsForwardToCallback(Renderer.SetCdmResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2)) {
                    return false;
                }
                RendererSetCdmResponseParams response = RendererSetCdmResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer_Internal$RendererSetCdmResponseParamsProxyToResponder.class */
    static class RendererSetCdmResponseParamsProxyToResponder implements Renderer.SetCdmResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RendererSetCdmResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            RendererSetCdmResponseParams _response = new RendererSetCdmResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
