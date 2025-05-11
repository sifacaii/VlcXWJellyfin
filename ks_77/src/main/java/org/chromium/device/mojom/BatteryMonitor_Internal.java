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

class BatteryMonitor_Internal {
    public static final Interface.Manager<BatteryMonitor, BatteryMonitor.Proxy> MANAGER = new Interface.Manager<BatteryMonitor, BatteryMonitor.Proxy>() {
        public String getName() {
            return "device.mojom.BatteryMonitor";
        }

        public int getVersion() {
            return 0;
        }

        public BatteryMonitor_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BatteryMonitor_Internal.Proxy(core, messageReceiver);
        }

        public BatteryMonitor_Internal.Stub buildStub(Core core, BatteryMonitor impl) {
            return new BatteryMonitor_Internal.Stub(core, impl);
        }

        public BatteryMonitor[] buildArray(int size) {
            return new BatteryMonitor[size];
        }
    };

    private static final int QUERY_NEXT_STATUS_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements BatteryMonitor.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void queryNextStatus(BatteryMonitor.QueryNextStatusResponse callback) {
            BatteryMonitor_Internal.BatteryMonitorQueryNextStatusParams _message = new BatteryMonitor_Internal.BatteryMonitorQueryNextStatusParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BatteryMonitor_Internal.BatteryMonitorQueryNextStatusResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<BatteryMonitor> {
        Stub(Core core, BatteryMonitor impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BatteryMonitor_Internal.MANAGER, messageWithHeader);
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
                                getCore(), BatteryMonitor_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        BatteryMonitor_Internal.BatteryMonitorQueryNextStatusParams.deserialize(messageWithHeader.getPayload());
                        ((BatteryMonitor)getImpl()).queryNextStatus(new BatteryMonitor_Internal.BatteryMonitorQueryNextStatusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BatteryMonitorQueryNextStatusParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BatteryMonitorQueryNextStatusParams(int version) {
            super(8, version);
        }

        public BatteryMonitorQueryNextStatusParams() {
            this(0);
        }

        public static BatteryMonitorQueryNextStatusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BatteryMonitorQueryNextStatusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BatteryMonitorQueryNextStatusParams decode(Decoder decoder0) {
            BatteryMonitorQueryNextStatusParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BatteryMonitorQueryNextStatusParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BatteryMonitorQueryNextStatusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BatteryStatus status;

        private BatteryMonitorQueryNextStatusResponseParams(int version) {
            super(16, version);
        }

        public BatteryMonitorQueryNextStatusResponseParams() {
            this(0);
        }

        public static BatteryMonitorQueryNextStatusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BatteryMonitorQueryNextStatusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BatteryMonitorQueryNextStatusResponseParams decode(Decoder decoder0) {
            BatteryMonitorQueryNextStatusResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BatteryMonitorQueryNextStatusResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.status = BatteryStatus.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8, false);
        }
    }

    static class BatteryMonitorQueryNextStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BatteryMonitor.QueryNextStatusResponse mCallback;

        BatteryMonitorQueryNextStatusResponseParamsForwardToCallback(BatteryMonitor.QueryNextStatusResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                BatteryMonitor_Internal.BatteryMonitorQueryNextStatusResponseParams response = BatteryMonitor_Internal.BatteryMonitorQueryNextStatusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.status);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BatteryMonitorQueryNextStatusResponseParamsProxyToResponder implements BatteryMonitor.QueryNextStatusResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BatteryMonitorQueryNextStatusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BatteryStatus status) {
            BatteryMonitor_Internal.BatteryMonitorQueryNextStatusResponseParams _response = new BatteryMonitor_Internal.BatteryMonitorQueryNextStatusResponseParams();
            _response.status = status;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
