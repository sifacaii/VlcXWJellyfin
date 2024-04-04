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

class ScreenOrientation_Internal {
    public static final Interface.Manager<ScreenOrientation, ScreenOrientation.Proxy> MANAGER = new Interface.Manager<ScreenOrientation, ScreenOrientation.Proxy>() {
        public String getName() {
            return "device.mojom.ScreenOrientation";
        }

        public int getVersion() {
            return 0;
        }

        public ScreenOrientation_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ScreenOrientation_Internal.Proxy(core, messageReceiver);
        }

        public ScreenOrientation_Internal.Stub buildStub(Core core, ScreenOrientation impl) {
            return new ScreenOrientation_Internal.Stub(core, impl);
        }

        public ScreenOrientation[] buildArray(int size) {
            return new ScreenOrientation[size];
        }
    };

    private static final int LOCK_ORIENTATION_ORDINAL = 0;

    private static final int UNLOCK_ORIENTATION_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements ScreenOrientation.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void lockOrientation(int orientation, ScreenOrientation.LockOrientationResponse callback) {
            ScreenOrientation_Internal.ScreenOrientationLockOrientationParams _message = new ScreenOrientation_Internal.ScreenOrientationLockOrientationParams();
            _message.orientation = orientation;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ScreenOrientation_Internal.ScreenOrientationLockOrientationResponseParamsForwardToCallback(callback));
        }

        public void unlockOrientation() {
            ScreenOrientation_Internal.ScreenOrientationUnlockOrientationParams _message = new ScreenOrientation_Internal.ScreenOrientationUnlockOrientationParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<ScreenOrientation> {
        Stub(Core core, ScreenOrientation impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ScreenOrientation_Internal.MANAGER, messageWithHeader);
                    case 1:
                        ScreenOrientation_Internal.ScreenOrientationUnlockOrientationParams.deserialize(messageWithHeader.getPayload());
                        ((ScreenOrientation)getImpl()).unlockOrientation();
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
                ScreenOrientation_Internal.ScreenOrientationLockOrientationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ScreenOrientation_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = ScreenOrientation_Internal.ScreenOrientationLockOrientationParams.deserialize(messageWithHeader.getPayload());
                        ((ScreenOrientation)getImpl()).lockOrientation(data.orientation, new ScreenOrientation_Internal.ScreenOrientationLockOrientationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ScreenOrientationLockOrientationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int orientation;

        private ScreenOrientationLockOrientationParams(int version) {
            super(16, version);
        }

        public ScreenOrientationLockOrientationParams() {
            this(0);
        }

        public static ScreenOrientationLockOrientationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ScreenOrientationLockOrientationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ScreenOrientationLockOrientationParams decode(Decoder decoder0) {
            ScreenOrientationLockOrientationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ScreenOrientationLockOrientationParams(elementsOrVersion);
                result.orientation = decoder0.readInt(8);
                ScreenOrientationLockType.validate(result.orientation);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.orientation, 8);
        }
    }

    static final class ScreenOrientationLockOrientationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        private ScreenOrientationLockOrientationResponseParams(int version) {
            super(16, version);
        }

        public ScreenOrientationLockOrientationResponseParams() {
            this(0);
        }

        public static ScreenOrientationLockOrientationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ScreenOrientationLockOrientationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ScreenOrientationLockOrientationResponseParams decode(Decoder decoder0) {
            ScreenOrientationLockOrientationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ScreenOrientationLockOrientationResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                ScreenOrientationLockResult.validate(result.result);
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

    static class ScreenOrientationLockOrientationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ScreenOrientation.LockOrientationResponse mCallback;

        ScreenOrientationLockOrientationResponseParamsForwardToCallback(ScreenOrientation.LockOrientationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ScreenOrientation_Internal.ScreenOrientationLockOrientationResponseParams response = ScreenOrientation_Internal.ScreenOrientationLockOrientationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ScreenOrientationLockOrientationResponseParamsProxyToResponder implements ScreenOrientation.LockOrientationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ScreenOrientationLockOrientationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result) {
            ScreenOrientation_Internal.ScreenOrientationLockOrientationResponseParams _response = new ScreenOrientation_Internal.ScreenOrientationLockOrientationResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ScreenOrientationUnlockOrientationParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ScreenOrientationUnlockOrientationParams(int version) {
            super(8, version);
        }

        public ScreenOrientationUnlockOrientationParams() {
            this(0);
        }

        public static ScreenOrientationUnlockOrientationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ScreenOrientationUnlockOrientationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ScreenOrientationUnlockOrientationParams decode(Decoder decoder0) {
            ScreenOrientationUnlockOrientationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ScreenOrientationUnlockOrientationParams(elementsOrVersion);
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
