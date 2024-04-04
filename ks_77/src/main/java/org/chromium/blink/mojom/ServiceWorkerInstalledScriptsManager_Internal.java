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

class ServiceWorkerInstalledScriptsManager_Internal {
    public static final Interface.Manager<ServiceWorkerInstalledScriptsManager, ServiceWorkerInstalledScriptsManager.Proxy> MANAGER = new Interface.Manager<ServiceWorkerInstalledScriptsManager, ServiceWorkerInstalledScriptsManager.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerInstalledScriptsManager";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerInstalledScriptsManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerInstalledScriptsManager_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerInstalledScriptsManager_Internal.Stub buildStub(Core core, ServiceWorkerInstalledScriptsManager impl) {
            return new ServiceWorkerInstalledScriptsManager_Internal.Stub(core, impl);
        }

        public ServiceWorkerInstalledScriptsManager[] buildArray(int size) {
            return new ServiceWorkerInstalledScriptsManager[size];
        }
    };

    private static final int TRANSFER_INSTALLED_SCRIPT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerInstalledScriptsManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void transferInstalledScript(ServiceWorkerScriptInfo scriptInfo) {
            ServiceWorkerInstalledScriptsManager_Internal.ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams _message = new ServiceWorkerInstalledScriptsManager_Internal.ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams();
            _message.scriptInfo = scriptInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerInstalledScriptsManager> {
        Stub(Core core, ServiceWorkerInstalledScriptsManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerInstalledScriptsManager_Internal.ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerInstalledScriptsManager_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorkerInstalledScriptsManager_Internal.ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerInstalledScriptsManager)getImpl()).transferInstalledScript(data.scriptInfo);
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
                                getCore(), ServiceWorkerInstalledScriptsManager_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerScriptInfo scriptInfo;

        private ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams(int version) {
            super(16, version);
        }

        public ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams() {
            this(0);
        }

        public static ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams decode(Decoder decoder0) {
            ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerInstalledScriptsManagerTransferInstalledScriptParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.scriptInfo = ServiceWorkerScriptInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.scriptInfo, 8, false);
        }
    }
}
