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

class UsbDeviceClient_Internal {
    public static final Interface.Manager<UsbDeviceClient, UsbDeviceClient.Proxy> MANAGER = new Interface.Manager<UsbDeviceClient, UsbDeviceClient.Proxy>() {
        public String getName() {
            return "device.mojom.UsbDeviceClient";
        }

        public int getVersion() {
            return 0;
        }

        public UsbDeviceClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new UsbDeviceClient_Internal.Proxy(core, messageReceiver);
        }

        public UsbDeviceClient_Internal.Stub buildStub(Core core, UsbDeviceClient impl) {
            return new UsbDeviceClient_Internal.Stub(core, impl);
        }

        public UsbDeviceClient[] buildArray(int size) {
            return new UsbDeviceClient[size];
        }
    };

    private static final int ON_DEVICE_OPENED_ORDINAL = 0;

    private static final int ON_DEVICE_CLOSED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements UsbDeviceClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onDeviceOpened() {
            UsbDeviceClient_Internal.UsbDeviceClientOnDeviceOpenedParams _message = new UsbDeviceClient_Internal.UsbDeviceClientOnDeviceOpenedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onDeviceClosed() {
            UsbDeviceClient_Internal.UsbDeviceClientOnDeviceClosedParams _message = new UsbDeviceClient_Internal.UsbDeviceClientOnDeviceClosedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<UsbDeviceClient> {
        Stub(Core core, UsbDeviceClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UsbDeviceClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        UsbDeviceClient_Internal.UsbDeviceClientOnDeviceOpenedParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceClient)getImpl()).onDeviceOpened();
                        return true;
                    case 1:
                        UsbDeviceClient_Internal.UsbDeviceClientOnDeviceClosedParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceClient)getImpl()).onDeviceClosed();
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
                                getCore(), UsbDeviceClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class UsbDeviceClientOnDeviceOpenedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UsbDeviceClientOnDeviceOpenedParams(int version) {
            super(8, version);
        }

        public UsbDeviceClientOnDeviceOpenedParams() {
            this(0);
        }

        public static UsbDeviceClientOnDeviceOpenedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceClientOnDeviceOpenedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceClientOnDeviceOpenedParams decode(Decoder decoder0) {
            UsbDeviceClientOnDeviceOpenedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceClientOnDeviceOpenedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class UsbDeviceClientOnDeviceClosedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UsbDeviceClientOnDeviceClosedParams(int version) {
            super(8, version);
        }

        public UsbDeviceClientOnDeviceClosedParams() {
            this(0);
        }

        public static UsbDeviceClientOnDeviceClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceClientOnDeviceClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceClientOnDeviceClosedParams decode(Decoder decoder0) {
            UsbDeviceClientOnDeviceClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceClientOnDeviceClosedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
