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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.payments.mojom.PaymentRequestClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal.class */
class PaymentRequestClient_Internal {
    public static final Interface.Manager<PaymentRequestClient, PaymentRequestClient.Proxy> MANAGER = new Interface.Manager<PaymentRequestClient, PaymentRequestClient.Proxy>() { // from class: org.chromium.payments.mojom.PaymentRequestClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "payments.mojom.PaymentRequestClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public PaymentRequestClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, PaymentRequestClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public PaymentRequestClient[] buildArray(int size) {
            return new PaymentRequestClient[size];
        }
    };
    private static final int ON_PAYMENT_METHOD_CHANGE_ORDINAL = 0;
    private static final int ON_SHIPPING_ADDRESS_CHANGE_ORDINAL = 1;
    private static final int ON_SHIPPING_OPTION_CHANGE_ORDINAL = 2;
    private static final int ON_PAYER_DETAIL_CHANGE_ORDINAL = 3;
    private static final int ON_PAYMENT_RESPONSE_ORDINAL = 4;
    private static final int ON_ERROR_ORDINAL = 5;
    private static final int ON_COMPLETE_ORDINAL = 6;
    private static final int ON_ABORT_ORDINAL = 7;
    private static final int ON_CAN_MAKE_PAYMENT_ORDINAL = 8;
    private static final int ON_HAS_ENROLLED_INSTRUMENT_ORDINAL = 9;
    private static final int WARN_NO_FAVICON_ORDINAL = 10;

    PaymentRequestClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements PaymentRequestClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onPaymentMethodChange(String methodName, String stringifiedDetails) {
            PaymentRequestClientOnPaymentMethodChangeParams _message = new PaymentRequestClientOnPaymentMethodChangeParams();
            _message.methodName = methodName;
            _message.stringifiedDetails = stringifiedDetails;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onShippingAddressChange(PaymentAddress address) {
            PaymentRequestClientOnShippingAddressChangeParams _message = new PaymentRequestClientOnShippingAddressChangeParams();
            _message.address = address;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onShippingOptionChange(String shippingOptionId) {
            PaymentRequestClientOnShippingOptionChangeParams _message = new PaymentRequestClientOnShippingOptionChangeParams();
            _message.shippingOptionId = shippingOptionId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onPayerDetailChange(PayerDetail detail) {
            PaymentRequestClientOnPayerDetailChangeParams _message = new PaymentRequestClientOnPayerDetailChangeParams();
            _message.detail = detail;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onPaymentResponse(PaymentResponse response) {
            PaymentRequestClientOnPaymentResponseParams _message = new PaymentRequestClientOnPaymentResponseParams();
            _message.response = response;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onError(int error, String errorMessage) {
            PaymentRequestClientOnErrorParams _message = new PaymentRequestClientOnErrorParams();
            _message.error = error;
            _message.errorMessage = errorMessage;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onComplete() {
            PaymentRequestClientOnCompleteParams _message = new PaymentRequestClientOnCompleteParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onAbort(boolean abortedSuccessfully) {
            PaymentRequestClientOnAbortParams _message = new PaymentRequestClientOnAbortParams();
            _message.abortedSuccessfully = abortedSuccessfully;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onCanMakePayment(int result) {
            PaymentRequestClientOnCanMakePaymentParams _message = new PaymentRequestClientOnCanMakePaymentParams();
            _message.result = result;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void onHasEnrolledInstrument(int result) {
            PaymentRequestClientOnHasEnrolledInstrumentParams _message = new PaymentRequestClientOnHasEnrolledInstrumentParams();
            _message.result = result;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequestClient
        public void warnNoFavicon() {
            PaymentRequestClientWarnNoFaviconParams _message = new PaymentRequestClientWarnNoFaviconParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<PaymentRequestClient> {
        Stub(Core core, PaymentRequestClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PaymentRequestClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        PaymentRequestClientOnPaymentMethodChangeParams data = PaymentRequestClientOnPaymentMethodChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onPaymentMethodChange(data.methodName, data.stringifiedDetails);
                        return true;
                    case 1:
                        PaymentRequestClientOnShippingAddressChangeParams data2 = PaymentRequestClientOnShippingAddressChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onShippingAddressChange(data2.address);
                        return true;
                    case 2:
                        PaymentRequestClientOnShippingOptionChangeParams data3 = PaymentRequestClientOnShippingOptionChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onShippingOptionChange(data3.shippingOptionId);
                        return true;
                    case 3:
                        PaymentRequestClientOnPayerDetailChangeParams data4 = PaymentRequestClientOnPayerDetailChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onPayerDetailChange(data4.detail);
                        return true;
                    case 4:
                        PaymentRequestClientOnPaymentResponseParams data5 = PaymentRequestClientOnPaymentResponseParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onPaymentResponse(data5.response);
                        return true;
                    case 5:
                        PaymentRequestClientOnErrorParams data6 = PaymentRequestClientOnErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onError(data6.error, data6.errorMessage);
                        return true;
                    case 6:
                        PaymentRequestClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onComplete();
                        return true;
                    case 7:
                        PaymentRequestClientOnAbortParams data7 = PaymentRequestClientOnAbortParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onAbort(data7.abortedSuccessfully);
                        return true;
                    case 8:
                        PaymentRequestClientOnCanMakePaymentParams data8 = PaymentRequestClientOnCanMakePaymentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onCanMakePayment(data8.result);
                        return true;
                    case 9:
                        PaymentRequestClientOnHasEnrolledInstrumentParams data9 = PaymentRequestClientOnHasEnrolledInstrumentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onHasEnrolledInstrument(data9.result);
                        return true;
                    case 10:
                        PaymentRequestClientWarnNoFaviconParams.deserialize(messageWithHeader.getPayload());
                        getImpl().warnNoFavicon();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), PaymentRequestClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnPaymentMethodChangeParams.class */
    static final class PaymentRequestClientOnPaymentMethodChangeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String methodName;
        public String stringifiedDetails;

        private PaymentRequestClientOnPaymentMethodChangeParams(int version) {
            super(24, version);
        }

        public PaymentRequestClientOnPaymentMethodChangeParams() {
            this(0);
        }

        public static PaymentRequestClientOnPaymentMethodChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnPaymentMethodChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnPaymentMethodChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnPaymentMethodChangeParams result = new PaymentRequestClientOnPaymentMethodChangeParams(elementsOrVersion);
                result.methodName = decoder0.readString(8, false);
                result.stringifiedDetails = decoder0.readString(16, false);
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
            encoder0.encode(this.methodName, 8, false);
            encoder0.encode(this.stringifiedDetails, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnShippingAddressChangeParams.class */
    static final class PaymentRequestClientOnShippingAddressChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentAddress address;

        private PaymentRequestClientOnShippingAddressChangeParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnShippingAddressChangeParams() {
            this(0);
        }

        public static PaymentRequestClientOnShippingAddressChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnShippingAddressChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnShippingAddressChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnShippingAddressChangeParams result = new PaymentRequestClientOnShippingAddressChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.address = PaymentAddress.decode(decoder1);
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
            encoder0.encode((Struct) this.address, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnShippingOptionChangeParams.class */
    static final class PaymentRequestClientOnShippingOptionChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String shippingOptionId;

        private PaymentRequestClientOnShippingOptionChangeParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnShippingOptionChangeParams() {
            this(0);
        }

        public static PaymentRequestClientOnShippingOptionChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnShippingOptionChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnShippingOptionChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnShippingOptionChangeParams result = new PaymentRequestClientOnShippingOptionChangeParams(elementsOrVersion);
                result.shippingOptionId = decoder0.readString(8, false);
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
            encoder0.encode(this.shippingOptionId, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnPayerDetailChangeParams.class */
    static final class PaymentRequestClientOnPayerDetailChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PayerDetail detail;

        private PaymentRequestClientOnPayerDetailChangeParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnPayerDetailChangeParams() {
            this(0);
        }

        public static PaymentRequestClientOnPayerDetailChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnPayerDetailChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnPayerDetailChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnPayerDetailChangeParams result = new PaymentRequestClientOnPayerDetailChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.detail = PayerDetail.decode(decoder1);
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
            encoder0.encode((Struct) this.detail, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnPaymentResponseParams.class */
    static final class PaymentRequestClientOnPaymentResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentResponse response;

        private PaymentRequestClientOnPaymentResponseParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnPaymentResponseParams() {
            this(0);
        }

        public static PaymentRequestClientOnPaymentResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnPaymentResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnPaymentResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnPaymentResponseParams result = new PaymentRequestClientOnPaymentResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.response = PaymentResponse.decode(decoder1);
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
            encoder0.encode((Struct) this.response, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnErrorParams.class */
    static final class PaymentRequestClientOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public String errorMessage;

        private PaymentRequestClientOnErrorParams(int version) {
            super(24, version);
        }

        public PaymentRequestClientOnErrorParams() {
            this(0);
        }

        public static PaymentRequestClientOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnErrorParams result = new PaymentRequestClientOnErrorParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                PaymentErrorReason.validate(result.error);
                result.errorMessage = decoder0.readString(16, false);
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
            encoder0.encode(this.error, 8);
            encoder0.encode(this.errorMessage, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnCompleteParams.class */
    static final class PaymentRequestClientOnCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PaymentRequestClientOnCompleteParams(int version) {
            super(8, version);
        }

        public PaymentRequestClientOnCompleteParams() {
            this(0);
        }

        public static PaymentRequestClientOnCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnCompleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnCompleteParams result = new PaymentRequestClientOnCompleteParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnAbortParams.class */
    static final class PaymentRequestClientOnAbortParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean abortedSuccessfully;

        private PaymentRequestClientOnAbortParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnAbortParams() {
            this(0);
        }

        public static PaymentRequestClientOnAbortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnAbortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnAbortParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnAbortParams result = new PaymentRequestClientOnAbortParams(elementsOrVersion);
                result.abortedSuccessfully = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.abortedSuccessfully, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnCanMakePaymentParams.class */
    static final class PaymentRequestClientOnCanMakePaymentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private PaymentRequestClientOnCanMakePaymentParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnCanMakePaymentParams() {
            this(0);
        }

        public static PaymentRequestClientOnCanMakePaymentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnCanMakePaymentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnCanMakePaymentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnCanMakePaymentParams result = new PaymentRequestClientOnCanMakePaymentParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                CanMakePaymentQueryResult.validate(result.result);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientOnHasEnrolledInstrumentParams.class */
    static final class PaymentRequestClientOnHasEnrolledInstrumentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private PaymentRequestClientOnHasEnrolledInstrumentParams(int version) {
            super(16, version);
        }

        public PaymentRequestClientOnHasEnrolledInstrumentParams() {
            this(0);
        }

        public static PaymentRequestClientOnHasEnrolledInstrumentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientOnHasEnrolledInstrumentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientOnHasEnrolledInstrumentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientOnHasEnrolledInstrumentParams result = new PaymentRequestClientOnHasEnrolledInstrumentParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                HasEnrolledInstrumentQueryResult.validate(result.result);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient_Internal$PaymentRequestClientWarnNoFaviconParams.class */
    static final class PaymentRequestClientWarnNoFaviconParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PaymentRequestClientWarnNoFaviconParams(int version) {
            super(8, version);
        }

        public PaymentRequestClientWarnNoFaviconParams() {
            this(0);
        }

        public static PaymentRequestClientWarnNoFaviconParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestClientWarnNoFaviconParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestClientWarnNoFaviconParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestClientWarnNoFaviconParams result = new PaymentRequestClientWarnNoFaviconParams(elementsOrVersion);
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
}
