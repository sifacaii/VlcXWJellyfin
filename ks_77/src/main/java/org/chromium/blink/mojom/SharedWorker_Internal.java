package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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

class SharedWorker_Internal {
    public static final Interface.Manager<SharedWorker, SharedWorker.Proxy> MANAGER = new Interface.Manager<SharedWorker, SharedWorker.Proxy>() {
        public String getName() {
            return "blink.mojom.SharedWorker";
        }

        public int getVersion() {
            return 0;
        }

        public SharedWorker_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SharedWorker_Internal.Proxy(core, messageReceiver);
        }

        public SharedWorker_Internal.Stub buildStub(Core core, SharedWorker impl) {
            return new SharedWorker_Internal.Stub(core, impl);
        }

        public SharedWorker[] buildArray(int size) {
            return new SharedWorker[size];
        }
    };

    private static final int CONNECT_ORDINAL = 0;

    private static final int TERMINATE_ORDINAL = 1;

    private static final int BIND_DEV_TOOLS_AGENT_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements SharedWorker.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void connect(int connectionId, MessagePipeHandle messagePort) {
            SharedWorker_Internal.SharedWorkerConnectParams _message = new SharedWorker_Internal.SharedWorkerConnectParams();
            _message.connectionId = connectionId;
            _message.messagePort = messagePort;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void terminate() {
            SharedWorker_Internal.SharedWorkerTerminateParams _message = new SharedWorker_Internal.SharedWorkerTerminateParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void bindDevToolsAgent(AssociatedInterfaceNotSupported agentHost, AssociatedInterfaceRequestNotSupported agent) {
            SharedWorker_Internal.SharedWorkerBindDevToolsAgentParams _message = new SharedWorker_Internal.SharedWorkerBindDevToolsAgentParams();
            _message.agentHost = agentHost;
            _message.agent = agent;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<SharedWorker> {
        Stub(Core core, SharedWorker impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SharedWorker_Internal.SharedWorkerConnectParams sharedWorkerConnectParams;
                SharedWorker_Internal.SharedWorkerBindDevToolsAgentParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SharedWorker_Internal.MANAGER, messageWithHeader);
                    case 0:
                        sharedWorkerConnectParams = SharedWorker_Internal.SharedWorkerConnectParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorker)getImpl()).connect(sharedWorkerConnectParams.connectionId, sharedWorkerConnectParams.messagePort);
                        return true;
                    case 1:
                        SharedWorker_Internal.SharedWorkerTerminateParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorker)getImpl()).terminate();
                        return true;
                    case 2:
                        data = SharedWorker_Internal.SharedWorkerBindDevToolsAgentParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorker)getImpl()).bindDevToolsAgent(data.agentHost, data.agent);
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
                                getCore(), SharedWorker_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SharedWorkerConnectParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int connectionId;

        public MessagePipeHandle messagePort;

        private SharedWorkerConnectParams(int version) {
            super(16, version);
            this.messagePort = (MessagePipeHandle)InvalidHandle.INSTANCE;
        }

        public SharedWorkerConnectParams() {
            this(0);
        }

        public static SharedWorkerConnectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerConnectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerConnectParams decode(Decoder decoder0) {
            SharedWorkerConnectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerConnectParams(elementsOrVersion);
                result.connectionId = decoder0.readInt(8);
                result.messagePort = decoder0.readMessagePipeHandle(12, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.connectionId, 8);
            encoder0.encode((Handle)this.messagePort, 12, false);
        }
    }

    static final class SharedWorkerTerminateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SharedWorkerTerminateParams(int version) {
            super(8, version);
        }

        public SharedWorkerTerminateParams() {
            this(0);
        }

        public static SharedWorkerTerminateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerTerminateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerTerminateParams decode(Decoder decoder0) {
            SharedWorkerTerminateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerTerminateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SharedWorkerBindDevToolsAgentParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported agentHost;

        public AssociatedInterfaceRequestNotSupported agent;

        private SharedWorkerBindDevToolsAgentParams(int version) {
            super(24, version);
        }

        public SharedWorkerBindDevToolsAgentParams() {
            this(0);
        }

        public static SharedWorkerBindDevToolsAgentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerBindDevToolsAgentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerBindDevToolsAgentParams decode(Decoder decoder0) {
            SharedWorkerBindDevToolsAgentParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerBindDevToolsAgentParams(elementsOrVersion);
                result.agentHost = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
                result.agent = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.agentHost, 8, false);
            encoder0.encode(this.agent, 16, false);
        }
    }
}
