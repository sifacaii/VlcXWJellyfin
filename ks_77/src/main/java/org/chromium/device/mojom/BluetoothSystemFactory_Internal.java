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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class BluetoothSystemFactory_Internal {
    public static final Interface.Manager<BluetoothSystemFactory, BluetoothSystemFactory.Proxy> MANAGER = new Interface.Manager<BluetoothSystemFactory, BluetoothSystemFactory.Proxy>() {
        public String getName() {
            return "device.mojom.BluetoothSystemFactory";
        }

        public int getVersion() {
            return 0;
        }

        public BluetoothSystemFactory_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BluetoothSystemFactory_Internal.Proxy(core, messageReceiver);
        }

        public BluetoothSystemFactory_Internal.Stub buildStub(Core core, BluetoothSystemFactory impl) {
            return new BluetoothSystemFactory_Internal.Stub(core, impl);
        }

        public BluetoothSystemFactory[] buildArray(int size) {
            return new BluetoothSystemFactory[size];
        }
    };

    private static final int CREATE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements BluetoothSystemFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void create(InterfaceRequest<BluetoothSystem> system, BluetoothSystemClient systemClient) {
            BluetoothSystemFactory_Internal.BluetoothSystemFactoryCreateParams _message = new BluetoothSystemFactory_Internal.BluetoothSystemFactoryCreateParams();
            _message.system = system;
            _message.systemClient = systemClient;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<BluetoothSystemFactory> {
        Stub(Core core, BluetoothSystemFactory impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BluetoothSystemFactory_Internal.BluetoothSystemFactoryCreateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BluetoothSystemFactory_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = BluetoothSystemFactory_Internal.BluetoothSystemFactoryCreateParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystemFactory)getImpl()).create(data.system, data.systemClient);
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
                                getCore(), BluetoothSystemFactory_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BluetoothSystemFactoryCreateParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<BluetoothSystem> system;

        public BluetoothSystemClient systemClient;

        private BluetoothSystemFactoryCreateParams(int version) {
            super(24, version);
        }

        public BluetoothSystemFactoryCreateParams() {
            this(0);
        }

        public static BluetoothSystemFactoryCreateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemFactoryCreateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemFactoryCreateParams decode(Decoder decoder0) {
            BluetoothSystemFactoryCreateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemFactoryCreateParams(elementsOrVersion);
                result.system = decoder0.readInterfaceRequest(8, false);
                result.systemClient = (BluetoothSystemClient)decoder0.readServiceInterface(12, false, BluetoothSystemClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.system, 8, false);
            encoder0.encode(this.systemClient, 12, false, BluetoothSystemClient.MANAGER);
        }
    }
}
