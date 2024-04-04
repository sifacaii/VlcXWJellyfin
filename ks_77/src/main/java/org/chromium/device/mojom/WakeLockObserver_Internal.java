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

class WakeLockObserver_Internal {
    public static final Interface.Manager<WakeLockObserver, WakeLockObserver.Proxy> MANAGER = new Interface.Manager<WakeLockObserver, WakeLockObserver.Proxy>() {
        public String getName() {
            return "device.mojom.WakeLockObserver";
        }

        public int getVersion() {
            return 0;
        }

        public WakeLockObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WakeLockObserver_Internal.Proxy(core, messageReceiver);
        }

        public WakeLockObserver_Internal.Stub buildStub(Core core, WakeLockObserver impl) {
            return new WakeLockObserver_Internal.Stub(core, impl);
        }

        public WakeLockObserver[] buildArray(int size) {
            return new WakeLockObserver[size];
        }
    };

    private static final int ON_WAKE_LOCK_DEACTIVATED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements WakeLockObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onWakeLockDeactivated(int type) {
            WakeLockObserver_Internal.WakeLockObserverOnWakeLockDeactivatedParams _message = new WakeLockObserver_Internal.WakeLockObserverOnWakeLockDeactivatedParams();
            _message.type = type;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<WakeLockObserver> {
        Stub(Core core, WakeLockObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WakeLockObserver_Internal.WakeLockObserverOnWakeLockDeactivatedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WakeLockObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = WakeLockObserver_Internal.WakeLockObserverOnWakeLockDeactivatedParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLockObserver)getImpl()).onWakeLockDeactivated(data.type);
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
                                getCore(), WakeLockObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WakeLockObserverOnWakeLockDeactivatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        private WakeLockObserverOnWakeLockDeactivatedParams(int version) {
            super(16, version);
        }

        public WakeLockObserverOnWakeLockDeactivatedParams() {
            this(0);
        }

        public static WakeLockObserverOnWakeLockDeactivatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockObserverOnWakeLockDeactivatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockObserverOnWakeLockDeactivatedParams decode(Decoder decoder0) {
            WakeLockObserverOnWakeLockDeactivatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockObserverOnWakeLockDeactivatedParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                WakeLockType.validate(result.type);
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
}
