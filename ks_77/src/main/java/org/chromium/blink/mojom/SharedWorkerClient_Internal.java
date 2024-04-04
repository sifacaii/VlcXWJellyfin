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

class SharedWorkerClient_Internal {
    public static final Interface.Manager<SharedWorkerClient, SharedWorkerClient.Proxy> MANAGER = new Interface.Manager<SharedWorkerClient, SharedWorkerClient.Proxy>() {
        public String getName() {
            return "blink.mojom.SharedWorkerClient";
        }

        public int getVersion() {
            return 0;
        }

        public SharedWorkerClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SharedWorkerClient_Internal.Proxy(core, messageReceiver);
        }

        public SharedWorkerClient_Internal.Stub buildStub(Core core, SharedWorkerClient impl) {
            return new SharedWorkerClient_Internal.Stub(core, impl);
        }

        public SharedWorkerClient[] buildArray(int size) {
            return new SharedWorkerClient[size];
        }
    };

    private static final int ON_CREATED_ORDINAL = 0;

    private static final int ON_CONNECTED_ORDINAL = 1;

    private static final int ON_SCRIPT_LOAD_FAILED_ORDINAL = 2;

    private static final int ON_FEATURE_USED_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements SharedWorkerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onCreated(int creationContextType) {
            SharedWorkerClient_Internal.SharedWorkerClientOnCreatedParams _message = new SharedWorkerClient_Internal.SharedWorkerClientOnCreatedParams();
            _message.creationContextType = creationContextType;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onConnected(int[] featuresUsed) {
            SharedWorkerClient_Internal.SharedWorkerClientOnConnectedParams _message = new SharedWorkerClient_Internal.SharedWorkerClientOnConnectedParams();
            _message.featuresUsed = featuresUsed;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onScriptLoadFailed() {
            SharedWorkerClient_Internal.SharedWorkerClientOnScriptLoadFailedParams _message = new SharedWorkerClient_Internal.SharedWorkerClientOnScriptLoadFailedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onFeatureUsed(int feature) {
            SharedWorkerClient_Internal.SharedWorkerClientOnFeatureUsedParams _message = new SharedWorkerClient_Internal.SharedWorkerClientOnFeatureUsedParams();
            _message.feature = feature;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<SharedWorkerClient> {
        Stub(Core core, SharedWorkerClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SharedWorkerClient_Internal.SharedWorkerClientOnCreatedParams sharedWorkerClientOnCreatedParams;
                SharedWorkerClient_Internal.SharedWorkerClientOnConnectedParams sharedWorkerClientOnConnectedParams;
                SharedWorkerClient_Internal.SharedWorkerClientOnFeatureUsedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SharedWorkerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        sharedWorkerClientOnCreatedParams = SharedWorkerClient_Internal.SharedWorkerClientOnCreatedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerClient)getImpl()).onCreated(sharedWorkerClientOnCreatedParams.creationContextType);
                        return true;
                    case 1:
                        sharedWorkerClientOnConnectedParams = SharedWorkerClient_Internal.SharedWorkerClientOnConnectedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerClient)getImpl()).onConnected(sharedWorkerClientOnConnectedParams.featuresUsed);
                        return true;
                    case 2:
                        SharedWorkerClient_Internal.SharedWorkerClientOnScriptLoadFailedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerClient)getImpl()).onScriptLoadFailed();
                        return true;
                    case 3:
                        data = SharedWorkerClient_Internal.SharedWorkerClientOnFeatureUsedParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerClient)getImpl()).onFeatureUsed(data.feature);
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
                                getCore(), SharedWorkerClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SharedWorkerClientOnCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int creationContextType;

        private SharedWorkerClientOnCreatedParams(int version) {
            super(16, version);
        }

        public SharedWorkerClientOnCreatedParams() {
            this(0);
        }

        public static SharedWorkerClientOnCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerClientOnCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerClientOnCreatedParams decode(Decoder decoder0) {
            SharedWorkerClientOnCreatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerClientOnCreatedParams(elementsOrVersion);
                result.creationContextType = decoder0.readInt(8);
                SharedWorkerCreationContextType.validate(result.creationContextType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.creationContextType, 8);
        }
    }

    static final class SharedWorkerClientOnConnectedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int[] featuresUsed;

        private SharedWorkerClientOnConnectedParams(int version) {
            super(16, version);
        }

        public SharedWorkerClientOnConnectedParams() {
            this(0);
        }

        public static SharedWorkerClientOnConnectedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerClientOnConnectedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerClientOnConnectedParams decode(Decoder decoder0) {
            SharedWorkerClientOnConnectedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerClientOnConnectedParams(elementsOrVersion);
                result.featuresUsed = decoder0.readInts(8, 0, -1);
                for (int i0 = 0; i0 < result.featuresUsed.length; i0++)
                    WebFeature.validate(result.featuresUsed[i0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.featuresUsed, 8, 0, -1);
        }
    }

    static final class SharedWorkerClientOnScriptLoadFailedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SharedWorkerClientOnScriptLoadFailedParams(int version) {
            super(8, version);
        }

        public SharedWorkerClientOnScriptLoadFailedParams() {
            this(0);
        }

        public static SharedWorkerClientOnScriptLoadFailedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerClientOnScriptLoadFailedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerClientOnScriptLoadFailedParams decode(Decoder decoder0) {
            SharedWorkerClientOnScriptLoadFailedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerClientOnScriptLoadFailedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SharedWorkerClientOnFeatureUsedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int feature;

        private SharedWorkerClientOnFeatureUsedParams(int version) {
            super(16, version);
        }

        public SharedWorkerClientOnFeatureUsedParams() {
            this(0);
        }

        public static SharedWorkerClientOnFeatureUsedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerClientOnFeatureUsedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerClientOnFeatureUsedParams decode(Decoder decoder0) {
            SharedWorkerClientOnFeatureUsedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerClientOnFeatureUsedParams(elementsOrVersion);
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
