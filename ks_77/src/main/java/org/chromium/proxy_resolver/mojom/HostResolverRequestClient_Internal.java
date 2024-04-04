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
import org.chromium.network.mojom.IpAddress;
import org.chromium.proxy_resolver.mojom.HostResolverRequestClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolverRequestClient_Internal.class */
class HostResolverRequestClient_Internal {
    public static final Interface.Manager<HostResolverRequestClient, HostResolverRequestClient.Proxy> MANAGER = new Interface.Manager<HostResolverRequestClient, HostResolverRequestClient.Proxy>() { // from class: org.chromium.proxy_resolver.mojom.HostResolverRequestClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "proxy_resolver.mojom.HostResolverRequestClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public HostResolverRequestClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, HostResolverRequestClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public HostResolverRequestClient[] buildArray(int size) {
            return new HostResolverRequestClient[size];
        }
    };
    private static final int REPORT_RESULT_ORDINAL = 0;

    HostResolverRequestClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolverRequestClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements HostResolverRequestClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.proxy_resolver.mojom.HostResolverRequestClient
        public void reportResult(int error, IpAddress[] result) {
            HostResolverRequestClientReportResultParams _message = new HostResolverRequestClientReportResultParams();
            _message.error = error;
            _message.result = result;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolverRequestClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<HostResolverRequestClient> {
        Stub(Core core, HostResolverRequestClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(HostResolverRequestClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        HostResolverRequestClientReportResultParams data = HostResolverRequestClientReportResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().reportResult(data.error, data.result);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), HostResolverRequestClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolverRequestClient_Internal$HostResolverRequestClientReportResultParams.class */
    static final class HostResolverRequestClientReportResultParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public IpAddress[] result;

        private HostResolverRequestClientReportResultParams(int version) {
            super(24, version);
        }

        public HostResolverRequestClientReportResultParams() {
            this(0);
        }

        public static HostResolverRequestClientReportResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HostResolverRequestClientReportResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HostResolverRequestClientReportResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                HostResolverRequestClientReportResultParams result = new HostResolverRequestClientReportResultParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.result = new IpAddress[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.result[i1] = IpAddress.decode(decoder2);
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
            encoder0.encode(this.error, 8);
            if (this.result == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.result.length, 16, -1);
            for (int i0 = 0; i0 < this.result.length; i0++) {
                encoder1.encode((Struct) this.result[i0], 8 + (8 * i0), false);
            }
        }
    }
}
