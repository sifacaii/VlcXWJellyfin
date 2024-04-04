package org.chromium.media.mojom;

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
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.service_manager.mojom.InterfaceProvider;

class CdmService_Internal {
    public static final Interface.Manager<CdmService, CdmService.Proxy> MANAGER = new Interface.Manager<CdmService, CdmService.Proxy>() {
        public String getName() {
            return "media.mojom.CdmService";
        }

        public int getVersion() {
            return 0;
        }

        public CdmService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CdmService_Internal.Proxy(core, messageReceiver);
        }

        public CdmService_Internal.Stub buildStub(Core core, CdmService impl) {
            return new CdmService_Internal.Stub(core, impl);
        }

        public CdmService[] buildArray(int size) {
            return new CdmService[size];
        }
    };

    private static final int LOAD_CDM_ORDINAL = 0;

    private static final int CREATE_CDM_FACTORY_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements CdmService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void loadCdm(FilePath cdmPath) {
            CdmService_Internal.CdmServiceLoadCdmParams _message = new CdmService_Internal.CdmServiceLoadCdmParams();
            _message.cdmPath = cdmPath;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void createCdmFactory(InterfaceRequest<CdmFactory> factory, InterfaceProvider hostInterfaces) {
            CdmService_Internal.CdmServiceCreateCdmFactoryParams _message = new CdmService_Internal.CdmServiceCreateCdmFactoryParams();
            _message.factory = factory;
            _message.hostInterfaces = hostInterfaces;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<CdmService> {
        Stub(Core core, CdmService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                CdmService_Internal.CdmServiceLoadCdmParams cdmServiceLoadCdmParams;
                CdmService_Internal.CdmServiceCreateCdmFactoryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CdmService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        cdmServiceLoadCdmParams = CdmService_Internal.CdmServiceLoadCdmParams.deserialize(messageWithHeader.getPayload());
                        ((CdmService)getImpl()).loadCdm(cdmServiceLoadCdmParams.cdmPath);
                        return true;
                    case 1:
                        data = CdmService_Internal.CdmServiceCreateCdmFactoryParams.deserialize(messageWithHeader.getPayload());
                        ((CdmService)getImpl()).createCdmFactory(data.factory, data.hostInterfaces);
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
                                getCore(), CdmService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CdmServiceLoadCdmParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FilePath cdmPath;

        private CdmServiceLoadCdmParams(int version) {
            super(16, version);
        }

        public CdmServiceLoadCdmParams() {
            this(0);
        }

        public static CdmServiceLoadCdmParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmServiceLoadCdmParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmServiceLoadCdmParams decode(Decoder decoder0) {
            CdmServiceLoadCdmParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmServiceLoadCdmParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cdmPath = FilePath.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.cdmPath, 8, false);
        }
    }

    static final class CdmServiceCreateCdmFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<CdmFactory> factory;

        public InterfaceProvider hostInterfaces;

        private CdmServiceCreateCdmFactoryParams(int version) {
            super(24, version);
        }

        public CdmServiceCreateCdmFactoryParams() {
            this(0);
        }

        public static CdmServiceCreateCdmFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmServiceCreateCdmFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmServiceCreateCdmFactoryParams decode(Decoder decoder0) {
            CdmServiceCreateCdmFactoryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmServiceCreateCdmFactoryParams(elementsOrVersion);
                result.factory = decoder0.readInterfaceRequest(8, false);
                result.hostInterfaces = (InterfaceProvider)decoder0.readServiceInterface(12, true, InterfaceProvider.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.factory, 8, false);
            encoder0.encode(this.hostInterfaces, 12, true, InterfaceProvider.MANAGER);
        }
    }
}
