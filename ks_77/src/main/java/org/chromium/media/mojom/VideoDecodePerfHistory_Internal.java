package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoDecodePerfHistory;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal.class */
class VideoDecodePerfHistory_Internal {
    public static final Interface.Manager<VideoDecodePerfHistory, VideoDecodePerfHistory.Proxy> MANAGER = new Interface.Manager<VideoDecodePerfHistory, VideoDecodePerfHistory.Proxy>() { // from class: org.chromium.media.mojom.VideoDecodePerfHistory_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoDecodePerfHistory";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoDecodePerfHistory.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoDecodePerfHistory impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoDecodePerfHistory[] buildArray(int size) {
            return new VideoDecodePerfHistory[size];
        }
    };
    private static final int GET_PERF_INFO_ORDINAL = 0;

    VideoDecodePerfHistory_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoDecodePerfHistory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoDecodePerfHistory
        public void getPerfInfo(PredictionFeatures features, VideoDecodePerfHistory.GetPerfInfoResponse callback) {
            VideoDecodePerfHistoryGetPerfInfoParams _message = new VideoDecodePerfHistoryGetPerfInfoParams();
            _message.features = features;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoDecodePerfHistory> {
        Stub(Core core, VideoDecodePerfHistory impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoDecodePerfHistory_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoDecodePerfHistory_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        VideoDecodePerfHistoryGetPerfInfoParams data = VideoDecodePerfHistoryGetPerfInfoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getPerfInfo(data.features, new VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal$VideoDecodePerfHistoryGetPerfInfoParams.class */
    static final class VideoDecodePerfHistoryGetPerfInfoParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PredictionFeatures features;

        private VideoDecodePerfHistoryGetPerfInfoParams(int version) {
            super(16, version);
        }

        public VideoDecodePerfHistoryGetPerfInfoParams() {
            this(0);
        }

        public static VideoDecodePerfHistoryGetPerfInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecodePerfHistoryGetPerfInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecodePerfHistoryGetPerfInfoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDecodePerfHistoryGetPerfInfoParams result = new VideoDecodePerfHistoryGetPerfInfoParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.features = PredictionFeatures.decode(decoder1);
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
            encoder0.encode((Struct) this.features, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal$VideoDecodePerfHistoryGetPerfInfoResponseParams.class */
    public static final class VideoDecodePerfHistoryGetPerfInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isSmooth;
        public boolean isPowerEfficient;

        private VideoDecodePerfHistoryGetPerfInfoResponseParams(int version) {
            super(16, version);
        }

        public VideoDecodePerfHistoryGetPerfInfoResponseParams() {
            this(0);
        }

        public static VideoDecodePerfHistoryGetPerfInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecodePerfHistoryGetPerfInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecodePerfHistoryGetPerfInfoResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDecodePerfHistoryGetPerfInfoResponseParams result = new VideoDecodePerfHistoryGetPerfInfoResponseParams(elementsOrVersion);
                result.isSmooth = decoder0.readBoolean(8, 0);
                result.isPowerEfficient = decoder0.readBoolean(8, 1);
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
            encoder0.encode(this.isSmooth, 8, 0);
            encoder0.encode(this.isPowerEfficient, 8, 1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal$VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback.class */
    static class VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoDecodePerfHistory.GetPerfInfoResponse mCallback;

        VideoDecodePerfHistoryGetPerfInfoResponseParamsForwardToCallback(VideoDecodePerfHistory.GetPerfInfoResponse callback) {
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
                VideoDecodePerfHistoryGetPerfInfoResponseParams response = VideoDecodePerfHistoryGetPerfInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.isSmooth), Boolean.valueOf(response.isPowerEfficient));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory_Internal$VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder.class */
    static class VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder implements VideoDecodePerfHistory.GetPerfInfoResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        VideoDecodePerfHistoryGetPerfInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Boolean isSmooth, Boolean isPowerEfficient) {
            VideoDecodePerfHistoryGetPerfInfoResponseParams _response = new VideoDecodePerfHistoryGetPerfInfoResponseParams();
            _response.isSmooth = isSmooth.booleanValue();
            _response.isPowerEfficient = isPowerEfficient.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
