package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.url.mojom.Origin;

class BlobRegistry_Internal {
    public static final Interface.Manager<BlobRegistry, BlobRegistry.Proxy> MANAGER = new Interface.Manager<BlobRegistry, BlobRegistry.Proxy>() {
        public String getName() {
            return "blink.mojom.BlobRegistry";
        }

        public int getVersion() {
            return 0;
        }

        public BlobRegistry_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BlobRegistry_Internal.Proxy(core, messageReceiver);
        }

        public BlobRegistry_Internal.Stub buildStub(Core core, BlobRegistry impl) {
            return new BlobRegistry_Internal.Stub(core, impl);
        }

        public BlobRegistry[] buildArray(int size) {
            return new BlobRegistry[size];
        }
    };

    private static final int REGISTER_ORDINAL = 0;

    private static final int REGISTER_FROM_STREAM_ORDINAL = 1;

    private static final int GET_BLOB_FROM_UUID_ORDINAL = 2;

    private static final int URL_STORE_FOR_ORIGIN_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements BlobRegistry.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void register(InterfaceRequest<Blob> blob, String uuid, String contentType, String contentDisposition, DataElement[] elements, BlobRegistry.RegisterResponse callback) {
            BlobRegistry_Internal.BlobRegistryRegisterParams _message = new BlobRegistry_Internal.BlobRegistryRegisterParams();
            _message.blob = blob;
            _message.uuid = uuid;
            _message.contentType = contentType;
            _message.contentDisposition = contentDisposition;
            _message.elements = elements;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BlobRegistry_Internal.BlobRegistryRegisterResponseParamsForwardToCallback(callback));
        }

        public void registerFromStream(String contentType, String contentDisposition, long lengthHint, DataPipe.ConsumerHandle data, AssociatedInterfaceNotSupported progressClient, BlobRegistry.RegisterFromStreamResponse callback) {
            BlobRegistry_Internal.BlobRegistryRegisterFromStreamParams _message = new BlobRegistry_Internal.BlobRegistryRegisterFromStreamParams();
            _message.contentType = contentType;
            _message.contentDisposition = contentDisposition;
            _message.lengthHint = lengthHint;
            _message.data = data;
            _message.progressClient = progressClient;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new BlobRegistry_Internal.BlobRegistryRegisterFromStreamResponseParamsForwardToCallback(callback));
        }

        public void getBlobFromUuid(InterfaceRequest<Blob> blob, String uuid, BlobRegistry.GetBlobFromUuidResponse callback) {
            BlobRegistry_Internal.BlobRegistryGetBlobFromUuidParams _message = new BlobRegistry_Internal.BlobRegistryGetBlobFromUuidParams();
            _message.blob = blob;
            _message.uuid = uuid;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new BlobRegistry_Internal.BlobRegistryGetBlobFromUuidResponseParamsForwardToCallback(callback));
        }

        public void urlStoreForOrigin(Origin origin, AssociatedInterfaceRequestNotSupported urlStore) {
            BlobRegistry_Internal.BlobRegistryUrlStoreForOriginParams _message = new BlobRegistry_Internal.BlobRegistryUrlStoreForOriginParams();
            _message.origin = origin;
            _message.urlStore = urlStore;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<BlobRegistry> {
        Stub(Core core, BlobRegistry impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BlobRegistry_Internal.BlobRegistryUrlStoreForOriginParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BlobRegistry_Internal.MANAGER, messageWithHeader);
                    case 3:
                        data = BlobRegistry_Internal.BlobRegistryUrlStoreForOriginParams.deserialize(messageWithHeader.getPayload());
                        ((BlobRegistry)getImpl()).urlStoreForOrigin(data.origin, data.urlStore);
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
                BlobRegistry_Internal.BlobRegistryRegisterParams blobRegistryRegisterParams;
                BlobRegistry_Internal.BlobRegistryRegisterFromStreamParams blobRegistryRegisterFromStreamParams;
                BlobRegistry_Internal.BlobRegistryGetBlobFromUuidParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BlobRegistry_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        blobRegistryRegisterParams = BlobRegistry_Internal.BlobRegistryRegisterParams.deserialize(messageWithHeader.getPayload());
                        ((BlobRegistry)getImpl()).register(blobRegistryRegisterParams.blob, blobRegistryRegisterParams.uuid, blobRegistryRegisterParams.contentType, blobRegistryRegisterParams.contentDisposition, blobRegistryRegisterParams.elements, new BlobRegistry_Internal.BlobRegistryRegisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        blobRegistryRegisterFromStreamParams = BlobRegistry_Internal.BlobRegistryRegisterFromStreamParams.deserialize(messageWithHeader.getPayload());
                        ((BlobRegistry)getImpl()).registerFromStream(blobRegistryRegisterFromStreamParams.contentType, blobRegistryRegisterFromStreamParams.contentDisposition, blobRegistryRegisterFromStreamParams.lengthHint, blobRegistryRegisterFromStreamParams.data, blobRegistryRegisterFromStreamParams.progressClient, new BlobRegistry_Internal.BlobRegistryRegisterFromStreamResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = BlobRegistry_Internal.BlobRegistryGetBlobFromUuidParams.deserialize(messageWithHeader.getPayload());
                        ((BlobRegistry)getImpl()).getBlobFromUuid(data.blob, data.uuid, new BlobRegistry_Internal.BlobRegistryGetBlobFromUuidResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BlobRegistryRegisterParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<Blob> blob;

        public String uuid;

        public String contentType;

        public String contentDisposition;

        public DataElement[] elements;

        private BlobRegistryRegisterParams(int version) {
            super(48, version);
        }

        public BlobRegistryRegisterParams() {
            this(0);
        }

        public static BlobRegistryRegisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryRegisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryRegisterParams decode(Decoder decoder0) {
            BlobRegistryRegisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryRegisterParams(elementsOrVersion);
                result.blob = decoder0.readInterfaceRequest(8, false);
                result.uuid = decoder0.readString(16, false);
                result.contentType = decoder0.readString(24, false);
                result.contentDisposition = decoder0.readString(32, false);
                Decoder decoder1 = decoder0.readPointer(40, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.elements = new DataElement[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.elements[i1] = DataElement.decode(decoder1, 8 + 16 * i1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.blob, 8, false);
            encoder0.encode(this.uuid, 16, false);
            encoder0.encode(this.contentType, 24, false);
            encoder0.encode(this.contentDisposition, 32, false);
            if (this.elements == null) {
                encoder0.encodeNullPointer(40, false);
            } else {
                Encoder encoder1 = encoder0.encodeUnionArray(this.elements.length, 40, -1);
                for (int i0 = 0; i0 < this.elements.length; i0++)
                    encoder1.encode(this.elements[i0], 8 + 16 * i0, false);
            }
        }
    }

    static final class BlobRegistryRegisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BlobRegistryRegisterResponseParams(int version) {
            super(8, version);
        }

        public BlobRegistryRegisterResponseParams() {
            this(0);
        }

        public static BlobRegistryRegisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryRegisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryRegisterResponseParams decode(Decoder decoder0) {
            BlobRegistryRegisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryRegisterResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class BlobRegistryRegisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BlobRegistry.RegisterResponse mCallback;

        BlobRegistryRegisterResponseParamsForwardToCallback(BlobRegistry.RegisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobRegistryRegisterResponseParamsProxyToResponder implements BlobRegistry.RegisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobRegistryRegisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            BlobRegistry_Internal.BlobRegistryRegisterResponseParams _response = new BlobRegistry_Internal.BlobRegistryRegisterResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BlobRegistryRegisterFromStreamParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String contentType;

        public String contentDisposition;

        public long lengthHint;

        public DataPipe.ConsumerHandle data;

        public AssociatedInterfaceNotSupported progressClient;

        private BlobRegistryRegisterFromStreamParams(int version) {
            super(48, version);
            this.data = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
        }

        public BlobRegistryRegisterFromStreamParams() {
            this(0);
        }

        public static BlobRegistryRegisterFromStreamParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryRegisterFromStreamParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryRegisterFromStreamParams decode(Decoder decoder0) {
            BlobRegistryRegisterFromStreamParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryRegisterFromStreamParams(elementsOrVersion);
                result.contentType = decoder0.readString(8, false);
                result.contentDisposition = decoder0.readString(16, false);
                result.lengthHint = decoder0.readLong(24);
                result.data = decoder0.readConsumerHandle(32, false);
                result.progressClient = decoder0.readAssociatedServiceInterfaceNotSupported(36, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.contentType, 8, false);
            encoder0.encode(this.contentDisposition, 16, false);
            encoder0.encode(this.lengthHint, 24);
            encoder0.encode((Handle)this.data, 32, false);
            encoder0.encode(this.progressClient, 36, true);
        }
    }

    static final class BlobRegistryRegisterFromStreamResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerializedBlob blob;

        private BlobRegistryRegisterFromStreamResponseParams(int version) {
            super(16, version);
        }

        public BlobRegistryRegisterFromStreamResponseParams() {
            this(0);
        }

        public static BlobRegistryRegisterFromStreamResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryRegisterFromStreamResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryRegisterFromStreamResponseParams decode(Decoder decoder0) {
            BlobRegistryRegisterFromStreamResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryRegisterFromStreamResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.blob = SerializedBlob.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.blob, 8, true);
        }
    }

    static class BlobRegistryRegisterFromStreamResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BlobRegistry.RegisterFromStreamResponse mCallback;

        BlobRegistryRegisterFromStreamResponseParamsForwardToCallback(BlobRegistry.RegisterFromStreamResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                BlobRegistry_Internal.BlobRegistryRegisterFromStreamResponseParams response = BlobRegistry_Internal.BlobRegistryRegisterFromStreamResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.blob);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobRegistryRegisterFromStreamResponseParamsProxyToResponder implements BlobRegistry.RegisterFromStreamResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobRegistryRegisterFromStreamResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(SerializedBlob blob) {
            BlobRegistry_Internal.BlobRegistryRegisterFromStreamResponseParams _response = new BlobRegistry_Internal.BlobRegistryRegisterFromStreamResponseParams();
            _response.blob = blob;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BlobRegistryGetBlobFromUuidParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<Blob> blob;

        public String uuid;

        private BlobRegistryGetBlobFromUuidParams(int version) {
            super(24, version);
        }

        public BlobRegistryGetBlobFromUuidParams() {
            this(0);
        }

        public static BlobRegistryGetBlobFromUuidParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryGetBlobFromUuidParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryGetBlobFromUuidParams decode(Decoder decoder0) {
            BlobRegistryGetBlobFromUuidParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryGetBlobFromUuidParams(elementsOrVersion);
                result.blob = decoder0.readInterfaceRequest(8, false);
                result.uuid = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.blob, 8, false);
            encoder0.encode(this.uuid, 16, false);
        }
    }

    static final class BlobRegistryGetBlobFromUuidResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BlobRegistryGetBlobFromUuidResponseParams(int version) {
            super(8, version);
        }

        public BlobRegistryGetBlobFromUuidResponseParams() {
            this(0);
        }

        public static BlobRegistryGetBlobFromUuidResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryGetBlobFromUuidResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryGetBlobFromUuidResponseParams decode(Decoder decoder0) {
            BlobRegistryGetBlobFromUuidResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryGetBlobFromUuidResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class BlobRegistryGetBlobFromUuidResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BlobRegistry.GetBlobFromUuidResponse mCallback;

        BlobRegistryGetBlobFromUuidResponseParamsForwardToCallback(BlobRegistry.GetBlobFromUuidResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobRegistryGetBlobFromUuidResponseParamsProxyToResponder implements BlobRegistry.GetBlobFromUuidResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobRegistryGetBlobFromUuidResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            BlobRegistry_Internal.BlobRegistryGetBlobFromUuidResponseParams _response = new BlobRegistry_Internal.BlobRegistryGetBlobFromUuidResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BlobRegistryUrlStoreForOriginParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public AssociatedInterfaceRequestNotSupported urlStore;

        private BlobRegistryUrlStoreForOriginParams(int version) {
            super(24, version);
        }

        public BlobRegistryUrlStoreForOriginParams() {
            this(0);
        }

        public static BlobRegistryUrlStoreForOriginParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobRegistryUrlStoreForOriginParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobRegistryUrlStoreForOriginParams decode(Decoder decoder0) {
            BlobRegistryUrlStoreForOriginParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobRegistryUrlStoreForOriginParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.urlStore = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.urlStore, 16, false);
        }
    }
}
