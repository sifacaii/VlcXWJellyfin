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
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.TrustedHeaderClient;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal.class */
class TrustedHeaderClient_Internal {
    public static final Interface.Manager<TrustedHeaderClient, TrustedHeaderClient.Proxy> MANAGER = new Interface.Manager<TrustedHeaderClient, TrustedHeaderClient.Proxy>() { // from class: org.chromium.network.mojom.TrustedHeaderClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.TrustedHeaderClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public TrustedHeaderClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, TrustedHeaderClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public TrustedHeaderClient[] buildArray(int size) {
            return new TrustedHeaderClient[size];
        }
    };
    private static final int ON_BEFORE_SEND_HEADERS_ORDINAL = 0;
    private static final int ON_HEADERS_RECEIVED_ORDINAL = 1;

    TrustedHeaderClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements TrustedHeaderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.TrustedHeaderClient
        public void onBeforeSendHeaders(HttpRequestHeaders headers, TrustedHeaderClient.OnBeforeSendHeadersResponse callback) {
            TrustedHeaderClientOnBeforeSendHeadersParams _message = new TrustedHeaderClientOnBeforeSendHeadersParams();
            _message.headers = headers;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.TrustedHeaderClient
        public void onHeadersReceived(String headers, TrustedHeaderClient.OnHeadersReceivedResponse callback) {
            TrustedHeaderClientOnHeadersReceivedParams _message = new TrustedHeaderClientOnHeadersReceivedParams();
            _message.headers = headers;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<TrustedHeaderClient> {
        Stub(Core core, TrustedHeaderClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TrustedHeaderClient_Internal.MANAGER, messageWithHeader);
                    default:
                        return false;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), TrustedHeaderClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        TrustedHeaderClientOnBeforeSendHeadersParams data = TrustedHeaderClientOnBeforeSendHeadersParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onBeforeSendHeaders(data.headers, new TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        TrustedHeaderClientOnHeadersReceivedParams data2 = TrustedHeaderClientOnHeadersReceivedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onHeadersReceived(data2.headers, new TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnBeforeSendHeadersParams.class */
    static final class TrustedHeaderClientOnBeforeSendHeadersParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HttpRequestHeaders headers;

        private TrustedHeaderClientOnBeforeSendHeadersParams(int version) {
            super(16, version);
        }

        public TrustedHeaderClientOnBeforeSendHeadersParams() {
            this(0);
        }

        public static TrustedHeaderClientOnBeforeSendHeadersParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TrustedHeaderClientOnBeforeSendHeadersParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TrustedHeaderClientOnBeforeSendHeadersParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TrustedHeaderClientOnBeforeSendHeadersParams result = new TrustedHeaderClientOnBeforeSendHeadersParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.headers = HttpRequestHeaders.decode(decoder1);
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
            encoder0.encode((Struct) this.headers, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnBeforeSendHeadersResponseParams.class */
    public static final class TrustedHeaderClientOnBeforeSendHeadersResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public HttpRequestHeaders headers;

        private TrustedHeaderClientOnBeforeSendHeadersResponseParams(int version) {
            super(24, version);
        }

        public TrustedHeaderClientOnBeforeSendHeadersResponseParams() {
            this(0);
        }

        public static TrustedHeaderClientOnBeforeSendHeadersResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TrustedHeaderClientOnBeforeSendHeadersResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TrustedHeaderClientOnBeforeSendHeadersResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TrustedHeaderClientOnBeforeSendHeadersResponseParams result = new TrustedHeaderClientOnBeforeSendHeadersResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.headers = HttpRequestHeaders.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.headers, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback.class */
    static class TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final TrustedHeaderClient.OnBeforeSendHeadersResponse mCallback;

        TrustedHeaderClientOnBeforeSendHeadersResponseParamsForwardToCallback(TrustedHeaderClient.OnBeforeSendHeadersResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                TrustedHeaderClientOnBeforeSendHeadersResponseParams response = TrustedHeaderClientOnBeforeSendHeadersResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.headers);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder.class */
    static class TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder implements TrustedHeaderClient.OnBeforeSendHeadersResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TrustedHeaderClientOnBeforeSendHeadersResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, HttpRequestHeaders headers) {
            TrustedHeaderClientOnBeforeSendHeadersResponseParams _response = new TrustedHeaderClientOnBeforeSendHeadersResponseParams();
            _response.result = result.intValue();
            _response.headers = headers;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnHeadersReceivedParams.class */
    static final class TrustedHeaderClientOnHeadersReceivedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String headers;

        private TrustedHeaderClientOnHeadersReceivedParams(int version) {
            super(16, version);
        }

        public TrustedHeaderClientOnHeadersReceivedParams() {
            this(0);
        }

        public static TrustedHeaderClientOnHeadersReceivedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TrustedHeaderClientOnHeadersReceivedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TrustedHeaderClientOnHeadersReceivedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TrustedHeaderClientOnHeadersReceivedParams result = new TrustedHeaderClientOnHeadersReceivedParams(elementsOrVersion);
                result.headers = decoder0.readString(8, false);
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
            encoder0.encode(this.headers, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnHeadersReceivedResponseParams.class */
    public static final class TrustedHeaderClientOnHeadersReceivedResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public String headers;
        public Url allowedUnsafeRedirectUrl;

        private TrustedHeaderClientOnHeadersReceivedResponseParams(int version) {
            super(32, version);
        }

        public TrustedHeaderClientOnHeadersReceivedResponseParams() {
            this(0);
        }

        public static TrustedHeaderClientOnHeadersReceivedResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TrustedHeaderClientOnHeadersReceivedResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TrustedHeaderClientOnHeadersReceivedResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                TrustedHeaderClientOnHeadersReceivedResponseParams result = new TrustedHeaderClientOnHeadersReceivedResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                result.headers = decoder0.readString(16, true);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.allowedUnsafeRedirectUrl = Url.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode(this.headers, 16, true);
            encoder0.encode((Struct) this.allowedUnsafeRedirectUrl, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback.class */
    static class TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final TrustedHeaderClient.OnHeadersReceivedResponse mCallback;

        TrustedHeaderClientOnHeadersReceivedResponseParamsForwardToCallback(TrustedHeaderClient.OnHeadersReceivedResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                TrustedHeaderClientOnHeadersReceivedResponseParams response = TrustedHeaderClientOnHeadersReceivedResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.headers, response.allowedUnsafeRedirectUrl);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedHeaderClient_Internal$TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder.class */
    static class TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder implements TrustedHeaderClient.OnHeadersReceivedResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TrustedHeaderClientOnHeadersReceivedResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback3
        public void call(Integer result, String headers, Url allowedUnsafeRedirectUrl) {
            TrustedHeaderClientOnHeadersReceivedResponseParams _response = new TrustedHeaderClientOnHeadersReceivedResponseParams();
            _response.result = result.intValue();
            _response.headers = headers;
            _response.allowedUnsafeRedirectUrl = allowedUnsafeRedirectUrl;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
