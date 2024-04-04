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

class ServiceWorkerObject_Internal {
    public static final Interface.Manager<ServiceWorkerObject, ServiceWorkerObject.Proxy> MANAGER = new Interface.Manager<ServiceWorkerObject, ServiceWorkerObject.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerObject";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerObject_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerObject_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerObject_Internal.Stub buildStub(Core core, ServiceWorkerObject impl) {
            return new ServiceWorkerObject_Internal.Stub(core, impl);
        }

        public ServiceWorkerObject[] buildArray(int size) {
            return new ServiceWorkerObject[size];
        }
    };

    private static final int STATE_CHANGED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerObject.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void stateChanged(int state) {
            ServiceWorkerObject_Internal.ServiceWorkerObjectStateChangedParams _message = new ServiceWorkerObject_Internal.ServiceWorkerObjectStateChangedParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerObject> {
        Stub(Core core, ServiceWorkerObject impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerObject_Internal.ServiceWorkerObjectStateChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerObject_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorkerObject_Internal.ServiceWorkerObjectStateChangedParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerObject)getImpl()).stateChanged(data.state);
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
                                getCore(), ServiceWorkerObject_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerObjectStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int state;

        private ServiceWorkerObjectStateChangedParams(int version) {
            super(16, version);
        }

        public ServiceWorkerObjectStateChangedParams() {
            this(0);
        }

        public static ServiceWorkerObjectStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerObjectStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerObjectStateChangedParams decode(Decoder decoder0) {
            ServiceWorkerObjectStateChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerObjectStateChangedParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                ServiceWorkerState.validate(result.state);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.state, 8);
        }
    }
}
