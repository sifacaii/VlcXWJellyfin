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

class WakeLockProvider_Internal {
    public static final Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy> MANAGER = new Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy>() {
        public String getName() {
            return "device.mojom.WakeLockProvider";
        }

        public int getVersion() {
            return 0;
        }

        public WakeLockProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WakeLockProvider_Internal.Proxy(core, messageReceiver);
        }

        public WakeLockProvider_Internal.Stub buildStub(Core core, WakeLockProvider impl) {
            return new WakeLockProvider_Internal.Stub(core, impl);
        }

        public WakeLockProvider[] buildArray(int size) {
            return new WakeLockProvider[size];
        }
    };

    private static final int GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL = 0;

    private static final int GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL = 1;

    private static final int NOTIFY_ON_WAKE_LOCK_DEACTIVATION_ORDINAL = 2;

    private static final int GET_ACTIVE_WAKE_LOCKS_FOR_TESTS_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements WakeLockProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getWakeLockContextForId(int contextId, InterfaceRequest<WakeLockContext> context) {
            WakeLockProvider_Internal.WakeLockProviderGetWakeLockContextForIdParams _message = new WakeLockProvider_Internal.WakeLockProviderGetWakeLockContextForIdParams();
            _message.contextId = contextId;
            _message.context = context;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void getWakeLockWithoutContext(int type, int reason, String description, InterfaceRequest<WakeLock> wakeLock) {
            WakeLockProvider_Internal.WakeLockProviderGetWakeLockWithoutContextParams _message = new WakeLockProvider_Internal.WakeLockProviderGetWakeLockWithoutContextParams();
            _message.type = type;
            _message.reason = reason;
            _message.description = description;
            _message.wakeLock = wakeLock;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void notifyOnWakeLockDeactivation(int type, WakeLockObserver observer) {
            WakeLockProvider_Internal.WakeLockProviderNotifyOnWakeLockDeactivationParams _message = new WakeLockProvider_Internal.WakeLockProviderNotifyOnWakeLockDeactivationParams();
            _message.type = type;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void getActiveWakeLocksForTests(int type, WakeLockProvider.GetActiveWakeLocksForTestsResponse callback) {
            WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsParams _message = new WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<WakeLockProvider> {
        Stub(Core core, WakeLockProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WakeLockProvider_Internal.WakeLockProviderGetWakeLockContextForIdParams wakeLockProviderGetWakeLockContextForIdParams;
                WakeLockProvider_Internal.WakeLockProviderGetWakeLockWithoutContextParams wakeLockProviderGetWakeLockWithoutContextParams;
                WakeLockProvider_Internal.WakeLockProviderNotifyOnWakeLockDeactivationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WakeLockProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        wakeLockProviderGetWakeLockContextForIdParams = WakeLockProvider_Internal.WakeLockProviderGetWakeLockContextForIdParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLockProvider)getImpl()).getWakeLockContextForId(wakeLockProviderGetWakeLockContextForIdParams.contextId, wakeLockProviderGetWakeLockContextForIdParams.context);
                        return true;
                    case 1:
                        wakeLockProviderGetWakeLockWithoutContextParams = WakeLockProvider_Internal.WakeLockProviderGetWakeLockWithoutContextParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLockProvider)getImpl()).getWakeLockWithoutContext(wakeLockProviderGetWakeLockWithoutContextParams.type, wakeLockProviderGetWakeLockWithoutContextParams.reason, wakeLockProviderGetWakeLockWithoutContextParams.description, wakeLockProviderGetWakeLockWithoutContextParams.wakeLock);
                        return true;
                    case 2:
                        data = WakeLockProvider_Internal.WakeLockProviderNotifyOnWakeLockDeactivationParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLockProvider)getImpl()).notifyOnWakeLockDeactivation(data.type, data.observer);
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
                WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), WakeLockProvider_Internal.MANAGER, messageWithHeader, receiver);
                    case 3:
                        data = WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLockProvider)getImpl()).getActiveWakeLocksForTests(data.type, new WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WakeLockProviderGetWakeLockContextForIdParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int contextId;

        public InterfaceRequest<WakeLockContext> context;

        private WakeLockProviderGetWakeLockContextForIdParams(int version) {
            super(16, version);
        }

        public WakeLockProviderGetWakeLockContextForIdParams() {
            this(0);
        }

        public static WakeLockProviderGetWakeLockContextForIdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockProviderGetWakeLockContextForIdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockProviderGetWakeLockContextForIdParams decode(Decoder decoder0) {
            WakeLockProviderGetWakeLockContextForIdParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetWakeLockContextForIdParams(elementsOrVersion);
                result.contextId = decoder0.readInt(8);
                result.context = decoder0.readInterfaceRequest(12, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.contextId, 8);
            encoder0.encode(this.context, 12, false);
        }
    }

    static final class WakeLockProviderGetWakeLockWithoutContextParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        public int reason;

        public String description;

        public InterfaceRequest<WakeLock> wakeLock;

        private WakeLockProviderGetWakeLockWithoutContextParams(int version) {
            super(32, version);
        }

        public WakeLockProviderGetWakeLockWithoutContextParams() {
            this(0);
        }

        public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockProviderGetWakeLockWithoutContextParams decode(Decoder decoder0) {
            WakeLockProviderGetWakeLockWithoutContextParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetWakeLockWithoutContextParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                WakeLockType.validate(result.type);
                result.reason = decoder0.readInt(12);
                WakeLockReason.validate(result.reason);
                result.description = decoder0.readString(16, false);
                result.wakeLock = decoder0.readInterfaceRequest(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
            encoder0.encode(this.reason, 12);
            encoder0.encode(this.description, 16, false);
            encoder0.encode(this.wakeLock, 24, false);
        }
    }

    static final class WakeLockProviderNotifyOnWakeLockDeactivationParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        public WakeLockObserver observer;

        private WakeLockProviderNotifyOnWakeLockDeactivationParams(int version) {
            super(24, version);
        }

        public WakeLockProviderNotifyOnWakeLockDeactivationParams() {
            this(0);
        }

        public static WakeLockProviderNotifyOnWakeLockDeactivationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockProviderNotifyOnWakeLockDeactivationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockProviderNotifyOnWakeLockDeactivationParams decode(Decoder decoder0) {
            WakeLockProviderNotifyOnWakeLockDeactivationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderNotifyOnWakeLockDeactivationParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                WakeLockType.validate(result.type);
                result.observer = (WakeLockObserver)decoder0.readServiceInterface(12, false, WakeLockObserver.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
            encoder0.encode(this.observer, 12, false, WakeLockObserver.MANAGER);
        }
    }

    static final class WakeLockProviderGetActiveWakeLocksForTestsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        private WakeLockProviderGetActiveWakeLocksForTestsParams(int version) {
            super(16, version);
        }

        public WakeLockProviderGetActiveWakeLocksForTestsParams() {
            this(0);
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsParams decode(Decoder decoder0) {
            WakeLockProviderGetActiveWakeLocksForTestsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetActiveWakeLocksForTestsParams(elementsOrVersion);
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

    static final class WakeLockProviderGetActiveWakeLocksForTestsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int count;

        private WakeLockProviderGetActiveWakeLocksForTestsResponseParams(int version) {
            super(16, version);
        }

        public WakeLockProviderGetActiveWakeLocksForTestsResponseParams() {
            this(0);
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockProviderGetActiveWakeLocksForTestsResponseParams decode(Decoder decoder0) {
            WakeLockProviderGetActiveWakeLocksForTestsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetActiveWakeLocksForTestsResponseParams(elementsOrVersion);
                result.count = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.count, 8);
        }
    }

    static class WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WakeLockProvider.GetActiveWakeLocksForTestsResponse mCallback;

        WakeLockProviderGetActiveWakeLocksForTestsResponseParamsForwardToCallback(WakeLockProvider.GetActiveWakeLocksForTestsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsResponseParams response = WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.count));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder implements WakeLockProvider.GetActiveWakeLocksForTestsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WakeLockProviderGetActiveWakeLocksForTestsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer count) {
            WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsResponseParams _response = new WakeLockProvider_Internal.WakeLockProviderGetActiveWakeLocksForTestsResponseParams();
            _response.count = count.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
