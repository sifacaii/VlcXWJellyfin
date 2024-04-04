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

class HidManagerClient_Internal {
    public static final Interface.Manager<HidManagerClient, HidManagerClient.Proxy> MANAGER = new Interface.Manager<HidManagerClient, HidManagerClient.Proxy>() {
        public String getName() {
            return "device.mojom.HidManagerClient";
        }

        public int getVersion() {
            return 0;
        }

        public HidManagerClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new HidManagerClient_Internal.Proxy(core, messageReceiver);
        }

        public HidManagerClient_Internal.Stub buildStub(Core core, HidManagerClient impl) {
            return new HidManagerClient_Internal.Stub(core, impl);
        }

        public HidManagerClient[] buildArray(int size) {
            return new HidManagerClient[size];
        }
    };

    private static final int DEVICE_ADDED_ORDINAL = 0;

    private static final int DEVICE_REMOVED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements HidManagerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void deviceAdded(HidDeviceInfo deviceInfo) {
            HidManagerClient_Internal.HidManagerClientDeviceAddedParams _message = new HidManagerClient_Internal.HidManagerClientDeviceAddedParams();
            _message.deviceInfo = deviceInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void deviceRemoved(HidDeviceInfo deviceInfo) {
            HidManagerClient_Internal.HidManagerClientDeviceRemovedParams _message = new HidManagerClient_Internal.HidManagerClientDeviceRemovedParams();
            _message.deviceInfo = deviceInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<HidManagerClient> {
        Stub(Core core, HidManagerClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                HidManagerClient_Internal.HidManagerClientDeviceAddedParams hidManagerClientDeviceAddedParams;
                HidManagerClient_Internal.HidManagerClientDeviceRemovedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(HidManagerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        hidManagerClientDeviceAddedParams = HidManagerClient_Internal.HidManagerClientDeviceAddedParams.deserialize(messageWithHeader.getPayload());
                        ((HidManagerClient)getImpl()).deviceAdded(hidManagerClientDeviceAddedParams.deviceInfo);
                        return true;
                    case 1:
                        data = HidManagerClient_Internal.HidManagerClientDeviceRemovedParams.deserialize(messageWithHeader.getPayload());
                        ((HidManagerClient)getImpl()).deviceRemoved(data.deviceInfo);
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
                                getCore(), HidManagerClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class HidManagerClientDeviceAddedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceInfo deviceInfo;

        private HidManagerClientDeviceAddedParams(int version) {
            super(16, version);
        }

        public HidManagerClientDeviceAddedParams() {
            this(0);
        }

        public static HidManagerClientDeviceAddedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerClientDeviceAddedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerClientDeviceAddedParams decode(Decoder decoder0) {
            HidManagerClientDeviceAddedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerClientDeviceAddedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.deviceInfo = HidDeviceInfo.decode(decoder1);
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

    static final class HidManagerClientDeviceRemovedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceInfo deviceInfo;

        private HidManagerClientDeviceRemovedParams(int version) {
            super(16, version);
        }

        public HidManagerClientDeviceRemovedParams() {
            this(0);
        }

        public static HidManagerClientDeviceRemovedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerClientDeviceRemovedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerClientDeviceRemovedParams decode(Decoder decoder0) {
            HidManagerClientDeviceRemovedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerClientDeviceRemovedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.deviceInfo = HidDeviceInfo.decode(decoder1);
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
