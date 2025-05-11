package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WakeLock_Internal {
    public static final Interface.Manager<WakeLock, WakeLock.Proxy> MANAGER = new Interface.Manager<WakeLock, WakeLock.Proxy>() {
        public String getName() {
            return "device.mojom.WakeLock";
        }

        public int getVersion() {
            return 0;
        }

        public WakeLock_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WakeLock_Internal.Proxy(core, messageReceiver);
        }

        public WakeLock_Internal.Stub buildStub(Core core, WakeLock impl) {
            return new WakeLock_Internal.Stub(core, impl);
        }

        public WakeLock[] buildArray(int size) {
            return new WakeLock[size];
        }
    };

    private static final int REQUEST_WAKE_LOCK_ORDINAL = 0;

    private static final int CANCEL_WAKE_LOCK_ORDINAL = 1;

    private static final int ADD_CLIENT_ORDINAL = 2;

    private static final int CHANGE_TYPE_ORDINAL = 3;

    private static final int HAS_WAKE_LOCK_FOR_TESTS_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements WakeLock.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestWakeLock() {
            WakeLock_Internal.WakeLockRequestWakeLockParams _message = new WakeLock_Internal.WakeLockRequestWakeLockParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void cancelWakeLock() {
            WakeLock_Internal.WakeLockCancelWakeLockParams _message = new WakeLock_Internal.WakeLockCancelWakeLockParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void addClient(InterfaceRequest<WakeLock> wakeLock) {
            WakeLock_Internal.WakeLockAddClientParams _message = new WakeLock_Internal.WakeLockAddClientParams();
            _message.wakeLock = wakeLock;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void changeType(int type, WakeLock.ChangeTypeResponse callback) {
            WakeLock_Internal.WakeLockChangeTypeParams _message = new WakeLock_Internal.WakeLockChangeTypeParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new WakeLock_Internal.WakeLockChangeTypeResponseParamsForwardToCallback(callback));
        }

        public void hasWakeLockForTests(WakeLock.HasWakeLockForTestsResponse callback) {
            WakeLock_Internal.WakeLockHasWakeLockForTestsParams _message = new WakeLock_Internal.WakeLockHasWakeLockForTestsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new WakeLock_Internal.WakeLockHasWakeLockForTestsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<WakeLock> {
        Stub(Core core, WakeLock impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WakeLock_Internal.WakeLockAddClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WakeLock_Internal.MANAGER, messageWithHeader);
                    case 0:
                        WakeLock_Internal.WakeLockRequestWakeLockParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLock)getImpl()).requestWakeLock();
                        return true;
                    case 1:
                        WakeLock_Internal.WakeLockCancelWakeLockParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLock)getImpl()).cancelWakeLock();
                        return true;
                    case 2:
                        data = WakeLock_Internal.WakeLockAddClientParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLock)getImpl()).addClient(data.wakeLock);
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
                WakeLock_Internal.WakeLockChangeTypeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), WakeLock_Internal.MANAGER, messageWithHeader, receiver);
                    case 3:
                        data = WakeLock_Internal.WakeLockChangeTypeParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLock)getImpl()).changeType(data.type, new WakeLock_Internal.WakeLockChangeTypeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        WakeLock_Internal.WakeLockHasWakeLockForTestsParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLock)getImpl()).hasWakeLockForTests(new WakeLock_Internal.WakeLockHasWakeLockForTestsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WakeLockRequestWakeLockParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WakeLockRequestWakeLockParams(int version) {
            super(8, version);
        }

        public WakeLockRequestWakeLockParams() {
            this(0);
        }

        public static WakeLockRequestWakeLockParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockRequestWakeLockParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockRequestWakeLockParams decode(Decoder decoder0) {
            WakeLockRequestWakeLockParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockRequestWakeLockParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WakeLockCancelWakeLockParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WakeLockCancelWakeLockParams(int version) {
            super(8, version);
        }

        public WakeLockCancelWakeLockParams() {
            this(0);
        }

        public static WakeLockCancelWakeLockParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockCancelWakeLockParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockCancelWakeLockParams decode(Decoder decoder0) {
            WakeLockCancelWakeLockParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockCancelWakeLockParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WakeLockAddClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<WakeLock> wakeLock;

        private WakeLockAddClientParams(int version) {
            super(16, version);
        }

        public WakeLockAddClientParams() {
            this(0);
        }

        public static WakeLockAddClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockAddClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockAddClientParams decode(Decoder decoder0) {
            WakeLockAddClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockAddClientParams(elementsOrVersion);
                result.wakeLock = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.wakeLock, 8, false);
        }
    }

    static final class WakeLockChangeTypeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        private WakeLockChangeTypeParams(int version) {
            super(16, version);
        }

        public WakeLockChangeTypeParams() {
            this(0);
        }

        public static WakeLockChangeTypeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockChangeTypeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockChangeTypeParams decode(Decoder decoder0) {
            WakeLockChangeTypeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockChangeTypeParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                WakeLockType.validate(result.type);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
        }
    }

    static final class WakeLockChangeTypeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean result;

        private WakeLockChangeTypeResponseParams(int version) {
            super(16, version);
        }

        public WakeLockChangeTypeResponseParams() {
            this(0);
        }

        public static WakeLockChangeTypeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockChangeTypeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockChangeTypeResponseParams decode(Decoder decoder0) {
            WakeLockChangeTypeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockChangeTypeResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, 0);
        }
    }

    static class WakeLockChangeTypeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WakeLock.ChangeTypeResponse mCallback;

        WakeLockChangeTypeResponseParamsForwardToCallback(WakeLock.ChangeTypeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                WakeLock_Internal.WakeLockChangeTypeResponseParams response = WakeLock_Internal.WakeLockChangeTypeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WakeLockChangeTypeResponseParamsProxyToResponder implements WakeLock.ChangeTypeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WakeLockChangeTypeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean result) {
            WakeLock_Internal.WakeLockChangeTypeResponseParams _response = new WakeLock_Internal.WakeLockChangeTypeResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WakeLockHasWakeLockForTestsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private WakeLockHasWakeLockForTestsParams(int version) {
            super(8, version);
        }

        public WakeLockHasWakeLockForTestsParams() {
            this(0);
        }

        public static WakeLockHasWakeLockForTestsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockHasWakeLockForTestsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockHasWakeLockForTestsParams decode(Decoder decoder0) {
            WakeLockHasWakeLockForTestsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockHasWakeLockForTestsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class WakeLockHasWakeLockForTestsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean result;

        private WakeLockHasWakeLockForTestsResponseParams(int version) {
            super(16, version);
        }

        public WakeLockHasWakeLockForTestsResponseParams() {
            this(0);
        }

        public static WakeLockHasWakeLockForTestsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockHasWakeLockForTestsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockHasWakeLockForTestsResponseParams decode(Decoder decoder0) {
            WakeLockHasWakeLockForTestsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockHasWakeLockForTestsResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, 0);
        }
    }

    static class WakeLockHasWakeLockForTestsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WakeLock.HasWakeLockForTestsResponse mCallback;

        WakeLockHasWakeLockForTestsResponseParamsForwardToCallback(WakeLock.HasWakeLockForTestsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                WakeLock_Internal.WakeLockHasWakeLockForTestsResponseParams response = WakeLock_Internal.WakeLockHasWakeLockForTestsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WakeLockHasWakeLockForTestsResponseParamsProxyToResponder implements WakeLock.HasWakeLockForTestsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WakeLockHasWakeLockForTestsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean result) {
            WakeLock_Internal.WakeLockHasWakeLockForTestsResponseParams _response = new WakeLock_Internal.WakeLockHasWakeLockForTestsResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
