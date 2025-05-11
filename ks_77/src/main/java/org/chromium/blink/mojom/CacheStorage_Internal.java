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
import org.chromium.mojo_base.mojom.String16;

class CacheStorage_Internal {
    public static final Interface.Manager<CacheStorage, CacheStorage.Proxy> MANAGER = new Interface.Manager<CacheStorage, CacheStorage.Proxy>() {
        public String getName() {
            return "blink.mojom.CacheStorage";
        }

        public int getVersion() {
            return 0;
        }

        public CacheStorage_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CacheStorage_Internal.Proxy(core, messageReceiver);
        }

        public CacheStorage_Internal.Stub buildStub(Core core, CacheStorage impl) {
            return new CacheStorage_Internal.Stub(core, impl);
        }

        public CacheStorage[] buildArray(int size) {
            return new CacheStorage[size];
        }
    };

    private static final int HAS_ORDINAL = 0;

    private static final int DELETE_ORDINAL = 1;

    private static final int KEYS_ORDINAL = 2;

    private static final int MATCH_ORDINAL = 3;

    private static final int OPEN_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements CacheStorage.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void has(String16 cacheName, long traceId, CacheStorage.HasResponse callback) {
            CacheStorage_Internal.CacheStorageHasParams _message = new CacheStorage_Internal.CacheStorageHasParams();
            _message.cacheName = cacheName;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CacheStorage_Internal.CacheStorageHasResponseParamsForwardToCallback(callback));
        }

        public void delete(String16 cacheName, long traceId, CacheStorage.DeleteResponse callback) {
            CacheStorage_Internal.CacheStorageDeleteParams _message = new CacheStorage_Internal.CacheStorageDeleteParams();
            _message.cacheName = cacheName;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CacheStorage_Internal.CacheStorageDeleteResponseParamsForwardToCallback(callback));
        }

        public void keys(long traceId, CacheStorage.KeysResponse callback) {
            CacheStorage_Internal.CacheStorageKeysParams _message = new CacheStorage_Internal.CacheStorageKeysParams();
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new CacheStorage_Internal.CacheStorageKeysResponseParamsForwardToCallback(callback));
        }

        public void match(FetchApiRequest request, MultiCacheQueryOptions matchOptions, long traceId, CacheStorage.MatchResponse callback) {
            CacheStorage_Internal.CacheStorageMatchParams _message = new CacheStorage_Internal.CacheStorageMatchParams();
            _message.request = request;
            _message.matchOptions = matchOptions;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new CacheStorage_Internal.CacheStorageMatchResponseParamsForwardToCallback(callback));
        }

        public void open(String16 cacheName, long traceId, CacheStorage.OpenResponse callback) {
            CacheStorage_Internal.CacheStorageOpenParams _message = new CacheStorage_Internal.CacheStorageOpenParams();
            _message.cacheName = cacheName;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new CacheStorage_Internal.CacheStorageOpenResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CacheStorage> {
        Stub(Core core, CacheStorage impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CacheStorage_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CacheStorage_Internal.CacheStorageHasParams cacheStorageHasParams;
                CacheStorage_Internal.CacheStorageDeleteParams cacheStorageDeleteParams;
                CacheStorage_Internal.CacheStorageKeysParams cacheStorageKeysParams;
                CacheStorage_Internal.CacheStorageMatchParams cacheStorageMatchParams;
                CacheStorage_Internal.CacheStorageOpenParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CacheStorage_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        cacheStorageHasParams = CacheStorage_Internal.CacheStorageHasParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorage)getImpl()).has(cacheStorageHasParams.cacheName, cacheStorageHasParams.traceId, new CacheStorage_Internal.CacheStorageHasResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        cacheStorageDeleteParams = CacheStorage_Internal.CacheStorageDeleteParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorage)getImpl()).delete(cacheStorageDeleteParams.cacheName, cacheStorageDeleteParams.traceId, new CacheStorage_Internal.CacheStorageDeleteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        cacheStorageKeysParams = CacheStorage_Internal.CacheStorageKeysParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorage)getImpl()).keys(cacheStorageKeysParams.traceId, new CacheStorage_Internal.CacheStorageKeysResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        cacheStorageMatchParams = CacheStorage_Internal.CacheStorageMatchParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorage)getImpl()).match(cacheStorageMatchParams.request, cacheStorageMatchParams.matchOptions, cacheStorageMatchParams.traceId, new CacheStorage_Internal.CacheStorageMatchResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        data = CacheStorage_Internal.CacheStorageOpenParams.deserialize(messageWithHeader.getPayload());
                        ((CacheStorage)getImpl()).open(data.cacheName, data.traceId, new CacheStorage_Internal.CacheStorageOpenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CacheStorageHasParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 cacheName;

        public long traceId;

        private CacheStorageHasParams(int version) {
            super(24, version);
        }

        public CacheStorageHasParams() {
            this(0);
        }

        public static CacheStorageHasParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageHasParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageHasParams decode(Decoder decoder0) {
            CacheStorageHasParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageHasParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cacheName = String16.decode(decoder1);
                result.traceId = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.cacheName, 8, false);
            encoder0.encode(this.traceId, 16);
        }
    }

    static final class CacheStorageHasResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private CacheStorageHasResponseParams(int version) {
            super(16, version);
        }

        public CacheStorageHasResponseParams() {
            this(0);
        }

        public static CacheStorageHasResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageHasResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageHasResponseParams decode(Decoder decoder0) {
            CacheStorageHasResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageHasResponseParams(elementsOrVersion);
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

    static class CacheStorageHasResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorage.HasResponse mCallback;

        CacheStorageHasResponseParamsForwardToCallback(CacheStorage.HasResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CacheStorage_Internal.CacheStorageHasResponseParams response = CacheStorage_Internal.CacheStorageHasResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageHasResponseParamsProxyToResponder implements CacheStorage.HasResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageHasResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            CacheStorage_Internal.CacheStorageHasResponseParams _response = new CacheStorage_Internal.CacheStorageHasResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageDeleteParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 cacheName;

        public long traceId;

        private CacheStorageDeleteParams(int version) {
            super(24, version);
        }

        public CacheStorageDeleteParams() {
            this(0);
        }

        public static CacheStorageDeleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageDeleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageDeleteParams decode(Decoder decoder0) {
            CacheStorageDeleteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageDeleteParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cacheName = String16.decode(decoder1);
                result.traceId = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.cacheName, 8, false);
            encoder0.encode(this.traceId, 16);
        }
    }

    static final class CacheStorageDeleteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private CacheStorageDeleteResponseParams(int version) {
            super(16, version);
        }

        public CacheStorageDeleteResponseParams() {
            this(0);
        }

        public static CacheStorageDeleteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageDeleteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageDeleteResponseParams decode(Decoder decoder0) {
            CacheStorageDeleteResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageDeleteResponseParams(elementsOrVersion);
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

    static class CacheStorageDeleteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorage.DeleteResponse mCallback;

        CacheStorageDeleteResponseParamsForwardToCallback(CacheStorage.DeleteResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                CacheStorage_Internal.CacheStorageDeleteResponseParams response = CacheStorage_Internal.CacheStorageDeleteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageDeleteResponseParamsProxyToResponder implements CacheStorage.DeleteResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageDeleteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            CacheStorage_Internal.CacheStorageDeleteResponseParams _response = new CacheStorage_Internal.CacheStorageDeleteResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageKeysParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long traceId;

        private CacheStorageKeysParams(int version) {
            super(16, version);
        }

        public CacheStorageKeysParams() {
            this(0);
        }

        public static CacheStorageKeysParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageKeysParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageKeysParams decode(Decoder decoder0) {
            CacheStorageKeysParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageKeysParams(elementsOrVersion);
                result.traceId = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.traceId, 8);
        }
    }

    static final class CacheStorageKeysResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16[] keys;

        private CacheStorageKeysResponseParams(int version) {
            super(16, version);
        }

        public CacheStorageKeysResponseParams() {
            this(0);
        }

        public static CacheStorageKeysResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageKeysResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageKeysResponseParams decode(Decoder decoder0) {
            CacheStorageKeysResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageKeysResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.keys = new String16[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.keys[i1] = String16.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.keys == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.keys.length, 8, -1);
                for (int i0 = 0; i0 < this.keys.length; i0++)
                    encoder1.encode((Struct)this.keys[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class CacheStorageKeysResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorage.KeysResponse mCallback;

        CacheStorageKeysResponseParamsForwardToCallback(CacheStorage.KeysResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                CacheStorage_Internal.CacheStorageKeysResponseParams response = CacheStorage_Internal.CacheStorageKeysResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.keys);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageKeysResponseParamsProxyToResponder implements CacheStorage.KeysResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageKeysResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String16[] keys) {
            CacheStorage_Internal.CacheStorageKeysResponseParams _response = new CacheStorage_Internal.CacheStorageKeysResponseParams();
            _response.keys = keys;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageMatchParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiRequest request;

        public MultiCacheQueryOptions matchOptions;

        public long traceId;

        private CacheStorageMatchParams(int version) {
            super(32, version);
        }

        public CacheStorageMatchParams() {
            this(0);
        }

        public static CacheStorageMatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageMatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageMatchParams decode(Decoder decoder0) {
            CacheStorageMatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageMatchParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.request = FetchApiRequest.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.matchOptions = MultiCacheQueryOptions.decode(decoder1);
                result.traceId = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, false);
            encoder0.encode(this.matchOptions, 16, false);
            encoder0.encode(this.traceId, 24);
        }
    }

    static final class CacheStorageMatchResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MatchResult result;

        private CacheStorageMatchResponseParams(int version) {
            super(24, version);
        }

        public CacheStorageMatchResponseParams() {
            this(0);
        }

        public static CacheStorageMatchResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageMatchResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageMatchResponseParams decode(Decoder decoder0) {
            CacheStorageMatchResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageMatchResponseParams(elementsOrVersion);
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

    static class CacheStorageMatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorage.MatchResponse mCallback;

        CacheStorageMatchResponseParamsForwardToCallback(CacheStorage.MatchResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                CacheStorage_Internal.CacheStorageMatchResponseParams response = CacheStorage_Internal.CacheStorageMatchResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageMatchResponseParamsProxyToResponder implements CacheStorage.MatchResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageMatchResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(MatchResult result) {
            CacheStorage_Internal.CacheStorageMatchResponseParams _response = new CacheStorage_Internal.CacheStorageMatchResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CacheStorageOpenParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 cacheName;

        public long traceId;

        private CacheStorageOpenParams(int version) {
            super(24, version);
        }

        public CacheStorageOpenParams() {
            this(0);
        }

        public static CacheStorageOpenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageOpenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageOpenParams decode(Decoder decoder0) {
            CacheStorageOpenParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageOpenParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cacheName = String16.decode(decoder1);
                result.traceId = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.cacheName, 8, false);
            encoder0.encode(this.traceId, 16);
        }
    }

    static final class CacheStorageOpenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public OpenResult result;

        private CacheStorageOpenResponseParams(int version) {
            super(24, version);
        }

        public CacheStorageOpenResponseParams() {
            this(0);
        }

        public static CacheStorageOpenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CacheStorageOpenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CacheStorageOpenResponseParams decode(Decoder decoder0) {
            CacheStorageOpenResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CacheStorageOpenResponseParams(elementsOrVersion);
                result.result = OpenResult.decode(decoder0, 8);
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

    static class CacheStorageOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CacheStorage.OpenResponse mCallback;

        CacheStorageOpenResponseParamsForwardToCallback(CacheStorage.OpenResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                CacheStorage_Internal.CacheStorageOpenResponseParams response = CacheStorage_Internal.CacheStorageOpenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CacheStorageOpenResponseParamsProxyToResponder implements CacheStorage.OpenResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CacheStorageOpenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(OpenResult result) {
            CacheStorage_Internal.CacheStorageOpenResponseParams _response = new CacheStorage_Internal.CacheStorageOpenResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
