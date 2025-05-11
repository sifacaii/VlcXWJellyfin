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

class EmbeddedWorkerInstanceClient_Internal {
    public static final Interface.Manager<EmbeddedWorkerInstanceClient, EmbeddedWorkerInstanceClient.Proxy> MANAGER = new Interface.Manager<EmbeddedWorkerInstanceClient, EmbeddedWorkerInstanceClient.Proxy>() {
        public String getName() {
            return "blink.mojom.EmbeddedWorkerInstanceClient";
        }

        public int getVersion() {
            return 0;
        }

        public EmbeddedWorkerInstanceClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new EmbeddedWorkerInstanceClient_Internal.Proxy(core, messageReceiver);
        }

        public EmbeddedWorkerInstanceClient_Internal.Stub buildStub(Core core, EmbeddedWorkerInstanceClient impl) {
            return new EmbeddedWorkerInstanceClient_Internal.Stub(core, impl);
        }

        public EmbeddedWorkerInstanceClient[] buildArray(int size) {
            return new EmbeddedWorkerInstanceClient[size];
        }
    };

    private static final int START_WORKER_ORDINAL = 0;

    private static final int STOP_WORKER_ORDINAL = 1;

    private static final int RESUME_AFTER_DOWNLOAD_ORDINAL = 2;

    private static final int ADD_MESSAGE_TO_CONSOLE_ORDINAL = 3;

    private static final int BIND_DEV_TOOLS_AGENT_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements EmbeddedWorkerInstanceClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void startWorker(EmbeddedWorkerStartParams params) {
            EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStartWorkerParams _message = new EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStartWorkerParams();
            _message.params = params;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void stopWorker() {
            EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStopWorkerParams _message = new EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStopWorkerParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void resumeAfterDownload() {
            EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientResumeAfterDownloadParams _message = new EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientResumeAfterDownloadParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void addMessageToConsole(int level, String message) {
            EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientAddMessageToConsoleParams _message = new EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientAddMessageToConsoleParams();
            _message.level = level;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void bindDevToolsAgent(AssociatedInterfaceNotSupported agentHost, AssociatedInterfaceRequestNotSupported agent) {
            EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientBindDevToolsAgentParams _message = new EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientBindDevToolsAgentParams();
            _message.agentHost = agentHost;
            _message.agent = agent;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<EmbeddedWorkerInstanceClient> {
        Stub(Core core, EmbeddedWorkerInstanceClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStartWorkerParams embeddedWorkerInstanceClientStartWorkerParams;
                EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientAddMessageToConsoleParams embeddedWorkerInstanceClientAddMessageToConsoleParams;
                EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientBindDevToolsAgentParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(EmbeddedWorkerInstanceClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        embeddedWorkerInstanceClientStartWorkerParams = EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStartWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceClient)getImpl()).startWorker(embeddedWorkerInstanceClientStartWorkerParams.params);
                        return true;
                    case 1:
                        EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientStopWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceClient)getImpl()).stopWorker();
                        return true;
                    case 2:
                        EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientResumeAfterDownloadParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceClient)getImpl()).resumeAfterDownload();
                        return true;
                    case 3:
                        embeddedWorkerInstanceClientAddMessageToConsoleParams = EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientAddMessageToConsoleParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceClient)getImpl()).addMessageToConsole(embeddedWorkerInstanceClientAddMessageToConsoleParams.level, embeddedWorkerInstanceClientAddMessageToConsoleParams.message);
                        return true;
                    case 4:
                        data = EmbeddedWorkerInstanceClient_Internal.EmbeddedWorkerInstanceClientBindDevToolsAgentParams.deserialize(messageWithHeader.getPayload());
                        ((EmbeddedWorkerInstanceClient)getImpl()).bindDevToolsAgent(data.agentHost, data.agent);
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
                                getCore(), EmbeddedWorkerInstanceClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class EmbeddedWorkerInstanceClientStartWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public EmbeddedWorkerStartParams params;

        private EmbeddedWorkerInstanceClientStartWorkerParams(int version) {
            super(16, version);
        }

        public EmbeddedWorkerInstanceClientStartWorkerParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceClientStartWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceClientStartWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceClientStartWorkerParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceClientStartWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceClientStartWorkerParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = EmbeddedWorkerStartParams.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
        }
    }

    static final class EmbeddedWorkerInstanceClientStopWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceClientStopWorkerParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceClientStopWorkerParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceClientStopWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceClientStopWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceClientStopWorkerParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceClientStopWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceClientStopWorkerParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class EmbeddedWorkerInstanceClientResumeAfterDownloadParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private EmbeddedWorkerInstanceClientResumeAfterDownloadParams(int version) {
            super(8, version);
        }

        public EmbeddedWorkerInstanceClientResumeAfterDownloadParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceClientResumeAfterDownloadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceClientResumeAfterDownloadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceClientResumeAfterDownloadParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceClientResumeAfterDownloadParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceClientResumeAfterDownloadParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class EmbeddedWorkerInstanceClientAddMessageToConsoleParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int level;

        public String message;

        private EmbeddedWorkerInstanceClientAddMessageToConsoleParams(int version) {
            super(24, version);
        }

        public EmbeddedWorkerInstanceClientAddMessageToConsoleParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceClientAddMessageToConsoleParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceClientAddMessageToConsoleParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceClientAddMessageToConsoleParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceClientAddMessageToConsoleParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceClientAddMessageToConsoleParams(elementsOrVersion);
                result.level = decoder0.readInt(8);
                ConsoleMessageLevel.validate(result.level);
                result.message = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.level, 8);
            encoder0.encode(this.message, 16, false);
        }
    }

    static final class EmbeddedWorkerInstanceClientBindDevToolsAgentParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported agentHost;

        public AssociatedInterfaceRequestNotSupported agent;

        private EmbeddedWorkerInstanceClientBindDevToolsAgentParams(int version) {
            super(24, version);
        }

        public EmbeddedWorkerInstanceClientBindDevToolsAgentParams() {
            this(0);
        }

        public static EmbeddedWorkerInstanceClientBindDevToolsAgentParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static EmbeddedWorkerInstanceClientBindDevToolsAgentParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static EmbeddedWorkerInstanceClientBindDevToolsAgentParams decode(Decoder decoder0) {
            EmbeddedWorkerInstanceClientBindDevToolsAgentParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new EmbeddedWorkerInstanceClientBindDevToolsAgentParams(elementsOrVersion);
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
