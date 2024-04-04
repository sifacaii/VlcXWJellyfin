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

class AndroidOverlayProvider_Internal {
    public static final Interface.Manager<AndroidOverlayProvider, AndroidOverlayProvider.Proxy> MANAGER = new Interface.Manager<AndroidOverlayProvider, AndroidOverlayProvider.Proxy>() {
        public String getName() {
            return "media.mojom.AndroidOverlayProvider";
        }

        public int getVersion() {
            return 0;
        }

        public AndroidOverlayProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AndroidOverlayProvider_Internal.Proxy(core, messageReceiver);
        }

        public AndroidOverlayProvider_Internal.Stub buildStub(Core core, AndroidOverlayProvider impl) {
            return new AndroidOverlayProvider_Internal.Stub(core, impl);
        }

        public AndroidOverlayProvider[] buildArray(int size) {
            return new AndroidOverlayProvider[size];
        }
    };

    private static final int CREATE_OVERLAY_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AndroidOverlayProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createOverlay(InterfaceRequest<AndroidOverlay> overlay, AndroidOverlayClient client, AndroidOverlayConfig config) {
            AndroidOverlayProvider_Internal.AndroidOverlayProviderCreateOverlayParams _message = new AndroidOverlayProvider_Internal.AndroidOverlayProviderCreateOverlayParams();
            _message.overlay = overlay;
            _message.client = client;
            _message.config = config;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AndroidOverlayProvider> {
        Stub(Core core, AndroidOverlayProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AndroidOverlayProvider_Internal.AndroidOverlayProviderCreateOverlayParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AndroidOverlayProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AndroidOverlayProvider_Internal.AndroidOverlayProviderCreateOverlayParams.deserialize(messageWithHeader.getPayload());
                        ((AndroidOverlayProvider)getImpl()).createOverlay(data.overlay, data.client, data.config);
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
                                getCore(), AndroidOverlayProvider_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AndroidOverlayProviderCreateOverlayParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<AndroidOverlay> overlay;

        public AndroidOverlayClient client;

        public AndroidOverlayConfig config;

        private AndroidOverlayProviderCreateOverlayParams(int version) {
            super(32, version);
        }

        public AndroidOverlayProviderCreateOverlayParams() {
            this(0);
        }

        public static AndroidOverlayProviderCreateOverlayParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AndroidOverlayProviderCreateOverlayParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AndroidOverlayProviderCreateOverlayParams decode(Decoder decoder0) {
            AndroidOverlayProviderCreateOverlayParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AndroidOverlayProviderCreateOverlayParams(elementsOrVersion);
                result.overlay = decoder0.readInterfaceRequest(8, false);
                result.client = (AndroidOverlayClient)decoder0.readServiceInterface(12, false, AndroidOverlayClient.MANAGER);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.config = AndroidOverlayConfig.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.overlay, 8, false);
            encoder0.encode(this.client, 12, false, AndroidOverlayClient.MANAGER);
            encoder0.encode(this.config, 24, false);
        }
    }
}
