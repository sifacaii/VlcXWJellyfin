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

class Authenticator_Internal {
    public static final Interface.Manager<Authenticator, Authenticator.Proxy> MANAGER = new Interface.Manager<Authenticator, Authenticator.Proxy>() {
        public String getName() {
            return "blink.mojom.Authenticator";
        }

        public int getVersion() {
            return 0;
        }

        public Authenticator_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Authenticator_Internal.Proxy(core, messageReceiver);
        }

        public Authenticator_Internal.Stub buildStub(Core core, Authenticator impl) {
            return new Authenticator_Internal.Stub(core, impl);
        }

        public Authenticator[] buildArray(int size) {
            return new Authenticator[size];
        }
    };

    private static final int MAKE_CREDENTIAL_ORDINAL = 0;

    private static final int GET_ASSERTION_ORDINAL = 1;

    private static final int IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL = 2;

    private static final int CANCEL_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements Authenticator.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void makeCredential(PublicKeyCredentialCreationOptions options, Authenticator.MakeCredentialResponse callback) {
            Authenticator_Internal.AuthenticatorMakeCredentialParams _message = new Authenticator_Internal.AuthenticatorMakeCredentialParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new Authenticator_Internal.AuthenticatorMakeCredentialResponseParamsForwardToCallback(callback));
        }

        public void getAssertion(PublicKeyCredentialRequestOptions options, Authenticator.GetAssertionResponse callback) {
            Authenticator_Internal.AuthenticatorGetAssertionParams _message = new Authenticator_Internal.AuthenticatorGetAssertionParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new Authenticator_Internal.AuthenticatorGetAssertionResponseParamsForwardToCallback(callback));
        }

        public void isUserVerifyingPlatformAuthenticatorAvailable(Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse callback) {
            Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams _message = new Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback(callback));
        }

        public void cancel() {
            Authenticator_Internal.AuthenticatorCancelParams _message = new Authenticator_Internal.AuthenticatorCancelParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<Authenticator> {
        Stub(Core core, Authenticator impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Authenticator_Internal.MANAGER, messageWithHeader);
                    case 3:
                        Authenticator_Internal.AuthenticatorCancelParams.deserialize(messageWithHeader.getPayload());
                        ((Authenticator)getImpl()).cancel();
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
                Authenticator_Internal.AuthenticatorMakeCredentialParams authenticatorMakeCredentialParams;
                Authenticator_Internal.AuthenticatorGetAssertionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Authenticator_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        authenticatorMakeCredentialParams = Authenticator_Internal.AuthenticatorMakeCredentialParams.deserialize(messageWithHeader.getPayload());
                        ((Authenticator)getImpl()).makeCredential(authenticatorMakeCredentialParams.options, new Authenticator_Internal.AuthenticatorMakeCredentialResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = Authenticator_Internal.AuthenticatorGetAssertionParams.deserialize(messageWithHeader.getPayload());
                        ((Authenticator)getImpl()).getAssertion(data.options, new Authenticator_Internal.AuthenticatorGetAssertionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams.deserialize(messageWithHeader.getPayload());
                        ((Authenticator)getImpl()).isUserVerifyingPlatformAuthenticatorAvailable(new Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AuthenticatorMakeCredentialParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PublicKeyCredentialCreationOptions options;

        private AuthenticatorMakeCredentialParams(int version) {
            super(16, version);
        }

        public AuthenticatorMakeCredentialParams() {
            this(0);
        }

        public static AuthenticatorMakeCredentialParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorMakeCredentialParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorMakeCredentialParams decode(Decoder decoder0) {
            AuthenticatorMakeCredentialParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorMakeCredentialParams(elementsOrVersion);
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

    static final class AuthenticatorMakeCredentialResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public MakeCredentialAuthenticatorResponse credential;

        private AuthenticatorMakeCredentialResponseParams(int version) {
            super(24, version);
        }

        public AuthenticatorMakeCredentialResponseParams() {
            this(0);
        }

        public static AuthenticatorMakeCredentialResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorMakeCredentialResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorMakeCredentialResponseParams decode(Decoder decoder0) {
            AuthenticatorMakeCredentialResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorMakeCredentialResponseParams(elementsOrVersion);
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

    static class AuthenticatorMakeCredentialResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Authenticator.MakeCredentialResponse mCallback;

        AuthenticatorMakeCredentialResponseParamsForwardToCallback(Authenticator.MakeCredentialResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                Authenticator_Internal.AuthenticatorMakeCredentialResponseParams response = Authenticator_Internal.AuthenticatorMakeCredentialResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.credential);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AuthenticatorMakeCredentialResponseParamsProxyToResponder implements Authenticator.MakeCredentialResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AuthenticatorMakeCredentialResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, MakeCredentialAuthenticatorResponse credential) {
            Authenticator_Internal.AuthenticatorMakeCredentialResponseParams _response = new Authenticator_Internal.AuthenticatorMakeCredentialResponseParams();
            _response.status = status.intValue();
            _response.credential = credential;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AuthenticatorGetAssertionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PublicKeyCredentialRequestOptions options;

        private AuthenticatorGetAssertionParams(int version) {
            super(16, version);
        }

        public AuthenticatorGetAssertionParams() {
            this(0);
        }

        public static AuthenticatorGetAssertionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorGetAssertionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorGetAssertionParams decode(Decoder decoder0) {
            AuthenticatorGetAssertionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorGetAssertionParams(elementsOrVersion);
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

    static final class AuthenticatorGetAssertionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public GetAssertionAuthenticatorResponse credential;

        private AuthenticatorGetAssertionResponseParams(int version) {
            super(24, version);
        }

        public AuthenticatorGetAssertionResponseParams() {
            this(0);
        }

        public static AuthenticatorGetAssertionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorGetAssertionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorGetAssertionResponseParams decode(Decoder decoder0) {
            AuthenticatorGetAssertionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorGetAssertionResponseParams(elementsOrVersion);
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

    static class AuthenticatorGetAssertionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Authenticator.GetAssertionResponse mCallback;

        AuthenticatorGetAssertionResponseParamsForwardToCallback(Authenticator.GetAssertionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                Authenticator_Internal.AuthenticatorGetAssertionResponseParams response = Authenticator_Internal.AuthenticatorGetAssertionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.credential);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AuthenticatorGetAssertionResponseParamsProxyToResponder implements Authenticator.GetAssertionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AuthenticatorGetAssertionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, GetAssertionAuthenticatorResponse credential) {
            Authenticator_Internal.AuthenticatorGetAssertionResponseParams _response = new Authenticator_Internal.AuthenticatorGetAssertionResponseParams();
            _response.status = status.intValue();
            _response.credential = credential;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams(int version) {
            super(8, version);
        }

        public AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams() {
            this(0);
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams decode(Decoder decoder0) {
            AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean available;

        private AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams(int version) {
            super(16, version);
        }

        public AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams() {
            this(0);
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams decode(Decoder decoder0) {
            AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams(elementsOrVersion);
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

    static class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse mCallback;

        AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback(Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams response = Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.available));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder implements Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean available) {
            Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams _response = new Authenticator_Internal.AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams();
            _response.available = available.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AuthenticatorCancelParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AuthenticatorCancelParams(int version) {
            super(8, version);
        }

        public AuthenticatorCancelParams() {
            this(0);
        }

        public static AuthenticatorCancelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticatorCancelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticatorCancelParams decode(Decoder decoder0) {
            AuthenticatorCancelParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorCancelParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
