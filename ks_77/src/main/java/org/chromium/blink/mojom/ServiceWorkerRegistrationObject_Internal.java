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

class ServiceWorkerRegistrationObject_Internal {
    public static final Interface.Manager<ServiceWorkerRegistrationObject, ServiceWorkerRegistrationObject.Proxy> MANAGER = new Interface.Manager<ServiceWorkerRegistrationObject, ServiceWorkerRegistrationObject.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerRegistrationObject";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerRegistrationObject_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerRegistrationObject_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerRegistrationObject_Internal.Stub buildStub(Core core, ServiceWorkerRegistrationObject impl) {
            return new ServiceWorkerRegistrationObject_Internal.Stub(core, impl);
        }

        public ServiceWorkerRegistrationObject[] buildArray(int size) {
            return new ServiceWorkerRegistrationObject[size];
        }
    };

    private static final int SET_SERVICE_WORKER_OBJECTS_ORDINAL = 0;

    private static final int SET_UPDATE_VIA_CACHE_ORDINAL = 1;

    private static final int UPDATE_FOUND_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerRegistrationObject.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setServiceWorkerObjects(ChangedServiceWorkerObjectsMask changedMask, ServiceWorkerObjectInfo installing, ServiceWorkerObjectInfo waiting, ServiceWorkerObjectInfo active) {
            ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams _message = new ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams();
            _message.changedMask = changedMask;
            _message.installing = installing;
            _message.waiting = waiting;
            _message.active = active;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setUpdateViaCache(int updateViaCache) {
            ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetUpdateViaCacheParams _message = new ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetUpdateViaCacheParams();
            _message.updateViaCache = updateViaCache;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void updateFound() {
            ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectUpdateFoundParams _message = new ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectUpdateFoundParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerRegistrationObject> {
        Stub(Core core, ServiceWorkerRegistrationObject impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams serviceWorkerRegistrationObjectSetServiceWorkerObjectsParams;
                ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetUpdateViaCacheParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerRegistrationObject_Internal.MANAGER, messageWithHeader);
                    case 0:
                        serviceWorkerRegistrationObjectSetServiceWorkerObjectsParams = ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObject)getImpl()).setServiceWorkerObjects(serviceWorkerRegistrationObjectSetServiceWorkerObjectsParams.changedMask, serviceWorkerRegistrationObjectSetServiceWorkerObjectsParams.installing, serviceWorkerRegistrationObjectSetServiceWorkerObjectsParams.waiting, serviceWorkerRegistrationObjectSetServiceWorkerObjectsParams.active);
                        return true;
                    case 1:
                        data = ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectSetUpdateViaCacheParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObject)getImpl()).setUpdateViaCache(data.updateViaCache);
                        return true;
                    case 2:
                        ServiceWorkerRegistrationObject_Internal.ServiceWorkerRegistrationObjectUpdateFoundParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObject)getImpl()).updateFound();
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
                                getCore(), ServiceWorkerRegistrationObject_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ChangedServiceWorkerObjectsMask changedMask;

        public ServiceWorkerObjectInfo installing;

        public ServiceWorkerObjectInfo waiting;

        public ServiceWorkerObjectInfo active;

        private ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams(int version) {
            super(40, version);
        }

        public ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectSetServiceWorkerObjectsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.changedMask = ChangedServiceWorkerObjectsMask.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.installing = ServiceWorkerObjectInfo.decode(decoder1);
                decoder1 = decoder0.readPointer(24, true);
                result.waiting = ServiceWorkerObjectInfo.decode(decoder1);
                decoder1 = decoder0.readPointer(32, true);
                result.active = ServiceWorkerObjectInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.changedMask, 8, false);
            encoder0.encode(this.installing, 16, true);
            encoder0.encode(this.waiting, 24, true);
            encoder0.encode(this.active, 32, true);
        }
    }

    static final class ServiceWorkerRegistrationObjectSetUpdateViaCacheParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int updateViaCache;

        private ServiceWorkerRegistrationObjectSetUpdateViaCacheParams(int version) {
            super(16, version);
        }

        public ServiceWorkerRegistrationObjectSetUpdateViaCacheParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectSetUpdateViaCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectSetUpdateViaCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectSetUpdateViaCacheParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectSetUpdateViaCacheParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectSetUpdateViaCacheParams(elementsOrVersion);
                result.updateViaCache = decoder0.readInt(8);
                ServiceWorkerUpdateViaCache.validate(result.updateViaCache);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.updateViaCache, 8);
        }
    }

    static final class ServiceWorkerRegistrationObjectUpdateFoundParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerRegistrationObjectUpdateFoundParams(int version) {
            super(8, version);
        }

        public ServiceWorkerRegistrationObjectUpdateFoundParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectUpdateFoundParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectUpdateFoundParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectUpdateFoundParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectUpdateFoundParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectUpdateFoundParams(elementsOrVersion);
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
