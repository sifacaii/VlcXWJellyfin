package org.chromium.device.mojom;

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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class NfcProvider_Internal {
    public static final Interface.Manager<NfcProvider, NfcProvider.Proxy> MANAGER = new Interface.Manager<NfcProvider, NfcProvider.Proxy>() {
        public String getName() {
            return "device.mojom.NFCProvider";
        }

        public int getVersion() {
            return 0;
        }

        public NfcProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NfcProvider_Internal.Proxy(core, messageReceiver);
        }

        public NfcProvider_Internal.Stub buildStub(Core core, NfcProvider impl) {
            return new NfcProvider_Internal.Stub(core, impl);
        }

        public NfcProvider[] buildArray(int size) {
            return new NfcProvider[size];
        }
    };

    private static final int GET_NFC_FOR_HOST_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements NfcProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getNfcForHost(int hostId, InterfaceRequest<Nfc> nfc) {
            NfcProvider_Internal.NfcProviderGetNfcForHostParams _message = new NfcProvider_Internal.NfcProviderGetNfcForHostParams();
            _message.hostId = hostId;
            _message.nfc = nfc;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<NfcProvider> {
        Stub(Core core, NfcProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                NfcProvider_Internal.NfcProviderGetNfcForHostParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NfcProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = NfcProvider_Internal.NfcProviderGetNfcForHostParams.deserialize(messageWithHeader.getPayload());
                        ((NfcProvider)getImpl()).getNfcForHost(data.hostId, data.nfc);
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
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), NfcProvider_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NfcProviderGetNfcForHostParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int hostId;

        public InterfaceRequest<Nfc> nfc;

        private NfcProviderGetNfcForHostParams(int version) {
            super(16, version);
        }

        public NfcProviderGetNfcForHostParams() {
            this(0);
        }

        public static NfcProviderGetNfcForHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcProviderGetNfcForHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcProviderGetNfcForHostParams decode(Decoder decoder0) {
            NfcProviderGetNfcForHostParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcProviderGetNfcForHostParams(elementsOrVersion);
                result.hostId = decoder0.readInt(8);
                result.nfc = decoder0.readInterfaceRequest(12, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.hostId, 8);
            encoder0.encode(this.nfc, 12, false);
        }
    }
}
