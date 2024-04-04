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
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class UsbDeviceManager_Internal {
    public static final Interface.Manager<UsbDeviceManager, UsbDeviceManager.Proxy> MANAGER = new Interface.Manager<UsbDeviceManager, UsbDeviceManager.Proxy>() {
        public String getName() {
            return "device.mojom.UsbDeviceManager";
        }

        public int getVersion() {
            return 0;
        }

        public UsbDeviceManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new UsbDeviceManager_Internal.Proxy(core, messageReceiver);
        }

        public UsbDeviceManager_Internal.Stub buildStub(Core core, UsbDeviceManager impl) {
            return new UsbDeviceManager_Internal.Stub(core, impl);
        }

        public UsbDeviceManager[] buildArray(int size) {
            return new UsbDeviceManager[size];
        }
    };

    private static final int ENUMERATE_DEVICES_AND_SET_CLIENT_ORDINAL = 0;

    private static final int GET_DEVICES_ORDINAL = 1;

    private static final int GET_DEVICE_ORDINAL = 2;

    private static final int REFRESH_DEVICE_INFO_ORDINAL = 3;

    private static final int SET_CLIENT_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements UsbDeviceManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void enumerateDevicesAndSetClient(AssociatedInterfaceNotSupported client, UsbDeviceManager.EnumerateDevicesAndSetClientResponse callback) {
            UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientParams _message = new UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsForwardToCallback(callback));
        }

        public void getDevices(UsbEnumerationOptions options, UsbDeviceManager.GetDevicesResponse callback) {
            UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesParams _message = new UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesResponseParamsForwardToCallback(callback));
        }

        public void getDevice(String guid, InterfaceRequest<UsbDevice> deviceRequest, UsbDeviceClient deviceClient) {
            UsbDeviceManager_Internal.UsbDeviceManagerGetDeviceParams _message = new UsbDeviceManager_Internal.UsbDeviceManagerGetDeviceParams();
            _message.guid = guid;
            _message.deviceRequest = deviceRequest;
            _message.deviceClient = deviceClient;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void refreshDeviceInfo(String guid, UsbDeviceManager.RefreshDeviceInfoResponse callback) {
            UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoParams _message = new UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoParams();
            _message.guid = guid;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoResponseParamsForwardToCallback(callback));
        }

        public void setClient(AssociatedInterfaceNotSupported client) {
            UsbDeviceManager_Internal.UsbDeviceManagerSetClientParams _message = new UsbDeviceManager_Internal.UsbDeviceManagerSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<UsbDeviceManager> {
        Stub(Core core, UsbDeviceManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                UsbDeviceManager_Internal.UsbDeviceManagerGetDeviceParams usbDeviceManagerGetDeviceParams;
                UsbDeviceManager_Internal.UsbDeviceManagerSetClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UsbDeviceManager_Internal.MANAGER, messageWithHeader);
                    case 2:
                        usbDeviceManagerGetDeviceParams = UsbDeviceManager_Internal.UsbDeviceManagerGetDeviceParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManager)getImpl()).getDevice(usbDeviceManagerGetDeviceParams.guid, usbDeviceManagerGetDeviceParams.deviceRequest, usbDeviceManagerGetDeviceParams.deviceClient);
                        return true;
                    case 4:
                        data = UsbDeviceManager_Internal.UsbDeviceManagerSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManager)getImpl()).setClient(data.client);
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
                UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientParams usbDeviceManagerEnumerateDevicesAndSetClientParams;
                UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesParams usbDeviceManagerGetDevicesParams;
                UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), UsbDeviceManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        usbDeviceManagerEnumerateDevicesAndSetClientParams = UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManager)getImpl()).enumerateDevicesAndSetClient(usbDeviceManagerEnumerateDevicesAndSetClientParams.client, new UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        usbDeviceManagerGetDevicesParams = UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManager)getImpl()).getDevices(usbDeviceManagerGetDevicesParams.options, new UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDeviceManager)getImpl()).refreshDeviceInfo(data.guid, new UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class UsbDeviceManagerEnumerateDevicesAndSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private UsbDeviceManagerEnumerateDevicesAndSetClientParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerEnumerateDevicesAndSetClientParams() {
            this(0);
        }

        public static UsbDeviceManagerEnumerateDevicesAndSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerEnumerateDevicesAndSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerEnumerateDevicesAndSetClientParams decode(Decoder decoder0) {
            UsbDeviceManagerEnumerateDevicesAndSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerEnumerateDevicesAndSetClientParams(elementsOrVersion);
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

    static final class UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo[] results;

        private UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams() {
            this(0);
        }

        public static UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams decode(Decoder decoder0) {
            UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.results = new UsbDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.results[i1] = UsbDeviceInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.results == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.results.length, 8, -1);
                for (int i0 = 0; i0 < this.results.length; i0++)
                    encoder1.encode(this.results[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDeviceManager.EnumerateDevicesAndSetClientResponse mCallback;

        UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsForwardToCallback(UsbDeviceManager.EnumerateDevicesAndSetClientResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams response = UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.results);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsProxyToResponder implements UsbDeviceManager.EnumerateDevicesAndSetClientResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceManagerEnumerateDevicesAndSetClientResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UsbDeviceInfo[] results) {
            UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams _response = new UsbDeviceManager_Internal.UsbDeviceManagerEnumerateDevicesAndSetClientResponseParams();
            _response.results = results;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceManagerGetDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbEnumerationOptions options;

        private UsbDeviceManagerGetDevicesParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerGetDevicesParams() {
            this(0);
        }

        public static UsbDeviceManagerGetDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerGetDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerGetDevicesParams decode(Decoder decoder0) {
            UsbDeviceManagerGetDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerGetDevicesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.options = UsbEnumerationOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, true);
        }
    }

    static final class UsbDeviceManagerGetDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo[] results;

        private UsbDeviceManagerGetDevicesResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerGetDevicesResponseParams() {
            this(0);
        }

        public static UsbDeviceManagerGetDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerGetDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerGetDevicesResponseParams decode(Decoder decoder0) {
            UsbDeviceManagerGetDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerGetDevicesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.results = new UsbDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.results[i1] = UsbDeviceInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.results == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.results.length, 8, -1);
                for (int i0 = 0; i0 < this.results.length; i0++)
                    encoder1.encode(this.results[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class UsbDeviceManagerGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDeviceManager.GetDevicesResponse mCallback;

        UsbDeviceManagerGetDevicesResponseParamsForwardToCallback(UsbDeviceManager.GetDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesResponseParams response = UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.results);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceManagerGetDevicesResponseParamsProxyToResponder implements UsbDeviceManager.GetDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceManagerGetDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UsbDeviceInfo[] results) {
            UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesResponseParams _response = new UsbDeviceManager_Internal.UsbDeviceManagerGetDevicesResponseParams();
            _response.results = results;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceManagerGetDeviceParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String guid;

        public InterfaceRequest<UsbDevice> deviceRequest;

        public UsbDeviceClient deviceClient;

        private UsbDeviceManagerGetDeviceParams(int version) {
            super(32, version);
        }

        public UsbDeviceManagerGetDeviceParams() {
            this(0);
        }

        public static UsbDeviceManagerGetDeviceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerGetDeviceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerGetDeviceParams decode(Decoder decoder0) {
            UsbDeviceManagerGetDeviceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerGetDeviceParams(elementsOrVersion);
                result.guid = decoder0.readString(8, false);
                result.deviceRequest = decoder0.readInterfaceRequest(16, false);
                result.deviceClient = (UsbDeviceClient)decoder0.readServiceInterface(20, true, UsbDeviceClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.guid, 8, false);
            encoder0.encode(this.deviceRequest, 16, false);
            encoder0.encode(this.deviceClient, 20, true, UsbDeviceClient.MANAGER);
        }
    }

    static final class UsbDeviceManagerRefreshDeviceInfoParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String guid;

        private UsbDeviceManagerRefreshDeviceInfoParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerRefreshDeviceInfoParams() {
            this(0);
        }

        public static UsbDeviceManagerRefreshDeviceInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerRefreshDeviceInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerRefreshDeviceInfoParams decode(Decoder decoder0) {
            UsbDeviceManagerRefreshDeviceInfoParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerRefreshDeviceInfoParams(elementsOrVersion);
                result.guid = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.guid, 8, false);
        }
    }

    static final class UsbDeviceManagerRefreshDeviceInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo deviceInfo;

        private UsbDeviceManagerRefreshDeviceInfoResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerRefreshDeviceInfoResponseParams() {
            this(0);
        }

        public static UsbDeviceManagerRefreshDeviceInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerRefreshDeviceInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerRefreshDeviceInfoResponseParams decode(Decoder decoder0) {
            UsbDeviceManagerRefreshDeviceInfoResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerRefreshDeviceInfoResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.deviceInfo = UsbDeviceInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.deviceInfo, 8, true);
        }
    }

    static class UsbDeviceManagerRefreshDeviceInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDeviceManager.RefreshDeviceInfoResponse mCallback;

        UsbDeviceManagerRefreshDeviceInfoResponseParamsForwardToCallback(UsbDeviceManager.RefreshDeviceInfoResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoResponseParams response = UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.deviceInfo);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceManagerRefreshDeviceInfoResponseParamsProxyToResponder implements UsbDeviceManager.RefreshDeviceInfoResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceManagerRefreshDeviceInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UsbDeviceInfo deviceInfo) {
            UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoResponseParams _response = new UsbDeviceManager_Internal.UsbDeviceManagerRefreshDeviceInfoResponseParams();
            _response.deviceInfo = deviceInfo;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceManagerSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private UsbDeviceManagerSetClientParams(int version) {
            super(16, version);
        }

        public UsbDeviceManagerSetClientParams() {
            this(0);
        }

        public static UsbDeviceManagerSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceManagerSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceManagerSetClientParams decode(Decoder decoder0) {
            UsbDeviceManagerSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceManagerSetClientParams(elementsOrVersion);
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
}
