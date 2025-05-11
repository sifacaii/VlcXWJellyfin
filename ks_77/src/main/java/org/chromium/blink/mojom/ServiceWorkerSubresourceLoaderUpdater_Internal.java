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

class ServiceWorkerSubresourceLoaderUpdater_Internal {
    public static final Interface.Manager<ServiceWorkerSubresourceLoaderUpdater, ServiceWorkerSubresourceLoaderUpdater.Proxy> MANAGER = new Interface.Manager<ServiceWorkerSubresourceLoaderUpdater, ServiceWorkerSubresourceLoaderUpdater.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerSubresourceLoaderUpdater";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerSubresourceLoaderUpdater_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerSubresourceLoaderUpdater_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerSubresourceLoaderUpdater_Internal.Stub buildStub(Core core, ServiceWorkerSubresourceLoaderUpdater impl) {
            return new ServiceWorkerSubresourceLoaderUpdater_Internal.Stub(core, impl);
        }

        public ServiceWorkerSubresourceLoaderUpdater[] buildArray(int size) {
            return new ServiceWorkerSubresourceLoaderUpdater[size];
        }
    };

    private static final int UPDATE_SUBRESOURCE_LOADER_FACTORIES_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerSubresourceLoaderUpdater.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void updateSubresourceLoaderFactories(UrlLoaderFactoryBundle subresourceLoaderFactories) {
            ServiceWorkerSubresourceLoaderUpdater_Internal.ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams _message = new ServiceWorkerSubresourceLoaderUpdater_Internal.ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams();
            _message.subresourceLoaderFactories = subresourceLoaderFactories;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerSubresourceLoaderUpdater> {
        Stub(Core core, ServiceWorkerSubresourceLoaderUpdater impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerSubresourceLoaderUpdater_Internal.ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerSubresourceLoaderUpdater_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorkerSubresourceLoaderUpdater_Internal.ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerSubresourceLoaderUpdater)getImpl()).updateSubresourceLoaderFactories(data.subresourceLoaderFactories);
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
                                getCore(), ServiceWorkerSubresourceLoaderUpdater_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UrlLoaderFactoryBundle subresourceLoaderFactories;

        private ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams(int version) {
            super(16, version);
        }

        public ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams() {
            this(0);
        }

        public static ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams decode(Decoder decoder0) {
            ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerSubresourceLoaderUpdaterUpdateSubresourceLoaderFactoriesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.subresourceLoaderFactories, 8, false);
        }
    }
}
