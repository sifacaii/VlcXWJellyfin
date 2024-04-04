package org.chromium.blink.test.mojom;

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

class VirtualAuthenticatorManager_Internal {
    public static final Interface.Manager<VirtualAuthenticatorManager, VirtualAuthenticatorManager.Proxy> MANAGER = new Interface.Manager<VirtualAuthenticatorManager, VirtualAuthenticatorManager.Proxy>() {
        public String getName() {
            return "blink.test.mojom.VirtualAuthenticatorManager";
        }

        public int getVersion() {
            return 0;
        }

        public VirtualAuthenticatorManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new VirtualAuthenticatorManager_Internal.Proxy(core, messageReceiver);
        }

        public VirtualAuthenticatorManager_Internal.Stub buildStub(Core core, VirtualAuthenticatorManager impl) {
            return new VirtualAuthenticatorManager_Internal.Stub(core, impl);
        }

        public VirtualAuthenticatorManager[] buildArray(int size) {
            return new VirtualAuthenticatorManager[size];
        }
    };

    private static final int CREATE_AUTHENTICATOR_ORDINAL = 0;

    private static final int GET_AUTHENTICATORS_ORDINAL = 1;

    private static final int REMOVE_AUTHENTICATOR_ORDINAL = 2;

    private static final int CLEAR_AUTHENTICATORS_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements VirtualAuthenticatorManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createAuthenticator(VirtualAuthenticatorOptions options, VirtualAuthenticatorManager.CreateAuthenticatorResponse callback) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorParams _message = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsForwardToCallback(callback));
        }

        public void getAuthenticators(VirtualAuthenticatorManager.GetAuthenticatorsResponse callback) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsParams _message = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsForwardToCallback(callback));
        }

        public void removeAuthenticator(String id, VirtualAuthenticatorManager.RemoveAuthenticatorResponse callback) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorParams _message = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsForwardToCallback(callback));
        }

        public void clearAuthenticators(VirtualAuthenticatorManager.ClearAuthenticatorsResponse callback) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsParams _message = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<VirtualAuthenticatorManager> {
        Stub(Core core, VirtualAuthenticatorManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VirtualAuthenticatorManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorParams virtualAuthenticatorManagerCreateAuthenticatorParams;
                VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), VirtualAuthenticatorManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        virtualAuthenticatorManagerCreateAuthenticatorParams = VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticatorManager)getImpl()).createAuthenticator(virtualAuthenticatorManagerCreateAuthenticatorParams.options, new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticatorManager)getImpl()).getAuthenticators(new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticatorManager)getImpl()).removeAuthenticator(data.id, new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticatorManager)getImpl()).clearAuthenticators(new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class VirtualAuthenticatorManagerCreateAuthenticatorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VirtualAuthenticatorOptions options;

        private VirtualAuthenticatorManagerCreateAuthenticatorParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorManagerCreateAuthenticatorParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerCreateAuthenticatorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerCreateAuthenticatorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerCreateAuthenticatorParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerCreateAuthenticatorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerCreateAuthenticatorParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = VirtualAuthenticatorOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, false);
        }
    }

    static final class VirtualAuthenticatorManagerCreateAuthenticatorResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VirtualAuthenticator authenticator;

        private VirtualAuthenticatorManagerCreateAuthenticatorResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorManagerCreateAuthenticatorResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerCreateAuthenticatorResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerCreateAuthenticatorResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerCreateAuthenticatorResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerCreateAuthenticatorResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerCreateAuthenticatorResponseParams(elementsOrVersion);
                result.authenticator = (VirtualAuthenticator)decoder0.readServiceInterface(8, false, VirtualAuthenticator.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.authenticator, 8, false, VirtualAuthenticator.MANAGER);
        }
    }

    static class VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticatorManager.CreateAuthenticatorResponse mCallback;

        VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsForwardToCallback(VirtualAuthenticatorManager.CreateAuthenticatorResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorResponseParams response = VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.authenticator);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsProxyToResponder implements VirtualAuthenticatorManager.CreateAuthenticatorResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorManagerCreateAuthenticatorResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(VirtualAuthenticator authenticator) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorResponseParams _response = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerCreateAuthenticatorResponseParams();
            _response.authenticator = authenticator;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorManagerGetAuthenticatorsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorManagerGetAuthenticatorsParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorManagerGetAuthenticatorsParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerGetAuthenticatorsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerGetAuthenticatorsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerGetAuthenticatorsParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerGetAuthenticatorsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerGetAuthenticatorsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VirtualAuthenticatorManagerGetAuthenticatorsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VirtualAuthenticator[] authenticators;

        private VirtualAuthenticatorManagerGetAuthenticatorsResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorManagerGetAuthenticatorsResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerGetAuthenticatorsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerGetAuthenticatorsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerGetAuthenticatorsResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerGetAuthenticatorsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerGetAuthenticatorsResponseParams(elementsOrVersion);
                result.authenticators = (VirtualAuthenticator[])decoder0.readServiceInterfaces(8, 0, -1, VirtualAuthenticator.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.authenticators, 8, 0, -1, VirtualAuthenticator.MANAGER);
        }
    }

    static class VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticatorManager.GetAuthenticatorsResponse mCallback;

        VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsForwardToCallback(VirtualAuthenticatorManager.GetAuthenticatorsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsResponseParams response = VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.authenticators);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsProxyToResponder implements VirtualAuthenticatorManager.GetAuthenticatorsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorManagerGetAuthenticatorsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(VirtualAuthenticator[] authenticators) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsResponseParams _response = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerGetAuthenticatorsResponseParams();
            _response.authenticators = authenticators;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorManagerRemoveAuthenticatorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String id;

        private VirtualAuthenticatorManagerRemoveAuthenticatorParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorManagerRemoveAuthenticatorParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerRemoveAuthenticatorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerRemoveAuthenticatorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerRemoveAuthenticatorParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerRemoveAuthenticatorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerRemoveAuthenticatorParams(elementsOrVersion);
                result.id = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8, false);
        }
    }

    static final class VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean removed;

        private VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams(elementsOrVersion);
                result.removed = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.removed, 8, 0);
        }
    }

    static class VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticatorManager.RemoveAuthenticatorResponse mCallback;

        VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsForwardToCallback(VirtualAuthenticatorManager.RemoveAuthenticatorResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams response = VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.removed));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsProxyToResponder implements VirtualAuthenticatorManager.RemoveAuthenticatorResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorManagerRemoveAuthenticatorResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean removed) {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams _response = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerRemoveAuthenticatorResponseParams();
            _response.removed = removed.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorManagerClearAuthenticatorsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorManagerClearAuthenticatorsParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorManagerClearAuthenticatorsParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerClearAuthenticatorsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerClearAuthenticatorsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerClearAuthenticatorsParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerClearAuthenticatorsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerClearAuthenticatorsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VirtualAuthenticatorManagerClearAuthenticatorsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorManagerClearAuthenticatorsResponseParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorManagerClearAuthenticatorsResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorManagerClearAuthenticatorsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorManagerClearAuthenticatorsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorManagerClearAuthenticatorsResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorManagerClearAuthenticatorsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorManagerClearAuthenticatorsResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticatorManager.ClearAuthenticatorsResponse mCallback;

        VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsForwardToCallback(VirtualAuthenticatorManager.ClearAuthenticatorsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsProxyToResponder implements VirtualAuthenticatorManager.ClearAuthenticatorsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorManagerClearAuthenticatorsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsResponseParams _response = new VirtualAuthenticatorManager_Internal.VirtualAuthenticatorManagerClearAuthenticatorsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
