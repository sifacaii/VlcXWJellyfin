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
import org.chromium.url.mojom.Url;

class ManifestManager_Internal {
    public static final Interface.Manager<ManifestManager, ManifestManager.Proxy> MANAGER = new Interface.Manager<ManifestManager, ManifestManager.Proxy>() {
        public String getName() {
            return "blink.mojom.ManifestManager";
        }

        public int getVersion() {
            return 0;
        }

        public ManifestManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ManifestManager_Internal.Proxy(core, messageReceiver);
        }

        public ManifestManager_Internal.Stub buildStub(Core core, ManifestManager impl) {
            return new ManifestManager_Internal.Stub(core, impl);
        }

        public ManifestManager[] buildArray(int size) {
            return new ManifestManager[size];
        }
    };

    private static final int REQUEST_MANIFEST_ORDINAL = 0;

    private static final int REQUEST_MANIFEST_DEBUG_INFO_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements ManifestManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestManifest(ManifestManager.RequestManifestResponse callback) {
            ManifestManager_Internal.ManifestManagerRequestManifestParams _message = new ManifestManager_Internal.ManifestManagerRequestManifestParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ManifestManager_Internal.ManifestManagerRequestManifestResponseParamsForwardToCallback(callback));
        }

        public void requestManifestDebugInfo(ManifestManager.RequestManifestDebugInfoResponse callback) {
            ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoParams _message = new ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ManifestManager> {
        Stub(Core core, ManifestManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ManifestManager_Internal.MANAGER, messageWithHeader);
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
                                getCore(), ManifestManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ManifestManager_Internal.ManifestManagerRequestManifestParams.deserialize(messageWithHeader.getPayload());
                        ((ManifestManager)getImpl()).requestManifest(new ManifestManager_Internal.ManifestManagerRequestManifestResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoParams.deserialize(messageWithHeader.getPayload());
                        ((ManifestManager)getImpl()).requestManifestDebugInfo(new ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ManifestManagerRequestManifestParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ManifestManagerRequestManifestParams(int version) {
            super(8, version);
        }

        public ManifestManagerRequestManifestParams() {
            this(0);
        }

        public static ManifestManagerRequestManifestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ManifestManagerRequestManifestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ManifestManagerRequestManifestParams decode(Decoder decoder0) {
            ManifestManagerRequestManifestParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ManifestManagerRequestManifestParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ManifestManagerRequestManifestResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public Manifest_ manifest;

        private ManifestManagerRequestManifestResponseParams(int version) {
            super(24, version);
        }

        public ManifestManagerRequestManifestResponseParams() {
            this(0);
        }

        public static ManifestManagerRequestManifestResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ManifestManagerRequestManifestResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ManifestManagerRequestManifestResponseParams decode(Decoder decoder0) {
            ManifestManagerRequestManifestResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ManifestManagerRequestManifestResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.manifest = Manifest_.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.manifest, 16, true);
        }
    }

    static class ManifestManagerRequestManifestResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ManifestManager.RequestManifestResponse mCallback;

        ManifestManagerRequestManifestResponseParamsForwardToCallback(ManifestManager.RequestManifestResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ManifestManager_Internal.ManifestManagerRequestManifestResponseParams response = ManifestManager_Internal.ManifestManagerRequestManifestResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.url, response.manifest);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ManifestManagerRequestManifestResponseParamsProxyToResponder implements ManifestManager.RequestManifestResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ManifestManagerRequestManifestResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Url url, Manifest_ manifest) {
            ManifestManager_Internal.ManifestManagerRequestManifestResponseParams _response = new ManifestManager_Internal.ManifestManagerRequestManifestResponseParams();
            _response.url = url;
            _response.manifest = manifest;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ManifestManagerRequestManifestDebugInfoParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ManifestManagerRequestManifestDebugInfoParams(int version) {
            super(8, version);
        }

        public ManifestManagerRequestManifestDebugInfoParams() {
            this(0);
        }

        public static ManifestManagerRequestManifestDebugInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ManifestManagerRequestManifestDebugInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ManifestManagerRequestManifestDebugInfoParams decode(Decoder decoder0) {
            ManifestManagerRequestManifestDebugInfoParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ManifestManagerRequestManifestDebugInfoParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ManifestManagerRequestManifestDebugInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public ManifestDebugInfo debugInfo;

        private ManifestManagerRequestManifestDebugInfoResponseParams(int version) {
            super(24, version);
        }

        public ManifestManagerRequestManifestDebugInfoResponseParams() {
            this(0);
        }

        public static ManifestManagerRequestManifestDebugInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ManifestManagerRequestManifestDebugInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ManifestManagerRequestManifestDebugInfoResponseParams decode(Decoder decoder0) {
            ManifestManagerRequestManifestDebugInfoResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ManifestManagerRequestManifestDebugInfoResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.debugInfo = ManifestDebugInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.debugInfo, 16, true);
        }
    }

    static class ManifestManagerRequestManifestDebugInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ManifestManager.RequestManifestDebugInfoResponse mCallback;

        ManifestManagerRequestManifestDebugInfoResponseParamsForwardToCallback(ManifestManager.RequestManifestDebugInfoResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoResponseParams response = ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.url, response.debugInfo);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ManifestManagerRequestManifestDebugInfoResponseParamsProxyToResponder implements ManifestManager.RequestManifestDebugInfoResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ManifestManagerRequestManifestDebugInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Url url, ManifestDebugInfo debugInfo) {
            ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoResponseParams _response = new ManifestManager_Internal.ManifestManagerRequestManifestDebugInfoResponseParams();
            _response.url = url;
            _response.debugInfo = debugInfo;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
