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

class IdleMonitor_Internal {
    public static final Interface.Manager<IdleMonitor, IdleMonitor.Proxy> MANAGER = new Interface.Manager<IdleMonitor, IdleMonitor.Proxy>() {
        public String getName() {
            return "blink.mojom.IdleMonitor";
        }

        public int getVersion() {
            return 0;
        }

        public IdleMonitor_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new IdleMonitor_Internal.Proxy(core, messageReceiver);
        }

        public IdleMonitor_Internal.Stub buildStub(Core core, IdleMonitor impl) {
            return new IdleMonitor_Internal.Stub(core, impl);
        }

        public IdleMonitor[] buildArray(int size) {
            return new IdleMonitor[size];
        }
    };

    private static final int UPDATE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements IdleMonitor.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void update(IdleState state) {
            IdleMonitor_Internal.IdleMonitorUpdateParams _message = new IdleMonitor_Internal.IdleMonitorUpdateParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<IdleMonitor> {
        Stub(Core core, IdleMonitor impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                IdleMonitor_Internal.IdleMonitorUpdateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(IdleMonitor_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = IdleMonitor_Internal.IdleMonitorUpdateParams.deserialize(messageWithHeader.getPayload());
                        ((IdleMonitor)getImpl()).update(data.state);
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
                                getCore(), IdleMonitor_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class IdleMonitorUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public IdleState state;

        private IdleMonitorUpdateParams(int version) {
            super(16, version);
        }

        public IdleMonitorUpdateParams() {
            this(0);
        }

        public static IdleMonitorUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static IdleMonitorUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static IdleMonitorUpdateParams decode(Decoder decoder0) {
            IdleMonitorUpdateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new IdleMonitorUpdateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.state = IdleState.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.state, 8, false);
        }
    }
}
