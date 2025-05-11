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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class LockManager_Internal {
    public static final Interface.Manager<LockManager, LockManager.Proxy> MANAGER = new Interface.Manager<LockManager, LockManager.Proxy>() {
        public String getName() {
            return "blink.mojom.LockManager";
        }

        public int getVersion() {
            return 0;
        }

        public LockManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new LockManager_Internal.Proxy(core, messageReceiver);
        }

        public LockManager_Internal.Stub buildStub(Core core, LockManager impl) {
            return new LockManager_Internal.Stub(core, impl);
        }

        public LockManager[] buildArray(int size) {
            return new LockManager[size];
        }
    };

    private static final int REQUEST_LOCK_ORDINAL = 0;

    private static final int QUERY_STATE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements LockManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestLock(String name, int mode, int wait, AssociatedInterfaceNotSupported request) {
            LockManager_Internal.LockManagerRequestLockParams _message = new LockManager_Internal.LockManagerRequestLockParams();
            _message.name = name;
            _message.mode = mode;
            _message.wait = wait;
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void queryState(LockManager.QueryStateResponse callback) {
            LockManager_Internal.LockManagerQueryStateParams _message = new LockManager_Internal.LockManagerQueryStateParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new LockManager_Internal.LockManagerQueryStateResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<LockManager> {
        Stub(Core core, LockManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                LockManager_Internal.LockManagerRequestLockParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(LockManager_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = LockManager_Internal.LockManagerRequestLockParams.deserialize(messageWithHeader.getPayload());
                        ((LockManager)getImpl()).requestLock(data.name, data.mode, data.wait, data.request);
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
                                getCore(), LockManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        LockManager_Internal.LockManagerQueryStateParams.deserialize(messageWithHeader.getPayload());
                        ((LockManager)getImpl()).queryState(new LockManager_Internal.LockManagerQueryStateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class LockManagerRequestLockParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String name;

        public int mode;

        public int wait;

        public AssociatedInterfaceNotSupported request;

        private LockManagerRequestLockParams(int version) {
            super(32, version);
        }

        public LockManagerRequestLockParams() {
            this(0);
        }

        public static LockManagerRequestLockParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LockManagerRequestLockParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LockManagerRequestLockParams decode(Decoder decoder0) {
            LockManagerRequestLockParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LockManagerRequestLockParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
                result.mode = decoder0.readInt(16);
                LockMode.validate(result.mode);
                result.wait = decoder0.readInt(20);
                LockManager.WaitMode.validate(result.wait);
                result.request = decoder0.readAssociatedServiceInterfaceNotSupported(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.name, 8, false);
            encoder0.encode(this.mode, 16);
            encoder0.encode(this.wait, 20);
            encoder0.encode(this.request, 24, false);
        }
    }

    static final class LockManagerQueryStateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private LockManagerQueryStateParams(int version) {
            super(8, version);
        }

        public LockManagerQueryStateParams() {
            this(0);
        }

        public static LockManagerQueryStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LockManagerQueryStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LockManagerQueryStateParams decode(Decoder decoder0) {
            LockManagerQueryStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LockManagerQueryStateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class LockManagerQueryStateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public LockInfo[] requested;

        public LockInfo[] held;

        private LockManagerQueryStateResponseParams(int version) {
            super(24, version);
        }

        public LockManagerQueryStateResponseParams() {
            this(0);
        }

        public static LockManagerQueryStateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static LockManagerQueryStateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static LockManagerQueryStateResponseParams decode(Decoder decoder0) {
            LockManagerQueryStateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new LockManagerQueryStateResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.requested = new LockInfo[si1.elementsOrVersion];
                int i1;
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.requested[i1] = LockInfo.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(16, false);
                si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.held = new LockInfo[si1.elementsOrVersion];
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.held[i1] = LockInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.requested == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.requested.length, 8, -1);
                for (int i0 = 0; i0 < this.requested.length; i0++)
                    encoder1.encode(this.requested[i0], 8 + 8 * i0, false);
            }
            if (this.held == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.held.length, 16, -1);
                for (int i0 = 0; i0 < this.held.length; i0++)
                    encoder1.encode(this.held[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class LockManagerQueryStateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final LockManager.QueryStateResponse mCallback;

        LockManagerQueryStateResponseParamsForwardToCallback(LockManager.QueryStateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                LockManager_Internal.LockManagerQueryStateResponseParams response = LockManager_Internal.LockManagerQueryStateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.requested, response.held);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class LockManagerQueryStateResponseParamsProxyToResponder implements LockManager.QueryStateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        LockManagerQueryStateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(LockInfo[] requested, LockInfo[] held) {
            LockManager_Internal.LockManagerQueryStateResponseParams _response = new LockManager_Internal.LockManagerQueryStateResponseParams();
            _response.requested = requested;
            _response.held = held;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
