package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.mojom.Url;

class BlobUrlStore_Internal {
    public static final Interface.Manager<BlobUrlStore, BlobUrlStore.Proxy> MANAGER = new Interface.Manager<BlobUrlStore, BlobUrlStore.Proxy>() {
        public String getName() {
            return "blink.mojom.BlobURLStore";
        }

        public int getVersion() {
            return 0;
        }

        public BlobUrlStore_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BlobUrlStore_Internal.Proxy(core, messageReceiver);
        }

        public BlobUrlStore_Internal.Stub buildStub(Core core, BlobUrlStore impl) {
            return new BlobUrlStore_Internal.Stub(core, impl);
        }

        public BlobUrlStore[] buildArray(int size) {
            return new BlobUrlStore[size];
        }
    };

    private static final int REGISTER_ORDINAL = 0;

    private static final int REVOKE_ORDINAL = 1;

    private static final int RESOLVE_ORDINAL = 2;

    private static final int RESOLVE_AS_URL_LOADER_FACTORY_ORDINAL = 3;

    private static final int RESOLVE_FOR_NAVIGATION_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements BlobUrlStore.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void register(Blob blob, Url url, BlobUrlStore.RegisterResponse callback) {
            BlobUrlStore_Internal.BlobUrlStoreRegisterParams _message = new BlobUrlStore_Internal.BlobUrlStoreRegisterParams();
            _message.blob = blob;
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BlobUrlStore_Internal.BlobUrlStoreRegisterResponseParamsForwardToCallback(callback));
        }

        public void revoke(Url url) {
            BlobUrlStore_Internal.BlobUrlStoreRevokeParams _message = new BlobUrlStore_Internal.BlobUrlStoreRevokeParams();
            _message.url = url;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void resolve(Url url, BlobUrlStore.ResolveResponse callback) {
            BlobUrlStore_Internal.BlobUrlStoreResolveParams _message = new BlobUrlStore_Internal.BlobUrlStoreResolveParams();
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new BlobUrlStore_Internal.BlobUrlStoreResolveResponseParamsForwardToCallback(callback));
        }

        public void resolveAsUrlLoaderFactory(Url url, InterfaceRequest<UrlLoaderFactory> factory) {
            BlobUrlStore_Internal.BlobUrlStoreResolveAsUrlLoaderFactoryParams _message = new BlobUrlStore_Internal.BlobUrlStoreResolveAsUrlLoaderFactoryParams();
            _message.url = url;
            _message.factory = factory;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void resolveForNavigation(Url url, InterfaceRequest<BlobUrlToken> token) {
            BlobUrlStore_Internal.BlobUrlStoreResolveForNavigationParams _message = new BlobUrlStore_Internal.BlobUrlStoreResolveForNavigationParams();
            _message.url = url;
            _message.token = token;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<BlobUrlStore> {
        Stub(Core core, BlobUrlStore impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BlobUrlStore_Internal.BlobUrlStoreRevokeParams blobUrlStoreRevokeParams;
                BlobUrlStore_Internal.BlobUrlStoreResolveAsUrlLoaderFactoryParams blobUrlStoreResolveAsUrlLoaderFactoryParams;
                BlobUrlStore_Internal.BlobUrlStoreResolveForNavigationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BlobUrlStore_Internal.MANAGER, messageWithHeader);
                    case 1:
                        blobUrlStoreRevokeParams = BlobUrlStore_Internal.BlobUrlStoreRevokeParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlStore)getImpl()).revoke(blobUrlStoreRevokeParams.url);
                        return true;
                    case 3:
                        blobUrlStoreResolveAsUrlLoaderFactoryParams = BlobUrlStore_Internal.BlobUrlStoreResolveAsUrlLoaderFactoryParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlStore)getImpl()).resolveAsUrlLoaderFactory(blobUrlStoreResolveAsUrlLoaderFactoryParams.url, blobUrlStoreResolveAsUrlLoaderFactoryParams.factory);
                        return true;
                    case 4:
                        data = BlobUrlStore_Internal.BlobUrlStoreResolveForNavigationParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlStore)getImpl()).resolveForNavigation(data.url, data.token);
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
                BlobUrlStore_Internal.BlobUrlStoreRegisterParams blobUrlStoreRegisterParams;
                BlobUrlStore_Internal.BlobUrlStoreResolveParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BlobUrlStore_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        blobUrlStoreRegisterParams = BlobUrlStore_Internal.BlobUrlStoreRegisterParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlStore)getImpl()).register(blobUrlStoreRegisterParams.blob, blobUrlStoreRegisterParams.url, new BlobUrlStore_Internal.BlobUrlStoreRegisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = BlobUrlStore_Internal.BlobUrlStoreResolveParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlStore)getImpl()).resolve(data.url, new BlobUrlStore_Internal.BlobUrlStoreResolveResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BlobUrlStoreRegisterParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Blob blob;

        public Url url;

        private BlobUrlStoreRegisterParams(int version) {
            super(24, version);
        }

        public BlobUrlStoreRegisterParams() {
            this(0);
        }

        public static BlobUrlStoreRegisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreRegisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreRegisterParams decode(Decoder decoder0) {
            BlobUrlStoreRegisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreRegisterParams(elementsOrVersion);
                result.blob = (Blob)decoder0.readServiceInterface(8, false, Blob.MANAGER);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.blob, 8, false, Blob.MANAGER);
            encoder0.encode((Struct)this.url, 16, false);
        }
    }

    static final class BlobUrlStoreRegisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BlobUrlStoreRegisterResponseParams(int version) {
            super(8, version);
        }

        public BlobUrlStoreRegisterResponseParams() {
            this(0);
        }

        public static BlobUrlStoreRegisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreRegisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreRegisterResponseParams decode(Decoder decoder0) {
            BlobUrlStoreRegisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreRegisterResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class BlobUrlStoreRegisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BlobUrlStore.RegisterResponse mCallback;

        BlobUrlStoreRegisterResponseParamsForwardToCallback(BlobUrlStore.RegisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobUrlStoreRegisterResponseParamsProxyToResponder implements BlobUrlStore.RegisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobUrlStoreRegisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            BlobUrlStore_Internal.BlobUrlStoreRegisterResponseParams _response = new BlobUrlStore_Internal.BlobUrlStoreRegisterResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BlobUrlStoreRevokeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        private BlobUrlStoreRevokeParams(int version) {
            super(16, version);
        }

        public BlobUrlStoreRevokeParams() {
            this(0);
        }

        public static BlobUrlStoreRevokeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreRevokeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreRevokeParams decode(Decoder decoder0) {
            BlobUrlStoreRevokeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreRevokeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
        }
    }

    static final class BlobUrlStoreResolveParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        private BlobUrlStoreResolveParams(int version) {
            super(16, version);
        }

        public BlobUrlStoreResolveParams() {
            this(0);
        }

        public static BlobUrlStoreResolveParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreResolveParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreResolveParams decode(Decoder decoder0) {
            BlobUrlStoreResolveParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreResolveParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
        }
    }

    static final class BlobUrlStoreResolveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Blob blob;

        private BlobUrlStoreResolveResponseParams(int version) {
            super(16, version);
        }

        public BlobUrlStoreResolveResponseParams() {
            this(0);
        }

        public static BlobUrlStoreResolveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreResolveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreResolveResponseParams decode(Decoder decoder0) {
            BlobUrlStoreResolveResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreResolveResponseParams(elementsOrVersion);
                result.blob = (Blob)decoder0.readServiceInterface(8, true, Blob.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.blob, 8, true, Blob.MANAGER);
        }
    }

    static class BlobUrlStoreResolveResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BlobUrlStore.ResolveResponse mCallback;

        BlobUrlStoreResolveResponseParamsForwardToCallback(BlobUrlStore.ResolveResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                BlobUrlStore_Internal.BlobUrlStoreResolveResponseParams response = BlobUrlStore_Internal.BlobUrlStoreResolveResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.blob);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobUrlStoreResolveResponseParamsProxyToResponder implements BlobUrlStore.ResolveResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobUrlStoreResolveResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Blob blob) {
            BlobUrlStore_Internal.BlobUrlStoreResolveResponseParams _response = new BlobUrlStore_Internal.BlobUrlStoreResolveResponseParams();
            _response.blob = blob;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BlobUrlStoreResolveAsUrlLoaderFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public InterfaceRequest<UrlLoaderFactory> factory;

        private BlobUrlStoreResolveAsUrlLoaderFactoryParams(int version) {
            super(24, version);
        }

        public BlobUrlStoreResolveAsUrlLoaderFactoryParams() {
            this(0);
        }

        public static BlobUrlStoreResolveAsUrlLoaderFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreResolveAsUrlLoaderFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreResolveAsUrlLoaderFactoryParams decode(Decoder decoder0) {
            BlobUrlStoreResolveAsUrlLoaderFactoryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreResolveAsUrlLoaderFactoryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.factory = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.factory, 16, false);
        }
    }

    static final class BlobUrlStoreResolveForNavigationParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public InterfaceRequest<BlobUrlToken> token;

        private BlobUrlStoreResolveForNavigationParams(int version) {
            super(24, version);
        }

        public BlobUrlStoreResolveForNavigationParams() {
            this(0);
        }

        public static BlobUrlStoreResolveForNavigationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlStoreResolveForNavigationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlStoreResolveForNavigationParams decode(Decoder decoder0) {
            BlobUrlStoreResolveForNavigationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlStoreResolveForNavigationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.token = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.token, 16, false);
        }
    }
}
