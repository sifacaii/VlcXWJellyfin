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
import org.chromium.mojo_base.mojom.File;

class Hyphenation_Internal {
    public static final Interface.Manager<Hyphenation, Hyphenation.Proxy> MANAGER = new Interface.Manager<Hyphenation, Hyphenation.Proxy>() {
        public String getName() {
            return "blink.mojom.Hyphenation";
        }

        public int getVersion() {
            return 0;
        }

        public Hyphenation_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Hyphenation_Internal.Proxy(core, messageReceiver);
        }

        public Hyphenation_Internal.Stub buildStub(Core core, Hyphenation impl) {
            return new Hyphenation_Internal.Stub(core, impl);
        }

        public Hyphenation[] buildArray(int size) {
            return new Hyphenation[size];
        }
    };

    private static final int OPEN_DICTIONARY_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements Hyphenation.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openDictionary(String locale, Hyphenation.OpenDictionaryResponse callback) {
            Hyphenation_Internal.HyphenationOpenDictionaryParams _message = new Hyphenation_Internal.HyphenationOpenDictionaryParams();
            _message.locale = locale;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new Hyphenation_Internal.HyphenationOpenDictionaryResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<Hyphenation> {
        Stub(Core core, Hyphenation impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Hyphenation_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                Hyphenation_Internal.HyphenationOpenDictionaryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Hyphenation_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = Hyphenation_Internal.HyphenationOpenDictionaryParams.deserialize(messageWithHeader.getPayload());
                        ((Hyphenation)getImpl()).openDictionary(data.locale, new Hyphenation_Internal.HyphenationOpenDictionaryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class HyphenationOpenDictionaryParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String locale;

        private HyphenationOpenDictionaryParams(int version) {
            super(16, version);
        }

        public HyphenationOpenDictionaryParams() {
            this(0);
        }

        public static HyphenationOpenDictionaryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HyphenationOpenDictionaryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HyphenationOpenDictionaryParams decode(Decoder decoder0) {
            HyphenationOpenDictionaryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HyphenationOpenDictionaryParams(elementsOrVersion);
                result.locale = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.locale, 8, false);
        }
    }

    static final class HyphenationOpenDictionaryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public File hyphenationDictionaryHandle;

        private HyphenationOpenDictionaryResponseParams(int version) {
            super(16, version);
        }

        public HyphenationOpenDictionaryResponseParams() {
            this(0);
        }

        public static HyphenationOpenDictionaryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HyphenationOpenDictionaryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HyphenationOpenDictionaryResponseParams decode(Decoder decoder0) {
            HyphenationOpenDictionaryResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HyphenationOpenDictionaryResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.hyphenationDictionaryHandle = File.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.hyphenationDictionaryHandle, 8, true);
        }
    }

    static class HyphenationOpenDictionaryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Hyphenation.OpenDictionaryResponse mCallback;

        HyphenationOpenDictionaryResponseParamsForwardToCallback(Hyphenation.OpenDictionaryResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                Hyphenation_Internal.HyphenationOpenDictionaryResponseParams response = Hyphenation_Internal.HyphenationOpenDictionaryResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.hyphenationDictionaryHandle);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class HyphenationOpenDictionaryResponseParamsProxyToResponder implements Hyphenation.OpenDictionaryResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        HyphenationOpenDictionaryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(File hyphenationDictionaryHandle) {
            Hyphenation_Internal.HyphenationOpenDictionaryResponseParams _response = new Hyphenation_Internal.HyphenationOpenDictionaryResponseParams();
            _response.hyphenationDictionaryHandle = hyphenationDictionaryHandle;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
