package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class LockRequest_Internal {
    public static final Interface.Manager<LockRequest, LockRequest.Proxy> MANAGER = new Interface.Manager<LockRequest, LockRequest.Proxy>() {
        public String getName() {
            return "blink.mojom.LockRequest";
        }

        public int getVersion() {
            return 0;
        }

        public LockRequest_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new LockRequest_Internal.Proxy(core, messageReceiver);
        }

        public LockRequest_Internal.Stub buildStub(Core core, LockRequest impl) {
            return new LockRequest_Internal.Stub(core, impl);
        }

        public LockRequest[] buildArray(int size) {
            return new LockRequest[size];
        }
    };

    private static final int GRANTED_ORDINAL = 0;

    private static final int FAILED_ORDINAL = 1;

    private static final int ABORT_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements LockRequest.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void granted(AssociatedInterfaceNotSupported lockHandle) {
            LockRequest_Internal.LockRequestGrantedParams _message = new LockRequest_Internal.LockRequestGrantedParams();
            _message.lockHandle = lockHandle;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void failed() {
            LockRequest_Internal.LockRequestFailedParams _message = new LockRequest_Internal.LockRequestFailedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void abort(String reason) {
            LockRequest_Internal.LockRequestAbortParams _message = new LockRequest_Internal.LockRequestAbortParams();
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<LockRequest> {
        Stub(Core core, LockRequest impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                LockRequest_Internal.LockRequestGrantedParams lockRequestGrantedParams;
                LockRequest_Internal.LockRequestAbortParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(LockRequest_Internal.MANAGER, messageWithHeader);
                    case 0:
                        lockRequestGrantedParams = LockRequest_Internal.LockRequestGrantedParams.deserialize(messageWithHeader.getPayload());
                        ((LockRequest)getImpl()).granted(lockRequestGrantedParams.lockHandle);
                        return true;
                    case 1:
                        LockRequest_Internal.LockRequestFailedParams.deserialize(messageWithHeader.getPayload());
                        ((LockRequest)getImpl()).failed();
                        return true;
                    case 2:
                        data = LockRequest_Internal.LockRequestAbortParams.deserialize(messageWithHeader.getPayload());
                        ((LockRequest)getImpl()).abort(data.reason);
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
                                getCore(), LockRequest_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class LockRequestGrantedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported lockHandle;

        private LockRequestGrantedParams(int version) {
            super(16, version);
        }

        public LockRequestGrantedParams() {
            this(0);
        }

        public static LockRequestGrantedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LockRequestGrantedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LockRequestGrantedParams decode(Decoder decoder0) {
            LockRequestGrantedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LockRequestGrantedParams(elementsOrVersion);
                result.lockHandle = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.lockHandle, 8, false);
        }
    }

    static final class LockRequestFailedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private LockRequestFailedParams(int version) {
            super(8, version);
        }

        public LockRequestFailedParams() {
            this(0);
        }

        public static LockRequestFailedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LockRequestFailedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LockRequestFailedParams decode(Decoder decoder0) {
            LockRequestFailedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LockRequestFailedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class LockRequestAbortParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String reason;

        private LockRequestAbortParams(int version) {
            super(16, version);
        }

        public LockRequestAbortParams() {
            this(0);
        }

        public static LockRequestAbortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LockRequestAbortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LockRequestAbortParams decode(Decoder decoder0) {
            LockRequestAbortParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LockRequestAbortParams(elementsOrVersion);
                result.reason = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reason, 8, false);
        }
    }
}
