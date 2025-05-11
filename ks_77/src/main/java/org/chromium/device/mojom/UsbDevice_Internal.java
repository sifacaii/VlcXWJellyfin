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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class UsbDevice_Internal {
    public static final Interface.Manager<UsbDevice, UsbDevice.Proxy> MANAGER = new Interface.Manager<UsbDevice, UsbDevice.Proxy>() {
        public String getName() {
            return "device.mojom.UsbDevice";
        }

        public int getVersion() {
            return 0;
        }

        public UsbDevice_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new UsbDevice_Internal.Proxy(core, messageReceiver);
        }

        public UsbDevice_Internal.Stub buildStub(Core core, UsbDevice impl) {
            return new UsbDevice_Internal.Stub(core, impl);
        }

        public UsbDevice[] buildArray(int size) {
            return new UsbDevice[size];
        }
    };

    private static final int OPEN_ORDINAL = 0;

    private static final int CLOSE_ORDINAL = 1;

    private static final int SET_CONFIGURATION_ORDINAL = 2;

    private static final int CLAIM_INTERFACE_ORDINAL = 3;

    private static final int RELEASE_INTERFACE_ORDINAL = 4;

    private static final int SET_INTERFACE_ALTERNATE_SETTING_ORDINAL = 5;

    private static final int RESET_ORDINAL = 6;

    private static final int CLEAR_HALT_ORDINAL = 7;

    private static final int CONTROL_TRANSFER_IN_ORDINAL = 8;

    private static final int CONTROL_TRANSFER_OUT_ORDINAL = 9;

    private static final int GENERIC_TRANSFER_IN_ORDINAL = 10;

    private static final int GENERIC_TRANSFER_OUT_ORDINAL = 11;

    private static final int ISOCHRONOUS_TRANSFER_IN_ORDINAL = 12;

    private static final int ISOCHRONOUS_TRANSFER_OUT_ORDINAL = 13;

    static final class Proxy extends Interface.AbstractProxy implements UsbDevice.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void open(UsbDevice.OpenResponse callback) {
            UsbDevice_Internal.UsbDeviceOpenParams _message = new UsbDevice_Internal.UsbDeviceOpenParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new UsbDevice_Internal.UsbDeviceOpenResponseParamsForwardToCallback(callback));
        }

        public void close(UsbDevice.CloseResponse callback) {
            UsbDevice_Internal.UsbDeviceCloseParams _message = new UsbDevice_Internal.UsbDeviceCloseParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new UsbDevice_Internal.UsbDeviceCloseResponseParamsForwardToCallback(callback));
        }

        public void setConfiguration(byte value, UsbDevice.SetConfigurationResponse callback) {
            UsbDevice_Internal.UsbDeviceSetConfigurationParams _message = new UsbDevice_Internal.UsbDeviceSetConfigurationParams();
            _message.value = value;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new UsbDevice_Internal.UsbDeviceSetConfigurationResponseParamsForwardToCallback(callback));
        }

        public void claimInterface(byte interfaceNumber, UsbDevice.ClaimInterfaceResponse callback) {
            UsbDevice_Internal.UsbDeviceClaimInterfaceParams _message = new UsbDevice_Internal.UsbDeviceClaimInterfaceParams();
            _message.interfaceNumber = interfaceNumber;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new UsbDevice_Internal.UsbDeviceClaimInterfaceResponseParamsForwardToCallback(callback));
        }

        public void releaseInterface(byte interfaceNumber, UsbDevice.ReleaseInterfaceResponse callback) {
            UsbDevice_Internal.UsbDeviceReleaseInterfaceParams _message = new UsbDevice_Internal.UsbDeviceReleaseInterfaceParams();
            _message.interfaceNumber = interfaceNumber;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new UsbDevice_Internal.UsbDeviceReleaseInterfaceResponseParamsForwardToCallback(callback));
        }

        public void setInterfaceAlternateSetting(byte interfaceNumber, byte alternateSetting, UsbDevice.SetInterfaceAlternateSettingResponse callback) {
            UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingParams _message = new UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingParams();
            _message.interfaceNumber = interfaceNumber;
            _message.alternateSetting = alternateSetting;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingResponseParamsForwardToCallback(callback));
        }

        public void reset(UsbDevice.ResetResponse callback) {
            UsbDevice_Internal.UsbDeviceResetParams _message = new UsbDevice_Internal.UsbDeviceResetParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new UsbDevice_Internal.UsbDeviceResetResponseParamsForwardToCallback(callback));
        }

        public void clearHalt(byte endpoint, UsbDevice.ClearHaltResponse callback) {
            UsbDevice_Internal.UsbDeviceClearHaltParams _message = new UsbDevice_Internal.UsbDeviceClearHaltParams();
            _message.endpoint = endpoint;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new UsbDevice_Internal.UsbDeviceClearHaltResponseParamsForwardToCallback(callback));
        }

        public void controlTransferIn(UsbControlTransferParams params, int length, int timeout, UsbDevice.ControlTransferInResponse callback) {
            UsbDevice_Internal.UsbDeviceControlTransferInParams _message = new UsbDevice_Internal.UsbDeviceControlTransferInParams();
            _message.params = params;
            _message.length = length;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new UsbDevice_Internal.UsbDeviceControlTransferInResponseParamsForwardToCallback(callback));
        }

        public void controlTransferOut(UsbControlTransferParams params, byte[] data, int timeout, UsbDevice.ControlTransferOutResponse callback) {
            UsbDevice_Internal.UsbDeviceControlTransferOutParams _message = new UsbDevice_Internal.UsbDeviceControlTransferOutParams();
            _message.params = params;
            _message.data = data;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new UsbDevice_Internal.UsbDeviceControlTransferOutResponseParamsForwardToCallback(callback));
        }

        public void genericTransferIn(byte endpointNumber, int length, int timeout, UsbDevice.GenericTransferInResponse callback) {
            UsbDevice_Internal.UsbDeviceGenericTransferInParams _message = new UsbDevice_Internal.UsbDeviceGenericTransferInParams();
            _message.endpointNumber = endpointNumber;
            _message.length = length;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new UsbDevice_Internal.UsbDeviceGenericTransferInResponseParamsForwardToCallback(callback));
        }

        public void genericTransferOut(byte endpointNumber, byte[] data, int timeout, UsbDevice.GenericTransferOutResponse callback) {
            UsbDevice_Internal.UsbDeviceGenericTransferOutParams _message = new UsbDevice_Internal.UsbDeviceGenericTransferOutParams();
            _message.endpointNumber = endpointNumber;
            _message.data = data;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)), new UsbDevice_Internal.UsbDeviceGenericTransferOutResponseParamsForwardToCallback(callback));
        }

        public void isochronousTransferIn(byte endpointNumber, int[] packetLengths, int timeout, UsbDevice.IsochronousTransferInResponse callback) {
            UsbDevice_Internal.UsbDeviceIsochronousTransferInParams _message = new UsbDevice_Internal.UsbDeviceIsochronousTransferInParams();
            _message.endpointNumber = endpointNumber;
            _message.packetLengths = packetLengths;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)), new UsbDevice_Internal.UsbDeviceIsochronousTransferInResponseParamsForwardToCallback(callback));
        }

        public void isochronousTransferOut(byte endpointNumber, byte[] data, int[] packetLengths, int timeout, UsbDevice.IsochronousTransferOutResponse callback) {
            UsbDevice_Internal.UsbDeviceIsochronousTransferOutParams _message = new UsbDevice_Internal.UsbDeviceIsochronousTransferOutParams();
            _message.endpointNumber = endpointNumber;
            _message.data = data;
            _message.packetLengths = packetLengths;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)), new UsbDevice_Internal.UsbDeviceIsochronousTransferOutResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<UsbDevice> {
        Stub(Core core, UsbDevice impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UsbDevice_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                UsbDevice_Internal.UsbDeviceSetConfigurationParams usbDeviceSetConfigurationParams;
                UsbDevice_Internal.UsbDeviceClaimInterfaceParams usbDeviceClaimInterfaceParams;
                UsbDevice_Internal.UsbDeviceReleaseInterfaceParams usbDeviceReleaseInterfaceParams;
                UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingParams usbDeviceSetInterfaceAlternateSettingParams;
                UsbDevice_Internal.UsbDeviceClearHaltParams usbDeviceClearHaltParams;
                UsbDevice_Internal.UsbDeviceControlTransferInParams usbDeviceControlTransferInParams;
                UsbDevice_Internal.UsbDeviceControlTransferOutParams usbDeviceControlTransferOutParams;
                UsbDevice_Internal.UsbDeviceGenericTransferInParams usbDeviceGenericTransferInParams;
                UsbDevice_Internal.UsbDeviceGenericTransferOutParams usbDeviceGenericTransferOutParams;
                UsbDevice_Internal.UsbDeviceIsochronousTransferInParams usbDeviceIsochronousTransferInParams;
                UsbDevice_Internal.UsbDeviceIsochronousTransferOutParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), UsbDevice_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        UsbDevice_Internal.UsbDeviceOpenParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).open(new UsbDevice_Internal.UsbDeviceOpenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        UsbDevice_Internal.UsbDeviceCloseParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).close(new UsbDevice_Internal.UsbDeviceCloseResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        usbDeviceSetConfigurationParams = UsbDevice_Internal.UsbDeviceSetConfigurationParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).setConfiguration(usbDeviceSetConfigurationParams.value, new UsbDevice_Internal.UsbDeviceSetConfigurationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        usbDeviceClaimInterfaceParams = UsbDevice_Internal.UsbDeviceClaimInterfaceParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).claimInterface(usbDeviceClaimInterfaceParams.interfaceNumber, new UsbDevice_Internal.UsbDeviceClaimInterfaceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        usbDeviceReleaseInterfaceParams = UsbDevice_Internal.UsbDeviceReleaseInterfaceParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).releaseInterface(usbDeviceReleaseInterfaceParams.interfaceNumber, new UsbDevice_Internal.UsbDeviceReleaseInterfaceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        usbDeviceSetInterfaceAlternateSettingParams = UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).setInterfaceAlternateSetting(usbDeviceSetInterfaceAlternateSettingParams.interfaceNumber, usbDeviceSetInterfaceAlternateSettingParams.alternateSetting, new UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        UsbDevice_Internal.UsbDeviceResetParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).reset(new UsbDevice_Internal.UsbDeviceResetResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        usbDeviceClearHaltParams = UsbDevice_Internal.UsbDeviceClearHaltParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).clearHalt(usbDeviceClearHaltParams.endpoint, new UsbDevice_Internal.UsbDeviceClearHaltResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        usbDeviceControlTransferInParams = UsbDevice_Internal.UsbDeviceControlTransferInParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).controlTransferIn(usbDeviceControlTransferInParams.params, usbDeviceControlTransferInParams.length, usbDeviceControlTransferInParams.timeout, new UsbDevice_Internal.UsbDeviceControlTransferInResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        usbDeviceControlTransferOutParams = UsbDevice_Internal.UsbDeviceControlTransferOutParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).controlTransferOut(usbDeviceControlTransferOutParams.params, usbDeviceControlTransferOutParams.data, usbDeviceControlTransferOutParams.timeout, new UsbDevice_Internal.UsbDeviceControlTransferOutResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        usbDeviceGenericTransferInParams = UsbDevice_Internal.UsbDeviceGenericTransferInParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).genericTransferIn(usbDeviceGenericTransferInParams.endpointNumber, usbDeviceGenericTransferInParams.length, usbDeviceGenericTransferInParams.timeout, new UsbDevice_Internal.UsbDeviceGenericTransferInResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 11:
                        usbDeviceGenericTransferOutParams = UsbDevice_Internal.UsbDeviceGenericTransferOutParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).genericTransferOut(usbDeviceGenericTransferOutParams.endpointNumber, usbDeviceGenericTransferOutParams.data, usbDeviceGenericTransferOutParams.timeout, new UsbDevice_Internal.UsbDeviceGenericTransferOutResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                        usbDeviceIsochronousTransferInParams = UsbDevice_Internal.UsbDeviceIsochronousTransferInParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).isochronousTransferIn(usbDeviceIsochronousTransferInParams.endpointNumber, usbDeviceIsochronousTransferInParams.packetLengths, usbDeviceIsochronousTransferInParams.timeout, new UsbDevice_Internal.UsbDeviceIsochronousTransferInResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 13:
                        data = UsbDevice_Internal.UsbDeviceIsochronousTransferOutParams.deserialize(messageWithHeader.getPayload());
                        ((UsbDevice)getImpl()).isochronousTransferOut(data.endpointNumber, data.data, data.packetLengths, data.timeout, new UsbDevice_Internal.UsbDeviceIsochronousTransferOutResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class UsbDeviceOpenParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UsbDeviceOpenParams(int version) {
            super(8, version);
        }

        public UsbDeviceOpenParams() {
            this(0);
        }

        public static UsbDeviceOpenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceOpenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceOpenParams decode(Decoder decoder0) {
            UsbDeviceOpenParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceOpenParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class UsbDeviceOpenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private UsbDeviceOpenResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceOpenResponseParams() {
            this(0);
        }

        public static UsbDeviceOpenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceOpenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceOpenResponseParams decode(Decoder decoder0) {
            UsbDeviceOpenResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceOpenResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                UsbOpenDeviceError.validate(result.error);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    static class UsbDeviceOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.OpenResponse mCallback;

        UsbDeviceOpenResponseParamsForwardToCallback(UsbDevice.OpenResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceOpenResponseParams response = UsbDevice_Internal.UsbDeviceOpenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceOpenResponseParamsProxyToResponder implements UsbDevice.OpenResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceOpenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error) {
            UsbDevice_Internal.UsbDeviceOpenResponseParams _response = new UsbDevice_Internal.UsbDeviceOpenResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceCloseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UsbDeviceCloseParams(int version) {
            super(8, version);
        }

        public UsbDeviceCloseParams() {
            this(0);
        }

        public static UsbDeviceCloseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceCloseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceCloseParams decode(Decoder decoder0) {
            UsbDeviceCloseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceCloseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class UsbDeviceCloseResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UsbDeviceCloseResponseParams(int version) {
            super(8, version);
        }

        public UsbDeviceCloseResponseParams() {
            this(0);
        }

        public static UsbDeviceCloseResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceCloseResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceCloseResponseParams decode(Decoder decoder0) {
            UsbDeviceCloseResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceCloseResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class UsbDeviceCloseResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.CloseResponse mCallback;

        UsbDeviceCloseResponseParamsForwardToCallback(UsbDevice.CloseResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceCloseResponseParamsProxyToResponder implements UsbDevice.CloseResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceCloseResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            UsbDevice_Internal.UsbDeviceCloseResponseParams _response = new UsbDevice_Internal.UsbDeviceCloseResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceSetConfigurationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte value;

        private UsbDeviceSetConfigurationParams(int version) {
            super(16, version);
        }

        public UsbDeviceSetConfigurationParams() {
            this(0);
        }

        public static UsbDeviceSetConfigurationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceSetConfigurationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceSetConfigurationParams decode(Decoder decoder0) {
            UsbDeviceSetConfigurationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceSetConfigurationParams(elementsOrVersion);
                result.value = decoder0.readByte(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.value, 8);
        }
    }

    static final class UsbDeviceSetConfigurationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private UsbDeviceSetConfigurationResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceSetConfigurationResponseParams() {
            this(0);
        }

        public static UsbDeviceSetConfigurationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceSetConfigurationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceSetConfigurationResponseParams decode(Decoder decoder0) {
            UsbDeviceSetConfigurationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceSetConfigurationResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class UsbDeviceSetConfigurationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.SetConfigurationResponse mCallback;

        UsbDeviceSetConfigurationResponseParamsForwardToCallback(UsbDevice.SetConfigurationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceSetConfigurationResponseParams response = UsbDevice_Internal.UsbDeviceSetConfigurationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceSetConfigurationResponseParamsProxyToResponder implements UsbDevice.SetConfigurationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceSetConfigurationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            UsbDevice_Internal.UsbDeviceSetConfigurationResponseParams _response = new UsbDevice_Internal.UsbDeviceSetConfigurationResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceClaimInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte interfaceNumber;

        private UsbDeviceClaimInterfaceParams(int version) {
            super(16, version);
        }

        public UsbDeviceClaimInterfaceParams() {
            this(0);
        }

        public static UsbDeviceClaimInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceClaimInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceClaimInterfaceParams decode(Decoder decoder0) {
            UsbDeviceClaimInterfaceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceClaimInterfaceParams(elementsOrVersion);
                result.interfaceNumber = decoder0.readByte(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.interfaceNumber, 8);
        }
    }

    static final class UsbDeviceClaimInterfaceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private UsbDeviceClaimInterfaceResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceClaimInterfaceResponseParams() {
            this(0);
        }

        public static UsbDeviceClaimInterfaceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceClaimInterfaceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceClaimInterfaceResponseParams decode(Decoder decoder0) {
            UsbDeviceClaimInterfaceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceClaimInterfaceResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class UsbDeviceClaimInterfaceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.ClaimInterfaceResponse mCallback;

        UsbDeviceClaimInterfaceResponseParamsForwardToCallback(UsbDevice.ClaimInterfaceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceClaimInterfaceResponseParams response = UsbDevice_Internal.UsbDeviceClaimInterfaceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceClaimInterfaceResponseParamsProxyToResponder implements UsbDevice.ClaimInterfaceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceClaimInterfaceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            UsbDevice_Internal.UsbDeviceClaimInterfaceResponseParams _response = new UsbDevice_Internal.UsbDeviceClaimInterfaceResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceReleaseInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte interfaceNumber;

        private UsbDeviceReleaseInterfaceParams(int version) {
            super(16, version);
        }

        public UsbDeviceReleaseInterfaceParams() {
            this(0);
        }

        public static UsbDeviceReleaseInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceReleaseInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceReleaseInterfaceParams decode(Decoder decoder0) {
            UsbDeviceReleaseInterfaceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceReleaseInterfaceParams(elementsOrVersion);
                result.interfaceNumber = decoder0.readByte(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.interfaceNumber, 8);
        }
    }

    static final class UsbDeviceReleaseInterfaceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private UsbDeviceReleaseInterfaceResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceReleaseInterfaceResponseParams() {
            this(0);
        }

        public static UsbDeviceReleaseInterfaceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceReleaseInterfaceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceReleaseInterfaceResponseParams decode(Decoder decoder0) {
            UsbDeviceReleaseInterfaceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceReleaseInterfaceResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class UsbDeviceReleaseInterfaceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.ReleaseInterfaceResponse mCallback;

        UsbDeviceReleaseInterfaceResponseParamsForwardToCallback(UsbDevice.ReleaseInterfaceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceReleaseInterfaceResponseParams response = UsbDevice_Internal.UsbDeviceReleaseInterfaceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceReleaseInterfaceResponseParamsProxyToResponder implements UsbDevice.ReleaseInterfaceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceReleaseInterfaceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            UsbDevice_Internal.UsbDeviceReleaseInterfaceResponseParams _response = new UsbDevice_Internal.UsbDeviceReleaseInterfaceResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceSetInterfaceAlternateSettingParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte interfaceNumber;

        public byte alternateSetting;

        private UsbDeviceSetInterfaceAlternateSettingParams(int version) {
            super(16, version);
        }

        public UsbDeviceSetInterfaceAlternateSettingParams() {
            this(0);
        }

        public static UsbDeviceSetInterfaceAlternateSettingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceSetInterfaceAlternateSettingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceSetInterfaceAlternateSettingParams decode(Decoder decoder0) {
            UsbDeviceSetInterfaceAlternateSettingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceSetInterfaceAlternateSettingParams(elementsOrVersion);
                result.interfaceNumber = decoder0.readByte(8);
                result.alternateSetting = decoder0.readByte(9);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.interfaceNumber, 8);
            encoder0.encode(this.alternateSetting, 9);
        }
    }

    static final class UsbDeviceSetInterfaceAlternateSettingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private UsbDeviceSetInterfaceAlternateSettingResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceSetInterfaceAlternateSettingResponseParams() {
            this(0);
        }

        public static UsbDeviceSetInterfaceAlternateSettingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceSetInterfaceAlternateSettingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceSetInterfaceAlternateSettingResponseParams decode(Decoder decoder0) {
            UsbDeviceSetInterfaceAlternateSettingResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceSetInterfaceAlternateSettingResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class UsbDeviceSetInterfaceAlternateSettingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.SetInterfaceAlternateSettingResponse mCallback;

        UsbDeviceSetInterfaceAlternateSettingResponseParamsForwardToCallback(UsbDevice.SetInterfaceAlternateSettingResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingResponseParams response = UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceSetInterfaceAlternateSettingResponseParamsProxyToResponder implements UsbDevice.SetInterfaceAlternateSettingResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceSetInterfaceAlternateSettingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingResponseParams _response = new UsbDevice_Internal.UsbDeviceSetInterfaceAlternateSettingResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceResetParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UsbDeviceResetParams(int version) {
            super(8, version);
        }

        public UsbDeviceResetParams() {
            this(0);
        }

        public static UsbDeviceResetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceResetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceResetParams decode(Decoder decoder0) {
            UsbDeviceResetParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceResetParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class UsbDeviceResetResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private UsbDeviceResetResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceResetResponseParams() {
            this(0);
        }

        public static UsbDeviceResetResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceResetResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceResetResponseParams decode(Decoder decoder0) {
            UsbDeviceResetResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceResetResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class UsbDeviceResetResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.ResetResponse mCallback;

        UsbDeviceResetResponseParamsForwardToCallback(UsbDevice.ResetResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceResetResponseParams response = UsbDevice_Internal.UsbDeviceResetResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceResetResponseParamsProxyToResponder implements UsbDevice.ResetResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceResetResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            UsbDevice_Internal.UsbDeviceResetResponseParams _response = new UsbDevice_Internal.UsbDeviceResetResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceClearHaltParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte endpoint;

        private UsbDeviceClearHaltParams(int version) {
            super(16, version);
        }

        public UsbDeviceClearHaltParams() {
            this(0);
        }

        public static UsbDeviceClearHaltParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceClearHaltParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceClearHaltParams decode(Decoder decoder0) {
            UsbDeviceClearHaltParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceClearHaltParams(elementsOrVersion);
                result.endpoint = decoder0.readByte(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.endpoint, 8);
        }
    }

    static final class UsbDeviceClearHaltResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private UsbDeviceClearHaltResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceClearHaltResponseParams() {
            this(0);
        }

        public static UsbDeviceClearHaltResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceClearHaltResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceClearHaltResponseParams decode(Decoder decoder0) {
            UsbDeviceClearHaltResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceClearHaltResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class UsbDeviceClearHaltResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.ClearHaltResponse mCallback;

        UsbDeviceClearHaltResponseParamsForwardToCallback(UsbDevice.ClearHaltResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceClearHaltResponseParams response = UsbDevice_Internal.UsbDeviceClearHaltResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceClearHaltResponseParamsProxyToResponder implements UsbDevice.ClearHaltResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceClearHaltResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            UsbDevice_Internal.UsbDeviceClearHaltResponseParams _response = new UsbDevice_Internal.UsbDeviceClearHaltResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceControlTransferInParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbControlTransferParams params;

        public int length;

        public int timeout;

        private UsbDeviceControlTransferInParams(int version) {
            super(24, version);
        }

        public UsbDeviceControlTransferInParams() {
            this(0);
        }

        public static UsbDeviceControlTransferInParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceControlTransferInParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceControlTransferInParams decode(Decoder decoder0) {
            UsbDeviceControlTransferInParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceControlTransferInParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = UsbControlTransferParams.decode(decoder1);
                result.length = decoder0.readInt(16);
                result.timeout = decoder0.readInt(20);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
            encoder0.encode(this.length, 16);
            encoder0.encode(this.timeout, 20);
        }
    }

    static final class UsbDeviceControlTransferInResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public byte[] data;

        private UsbDeviceControlTransferInResponseParams(int version) {
            super(24, version);
        }

        public UsbDeviceControlTransferInResponseParams() {
            this(0);
        }

        public static UsbDeviceControlTransferInResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceControlTransferInResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceControlTransferInResponseParams decode(Decoder decoder0) {
            UsbDeviceControlTransferInResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceControlTransferInResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                UsbTransferStatus.validate(result.status);
                result.data = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    static class UsbDeviceControlTransferInResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.ControlTransferInResponse mCallback;

        UsbDeviceControlTransferInResponseParamsForwardToCallback(UsbDevice.ControlTransferInResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceControlTransferInResponseParams response = UsbDevice_Internal.UsbDeviceControlTransferInResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceControlTransferInResponseParamsProxyToResponder implements UsbDevice.ControlTransferInResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceControlTransferInResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, byte[] data) {
            UsbDevice_Internal.UsbDeviceControlTransferInResponseParams _response = new UsbDevice_Internal.UsbDeviceControlTransferInResponseParams();
            _response.status = status.intValue();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceControlTransferOutParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbControlTransferParams params;

        public byte[] data;

        public int timeout;

        private UsbDeviceControlTransferOutParams(int version) {
            super(32, version);
        }

        public UsbDeviceControlTransferOutParams() {
            this(0);
        }

        public static UsbDeviceControlTransferOutParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceControlTransferOutParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceControlTransferOutParams decode(Decoder decoder0) {
            UsbDeviceControlTransferOutParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceControlTransferOutParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = UsbControlTransferParams.decode(decoder1);
                result.data = decoder0.readBytes(16, 0, -1);
                result.timeout = decoder0.readInt(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
            encoder0.encode(this.data, 16, 0, -1);
            encoder0.encode(this.timeout, 24);
        }
    }

    static final class UsbDeviceControlTransferOutResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private UsbDeviceControlTransferOutResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceControlTransferOutResponseParams() {
            this(0);
        }

        public static UsbDeviceControlTransferOutResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceControlTransferOutResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceControlTransferOutResponseParams decode(Decoder decoder0) {
            UsbDeviceControlTransferOutResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceControlTransferOutResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                UsbTransferStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class UsbDeviceControlTransferOutResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.ControlTransferOutResponse mCallback;

        UsbDeviceControlTransferOutResponseParamsForwardToCallback(UsbDevice.ControlTransferOutResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceControlTransferOutResponseParams response = UsbDevice_Internal.UsbDeviceControlTransferOutResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceControlTransferOutResponseParamsProxyToResponder implements UsbDevice.ControlTransferOutResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceControlTransferOutResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            UsbDevice_Internal.UsbDeviceControlTransferOutResponseParams _response = new UsbDevice_Internal.UsbDeviceControlTransferOutResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceGenericTransferInParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte endpointNumber;

        public int length;

        public int timeout;

        private UsbDeviceGenericTransferInParams(int version) {
            super(24, version);
        }

        public UsbDeviceGenericTransferInParams() {
            this(0);
        }

        public static UsbDeviceGenericTransferInParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceGenericTransferInParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceGenericTransferInParams decode(Decoder decoder0) {
            UsbDeviceGenericTransferInParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceGenericTransferInParams(elementsOrVersion);
                result.endpointNumber = decoder0.readByte(8);
                result.length = decoder0.readInt(12);
                result.timeout = decoder0.readInt(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.endpointNumber, 8);
            encoder0.encode(this.length, 12);
            encoder0.encode(this.timeout, 16);
        }
    }

    static final class UsbDeviceGenericTransferInResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public byte[] data;

        private UsbDeviceGenericTransferInResponseParams(int version) {
            super(24, version);
        }

        public UsbDeviceGenericTransferInResponseParams() {
            this(0);
        }

        public static UsbDeviceGenericTransferInResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceGenericTransferInResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceGenericTransferInResponseParams decode(Decoder decoder0) {
            UsbDeviceGenericTransferInResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceGenericTransferInResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                UsbTransferStatus.validate(result.status);
                result.data = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    static class UsbDeviceGenericTransferInResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.GenericTransferInResponse mCallback;

        UsbDeviceGenericTransferInResponseParamsForwardToCallback(UsbDevice.GenericTransferInResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceGenericTransferInResponseParams response = UsbDevice_Internal.UsbDeviceGenericTransferInResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceGenericTransferInResponseParamsProxyToResponder implements UsbDevice.GenericTransferInResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceGenericTransferInResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, byte[] data) {
            UsbDevice_Internal.UsbDeviceGenericTransferInResponseParams _response = new UsbDevice_Internal.UsbDeviceGenericTransferInResponseParams();
            _response.status = status.intValue();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceGenericTransferOutParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte endpointNumber;

        public byte[] data;

        public int timeout;

        private UsbDeviceGenericTransferOutParams(int version) {
            super(24, version);
        }

        public UsbDeviceGenericTransferOutParams() {
            this(0);
        }

        public static UsbDeviceGenericTransferOutParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceGenericTransferOutParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceGenericTransferOutParams decode(Decoder decoder0) {
            UsbDeviceGenericTransferOutParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceGenericTransferOutParams(elementsOrVersion);
                result.endpointNumber = decoder0.readByte(8);
                result.timeout = decoder0.readInt(12);
                result.data = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.endpointNumber, 8);
            encoder0.encode(this.timeout, 12);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    static final class UsbDeviceGenericTransferOutResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private UsbDeviceGenericTransferOutResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceGenericTransferOutResponseParams() {
            this(0);
        }

        public static UsbDeviceGenericTransferOutResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceGenericTransferOutResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceGenericTransferOutResponseParams decode(Decoder decoder0) {
            UsbDeviceGenericTransferOutResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceGenericTransferOutResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                UsbTransferStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class UsbDeviceGenericTransferOutResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.GenericTransferOutResponse mCallback;

        UsbDeviceGenericTransferOutResponseParamsForwardToCallback(UsbDevice.GenericTransferOutResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(11, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceGenericTransferOutResponseParams response = UsbDevice_Internal.UsbDeviceGenericTransferOutResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceGenericTransferOutResponseParamsProxyToResponder implements UsbDevice.GenericTransferOutResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceGenericTransferOutResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            UsbDevice_Internal.UsbDeviceGenericTransferOutResponseParams _response = new UsbDevice_Internal.UsbDeviceGenericTransferOutResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceIsochronousTransferInParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte endpointNumber;

        public int[] packetLengths;

        public int timeout;

        private UsbDeviceIsochronousTransferInParams(int version) {
            super(24, version);
        }

        public UsbDeviceIsochronousTransferInParams() {
            this(0);
        }

        public static UsbDeviceIsochronousTransferInParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceIsochronousTransferInParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceIsochronousTransferInParams decode(Decoder decoder0) {
            UsbDeviceIsochronousTransferInParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceIsochronousTransferInParams(elementsOrVersion);
                result.endpointNumber = decoder0.readByte(8);
                result.timeout = decoder0.readInt(12);
                result.packetLengths = decoder0.readInts(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.endpointNumber, 8);
            encoder0.encode(this.timeout, 12);
            encoder0.encode(this.packetLengths, 16, 0, -1);
        }
    }

    static final class UsbDeviceIsochronousTransferInResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] data;

        public UsbIsochronousPacket[] packets;

        private UsbDeviceIsochronousTransferInResponseParams(int version) {
            super(24, version);
        }

        public UsbDeviceIsochronousTransferInResponseParams() {
            this(0);
        }

        public static UsbDeviceIsochronousTransferInResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceIsochronousTransferInResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceIsochronousTransferInResponseParams decode(Decoder decoder0) {
            UsbDeviceIsochronousTransferInResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceIsochronousTransferInResponseParams(elementsOrVersion);
                result.data = decoder0.readBytes(8, 0, -1);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.packets = new UsbIsochronousPacket[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.packets[i1] = UsbIsochronousPacket.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.data, 8, 0, -1);
            if (this.packets == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.packets.length, 16, -1);
                for (int i0 = 0; i0 < this.packets.length; i0++)
                    encoder1.encode(this.packets[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class UsbDeviceIsochronousTransferInResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.IsochronousTransferInResponse mCallback;

        UsbDeviceIsochronousTransferInResponseParamsForwardToCallback(UsbDevice.IsochronousTransferInResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(12, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceIsochronousTransferInResponseParams response = UsbDevice_Internal.UsbDeviceIsochronousTransferInResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.data, response.packets);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceIsochronousTransferInResponseParamsProxyToResponder implements UsbDevice.IsochronousTransferInResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceIsochronousTransferInResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(byte[] data, UsbIsochronousPacket[] packets) {
            UsbDevice_Internal.UsbDeviceIsochronousTransferInResponseParams _response = new UsbDevice_Internal.UsbDeviceIsochronousTransferInResponseParams();
            _response.data = data;
            _response.packets = packets;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class UsbDeviceIsochronousTransferOutParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte endpointNumber;

        public byte[] data;

        public int[] packetLengths;

        public int timeout;

        private UsbDeviceIsochronousTransferOutParams(int version) {
            super(32, version);
        }

        public UsbDeviceIsochronousTransferOutParams() {
            this(0);
        }

        public static UsbDeviceIsochronousTransferOutParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceIsochronousTransferOutParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceIsochronousTransferOutParams decode(Decoder decoder0) {
            UsbDeviceIsochronousTransferOutParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceIsochronousTransferOutParams(elementsOrVersion);
                result.endpointNumber = decoder0.readByte(8);
                result.timeout = decoder0.readInt(12);
                result.data = decoder0.readBytes(16, 0, -1);
                result.packetLengths = decoder0.readInts(24, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.endpointNumber, 8);
            encoder0.encode(this.timeout, 12);
            encoder0.encode(this.data, 16, 0, -1);
            encoder0.encode(this.packetLengths, 24, 0, -1);
        }
    }

    static final class UsbDeviceIsochronousTransferOutResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UsbIsochronousPacket[] packets;

        private UsbDeviceIsochronousTransferOutResponseParams(int version) {
            super(16, version);
        }

        public UsbDeviceIsochronousTransferOutResponseParams() {
            this(0);
        }

        public static UsbDeviceIsochronousTransferOutResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UsbDeviceIsochronousTransferOutResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UsbDeviceIsochronousTransferOutResponseParams decode(Decoder decoder0) {
            UsbDeviceIsochronousTransferOutResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UsbDeviceIsochronousTransferOutResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.packets = new UsbIsochronousPacket[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.packets[i1] = UsbIsochronousPacket.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.packets == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.packets.length, 8, -1);
                for (int i0 = 0; i0 < this.packets.length; i0++)
                    encoder1.encode(this.packets[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class UsbDeviceIsochronousTransferOutResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final UsbDevice.IsochronousTransferOutResponse mCallback;

        UsbDeviceIsochronousTransferOutResponseParamsForwardToCallback(UsbDevice.IsochronousTransferOutResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(13, 2))
                    return false;
                UsbDevice_Internal.UsbDeviceIsochronousTransferOutResponseParams response = UsbDevice_Internal.UsbDeviceIsochronousTransferOutResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.packets);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class UsbDeviceIsochronousTransferOutResponseParamsProxyToResponder implements UsbDevice.IsochronousTransferOutResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        UsbDeviceIsochronousTransferOutResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UsbIsochronousPacket[] packets) {
            UsbDevice_Internal.UsbDeviceIsochronousTransferOutResponseParams _response = new UsbDevice_Internal.UsbDeviceIsochronousTransferOutResponseParams();
            _response.packets = packets;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
