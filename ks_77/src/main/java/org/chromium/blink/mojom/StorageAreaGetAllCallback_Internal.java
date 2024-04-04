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

class StorageAreaGetAllCallback_Internal {
    public static final Interface.Manager<StorageAreaGetAllCallback, StorageAreaGetAllCallback.Proxy> MANAGER = new Interface.Manager<StorageAreaGetAllCallback, StorageAreaGetAllCallback.Proxy>() {
        public String getName() {
            return "blink.mojom.StorageAreaGetAllCallback";
        }

        public int getVersion() {
            return 0;
        }

        public StorageAreaGetAllCallback_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new StorageAreaGetAllCallback_Internal.Proxy(core, messageReceiver);
        }

        public StorageAreaGetAllCallback_Internal.Stub buildStub(Core core, StorageAreaGetAllCallback impl) {
            return new StorageAreaGetAllCallback_Internal.Stub(core, impl);
        }

        public StorageAreaGetAllCallback[] buildArray(int size) {
            return new StorageAreaGetAllCallback[size];
        }
    };

    private static final int COMPLETE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements StorageAreaGetAllCallback.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void complete(boolean success) {
            StorageAreaGetAllCallback_Internal.StorageAreaGetAllCallbackCompleteParams _message = new StorageAreaGetAllCallback_Internal.StorageAreaGetAllCallbackCompleteParams();
            _message.success = success;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<StorageAreaGetAllCallback> {
        Stub(Core core, StorageAreaGetAllCallback impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                StorageAreaGetAllCallback_Internal.StorageAreaGetAllCallbackCompleteParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(StorageAreaGetAllCallback_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = StorageAreaGetAllCallback_Internal.StorageAreaGetAllCallbackCompleteParams.deserialize(messageWithHeader.getPayload());
                        ((StorageAreaGetAllCallback)getImpl()).complete(data.success);
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
                                getCore(), StorageAreaGetAllCallback_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class StorageAreaGetAllCallbackCompleteParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private StorageAreaGetAllCallbackCompleteParams(int version) {
            super(16, version);
        }

        public StorageAreaGetAllCallbackCompleteParams() {
            this(0);
        }

        public static StorageAreaGetAllCallbackCompleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static StorageAreaGetAllCallbackCompleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static StorageAreaGetAllCallbackCompleteParams decode(Decoder decoder0) {
            StorageAreaGetAllCallbackCompleteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new StorageAreaGetAllCallbackCompleteParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }
}
