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
import org.chromium.network.mojom.ProxyErrorClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient_Internal.class */
class ProxyErrorClient_Internal {
    public static final Interface.Manager<ProxyErrorClient, ProxyErrorClient.Proxy> MANAGER = new Interface.Manager<ProxyErrorClient, ProxyErrorClient.Proxy>() { // from class: org.chromium.network.mojom.ProxyErrorClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.ProxyErrorClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ProxyErrorClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ProxyErrorClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ProxyErrorClient[] buildArray(int size) {
            return new ProxyErrorClient[size];
        }
    };
    private static final int ON_PAC_SCRIPT_ERROR_ORDINAL = 0;
    private static final int ON_REQUEST_MAYBE_FAILED_DUE_TO_PROXY_SETTINGS_ORDINAL = 1;

    ProxyErrorClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ProxyErrorClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.ProxyErrorClient
        public void onPacScriptError(int lineNumber, String details) {
            ProxyErrorClientOnPacScriptErrorParams _message = new ProxyErrorClientOnPacScriptErrorParams();
            _message.lineNumber = lineNumber;
            _message.details = details;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.ProxyErrorClient
        public void onRequestMaybeFailedDueToProxySettings(int netError) {
            ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams _message = new ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams();
            _message.netError = netError;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ProxyErrorClient> {
        Stub(Core core, ProxyErrorClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProxyErrorClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        ProxyErrorClientOnPacScriptErrorParams data = ProxyErrorClientOnPacScriptErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onPacScriptError(data.lineNumber, data.details);
                        return true;
                    case 1:
                        getImpl().onRequestMaybeFailedDueToProxySettings(ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams.deserialize(messageWithHeader.getPayload()).netError);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ProxyErrorClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient_Internal$ProxyErrorClientOnPacScriptErrorParams.class */
    static final class ProxyErrorClientOnPacScriptErrorParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int lineNumber;
        public String details;

        private ProxyErrorClientOnPacScriptErrorParams(int version) {
            super(24, version);
        }

        public ProxyErrorClientOnPacScriptErrorParams() {
            this(0);
        }

        public static ProxyErrorClientOnPacScriptErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyErrorClientOnPacScriptErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyErrorClientOnPacScriptErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyErrorClientOnPacScriptErrorParams result = new ProxyErrorClientOnPacScriptErrorParams(elementsOrVersion);
                result.lineNumber = decoder0.readInt(8);
                result.details = decoder0.readString(16, false);
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
            encoder0.encode(this.details, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient_Internal$ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams.class */
    static final class ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;

        private ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams(int version) {
            super(16, version);
        }

        public ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams() {
            this(0);
        }

        public static ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams result = new ProxyErrorClientOnRequestMaybeFailedDueToProxySettingsParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
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
            encoder0.encode(this.netError, 8);
        }
    }
}
