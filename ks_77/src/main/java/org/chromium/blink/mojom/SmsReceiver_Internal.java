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
import org.chromium.mojo_base.mojom.TimeDelta;

class SmsReceiver_Internal {
    public static final Interface.Manager<SmsReceiver, SmsReceiver.Proxy> MANAGER = new Interface.Manager<SmsReceiver, SmsReceiver.Proxy>() {
        public String getName() {
            return "blink.mojom.SmsReceiver";
        }

        public int getVersion() {
            return 0;
        }

        public SmsReceiver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SmsReceiver_Internal.Proxy(core, messageReceiver);
        }

        public SmsReceiver_Internal.Stub buildStub(Core core, SmsReceiver impl) {
            return new SmsReceiver_Internal.Stub(core, impl);
        }

        public SmsReceiver[] buildArray(int size) {
            return new SmsReceiver[size];
        }
    };

    private static final int RECEIVE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements SmsReceiver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void receive(TimeDelta timeout, SmsReceiver.ReceiveResponse callback) {
            SmsReceiver_Internal.SmsReceiverReceiveParams _message = new SmsReceiver_Internal.SmsReceiverReceiveParams();
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new SmsReceiver_Internal.SmsReceiverReceiveResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<SmsReceiver> {
        Stub(Core core, SmsReceiver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SmsReceiver_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                SmsReceiver_Internal.SmsReceiverReceiveParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), SmsReceiver_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = SmsReceiver_Internal.SmsReceiverReceiveParams.deserialize(messageWithHeader.getPayload());
                        ((SmsReceiver)getImpl()).receive(data.timeout, new SmsReceiver_Internal.SmsReceiverReceiveResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SmsReceiverReceiveParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TimeDelta timeout;

        private SmsReceiverReceiveParams(int version) {
            super(16, version);
        }

        public SmsReceiverReceiveParams() {
            this(0);
        }

        public static SmsReceiverReceiveParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SmsReceiverReceiveParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SmsReceiverReceiveParams decode(Decoder decoder0) {
            SmsReceiverReceiveParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SmsReceiverReceiveParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.timeout = TimeDelta.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.timeout, 8, false);
        }
    }

    static final class SmsReceiverReceiveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public String message;

        private SmsReceiverReceiveResponseParams(int version) {
            super(24, version);
        }

        public SmsReceiverReceiveResponseParams() {
            this(0);
        }

        public static SmsReceiverReceiveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SmsReceiverReceiveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SmsReceiverReceiveResponseParams decode(Decoder decoder0) {
            SmsReceiverReceiveResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SmsReceiverReceiveResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                SmsStatus.validate(result.status);
                result.message = decoder0.readString(16, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.message, 16, true);
        }
    }

    static class SmsReceiverReceiveResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SmsReceiver.ReceiveResponse mCallback;

        SmsReceiverReceiveResponseParamsForwardToCallback(SmsReceiver.ReceiveResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                SmsReceiver_Internal.SmsReceiverReceiveResponseParams response = SmsReceiver_Internal.SmsReceiverReceiveResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.message);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SmsReceiverReceiveResponseParamsProxyToResponder implements SmsReceiver.ReceiveResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SmsReceiverReceiveResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, String message) {
            SmsReceiver_Internal.SmsReceiverReceiveResponseParams _response = new SmsReceiver_Internal.SmsReceiverReceiveResponseParams();
            _response.status = status.intValue();
            _response.message = message;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
