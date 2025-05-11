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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

class CodeCacheHost_Internal {
    public static final Interface.Manager<CodeCacheHost, CodeCacheHost.Proxy> MANAGER = new Interface.Manager<CodeCacheHost, CodeCacheHost.Proxy>() {
        public String getName() {
            return "blink.mojom.CodeCacheHost";
        }

        public int getVersion() {
            return 0;
        }

        public CodeCacheHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CodeCacheHost_Internal.Proxy(core, messageReceiver);
        }

        public CodeCacheHost_Internal.Stub buildStub(Core core, CodeCacheHost impl) {
            return new CodeCacheHost_Internal.Stub(core, impl);
        }

        public CodeCacheHost[] buildArray(int size) {
            return new CodeCacheHost[size];
        }
    };

    private static final int DID_GENERATE_CACHEABLE_METADATA_ORDINAL = 0;

    private static final int FETCH_CACHED_CODE_ORDINAL = 1;

    private static final int CLEAR_CODE_CACHE_ENTRY_ORDINAL = 2;

    private static final int DID_GENERATE_CACHEABLE_METADATA_IN_CACHE_STORAGE_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements CodeCacheHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didGenerateCacheableMetadata(int cacheType, Url url, Time expectedResponseTime, BigBuffer data) {
            CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataParams _message = new CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataParams();
            _message.cacheType = cacheType;
            _message.url = url;
            _message.expectedResponseTime = expectedResponseTime;
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void fetchCachedCode(int cacheType, Url url, CodeCacheHost.FetchCachedCodeResponse callback) {
            CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeParams _message = new CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeParams();
            _message.cacheType = cacheType;
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeResponseParamsForwardToCallback(callback));
        }

        public void clearCodeCacheEntry(int cacheType, Url url) {
            CodeCacheHost_Internal.CodeCacheHostClearCodeCacheEntryParams _message = new CodeCacheHost_Internal.CodeCacheHostClearCodeCacheEntryParams();
            _message.cacheType = cacheType;
            _message.url = url;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void didGenerateCacheableMetadataInCacheStorage(Url url, Time expectedResponseTime, BigBuffer data, Origin cacheStorageOrigin, String cacheStorageCacheName) {
            CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams _message = new CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams();
            _message.url = url;
            _message.expectedResponseTime = expectedResponseTime;
            _message.data = data;
            _message.cacheStorageOrigin = cacheStorageOrigin;
            _message.cacheStorageCacheName = cacheStorageCacheName;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<CodeCacheHost> {
        Stub(Core core, CodeCacheHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataParams codeCacheHostDidGenerateCacheableMetadataParams;
                CodeCacheHost_Internal.CodeCacheHostClearCodeCacheEntryParams codeCacheHostClearCodeCacheEntryParams;
                CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CodeCacheHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        codeCacheHostDidGenerateCacheableMetadataParams = CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataParams.deserialize(messageWithHeader.getPayload());
                        ((CodeCacheHost)getImpl()).didGenerateCacheableMetadata(codeCacheHostDidGenerateCacheableMetadataParams.cacheType, codeCacheHostDidGenerateCacheableMetadataParams.url, codeCacheHostDidGenerateCacheableMetadataParams.expectedResponseTime, codeCacheHostDidGenerateCacheableMetadataParams.data);
                        return true;
                    case 2:
                        codeCacheHostClearCodeCacheEntryParams = CodeCacheHost_Internal.CodeCacheHostClearCodeCacheEntryParams.deserialize(messageWithHeader.getPayload());
                        ((CodeCacheHost)getImpl()).clearCodeCacheEntry(codeCacheHostClearCodeCacheEntryParams.cacheType, codeCacheHostClearCodeCacheEntryParams.url);
                        return true;
                    case 3:
                        data = CodeCacheHost_Internal.CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams.deserialize(messageWithHeader.getPayload());
                        ((CodeCacheHost)getImpl()).didGenerateCacheableMetadataInCacheStorage(data.url, data.expectedResponseTime, data.data, data.cacheStorageOrigin, data.cacheStorageCacheName);
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
                CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CodeCacheHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        data = CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeParams.deserialize(messageWithHeader.getPayload());
                        ((CodeCacheHost)getImpl()).fetchCachedCode(data.cacheType, data.url, new CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CodeCacheHostDidGenerateCacheableMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int cacheType;

        public Url url;

        public Time expectedResponseTime;

        public BigBuffer data;

        private CodeCacheHostDidGenerateCacheableMetadataParams(int version) {
            super(48, version);
        }

        public CodeCacheHostDidGenerateCacheableMetadataParams() {
            this(0);
        }

        public static CodeCacheHostDidGenerateCacheableMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CodeCacheHostDidGenerateCacheableMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CodeCacheHostDidGenerateCacheableMetadataParams decode(Decoder decoder0) {
            CodeCacheHostDidGenerateCacheableMetadataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CodeCacheHostDidGenerateCacheableMetadataParams(elementsOrVersion);
                result.cacheType = decoder0.readInt(8);
                CodeCacheType.validate(result.cacheType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.expectedResponseTime = Time.decode(decoder1);
                result.data = BigBuffer.decode(decoder0, 32);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.cacheType, 8);
            encoder0.encode((Struct)this.url, 16, false);
            encoder0.encode((Struct)this.expectedResponseTime, 24, false);
            encoder0.encode((Union)this.data, 32, false);
        }
    }

    static final class CodeCacheHostFetchCachedCodeParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int cacheType;

        public Url url;

        private CodeCacheHostFetchCachedCodeParams(int version) {
            super(24, version);
        }

        public CodeCacheHostFetchCachedCodeParams() {
            this(0);
        }

        public static CodeCacheHostFetchCachedCodeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CodeCacheHostFetchCachedCodeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CodeCacheHostFetchCachedCodeParams decode(Decoder decoder0) {
            CodeCacheHostFetchCachedCodeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CodeCacheHostFetchCachedCodeParams(elementsOrVersion);
                result.cacheType = decoder0.readInt(8);
                CodeCacheType.validate(result.cacheType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.cacheType, 8);
            encoder0.encode((Struct)this.url, 16, false);
        }
    }

    static final class CodeCacheHostFetchCachedCodeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Time responseTime;

        public BigBuffer data;

        private CodeCacheHostFetchCachedCodeResponseParams(int version) {
            super(32, version);
        }

        public CodeCacheHostFetchCachedCodeResponseParams() {
            this(0);
        }

        public static CodeCacheHostFetchCachedCodeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CodeCacheHostFetchCachedCodeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CodeCacheHostFetchCachedCodeResponseParams decode(Decoder decoder0) {
            CodeCacheHostFetchCachedCodeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CodeCacheHostFetchCachedCodeResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.responseTime = Time.decode(decoder1);
                result.data = BigBuffer.decode(decoder0, 16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.responseTime, 8, false);
            encoder0.encode((Union)this.data, 16, false);
        }
    }

    static class CodeCacheHostFetchCachedCodeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CodeCacheHost.FetchCachedCodeResponse mCallback;

        CodeCacheHostFetchCachedCodeResponseParamsForwardToCallback(CodeCacheHost.FetchCachedCodeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeResponseParams response = CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.responseTime, response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CodeCacheHostFetchCachedCodeResponseParamsProxyToResponder implements CodeCacheHost.FetchCachedCodeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CodeCacheHostFetchCachedCodeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Time responseTime, BigBuffer data) {
            CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeResponseParams _response = new CodeCacheHost_Internal.CodeCacheHostFetchCachedCodeResponseParams();
            _response.responseTime = responseTime;
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CodeCacheHostClearCodeCacheEntryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int cacheType;

        public Url url;

        private CodeCacheHostClearCodeCacheEntryParams(int version) {
            super(24, version);
        }

        public CodeCacheHostClearCodeCacheEntryParams() {
            this(0);
        }

        public static CodeCacheHostClearCodeCacheEntryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CodeCacheHostClearCodeCacheEntryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CodeCacheHostClearCodeCacheEntryParams decode(Decoder decoder0) {
            CodeCacheHostClearCodeCacheEntryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CodeCacheHostClearCodeCacheEntryParams(elementsOrVersion);
                result.cacheType = decoder0.readInt(8);
                CodeCacheType.validate(result.cacheType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.cacheType, 8);
            encoder0.encode((Struct)this.url, 16, false);
        }
    }

    static final class CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public Time expectedResponseTime;

        public BigBuffer data;

        public Origin cacheStorageOrigin;

        public String cacheStorageCacheName;

        private CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams(int version) {
            super(56, version);
        }

        public CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams() {
            this(0);
        }

        public static CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams decode(Decoder decoder0) {
            CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CodeCacheHostDidGenerateCacheableMetadataInCacheStorageParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.expectedResponseTime = Time.decode(decoder1);
                result.data = BigBuffer.decode(decoder0, 24);
                decoder1 = decoder0.readPointer(40, false);
                result.cacheStorageOrigin = Origin.decode(decoder1);
                result.cacheStorageCacheName = decoder0.readString(48, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode((Struct)this.expectedResponseTime, 16, false);
            encoder0.encode((Union)this.data, 24, false);
            encoder0.encode((Struct)this.cacheStorageOrigin, 40, false);
            encoder0.encode(this.cacheStorageCacheName, 48, false);
        }
    }
}
