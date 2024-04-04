package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
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

class FindInPageClient_Internal {
    public static final Interface.Manager<FindInPageClient, FindInPageClient.Proxy> MANAGER = new Interface.Manager<FindInPageClient, FindInPageClient.Proxy>() {
        public String getName() {
            return "blink.mojom.FindInPageClient";
        }

        public int getVersion() {
            return 0;
        }

        public FindInPageClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FindInPageClient_Internal.Proxy(core, messageReceiver);
        }

        public FindInPageClient_Internal.Stub buildStub(Core core, FindInPageClient impl) {
            return new FindInPageClient_Internal.Stub(core, impl);
        }

        public FindInPageClient[] buildArray(int size) {
            return new FindInPageClient[size];
        }
    };

    private static final int SET_NUMBER_OF_MATCHES_ORDINAL = 0;

    private static final int SET_ACTIVE_MATCH_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements FindInPageClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setNumberOfMatches(int requestId, int numberOfMatches, int updateType) {
            FindInPageClient_Internal.FindInPageClientSetNumberOfMatchesParams _message = new FindInPageClient_Internal.FindInPageClientSetNumberOfMatchesParams();
            _message.requestId = requestId;
            _message.numberOfMatches = numberOfMatches;
            _message.updateType = updateType;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setActiveMatch(int requestId, Rect activeMatchRect, int activeMatchOrdinal, int updateType) {
            FindInPageClient_Internal.FindInPageClientSetActiveMatchParams _message = new FindInPageClient_Internal.FindInPageClientSetActiveMatchParams();
            _message.requestId = requestId;
            _message.activeMatchRect = activeMatchRect;
            _message.activeMatchOrdinal = activeMatchOrdinal;
            _message.updateType = updateType;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<FindInPageClient> {
        Stub(Core core, FindInPageClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                FindInPageClient_Internal.FindInPageClientSetNumberOfMatchesParams findInPageClientSetNumberOfMatchesParams;
                FindInPageClient_Internal.FindInPageClientSetActiveMatchParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FindInPageClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        findInPageClientSetNumberOfMatchesParams = FindInPageClient_Internal.FindInPageClientSetNumberOfMatchesParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPageClient)getImpl()).setNumberOfMatches(findInPageClientSetNumberOfMatchesParams.requestId, findInPageClientSetNumberOfMatchesParams.numberOfMatches, findInPageClientSetNumberOfMatchesParams.updateType);
                        return true;
                    case 1:
                        data = FindInPageClient_Internal.FindInPageClientSetActiveMatchParams.deserialize(messageWithHeader.getPayload());
                        ((FindInPageClient)getImpl()).setActiveMatch(data.requestId, data.activeMatchRect, data.activeMatchOrdinal, data.updateType);
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
                                getCore(), FindInPageClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FindInPageClientSetNumberOfMatchesParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        public int numberOfMatches;

        public int updateType;

        private FindInPageClientSetNumberOfMatchesParams(int version) {
            super(24, version);
        }

        public FindInPageClientSetNumberOfMatchesParams() {
            this(0);
        }

        public static FindInPageClientSetNumberOfMatchesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageClientSetNumberOfMatchesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageClientSetNumberOfMatchesParams decode(Decoder decoder0) {
            FindInPageClientSetNumberOfMatchesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageClientSetNumberOfMatchesParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                result.numberOfMatches = decoder0.readInt(12);
                result.updateType = decoder0.readInt(16);
                FindMatchUpdateType.validate(result.updateType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
            encoder0.encode(this.numberOfMatches, 12);
            encoder0.encode(this.updateType, 16);
        }
    }

    static final class FindInPageClientSetActiveMatchParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int requestId;

        public Rect activeMatchRect;

        public int activeMatchOrdinal;

        public int updateType;

        private FindInPageClientSetActiveMatchParams(int version) {
            super(32, version);
        }

        public FindInPageClientSetActiveMatchParams() {
            this(0);
        }

        public static FindInPageClientSetActiveMatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FindInPageClientSetActiveMatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FindInPageClientSetActiveMatchParams decode(Decoder decoder0) {
            FindInPageClientSetActiveMatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FindInPageClientSetActiveMatchParams(elementsOrVersion);
                result.requestId = decoder0.readInt(8);
                result.activeMatchOrdinal = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.activeMatchRect = Rect.decode(decoder1);
                result.updateType = decoder0.readInt(24);
                FindMatchUpdateType.validate(result.updateType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestId, 8);
            encoder0.encode(this.activeMatchOrdinal, 12);
            encoder0.encode((Struct)this.activeMatchRect, 16, false);
            encoder0.encode(this.updateType, 24);
        }
    }
}
