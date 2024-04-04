package org.chromium.payments.mojom;

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
import org.chromium.payments.mojom.PaymentManager;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal.class */
class PaymentManager_Internal {
    public static final Interface.Manager<PaymentManager, PaymentManager.Proxy> MANAGER = new Interface.Manager<PaymentManager, PaymentManager.Proxy>() { // from class: org.chromium.payments.mojom.PaymentManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "payments.mojom.PaymentManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public PaymentManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, PaymentManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public PaymentManager[] buildArray(int size) {
            return new PaymentManager[size];
        }
    };
    private static final int INIT_ORDINAL = 0;
    private static final int DELETE_PAYMENT_INSTRUMENT_ORDINAL = 1;
    private static final int GET_PAYMENT_INSTRUMENT_ORDINAL = 2;
    private static final int KEYS_OF_PAYMENT_INSTRUMENTS_ORDINAL = 3;
    private static final int HAS_PAYMENT_INSTRUMENT_ORDINAL = 4;
    private static final int SET_PAYMENT_INSTRUMENT_ORDINAL = 5;
    private static final int CLEAR_PAYMENT_INSTRUMENTS_ORDINAL = 6;
    private static final int SET_USER_HINT_ORDINAL = 7;

    PaymentManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements PaymentManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void init(Url contextUrl, String serviceWorkerScope) {
            PaymentManagerInitParams _message = new PaymentManagerInitParams();
            _message.contextUrl = contextUrl;
            _message.serviceWorkerScope = serviceWorkerScope;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void deletePaymentInstrument(String instrumentKey, PaymentManager.DeletePaymentInstrumentResponse callback) {
            PaymentManagerDeletePaymentInstrumentParams _message = new PaymentManagerDeletePaymentInstrumentParams();
            _message.instrumentKey = instrumentKey;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void getPaymentInstrument(String instrumentKey, PaymentManager.GetPaymentInstrumentResponse callback) {
            PaymentManagerGetPaymentInstrumentParams _message = new PaymentManagerGetPaymentInstrumentParams();
            _message.instrumentKey = instrumentKey;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void keysOfPaymentInstruments(PaymentManager.KeysOfPaymentInstrumentsResponse callback) {
            PaymentManagerKeysOfPaymentInstrumentsParams _message = new PaymentManagerKeysOfPaymentInstrumentsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void hasPaymentInstrument(String instrumentKey, PaymentManager.HasPaymentInstrumentResponse callback) {
            PaymentManagerHasPaymentInstrumentParams _message = new PaymentManagerHasPaymentInstrumentParams();
            _message.instrumentKey = instrumentKey;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void setPaymentInstrument(String instrumentKey, PaymentInstrument instrument, PaymentManager.SetPaymentInstrumentResponse callback) {
            PaymentManagerSetPaymentInstrumentParams _message = new PaymentManagerSetPaymentInstrumentParams();
            _message.instrumentKey = instrumentKey;
            _message.instrument = instrument;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void clearPaymentInstruments(PaymentManager.ClearPaymentInstrumentsResponse callback) {
            PaymentManagerClearPaymentInstrumentsParams _message = new PaymentManagerClearPaymentInstrumentsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.payments.mojom.PaymentManager
        public void setUserHint(String userHint) {
            PaymentManagerSetUserHintParams _message = new PaymentManagerSetUserHintParams();
            _message.userHint = userHint;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<PaymentManager> {
        Stub(Core core, PaymentManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PaymentManager_Internal.MANAGER, messageWithHeader);
                    case 0:
                        PaymentManagerInitParams data = PaymentManagerInitParams.deserialize(messageWithHeader.getPayload());
                        getImpl().init(data.contextUrl, data.serviceWorkerScope);
                        return true;
                    case 7:
                        getImpl().setUserHint(PaymentManagerSetUserHintParams.deserialize(messageWithHeader.getPayload()).userHint);
                        return true;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), PaymentManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                    default:
                        return false;
                    case 1:
                        getImpl().deletePaymentInstrument(PaymentManagerDeletePaymentInstrumentParams.deserialize(messageWithHeader.getPayload()).instrumentKey, new PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        getImpl().getPaymentInstrument(PaymentManagerGetPaymentInstrumentParams.deserialize(messageWithHeader.getPayload()).instrumentKey, new PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        PaymentManagerKeysOfPaymentInstrumentsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().keysOfPaymentInstruments(new PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        getImpl().hasPaymentInstrument(PaymentManagerHasPaymentInstrumentParams.deserialize(messageWithHeader.getPayload()).instrumentKey, new PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        PaymentManagerSetPaymentInstrumentParams data = PaymentManagerSetPaymentInstrumentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setPaymentInstrument(data.instrumentKey, data.instrument, new PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        PaymentManagerClearPaymentInstrumentsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().clearPaymentInstruments(new PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerInitParams.class */
    static final class PaymentManagerInitParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url contextUrl;
        public String serviceWorkerScope;

        private PaymentManagerInitParams(int version) {
            super(24, version);
        }

        public PaymentManagerInitParams() {
            this(0);
        }

        public static PaymentManagerInitParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerInitParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerInitParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerInitParams result = new PaymentManagerInitParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.contextUrl = Url.decode(decoder1);
                result.serviceWorkerScope = decoder0.readString(16, false);
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
            encoder0.encode((Struct) this.contextUrl, 8, false);
            encoder0.encode(this.serviceWorkerScope, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerDeletePaymentInstrumentParams.class */
    static final class PaymentManagerDeletePaymentInstrumentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String instrumentKey;

        private PaymentManagerDeletePaymentInstrumentParams(int version) {
            super(16, version);
        }

        public PaymentManagerDeletePaymentInstrumentParams() {
            this(0);
        }

        public static PaymentManagerDeletePaymentInstrumentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerDeletePaymentInstrumentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerDeletePaymentInstrumentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerDeletePaymentInstrumentParams result = new PaymentManagerDeletePaymentInstrumentParams(elementsOrVersion);
                result.instrumentKey = decoder0.readString(8, false);
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
            encoder0.encode(this.instrumentKey, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerDeletePaymentInstrumentResponseParams.class */
    public static final class PaymentManagerDeletePaymentInstrumentResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private PaymentManagerDeletePaymentInstrumentResponseParams(int version) {
            super(16, version);
        }

        public PaymentManagerDeletePaymentInstrumentResponseParams() {
            this(0);
        }

        public static PaymentManagerDeletePaymentInstrumentResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerDeletePaymentInstrumentResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerDeletePaymentInstrumentResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerDeletePaymentInstrumentResponseParams result = new PaymentManagerDeletePaymentInstrumentResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PaymentHandlerStatus.validate(result.status);
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
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback.class */
    static class PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentManager.DeletePaymentInstrumentResponse mCallback;

        PaymentManagerDeletePaymentInstrumentResponseParamsForwardToCallback(PaymentManager.DeletePaymentInstrumentResponse callback) {
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
                PaymentManagerDeletePaymentInstrumentResponseParams response = PaymentManagerDeletePaymentInstrumentResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder.class */
    static class PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder implements PaymentManager.DeletePaymentInstrumentResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentManagerDeletePaymentInstrumentResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer status) {
            PaymentManagerDeletePaymentInstrumentResponseParams _response = new PaymentManagerDeletePaymentInstrumentResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerGetPaymentInstrumentParams.class */
    static final class PaymentManagerGetPaymentInstrumentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String instrumentKey;

        private PaymentManagerGetPaymentInstrumentParams(int version) {
            super(16, version);
        }

        public PaymentManagerGetPaymentInstrumentParams() {
            this(0);
        }

        public static PaymentManagerGetPaymentInstrumentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerGetPaymentInstrumentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerGetPaymentInstrumentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerGetPaymentInstrumentParams result = new PaymentManagerGetPaymentInstrumentParams(elementsOrVersion);
                result.instrumentKey = decoder0.readString(8, false);
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
            encoder0.encode(this.instrumentKey, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerGetPaymentInstrumentResponseParams.class */
    public static final class PaymentManagerGetPaymentInstrumentResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentInstrument instrument;
        public int status;

        private PaymentManagerGetPaymentInstrumentResponseParams(int version) {
            super(24, version);
        }

        public PaymentManagerGetPaymentInstrumentResponseParams() {
            this(0);
        }

        public static PaymentManagerGetPaymentInstrumentResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerGetPaymentInstrumentResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerGetPaymentInstrumentResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerGetPaymentInstrumentResponseParams result = new PaymentManagerGetPaymentInstrumentResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.instrument = PaymentInstrument.decode(decoder1);
                result.status = decoder0.readInt(16);
                PaymentHandlerStatus.validate(result.status);
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
            encoder0.encode((Struct) this.instrument, 8, false);
            encoder0.encode(this.status, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback.class */
    static class PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentManager.GetPaymentInstrumentResponse mCallback;

        PaymentManagerGetPaymentInstrumentResponseParamsForwardToCallback(PaymentManager.GetPaymentInstrumentResponse callback) {
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
                PaymentManagerGetPaymentInstrumentResponseParams response = PaymentManagerGetPaymentInstrumentResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.instrument, Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder.class */
    static class PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder implements PaymentManager.GetPaymentInstrumentResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentManagerGetPaymentInstrumentResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(PaymentInstrument instrument, Integer status) {
            PaymentManagerGetPaymentInstrumentResponseParams _response = new PaymentManagerGetPaymentInstrumentResponseParams();
            _response.instrument = instrument;
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerKeysOfPaymentInstrumentsParams.class */
    static final class PaymentManagerKeysOfPaymentInstrumentsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PaymentManagerKeysOfPaymentInstrumentsParams(int version) {
            super(8, version);
        }

        public PaymentManagerKeysOfPaymentInstrumentsParams() {
            this(0);
        }

        public static PaymentManagerKeysOfPaymentInstrumentsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerKeysOfPaymentInstrumentsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerKeysOfPaymentInstrumentsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerKeysOfPaymentInstrumentsParams result = new PaymentManagerKeysOfPaymentInstrumentsParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerKeysOfPaymentInstrumentsResponseParams.class */
    public static final class PaymentManagerKeysOfPaymentInstrumentsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String[] keys;
        public int status;

        private PaymentManagerKeysOfPaymentInstrumentsResponseParams(int version) {
            super(24, version);
        }

        public PaymentManagerKeysOfPaymentInstrumentsResponseParams() {
            this(0);
        }

        public static PaymentManagerKeysOfPaymentInstrumentsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerKeysOfPaymentInstrumentsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerKeysOfPaymentInstrumentsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerKeysOfPaymentInstrumentsResponseParams result = new PaymentManagerKeysOfPaymentInstrumentsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.keys = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.keys[i1] = decoder1.readString(8 + (8 * i1), false);
                }
                result.status = decoder0.readInt(16);
                PaymentHandlerStatus.validate(result.status);
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
            if (this.keys == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.keys.length, 8, -1);
                for (int i0 = 0; i0 < this.keys.length; i0++) {
                    encoder1.encode(this.keys[i0], 8 + (8 * i0), false);
                }
            }
            encoder0.encode(this.status, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback.class */
    static class PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentManager.KeysOfPaymentInstrumentsResponse mCallback;

        PaymentManagerKeysOfPaymentInstrumentsResponseParamsForwardToCallback(PaymentManager.KeysOfPaymentInstrumentsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                PaymentManagerKeysOfPaymentInstrumentsResponseParams response = PaymentManagerKeysOfPaymentInstrumentsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.keys, Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder.class */
    static class PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder implements PaymentManager.KeysOfPaymentInstrumentsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentManagerKeysOfPaymentInstrumentsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(String[] keys, Integer status) {
            PaymentManagerKeysOfPaymentInstrumentsResponseParams _response = new PaymentManagerKeysOfPaymentInstrumentsResponseParams();
            _response.keys = keys;
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerHasPaymentInstrumentParams.class */
    static final class PaymentManagerHasPaymentInstrumentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String instrumentKey;

        private PaymentManagerHasPaymentInstrumentParams(int version) {
            super(16, version);
        }

        public PaymentManagerHasPaymentInstrumentParams() {
            this(0);
        }

        public static PaymentManagerHasPaymentInstrumentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerHasPaymentInstrumentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerHasPaymentInstrumentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerHasPaymentInstrumentParams result = new PaymentManagerHasPaymentInstrumentParams(elementsOrVersion);
                result.instrumentKey = decoder0.readString(8, false);
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
            encoder0.encode(this.instrumentKey, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerHasPaymentInstrumentResponseParams.class */
    public static final class PaymentManagerHasPaymentInstrumentResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private PaymentManagerHasPaymentInstrumentResponseParams(int version) {
            super(16, version);
        }

        public PaymentManagerHasPaymentInstrumentResponseParams() {
            this(0);
        }

        public static PaymentManagerHasPaymentInstrumentResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerHasPaymentInstrumentResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerHasPaymentInstrumentResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerHasPaymentInstrumentResponseParams result = new PaymentManagerHasPaymentInstrumentResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PaymentHandlerStatus.validate(result.status);
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
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback.class */
    static class PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentManager.HasPaymentInstrumentResponse mCallback;

        PaymentManagerHasPaymentInstrumentResponseParamsForwardToCallback(PaymentManager.HasPaymentInstrumentResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                PaymentManagerHasPaymentInstrumentResponseParams response = PaymentManagerHasPaymentInstrumentResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder.class */
    static class PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder implements PaymentManager.HasPaymentInstrumentResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentManagerHasPaymentInstrumentResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer status) {
            PaymentManagerHasPaymentInstrumentResponseParams _response = new PaymentManagerHasPaymentInstrumentResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerSetPaymentInstrumentParams.class */
    static final class PaymentManagerSetPaymentInstrumentParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String instrumentKey;
        public PaymentInstrument instrument;

        private PaymentManagerSetPaymentInstrumentParams(int version) {
            super(24, version);
        }

        public PaymentManagerSetPaymentInstrumentParams() {
            this(0);
        }

        public static PaymentManagerSetPaymentInstrumentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerSetPaymentInstrumentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerSetPaymentInstrumentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerSetPaymentInstrumentParams result = new PaymentManagerSetPaymentInstrumentParams(elementsOrVersion);
                result.instrumentKey = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.instrument = PaymentInstrument.decode(decoder1);
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
            encoder0.encode(this.instrumentKey, 8, false);
            encoder0.encode((Struct) this.instrument, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerSetPaymentInstrumentResponseParams.class */
    public static final class PaymentManagerSetPaymentInstrumentResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private PaymentManagerSetPaymentInstrumentResponseParams(int version) {
            super(16, version);
        }

        public PaymentManagerSetPaymentInstrumentResponseParams() {
            this(0);
        }

        public static PaymentManagerSetPaymentInstrumentResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerSetPaymentInstrumentResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerSetPaymentInstrumentResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerSetPaymentInstrumentResponseParams result = new PaymentManagerSetPaymentInstrumentResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PaymentHandlerStatus.validate(result.status);
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
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback.class */
    static class PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentManager.SetPaymentInstrumentResponse mCallback;

        PaymentManagerSetPaymentInstrumentResponseParamsForwardToCallback(PaymentManager.SetPaymentInstrumentResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2)) {
                    return false;
                }
                PaymentManagerSetPaymentInstrumentResponseParams response = PaymentManagerSetPaymentInstrumentResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder.class */
    static class PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder implements PaymentManager.SetPaymentInstrumentResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentManagerSetPaymentInstrumentResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer status) {
            PaymentManagerSetPaymentInstrumentResponseParams _response = new PaymentManagerSetPaymentInstrumentResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerClearPaymentInstrumentsParams.class */
    static final class PaymentManagerClearPaymentInstrumentsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PaymentManagerClearPaymentInstrumentsParams(int version) {
            super(8, version);
        }

        public PaymentManagerClearPaymentInstrumentsParams() {
            this(0);
        }

        public static PaymentManagerClearPaymentInstrumentsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerClearPaymentInstrumentsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerClearPaymentInstrumentsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerClearPaymentInstrumentsParams result = new PaymentManagerClearPaymentInstrumentsParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerClearPaymentInstrumentsResponseParams.class */
    public static final class PaymentManagerClearPaymentInstrumentsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private PaymentManagerClearPaymentInstrumentsResponseParams(int version) {
            super(16, version);
        }

        public PaymentManagerClearPaymentInstrumentsResponseParams() {
            this(0);
        }

        public static PaymentManagerClearPaymentInstrumentsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerClearPaymentInstrumentsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerClearPaymentInstrumentsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerClearPaymentInstrumentsResponseParams result = new PaymentManagerClearPaymentInstrumentsResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PaymentHandlerStatus.validate(result.status);
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
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback.class */
    static class PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentManager.ClearPaymentInstrumentsResponse mCallback;

        PaymentManagerClearPaymentInstrumentsResponseParamsForwardToCallback(PaymentManager.ClearPaymentInstrumentsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2)) {
                    return false;
                }
                PaymentManagerClearPaymentInstrumentsResponseParams response = PaymentManagerClearPaymentInstrumentsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder.class */
    static class PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder implements PaymentManager.ClearPaymentInstrumentsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentManagerClearPaymentInstrumentsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer status) {
            PaymentManagerClearPaymentInstrumentsResponseParams _response = new PaymentManagerClearPaymentInstrumentsResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager_Internal$PaymentManagerSetUserHintParams.class */
    static final class PaymentManagerSetUserHintParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String userHint;

        private PaymentManagerSetUserHintParams(int version) {
            super(16, version);
        }

        public PaymentManagerSetUserHintParams() {
            this(0);
        }

        public static PaymentManagerSetUserHintParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentManagerSetUserHintParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentManagerSetUserHintParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentManagerSetUserHintParams result = new PaymentManagerSetUserHintParams(elementsOrVersion);
                result.userHint = decoder0.readString(8, false);
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
            encoder0.encode(this.userHint, 8, false);
        }
    }
}
