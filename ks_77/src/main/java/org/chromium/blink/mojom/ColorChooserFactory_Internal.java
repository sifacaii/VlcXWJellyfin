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

class ColorChooserFactory_Internal {
    public static final Interface.Manager<ColorChooserFactory, ColorChooserFactory.Proxy> MANAGER = new Interface.Manager<ColorChooserFactory, ColorChooserFactory.Proxy>() {
        public String getName() {
            return "blink.mojom.ColorChooserFactory";
        }

        public int getVersion() {
            return 0;
        }

        public ColorChooserFactory_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ColorChooserFactory_Internal.Proxy(core, messageReceiver);
        }

        public ColorChooserFactory_Internal.Stub buildStub(Core core, ColorChooserFactory impl) {
            return new ColorChooserFactory_Internal.Stub(core, impl);
        }

        public ColorChooserFactory[] buildArray(int size) {
            return new ColorChooserFactory[size];
        }
    };

    private static final int OPEN_COLOR_CHOOSER_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ColorChooserFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openColorChooser(InterfaceRequest<ColorChooser> chooser, ColorChooserClient client, int color, ColorSuggestion[] suggestions) {
            ColorChooserFactory_Internal.ColorChooserFactoryOpenColorChooserParams _message = new ColorChooserFactory_Internal.ColorChooserFactoryOpenColorChooserParams();
            _message.chooser = chooser;
            _message.client = client;
            _message.color = color;
            _message.suggestions = suggestions;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ColorChooserFactory> {
        Stub(Core core, ColorChooserFactory impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ColorChooserFactory_Internal.ColorChooserFactoryOpenColorChooserParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ColorChooserFactory_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ColorChooserFactory_Internal.ColorChooserFactoryOpenColorChooserParams.deserialize(messageWithHeader.getPayload());
                        ((ColorChooserFactory)getImpl()).openColorChooser(data.chooser, data.client, data.color, data.suggestions);
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
                                getCore(), ColorChooserFactory_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ColorChooserFactoryOpenColorChooserParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<ColorChooser> chooser;

        public ColorChooserClient client;

        public int color;

        public ColorSuggestion[] suggestions;

        private ColorChooserFactoryOpenColorChooserParams(int version) {
            super(32, version);
        }

        public ColorChooserFactoryOpenColorChooserParams() {
            this(0);
        }

        public static ColorChooserFactoryOpenColorChooserParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ColorChooserFactoryOpenColorChooserParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ColorChooserFactoryOpenColorChooserParams decode(Decoder decoder0) {
            ColorChooserFactoryOpenColorChooserParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ColorChooserFactoryOpenColorChooserParams(elementsOrVersion);
                result.chooser = decoder0.readInterfaceRequest(8, false);
                result.client = (ColorChooserClient)decoder0.readServiceInterface(12, false, ColorChooserClient.MANAGER);
                result.color = decoder0.readInt(20);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.suggestions = new ColorSuggestion[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.suggestions[i1] = ColorSuggestion.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.chooser, 8, false);
            encoder0.encode(this.client, 12, false, ColorChooserClient.MANAGER);
            encoder0.encode(this.color, 20);
            if (this.suggestions == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 24, -1);
                for (int i0 = 0; i0 < this.suggestions.length; i0++)
                    encoder1.encode(this.suggestions[i0], 8 + 8 * i0, false);
            }
        }
    }
}
