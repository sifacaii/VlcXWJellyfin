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
import org.chromium.network.mojom.OriginPolicyManager;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal.class */
class OriginPolicyManager_Internal {
    public static final Interface.Manager<OriginPolicyManager, OriginPolicyManager.Proxy> MANAGER = new Interface.Manager<OriginPolicyManager, OriginPolicyManager.Proxy>() { // from class: org.chromium.network.mojom.OriginPolicyManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.OriginPolicyManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public OriginPolicyManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, OriginPolicyManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public OriginPolicyManager[] buildArray(int size) {
            return new OriginPolicyManager[size];
        }
    };
    private static final int RETRIEVE_ORIGIN_POLICY_ORDINAL = 0;
    private static final int ADD_EXCEPTION_FOR_ORDINAL = 1;

    OriginPolicyManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements OriginPolicyManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.OriginPolicyManager
        public void retrieveOriginPolicy(Origin origin, String headerValue, OriginPolicyManager.RetrieveOriginPolicyResponse callback) {
            OriginPolicyManagerRetrieveOriginPolicyParams _message = new OriginPolicyManagerRetrieveOriginPolicyParams();
            _message.origin = origin;
            _message.headerValue = headerValue;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new OriginPolicyManagerRetrieveOriginPolicyResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.OriginPolicyManager
        public void addExceptionFor(Origin origin) {
            OriginPolicyManagerAddExceptionForParams _message = new OriginPolicyManagerAddExceptionForParams();
            _message.origin = origin;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<OriginPolicyManager> {
        Stub(Core core, OriginPolicyManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(OriginPolicyManager_Internal.MANAGER, messageWithHeader);
                    case 1:
                        OriginPolicyManagerAddExceptionForParams data = OriginPolicyManagerAddExceptionForParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addExceptionFor(data.origin);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), OriginPolicyManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        OriginPolicyManagerRetrieveOriginPolicyParams data = OriginPolicyManagerRetrieveOriginPolicyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().retrieveOriginPolicy(data.origin, data.headerValue, new OriginPolicyManagerRetrieveOriginPolicyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$OriginPolicyManagerRetrieveOriginPolicyParams.class */
    static final class OriginPolicyManagerRetrieveOriginPolicyParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Origin origin;
        public String headerValue;

        private OriginPolicyManagerRetrieveOriginPolicyParams(int version) {
            super(24, version);
        }

        public OriginPolicyManagerRetrieveOriginPolicyParams() {
            this(0);
        }

        public static OriginPolicyManagerRetrieveOriginPolicyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OriginPolicyManagerRetrieveOriginPolicyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OriginPolicyManagerRetrieveOriginPolicyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OriginPolicyManagerRetrieveOriginPolicyParams result = new OriginPolicyManagerRetrieveOriginPolicyParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.headerValue = decoder0.readString(16, false);
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
            encoder0.encode((Struct) this.origin, 8, false);
            encoder0.encode(this.headerValue, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$OriginPolicyManagerRetrieveOriginPolicyResponseParams.class */
    public static final class OriginPolicyManagerRetrieveOriginPolicyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public OriginPolicy originPolicy;

        private OriginPolicyManagerRetrieveOriginPolicyResponseParams(int version) {
            super(16, version);
        }

        public OriginPolicyManagerRetrieveOriginPolicyResponseParams() {
            this(0);
        }

        public static OriginPolicyManagerRetrieveOriginPolicyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OriginPolicyManagerRetrieveOriginPolicyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OriginPolicyManagerRetrieveOriginPolicyResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OriginPolicyManagerRetrieveOriginPolicyResponseParams result = new OriginPolicyManagerRetrieveOriginPolicyResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.originPolicy = OriginPolicy.decode(decoder1);
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
            encoder0.encode((Struct) this.originPolicy, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$OriginPolicyManagerRetrieveOriginPolicyResponseParamsForwardToCallback.class */
    static class OriginPolicyManagerRetrieveOriginPolicyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final OriginPolicyManager.RetrieveOriginPolicyResponse mCallback;

        OriginPolicyManagerRetrieveOriginPolicyResponseParamsForwardToCallback(OriginPolicyManager.RetrieveOriginPolicyResponse callback) {
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
                OriginPolicyManagerRetrieveOriginPolicyResponseParams response = OriginPolicyManagerRetrieveOriginPolicyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.originPolicy);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$OriginPolicyManagerRetrieveOriginPolicyResponseParamsProxyToResponder.class */
    static class OriginPolicyManagerRetrieveOriginPolicyResponseParamsProxyToResponder implements OriginPolicyManager.RetrieveOriginPolicyResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        OriginPolicyManagerRetrieveOriginPolicyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(OriginPolicy originPolicy) {
            OriginPolicyManagerRetrieveOriginPolicyResponseParams _response = new OriginPolicyManagerRetrieveOriginPolicyResponseParams();
            _response.originPolicy = originPolicy;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/OriginPolicyManager_Internal$OriginPolicyManagerAddExceptionForParams.class */
    static final class OriginPolicyManagerAddExceptionForParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Origin origin;

        private OriginPolicyManagerAddExceptionForParams(int version) {
            super(16, version);
        }

        public OriginPolicyManagerAddExceptionForParams() {
            this(0);
        }

        public static OriginPolicyManagerAddExceptionForParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OriginPolicyManagerAddExceptionForParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OriginPolicyManagerAddExceptionForParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OriginPolicyManagerAddExceptionForParams result = new OriginPolicyManagerAddExceptionForParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
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
            encoder0.encode((Struct) this.origin, 8, false);
        }
    }
}
