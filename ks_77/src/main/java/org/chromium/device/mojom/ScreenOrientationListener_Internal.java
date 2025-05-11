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

class ScreenOrientationListener_Internal {
    public static final Interface.Manager<ScreenOrientationListener, ScreenOrientationListener.Proxy> MANAGER = new Interface.Manager<ScreenOrientationListener, ScreenOrientationListener.Proxy>() {
        public String getName() {
            return "device.mojom.ScreenOrientationListener";
        }

        public int getVersion() {
            return 0;
        }

        public ScreenOrientationListener_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ScreenOrientationListener_Internal.Proxy(core, messageReceiver);
        }

        public ScreenOrientationListener_Internal.Stub buildStub(Core core, ScreenOrientationListener impl) {
            return new ScreenOrientationListener_Internal.Stub(core, impl);
        }

        public ScreenOrientationListener[] buildArray(int size) {
            return new ScreenOrientationListener[size];
        }
    };

    private static final int IS_AUTO_ROTATE_ENABLED_BY_USER_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ScreenOrientationListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void isAutoRotateEnabledByUser(ScreenOrientationListener.IsAutoRotateEnabledByUserResponse callback) {
            ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserParams _message = new ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ScreenOrientationListener> {
        Stub(Core core, ScreenOrientationListener impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ScreenOrientationListener_Internal.MANAGER, messageWithHeader);
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
                                getCore(), ScreenOrientationListener_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserParams.deserialize(messageWithHeader.getPayload());
                        ((ScreenOrientationListener)getImpl()).isAutoRotateEnabledByUser(new ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ScreenOrientationListenerIsAutoRotateEnabledByUserParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ScreenOrientationListenerIsAutoRotateEnabledByUserParams(int version) {
            super(8, version);
        }

        public ScreenOrientationListenerIsAutoRotateEnabledByUserParams() {
            this(0);
        }

        public static ScreenOrientationListenerIsAutoRotateEnabledByUserParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ScreenOrientationListenerIsAutoRotateEnabledByUserParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ScreenOrientationListenerIsAutoRotateEnabledByUserParams decode(Decoder decoder0) {
            ScreenOrientationListenerIsAutoRotateEnabledByUserParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ScreenOrientationListenerIsAutoRotateEnabledByUserParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean enabled;

        private ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams(int version) {
            super(16, version);
        }

        public ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams() {
            this(0);
        }

        public static ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams decode(Decoder decoder0) {
            ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams(elementsOrVersion);
                result.enabled = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.enabled, 8, 0);
        }
    }

    static class ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ScreenOrientationListener.IsAutoRotateEnabledByUserResponse mCallback;

        ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsForwardToCallback(ScreenOrientationListener.IsAutoRotateEnabledByUserResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams response = ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.enabled));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsProxyToResponder implements ScreenOrientationListener.IsAutoRotateEnabledByUserResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean enabled) {
            ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams _response = new ScreenOrientationListener_Internal.ScreenOrientationListenerIsAutoRotateEnabledByUserResponseParams();
            _response.enabled = enabled.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
