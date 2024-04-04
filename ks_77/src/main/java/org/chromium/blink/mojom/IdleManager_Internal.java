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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.TimeDelta;

class IdleManager_Internal {
    public static final Interface.Manager<IdleManager, IdleManager.Proxy> MANAGER = new Interface.Manager<IdleManager, IdleManager.Proxy>() {
        public String getName() {
            return "blink.mojom.IdleManager";
        }

        public int getVersion() {
            return 0;
        }

        public IdleManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new IdleManager_Internal.Proxy(core, messageReceiver);
        }

        public IdleManager_Internal.Stub buildStub(Core core, IdleManager impl) {
            return new IdleManager_Internal.Stub(core, impl);
        }

        public IdleManager[] buildArray(int size) {
            return new IdleManager[size];
        }
    };

    private static final int ADD_MONITOR_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements IdleManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void addMonitor(TimeDelta threshold, IdleMonitor monitor, IdleManager.AddMonitorResponse callback) {
            IdleManager_Internal.IdleManagerAddMonitorParams _message = new IdleManager_Internal.IdleManagerAddMonitorParams();
            _message.threshold = threshold;
            _message.monitor = monitor;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new IdleManager_Internal.IdleManagerAddMonitorResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<IdleManager> {
        Stub(Core core, IdleManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(IdleManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                IdleManager_Internal.IdleManagerAddMonitorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), IdleManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = IdleManager_Internal.IdleManagerAddMonitorParams.deserialize(messageWithHeader.getPayload());
                        ((IdleManager)getImpl()).addMonitor(data.threshold, data.monitor, new IdleManager_Internal.IdleManagerAddMonitorResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class IdleManagerAddMonitorParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TimeDelta threshold;

        public IdleMonitor monitor;

        private IdleManagerAddMonitorParams(int version) {
            super(24, version);
        }

        public IdleManagerAddMonitorParams() {
            this(0);
        }

        public static IdleManagerAddMonitorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static IdleManagerAddMonitorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static IdleManagerAddMonitorParams decode(Decoder decoder0) {
            IdleManagerAddMonitorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new IdleManagerAddMonitorParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.threshold = TimeDelta.decode(decoder1);
                result.monitor = (IdleMonitor)decoder0.readServiceInterface(16, false, IdleMonitor.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.threshold, 8, false);
            encoder0.encode(this.monitor, 16, false, IdleMonitor.MANAGER);
        }
    }

    static final class IdleManagerAddMonitorResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public IdleState state;

        private IdleManagerAddMonitorResponseParams(int version) {
            super(16, version);
        }

        public IdleManagerAddMonitorResponseParams() {
            this(0);
        }

        public static IdleManagerAddMonitorResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static IdleManagerAddMonitorResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static IdleManagerAddMonitorResponseParams decode(Decoder decoder0) {
            IdleManagerAddMonitorResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new IdleManagerAddMonitorResponseParams(elementsOrVersion);
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

    static class IdleManagerAddMonitorResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final IdleManager.AddMonitorResponse mCallback;

        IdleManagerAddMonitorResponseParamsForwardToCallback(IdleManager.AddMonitorResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                IdleManager_Internal.IdleManagerAddMonitorResponseParams response = IdleManager_Internal.IdleManagerAddMonitorResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.state);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class IdleManagerAddMonitorResponseParamsProxyToResponder implements IdleManager.AddMonitorResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        IdleManagerAddMonitorResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(IdleState state) {
            IdleManager_Internal.IdleManagerAddMonitorResponseParams _response = new IdleManager_Internal.IdleManagerAddMonitorResponseParams();
            _response.state = state;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
