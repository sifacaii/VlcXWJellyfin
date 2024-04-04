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

class TimeZoneMonitorClient_Internal {
    public static final Interface.Manager<TimeZoneMonitorClient, TimeZoneMonitorClient.Proxy> MANAGER = new Interface.Manager<TimeZoneMonitorClient, TimeZoneMonitorClient.Proxy>() {
        public String getName() {
            return "device.mojom.TimeZoneMonitorClient";
        }

        public int getVersion() {
            return 0;
        }

        public TimeZoneMonitorClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new TimeZoneMonitorClient_Internal.Proxy(core, messageReceiver);
        }

        public TimeZoneMonitorClient_Internal.Stub buildStub(Core core, TimeZoneMonitorClient impl) {
            return new TimeZoneMonitorClient_Internal.Stub(core, impl);
        }

        public TimeZoneMonitorClient[] buildArray(int size) {
            return new TimeZoneMonitorClient[size];
        }
    };

    private static final int ON_TIME_ZONE_CHANGE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements TimeZoneMonitorClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onTimeZoneChange(String tzInfo) {
            TimeZoneMonitorClient_Internal.TimeZoneMonitorClientOnTimeZoneChangeParams _message = new TimeZoneMonitorClient_Internal.TimeZoneMonitorClientOnTimeZoneChangeParams();
            _message.tzInfo = tzInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<TimeZoneMonitorClient> {
        Stub(Core core, TimeZoneMonitorClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                TimeZoneMonitorClient_Internal.TimeZoneMonitorClientOnTimeZoneChangeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TimeZoneMonitorClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = TimeZoneMonitorClient_Internal.TimeZoneMonitorClientOnTimeZoneChangeParams.deserialize(messageWithHeader.getPayload());
                        ((TimeZoneMonitorClient)getImpl()).onTimeZoneChange(data.tzInfo);
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
                                getCore(), TimeZoneMonitorClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class TimeZoneMonitorClientOnTimeZoneChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String tzInfo;

        private TimeZoneMonitorClientOnTimeZoneChangeParams(int version) {
            super(16, version);
        }

        public TimeZoneMonitorClientOnTimeZoneChangeParams() {
            this(0);
        }

        public static TimeZoneMonitorClientOnTimeZoneChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TimeZoneMonitorClientOnTimeZoneChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TimeZoneMonitorClientOnTimeZoneChangeParams decode(Decoder decoder0) {
            TimeZoneMonitorClientOnTimeZoneChangeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TimeZoneMonitorClientOnTimeZoneChangeParams(elementsOrVersion);
                result.tzInfo = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.tzInfo, 8, false);
        }
    }
}
