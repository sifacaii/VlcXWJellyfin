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

class PreviewsResourceLoadingHintsReceiver_Internal {
    public static final Interface.Manager<PreviewsResourceLoadingHintsReceiver, PreviewsResourceLoadingHintsReceiver.Proxy> MANAGER = new Interface.Manager<PreviewsResourceLoadingHintsReceiver, PreviewsResourceLoadingHintsReceiver.Proxy>() {
        public String getName() {
            return "blink.mojom.PreviewsResourceLoadingHintsReceiver";
        }

        public int getVersion() {
            return 0;
        }

        public PreviewsResourceLoadingHintsReceiver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PreviewsResourceLoadingHintsReceiver_Internal.Proxy(core, messageReceiver);
        }

        public PreviewsResourceLoadingHintsReceiver_Internal.Stub buildStub(Core core, PreviewsResourceLoadingHintsReceiver impl) {
            return new PreviewsResourceLoadingHintsReceiver_Internal.Stub(core, impl);
        }

        public PreviewsResourceLoadingHintsReceiver[] buildArray(int size) {
            return new PreviewsResourceLoadingHintsReceiver[size];
        }
    };

    private static final int SET_RESOURCE_LOADING_HINTS_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PreviewsResourceLoadingHintsReceiver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setResourceLoadingHints(PreviewsResourceLoadingHints previewsResourceLoadingHints) {
            PreviewsResourceLoadingHintsReceiver_Internal.PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams _message = new PreviewsResourceLoadingHintsReceiver_Internal.PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams();
            _message.previewsResourceLoadingHints = previewsResourceLoadingHints;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<PreviewsResourceLoadingHintsReceiver> {
        Stub(Core core, PreviewsResourceLoadingHintsReceiver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PreviewsResourceLoadingHintsReceiver_Internal.PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PreviewsResourceLoadingHintsReceiver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PreviewsResourceLoadingHintsReceiver_Internal.PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams.deserialize(messageWithHeader.getPayload());
                        ((PreviewsResourceLoadingHintsReceiver)getImpl()).setResourceLoadingHints(data.previewsResourceLoadingHints);
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
                                getCore(), PreviewsResourceLoadingHintsReceiver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PreviewsResourceLoadingHints previewsResourceLoadingHints;

        private PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams(int version) {
            super(16, version);
        }

        public PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams() {
            this(0);
        }

        public static PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams decode(Decoder decoder0) {
            PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PreviewsResourceLoadingHintsReceiverSetResourceLoadingHintsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.previewsResourceLoadingHints = PreviewsResourceLoadingHints.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.previewsResourceLoadingHints, 8, false);
        }
    }
}
