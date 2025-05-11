//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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

class AecDumpManager_Internal {
    public static final Interface.Manager<AecDumpManager, AecDumpManager.Proxy> MANAGER = new Interface.Manager<AecDumpManager, AecDumpManager.Proxy>() {
        public String getName() {
            return "blink.mojom.AecDumpManager";
        }

        public int getVersion() {
            return 0;
        }

        public Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        public Stub buildStub(Core core, AecDumpManager impl) {
            return new Stub(core, impl);
        }

        public AecDumpManager[] buildArray(int size) {
            return new AecDumpManager[size];
        }
    };
    private static final int ADD_ORDINAL = 0;

    AecDumpManager_Internal() {
    }

    static final class AecDumpManagerAddParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public AecDumpAgent agent;

        private AecDumpManagerAddParams(int version) {
            super(16, version);
        }

        public AecDumpManagerAddParams() {
            this(0);
        }

        public static AecDumpManagerAddParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AecDumpManagerAddParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AecDumpManagerAddParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AecDumpManagerAddParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AecDumpManagerAddParams(elementsOrVersion);
                    result.agent = (AecDumpAgent)decoder0.readServiceInterface(8, false, AecDumpAgent.MANAGER);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.agent, 8, false, AecDumpAgent.MANAGER);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class Stub extends Interface.Stub<AecDumpManager> {
        Stub(Core core, AecDumpManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                } else {
                    switch (header.getType()) {
                        case -2:
                            return InterfaceControlMessagesHelper.handleRunOrClosePipe(AecDumpManager_Internal.MANAGER, messageWithHeader);
                        case 0:
                            AecDumpManagerAddParams data = AecDumpManager_Internal.AecDumpManagerAddParams.deserialize(messageWithHeader.getPayload());
                            ((AecDumpManager)this.getImpl()).add(data.agent);
                            return true;
                        default:
                            return false;
                    }
                }
            } catch (DeserializationException var5) {
                System.err.println(var5.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                } else {
                    switch (header.getType()) {
                        case -1:
                            return InterfaceControlMessagesHelper.handleRun(this.getCore(), AecDumpManager_Internal.MANAGER, messageWithHeader, receiver);
                        default:
                            return false;
                    }
                }
            } catch (DeserializationException var5) {
                System.err.println(var5.toString());
                return false;
            }
        }
    }

    static final class Proxy extends Interface.AbstractProxy implements AecDumpManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void add(AecDumpAgent agent) {
            AecDumpManagerAddParams _message = new AecDumpManagerAddParams();
            _message.agent = agent;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }
}
