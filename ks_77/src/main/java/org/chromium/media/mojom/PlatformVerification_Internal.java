package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.PlatformVerification;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal.class */
class PlatformVerification_Internal {
    public static final Interface.Manager<PlatformVerification, PlatformVerification.Proxy> MANAGER = new Interface.Manager<PlatformVerification, PlatformVerification.Proxy>() { // from class: org.chromium.media.mojom.PlatformVerification_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.PlatformVerification";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public PlatformVerification.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, PlatformVerification impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public PlatformVerification[] buildArray(int size) {
            return new PlatformVerification[size];
        }
    };
    private static final int CHALLENGE_PLATFORM_ORDINAL = 0;
    private static final int GET_STORAGE_ID_ORDINAL = 1;

    PlatformVerification_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements PlatformVerification.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.PlatformVerification
        public void challengePlatform(String serviceId, String challenge, PlatformVerification.ChallengePlatformResponse callback) {
            PlatformVerificationChallengePlatformParams _message = new PlatformVerificationChallengePlatformParams();
            _message.serviceId = serviceId;
            _message.challenge = challenge;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PlatformVerificationChallengePlatformResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.PlatformVerification
        public void getStorageId(int version, PlatformVerification.GetStorageIdResponse callback) {
            PlatformVerificationGetStorageIdParams _message = new PlatformVerificationGetStorageIdParams();
            _message.version = version;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new PlatformVerificationGetStorageIdResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<PlatformVerification> {
        Stub(Core core, PlatformVerification impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PlatformVerification_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), PlatformVerification_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        PlatformVerificationChallengePlatformParams data = PlatformVerificationChallengePlatformParams.deserialize(messageWithHeader.getPayload());
                        getImpl().challengePlatform(data.serviceId, data.challenge, new PlatformVerificationChallengePlatformResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        getImpl().getStorageId(PlatformVerificationGetStorageIdParams.deserialize(messageWithHeader.getPayload()).version, new PlatformVerificationGetStorageIdResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationChallengePlatformParams.class */
    static final class PlatformVerificationChallengePlatformParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String serviceId;
        public String challenge;

        private PlatformVerificationChallengePlatformParams(int version) {
            super(24, version);
        }

        public PlatformVerificationChallengePlatformParams() {
            this(0);
        }

        public static PlatformVerificationChallengePlatformParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PlatformVerificationChallengePlatformParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PlatformVerificationChallengePlatformParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PlatformVerificationChallengePlatformParams result = new PlatformVerificationChallengePlatformParams(elementsOrVersion);
                result.serviceId = decoder0.readString(8, false);
                result.challenge = decoder0.readString(16, false);
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
            encoder0.encode(this.serviceId, 8, false);
            encoder0.encode(this.challenge, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationChallengePlatformResponseParams.class */
    public static final class PlatformVerificationChallengePlatformResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;
        public String signedData;
        public String signedDataSignature;
        public String platformKeyCertificate;

        private PlatformVerificationChallengePlatformResponseParams(int version) {
            super(40, version);
        }

        public PlatformVerificationChallengePlatformResponseParams() {
            this(0);
        }

        public static PlatformVerificationChallengePlatformResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PlatformVerificationChallengePlatformResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PlatformVerificationChallengePlatformResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PlatformVerificationChallengePlatformResponseParams result = new PlatformVerificationChallengePlatformResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.signedData = decoder0.readString(16, false);
                result.signedDataSignature = decoder0.readString(24, false);
                result.platformKeyCertificate = decoder0.readString(32, false);
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
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.signedData, 16, false);
            encoder0.encode(this.signedDataSignature, 24, false);
            encoder0.encode(this.platformKeyCertificate, 32, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationChallengePlatformResponseParamsForwardToCallback.class */
    static class PlatformVerificationChallengePlatformResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PlatformVerification.ChallengePlatformResponse mCallback;

        PlatformVerificationChallengePlatformResponseParamsForwardToCallback(PlatformVerification.ChallengePlatformResponse callback) {
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
                PlatformVerificationChallengePlatformResponseParams response = PlatformVerificationChallengePlatformResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.signedData, response.signedDataSignature, response.platformKeyCertificate);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationChallengePlatformResponseParamsProxyToResponder.class */
    static class PlatformVerificationChallengePlatformResponseParamsProxyToResponder implements PlatformVerification.ChallengePlatformResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PlatformVerificationChallengePlatformResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback4
        public void call(Boolean success, String signedData, String signedDataSignature, String platformKeyCertificate) {
            PlatformVerificationChallengePlatformResponseParams _response = new PlatformVerificationChallengePlatformResponseParams();
            _response.success = success.booleanValue();
            _response.signedData = signedData;
            _response.signedDataSignature = signedDataSignature;
            _response.platformKeyCertificate = platformKeyCertificate;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationGetStorageIdParams.class */
    static final class PlatformVerificationGetStorageIdParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int version;

        private PlatformVerificationGetStorageIdParams(int version) {
            super(16, version);
        }

        public PlatformVerificationGetStorageIdParams() {
            this(0);
        }

        public static PlatformVerificationGetStorageIdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PlatformVerificationGetStorageIdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PlatformVerificationGetStorageIdParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PlatformVerificationGetStorageIdParams result = new PlatformVerificationGetStorageIdParams(elementsOrVersion);
                result.version = decoder0.readInt(8);
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
            encoder0.encode(this.version, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationGetStorageIdResponseParams.class */
    public static final class PlatformVerificationGetStorageIdResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int version;
        public byte[] storageId;

        private PlatformVerificationGetStorageIdResponseParams(int version) {
            super(24, version);
        }

        public PlatformVerificationGetStorageIdResponseParams() {
            this(0);
        }

        public static PlatformVerificationGetStorageIdResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PlatformVerificationGetStorageIdResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PlatformVerificationGetStorageIdResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                PlatformVerificationGetStorageIdResponseParams result = new PlatformVerificationGetStorageIdResponseParams(elementsOrVersion);
                result.version = decoder0.readInt(8);
                result.storageId = decoder0.readBytes(16, 0, -1);
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
            encoder0.encode(this.version, 8);
            encoder0.encode(this.storageId, 16, 0, -1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationGetStorageIdResponseParamsForwardToCallback.class */
    static class PlatformVerificationGetStorageIdResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PlatformVerification.GetStorageIdResponse mCallback;

        PlatformVerificationGetStorageIdResponseParamsForwardToCallback(PlatformVerification.GetStorageIdResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                PlatformVerificationGetStorageIdResponseParams response = PlatformVerificationGetStorageIdResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.version), response.storageId);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlatformVerification_Internal$PlatformVerificationGetStorageIdResponseParamsProxyToResponder.class */
    static class PlatformVerificationGetStorageIdResponseParamsProxyToResponder implements PlatformVerification.GetStorageIdResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        PlatformVerificationGetStorageIdResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer version, byte[] storageId) {
            PlatformVerificationGetStorageIdResponseParams _response = new PlatformVerificationGetStorageIdResponseParams();
            _response.version = version.intValue();
            _response.storageId = storageId;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
