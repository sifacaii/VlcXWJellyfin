package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.ProvisionFetcher;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal.class */
class ProvisionFetcher_Internal {
    public static final Interface.Manager<ProvisionFetcher, ProvisionFetcher.Proxy> MANAGER = new Interface.Manager<ProvisionFetcher, ProvisionFetcher.Proxy>() { // from class: org.chromium.media.mojom.ProvisionFetcher_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.ProvisionFetcher";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProvisionFetcher.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProvisionFetcher impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProvisionFetcher[] buildArray(int size) {
            return new ProvisionFetcher[size];
        }
    };
    private static final int RETRIEVE_ORDINAL = 0;

    ProvisionFetcher_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProvisionFetcher.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.ProvisionFetcher
        public void retrieve(String defaultUrl, String requestData, ProvisionFetcher.RetrieveResponse callback) {
            ProvisionFetcherRetrieveParams _message = new ProvisionFetcherRetrieveParams();
            _message.defaultUrl = defaultUrl;
            _message.requestData = requestData;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ProvisionFetcherRetrieveResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProvisionFetcher> {
        Stub(Core core, ProvisionFetcher impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProvisionFetcher_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProvisionFetcher_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ProvisionFetcherRetrieveParams data = ProvisionFetcherRetrieveParams.deserialize(messageWithHeader.getPayload());
                        getImpl().retrieve(data.defaultUrl, data.requestData, new ProvisionFetcherRetrieveResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal$ProvisionFetcherRetrieveParams.class */
    static final class ProvisionFetcherRetrieveParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String defaultUrl;
        public String requestData;

        private ProvisionFetcherRetrieveParams(int version) {
            super(24, version);
        }

        public ProvisionFetcherRetrieveParams() {
            this(0);
        }

        public static ProvisionFetcherRetrieveParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProvisionFetcherRetrieveParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProvisionFetcherRetrieveParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProvisionFetcherRetrieveParams result = new ProvisionFetcherRetrieveParams(elementsOrVersion);
                result.defaultUrl = decoder0.readString(8, false);
                result.requestData = decoder0.readString(16, false);
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
            encoder0.encode(this.defaultUrl, 8, false);
            encoder0.encode(this.requestData, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal$ProvisionFetcherRetrieveResponseParams.class */
    public static final class ProvisionFetcherRetrieveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean result;
        public String response;

        private ProvisionFetcherRetrieveResponseParams(int version) {
            super(24, version);
        }

        public ProvisionFetcherRetrieveResponseParams() {
            this(0);
        }

        public static ProvisionFetcherRetrieveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProvisionFetcherRetrieveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProvisionFetcherRetrieveResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProvisionFetcherRetrieveResponseParams result = new ProvisionFetcherRetrieveResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
                result.response = decoder0.readString(16, false);
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
            encoder0.encode(this.result, 8, 0);
            encoder0.encode(this.response, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal$ProvisionFetcherRetrieveResponseParamsForwardToCallback.class */
    static class ProvisionFetcherRetrieveResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ProvisionFetcher.RetrieveResponse mCallback;

        ProvisionFetcherRetrieveResponseParamsForwardToCallback(ProvisionFetcher.RetrieveResponse callback) {
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
                ProvisionFetcherRetrieveResponseParams response = ProvisionFetcherRetrieveResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result), response.response);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher_Internal$ProvisionFetcherRetrieveResponseParamsProxyToResponder.class */
    static class ProvisionFetcherRetrieveResponseParamsProxyToResponder implements ProvisionFetcher.RetrieveResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ProvisionFetcherRetrieveResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Boolean result, String response) {
            ProvisionFetcherRetrieveResponseParams _response = new ProvisionFetcherRetrieveResponseParams();
            _response.result = result.booleanValue();
            _response.response = response;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
