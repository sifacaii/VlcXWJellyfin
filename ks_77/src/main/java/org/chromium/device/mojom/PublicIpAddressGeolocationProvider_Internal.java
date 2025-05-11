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
import org.chromium.network.mojom.MutablePartialNetworkTrafficAnnotationTag;

class PublicIpAddressGeolocationProvider_Internal {
    public static final Interface.Manager<PublicIpAddressGeolocationProvider, PublicIpAddressGeolocationProvider.Proxy> MANAGER = new Interface.Manager<PublicIpAddressGeolocationProvider, PublicIpAddressGeolocationProvider.Proxy>() {
        public String getName() {
            return "device.mojom.PublicIpAddressGeolocationProvider";
        }

        public int getVersion() {
            return 0;
        }

        public PublicIpAddressGeolocationProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PublicIpAddressGeolocationProvider_Internal.Proxy(core, messageReceiver);
        }

        public PublicIpAddressGeolocationProvider_Internal.Stub buildStub(Core core, PublicIpAddressGeolocationProvider impl) {
            return new PublicIpAddressGeolocationProvider_Internal.Stub(core, impl);
        }

        public PublicIpAddressGeolocationProvider[] buildArray(int size) {
            return new PublicIpAddressGeolocationProvider[size];
        }
    };

    private static final int CREATE_GEOLOCATION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PublicIpAddressGeolocationProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createGeolocation(MutablePartialNetworkTrafficAnnotationTag tag, InterfaceRequest<Geolocation> request) {
            PublicIpAddressGeolocationProvider_Internal.PublicIpAddressGeolocationProviderCreateGeolocationParams _message = new PublicIpAddressGeolocationProvider_Internal.PublicIpAddressGeolocationProviderCreateGeolocationParams();
            _message.tag = tag;
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<PublicIpAddressGeolocationProvider> {
        Stub(Core core, PublicIpAddressGeolocationProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PublicIpAddressGeolocationProvider_Internal.PublicIpAddressGeolocationProviderCreateGeolocationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PublicIpAddressGeolocationProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PublicIpAddressGeolocationProvider_Internal.PublicIpAddressGeolocationProviderCreateGeolocationParams.deserialize(messageWithHeader.getPayload());
                        ((PublicIpAddressGeolocationProvider)getImpl()).createGeolocation(data.tag, data.request);
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
                                getCore(), PublicIpAddressGeolocationProvider_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PublicIpAddressGeolocationProviderCreateGeolocationParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MutablePartialNetworkTrafficAnnotationTag tag;

        public InterfaceRequest<Geolocation> request;

        private PublicIpAddressGeolocationProviderCreateGeolocationParams(int version) {
            super(24, version);
        }

        public PublicIpAddressGeolocationProviderCreateGeolocationParams() {
            this(0);
        }

        public static PublicIpAddressGeolocationProviderCreateGeolocationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PublicIpAddressGeolocationProviderCreateGeolocationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PublicIpAddressGeolocationProviderCreateGeolocationParams decode(Decoder decoder0) {
            PublicIpAddressGeolocationProviderCreateGeolocationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PublicIpAddressGeolocationProviderCreateGeolocationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.tag = MutablePartialNetworkTrafficAnnotationTag.decode(decoder1);
                result.request = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.tag, 8, false);
            encoder0.encode(this.request, 16, false);
        }
    }
}
