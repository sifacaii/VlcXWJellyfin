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

class ColorChooserClient_Internal {
    public static final Interface.Manager<ColorChooserClient, ColorChooserClient.Proxy> MANAGER = new Interface.Manager<ColorChooserClient, ColorChooserClient.Proxy>() {
        public String getName() {
            return "blink.mojom.ColorChooserClient";
        }

        public int getVersion() {
            return 0;
        }

        public ColorChooserClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ColorChooserClient_Internal.Proxy(core, messageReceiver);
        }

        public ColorChooserClient_Internal.Stub buildStub(Core core, ColorChooserClient impl) {
            return new ColorChooserClient_Internal.Stub(core, impl);
        }

        public ColorChooserClient[] buildArray(int size) {
            return new ColorChooserClient[size];
        }
    };

    private static final int DID_CHOOSE_COLOR_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ColorChooserClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didChooseColor(int color) {
            ColorChooserClient_Internal.ColorChooserClientDidChooseColorParams _message = new ColorChooserClient_Internal.ColorChooserClientDidChooseColorParams();
            _message.color = color;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ColorChooserClient> {
        Stub(Core core, ColorChooserClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ColorChooserClient_Internal.ColorChooserClientDidChooseColorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ColorChooserClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ColorChooserClient_Internal.ColorChooserClientDidChooseColorParams.deserialize(messageWithHeader.getPayload());
                        ((ColorChooserClient)getImpl()).didChooseColor(data.color);
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
                                getCore(), ColorChooserClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ColorChooserClientDidChooseColorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int color;

        private ColorChooserClientDidChooseColorParams(int version) {
            super(16, version);
        }

        public ColorChooserClientDidChooseColorParams() {
            this(0);
        }

        public static ColorChooserClientDidChooseColorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ColorChooserClientDidChooseColorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ColorChooserClientDidChooseColorParams decode(Decoder decoder0) {
            ColorChooserClientDidChooseColorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ColorChooserClientDidChooseColorParams(elementsOrVersion);
                result.color = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.color, 8);
        }
    }
}
