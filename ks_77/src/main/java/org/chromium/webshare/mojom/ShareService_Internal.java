package org.chromium.webshare.mojom;

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
import org.chromium.url.mojom.Url;
import org.chromium.webshare.mojom.ShareService;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal.class */
class ShareService_Internal {
    public static final Interface.Manager<ShareService, ShareService.Proxy> MANAGER = new Interface.Manager<ShareService, ShareService.Proxy>() { // from class: org.chromium.webshare.mojom.ShareService_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "blink.mojom.ShareService";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ShareService.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ShareService impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ShareService[] buildArray(int size) {
            return new ShareService[size];
        }
    };
    private static final int SHARE_ORDINAL = 0;

    ShareService_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ShareService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.webshare.mojom.ShareService
        public void share(String title, String text, Url url, SharedFile[] files, ShareService.ShareResponse callback) {
            ShareServiceShareParams _message = new ShareServiceShareParams();
            _message.title = title;
            _message.text = text;
            _message.url = url;
            _message.files = files;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ShareServiceShareResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ShareService> {
        Stub(Core core, ShareService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ShareService_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ShareService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ShareServiceShareParams data = ShareServiceShareParams.deserialize(messageWithHeader.getPayload());
                        getImpl().share(data.title, data.text, data.url, data.files, new ShareServiceShareResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal$ShareServiceShareParams.class */
    static final class ShareServiceShareParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String title;
        public String text;
        public Url url;
        public SharedFile[] files;

        private ShareServiceShareParams(int version) {
            super(40, version);
        }

        public ShareServiceShareParams() {
            this(0);
        }

        public static ShareServiceShareParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ShareServiceShareParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ShareServiceShareParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ShareServiceShareParams result = new ShareServiceShareParams(elementsOrVersion);
                result.title = decoder0.readString(8, false);
                result.text = decoder0.readString(16, false);
                result.url = Url.decode(decoder0.readPointer(24, false));
                Decoder decoder1 = decoder0.readPointer(32, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.files = new SharedFile[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.files[i1] = SharedFile.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.title, 8, false);
            encoder0.encode(this.text, 16, false);
            encoder0.encode((Struct) this.url, 24, false);
            if (this.files == null) {
                encoder0.encodeNullPointer(32, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.files.length, 32, -1);
            for (int i0 = 0; i0 < this.files.length; i0++) {
                encoder1.encode((Struct) this.files[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal$ShareServiceShareResponseParams.class */
    public static final class ShareServiceShareResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private ShareServiceShareResponseParams(int version) {
            super(16, version);
        }

        public ShareServiceShareResponseParams() {
            this(0);
        }

        public static ShareServiceShareResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ShareServiceShareResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ShareServiceShareResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ShareServiceShareResponseParams result = new ShareServiceShareResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ShareError.validate(result.error);
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
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal$ShareServiceShareResponseParamsForwardToCallback.class */
    static class ShareServiceShareResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ShareService.ShareResponse mCallback;

        ShareServiceShareResponseParamsForwardToCallback(ShareService.ShareResponse callback) {
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
                ShareServiceShareResponseParams response = ShareServiceShareResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareService_Internal$ShareServiceShareResponseParamsProxyToResponder.class */
    static class ShareServiceShareResponseParamsProxyToResponder implements ShareService.ShareResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ShareServiceShareResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            ShareServiceShareResponseParams _response = new ShareServiceShareResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
