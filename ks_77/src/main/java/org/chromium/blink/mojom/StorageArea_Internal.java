package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class StorageArea_Internal {
    public static final Interface.Manager<StorageArea, StorageArea.Proxy> MANAGER = new Interface.Manager<StorageArea, StorageArea.Proxy>() {
        public String getName() {
            return "blink.mojom.StorageArea";
        }

        public int getVersion() {
            return 0;
        }

        public StorageArea_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new StorageArea_Internal.Proxy(core, messageReceiver);
        }

        public StorageArea_Internal.Stub buildStub(Core core, StorageArea impl) {
            return new StorageArea_Internal.Stub(core, impl);
        }

        public StorageArea[] buildArray(int size) {
            return new StorageArea[size];
        }
    };

    private static final int ADD_OBSERVER_ORDINAL = 0;

    private static final int PUT_ORDINAL = 1;

    private static final int DELETE_ORDINAL = 2;

    private static final int DELETE_ALL_ORDINAL = 3;

    private static final int GET_ORDINAL = 4;

    private static final int GET_ALL_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements StorageArea.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void addObserver(AssociatedInterfaceNotSupported observer) {
            StorageArea_Internal.StorageAreaAddObserverParams _message = new StorageArea_Internal.StorageAreaAddObserverParams();
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void put(byte[] key, byte[] value, byte[] clientOldValue, String source, StorageArea.PutResponse callback) {
            StorageArea_Internal.StorageAreaPutParams _message = new StorageArea_Internal.StorageAreaPutParams();
            _message.key = key;
            _message.value = value;
            _message.clientOldValue = clientOldValue;
            _message.source = source;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new StorageArea_Internal.StorageAreaPutResponseParamsForwardToCallback(callback));
        }

        public void delete(byte[] key, byte[] clientOldValue, String source, StorageArea.DeleteResponse callback) {
            StorageArea_Internal.StorageAreaDeleteParams _message = new StorageArea_Internal.StorageAreaDeleteParams();
            _message.key = key;
            _message.clientOldValue = clientOldValue;
            _message.source = source;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new StorageArea_Internal.StorageAreaDeleteResponseParamsForwardToCallback(callback));
        }

        public void deleteAll(String source, StorageArea.DeleteAllResponse callback) {
            StorageArea_Internal.StorageAreaDeleteAllParams _message = new StorageArea_Internal.StorageAreaDeleteAllParams();
            _message.source = source;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new StorageArea_Internal.StorageAreaDeleteAllResponseParamsForwardToCallback(callback));
        }

        public void get(byte[] key, StorageArea.GetResponse callback) {
            StorageArea_Internal.StorageAreaGetParams _message = new StorageArea_Internal.StorageAreaGetParams();
            _message.key = key;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new StorageArea_Internal.StorageAreaGetResponseParamsForwardToCallback(callback));
        }

        public void getAll(AssociatedInterfaceNotSupported completeCallback, StorageArea.GetAllResponse callback) {
            StorageArea_Internal.StorageAreaGetAllParams _message = new StorageArea_Internal.StorageAreaGetAllParams();
            _message.completeCallback = completeCallback;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new StorageArea_Internal.StorageAreaGetAllResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<StorageArea> {
        Stub(Core core, StorageArea impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                StorageArea_Internal.StorageAreaAddObserverParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(StorageArea_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = StorageArea_Internal.StorageAreaAddObserverParams.deserialize(messageWithHeader.getPayload());
                        ((StorageArea)getImpl()).addObserver(data.observer);
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
                StorageArea_Internal.StorageAreaPutParams storageAreaPutParams;
                StorageArea_Internal.StorageAreaDeleteParams storageAreaDeleteParams;
                StorageArea_Internal.StorageAreaDeleteAllParams storageAreaDeleteAllParams;
                StorageArea_Internal.StorageAreaGetParams storageAreaGetParams;
                StorageArea_Internal.StorageAreaGetAllParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), StorageArea_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        storageAreaPutParams = StorageArea_Internal.StorageAreaPutParams.deserialize(messageWithHeader.getPayload());
                        ((StorageArea)getImpl()).put(storageAreaPutParams.key, storageAreaPutParams.value, storageAreaPutParams.clientOldValue, storageAreaPutParams.source, new StorageArea_Internal.StorageAreaPutResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        storageAreaDeleteParams = StorageArea_Internal.StorageAreaDeleteParams.deserialize(messageWithHeader.getPayload());
                        ((StorageArea)getImpl()).delete(storageAreaDeleteParams.key, storageAreaDeleteParams.clientOldValue, storageAreaDeleteParams.source, new StorageArea_Internal.StorageAreaDeleteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        storageAreaDeleteAllParams = StorageArea_Internal.StorageAreaDeleteAllParams.deserialize(messageWithHeader.getPayload());
                        ((StorageArea)getImpl()).deleteAll(storageAreaDeleteAllParams.source, new StorageArea_Internal.StorageAreaDeleteAllResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        storageAreaGetParams = StorageArea_Internal.StorageAreaGetParams.deserialize(messageWithHeader.getPayload());
                        ((StorageArea)getImpl()).get(storageAreaGetParams.key, new StorageArea_Internal.StorageAreaGetResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        data = StorageArea_Internal.StorageAreaGetAllParams.deserialize(messageWithHeader.getPayload());
                        ((StorageArea)getImpl()).getAll(data.completeCallback, new StorageArea_Internal.StorageAreaGetAllResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class StorageAreaAddObserverParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported observer;

        private StorageAreaAddObserverParams(int version) {
            super(16, version);
        }

        public StorageAreaAddObserverParams() {
            this(0);
        }

        public static StorageAreaAddObserverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaAddObserverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaAddObserverParams decode(Decoder decoder0) {
            StorageAreaAddObserverParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaAddObserverParams(elementsOrVersion);
                result.observer = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.observer, 8, false);
        }
    }

    static final class StorageAreaPutParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] key;

        public byte[] value;

        public byte[] clientOldValue;

        public String source;

        private StorageAreaPutParams(int version) {
            super(40, version);
        }

        public StorageAreaPutParams() {
            this(0);
        }

        public static StorageAreaPutParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaPutParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaPutParams decode(Decoder decoder0) {
            StorageAreaPutParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaPutParams(elementsOrVersion);
                result.key = decoder0.readBytes(8, 0, -1);
                result.value = decoder0.readBytes(16, 0, -1);
                result.clientOldValue = decoder0.readBytes(24, 1, -1);
                result.source = decoder0.readString(32, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, 0, -1);
            encoder0.encode(this.value, 16, 0, -1);
            encoder0.encode(this.clientOldValue, 24, 1, -1);
            encoder0.encode(this.source, 32, false);
        }
    }

    static final class StorageAreaPutResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private StorageAreaPutResponseParams(int version) {
            super(16, version);
        }

        public StorageAreaPutResponseParams() {
            this(0);
        }

        public static StorageAreaPutResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaPutResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaPutResponseParams decode(Decoder decoder0) {
            StorageAreaPutResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaPutResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class StorageAreaPutResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final StorageArea.PutResponse mCallback;

        StorageAreaPutResponseParamsForwardToCallback(StorageArea.PutResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                StorageArea_Internal.StorageAreaPutResponseParams response = StorageArea_Internal.StorageAreaPutResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class StorageAreaPutResponseParamsProxyToResponder implements StorageArea.PutResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        StorageAreaPutResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            StorageArea_Internal.StorageAreaPutResponseParams _response = new StorageArea_Internal.StorageAreaPutResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class StorageAreaDeleteParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] key;

        public byte[] clientOldValue;

        public String source;

        private StorageAreaDeleteParams(int version) {
            super(32, version);
        }

        public StorageAreaDeleteParams() {
            this(0);
        }

        public static StorageAreaDeleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaDeleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaDeleteParams decode(Decoder decoder0) {
            StorageAreaDeleteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaDeleteParams(elementsOrVersion);
                result.key = decoder0.readBytes(8, 0, -1);
                result.clientOldValue = decoder0.readBytes(16, 1, -1);
                result.source = decoder0.readString(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, 0, -1);
            encoder0.encode(this.clientOldValue, 16, 1, -1);
            encoder0.encode(this.source, 24, false);
        }
    }

    static final class StorageAreaDeleteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private StorageAreaDeleteResponseParams(int version) {
            super(16, version);
        }

        public StorageAreaDeleteResponseParams() {
            this(0);
        }

        public static StorageAreaDeleteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaDeleteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaDeleteResponseParams decode(Decoder decoder0) {
            StorageAreaDeleteResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaDeleteResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class StorageAreaDeleteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final StorageArea.DeleteResponse mCallback;

        StorageAreaDeleteResponseParamsForwardToCallback(StorageArea.DeleteResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                StorageArea_Internal.StorageAreaDeleteResponseParams response = StorageArea_Internal.StorageAreaDeleteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class StorageAreaDeleteResponseParamsProxyToResponder implements StorageArea.DeleteResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        StorageAreaDeleteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            StorageArea_Internal.StorageAreaDeleteResponseParams _response = new StorageArea_Internal.StorageAreaDeleteResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class StorageAreaDeleteAllParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String source;

        private StorageAreaDeleteAllParams(int version) {
            super(16, version);
        }

        public StorageAreaDeleteAllParams() {
            this(0);
        }

        public static StorageAreaDeleteAllParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaDeleteAllParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaDeleteAllParams decode(Decoder decoder0) {
            StorageAreaDeleteAllParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaDeleteAllParams(elementsOrVersion);
                result.source = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.source, 8, false);
        }
    }

    static final class StorageAreaDeleteAllResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private StorageAreaDeleteAllResponseParams(int version) {
            super(16, version);
        }

        public StorageAreaDeleteAllResponseParams() {
            this(0);
        }

        public static StorageAreaDeleteAllResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaDeleteAllResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaDeleteAllResponseParams decode(Decoder decoder0) {
            StorageAreaDeleteAllResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaDeleteAllResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class StorageAreaDeleteAllResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final StorageArea.DeleteAllResponse mCallback;

        StorageAreaDeleteAllResponseParamsForwardToCallback(StorageArea.DeleteAllResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                StorageArea_Internal.StorageAreaDeleteAllResponseParams response = StorageArea_Internal.StorageAreaDeleteAllResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class StorageAreaDeleteAllResponseParamsProxyToResponder implements StorageArea.DeleteAllResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        StorageAreaDeleteAllResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            StorageArea_Internal.StorageAreaDeleteAllResponseParams _response = new StorageArea_Internal.StorageAreaDeleteAllResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class StorageAreaGetParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] key;

        private StorageAreaGetParams(int version) {
            super(16, version);
        }

        public StorageAreaGetParams() {
            this(0);
        }

        public static StorageAreaGetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaGetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaGetParams decode(Decoder decoder0) {
            StorageAreaGetParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaGetParams(elementsOrVersion);
                result.key = decoder0.readBytes(8, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, 0, -1);
        }
    }

    static final class StorageAreaGetResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public byte[] value;

        private StorageAreaGetResponseParams(int version) {
            super(24, version);
        }

        public StorageAreaGetResponseParams() {
            this(0);
        }

        public static StorageAreaGetResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaGetResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaGetResponseParams decode(Decoder decoder0) {
            StorageAreaGetResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaGetResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.value = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.value, 16, 0, -1);
        }
    }

    static class StorageAreaGetResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final StorageArea.GetResponse mCallback;

        StorageAreaGetResponseParamsForwardToCallback(StorageArea.GetResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                StorageArea_Internal.StorageAreaGetResponseParams response = StorageArea_Internal.StorageAreaGetResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.value);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class StorageAreaGetResponseParamsProxyToResponder implements StorageArea.GetResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        StorageAreaGetResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, byte[] value) {
            StorageArea_Internal.StorageAreaGetResponseParams _response = new StorageArea_Internal.StorageAreaGetResponseParams();
            _response.success = success.booleanValue();
            _response.value = value;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class StorageAreaGetAllParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported completeCallback;

        private StorageAreaGetAllParams(int version) {
            super(16, version);
        }

        public StorageAreaGetAllParams() {
            this(0);
        }

        public static StorageAreaGetAllParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaGetAllParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaGetAllParams decode(Decoder decoder0) {
            StorageAreaGetAllParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaGetAllParams(elementsOrVersion);
                result.completeCallback = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.completeCallback, 8, false);
        }
    }

    static final class StorageAreaGetAllResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public KeyValue[] data;

        private StorageAreaGetAllResponseParams(int version) {
            super(24, version);
        }

        public StorageAreaGetAllResponseParams() {
            this(0);
        }

        public static StorageAreaGetAllResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaGetAllResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaGetAllResponseParams decode(Decoder decoder0) {
            StorageAreaGetAllResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaGetAllResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.data = new KeyValue[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.data[i1] = KeyValue.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            if (this.data == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.data.length, 16, -1);
                for (int i0 = 0; i0 < this.data.length; i0++)
                    encoder1.encode(this.data[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class StorageAreaGetAllResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final StorageArea.GetAllResponse mCallback;

        StorageAreaGetAllResponseParamsForwardToCallback(StorageArea.GetAllResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                StorageArea_Internal.StorageAreaGetAllResponseParams response = StorageArea_Internal.StorageAreaGetAllResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class StorageAreaGetAllResponseParamsProxyToResponder implements StorageArea.GetAllResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        StorageAreaGetAllResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, KeyValue[] data) {
            StorageArea_Internal.StorageAreaGetAllResponseParams _response = new StorageArea_Internal.StorageAreaGetAllResponseParams();
            _response.success = success.booleanValue();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
