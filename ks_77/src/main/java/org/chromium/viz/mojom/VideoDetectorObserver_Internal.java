package org.chromium.viz.mojom;

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
import org.chromium.viz.mojom.VideoDetectorObserver;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver_Internal.class */
class VideoDetectorObserver_Internal {
    public static final Interface.Manager<VideoDetectorObserver, VideoDetectorObserver.Proxy> MANAGER = new Interface.Manager<VideoDetectorObserver, VideoDetectorObserver.Proxy>() { // from class: org.chromium.viz.mojom.VideoDetectorObserver_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.VideoDetectorObserver";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoDetectorObserver.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoDetectorObserver impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoDetectorObserver[] buildArray(int size) {
            return new VideoDetectorObserver[size];
        }
    };
    private static final int ON_VIDEO_ACTIVITY_STARTED_ORDINAL = 0;
    private static final int ON_VIDEO_ACTIVITY_ENDED_ORDINAL = 1;

    VideoDetectorObserver_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoDetectorObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.VideoDetectorObserver
        public void onVideoActivityStarted() {
            VideoDetectorObserverOnVideoActivityStartedParams _message = new VideoDetectorObserverOnVideoActivityStartedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.viz.mojom.VideoDetectorObserver
        public void onVideoActivityEnded() {
            VideoDetectorObserverOnVideoActivityEndedParams _message = new VideoDetectorObserverOnVideoActivityEndedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoDetectorObserver> {
        Stub(Core core, VideoDetectorObserver impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoDetectorObserver_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        VideoDetectorObserverOnVideoActivityStartedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoActivityStarted();
                        return true;
                    case 1:
                        VideoDetectorObserverOnVideoActivityEndedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoActivityEnded();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoDetectorObserver_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver_Internal$VideoDetectorObserverOnVideoActivityStartedParams.class */
    static final class VideoDetectorObserverOnVideoActivityStartedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VideoDetectorObserverOnVideoActivityStartedParams(int version) {
            super(8, version);
        }

        public VideoDetectorObserverOnVideoActivityStartedParams() {
            this(0);
        }

        public static VideoDetectorObserverOnVideoActivityStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDetectorObserverOnVideoActivityStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDetectorObserverOnVideoActivityStartedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDetectorObserverOnVideoActivityStartedParams result = new VideoDetectorObserverOnVideoActivityStartedParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver_Internal$VideoDetectorObserverOnVideoActivityEndedParams.class */
    static final class VideoDetectorObserverOnVideoActivityEndedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VideoDetectorObserverOnVideoActivityEndedParams(int version) {
            super(8, version);
        }

        public VideoDetectorObserverOnVideoActivityEndedParams() {
            this(0);
        }

        public static VideoDetectorObserverOnVideoActivityEndedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDetectorObserverOnVideoActivityEndedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDetectorObserverOnVideoActivityEndedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDetectorObserverOnVideoActivityEndedParams result = new VideoDetectorObserverOnVideoActivityEndedParams(elementsOrVersion);
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
