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
import org.chromium.network.mojom.CredentialsMode;
import org.chromium.service_manager.mojom.InterfaceProvider;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

class DedicatedWorkerHostFactory_Internal {
    public static final Interface.Manager<DedicatedWorkerHostFactory, DedicatedWorkerHostFactory.Proxy> MANAGER = new Interface.Manager<DedicatedWorkerHostFactory, DedicatedWorkerHostFactory.Proxy>() {
        public String getName() {
            return "blink.mojom.DedicatedWorkerHostFactory";
        }

        public int getVersion() {
            return 0;
        }

        public DedicatedWorkerHostFactory_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DedicatedWorkerHostFactory_Internal.Proxy(core, messageReceiver);
        }

        public DedicatedWorkerHostFactory_Internal.Stub buildStub(Core core, DedicatedWorkerHostFactory impl) {
            return new DedicatedWorkerHostFactory_Internal.Stub(core, impl);
        }

        public DedicatedWorkerHostFactory[] buildArray(int size) {
            return new DedicatedWorkerHostFactory[size];
        }
    };

    private static final int CREATE_WORKER_HOST_ORDINAL = 0;

    private static final int CREATE_WORKER_HOST_AND_START_SCRIPT_LOAD_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements DedicatedWorkerHostFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createWorkerHost(Origin origin, InterfaceRequest<InterfaceProvider> workerInterfaceProvider) {
            DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostParams _message = new DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostParams();
            _message.origin = origin;
            _message.workerInterfaceProvider = workerInterfaceProvider;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void createWorkerHostAndStartScriptLoad(Url scriptUrl, Origin origin, int credentialsMode, FetchClientSettingsObject outsideFetchClientSettingsObject, BlobUrlToken blobUrlToken, DedicatedWorkerHostFactoryClient client) {
            DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams _message = new DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams();
            _message.scriptUrl = scriptUrl;
            _message.origin = origin;
            _message.credentialsMode = credentialsMode;
            _message.outsideFetchClientSettingsObject = outsideFetchClientSettingsObject;
            _message.blobUrlToken = blobUrlToken;
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<DedicatedWorkerHostFactory> {
        Stub(Core core, DedicatedWorkerHostFactory impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostParams dedicatedWorkerHostFactoryCreateWorkerHostParams;
                DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DedicatedWorkerHostFactory_Internal.MANAGER, messageWithHeader);
                    case 0:
                        dedicatedWorkerHostFactoryCreateWorkerHostParams = DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostParams.deserialize(messageWithHeader.getPayload());
                        ((DedicatedWorkerHostFactory)getImpl()).createWorkerHost(dedicatedWorkerHostFactoryCreateWorkerHostParams.origin, dedicatedWorkerHostFactoryCreateWorkerHostParams.workerInterfaceProvider);
                        return true;
                    case 1:
                        data = DedicatedWorkerHostFactory_Internal.DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams.deserialize(messageWithHeader.getPayload());
                        ((DedicatedWorkerHostFactory)getImpl()).createWorkerHostAndStartScriptLoad(data.scriptUrl, data.origin, data.credentialsMode, data.outsideFetchClientSettingsObject, data.blobUrlToken, data.client);
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
                                getCore(), DedicatedWorkerHostFactory_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DedicatedWorkerHostFactoryCreateWorkerHostParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public InterfaceRequest<InterfaceProvider> workerInterfaceProvider;

        private DedicatedWorkerHostFactoryCreateWorkerHostParams(int version) {
            super(24, version);
        }

        public DedicatedWorkerHostFactoryCreateWorkerHostParams() {
            this(0);
        }

        public static DedicatedWorkerHostFactoryCreateWorkerHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DedicatedWorkerHostFactoryCreateWorkerHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DedicatedWorkerHostFactoryCreateWorkerHostParams decode(Decoder decoder0) {
            DedicatedWorkerHostFactoryCreateWorkerHostParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DedicatedWorkerHostFactoryCreateWorkerHostParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.workerInterfaceProvider = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.workerInterfaceProvider, 16, false);
        }
    }

    static final class DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url scriptUrl;

        public Origin origin;

        public int credentialsMode;

        public FetchClientSettingsObject outsideFetchClientSettingsObject;

        public BlobUrlToken blobUrlToken;

        public DedicatedWorkerHostFactoryClient client;

        private DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams(int version) {
            super(56, version);
        }

        public DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams() {
            this(0);
        }

        public static DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams decode(Decoder decoder0) {
            DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DedicatedWorkerHostFactoryCreateWorkerHostAndStartScriptLoadParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.scriptUrl = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.origin = Origin.decode(decoder1);
                result.credentialsMode = decoder0.readInt(24);
                CredentialsMode.validate(result.credentialsMode);
                decoder1 = decoder0.readPointer(32, false);
                result.outsideFetchClientSettingsObject = FetchClientSettingsObject.decode(decoder1);
                result.blobUrlToken = (BlobUrlToken)decoder0.readServiceInterface(40, true, BlobUrlToken.MANAGER);
                result.client = (DedicatedWorkerHostFactoryClient)decoder0.readServiceInterface(48, false, DedicatedWorkerHostFactoryClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.scriptUrl, 8, false);
            encoder0.encode((Struct)this.origin, 16, false);
            encoder0.encode(this.credentialsMode, 24);
            encoder0.encode(this.outsideFetchClientSettingsObject, 32, false);
            encoder0.encode(this.blobUrlToken, 40, true, BlobUrlToken.MANAGER);
            encoder0.encode(this.client, 48, false, DedicatedWorkerHostFactoryClient.MANAGER);
        }
    }
}
