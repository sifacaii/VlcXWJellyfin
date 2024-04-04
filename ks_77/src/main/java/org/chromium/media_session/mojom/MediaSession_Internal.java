package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaSession;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal.class */
class MediaSession_Internal {
    public static final Interface.Manager<MediaSession, MediaSession.Proxy> MANAGER = new Interface.Manager<MediaSession, MediaSession.Proxy>() { // from class: org.chromium.media_session.mojom.MediaSession_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media_session.mojom.MediaSession";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaSession.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaSession impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaSession[] buildArray(int size) {
            return new MediaSession[size];
        }
    };
    private static final int GET_MEDIA_SESSION_INFO_ORDINAL = 0;
    private static final int GET_DEBUG_INFO_ORDINAL = 1;
    private static final int START_DUCKING_ORDINAL = 2;
    private static final int STOP_DUCKING_ORDINAL = 3;
    private static final int SUSPEND_ORDINAL = 4;
    private static final int RESUME_ORDINAL = 5;
    private static final int ADD_OBSERVER_ORDINAL = 6;
    private static final int PREVIOUS_TRACK_ORDINAL = 7;
    private static final int NEXT_TRACK_ORDINAL = 8;
    private static final int SEEK_ORDINAL = 9;
    private static final int STOP_ORDINAL = 10;
    private static final int SKIP_AD_ORDINAL = 11;
    private static final int GET_MEDIA_IMAGE_BITMAP_ORDINAL = 12;
    private static final int SEEK_TO_ORDINAL = 13;
    private static final int SCRUB_TO_ORDINAL = 14;

    MediaSession_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaSession.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void getMediaSessionInfo(MediaSession.GetMediaSessionInfoResponse callback) {
            MediaSessionGetMediaSessionInfoParams _message = new MediaSessionGetMediaSessionInfoParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new MediaSessionGetMediaSessionInfoResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void getDebugInfo(MediaSession.GetDebugInfoResponse callback) {
            MediaSessionGetDebugInfoParams _message = new MediaSessionGetDebugInfoParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new MediaSessionGetDebugInfoResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void startDucking() {
            MediaSessionStartDuckingParams _message = new MediaSessionStartDuckingParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void stopDucking() {
            MediaSessionStopDuckingParams _message = new MediaSessionStopDuckingParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void suspend(int suspendType) {
            MediaSessionSuspendParams _message = new MediaSessionSuspendParams();
            _message.suspendType = suspendType;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void resume(int suspendType) {
            MediaSessionResumeParams _message = new MediaSessionResumeParams();
            _message.suspendType = suspendType;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void addObserver(MediaSessionObserver observer) {
            MediaSessionAddObserverParams _message = new MediaSessionAddObserverParams();
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void previousTrack() {
            MediaSessionPreviousTrackParams _message = new MediaSessionPreviousTrackParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void nextTrack() {
            MediaSessionNextTrackParams _message = new MediaSessionNextTrackParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void seek(TimeDelta seekTime) {
            MediaSessionSeekParams _message = new MediaSessionSeekParams();
            _message.seekTime = seekTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void stop(int suspendType) {
            MediaSessionStopParams _message = new MediaSessionStopParams();
            _message.suspendType = suspendType;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void skipAd() {
            MediaSessionSkipAdParams _message = new MediaSessionSkipAdParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void getMediaImageBitmap(MediaImage image, int minimumSizePx, int desiredSizePx, MediaSession.GetMediaImageBitmapResponse callback) {
            MediaSessionGetMediaImageBitmapParams _message = new MediaSessionGetMediaImageBitmapParams();
            _message.image = image;
            _message.minimumSizePx = minimumSizePx;
            _message.desiredSizePx = desiredSizePx;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)), new MediaSessionGetMediaImageBitmapResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void seekTo(TimeDelta seekTime) {
            MediaSessionSeekToParams _message = new MediaSessionSeekToParams();
            _message.seekTime = seekTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
        }

        @Override // org.chromium.media_session.mojom.MediaSession
        public void scrubTo(TimeDelta seekTime) {
            MediaSessionScrubToParams _message = new MediaSessionScrubToParams();
            _message.seekTime = seekTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaSession> {
        Stub(Core core, MediaSession impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaSession_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 0:
                    case 1:
                    case 12:
                    default:
                        return false;
                    case 2:
                        MediaSessionStartDuckingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().startDucking();
                        return true;
                    case 3:
                        MediaSessionStopDuckingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().stopDucking();
                        return true;
                    case 4:
                        MediaSessionSuspendParams data = MediaSessionSuspendParams.deserialize(messageWithHeader.getPayload());
                        getImpl().suspend(data.suspendType);
                        return true;
                    case 5:
                        MediaSessionResumeParams data2 = MediaSessionResumeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resume(data2.suspendType);
                        return true;
                    case 6:
                        MediaSessionAddObserverParams data3 = MediaSessionAddObserverParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addObserver(data3.observer);
                        return true;
                    case 7:
                        MediaSessionPreviousTrackParams.deserialize(messageWithHeader.getPayload());
                        getImpl().previousTrack();
                        return true;
                    case 8:
                        MediaSessionNextTrackParams.deserialize(messageWithHeader.getPayload());
                        getImpl().nextTrack();
                        return true;
                    case 9:
                        MediaSessionSeekParams data4 = MediaSessionSeekParams.deserialize(messageWithHeader.getPayload());
                        getImpl().seek(data4.seekTime);
                        return true;
                    case 10:
                        MediaSessionStopParams data5 = MediaSessionStopParams.deserialize(messageWithHeader.getPayload());
                        getImpl().stop(data5.suspendType);
                        return true;
                    case 11:
                        MediaSessionSkipAdParams.deserialize(messageWithHeader.getPayload());
                        getImpl().skipAd();
                        return true;
                    case 13:
                        MediaSessionSeekToParams data6 = MediaSessionSeekToParams.deserialize(messageWithHeader.getPayload());
                        getImpl().seekTo(data6.seekTime);
                        return true;
                    case 14:
                        MediaSessionScrubToParams data7 = MediaSessionScrubToParams.deserialize(messageWithHeader.getPayload());
                        getImpl().scrubTo(data7.seekTime);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaSession_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        MediaSessionGetMediaSessionInfoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getMediaSessionInfo(new MediaSessionGetMediaSessionInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        MediaSessionGetDebugInfoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getDebugInfo(new MediaSessionGetDebugInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                        MediaSessionGetMediaImageBitmapParams data = MediaSessionGetMediaImageBitmapParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getMediaImageBitmap(data.image, data.minimumSizePx, data.desiredSizePx, new MediaSessionGetMediaImageBitmapResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaSessionInfoParams.class */
    static final class MediaSessionGetMediaSessionInfoParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionGetMediaSessionInfoParams(int version) {
            super(8, version);
        }

        public MediaSessionGetMediaSessionInfoParams() {
            this(0);
        }

        public static MediaSessionGetMediaSessionInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionGetMediaSessionInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionGetMediaSessionInfoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionGetMediaSessionInfoParams result = new MediaSessionGetMediaSessionInfoParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaSessionInfoResponseParams.class */
    public static final class MediaSessionGetMediaSessionInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaSessionInfo info;

        private MediaSessionGetMediaSessionInfoResponseParams(int version) {
            super(16, version);
        }

        public MediaSessionGetMediaSessionInfoResponseParams() {
            this(0);
        }

        public static MediaSessionGetMediaSessionInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionGetMediaSessionInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionGetMediaSessionInfoResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionGetMediaSessionInfoResponseParams result = new MediaSessionGetMediaSessionInfoResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = MediaSessionInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.info, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaSessionInfoResponseParamsForwardToCallback.class */
    static class MediaSessionGetMediaSessionInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaSession.GetMediaSessionInfoResponse mCallback;

        MediaSessionGetMediaSessionInfoResponseParamsForwardToCallback(MediaSession.GetMediaSessionInfoResponse callback) {
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
                MediaSessionGetMediaSessionInfoResponseParams response = MediaSessionGetMediaSessionInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.info);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaSessionInfoResponseParamsProxyToResponder.class */
    static class MediaSessionGetMediaSessionInfoResponseParamsProxyToResponder implements MediaSession.GetMediaSessionInfoResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaSessionGetMediaSessionInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(MediaSessionInfo info) {
            MediaSessionGetMediaSessionInfoResponseParams _response = new MediaSessionGetMediaSessionInfoResponseParams();
            _response.info = info;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetDebugInfoParams.class */
    static final class MediaSessionGetDebugInfoParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionGetDebugInfoParams(int version) {
            super(8, version);
        }

        public MediaSessionGetDebugInfoParams() {
            this(0);
        }

        public static MediaSessionGetDebugInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionGetDebugInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionGetDebugInfoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionGetDebugInfoParams result = new MediaSessionGetDebugInfoParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetDebugInfoResponseParams.class */
    public static final class MediaSessionGetDebugInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaSessionDebugInfo info;

        private MediaSessionGetDebugInfoResponseParams(int version) {
            super(16, version);
        }

        public MediaSessionGetDebugInfoResponseParams() {
            this(0);
        }

        public static MediaSessionGetDebugInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionGetDebugInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionGetDebugInfoResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionGetDebugInfoResponseParams result = new MediaSessionGetDebugInfoResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = MediaSessionDebugInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.info, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetDebugInfoResponseParamsForwardToCallback.class */
    static class MediaSessionGetDebugInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaSession.GetDebugInfoResponse mCallback;

        MediaSessionGetDebugInfoResponseParamsForwardToCallback(MediaSession.GetDebugInfoResponse callback) {
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
                MediaSessionGetDebugInfoResponseParams response = MediaSessionGetDebugInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.info);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetDebugInfoResponseParamsProxyToResponder.class */
    static class MediaSessionGetDebugInfoResponseParamsProxyToResponder implements MediaSession.GetDebugInfoResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaSessionGetDebugInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(MediaSessionDebugInfo info) {
            MediaSessionGetDebugInfoResponseParams _response = new MediaSessionGetDebugInfoResponseParams();
            _response.info = info;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionStartDuckingParams.class */
    static final class MediaSessionStartDuckingParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionStartDuckingParams(int version) {
            super(8, version);
        }

        public MediaSessionStartDuckingParams() {
            this(0);
        }

        public static MediaSessionStartDuckingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionStartDuckingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionStartDuckingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionStartDuckingParams result = new MediaSessionStartDuckingParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionStopDuckingParams.class */
    static final class MediaSessionStopDuckingParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionStopDuckingParams(int version) {
            super(8, version);
        }

        public MediaSessionStopDuckingParams() {
            this(0);
        }

        public static MediaSessionStopDuckingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionStopDuckingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionStopDuckingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionStopDuckingParams result = new MediaSessionStopDuckingParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionSuspendParams.class */
    static final class MediaSessionSuspendParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int suspendType;

        private MediaSessionSuspendParams(int version) {
            super(16, version);
        }

        public MediaSessionSuspendParams() {
            this(0);
        }

        public static MediaSessionSuspendParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionSuspendParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionSuspendParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionSuspendParams result = new MediaSessionSuspendParams(elementsOrVersion);
                result.suspendType = decoder0.readInt(8);
                MediaSession.SuspendType.validate(result.suspendType);
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
            encoder0.encode(this.suspendType, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionResumeParams.class */
    static final class MediaSessionResumeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int suspendType;

        private MediaSessionResumeParams(int version) {
            super(16, version);
        }

        public MediaSessionResumeParams() {
            this(0);
        }

        public static MediaSessionResumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionResumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionResumeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionResumeParams result = new MediaSessionResumeParams(elementsOrVersion);
                result.suspendType = decoder0.readInt(8);
                MediaSession.SuspendType.validate(result.suspendType);
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
            encoder0.encode(this.suspendType, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionAddObserverParams.class */
    static final class MediaSessionAddObserverParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaSessionObserver observer;

        private MediaSessionAddObserverParams(int version) {
            super(16, version);
        }

        public MediaSessionAddObserverParams() {
            this(0);
        }

        public static MediaSessionAddObserverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionAddObserverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionAddObserverParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionAddObserverParams result = new MediaSessionAddObserverParams(elementsOrVersion);
                result.observer = (MediaSessionObserver) decoder0.readServiceInterface(8, false, MediaSessionObserver.MANAGER);
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
            encoder0.encode( this.observer, 8, false, MediaSessionObserver.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionPreviousTrackParams.class */
    static final class MediaSessionPreviousTrackParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionPreviousTrackParams(int version) {
            super(8, version);
        }

        public MediaSessionPreviousTrackParams() {
            this(0);
        }

        public static MediaSessionPreviousTrackParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionPreviousTrackParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionPreviousTrackParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionPreviousTrackParams result = new MediaSessionPreviousTrackParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionNextTrackParams.class */
    static final class MediaSessionNextTrackParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionNextTrackParams(int version) {
            super(8, version);
        }

        public MediaSessionNextTrackParams() {
            this(0);
        }

        public static MediaSessionNextTrackParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionNextTrackParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionNextTrackParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionNextTrackParams result = new MediaSessionNextTrackParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionSeekParams.class */
    static final class MediaSessionSeekParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta seekTime;

        private MediaSessionSeekParams(int version) {
            super(16, version);
        }

        public MediaSessionSeekParams() {
            this(0);
        }

        public static MediaSessionSeekParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionSeekParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionSeekParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionSeekParams result = new MediaSessionSeekParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.seekTime = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.seekTime, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionStopParams.class */
    static final class MediaSessionStopParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int suspendType;

        private MediaSessionStopParams(int version) {
            super(16, version);
        }

        public MediaSessionStopParams() {
            this(0);
        }

        public static MediaSessionStopParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionStopParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionStopParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionStopParams result = new MediaSessionStopParams(elementsOrVersion);
                result.suspendType = decoder0.readInt(8);
                MediaSession.SuspendType.validate(result.suspendType);
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
            encoder0.encode(this.suspendType, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionSkipAdParams.class */
    static final class MediaSessionSkipAdParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaSessionSkipAdParams(int version) {
            super(8, version);
        }

        public MediaSessionSkipAdParams() {
            this(0);
        }

        public static MediaSessionSkipAdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionSkipAdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionSkipAdParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionSkipAdParams result = new MediaSessionSkipAdParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaImageBitmapParams.class */
    static final class MediaSessionGetMediaImageBitmapParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaImage image;
        public int minimumSizePx;
        public int desiredSizePx;

        private MediaSessionGetMediaImageBitmapParams(int version) {
            super(24, version);
        }

        public MediaSessionGetMediaImageBitmapParams() {
            this(0);
        }

        public static MediaSessionGetMediaImageBitmapParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionGetMediaImageBitmapParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionGetMediaImageBitmapParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionGetMediaImageBitmapParams result = new MediaSessionGetMediaImageBitmapParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.image = MediaImage.decode(decoder1);
                result.minimumSizePx = decoder0.readInt(16);
                result.desiredSizePx = decoder0.readInt(20);
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
            encoder0.encode((Struct) this.image, 8, false);
            encoder0.encode(this.minimumSizePx, 16);
            encoder0.encode(this.desiredSizePx, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaImageBitmapResponseParams.class */
    public static final class MediaSessionGetMediaImageBitmapResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaImageBitmap image;

        private MediaSessionGetMediaImageBitmapResponseParams(int version) {
            super(16, version);
        }

        public MediaSessionGetMediaImageBitmapResponseParams() {
            this(0);
        }

        public static MediaSessionGetMediaImageBitmapResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionGetMediaImageBitmapResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionGetMediaImageBitmapResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionGetMediaImageBitmapResponseParams result = new MediaSessionGetMediaImageBitmapResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.image = MediaImageBitmap.decode(decoder1);
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
            encoder0.encode((Struct) this.image, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaImageBitmapResponseParamsForwardToCallback.class */
    static class MediaSessionGetMediaImageBitmapResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaSession.GetMediaImageBitmapResponse mCallback;

        MediaSessionGetMediaImageBitmapResponseParamsForwardToCallback(MediaSession.GetMediaImageBitmapResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(12, 2)) {
                    return false;
                }
                MediaSessionGetMediaImageBitmapResponseParams response = MediaSessionGetMediaImageBitmapResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.image);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionGetMediaImageBitmapResponseParamsProxyToResponder.class */
    static class MediaSessionGetMediaImageBitmapResponseParamsProxyToResponder implements MediaSession.GetMediaImageBitmapResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaSessionGetMediaImageBitmapResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(MediaImageBitmap image) {
            MediaSessionGetMediaImageBitmapResponseParams _response = new MediaSessionGetMediaImageBitmapResponseParams();
            _response.image = image;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionSeekToParams.class */
    static final class MediaSessionSeekToParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta seekTime;

        private MediaSessionSeekToParams(int version) {
            super(16, version);
        }

        public MediaSessionSeekToParams() {
            this(0);
        }

        public static MediaSessionSeekToParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionSeekToParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionSeekToParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionSeekToParams result = new MediaSessionSeekToParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.seekTime = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.seekTime, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession_Internal$MediaSessionScrubToParams.class */
    static final class MediaSessionScrubToParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta seekTime;

        private MediaSessionScrubToParams(int version) {
            super(16, version);
        }

        public MediaSessionScrubToParams() {
            this(0);
        }

        public static MediaSessionScrubToParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionScrubToParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionScrubToParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaSessionScrubToParams result = new MediaSessionScrubToParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.seekTime = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.seekTime, 8, false);
        }
    }
}
