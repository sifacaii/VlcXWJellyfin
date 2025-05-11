package org.chromium.media.mojom;

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

class AndroidOverlayClient_Internal {
    public static final Interface.Manager<AndroidOverlayClient, AndroidOverlayClient.Proxy> MANAGER = new Interface.Manager<AndroidOverlayClient, AndroidOverlayClient.Proxy>() {
        public String getName() {
            return "media.mojom.AndroidOverlayClient";
        }

        public int getVersion() {
            return 0;
        }

        public AndroidOverlayClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AndroidOverlayClient_Internal.Proxy(core, messageReceiver);
        }

        public AndroidOverlayClient_Internal.Stub buildStub(Core core, AndroidOverlayClient impl) {
            return new AndroidOverlayClient_Internal.Stub(core, impl);
        }

        public AndroidOverlayClient[] buildArray(int size) {
            return new AndroidOverlayClient[size];
        }
    };

    private static final int ON_SURFACE_READY_ORDINAL = 0;

    private static final int ON_DESTROYED_ORDINAL = 1;

    private static final int ON_POWER_EFFICIENT_STATE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements AndroidOverlayClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onSurfaceReady(long surfaceKey) {
            AndroidOverlayClient_Internal.AndroidOverlayClientOnSurfaceReadyParams _message = new AndroidOverlayClient_Internal.AndroidOverlayClientOnSurfaceReadyParams();
            _message.surfaceKey = surfaceKey;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onDestroyed() {
            AndroidOverlayClient_Internal.AndroidOverlayClientOnDestroyedParams _message = new AndroidOverlayClient_Internal.AndroidOverlayClientOnDestroyedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onPowerEfficientState(boolean isPowerEfficient) {
            AndroidOverlayClient_Internal.AndroidOverlayClientOnPowerEfficientStateParams _message = new AndroidOverlayClient_Internal.AndroidOverlayClientOnPowerEfficientStateParams();
            _message.isPowerEfficient = isPowerEfficient;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<AndroidOverlayClient> {
        Stub(Core core, AndroidOverlayClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AndroidOverlayClient_Internal.AndroidOverlayClientOnSurfaceReadyParams androidOverlayClientOnSurfaceReadyParams;
                AndroidOverlayClient_Internal.AndroidOverlayClientOnPowerEfficientStateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AndroidOverlayClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        androidOverlayClientOnSurfaceReadyParams = AndroidOverlayClient_Internal.AndroidOverlayClientOnSurfaceReadyParams.deserialize(messageWithHeader.getPayload());
                        ((AndroidOverlayClient)getImpl()).onSurfaceReady(androidOverlayClientOnSurfaceReadyParams.surfaceKey);
                        return true;
                    case 1:
                        AndroidOverlayClient_Internal.AndroidOverlayClientOnDestroyedParams.deserialize(messageWithHeader.getPayload());
                        ((AndroidOverlayClient)getImpl()).onDestroyed();
                        return true;
                    case 2:
                        data = AndroidOverlayClient_Internal.AndroidOverlayClientOnPowerEfficientStateParams.deserialize(messageWithHeader.getPayload());
                        ((AndroidOverlayClient)getImpl()).onPowerEfficientState(data.isPowerEfficient);
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
                                getCore(), AndroidOverlayClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AndroidOverlayClientOnSurfaceReadyParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long surfaceKey;

        private AndroidOverlayClientOnSurfaceReadyParams(int version) {
            super(16, version);
        }

        public AndroidOverlayClientOnSurfaceReadyParams() {
            this(0);
        }

        public static AndroidOverlayClientOnSurfaceReadyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AndroidOverlayClientOnSurfaceReadyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AndroidOverlayClientOnSurfaceReadyParams decode(Decoder decoder0) {
            AndroidOverlayClientOnSurfaceReadyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AndroidOverlayClientOnSurfaceReadyParams(elementsOrVersion);
                result.surfaceKey = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.surfaceKey, 8);
        }
    }

    static final class AndroidOverlayClientOnDestroyedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AndroidOverlayClientOnDestroyedParams(int version) {
            super(8, version);
        }

        public AndroidOverlayClientOnDestroyedParams() {
            this(0);
        }

        public static AndroidOverlayClientOnDestroyedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AndroidOverlayClientOnDestroyedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AndroidOverlayClientOnDestroyedParams decode(Decoder decoder0) {
            AndroidOverlayClientOnDestroyedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AndroidOverlayClientOnDestroyedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AndroidOverlayClientOnPowerEfficientStateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean isPowerEfficient;

        private AndroidOverlayClientOnPowerEfficientStateParams(int version) {
            super(16, version);
        }

        public AndroidOverlayClientOnPowerEfficientStateParams() {
            this(0);
        }

        public static AndroidOverlayClientOnPowerEfficientStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AndroidOverlayClientOnPowerEfficientStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AndroidOverlayClientOnPowerEfficientStateParams decode(Decoder decoder0) {
            AndroidOverlayClientOnPowerEfficientStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AndroidOverlayClientOnPowerEfficientStateParams(elementsOrVersion);
                result.isPowerEfficient = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.isPowerEfficient, 8, 0);
        }
    }
}
