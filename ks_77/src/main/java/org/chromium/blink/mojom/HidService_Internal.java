package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.HidConnection;
import org.chromium.device.mojom.HidConnectionClient;
import org.chromium.device.mojom.HidDeviceInfo;
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

class HidService_Internal {
    public static final Interface.Manager<HidService, HidService.Proxy> MANAGER = new Interface.Manager<HidService, HidService.Proxy>() {
        public String getName() {
            return "blink.mojom.HidService";
        }

        public int getVersion() {
            return 0;
        }

        public HidService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new HidService_Internal.Proxy(core, messageReceiver);
        }

        public HidService_Internal.Stub buildStub(Core core, HidService impl) {
            return new HidService_Internal.Stub(core, impl);
        }

        public HidService[] buildArray(int size) {
            return new HidService[size];
        }
    };

    private static final int GET_DEVICES_ORDINAL = 0;

    private static final int REQUEST_DEVICE_ORDINAL = 1;

    private static final int CONNECT_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements HidService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getDevices(HidService.GetDevicesResponse callback) {
            HidService_Internal.HidServiceGetDevicesParams _message = new HidService_Internal.HidServiceGetDevicesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new HidService_Internal.HidServiceGetDevicesResponseParamsForwardToCallback(callback));
        }

        public void requestDevice(HidDeviceFilter[] filters, HidService.RequestDeviceResponse callback) {
            HidService_Internal.HidServiceRequestDeviceParams _message = new HidService_Internal.HidServiceRequestDeviceParams();
            _message.filters = filters;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new HidService_Internal.HidServiceRequestDeviceResponseParamsForwardToCallback(callback));
        }

        public void connect(String deviceGuid, HidConnectionClient client, HidService.ConnectResponse callback) {
            HidService_Internal.HidServiceConnectParams _message = new HidService_Internal.HidServiceConnectParams();
            _message.deviceGuid = deviceGuid;
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new HidService_Internal.HidServiceConnectResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<HidService> {
        Stub(Core core, HidService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(HidService_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                HidService_Internal.HidServiceRequestDeviceParams hidServiceRequestDeviceParams;
                HidService_Internal.HidServiceConnectParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), HidService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        HidService_Internal.HidServiceGetDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((HidService)getImpl()).getDevices(new HidService_Internal.HidServiceGetDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        hidServiceRequestDeviceParams = HidService_Internal.HidServiceRequestDeviceParams.deserialize(messageWithHeader.getPayload());
                        ((HidService)getImpl()).requestDevice(hidServiceRequestDeviceParams.filters, new HidService_Internal.HidServiceRequestDeviceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = HidService_Internal.HidServiceConnectParams.deserialize(messageWithHeader.getPayload());
                        ((HidService)getImpl()).connect(data.deviceGuid, data.client, new HidService_Internal.HidServiceConnectResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class HidServiceGetDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private HidServiceGetDevicesParams(int version) {
            super(8, version);
        }

        public HidServiceGetDevicesParams() {
            this(0);
        }

        public static HidServiceGetDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidServiceGetDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidServiceGetDevicesParams decode(Decoder decoder0) {
            HidServiceGetDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidServiceGetDevicesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class HidServiceGetDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceInfo[] devices;

        private HidServiceGetDevicesResponseParams(int version) {
            super(16, version);
        }

        public HidServiceGetDevicesResponseParams() {
            this(0);
        }

        public static HidServiceGetDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidServiceGetDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidServiceGetDevicesResponseParams decode(Decoder decoder0) {
            HidServiceGetDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidServiceGetDevicesResponseParams(elementsOrVersion);
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
                    encoder1.encode((Struct)this.devices[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class HidServiceGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidService.GetDevicesResponse mCallback;

        HidServiceGetDevicesResponseParamsForwardToCallback(HidService.GetDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                HidService_Internal.HidServiceGetDevicesResponseParams response = HidService_Internal.HidServiceGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidServiceGetDevicesResponseParamsProxyToResponder implements HidService.GetDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidServiceGetDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(HidDeviceInfo[] devices) {
            HidService_Internal.HidServiceGetDevicesResponseParams _response = new HidService_Internal.HidServiceGetDevicesResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidServiceRequestDeviceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceFilter[] filters;

        private HidServiceRequestDeviceParams(int version) {
            super(16, version);
        }

        public HidServiceRequestDeviceParams() {
            this(0);
        }

        public static HidServiceRequestDeviceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidServiceRequestDeviceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidServiceRequestDeviceParams decode(Decoder decoder0) {
            HidServiceRequestDeviceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidServiceRequestDeviceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.filters = new HidDeviceFilter[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.filters[i1] = HidDeviceFilter.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.filters == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.filters.length, 8, -1);
                for (int i0 = 0; i0 < this.filters.length; i0++)
                    encoder1.encode(this.filters[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class HidServiceRequestDeviceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidDeviceInfo device;

        private HidServiceRequestDeviceResponseParams(int version) {
            super(16, version);
        }

        public HidServiceRequestDeviceResponseParams() {
            this(0);
        }

        public static HidServiceRequestDeviceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidServiceRequestDeviceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidServiceRequestDeviceResponseParams decode(Decoder decoder0) {
            HidServiceRequestDeviceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidServiceRequestDeviceResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.device = HidDeviceInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.device, 8, true);
        }
    }

    static class HidServiceRequestDeviceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidService.RequestDeviceResponse mCallback;

        HidServiceRequestDeviceResponseParamsForwardToCallback(HidService.RequestDeviceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                HidService_Internal.HidServiceRequestDeviceResponseParams response = HidService_Internal.HidServiceRequestDeviceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.device);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidServiceRequestDeviceResponseParamsProxyToResponder implements HidService.RequestDeviceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidServiceRequestDeviceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(HidDeviceInfo device) {
            HidService_Internal.HidServiceRequestDeviceResponseParams _response = new HidService_Internal.HidServiceRequestDeviceResponseParams();
            _response.device = device;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class HidServiceConnectParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String deviceGuid;

        public HidConnectionClient client;

        private HidServiceConnectParams(int version) {
            super(24, version);
        }

        public HidServiceConnectParams() {
            this(0);
        }

        public static HidServiceConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidServiceConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidServiceConnectParams decode(Decoder decoder0) {
            HidServiceConnectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidServiceConnectParams(elementsOrVersion);
                result.deviceGuid = decoder0.readString(8, false);
                result.client = (HidConnectionClient)decoder0.readServiceInterface(16, false, HidConnectionClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceGuid, 8, false);
            encoder0.encode(this.client, 16, false, HidConnectionClient.MANAGER);
        }
    }

    static final class HidServiceConnectResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public HidConnection connection;

        private HidServiceConnectResponseParams(int version) {
            super(16, version);
        }

        public HidServiceConnectResponseParams() {
            this(0);
        }

        public static HidServiceConnectResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidServiceConnectResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidServiceConnectResponseParams decode(Decoder decoder0) {
            HidServiceConnectResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidServiceConnectResponseParams(elementsOrVersion);
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

    static class HidServiceConnectResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final HidService.ConnectResponse mCallback;

        HidServiceConnectResponseParamsForwardToCallback(HidService.ConnectResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                HidService_Internal.HidServiceConnectResponseParams response = HidService_Internal.HidServiceConnectResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.connection);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HidServiceConnectResponseParamsProxyToResponder implements HidService.ConnectResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HidServiceConnectResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(HidConnection connection) {
            HidService_Internal.HidServiceConnectResponseParams _response = new HidService_Internal.HidServiceConnectResponseParams();
            _response.connection = connection;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
