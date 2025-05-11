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
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

class FontUniqueNameLookup_Internal {
    public static final Interface.Manager<FontUniqueNameLookup, FontUniqueNameLookup.Proxy> MANAGER = new Interface.Manager<FontUniqueNameLookup, FontUniqueNameLookup.Proxy>() {
        public String getName() {
            return "blink.mojom.FontUniqueNameLookup";
        }

        public int getVersion() {
            return 0;
        }

        public FontUniqueNameLookup_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FontUniqueNameLookup_Internal.Proxy(core, messageReceiver);
        }

        public FontUniqueNameLookup_Internal.Stub buildStub(Core core, FontUniqueNameLookup impl) {
            return new FontUniqueNameLookup_Internal.Stub(core, impl);
        }

        public FontUniqueNameLookup[] buildArray(int size) {
            return new FontUniqueNameLookup[size];
        }
    };

    private static final int GET_UNIQUE_NAME_LOOKUP_TABLE_IF_AVAILABLE_ORDINAL = 0;

    private static final int GET_UNIQUE_NAME_LOOKUP_TABLE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements FontUniqueNameLookup.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getUniqueNameLookupTableIfAvailable(FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailableResponse callback) {
            FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams _message = new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsForwardToCallback(callback));
        }

        public void getUniqueNameLookupTable(FontUniqueNameLookup.GetUniqueNameLookupTableResponse callback) {
            FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableParams _message = new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FontUniqueNameLookup> {
        Stub(Core core, FontUniqueNameLookup impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FontUniqueNameLookup_Internal.MANAGER, messageWithHeader);
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
                                getCore(), FontUniqueNameLookup_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams.deserialize(messageWithHeader.getPayload());
                        ((FontUniqueNameLookup)getImpl()).getUniqueNameLookupTableIfAvailable(new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableParams.deserialize(messageWithHeader.getPayload());
                        ((FontUniqueNameLookup)getImpl()).getUniqueNameLookupTable(new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams(int version) {
            super(8, version);
        }

        public FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams() {
            this(0);
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams decode(Decoder decoder0) {
            FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean syncAvailable;

        public ReadOnlySharedMemoryRegion fontLookupTable;

        private FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams(int version) {
            super(24, version);
        }

        public FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams() {
            this(0);
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams decode(Decoder decoder0) {
            FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams(elementsOrVersion);
                result.syncAvailable = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.fontLookupTable = ReadOnlySharedMemoryRegion.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.syncAvailable, 8, 0);
            encoder0.encode((Struct)this.fontLookupTable, 16, true);
        }
    }

    static class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailableResponse mCallback;

        FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsForwardToCallback(FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailableResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams response = FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.syncAvailable), response.fontLookupTable);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsProxyToResponder implements FontUniqueNameLookup.GetUniqueNameLookupTableIfAvailableResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean syncAvailable, ReadOnlySharedMemoryRegion fontLookupTable) {
            FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams _response = new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableIfAvailableResponseParams();
            _response.syncAvailable = syncAvailable.booleanValue();
            _response.fontLookupTable = fontLookupTable;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FontUniqueNameLookupGetUniqueNameLookupTableParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FontUniqueNameLookupGetUniqueNameLookupTableParams(int version) {
            super(8, version);
        }

        public FontUniqueNameLookupGetUniqueNameLookupTableParams() {
            this(0);
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableParams decode(Decoder decoder0) {
            FontUniqueNameLookupGetUniqueNameLookupTableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FontUniqueNameLookupGetUniqueNameLookupTableParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FontUniqueNameLookupGetUniqueNameLookupTableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ReadOnlySharedMemoryRegion fontLookupTable;

        private FontUniqueNameLookupGetUniqueNameLookupTableResponseParams(int version) {
            super(16, version);
        }

        public FontUniqueNameLookupGetUniqueNameLookupTableResponseParams() {
            this(0);
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FontUniqueNameLookupGetUniqueNameLookupTableResponseParams decode(Decoder decoder0) {
            FontUniqueNameLookupGetUniqueNameLookupTableResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FontUniqueNameLookupGetUniqueNameLookupTableResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.fontLookupTable = ReadOnlySharedMemoryRegion.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.fontLookupTable, 8, true);
        }
    }

    static class FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FontUniqueNameLookup.GetUniqueNameLookupTableResponse mCallback;

        FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsForwardToCallback(FontUniqueNameLookup.GetUniqueNameLookupTableResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableResponseParams response = FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.fontLookupTable);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsProxyToResponder implements FontUniqueNameLookup.GetUniqueNameLookupTableResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FontUniqueNameLookupGetUniqueNameLookupTableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(ReadOnlySharedMemoryRegion fontLookupTable) {
            FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableResponseParams _response = new FontUniqueNameLookup_Internal.FontUniqueNameLookupGetUniqueNameLookupTableResponseParams();
            _response.fontLookupTable = fontLookupTable;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
