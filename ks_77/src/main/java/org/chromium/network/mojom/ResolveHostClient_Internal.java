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
import org.chromium.network.mojom.ResolveHostClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient_Internal.class */
class ResolveHostClient_Internal {
    public static final Interface.Manager<ResolveHostClient, ResolveHostClient.Proxy> MANAGER = new Interface.Manager<ResolveHostClient, ResolveHostClient.Proxy>() { // from class: org.chromium.network.mojom.ResolveHostClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.ResolveHostClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ResolveHostClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ResolveHostClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ResolveHostClient[] buildArray(int size) {
            return new ResolveHostClient[size];
        }
    };
    private static final int ON_COMPLETE_ORDINAL = 0;
    private static final int ON_TEXT_RESULTS_ORDINAL = 1;
    private static final int ON_HOSTNAME_RESULTS_ORDINAL = 2;

    ResolveHostClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ResolveHostClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.ResolveHostClient
        public void onComplete(int result, AddressList resolvedAddresses) {
            ResolveHostClientOnCompleteParams _message = new ResolveHostClientOnCompleteParams();
            _message.result = result;
            _message.resolvedAddresses = resolvedAddresses;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.ResolveHostClient
        public void onTextResults(String[] textResults) {
            ResolveHostClientOnTextResultsParams _message = new ResolveHostClientOnTextResultsParams();
            _message.textResults = textResults;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.ResolveHostClient
        public void onHostnameResults(HostPortPair[] hosts) {
            ResolveHostClientOnHostnameResultsParams _message = new ResolveHostClientOnHostnameResultsParams();
            _message.hosts = hosts;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ResolveHostClient> {
        Stub(Core core, ResolveHostClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ResolveHostClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        ResolveHostClientOnCompleteParams data = ResolveHostClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onComplete(data.result, data.resolvedAddresses);
                        return true;
                    case 1:
                        ResolveHostClientOnTextResultsParams data2 = ResolveHostClientOnTextResultsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onTextResults(data2.textResults);
                        return true;
                    case 2:
                        ResolveHostClientOnHostnameResultsParams data3 = ResolveHostClientOnHostnameResultsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onHostnameResults(data3.hosts);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ResolveHostClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient_Internal$ResolveHostClientOnCompleteParams.class */
    static final class ResolveHostClientOnCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public AddressList resolvedAddresses;

        private ResolveHostClientOnCompleteParams(int version) {
            super(24, version);
        }

        public ResolveHostClientOnCompleteParams() {
            this(0);
        }

        public static ResolveHostClientOnCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ResolveHostClientOnCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ResolveHostClientOnCompleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ResolveHostClientOnCompleteParams result = new ResolveHostClientOnCompleteParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.resolvedAddresses = AddressList.decode(decoder1);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.resolvedAddresses, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient_Internal$ResolveHostClientOnTextResultsParams.class */
    static final class ResolveHostClientOnTextResultsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String[] textResults;

        private ResolveHostClientOnTextResultsParams(int version) {
            super(16, version);
        }

        public ResolveHostClientOnTextResultsParams() {
            this(0);
        }

        public static ResolveHostClientOnTextResultsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ResolveHostClientOnTextResultsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ResolveHostClientOnTextResultsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ResolveHostClientOnTextResultsParams result = new ResolveHostClientOnTextResultsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.textResults = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.textResults[i1] = decoder1.readString(8 + (8 * i1), false);
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
            if (this.textResults == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.textResults.length, 8, -1);
            for (int i0 = 0; i0 < this.textResults.length; i0++) {
                encoder1.encode(this.textResults[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient_Internal$ResolveHostClientOnHostnameResultsParams.class */
    static final class ResolveHostClientOnHostnameResultsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HostPortPair[] hosts;

        private ResolveHostClientOnHostnameResultsParams(int version) {
            super(16, version);
        }

        public ResolveHostClientOnHostnameResultsParams() {
            this(0);
        }

        public static ResolveHostClientOnHostnameResultsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ResolveHostClientOnHostnameResultsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ResolveHostClientOnHostnameResultsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ResolveHostClientOnHostnameResultsParams result = new ResolveHostClientOnHostnameResultsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.hosts = new HostPortPair[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.hosts[i1] = HostPortPair.decode(decoder2);
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
            if (this.hosts == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.hosts.length, 8, -1);
            for (int i0 = 0; i0 < this.hosts.length; i0++) {
                encoder1.encode((Struct) this.hosts[i0], 8 + (8 * i0), false);
            }
        }
    }
}
