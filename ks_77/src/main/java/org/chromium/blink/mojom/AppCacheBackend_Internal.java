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
import org.chromium.mojo_base.mojom.UnguessableToken;

class AppCacheBackend_Internal {
    public static final Interface.Manager<AppCacheBackend, AppCacheBackend.Proxy> MANAGER = new Interface.Manager<AppCacheBackend, AppCacheBackend.Proxy>() {
        public String getName() {
            return "blink.mojom.AppCacheBackend";
        }

        public int getVersion() {
            return 0;
        }

        public AppCacheBackend_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AppCacheBackend_Internal.Proxy(core, messageReceiver);
        }

        public AppCacheBackend_Internal.Stub buildStub(Core core, AppCacheBackend impl) {
            return new AppCacheBackend_Internal.Stub(core, impl);
        }

        public AppCacheBackend[] buildArray(int size) {
            return new AppCacheBackend[size];
        }
    };

    private static final int REGISTER_HOST_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AppCacheBackend.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void registerHost(InterfaceRequest<AppCacheHost> hostReceiver, AppCacheFrontend frontend, UnguessableToken hostId) {
            AppCacheBackend_Internal.AppCacheBackendRegisterHostParams _message = new AppCacheBackend_Internal.AppCacheBackendRegisterHostParams();
            _message.hostReceiver = hostReceiver;
            _message.frontend = frontend;
            _message.hostId = hostId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AppCacheBackend> {
        Stub(Core core, AppCacheBackend impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AppCacheBackend_Internal.AppCacheBackendRegisterHostParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AppCacheBackend_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AppCacheBackend_Internal.AppCacheBackendRegisterHostParams.deserialize(messageWithHeader.getPayload());
                        ((AppCacheBackend)getImpl()).registerHost(data.hostReceiver, data.frontend, data.hostId);
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
                                getCore(), AppCacheBackend_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AppCacheBackendRegisterHostParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<AppCacheHost> hostReceiver;

        public AppCacheFrontend frontend;

        public UnguessableToken hostId;

        private AppCacheBackendRegisterHostParams(int version) {
            super(32, version);
        }

        public AppCacheBackendRegisterHostParams() {
            this(0);
        }

        public static AppCacheBackendRegisterHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheBackendRegisterHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheBackendRegisterHostParams decode(Decoder decoder0) {
            AppCacheBackendRegisterHostParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppCacheBackendRegisterHostParams(elementsOrVersion);
                result.hostReceiver = decoder0.readInterfaceRequest(8, false);
                result.frontend = (AppCacheFrontend)decoder0.readServiceInterface(12, false, AppCacheFrontend.MANAGER);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.hostId = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.hostReceiver, 8, false);
            encoder0.encode(this.frontend, 12, false, AppCacheFrontend.MANAGER);
            encoder0.encode((Struct)this.hostId, 24, false);
        }
    }
}
