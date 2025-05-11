package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.AecDumpAgent;
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
import org.chromium.mojo_base.mojom.File;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent_Internal.class */
class AecDumpAgent_Internal {
    public static final Interface.Manager<AecDumpAgent, AecDumpAgent.Proxy> MANAGER = new Interface.Manager<AecDumpAgent, AecDumpAgent.Proxy>() { // from class: org.chromium.blink.mojom.AecDumpAgent_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "blink.mojom.AecDumpAgent";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }



        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, AecDumpAgent impl) {
            return new Stub(core, impl);
        }

        @Override
        protected AecDumpAgent.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public AecDumpAgent[] buildArray(int size) {
            return new AecDumpAgent[size];
        }
    };
    private static final int START_ORDINAL = 0;
    private static final int STOP_ORDINAL = 1;

    AecDumpAgent_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements AecDumpAgent.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.blink.mojom.AecDumpAgent
        public void start(File file) {
            AecDumpAgentStartParams _message = new AecDumpAgentStartParams();
            _message.file = file;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.blink.mojom.AecDumpAgent
        public void stop() {
            AecDumpAgentStopParams _message = new AecDumpAgentStopParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<AecDumpAgent> {
        Stub(Core core, AecDumpAgent impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AecDumpAgent_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        AecDumpAgentStartParams data = AecDumpAgentStartParams.deserialize(messageWithHeader.getPayload());
                        getImpl().start(data.file);
                        return true;
                    case 1:
                        AecDumpAgentStopParams.deserialize(messageWithHeader.getPayload());
                        getImpl().stop();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), AecDumpAgent_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent_Internal$AecDumpAgentStartParams.class */
    static final class AecDumpAgentStartParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public File file;

        private AecDumpAgentStartParams(int version) {
            super(16, version);
        }

        public AecDumpAgentStartParams() {
            this(0);
        }

        public static AecDumpAgentStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AecDumpAgentStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AecDumpAgentStartParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AecDumpAgentStartParams result = new AecDumpAgentStartParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.file = File.decode(decoder1);
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
            encoder0.encode((Struct) this.file, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AecDumpAgent_Internal$AecDumpAgentStopParams.class */
    static final class AecDumpAgentStopParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AecDumpAgentStopParams(int version) {
            super(8, version);
        }

        public AecDumpAgentStopParams() {
            this(0);
        }

        public static AecDumpAgentStopParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AecDumpAgentStopParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AecDumpAgentStopParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AecDumpAgentStopParams result = new AecDumpAgentStopParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
