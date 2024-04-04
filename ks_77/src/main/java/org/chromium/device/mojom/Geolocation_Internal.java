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

class Geolocation_Internal {
    public static final Interface.Manager<Geolocation, Geolocation.Proxy> MANAGER = new Interface.Manager<Geolocation, Geolocation.Proxy>() {
        public String getName() {
            return "device.mojom.Geolocation";
        }

        public int getVersion() {
            return 0;
        }

        public Geolocation_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Geolocation_Internal.Proxy(core, messageReceiver);
        }

        public Geolocation_Internal.Stub buildStub(Core core, Geolocation impl) {
            return new Geolocation_Internal.Stub(core, impl);
        }

        public Geolocation[] buildArray(int size) {
            return new Geolocation[size];
        }
    };

    private static final int SET_HIGH_ACCURACY_ORDINAL = 0;

    private static final int QUERY_NEXT_POSITION_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements Geolocation.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setHighAccuracy(boolean highAccuracy) {
            Geolocation_Internal.GeolocationSetHighAccuracyParams _message = new Geolocation_Internal.GeolocationSetHighAccuracyParams();
            _message.highAccuracy = highAccuracy;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void queryNextPosition(Geolocation.QueryNextPositionResponse callback) {
            Geolocation_Internal.GeolocationQueryNextPositionParams _message = new Geolocation_Internal.GeolocationQueryNextPositionParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new Geolocation_Internal.GeolocationQueryNextPositionResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<Geolocation> {
        Stub(Core core, Geolocation impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Geolocation_Internal.GeolocationSetHighAccuracyParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Geolocation_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = Geolocation_Internal.GeolocationSetHighAccuracyParams.deserialize(messageWithHeader.getPayload());
                        ((Geolocation)getImpl()).setHighAccuracy(data.highAccuracy);
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
                                getCore(), Geolocation_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        Geolocation_Internal.GeolocationQueryNextPositionParams.deserialize(messageWithHeader.getPayload());
                        ((Geolocation)getImpl()).queryNextPosition(new Geolocation_Internal.GeolocationQueryNextPositionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class GeolocationSetHighAccuracyParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean highAccuracy;

        private GeolocationSetHighAccuracyParams(int version) {
            super(16, version);
        }

        public GeolocationSetHighAccuracyParams() {
            this(0);
        }

        public static GeolocationSetHighAccuracyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationSetHighAccuracyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationSetHighAccuracyParams decode(Decoder decoder0) {
            GeolocationSetHighAccuracyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationSetHighAccuracyParams(elementsOrVersion);
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

    static final class GeolocationQueryNextPositionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GeolocationQueryNextPositionParams(int version) {
            super(8, version);
        }

        public GeolocationQueryNextPositionParams() {
            this(0);
        }

        public static GeolocationQueryNextPositionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationQueryNextPositionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationQueryNextPositionParams decode(Decoder decoder0) {
            GeolocationQueryNextPositionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationQueryNextPositionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class GeolocationQueryNextPositionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Geoposition geoposition;

        private GeolocationQueryNextPositionResponseParams(int version) {
            super(16, version);
        }

        public GeolocationQueryNextPositionResponseParams() {
            this(0);
        }

        public static GeolocationQueryNextPositionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationQueryNextPositionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationQueryNextPositionResponseParams decode(Decoder decoder0) {
            GeolocationQueryNextPositionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationQueryNextPositionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.geoposition = Geoposition.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.geoposition, 8, false);
        }
    }

    static class GeolocationQueryNextPositionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Geolocation.QueryNextPositionResponse mCallback;

        GeolocationQueryNextPositionResponseParamsForwardToCallback(Geolocation.QueryNextPositionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                Geolocation_Internal.GeolocationQueryNextPositionResponseParams response = Geolocation_Internal.GeolocationQueryNextPositionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.geoposition);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class GeolocationQueryNextPositionResponseParamsProxyToResponder implements Geolocation.QueryNextPositionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        GeolocationQueryNextPositionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Geoposition geoposition) {
            Geolocation_Internal.GeolocationQueryNextPositionResponseParams _response = new Geolocation_Internal.GeolocationQueryNextPositionResponseParams();
            _response.geoposition = geoposition;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
