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

class HidManager_Internal {
    public static final Interface.Manager<HidManager, HidManager.Proxy> MANAGER = new Interface.Manager<HidManager, HidManager.Proxy>() {
        public String getName() {
            return "device.mojom.HidManager";
        }

        public int getVersion() {
            return 0;
        }

        public HidManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new HidManager_Internal.Proxy(core, messageReceiver);
        }

        public HidManager_Internal.Stub buildStub(Core core, HidManager impl) {
            return new HidManager_Internal.Stub(core, impl);
        }

        public HidManager[] buildArray(int size) {
            return new HidManager[size];
        }
    };

    private static final int GET_DEVICES_AND_SET_CLIENT_ORDINAL = 0;

    private static final int GET_DEVICES_ORDINAL = 1;

    private static final int CONNECT_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements HidManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getDevicesAndSetClient(AssociatedInterfaceNotSupported client, HidManager.GetDevicesAndSetClientResponse callback) {
            HidManager_Internal.HidManagerGetDevicesAndSetClientParams _message = new HidManager_Internal.HidManagerGetDevicesAndSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new HidManager_Internal.HidManagerGetDevicesAndSetClientResponseParamsForwardToCallback(callback));
        }

        public void getDevices(HidManager.GetDevicesResponse callback) {
            HidManager_Internal.HidManagerGetDevicesParams _message = new HidManager_Internal.HidManagerGetDevicesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new HidManager_Internal.HidManagerGetDevicesResponseParamsForwardToCallback(callback));
        }

        public void connect(String deviceGuid, HidConnectionClient connectionClient, HidManager.ConnectResponse callback) {
            HidManager_Internal.HidManagerConnectParams _message = new HidManager_Internal.HidManagerConnectParams();
            _message.deviceGuid = deviceGuid;
            _message.connectionClient = connectionClient;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new HidManager_Internal.HidManagerConnectResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<HidManager> {
        Stub(Core core, HidManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(HidManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                HidManager_Internal.HidManagerGetDevicesAndSetClientParams hidManagerGetDevicesAndSetClientParams;
                HidManager_Internal.HidManagerConnectParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), HidManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        hidManagerGetDevicesAndSetClientParams = HidManager_Internal.HidManagerGetDevicesAndSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((HidManager)getImpl()).getDevicesAndSetClient(hidManagerGetDevicesAndSetClientParams.client, new HidManager_Internal.HidManagerGetDevicesAndSetClientResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        HidManager_Internal.HidManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((HidManager)getImpl()).getDevices(new HidManager_Internal.HidManagerGetDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = HidManager_Internal.HidManagerConnectParams.deserialize(messageWithHeader.getPayload());
                        ((HidManager)getImpl()).connect(data.deviceGuid, data.connectionClient, new HidManager_Internal.HidManagerConnectResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class HidManagerGetDevicesAndSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private HidManagerGetDevicesAndSetClientParams(int version) {
            super(16, version);
        }

        public HidManagerGetDevicesAndSetClientParams() {
            this(0);
        }

        public static HidManagerGetDevicesAndSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerGetDevicesAndSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerGetDevicesAndSetClientParams decode(Decoder decoder0) {
            HidManagerGetDevicesAndSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerGetDevicesAndSetClientParams(elementsOrVersion);
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

    static final class HidManagerGetDevicesAndSetClientResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceInfo[] devices;

        private HidManagerGetDevicesAndSetClientResponseParams(int version) {
            super(16, version);
        }

        public HidManagerGetDevicesAndSetClientResponseParams() {
            this(0);
        }

        public static HidManagerGetDevicesAndSetClientResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerGetDevicesAndSetClientResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerGetDevicesAndSetClientResponseParams decode(Decoder decoder0) {
            HidManagerGetDevicesAndSetClientResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerGetDevicesAndSetClientResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.devices = new HidDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.devices[i1] = HidDeviceInfo.decode(decoder2);
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

    static class HidManagerGetDevicesAndSetClientResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidManager.GetDevicesAndSetClientResponse mCallback;

        HidManagerGetDevicesAndSetClientResponseParamsForwardToCallback(HidManager.GetDevicesAndSetClientResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                HidManager_Internal.HidManagerGetDevicesAndSetClientResponseParams response = HidManager_Internal.HidManagerGetDevicesAndSetClientResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidManagerGetDevicesAndSetClientResponseParamsProxyToResponder implements HidManager.GetDevicesAndSetClientResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidManagerGetDevicesAndSetClientResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(HidDeviceInfo[] devices) {
            HidManager_Internal.HidManagerGetDevicesAndSetClientResponseParams _response = new HidManager_Internal.HidManagerGetDevicesAndSetClientResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidManagerGetDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private HidManagerGetDevicesParams(int version) {
            super(8, version);
        }

        public HidManagerGetDevicesParams() {
            this(0);
        }

        public static HidManagerGetDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerGetDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerGetDevicesParams decode(Decoder decoder0) {
            HidManagerGetDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerGetDevicesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class HidManagerGetDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceInfo[] devices;

        private HidManagerGetDevicesResponseParams(int version) {
            super(16, version);
        }

        public HidManagerGetDevicesResponseParams() {
            this(0);
        }

        public static HidManagerGetDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerGetDevicesResponseParams decode(Decoder decoder0) {
            HidManagerGetDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerGetDevicesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.devices = new HidDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.devices[i1] = HidDeviceInfo.decode(decoder2);
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

    static class HidManagerGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidManager.GetDevicesResponse mCallback;

        HidManagerGetDevicesResponseParamsForwardToCallback(HidManager.GetDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                HidManager_Internal.HidManagerGetDevicesResponseParams response = HidManager_Internal.HidManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidManagerGetDevicesResponseParamsProxyToResponder implements HidManager.GetDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidManagerGetDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(HidDeviceInfo[] devices) {
            HidManager_Internal.HidManagerGetDevicesResponseParams _response = new HidManager_Internal.HidManagerGetDevicesResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidManagerConnectParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String deviceGuid;

        public HidConnectionClient connectionClient;

        private HidManagerConnectParams(int version) {
            super(24, version);
        }

        public HidManagerConnectParams() {
            this(0);
        }

        public static HidManagerConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerConnectParams decode(Decoder decoder0) {
            HidManagerConnectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerConnectParams(elementsOrVersion);
                result.deviceGuid = decoder0.readString(8, false);
                result.connectionClient = (HidConnectionClient)decoder0.readServiceInterface(16, true, HidConnectionClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceGuid, 8, false);
            encoder0.encode(this.connectionClient, 16, true, HidConnectionClient.MANAGER);
        }
    }

    static final class HidManagerConnectResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidConnection connection;

        private HidManagerConnectResponseParams(int version) {
            super(16, version);
        }

        public HidManagerConnectResponseParams() {
            this(0);
        }

        public static HidManagerConnectResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidManagerConnectResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidManagerConnectResponseParams decode(Decoder decoder0) {
            HidManagerConnectResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidManagerConnectResponseParams(elementsOrVersion);
                result.connection = (HidConnection)decoder0.readServiceInterface(8, true, HidConnection.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.connection, 8, true, HidConnection.MANAGER);
        }
    }

    static class HidManagerConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidManager.ConnectResponse mCallback;

        HidManagerConnectResponseParamsForwardToCallback(HidManager.ConnectResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                HidManager_Internal.HidManagerConnectResponseParams response = HidManager_Internal.HidManagerConnectResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.connection);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidManagerConnectResponseParamsProxyToResponder implements HidManager.ConnectResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidManagerConnectResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(HidConnection connection) {
            HidManager_Internal.HidManagerConnectResponseParams _response = new HidManager_Internal.HidManagerConnectResponseParams();
            _response.connection = connection;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
