package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.UsbDevice;
import org.chromium.device.mojom.UsbDeviceFilter;
import org.chromium.device.mojom.UsbDeviceInfo;
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

class WebUsbService_Internal {
    public static final Interface.Manager<WebUsbService, WebUsbService.Proxy> MANAGER = new Interface.Manager<WebUsbService, WebUsbService.Proxy>() {
        public String getName() {
            return "blink.mojom.WebUsbService";
        }

        public int getVersion() {
            return 0;
        }

        public WebUsbService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WebUsbService_Internal.Proxy(core, messageReceiver);
        }

        public WebUsbService_Internal.Stub buildStub(Core core, WebUsbService impl) {
            return new WebUsbService_Internal.Stub(core, impl);
        }

        public WebUsbService[] buildArray(int size) {
            return new WebUsbService[size];
        }
    };

    private static final int GET_DEVICES_ORDINAL = 0;

    private static final int GET_DEVICE_ORDINAL = 1;

    private static final int GET_PERMISSION_ORDINAL = 2;

    private static final int SET_CLIENT_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements WebUsbService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getDevices(WebUsbService.GetDevicesResponse callback) {
            WebUsbService_Internal.WebUsbServiceGetDevicesParams _message = new WebUsbService_Internal.WebUsbServiceGetDevicesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new WebUsbService_Internal.WebUsbServiceGetDevicesResponseParamsForwardToCallback(callback));
        }

        public void getDevice(String guid, InterfaceRequest<UsbDevice> deviceRequestd) {
            WebUsbService_Internal.WebUsbServiceGetDeviceParams _message = new WebUsbService_Internal.WebUsbServiceGetDeviceParams();
            _message.guid = guid;
            _message.deviceRequestd = deviceRequestd;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void getPermission(UsbDeviceFilter[] deviceFilters, WebUsbService.GetPermissionResponse callback) {
            WebUsbService_Internal.WebUsbServiceGetPermissionParams _message = new WebUsbService_Internal.WebUsbServiceGetPermissionParams();
            _message.deviceFilters = deviceFilters;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new WebUsbService_Internal.WebUsbServiceGetPermissionResponseParamsForwardToCallback(callback));
        }

        public void setClient(AssociatedInterfaceNotSupported client) {
            WebUsbService_Internal.WebUsbServiceSetClientParams _message = new WebUsbService_Internal.WebUsbServiceSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<WebUsbService> {
        Stub(Core core, WebUsbService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WebUsbService_Internal.WebUsbServiceGetDeviceParams webUsbServiceGetDeviceParams;
                WebUsbService_Internal.WebUsbServiceSetClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebUsbService_Internal.MANAGER, messageWithHeader);
                    case 1:
                        webUsbServiceGetDeviceParams = WebUsbService_Internal.WebUsbServiceGetDeviceParams.deserialize(messageWithHeader.getPayload());
                        ((WebUsbService)getImpl()).getDevice(webUsbServiceGetDeviceParams.guid, webUsbServiceGetDeviceParams.deviceRequestd);
                        return true;
                    case 3:
                        data = WebUsbService_Internal.WebUsbServiceSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((WebUsbService)getImpl()).setClient(data.client);
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
                WebUsbService_Internal.WebUsbServiceGetPermissionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), WebUsbService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        WebUsbService_Internal.WebUsbServiceGetDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((WebUsbService)getImpl()).getDevices(new WebUsbService_Internal.WebUsbServiceGetDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = WebUsbService_Internal.WebUsbServiceGetPermissionParams.deserialize(messageWithHeader.getPayload());
                        ((WebUsbService)getImpl()).getPermission(data.deviceFilters, new WebUsbService_Internal.WebUsbServiceGetPermissionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WebUsbServiceGetDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WebUsbServiceGetDevicesParams(int version) {
            super(8, version);
        }

        public WebUsbServiceGetDevicesParams() {
            this(0);
        }

        public static WebUsbServiceGetDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebUsbServiceGetDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebUsbServiceGetDevicesParams decode(Decoder decoder0) {
            WebUsbServiceGetDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebUsbServiceGetDevicesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WebUsbServiceGetDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo[] results;

        private WebUsbServiceGetDevicesResponseParams(int version) {
            super(16, version);
        }

        public WebUsbServiceGetDevicesResponseParams() {
            this(0);
        }

        public static WebUsbServiceGetDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebUsbServiceGetDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebUsbServiceGetDevicesResponseParams decode(Decoder decoder0) {
            WebUsbServiceGetDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebUsbServiceGetDevicesResponseParams(elementsOrVersion);
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
                    encoder1.encode((Struct)this.results[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class WebUsbServiceGetDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebUsbService.GetDevicesResponse mCallback;

        WebUsbServiceGetDevicesResponseParamsForwardToCallback(WebUsbService.GetDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                WebUsbService_Internal.WebUsbServiceGetDevicesResponseParams response = WebUsbService_Internal.WebUsbServiceGetDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.results);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebUsbServiceGetDevicesResponseParamsProxyToResponder implements WebUsbService.GetDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebUsbServiceGetDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UsbDeviceInfo[] results) {
            WebUsbService_Internal.WebUsbServiceGetDevicesResponseParams _response = new WebUsbService_Internal.WebUsbServiceGetDevicesResponseParams();
            _response.results = results;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebUsbServiceGetDeviceParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String guid;

        public InterfaceRequest<UsbDevice> deviceRequestd;

        private WebUsbServiceGetDeviceParams(int version) {
            super(24, version);
        }

        public WebUsbServiceGetDeviceParams() {
            this(0);
        }

        public static WebUsbServiceGetDeviceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebUsbServiceGetDeviceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebUsbServiceGetDeviceParams decode(Decoder decoder0) {
            WebUsbServiceGetDeviceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebUsbServiceGetDeviceParams(elementsOrVersion);
                result.guid = decoder0.readString(8, false);
                result.deviceRequestd = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.guid, 8, false);
            encoder0.encode(this.deviceRequestd, 16, false);
        }
    }

    static final class WebUsbServiceGetPermissionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceFilter[] deviceFilters;

        private WebUsbServiceGetPermissionParams(int version) {
            super(16, version);
        }

        public WebUsbServiceGetPermissionParams() {
            this(0);
        }

        public static WebUsbServiceGetPermissionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebUsbServiceGetPermissionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebUsbServiceGetPermissionParams decode(Decoder decoder0) {
            WebUsbServiceGetPermissionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebUsbServiceGetPermissionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.deviceFilters = new UsbDeviceFilter[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.deviceFilters[i1] = UsbDeviceFilter.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.deviceFilters == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.deviceFilters.length, 8, -1);
                for (int i0 = 0; i0 < this.deviceFilters.length; i0++)
                    encoder1.encode((Struct)this.deviceFilters[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class WebUsbServiceGetPermissionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbDeviceInfo result;

        private WebUsbServiceGetPermissionResponseParams(int version) {
            super(16, version);
        }

        public WebUsbServiceGetPermissionResponseParams() {
            this(0);
        }

        public static WebUsbServiceGetPermissionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebUsbServiceGetPermissionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebUsbServiceGetPermissionResponseParams decode(Decoder decoder0) {
            WebUsbServiceGetPermissionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebUsbServiceGetPermissionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.result = UsbDeviceInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.result, 8, true);
        }
    }

    static class WebUsbServiceGetPermissionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebUsbService.GetPermissionResponse mCallback;

        WebUsbServiceGetPermissionResponseParamsForwardToCallback(WebUsbService.GetPermissionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                WebUsbService_Internal.WebUsbServiceGetPermissionResponseParams response = WebUsbService_Internal.WebUsbServiceGetPermissionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebUsbServiceGetPermissionResponseParamsProxyToResponder implements WebUsbService.GetPermissionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebUsbServiceGetPermissionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UsbDeviceInfo result) {
            WebUsbService_Internal.WebUsbServiceGetPermissionResponseParams _response = new WebUsbService_Internal.WebUsbServiceGetPermissionResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebUsbServiceSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private WebUsbServiceSetClientParams(int version) {
            super(16, version);
        }

        public WebUsbServiceSetClientParams() {
            this(0);
        }

        public static WebUsbServiceSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebUsbServiceSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebUsbServiceSetClientParams decode(Decoder decoder0) {
            WebUsbServiceSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebUsbServiceSetClientParams(elementsOrVersion);
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
