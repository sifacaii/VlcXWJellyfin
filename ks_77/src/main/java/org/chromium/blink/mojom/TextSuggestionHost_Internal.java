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

class TextSuggestionHost_Internal {
    public static final Interface.Manager<TextSuggestionHost, TextSuggestionHost.Proxy> MANAGER = new Interface.Manager<TextSuggestionHost, TextSuggestionHost.Proxy>() {
        public String getName() {
            return "blink.mojom.TextSuggestionHost";
        }

        public int getVersion() {
            return 0;
        }

        public TextSuggestionHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new TextSuggestionHost_Internal.Proxy(core, messageReceiver);
        }

        public TextSuggestionHost_Internal.Stub buildStub(Core core, TextSuggestionHost impl) {
            return new TextSuggestionHost_Internal.Stub(core, impl);
        }

        public TextSuggestionHost[] buildArray(int size) {
            return new TextSuggestionHost[size];
        }
    };

    private static final int START_SUGGESTION_MENU_TIMER_ORDINAL = 0;

    private static final int SHOW_SPELL_CHECK_SUGGESTION_MENU_ORDINAL = 1;

    private static final int SHOW_TEXT_SUGGESTION_MENU_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements TextSuggestionHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void startSuggestionMenuTimer() {
            TextSuggestionHost_Internal.TextSuggestionHostStartSuggestionMenuTimerParams _message = new TextSuggestionHost_Internal.TextSuggestionHostStartSuggestionMenuTimerParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void showSpellCheckSuggestionMenu(double caretX, double caretY, String markedText, SpellCheckSuggestion[] suggestions) {
            TextSuggestionHost_Internal.TextSuggestionHostShowSpellCheckSuggestionMenuParams _message = new TextSuggestionHost_Internal.TextSuggestionHostShowSpellCheckSuggestionMenuParams();
            _message.caretX = caretX;
            _message.caretY = caretY;
            _message.markedText = markedText;
            _message.suggestions = suggestions;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void showTextSuggestionMenu(double caretX, double caretY, String markedText, TextSuggestion[] suggestions) {
            TextSuggestionHost_Internal.TextSuggestionHostShowTextSuggestionMenuParams _message = new TextSuggestionHost_Internal.TextSuggestionHostShowTextSuggestionMenuParams();
            _message.caretX = caretX;
            _message.caretY = caretY;
            _message.markedText = markedText;
            _message.suggestions = suggestions;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<TextSuggestionHost> {
        Stub(Core core, TextSuggestionHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                TextSuggestionHost_Internal.TextSuggestionHostShowSpellCheckSuggestionMenuParams textSuggestionHostShowSpellCheckSuggestionMenuParams;
                TextSuggestionHost_Internal.TextSuggestionHostShowTextSuggestionMenuParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TextSuggestionHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        TextSuggestionHost_Internal.TextSuggestionHostStartSuggestionMenuTimerParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionHost)getImpl()).startSuggestionMenuTimer();
                        return true;
                    case 1:
                        textSuggestionHostShowSpellCheckSuggestionMenuParams = TextSuggestionHost_Internal.TextSuggestionHostShowSpellCheckSuggestionMenuParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionHost)getImpl()).showSpellCheckSuggestionMenu(textSuggestionHostShowSpellCheckSuggestionMenuParams.caretX, textSuggestionHostShowSpellCheckSuggestionMenuParams.caretY, textSuggestionHostShowSpellCheckSuggestionMenuParams.markedText, textSuggestionHostShowSpellCheckSuggestionMenuParams.suggestions);
                        return true;
                    case 2:
                        data = TextSuggestionHost_Internal.TextSuggestionHostShowTextSuggestionMenuParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionHost)getImpl()).showTextSuggestionMenu(data.caretX, data.caretY, data.markedText, data.suggestions);
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
                                getCore(), TextSuggestionHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class TextSuggestionHostStartSuggestionMenuTimerParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private TextSuggestionHostStartSuggestionMenuTimerParams(int version) {
            super(8, version);
        }

        public TextSuggestionHostStartSuggestionMenuTimerParams() {
            this(0);
        }

        public static TextSuggestionHostStartSuggestionMenuTimerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionHostStartSuggestionMenuTimerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionHostStartSuggestionMenuTimerParams decode(Decoder decoder0) {
            TextSuggestionHostStartSuggestionMenuTimerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionHostStartSuggestionMenuTimerParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class TextSuggestionHostShowSpellCheckSuggestionMenuParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public double caretX;

        public double caretY;

        public String markedText;

        public SpellCheckSuggestion[] suggestions;

        private TextSuggestionHostShowSpellCheckSuggestionMenuParams(int version) {
            super(40, version);
        }

        public TextSuggestionHostShowSpellCheckSuggestionMenuParams() {
            this(0);
        }

        public static TextSuggestionHostShowSpellCheckSuggestionMenuParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionHostShowSpellCheckSuggestionMenuParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionHostShowSpellCheckSuggestionMenuParams decode(Decoder decoder0) {
            TextSuggestionHostShowSpellCheckSuggestionMenuParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionHostShowSpellCheckSuggestionMenuParams(elementsOrVersion);
                result.caretX = decoder0.readDouble(8);
                result.caretY = decoder0.readDouble(16);
                result.markedText = decoder0.readString(24, false);
                Decoder decoder1 = decoder0.readPointer(32, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.suggestions = new SpellCheckSuggestion[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.suggestions[i1] = SpellCheckSuggestion.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.caretX, 8);
            encoder0.encode(this.caretY, 16);
            encoder0.encode(this.markedText, 24, false);
            if (this.suggestions == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 32, -1);
                for (int i0 = 0; i0 < this.suggestions.length; i0++)
                    encoder1.encode(this.suggestions[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class TextSuggestionHostShowTextSuggestionMenuParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public double caretX;

        public double caretY;

        public String markedText;

        public TextSuggestion[] suggestions;

        private TextSuggestionHostShowTextSuggestionMenuParams(int version) {
            super(40, version);
        }

        public TextSuggestionHostShowTextSuggestionMenuParams() {
            this(0);
        }

        public static TextSuggestionHostShowTextSuggestionMenuParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionHostShowTextSuggestionMenuParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionHostShowTextSuggestionMenuParams decode(Decoder decoder0) {
            TextSuggestionHostShowTextSuggestionMenuParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionHostShowTextSuggestionMenuParams(elementsOrVersion);
                result.caretX = decoder0.readDouble(8);
                result.caretY = decoder0.readDouble(16);
                result.markedText = decoder0.readString(24, false);
                Decoder decoder1 = decoder0.readPointer(32, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.suggestions = new TextSuggestion[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.suggestions[i1] = TextSuggestion.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.caretX, 8);
            encoder0.encode(this.caretY, 16);
            encoder0.encode(this.markedText, 24, false);
            if (this.suggestions == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 32, -1);
                for (int i0 = 0; i0 < this.suggestions.length; i0++)
                    encoder1.encode(this.suggestions[i0], 8 + 8 * i0, false);
            }
        }
    }
}
