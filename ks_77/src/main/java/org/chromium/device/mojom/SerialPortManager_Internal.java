package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class SerialPortManager_Internal {
    public static final Interface.Manager<SerialPortManager, SerialPortManager.Proxy> MANAGER = new Interface.Manager<SerialPortManager, SerialPortManager.Proxy>() {
        public String getName() {
            return "device.mojom.SerialPortManager";
        }

        public int getVersion() {
            return 0;
        }

        public SerialPortManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SerialPortManager_Internal.Proxy(core, messageReceiver);
        }

        public SerialPortManager_Internal.Stub buildStub(Core core, SerialPortManager impl) {
            return new SerialPortManager_Internal.Stub(core, impl);
        }

        public SerialPortManager[] buildArray(int size) {
            return new SerialPortManager[size];
        }
    };

    private static final int GET_DEVICES_ORDINAL = 0;

    private static final int GET_PORT_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements SerialPortManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getDevices(SerialPortManager.GetDevicesResponse callback) {
            SerialPortManager_Internal.SerialPortManagerGetDevicesParams _message = new SerialPortManager_Internal.SerialPortManagerGetDevicesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new SerialPortManager_Internal.SerialPortManagerGetDevicesResponseParamsForwardToCallback(callback));
        }

        public void getPort(UnguessableToken token, InterfaceRequest<SerialPort> portRequest, SerialPortConnectionWatcher watcher) {
            SerialPortManager_Internal.SerialPortManagerGetPortParams _message = new SerialPortManager_Internal.SerialPortManagerGetPortParams();
            _message.token = token;
            _message.portRequest = portRequest;
            _message.watcher = watcher;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<SerialPortManager> {
        Stub(Core core, SerialPortManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SerialPortManager_Internal.SerialPortManagerGetPortParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SerialPortManager_Internal.MANAGER, messageWithHeader);
                    case 1:
                        data = SerialPortManager_Internal.SerialPortManagerGetPortParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPortManager)getImpl()).getPort(data.token, data.portRequest, data.watcher);
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
                                getCore(), SerialPortManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        SerialPortManager_Internal.SerialPortManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((SerialPortManager)getImpl()).getDevices(new SerialPortManager_Internal.SerialPortManagerGetDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SerialPortManagerGetDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SerialPortManagerGetDevicesParams(int version) {
            super(8, version);
        }

        public SerialPortManagerGetDevicesParams() {
            this(0);
        }

        public static SerialPortManagerGetDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortManagerGetDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortManagerGetDevicesParams decode(Decoder decoder0) {
            SerialPortManagerGetDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortManagerGetDevicesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SerialPortManagerGetDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SerialPortInfo[] devices;

        private SerialPortManagerGetDevicesResponseParams(int version) {
            super(16, version);
        }

        public SerialPortManagerGetDevicesResponseParams() {
            this(0);
        }

        public static SerialPortManagerGetDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortManagerGetDevicesResponseParams decode(Decoder decoder0) {
            SerialPortManagerGetDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortManagerGetDevicesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.devices = new SerialPortInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.devices[i1] = SerialPortInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.devices == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.devices.length, 8, -1);
                for (int i0 = 0; i0 < this.devices.length; i0++)
                    encoder1.encode(this.devices[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class SerialPortManagerGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SerialPortManager.GetDevicesResponse mCallback;

        SerialPortManagerGetDevicesResponseParamsForwardToCallback(SerialPortManager.GetDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                SerialPortManager_Internal.SerialPortManagerGetDevicesResponseParams response = SerialPortManager_Internal.SerialPortManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SerialPortManagerGetDevicesResponseParamsProxyToResponder implements SerialPortManager.GetDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SerialPortManagerGetDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(SerialPortInfo[] devices) {
            SerialPortManager_Internal.SerialPortManagerGetDevicesResponseParams _response = new SerialPortManager_Internal.SerialPortManagerGetDevicesResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SerialPortManagerGetPortParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UnguessableToken token;

        public InterfaceRequest<SerialPort> portRequest;

        public SerialPortConnectionWatcher watcher;

        private SerialPortManagerGetPortParams(int version) {
            super(32, version);
        }

        public SerialPortManagerGetPortParams() {
            this(0);
        }

        public static SerialPortManagerGetPortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SerialPortManagerGetPortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SerialPortManagerGetPortParams decode(Decoder decoder0) {
            SerialPortManagerGetPortParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SerialPortManagerGetPortParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.token = UnguessableToken.decode(decoder1);
                result.portRequest = decoder0.readInterfaceRequest(16, false);
                result.watcher = (SerialPortConnectionWatcher)decoder0.readServiceInterface(20, true, SerialPortConnectionWatcher.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.token, 8, false);
            encoder0.encode(this.portRequest, 16, false);
            encoder0.encode(this.watcher, 20, true, SerialPortConnectionWatcher.MANAGER);
        }
    }
}
