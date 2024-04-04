package org.chromium.device.mojom;

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

class GeolocationConfig_Internal {
    public static final Interface.Manager<GeolocationConfig, GeolocationConfig.Proxy> MANAGER = new Interface.Manager<GeolocationConfig, GeolocationConfig.Proxy>() {
        public String getName() {
            return "device.mojom.GeolocationConfig";
        }

        public int getVersion() {
            return 0;
        }

        public GeolocationConfig_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new GeolocationConfig_Internal.Proxy(core, messageReceiver);
        }

        public GeolocationConfig_Internal.Stub buildStub(Core core, GeolocationConfig impl) {
            return new GeolocationConfig_Internal.Stub(core, impl);
        }

        public GeolocationConfig[] buildArray(int size) {
            return new GeolocationConfig[size];
        }
    };

    private static final int IS_HIGH_ACCURACY_LOCATION_BEING_CAPTURED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements GeolocationConfig.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void isHighAccuracyLocationBeingCaptured(GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse callback) {
            GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedParams _message = new GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<GeolocationConfig> {
        Stub(Core core, GeolocationConfig impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(GeolocationConfig_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), GeolocationConfig_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedParams.deserialize(messageWithHeader.getPayload());
                        ((GeolocationConfig)getImpl()).isHighAccuracyLocationBeingCaptured(new GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class GeolocationConfigIsHighAccuracyLocationBeingCapturedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GeolocationConfigIsHighAccuracyLocationBeingCapturedParams(int version) {
            super(8, version);
        }

        public GeolocationConfigIsHighAccuracyLocationBeingCapturedParams() {
            this(0);
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedParams decode(Decoder decoder0) {
            GeolocationConfigIsHighAccuracyLocationBeingCapturedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationConfigIsHighAccuracyLocationBeingCapturedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean highAccuracy;

        private GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams(int version) {
            super(16, version);
        }

        public GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams() {
            this(0);
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams decode(Decoder decoder0) {
            GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams(elementsOrVersion);
                result.highAccuracy = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.highAccuracy, 8, 0);
        }
    }

    static class GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse mCallback;

        GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsForwardToCallback(GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams response = GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.highAccuracy));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsProxyToResponder implements GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean highAccuracy) {
            GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams _response = new GeolocationConfig_Internal.GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams();
            _response.highAccuracy = highAccuracy.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
