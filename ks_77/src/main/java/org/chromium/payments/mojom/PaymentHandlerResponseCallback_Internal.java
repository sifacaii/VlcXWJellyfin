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
import org.chromium.payments.mojom.PaymentHandlerResponseCallback;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback_Internal.class */
class PaymentHandlerResponseCallback_Internal {
    public static final Interface.Manager<PaymentHandlerResponseCallback, PaymentHandlerResponseCallback.Proxy> MANAGER = new Interface.Manager<PaymentHandlerResponseCallback, PaymentHandlerResponseCallback.Proxy>() { // from class: org.chromium.payments.mojom.PaymentHandlerResponseCallback_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "payments.mojom.PaymentHandlerResponseCallback";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public PaymentHandlerResponseCallback.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, PaymentHandlerResponseCallback impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public PaymentHandlerResponseCallback[] buildArray(int size) {
            return new PaymentHandlerResponseCallback[size];
        }
    };
    private static final int ON_RESPONSE_FOR_ABORT_PAYMENT_ORDINAL = 0;
    private static final int ON_RESPONSE_FOR_CAN_MAKE_PAYMENT_ORDINAL = 1;
    private static final int ON_RESPONSE_FOR_PAYMENT_REQUEST_ORDINAL = 2;

    PaymentHandlerResponseCallback_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements PaymentHandlerResponseCallback.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.payments.mojom.PaymentHandlerResponseCallback
        public void onResponseForAbortPayment(boolean paymentAborted) {
            PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams _message = new PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams();
            _message.paymentAborted = paymentAborted;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.payments.mojom.PaymentHandlerResponseCallback
        public void onResponseForCanMakePayment(boolean canMakePayment) {
            PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams _message = new PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams();
            _message.canMakePayment = canMakePayment;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.payments.mojom.PaymentHandlerResponseCallback
        public void onResponseForPaymentRequest(PaymentHandlerResponse response) {
            PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams _message = new PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams();
            _message.response = response;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<PaymentHandlerResponseCallback> {
        Stub(Core core, PaymentHandlerResponseCallback impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PaymentHandlerResponseCallback_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams data = PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onResponseForAbortPayment(data.paymentAborted);
                        return true;
                    case 1:
                        PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams data2 = PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onResponseForCanMakePayment(data2.canMakePayment);
                        return true;
                    case 2:
                        PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams data3 = PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onResponseForPaymentRequest(data3.response);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), PaymentHandlerResponseCallback_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback_Internal$PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams.class */
    static final class PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean paymentAborted;

        private PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams(int version) {
            super(16, version);
        }

        public PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams() {
            this(0);
        }

        public static PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams result = new PaymentHandlerResponseCallbackOnResponseForAbortPaymentParams(elementsOrVersion);
                result.paymentAborted = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.paymentAborted, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback_Internal$PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams.class */
    static final class PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean canMakePayment;

        private PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams(int version) {
            super(16, version);
        }

        public PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams() {
            this(0);
        }

        public static PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams result = new PaymentHandlerResponseCallbackOnResponseForCanMakePaymentParams(elementsOrVersion);
                result.canMakePayment = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.canMakePayment, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback_Internal$PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams.class */
    static final class PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentHandlerResponse response;

        private PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams(int version) {
            super(16, version);
        }

        public PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams() {
            this(0);
        }

        public static PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams result = new PaymentHandlerResponseCallbackOnResponseForPaymentRequestParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.response = PaymentHandlerResponse.decode(decoder1);
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
}
