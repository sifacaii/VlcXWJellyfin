package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.Geolocation;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class GeolocationService_Internal {
    public static final Interface.Manager<GeolocationService, GeolocationService.Proxy> MANAGER = new Interface.Manager<GeolocationService, GeolocationService.Proxy>() {
        public String getName() {
            return "blink.mojom.GeolocationService";
        }

        public int getVersion() {
            return 0;
        }

        public GeolocationService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new GeolocationService_Internal.Proxy(core, messageReceiver);
        }

        public GeolocationService_Internal.Stub buildStub(Core core, GeolocationService impl) {
            return new GeolocationService_Internal.Stub(core, impl);
        }

        public GeolocationService[] buildArray(int size) {
            return new GeolocationService[size];
        }
    };

    private static final int CREATE_GEOLOCATION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements GeolocationService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createGeolocation(InterfaceRequest<Geolocation> request, boolean userGesture, GeolocationService.CreateGeolocationResponse callback) {
            GeolocationService_Internal.GeolocationServiceCreateGeolocationParams _message = new GeolocationService_Internal.GeolocationServiceCreateGeolocationParams();
            _message.request = request;
            _message.userGesture = userGesture;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new GeolocationService_Internal.GeolocationServiceCreateGeolocationResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<GeolocationService> {
        Stub(Core core, GeolocationService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(GeolocationService_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                GeolocationService_Internal.GeolocationServiceCreateGeolocationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), GeolocationService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = GeolocationService_Internal.GeolocationServiceCreateGeolocationParams.deserialize(messageWithHeader.getPayload());
                        ((GeolocationService)getImpl()).createGeolocation(data.request, data.userGesture, new GeolocationService_Internal.GeolocationServiceCreateGeolocationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class GeolocationServiceCreateGeolocationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<Geolocation> request;

        public boolean userGesture;

        private GeolocationServiceCreateGeolocationParams(int version) {
            super(16, version);
        }

        public GeolocationServiceCreateGeolocationParams() {
            this(0);
        }

        public static GeolocationServiceCreateGeolocationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationServiceCreateGeolocationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationServiceCreateGeolocationParams decode(Decoder decoder0) {
            GeolocationServiceCreateGeolocationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationServiceCreateGeolocationParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
                result.userGesture = decoder0.readBoolean(12, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, false);
            encoder0.encode(this.userGesture, 12, 0);
        }
    }

    static final class GeolocationServiceCreateGeolocationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private GeolocationServiceCreateGeolocationResponseParams(int version) {
            super(16, version);
        }

        public GeolocationServiceCreateGeolocationResponseParams() {
            this(0);
        }

        public static GeolocationServiceCreateGeolocationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationServiceCreateGeolocationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationServiceCreateGeolocationResponseParams decode(Decoder decoder0) {
            GeolocationServiceCreateGeolocationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationServiceCreateGeolocationResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class GeolocationServiceCreateGeolocationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final GeolocationService.CreateGeolocationResponse mCallback;

        GeolocationServiceCreateGeolocationResponseParamsForwardToCallback(GeolocationService.CreateGeolocationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                GeolocationService_Internal.GeolocationServiceCreateGeolocationResponseParams response = GeolocationService_Internal.GeolocationServiceCreateGeolocationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class GeolocationServiceCreateGeolocationResponseParamsProxyToResponder implements GeolocationService.CreateGeolocationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        GeolocationServiceCreateGeolocationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            GeolocationService_Internal.GeolocationServiceCreateGeolocationResponseParams _response = new GeolocationService_Internal.GeolocationServiceCreateGeolocationResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
