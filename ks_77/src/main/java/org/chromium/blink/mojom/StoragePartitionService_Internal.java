package org.chromium.blink.mojom;

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
import org.chromium.url.mojom.Origin;

class StoragePartitionService_Internal {
    public static final Interface.Manager<StoragePartitionService, StoragePartitionService.Proxy> MANAGER = new Interface.Manager<StoragePartitionService, StoragePartitionService.Proxy>() {
        public String getName() {
            return "blink.mojom.StoragePartitionService";
        }

        public int getVersion() {
            return 0;
        }

        public StoragePartitionService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new StoragePartitionService_Internal.Proxy(core, messageReceiver);
        }

        public StoragePartitionService_Internal.Stub buildStub(Core core, StoragePartitionService impl) {
            return new StoragePartitionService_Internal.Stub(core, impl);
        }

        public StoragePartitionService[] buildArray(int size) {
            return new StoragePartitionService[size];
        }
    };

    private static final int OPEN_LOCAL_STORAGE_ORDINAL = 0;

    private static final int OPEN_SESSION_STORAGE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements StoragePartitionService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openLocalStorage(Origin origin, InterfaceRequest<StorageArea> area) {
            StoragePartitionService_Internal.StoragePartitionServiceOpenLocalStorageParams _message = new StoragePartitionService_Internal.StoragePartitionServiceOpenLocalStorageParams();
            _message.origin = origin;
            _message.area = area;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void openSessionStorage(String namespaceId, InterfaceRequest<SessionStorageNamespace> sessionNamespace) {
            StoragePartitionService_Internal.StoragePartitionServiceOpenSessionStorageParams _message = new StoragePartitionService_Internal.StoragePartitionServiceOpenSessionStorageParams();
            _message.namespaceId = namespaceId;
            _message.sessionNamespace = sessionNamespace;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<StoragePartitionService> {
        Stub(Core core, StoragePartitionService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                StoragePartitionService_Internal.StoragePartitionServiceOpenLocalStorageParams storagePartitionServiceOpenLocalStorageParams;
                StoragePartitionService_Internal.StoragePartitionServiceOpenSessionStorageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(StoragePartitionService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        storagePartitionServiceOpenLocalStorageParams = StoragePartitionService_Internal.StoragePartitionServiceOpenLocalStorageParams.deserialize(messageWithHeader.getPayload());
                        ((StoragePartitionService)getImpl()).openLocalStorage(storagePartitionServiceOpenLocalStorageParams.origin, storagePartitionServiceOpenLocalStorageParams.area);
                        return true;
                    case 1:
                        data = StoragePartitionService_Internal.StoragePartitionServiceOpenSessionStorageParams.deserialize(messageWithHeader.getPayload());
                        ((StoragePartitionService)getImpl()).openSessionStorage(data.namespaceId, data.sessionNamespace);
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
                                getCore(), StoragePartitionService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class StoragePartitionServiceOpenLocalStorageParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public InterfaceRequest<StorageArea> area;

        private StoragePartitionServiceOpenLocalStorageParams(int version) {
            super(24, version);
        }

        public StoragePartitionServiceOpenLocalStorageParams() {
            this(0);
        }

        public static StoragePartitionServiceOpenLocalStorageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StoragePartitionServiceOpenLocalStorageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StoragePartitionServiceOpenLocalStorageParams decode(Decoder decoder0) {
            StoragePartitionServiceOpenLocalStorageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StoragePartitionServiceOpenLocalStorageParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.area = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.area, 16, false);
        }
    }

    static final class StoragePartitionServiceOpenSessionStorageParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String namespaceId;

        public InterfaceRequest<SessionStorageNamespace> sessionNamespace;

        private StoragePartitionServiceOpenSessionStorageParams(int version) {
            super(24, version);
        }

        public StoragePartitionServiceOpenSessionStorageParams() {
            this(0);
        }

        public static StoragePartitionServiceOpenSessionStorageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StoragePartitionServiceOpenSessionStorageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StoragePartitionServiceOpenSessionStorageParams decode(Decoder decoder0) {
            StoragePartitionServiceOpenSessionStorageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StoragePartitionServiceOpenSessionStorageParams(elementsOrVersion);
                result.namespaceId = decoder0.readString(8, false);
                result.sessionNamespace = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.namespaceId, 8, false);
            encoder0.encode(this.sessionNamespace, 16, false);
        }
    }
}
