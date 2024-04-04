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
import org.chromium.url.mojom.Url;

class PresentationService_Internal {
    public static final Interface.Manager<PresentationService, PresentationService.Proxy> MANAGER = new Interface.Manager<PresentationService, PresentationService.Proxy>() {
        public String getName() {
            return "blink.mojom.PresentationService";
        }

        public int getVersion() {
            return 0;
        }

        public PresentationService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PresentationService_Internal.Proxy(core, messageReceiver);
        }

        public PresentationService_Internal.Stub buildStub(Core core, PresentationService impl) {
            return new PresentationService_Internal.Stub(core, impl);
        }

        public PresentationService[] buildArray(int size) {
            return new PresentationService[size];
        }
    };

    private static final int SET_CONTROLLER_ORDINAL = 0;

    private static final int SET_RECEIVER_ORDINAL = 1;

    private static final int SET_DEFAULT_PRESENTATION_URLS_ORDINAL = 2;

    private static final int LISTEN_FOR_SCREEN_AVAILABILITY_ORDINAL = 3;

    private static final int STOP_LISTENING_FOR_SCREEN_AVAILABILITY_ORDINAL = 4;

    private static final int START_PRESENTATION_ORDINAL = 5;

    private static final int RECONNECT_PRESENTATION_ORDINAL = 6;

    private static final int CLOSE_CONNECTION_ORDINAL = 7;

    private static final int TERMINATE_ORDINAL = 8;

    static final class Proxy extends Interface.AbstractProxy implements PresentationService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setController(PresentationController controller) {
            PresentationService_Internal.PresentationServiceSetControllerParams _message = new PresentationService_Internal.PresentationServiceSetControllerParams();
            _message.controller = controller;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setReceiver(PresentationReceiver receiver) {
            PresentationService_Internal.PresentationServiceSetReceiverParams _message = new PresentationService_Internal.PresentationServiceSetReceiverParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void setDefaultPresentationUrls(Url[] presentationUrls) {
            PresentationService_Internal.PresentationServiceSetDefaultPresentationUrlsParams _message = new PresentationService_Internal.PresentationServiceSetDefaultPresentationUrlsParams();
            _message.presentationUrls = presentationUrls;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void listenForScreenAvailability(Url availabilityUrl) {
            PresentationService_Internal.PresentationServiceListenForScreenAvailabilityParams _message = new PresentationService_Internal.PresentationServiceListenForScreenAvailabilityParams();
            _message.availabilityUrl = availabilityUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void stopListeningForScreenAvailability(Url availabilityUrl) {
            PresentationService_Internal.PresentationServiceStopListeningForScreenAvailabilityParams _message = new PresentationService_Internal.PresentationServiceStopListeningForScreenAvailabilityParams();
            _message.availabilityUrl = availabilityUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void startPresentation(Url[] presentationUrls, PresentationService.StartPresentationResponse callback) {
            PresentationService_Internal.PresentationServiceStartPresentationParams _message = new PresentationService_Internal.PresentationServiceStartPresentationParams();
            _message.presentationUrls = presentationUrls;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new PresentationService_Internal.PresentationServiceStartPresentationResponseParamsForwardToCallback(callback));
        }

        public void reconnectPresentation(Url[] presentationUrls, String presentationId, PresentationService.ReconnectPresentationResponse callback) {
            PresentationService_Internal.PresentationServiceReconnectPresentationParams _message = new PresentationService_Internal.PresentationServiceReconnectPresentationParams();
            _message.presentationUrls = presentationUrls;
            _message.presentationId = presentationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new PresentationService_Internal.PresentationServiceReconnectPresentationResponseParamsForwardToCallback(callback));
        }

        public void closeConnection(Url presentationUrl, String presentationId) {
            PresentationService_Internal.PresentationServiceCloseConnectionParams _message = new PresentationService_Internal.PresentationServiceCloseConnectionParams();
            _message.presentationUrl = presentationUrl;
            _message.presentationId = presentationId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }

        public void terminate(Url presentationUrl, String presentationId) {
            PresentationService_Internal.PresentationServiceTerminateParams _message = new PresentationService_Internal.PresentationServiceTerminateParams();
            _message.presentationUrl = presentationUrl;
            _message.presentationId = presentationId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }
    }

    static final class Stub extends Interface.Stub<PresentationService> {
        Stub(Core core, PresentationService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PresentationService_Internal.PresentationServiceSetControllerParams presentationServiceSetControllerParams;
                PresentationService_Internal.PresentationServiceSetReceiverParams presentationServiceSetReceiverParams;
                PresentationService_Internal.PresentationServiceSetDefaultPresentationUrlsParams presentationServiceSetDefaultPresentationUrlsParams;
                PresentationService_Internal.PresentationServiceListenForScreenAvailabilityParams presentationServiceListenForScreenAvailabilityParams;
                PresentationService_Internal.PresentationServiceStopListeningForScreenAvailabilityParams presentationServiceStopListeningForScreenAvailabilityParams;
                PresentationService_Internal.PresentationServiceCloseConnectionParams presentationServiceCloseConnectionParams;
                PresentationService_Internal.PresentationServiceTerminateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PresentationService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        presentationServiceSetControllerParams = PresentationService_Internal.PresentationServiceSetControllerParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).setController(presentationServiceSetControllerParams.controller);
                        return true;
                    case 1:
                        presentationServiceSetReceiverParams = PresentationService_Internal.PresentationServiceSetReceiverParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).setReceiver(presentationServiceSetReceiverParams.receiver);
                        return true;
                    case 2:
                        presentationServiceSetDefaultPresentationUrlsParams = PresentationService_Internal.PresentationServiceSetDefaultPresentationUrlsParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).setDefaultPresentationUrls(presentationServiceSetDefaultPresentationUrlsParams.presentationUrls);
                        return true;
                    case 3:
                        presentationServiceListenForScreenAvailabilityParams = PresentationService_Internal.PresentationServiceListenForScreenAvailabilityParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).listenForScreenAvailability(presentationServiceListenForScreenAvailabilityParams.availabilityUrl);
                        return true;
                    case 4:
                        presentationServiceStopListeningForScreenAvailabilityParams = PresentationService_Internal.PresentationServiceStopListeningForScreenAvailabilityParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).stopListeningForScreenAvailability(presentationServiceStopListeningForScreenAvailabilityParams.availabilityUrl);
                        return true;
                    case 7:
                        presentationServiceCloseConnectionParams = PresentationService_Internal.PresentationServiceCloseConnectionParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).closeConnection(presentationServiceCloseConnectionParams.presentationUrl, presentationServiceCloseConnectionParams.presentationId);
                        return true;
                    case 8:
                        data = PresentationService_Internal.PresentationServiceTerminateParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).terminate(data.presentationUrl, data.presentationId);
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
                PresentationService_Internal.PresentationServiceStartPresentationParams presentationServiceStartPresentationParams;
                PresentationService_Internal.PresentationServiceReconnectPresentationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PresentationService_Internal.MANAGER, messageWithHeader, receiver);
                    case 5:
                        presentationServiceStartPresentationParams = PresentationService_Internal.PresentationServiceStartPresentationParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).startPresentation(presentationServiceStartPresentationParams.presentationUrls, new PresentationService_Internal.PresentationServiceStartPresentationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        data = PresentationService_Internal.PresentationServiceReconnectPresentationParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationService)getImpl()).reconnectPresentation(data.presentationUrls, data.presentationId, new PresentationService_Internal.PresentationServiceReconnectPresentationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PresentationServiceSetControllerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationController controller;

        private PresentationServiceSetControllerParams(int version) {
            super(16, version);
        }

        public PresentationServiceSetControllerParams() {
            this(0);
        }

        public static PresentationServiceSetControllerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceSetControllerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceSetControllerParams decode(Decoder decoder0) {
            PresentationServiceSetControllerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceSetControllerParams(elementsOrVersion);
                result.controller = (PresentationController)decoder0.readServiceInterface(8, false, PresentationController.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.controller, 8, false, PresentationController.MANAGER);
        }
    }

    static final class PresentationServiceSetReceiverParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationReceiver receiver;

        private PresentationServiceSetReceiverParams(int version) {
            super(16, version);
        }

        public PresentationServiceSetReceiverParams() {
            this(0);
        }

        public static PresentationServiceSetReceiverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceSetReceiverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceSetReceiverParams decode(Decoder decoder0) {
            PresentationServiceSetReceiverParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceSetReceiverParams(elementsOrVersion);
                result.receiver = (PresentationReceiver)decoder0.readServiceInterface(8, false, PresentationReceiver.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false, PresentationReceiver.MANAGER);
        }
    }

    static final class PresentationServiceSetDefaultPresentationUrlsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url[] presentationUrls;

        private PresentationServiceSetDefaultPresentationUrlsParams(int version) {
            super(16, version);
        }

        public PresentationServiceSetDefaultPresentationUrlsParams() {
            this(0);
        }

        public static PresentationServiceSetDefaultPresentationUrlsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceSetDefaultPresentationUrlsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceSetDefaultPresentationUrlsParams decode(Decoder decoder0) {
            PresentationServiceSetDefaultPresentationUrlsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceSetDefaultPresentationUrlsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.presentationUrls = new Url[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.presentationUrls[i1] = Url.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.presentationUrls == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.presentationUrls.length, 8, -1);
                for (int i0 = 0; i0 < this.presentationUrls.length; i0++)
                    encoder1.encode((Struct)this.presentationUrls[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class PresentationServiceListenForScreenAvailabilityParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url availabilityUrl;

        private PresentationServiceListenForScreenAvailabilityParams(int version) {
            super(16, version);
        }

        public PresentationServiceListenForScreenAvailabilityParams() {
            this(0);
        }

        public static PresentationServiceListenForScreenAvailabilityParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceListenForScreenAvailabilityParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceListenForScreenAvailabilityParams decode(Decoder decoder0) {
            PresentationServiceListenForScreenAvailabilityParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceListenForScreenAvailabilityParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.availabilityUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.availabilityUrl, 8, false);
        }
    }

    static final class PresentationServiceStopListeningForScreenAvailabilityParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url availabilityUrl;

        private PresentationServiceStopListeningForScreenAvailabilityParams(int version) {
            super(16, version);
        }

        public PresentationServiceStopListeningForScreenAvailabilityParams() {
            this(0);
        }

        public static PresentationServiceStopListeningForScreenAvailabilityParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceStopListeningForScreenAvailabilityParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceStopListeningForScreenAvailabilityParams decode(Decoder decoder0) {
            PresentationServiceStopListeningForScreenAvailabilityParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceStopListeningForScreenAvailabilityParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.availabilityUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.availabilityUrl, 8, false);
        }
    }

    static final class PresentationServiceStartPresentationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url[] presentationUrls;

        private PresentationServiceStartPresentationParams(int version) {
            super(16, version);
        }

        public PresentationServiceStartPresentationParams() {
            this(0);
        }

        public static PresentationServiceStartPresentationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceStartPresentationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceStartPresentationParams decode(Decoder decoder0) {
            PresentationServiceStartPresentationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceStartPresentationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.presentationUrls = new Url[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.presentationUrls[i1] = Url.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.presentationUrls == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.presentationUrls.length, 8, -1);
                for (int i0 = 0; i0 < this.presentationUrls.length; i0++)
                    encoder1.encode((Struct)this.presentationUrls[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class PresentationServiceStartPresentationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationConnectionResult result;

        public PresentationError error;

        private PresentationServiceStartPresentationResponseParams(int version) {
            super(24, version);
        }

        public PresentationServiceStartPresentationResponseParams() {
            this(0);
        }

        public static PresentationServiceStartPresentationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceStartPresentationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceStartPresentationResponseParams decode(Decoder decoder0) {
            PresentationServiceStartPresentationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceStartPresentationResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.result = PresentationConnectionResult.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.error = PresentationError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, true);
            encoder0.encode(this.error, 16, true);
        }
    }

    static class PresentationServiceStartPresentationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PresentationService.StartPresentationResponse mCallback;

        PresentationServiceStartPresentationResponseParamsForwardToCallback(PresentationService.StartPresentationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                PresentationService_Internal.PresentationServiceStartPresentationResponseParams response = PresentationService_Internal.PresentationServiceStartPresentationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PresentationServiceStartPresentationResponseParamsProxyToResponder implements PresentationService.StartPresentationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PresentationServiceStartPresentationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(PresentationConnectionResult result, PresentationError error) {
            PresentationService_Internal.PresentationServiceStartPresentationResponseParams _response = new PresentationService_Internal.PresentationServiceStartPresentationResponseParams();
            _response.result = result;
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PresentationServiceReconnectPresentationParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url[] presentationUrls;

        public String presentationId;

        private PresentationServiceReconnectPresentationParams(int version) {
            super(24, version);
        }

        public PresentationServiceReconnectPresentationParams() {
            this(0);
        }

        public static PresentationServiceReconnectPresentationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceReconnectPresentationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceReconnectPresentationParams decode(Decoder decoder0) {
            PresentationServiceReconnectPresentationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceReconnectPresentationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.presentationUrls = new Url[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.presentationUrls[i1] = Url.decode(decoder2);
                }
                result.presentationId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.presentationUrls == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.presentationUrls.length, 8, -1);
                for (int i0 = 0; i0 < this.presentationUrls.length; i0++)
                    encoder1.encode((Struct)this.presentationUrls[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.presentationId, 16, false);
        }
    }

    static final class PresentationServiceReconnectPresentationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationConnectionResult result;

        public PresentationError error;

        private PresentationServiceReconnectPresentationResponseParams(int version) {
            super(24, version);
        }

        public PresentationServiceReconnectPresentationResponseParams() {
            this(0);
        }

        public static PresentationServiceReconnectPresentationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceReconnectPresentationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceReconnectPresentationResponseParams decode(Decoder decoder0) {
            PresentationServiceReconnectPresentationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceReconnectPresentationResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.result = PresentationConnectionResult.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.error = PresentationError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, true);
            encoder0.encode(this.error, 16, true);
        }
    }

    static class PresentationServiceReconnectPresentationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PresentationService.ReconnectPresentationResponse mCallback;

        PresentationServiceReconnectPresentationResponseParamsForwardToCallback(PresentationService.ReconnectPresentationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                PresentationService_Internal.PresentationServiceReconnectPresentationResponseParams response = PresentationService_Internal.PresentationServiceReconnectPresentationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PresentationServiceReconnectPresentationResponseParamsProxyToResponder implements PresentationService.ReconnectPresentationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PresentationServiceReconnectPresentationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(PresentationConnectionResult result, PresentationError error) {
            PresentationService_Internal.PresentationServiceReconnectPresentationResponseParams _response = new PresentationService_Internal.PresentationServiceReconnectPresentationResponseParams();
            _response.result = result;
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PresentationServiceCloseConnectionParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url presentationUrl;

        public String presentationId;

        private PresentationServiceCloseConnectionParams(int version) {
            super(24, version);
        }

        public PresentationServiceCloseConnectionParams() {
            this(0);
        }

        public static PresentationServiceCloseConnectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceCloseConnectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceCloseConnectionParams decode(Decoder decoder0) {
            PresentationServiceCloseConnectionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceCloseConnectionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.presentationUrl = Url.decode(decoder1);
                result.presentationId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.presentationUrl, 8, false);
            encoder0.encode(this.presentationId, 16, false);
        }
    }

    static final class PresentationServiceTerminateParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url presentationUrl;

        public String presentationId;

        private PresentationServiceTerminateParams(int version) {
            super(24, version);
        }

        public PresentationServiceTerminateParams() {
            this(0);
        }

        public static PresentationServiceTerminateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationServiceTerminateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationServiceTerminateParams decode(Decoder decoder0) {
            PresentationServiceTerminateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationServiceTerminateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.presentationUrl = Url.decode(decoder1);
                result.presentationId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.presentationUrl, 8, false);
            encoder0.encode(this.presentationId, 16, false);
        }
    }
}
