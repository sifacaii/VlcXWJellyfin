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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;

class SharedWorkerConnector_Internal {
    public static final Interface.Manager<SharedWorkerConnector, SharedWorkerConnector.Proxy> MANAGER = new Interface.Manager<SharedWorkerConnector, SharedWorkerConnector.Proxy>() {
        public String getName() {
            return "blink.mojom.SharedWorkerConnector";
        }

        public int getVersion() {
            return 0;
        }

        public SharedWorkerConnector_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SharedWorkerConnector_Internal.Proxy(core, messageReceiver);
        }

        public SharedWorkerConnector_Internal.Stub buildStub(Core core, SharedWorkerConnector impl) {
            return new SharedWorkerConnector_Internal.Stub(core, impl);
        }

        public SharedWorkerConnector[] buildArray(int size) {
            return new SharedWorkerConnector[size];
        }
    };

    private static final int CONNECT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements SharedWorkerConnector.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void connect(SharedWorkerInfo info, FetchClientSettingsObject outsideFetchClientSettingsObject, SharedWorkerClient client, int creationContextType, MessagePipeHandle messagePort, BlobUrlToken blobUrlToken) {
            SharedWorkerConnector_Internal.SharedWorkerConnectorConnectParams _message = new SharedWorkerConnector_Internal.SharedWorkerConnectorConnectParams();
            _message.info = info;
            _message.outsideFetchClientSettingsObject = outsideFetchClientSettingsObject;
            _message.client = client;
            _message.creationContextType = creationContextType;
            _message.messagePort = messagePort;
            _message.blobUrlToken = blobUrlToken;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<SharedWorkerConnector> {
        Stub(Core core, SharedWorkerConnector impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SharedWorkerConnector_Internal.SharedWorkerConnectorConnectParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SharedWorkerConnector_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = SharedWorkerConnector_Internal.SharedWorkerConnectorConnectParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerConnector)getImpl()).connect(data.info, data.outsideFetchClientSettingsObject, data.client, data.creationContextType, data.messagePort, data.blobUrlToken);
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
                                getCore(), SharedWorkerConnector_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SharedWorkerConnectorConnectParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SharedWorkerInfo info;

        public FetchClientSettingsObject outsideFetchClientSettingsObject;

        public SharedWorkerClient client;

        public int creationContextType;

        public MessagePipeHandle messagePort;

        public BlobUrlToken blobUrlToken;

        private SharedWorkerConnectorConnectParams(int version) {
            super(48, version);
            this.messagePort = (MessagePipeHandle)InvalidHandle.INSTANCE;
        }

        public SharedWorkerConnectorConnectParams() {
            this(0);
        }

        public static SharedWorkerConnectorConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerConnectorConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerConnectorConnectParams decode(Decoder decoder0) {
            SharedWorkerConnectorConnectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerConnectorConnectParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = SharedWorkerInfo.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.outsideFetchClientSettingsObject = FetchClientSettingsObject.decode(decoder1);
                result.client = (SharedWorkerClient)decoder0.readServiceInterface(24, false, SharedWorkerClient.MANAGER);
                result.creationContextType = decoder0.readInt(32);
                SharedWorkerCreationContextType.validate(result.creationContextType);
                result.messagePort = decoder0.readMessagePipeHandle(36, false);
                result.blobUrlToken = (BlobUrlToken)decoder0.readServiceInterface(40, true, BlobUrlToken.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
            encoder0.encode(this.outsideFetchClientSettingsObject, 16, false);
            encoder0.encode(this.client, 24, false, SharedWorkerClient.MANAGER);
            encoder0.encode(this.creationContextType, 32);
            encoder0.encode((Handle)this.messagePort, 36, false);
            encoder0.encode(this.blobUrlToken, 40, true, BlobUrlToken.MANAGER);
        }
    }
}
