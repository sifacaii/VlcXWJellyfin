package org.chromium.blink.mojom;

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

class ReceivedSnapshotListener_Internal {
    public static final Interface.Manager<ReceivedSnapshotListener, ReceivedSnapshotListener.Proxy> MANAGER = new Interface.Manager<ReceivedSnapshotListener, ReceivedSnapshotListener.Proxy>() {
        public String getName() {
            return "blink.mojom.ReceivedSnapshotListener";
        }

        public int getVersion() {
            return 0;
        }

        public ReceivedSnapshotListener_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ReceivedSnapshotListener_Internal.Proxy(core, messageReceiver);
        }

        public ReceivedSnapshotListener_Internal.Stub buildStub(Core core, ReceivedSnapshotListener impl) {
            return new ReceivedSnapshotListener_Internal.Stub(core, impl);
        }

        public ReceivedSnapshotListener[] buildArray(int size) {
            return new ReceivedSnapshotListener[size];
        }
    };

    private static final int DID_RECEIVE_SNAPSHOT_FILE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ReceivedSnapshotListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didReceiveSnapshotFile() {
            ReceivedSnapshotListener_Internal.ReceivedSnapshotListenerDidReceiveSnapshotFileParams _message = new ReceivedSnapshotListener_Internal.ReceivedSnapshotListenerDidReceiveSnapshotFileParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ReceivedSnapshotListener> {
        Stub(Core core, ReceivedSnapshotListener impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ReceivedSnapshotListener_Internal.MANAGER, messageWithHeader);
                    case 0:
                        ReceivedSnapshotListener_Internal.ReceivedSnapshotListenerDidReceiveSnapshotFileParams.deserialize(messageWithHeader.getPayload());
                        ((ReceivedSnapshotListener)getImpl()).didReceiveSnapshotFile();
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
                                getCore(), ReceivedSnapshotListener_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ReceivedSnapshotListenerDidReceiveSnapshotFileParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ReceivedSnapshotListenerDidReceiveSnapshotFileParams(int version) {
            super(8, version);
        }

        public ReceivedSnapshotListenerDidReceiveSnapshotFileParams() {
            this(0);
        }

        public static ReceivedSnapshotListenerDidReceiveSnapshotFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ReceivedSnapshotListenerDidReceiveSnapshotFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ReceivedSnapshotListenerDidReceiveSnapshotFileParams decode(Decoder decoder0) {
            ReceivedSnapshotListenerDidReceiveSnapshotFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ReceivedSnapshotListenerDidReceiveSnapshotFileParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
