package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class MediaStreamDispatcherHost_Internal {
    public static final Interface.Manager<MediaStreamDispatcherHost, MediaStreamDispatcherHost.Proxy> MANAGER = new Interface.Manager<MediaStreamDispatcherHost, MediaStreamDispatcherHost.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaStreamDispatcherHost";
        }

        public int getVersion() {
            return 0;
        }

        public MediaStreamDispatcherHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaStreamDispatcherHost_Internal.Proxy(core, messageReceiver);
        }

        public MediaStreamDispatcherHost_Internal.Stub buildStub(Core core, MediaStreamDispatcherHost impl) {
            return new MediaStreamDispatcherHost_Internal.Stub(core, impl);
        }

        public MediaStreamDispatcherHost[] buildArray(int size) {
            return new MediaStreamDispatcherHost[size];
        }
    };

    private static final int GENERATE_STREAM_ORDINAL = 0;

    private static final int CANCEL_REQUEST_ORDINAL = 1;

    private static final int STOP_STREAM_DEVICE_ORDINAL = 2;

    private static final int OPEN_DEVICE_ORDINAL = 3;

    private static final int CLOSE_DEVICE_ORDINAL = 4;

    private static final int SET_CAPTURING_LINK_SECURED_ORDINAL = 5;

    private static final int ON_STREAM_STARTED_ORDINAL = 6;

    static final class Proxy extends Interface.AbstractProxy implements MediaStreamDispatcherHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void generateStream(int requestId, StreamControls controls, boolean userGesture, MediaStreamDispatcherHost.GenerateStreamResponse callback) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamParams();
            _message.requestId = requestId;
            _message.controls = controls;
            _message.userGesture = userGesture;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamResponseParamsForwardToCallback(callback));
        }

        public void cancelRequest(int requestId) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCancelRequestParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCancelRequestParams();
            _message.requestId = requestId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void stopStreamDevice(String deviceId, int sessionId) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostStopStreamDeviceParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostStopStreamDeviceParams();
            _message.deviceId = deviceId;
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void openDevice(int requestId, String deviceId, int type, MediaStreamDispatcherHost.OpenDeviceResponse callback) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceParams();
            _message.requestId = requestId;
            _message.deviceId = deviceId;
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceResponseParamsForwardToCallback(callback));
        }

        public void closeDevice(String label) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCloseDeviceParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCloseDeviceParams();
            _message.label = label;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void setCapturingLinkSecured(int sessionId, int type, boolean isSecure) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostSetCapturingLinkSecuredParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostSetCapturingLinkSecuredParams();
            _message.sessionId = sessionId;
            _message.type = type;
            _message.isSecure = isSecure;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void onStreamStarted(String label) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOnStreamStartedParams _message = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOnStreamStartedParams();
            _message.label = label;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }
    }

    static final class Stub extends Interface.Stub<MediaStreamDispatcherHost> {
        Stub(Core core, MediaStreamDispatcherHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCancelRequestParams mediaStreamDispatcherHostCancelRequestParams;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostStopStreamDeviceParams mediaStreamDispatcherHostStopStreamDeviceParams;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCloseDeviceParams mediaStreamDispatcherHostCloseDeviceParams;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostSetCapturingLinkSecuredParams mediaStreamDispatcherHostSetCapturingLinkSecuredParams;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOnStreamStartedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaStreamDispatcherHost_Internal.MANAGER, messageWithHeader);
                    case 1:
                        mediaStreamDispatcherHostCancelRequestParams = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCancelRequestParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).cancelRequest(mediaStreamDispatcherHostCancelRequestParams.requestId);
                        return true;
                    case 2:
                        mediaStreamDispatcherHostStopStreamDeviceParams = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostStopStreamDeviceParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).stopStreamDevice(mediaStreamDispatcherHostStopStreamDeviceParams.deviceId, mediaStreamDispatcherHostStopStreamDeviceParams.sessionId);
                        return true;
                    case 4:
                        mediaStreamDispatcherHostCloseDeviceParams = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostCloseDeviceParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).closeDevice(mediaStreamDispatcherHostCloseDeviceParams.label);
                        return true;
                    case 5:
                        mediaStreamDispatcherHostSetCapturingLinkSecuredParams = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostSetCapturingLinkSecuredParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).setCapturingLinkSecured(mediaStreamDispatcherHostSetCapturingLinkSecuredParams.sessionId, mediaStreamDispatcherHostSetCapturingLinkSecuredParams.type, mediaStreamDispatcherHostSetCapturingLinkSecuredParams.isSecure);
                        return true;
                    case 6:
                        data = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOnStreamStartedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).onStreamStarted(data.label);
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamParams mediaStreamDispatcherHostGenerateStreamParams;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), MediaStreamDispatcherHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        mediaStreamDispatcherHostGenerateStreamParams = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).generateStream(mediaStreamDispatcherHostGenerateStreamParams.requestId, mediaStreamDispatcherHostGenerateStreamParams.controls, mediaStreamDispatcherHostGenerateStreamParams.userGesture, new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamDispatcherHost)getImpl()).openDevice(data.requestId, data.deviceId, data.type, new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaStreamDispatcherHostGenerateStreamParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        public StreamControls controls;

        public boolean userGesture;

        private MediaStreamDispatcherHostGenerateStreamParams(int version) {
            super(24, version);
        }

        public MediaStreamDispatcherHostGenerateStreamParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostGenerateStreamParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostGenerateStreamParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostGenerateStreamParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostGenerateStreamParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostGenerateStreamParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                result.userGesture = decoder0.readBoolean(12, 0);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.controls = StreamControls.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
            encoder0.encode(this.userGesture, 12, 0);
            encoder0.encode(this.controls, 16, false);
        }
    }

    static final class MediaStreamDispatcherHostGenerateStreamResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        public String label;

        public MediaStreamDevice[] audioDevices;

        public MediaStreamDevice[] videoDevices;

        private MediaStreamDispatcherHostGenerateStreamResponseParams(int version) {
            super(40, version);
        }

        public MediaStreamDispatcherHostGenerateStreamResponseParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostGenerateStreamResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostGenerateStreamResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostGenerateStreamResponseParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostGenerateStreamResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostGenerateStreamResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                MediaStreamRequestResult.validate(result.result);
                result.label = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.audioDevices = new MediaStreamDevice[si1.elementsOrVersion];
                int i1;
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.audioDevices[i1] = MediaStreamDevice.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(32, false);
                si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.videoDevices = new MediaStreamDevice[si1.elementsOrVersion];
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.videoDevices[i1] = MediaStreamDevice.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
            encoder0.encode(this.label, 16, false);
            if (this.audioDevices == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.audioDevices.length, 24, -1);
                for (int i0 = 0; i0 < this.audioDevices.length; i0++)
                    encoder1.encode(this.audioDevices[i0], 8 + 8 * i0, false);
            }
            if (this.videoDevices == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.videoDevices.length, 32, -1);
                for (int i0 = 0; i0 < this.videoDevices.length; i0++)
                    encoder1.encode(this.videoDevices[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class MediaStreamDispatcherHostGenerateStreamResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaStreamDispatcherHost.GenerateStreamResponse mCallback;

        MediaStreamDispatcherHostGenerateStreamResponseParamsForwardToCallback(MediaStreamDispatcherHost.GenerateStreamResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamResponseParams response = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.label, response.audioDevices, response.videoDevices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaStreamDispatcherHostGenerateStreamResponseParamsProxyToResponder implements MediaStreamDispatcherHost.GenerateStreamResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaStreamDispatcherHostGenerateStreamResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result, String label, MediaStreamDevice[] audioDevices, MediaStreamDevice[] videoDevices) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamResponseParams _response = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostGenerateStreamResponseParams();
            _response.result = result.intValue();
            _response.label = label;
            _response.audioDevices = audioDevices;
            _response.videoDevices = videoDevices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaStreamDispatcherHostCancelRequestParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        private MediaStreamDispatcherHostCancelRequestParams(int version) {
            super(16, version);
        }

        public MediaStreamDispatcherHostCancelRequestParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostCancelRequestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostCancelRequestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostCancelRequestParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostCancelRequestParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostCancelRequestParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
        }
    }

    static final class MediaStreamDispatcherHostStopStreamDeviceParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String deviceId;

        public int sessionId;

        private MediaStreamDispatcherHostStopStreamDeviceParams(int version) {
            super(24, version);
        }

        public MediaStreamDispatcherHostStopStreamDeviceParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostStopStreamDeviceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostStopStreamDeviceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostStopStreamDeviceParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostStopStreamDeviceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostStopStreamDeviceParams(elementsOrVersion);
                result.deviceId = decoder0.readString(8, false);
                result.sessionId = decoder0.readInt(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceId, 8, false);
            encoder0.encode(this.sessionId, 16);
        }
    }

    static final class MediaStreamDispatcherHostOpenDeviceParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        public String deviceId;

        public int type;

        private MediaStreamDispatcherHostOpenDeviceParams(int version) {
            super(24, version);
        }

        public MediaStreamDispatcherHostOpenDeviceParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostOpenDeviceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostOpenDeviceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostOpenDeviceParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostOpenDeviceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostOpenDeviceParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                result.type = decoder0.readInt(12);
                MediaStreamType.validate(result.type);
                result.deviceId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
            encoder0.encode(this.type, 12);
            encoder0.encode(this.deviceId, 16, false);
        }
    }

    static final class MediaStreamDispatcherHostOpenDeviceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public String label;

        public MediaStreamDevice device;

        private MediaStreamDispatcherHostOpenDeviceResponseParams(int version) {
            super(32, version);
        }

        public MediaStreamDispatcherHostOpenDeviceResponseParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostOpenDeviceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostOpenDeviceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostOpenDeviceResponseParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostOpenDeviceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostOpenDeviceResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.label = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.device = MediaStreamDevice.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.label, 16, false);
            encoder0.encode(this.device, 24, false);
        }
    }

    static class MediaStreamDispatcherHostOpenDeviceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaStreamDispatcherHost.OpenDeviceResponse mCallback;

        MediaStreamDispatcherHostOpenDeviceResponseParamsForwardToCallback(MediaStreamDispatcherHost.OpenDeviceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceResponseParams response = MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.label, response.device);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaStreamDispatcherHostOpenDeviceResponseParamsProxyToResponder implements MediaStreamDispatcherHost.OpenDeviceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaStreamDispatcherHostOpenDeviceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, String label, MediaStreamDevice device) {
            MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceResponseParams _response = new MediaStreamDispatcherHost_Internal.MediaStreamDispatcherHostOpenDeviceResponseParams();
            _response.success = success.booleanValue();
            _response.label = label;
            _response.device = device;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaStreamDispatcherHostCloseDeviceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String label;

        private MediaStreamDispatcherHostCloseDeviceParams(int version) {
            super(16, version);
        }

        public MediaStreamDispatcherHostCloseDeviceParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostCloseDeviceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostCloseDeviceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostCloseDeviceParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostCloseDeviceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostCloseDeviceParams(elementsOrVersion);
                result.label = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.label, 8, false);
        }
    }

    static final class MediaStreamDispatcherHostSetCapturingLinkSecuredParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int sessionId;

        public int type;

        public boolean isSecure;

        private MediaStreamDispatcherHostSetCapturingLinkSecuredParams(int version) {
            super(24, version);
        }

        public MediaStreamDispatcherHostSetCapturingLinkSecuredParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostSetCapturingLinkSecuredParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostSetCapturingLinkSecuredParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostSetCapturingLinkSecuredParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostSetCapturingLinkSecuredParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostSetCapturingLinkSecuredParams(elementsOrVersion);
                result.sessionId = decoder0.readInt(8);
                result.type = decoder0.readInt(12);
                MediaStreamType.validate(result.type);
                result.isSecure = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8);
            encoder0.encode(this.type, 12);
            encoder0.encode(this.isSecure, 16, 0);
        }
    }

    static final class MediaStreamDispatcherHostOnStreamStartedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String label;

        private MediaStreamDispatcherHostOnStreamStartedParams(int version) {
            super(16, version);
        }

        public MediaStreamDispatcherHostOnStreamStartedParams() {
            this(0);
        }

        public static MediaStreamDispatcherHostOnStreamStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamDispatcherHostOnStreamStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamDispatcherHostOnStreamStartedParams decode(Decoder decoder0) {
            MediaStreamDispatcherHostOnStreamStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamDispatcherHostOnStreamStartedParams(elementsOrVersion);
                result.label = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.label, 8, false);
        }
    }
}
