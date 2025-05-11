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

class VirtualAuthenticator_Internal {
    public static final Interface.Manager<VirtualAuthenticator, VirtualAuthenticator.Proxy> MANAGER = new Interface.Manager<VirtualAuthenticator, VirtualAuthenticator.Proxy>() {
        public String getName() {
            return "blink.test.mojom.VirtualAuthenticator";
        }

        public int getVersion() {
            return 0;
        }

        public VirtualAuthenticator_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new VirtualAuthenticator_Internal.Proxy(core, messageReceiver);
        }

        public VirtualAuthenticator_Internal.Stub buildStub(Core core, VirtualAuthenticator impl) {
            return new VirtualAuthenticator_Internal.Stub(core, impl);
        }

        public VirtualAuthenticator[] buildArray(int size) {
            return new VirtualAuthenticator[size];
        }
    };

    private static final int GET_UNIQUE_ID_ORDINAL = 0;

    private static final int ADD_REGISTRATION_ORDINAL = 1;

    private static final int GET_REGISTRATIONS_ORDINAL = 2;

    private static final int CLEAR_REGISTRATIONS_ORDINAL = 3;

    private static final int SET_USER_PRESENCE_ORDINAL = 4;

    private static final int GET_USER_PRESENCE_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements VirtualAuthenticator.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getUniqueId(VirtualAuthenticator.GetUniqueIdResponse callback) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdParams _message = new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdResponseParamsForwardToCallback(callback));
        }

        public void addRegistration(RegisteredKey key, VirtualAuthenticator.AddRegistrationResponse callback) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationParams _message = new VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationParams();
            _message.key = key;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationResponseParamsForwardToCallback(callback));
        }

        public void getRegistrations(VirtualAuthenticator.GetRegistrationsResponse callback) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsParams _message = new VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsResponseParamsForwardToCallback(callback));
        }

        public void clearRegistrations(VirtualAuthenticator.ClearRegistrationsResponse callback) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsParams _message = new VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsResponseParamsForwardToCallback(callback));
        }

        public void setUserPresence(boolean present, VirtualAuthenticator.SetUserPresenceResponse callback) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceParams _message = new VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceParams();
            _message.present = present;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceResponseParamsForwardToCallback(callback));
        }

        public void getUserPresence(VirtualAuthenticator.GetUserPresenceResponse callback) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceParams _message = new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<VirtualAuthenticator> {
        Stub(Core core, VirtualAuthenticator impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VirtualAuthenticator_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationParams virtualAuthenticatorAddRegistrationParams;
                VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), VirtualAuthenticator_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticator)getImpl()).getUniqueId(new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        virtualAuthenticatorAddRegistrationParams = VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticator)getImpl()).addRegistration(virtualAuthenticatorAddRegistrationParams.key, new VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticator)getImpl()).getRegistrations(new VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticator)getImpl()).clearRegistrations(new VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        data = VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticator)getImpl()).setUserPresence(data.present, new VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceParams.deserialize(messageWithHeader.getPayload());
                        ((VirtualAuthenticator)getImpl()).getUserPresence(new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class VirtualAuthenticatorGetUniqueIdParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorGetUniqueIdParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorGetUniqueIdParams() {
            this(0);
        }

        public static VirtualAuthenticatorGetUniqueIdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorGetUniqueIdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorGetUniqueIdParams decode(Decoder decoder0) {
            VirtualAuthenticatorGetUniqueIdParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorGetUniqueIdParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VirtualAuthenticatorGetUniqueIdResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String id;

        private VirtualAuthenticatorGetUniqueIdResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorGetUniqueIdResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorGetUniqueIdResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorGetUniqueIdResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorGetUniqueIdResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorGetUniqueIdResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorGetUniqueIdResponseParams(elementsOrVersion);
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

    static class VirtualAuthenticatorGetUniqueIdResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticator.GetUniqueIdResponse mCallback;

        VirtualAuthenticatorGetUniqueIdResponseParamsForwardToCallback(VirtualAuthenticator.GetUniqueIdResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdResponseParams response = VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.id);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorGetUniqueIdResponseParamsProxyToResponder implements VirtualAuthenticator.GetUniqueIdResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorGetUniqueIdResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String id) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdResponseParams _response = new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUniqueIdResponseParams();
            _response.id = id;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorAddRegistrationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public RegisteredKey key;

        private VirtualAuthenticatorAddRegistrationParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorAddRegistrationParams() {
            this(0);
        }

        public static VirtualAuthenticatorAddRegistrationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorAddRegistrationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorAddRegistrationParams decode(Decoder decoder0) {
            VirtualAuthenticatorAddRegistrationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorAddRegistrationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.key = RegisteredKey.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.key, 8, false);
        }
    }

    static final class VirtualAuthenticatorAddRegistrationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean added;

        private VirtualAuthenticatorAddRegistrationResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorAddRegistrationResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorAddRegistrationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorAddRegistrationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorAddRegistrationResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorAddRegistrationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorAddRegistrationResponseParams(elementsOrVersion);
                result.added = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.added, 8, 0);
        }
    }

    static class VirtualAuthenticatorAddRegistrationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticator.AddRegistrationResponse mCallback;

        VirtualAuthenticatorAddRegistrationResponseParamsForwardToCallback(VirtualAuthenticator.AddRegistrationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationResponseParams response = VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.added));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorAddRegistrationResponseParamsProxyToResponder implements VirtualAuthenticator.AddRegistrationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorAddRegistrationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean added) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationResponseParams _response = new VirtualAuthenticator_Internal.VirtualAuthenticatorAddRegistrationResponseParams();
            _response.added = added.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorGetRegistrationsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorGetRegistrationsParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorGetRegistrationsParams() {
            this(0);
        }

        public static VirtualAuthenticatorGetRegistrationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorGetRegistrationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorGetRegistrationsParams decode(Decoder decoder0) {
            VirtualAuthenticatorGetRegistrationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorGetRegistrationsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VirtualAuthenticatorGetRegistrationsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public RegisteredKey[] keys;

        private VirtualAuthenticatorGetRegistrationsResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorGetRegistrationsResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorGetRegistrationsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorGetRegistrationsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorGetRegistrationsResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorGetRegistrationsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorGetRegistrationsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.keys = new RegisteredKey[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.keys[i1] = RegisteredKey.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.keys == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.keys.length, 8, -1);
                for (int i0 = 0; i0 < this.keys.length; i0++)
                    encoder1.encode(this.keys[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class VirtualAuthenticatorGetRegistrationsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticator.GetRegistrationsResponse mCallback;

        VirtualAuthenticatorGetRegistrationsResponseParamsForwardToCallback(VirtualAuthenticator.GetRegistrationsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsResponseParams response = VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.keys);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorGetRegistrationsResponseParamsProxyToResponder implements VirtualAuthenticator.GetRegistrationsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorGetRegistrationsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(RegisteredKey[] keys) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsResponseParams _response = new VirtualAuthenticator_Internal.VirtualAuthenticatorGetRegistrationsResponseParams();
            _response.keys = keys;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorClearRegistrationsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorClearRegistrationsParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorClearRegistrationsParams() {
            this(0);
        }

        public static VirtualAuthenticatorClearRegistrationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorClearRegistrationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorClearRegistrationsParams decode(Decoder decoder0) {
            VirtualAuthenticatorClearRegistrationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorClearRegistrationsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VirtualAuthenticatorClearRegistrationsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorClearRegistrationsResponseParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorClearRegistrationsResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorClearRegistrationsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorClearRegistrationsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorClearRegistrationsResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorClearRegistrationsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorClearRegistrationsResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class VirtualAuthenticatorClearRegistrationsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticator.ClearRegistrationsResponse mCallback;

        VirtualAuthenticatorClearRegistrationsResponseParamsForwardToCallback(VirtualAuthenticator.ClearRegistrationsResponse callback) {
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

    static class VirtualAuthenticatorClearRegistrationsResponseParamsProxyToResponder implements VirtualAuthenticator.ClearRegistrationsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorClearRegistrationsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsResponseParams _response = new VirtualAuthenticator_Internal.VirtualAuthenticatorClearRegistrationsResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorSetUserPresenceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean present;

        private VirtualAuthenticatorSetUserPresenceParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorSetUserPresenceParams() {
            this(0);
        }

        public static VirtualAuthenticatorSetUserPresenceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorSetUserPresenceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorSetUserPresenceParams decode(Decoder decoder0) {
            VirtualAuthenticatorSetUserPresenceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorSetUserPresenceParams(elementsOrVersion);
                result.present = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.present, 8, 0);
        }
    }

    static final class VirtualAuthenticatorSetUserPresenceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorSetUserPresenceResponseParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorSetUserPresenceResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorSetUserPresenceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorSetUserPresenceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorSetUserPresenceResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorSetUserPresenceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorSetUserPresenceResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class VirtualAuthenticatorSetUserPresenceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticator.SetUserPresenceResponse mCallback;

        VirtualAuthenticatorSetUserPresenceResponseParamsForwardToCallback(VirtualAuthenticator.SetUserPresenceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorSetUserPresenceResponseParamsProxyToResponder implements VirtualAuthenticator.SetUserPresenceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorSetUserPresenceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceResponseParams _response = new VirtualAuthenticator_Internal.VirtualAuthenticatorSetUserPresenceResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VirtualAuthenticatorGetUserPresenceParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VirtualAuthenticatorGetUserPresenceParams(int version) {
            super(8, version);
        }

        public VirtualAuthenticatorGetUserPresenceParams() {
            this(0);
        }

        public static VirtualAuthenticatorGetUserPresenceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorGetUserPresenceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorGetUserPresenceParams decode(Decoder decoder0) {
            VirtualAuthenticatorGetUserPresenceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorGetUserPresenceParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VirtualAuthenticatorGetUserPresenceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean present;

        private VirtualAuthenticatorGetUserPresenceResponseParams(int version) {
            super(16, version);
        }

        public VirtualAuthenticatorGetUserPresenceResponseParams() {
            this(0);
        }

        public static VirtualAuthenticatorGetUserPresenceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VirtualAuthenticatorGetUserPresenceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VirtualAuthenticatorGetUserPresenceResponseParams decode(Decoder decoder0) {
            VirtualAuthenticatorGetUserPresenceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VirtualAuthenticatorGetUserPresenceResponseParams(elementsOrVersion);
                result.present = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.present, 8, 0);
        }
    }

    static class VirtualAuthenticatorGetUserPresenceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VirtualAuthenticator.GetUserPresenceResponse mCallback;

        VirtualAuthenticatorGetUserPresenceResponseParamsForwardToCallback(VirtualAuthenticator.GetUserPresenceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceResponseParams response = VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.present));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VirtualAuthenticatorGetUserPresenceResponseParamsProxyToResponder implements VirtualAuthenticator.GetUserPresenceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VirtualAuthenticatorGetUserPresenceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean present) {
            VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceResponseParams _response = new VirtualAuthenticator_Internal.VirtualAuthenticatorGetUserPresenceResponseParams();
            _response.present = present.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
