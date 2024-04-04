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

class NativeFileSystemManager_Internal {
    public static final Interface.Manager<NativeFileSystemManager, NativeFileSystemManager.Proxy> MANAGER = new Interface.Manager<NativeFileSystemManager, NativeFileSystemManager.Proxy>() {
        public String getName() {
            return "blink.mojom.NativeFileSystemManager";
        }

        public int getVersion() {
            return 0;
        }

        public NativeFileSystemManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NativeFileSystemManager_Internal.Proxy(core, messageReceiver);
        }

        public NativeFileSystemManager_Internal.Stub buildStub(Core core, NativeFileSystemManager impl) {
            return new NativeFileSystemManager_Internal.Stub(core, impl);
        }

        public NativeFileSystemManager[] buildArray(int size) {
            return new NativeFileSystemManager[size];
        }
    };

    private static final int GET_SANDBOXED_FILE_SYSTEM_ORDINAL = 0;

    private static final int CHOOSE_ENTRIES_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements NativeFileSystemManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getSandboxedFileSystem(NativeFileSystemManager.GetSandboxedFileSystemResponse callback) {
            NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemParams _message = new NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemResponseParamsForwardToCallback(callback));
        }

        public void chooseEntries(int type, ChooseFileSystemEntryAcceptsOption[] accepts, boolean includeAcceptsAll, NativeFileSystemManager.ChooseEntriesResponse callback) {
            NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesParams _message = new NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesParams();
            _message.type = type;
            _message.accepts = accepts;
            _message.includeAcceptsAll = includeAcceptsAll;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<NativeFileSystemManager> {
        Stub(Core core, NativeFileSystemManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NativeFileSystemManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), NativeFileSystemManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemManager)getImpl()).getSandboxedFileSystem(new NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemManager)getImpl()).chooseEntries(data.type, data.accepts, data.includeAcceptsAll, new NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NativeFileSystemManagerGetSandboxedFileSystemParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemManagerGetSandboxedFileSystemParams(int version) {
            super(8, version);
        }

        public NativeFileSystemManagerGetSandboxedFileSystemParams() {
            this(0);
        }

        public static NativeFileSystemManagerGetSandboxedFileSystemParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemManagerGetSandboxedFileSystemParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemManagerGetSandboxedFileSystemParams decode(Decoder decoder0) {
            NativeFileSystemManagerGetSandboxedFileSystemParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemManagerGetSandboxedFileSystemParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemManagerGetSandboxedFileSystemResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public NativeFileSystemDirectoryHandle directory;

        private NativeFileSystemManagerGetSandboxedFileSystemResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemManagerGetSandboxedFileSystemResponseParams() {
            this(0);
        }

        public static NativeFileSystemManagerGetSandboxedFileSystemResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemManagerGetSandboxedFileSystemResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemManagerGetSandboxedFileSystemResponseParams decode(Decoder decoder0) {
            NativeFileSystemManagerGetSandboxedFileSystemResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemManagerGetSandboxedFileSystemResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                result.directory = (NativeFileSystemDirectoryHandle)decoder0.readServiceInterface(16, true, NativeFileSystemDirectoryHandle.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.directory, 16, true, NativeFileSystemDirectoryHandle.MANAGER);
        }
    }

    static class NativeFileSystemManagerGetSandboxedFileSystemResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemManager.GetSandboxedFileSystemResponse mCallback;

        NativeFileSystemManagerGetSandboxedFileSystemResponseParamsForwardToCallback(NativeFileSystemManager.GetSandboxedFileSystemResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemResponseParams response = NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.directory);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemManagerGetSandboxedFileSystemResponseParamsProxyToResponder implements NativeFileSystemManager.GetSandboxedFileSystemResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemManagerGetSandboxedFileSystemResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, NativeFileSystemDirectoryHandle directory) {
            NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemResponseParams _response = new NativeFileSystemManager_Internal.NativeFileSystemManagerGetSandboxedFileSystemResponseParams();
            _response.result = result;
            _response.directory = directory;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemManagerChooseEntriesParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        public ChooseFileSystemEntryAcceptsOption[] accepts;

        public boolean includeAcceptsAll;

        private NativeFileSystemManagerChooseEntriesParams(int version) {
            super(24, version);
        }

        public NativeFileSystemManagerChooseEntriesParams() {
            this(0);
        }

        public static NativeFileSystemManagerChooseEntriesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemManagerChooseEntriesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemManagerChooseEntriesParams decode(Decoder decoder0) {
            NativeFileSystemManagerChooseEntriesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemManagerChooseEntriesParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                ChooseFileSystemEntryType.validate(result.type);
                result.includeAcceptsAll = decoder0.readBoolean(12, 0);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.accepts = new ChooseFileSystemEntryAcceptsOption[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.accepts[i1] = ChooseFileSystemEntryAcceptsOption.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
            encoder0.encode(this.includeAcceptsAll, 12, 0);
            if (this.accepts == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.accepts.length, 16, -1);
                for (int i0 = 0; i0 < this.accepts.length; i0++)
                    encoder1.encode(this.accepts[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class NativeFileSystemManagerChooseEntriesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public NativeFileSystemEntry[] entries;

        private NativeFileSystemManagerChooseEntriesResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemManagerChooseEntriesResponseParams() {
            this(0);
        }

        public static NativeFileSystemManagerChooseEntriesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemManagerChooseEntriesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemManagerChooseEntriesResponseParams decode(Decoder decoder0) {
            NativeFileSystemManagerChooseEntriesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemManagerChooseEntriesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.entries = new NativeFileSystemEntry[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.entries[i1] = NativeFileSystemEntry.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            if (this.entries == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.entries.length, 16, -1);
                for (int i0 = 0; i0 < this.entries.length; i0++)
                    encoder1.encode(this.entries[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class NativeFileSystemManagerChooseEntriesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemManager.ChooseEntriesResponse mCallback;

        NativeFileSystemManagerChooseEntriesResponseParamsForwardToCallback(NativeFileSystemManager.ChooseEntriesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesResponseParams response = NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.entries);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemManagerChooseEntriesResponseParamsProxyToResponder implements NativeFileSystemManager.ChooseEntriesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemManagerChooseEntriesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, NativeFileSystemEntry[] entries) {
            NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesResponseParams _response = new NativeFileSystemManager_Internal.NativeFileSystemManagerChooseEntriesResponseParams();
            _response.result = result;
            _response.entries = entries;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
