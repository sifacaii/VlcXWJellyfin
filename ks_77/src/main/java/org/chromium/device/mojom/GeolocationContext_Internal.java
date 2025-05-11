package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class GeolocationContext_Internal {
    public static final Interface.Manager<GeolocationContext, GeolocationContext.Proxy> MANAGER = new Interface.Manager<GeolocationContext, GeolocationContext.Proxy>() {
        public String getName() {
            return "device.mojom.GeolocationContext";
        }

        public int getVersion() {
            return 0;
        }

        public GeolocationContext_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new GeolocationContext_Internal.Proxy(core, messageReceiver);
        }

        public GeolocationContext_Internal.Stub buildStub(Core core, GeolocationContext impl) {
            return new GeolocationContext_Internal.Stub(core, impl);
        }

        public GeolocationContext[] buildArray(int size) {
            return new GeolocationContext[size];
        }
    };

    private static final int BIND_GEOLOCATION_ORDINAL = 0;

    private static final int SET_OVERRIDE_ORDINAL = 1;

    private static final int CLEAR_OVERRIDE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements GeolocationContext.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void bindGeolocation(InterfaceRequest<Geolocation> request) {
            GeolocationContext_Internal.GeolocationContextBindGeolocationParams _message = new GeolocationContext_Internal.GeolocationContextBindGeolocationParams();
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setOverride(Geoposition geoposition) {
            GeolocationContext_Internal.GeolocationContextSetOverrideParams _message = new GeolocationContext_Internal.GeolocationContextSetOverrideParams();
            _message.geoposition = geoposition;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void clearOverride() {
            GeolocationContext_Internal.GeolocationContextClearOverrideParams _message = new GeolocationContext_Internal.GeolocationContextClearOverrideParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<GeolocationContext> {
        Stub(Core core, GeolocationContext impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                GeolocationContext_Internal.GeolocationContextBindGeolocationParams geolocationContextBindGeolocationParams;
                GeolocationContext_Internal.GeolocationContextSetOverrideParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(GeolocationContext_Internal.MANAGER, messageWithHeader);
                    case 0:
                        geolocationContextBindGeolocationParams = GeolocationContext_Internal.GeolocationContextBindGeolocationParams.deserialize(messageWithHeader.getPayload());
                        ((GeolocationContext)getImpl()).bindGeolocation(geolocationContextBindGeolocationParams.request);
                        return true;
                    case 1:
                        data = GeolocationContext_Internal.GeolocationContextSetOverrideParams.deserialize(messageWithHeader.getPayload());
                        ((GeolocationContext)getImpl()).setOverride(data.geoposition);
                        return true;
                    case 2:
                        GeolocationContext_Internal.GeolocationContextClearOverrideParams.deserialize(messageWithHeader.getPayload());
                        ((GeolocationContext)getImpl()).clearOverride();
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
                                getCore(), GeolocationContext_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class GeolocationContextBindGeolocationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<Geolocation> request;

        private GeolocationContextBindGeolocationParams(int version) {
            super(16, version);
        }

        public GeolocationContextBindGeolocationParams() {
            this(0);
        }

        public static GeolocationContextBindGeolocationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationContextBindGeolocationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationContextBindGeolocationParams decode(Decoder decoder0) {
            GeolocationContextBindGeolocationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationContextBindGeolocationParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, false);
        }
    }

    static final class GeolocationContextSetOverrideParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Geoposition geoposition;

        private GeolocationContextSetOverrideParams(int version) {
            super(16, version);
        }

        public GeolocationContextSetOverrideParams() {
            this(0);
        }

        public static GeolocationContextSetOverrideParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationContextSetOverrideParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationContextSetOverrideParams decode(Decoder decoder0) {
            GeolocationContextSetOverrideParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationContextSetOverrideParams(elementsOrVersion);
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

    static final class GeolocationContextClearOverrideParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GeolocationContextClearOverrideParams(int version) {
            super(8, version);
        }

        public GeolocationContextClearOverrideParams() {
            this(0);
        }

        public static GeolocationContextClearOverrideParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationContextClearOverrideParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationContextClearOverrideParams decode(Decoder decoder0) {
            GeolocationContextClearOverrideParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationContextClearOverrideParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
