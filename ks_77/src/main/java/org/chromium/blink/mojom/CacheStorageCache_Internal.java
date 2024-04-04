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
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

class CacheStorageCache_Internal {
    public static final Interface.Manager<CacheStorageCache, CacheStorageCache.Proxy> MANAGER = new Interface.Manager<CacheStorageCache, CacheStorageCache.Proxy>() {
        public String getName() {
            return "blink.mojom.CacheStorageCache";
        }

        public int getVersion() {
            return 0;
        }

        public CacheStorageCache_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CacheStorageCache_Internal.Proxy(core, messageReceiver);
        }

        public CacheStorageCache_Internal.Stub buildStub(Core core, CacheStorageCache impl) {
            return new CacheStorageCache_Internal.Stub(core, impl);
        }

        public CacheStorageCache[] buildArray(int size) {
            return new CacheStorageCache[size];
        }
    };

    private static final int MATCH_ORDINAL = 0;

    private static final int MATCH_ALL_ORDINAL = 1;

    private static final int KEYS_ORDINAL = 2;

    private static final int BATCH_ORDINAL = 3;

    private static final int SET_SIDE_DATA_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements CacheStorageCache.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void match(FetchApiRequest request, CacheQueryOptions queryOptions, long traceId, CacheStorageCache.MatchResponse callback) {
            CacheStorageCache_Internal.CacheStorageCacheMatchParams _message = new CacheStorageCache_Internal.CacheStorageCacheMatchParams();
            _message.request = request;
            _message.queryOptions = queryOptions;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CacheStorageCache_Internal.CacheStorageCacheMatchResponseParamsForwardToCallback(callback));
        }

        public void matchAll(FetchApiRequest request, CacheQueryOptions queryOptions, long traceId, CacheStorageCache.MatchAllResponse callback) {
            CacheStorageCache_Internal.CacheStorageCacheMatchAllParams _message = new CacheStorageCache_Internal.CacheStorageCacheMatchAllParams();
            _message.request = request;
            _message.queryOptions = queryOptions;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CacheStorageCache_Internal.CacheStorageCacheMatchAllResponseParamsForwardToCallback(callback));
        }

        public void keys(FetchApiRequest request, CacheQueryOptions queryOptions, long traceId, CacheStorageCache.KeysResponse callback) {
            CacheStorageCache_Internal.CacheStorageCacheKeysParams _message = new CacheStorageCache_Internal.CacheStorageCacheKeysParams();
            _message.request = request;
            _message.queryOptions = queryOptions;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new CacheStorageCache_Internal.CacheStorageCacheKeysResponseParamsForwardToCallback(callback));
        }

        public void batch(BatchOperation[] batchOperations, long traceId, CacheStorageCache.BatchResponse callback) {
            CacheStorageCache_Internal.CacheStorageCacheBatchParams _message = new CacheStorageCache_Internal.CacheStorageCacheBatchParams();
            _message.batchOperations = batchOperations;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new CacheStorageCache_Internal.CacheStorageCacheBatchResponseParamsForwardToCallback(callback));
        }

        public void setSideData(Url url, Time responseTime, byte[] sideData, long traceId, CacheStorageCache.SetSideDataResponse callback) {
            CacheStorageCache_Internal.CacheStorageCacheSetSideDataParams _message = new CacheStorageCache_Internal.CacheStorageCacheSetSideDataParams();
            _message.url = url;
            _message.responseTime = responseTime;
            _message.sideData = sideData;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new CacheStorageCache_Internal.CacheStorageCacheSetSideDataResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CacheStorageCache> {
        Stub(Core core, CacheStorageCache impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CacheStorageCache_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CacheStorageCache_Internal.CacheStorageCacheMatchParams cacheStorageCacheMatchParams;
                CacheStorageCache_Internal.CacheStorageCacheMatchAllParams cacheStorageCacheMatchAllParams;
                CacheStorageCache_Internal.CacheStorageCacheKeysParams cacheStorageCacheKeysParams;
                CacheStorageCache_Internal.CacheStorageCacheBatchParams cacheStorageCacheBatchParams;
                CacheStorageCache_Internal.CacheStorageCacheSetSideDataParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CacheStorageCache_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        cacheStorageCacheMatchParams = CacheStorageCache_Internal.CacheStorageCacheMatchParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorageCache)getImpl()).match(cacheStorageCacheMatchParams.request, cacheStorageCacheMatchParams.queryOptions, cacheStorageCacheMatchParams.traceId, new CacheStorageCache_Internal.CacheStorageCacheMatchResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        cacheStorageCacheMatchAllParams = CacheStorageCache_Internal.CacheStorageCacheMatchAllParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorageCache)getImpl()).matchAll(cacheStorageCacheMatchAllParams.request, cacheStorageCacheMatchAllParams.queryOptions, cacheStorageCacheMatchAllParams.traceId, new CacheStorageCache_Internal.CacheStorageCacheMatchAllResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        cacheStorageCacheKeysParams = CacheStorageCache_Internal.CacheStorageCacheKeysParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorageCache)getImpl()).keys(cacheStorageCacheKeysParams.request, cacheStorageCacheKeysParams.queryOptions, cacheStorageCacheKeysParams.traceId, new CacheStorageCache_Internal.CacheStorageCacheKeysResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        cacheStorageCacheBatchParams = CacheStorageCache_Internal.CacheStorageCacheBatchParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorageCache)getImpl()).batch(cacheStorageCacheBatchParams.batchOperations, cacheStorageCacheBatchParams.traceId, new CacheStorageCache_Internal.CacheStorageCacheBatchResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        data = CacheStorageCache_Internal.CacheStorageCacheSetSideDataParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorageCache)getImpl()).setSideData(data.url, data.responseTime, data.sideData, data.traceId, new CacheStorageCache_Internal.CacheStorageCacheSetSideDataResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CacheStorageCacheMatchParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiRequest request;

        public CacheQueryOptions queryOptions;

        public long traceId;

        private CacheStorageCacheMatchParams(int version) {
            super(32, version);
        }

        public CacheStorageCacheMatchParams() {
            this(0);
        }

        public static CacheStorageCacheMatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheMatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheMatchParams decode(Decoder decoder0) {
            CacheStorageCacheMatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheMatchParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.request = FetchApiRequest.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.queryOptions = CacheQueryOptions.decode(decoder1);
                result.traceId = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, false);
            encoder0.encode(this.queryOptions, 16, false);
            encoder0.encode(this.traceId, 24);
        }
    }

    static final class CacheStorageCacheMatchResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MatchResult result;

        private CacheStorageCacheMatchResponseParams(int version) {
            super(24, version);
        }

        public CacheStorageCacheMatchResponseParams() {
            this(0);
        }

        public static CacheStorageCacheMatchResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheMatchResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheMatchResponseParams decode(Decoder decoder0) {
            CacheStorageCacheMatchResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheMatchResponseParams(elementsOrVersion);
                result.result = MatchResult.decode(decoder0, 8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class CacheStorageCacheMatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorageCache.MatchResponse mCallback;

        CacheStorageCacheMatchResponseParamsForwardToCallback(CacheStorageCache.MatchResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CacheStorageCache_Internal.CacheStorageCacheMatchResponseParams response = CacheStorageCache_Internal.CacheStorageCacheMatchResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageCacheMatchResponseParamsProxyToResponder implements CacheStorageCache.MatchResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageCacheMatchResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(MatchResult result) {
            CacheStorageCache_Internal.CacheStorageCacheMatchResponseParams _response = new CacheStorageCache_Internal.CacheStorageCacheMatchResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageCacheMatchAllParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiRequest request;

        public CacheQueryOptions queryOptions;

        public long traceId;

        private CacheStorageCacheMatchAllParams(int version) {
            super(32, version);
        }

        public CacheStorageCacheMatchAllParams() {
            this(0);
        }

        public static CacheStorageCacheMatchAllParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheMatchAllParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheMatchAllParams decode(Decoder decoder0) {
            CacheStorageCacheMatchAllParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheMatchAllParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.request = FetchApiRequest.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.queryOptions = CacheQueryOptions.decode(decoder1);
                result.traceId = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, true);
            encoder0.encode(this.queryOptions, 16, false);
            encoder0.encode(this.traceId, 24);
        }
    }

    static final class CacheStorageCacheMatchAllResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MatchAllResult result;

        private CacheStorageCacheMatchAllResponseParams(int version) {
            super(24, version);
        }

        public CacheStorageCacheMatchAllResponseParams() {
            this(0);
        }

        public static CacheStorageCacheMatchAllResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheMatchAllResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheMatchAllResponseParams decode(Decoder decoder0) {
            CacheStorageCacheMatchAllResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheMatchAllResponseParams(elementsOrVersion);
                result.result = MatchAllResult.decode(decoder0, 8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class CacheStorageCacheMatchAllResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorageCache.MatchAllResponse mCallback;

        CacheStorageCacheMatchAllResponseParamsForwardToCallback(CacheStorageCache.MatchAllResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                CacheStorageCache_Internal.CacheStorageCacheMatchAllResponseParams response = CacheStorageCache_Internal.CacheStorageCacheMatchAllResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageCacheMatchAllResponseParamsProxyToResponder implements CacheStorageCache.MatchAllResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageCacheMatchAllResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(MatchAllResult result) {
            CacheStorageCache_Internal.CacheStorageCacheMatchAllResponseParams _response = new CacheStorageCache_Internal.CacheStorageCacheMatchAllResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageCacheKeysParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiRequest request;

        public CacheQueryOptions queryOptions;

        public long traceId;

        private CacheStorageCacheKeysParams(int version) {
            super(32, version);
        }

        public CacheStorageCacheKeysParams() {
            this(0);
        }

        public static CacheStorageCacheKeysParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheKeysParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheKeysParams decode(Decoder decoder0) {
            CacheStorageCacheKeysParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheKeysParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.request = FetchApiRequest.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.queryOptions = CacheQueryOptions.decode(decoder1);
                result.traceId = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, true);
            encoder0.encode(this.queryOptions, 16, false);
            encoder0.encode(this.traceId, 24);
        }
    }

    static final class CacheStorageCacheKeysResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CacheKeysResult result;

        private CacheStorageCacheKeysResponseParams(int version) {
            super(24, version);
        }

        public CacheStorageCacheKeysResponseParams() {
            this(0);
        }

        public static CacheStorageCacheKeysResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheKeysResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheKeysResponseParams decode(Decoder decoder0) {
            CacheStorageCacheKeysResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheKeysResponseParams(elementsOrVersion);
                result.result = CacheKeysResult.decode(decoder0, 8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class CacheStorageCacheKeysResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorageCache.KeysResponse mCallback;

        CacheStorageCacheKeysResponseParamsForwardToCallback(CacheStorageCache.KeysResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                CacheStorageCache_Internal.CacheStorageCacheKeysResponseParams response = CacheStorageCache_Internal.CacheStorageCacheKeysResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageCacheKeysResponseParamsProxyToResponder implements CacheStorageCache.KeysResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageCacheKeysResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CacheKeysResult result) {
            CacheStorageCache_Internal.CacheStorageCacheKeysResponseParams _response = new CacheStorageCache_Internal.CacheStorageCacheKeysResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageCacheBatchParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BatchOperation[] batchOperations;

        public long traceId;

        private CacheStorageCacheBatchParams(int version) {
            super(24, version);
        }

        public CacheStorageCacheBatchParams() {
            this(0);
        }

        public static CacheStorageCacheBatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheBatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheBatchParams decode(Decoder decoder0) {
            CacheStorageCacheBatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheBatchParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.batchOperations = new BatchOperation[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.batchOperations[i1] = BatchOperation.decode(decoder2);
                }
                result.traceId = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.batchOperations == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.batchOperations.length, 8, -1);
                for (int i0 = 0; i0 < this.batchOperations.length; i0++)
                    encoder1.encode(this.batchOperations[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.traceId, 16);
        }
    }

    static final class CacheStorageCacheBatchResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CacheStorageVerboseError result;

        private CacheStorageCacheBatchResponseParams(int version) {
            super(16, version);
        }

        public CacheStorageCacheBatchResponseParams() {
            this(0);
        }

        public static CacheStorageCacheBatchResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheBatchResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheBatchResponseParams decode(Decoder decoder0) {
            CacheStorageCacheBatchResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheBatchResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CacheStorageVerboseError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class CacheStorageCacheBatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorageCache.BatchResponse mCallback;

        CacheStorageCacheBatchResponseParamsForwardToCallback(CacheStorageCache.BatchResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                CacheStorageCache_Internal.CacheStorageCacheBatchResponseParams response = CacheStorageCache_Internal.CacheStorageCacheBatchResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageCacheBatchResponseParamsProxyToResponder implements CacheStorageCache.BatchResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageCacheBatchResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CacheStorageVerboseError result) {
            CacheStorageCache_Internal.CacheStorageCacheBatchResponseParams _response = new CacheStorageCache_Internal.CacheStorageCacheBatchResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageCacheSetSideDataParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public Time responseTime;

        public byte[] sideData;

        public long traceId;

        private CacheStorageCacheSetSideDataParams(int version) {
            super(40, version);
        }

        public CacheStorageCacheSetSideDataParams() {
            this(0);
        }

        public static CacheStorageCacheSetSideDataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheSetSideDataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheSetSideDataParams decode(Decoder decoder0) {
            CacheStorageCacheSetSideDataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheSetSideDataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.responseTime = Time.decode(decoder1);
                result.sideData = decoder0.readBytes(24, 0, -1);
                result.traceId = decoder0.readLong(32);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode((Struct)this.responseTime, 16, false);
            encoder0.encode(this.sideData, 24, 0, -1);
            encoder0.encode(this.traceId, 32);
        }
    }

    static final class CacheStorageCacheSetSideDataResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private CacheStorageCacheSetSideDataResponseParams(int version) {
            super(16, version);
        }

        public CacheStorageCacheSetSideDataResponseParams() {
            this(0);
        }

        public static CacheStorageCacheSetSideDataResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageCacheSetSideDataResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageCacheSetSideDataResponseParams decode(Decoder decoder0) {
            CacheStorageCacheSetSideDataResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageCacheSetSideDataResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                CacheStorageError.validate(result.result);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
        }
    }

    static class CacheStorageCacheSetSideDataResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorageCache.SetSideDataResponse mCallback;

        CacheStorageCacheSetSideDataResponseParamsForwardToCallback(CacheStorageCache.SetSideDataResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                CacheStorageCache_Internal.CacheStorageCacheSetSideDataResponseParams response = CacheStorageCache_Internal.CacheStorageCacheSetSideDataResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageCacheSetSideDataResponseParamsProxyToResponder implements CacheStorageCache.SetSideDataResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageCacheSetSideDataResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            CacheStorageCache_Internal.CacheStorageCacheSetSideDataResponseParams _response = new CacheStorageCache_Internal.CacheStorageCacheSetSideDataResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
