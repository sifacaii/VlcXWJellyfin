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

class SensorProvider_Internal {
    public static final Interface.Manager<SensorProvider, SensorProvider.Proxy> MANAGER = new Interface.Manager<SensorProvider, SensorProvider.Proxy>() {
        public String getName() {
            return "device.mojom.SensorProvider";
        }

        public int getVersion() {
            return 0;
        }

        public SensorProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SensorProvider_Internal.Proxy(core, messageReceiver);
        }

        public SensorProvider_Internal.Stub buildStub(Core core, SensorProvider impl) {
            return new SensorProvider_Internal.Stub(core, impl);
        }

        public SensorProvider[] buildArray(int size) {
            return new SensorProvider[size];
        }
    };

    private static final int GET_SENSOR_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements SensorProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getSensor(int type, SensorProvider.GetSensorResponse callback) {
            SensorProvider_Internal.SensorProviderGetSensorParams _message = new SensorProvider_Internal.SensorProviderGetSensorParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new SensorProvider_Internal.SensorProviderGetSensorResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<SensorProvider> {
        Stub(Core core, SensorProvider impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SensorProvider_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                SensorProvider_Internal.SensorProviderGetSensorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), SensorProvider_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = SensorProvider_Internal.SensorProviderGetSensorParams.deserialize(messageWithHeader.getPayload());
                        ((SensorProvider)getImpl()).getSensor(data.type, new SensorProvider_Internal.SensorProviderGetSensorResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SensorProviderGetSensorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        private SensorProviderGetSensorParams(int version) {
            super(16, version);
        }

        public SensorProviderGetSensorParams() {
            this(0);
        }

        public static SensorProviderGetSensorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorProviderGetSensorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorProviderGetSensorParams decode(Decoder decoder0) {
            SensorProviderGetSensorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorProviderGetSensorParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                SensorType.validate(result.type);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
        }
    }

    static final class SensorProviderGetSensorResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int result;

        public SensorInitParams initParams;

        private SensorProviderGetSensorResponseParams(int version) {
            super(24, version);
        }

        public SensorProviderGetSensorResponseParams() {
            this(0);
        }

        public static SensorProviderGetSensorResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SensorProviderGetSensorResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SensorProviderGetSensorResponseParams decode(Decoder decoder0) {
            SensorProviderGetSensorResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SensorProviderGetSensorResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                SensorCreationResult.validate(result.result);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.initParams = SensorInitParams.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
            encoder0.encode(this.initParams, 16, true);
        }
    }

    static class SensorProviderGetSensorResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final SensorProvider.GetSensorResponse mCallback;

        SensorProviderGetSensorResponseParamsForwardToCallback(SensorProvider.GetSensorResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                SensorProvider_Internal.SensorProviderGetSensorResponseParams response = SensorProvider_Internal.SensorProviderGetSensorResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.initParams);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class SensorProviderGetSensorResponseParamsProxyToResponder implements SensorProvider.GetSensorResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        SensorProviderGetSensorResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer result, SensorInitParams initParams) {
            SensorProvider_Internal.SensorProviderGetSensorResponseParams _response = new SensorProvider_Internal.SensorProviderGetSensorResponseParams();
            _response.result = result.intValue();
            _response.initParams = initParams;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
