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

class DateTimeChooser_Internal {
    public static final Interface.Manager<DateTimeChooser, DateTimeChooser.Proxy> MANAGER = new Interface.Manager<DateTimeChooser, DateTimeChooser.Proxy>() {
        public String getName() {
            return "blink.mojom.DateTimeChooser";
        }

        public int getVersion() {
            return 0;
        }

        public DateTimeChooser_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DateTimeChooser_Internal.Proxy(core, messageReceiver);
        }

        public DateTimeChooser_Internal.Stub buildStub(Core core, DateTimeChooser impl) {
            return new DateTimeChooser_Internal.Stub(core, impl);
        }

        public DateTimeChooser[] buildArray(int size) {
            return new DateTimeChooser[size];
        }
    };

    private static final int OPEN_DATE_TIME_DIALOG_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements DateTimeChooser.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openDateTimeDialog(DateTimeDialogValue value, DateTimeChooser.OpenDateTimeDialogResponse callback) {
            DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogParams _message = new DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogParams();
            _message.value = value;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<DateTimeChooser> {
        Stub(Core core, DateTimeChooser impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DateTimeChooser_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), DateTimeChooser_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogParams.deserialize(messageWithHeader.getPayload());
                        ((DateTimeChooser)getImpl()).openDateTimeDialog(data.value, new DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DateTimeChooserOpenDateTimeDialogParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DateTimeDialogValue value;

        private DateTimeChooserOpenDateTimeDialogParams(int version) {
            super(16, version);
        }

        public DateTimeChooserOpenDateTimeDialogParams() {
            this(0);
        }

        public static DateTimeChooserOpenDateTimeDialogParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DateTimeChooserOpenDateTimeDialogParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DateTimeChooserOpenDateTimeDialogParams decode(Decoder decoder0) {
            DateTimeChooserOpenDateTimeDialogParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DateTimeChooserOpenDateTimeDialogParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.value = DateTimeDialogValue.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.value, 8, false);
        }
    }

    static final class DateTimeChooserOpenDateTimeDialogResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public double dialogValue;

        private DateTimeChooserOpenDateTimeDialogResponseParams(int version) {
            super(24, version);
        }

        public DateTimeChooserOpenDateTimeDialogResponseParams() {
            this(0);
        }

        public static DateTimeChooserOpenDateTimeDialogResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DateTimeChooserOpenDateTimeDialogResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DateTimeChooserOpenDateTimeDialogResponseParams decode(Decoder decoder0) {
            DateTimeChooserOpenDateTimeDialogResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DateTimeChooserOpenDateTimeDialogResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.dialogValue = decoder0.readDouble(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.dialogValue, 16);
        }
    }

    static class DateTimeChooserOpenDateTimeDialogResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final DateTimeChooser.OpenDateTimeDialogResponse mCallback;

        DateTimeChooserOpenDateTimeDialogResponseParamsForwardToCallback(DateTimeChooser.OpenDateTimeDialogResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogResponseParams response = DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), Double.valueOf(response.dialogValue));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DateTimeChooserOpenDateTimeDialogResponseParamsProxyToResponder implements DateTimeChooser.OpenDateTimeDialogResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DateTimeChooserOpenDateTimeDialogResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, Double dialogValue) {
            DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogResponseParams _response = new DateTimeChooser_Internal.DateTimeChooserOpenDateTimeDialogResponseParams();
            _response.success = success.booleanValue();
            _response.dialogValue = dialogValue.doubleValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
