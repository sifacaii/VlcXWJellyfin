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
import org.chromium.network.mojom.MdnsListenClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal.class */
class MdnsListenClient_Internal {
    public static final Interface.Manager<MdnsListenClient, MdnsListenClient.Proxy> MANAGER = new Interface.Manager<MdnsListenClient, MdnsListenClient.Proxy>() { // from class: org.chromium.network.mojom.MdnsListenClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.MdnsListenClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MdnsListenClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MdnsListenClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MdnsListenClient[] buildArray(int size) {
            return new MdnsListenClient[size];
        }
    };
    private static final int ON_ADDRESS_RESULT_ORDINAL = 0;
    private static final int ON_TEXT_RESULT_ORDINAL = 1;
    private static final int ON_HOSTNAME_RESULT_ORDINAL = 2;
    private static final int ON_UNHANDLED_RESULT_ORDINAL = 3;

    MdnsListenClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MdnsListenClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.MdnsListenClient
        public void onAddressResult(int updateType, int queryType, IpEndPoint endpoint) {
            MdnsListenClientOnAddressResultParams _message = new MdnsListenClientOnAddressResultParams();
            _message.updateType = updateType;
            _message.queryType = queryType;
            _message.endpoint = endpoint;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.MdnsListenClient
        public void onTextResult(int updateType, int queryType, String[] textRecords) {
            MdnsListenClientOnTextResultParams _message = new MdnsListenClientOnTextResultParams();
            _message.updateType = updateType;
            _message.queryType = queryType;
            _message.textRecords = textRecords;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.MdnsListenClient
        public void onHostnameResult(int updateType, int queryType, HostPortPair host) {
            MdnsListenClientOnHostnameResultParams _message = new MdnsListenClientOnHostnameResultParams();
            _message.updateType = updateType;
            _message.queryType = queryType;
            _message.host = host;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.network.mojom.MdnsListenClient
        public void onUnhandledResult(int updateType, int queryType) {
            MdnsListenClientOnUnhandledResultParams _message = new MdnsListenClientOnUnhandledResultParams();
            _message.updateType = updateType;
            _message.queryType = queryType;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MdnsListenClient> {
        Stub(Core core, MdnsListenClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MdnsListenClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        MdnsListenClientOnAddressResultParams data = MdnsListenClientOnAddressResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onAddressResult(data.updateType, data.queryType, data.endpoint);
                        return true;
                    case 1:
                        MdnsListenClientOnTextResultParams data2 = MdnsListenClientOnTextResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onTextResult(data2.updateType, data2.queryType, data2.textRecords);
                        return true;
                    case 2:
                        MdnsListenClientOnHostnameResultParams data3 = MdnsListenClientOnHostnameResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onHostnameResult(data3.updateType, data3.queryType, data3.host);
                        return true;
                    case 3:
                        MdnsListenClientOnUnhandledResultParams data4 = MdnsListenClientOnUnhandledResultParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onUnhandledResult(data4.updateType, data4.queryType);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MdnsListenClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal$MdnsListenClientOnAddressResultParams.class */
    static final class MdnsListenClientOnAddressResultParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int updateType;
        public int queryType;
        public IpEndPoint endpoint;

        private MdnsListenClientOnAddressResultParams(int version) {
            super(24, version);
        }

        public MdnsListenClientOnAddressResultParams() {
            this(0);
        }

        public static MdnsListenClientOnAddressResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MdnsListenClientOnAddressResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MdnsListenClientOnAddressResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MdnsListenClientOnAddressResultParams result = new MdnsListenClientOnAddressResultParams(elementsOrVersion);
                result.updateType = decoder0.readInt(8);
                MdnsListenClient.UpdateType.validate(result.updateType);
                result.queryType = decoder0.readInt(12);
                DnsQueryType.validate(result.queryType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.endpoint = IpEndPoint.decode(decoder1);
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
            encoder0.encode(this.updateType, 8);
            encoder0.encode(this.queryType, 12);
            encoder0.encode((Struct) this.endpoint, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal$MdnsListenClientOnTextResultParams.class */
    static final class MdnsListenClientOnTextResultParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int updateType;
        public int queryType;
        public String[] textRecords;

        private MdnsListenClientOnTextResultParams(int version) {
            super(24, version);
        }

        public MdnsListenClientOnTextResultParams() {
            this(0);
        }

        public static MdnsListenClientOnTextResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MdnsListenClientOnTextResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MdnsListenClientOnTextResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MdnsListenClientOnTextResultParams result = new MdnsListenClientOnTextResultParams(elementsOrVersion);
                result.updateType = decoder0.readInt(8);
                MdnsListenClient.UpdateType.validate(result.updateType);
                result.queryType = decoder0.readInt(12);
                DnsQueryType.validate(result.queryType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.textRecords = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.textRecords[i1] = decoder1.readString(8 + (8 * i1), false);
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
            encoder0.encode(this.updateType, 8);
            encoder0.encode(this.queryType, 12);
            if (this.textRecords == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.textRecords.length, 16, -1);
            for (int i0 = 0; i0 < this.textRecords.length; i0++) {
                encoder1.encode(this.textRecords[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal$MdnsListenClientOnHostnameResultParams.class */
    static final class MdnsListenClientOnHostnameResultParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int updateType;
        public int queryType;
        public HostPortPair host;

        private MdnsListenClientOnHostnameResultParams(int version) {
            super(24, version);
        }

        public MdnsListenClientOnHostnameResultParams() {
            this(0);
        }

        public static MdnsListenClientOnHostnameResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MdnsListenClientOnHostnameResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MdnsListenClientOnHostnameResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MdnsListenClientOnHostnameResultParams result = new MdnsListenClientOnHostnameResultParams(elementsOrVersion);
                result.updateType = decoder0.readInt(8);
                MdnsListenClient.UpdateType.validate(result.updateType);
                result.queryType = decoder0.readInt(12);
                DnsQueryType.validate(result.queryType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.host = HostPortPair.decode(decoder1);
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
            encoder0.encode(this.updateType, 8);
            encoder0.encode(this.queryType, 12);
            encoder0.encode((Struct) this.host, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/MdnsListenClient_Internal$MdnsListenClientOnUnhandledResultParams.class */
    static final class MdnsListenClientOnUnhandledResultParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int updateType;
        public int queryType;

        private MdnsListenClientOnUnhandledResultParams(int version) {
            super(16, version);
        }

        public MdnsListenClientOnUnhandledResultParams() {
            this(0);
        }

        public static MdnsListenClientOnUnhandledResultParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MdnsListenClientOnUnhandledResultParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MdnsListenClientOnUnhandledResultParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MdnsListenClientOnUnhandledResultParams result = new MdnsListenClientOnUnhandledResultParams(elementsOrVersion);
                result.updateType = decoder0.readInt(8);
                MdnsListenClient.UpdateType.validate(result.updateType);
                result.queryType = decoder0.readInt(12);
                DnsQueryType.validate(result.queryType);
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
            encoder0.encode(this.updateType, 8);
            encoder0.encode(this.queryType, 12);
        }
    }
}
