package org.chromium.proxy_resolver.mojom;

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
import org.chromium.proxy_resolver.mojom.ProxyResolverFactoryRequestClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal.class */
class ProxyResolverFactoryRequestClient_Internal {
    public static final Interface.Manager<ProxyResolverFactoryRequestClient, ProxyResolverFactoryRequestClient.Proxy> MANAGER = new Interface.Manager<ProxyResolverFactoryRequestClient, ProxyResolverFactoryRequestClient.Proxy>() { // from class: org.chromium.proxy_resolver.mojom.ProxyResolverFactoryRequestClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "proxy_resolver.mojom.ProxyResolverFactoryRequestClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProxyResolverFactoryRequestClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProxyResolverFactoryRequestClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProxyResolverFactoryRequestClient[] buildArray(int size) {
            return new ProxyResolverFactoryRequestClient[size];
        }
    };
    private static final int REPORT_RESULT_ORDINAL = 0;
    private static final int ALERT_ORDINAL = 1;
    private static final int ON_ERROR_ORDINAL = 2;
    private static final int RESOLVE_DNS_ORDINAL = 3;

    ProxyResolverFactoryRequestClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProxyResolverFactoryRequestClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverFactoryRequestClient
        public void reportResult(int error) {
            ProxyResolverFactoryRequestClientReportResultParams _message = new ProxyResolverFactoryRequestClientReportResultParams();
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverFactoryRequestClient
        public void alert(String error) {
            ProxyResolverFactoryRequestClientAlertParams _message = new ProxyResolverFactoryRequestClientAlertParams();
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverFactoryRequestClient
        public void onError(int lineNumber, String error) {
            ProxyResolverFactoryRequestClientOnErrorParams _message = new ProxyResolverFactoryRequestClientOnErrorParams();
            _message.lineNumber = lineNumber;
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverFactoryRequestClient
        public void resolveDns(String host, int operation, HostResolverRequestClient client) {
            ProxyResolverFactoryRequestClientResolveDnsParams _message = new ProxyResolverFactoryRequestClientResolveDnsParams();
            _message.host = host;
            _message.operation = operation;
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProxyResolverFactoryRequestClient> {
        Stub(Core core, ProxyResolverFactoryRequestClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProxyResolverFactoryRequestClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        getImpl().reportResult(ProxyResolverFactoryRequestClientReportResultParams.deserialize(messageWithHeader.getPayload()).error);
                        return true;
                    case 1:
                        getImpl().alert(ProxyResolverFactoryRequestClientAlertParams.deserialize(messageWithHeader.getPayload()).error);
                        return true;
                    case 2:
                        ProxyResolverFactoryRequestClientOnErrorParams data = ProxyResolverFactoryRequestClientOnErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onError(data.lineNumber, data.error);
                        return true;
                    case 3:
                        ProxyResolverFactoryRequestClientResolveDnsParams data2 = ProxyResolverFactoryRequestClientResolveDnsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resolveDns(data2.host, data2.operation, data2.client);
                        return true;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProxyResolverFactoryRequestClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal$ProxyResolverFactoryRequestClientReportResultParams.class */
    static final class ProxyResolverFactoryRequestClientReportResultParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private ProxyResolverFactoryRequestClientReportResultParams(int version) {
            super(16, version);
        }

        public ProxyResolverFactoryRequestClientReportResultParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientReportResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverFactoryRequestClientReportResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverFactoryRequestClientReportResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverFactoryRequestClientReportResultParams result = new ProxyResolverFactoryRequestClientReportResultParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal$ProxyResolverFactoryRequestClientAlertParams.class */
    static final class ProxyResolverFactoryRequestClientAlertParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String error;

        private ProxyResolverFactoryRequestClientAlertParams(int version) {
            super(16, version);
        }

        public ProxyResolverFactoryRequestClientAlertParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientAlertParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverFactoryRequestClientAlertParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverFactoryRequestClientAlertParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverFactoryRequestClientAlertParams result = new ProxyResolverFactoryRequestClientAlertParams(elementsOrVersion);
                result.error = decoder0.readString(8, false);
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
            encoder0.encode(this.error, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal$ProxyResolverFactoryRequestClientOnErrorParams.class */
    static final class ProxyResolverFactoryRequestClientOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int lineNumber;
        public String error;

        private ProxyResolverFactoryRequestClientOnErrorParams(int version) {
            super(24, version);
        }

        public ProxyResolverFactoryRequestClientOnErrorParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverFactoryRequestClientOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverFactoryRequestClientOnErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverFactoryRequestClientOnErrorParams result = new ProxyResolverFactoryRequestClientOnErrorParams(elementsOrVersion);
                result.lineNumber = decoder0.readInt(8);
                result.error = decoder0.readString(16, false);
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
            encoder0.encode(this.lineNumber, 8);
            encoder0.encode(this.error, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient_Internal$ProxyResolverFactoryRequestClientResolveDnsParams.class */
    static final class ProxyResolverFactoryRequestClientResolveDnsParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;
        public int operation;
        public HostResolverRequestClient client;

        private ProxyResolverFactoryRequestClientResolveDnsParams(int version) {
            super(32, version);
        }

        public ProxyResolverFactoryRequestClientResolveDnsParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientResolveDnsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverFactoryRequestClientResolveDnsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverFactoryRequestClientResolveDnsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverFactoryRequestClientResolveDnsParams result = new ProxyResolverFactoryRequestClientResolveDnsParams(elementsOrVersion);
                result.host = decoder0.readString(8, false);
                result.operation = decoder0.readInt(16);
                HostResolveOperation.validate(result.operation);
                result.client = (HostResolverRequestClient) decoder0.readServiceInterface(20, false, HostResolverRequestClient.MANAGER);
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
            encoder0.encode(this.host, 8, false);
            encoder0.encode(this.operation, 16);
            encoder0.encode(this.client, 20, false,HostResolverRequestClient.MANAGER);
        }
    }
}
