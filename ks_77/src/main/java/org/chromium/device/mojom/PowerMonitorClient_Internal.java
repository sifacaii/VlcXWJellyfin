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

class PowerMonitorClient_Internal {
    public static final Interface.Manager<PowerMonitorClient, PowerMonitorClient.Proxy> MANAGER = new Interface.Manager<PowerMonitorClient, PowerMonitorClient.Proxy>() {
        public String getName() {
            return "device.mojom.PowerMonitorClient";
        }

        public int getVersion() {
            return 0;
        }

        public PowerMonitorClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PowerMonitorClient_Internal.Proxy(core, messageReceiver);
        }

        public PowerMonitorClient_Internal.Stub buildStub(Core core, PowerMonitorClient impl) {
            return new PowerMonitorClient_Internal.Stub(core, impl);
        }

        public PowerMonitorClient[] buildArray(int size) {
            return new PowerMonitorClient[size];
        }
    };

    private static final int POWER_STATE_CHANGE_ORDINAL = 0;

    private static final int SUSPEND_ORDINAL = 1;

    private static final int RESUME_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements PowerMonitorClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void powerStateChange(boolean onBatteryPower) {
            PowerMonitorClient_Internal.PowerMonitorClientPowerStateChangeParams _message = new PowerMonitorClient_Internal.PowerMonitorClientPowerStateChangeParams();
            _message.onBatteryPower = onBatteryPower;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void suspend() {
            PowerMonitorClient_Internal.PowerMonitorClientSuspendParams _message = new PowerMonitorClient_Internal.PowerMonitorClientSuspendParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void resume() {
            PowerMonitorClient_Internal.PowerMonitorClientResumeParams _message = new PowerMonitorClient_Internal.PowerMonitorClientResumeParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<PowerMonitorClient> {
        Stub(Core core, PowerMonitorClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PowerMonitorClient_Internal.PowerMonitorClientPowerStateChangeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PowerMonitorClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PowerMonitorClient_Internal.PowerMonitorClientPowerStateChangeParams.deserialize(messageWithHeader.getPayload());
                        ((PowerMonitorClient)getImpl()).powerStateChange(data.onBatteryPower);
                        return true;
                    case 1:
                        PowerMonitorClient_Internal.PowerMonitorClientSuspendParams.deserialize(messageWithHeader.getPayload());
                        ((PowerMonitorClient)getImpl()).suspend();
                        return true;
                    case 2:
                        PowerMonitorClient_Internal.PowerMonitorClientResumeParams.deserialize(messageWithHeader.getPayload());
                        ((PowerMonitorClient)getImpl()).resume();
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
                                getCore(), PowerMonitorClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PowerMonitorClientPowerStateChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean onBatteryPower;

        private PowerMonitorClientPowerStateChangeParams(int version) {
            super(16, version);
        }

        public PowerMonitorClientPowerStateChangeParams() {
            this(0);
        }

        public static PowerMonitorClientPowerStateChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PowerMonitorClientPowerStateChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PowerMonitorClientPowerStateChangeParams decode(Decoder decoder0) {
            PowerMonitorClientPowerStateChangeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PowerMonitorClientPowerStateChangeParams(elementsOrVersion);
                result.onBatteryPower = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.onBatteryPower, 8, 0);
        }
    }

    static final class PowerMonitorClientSuspendParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PowerMonitorClientSuspendParams(int version) {
            super(8, version);
        }

        public PowerMonitorClientSuspendParams() {
            this(0);
        }

        public static PowerMonitorClientSuspendParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PowerMonitorClientSuspendParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PowerMonitorClientSuspendParams decode(Decoder decoder0) {
            PowerMonitorClientSuspendParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PowerMonitorClientSuspendParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class PowerMonitorClientResumeParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PowerMonitorClientResumeParams(int version) {
            super(8, version);
        }

        public PowerMonitorClientResumeParams() {
            this(0);
        }

        public static PowerMonitorClientResumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PowerMonitorClientResumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PowerMonitorClientResumeParams decode(Decoder decoder0) {
            PowerMonitorClientResumeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PowerMonitorClientResumeParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
