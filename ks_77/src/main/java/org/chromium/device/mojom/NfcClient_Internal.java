package org.chromium.device.mojom;

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

class NfcClient_Internal {
    public static final Interface.Manager<NfcClient, NfcClient.Proxy> MANAGER = new Interface.Manager<NfcClient, NfcClient.Proxy>() {
        public String getName() {
            return "device.mojom.NFCClient";
        }

        public int getVersion() {
            return 0;
        }

        public NfcClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NfcClient_Internal.Proxy(core, messageReceiver);
        }

        public NfcClient_Internal.Stub buildStub(Core core, NfcClient impl) {
            return new NfcClient_Internal.Stub(core, impl);
        }

        public NfcClient[] buildArray(int size) {
            return new NfcClient[size];
        }
    };

    private static final int ON_WATCH_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements NfcClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onWatch(int[] watchIds, String serialNumber, NdefMessage message) {
            NfcClient_Internal.NfcClientOnWatchParams _message = new NfcClient_Internal.NfcClientOnWatchParams();
            _message.watchIds = watchIds;
            _message.serialNumber = serialNumber;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<NfcClient> {
        Stub(Core core, NfcClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                NfcClient_Internal.NfcClientOnWatchParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NfcClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = NfcClient_Internal.NfcClientOnWatchParams.deserialize(messageWithHeader.getPayload());
                        ((NfcClient)getImpl()).onWatch(data.watchIds, data.serialNumber, data.message);
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
                                getCore(), NfcClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NfcClientOnWatchParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int[] watchIds;

        public String serialNumber;

        public NdefMessage message;

        private NfcClientOnWatchParams(int version) {
            super(32, version);
        }

        public NfcClientOnWatchParams() {
            this(0);
        }

        public static NfcClientOnWatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcClientOnWatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcClientOnWatchParams decode(Decoder decoder0) {
            NfcClientOnWatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcClientOnWatchParams(elementsOrVersion);
                result.watchIds = decoder0.readInts(8, 0, -1);
                result.serialNumber = decoder0.readString(16, true);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.message = NdefMessage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.watchIds, 8, 0, -1);
            encoder0.encode(this.serialNumber, 16, true);
            encoder0.encode(this.message, 24, false);
        }
    }
}
