package org.chromium.network.mojom;

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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.network.mojom.UrlLoaderClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal.class */
class UrlLoaderClient_Internal {
    public static final Interface.Manager<UrlLoaderClient, UrlLoaderClient.Proxy> MANAGER = new Interface.Manager<UrlLoaderClient, UrlLoaderClient.Proxy>() { // from class: org.chromium.network.mojom.UrlLoaderClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.URLLoaderClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public UrlLoaderClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, UrlLoaderClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public UrlLoaderClient[] buildArray(int size) {
            return new UrlLoaderClient[size];
        }
    };
    private static final int ON_RECEIVE_RESPONSE_ORDINAL = 0;
    private static final int ON_RECEIVE_REDIRECT_ORDINAL = 1;
    private static final int ON_UPLOAD_PROGRESS_ORDINAL = 2;
    private static final int ON_RECEIVE_CACHED_METADATA_ORDINAL = 3;
    private static final int ON_TRANSFER_SIZE_UPDATED_ORDINAL = 4;
    private static final int ON_START_LOADING_RESPONSE_BODY_ORDINAL = 5;
    private static final int ON_COMPLETE_ORDINAL = 6;

    UrlLoaderClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements UrlLoaderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onReceiveResponse(UrlResponseHead head) {
            UrlLoaderClientOnReceiveResponseParams _message = new UrlLoaderClientOnReceiveResponseParams();
            _message.head = head;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onReceiveRedirect(UrlRequestRedirectInfo redirectInfo, UrlResponseHead head) {
            UrlLoaderClientOnReceiveRedirectParams _message = new UrlLoaderClientOnReceiveRedirectParams();
            _message.redirectInfo = redirectInfo;
            _message.head = head;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onUploadProgress(long currentPosition, long totalSize, UrlLoaderClient.OnUploadProgressResponse callback) {
            UrlLoaderClientOnUploadProgressParams _message = new UrlLoaderClientOnUploadProgressParams();
            _message.currentPosition = currentPosition;
            _message.totalSize = totalSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onReceiveCachedMetadata(BigBuffer data) {
            UrlLoaderClientOnReceiveCachedMetadataParams _message = new UrlLoaderClientOnReceiveCachedMetadataParams();
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onTransferSizeUpdated(int transferSizeDiff) {
            UrlLoaderClientOnTransferSizeUpdatedParams _message = new UrlLoaderClientOnTransferSizeUpdatedParams();
            _message.transferSizeDiff = transferSizeDiff;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onStartLoadingResponseBody(DataPipe.ConsumerHandle body) {
            UrlLoaderClientOnStartLoadingResponseBodyParams _message = new UrlLoaderClientOnStartLoadingResponseBodyParams();
            _message.body = body;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.network.mojom.UrlLoaderClient
        public void onComplete(UrlLoaderCompletionStatus status) {
            UrlLoaderClientOnCompleteParams _message = new UrlLoaderClientOnCompleteParams();
            _message.status = status;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<UrlLoaderClient> {
        Stub(Core core, UrlLoaderClient impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UrlLoaderClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 2:
                    default:
                        return false;
                    case 0:
                        UrlLoaderClientOnReceiveResponseParams data = UrlLoaderClientOnReceiveResponseParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onReceiveResponse(data.head);
                        return true;
                    case 1:
                        UrlLoaderClientOnReceiveRedirectParams data2 = UrlLoaderClientOnReceiveRedirectParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onReceiveRedirect(data2.redirectInfo, data2.head);
                        return true;
                    case 3:
                        UrlLoaderClientOnReceiveCachedMetadataParams data3 = UrlLoaderClientOnReceiveCachedMetadataParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onReceiveCachedMetadata(data3.data);
                        return true;
                    case 4:
                        UrlLoaderClientOnTransferSizeUpdatedParams data4 = UrlLoaderClientOnTransferSizeUpdatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onTransferSizeUpdated(data4.transferSizeDiff);
                        return true;
                    case 5:
                        UrlLoaderClientOnStartLoadingResponseBodyParams data5 = UrlLoaderClientOnStartLoadingResponseBodyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onStartLoadingResponseBody(data5.body);
                        return true;
                    case 6:
                        UrlLoaderClientOnCompleteParams data6 = UrlLoaderClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onComplete(data6.status);
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), UrlLoaderClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 2:
                        UrlLoaderClientOnUploadProgressParams data = UrlLoaderClientOnUploadProgressParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onUploadProgress(data.currentPosition, data.totalSize, new UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnReceiveResponseParams.class */
    static final class UrlLoaderClientOnReceiveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UrlResponseHead head;

        private UrlLoaderClientOnReceiveResponseParams(int version) {
            super(16, version);
        }

        public UrlLoaderClientOnReceiveResponseParams() {
            this(0);
        }

        public static UrlLoaderClientOnReceiveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnReceiveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnReceiveResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnReceiveResponseParams result = new UrlLoaderClientOnReceiveResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.head = UrlResponseHead.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.head, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnReceiveRedirectParams.class */
    static final class UrlLoaderClientOnReceiveRedirectParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UrlRequestRedirectInfo redirectInfo;
        public UrlResponseHead head;

        private UrlLoaderClientOnReceiveRedirectParams(int version) {
            super(24, version);
        }

        public UrlLoaderClientOnReceiveRedirectParams() {
            this(0);
        }

        public static UrlLoaderClientOnReceiveRedirectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnReceiveRedirectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnReceiveRedirectParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnReceiveRedirectParams result = new UrlLoaderClientOnReceiveRedirectParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.redirectInfo = UrlRequestRedirectInfo.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.head = UrlResponseHead.decode(decoder12);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.redirectInfo, 8, false);
            encoder0.encode((Struct) this.head, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnUploadProgressParams.class */
    static final class UrlLoaderClientOnUploadProgressParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public long currentPosition;
        public long totalSize;

        private UrlLoaderClientOnUploadProgressParams(int version) {
            super(24, version);
        }

        public UrlLoaderClientOnUploadProgressParams() {
            this(0);
        }

        public static UrlLoaderClientOnUploadProgressParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnUploadProgressParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnUploadProgressParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnUploadProgressParams result = new UrlLoaderClientOnUploadProgressParams(elementsOrVersion);
                result.currentPosition = decoder0.readLong(8);
                result.totalSize = decoder0.readLong(16);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.currentPosition, 8);
            encoder0.encode(this.totalSize, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnUploadProgressResponseParams.class */
    static final class UrlLoaderClientOnUploadProgressResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderClientOnUploadProgressResponseParams(int version) {
            super(8, version);
        }

        public UrlLoaderClientOnUploadProgressResponseParams() {
            this(0);
        }

        public static UrlLoaderClientOnUploadProgressResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnUploadProgressResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnUploadProgressResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnUploadProgressResponseParams result = new UrlLoaderClientOnUploadProgressResponseParams(elementsOrVersion);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback.class */
    static class UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UrlLoaderClient.OnUploadProgressResponse mCallback;

        UrlLoaderClientOnUploadProgressResponseParamsForwardToCallback(UrlLoaderClient.OnUploadProgressResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder.class */
    static class UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder implements UrlLoaderClient.OnUploadProgressResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        UrlLoaderClientOnUploadProgressResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            UrlLoaderClientOnUploadProgressResponseParams _response = new UrlLoaderClientOnUploadProgressResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnReceiveCachedMetadataParams.class */
    static final class UrlLoaderClientOnReceiveCachedMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public BigBuffer data;

        private UrlLoaderClientOnReceiveCachedMetadataParams(int version) {
            super(24, version);
        }

        public UrlLoaderClientOnReceiveCachedMetadataParams() {
            this(0);
        }

        public static UrlLoaderClientOnReceiveCachedMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnReceiveCachedMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnReceiveCachedMetadataParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnReceiveCachedMetadataParams result = new UrlLoaderClientOnReceiveCachedMetadataParams(elementsOrVersion);
                result.data = BigBuffer.decode(decoder0, 8);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Union) this.data, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnTransferSizeUpdatedParams.class */
    static final class UrlLoaderClientOnTransferSizeUpdatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int transferSizeDiff;

        private UrlLoaderClientOnTransferSizeUpdatedParams(int version) {
            super(16, version);
        }

        public UrlLoaderClientOnTransferSizeUpdatedParams() {
            this(0);
        }

        public static UrlLoaderClientOnTransferSizeUpdatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnTransferSizeUpdatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnTransferSizeUpdatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnTransferSizeUpdatedParams result = new UrlLoaderClientOnTransferSizeUpdatedParams(elementsOrVersion);
                result.transferSizeDiff = decoder0.readInt(8);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.transferSizeDiff, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnStartLoadingResponseBodyParams.class */
    static final class UrlLoaderClientOnStartLoadingResponseBodyParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DataPipe.ConsumerHandle body;

        private UrlLoaderClientOnStartLoadingResponseBodyParams(int version) {
            super(16, version);
            this.body = InvalidHandle.INSTANCE;
        }

        public UrlLoaderClientOnStartLoadingResponseBodyParams() {
            this(0);
        }

        public static UrlLoaderClientOnStartLoadingResponseBodyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnStartLoadingResponseBodyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnStartLoadingResponseBodyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnStartLoadingResponseBodyParams result = new UrlLoaderClientOnStartLoadingResponseBodyParams(elementsOrVersion);
                result.body = decoder0.readConsumerHandle(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle) this.body, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoaderClient_Internal$UrlLoaderClientOnCompleteParams.class */
    static final class UrlLoaderClientOnCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UrlLoaderCompletionStatus status;

        private UrlLoaderClientOnCompleteParams(int version) {
            super(16, version);
        }

        public UrlLoaderClientOnCompleteParams() {
            this(0);
        }

        public static UrlLoaderClientOnCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderClientOnCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderClientOnCompleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderClientOnCompleteParams result = new UrlLoaderClientOnCompleteParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.status = UrlLoaderCompletionStatus.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.status, 8, false);
        }
    }
}
