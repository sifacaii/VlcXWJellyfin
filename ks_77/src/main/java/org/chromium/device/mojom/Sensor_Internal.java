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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class Sensor_Internal {
    public static final Interface.Manager<Sensor, Sensor.Proxy> MANAGER = new Interface.Manager<Sensor, Sensor.Proxy>() {
        public String getName() {
            return "device.mojom.Sensor";
        }

        public int getVersion() {
            return 0;
        }

        public Sensor_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Sensor_Internal.Proxy(core, messageReceiver);
        }

        public Sensor_Internal.Stub buildStub(Core core, Sensor impl) {
            return new Sensor_Internal.Stub(core, impl);
        }

        public Sensor[] buildArray(int size) {
            return new Sensor[size];
        }
    };

    private static final int GET_DEFAULT_CONFIGURATION_ORDINAL = 0;

    private static final int ADD_CONFIGURATION_ORDINAL = 1;

    private static final int REMOVE_CONFIGURATION_ORDINAL = 2;

    private static final int SUSPEND_ORDINAL = 3;

    private static final int RESUME_ORDINAL = 4;

    private static final int CONFIGURE_READING_CHANGE_NOTIFICATIONS_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements Sensor.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getDefaultConfiguration(Sensor.GetDefaultConfigurationResponse callback) {
            Sensor_Internal.SensorGetDefaultConfigurationParams _message = new Sensor_Internal.SensorGetDefaultConfigurationParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new Sensor_Internal.SensorGetDefaultConfigurationResponseParamsForwardToCallback(callback));
        }

        public void addConfiguration(SensorConfiguration configuration, Sensor.AddConfigurationResponse callback) {
            Sensor_Internal.SensorAddConfigurationParams _message = new Sensor_Internal.SensorAddConfigurationParams();
            _message.configuration = configuration;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new Sensor_Internal.SensorAddConfigurationResponseParamsForwardToCallback(callback));
        }

        public void removeConfiguration(SensorConfiguration configuration) {
            Sensor_Internal.SensorRemoveConfigurationParams _message = new Sensor_Internal.SensorRemoveConfigurationParams();
            _message.configuration = configuration;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void suspend() {
            Sensor_Internal.SensorSuspendParams _message = new Sensor_Internal.SensorSuspendParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void resume() {
            Sensor_Internal.SensorResumeParams _message = new Sensor_Internal.SensorResumeParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void configureReadingChangeNotifications(boolean enabled) {
            Sensor_Internal.SensorConfigureReadingChangeNotificationsParams _message = new Sensor_Internal.SensorConfigureReadingChangeNotificationsParams();
            _message.enabled = enabled;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    static final class Stub extends Interface.Stub<Sensor> {
        Stub(Core core, Sensor impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Sensor_Internal.SensorRemoveConfigurationParams sensorRemoveConfigurationParams;
                Sensor_Internal.SensorConfigureReadingChangeNotificationsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Sensor_Internal.MANAGER, messageWithHeader);
                    case 2:
                        sensorRemoveConfigurationParams = Sensor_Internal.SensorRemoveConfigurationParams.deserialize(messageWithHeader.getPayload());
                        ((Sensor)getImpl()).removeConfiguration(sensorRemoveConfigurationParams.configuration);
                        return true;
                    case 3:
                        Sensor_Internal.SensorSuspendParams.deserialize(messageWithHeader.getPayload());
                        ((Sensor)getImpl()).suspend();
                        return true;
                    case 4:
                        Sensor_Internal.SensorResumeParams.deserialize(messageWithHeader.getPayload());
                        ((Sensor)getImpl()).resume();
                        return true;
                    case 5:
                        data = Sensor_Internal.SensorConfigureReadingChangeNotificationsParams.deserialize(messageWithHeader.getPayload());
                        ((Sensor)getImpl()).configureReadingChangeNotifications(data.enabled);
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
                Sensor_Internal.SensorAddConfigurationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Sensor_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        Sensor_Internal.SensorGetDefaultConfigurationParams.deserialize(messageWithHeader.getPayload());
                        ((Sensor)getImpl()).getDefaultConfiguration(new Sensor_Internal.SensorGetDefaultConfigurationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = Sensor_Internal.SensorAddConfigurationParams.deserialize(messageWithHeader.getPayload());
                        ((Sensor)getImpl()).addConfiguration(data.configuration, new Sensor_Internal.SensorAddConfigurationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SensorGetDefaultConfigurationParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SensorGetDefaultConfigurationParams(int version) {
            super(8, version);
        }

        public SensorGetDefaultConfigurationParams() {
            this(0);
        }

        public static SensorGetDefaultConfigurationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorGetDefaultConfigurationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorGetDefaultConfigurationParams decode(Decoder decoder0) {
            SensorGetDefaultConfigurationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorGetDefaultConfigurationParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SensorGetDefaultConfigurationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SensorConfiguration configuration;

        private SensorGetDefaultConfigurationResponseParams(int version) {
            super(16, version);
        }

        public SensorGetDefaultConfigurationResponseParams() {
            this(0);
        }

        public static SensorGetDefaultConfigurationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorGetDefaultConfigurationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorGetDefaultConfigurationResponseParams decode(Decoder decoder0) {
            SensorGetDefaultConfigurationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorGetDefaultConfigurationResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.configuration = SensorConfiguration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.configuration, 8, false);
        }
    }

    static class SensorGetDefaultConfigurationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Sensor.GetDefaultConfigurationResponse mCallback;

        SensorGetDefaultConfigurationResponseParamsForwardToCallback(Sensor.GetDefaultConfigurationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                Sensor_Internal.SensorGetDefaultConfigurationResponseParams response = Sensor_Internal.SensorGetDefaultConfigurationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.configuration);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SensorGetDefaultConfigurationResponseParamsProxyToResponder implements Sensor.GetDefaultConfigurationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SensorGetDefaultConfigurationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(SensorConfiguration configuration) {
            Sensor_Internal.SensorGetDefaultConfigurationResponseParams _response = new Sensor_Internal.SensorGetDefaultConfigurationResponseParams();
            _response.configuration = configuration;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SensorAddConfigurationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SensorConfiguration configuration;

        private SensorAddConfigurationParams(int version) {
            super(16, version);
        }

        public SensorAddConfigurationParams() {
            this(0);
        }

        public static SensorAddConfigurationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorAddConfigurationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorAddConfigurationParams decode(Decoder decoder0) {
            SensorAddConfigurationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorAddConfigurationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.configuration = SensorConfiguration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.configuration, 8, false);
        }
    }

    static final class SensorAddConfigurationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private SensorAddConfigurationResponseParams(int version) {
            super(16, version);
        }

        public SensorAddConfigurationResponseParams() {
            this(0);
        }

        public static SensorAddConfigurationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorAddConfigurationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorAddConfigurationResponseParams decode(Decoder decoder0) {
            SensorAddConfigurationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorAddConfigurationResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class SensorAddConfigurationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Sensor.AddConfigurationResponse mCallback;

        SensorAddConfigurationResponseParamsForwardToCallback(Sensor.AddConfigurationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                Sensor_Internal.SensorAddConfigurationResponseParams response = Sensor_Internal.SensorAddConfigurationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SensorAddConfigurationResponseParamsProxyToResponder implements Sensor.AddConfigurationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SensorAddConfigurationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Sensor_Internal.SensorAddConfigurationResponseParams _response = new Sensor_Internal.SensorAddConfigurationResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class SensorRemoveConfigurationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SensorConfiguration configuration;

        private SensorRemoveConfigurationParams(int version) {
            super(16, version);
        }

        public SensorRemoveConfigurationParams() {
            this(0);
        }

        public static SensorRemoveConfigurationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorRemoveConfigurationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorRemoveConfigurationParams decode(Decoder decoder0) {
            SensorRemoveConfigurationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorRemoveConfigurationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.configuration = SensorConfiguration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.configuration, 8, false);
        }
    }

    static final class SensorSuspendParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SensorSuspendParams(int version) {
            super(8, version);
        }

        public SensorSuspendParams() {
            this(0);
        }

        public static SensorSuspendParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorSuspendParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorSuspendParams decode(Decoder decoder0) {
            SensorSuspendParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorSuspendParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SensorResumeParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SensorResumeParams(int version) {
            super(8, version);
        }

        public SensorResumeParams() {
            this(0);
        }

        public static SensorResumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorResumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorResumeParams decode(Decoder decoder0) {
            SensorResumeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorResumeParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SensorConfigureReadingChangeNotificationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean enabled;

        private SensorConfigureReadingChangeNotificationsParams(int version) {
            super(16, version);
        }

        public SensorConfigureReadingChangeNotificationsParams() {
            this(0);
        }

        public static SensorConfigureReadingChangeNotificationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorConfigureReadingChangeNotificationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorConfigureReadingChangeNotificationsParams decode(Decoder decoder0) {
            SensorConfigureReadingChangeNotificationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorConfigureReadingChangeNotificationsParams(elementsOrVersion);
                result.enabled = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.enabled, 8, 0);
        }
    }
}
