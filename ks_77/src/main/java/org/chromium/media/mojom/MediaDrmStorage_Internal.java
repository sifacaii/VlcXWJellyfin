package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.MediaDrmStorage;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal.class */
class MediaDrmStorage_Internal {
    public static final Interface.Manager<MediaDrmStorage, MediaDrmStorage.Proxy> MANAGER = new Interface.Manager<MediaDrmStorage, MediaDrmStorage.Proxy>() { // from class: org.chromium.media.mojom.MediaDrmStorage_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.MediaDrmStorage";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaDrmStorage.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaDrmStorage impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaDrmStorage[] buildArray(int size) {
            return new MediaDrmStorage[size];
        }
    };
    private static final int INITIALIZE_ORDINAL = 0;
    private static final int ON_PROVISIONED_ORDINAL = 1;
    private static final int SAVE_PERSISTENT_SESSION_ORDINAL = 2;
    private static final int LOAD_PERSISTENT_SESSION_ORDINAL = 3;
    private static final int REMOVE_PERSISTENT_SESSION_ORDINAL = 4;

    MediaDrmStorage_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaDrmStorage.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.MediaDrmStorage
        public void initialize(MediaDrmStorage.InitializeResponse callback) {
            MediaDrmStorageInitializeParams _message = new MediaDrmStorageInitializeParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new MediaDrmStorageInitializeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.MediaDrmStorage
        public void onProvisioned(MediaDrmStorage.OnProvisionedResponse callback) {
            MediaDrmStorageOnProvisionedParams _message = new MediaDrmStorageOnProvisionedParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new MediaDrmStorageOnProvisionedResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.MediaDrmStorage
        public void savePersistentSession(String sessionId, SessionData sessionData, MediaDrmStorage.SavePersistentSessionResponse callback) {
            MediaDrmStorageSavePersistentSessionParams _message = new MediaDrmStorageSavePersistentSessionParams();
            _message.sessionId = sessionId;
            _message.sessionData = sessionData;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new MediaDrmStorageSavePersistentSessionResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.MediaDrmStorage
        public void loadPersistentSession(String sessionId, MediaDrmStorage.LoadPersistentSessionResponse callback) {
            MediaDrmStorageLoadPersistentSessionParams _message = new MediaDrmStorageLoadPersistentSessionParams();
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new MediaDrmStorageLoadPersistentSessionResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.MediaDrmStorage
        public void removePersistentSession(String sessionId, MediaDrmStorage.RemovePersistentSessionResponse callback) {
            MediaDrmStorageRemovePersistentSessionParams _message = new MediaDrmStorageRemovePersistentSessionParams();
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new MediaDrmStorageRemovePersistentSessionResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaDrmStorage> {
        Stub(Core core, MediaDrmStorage impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaDrmStorage_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaDrmStorage_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        MediaDrmStorageInitializeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().initialize(new MediaDrmStorageInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        MediaDrmStorageOnProvisionedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onProvisioned(new MediaDrmStorageOnProvisionedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        MediaDrmStorageSavePersistentSessionParams data = MediaDrmStorageSavePersistentSessionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().savePersistentSession(data.sessionId, data.sessionData, new MediaDrmStorageSavePersistentSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        MediaDrmStorageLoadPersistentSessionParams data2 = MediaDrmStorageLoadPersistentSessionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().loadPersistentSession(data2.sessionId, new MediaDrmStorageLoadPersistentSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        MediaDrmStorageRemovePersistentSessionParams data3 = MediaDrmStorageRemovePersistentSessionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().removePersistentSession(data3.sessionId, new MediaDrmStorageRemovePersistentSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageInitializeParams.class */
    static final class MediaDrmStorageInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaDrmStorageInitializeParams(int version) {
            super(8, version);
        }

        public MediaDrmStorageInitializeParams() {
            this(0);
        }

        public static MediaDrmStorageInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageInitializeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageInitializeParams result = new MediaDrmStorageInitializeParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageInitializeResponseParams.class */
    public static final class MediaDrmStorageInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;
        public UnguessableToken originId;

        private MediaDrmStorageInitializeResponseParams(int version) {
            super(24, version);
        }

        public MediaDrmStorageInitializeResponseParams() {
            this(0);
        }

        public static MediaDrmStorageInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageInitializeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageInitializeResponseParams result = new MediaDrmStorageInitializeResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.originId = UnguessableToken.decode(decoder1);
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
            encoder0.encode((Struct) this.originId, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageInitializeResponseParamsForwardToCallback.class */
    static class MediaDrmStorageInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDrmStorage.InitializeResponse mCallback;

        MediaDrmStorageInitializeResponseParamsForwardToCallback(MediaDrmStorage.InitializeResponse callback) {
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
                MediaDrmStorageInitializeResponseParams response = MediaDrmStorageInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.originId);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageInitializeResponseParamsProxyToResponder.class */
    static class MediaDrmStorageInitializeResponseParamsProxyToResponder implements MediaDrmStorage.InitializeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaDrmStorageInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Boolean success, UnguessableToken originId) {
            MediaDrmStorageInitializeResponseParams _response = new MediaDrmStorageInitializeResponseParams();
            _response.success = success.booleanValue();
            _response.originId = originId;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageOnProvisionedParams.class */
    static final class MediaDrmStorageOnProvisionedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaDrmStorageOnProvisionedParams(int version) {
            super(8, version);
        }

        public MediaDrmStorageOnProvisionedParams() {
            this(0);
        }

        public static MediaDrmStorageOnProvisionedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageOnProvisionedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageOnProvisionedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageOnProvisionedParams result = new MediaDrmStorageOnProvisionedParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageOnProvisionedResponseParams.class */
    public static final class MediaDrmStorageOnProvisionedResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private MediaDrmStorageOnProvisionedResponseParams(int version) {
            super(16, version);
        }

        public MediaDrmStorageOnProvisionedResponseParams() {
            this(0);
        }

        public static MediaDrmStorageOnProvisionedResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageOnProvisionedResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageOnProvisionedResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageOnProvisionedResponseParams result = new MediaDrmStorageOnProvisionedResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageOnProvisionedResponseParamsForwardToCallback.class */
    static class MediaDrmStorageOnProvisionedResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDrmStorage.OnProvisionedResponse mCallback;

        MediaDrmStorageOnProvisionedResponseParamsForwardToCallback(MediaDrmStorage.OnProvisionedResponse callback) {
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
                MediaDrmStorageOnProvisionedResponseParams response = MediaDrmStorageOnProvisionedResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageOnProvisionedResponseParamsProxyToResponder.class */
    static class MediaDrmStorageOnProvisionedResponseParamsProxyToResponder implements MediaDrmStorage.OnProvisionedResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaDrmStorageOnProvisionedResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            MediaDrmStorageOnProvisionedResponseParams _response = new MediaDrmStorageOnProvisionedResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageSavePersistentSessionParams.class */
    static final class MediaDrmStorageSavePersistentSessionParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String sessionId;
        public SessionData sessionData;

        private MediaDrmStorageSavePersistentSessionParams(int version) {
            super(24, version);
        }

        public MediaDrmStorageSavePersistentSessionParams() {
            this(0);
        }

        public static MediaDrmStorageSavePersistentSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageSavePersistentSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageSavePersistentSessionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageSavePersistentSessionParams result = new MediaDrmStorageSavePersistentSessionParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.sessionData = SessionData.decode(decoder1);
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
            encoder0.encode(this.sessionId, 8, false);
            encoder0.encode((Struct) this.sessionData, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageSavePersistentSessionResponseParams.class */
    public static final class MediaDrmStorageSavePersistentSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private MediaDrmStorageSavePersistentSessionResponseParams(int version) {
            super(16, version);
        }

        public MediaDrmStorageSavePersistentSessionResponseParams() {
            this(0);
        }

        public static MediaDrmStorageSavePersistentSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageSavePersistentSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageSavePersistentSessionResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageSavePersistentSessionResponseParams result = new MediaDrmStorageSavePersistentSessionResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageSavePersistentSessionResponseParamsForwardToCallback.class */
    static class MediaDrmStorageSavePersistentSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDrmStorage.SavePersistentSessionResponse mCallback;

        MediaDrmStorageSavePersistentSessionResponseParamsForwardToCallback(MediaDrmStorage.SavePersistentSessionResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                MediaDrmStorageSavePersistentSessionResponseParams response = MediaDrmStorageSavePersistentSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageSavePersistentSessionResponseParamsProxyToResponder.class */
    static class MediaDrmStorageSavePersistentSessionResponseParamsProxyToResponder implements MediaDrmStorage.SavePersistentSessionResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaDrmStorageSavePersistentSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            MediaDrmStorageSavePersistentSessionResponseParams _response = new MediaDrmStorageSavePersistentSessionResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageLoadPersistentSessionParams.class */
    static final class MediaDrmStorageLoadPersistentSessionParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String sessionId;

        private MediaDrmStorageLoadPersistentSessionParams(int version) {
            super(16, version);
        }

        public MediaDrmStorageLoadPersistentSessionParams() {
            this(0);
        }

        public static MediaDrmStorageLoadPersistentSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageLoadPersistentSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageLoadPersistentSessionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageLoadPersistentSessionParams result = new MediaDrmStorageLoadPersistentSessionParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
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
            encoder0.encode(this.sessionId, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageLoadPersistentSessionResponseParams.class */
    public static final class MediaDrmStorageLoadPersistentSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SessionData sessionData;

        private MediaDrmStorageLoadPersistentSessionResponseParams(int version) {
            super(16, version);
        }

        public MediaDrmStorageLoadPersistentSessionResponseParams() {
            this(0);
        }

        public static MediaDrmStorageLoadPersistentSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageLoadPersistentSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageLoadPersistentSessionResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageLoadPersistentSessionResponseParams result = new MediaDrmStorageLoadPersistentSessionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.sessionData = SessionData.decode(decoder1);
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
            encoder0.encode((Struct) this.sessionData, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageLoadPersistentSessionResponseParamsForwardToCallback.class */
    static class MediaDrmStorageLoadPersistentSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDrmStorage.LoadPersistentSessionResponse mCallback;

        MediaDrmStorageLoadPersistentSessionResponseParamsForwardToCallback(MediaDrmStorage.LoadPersistentSessionResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                MediaDrmStorageLoadPersistentSessionResponseParams response = MediaDrmStorageLoadPersistentSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.sessionData);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageLoadPersistentSessionResponseParamsProxyToResponder.class */
    static class MediaDrmStorageLoadPersistentSessionResponseParamsProxyToResponder implements MediaDrmStorage.LoadPersistentSessionResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaDrmStorageLoadPersistentSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(SessionData sessionData) {
            MediaDrmStorageLoadPersistentSessionResponseParams _response = new MediaDrmStorageLoadPersistentSessionResponseParams();
            _response.sessionData = sessionData;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageRemovePersistentSessionParams.class */
    static final class MediaDrmStorageRemovePersistentSessionParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String sessionId;

        private MediaDrmStorageRemovePersistentSessionParams(int version) {
            super(16, version);
        }

        public MediaDrmStorageRemovePersistentSessionParams() {
            this(0);
        }

        public static MediaDrmStorageRemovePersistentSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageRemovePersistentSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageRemovePersistentSessionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageRemovePersistentSessionParams result = new MediaDrmStorageRemovePersistentSessionParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
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
            encoder0.encode(this.sessionId, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageRemovePersistentSessionResponseParams.class */
    public static final class MediaDrmStorageRemovePersistentSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private MediaDrmStorageRemovePersistentSessionResponseParams(int version) {
            super(16, version);
        }

        public MediaDrmStorageRemovePersistentSessionResponseParams() {
            this(0);
        }

        public static MediaDrmStorageRemovePersistentSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaDrmStorageRemovePersistentSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaDrmStorageRemovePersistentSessionResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaDrmStorageRemovePersistentSessionResponseParams result = new MediaDrmStorageRemovePersistentSessionResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageRemovePersistentSessionResponseParamsForwardToCallback.class */
    static class MediaDrmStorageRemovePersistentSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaDrmStorage.RemovePersistentSessionResponse mCallback;

        MediaDrmStorageRemovePersistentSessionResponseParamsForwardToCallback(MediaDrmStorage.RemovePersistentSessionResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                MediaDrmStorageRemovePersistentSessionResponseParams response = MediaDrmStorageRemovePersistentSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaDrmStorage_Internal$MediaDrmStorageRemovePersistentSessionResponseParamsProxyToResponder.class */
    static class MediaDrmStorageRemovePersistentSessionResponseParamsProxyToResponder implements MediaDrmStorage.RemovePersistentSessionResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaDrmStorageRemovePersistentSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            MediaDrmStorageRemovePersistentSessionResponseParams _response = new MediaDrmStorageRemovePersistentSessionResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
