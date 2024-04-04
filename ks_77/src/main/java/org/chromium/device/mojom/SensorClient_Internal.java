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

class SensorClient_Internal {
    public static final Interface.Manager<SensorClient, SensorClient.Proxy> MANAGER = new Interface.Manager<SensorClient, SensorClient.Proxy>() {
        public String getName() {
            return "device.mojom.SensorClient";
        }

        public int getVersion() {
            return 0;
        }

        public SensorClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SensorClient_Internal.Proxy(core, messageReceiver);
        }

        public SensorClient_Internal.Stub buildStub(Core core, SensorClient impl) {
            return new SensorClient_Internal.Stub(core, impl);
        }

        public SensorClient[] buildArray(int size) {
            return new SensorClient[size];
        }
    };

    private static final int RAISE_ERROR_ORDINAL = 0;

    private static final int SENSOR_READING_CHANGED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements SensorClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void raiseError() {
            SensorClient_Internal.SensorClientRaiseErrorParams _message = new SensorClient_Internal.SensorClientRaiseErrorParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void sensorReadingChanged() {
            SensorClient_Internal.SensorClientSensorReadingChangedParams _message = new SensorClient_Internal.SensorClientSensorReadingChangedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<SensorClient> {
        Stub(Core core, SensorClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SensorClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        SensorClient_Internal.SensorClientRaiseErrorParams.deserialize(messageWithHeader.getPayload());
                        ((SensorClient)getImpl()).raiseError();
                        return true;
                    case 1:
                        SensorClient_Internal.SensorClientSensorReadingChangedParams.deserialize(messageWithHeader.getPayload());
                        ((SensorClient)getImpl()).sensorReadingChanged();
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
                                getCore(), SensorClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SensorClientRaiseErrorParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SensorClientRaiseErrorParams(int version) {
            super(8, version);
        }

        public SensorClientRaiseErrorParams() {
            this(0);
        }

        public static SensorClientRaiseErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorClientRaiseErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorClientRaiseErrorParams decode(Decoder decoder0) {
            SensorClientRaiseErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorClientRaiseErrorParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SensorClientSensorReadingChangedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SensorClientSensorReadingChangedParams(int version) {
            super(8, version);
        }

        public SensorClientSensorReadingChangedParams() {
            this(0);
        }

        public static SensorClientSensorReadingChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorClientSensorReadingChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorClientSensorReadingChangedParams decode(Decoder decoder0) {
            SensorClientSensorReadingChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorClientSensorReadingChangedParams(elementsOrVersion);
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
