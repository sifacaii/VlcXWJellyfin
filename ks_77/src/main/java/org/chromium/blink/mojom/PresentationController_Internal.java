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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.url.mojom.Url;

class PresentationController_Internal {
    public static final Interface.Manager<PresentationController, PresentationController.Proxy> MANAGER = new Interface.Manager<PresentationController, PresentationController.Proxy>() {
        public String getName() {
            return "blink.mojom.PresentationController";
        }

        public int getVersion() {
            return 0;
        }

        public PresentationController_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PresentationController_Internal.Proxy(core, messageReceiver);
        }

        public PresentationController_Internal.Stub buildStub(Core core, PresentationController impl) {
            return new PresentationController_Internal.Stub(core, impl);
        }

        public PresentationController[] buildArray(int size) {
            return new PresentationController[size];
        }
    };

    private static final int ON_SCREEN_AVAILABILITY_UPDATED_ORDINAL = 0;

    private static final int ON_DEFAULT_PRESENTATION_STARTED_ORDINAL = 1;

    private static final int ON_CONNECTION_STATE_CHANGED_ORDINAL = 2;

    private static final int ON_CONNECTION_CLOSED_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements PresentationController.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onScreenAvailabilityUpdated(Url url, int availability) {
            PresentationController_Internal.PresentationControllerOnScreenAvailabilityUpdatedParams _message = new PresentationController_Internal.PresentationControllerOnScreenAvailabilityUpdatedParams();
            _message.url = url;
            _message.availability = availability;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onDefaultPresentationStarted(PresentationConnectionResult result) {
            PresentationController_Internal.PresentationControllerOnDefaultPresentationStartedParams _message = new PresentationController_Internal.PresentationControllerOnDefaultPresentationStartedParams();
            _message.result = result;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onConnectionStateChanged(PresentationInfo presentationInfo, int newState) {
            PresentationController_Internal.PresentationControllerOnConnectionStateChangedParams _message = new PresentationController_Internal.PresentationControllerOnConnectionStateChangedParams();
            _message.presentationInfo = presentationInfo;
            _message.newState = newState;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onConnectionClosed(PresentationInfo presentationInfo, int reason, String message) {
            PresentationController_Internal.PresentationControllerOnConnectionClosedParams _message = new PresentationController_Internal.PresentationControllerOnConnectionClosedParams();
            _message.presentationInfo = presentationInfo;
            _message.reason = reason;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<PresentationController> {
        Stub(Core core, PresentationController impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PresentationController_Internal.PresentationControllerOnScreenAvailabilityUpdatedParams presentationControllerOnScreenAvailabilityUpdatedParams;
                PresentationController_Internal.PresentationControllerOnDefaultPresentationStartedParams presentationControllerOnDefaultPresentationStartedParams;
                PresentationController_Internal.PresentationControllerOnConnectionStateChangedParams presentationControllerOnConnectionStateChangedParams;
                PresentationController_Internal.PresentationControllerOnConnectionClosedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PresentationController_Internal.MANAGER, messageWithHeader);
                    case 0:
                        presentationControllerOnScreenAvailabilityUpdatedParams = PresentationController_Internal.PresentationControllerOnScreenAvailabilityUpdatedParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationController)getImpl()).onScreenAvailabilityUpdated(presentationControllerOnScreenAvailabilityUpdatedParams.url, presentationControllerOnScreenAvailabilityUpdatedParams.availability);
                        return true;
                    case 1:
                        presentationControllerOnDefaultPresentationStartedParams = PresentationController_Internal.PresentationControllerOnDefaultPresentationStartedParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationController)getImpl()).onDefaultPresentationStarted(presentationControllerOnDefaultPresentationStartedParams.result);
                        return true;
                    case 2:
                        presentationControllerOnConnectionStateChangedParams = PresentationController_Internal.PresentationControllerOnConnectionStateChangedParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationController)getImpl()).onConnectionStateChanged(presentationControllerOnConnectionStateChangedParams.presentationInfo, presentationControllerOnConnectionStateChangedParams.newState);
                        return true;
                    case 3:
                        data = PresentationController_Internal.PresentationControllerOnConnectionClosedParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationController)getImpl()).onConnectionClosed(data.presentationInfo, data.reason, data.message);
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
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PresentationController_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PresentationControllerOnScreenAvailabilityUpdatedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public int availability;

        private PresentationControllerOnScreenAvailabilityUpdatedParams(int version) {
            super(24, version);
        }

        public PresentationControllerOnScreenAvailabilityUpdatedParams() {
            this(0);
        }

        public static PresentationControllerOnScreenAvailabilityUpdatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationControllerOnScreenAvailabilityUpdatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationControllerOnScreenAvailabilityUpdatedParams decode(Decoder decoder0) {
            PresentationControllerOnScreenAvailabilityUpdatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnScreenAvailabilityUpdatedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.availability = decoder0.readInt(16);
                ScreenAvailability.validate(result.availability);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.availability, 16);
        }
    }

    static final class PresentationControllerOnDefaultPresentationStartedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationConnectionResult result;

        private PresentationControllerOnDefaultPresentationStartedParams(int version) {
            super(16, version);
        }

        public PresentationControllerOnDefaultPresentationStartedParams() {
            this(0);
        }

        public static PresentationControllerOnDefaultPresentationStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationControllerOnDefaultPresentationStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationControllerOnDefaultPresentationStartedParams decode(Decoder decoder0) {
            PresentationControllerOnDefaultPresentationStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnDefaultPresentationStartedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = PresentationConnectionResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static final class PresentationControllerOnConnectionStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationInfo presentationInfo;

        public int newState;

        private PresentationControllerOnConnectionStateChangedParams(int version) {
            super(24, version);
        }

        public PresentationControllerOnConnectionStateChangedParams() {
            this(0);
        }

        public static PresentationControllerOnConnectionStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationControllerOnConnectionStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationControllerOnConnectionStateChangedParams decode(Decoder decoder0) {
            PresentationControllerOnConnectionStateChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnConnectionStateChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.presentationInfo = PresentationInfo.decode(decoder1);
                result.newState = decoder0.readInt(16);
                PresentationConnectionState.validate(result.newState);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.presentationInfo, 8, false);
            encoder0.encode(this.newState, 16);
        }
    }

    static final class PresentationControllerOnConnectionClosedParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationInfo presentationInfo;

        public int reason;

        public String message;

        private PresentationControllerOnConnectionClosedParams(int version) {
            super(32, version);
        }

        public PresentationControllerOnConnectionClosedParams() {
            this(0);
        }

        public static PresentationControllerOnConnectionClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationControllerOnConnectionClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationControllerOnConnectionClosedParams decode(Decoder decoder0) {
            PresentationControllerOnConnectionClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationControllerOnConnectionClosedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.presentationInfo = PresentationInfo.decode(decoder1);
                result.reason = decoder0.readInt(16);
                PresentationConnectionCloseReason.validate(result.reason);
                result.message = decoder0.readString(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.presentationInfo, 8, false);
            encoder0.encode(this.reason, 16);
            encoder0.encode(this.message, 24, false);
        }
    }
}
