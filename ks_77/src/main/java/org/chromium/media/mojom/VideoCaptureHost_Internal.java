package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoCaptureHost;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal.class */
class VideoCaptureHost_Internal {
    public static final Interface.Manager<VideoCaptureHost, VideoCaptureHost.Proxy> MANAGER = new Interface.Manager<VideoCaptureHost, VideoCaptureHost.Proxy>() { // from class: org.chromium.media.mojom.VideoCaptureHost_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoCaptureHost";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoCaptureHost.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoCaptureHost impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoCaptureHost[] buildArray(int size) {
            return new VideoCaptureHost[size];
        }
    };
    private static final int START_ORDINAL = 0;
    private static final int STOP_ORDINAL = 1;
    private static final int PAUSE_ORDINAL = 2;
    private static final int RESUME_ORDINAL = 3;
    private static final int REQUEST_REFRESH_FRAME_ORDINAL = 4;
    private static final int RELEASE_BUFFER_ORDINAL = 5;
    private static final int GET_DEVICE_SUPPORTED_FORMATS_ORDINAL = 6;
    private static final int GET_DEVICE_FORMATS_IN_USE_ORDINAL = 7;
    private static final int ON_FRAME_DROPPED_ORDINAL = 8;
    private static final int ON_LOG_ORDINAL = 9;

    VideoCaptureHost_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoCaptureHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void start(int deviceId, int sessionId, VideoCaptureParams params, VideoCaptureObserver observer) {
            VideoCaptureHostStartParams _message = new VideoCaptureHostStartParams();
            _message.deviceId = deviceId;
            _message.sessionId = sessionId;
            _message.params = params;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void stop(int deviceId) {
            VideoCaptureHostStopParams _message = new VideoCaptureHostStopParams();
            _message.deviceId = deviceId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void pause(int deviceId) {
            VideoCaptureHostPauseParams _message = new VideoCaptureHostPauseParams();
            _message.deviceId = deviceId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void resume(int deviceId, int sessionId, VideoCaptureParams params) {
            VideoCaptureHostResumeParams _message = new VideoCaptureHostResumeParams();
            _message.deviceId = deviceId;
            _message.sessionId = sessionId;
            _message.params = params;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void requestRefreshFrame(int deviceId) {
            VideoCaptureHostRequestRefreshFrameParams _message = new VideoCaptureHostRequestRefreshFrameParams();
            _message.deviceId = deviceId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void releaseBuffer(int deviceId, int bufferId, double consumerResourceUtilization) {
            VideoCaptureHostReleaseBufferParams _message = new VideoCaptureHostReleaseBufferParams();
            _message.deviceId = deviceId;
            _message.bufferId = bufferId;
            _message.consumerResourceUtilization = consumerResourceUtilization;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void getDeviceSupportedFormats(int deviceId, int sessionId, VideoCaptureHost.GetDeviceSupportedFormatsResponse callback) {
            VideoCaptureHostGetDeviceSupportedFormatsParams _message = new VideoCaptureHostGetDeviceSupportedFormatsParams();
            _message.deviceId = deviceId;
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void getDeviceFormatsInUse(int deviceId, int sessionId, VideoCaptureHost.GetDeviceFormatsInUseResponse callback) {
            VideoCaptureHostGetDeviceFormatsInUseParams _message = new VideoCaptureHostGetDeviceFormatsInUseParams();
            _message.deviceId = deviceId;
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void onFrameDropped(int deviceId, int reason) {
            VideoCaptureHostOnFrameDroppedParams _message = new VideoCaptureHostOnFrameDroppedParams();
            _message.deviceId = deviceId;
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.media.mojom.VideoCaptureHost
        public void onLog(int deviceId, String message) {
            VideoCaptureHostOnLogParams _message = new VideoCaptureHostOnLogParams();
            _message.deviceId = deviceId;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoCaptureHost> {
        Stub(Core core, VideoCaptureHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoCaptureHost_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 6:
                    case 7:
                    default:
                        return false;
                    case 0:
                        VideoCaptureHostStartParams data = VideoCaptureHostStartParams.deserialize(messageWithHeader.getPayload());
                        getImpl().start(data.deviceId, data.sessionId, data.params, data.observer);
                        return true;
                    case 1:
                        getImpl().stop(VideoCaptureHostStopParams.deserialize(messageWithHeader.getPayload()).deviceId);
                        return true;
                    case 2:
                        getImpl().pause(VideoCaptureHostPauseParams.deserialize(messageWithHeader.getPayload()).deviceId);
                        return true;
                    case 3:
                        VideoCaptureHostResumeParams data2 = VideoCaptureHostResumeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resume(data2.deviceId, data2.sessionId, data2.params);
                        return true;
                    case 4:
                        getImpl().requestRefreshFrame(VideoCaptureHostRequestRefreshFrameParams.deserialize(messageWithHeader.getPayload()).deviceId);
                        return true;
                    case 5:
                        VideoCaptureHostReleaseBufferParams data3 = VideoCaptureHostReleaseBufferParams.deserialize(messageWithHeader.getPayload());
                        getImpl().releaseBuffer(data3.deviceId, data3.bufferId, data3.consumerResourceUtilization);
                        return true;
                    case 8:
                        VideoCaptureHostOnFrameDroppedParams data4 = VideoCaptureHostOnFrameDroppedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onFrameDropped(data4.deviceId, data4.reason);
                        return true;
                    case 9:
                        VideoCaptureHostOnLogParams data5 = VideoCaptureHostOnLogParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onLog(data5.deviceId, data5.message);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoCaptureHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 6:
                        VideoCaptureHostGetDeviceSupportedFormatsParams data = VideoCaptureHostGetDeviceSupportedFormatsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getDeviceSupportedFormats(data.deviceId, data.sessionId, new VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        VideoCaptureHostGetDeviceFormatsInUseParams data2 = VideoCaptureHostGetDeviceFormatsInUseParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getDeviceFormatsInUse(data2.deviceId, data2.sessionId, new VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostStartParams.class */
    static final class VideoCaptureHostStartParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public int sessionId;
        public VideoCaptureParams params;
        public VideoCaptureObserver observer;

        private VideoCaptureHostStartParams(int version) {
            super(32, version);
        }

        public VideoCaptureHostStartParams() {
            this(0);
        }

        public static VideoCaptureHostStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostStartParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostStartParams result = new VideoCaptureHostStartParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.sessionId = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.params = VideoCaptureParams.decode(decoder1);
                result.observer = (VideoCaptureObserver) decoder0.readServiceInterface(24, false, VideoCaptureObserver.MANAGER);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.sessionId, 12);
            encoder0.encode((Struct) this.params, 16, false);
            encoder0.encode( this.observer, 24, false,  VideoCaptureObserver.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostStopParams.class */
    static final class VideoCaptureHostStopParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;

        private VideoCaptureHostStopParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostStopParams() {
            this(0);
        }

        public static VideoCaptureHostStopParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostStopParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostStopParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostStopParams result = new VideoCaptureHostStopParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
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
            encoder0.encode(this.deviceId, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostPauseParams.class */
    static final class VideoCaptureHostPauseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;

        private VideoCaptureHostPauseParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostPauseParams() {
            this(0);
        }

        public static VideoCaptureHostPauseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostPauseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostPauseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostPauseParams result = new VideoCaptureHostPauseParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
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
            encoder0.encode(this.deviceId, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostResumeParams.class */
    static final class VideoCaptureHostResumeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public int sessionId;
        public VideoCaptureParams params;

        private VideoCaptureHostResumeParams(int version) {
            super(24, version);
        }

        public VideoCaptureHostResumeParams() {
            this(0);
        }

        public static VideoCaptureHostResumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostResumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostResumeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostResumeParams result = new VideoCaptureHostResumeParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.sessionId = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.params = VideoCaptureParams.decode(decoder1);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.sessionId, 12);
            encoder0.encode((Struct) this.params, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostRequestRefreshFrameParams.class */
    static final class VideoCaptureHostRequestRefreshFrameParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;

        private VideoCaptureHostRequestRefreshFrameParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostRequestRefreshFrameParams() {
            this(0);
        }

        public static VideoCaptureHostRequestRefreshFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostRequestRefreshFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostRequestRefreshFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostRequestRefreshFrameParams result = new VideoCaptureHostRequestRefreshFrameParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
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
            encoder0.encode(this.deviceId, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostReleaseBufferParams.class */
    static final class VideoCaptureHostReleaseBufferParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public int bufferId;
        public double consumerResourceUtilization;

        private VideoCaptureHostReleaseBufferParams(int version) {
            super(24, version);
        }

        public VideoCaptureHostReleaseBufferParams() {
            this(0);
        }

        public static VideoCaptureHostReleaseBufferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostReleaseBufferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostReleaseBufferParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostReleaseBufferParams result = new VideoCaptureHostReleaseBufferParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.bufferId = decoder0.readInt(12);
                result.consumerResourceUtilization = decoder0.readDouble(16);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.bufferId, 12);
            encoder0.encode(this.consumerResourceUtilization, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceSupportedFormatsParams.class */
    static final class VideoCaptureHostGetDeviceSupportedFormatsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public int sessionId;

        private VideoCaptureHostGetDeviceSupportedFormatsParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostGetDeviceSupportedFormatsParams() {
            this(0);
        }

        public static VideoCaptureHostGetDeviceSupportedFormatsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostGetDeviceSupportedFormatsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostGetDeviceSupportedFormatsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostGetDeviceSupportedFormatsParams result = new VideoCaptureHostGetDeviceSupportedFormatsParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.sessionId = decoder0.readInt(12);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.sessionId, 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceSupportedFormatsResponseParams.class */
    public static final class VideoCaptureHostGetDeviceSupportedFormatsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoCaptureFormat[] formatsSupported;

        private VideoCaptureHostGetDeviceSupportedFormatsResponseParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostGetDeviceSupportedFormatsResponseParams() {
            this(0);
        }

        public static VideoCaptureHostGetDeviceSupportedFormatsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostGetDeviceSupportedFormatsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostGetDeviceSupportedFormatsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostGetDeviceSupportedFormatsResponseParams result = new VideoCaptureHostGetDeviceSupportedFormatsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.formatsSupported = new VideoCaptureFormat[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.formatsSupported[i1] = VideoCaptureFormat.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.formatsSupported == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.formatsSupported.length, 8, -1);
            for (int i0 = 0; i0 < this.formatsSupported.length; i0++) {
                encoder1.encode((Struct) this.formatsSupported[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback.class */
    static class VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoCaptureHost.GetDeviceSupportedFormatsResponse mCallback;

        VideoCaptureHostGetDeviceSupportedFormatsResponseParamsForwardToCallback(VideoCaptureHost.GetDeviceSupportedFormatsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2)) {
                    return false;
                }
                VideoCaptureHostGetDeviceSupportedFormatsResponseParams response = VideoCaptureHostGetDeviceSupportedFormatsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.formatsSupported);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder.class */
    static class VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder implements VideoCaptureHost.GetDeviceSupportedFormatsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        VideoCaptureHostGetDeviceSupportedFormatsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(VideoCaptureFormat[] formatsSupported) {
            VideoCaptureHostGetDeviceSupportedFormatsResponseParams _response = new VideoCaptureHostGetDeviceSupportedFormatsResponseParams();
            _response.formatsSupported = formatsSupported;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceFormatsInUseParams.class */
    static final class VideoCaptureHostGetDeviceFormatsInUseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public int sessionId;

        private VideoCaptureHostGetDeviceFormatsInUseParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostGetDeviceFormatsInUseParams() {
            this(0);
        }

        public static VideoCaptureHostGetDeviceFormatsInUseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostGetDeviceFormatsInUseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostGetDeviceFormatsInUseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostGetDeviceFormatsInUseParams result = new VideoCaptureHostGetDeviceFormatsInUseParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.sessionId = decoder0.readInt(12);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.sessionId, 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceFormatsInUseResponseParams.class */
    public static final class VideoCaptureHostGetDeviceFormatsInUseResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoCaptureFormat[] formatsInUse;

        private VideoCaptureHostGetDeviceFormatsInUseResponseParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostGetDeviceFormatsInUseResponseParams() {
            this(0);
        }

        public static VideoCaptureHostGetDeviceFormatsInUseResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostGetDeviceFormatsInUseResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostGetDeviceFormatsInUseResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostGetDeviceFormatsInUseResponseParams result = new VideoCaptureHostGetDeviceFormatsInUseResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.formatsInUse = new VideoCaptureFormat[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.formatsInUse[i1] = VideoCaptureFormat.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.formatsInUse == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.formatsInUse.length, 8, -1);
            for (int i0 = 0; i0 < this.formatsInUse.length; i0++) {
                encoder1.encode((Struct) this.formatsInUse[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback.class */
    static class VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoCaptureHost.GetDeviceFormatsInUseResponse mCallback;

        VideoCaptureHostGetDeviceFormatsInUseResponseParamsForwardToCallback(VideoCaptureHost.GetDeviceFormatsInUseResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2)) {
                    return false;
                }
                VideoCaptureHostGetDeviceFormatsInUseResponseParams response = VideoCaptureHostGetDeviceFormatsInUseResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.formatsInUse);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder.class */
    static class VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder implements VideoCaptureHost.GetDeviceFormatsInUseResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        VideoCaptureHostGetDeviceFormatsInUseResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(VideoCaptureFormat[] formatsInUse) {
            VideoCaptureHostGetDeviceFormatsInUseResponseParams _response = new VideoCaptureHostGetDeviceFormatsInUseResponseParams();
            _response.formatsInUse = formatsInUse;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostOnFrameDroppedParams.class */
    static final class VideoCaptureHostOnFrameDroppedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public int reason;

        private VideoCaptureHostOnFrameDroppedParams(int version) {
            super(16, version);
        }

        public VideoCaptureHostOnFrameDroppedParams() {
            this(0);
        }

        public static VideoCaptureHostOnFrameDroppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostOnFrameDroppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostOnFrameDroppedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostOnFrameDroppedParams result = new VideoCaptureHostOnFrameDroppedParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.reason = decoder0.readInt(12);
                VideoCaptureFrameDropReason.validate(result.reason);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.reason, 12);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureHost_Internal$VideoCaptureHostOnLogParams.class */
    static final class VideoCaptureHostOnLogParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int deviceId;
        public String message;

        private VideoCaptureHostOnLogParams(int version) {
            super(24, version);
        }

        public VideoCaptureHostOnLogParams() {
            this(0);
        }

        public static VideoCaptureHostOnLogParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoCaptureHostOnLogParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoCaptureHostOnLogParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoCaptureHostOnLogParams result = new VideoCaptureHostOnLogParams(elementsOrVersion);
                result.deviceId = decoder0.readInt(8);
                result.message = decoder0.readString(16, false);
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
            encoder0.encode(this.deviceId, 8);
            encoder0.encode(this.message, 16, false);
        }
    }
}
