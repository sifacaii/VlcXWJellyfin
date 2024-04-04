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

class TimeZoneMonitor_Internal {
    public static final Interface.Manager<TimeZoneMonitor, TimeZoneMonitor.Proxy> MANAGER = new Interface.Manager<TimeZoneMonitor, TimeZoneMonitor.Proxy>() {
        public String getName() {
            return "device.mojom.TimeZoneMonitor";
        }

        public int getVersion() {
            return 0;
        }

        public TimeZoneMonitor_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new TimeZoneMonitor_Internal.Proxy(core, messageReceiver);
        }

        public TimeZoneMonitor_Internal.Stub buildStub(Core core, TimeZoneMonitor impl) {
            return new TimeZoneMonitor_Internal.Stub(core, impl);
        }

        public TimeZoneMonitor[] buildArray(int size) {
            return new TimeZoneMonitor[size];
        }
    };

    private static final int ADD_CLIENT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements TimeZoneMonitor.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void addClient(TimeZoneMonitorClient client) {
            TimeZoneMonitor_Internal.TimeZoneMonitorAddClientParams _message = new TimeZoneMonitor_Internal.TimeZoneMonitorAddClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<TimeZoneMonitor> {
        Stub(Core core, TimeZoneMonitor impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                TimeZoneMonitor_Internal.TimeZoneMonitorAddClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TimeZoneMonitor_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = TimeZoneMonitor_Internal.TimeZoneMonitorAddClientParams.deserialize(messageWithHeader.getPayload());
                        ((TimeZoneMonitor)getImpl()).addClient(data.client);
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
                                getCore(), TimeZoneMonitor_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class TimeZoneMonitorAddClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TimeZoneMonitorClient client;

        private TimeZoneMonitorAddClientParams(int version) {
            super(16, version);
        }

        public TimeZoneMonitorAddClientParams() {
            this(0);
        }

        public static TimeZoneMonitorAddClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TimeZoneMonitorAddClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TimeZoneMonitorAddClientParams decode(Decoder decoder0) {
            TimeZoneMonitorAddClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TimeZoneMonitorAddClientParams(elementsOrVersion);
                result.client = (TimeZoneMonitorClient)decoder0.readServiceInterface(8, false, TimeZoneMonitorClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false, TimeZoneMonitorClient.MANAGER);
        }
    }
}
