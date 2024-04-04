package org.chromium.network.mojom;

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
import org.chromium.network.mojom.AuthenticationHandler;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal.class */
class AuthenticationHandler_Internal {
    public static final Interface.Manager<AuthenticationHandler, AuthenticationHandler.Proxy> MANAGER = new Interface.Manager<AuthenticationHandler, AuthenticationHandler.Proxy>() { // from class: org.chromium.network.mojom.AuthenticationHandler_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.AuthenticationHandler";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public AuthenticationHandler.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, AuthenticationHandler impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public AuthenticationHandler[] buildArray(int size) {
            return new AuthenticationHandler[size];
        }
    };
    private static final int ON_AUTH_REQUIRED_ORDINAL = 0;

    AuthenticationHandler_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements AuthenticationHandler.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.AuthenticationHandler
        public void onAuthRequired(AuthChallengeInfo info, HttpResponseHeaders headers, IpEndPoint remoteEndpoint, AuthenticationHandler.OnAuthRequiredResponse callback) {
            AuthenticationHandlerOnAuthRequiredParams _message = new AuthenticationHandlerOnAuthRequiredParams();
            _message.info = info;
            _message.headers = headers;
            _message.remoteEndpoint = remoteEndpoint;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new AuthenticationHandlerOnAuthRequiredResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<AuthenticationHandler> {
        Stub(Core core, AuthenticationHandler impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AuthenticationHandler_Internal.MANAGER, messageWithHeader);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), AuthenticationHandler_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        AuthenticationHandlerOnAuthRequiredParams data = AuthenticationHandlerOnAuthRequiredParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onAuthRequired(data.info, data.headers, data.remoteEndpoint, new AuthenticationHandlerOnAuthRequiredResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal$AuthenticationHandlerOnAuthRequiredParams.class */
    static final class AuthenticationHandlerOnAuthRequiredParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AuthChallengeInfo info;
        public HttpResponseHeaders headers;
        public IpEndPoint remoteEndpoint;

        private AuthenticationHandlerOnAuthRequiredParams(int version) {
            super(32, version);
        }

        public AuthenticationHandlerOnAuthRequiredParams() {
            this(0);
        }

        public static AuthenticationHandlerOnAuthRequiredParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticationHandlerOnAuthRequiredParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticationHandlerOnAuthRequiredParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AuthenticationHandlerOnAuthRequiredParams result = new AuthenticationHandlerOnAuthRequiredParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = AuthChallengeInfo.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.headers = HttpResponseHeaders.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, false);
                result.remoteEndpoint = IpEndPoint.decode(decoder13);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.info, 8, false);
            encoder0.encode((Struct) this.headers, 16, false);
            encoder0.encode((Struct) this.remoteEndpoint, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal$AuthenticationHandlerOnAuthRequiredResponseParams.class */
    public static final class AuthenticationHandlerOnAuthRequiredResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AuthCredentials credentials;

        private AuthenticationHandlerOnAuthRequiredResponseParams(int version) {
            super(16, version);
        }

        public AuthenticationHandlerOnAuthRequiredResponseParams() {
            this(0);
        }

        public static AuthenticationHandlerOnAuthRequiredResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthenticationHandlerOnAuthRequiredResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthenticationHandlerOnAuthRequiredResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AuthenticationHandlerOnAuthRequiredResponseParams result = new AuthenticationHandlerOnAuthRequiredResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.credentials = AuthCredentials.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.credentials, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal$AuthenticationHandlerOnAuthRequiredResponseParamsForwardToCallback.class */
    static class AuthenticationHandlerOnAuthRequiredResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AuthenticationHandler.OnAuthRequiredResponse mCallback;

        AuthenticationHandlerOnAuthRequiredResponseParamsForwardToCallback(AuthenticationHandler.OnAuthRequiredResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                AuthenticationHandlerOnAuthRequiredResponseParams response = AuthenticationHandlerOnAuthRequiredResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.credentials);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthenticationHandler_Internal$AuthenticationHandlerOnAuthRequiredResponseParamsProxyToResponder.class */
    static class AuthenticationHandlerOnAuthRequiredResponseParamsProxyToResponder implements AuthenticationHandler.OnAuthRequiredResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AuthenticationHandlerOnAuthRequiredResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(AuthCredentials credentials) {
            AuthenticationHandlerOnAuthRequiredResponseParams _response = new AuthenticationHandlerOnAuthRequiredResponseParams();
            _response.credentials = credentials;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
