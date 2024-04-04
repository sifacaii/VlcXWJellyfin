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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WorkerContentSettingsProxy_Internal {
    public static final Interface.Manager<WorkerContentSettingsProxy, WorkerContentSettingsProxy.Proxy> MANAGER = new Interface.Manager<WorkerContentSettingsProxy, WorkerContentSettingsProxy.Proxy>() {
        public String getName() {
            return "blink.mojom.WorkerContentSettingsProxy";
        }

        public int getVersion() {
            return 0;
        }

        public WorkerContentSettingsProxy_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WorkerContentSettingsProxy_Internal.Proxy(core, messageReceiver);
        }

        public WorkerContentSettingsProxy_Internal.Stub buildStub(Core core, WorkerContentSettingsProxy impl) {
            return new WorkerContentSettingsProxy_Internal.Stub(core, impl);
        }

        public WorkerContentSettingsProxy[] buildArray(int size) {
            return new WorkerContentSettingsProxy[size];
        }
    };

    private static final int ALLOW_INDEXED_DB_ORDINAL = 0;

    private static final int ALLOW_CACHE_STORAGE_ORDINAL = 1;

    private static final int REQUEST_FILE_SYSTEM_ACCESS_SYNC_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements WorkerContentSettingsProxy.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void allowIndexedDb(WorkerContentSettingsProxy.AllowIndexedDbResponse callback) {
            WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbParams _message = new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbResponseParamsForwardToCallback(callback));
        }

        public void allowCacheStorage(WorkerContentSettingsProxy.AllowCacheStorageResponse callback) {
            WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageParams _message = new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageResponseParamsForwardToCallback(callback));
        }

        public void requestFileSystemAccessSync(WorkerContentSettingsProxy.RequestFileSystemAccessSyncResponse callback) {
            WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncParams _message = new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<WorkerContentSettingsProxy> {
        Stub(Core core, WorkerContentSettingsProxy impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WorkerContentSettingsProxy_Internal.MANAGER, messageWithHeader);
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
                                getCore(), WorkerContentSettingsProxy_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbParams.deserialize(messageWithHeader.getPayload());
                        ((WorkerContentSettingsProxy)getImpl()).allowIndexedDb(new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageParams.deserialize(messageWithHeader.getPayload());
                        ((WorkerContentSettingsProxy)getImpl()).allowCacheStorage(new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncParams.deserialize(messageWithHeader.getPayload());
                        ((WorkerContentSettingsProxy)getImpl()).requestFileSystemAccessSync(new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WorkerContentSettingsProxyAllowIndexedDbParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WorkerContentSettingsProxyAllowIndexedDbParams(int version) {
            super(8, version);
        }

        public WorkerContentSettingsProxyAllowIndexedDbParams() {
            this(0);
        }

        public static WorkerContentSettingsProxyAllowIndexedDbParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WorkerContentSettingsProxyAllowIndexedDbParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WorkerContentSettingsProxyAllowIndexedDbParams decode(Decoder decoder0) {
            WorkerContentSettingsProxyAllowIndexedDbParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WorkerContentSettingsProxyAllowIndexedDbParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WorkerContentSettingsProxyAllowIndexedDbResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean result;

        private WorkerContentSettingsProxyAllowIndexedDbResponseParams(int version) {
            super(16, version);
        }

        public WorkerContentSettingsProxyAllowIndexedDbResponseParams() {
            this(0);
        }

        public static WorkerContentSettingsProxyAllowIndexedDbResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WorkerContentSettingsProxyAllowIndexedDbResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WorkerContentSettingsProxyAllowIndexedDbResponseParams decode(Decoder decoder0) {
            WorkerContentSettingsProxyAllowIndexedDbResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WorkerContentSettingsProxyAllowIndexedDbResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, 0);
        }
    }

    static class WorkerContentSettingsProxyAllowIndexedDbResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WorkerContentSettingsProxy.AllowIndexedDbResponse mCallback;

        WorkerContentSettingsProxyAllowIndexedDbResponseParamsForwardToCallback(WorkerContentSettingsProxy.AllowIndexedDbResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbResponseParams response = WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WorkerContentSettingsProxyAllowIndexedDbResponseParamsProxyToResponder implements WorkerContentSettingsProxy.AllowIndexedDbResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WorkerContentSettingsProxyAllowIndexedDbResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean result) {
            WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbResponseParams _response = new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowIndexedDbResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WorkerContentSettingsProxyAllowCacheStorageParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WorkerContentSettingsProxyAllowCacheStorageParams(int version) {
            super(8, version);
        }

        public WorkerContentSettingsProxyAllowCacheStorageParams() {
            this(0);
        }

        public static WorkerContentSettingsProxyAllowCacheStorageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WorkerContentSettingsProxyAllowCacheStorageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WorkerContentSettingsProxyAllowCacheStorageParams decode(Decoder decoder0) {
            WorkerContentSettingsProxyAllowCacheStorageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WorkerContentSettingsProxyAllowCacheStorageParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WorkerContentSettingsProxyAllowCacheStorageResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean result;

        private WorkerContentSettingsProxyAllowCacheStorageResponseParams(int version) {
            super(16, version);
        }

        public WorkerContentSettingsProxyAllowCacheStorageResponseParams() {
            this(0);
        }

        public static WorkerContentSettingsProxyAllowCacheStorageResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WorkerContentSettingsProxyAllowCacheStorageResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WorkerContentSettingsProxyAllowCacheStorageResponseParams decode(Decoder decoder0) {
            WorkerContentSettingsProxyAllowCacheStorageResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WorkerContentSettingsProxyAllowCacheStorageResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, 0);
        }
    }

    static class WorkerContentSettingsProxyAllowCacheStorageResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WorkerContentSettingsProxy.AllowCacheStorageResponse mCallback;

        WorkerContentSettingsProxyAllowCacheStorageResponseParamsForwardToCallback(WorkerContentSettingsProxy.AllowCacheStorageResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageResponseParams response = WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WorkerContentSettingsProxyAllowCacheStorageResponseParamsProxyToResponder implements WorkerContentSettingsProxy.AllowCacheStorageResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WorkerContentSettingsProxyAllowCacheStorageResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean result) {
            WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageResponseParams _response = new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyAllowCacheStorageResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WorkerContentSettingsProxyRequestFileSystemAccessSyncParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WorkerContentSettingsProxyRequestFileSystemAccessSyncParams(int version) {
            super(8, version);
        }

        public WorkerContentSettingsProxyRequestFileSystemAccessSyncParams() {
            this(0);
        }

        public static WorkerContentSettingsProxyRequestFileSystemAccessSyncParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WorkerContentSettingsProxyRequestFileSystemAccessSyncParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WorkerContentSettingsProxyRequestFileSystemAccessSyncParams decode(Decoder decoder0) {
            WorkerContentSettingsProxyRequestFileSystemAccessSyncParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WorkerContentSettingsProxyRequestFileSystemAccessSyncParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean result;

        private WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams(int version) {
            super(16, version);
        }

        public WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams() {
            this(0);
        }

        public static WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams decode(Decoder decoder0) {
            WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, 0);
        }
    }

    static class WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WorkerContentSettingsProxy.RequestFileSystemAccessSyncResponse mCallback;

        WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsForwardToCallback(WorkerContentSettingsProxy.RequestFileSystemAccessSyncResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams response = WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsProxyToResponder implements WorkerContentSettingsProxy.RequestFileSystemAccessSyncResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean result) {
            WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams _response = new WorkerContentSettingsProxy_Internal.WorkerContentSettingsProxyRequestFileSystemAccessSyncResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
