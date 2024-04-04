package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class RemoteObjectHost_Internal {
    public static final Interface.Manager<RemoteObjectHost, RemoteObjectHost.Proxy> MANAGER = new Interface.Manager<RemoteObjectHost, RemoteObjectHost.Proxy>() {
        public String getName() {
            return "blink.mojom.RemoteObjectHost";
        }

        public int getVersion() {
            return 0;
        }

        public RemoteObjectHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new RemoteObjectHost_Internal.Proxy(core, messageReceiver);
        }

        public RemoteObjectHost_Internal.Stub buildStub(Core core, RemoteObjectHost impl) {
            return new RemoteObjectHost_Internal.Stub(core, impl);
        }

        public RemoteObjectHost[] buildArray(int size) {
            return new RemoteObjectHost[size];
        }
    };

    private static final int GET_OBJECT_ORDINAL = 0;

    private static final int RELEASE_OBJECT_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements RemoteObjectHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getObject(int objectId, InterfaceRequest<RemoteObject> request) {
            RemoteObjectHost_Internal.RemoteObjectHostGetObjectParams _message = new RemoteObjectHost_Internal.RemoteObjectHostGetObjectParams();
            _message.objectId = objectId;
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void releaseObject(int objectId) {
            RemoteObjectHost_Internal.RemoteObjectHostReleaseObjectParams _message = new RemoteObjectHost_Internal.RemoteObjectHostReleaseObjectParams();
            _message.objectId = objectId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<RemoteObjectHost> {
        Stub(Core core, RemoteObjectHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                RemoteObjectHost_Internal.RemoteObjectHostGetObjectParams remoteObjectHostGetObjectParams;
                RemoteObjectHost_Internal.RemoteObjectHostReleaseObjectParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(RemoteObjectHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        remoteObjectHostGetObjectParams = RemoteObjectHost_Internal.RemoteObjectHostGetObjectParams.deserialize(messageWithHeader.getPayload());
                        ((RemoteObjectHost)getImpl()).getObject(remoteObjectHostGetObjectParams.objectId, remoteObjectHostGetObjectParams.request);
                        return true;
                    case 1:
                        data = RemoteObjectHost_Internal.RemoteObjectHostReleaseObjectParams.deserialize(messageWithHeader.getPayload());
                        ((RemoteObjectHost)getImpl()).releaseObject(data.objectId);
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
                                getCore(), RemoteObjectHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class RemoteObjectHostGetObjectParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int objectId;

        public InterfaceRequest<RemoteObject> request;

        private RemoteObjectHostGetObjectParams(int version) {
            super(16, version);
        }

        public RemoteObjectHostGetObjectParams() {
            this(0);
        }

        public static RemoteObjectHostGetObjectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectHostGetObjectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectHostGetObjectParams decode(Decoder decoder0) {
            RemoteObjectHostGetObjectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectHostGetObjectParams(elementsOrVersion);
                result.objectId = decoder0.readInt(8);
                result.request = decoder0.readInterfaceRequest(12, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.objectId, 8);
            encoder0.encode(this.request, 12, false);
        }
    }

    static final class RemoteObjectHostReleaseObjectParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int objectId;

        private RemoteObjectHostReleaseObjectParams(int version) {
            super(16, version);
        }

        public RemoteObjectHostReleaseObjectParams() {
            this(0);
        }

        public static RemoteObjectHostReleaseObjectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RemoteObjectHostReleaseObjectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RemoteObjectHostReleaseObjectParams decode(Decoder decoder0) {
            RemoteObjectHostReleaseObjectParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new RemoteObjectHostReleaseObjectParams(elementsOrVersion);
                result.objectId = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.objectId, 8);
        }
    }
}
