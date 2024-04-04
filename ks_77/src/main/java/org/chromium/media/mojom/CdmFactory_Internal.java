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

class CdmFactory_Internal {
    public static final Interface.Manager<CdmFactory, CdmFactory.Proxy> MANAGER = new Interface.Manager<CdmFactory, CdmFactory.Proxy>() {
        public String getName() {
            return "media.mojom.CdmFactory";
        }

        public int getVersion() {
            return 0;
        }

        public CdmFactory_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CdmFactory_Internal.Proxy(core, messageReceiver);
        }

        public CdmFactory_Internal.Stub buildStub(Core core, CdmFactory impl) {
            return new CdmFactory_Internal.Stub(core, impl);
        }

        public CdmFactory[] buildArray(int size) {
            return new CdmFactory[size];
        }
    };

    private static final int CREATE_CDM_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements CdmFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createCdm(String keySystem, InterfaceRequest<ContentDecryptionModule> cdm) {
            CdmFactory_Internal.CdmFactoryCreateCdmParams _message = new CdmFactory_Internal.CdmFactoryCreateCdmParams();
            _message.keySystem = keySystem;
            _message.cdm = cdm;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<CdmFactory> {
        Stub(Core core, CdmFactory impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                CdmFactory_Internal.CdmFactoryCreateCdmParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CdmFactory_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = CdmFactory_Internal.CdmFactoryCreateCdmParams.deserialize(messageWithHeader.getPayload());
                        ((CdmFactory)getImpl()).createCdm(data.keySystem, data.cdm);
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
                                getCore(), CdmFactory_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CdmFactoryCreateCdmParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String keySystem;

        public InterfaceRequest<ContentDecryptionModule> cdm;

        private CdmFactoryCreateCdmParams(int version) {
            super(24, version);
        }

        public CdmFactoryCreateCdmParams() {
            this(0);
        }

        public static CdmFactoryCreateCdmParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmFactoryCreateCdmParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmFactoryCreateCdmParams decode(Decoder decoder0) {
            CdmFactoryCreateCdmParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmFactoryCreateCdmParams(elementsOrVersion);
                result.keySystem = decoder0.readString(8, false);
                result.cdm = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.keySystem, 8, false);
            encoder0.encode(this.cdm, 16, false);
        }
    }
}
