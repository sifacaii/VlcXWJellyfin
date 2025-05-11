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
import org.chromium.url.mojom.Origin;

class PluginRegistry_Internal {
    public static final Interface.Manager<PluginRegistry, PluginRegistry.Proxy> MANAGER = new Interface.Manager<PluginRegistry, PluginRegistry.Proxy>() {
        public String getName() {
            return "blink.mojom.PluginRegistry";
        }

        public int getVersion() {
            return 0;
        }

        public PluginRegistry_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PluginRegistry_Internal.Proxy(core, messageReceiver);
        }

        public PluginRegistry_Internal.Stub buildStub(Core core, PluginRegistry impl) {
            return new PluginRegistry_Internal.Stub(core, impl);
        }

        public PluginRegistry[] buildArray(int size) {
            return new PluginRegistry[size];
        }
    };

    private static final int GET_PLUGINS_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PluginRegistry.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getPlugins(boolean refresh, Origin mainFrameOrigin, PluginRegistry.GetPluginsResponse callback) {
            PluginRegistry_Internal.PluginRegistryGetPluginsParams _message = new PluginRegistry_Internal.PluginRegistryGetPluginsParams();
            _message.refresh = refresh;
            _message.mainFrameOrigin = mainFrameOrigin;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PluginRegistry_Internal.PluginRegistryGetPluginsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<PluginRegistry> {
        Stub(Core core, PluginRegistry impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PluginRegistry_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                PluginRegistry_Internal.PluginRegistryGetPluginsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PluginRegistry_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = PluginRegistry_Internal.PluginRegistryGetPluginsParams.deserialize(messageWithHeader.getPayload());
                        ((PluginRegistry)getImpl()).getPlugins(data.refresh, data.mainFrameOrigin, new PluginRegistry_Internal.PluginRegistryGetPluginsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PluginRegistryGetPluginsParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean refresh;

        public Origin mainFrameOrigin;

        private PluginRegistryGetPluginsParams(int version) {
            super(24, version);
        }

        public PluginRegistryGetPluginsParams() {
            this(0);
        }

        public static PluginRegistryGetPluginsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PluginRegistryGetPluginsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PluginRegistryGetPluginsParams decode(Decoder decoder0) {
            PluginRegistryGetPluginsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PluginRegistryGetPluginsParams(elementsOrVersion);
                result.refresh = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.mainFrameOrigin = Origin.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.refresh, 8, 0);
            encoder0.encode((Struct)this.mainFrameOrigin, 16, false);
        }
    }

    static final class PluginRegistryGetPluginsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PluginInfo[] plugins;

        private PluginRegistryGetPluginsResponseParams(int version) {
            super(16, version);
        }

        public PluginRegistryGetPluginsResponseParams() {
            this(0);
        }

        public static PluginRegistryGetPluginsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PluginRegistryGetPluginsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PluginRegistryGetPluginsResponseParams decode(Decoder decoder0) {
            PluginRegistryGetPluginsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PluginRegistryGetPluginsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.plugins = new PluginInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.plugins[i1] = PluginInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.plugins == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.plugins.length, 8, -1);
                for (int i0 = 0; i0 < this.plugins.length; i0++)
                    encoder1.encode(this.plugins[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class PluginRegistryGetPluginsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PluginRegistry.GetPluginsResponse mCallback;

        PluginRegistryGetPluginsResponseParamsForwardToCallback(PluginRegistry.GetPluginsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                PluginRegistry_Internal.PluginRegistryGetPluginsResponseParams response = PluginRegistry_Internal.PluginRegistryGetPluginsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.plugins);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PluginRegistryGetPluginsResponseParamsProxyToResponder implements PluginRegistry.GetPluginsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PluginRegistryGetPluginsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(PluginInfo[] plugins) {
            PluginRegistry_Internal.PluginRegistryGetPluginsResponseParams _response = new PluginRegistry_Internal.PluginRegistryGetPluginsResponseParams();
            _response.plugins = plugins;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
