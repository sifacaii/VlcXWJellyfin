package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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

class AssociatedInterfaceProvider_Internal {
    public static final Interface.Manager<AssociatedInterfaceProvider, AssociatedInterfaceProvider.Proxy> MANAGER = new Interface.Manager<AssociatedInterfaceProvider, AssociatedInterfaceProvider.Proxy>() {
        public String getName() {
            return "blink.mojom.AssociatedInterfaceProvider";
        }

        public int getVersion() {
            return 0;
        }

        public AssociatedInterfaceProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AssociatedInterfaceProvider_Internal.Proxy(core, messageReceiver);
        }

        public AssociatedInterfaceProvider_Internal.Stub buildStub(Core core, AssociatedInterfaceProvider impl) {
            return new AssociatedInterfaceProvider_Internal.Stub(core, impl);
        }

        public AssociatedInterfaceProvider[] buildArray(int size) {
            return new AssociatedInterfaceProvider[size];
        }
    };

    private static final int GET_ASSOCIATED_INTERFACE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AssociatedInterfaceProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getAssociatedInterface(String name, AssociatedInterfaceRequestNotSupported request) {
            AssociatedInterfaceProvider_Internal.AssociatedInterfaceProviderGetAssociatedInterfaceParams _message = new AssociatedInterfaceProvider_Internal.AssociatedInterfaceProviderGetAssociatedInterfaceParams();
            _message.name = name;
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AssociatedInterfaceProvider> {
        Stub(Core core, AssociatedInterfaceProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AssociatedInterfaceProvider_Internal.AssociatedInterfaceProviderGetAssociatedInterfaceParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AssociatedInterfaceProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AssociatedInterfaceProvider_Internal.AssociatedInterfaceProviderGetAssociatedInterfaceParams.deserialize(messageWithHeader.getPayload());
                        ((AssociatedInterfaceProvider)getImpl()).getAssociatedInterface(data.name, data.request);
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
                                getCore(), AssociatedInterfaceProvider_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AssociatedInterfaceProviderGetAssociatedInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String name;

        public AssociatedInterfaceRequestNotSupported request;

        private AssociatedInterfaceProviderGetAssociatedInterfaceParams(int version) {
            super(24, version);
        }

        public AssociatedInterfaceProviderGetAssociatedInterfaceParams() {
            this(0);
        }

        public static AssociatedInterfaceProviderGetAssociatedInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AssociatedInterfaceProviderGetAssociatedInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AssociatedInterfaceProviderGetAssociatedInterfaceParams decode(Decoder decoder0) {
            AssociatedInterfaceProviderGetAssociatedInterfaceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AssociatedInterfaceProviderGetAssociatedInterfaceParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
                result.request = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.name, 8, false);
            encoder0.encode(this.request, 16, false);
        }
    }
}
