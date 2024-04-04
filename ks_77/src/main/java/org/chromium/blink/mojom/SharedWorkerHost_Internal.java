package org.chromium.blink.mojom;

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

class SharedWorkerHost_Internal {
    public static final Interface.Manager<SharedWorkerHost, SharedWorkerHost.Proxy> MANAGER = new Interface.Manager<SharedWorkerHost, SharedWorkerHost.Proxy>() {
        public String getName() {
            return "blink.mojom.SharedWorkerHost";
        }

        public int getVersion() {
            return 0;
        }

        public SharedWorkerHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SharedWorkerHost_Internal.Proxy(core, messageReceiver);
        }

        public SharedWorkerHost_Internal.Stub buildStub(Core core, SharedWorkerHost impl) {
            return new SharedWorkerHost_Internal.Stub(core, impl);
        }

        public SharedWorkerHost[] buildArray(int size) {
            return new SharedWorkerHost[size];
        }
    };

    private static final int ON_CONNECTED_ORDINAL = 0;

    private static final int ON_CONTEXT_CLOSED_ORDINAL = 1;

    private static final int ON_READY_FOR_INSPECTION_ORDINAL = 2;

    private static final int ON_SCRIPT_LOAD_FAILED_ORDINAL = 3;

    private static final int ON_FEATURE_USED_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements SharedWorkerHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onConnected(int connectionId) {
            SharedWorkerHost_Internal.SharedWorkerHostOnConnectedParams _message = new SharedWorkerHost_Internal.SharedWorkerHostOnConnectedParams();
            _message.connectionId = connectionId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onContextClosed() {
            SharedWorkerHost_Internal.SharedWorkerHostOnContextClosedParams _message = new SharedWorkerHost_Internal.SharedWorkerHostOnContextClosedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onReadyForInspection() {
            SharedWorkerHost_Internal.SharedWorkerHostOnReadyForInspectionParams _message = new SharedWorkerHost_Internal.SharedWorkerHostOnReadyForInspectionParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onScriptLoadFailed() {
            SharedWorkerHost_Internal.SharedWorkerHostOnScriptLoadFailedParams _message = new SharedWorkerHost_Internal.SharedWorkerHostOnScriptLoadFailedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void onFeatureUsed(int feature) {
            SharedWorkerHost_Internal.SharedWorkerHostOnFeatureUsedParams _message = new SharedWorkerHost_Internal.SharedWorkerHostOnFeatureUsedParams();
            _message.feature = feature;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<SharedWorkerHost> {
        Stub(Core core, SharedWorkerHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SharedWorkerHost_Internal.SharedWorkerHostOnConnectedParams sharedWorkerHostOnConnectedParams;
                SharedWorkerHost_Internal.SharedWorkerHostOnFeatureUsedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SharedWorkerHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        sharedWorkerHostOnConnectedParams = SharedWorkerHost_Internal.SharedWorkerHostOnConnectedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerHost)getImpl()).onConnected(sharedWorkerHostOnConnectedParams.connectionId);
                        return true;
                    case 1:
                        SharedWorkerHost_Internal.SharedWorkerHostOnContextClosedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerHost)getImpl()).onContextClosed();
                        return true;
                    case 2:
                        SharedWorkerHost_Internal.SharedWorkerHostOnReadyForInspectionParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerHost)getImpl()).onReadyForInspection();
                        return true;
                    case 3:
                        SharedWorkerHost_Internal.SharedWorkerHostOnScriptLoadFailedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerHost)getImpl()).onScriptLoadFailed();
                        return true;
                    case 4:
                        data = SharedWorkerHost_Internal.SharedWorkerHostOnFeatureUsedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerHost)getImpl()).onFeatureUsed(data.feature);
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
                                getCore(), SharedWorkerHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SharedWorkerHostOnConnectedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int connectionId;

        private SharedWorkerHostOnConnectedParams(int version) {
            super(16, version);
        }

        public SharedWorkerHostOnConnectedParams() {
            this(0);
        }

        public static SharedWorkerHostOnConnectedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerHostOnConnectedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerHostOnConnectedParams decode(Decoder decoder0) {
            SharedWorkerHostOnConnectedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerHostOnConnectedParams(elementsOrVersion);
                result.connectionId = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.connectionId, 8);
        }
    }

    static final class SharedWorkerHostOnContextClosedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SharedWorkerHostOnContextClosedParams(int version) {
            super(8, version);
        }

        public SharedWorkerHostOnContextClosedParams() {
            this(0);
        }

        public static SharedWorkerHostOnContextClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerHostOnContextClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerHostOnContextClosedParams decode(Decoder decoder0) {
            SharedWorkerHostOnContextClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerHostOnContextClosedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SharedWorkerHostOnReadyForInspectionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SharedWorkerHostOnReadyForInspectionParams(int version) {
            super(8, version);
        }

        public SharedWorkerHostOnReadyForInspectionParams() {
            this(0);
        }

        public static SharedWorkerHostOnReadyForInspectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerHostOnReadyForInspectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerHostOnReadyForInspectionParams decode(Decoder decoder0) {
            SharedWorkerHostOnReadyForInspectionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerHostOnReadyForInspectionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SharedWorkerHostOnScriptLoadFailedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SharedWorkerHostOnScriptLoadFailedParams(int version) {
            super(8, version);
        }

        public SharedWorkerHostOnScriptLoadFailedParams() {
            this(0);
        }

        public static SharedWorkerHostOnScriptLoadFailedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerHostOnScriptLoadFailedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerHostOnScriptLoadFailedParams decode(Decoder decoder0) {
            SharedWorkerHostOnScriptLoadFailedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerHostOnScriptLoadFailedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SharedWorkerHostOnFeatureUsedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int feature;

        private SharedWorkerHostOnFeatureUsedParams(int version) {
            super(16, version);
        }

        public SharedWorkerHostOnFeatureUsedParams() {
            this(0);
        }

        public static SharedWorkerHostOnFeatureUsedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerHostOnFeatureUsedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerHostOnFeatureUsedParams decode(Decoder decoder0) {
            SharedWorkerHostOnFeatureUsedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerHostOnFeatureUsedParams(elementsOrVersion);
                result.feature = decoder0.readInt(8);
                WebFeature.validate(result.feature);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.feature, 8);
        }
    }
}
