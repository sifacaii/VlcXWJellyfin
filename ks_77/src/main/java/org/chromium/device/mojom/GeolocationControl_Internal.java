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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class GeolocationControl_Internal {
    public static final Interface.Manager<GeolocationControl, GeolocationControl.Proxy> MANAGER = new Interface.Manager<GeolocationControl, GeolocationControl.Proxy>() {
        public String getName() {
            return "device.mojom.GeolocationControl";
        }

        public int getVersion() {
            return 0;
        }

        public GeolocationControl_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new GeolocationControl_Internal.Proxy(core, messageReceiver);
        }

        public GeolocationControl_Internal.Stub buildStub(Core core, GeolocationControl impl) {
            return new GeolocationControl_Internal.Stub(core, impl);
        }

        public GeolocationControl[] buildArray(int size) {
            return new GeolocationControl[size];
        }
    };

    private static final int USER_DID_OPT_INTO_LOCATION_SERVICES_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements GeolocationControl.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void userDidOptIntoLocationServices() {
            GeolocationControl_Internal.GeolocationControlUserDidOptIntoLocationServicesParams _message = new GeolocationControl_Internal.GeolocationControlUserDidOptIntoLocationServicesParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<GeolocationControl> {
        Stub(Core core, GeolocationControl impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(GeolocationControl_Internal.MANAGER, messageWithHeader);
                    case 0:
                        GeolocationControl_Internal.GeolocationControlUserDidOptIntoLocationServicesParams.deserialize(messageWithHeader.getPayload());
                        ((GeolocationControl)getImpl()).userDidOptIntoLocationServices();
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
                                getCore(), GeolocationControl_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class GeolocationControlUserDidOptIntoLocationServicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GeolocationControlUserDidOptIntoLocationServicesParams(int version) {
            super(8, version);
        }

        public GeolocationControlUserDidOptIntoLocationServicesParams() {
            this(0);
        }

        public static GeolocationControlUserDidOptIntoLocationServicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GeolocationControlUserDidOptIntoLocationServicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GeolocationControlUserDidOptIntoLocationServicesParams decode(Decoder decoder0) {
            GeolocationControlUserDidOptIntoLocationServicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationControlUserDidOptIntoLocationServicesParams(elementsOrVersion);
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
