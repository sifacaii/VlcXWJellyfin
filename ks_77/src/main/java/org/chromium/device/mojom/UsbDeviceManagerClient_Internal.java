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

class UsbDeviceManagerClient_Internal {
    public static final Interface.Manager<UsbDeviceManagerClient, UsbDeviceManagerClient.Proxy> MANAGER = new Interface.Manager<UsbDeviceManagerClient, UsbDeviceManagerClient.Proxy>() {
        public String getName() {
            return "device.mojom.UsbDeviceManagerClient";
        }

        public int getVersion() {
            return 0;
        }

        public UsbDeviceManagerClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new UsbDeviceManagerClient_Internal.Proxy(core, messageReceiver);
        }

        public UsbDeviceManagerClient_Internal.Stub buildStub(Core core, UsbDeviceManagerClient impl) {
            return new UsbDeviceManagerClient_Internal.Stub(core, impl);
        }

        public UsbDeviceManagerClient[] buildArray(int size) {
            return new UsbDeviceManagerClient[size];
        }
    };

    private static final int ON_DEVICE_ADDED_ORDINAL = 0;

    private static final int ON_DEVICE_REMOVED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements UsbDeviceManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onDeviceAdded(UsbDeviceInfo deviceInfo) {
            UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceAddedParams _message = new UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceAddedParams();
            _message.deviceInfo = deviceInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onDeviceRemoved(UsbDeviceInfo deviceInfo) {
            UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceRemovedParams _message = new UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceRemovedParams();
            _message.deviceInfo = deviceInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<UsbDeviceManagerClient> {
        Stub(Core core, UsbDeviceManagerClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceAddedParams usbDeviceManagerClientOnDeviceAddedParams;
                UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceRemovedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UsbDeviceManagerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        usbDeviceManagerClientOnDeviceAddedParams = UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceAddedParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManagerClient)getImpl()).onDeviceAdded(usbDeviceManagerClientOnDeviceAddedParams.deviceInfo);
                        return true;
                    case 1:
                        data = UsbDeviceManagerClient_Internal.UsbDeviceManagerClientOnDeviceRemovedParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManagerClient)getImpl()).onDeviceRemoved(data.deviceInfo);
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
                                getCore(), UsbDeviceManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class UsbDeviceManagerClientOnDeviceAddedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo deviceInfo;

        private UsbDeviceManagerClientOnDeviceAddedParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerClientOnDeviceAddedParams() {
            this(0);
        }

        public static UsbDeviceManagerClientOnDeviceAddedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerClientOnDeviceAddedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerClientOnDeviceAddedParams decode(Decoder decoder0) {
            UsbDeviceManagerClientOnDeviceAddedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerClientOnDeviceAddedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.deviceInfo = UsbDeviceInfo.decode(decoder1);
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

    static final class UsbDeviceManagerClientOnDeviceRemovedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo deviceInfo;

        private UsbDeviceManagerClientOnDeviceRemovedParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerClientOnDeviceRemovedParams() {
            this(0);
        }

        public static UsbDeviceManagerClientOnDeviceRemovedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerClientOnDeviceRemovedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerClientOnDeviceRemovedParams decode(Decoder decoder0) {
            UsbDeviceManagerClientOnDeviceRemovedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerClientOnDeviceRemovedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.deviceInfo = UsbDeviceInfo.decode(decoder1);
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
}
