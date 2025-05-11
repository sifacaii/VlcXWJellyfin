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

class ServiceWorkerContainer_Internal {
    public static final Interface.Manager<ServiceWorkerContainer, ServiceWorkerContainer.Proxy> MANAGER = new Interface.Manager<ServiceWorkerContainer, ServiceWorkerContainer.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerContainer";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerContainer_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerContainer_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerContainer_Internal.Stub buildStub(Core core, ServiceWorkerContainer impl) {
            return new ServiceWorkerContainer_Internal.Stub(core, impl);
        }

        public ServiceWorkerContainer[] buildArray(int size) {
            return new ServiceWorkerContainer[size];
        }
    };

    private static final int SET_CONTROLLER_ORDINAL = 0;

    private static final int POST_MESSAGE_TO_CLIENT_ORDINAL = 1;

    private static final int COUNT_FEATURE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerContainer.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setController(ControllerServiceWorkerInfo controllerInfo, boolean shouldNotifyControllerchange) {
            ServiceWorkerContainer_Internal.ServiceWorkerContainerSetControllerParams _message = new ServiceWorkerContainer_Internal.ServiceWorkerContainerSetControllerParams();
            _message.controllerInfo = controllerInfo;
            _message.shouldNotifyControllerchange = shouldNotifyControllerchange;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void postMessageToClient(ServiceWorkerObjectInfo source, TransferableMessage message) {
            ServiceWorkerContainer_Internal.ServiceWorkerContainerPostMessageToClientParams _message = new ServiceWorkerContainer_Internal.ServiceWorkerContainerPostMessageToClientParams();
            _message.source = source;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void countFeature(int feature) {
            ServiceWorkerContainer_Internal.ServiceWorkerContainerCountFeatureParams _message = new ServiceWorkerContainer_Internal.ServiceWorkerContainerCountFeatureParams();
            _message.feature = feature;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerContainer> {
        Stub(Core core, ServiceWorkerContainer impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerContainer_Internal.ServiceWorkerContainerSetControllerParams serviceWorkerContainerSetControllerParams;
                ServiceWorkerContainer_Internal.ServiceWorkerContainerPostMessageToClientParams serviceWorkerContainerPostMessageToClientParams;
                ServiceWorkerContainer_Internal.ServiceWorkerContainerCountFeatureParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerContainer_Internal.MANAGER, messageWithHeader);
                    case 0:
                        serviceWorkerContainerSetControllerParams = ServiceWorkerContainer_Internal.ServiceWorkerContainerSetControllerParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainer)getImpl()).setController(serviceWorkerContainerSetControllerParams.controllerInfo, serviceWorkerContainerSetControllerParams.shouldNotifyControllerchange);
                        return true;
                    case 1:
                        serviceWorkerContainerPostMessageToClientParams = ServiceWorkerContainer_Internal.ServiceWorkerContainerPostMessageToClientParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainer)getImpl()).postMessageToClient(serviceWorkerContainerPostMessageToClientParams.source, serviceWorkerContainerPostMessageToClientParams.message);
                        return true;
                    case 2:
                        data = ServiceWorkerContainer_Internal.ServiceWorkerContainerCountFeatureParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainer)getImpl()).countFeature(data.feature);
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
                                getCore(), ServiceWorkerContainer_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerContainerSetControllerParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ControllerServiceWorkerInfo controllerInfo;

        public boolean shouldNotifyControllerchange;

        private ServiceWorkerContainerSetControllerParams(int version) {
            super(24, version);
        }

        public ServiceWorkerContainerSetControllerParams() {
            this(0);
        }

        public static ServiceWorkerContainerSetControllerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerSetControllerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerSetControllerParams decode(Decoder decoder0) {
            ServiceWorkerContainerSetControllerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerSetControllerParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.controllerInfo = ControllerServiceWorkerInfo.decode(decoder1);
                result.shouldNotifyControllerchange = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.controllerInfo, 8, false);
            encoder0.encode(this.shouldNotifyControllerchange, 16, 0);
        }
    }

    static final class ServiceWorkerContainerPostMessageToClientParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerObjectInfo source;

        public TransferableMessage message;

        private ServiceWorkerContainerPostMessageToClientParams(int version) {
            super(24, version);
        }

        public ServiceWorkerContainerPostMessageToClientParams() {
            this(0);
        }

        public static ServiceWorkerContainerPostMessageToClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerPostMessageToClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerPostMessageToClientParams decode(Decoder decoder0) {
            ServiceWorkerContainerPostMessageToClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerPostMessageToClientParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.source = ServiceWorkerObjectInfo.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.message = TransferableMessage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.source, 8, false);
            encoder0.encode(this.message, 16, false);
        }
    }

    static final class ServiceWorkerContainerCountFeatureParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int feature;

        private ServiceWorkerContainerCountFeatureParams(int version) {
            super(16, version);
        }

        public ServiceWorkerContainerCountFeatureParams() {
            this(0);
        }

        public static ServiceWorkerContainerCountFeatureParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerCountFeatureParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerCountFeatureParams decode(Decoder decoder0) {
            ServiceWorkerContainerCountFeatureParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerCountFeatureParams(elementsOrVersion);
                result.feature = decoder0.readInt(8);
                WebFeature.validate(result.feature);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.feature, 8);
        }
    }
}
