package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoCaptureFormat;
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

class MediaDevicesDispatcherHost_Internal {
    public static final Interface.Manager<MediaDevicesDispatcherHost, MediaDevicesDispatcherHost.Proxy> MANAGER = new Interface.Manager<MediaDevicesDispatcherHost, MediaDevicesDispatcherHost.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaDevicesDispatcherHost";
        }

        public int getVersion() {
            return 0;
        }

        public MediaDevicesDispatcherHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaDevicesDispatcherHost_Internal.Proxy(core, messageReceiver);
        }

        public MediaDevicesDispatcherHost_Internal.Stub buildStub(Core core, MediaDevicesDispatcherHost impl) {
            return new MediaDevicesDispatcherHost_Internal.Stub(core, impl);
        }

        public MediaDevicesDispatcherHost[] buildArray(int size) {
            return new MediaDevicesDispatcherHost[size];
        }
    };

    private static final int ENUMERATE_DEVICES_ORDINAL = 0;

    private static final int GET_VIDEO_INPUT_CAPABILITIES_ORDINAL = 1;

    private static final int GET_ALL_VIDEO_INPUT_DEVICE_FORMATS_ORDINAL = 2;

    private static final int GET_AVAILABLE_VIDEO_INPUT_DEVICE_FORMATS_ORDINAL = 3;

    private static final int GET_AUDIO_INPUT_CAPABILITIES_ORDINAL = 4;

    private static final int ADD_MEDIA_DEVICES_LISTENER_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements MediaDevicesDispatcherHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void enumerateDevices(boolean requestAudioInput, boolean requestVideoInput, boolean requestAudioOutput, boolean requestVideoInputCapabilities, boolean requestAudioInputCapabilities, MediaDevicesDispatcherHost.EnumerateDevicesResponse callback) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesParams _message = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesParams();
            _message.requestAudioInput = requestAudioInput;
            _message.requestVideoInput = requestVideoInput;
            _message.requestAudioOutput = requestAudioOutput;
            _message.requestVideoInputCapabilities = requestVideoInputCapabilities;
            _message.requestAudioInputCapabilities = requestAudioInputCapabilities;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesResponseParamsForwardToCallback(callback));
        }

        public void getVideoInputCapabilities(MediaDevicesDispatcherHost.GetVideoInputCapabilitiesResponse callback) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams _message = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParamsForwardToCallback(callback));
        }

        public void getAllVideoInputDeviceFormats(String deviceId, MediaDevicesDispatcherHost.GetAllVideoInputDeviceFormatsResponse callback) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams _message = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams();
            _message.deviceId = deviceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParamsForwardToCallback(callback));
        }

        public void getAvailableVideoInputDeviceFormats(String deviceId, MediaDevicesDispatcherHost.GetAvailableVideoInputDeviceFormatsResponse callback) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams _message = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams();
            _message.deviceId = deviceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParamsForwardToCallback(callback));
        }

        public void getAudioInputCapabilities(MediaDevicesDispatcherHost.GetAudioInputCapabilitiesResponse callback) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams _message = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParamsForwardToCallback(callback));
        }

        public void addMediaDevicesListener(boolean subscribeAudioInput, boolean subscribeVideoInput, boolean subscribeAudioOutput, MediaDevicesListener listener) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostAddMediaDevicesListenerParams _message = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostAddMediaDevicesListenerParams();
            _message.subscribeAudioInput = subscribeAudioInput;
            _message.subscribeVideoInput = subscribeVideoInput;
            _message.subscribeAudioOutput = subscribeAudioOutput;
            _message.listener = listener;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    static final class Stub extends Interface.Stub<MediaDevicesDispatcherHost> {
        Stub(Core core, MediaDevicesDispatcherHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostAddMediaDevicesListenerParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaDevicesDispatcherHost_Internal.MANAGER, messageWithHeader);
                    case 5:
                        data = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostAddMediaDevicesListenerParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesDispatcherHost)getImpl()).addMediaDevicesListener(data.subscribeAudioInput, data.subscribeVideoInput, data.subscribeAudioOutput, data.listener);
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
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesParams mediaDevicesDispatcherHostEnumerateDevicesParams;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams mediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), MediaDevicesDispatcherHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        mediaDevicesDispatcherHostEnumerateDevicesParams = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesDispatcherHost)getImpl()).enumerateDevices(mediaDevicesDispatcherHostEnumerateDevicesParams.requestAudioInput, mediaDevicesDispatcherHostEnumerateDevicesParams.requestVideoInput, mediaDevicesDispatcherHostEnumerateDevicesParams.requestAudioOutput, mediaDevicesDispatcherHostEnumerateDevicesParams.requestVideoInputCapabilities, mediaDevicesDispatcherHostEnumerateDevicesParams.requestAudioInputCapabilities, new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesDispatcherHost)getImpl()).getVideoInputCapabilities(new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        mediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesDispatcherHost)getImpl()).getAllVideoInputDeviceFormats(mediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams.deviceId, new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesDispatcherHost)getImpl()).getAvailableVideoInputDeviceFormats(data.deviceId, new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams.deserialize(messageWithHeader.getPayload());
                        ((MediaDevicesDispatcherHost)getImpl()).getAudioInputCapabilities(new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaDevicesDispatcherHostEnumerateDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean requestAudioInput;

        public boolean requestVideoInput;

        public boolean requestAudioOutput;

        public boolean requestVideoInputCapabilities;

        public boolean requestAudioInputCapabilities;

        private MediaDevicesDispatcherHostEnumerateDevicesParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostEnumerateDevicesParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostEnumerateDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostEnumerateDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostEnumerateDevicesParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostEnumerateDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostEnumerateDevicesParams(elementsOrVersion);
                result.requestAudioInput = decoder0.readBoolean(8, 0);
                result.requestVideoInput = decoder0.readBoolean(8, 1);
                result.requestAudioOutput = decoder0.readBoolean(8, 2);
                result.requestVideoInputCapabilities = decoder0.readBoolean(8, 3);
                result.requestAudioInputCapabilities = decoder0.readBoolean(8, 4);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestAudioInput, 8, 0);
            encoder0.encode(this.requestVideoInput, 8, 1);
            encoder0.encode(this.requestAudioOutput, 8, 2);
            encoder0.encode(this.requestVideoInputCapabilities, 8, 3);
            encoder0.encode(this.requestAudioInputCapabilities, 8, 4);
        }
    }

    static final class MediaDevicesDispatcherHostEnumerateDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MediaDeviceInfo[][] enumeration;

        public VideoInputDeviceCapabilities[] videoInputDeviceCapabilities;

        public AudioInputDeviceCapabilities[] audioInputDeviceCapabilities;

        private MediaDevicesDispatcherHostEnumerateDevicesResponseParams(int version) {
            super(32, version);
        }

        public MediaDevicesDispatcherHostEnumerateDevicesResponseParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostEnumerateDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostEnumerateDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostEnumerateDevicesResponseParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostEnumerateDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostEnumerateDevicesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.enumeration = new MediaDeviceInfo[si1.elementsOrVersion][];
                int i1;
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
                    result.enumeration[i1] = new MediaDeviceInfo[si2.elementsOrVersion];
                    for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                        Decoder decoder3 = decoder2.readPointer(8 + 8 * i2, false);
                        result.enumeration[i1][i2] = MediaDeviceInfo.decode(decoder3);
                    }
                }
                decoder1 = decoder0.readPointer(16, false);
                si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.videoInputDeviceCapabilities = new VideoInputDeviceCapabilities[si1.elementsOrVersion];
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.videoInputDeviceCapabilities[i1] = VideoInputDeviceCapabilities.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(24, false);
                si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.audioInputDeviceCapabilities = new AudioInputDeviceCapabilities[si1.elementsOrVersion];
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.audioInputDeviceCapabilities[i1] = AudioInputDeviceCapabilities.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.enumeration == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.enumeration.length, 8, -1);
                for (int i0 = 0; i0 < this.enumeration.length; i0++) {
                    if (this.enumeration[i0] == null) {
                        encoder1.encodeNullPointer(8 + 8 * i0, false);
                    } else {
                        Encoder encoder2 = encoder1.encodePointerArray((this.enumeration[i0]).length, 8 + 8 * i0, -1);
                        for (int i1 = 0; i1 < (this.enumeration[i0]).length; i1++)
                            encoder2.encode(this.enumeration[i0][i1], 8 + 8 * i1, false);
                    }
                }
            }
            if (this.videoInputDeviceCapabilities == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.videoInputDeviceCapabilities.length, 16, -1);
                for (int i0 = 0; i0 < this.videoInputDeviceCapabilities.length; i0++)
                    encoder1.encode(this.videoInputDeviceCapabilities[i0], 8 + 8 * i0, false);
            }
            if (this.audioInputDeviceCapabilities == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.audioInputDeviceCapabilities.length, 24, -1);
                for (int i0 = 0; i0 < this.audioInputDeviceCapabilities.length; i0++)
                    encoder1.encode(this.audioInputDeviceCapabilities[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class MediaDevicesDispatcherHostEnumerateDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDevicesDispatcherHost.EnumerateDevicesResponse mCallback;

        MediaDevicesDispatcherHostEnumerateDevicesResponseParamsForwardToCallback(MediaDevicesDispatcherHost.EnumerateDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesResponseParams response = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.enumeration, response.videoInputDeviceCapabilities, response.audioInputDeviceCapabilities);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaDevicesDispatcherHostEnumerateDevicesResponseParamsProxyToResponder implements MediaDevicesDispatcherHost.EnumerateDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaDevicesDispatcherHostEnumerateDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(MediaDeviceInfo[][] enumeration, VideoInputDeviceCapabilities[] videoInputDeviceCapabilities, AudioInputDeviceCapabilities[] audioInputDeviceCapabilities) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesResponseParams _response = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostEnumerateDevicesResponseParams();
            _response.enumeration = enumeration;
            _response.videoInputDeviceCapabilities = videoInputDeviceCapabilities;
            _response.audioInputDeviceCapabilities = audioInputDeviceCapabilities;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams(int version) {
            super(8, version);
        }

        public MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetVideoInputCapabilitiesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VideoInputDeviceCapabilities[] videoInputDeviceCapabilities;

        private MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.videoInputDeviceCapabilities = new VideoInputDeviceCapabilities[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.videoInputDeviceCapabilities[i1] = VideoInputDeviceCapabilities.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.videoInputDeviceCapabilities == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.videoInputDeviceCapabilities.length, 8, -1);
                for (int i0 = 0; i0 < this.videoInputDeviceCapabilities.length; i0++)
                    encoder1.encode(this.videoInputDeviceCapabilities[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDevicesDispatcherHost.GetVideoInputCapabilitiesResponse mCallback;

        MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParamsForwardToCallback(MediaDevicesDispatcherHost.GetVideoInputCapabilitiesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams response = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.videoInputDeviceCapabilities);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParamsProxyToResponder implements MediaDevicesDispatcherHost.GetVideoInputCapabilitiesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(VideoInputDeviceCapabilities[] videoInputDeviceCapabilities) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams _response = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetVideoInputCapabilitiesResponseParams();
            _response.videoInputDeviceCapabilities = videoInputDeviceCapabilities;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String deviceId;

        private MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsParams(elementsOrVersion);
                result.deviceId = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceId, 8, false);
        }
    }

    static final class MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VideoCaptureFormat[] formats;

        private MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.formats = new VideoCaptureFormat[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.formats[i1] = VideoCaptureFormat.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.formats == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.formats.length, 8, -1);
                for (int i0 = 0; i0 < this.formats.length; i0++)
                    encoder1.encode((Struct)this.formats[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDevicesDispatcherHost.GetAllVideoInputDeviceFormatsResponse mCallback;

        MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParamsForwardToCallback(MediaDevicesDispatcherHost.GetAllVideoInputDeviceFormatsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams response = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.formats);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParamsProxyToResponder implements MediaDevicesDispatcherHost.GetAllVideoInputDeviceFormatsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(VideoCaptureFormat[] formats) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams _response = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAllVideoInputDeviceFormatsResponseParams();
            _response.formats = formats;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String deviceId;

        private MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsParams(elementsOrVersion);
                result.deviceId = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceId, 8, false);
        }
    }

    static final class MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VideoCaptureFormat[] formats;

        private MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.formats = new VideoCaptureFormat[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.formats[i1] = VideoCaptureFormat.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.formats == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.formats.length, 8, -1);
                for (int i0 = 0; i0 < this.formats.length; i0++)
                    encoder1.encode((Struct)this.formats[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDevicesDispatcherHost.GetAvailableVideoInputDeviceFormatsResponse mCallback;

        MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParamsForwardToCallback(MediaDevicesDispatcherHost.GetAvailableVideoInputDeviceFormatsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams response = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.formats);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParamsProxyToResponder implements MediaDevicesDispatcherHost.GetAvailableVideoInputDeviceFormatsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(VideoCaptureFormat[] formats) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams _response = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAvailableVideoInputDeviceFormatsResponseParams();
            _response.formats = formats;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams(int version) {
            super(8, version);
        }

        public MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetAudioInputCapabilitiesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioInputDeviceCapabilities[] audioInputDeviceCapabilities;

        private MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams(int version) {
            super(16, version);
        }

        public MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.audioInputDeviceCapabilities = new AudioInputDeviceCapabilities[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.audioInputDeviceCapabilities[i1] = AudioInputDeviceCapabilities.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.audioInputDeviceCapabilities == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.audioInputDeviceCapabilities.length, 8, -1);
                for (int i0 = 0; i0 < this.audioInputDeviceCapabilities.length; i0++)
                    encoder1.encode(this.audioInputDeviceCapabilities[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDevicesDispatcherHost.GetAudioInputCapabilitiesResponse mCallback;

        MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParamsForwardToCallback(MediaDevicesDispatcherHost.GetAudioInputCapabilitiesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams response = MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.audioInputDeviceCapabilities);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParamsProxyToResponder implements MediaDevicesDispatcherHost.GetAudioInputCapabilitiesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(AudioInputDeviceCapabilities[] audioInputDeviceCapabilities) {
            MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams _response = new MediaDevicesDispatcherHost_Internal.MediaDevicesDispatcherHostGetAudioInputCapabilitiesResponseParams();
            _response.audioInputDeviceCapabilities = audioInputDeviceCapabilities;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class MediaDevicesDispatcherHostAddMediaDevicesListenerParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean subscribeAudioInput;

        public boolean subscribeVideoInput;

        public boolean subscribeAudioOutput;

        public MediaDevicesListener listener;

        private MediaDevicesDispatcherHostAddMediaDevicesListenerParams(int version) {
            super(24, version);
        }

        public MediaDevicesDispatcherHostAddMediaDevicesListenerParams() {
            this(0);
        }

        public static MediaDevicesDispatcherHostAddMediaDevicesListenerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDevicesDispatcherHostAddMediaDevicesListenerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDevicesDispatcherHostAddMediaDevicesListenerParams decode(Decoder decoder0) {
            MediaDevicesDispatcherHostAddMediaDevicesListenerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaDevicesDispatcherHostAddMediaDevicesListenerParams(elementsOrVersion);
                result.subscribeAudioInput = decoder0.readBoolean(8, 0);
                result.subscribeVideoInput = decoder0.readBoolean(8, 1);
                result.subscribeAudioOutput = decoder0.readBoolean(8, 2);
                result.listener = (MediaDevicesListener)decoder0.readServiceInterface(12, false, MediaDevicesListener.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.subscribeAudioInput, 8, 0);
            encoder0.encode(this.subscribeVideoInput, 8, 1);
            encoder0.encode(this.subscribeAudioOutput, 8, 2);
            encoder0.encode(this.listener, 12, false, MediaDevicesListener.MANAGER);
        }
    }
}
