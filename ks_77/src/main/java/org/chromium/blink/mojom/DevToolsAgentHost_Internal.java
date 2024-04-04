package org.chromium.blink.mojom;

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
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

class DevToolsAgentHost_Internal {
    public static final Interface.Manager<DevToolsAgentHost, DevToolsAgentHost.Proxy> MANAGER = new Interface.Manager<DevToolsAgentHost, DevToolsAgentHost.Proxy>() {
        public String getName() {
            return "blink.mojom.DevToolsAgentHost";
        }

        public int getVersion() {
            return 0;
        }

        public DevToolsAgentHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DevToolsAgentHost_Internal.Proxy(core, messageReceiver);
        }

        public DevToolsAgentHost_Internal.Stub buildStub(Core core, DevToolsAgentHost impl) {
            return new DevToolsAgentHost_Internal.Stub(core, impl);
        }

        public DevToolsAgentHost[] buildArray(int size) {
            return new DevToolsAgentHost[size];
        }
    };

    private static final int CHILD_WORKER_CREATED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements DevToolsAgentHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void childWorkerCreated(DevToolsAgent workerDevtoolsAgent, InterfaceRequest<DevToolsAgentHost> workerDevtoolsAgentHost, Url url, String name, UnguessableToken devtoolsWorkerToken, boolean waitingForDebugger) {
            DevToolsAgentHost_Internal.DevToolsAgentHostChildWorkerCreatedParams _message = new DevToolsAgentHost_Internal.DevToolsAgentHostChildWorkerCreatedParams();
            _message.workerDevtoolsAgent = workerDevtoolsAgent;
            _message.workerDevtoolsAgentHost = workerDevtoolsAgentHost;
            _message.url = url;
            _message.name = name;
            _message.devtoolsWorkerToken = devtoolsWorkerToken;
            _message.waitingForDebugger = waitingForDebugger;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<DevToolsAgentHost> {
        Stub(Core core, DevToolsAgentHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DevToolsAgentHost_Internal.DevToolsAgentHostChildWorkerCreatedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DevToolsAgentHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = DevToolsAgentHost_Internal.DevToolsAgentHostChildWorkerCreatedParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsAgentHost)getImpl()).childWorkerCreated(data.workerDevtoolsAgent, data.workerDevtoolsAgentHost, data.url, data.name, data.devtoolsWorkerToken, data.waitingForDebugger);
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
                                getCore(), DevToolsAgentHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DevToolsAgentHostChildWorkerCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DevToolsAgent workerDevtoolsAgent;

        public InterfaceRequest<DevToolsAgentHost> workerDevtoolsAgentHost;

        public Url url;

        public String name;

        public UnguessableToken devtoolsWorkerToken;

        public boolean waitingForDebugger;

        private DevToolsAgentHostChildWorkerCreatedParams(int version) {
            super(48, version);
        }

        public DevToolsAgentHostChildWorkerCreatedParams() {
            this(0);
        }

        public static DevToolsAgentHostChildWorkerCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsAgentHostChildWorkerCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsAgentHostChildWorkerCreatedParams decode(Decoder decoder0) {
            DevToolsAgentHostChildWorkerCreatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsAgentHostChildWorkerCreatedParams(elementsOrVersion);
                result.workerDevtoolsAgent = (DevToolsAgent)decoder0.readServiceInterface(8, false, DevToolsAgent.MANAGER);
                result.workerDevtoolsAgentHost = decoder0.readInterfaceRequest(16, false);
                result.waitingForDebugger = decoder0.readBoolean(20, 0);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.url = Url.decode(decoder1);
                result.name = decoder0.readString(32, false);
                decoder1 = decoder0.readPointer(40, false);
                result.devtoolsWorkerToken = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.workerDevtoolsAgent, 8, false, DevToolsAgent.MANAGER);
            encoder0.encode(this.workerDevtoolsAgentHost, 16, false);
            encoder0.encode(this.waitingForDebugger, 20, 0);
            encoder0.encode((Struct)this.url, 24, false);
            encoder0.encode(this.name, 32, false);
            encoder0.encode((Struct)this.devtoolsWorkerToken, 40, false);
        }
    }
}
