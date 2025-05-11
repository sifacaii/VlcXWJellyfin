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

class VibrationManager_Internal {
    public static final Interface.Manager<VibrationManager, VibrationManager.Proxy> MANAGER = new Interface.Manager<VibrationManager, VibrationManager.Proxy>() {
        public String getName() {
            return "device.mojom.VibrationManager";
        }

        public int getVersion() {
            return 0;
        }

        public VibrationManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new VibrationManager_Internal.Proxy(core, messageReceiver);
        }

        public VibrationManager_Internal.Stub buildStub(Core core, VibrationManager impl) {
            return new VibrationManager_Internal.Stub(core, impl);
        }

        public VibrationManager[] buildArray(int size) {
            return new VibrationManager[size];
        }
    };

    private static final int VIBRATE_ORDINAL = 0;

    private static final int CANCEL_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements VibrationManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void vibrate(long milliseconds, VibrationManager.VibrateResponse callback) {
            VibrationManager_Internal.VibrationManagerVibrateParams _message = new VibrationManager_Internal.VibrationManagerVibrateParams();
            _message.milliseconds = milliseconds;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new VibrationManager_Internal.VibrationManagerVibrateResponseParamsForwardToCallback(callback));
        }

        public void cancel(VibrationManager.CancelResponse callback) {
            VibrationManager_Internal.VibrationManagerCancelParams _message = new VibrationManager_Internal.VibrationManagerCancelParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new VibrationManager_Internal.VibrationManagerCancelResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<VibrationManager> {
        Stub(Core core, VibrationManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VibrationManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                VibrationManager_Internal.VibrationManagerVibrateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), VibrationManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = VibrationManager_Internal.VibrationManagerVibrateParams.deserialize(messageWithHeader.getPayload());
                        ((VibrationManager)getImpl()).vibrate(data.milliseconds, new VibrationManager_Internal.VibrationManagerVibrateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        VibrationManager_Internal.VibrationManagerCancelParams.deserialize(messageWithHeader.getPayload());
                        ((VibrationManager)getImpl()).cancel(new VibrationManager_Internal.VibrationManagerCancelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class VibrationManagerVibrateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long milliseconds;

        private VibrationManagerVibrateParams(int version) {
            super(16, version);
        }

        public VibrationManagerVibrateParams() {
            this(0);
        }

        public static VibrationManagerVibrateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VibrationManagerVibrateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VibrationManagerVibrateParams decode(Decoder decoder0) {
            VibrationManagerVibrateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VibrationManagerVibrateParams(elementsOrVersion);
                result.milliseconds = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.milliseconds, 8);
        }
    }

    static final class VibrationManagerVibrateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VibrationManagerVibrateResponseParams(int version) {
            super(8, version);
        }

        public VibrationManagerVibrateResponseParams() {
            this(0);
        }

        public static VibrationManagerVibrateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VibrationManagerVibrateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VibrationManagerVibrateResponseParams decode(Decoder decoder0) {
            VibrationManagerVibrateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VibrationManagerVibrateResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class VibrationManagerVibrateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VibrationManager.VibrateResponse mCallback;

        VibrationManagerVibrateResponseParamsForwardToCallback(VibrationManager.VibrateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VibrationManagerVibrateResponseParamsProxyToResponder implements VibrationManager.VibrateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VibrationManagerVibrateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            VibrationManager_Internal.VibrationManagerVibrateResponseParams _response = new VibrationManager_Internal.VibrationManagerVibrateResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VibrationManagerCancelParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VibrationManagerCancelParams(int version) {
            super(8, version);
        }

        public VibrationManagerCancelParams() {
            this(0);
        }

        public static VibrationManagerCancelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VibrationManagerCancelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VibrationManagerCancelParams decode(Decoder decoder0) {
            VibrationManagerCancelParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VibrationManagerCancelParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VibrationManagerCancelResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VibrationManagerCancelResponseParams(int version) {
            super(8, version);
        }

        public VibrationManagerCancelResponseParams() {
            this(0);
        }

        public static VibrationManagerCancelResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VibrationManagerCancelResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VibrationManagerCancelResponseParams decode(Decoder decoder0) {
            VibrationManagerCancelResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VibrationManagerCancelResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class VibrationManagerCancelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VibrationManager.CancelResponse mCallback;

        VibrationManagerCancelResponseParamsForwardToCallback(VibrationManager.CancelResponse callback) {
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

    static class VibrationManagerCancelResponseParamsProxyToResponder implements VibrationManager.CancelResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VibrationManagerCancelResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            VibrationManager_Internal.VibrationManagerCancelResponseParams _response = new VibrationManager_Internal.VibrationManagerCancelResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
