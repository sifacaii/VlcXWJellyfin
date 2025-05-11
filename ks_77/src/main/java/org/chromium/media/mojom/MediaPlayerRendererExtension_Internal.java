package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.MediaPlayerRendererExtension;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal.class */
class MediaPlayerRendererExtension_Internal {
    public static final Interface.Manager<MediaPlayerRendererExtension, MediaPlayerRendererExtension.Proxy> MANAGER = new Interface.Manager<MediaPlayerRendererExtension, MediaPlayerRendererExtension.Proxy>() { // from class: org.chromium.media.mojom.MediaPlayerRendererExtension_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.MediaPlayerRendererExtension";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaPlayerRendererExtension.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaPlayerRendererExtension impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaPlayerRendererExtension[] buildArray(int size) {
            return new MediaPlayerRendererExtension[size];
        }
    };
    private static final int INITIATE_SCOPED_SURFACE_REQUEST_ORDINAL = 0;

    MediaPlayerRendererExtension_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaPlayerRendererExtension.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.MediaPlayerRendererExtension
        public void initiateScopedSurfaceRequest(MediaPlayerRendererExtension.InitiateScopedSurfaceRequestResponse callback) {
            MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams _message = new MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaPlayerRendererExtension> {
        Stub(Core core, MediaPlayerRendererExtension impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaPlayerRendererExtension_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaPlayerRendererExtension_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams.deserialize(messageWithHeader.getPayload());
                        getImpl().initiateScopedSurfaceRequest(new MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal$MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams.class */
    static final class MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams(int version) {
            super(8, version);
        }

        public MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams() {
            this(0);
        }

        public static MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams result = new MediaPlayerRendererExtensionInitiateScopedSurfaceRequestParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal$MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams.class */
    public static final class MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken requestToken;

        private MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams(int version) {
            super(16, version);
        }

        public MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams() {
            this(0);
        }

        public static MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams result = new MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.requestToken = UnguessableToken.decode(decoder1);
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
            encoder0.encode((Struct) this.requestToken, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal$MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsForwardToCallback.class */
    static class MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MediaPlayerRendererExtension.InitiateScopedSurfaceRequestResponse mCallback;

        MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsForwardToCallback(MediaPlayerRendererExtension.InitiateScopedSurfaceRequestResponse callback) {
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
                MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams response = MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.requestToken);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension_Internal$MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsProxyToResponder.class */
    static class MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsProxyToResponder implements MediaPlayerRendererExtension.InitiateScopedSurfaceRequestResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(UnguessableToken requestToken) {
            MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams _response = new MediaPlayerRendererExtensionInitiateScopedSurfaceRequestResponseParams();
            _response.requestToken = requestToken;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
