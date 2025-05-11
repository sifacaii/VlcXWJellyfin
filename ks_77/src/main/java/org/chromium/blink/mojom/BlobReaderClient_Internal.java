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

class BlobReaderClient_Internal {
    public static final Interface.Manager<BlobReaderClient, BlobReaderClient.Proxy> MANAGER = new Interface.Manager<BlobReaderClient, BlobReaderClient.Proxy>() {
        public String getName() {
            return "blink.mojom.BlobReaderClient";
        }

        public int getVersion() {
            return 0;
        }

        public BlobReaderClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BlobReaderClient_Internal.Proxy(core, messageReceiver);
        }

        public BlobReaderClient_Internal.Stub buildStub(Core core, BlobReaderClient impl) {
            return new BlobReaderClient_Internal.Stub(core, impl);
        }

        public BlobReaderClient[] buildArray(int size) {
            return new BlobReaderClient[size];
        }
    };

    private static final int ON_CALCULATED_SIZE_ORDINAL = 0;

    private static final int ON_COMPLETE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements BlobReaderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onCalculatedSize(long totalSize, long expectedContentSize) {
            BlobReaderClient_Internal.BlobReaderClientOnCalculatedSizeParams _message = new BlobReaderClient_Internal.BlobReaderClientOnCalculatedSizeParams();
            _message.totalSize = totalSize;
            _message.expectedContentSize = expectedContentSize;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onComplete(int status, long dataLength) {
            BlobReaderClient_Internal.BlobReaderClientOnCompleteParams _message = new BlobReaderClient_Internal.BlobReaderClientOnCompleteParams();
            _message.status = status;
            _message.dataLength = dataLength;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<BlobReaderClient> {
        Stub(Core core, BlobReaderClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BlobReaderClient_Internal.BlobReaderClientOnCalculatedSizeParams blobReaderClientOnCalculatedSizeParams;
                BlobReaderClient_Internal.BlobReaderClientOnCompleteParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BlobReaderClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        blobReaderClientOnCalculatedSizeParams = BlobReaderClient_Internal.BlobReaderClientOnCalculatedSizeParams.deserialize(messageWithHeader.getPayload());
                        ((BlobReaderClient)getImpl()).onCalculatedSize(blobReaderClientOnCalculatedSizeParams.totalSize, blobReaderClientOnCalculatedSizeParams.expectedContentSize);
                        return true;
                    case 1:
                        data = BlobReaderClient_Internal.BlobReaderClientOnCompleteParams.deserialize(messageWithHeader.getPayload());
                        ((BlobReaderClient)getImpl()).onComplete(data.status, data.dataLength);
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
                                getCore(), BlobReaderClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BlobReaderClientOnCalculatedSizeParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long totalSize;

        public long expectedContentSize;

        private BlobReaderClientOnCalculatedSizeParams(int version) {
            super(24, version);
        }

        public BlobReaderClientOnCalculatedSizeParams() {
            this(0);
        }

        public static BlobReaderClientOnCalculatedSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobReaderClientOnCalculatedSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobReaderClientOnCalculatedSizeParams decode(Decoder decoder0) {
            BlobReaderClientOnCalculatedSizeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobReaderClientOnCalculatedSizeParams(elementsOrVersion);
                result.totalSize = decoder0.readLong(8);
                result.expectedContentSize = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.totalSize, 8);
            encoder0.encode(this.expectedContentSize, 16);
        }
    }

    static final class BlobReaderClientOnCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public long dataLength;

        private BlobReaderClientOnCompleteParams(int version) {
            super(24, version);
        }

        public BlobReaderClientOnCompleteParams() {
            this(0);
        }

        public static BlobReaderClientOnCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobReaderClientOnCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobReaderClientOnCompleteParams decode(Decoder decoder0) {
            BlobReaderClientOnCompleteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobReaderClientOnCompleteParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                result.dataLength = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.dataLength, 16);
        }
    }
}
