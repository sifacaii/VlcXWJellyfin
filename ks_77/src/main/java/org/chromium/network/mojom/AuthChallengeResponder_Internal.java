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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.AuthChallengeResponder;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthChallengeResponder_Internal.class */
class AuthChallengeResponder_Internal {
    public static final Interface.Manager<AuthChallengeResponder, AuthChallengeResponder.Proxy> MANAGER = new Interface.Manager<AuthChallengeResponder, AuthChallengeResponder.Proxy>() { // from class: org.chromium.network.mojom.AuthChallengeResponder_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.AuthChallengeResponder";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public AuthChallengeResponder.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, AuthChallengeResponder impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public AuthChallengeResponder[] buildArray(int size) {
            return new AuthChallengeResponder[size];
        }
    };
    private static final int ON_AUTH_CREDENTIALS_ORDINAL = 0;

    AuthChallengeResponder_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthChallengeResponder_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements AuthChallengeResponder.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.AuthChallengeResponder
        public void onAuthCredentials(AuthCredentials credentials) {
            AuthChallengeResponderOnAuthCredentialsParams _message = new AuthChallengeResponderOnAuthCredentialsParams();
            _message.credentials = credentials;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthChallengeResponder_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<AuthChallengeResponder> {
        Stub(Core core, AuthChallengeResponder impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AuthChallengeResponder_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AuthChallengeResponderOnAuthCredentialsParams data = AuthChallengeResponderOnAuthCredentialsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onAuthCredentials(data.credentials);
                        return true;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), AuthChallengeResponder_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/AuthChallengeResponder_Internal$AuthChallengeResponderOnAuthCredentialsParams.class */
    static final class AuthChallengeResponderOnAuthCredentialsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AuthCredentials credentials;

        private AuthChallengeResponderOnAuthCredentialsParams(int version) {
            super(16, version);
        }

        public AuthChallengeResponderOnAuthCredentialsParams() {
            this(0);
        }

        public static AuthChallengeResponderOnAuthCredentialsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AuthChallengeResponderOnAuthCredentialsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AuthChallengeResponderOnAuthCredentialsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AuthChallengeResponderOnAuthCredentialsParams result = new AuthChallengeResponderOnAuthCredentialsParams(elementsOrVersion);
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
}
