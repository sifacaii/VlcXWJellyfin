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
import org.chromium.url.mojom.Url;

class ServiceWorkerInstalledScriptsManagerHost_Internal {
    public static final Interface.Manager<ServiceWorkerInstalledScriptsManagerHost, ServiceWorkerInstalledScriptsManagerHost.Proxy> MANAGER = new Interface.Manager<ServiceWorkerInstalledScriptsManagerHost, ServiceWorkerInstalledScriptsManagerHost.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerInstalledScriptsManagerHost";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerInstalledScriptsManagerHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerInstalledScriptsManagerHost_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerInstalledScriptsManagerHost_Internal.Stub buildStub(Core core, ServiceWorkerInstalledScriptsManagerHost impl) {
            return new ServiceWorkerInstalledScriptsManagerHost_Internal.Stub(core, impl);
        }

        public ServiceWorkerInstalledScriptsManagerHost[] buildArray(int size) {
            return new ServiceWorkerInstalledScriptsManagerHost[size];
        }
    };

    private static final int REQUEST_INSTALLED_SCRIPT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerInstalledScriptsManagerHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestInstalledScript(Url scriptUrl) {
            ServiceWorkerInstalledScriptsManagerHost_Internal.ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams _message = new ServiceWorkerInstalledScriptsManagerHost_Internal.ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams();
            _message.scriptUrl = scriptUrl;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerInstalledScriptsManagerHost> {
        Stub(Core core, ServiceWorkerInstalledScriptsManagerHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerInstalledScriptsManagerHost_Internal.ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerInstalledScriptsManagerHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorkerInstalledScriptsManagerHost_Internal.ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerInstalledScriptsManagerHost)getImpl()).requestInstalledScript(data.scriptUrl);
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
                                getCore(), ServiceWorkerInstalledScriptsManagerHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url scriptUrl;

        private ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams(int version) {
            super(16, version);
        }

        public ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams() {
            this(0);
        }

        public static ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams decode(Decoder decoder0) {
            ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerInstalledScriptsManagerHostRequestInstalledScriptParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.scriptUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.scriptUrl, 8, false);
        }
    }
}
