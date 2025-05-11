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

class ColorChooser_Internal {
    public static final Interface.Manager<ColorChooser, ColorChooser.Proxy> MANAGER = new Interface.Manager<ColorChooser, ColorChooser.Proxy>() {
        public String getName() {
            return "blink.mojom.ColorChooser";
        }

        public int getVersion() {
            return 0;
        }

        public ColorChooser_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ColorChooser_Internal.Proxy(core, messageReceiver);
        }

        public ColorChooser_Internal.Stub buildStub(Core core, ColorChooser impl) {
            return new ColorChooser_Internal.Stub(core, impl);
        }

        public ColorChooser[] buildArray(int size) {
            return new ColorChooser[size];
        }
    };

    private static final int SET_SELECTED_COLOR_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ColorChooser.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setSelectedColor(int color) {
            ColorChooser_Internal.ColorChooserSetSelectedColorParams _message = new ColorChooser_Internal.ColorChooserSetSelectedColorParams();
            _message.color = color;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ColorChooser> {
        Stub(Core core, ColorChooser impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ColorChooser_Internal.ColorChooserSetSelectedColorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ColorChooser_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ColorChooser_Internal.ColorChooserSetSelectedColorParams.deserialize(messageWithHeader.getPayload());
                        ((ColorChooser)getImpl()).setSelectedColor(data.color);
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
                                getCore(), ColorChooser_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ColorChooserSetSelectedColorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int color;

        private ColorChooserSetSelectedColorParams(int version) {
            super(16, version);
        }

        public ColorChooserSetSelectedColorParams() {
            this(0);
        }

        public static ColorChooserSetSelectedColorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ColorChooserSetSelectedColorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ColorChooserSetSelectedColorParams decode(Decoder decoder0) {
            ColorChooserSetSelectedColorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ColorChooserSetSelectedColorParams(elementsOrVersion);
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
