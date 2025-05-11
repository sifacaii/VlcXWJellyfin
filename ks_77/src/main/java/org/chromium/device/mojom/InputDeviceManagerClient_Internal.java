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

class InputDeviceManagerClient_Internal {
    public static final Interface.Manager<InputDeviceManagerClient, InputDeviceManagerClient.Proxy> MANAGER = new Interface.Manager<InputDeviceManagerClient, InputDeviceManagerClient.Proxy>() {
        public String getName() {
            return "device.mojom.InputDeviceManagerClient";
        }

        public int getVersion() {
            return 0;
        }

        public InputDeviceManagerClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new InputDeviceManagerClient_Internal.Proxy(core, messageReceiver);
        }

        public InputDeviceManagerClient_Internal.Stub buildStub(Core core, InputDeviceManagerClient impl) {
            return new InputDeviceManagerClient_Internal.Stub(core, impl);
        }

        public InputDeviceManagerClient[] buildArray(int size) {
            return new InputDeviceManagerClient[size];
        }
    };

    private static final int INPUT_DEVICE_ADDED_ORDINAL = 0;

    private static final int INPUT_DEVICE_REMOVED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements InputDeviceManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void inputDeviceAdded(InputDeviceInfo deviceInfo) {
            InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceAddedParams _message = new InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceAddedParams();
            _message.deviceInfo = deviceInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void inputDeviceRemoved(String id) {
            InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceRemovedParams _message = new InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceRemovedParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<InputDeviceManagerClient> {
        Stub(Core core, InputDeviceManagerClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceAddedParams inputDeviceManagerClientInputDeviceAddedParams;
                InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceRemovedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InputDeviceManagerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        inputDeviceManagerClientInputDeviceAddedParams = InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceAddedParams.deserialize(messageWithHeader.getPayload());
                        ((InputDeviceManagerClient)getImpl()).inputDeviceAdded(inputDeviceManagerClientInputDeviceAddedParams.deviceInfo);
                        return true;
                    case 1:
                        data = InputDeviceManagerClient_Internal.InputDeviceManagerClientInputDeviceRemovedParams.deserialize(messageWithHeader.getPayload());
                        ((InputDeviceManagerClient)getImpl()).inputDeviceRemoved(data.id);
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
                                getCore(), InputDeviceManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class InputDeviceManagerClientInputDeviceAddedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InputDeviceInfo deviceInfo;

        private InputDeviceManagerClientInputDeviceAddedParams(int version) {
            super(16, version);
        }

        public InputDeviceManagerClientInputDeviceAddedParams() {
            this(0);
        }

        public static InputDeviceManagerClientInputDeviceAddedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputDeviceManagerClientInputDeviceAddedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputDeviceManagerClientInputDeviceAddedParams decode(Decoder decoder0) {
            InputDeviceManagerClientInputDeviceAddedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InputDeviceManagerClientInputDeviceAddedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.deviceInfo = InputDeviceInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceInfo, 8, false);
        }
    }

    static final class InputDeviceManagerClientInputDeviceRemovedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String id;

        private InputDeviceManagerClientInputDeviceRemovedParams(int version) {
            super(16, version);
        }

        public InputDeviceManagerClientInputDeviceRemovedParams() {
            this(0);
        }

        public static InputDeviceManagerClientInputDeviceRemovedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputDeviceManagerClientInputDeviceRemovedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputDeviceManagerClientInputDeviceRemovedParams decode(Decoder decoder0) {
            InputDeviceManagerClientInputDeviceRemovedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InputDeviceManagerClientInputDeviceRemovedParams(elementsOrVersion);
                result.id = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8, false);
        }
    }
}
