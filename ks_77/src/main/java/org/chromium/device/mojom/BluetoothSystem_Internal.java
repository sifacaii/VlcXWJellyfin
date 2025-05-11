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

class BluetoothSystem_Internal {
    public static final Interface.Manager<BluetoothSystem, BluetoothSystem.Proxy> MANAGER = new Interface.Manager<BluetoothSystem, BluetoothSystem.Proxy>() {
        public String getName() {
            return "device.mojom.BluetoothSystem";
        }

        public int getVersion() {
            return 0;
        }

        public BluetoothSystem_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BluetoothSystem_Internal.Proxy(core, messageReceiver);
        }

        public BluetoothSystem_Internal.Stub buildStub(Core core, BluetoothSystem impl) {
            return new BluetoothSystem_Internal.Stub(core, impl);
        }

        public BluetoothSystem[] buildArray(int size) {
            return new BluetoothSystem[size];
        }
    };

    private static final int GET_STATE_ORDINAL = 0;

    private static final int SET_POWERED_ORDINAL = 1;

    private static final int GET_SCAN_STATE_ORDINAL = 2;

    private static final int START_SCAN_ORDINAL = 3;

    private static final int STOP_SCAN_ORDINAL = 4;

    private static final int GET_AVAILABLE_DEVICES_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements BluetoothSystem.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getState(BluetoothSystem.GetStateResponse callback) {
            BluetoothSystem_Internal.BluetoothSystemGetStateParams _message = new BluetoothSystem_Internal.BluetoothSystemGetStateParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BluetoothSystem_Internal.BluetoothSystemGetStateResponseParamsForwardToCallback(callback));
        }

        public void setPowered(boolean powered, BluetoothSystem.SetPoweredResponse callback) {
            BluetoothSystem_Internal.BluetoothSystemSetPoweredParams _message = new BluetoothSystem_Internal.BluetoothSystemSetPoweredParams();
            _message.powered = powered;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new BluetoothSystem_Internal.BluetoothSystemSetPoweredResponseParamsForwardToCallback(callback));
        }

        public void getScanState(BluetoothSystem.GetScanStateResponse callback) {
            BluetoothSystem_Internal.BluetoothSystemGetScanStateParams _message = new BluetoothSystem_Internal.BluetoothSystemGetScanStateParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new BluetoothSystem_Internal.BluetoothSystemGetScanStateResponseParamsForwardToCallback(callback));
        }

        public void startScan(BluetoothSystem.StartScanResponse callback) {
            BluetoothSystem_Internal.BluetoothSystemStartScanParams _message = new BluetoothSystem_Internal.BluetoothSystemStartScanParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new BluetoothSystem_Internal.BluetoothSystemStartScanResponseParamsForwardToCallback(callback));
        }

        public void stopScan(BluetoothSystem.StopScanResponse callback) {
            BluetoothSystem_Internal.BluetoothSystemStopScanParams _message = new BluetoothSystem_Internal.BluetoothSystemStopScanParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new BluetoothSystem_Internal.BluetoothSystemStopScanResponseParamsForwardToCallback(callback));
        }

        public void getAvailableDevices(BluetoothSystem.GetAvailableDevicesResponse callback) {
            BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesParams _message = new BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<BluetoothSystem> {
        Stub(Core core, BluetoothSystem impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BluetoothSystem_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                BluetoothSystem_Internal.BluetoothSystemSetPoweredParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BluetoothSystem_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        BluetoothSystem_Internal.BluetoothSystemGetStateParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystem)getImpl()).getState(new BluetoothSystem_Internal.BluetoothSystemGetStateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = BluetoothSystem_Internal.BluetoothSystemSetPoweredParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystem)getImpl()).setPowered(data.powered, new BluetoothSystem_Internal.BluetoothSystemSetPoweredResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        BluetoothSystem_Internal.BluetoothSystemGetScanStateParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystem)getImpl()).getScanState(new BluetoothSystem_Internal.BluetoothSystemGetScanStateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        BluetoothSystem_Internal.BluetoothSystemStartScanParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystem)getImpl()).startScan(new BluetoothSystem_Internal.BluetoothSystemStartScanResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        BluetoothSystem_Internal.BluetoothSystemStopScanParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystem)getImpl()).stopScan(new BluetoothSystem_Internal.BluetoothSystemStopScanResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesParams.deserialize(messageWithHeader.getPayload());
                        ((BluetoothSystem)getImpl()).getAvailableDevices(new BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BluetoothSystemGetStateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BluetoothSystemGetStateParams(int version) {
            super(8, version);
        }

        public BluetoothSystemGetStateParams() {
            this(0);
        }

        public static BluetoothSystemGetStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemGetStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemGetStateParams decode(Decoder decoder0) {
            BluetoothSystemGetStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemGetStateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BluetoothSystemGetStateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int state;

        private BluetoothSystemGetStateResponseParams(int version) {
            super(16, version);
        }

        public BluetoothSystemGetStateResponseParams() {
            this(0);
        }

        public static BluetoothSystemGetStateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemGetStateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemGetStateResponseParams decode(Decoder decoder0) {
            BluetoothSystemGetStateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemGetStateResponseParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                BluetoothSystem.State.validate(result.state);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.state, 8);
        }
    }

    static class BluetoothSystemGetStateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BluetoothSystem.GetStateResponse mCallback;

        BluetoothSystemGetStateResponseParamsForwardToCallback(BluetoothSystem.GetStateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                BluetoothSystem_Internal.BluetoothSystemGetStateResponseParams response = BluetoothSystem_Internal.BluetoothSystemGetStateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.state));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BluetoothSystemGetStateResponseParamsProxyToResponder implements BluetoothSystem.GetStateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BluetoothSystemGetStateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer state) {
            BluetoothSystem_Internal.BluetoothSystemGetStateResponseParams _response = new BluetoothSystem_Internal.BluetoothSystemGetStateResponseParams();
            _response.state = state.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BluetoothSystemSetPoweredParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean powered;

        private BluetoothSystemSetPoweredParams(int version) {
            super(16, version);
        }

        public BluetoothSystemSetPoweredParams() {
            this(0);
        }

        public static BluetoothSystemSetPoweredParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemSetPoweredParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemSetPoweredParams decode(Decoder decoder0) {
            BluetoothSystemSetPoweredParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemSetPoweredParams(elementsOrVersion);
                result.powered = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.powered, 8, 0);
        }
    }

    static final class BluetoothSystemSetPoweredResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private BluetoothSystemSetPoweredResponseParams(int version) {
            super(16, version);
        }

        public BluetoothSystemSetPoweredResponseParams() {
            this(0);
        }

        public static BluetoothSystemSetPoweredResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemSetPoweredResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemSetPoweredResponseParams decode(Decoder decoder0) {
            BluetoothSystemSetPoweredResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemSetPoweredResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                BluetoothSystem.SetPoweredResult.validate(result.result);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
        }
    }

    static class BluetoothSystemSetPoweredResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BluetoothSystem.SetPoweredResponse mCallback;

        BluetoothSystemSetPoweredResponseParamsForwardToCallback(BluetoothSystem.SetPoweredResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                BluetoothSystem_Internal.BluetoothSystemSetPoweredResponseParams response = BluetoothSystem_Internal.BluetoothSystemSetPoweredResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BluetoothSystemSetPoweredResponseParamsProxyToResponder implements BluetoothSystem.SetPoweredResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BluetoothSystemSetPoweredResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            BluetoothSystem_Internal.BluetoothSystemSetPoweredResponseParams _response = new BluetoothSystem_Internal.BluetoothSystemSetPoweredResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BluetoothSystemGetScanStateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BluetoothSystemGetScanStateParams(int version) {
            super(8, version);
        }

        public BluetoothSystemGetScanStateParams() {
            this(0);
        }

        public static BluetoothSystemGetScanStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemGetScanStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemGetScanStateParams decode(Decoder decoder0) {
            BluetoothSystemGetScanStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemGetScanStateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BluetoothSystemGetScanStateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int scanState;

        private BluetoothSystemGetScanStateResponseParams(int version) {
            super(16, version);
        }

        public BluetoothSystemGetScanStateResponseParams() {
            this(0);
        }

        public static BluetoothSystemGetScanStateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemGetScanStateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemGetScanStateResponseParams decode(Decoder decoder0) {
            BluetoothSystemGetScanStateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemGetScanStateResponseParams(elementsOrVersion);
                result.scanState = decoder0.readInt(8);
                BluetoothSystem.ScanState.validate(result.scanState);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.scanState, 8);
        }
    }

    static class BluetoothSystemGetScanStateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BluetoothSystem.GetScanStateResponse mCallback;

        BluetoothSystemGetScanStateResponseParamsForwardToCallback(BluetoothSystem.GetScanStateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                BluetoothSystem_Internal.BluetoothSystemGetScanStateResponseParams response = BluetoothSystem_Internal.BluetoothSystemGetScanStateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.scanState));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BluetoothSystemGetScanStateResponseParamsProxyToResponder implements BluetoothSystem.GetScanStateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BluetoothSystemGetScanStateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer scanState) {
            BluetoothSystem_Internal.BluetoothSystemGetScanStateResponseParams _response = new BluetoothSystem_Internal.BluetoothSystemGetScanStateResponseParams();
            _response.scanState = scanState.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BluetoothSystemStartScanParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BluetoothSystemStartScanParams(int version) {
            super(8, version);
        }

        public BluetoothSystemStartScanParams() {
            this(0);
        }

        public static BluetoothSystemStartScanParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemStartScanParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemStartScanParams decode(Decoder decoder0) {
            BluetoothSystemStartScanParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemStartScanParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BluetoothSystemStartScanResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private BluetoothSystemStartScanResponseParams(int version) {
            super(16, version);
        }

        public BluetoothSystemStartScanResponseParams() {
            this(0);
        }

        public static BluetoothSystemStartScanResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemStartScanResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemStartScanResponseParams decode(Decoder decoder0) {
            BluetoothSystemStartScanResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemStartScanResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                BluetoothSystem.StartScanResult.validate(result.result);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
        }
    }

    static class BluetoothSystemStartScanResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BluetoothSystem.StartScanResponse mCallback;

        BluetoothSystemStartScanResponseParamsForwardToCallback(BluetoothSystem.StartScanResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                BluetoothSystem_Internal.BluetoothSystemStartScanResponseParams response = BluetoothSystem_Internal.BluetoothSystemStartScanResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BluetoothSystemStartScanResponseParamsProxyToResponder implements BluetoothSystem.StartScanResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BluetoothSystemStartScanResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            BluetoothSystem_Internal.BluetoothSystemStartScanResponseParams _response = new BluetoothSystem_Internal.BluetoothSystemStartScanResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BluetoothSystemStopScanParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BluetoothSystemStopScanParams(int version) {
            super(8, version);
        }

        public BluetoothSystemStopScanParams() {
            this(0);
        }

        public static BluetoothSystemStopScanParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemStopScanParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemStopScanParams decode(Decoder decoder0) {
            BluetoothSystemStopScanParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemStopScanParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BluetoothSystemStopScanResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private BluetoothSystemStopScanResponseParams(int version) {
            super(16, version);
        }

        public BluetoothSystemStopScanResponseParams() {
            this(0);
        }

        public static BluetoothSystemStopScanResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemStopScanResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemStopScanResponseParams decode(Decoder decoder0) {
            BluetoothSystemStopScanResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemStopScanResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                BluetoothSystem.StopScanResult.validate(result.result);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
        }
    }

    static class BluetoothSystemStopScanResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BluetoothSystem.StopScanResponse mCallback;

        BluetoothSystemStopScanResponseParamsForwardToCallback(BluetoothSystem.StopScanResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                BluetoothSystem_Internal.BluetoothSystemStopScanResponseParams response = BluetoothSystem_Internal.BluetoothSystemStopScanResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BluetoothSystemStopScanResponseParamsProxyToResponder implements BluetoothSystem.StopScanResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BluetoothSystemStopScanResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            BluetoothSystem_Internal.BluetoothSystemStopScanResponseParams _response = new BluetoothSystem_Internal.BluetoothSystemStopScanResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BluetoothSystemGetAvailableDevicesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BluetoothSystemGetAvailableDevicesParams(int version) {
            super(8, version);
        }

        public BluetoothSystemGetAvailableDevicesParams() {
            this(0);
        }

        public static BluetoothSystemGetAvailableDevicesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemGetAvailableDevicesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemGetAvailableDevicesParams decode(Decoder decoder0) {
            BluetoothSystemGetAvailableDevicesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemGetAvailableDevicesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BluetoothSystemGetAvailableDevicesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BluetoothDeviceInfo[] devices;

        private BluetoothSystemGetAvailableDevicesResponseParams(int version) {
            super(16, version);
        }

        public BluetoothSystemGetAvailableDevicesResponseParams() {
            this(0);
        }

        public static BluetoothSystemGetAvailableDevicesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BluetoothSystemGetAvailableDevicesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BluetoothSystemGetAvailableDevicesResponseParams decode(Decoder decoder0) {
            BluetoothSystemGetAvailableDevicesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BluetoothSystemGetAvailableDevicesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.devices = new BluetoothDeviceInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.devices[i1] = BluetoothDeviceInfo.decode(decoder2);
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

    static class BluetoothSystemGetAvailableDevicesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BluetoothSystem.GetAvailableDevicesResponse mCallback;

        BluetoothSystemGetAvailableDevicesResponseParamsForwardToCallback(BluetoothSystem.GetAvailableDevicesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesResponseParams response = BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.devices);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BluetoothSystemGetAvailableDevicesResponseParamsProxyToResponder implements BluetoothSystem.GetAvailableDevicesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BluetoothSystemGetAvailableDevicesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BluetoothDeviceInfo[] devices) {
            BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesResponseParams _response = new BluetoothSystem_Internal.BluetoothSystemGetAvailableDevicesResponseParams();
            _response.devices = devices;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
