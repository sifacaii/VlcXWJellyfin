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

class TextSuggestionBackend_Internal {
    public static final Interface.Manager<TextSuggestionBackend, TextSuggestionBackend.Proxy> MANAGER = new Interface.Manager<TextSuggestionBackend, TextSuggestionBackend.Proxy>() {
        public String getName() {
            return "blink.mojom.TextSuggestionBackend";
        }

        public int getVersion() {
            return 0;
        }

        public TextSuggestionBackend_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new TextSuggestionBackend_Internal.Proxy(core, messageReceiver);
        }

        public TextSuggestionBackend_Internal.Stub buildStub(Core core, TextSuggestionBackend impl) {
            return new TextSuggestionBackend_Internal.Stub(core, impl);
        }

        public TextSuggestionBackend[] buildArray(int size) {
            return new TextSuggestionBackend[size];
        }
    };

    private static final int APPLY_SPELL_CHECK_SUGGESTION_ORDINAL = 0;

    private static final int APPLY_TEXT_SUGGESTION_ORDINAL = 1;

    private static final int DELETE_ACTIVE_SUGGESTION_RANGE_ORDINAL = 2;

    private static final int ON_NEW_WORD_ADDED_TO_DICTIONARY_ORDINAL = 3;

    private static final int ON_SUGGESTION_MENU_CLOSED_ORDINAL = 4;

    private static final int SUGGESTION_MENU_TIMEOUT_CALLBACK_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements TextSuggestionBackend.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void applySpellCheckSuggestion(String suggestion) {
            TextSuggestionBackend_Internal.TextSuggestionBackendApplySpellCheckSuggestionParams _message = new TextSuggestionBackend_Internal.TextSuggestionBackendApplySpellCheckSuggestionParams();
            _message.suggestion = suggestion;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void applyTextSuggestion(int markerTag, int suggestionIndex) {
            TextSuggestionBackend_Internal.TextSuggestionBackendApplyTextSuggestionParams _message = new TextSuggestionBackend_Internal.TextSuggestionBackendApplyTextSuggestionParams();
            _message.markerTag = markerTag;
            _message.suggestionIndex = suggestionIndex;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void deleteActiveSuggestionRange() {
            TextSuggestionBackend_Internal.TextSuggestionBackendDeleteActiveSuggestionRangeParams _message = new TextSuggestionBackend_Internal.TextSuggestionBackendDeleteActiveSuggestionRangeParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onNewWordAddedToDictionary(String suggestion) {
            TextSuggestionBackend_Internal.TextSuggestionBackendOnNewWordAddedToDictionaryParams _message = new TextSuggestionBackend_Internal.TextSuggestionBackendOnNewWordAddedToDictionaryParams();
            _message.suggestion = suggestion;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void onSuggestionMenuClosed() {
            TextSuggestionBackend_Internal.TextSuggestionBackendOnSuggestionMenuClosedParams _message = new TextSuggestionBackend_Internal.TextSuggestionBackendOnSuggestionMenuClosedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void suggestionMenuTimeoutCallback(int maxNumberOfSuggestions) {
            TextSuggestionBackend_Internal.TextSuggestionBackendSuggestionMenuTimeoutCallbackParams _message = new TextSuggestionBackend_Internal.TextSuggestionBackendSuggestionMenuTimeoutCallbackParams();
            _message.maxNumberOfSuggestions = maxNumberOfSuggestions;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    static final class Stub extends Interface.Stub<TextSuggestionBackend> {
        Stub(Core core, TextSuggestionBackend impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                TextSuggestionBackend_Internal.TextSuggestionBackendApplySpellCheckSuggestionParams textSuggestionBackendApplySpellCheckSuggestionParams;
                TextSuggestionBackend_Internal.TextSuggestionBackendApplyTextSuggestionParams textSuggestionBackendApplyTextSuggestionParams;
                TextSuggestionBackend_Internal.TextSuggestionBackendOnNewWordAddedToDictionaryParams textSuggestionBackendOnNewWordAddedToDictionaryParams;
                TextSuggestionBackend_Internal.TextSuggestionBackendSuggestionMenuTimeoutCallbackParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(TextSuggestionBackend_Internal.MANAGER, messageWithHeader);
                    case 0:
                        textSuggestionBackendApplySpellCheckSuggestionParams = TextSuggestionBackend_Internal.TextSuggestionBackendApplySpellCheckSuggestionParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionBackend)getImpl()).applySpellCheckSuggestion(textSuggestionBackendApplySpellCheckSuggestionParams.suggestion);
                        return true;
                    case 1:
                        textSuggestionBackendApplyTextSuggestionParams = TextSuggestionBackend_Internal.TextSuggestionBackendApplyTextSuggestionParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionBackend)getImpl()).applyTextSuggestion(textSuggestionBackendApplyTextSuggestionParams.markerTag, textSuggestionBackendApplyTextSuggestionParams.suggestionIndex);
                        return true;
                    case 2:
                        TextSuggestionBackend_Internal.TextSuggestionBackendDeleteActiveSuggestionRangeParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionBackend)getImpl()).deleteActiveSuggestionRange();
                        return true;
                    case 3:
                        textSuggestionBackendOnNewWordAddedToDictionaryParams = TextSuggestionBackend_Internal.TextSuggestionBackendOnNewWordAddedToDictionaryParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionBackend)getImpl()).onNewWordAddedToDictionary(textSuggestionBackendOnNewWordAddedToDictionaryParams.suggestion);
                        return true;
                    case 4:
                        TextSuggestionBackend_Internal.TextSuggestionBackendOnSuggestionMenuClosedParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionBackend)getImpl()).onSuggestionMenuClosed();
                        return true;
                    case 5:
                        data = TextSuggestionBackend_Internal.TextSuggestionBackendSuggestionMenuTimeoutCallbackParams.deserialize(messageWithHeader.getPayload());
                        ((TextSuggestionBackend)getImpl()).suggestionMenuTimeoutCallback(data.maxNumberOfSuggestions);
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
                                getCore(), TextSuggestionBackend_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class TextSuggestionBackendApplySpellCheckSuggestionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String suggestion;

        private TextSuggestionBackendApplySpellCheckSuggestionParams(int version) {
            super(16, version);
        }

        public TextSuggestionBackendApplySpellCheckSuggestionParams() {
            this(0);
        }

        public static TextSuggestionBackendApplySpellCheckSuggestionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionBackendApplySpellCheckSuggestionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionBackendApplySpellCheckSuggestionParams decode(Decoder decoder0) {
            TextSuggestionBackendApplySpellCheckSuggestionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionBackendApplySpellCheckSuggestionParams(elementsOrVersion);
                result.suggestion = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.suggestion, 8, false);
        }
    }

    static final class TextSuggestionBackendApplyTextSuggestionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int markerTag;

        public int suggestionIndex;

        private TextSuggestionBackendApplyTextSuggestionParams(int version) {
            super(16, version);
        }

        public TextSuggestionBackendApplyTextSuggestionParams() {
            this(0);
        }

        public static TextSuggestionBackendApplyTextSuggestionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionBackendApplyTextSuggestionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionBackendApplyTextSuggestionParams decode(Decoder decoder0) {
            TextSuggestionBackendApplyTextSuggestionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionBackendApplyTextSuggestionParams(elementsOrVersion);
                result.markerTag = decoder0.readInt(8);
                result.suggestionIndex = decoder0.readInt(12);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.markerTag, 8);
            encoder0.encode(this.suggestionIndex, 12);
        }
    }

    static final class TextSuggestionBackendDeleteActiveSuggestionRangeParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private TextSuggestionBackendDeleteActiveSuggestionRangeParams(int version) {
            super(8, version);
        }

        public TextSuggestionBackendDeleteActiveSuggestionRangeParams() {
            this(0);
        }

        public static TextSuggestionBackendDeleteActiveSuggestionRangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionBackendDeleteActiveSuggestionRangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionBackendDeleteActiveSuggestionRangeParams decode(Decoder decoder0) {
            TextSuggestionBackendDeleteActiveSuggestionRangeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionBackendDeleteActiveSuggestionRangeParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class TextSuggestionBackendOnNewWordAddedToDictionaryParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String suggestion;

        private TextSuggestionBackendOnNewWordAddedToDictionaryParams(int version) {
            super(16, version);
        }

        public TextSuggestionBackendOnNewWordAddedToDictionaryParams() {
            this(0);
        }

        public static TextSuggestionBackendOnNewWordAddedToDictionaryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionBackendOnNewWordAddedToDictionaryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionBackendOnNewWordAddedToDictionaryParams decode(Decoder decoder0) {
            TextSuggestionBackendOnNewWordAddedToDictionaryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionBackendOnNewWordAddedToDictionaryParams(elementsOrVersion);
                result.suggestion = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.suggestion, 8, false);
        }
    }

    static final class TextSuggestionBackendOnSuggestionMenuClosedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private TextSuggestionBackendOnSuggestionMenuClosedParams(int version) {
            super(8, version);
        }

        public TextSuggestionBackendOnSuggestionMenuClosedParams() {
            this(0);
        }

        public static TextSuggestionBackendOnSuggestionMenuClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionBackendOnSuggestionMenuClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionBackendOnSuggestionMenuClosedParams decode(Decoder decoder0) {
            TextSuggestionBackendOnSuggestionMenuClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionBackendOnSuggestionMenuClosedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class TextSuggestionBackendSuggestionMenuTimeoutCallbackParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int maxNumberOfSuggestions;

        private TextSuggestionBackendSuggestionMenuTimeoutCallbackParams(int version) {
            super(16, version);
        }

        public TextSuggestionBackendSuggestionMenuTimeoutCallbackParams() {
            this(0);
        }

        public static TextSuggestionBackendSuggestionMenuTimeoutCallbackParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static TextSuggestionBackendSuggestionMenuTimeoutCallbackParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static TextSuggestionBackendSuggestionMenuTimeoutCallbackParams decode(Decoder decoder0) {
            TextSuggestionBackendSuggestionMenuTimeoutCallbackParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionBackendSuggestionMenuTimeoutCallbackParams(elementsOrVersion);
                result.maxNumberOfSuggestions = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.maxNumberOfSuggestions, 8);
        }
    }
}
