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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class SerialPort_Internal {
    public static final Interface.Manager<SerialPort, SerialPort.Proxy> MANAGER = new Interface.Manager<SerialPort, SerialPort.Proxy>() {
        public String getName() {
            return "device.mojom.SerialPort";
        }

        public int getVersion() {
            return 0;
        }

        public SerialPort_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SerialPort_Internal.Proxy(core, messageReceiver);
        }

        public SerialPort_Internal.Stub buildStub(Core core, SerialPort impl) {
            return new SerialPort_Internal.Stub(core, impl);
        }

        public SerialPort[] buildArray(int size) {
            return new SerialPort[size];
        }
    };

    private static final int OPEN_ORDINAL = 0;

    private static final int CLEAR_SEND_ERROR_ORDINAL = 1;

    private static final int CLEAR_READ_ERROR_ORDINAL = 2;

    private static final int FLUSH_ORDINAL = 3;

    private static final int GET_CONTROL_SIGNALS_ORDINAL = 4;

    private static final int SET_CONTROL_SIGNALS_ORDINAL = 5;

    private static final int CONFIGURE_PORT_ORDINAL = 6;

    private static final int GET_PORT_INFO_ORDINAL = 7;

    private static final int SET_BREAK_ORDINAL = 8;

    private static final int CLEAR_BREAK_ORDINAL = 9;

    private static final int CLOSE_ORDINAL = 10;

    static final class Proxy extends Interface.AbstractProxy implements SerialPort.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void open(SerialConnectionOptions options, DataPipe.ConsumerHandle inStream, DataPipe.ProducerHandle outStream, SerialPortClient client, SerialPort.OpenResponse callback) {
            SerialPort_Internal.SerialPortOpenParams _message = new SerialPort_Internal.SerialPortOpenParams();
            _message.options = options;
            _message.inStream = inStream;
            _message.outStream = outStream;
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new SerialPort_Internal.SerialPortOpenResponseParamsForwardToCallback(callback));
        }

        public void clearSendError(DataPipe.ConsumerHandle consumer) {
            SerialPort_Internal.SerialPortClearSendErrorParams _message = new SerialPort_Internal.SerialPortClearSendErrorParams();
            _message.consumer = consumer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void clearReadError(DataPipe.ProducerHandle producer) {
            SerialPort_Internal.SerialPortClearReadErrorParams _message = new SerialPort_Internal.SerialPortClearReadErrorParams();
            _message.producer = producer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void flush(SerialPort.FlushResponse callback) {
            SerialPort_Internal.SerialPortFlushParams _message = new SerialPort_Internal.SerialPortFlushParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new SerialPort_Internal.SerialPortFlushResponseParamsForwardToCallback(callback));
        }

        public void getControlSignals(SerialPort.GetControlSignalsResponse callback) {
            SerialPort_Internal.SerialPortGetControlSignalsParams _message = new SerialPort_Internal.SerialPortGetControlSignalsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new SerialPort_Internal.SerialPortGetControlSignalsResponseParamsForwardToCallback(callback));
        }

        public void setControlSignals(SerialHostControlSignals signals, SerialPort.SetControlSignalsResponse callback) {
            SerialPort_Internal.SerialPortSetControlSignalsParams _message = new SerialPort_Internal.SerialPortSetControlSignalsParams();
            _message.signals = signals;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new SerialPort_Internal.SerialPortSetControlSignalsResponseParamsForwardToCallback(callback));
        }

        public void configurePort(SerialConnectionOptions options, SerialPort.ConfigurePortResponse callback) {
            SerialPort_Internal.SerialPortConfigurePortParams _message = new SerialPort_Internal.SerialPortConfigurePortParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new SerialPort_Internal.SerialPortConfigurePortResponseParamsForwardToCallback(callback));
        }

        public void getPortInfo(SerialPort.GetPortInfoResponse callback) {
            SerialPort_Internal.SerialPortGetPortInfoParams _message = new SerialPort_Internal.SerialPortGetPortInfoParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new SerialPort_Internal.SerialPortGetPortInfoResponseParamsForwardToCallback(callback));
        }

        public void setBreak(SerialPort.SetBreakResponse callback) {
            SerialPort_Internal.SerialPortSetBreakParams _message = new SerialPort_Internal.SerialPortSetBreakParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new SerialPort_Internal.SerialPortSetBreakResponseParamsForwardToCallback(callback));
        }

        public void clearBreak(SerialPort.ClearBreakResponse callback) {
            SerialPort_Internal.SerialPortClearBreakParams _message = new SerialPort_Internal.SerialPortClearBreakParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new SerialPort_Internal.SerialPortClearBreakResponseParamsForwardToCallback(callback));
        }

        public void close(SerialPort.CloseResponse callback) {
            SerialPort_Internal.SerialPortCloseParams _message = new SerialPort_Internal.SerialPortCloseParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new SerialPort_Internal.SerialPortCloseResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<SerialPort> {
        Stub(Core core, SerialPort impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SerialPort_Internal.SerialPortClearSendErrorParams serialPortClearSendErrorParams;
                SerialPort_Internal.SerialPortClearReadErrorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SerialPort_Internal.MANAGER, messageWithHeader);
                    case 1:
                        serialPortClearSendErrorParams = SerialPort_Internal.SerialPortClearSendErrorParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).clearSendError(serialPortClearSendErrorParams.consumer);
                        return true;
                    case 2:
                        data = SerialPort_Internal.SerialPortClearReadErrorParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).clearReadError(data.producer);
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
                SerialPort_Internal.SerialPortOpenParams serialPortOpenParams;
                SerialPort_Internal.SerialPortSetControlSignalsParams serialPortSetControlSignalsParams;
                SerialPort_Internal.SerialPortConfigurePortParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), SerialPort_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        serialPortOpenParams = SerialPort_Internal.SerialPortOpenParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).open(serialPortOpenParams.options, serialPortOpenParams.inStream, serialPortOpenParams.outStream, serialPortOpenParams.client, new SerialPort_Internal.SerialPortOpenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        SerialPort_Internal.SerialPortFlushParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).flush(new SerialPort_Internal.SerialPortFlushResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        SerialPort_Internal.SerialPortGetControlSignalsParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).getControlSignals(new SerialPort_Internal.SerialPortGetControlSignalsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        serialPortSetControlSignalsParams = SerialPort_Internal.SerialPortSetControlSignalsParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).setControlSignals(serialPortSetControlSignalsParams.signals, new SerialPort_Internal.SerialPortSetControlSignalsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        data = SerialPort_Internal.SerialPortConfigurePortParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).configurePort(data.options, new SerialPort_Internal.SerialPortConfigurePortResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        SerialPort_Internal.SerialPortGetPortInfoParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).getPortInfo(new SerialPort_Internal.SerialPortGetPortInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        SerialPort_Internal.SerialPortSetBreakParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).setBreak(new SerialPort_Internal.SerialPortSetBreakResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        SerialPort_Internal.SerialPortClearBreakParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).clearBreak(new SerialPort_Internal.SerialPortClearBreakResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        SerialPort_Internal.SerialPortCloseParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPort)getImpl()).close(new SerialPort_Internal.SerialPortCloseResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SerialPortOpenParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerialConnectionOptions options;

        public DataPipe.ConsumerHandle inStream;

        public DataPipe.ProducerHandle outStream;

        public SerialPortClient client;

        private SerialPortOpenParams(int version) {
            super(32, version);
            this.inStream = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
            this.outStream = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
        }

        public SerialPortOpenParams() {
            this(0);
        }

        public static SerialPortOpenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortOpenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortOpenParams decode(Decoder decoder0) {
            SerialPortOpenParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortOpenParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = SerialConnectionOptions.decode(decoder1);
                result.inStream = decoder0.readConsumerHandle(16, false);
                result.outStream = decoder0.readProducerHandle(20, false);
                result.client = (SerialPortClient)decoder0.readServiceInterface(24, false, SerialPortClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, false);
            encoder0.encode((Handle)this.inStream, 16, false);
            encoder0.encode((Handle)this.outStream, 20, false);
            encoder0.encode(this.client, 24, false, SerialPortClient.MANAGER);
        }
    }

    static final class SerialPortOpenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SerialPortOpenResponseParams(int version) {
            super(16, version);
        }

        public SerialPortOpenResponseParams() {
            this(0);
        }

        public static SerialPortOpenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortOpenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortOpenResponseParams decode(Decoder decoder0) {
            SerialPortOpenResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortOpenResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SerialPortOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.OpenResponse mCallback;

        SerialPortOpenResponseParamsForwardToCallback(SerialPort.OpenResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                SerialPort_Internal.SerialPortOpenResponseParams response = SerialPort_Internal.SerialPortOpenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortOpenResponseParamsProxyToResponder implements SerialPort.OpenResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortOpenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            SerialPort_Internal.SerialPortOpenResponseParams _response = new SerialPort_Internal.SerialPortOpenResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortClearSendErrorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DataPipe.ConsumerHandle consumer;

        private SerialPortClearSendErrorParams(int version) {
            super(16, version);
            this.consumer = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
        }

        public SerialPortClearSendErrorParams() {
            this(0);
        }

        public static SerialPortClearSendErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortClearSendErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortClearSendErrorParams decode(Decoder decoder0) {
            SerialPortClearSendErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortClearSendErrorParams(elementsOrVersion);
                result.consumer = decoder0.readConsumerHandle(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle)this.consumer, 8, false);
        }
    }

    static final class SerialPortClearReadErrorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DataPipe.ProducerHandle producer;

        private SerialPortClearReadErrorParams(int version) {
            super(16, version);
            this.producer = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
        }

        public SerialPortClearReadErrorParams() {
            this(0);
        }

        public static SerialPortClearReadErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortClearReadErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortClearReadErrorParams decode(Decoder decoder0) {
            SerialPortClearReadErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortClearReadErrorParams(elementsOrVersion);
                result.producer = decoder0.readProducerHandle(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle)this.producer, 8, false);
        }
    }

    static final class SerialPortFlushParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortFlushParams(int version) {
            super(8, version);
        }

        public SerialPortFlushParams() {
            this(0);
        }

        public static SerialPortFlushParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortFlushParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortFlushParams decode(Decoder decoder0) {
            SerialPortFlushParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortFlushParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortFlushResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SerialPortFlushResponseParams(int version) {
            super(16, version);
        }

        public SerialPortFlushResponseParams() {
            this(0);
        }

        public static SerialPortFlushResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortFlushResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortFlushResponseParams decode(Decoder decoder0) {
            SerialPortFlushResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortFlushResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SerialPortFlushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.FlushResponse mCallback;

        SerialPortFlushResponseParamsForwardToCallback(SerialPort.FlushResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                SerialPort_Internal.SerialPortFlushResponseParams response = SerialPort_Internal.SerialPortFlushResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortFlushResponseParamsProxyToResponder implements SerialPort.FlushResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortFlushResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            SerialPort_Internal.SerialPortFlushResponseParams _response = new SerialPort_Internal.SerialPortFlushResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortGetControlSignalsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortGetControlSignalsParams(int version) {
            super(8, version);
        }

        public SerialPortGetControlSignalsParams() {
            this(0);
        }

        public static SerialPortGetControlSignalsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortGetControlSignalsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortGetControlSignalsParams decode(Decoder decoder0) {
            SerialPortGetControlSignalsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortGetControlSignalsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortGetControlSignalsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerialPortControlSignals signals;

        private SerialPortGetControlSignalsResponseParams(int version) {
            super(16, version);
        }

        public SerialPortGetControlSignalsResponseParams() {
            this(0);
        }

        public static SerialPortGetControlSignalsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortGetControlSignalsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortGetControlSignalsResponseParams decode(Decoder decoder0) {
            SerialPortGetControlSignalsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortGetControlSignalsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.signals = SerialPortControlSignals.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.signals, 8, false);
        }
    }

    static class SerialPortGetControlSignalsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.GetControlSignalsResponse mCallback;

        SerialPortGetControlSignalsResponseParamsForwardToCallback(SerialPort.GetControlSignalsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                SerialPort_Internal.SerialPortGetControlSignalsResponseParams response = SerialPort_Internal.SerialPortGetControlSignalsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.signals);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortGetControlSignalsResponseParamsProxyToResponder implements SerialPort.GetControlSignalsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortGetControlSignalsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(SerialPortControlSignals signals) {
            SerialPort_Internal.SerialPortGetControlSignalsResponseParams _response = new SerialPort_Internal.SerialPortGetControlSignalsResponseParams();
            _response.signals = signals;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortSetControlSignalsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerialHostControlSignals signals;

        private SerialPortSetControlSignalsParams(int version) {
            super(16, version);
        }

        public SerialPortSetControlSignalsParams() {
            this(0);
        }

        public static SerialPortSetControlSignalsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortSetControlSignalsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortSetControlSignalsParams decode(Decoder decoder0) {
            SerialPortSetControlSignalsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortSetControlSignalsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.signals = SerialHostControlSignals.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.signals, 8, false);
        }
    }

    static final class SerialPortSetControlSignalsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SerialPortSetControlSignalsResponseParams(int version) {
            super(16, version);
        }

        public SerialPortSetControlSignalsResponseParams() {
            this(0);
        }

        public static SerialPortSetControlSignalsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortSetControlSignalsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortSetControlSignalsResponseParams decode(Decoder decoder0) {
            SerialPortSetControlSignalsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortSetControlSignalsResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SerialPortSetControlSignalsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.SetControlSignalsResponse mCallback;

        SerialPortSetControlSignalsResponseParamsForwardToCallback(SerialPort.SetControlSignalsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                SerialPort_Internal.SerialPortSetControlSignalsResponseParams response = SerialPort_Internal.SerialPortSetControlSignalsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortSetControlSignalsResponseParamsProxyToResponder implements SerialPort.SetControlSignalsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortSetControlSignalsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            SerialPort_Internal.SerialPortSetControlSignalsResponseParams _response = new SerialPort_Internal.SerialPortSetControlSignalsResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortConfigurePortParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerialConnectionOptions options;

        private SerialPortConfigurePortParams(int version) {
            super(16, version);
        }

        public SerialPortConfigurePortParams() {
            this(0);
        }

        public static SerialPortConfigurePortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortConfigurePortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortConfigurePortParams decode(Decoder decoder0) {
            SerialPortConfigurePortParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortConfigurePortParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = SerialConnectionOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, false);
        }
    }

    static final class SerialPortConfigurePortResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SerialPortConfigurePortResponseParams(int version) {
            super(16, version);
        }

        public SerialPortConfigurePortResponseParams() {
            this(0);
        }

        public static SerialPortConfigurePortResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortConfigurePortResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortConfigurePortResponseParams decode(Decoder decoder0) {
            SerialPortConfigurePortResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortConfigurePortResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SerialPortConfigurePortResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.ConfigurePortResponse mCallback;

        SerialPortConfigurePortResponseParamsForwardToCallback(SerialPort.ConfigurePortResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                SerialPort_Internal.SerialPortConfigurePortResponseParams response = SerialPort_Internal.SerialPortConfigurePortResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortConfigurePortResponseParamsProxyToResponder implements SerialPort.ConfigurePortResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortConfigurePortResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            SerialPort_Internal.SerialPortConfigurePortResponseParams _response = new SerialPort_Internal.SerialPortConfigurePortResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortGetPortInfoParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortGetPortInfoParams(int version) {
            super(8, version);
        }

        public SerialPortGetPortInfoParams() {
            this(0);
        }

        public static SerialPortGetPortInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortGetPortInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortGetPortInfoParams decode(Decoder decoder0) {
            SerialPortGetPortInfoParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortGetPortInfoParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortGetPortInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerialConnectionInfo info;

        private SerialPortGetPortInfoResponseParams(int version) {
            super(16, version);
        }

        public SerialPortGetPortInfoResponseParams() {
            this(0);
        }

        public static SerialPortGetPortInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortGetPortInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortGetPortInfoResponseParams decode(Decoder decoder0) {
            SerialPortGetPortInfoResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortGetPortInfoResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = SerialConnectionInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
        }
    }

    static class SerialPortGetPortInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.GetPortInfoResponse mCallback;

        SerialPortGetPortInfoResponseParamsForwardToCallback(SerialPort.GetPortInfoResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                SerialPort_Internal.SerialPortGetPortInfoResponseParams response = SerialPort_Internal.SerialPortGetPortInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.info);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortGetPortInfoResponseParamsProxyToResponder implements SerialPort.GetPortInfoResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortGetPortInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(SerialConnectionInfo info) {
            SerialPort_Internal.SerialPortGetPortInfoResponseParams _response = new SerialPort_Internal.SerialPortGetPortInfoResponseParams();
            _response.info = info;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortSetBreakParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortSetBreakParams(int version) {
            super(8, version);
        }

        public SerialPortSetBreakParams() {
            this(0);
        }

        public static SerialPortSetBreakParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortSetBreakParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortSetBreakParams decode(Decoder decoder0) {
            SerialPortSetBreakParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortSetBreakParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortSetBreakResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SerialPortSetBreakResponseParams(int version) {
            super(16, version);
        }

        public SerialPortSetBreakResponseParams() {
            this(0);
        }

        public static SerialPortSetBreakResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortSetBreakResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortSetBreakResponseParams decode(Decoder decoder0) {
            SerialPortSetBreakResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortSetBreakResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SerialPortSetBreakResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.SetBreakResponse mCallback;

        SerialPortSetBreakResponseParamsForwardToCallback(SerialPort.SetBreakResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2))
                    return false;
                SerialPort_Internal.SerialPortSetBreakResponseParams response = SerialPort_Internal.SerialPortSetBreakResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortSetBreakResponseParamsProxyToResponder implements SerialPort.SetBreakResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortSetBreakResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            SerialPort_Internal.SerialPortSetBreakResponseParams _response = new SerialPort_Internal.SerialPortSetBreakResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortClearBreakParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortClearBreakParams(int version) {
            super(8, version);
        }

        public SerialPortClearBreakParams() {
            this(0);
        }

        public static SerialPortClearBreakParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortClearBreakParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortClearBreakParams decode(Decoder decoder0) {
            SerialPortClearBreakParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortClearBreakParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortClearBreakResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SerialPortClearBreakResponseParams(int version) {
            super(16, version);
        }

        public SerialPortClearBreakResponseParams() {
            this(0);
        }

        public static SerialPortClearBreakResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortClearBreakResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortClearBreakResponseParams decode(Decoder decoder0) {
            SerialPortClearBreakResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortClearBreakResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SerialPortClearBreakResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.ClearBreakResponse mCallback;

        SerialPortClearBreakResponseParamsForwardToCallback(SerialPort.ClearBreakResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2))
                    return false;
                SerialPort_Internal.SerialPortClearBreakResponseParams response = SerialPort_Internal.SerialPortClearBreakResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortClearBreakResponseParamsProxyToResponder implements SerialPort.ClearBreakResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortClearBreakResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            SerialPort_Internal.SerialPortClearBreakResponseParams _response = new SerialPort_Internal.SerialPortClearBreakResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortCloseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortCloseParams(int version) {
            super(8, version);
        }

        public SerialPortCloseParams() {
            this(0);
        }

        public static SerialPortCloseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortCloseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortCloseParams decode(Decoder decoder0) {
            SerialPortCloseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortCloseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortCloseResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortCloseResponseParams(int version) {
            super(8, version);
        }

        public SerialPortCloseResponseParams() {
            this(0);
        }

        public static SerialPortCloseResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortCloseResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortCloseResponseParams decode(Decoder decoder0) {
            SerialPortCloseResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortCloseResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class SerialPortCloseResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPort.CloseResponse mCallback;

        SerialPortCloseResponseParamsForwardToCallback(SerialPort.CloseResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortCloseResponseParamsProxyToResponder implements SerialPort.CloseResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortCloseResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            SerialPort_Internal.SerialPortCloseResponseParams _response = new SerialPort_Internal.SerialPortCloseResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
