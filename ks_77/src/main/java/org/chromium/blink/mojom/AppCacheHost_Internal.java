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
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

class AppCacheHost_Internal {
    public static final Interface.Manager<AppCacheHost, AppCacheHost.Proxy> MANAGER = new Interface.Manager<AppCacheHost, AppCacheHost.Proxy>() {
        public String getName() {
            return "blink.mojom.AppCacheHost";
        }

        public int getVersion() {
            return 0;
        }

        public AppCacheHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AppCacheHost_Internal.Proxy(core, messageReceiver);
        }

        public AppCacheHost_Internal.Stub buildStub(Core core, AppCacheHost impl) {
            return new AppCacheHost_Internal.Stub(core, impl);
        }

        public AppCacheHost[] buildArray(int size) {
            return new AppCacheHost[size];
        }
    };

    private static final int SET_SPAWNING_HOST_ID_ORDINAL = 0;

    private static final int SELECT_CACHE_ORDINAL = 1;

    private static final int SELECT_CACHE_FOR_SHARED_WORKER_ORDINAL = 2;

    private static final int MARK_AS_FOREIGN_ENTRY_ORDINAL = 3;

    private static final int GET_STATUS_ORDINAL = 4;

    private static final int START_UPDATE_ORDINAL = 5;

    private static final int SWAP_CACHE_ORDINAL = 6;

    private static final int GET_RESOURCE_LIST_ORDINAL = 7;

    static final class Proxy extends Interface.AbstractProxy implements AppCacheHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setSpawningHostId(UnguessableToken spawningHostId) {
            AppCacheHost_Internal.AppCacheHostSetSpawningHostIdParams _message = new AppCacheHost_Internal.AppCacheHostSetSpawningHostIdParams();
            _message.spawningHostId = spawningHostId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void selectCache(Url documentUrl, long appcacheDocumentWasLoadedFrom, Url optManifestUrl) {
            AppCacheHost_Internal.AppCacheHostSelectCacheParams _message = new AppCacheHost_Internal.AppCacheHostSelectCacheParams();
            _message.documentUrl = documentUrl;
            _message.appcacheDocumentWasLoadedFrom = appcacheDocumentWasLoadedFrom;
            _message.optManifestUrl = optManifestUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void selectCacheForSharedWorker(long appcacheId) {
            AppCacheHost_Internal.AppCacheHostSelectCacheForSharedWorkerParams _message = new AppCacheHost_Internal.AppCacheHostSelectCacheForSharedWorkerParams();
            _message.appcacheId = appcacheId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void markAsForeignEntry(Url documentUrl, long appcacheDocumentWasLoadedFrom) {
            AppCacheHost_Internal.AppCacheHostMarkAsForeignEntryParams _message = new AppCacheHost_Internal.AppCacheHostMarkAsForeignEntryParams();
            _message.documentUrl = documentUrl;
            _message.appcacheDocumentWasLoadedFrom = appcacheDocumentWasLoadedFrom;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void getStatus(AppCacheHost.GetStatusResponse callback) {
            AppCacheHost_Internal.AppCacheHostGetStatusParams _message = new AppCacheHost_Internal.AppCacheHostGetStatusParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new AppCacheHost_Internal.AppCacheHostGetStatusResponseParamsForwardToCallback(callback));
        }

        public void startUpdate(AppCacheHost.StartUpdateResponse callback) {
            AppCacheHost_Internal.AppCacheHostStartUpdateParams _message = new AppCacheHost_Internal.AppCacheHostStartUpdateParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new AppCacheHost_Internal.AppCacheHostStartUpdateResponseParamsForwardToCallback(callback));
        }

        public void swapCache(AppCacheHost.SwapCacheResponse callback) {
            AppCacheHost_Internal.AppCacheHostSwapCacheParams _message = new AppCacheHost_Internal.AppCacheHostSwapCacheParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new AppCacheHost_Internal.AppCacheHostSwapCacheResponseParamsForwardToCallback(callback));
        }

        public void getResourceList(AppCacheHost.GetResourceListResponse callback) {
            AppCacheHost_Internal.AppCacheHostGetResourceListParams _message = new AppCacheHost_Internal.AppCacheHostGetResourceListParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new AppCacheHost_Internal.AppCacheHostGetResourceListResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<AppCacheHost> {
        Stub(Core core, AppCacheHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AppCacheHost_Internal.AppCacheHostSetSpawningHostIdParams appCacheHostSetSpawningHostIdParams;
                AppCacheHost_Internal.AppCacheHostSelectCacheParams appCacheHostSelectCacheParams;
                AppCacheHost_Internal.AppCacheHostSelectCacheForSharedWorkerParams appCacheHostSelectCacheForSharedWorkerParams;
                AppCacheHost_Internal.AppCacheHostMarkAsForeignEntryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AppCacheHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        appCacheHostSetSpawningHostIdParams = AppCacheHost_Internal.AppCacheHostSetSpawningHostIdParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).setSpawningHostId(appCacheHostSetSpawningHostIdParams.spawningHostId);
                        return true;
                    case 1:
                        appCacheHostSelectCacheParams = AppCacheHost_Internal.AppCacheHostSelectCacheParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).selectCache(appCacheHostSelectCacheParams.documentUrl, appCacheHostSelectCacheParams.appcacheDocumentWasLoadedFrom, appCacheHostSelectCacheParams.optManifestUrl);
                        return true;
                    case 2:
                        appCacheHostSelectCacheForSharedWorkerParams = AppCacheHost_Internal.AppCacheHostSelectCacheForSharedWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).selectCacheForSharedWorker(appCacheHostSelectCacheForSharedWorkerParams.appcacheId);
                        return true;
                    case 3:
                        data = AppCacheHost_Internal.AppCacheHostMarkAsForeignEntryParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).markAsForeignEntry(data.documentUrl, data.appcacheDocumentWasLoadedFrom);
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
                                getCore(), AppCacheHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 4:
                        AppCacheHost_Internal.AppCacheHostGetStatusParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).getStatus(new AppCacheHost_Internal.AppCacheHostGetStatusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        AppCacheHost_Internal.AppCacheHostStartUpdateParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).startUpdate(new AppCacheHost_Internal.AppCacheHostStartUpdateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        AppCacheHost_Internal.AppCacheHostSwapCacheParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).swapCache(new AppCacheHost_Internal.AppCacheHostSwapCacheResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        AppCacheHost_Internal.AppCacheHostGetResourceListParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheHost)getImpl()).getResourceList(new AppCacheHost_Internal.AppCacheHostGetResourceListResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AppCacheHostSetSpawningHostIdParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UnguessableToken spawningHostId;

        private AppCacheHostSetSpawningHostIdParams(int version) {
            super(16, version);
        }

        public AppCacheHostSetSpawningHostIdParams() {
            this(0);
        }

        public static AppCacheHostSetSpawningHostIdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostSetSpawningHostIdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostSetSpawningHostIdParams decode(Decoder decoder0) {
            AppCacheHostSetSpawningHostIdParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostSetSpawningHostIdParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.spawningHostId = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.spawningHostId, 8, false);
        }
    }

    static final class AppCacheHostSelectCacheParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url documentUrl;

        public long appcacheDocumentWasLoadedFrom;

        public Url optManifestUrl;

        private AppCacheHostSelectCacheParams(int version) {
            super(32, version);
        }

        public AppCacheHostSelectCacheParams() {
            this(0);
        }

        public static AppCacheHostSelectCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostSelectCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostSelectCacheParams decode(Decoder decoder0) {
            AppCacheHostSelectCacheParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostSelectCacheParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.documentUrl = Url.decode(decoder1);
                result.appcacheDocumentWasLoadedFrom = decoder0.readLong(16);
                decoder1 = decoder0.readPointer(24, false);
                result.optManifestUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.documentUrl, 8, false);
            encoder0.encode(this.appcacheDocumentWasLoadedFrom, 16);
            encoder0.encode((Struct)this.optManifestUrl, 24, false);
        }
    }

    static final class AppCacheHostSelectCacheForSharedWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long appcacheId;

        private AppCacheHostSelectCacheForSharedWorkerParams(int version) {
            super(16, version);
        }

        public AppCacheHostSelectCacheForSharedWorkerParams() {
            this(0);
        }

        public static AppCacheHostSelectCacheForSharedWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostSelectCacheForSharedWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostSelectCacheForSharedWorkerParams decode(Decoder decoder0) {
            AppCacheHostSelectCacheForSharedWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostSelectCacheForSharedWorkerParams(elementsOrVersion);
                result.appcacheId = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.appcacheId, 8);
        }
    }

    static final class AppCacheHostMarkAsForeignEntryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url documentUrl;

        public long appcacheDocumentWasLoadedFrom;

        private AppCacheHostMarkAsForeignEntryParams(int version) {
            super(24, version);
        }

        public AppCacheHostMarkAsForeignEntryParams() {
            this(0);
        }

        public static AppCacheHostMarkAsForeignEntryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostMarkAsForeignEntryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostMarkAsForeignEntryParams decode(Decoder decoder0) {
            AppCacheHostMarkAsForeignEntryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostMarkAsForeignEntryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.documentUrl = Url.decode(decoder1);
                result.appcacheDocumentWasLoadedFrom = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.documentUrl, 8, false);
            encoder0.encode(this.appcacheDocumentWasLoadedFrom, 16);
        }
    }

    static final class AppCacheHostGetStatusParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AppCacheHostGetStatusParams(int version) {
            super(8, version);
        }

        public AppCacheHostGetStatusParams() {
            this(0);
        }

        public static AppCacheHostGetStatusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostGetStatusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostGetStatusParams decode(Decoder decoder0) {
            AppCacheHostGetStatusParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostGetStatusParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AppCacheHostGetStatusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private AppCacheHostGetStatusResponseParams(int version) {
            super(16, version);
        }

        public AppCacheHostGetStatusResponseParams() {
            this(0);
        }

        public static AppCacheHostGetStatusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostGetStatusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostGetStatusResponseParams decode(Decoder decoder0) {
            AppCacheHostGetStatusResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostGetStatusResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                AppCacheStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class AppCacheHostGetStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AppCacheHost.GetStatusResponse mCallback;

        AppCacheHostGetStatusResponseParamsForwardToCallback(AppCacheHost.GetStatusResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                AppCacheHost_Internal.AppCacheHostGetStatusResponseParams response = AppCacheHost_Internal.AppCacheHostGetStatusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AppCacheHostGetStatusResponseParamsProxyToResponder implements AppCacheHost.GetStatusResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AppCacheHostGetStatusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            AppCacheHost_Internal.AppCacheHostGetStatusResponseParams _response = new AppCacheHost_Internal.AppCacheHostGetStatusResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AppCacheHostStartUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AppCacheHostStartUpdateParams(int version) {
            super(8, version);
        }

        public AppCacheHostStartUpdateParams() {
            this(0);
        }

        public static AppCacheHostStartUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostStartUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostStartUpdateParams decode(Decoder decoder0) {
            AppCacheHostStartUpdateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostStartUpdateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AppCacheHostStartUpdateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private AppCacheHostStartUpdateResponseParams(int version) {
            super(16, version);
        }

        public AppCacheHostStartUpdateResponseParams() {
            this(0);
        }

        public static AppCacheHostStartUpdateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostStartUpdateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostStartUpdateResponseParams decode(Decoder decoder0) {
            AppCacheHostStartUpdateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostStartUpdateResponseParams(elementsOrVersion);
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

    static class AppCacheHostStartUpdateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AppCacheHost.StartUpdateResponse mCallback;

        AppCacheHostStartUpdateResponseParamsForwardToCallback(AppCacheHost.StartUpdateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                AppCacheHost_Internal.AppCacheHostStartUpdateResponseParams response = AppCacheHost_Internal.AppCacheHostStartUpdateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AppCacheHostStartUpdateResponseParamsProxyToResponder implements AppCacheHost.StartUpdateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AppCacheHostStartUpdateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            AppCacheHost_Internal.AppCacheHostStartUpdateResponseParams _response = new AppCacheHost_Internal.AppCacheHostStartUpdateResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AppCacheHostSwapCacheParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AppCacheHostSwapCacheParams(int version) {
            super(8, version);
        }

        public AppCacheHostSwapCacheParams() {
            this(0);
        }

        public static AppCacheHostSwapCacheParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostSwapCacheParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostSwapCacheParams decode(Decoder decoder0) {
            AppCacheHostSwapCacheParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostSwapCacheParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AppCacheHostSwapCacheResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private AppCacheHostSwapCacheResponseParams(int version) {
            super(16, version);
        }

        public AppCacheHostSwapCacheResponseParams() {
            this(0);
        }

        public static AppCacheHostSwapCacheResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostSwapCacheResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostSwapCacheResponseParams decode(Decoder decoder0) {
            AppCacheHostSwapCacheResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostSwapCacheResponseParams(elementsOrVersion);
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

    static class AppCacheHostSwapCacheResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AppCacheHost.SwapCacheResponse mCallback;

        AppCacheHostSwapCacheResponseParamsForwardToCallback(AppCacheHost.SwapCacheResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                AppCacheHost_Internal.AppCacheHostSwapCacheResponseParams response = AppCacheHost_Internal.AppCacheHostSwapCacheResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AppCacheHostSwapCacheResponseParamsProxyToResponder implements AppCacheHost.SwapCacheResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AppCacheHostSwapCacheResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            AppCacheHost_Internal.AppCacheHostSwapCacheResponseParams _response = new AppCacheHost_Internal.AppCacheHostSwapCacheResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AppCacheHostGetResourceListParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AppCacheHostGetResourceListParams(int version) {
            super(8, version);
        }

        public AppCacheHostGetResourceListParams() {
            this(0);
        }

        public static AppCacheHostGetResourceListParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostGetResourceListParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostGetResourceListParams decode(Decoder decoder0) {
            AppCacheHostGetResourceListParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostGetResourceListParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AppCacheHostGetResourceListResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AppCacheResourceInfo[] resources;

        private AppCacheHostGetResourceListResponseParams(int version) {
            super(16, version);
        }

        public AppCacheHostGetResourceListResponseParams() {
            this(0);
        }

        public static AppCacheHostGetResourceListResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheHostGetResourceListResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheHostGetResourceListResponseParams decode(Decoder decoder0) {
            AppCacheHostGetResourceListResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheHostGetResourceListResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.resources = new AppCacheResourceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.resources[i1] = AppCacheResourceInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.resources == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.resources.length, 8, -1);
                for (int i0 = 0; i0 < this.resources.length; i0++)
                    encoder1.encode(this.resources[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class AppCacheHostGetResourceListResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AppCacheHost.GetResourceListResponse mCallback;

        AppCacheHostGetResourceListResponseParamsForwardToCallback(AppCacheHost.GetResourceListResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                AppCacheHost_Internal.AppCacheHostGetResourceListResponseParams response = AppCacheHost_Internal.AppCacheHostGetResourceListResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.resources);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AppCacheHostGetResourceListResponseParamsProxyToResponder implements AppCacheHost.GetResourceListResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AppCacheHostGetResourceListResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(AppCacheResourceInfo[] resources) {
            AppCacheHost_Internal.AppCacheHostGetResourceListResponseParams _response = new AppCacheHost_Internal.AppCacheHostGetResourceListResponseParams();
            _response.resources = resources;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
