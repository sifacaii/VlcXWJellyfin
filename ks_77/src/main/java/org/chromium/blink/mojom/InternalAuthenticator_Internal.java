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

class InternalAuthenticator_Internal {
    public static final Interface.Manager<InternalAuthenticator, InternalAuthenticator.Proxy> MANAGER = new Interface.Manager<InternalAuthenticator, InternalAuthenticator.Proxy>() {
        public String getName() {
            return "blink.mojom.InternalAuthenticator";
        }

        public int getVersion() {
            return 0;
        }

        public InternalAuthenticator_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new InternalAuthenticator_Internal.Proxy(core, messageReceiver);
        }

        public InternalAuthenticator_Internal.Stub buildStub(Core core, InternalAuthenticator impl) {
            return new InternalAuthenticator_Internal.Stub(core, impl);
        }

        public InternalAuthenticator[] buildArray(int size) {
            return new InternalAuthenticator[size];
        }
    };

    private static final int MAKE_CREDENTIAL_ORDINAL = 0;

    private static final int GET_ASSERTION_ORDINAL = 1;

    private static final int IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements InternalAuthenticator.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void makeCredential(PublicKeyCredentialCreationOptions options, InternalAuthenticator.MakeCredentialResponse callback) {
            InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialParams _message = new InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialResponseParamsForwardToCallback(callback));
        }

        public void getAssertion(PublicKeyCredentialRequestOptions options, InternalAuthenticator.GetAssertionResponse callback) {
            InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionParams _message = new InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionResponseParamsForwardToCallback(callback));
        }

        public void isUserVerifyingPlatformAuthenticatorAvailable(InternalAuthenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse callback) {
            InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams _message = new InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<InternalAuthenticator> {
        Stub(Core core, InternalAuthenticator impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InternalAuthenticator_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialParams internalAuthenticatorMakeCredentialParams;
                InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), InternalAuthenticator_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        internalAuthenticatorMakeCredentialParams = InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialParams.deserialize(messageWithHeader.getPayload());
                        ((InternalAuthenticator)getImpl()).makeCredential(internalAuthenticatorMakeCredentialParams.options, new InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionParams.deserialize(messageWithHeader.getPayload());
                        ((InternalAuthenticator)getImpl()).getAssertion(data.options, new InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams.deserialize(messageWithHeader.getPayload());
                        ((InternalAuthenticator)getImpl()).isUserVerifyingPlatformAuthenticatorAvailable(new InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class InternalAuthenticatorMakeCredentialParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PublicKeyCredentialCreationOptions options;

        private InternalAuthenticatorMakeCredentialParams(int version) {
            super(16, version);
        }

        public InternalAuthenticatorMakeCredentialParams() {
            this(0);
        }

        public static InternalAuthenticatorMakeCredentialParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InternalAuthenticatorMakeCredentialParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InternalAuthenticatorMakeCredentialParams decode(Decoder decoder0) {
            InternalAuthenticatorMakeCredentialParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InternalAuthenticatorMakeCredentialParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = PublicKeyCredentialCreationOptions.decode(decoder1);
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

    static final class InternalAuthenticatorMakeCredentialResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public MakeCredentialAuthenticatorResponse credential;

        private InternalAuthenticatorMakeCredentialResponseParams(int version) {
            super(24, version);
        }

        public InternalAuthenticatorMakeCredentialResponseParams() {
            this(0);
        }

        public static InternalAuthenticatorMakeCredentialResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InternalAuthenticatorMakeCredentialResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InternalAuthenticatorMakeCredentialResponseParams decode(Decoder decoder0) {
            InternalAuthenticatorMakeCredentialResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InternalAuthenticatorMakeCredentialResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                AuthenticatorStatus.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.credential = MakeCredentialAuthenticatorResponse.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.credential, 16, true);
        }
    }

    static class InternalAuthenticatorMakeCredentialResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final InternalAuthenticator.MakeCredentialResponse mCallback;

        InternalAuthenticatorMakeCredentialResponseParamsForwardToCallback(InternalAuthenticator.MakeCredentialResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialResponseParams response = InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.credential);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class InternalAuthenticatorMakeCredentialResponseParamsProxyToResponder implements InternalAuthenticator.MakeCredentialResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        InternalAuthenticatorMakeCredentialResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, MakeCredentialAuthenticatorResponse credential) {
            InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialResponseParams _response = new InternalAuthenticator_Internal.InternalAuthenticatorMakeCredentialResponseParams();
            _response.status = status.intValue();
            _response.credential = credential;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class InternalAuthenticatorGetAssertionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PublicKeyCredentialRequestOptions options;

        private InternalAuthenticatorGetAssertionParams(int version) {
            super(16, version);
        }

        public InternalAuthenticatorGetAssertionParams() {
            this(0);
        }

        public static InternalAuthenticatorGetAssertionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InternalAuthenticatorGetAssertionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InternalAuthenticatorGetAssertionParams decode(Decoder decoder0) {
            InternalAuthenticatorGetAssertionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InternalAuthenticatorGetAssertionParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = PublicKeyCredentialRequestOptions.decode(decoder1);
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

    static final class InternalAuthenticatorGetAssertionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public GetAssertionAuthenticatorResponse credential;

        private InternalAuthenticatorGetAssertionResponseParams(int version) {
            super(24, version);
        }

        public InternalAuthenticatorGetAssertionResponseParams() {
            this(0);
        }

        public static InternalAuthenticatorGetAssertionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InternalAuthenticatorGetAssertionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InternalAuthenticatorGetAssertionResponseParams decode(Decoder decoder0) {
            InternalAuthenticatorGetAssertionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InternalAuthenticatorGetAssertionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                AuthenticatorStatus.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.credential = GetAssertionAuthenticatorResponse.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.credential, 16, true);
        }
    }

    static class InternalAuthenticatorGetAssertionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final InternalAuthenticator.GetAssertionResponse mCallback;

        InternalAuthenticatorGetAssertionResponseParamsForwardToCallback(InternalAuthenticator.GetAssertionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionResponseParams response = InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.credential);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class InternalAuthenticatorGetAssertionResponseParamsProxyToResponder implements InternalAuthenticator.GetAssertionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        InternalAuthenticatorGetAssertionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, GetAssertionAuthenticatorResponse credential) {
            InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionResponseParams _response = new InternalAuthenticator_Internal.InternalAuthenticatorGetAssertionResponseParams();
            _response.status = status.intValue();
            _response.credential = credential;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams(int version) {
            super(8, version);
        }

        public InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams() {
            this(0);
        }

        public static InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams decode(Decoder decoder0) {
            InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean available;

        private InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams(int version) {
            super(16, version);
        }

        public InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams() {
            this(0);
        }

        public static InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams decode(Decoder decoder0) {
            InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams(elementsOrVersion);
                result.available = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.available, 8, 0);
        }
    }

    static class InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final InternalAuthenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse mCallback;

        InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback(InternalAuthenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams response = InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.available));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder implements InternalAuthenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean available) {
            InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams _response = new InternalAuthenticator_Internal.InternalAuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams();
            _response.available = available.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
