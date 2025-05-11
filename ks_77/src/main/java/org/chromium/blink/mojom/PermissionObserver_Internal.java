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

class PermissionObserver_Internal {
    public static final Interface.Manager<PermissionObserver, PermissionObserver.Proxy> MANAGER = new Interface.Manager<PermissionObserver, PermissionObserver.Proxy>() {
        public String getName() {
            return "blink.mojom.PermissionObserver";
        }

        public int getVersion() {
            return 0;
        }

        public PermissionObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PermissionObserver_Internal.Proxy(core, messageReceiver);
        }

        public PermissionObserver_Internal.Stub buildStub(Core core, PermissionObserver impl) {
            return new PermissionObserver_Internal.Stub(core, impl);
        }

        public PermissionObserver[] buildArray(int size) {
            return new PermissionObserver[size];
        }
    };

    private static final int ON_PERMISSION_STATUS_CHANGE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PermissionObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onPermissionStatusChange(int status) {
            PermissionObserver_Internal.PermissionObserverOnPermissionStatusChangeParams _message = new PermissionObserver_Internal.PermissionObserverOnPermissionStatusChangeParams();
            _message.status = status;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<PermissionObserver> {
        Stub(Core core, PermissionObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PermissionObserver_Internal.PermissionObserverOnPermissionStatusChangeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PermissionObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PermissionObserver_Internal.PermissionObserverOnPermissionStatusChangeParams.deserialize(messageWithHeader.getPayload());
                        ((PermissionObserver)getImpl()).onPermissionStatusChange(data.status);
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
                                getCore(), PermissionObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PermissionObserverOnPermissionStatusChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private PermissionObserverOnPermissionStatusChangeParams(int version) {
            super(16, version);
        }

        public PermissionObserverOnPermissionStatusChangeParams() {
            this(0);
        }

        public static PermissionObserverOnPermissionStatusChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PermissionObserverOnPermissionStatusChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PermissionObserverOnPermissionStatusChangeParams decode(Decoder decoder0) {
            PermissionObserverOnPermissionStatusChangeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PermissionObserverOnPermissionStatusChangeParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }
}
