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
import org.chromium.proxy_resolver.mojom.ProxyResolverRequestClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal.class */
class ProxyResolverRequestClient_Internal {
    public static final Interface.Manager<ProxyResolverRequestClient, ProxyResolverRequestClient.Proxy> MANAGER = new Interface.Manager<ProxyResolverRequestClient, ProxyResolverRequestClient.Proxy>() { // from class: org.chromium.proxy_resolver.mojom.ProxyResolverRequestClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "proxy_resolver.mojom.ProxyResolverRequestClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProxyResolverRequestClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProxyResolverRequestClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProxyResolverRequestClient[] buildArray(int size) {
            return new ProxyResolverRequestClient[size];
        }
    };
    private static final int REPORT_RESULT_ORDINAL = 0;
    private static final int ALERT_ORDINAL = 1;
    private static final int ON_ERROR_ORDINAL = 2;
    private static final int RESOLVE_DNS_ORDINAL = 3;

    ProxyResolverRequestClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProxyResolverRequestClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverRequestClient
        public void reportResult(int error, ProxyInfo proxyInfo) {
            ProxyResolverRequestClientReportResultParams _message = new ProxyResolverRequestClientReportResultParams();
            _message.error = error;
            _message.proxyInfo = proxyInfo;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverRequestClient
        public void alert(String error) {
            ProxyResolverRequestClientAlertParams _message = new ProxyResolverRequestClientAlertParams();
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverRequestClient
        public void onError(int lineNumber, String error) {
            ProxyResolverRequestClientOnErrorParams _message = new ProxyResolverRequestClientOnErrorParams();
            _message.lineNumber = lineNumber;
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.proxy_resolver.mojom.ProxyResolverRequestClient
        public void resolveDns(String host, int operation, HostResolverRequestClient client) {
            ProxyResolverRequestClientResolveDnsParams _message = new ProxyResolverRequestClientResolveDnsParams();
            _message.host = host;
            _message.operation = operation;
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProxyResolverRequestClient> {
        Stub(Core core, ProxyResolverRequestClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProxyResolverRequestClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        ProxyResolverRequestClientReportResultParams data = ProxyResolverRequestClientReportResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().reportResult(data.error, data.proxyInfo);
                        return true;
                    case 1:
                        getImpl().alert(ProxyResolverRequestClientAlertParams.deserialize(messageWithHeader.getPayload()).error);
                        return true;
                    case 2:
                        ProxyResolverRequestClientOnErrorParams data2 = ProxyResolverRequestClientOnErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onError(data2.lineNumber, data2.error);
                        return true;
                    case 3:
                        ProxyResolverRequestClientResolveDnsParams data3 = ProxyResolverRequestClientResolveDnsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resolveDns(data3.host, data3.operation, data3.client);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProxyResolverRequestClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal$ProxyResolverRequestClientReportResultParams.class */
    static final class ProxyResolverRequestClientReportResultParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public ProxyInfo proxyInfo;

        private ProxyResolverRequestClientReportResultParams(int version) {
            super(24, version);
        }

        public ProxyResolverRequestClientReportResultParams() {
            this(0);
        }

        public static ProxyResolverRequestClientReportResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverRequestClientReportResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverRequestClientReportResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverRequestClientReportResultParams result = new ProxyResolverRequestClientReportResultParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.proxyInfo = ProxyInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.proxyInfo, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal$ProxyResolverRequestClientAlertParams.class */
    static final class ProxyResolverRequestClientAlertParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String error;

        private ProxyResolverRequestClientAlertParams(int version) {
            super(16, version);
        }

        public ProxyResolverRequestClientAlertParams() {
            this(0);
        }

        public static ProxyResolverRequestClientAlertParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverRequestClientAlertParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverRequestClientAlertParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverRequestClientAlertParams result = new ProxyResolverRequestClientAlertParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal$ProxyResolverRequestClientOnErrorParams.class */
    static final class ProxyResolverRequestClientOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int lineNumber;
        public String error;

        private ProxyResolverRequestClientOnErrorParams(int version) {
            super(24, version);
        }

        public ProxyResolverRequestClientOnErrorParams() {
            this(0);
        }

        public static ProxyResolverRequestClientOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverRequestClientOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverRequestClientOnErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverRequestClientOnErrorParams result = new ProxyResolverRequestClientOnErrorParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient_Internal$ProxyResolverRequestClientResolveDnsParams.class */
    static final class ProxyResolverRequestClientResolveDnsParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String host;
        public int operation;
        public HostResolverRequestClient client;

        private ProxyResolverRequestClientResolveDnsParams(int version) {
            super(32, version);
        }

        public ProxyResolverRequestClientResolveDnsParams() {
            this(0);
        }

        public static ProxyResolverRequestClientResolveDnsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyResolverRequestClientResolveDnsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyResolverRequestClientResolveDnsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyResolverRequestClientResolveDnsParams result = new ProxyResolverRequestClientResolveDnsParams(elementsOrVersion);
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
            encoder0.encode(this.client, 20, false, HostResolverRequestClient.MANAGER);
        }
    }
}
