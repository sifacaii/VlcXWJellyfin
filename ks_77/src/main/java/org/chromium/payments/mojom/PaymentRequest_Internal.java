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
import org.chromium.payments.mojom.PaymentRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal.class */
class PaymentRequest_Internal {
    public static final Interface.Manager<PaymentRequest, PaymentRequest.Proxy> MANAGER = new Interface.Manager<PaymentRequest, PaymentRequest.Proxy>() { // from class: org.chromium.payments.mojom.PaymentRequest_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "payments.mojom.PaymentRequest";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public PaymentRequest.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, PaymentRequest impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public PaymentRequest[] buildArray(int size) {
            return new PaymentRequest[size];
        }
    };
    private static final int INIT_ORDINAL = 0;
    private static final int SHOW_ORDINAL = 1;
    private static final int UPDATE_WITH_ORDINAL = 2;
    private static final int NO_UPDATED_PAYMENT_DETAILS_ORDINAL = 3;
    private static final int ABORT_ORDINAL = 4;
    private static final int COMPLETE_ORDINAL = 5;
    private static final int RETRY_ORDINAL = 6;
    private static final int CAN_MAKE_PAYMENT_ORDINAL = 7;
    private static final int HAS_ENROLLED_INSTRUMENT_ORDINAL = 8;

    PaymentRequest_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements PaymentRequest.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void init(PaymentRequestClient client, PaymentMethodData[] methodData, PaymentDetails details, PaymentOptions options) {
            PaymentRequestInitParams _message = new PaymentRequestInitParams();
            _message.client = client;
            _message.methodData = methodData;
            _message.details = details;
            _message.options = options;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void show(boolean isUserGesture, boolean waitForUpdatedDetails) {
            PaymentRequestShowParams _message = new PaymentRequestShowParams();
            _message.isUserGesture = isUserGesture;
            _message.waitForUpdatedDetails = waitForUpdatedDetails;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void updateWith(PaymentDetails details) {
            PaymentRequestUpdateWithParams _message = new PaymentRequestUpdateWithParams();
            _message.details = details;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void noUpdatedPaymentDetails() {
            PaymentRequestNoUpdatedPaymentDetailsParams _message = new PaymentRequestNoUpdatedPaymentDetailsParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void abort() {
            PaymentRequestAbortParams _message = new PaymentRequestAbortParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void complete(int result) {
            PaymentRequestCompleteParams _message = new PaymentRequestCompleteParams();
            _message.result = result;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void retry(PaymentValidationErrors errors) {
            PaymentRequestRetryParams _message = new PaymentRequestRetryParams();
            _message.errors = errors;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void canMakePayment(boolean legacyMode) {
            PaymentRequestCanMakePaymentParams _message = new PaymentRequestCanMakePaymentParams();
            _message.legacyMode = legacyMode;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.payments.mojom.PaymentRequest
        public void hasEnrolledInstrument(boolean perMethodQuota) {
            PaymentRequestHasEnrolledInstrumentParams _message = new PaymentRequestHasEnrolledInstrumentParams();
            _message.perMethodQuota = perMethodQuota;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<PaymentRequest> {
        Stub(Core core, PaymentRequest impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PaymentRequest_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        PaymentRequestInitParams data = PaymentRequestInitParams.deserialize(messageWithHeader.getPayload());
                        getImpl().init(data.client, data.methodData, data.details, data.options);
                        return true;
                    case 1:
                        PaymentRequestShowParams data2 = PaymentRequestShowParams.deserialize(messageWithHeader.getPayload());
                        getImpl().show(data2.isUserGesture, data2.waitForUpdatedDetails);
                        return true;
                    case 2:
                        PaymentRequestUpdateWithParams data3 = PaymentRequestUpdateWithParams.deserialize(messageWithHeader.getPayload());
                        getImpl().updateWith(data3.details);
                        return true;
                    case 3:
                        PaymentRequestNoUpdatedPaymentDetailsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().noUpdatedPaymentDetails();
                        return true;
                    case 4:
                        PaymentRequestAbortParams.deserialize(messageWithHeader.getPayload());
                        getImpl().abort();
                        return true;
                    case 5:
                        PaymentRequestCompleteParams data4 = PaymentRequestCompleteParams.deserialize(messageWithHeader.getPayload());
                        getImpl().complete(data4.result);
                        return true;
                    case 6:
                        PaymentRequestRetryParams data5 = PaymentRequestRetryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().retry(data5.errors);
                        return true;
                    case 7:
                        PaymentRequestCanMakePaymentParams data6 = PaymentRequestCanMakePaymentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().canMakePayment(data6.legacyMode);
                        return true;
                    case 8:
                        PaymentRequestHasEnrolledInstrumentParams data7 = PaymentRequestHasEnrolledInstrumentParams.deserialize(messageWithHeader.getPayload());
                        getImpl().hasEnrolledInstrument(data7.perMethodQuota);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), PaymentRequest_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestInitParams.class */
    static final class PaymentRequestInitParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentRequestClient client;
        public PaymentMethodData[] methodData;
        public PaymentDetails details;
        public PaymentOptions options;

        private PaymentRequestInitParams(int version) {
            super(40, version);
        }

        public PaymentRequestInitParams() {
            this(0);
        }

        public static PaymentRequestInitParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestInitParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestInitParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestInitParams result = new PaymentRequestInitParams(elementsOrVersion);
                result.client = (PaymentRequestClient) decoder0.readServiceInterface(8, false, PaymentRequestClient.MANAGER);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.methodData = new PaymentMethodData[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.methodData[i1] = PaymentMethodData.decode(decoder2);
                }
                result.details = PaymentDetails.decode(decoder0.readPointer(24, false));
                result.options = PaymentOptions.decode(decoder0.readPointer(32, false));
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
            encoder0.encode(this.client, 8, false, PaymentRequestClient.MANAGER);
            if (this.methodData == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.methodData.length, 16, -1);
                for (int i0 = 0; i0 < this.methodData.length; i0++) {
                    encoder1.encode((Struct) this.methodData[i0], 8 + (8 * i0), false);
                }
            }
            encoder0.encode((Struct) this.details, 24, false);
            encoder0.encode((Struct) this.options, 32, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestShowParams.class */
    static final class PaymentRequestShowParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isUserGesture;
        public boolean waitForUpdatedDetails;

        private PaymentRequestShowParams(int version) {
            super(16, version);
        }

        public PaymentRequestShowParams() {
            this(0);
        }

        public static PaymentRequestShowParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestShowParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestShowParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestShowParams result = new PaymentRequestShowParams(elementsOrVersion);
                result.isUserGesture = decoder0.readBoolean(8, 0);
                result.waitForUpdatedDetails = decoder0.readBoolean(8, 1);
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
            encoder0.encode(this.isUserGesture, 8, 0);
            encoder0.encode(this.waitForUpdatedDetails, 8, 1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestUpdateWithParams.class */
    static final class PaymentRequestUpdateWithParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentDetails details;

        private PaymentRequestUpdateWithParams(int version) {
            super(16, version);
        }

        public PaymentRequestUpdateWithParams() {
            this(0);
        }

        public static PaymentRequestUpdateWithParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestUpdateWithParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestUpdateWithParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestUpdateWithParams result = new PaymentRequestUpdateWithParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.details = PaymentDetails.decode(decoder1);
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
            encoder0.encode((Struct) this.details, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestNoUpdatedPaymentDetailsParams.class */
    static final class PaymentRequestNoUpdatedPaymentDetailsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PaymentRequestNoUpdatedPaymentDetailsParams(int version) {
            super(8, version);
        }

        public PaymentRequestNoUpdatedPaymentDetailsParams() {
            this(0);
        }

        public static PaymentRequestNoUpdatedPaymentDetailsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestNoUpdatedPaymentDetailsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestNoUpdatedPaymentDetailsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestNoUpdatedPaymentDetailsParams result = new PaymentRequestNoUpdatedPaymentDetailsParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestAbortParams.class */
    static final class PaymentRequestAbortParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PaymentRequestAbortParams(int version) {
            super(8, version);
        }

        public PaymentRequestAbortParams() {
            this(0);
        }

        public static PaymentRequestAbortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestAbortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestAbortParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestAbortParams result = new PaymentRequestAbortParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestCompleteParams.class */
    static final class PaymentRequestCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private PaymentRequestCompleteParams(int version) {
            super(16, version);
        }

        public PaymentRequestCompleteParams() {
            this(0);
        }

        public static PaymentRequestCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestCompleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestCompleteParams result = new PaymentRequestCompleteParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                PaymentComplete.validate(result.result);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestRetryParams.class */
    static final class PaymentRequestRetryParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentValidationErrors errors;

        private PaymentRequestRetryParams(int version) {
            super(16, version);
        }

        public PaymentRequestRetryParams() {
            this(0);
        }

        public static PaymentRequestRetryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestRetryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestRetryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestRetryParams result = new PaymentRequestRetryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.errors = PaymentValidationErrors.decode(decoder1);
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
            encoder0.encode((Struct) this.errors, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestCanMakePaymentParams.class */
    static final class PaymentRequestCanMakePaymentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean legacyMode;

        private PaymentRequestCanMakePaymentParams(int version) {
            super(16, version);
        }

        public PaymentRequestCanMakePaymentParams() {
            this(0);
        }

        public static PaymentRequestCanMakePaymentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestCanMakePaymentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestCanMakePaymentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestCanMakePaymentParams result = new PaymentRequestCanMakePaymentParams(elementsOrVersion);
                result.legacyMode = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.legacyMode, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest_Internal$PaymentRequestHasEnrolledInstrumentParams.class */
    static final class PaymentRequestHasEnrolledInstrumentParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean perMethodQuota;

        private PaymentRequestHasEnrolledInstrumentParams(int version) {
            super(16, version);
        }

        public PaymentRequestHasEnrolledInstrumentParams() {
            this(0);
        }

        public static PaymentRequestHasEnrolledInstrumentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentRequestHasEnrolledInstrumentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentRequestHasEnrolledInstrumentParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentRequestHasEnrolledInstrumentParams result = new PaymentRequestHasEnrolledInstrumentParams(elementsOrVersion);
                result.perMethodQuota = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.perMethodQuota, 8, 0);
        }
    }
}
