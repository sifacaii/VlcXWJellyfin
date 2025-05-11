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

class BluetoothSystemClient_Internal {
    public static final Interface.Manager<BluetoothSystemClient, BluetoothSystemClient.Proxy> MANAGER = new Interface.Manager<BluetoothSystemClient, BluetoothSystemClient.Proxy>() {
        public String getName() {
            return "device.mojom.BluetoothSystemClient";
        }

        public int getVersion() {
            return 0;
        }

        public BluetoothSystemClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BluetoothSystemClient_Internal.Proxy(core, messageReceiver);
        }

        public BluetoothSystemClient_Internal.Stub buildStub(Core core, BluetoothSystemClient impl) {
            return new BluetoothSystemClient_Internal.Stub(core, impl);
        }

        public BluetoothSystemClient[] buildArray(int size) {
            return new BluetoothSystemClient[size];
        }
    };

    private static final int ON_STATE_CHANGED_ORDINAL = 0;

    private static final int ON_SCAN_STATE_CHANGED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements BluetoothSystemClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onStateChanged(int newState) {
            BluetoothSystemClient_Internal.BluetoothSystemClientOnStateChangedParams _message = new BluetoothSystemClient_Internal.BluetoothSystemClientOnStateChangedParams();
            _message.newState = newState;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onScanStateChanged(int newState) {
            BluetoothSystemClient_Internal.BluetoothSystemClientOnScanStateChangedParams _message = new BluetoothSystemClient_Internal.BluetoothSystemClientOnScanStateChangedParams();
            _message.newState = newState;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<BluetoothSystemClient> {
        Stub(Core core, BluetoothSystemClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BluetoothSystemClient_Internal.BluetoothSystemClientOnStateChangedParams bluetoothSystemClientOnStateChangedParams;
                BluetoothSystemClient_Internal.BluetoothSystemClientOnScanStateChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BluetoothSystemClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        bluetoothSystemClientOnStateChangedParams = BluetoothSystemClient_Internal.BluetoothSystemClientOnStateChangedParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystemClient)getImpl()).onStateChanged(bluetoothSystemClientOnStateChangedParams.newState);
                        return true;
                    case 1:
                        data = BluetoothSystemClient_Internal.BluetoothSystemClientOnScanStateChangedParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystemClient)getImpl()).onScanStateChanged(data.newState);
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
                                getCore(), BluetoothSystemClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BluetoothSystemClientOnStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int newState;

        private BluetoothSystemClientOnStateChangedParams(int version) {
            super(16, version);
        }

        public BluetoothSystemClientOnStateChangedParams() {
            this(0);
        }

        public static BluetoothSystemClientOnStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemClientOnStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemClientOnStateChangedParams decode(Decoder decoder0) {
            BluetoothSystemClientOnStateChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemClientOnStateChangedParams(elementsOrVersion);
                result.newState = decoder0.readInt(8);
                BluetoothSystem.State.validate(result.newState);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.newState, 8);
        }
    }

    static final class BluetoothSystemClientOnScanStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int newState;

        private BluetoothSystemClientOnScanStateChangedParams(int version) {
            super(16, version);
        }

        public BluetoothSystemClientOnScanStateChangedParams() {
            this(0);
        }

        public static BluetoothSystemClientOnScanStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemClientOnScanStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemClientOnScanStateChangedParams decode(Decoder decoder0) {
            BluetoothSystemClientOnScanStateChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemClientOnScanStateChangedParams(elementsOrVersion);
                result.newState = decoder0.readInt(8);
                BluetoothSystem.ScanState.validate(result.newState);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.newState, 8);
        }
    }
}
