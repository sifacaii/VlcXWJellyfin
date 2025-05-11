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
import org.chromium.network.mojom.ProxyConfigClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal.class */
class ProxyConfigClient_Internal {
    public static final Interface.Manager<ProxyConfigClient, ProxyConfigClient.Proxy> MANAGER = new Interface.Manager<ProxyConfigClient, ProxyConfigClient.Proxy>() { // from class: org.chromium.network.mojom.ProxyConfigClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.ProxyConfigClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProxyConfigClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProxyConfigClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProxyConfigClient[] buildArray(int size) {
            return new ProxyConfigClient[size];
        }
    };
    private static final int ON_PROXY_CONFIG_UPDATED_ORDINAL = 0;
    private static final int FLUSH_PROXY_CONFIG_ORDINAL = 1;

    ProxyConfigClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProxyConfigClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.ProxyConfigClient
        public void onProxyConfigUpdated(ProxyConfigWithAnnotation proxyConfig) {
            ProxyConfigClientOnProxyConfigUpdatedParams _message = new ProxyConfigClientOnProxyConfigUpdatedParams();
            _message.proxyConfig = proxyConfig;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.ProxyConfigClient
        public void flushProxyConfig(ProxyConfigClient.FlushProxyConfigResponse callback) {
            ProxyConfigClientFlushProxyConfigParams _message = new ProxyConfigClientFlushProxyConfigParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProxyConfigClient> {
        Stub(Core core, ProxyConfigClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProxyConfigClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        ProxyConfigClientOnProxyConfigUpdatedParams data = ProxyConfigClientOnProxyConfigUpdatedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onProxyConfigUpdated(data.proxyConfig);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProxyConfigClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        ProxyConfigClientFlushProxyConfigParams.deserialize(messageWithHeader.getPayload());
                        getImpl().flushProxyConfig(new ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$ProxyConfigClientOnProxyConfigUpdatedParams.class */
    static final class ProxyConfigClientOnProxyConfigUpdatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ProxyConfigWithAnnotation proxyConfig;

        private ProxyConfigClientOnProxyConfigUpdatedParams(int version) {
            super(16, version);
        }

        public ProxyConfigClientOnProxyConfigUpdatedParams() {
            this(0);
        }

        public static ProxyConfigClientOnProxyConfigUpdatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyConfigClientOnProxyConfigUpdatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyConfigClientOnProxyConfigUpdatedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyConfigClientOnProxyConfigUpdatedParams result = new ProxyConfigClientOnProxyConfigUpdatedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.proxyConfig = ProxyConfigWithAnnotation.decode(decoder1);
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
            encoder0.encode((Struct) this.proxyConfig, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$ProxyConfigClientFlushProxyConfigParams.class */
    static final class ProxyConfigClientFlushProxyConfigParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ProxyConfigClientFlushProxyConfigParams(int version) {
            super(8, version);
        }

        public ProxyConfigClientFlushProxyConfigParams() {
            this(0);
        }

        public static ProxyConfigClientFlushProxyConfigParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyConfigClientFlushProxyConfigParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyConfigClientFlushProxyConfigParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyConfigClientFlushProxyConfigParams result = new ProxyConfigClientFlushProxyConfigParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$ProxyConfigClientFlushProxyConfigResponseParams.class */
    static final class ProxyConfigClientFlushProxyConfigResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ProxyConfigClientFlushProxyConfigResponseParams(int version) {
            super(8, version);
        }

        public ProxyConfigClientFlushProxyConfigResponseParams() {
            this(0);
        }

        public static ProxyConfigClientFlushProxyConfigResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyConfigClientFlushProxyConfigResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyConfigClientFlushProxyConfigResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyConfigClientFlushProxyConfigResponseParams result = new ProxyConfigClientFlushProxyConfigResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback.class */
    static class ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ProxyConfigClient.FlushProxyConfigResponse mCallback;

        ProxyConfigClientFlushProxyConfigResponseParamsForwardToCallback(ProxyConfigClient.FlushProxyConfigResponse callback) {
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
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient_Internal$ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder.class */
    static class ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder implements ProxyConfigClient.FlushProxyConfigResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ProxyConfigClientFlushProxyConfigResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            ProxyConfigClientFlushProxyConfigResponseParams _response = new ProxyConfigClientFlushProxyConfigResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
