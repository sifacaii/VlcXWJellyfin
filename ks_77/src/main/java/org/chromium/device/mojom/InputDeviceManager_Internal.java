package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class InputDeviceManager_Internal {
    public static final Interface.Manager<InputDeviceManager, InputDeviceManager.Proxy> MANAGER = new Interface.Manager<InputDeviceManager, InputDeviceManager.Proxy>() {
        public String getName() {
            return "device.mojom.InputDeviceManager";
        }

        public int getVersion() {
            return 0;
        }

        public InputDeviceManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new InputDeviceManager_Internal.Proxy(core, messageReceiver);
        }

        public InputDeviceManager_Internal.Stub buildStub(Core core, InputDeviceManager impl) {
            return new InputDeviceManager_Internal.Stub(core, impl);
        }

        public InputDeviceManager[] buildArray(int size) {
            return new InputDeviceManager[size];
        }
    };

    private static final int GET_DEVICES_AND_SET_CLIENT_ORDINAL = 0;

    private static final int GET_DEVICES_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements InputDeviceManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getDevicesAndSetClient(AssociatedInterfaceNotSupported client, InputDeviceManager.GetDevicesAndSetClientResponse callback) {
            InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientParams _message = new InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientResponseParamsForwardToCallback(callback));
        }

        public void getDevices(InputDeviceManager.GetDevicesResponse callback) {
            InputDeviceManager_Internal.InputDeviceManagerGetDevicesParams _message = new InputDeviceManager_Internal.InputDeviceManagerGetDevicesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new InputDeviceManager_Internal.InputDeviceManagerGetDevicesResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<InputDeviceManager> {
        Stub(Core core, InputDeviceManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InputDeviceManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), InputDeviceManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((InputDeviceManager)getImpl()).getDevicesAndSetClient(data.client, new InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        InputDeviceManager_Internal.InputDeviceManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((InputDeviceManager)getImpl()).getDevices(new InputDeviceManager_Internal.InputDeviceManagerGetDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class InputDeviceManagerGetDevicesAndSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private InputDeviceManagerGetDevicesAndSetClientParams(int version) {
            super(16, version);
        }

        public InputDeviceManagerGetDevicesAndSetClientParams() {
            this(0);
        }

        public static InputDeviceManagerGetDevicesAndSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputDeviceManagerGetDevicesAndSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputDeviceManagerGetDevicesAndSetClientParams decode(Decoder decoder0) {
            InputDeviceManagerGetDevicesAndSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InputDeviceManagerGetDevicesAndSetClientParams(elementsOrVersion);
                result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false);
        }
    }

    static final class InputDeviceManagerGetDevicesAndSetClientResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InputDeviceInfo[] devices;

        private InputDeviceManagerGetDevicesAndSetClientResponseParams(int version) {
            super(16, version);
        }

        public InputDeviceManagerGetDevicesAndSetClientResponseParams() {
            this(0);
        }

        public static InputDeviceManagerGetDevicesAndSetClientResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputDeviceManagerGetDevicesAndSetClientResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputDeviceManagerGetDevicesAndSetClientResponseParams decode(Decoder decoder0) {
            InputDeviceManagerGetDevicesAndSetClientResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InputDeviceManagerGetDevicesAndSetClientResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.devices = new InputDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.devices[i1] = InputDeviceInfo.decode(decoder2);
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

    static class InputDeviceManagerGetDevicesAndSetClientResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final InputDeviceManager.GetDevicesAndSetClientResponse mCallback;

        InputDeviceManagerGetDevicesAndSetClientResponseParamsForwardToCallback(InputDeviceManager.GetDevicesAndSetClientResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientResponseParams response = InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class InputDeviceManagerGetDevicesAndSetClientResponseParamsProxyToResponder implements InputDeviceManager.GetDevicesAndSetClientResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        InputDeviceManagerGetDevicesAndSetClientResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(InputDeviceInfo[] devices) {
            InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientResponseParams _response = new InputDeviceManager_Internal.InputDeviceManagerGetDevicesAndSetClientResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class InputDeviceManagerGetDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private InputDeviceManagerGetDevicesParams(int version) {
            super(8, version);
        }

        public InputDeviceManagerGetDevicesParams() {
            this(0);
        }

        public static InputDeviceManagerGetDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputDeviceManagerGetDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputDeviceManagerGetDevicesParams decode(Decoder decoder0) {
            InputDeviceManagerGetDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InputDeviceManagerGetDevicesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class InputDeviceManagerGetDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InputDeviceInfo[] devices;

        private InputDeviceManagerGetDevicesResponseParams(int version) {
            super(16, version);
        }

        public InputDeviceManagerGetDevicesResponseParams() {
            this(0);
        }

        public static InputDeviceManagerGetDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputDeviceManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputDeviceManagerGetDevicesResponseParams decode(Decoder decoder0) {
            InputDeviceManagerGetDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InputDeviceManagerGetDevicesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.devices = new InputDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.devices[i1] = InputDeviceInfo.decode(decoder2);
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

    static class InputDeviceManagerGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final InputDeviceManager.GetDevicesResponse mCallback;

        InputDeviceManagerGetDevicesResponseParamsForwardToCallback(InputDeviceManager.GetDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                InputDeviceManager_Internal.InputDeviceManagerGetDevicesResponseParams response = InputDeviceManager_Internal.InputDeviceManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class InputDeviceManagerGetDevicesResponseParamsProxyToResponder implements InputDeviceManager.GetDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        InputDeviceManagerGetDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(InputDeviceInfo[] devices) {
            InputDeviceManager_Internal.InputDeviceManagerGetDevicesResponseParams _response = new InputDeviceManager_Internal.InputDeviceManagerGetDevicesResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
