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

class UnhandledTapNotifier_Internal {
    public static final Interface.Manager<UnhandledTapNotifier, UnhandledTapNotifier.Proxy> MANAGER = new Interface.Manager<UnhandledTapNotifier, UnhandledTapNotifier.Proxy>() {
        public String getName() {
            return "blink.mojom.UnhandledTapNotifier";
        }

        public int getVersion() {
            return 0;
        }

        public UnhandledTapNotifier_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new UnhandledTapNotifier_Internal.Proxy(core, messageReceiver);
        }

        public UnhandledTapNotifier_Internal.Stub buildStub(Core core, UnhandledTapNotifier impl) {
            return new UnhandledTapNotifier_Internal.Stub(core, impl);
        }

        public UnhandledTapNotifier[] buildArray(int size) {
            return new UnhandledTapNotifier[size];
        }
    };

    private static final int SHOW_UNHANDLED_TAP_UI_IF_NEEDED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements UnhandledTapNotifier.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void showUnhandledTapUiIfNeeded(UnhandledTapInfo unhandledTapInfo) {
            UnhandledTapNotifier_Internal.UnhandledTapNotifierShowUnhandledTapUiIfNeededParams _message = new UnhandledTapNotifier_Internal.UnhandledTapNotifierShowUnhandledTapUiIfNeededParams();
            _message.unhandledTapInfo = unhandledTapInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<UnhandledTapNotifier> {
        Stub(Core core, UnhandledTapNotifier impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                UnhandledTapNotifier_Internal.UnhandledTapNotifierShowUnhandledTapUiIfNeededParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UnhandledTapNotifier_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = UnhandledTapNotifier_Internal.UnhandledTapNotifierShowUnhandledTapUiIfNeededParams.deserialize(messageWithHeader.getPayload());
                        ((UnhandledTapNotifier)getImpl()).showUnhandledTapUiIfNeeded(data.unhandledTapInfo);
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
                                getCore(), UnhandledTapNotifier_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class UnhandledTapNotifierShowUnhandledTapUiIfNeededParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UnhandledTapInfo unhandledTapInfo;

        private UnhandledTapNotifierShowUnhandledTapUiIfNeededParams(int version) {
            super(16, version);
        }

        public UnhandledTapNotifierShowUnhandledTapUiIfNeededParams() {
            this(0);
        }

        public static UnhandledTapNotifierShowUnhandledTapUiIfNeededParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UnhandledTapNotifierShowUnhandledTapUiIfNeededParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UnhandledTapNotifierShowUnhandledTapUiIfNeededParams decode(Decoder decoder0) {
            UnhandledTapNotifierShowUnhandledTapUiIfNeededParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UnhandledTapNotifierShowUnhandledTapUiIfNeededParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.unhandledTapInfo = UnhandledTapInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.unhandledTapInfo, 8, false);
        }
    }
}
