package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.WakeLock;
import org.chromium.device.mojom.WakeLockReason;
import org.chromium.device.mojom.WakeLockType;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class WakeLockService_Internal {
    public static final Interface.Manager<WakeLockService, WakeLockService.Proxy> MANAGER = new Interface.Manager<WakeLockService, WakeLockService.Proxy>() {
        public String getName() {
            return "blink.mojom.WakeLockService";
        }

        public int getVersion() {
            return 0;
        }

        public WakeLockService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WakeLockService_Internal.Proxy(core, messageReceiver);
        }

        public WakeLockService_Internal.Stub buildStub(Core core, WakeLockService impl) {
            return new WakeLockService_Internal.Stub(core, impl);
        }

        public WakeLockService[] buildArray(int size) {
            return new WakeLockService[size];
        }
    };

    private static final int GET_WAKE_LOCK_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements WakeLockService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getWakeLock(int type, int reason, String description, InterfaceRequest<WakeLock> wakeLock) {
            WakeLockService_Internal.WakeLockServiceGetWakeLockParams _message = new WakeLockService_Internal.WakeLockServiceGetWakeLockParams();
            _message.type = type;
            _message.reason = reason;
            _message.description = description;
            _message.wakeLock = wakeLock;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<WakeLockService> {
        Stub(Core core, WakeLockService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WakeLockService_Internal.WakeLockServiceGetWakeLockParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WakeLockService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = WakeLockService_Internal.WakeLockServiceGetWakeLockParams.deserialize(messageWithHeader.getPayload());
                        ((WakeLockService)getImpl()).getWakeLock(data.type, data.reason, data.description, data.wakeLock);
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
                                getCore(), WakeLockService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WakeLockServiceGetWakeLockParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        public int reason;

        public String description;

        public InterfaceRequest<WakeLock> wakeLock;

        private WakeLockServiceGetWakeLockParams(int version) {
            super(32, version);
        }

        public WakeLockServiceGetWakeLockParams() {
            this(0);
        }

        public static WakeLockServiceGetWakeLockParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WakeLockServiceGetWakeLockParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WakeLockServiceGetWakeLockParams decode(Decoder decoder0) {
            WakeLockServiceGetWakeLockParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockServiceGetWakeLockParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                WakeLockType.validate(result.type);
                result.reason = decoder0.readInt(12);
                WakeLockReason.validate(result.reason);
                result.description = decoder0.readString(16, false);
                result.wakeLock = decoder0.readInterfaceRequest(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
            encoder0.encode(this.reason, 12);
            encoder0.encode(this.description, 16, false);
            encoder0.encode(this.wakeLock, 24, false);
        }
    }
}
