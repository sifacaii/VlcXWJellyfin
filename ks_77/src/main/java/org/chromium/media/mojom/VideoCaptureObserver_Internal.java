package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoCaptureObserver;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal.class */
class VideoCaptureObserver_Internal {
    public static final Interface.Manager<VideoCaptureObserver, VideoCaptureObserver.Proxy> MANAGER = new Interface.Manager<VideoCaptureObserver, VideoCaptureObserver.Proxy>() { // from class: org.chromium.media.mojom.VideoCaptureObserver_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoCaptureObserver";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoCaptureObserver.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoCaptureObserver impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoCaptureObserver[] buildArray(int size) {
            return new VideoCaptureObserver[size];
        }
    };
    private static final int ON_STATE_CHANGED_ORDINAL = 0;
    private static final int ON_NEW_BUFFER_ORDINAL = 1;
    private static final int ON_BUFFER_READY_ORDINAL = 2;
    private static final int ON_BUFFER_DESTROYED_ORDINAL = 3;

    VideoCaptureObserver_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoCaptureObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoCaptureObserver
        public void onStateChanged(int state) {
            VideoCaptureObserverOnStateChangedParams _message = new VideoCaptureObserverOnStateChangedParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureObserver
        public void onNewBuffer(int bufferId, VideoBufferHandle bufferHandle) {
            VideoCaptureObserverOnNewBufferParams _message = new VideoCaptureObserverOnNewBufferParams();
            _message.bufferId = bufferId;
            _message.bufferHandle = bufferHandle;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureObserver
        public void onBufferReady(int bufferId, VideoFrameInfo info) {
            VideoCaptureObserverOnBufferReadyParams _message = new VideoCaptureObserverOnBufferReadyParams();
            _message.bufferId = bufferId;
            _message.info = info;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureObserver
        public void onBufferDestroyed(int bufferId) {
            VideoCaptureObserverOnBufferDestroyedParams _message = new VideoCaptureObserverOnBufferDestroyedParams();
            _message.bufferId = bufferId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoCaptureObserver> {
        Stub(Core core, VideoCaptureObserver impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoCaptureObserver_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        VideoCaptureObserverOnStateChangedParams data = VideoCaptureObserverOnStateChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onStateChanged(data.state);
                        return true;
                    case 1:
                        VideoCaptureObserverOnNewBufferParams data2 = VideoCaptureObserverOnNewBufferParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onNewBuffer(data2.bufferId, data2.bufferHandle);
                        return true;
                    case 2:
                        VideoCaptureObserverOnBufferReadyParams data3 = VideoCaptureObserverOnBufferReadyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onBufferReady(data3.bufferId, data3.info);
                        return true;
                    case 3:
                        getImpl().onBufferDestroyed(VideoCaptureObserverOnBufferDestroyedParams.deserialize(messageWithHeader.getPayload()).bufferId);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoCaptureObserver_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal$VideoCaptureObserverOnStateChangedParams.class */
    static final class VideoCaptureObserverOnStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int state;

        private VideoCaptureObserverOnStateChangedParams(int version) {
            super(16, version);
        }

        public VideoCaptureObserverOnStateChangedParams() {
            this(0);
        }

        public static VideoCaptureObserverOnStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureObserverOnStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureObserverOnStateChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureObserverOnStateChangedParams result = new VideoCaptureObserverOnStateChangedParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                VideoCaptureState.validate(result.state);
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
            encoder0.encode(this.state, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal$VideoCaptureObserverOnNewBufferParams.class */
    static final class VideoCaptureObserverOnNewBufferParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int bufferId;
        public VideoBufferHandle bufferHandle;

        private VideoCaptureObserverOnNewBufferParams(int version) {
            super(32, version);
        }

        public VideoCaptureObserverOnNewBufferParams() {
            this(0);
        }

        public static VideoCaptureObserverOnNewBufferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureObserverOnNewBufferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureObserverOnNewBufferParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureObserverOnNewBufferParams result = new VideoCaptureObserverOnNewBufferParams(elementsOrVersion);
                result.bufferId = decoder0.readInt(8);
                result.bufferHandle = VideoBufferHandle.decode(decoder0, 16);
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
            encoder0.encode(this.bufferId, 8);
            encoder0.encode((Union) this.bufferHandle, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal$VideoCaptureObserverOnBufferReadyParams.class */
    static final class VideoCaptureObserverOnBufferReadyParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int bufferId;
        public VideoFrameInfo info;

        private VideoCaptureObserverOnBufferReadyParams(int version) {
            super(24, version);
        }

        public VideoCaptureObserverOnBufferReadyParams() {
            this(0);
        }

        public static VideoCaptureObserverOnBufferReadyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureObserverOnBufferReadyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureObserverOnBufferReadyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureObserverOnBufferReadyParams result = new VideoCaptureObserverOnBufferReadyParams(elementsOrVersion);
                result.bufferId = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.info = VideoFrameInfo.decode(decoder1);
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
            encoder0.encode(this.bufferId, 8);
            encoder0.encode((Struct) this.info, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver_Internal$VideoCaptureObserverOnBufferDestroyedParams.class */
    static final class VideoCaptureObserverOnBufferDestroyedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int bufferId;

        private VideoCaptureObserverOnBufferDestroyedParams(int version) {
            super(16, version);
        }

        public VideoCaptureObserverOnBufferDestroyedParams() {
            this(0);
        }

        public static VideoCaptureObserverOnBufferDestroyedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureObserverOnBufferDestroyedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureObserverOnBufferDestroyedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureObserverOnBufferDestroyedParams result = new VideoCaptureObserverOnBufferDestroyedParams(elementsOrVersion);
                result.bufferId = decoder0.readInt(8);
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
            encoder0.encode(this.bufferId, 8);
        }
    }
}
