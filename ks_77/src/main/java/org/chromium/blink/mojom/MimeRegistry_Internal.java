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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class MimeRegistry_Internal {
    public static final Interface.Manager<MimeRegistry, MimeRegistry.Proxy> MANAGER = new Interface.Manager<MimeRegistry, MimeRegistry.Proxy>() {
        public String getName() {
            return "blink.mojom.MimeRegistry";
        }

        public int getVersion() {
            return 0;
        }

        public MimeRegistry_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MimeRegistry_Internal.Proxy(core, messageReceiver);
        }

        public MimeRegistry_Internal.Stub buildStub(Core core, MimeRegistry impl) {
            return new MimeRegistry_Internal.Stub(core, impl);
        }

        public MimeRegistry[] buildArray(int size) {
            return new MimeRegistry[size];
        }
    };

    private static final int GET_MIME_TYPE_FROM_EXTENSION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements MimeRegistry.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getMimeTypeFromExtension(String extension, MimeRegistry.GetMimeTypeFromExtensionResponse callback) {
            MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionParams _message = new MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionParams();
            _message.extension = extension;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<MimeRegistry> {
        Stub(Core core, MimeRegistry impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MimeRegistry_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), MimeRegistry_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionParams.deserialize(messageWithHeader.getPayload());
                        ((MimeRegistry)getImpl()).getMimeTypeFromExtension(data.extension, new MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MimeRegistryGetMimeTypeFromExtensionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String extension;

        private MimeRegistryGetMimeTypeFromExtensionParams(int version) {
            super(16, version);
        }

        public MimeRegistryGetMimeTypeFromExtensionParams() {
            this(0);
        }

        public static MimeRegistryGetMimeTypeFromExtensionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MimeRegistryGetMimeTypeFromExtensionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MimeRegistryGetMimeTypeFromExtensionParams decode(Decoder decoder0) {
            MimeRegistryGetMimeTypeFromExtensionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MimeRegistryGetMimeTypeFromExtensionParams(elementsOrVersion);
                result.extension = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.extension, 8, false);
        }
    }

    static final class MimeRegistryGetMimeTypeFromExtensionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String mimeType;

        private MimeRegistryGetMimeTypeFromExtensionResponseParams(int version) {
            super(16, version);
        }

        public MimeRegistryGetMimeTypeFromExtensionResponseParams() {
            this(0);
        }

        public static MimeRegistryGetMimeTypeFromExtensionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MimeRegistryGetMimeTypeFromExtensionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MimeRegistryGetMimeTypeFromExtensionResponseParams decode(Decoder decoder0) {
            MimeRegistryGetMimeTypeFromExtensionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MimeRegistryGetMimeTypeFromExtensionResponseParams(elementsOrVersion);
                result.mimeType = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.mimeType, 8, false);
        }
    }

    static class MimeRegistryGetMimeTypeFromExtensionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final MimeRegistry.GetMimeTypeFromExtensionResponse mCallback;

        MimeRegistryGetMimeTypeFromExtensionResponseParamsForwardToCallback(MimeRegistry.GetMimeTypeFromExtensionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionResponseParams response = MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.mimeType);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class MimeRegistryGetMimeTypeFromExtensionResponseParamsProxyToResponder implements MimeRegistry.GetMimeTypeFromExtensionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        MimeRegistryGetMimeTypeFromExtensionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String mimeType) {
            MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionResponseParams _response = new MimeRegistry_Internal.MimeRegistryGetMimeTypeFromExtensionResponseParams();
            _response.mimeType = mimeType;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
