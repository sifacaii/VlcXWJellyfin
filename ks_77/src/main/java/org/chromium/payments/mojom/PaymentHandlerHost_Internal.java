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
import org.chromium.payments.mojom.PaymentHandlerHost;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal.class */
class PaymentHandlerHost_Internal {
    public static final Interface.Manager<PaymentHandlerHost, PaymentHandlerHost.Proxy> MANAGER = new Interface.Manager<PaymentHandlerHost, PaymentHandlerHost.Proxy>() { // from class: org.chromium.payments.mojom.PaymentHandlerHost_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "payments.mojom.PaymentHandlerHost";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public PaymentHandlerHost.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, PaymentHandlerHost impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public PaymentHandlerHost[] buildArray(int size) {
            return new PaymentHandlerHost[size];
        }
    };
    private static final int CHANGE_PAYMENT_METHOD_ORDINAL = 0;

    PaymentHandlerHost_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements PaymentHandlerHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.payments.mojom.PaymentHandlerHost
        public void changePaymentMethod(PaymentHandlerMethodData methodData, PaymentHandlerHost.ChangePaymentMethodResponse callback) {
            PaymentHandlerHostChangePaymentMethodParams _message = new PaymentHandlerHostChangePaymentMethodParams();
            _message.methodData = methodData;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<PaymentHandlerHost> {
        Stub(Core core, PaymentHandlerHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PaymentHandlerHost_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), PaymentHandlerHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        PaymentHandlerHostChangePaymentMethodParams data = PaymentHandlerHostChangePaymentMethodParams.deserialize(messageWithHeader.getPayload());
                        getImpl().changePaymentMethod(data.methodData, new PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal$PaymentHandlerHostChangePaymentMethodParams.class */
    static final class PaymentHandlerHostChangePaymentMethodParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentHandlerMethodData methodData;

        private PaymentHandlerHostChangePaymentMethodParams(int version) {
            super(16, version);
        }

        public PaymentHandlerHostChangePaymentMethodParams() {
            this(0);
        }

        public static PaymentHandlerHostChangePaymentMethodParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentHandlerHostChangePaymentMethodParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentHandlerHostChangePaymentMethodParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentHandlerHostChangePaymentMethodParams result = new PaymentHandlerHostChangePaymentMethodParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.methodData = PaymentHandlerMethodData.decode(decoder1);
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
            encoder0.encode((Struct) this.methodData, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal$PaymentHandlerHostChangePaymentMethodResponseParams.class */
    public static final class PaymentHandlerHostChangePaymentMethodResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PaymentMethodChangeResponse responseData;

        private PaymentHandlerHostChangePaymentMethodResponseParams(int version) {
            super(16, version);
        }

        public PaymentHandlerHostChangePaymentMethodResponseParams() {
            this(0);
        }

        public static PaymentHandlerHostChangePaymentMethodResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PaymentHandlerHostChangePaymentMethodResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PaymentHandlerHostChangePaymentMethodResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PaymentHandlerHostChangePaymentMethodResponseParams result = new PaymentHandlerHostChangePaymentMethodResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.responseData = PaymentMethodChangeResponse.decode(decoder1);
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
            encoder0.encode((Struct) this.responseData, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal$PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback.class */
    static class PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PaymentHandlerHost.ChangePaymentMethodResponse mCallback;

        PaymentHandlerHostChangePaymentMethodResponseParamsForwardToCallback(PaymentHandlerHost.ChangePaymentMethodResponse callback) {
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
                PaymentHandlerHostChangePaymentMethodResponseParams response = PaymentHandlerHostChangePaymentMethodResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.responseData);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost_Internal$PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder.class */
    static class PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder implements PaymentHandlerHost.ChangePaymentMethodResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PaymentHandlerHostChangePaymentMethodResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(PaymentMethodChangeResponse responseData) {
            PaymentHandlerHostChangePaymentMethodResponseParams _response = new PaymentHandlerHostChangePaymentMethodResponseParams();
            _response.responseData = responseData;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
