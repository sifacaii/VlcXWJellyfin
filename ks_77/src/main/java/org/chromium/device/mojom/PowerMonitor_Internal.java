package org.chromium.device.mojom;

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

class PowerMonitor_Internal {
    public static final Interface.Manager<PowerMonitor, PowerMonitor.Proxy> MANAGER = new Interface.Manager<PowerMonitor, PowerMonitor.Proxy>() {
        public String getName() {
            return "device.mojom.PowerMonitor";
        }

        public int getVersion() {
            return 0;
        }

        public PowerMonitor_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PowerMonitor_Internal.Proxy(core, messageReceiver);
        }

        public PowerMonitor_Internal.Stub buildStub(Core core, PowerMonitor impl) {
            return new PowerMonitor_Internal.Stub(core, impl);
        }

        public PowerMonitor[] buildArray(int size) {
            return new PowerMonitor[size];
        }
    };

    private static final int ADD_CLIENT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PowerMonitor.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void addClient(PowerMonitorClient client) {
            PowerMonitor_Internal.PowerMonitorAddClientParams _message = new PowerMonitor_Internal.PowerMonitorAddClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<PowerMonitor> {
        Stub(Core core, PowerMonitor impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PowerMonitor_Internal.PowerMonitorAddClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PowerMonitor_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PowerMonitor_Internal.PowerMonitorAddClientParams.deserialize(messageWithHeader.getPayload());
                        ((PowerMonitor)getImpl()).addClient(data.client);
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
                                getCore(), PowerMonitor_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PowerMonitorAddClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PowerMonitorClient client;

        private PowerMonitorAddClientParams(int version) {
            super(16, version);
        }

        public PowerMonitorAddClientParams() {
            this(0);
        }

        public static PowerMonitorAddClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PowerMonitorAddClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PowerMonitorAddClientParams decode(Decoder decoder0) {
            PowerMonitorAddClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PowerMonitorAddClientParams(elementsOrVersion);
                result.client = (PowerMonitorClient)decoder0.readServiceInterface(8, false, PowerMonitorClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false, PowerMonitorClient.MANAGER);
        }
    }
}
