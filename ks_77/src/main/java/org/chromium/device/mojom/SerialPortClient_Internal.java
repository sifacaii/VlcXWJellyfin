package org.chromium.device.mojom;

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

class SerialPortClient_Internal {
    public static final Interface.Manager<SerialPortClient, SerialPortClient.Proxy> MANAGER = new Interface.Manager<SerialPortClient, SerialPortClient.Proxy>() {
        public String getName() {
            return "device.mojom.SerialPortClient";
        }

        public int getVersion() {
            return 0;
        }

        public SerialPortClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SerialPortClient_Internal.Proxy(core, messageReceiver);
        }

        public SerialPortClient_Internal.Stub buildStub(Core core, SerialPortClient impl) {
            return new SerialPortClient_Internal.Stub(core, impl);
        }

        public SerialPortClient[] buildArray(int size) {
            return new SerialPortClient[size];
        }
    };

    private static final int ON_READ_ERROR_ORDINAL = 0;

    private static final int ON_SEND_ERROR_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements SerialPortClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onReadError(int error) {
            SerialPortClient_Internal.SerialPortClientOnReadErrorParams _message = new SerialPortClient_Internal.SerialPortClientOnReadErrorParams();
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onSendError(int error) {
            SerialPortClient_Internal.SerialPortClientOnSendErrorParams _message = new SerialPortClient_Internal.SerialPortClientOnSendErrorParams();
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<SerialPortClient> {
        Stub(Core core, SerialPortClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SerialPortClient_Internal.SerialPortClientOnReadErrorParams serialPortClientOnReadErrorParams;
                SerialPortClient_Internal.SerialPortClientOnSendErrorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SerialPortClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        serialPortClientOnReadErrorParams = SerialPortClient_Internal.SerialPortClientOnReadErrorParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPortClient)getImpl()).onReadError(serialPortClientOnReadErrorParams.error);
                        return true;
                    case 1:
                        data = SerialPortClient_Internal.SerialPortClientOnSendErrorParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPortClient)getImpl()).onSendError(data.error);
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), SerialPortClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SerialPortClientOnReadErrorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private SerialPortClientOnReadErrorParams(int version) {
            super(16, version);
        }

        public SerialPortClientOnReadErrorParams() {
            this(0);
        }

        public static SerialPortClientOnReadErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortClientOnReadErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortClientOnReadErrorParams decode(Decoder decoder0) {
            SerialPortClientOnReadErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortClientOnReadErrorParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                SerialReceiveError.validate(result.error);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    static final class SerialPortClientOnSendErrorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private SerialPortClientOnSendErrorParams(int version) {
            super(16, version);
        }

        public SerialPortClientOnSendErrorParams() {
            this(0);
        }

        public static SerialPortClientOnSendErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortClientOnSendErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortClientOnSendErrorParams decode(Decoder decoder0) {
            SerialPortClientOnSendErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortClientOnSendErrorParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                SerialSendError.validate(result.error);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }
}
