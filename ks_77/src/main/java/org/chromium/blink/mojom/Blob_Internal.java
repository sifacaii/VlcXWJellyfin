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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.network.mojom.DataPipeGetter;

class Blob_Internal {
    public static final Interface.Manager<Blob, Blob.Proxy> MANAGER = new Interface.Manager<Blob, Blob.Proxy>() {
        public String getName() {
            return "blink.mojom.Blob";
        }

        public int getVersion() {
            return 0;
        }

        public Blob_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Blob_Internal.Proxy(core, messageReceiver);
        }

        public Blob_Internal.Stub buildStub(Core core, Blob impl) {
            return new Blob_Internal.Stub(core, impl);
        }

        public Blob[] buildArray(int size) {
            return new Blob[size];
        }
    };

    private static final int CLONE_ORDINAL = 0;

    private static final int AS_DATA_PIPE_GETTER_ORDINAL = 1;

    private static final int READ_ALL_ORDINAL = 2;

    private static final int READ_RANGE_ORDINAL = 3;

    private static final int READ_SIDE_DATA_ORDINAL = 4;

    private static final int GET_INTERNAL_UUID_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements Blob.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void clone(InterfaceRequest<Blob> blob) {
            Blob_Internal.BlobCloneParams _message = new Blob_Internal.BlobCloneParams();
            _message.blob = blob;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void asDataPipeGetter(InterfaceRequest<DataPipeGetter> dataPipeGetter) {
            Blob_Internal.BlobAsDataPipeGetterParams _message = new Blob_Internal.BlobAsDataPipeGetterParams();
            _message.dataPipeGetter = dataPipeGetter;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void readAll(DataPipe.ProducerHandle pipe, BlobReaderClient client) {
            Blob_Internal.BlobReadAllParams _message = new Blob_Internal.BlobReadAllParams();
            _message.pipe = pipe;
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void readRange(long offset, long length, DataPipe.ProducerHandle pipe, BlobReaderClient client) {
            Blob_Internal.BlobReadRangeParams _message = new Blob_Internal.BlobReadRangeParams();
            _message.offset = offset;
            _message.length = length;
            _message.pipe = pipe;
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void readSideData(Blob.ReadSideDataResponse callback) {
            Blob_Internal.BlobReadSideDataParams _message = new Blob_Internal.BlobReadSideDataParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new Blob_Internal.BlobReadSideDataResponseParamsForwardToCallback(callback));
        }

        public void getInternalUuid(Blob.GetInternalUuidResponse callback) {
            Blob_Internal.BlobGetInternalUuidParams _message = new Blob_Internal.BlobGetInternalUuidParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new Blob_Internal.BlobGetInternalUuidResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<Blob> {
        Stub(Core core, Blob impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Blob_Internal.BlobCloneParams blobCloneParams;
                Blob_Internal.BlobAsDataPipeGetterParams blobAsDataPipeGetterParams;
                Blob_Internal.BlobReadAllParams blobReadAllParams;
                Blob_Internal.BlobReadRangeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Blob_Internal.MANAGER, messageWithHeader);
                    case 0:
                        blobCloneParams = Blob_Internal.BlobCloneParams.deserialize(messageWithHeader.getPayload());
                        ((Blob)getImpl()).clone(blobCloneParams.blob);
                        return true;
                    case 1:
                        blobAsDataPipeGetterParams = Blob_Internal.BlobAsDataPipeGetterParams.deserialize(messageWithHeader.getPayload());
                        ((Blob)getImpl()).asDataPipeGetter(blobAsDataPipeGetterParams.dataPipeGetter);
                        return true;
                    case 2:
                        blobReadAllParams = Blob_Internal.BlobReadAllParams.deserialize(messageWithHeader.getPayload());
                        ((Blob)getImpl()).readAll(blobReadAllParams.pipe, blobReadAllParams.client);
                        return true;
                    case 3:
                        data = Blob_Internal.BlobReadRangeParams.deserialize(messageWithHeader.getPayload());
                        ((Blob)getImpl()).readRange(data.offset, data.length, data.pipe, data.client);
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
                                getCore(), Blob_Internal.MANAGER, messageWithHeader, receiver);
                    case 4:
                        Blob_Internal.BlobReadSideDataParams.deserialize(messageWithHeader.getPayload());
                        ((Blob)getImpl()).readSideData(new Blob_Internal.BlobReadSideDataResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        Blob_Internal.BlobGetInternalUuidParams.deserialize(messageWithHeader.getPayload());
                        ((Blob)getImpl()).getInternalUuid(new Blob_Internal.BlobGetInternalUuidResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BlobCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<Blob> blob;

        private BlobCloneParams(int version) {
            super(16, version);
        }

        public BlobCloneParams() {
            this(0);
        }

        public static BlobCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobCloneParams decode(Decoder decoder0) {
            BlobCloneParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobCloneParams(elementsOrVersion);
                result.blob = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.blob, 8, false);
        }
    }

    static final class BlobAsDataPipeGetterParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<DataPipeGetter> dataPipeGetter;

        private BlobAsDataPipeGetterParams(int version) {
            super(16, version);
        }

        public BlobAsDataPipeGetterParams() {
            this(0);
        }

        public static BlobAsDataPipeGetterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobAsDataPipeGetterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobAsDataPipeGetterParams decode(Decoder decoder0) {
            BlobAsDataPipeGetterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobAsDataPipeGetterParams(elementsOrVersion);
                result.dataPipeGetter = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.dataPipeGetter, 8, false);
        }
    }

    static final class BlobReadAllParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DataPipe.ProducerHandle pipe;

        public BlobReaderClient client;

        private BlobReadAllParams(int version) {
            super(24, version);
            this.pipe = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
        }

        public BlobReadAllParams() {
            this(0);
        }

        public static BlobReadAllParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobReadAllParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobReadAllParams decode(Decoder decoder0) {
            BlobReadAllParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobReadAllParams(elementsOrVersion);
                result.pipe = decoder0.readProducerHandle(8, false);
                result.client = (BlobReaderClient)decoder0.readServiceInterface(12, true, BlobReaderClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle)this.pipe, 8, false);
            encoder0.encode(this.client, 12, true, BlobReaderClient.MANAGER);
        }
    }

    static final class BlobReadRangeParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long offset;

        public long length;

        public DataPipe.ProducerHandle pipe;

        public BlobReaderClient client;

        private BlobReadRangeParams(int version) {
            super(40, version);
            this.pipe = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
        }

        public BlobReadRangeParams() {
            this(0);
        }

        public static BlobReadRangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobReadRangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobReadRangeParams decode(Decoder decoder0) {
            BlobReadRangeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobReadRangeParams(elementsOrVersion);
                result.offset = decoder0.readLong(8);
                result.length = decoder0.readLong(16);
                result.pipe = decoder0.readProducerHandle(24, false);
                result.client = (BlobReaderClient)decoder0.readServiceInterface(28, true, BlobReaderClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.offset, 8);
            encoder0.encode(this.length, 16);
            encoder0.encode((Handle)this.pipe, 24, false);
            encoder0.encode(this.client, 28, true, BlobReaderClient.MANAGER);
        }
    }

    static final class BlobReadSideDataParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BlobReadSideDataParams(int version) {
            super(8, version);
        }

        public BlobReadSideDataParams() {
            this(0);
        }

        public static BlobReadSideDataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobReadSideDataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobReadSideDataParams decode(Decoder decoder0) {
            BlobReadSideDataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobReadSideDataParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BlobReadSideDataResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BigBuffer data;

        private BlobReadSideDataResponseParams(int version) {
            super(24, version);
        }

        public BlobReadSideDataResponseParams() {
            this(0);
        }

        public static BlobReadSideDataResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobReadSideDataResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobReadSideDataResponseParams decode(Decoder decoder0) {
            BlobReadSideDataResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobReadSideDataResponseParams(elementsOrVersion);
                result.data = BigBuffer.decode(decoder0, 8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Union)this.data, 8, true);
        }
    }

    static class BlobReadSideDataResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Blob.ReadSideDataResponse mCallback;

        BlobReadSideDataResponseParamsForwardToCallback(Blob.ReadSideDataResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                Blob_Internal.BlobReadSideDataResponseParams response = Blob_Internal.BlobReadSideDataResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobReadSideDataResponseParamsProxyToResponder implements Blob.ReadSideDataResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobReadSideDataResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BigBuffer data) {
            Blob_Internal.BlobReadSideDataResponseParams _response = new Blob_Internal.BlobReadSideDataResponseParams();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BlobGetInternalUuidParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BlobGetInternalUuidParams(int version) {
            super(8, version);
        }

        public BlobGetInternalUuidParams() {
            this(0);
        }

        public static BlobGetInternalUuidParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobGetInternalUuidParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobGetInternalUuidParams decode(Decoder decoder0) {
            BlobGetInternalUuidParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobGetInternalUuidParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BlobGetInternalUuidResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String uuid;

        private BlobGetInternalUuidResponseParams(int version) {
            super(16, version);
        }

        public BlobGetInternalUuidResponseParams() {
            this(0);
        }

        public static BlobGetInternalUuidResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobGetInternalUuidResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobGetInternalUuidResponseParams decode(Decoder decoder0) {
            BlobGetInternalUuidResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobGetInternalUuidResponseParams(elementsOrVersion);
                result.uuid = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.uuid, 8, false);
        }
    }

    static class BlobGetInternalUuidResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Blob.GetInternalUuidResponse mCallback;

        BlobGetInternalUuidResponseParamsForwardToCallback(Blob.GetInternalUuidResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                Blob_Internal.BlobGetInternalUuidResponseParams response = Blob_Internal.BlobGetInternalUuidResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.uuid);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobGetInternalUuidResponseParamsProxyToResponder implements Blob.GetInternalUuidResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobGetInternalUuidResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String uuid) {
            Blob_Internal.BlobGetInternalUuidResponseParams _response = new Blob_Internal.BlobGetInternalUuidResponseParams();
            _response.uuid = uuid;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
