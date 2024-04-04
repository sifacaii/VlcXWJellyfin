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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class BadgeService_Internal {
    public static final Interface.Manager<BadgeService, BadgeService.Proxy> MANAGER = new Interface.Manager<BadgeService, BadgeService.Proxy>() {
        public String getName() {
            return "blink.mojom.BadgeService";
        }

        public int getVersion() {
            return 0;
        }

        public BadgeService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BadgeService_Internal.Proxy(core, messageReceiver);
        }

        public BadgeService_Internal.Stub buildStub(Core core, BadgeService impl) {
            return new BadgeService_Internal.Stub(core, impl);
        }

        public BadgeService[] buildArray(int size) {
            return new BadgeService[size];
        }
    };

    private static final int SET_INTEGER_ORDINAL = 0;

    private static final int SET_FLAG_ORDINAL = 1;

    private static final int CLEAR_BADGE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements BadgeService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setInteger(long content) {
            BadgeService_Internal.BadgeServiceSetIntegerParams _message = new BadgeService_Internal.BadgeServiceSetIntegerParams();
            _message.content = content;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setFlag() {
            BadgeService_Internal.BadgeServiceSetFlagParams _message = new BadgeService_Internal.BadgeServiceSetFlagParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void clearBadge() {
            BadgeService_Internal.BadgeServiceClearBadgeParams _message = new BadgeService_Internal.BadgeServiceClearBadgeParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<BadgeService> {
        Stub(Core core, BadgeService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BadgeService_Internal.BadgeServiceSetIntegerParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BadgeService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = BadgeService_Internal.BadgeServiceSetIntegerParams.deserialize(messageWithHeader.getPayload());
                        ((BadgeService)getImpl()).setInteger(data.content);
                        return true;
                    case 1:
                        BadgeService_Internal.BadgeServiceSetFlagParams.deserialize(messageWithHeader.getPayload());
                        ((BadgeService)getImpl()).setFlag();
                        return true;
                    case 2:
                        BadgeService_Internal.BadgeServiceClearBadgeParams.deserialize(messageWithHeader.getPayload());
                        ((BadgeService)getImpl()).clearBadge();
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
                                getCore(), BadgeService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BadgeServiceSetIntegerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long content;

        private BadgeServiceSetIntegerParams(int version) {
            super(16, version);
        }

        public BadgeServiceSetIntegerParams() {
            this(0);
        }

        public static BadgeServiceSetIntegerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BadgeServiceSetIntegerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BadgeServiceSetIntegerParams decode(Decoder decoder0) {
            BadgeServiceSetIntegerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BadgeServiceSetIntegerParams(elementsOrVersion);
                result.content = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.content, 8);
        }
    }

    static final class BadgeServiceSetFlagParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BadgeServiceSetFlagParams(int version) {
            super(8, version);
        }

        public BadgeServiceSetFlagParams() {
            this(0);
        }

        public static BadgeServiceSetFlagParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BadgeServiceSetFlagParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BadgeServiceSetFlagParams decode(Decoder decoder0) {
            BadgeServiceSetFlagParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BadgeServiceSetFlagParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BadgeServiceClearBadgeParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BadgeServiceClearBadgeParams(int version) {
            super(8, version);
        }

        public BadgeServiceClearBadgeParams() {
            this(0);
        }

        public static BadgeServiceClearBadgeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BadgeServiceClearBadgeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BadgeServiceClearBadgeParams decode(Decoder decoder0) {
            BadgeServiceClearBadgeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BadgeServiceClearBadgeParams(elementsOrVersion);
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
