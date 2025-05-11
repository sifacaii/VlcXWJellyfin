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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class LeakDetector_Internal {
    public static final Interface.Manager<LeakDetector, LeakDetector.Proxy> MANAGER = new Interface.Manager<LeakDetector, LeakDetector.Proxy>() {
        public String getName() {
            return "blink.mojom.LeakDetector";
        }

        public int getVersion() {
            return 0;
        }

        public LeakDetector_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new LeakDetector_Internal.Proxy(core, messageReceiver);
        }

        public LeakDetector_Internal.Stub buildStub(Core core, LeakDetector impl) {
            return new LeakDetector_Internal.Stub(core, impl);
        }

        public LeakDetector[] buildArray(int size) {
            return new LeakDetector[size];
        }
    };

    private static final int PERFORM_LEAK_DETECTION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements LeakDetector.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void performLeakDetection(LeakDetector.PerformLeakDetectionResponse callback) {
            LeakDetector_Internal.LeakDetectorPerformLeakDetectionParams _message = new LeakDetector_Internal.LeakDetectorPerformLeakDetectionParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new LeakDetector_Internal.LeakDetectorPerformLeakDetectionResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<LeakDetector> {
        Stub(Core core, LeakDetector impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(LeakDetector_Internal.MANAGER, messageWithHeader);
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
                                getCore(), LeakDetector_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        LeakDetector_Internal.LeakDetectorPerformLeakDetectionParams.deserialize(messageWithHeader.getPayload());
                        ((LeakDetector)getImpl()).performLeakDetection(new LeakDetector_Internal.LeakDetectorPerformLeakDetectionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class LeakDetectorPerformLeakDetectionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private LeakDetectorPerformLeakDetectionParams(int version) {
            super(8, version);
        }

        public LeakDetectorPerformLeakDetectionParams() {
            this(0);
        }

        public static LeakDetectorPerformLeakDetectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LeakDetectorPerformLeakDetectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LeakDetectorPerformLeakDetectionParams decode(Decoder decoder0) {
            LeakDetectorPerformLeakDetectionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LeakDetectorPerformLeakDetectionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class LeakDetectorPerformLeakDetectionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public LeakDetectionResult result;

        private LeakDetectorPerformLeakDetectionResponseParams(int version) {
            super(16, version);
        }

        public LeakDetectorPerformLeakDetectionResponseParams() {
            this(0);
        }

        public static LeakDetectorPerformLeakDetectionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LeakDetectorPerformLeakDetectionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LeakDetectorPerformLeakDetectionResponseParams decode(Decoder decoder0) {
            LeakDetectorPerformLeakDetectionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LeakDetectorPerformLeakDetectionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = LeakDetectionResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class LeakDetectorPerformLeakDetectionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final LeakDetector.PerformLeakDetectionResponse mCallback;

        LeakDetectorPerformLeakDetectionResponseParamsForwardToCallback(LeakDetector.PerformLeakDetectionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                LeakDetector_Internal.LeakDetectorPerformLeakDetectionResponseParams response = LeakDetector_Internal.LeakDetectorPerformLeakDetectionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class LeakDetectorPerformLeakDetectionResponseParamsProxyToResponder implements LeakDetector.PerformLeakDetectionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        LeakDetectorPerformLeakDetectionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(LeakDetectionResult result) {
            LeakDetector_Internal.LeakDetectorPerformLeakDetectionResponseParams _response = new LeakDetector_Internal.LeakDetectorPerformLeakDetectionResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
