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

class InstallationService_Internal {
    public static final Interface.Manager<InstallationService, InstallationService.Proxy> MANAGER = new Interface.Manager<InstallationService, InstallationService.Proxy>() {
        public String getName() {
            return "blink.mojom.InstallationService";
        }

        public int getVersion() {
            return 0;
        }

        public InstallationService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new InstallationService_Internal.Proxy(core, messageReceiver);
        }

        public InstallationService_Internal.Stub buildStub(Core core, InstallationService impl) {
            return new InstallationService_Internal.Stub(core, impl);
        }

        public InstallationService[] buildArray(int size) {
            return new InstallationService[size];
        }
    };

    private static final int ON_INSTALL_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements InstallationService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onInstall() {
            InstallationService_Internal.InstallationServiceOnInstallParams _message = new InstallationService_Internal.InstallationServiceOnInstallParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<InstallationService> {
        Stub(Core core, InstallationService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InstallationService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        InstallationService_Internal.InstallationServiceOnInstallParams.deserialize(messageWithHeader.getPayload());
                        ((InstallationService)getImpl()).onInstall();
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
                                getCore(), InstallationService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class InstallationServiceOnInstallParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private InstallationServiceOnInstallParams(int version) {
            super(8, version);
        }

        public InstallationServiceOnInstallParams() {
            this(0);
        }

        public static InstallationServiceOnInstallParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InstallationServiceOnInstallParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InstallationServiceOnInstallParams decode(Decoder decoder0) {
            InstallationServiceOnInstallParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InstallationServiceOnInstallParams(elementsOrVersion);
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
