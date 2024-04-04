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
import org.chromium.url.mojom.Url;

class FrameHostTestInterface_Internal {
    public static final Interface.Manager<FrameHostTestInterface, FrameHostTestInterface.Proxy> MANAGER = new Interface.Manager<FrameHostTestInterface, FrameHostTestInterface.Proxy>() {
        public String getName() {
            return "blink.mojom.FrameHostTestInterface";
        }

        public int getVersion() {
            return 0;
        }

        public FrameHostTestInterface_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FrameHostTestInterface_Internal.Proxy(core, messageReceiver);
        }

        public FrameHostTestInterface_Internal.Stub buildStub(Core core, FrameHostTestInterface impl) {
            return new FrameHostTestInterface_Internal.Stub(core, impl);
        }

        public FrameHostTestInterface[] buildArray(int size) {
            return new FrameHostTestInterface[size];
        }
    };

    private static final int PING_ORDINAL = 0;

    private static final int GET_NAME_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements FrameHostTestInterface.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void ping(Url sourceUrl, String sourceEvent) {
            FrameHostTestInterface_Internal.FrameHostTestInterfacePingParams _message = new FrameHostTestInterface_Internal.FrameHostTestInterfacePingParams();
            _message.sourceUrl = sourceUrl;
            _message.sourceEvent = sourceEvent;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void getName(FrameHostTestInterface.GetNameResponse callback) {
            FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameParams _message = new FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FrameHostTestInterface> {
        Stub(Core core, FrameHostTestInterface impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                FrameHostTestInterface_Internal.FrameHostTestInterfacePingParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FrameHostTestInterface_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = FrameHostTestInterface_Internal.FrameHostTestInterfacePingParams.deserialize(messageWithHeader.getPayload());
                        ((FrameHostTestInterface)getImpl()).ping(data.sourceUrl, data.sourceEvent);
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
                                getCore(), FrameHostTestInterface_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameParams.deserialize(messageWithHeader.getPayload());
                        ((FrameHostTestInterface)getImpl()).getName(new FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FrameHostTestInterfacePingParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url sourceUrl;

        public String sourceEvent;

        private FrameHostTestInterfacePingParams(int version) {
            super(24, version);
        }

        public FrameHostTestInterfacePingParams() {
            this(0);
        }

        public static FrameHostTestInterfacePingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FrameHostTestInterfacePingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FrameHostTestInterfacePingParams decode(Decoder decoder0) {
            FrameHostTestInterfacePingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FrameHostTestInterfacePingParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.sourceUrl = Url.decode(decoder1);
                result.sourceEvent = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.sourceUrl, 8, false);
            encoder0.encode(this.sourceEvent, 16, false);
        }
    }

    static final class FrameHostTestInterfaceGetNameParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FrameHostTestInterfaceGetNameParams(int version) {
            super(8, version);
        }

        public FrameHostTestInterfaceGetNameParams() {
            this(0);
        }

        public static FrameHostTestInterfaceGetNameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FrameHostTestInterfaceGetNameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FrameHostTestInterfaceGetNameParams decode(Decoder decoder0) {
            FrameHostTestInterfaceGetNameParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FrameHostTestInterfaceGetNameParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FrameHostTestInterfaceGetNameResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String name;

        private FrameHostTestInterfaceGetNameResponseParams(int version) {
            super(16, version);
        }

        public FrameHostTestInterfaceGetNameResponseParams() {
            this(0);
        }

        public static FrameHostTestInterfaceGetNameResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FrameHostTestInterfaceGetNameResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FrameHostTestInterfaceGetNameResponseParams decode(Decoder decoder0) {
            FrameHostTestInterfaceGetNameResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FrameHostTestInterfaceGetNameResponseParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.name, 8, false);
        }
    }

    static class FrameHostTestInterfaceGetNameResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FrameHostTestInterface.GetNameResponse mCallback;

        FrameHostTestInterfaceGetNameResponseParamsForwardToCallback(FrameHostTestInterface.GetNameResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameResponseParams response = FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.name);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FrameHostTestInterfaceGetNameResponseParamsProxyToResponder implements FrameHostTestInterface.GetNameResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FrameHostTestInterfaceGetNameResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String name) {
            FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameResponseParams _response = new FrameHostTestInterface_Internal.FrameHostTestInterfaceGetNameResponseParams();
            _response.name = name;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
