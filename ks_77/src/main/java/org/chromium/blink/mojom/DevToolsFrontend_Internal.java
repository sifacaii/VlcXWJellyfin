//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class DevToolsFrontend_Internal {
    public static final Interface.Manager<DevToolsFrontend, DevToolsFrontend.Proxy> MANAGER = new Interface.Manager<DevToolsFrontend, DevToolsFrontend.Proxy>() {
        public String getName() {
            return "blink.mojom.DevToolsFrontend";
        }

        public int getVersion() {
            return 0;
        }

        public Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        public Stub buildStub(Core core, DevToolsFrontend impl) {
            return new Stub(core, impl);
        }

        public DevToolsFrontend[] buildArray(int size) {
            return new DevToolsFrontend[size];
        }
    };
    private static final int SETUP_DEV_TOOLS_FRONTEND_ORDINAL = 0;
    private static final int SETUP_DEV_TOOLS_EXTENSION_API_ORDINAL = 1;

    DevToolsFrontend_Internal() {
    }

    static final class DevToolsFrontendSetupDevToolsExtensionApiParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public String extensionApi;

        private DevToolsFrontendSetupDevToolsExtensionApiParams(int version) {
            super(16, version);
        }

        public DevToolsFrontendSetupDevToolsExtensionApiParams() {
            this(0);
        }

        public static DevToolsFrontendSetupDevToolsExtensionApiParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsFrontendSetupDevToolsExtensionApiParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsFrontendSetupDevToolsExtensionApiParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                DevToolsFrontendSetupDevToolsExtensionApiParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new DevToolsFrontendSetupDevToolsExtensionApiParams(elementsOrVersion);
                    result.extensionApi = decoder0.readString(8, false);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.extensionApi, 8, false);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class DevToolsFrontendSetupDevToolsFrontendParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public String apiScript;
        public AssociatedInterfaceNotSupported host;

        private DevToolsFrontendSetupDevToolsFrontendParams(int version) {
            super(24, version);
        }

        public DevToolsFrontendSetupDevToolsFrontendParams() {
            this(0);
        }

        public static DevToolsFrontendSetupDevToolsFrontendParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsFrontendSetupDevToolsFrontendParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsFrontendSetupDevToolsFrontendParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                DevToolsFrontendSetupDevToolsFrontendParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new DevToolsFrontendSetupDevToolsFrontendParams(elementsOrVersion);
                    result.apiScript = decoder0.readString(8, false);
                    result.host = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.apiScript, 8, false);
            encoder0.encode(this.host, 16, false);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class Stub extends Interface.Stub<DevToolsFrontend> {
        Stub(Core core, DevToolsFrontend impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                } else {
                    switch (header.getType()) {
                        case -2:
                            return InterfaceControlMessagesHelper.handleRunOrClosePipe(DevToolsFrontend_Internal.MANAGER, messageWithHeader);
                        case -1:
                        default:
                            return false;
                        case 0:
                            DevToolsFrontendSetupDevToolsFrontendParams data = DevToolsFrontend_Internal.DevToolsFrontendSetupDevToolsFrontendParams.deserialize(messageWithHeader.getPayload());
                            ((DevToolsFrontend)this.getImpl()).setupDevToolsFrontend(data.apiScript, data.host);
                            return true;
                        case 1:
                            DevToolsFrontendSetupDevToolsExtensionApiParams datae = DevToolsFrontend_Internal.DevToolsFrontendSetupDevToolsExtensionApiParams.deserialize(messageWithHeader.getPayload());
                            ((DevToolsFrontend)this.getImpl()).setupDevToolsExtensionApi(datae.extensionApi);
                            return true;
                    }
                }
            } catch (DeserializationException var5) {
                System.err.println(var5.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                } else {
                    switch (header.getType()) {
                        case -1:
                            return InterfaceControlMessagesHelper.handleRun(this.getCore(), DevToolsFrontend_Internal.MANAGER, messageWithHeader, receiver);
                        default:
                            return false;
                    }
                }
            } catch (DeserializationException var5) {
                System.err.println(var5.toString());
                return false;
            }
        }
    }

    static final class Proxy extends Interface.AbstractProxy implements DevToolsFrontend.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setupDevToolsFrontend(String apiScript, AssociatedInterfaceNotSupported host) {
            DevToolsFrontendSetupDevToolsFrontendParams _message = new DevToolsFrontendSetupDevToolsFrontendParams();
            _message.apiScript = apiScript;
            _message.host = host;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setupDevToolsExtensionApi(String extensionApi) {
            DevToolsFrontendSetupDevToolsExtensionApiParams _message = new DevToolsFrontendSetupDevToolsExtensionApiParams();
            _message.extensionApi = extensionApi;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }
}
