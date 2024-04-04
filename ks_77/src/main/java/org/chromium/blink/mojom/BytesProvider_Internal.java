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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.Time;

class BytesProvider_Internal {
    public static final Interface.Manager<BytesProvider, BytesProvider.Proxy> MANAGER = new Interface.Manager<BytesProvider, BytesProvider.Proxy>() {
        public String getName() {
            return "blink.mojom.BytesProvider";
        }

        public int getVersion() {
            return 0;
        }

        public BytesProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BytesProvider_Internal.Proxy(core, messageReceiver);
        }

        public BytesProvider_Internal.Stub buildStub(Core core, BytesProvider impl) {
            return new BytesProvider_Internal.Stub(core, impl);
        }

        public BytesProvider[] buildArray(int size) {
            return new BytesProvider[size];
        }
    };

    private static final int REQUEST_AS_REPLY_ORDINAL = 0;

    private static final int REQUEST_AS_STREAM_ORDINAL = 1;

    private static final int REQUEST_AS_FILE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements BytesProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void requestAsReply(BytesProvider.RequestAsReplyResponse callback) {
            BytesProvider_Internal.BytesProviderRequestAsReplyParams _message = new BytesProvider_Internal.BytesProviderRequestAsReplyParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BytesProvider_Internal.BytesProviderRequestAsReplyResponseParamsForwardToCallback(callback));
        }

        public void requestAsStream(DataPipe.ProducerHandle pipe) {
            BytesProvider_Internal.BytesProviderRequestAsStreamParams _message = new BytesProvider_Internal.BytesProviderRequestAsStreamParams();
            _message.pipe = pipe;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void requestAsFile(long sourceOffset, long sourceSize, File file, long fileOffset, BytesProvider.RequestAsFileResponse callback) {
            BytesProvider_Internal.BytesProviderRequestAsFileParams _message = new BytesProvider_Internal.BytesProviderRequestAsFileParams();
            _message.sourceOffset = sourceOffset;
            _message.sourceSize = sourceSize;
            _message.file = file;
            _message.fileOffset = fileOffset;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new BytesProvider_Internal.BytesProviderRequestAsFileResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<BytesProvider> {
        Stub(Core core, BytesProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BytesProvider_Internal.BytesProviderRequestAsStreamParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BytesProvider_Internal.MANAGER, messageWithHeader);
                    case 1:
                        data = BytesProvider_Internal.BytesProviderRequestAsStreamParams.deserialize(messageWithHeader.getPayload());
                        ((BytesProvider)getImpl()).requestAsStream(data.pipe);
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
                BytesProvider_Internal.BytesProviderRequestAsFileParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BytesProvider_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        BytesProvider_Internal.BytesProviderRequestAsReplyParams.deserialize(messageWithHeader.getPayload());
                        ((BytesProvider)getImpl()).requestAsReply(new BytesProvider_Internal.BytesProviderRequestAsReplyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = BytesProvider_Internal.BytesProviderRequestAsFileParams.deserialize(messageWithHeader.getPayload());
                        ((BytesProvider)getImpl()).requestAsFile(data.sourceOffset, data.sourceSize, data.file, data.fileOffset, new BytesProvider_Internal.BytesProviderRequestAsFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BytesProviderRequestAsReplyParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BytesProviderRequestAsReplyParams(int version) {
            super(8, version);
        }

        public BytesProviderRequestAsReplyParams() {
            this(0);
        }

        public static BytesProviderRequestAsReplyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BytesProviderRequestAsReplyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BytesProviderRequestAsReplyParams decode(Decoder decoder0) {
            BytesProviderRequestAsReplyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BytesProviderRequestAsReplyParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BytesProviderRequestAsReplyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] data;

        private BytesProviderRequestAsReplyResponseParams(int version) {
            super(16, version);
        }

        public BytesProviderRequestAsReplyResponseParams() {
            this(0);
        }

        public static BytesProviderRequestAsReplyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BytesProviderRequestAsReplyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BytesProviderRequestAsReplyResponseParams decode(Decoder decoder0) {
            BytesProviderRequestAsReplyResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BytesProviderRequestAsReplyResponseParams(elementsOrVersion);
                result.data = decoder0.readBytes(8, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.data, 8, 0, -1);
        }
    }

    static class BytesProviderRequestAsReplyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BytesProvider.RequestAsReplyResponse mCallback;

        BytesProviderRequestAsReplyResponseParamsForwardToCallback(BytesProvider.RequestAsReplyResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                BytesProvider_Internal.BytesProviderRequestAsReplyResponseParams response = BytesProvider_Internal.BytesProviderRequestAsReplyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BytesProviderRequestAsReplyResponseParamsProxyToResponder implements BytesProvider.RequestAsReplyResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BytesProviderRequestAsReplyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(byte[] data) {
            BytesProvider_Internal.BytesProviderRequestAsReplyResponseParams _response = new BytesProvider_Internal.BytesProviderRequestAsReplyResponseParams();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BytesProviderRequestAsStreamParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DataPipe.ProducerHandle pipe;

        private BytesProviderRequestAsStreamParams(int version) {
            super(16, version);
            this.pipe = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
        }

        public BytesProviderRequestAsStreamParams() {
            this(0);
        }

        public static BytesProviderRequestAsStreamParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BytesProviderRequestAsStreamParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BytesProviderRequestAsStreamParams decode(Decoder decoder0) {
            BytesProviderRequestAsStreamParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BytesProviderRequestAsStreamParams(elementsOrVersion);
                result.pipe = decoder0.readProducerHandle(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle)this.pipe, 8, false);
        }
    }

    static final class BytesProviderRequestAsFileParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long sourceOffset;

        public long sourceSize;

        public File file;

        public long fileOffset;

        private BytesProviderRequestAsFileParams(int version) {
            super(40, version);
        }

        public BytesProviderRequestAsFileParams() {
            this(0);
        }

        public static BytesProviderRequestAsFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BytesProviderRequestAsFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BytesProviderRequestAsFileParams decode(Decoder decoder0) {
            BytesProviderRequestAsFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BytesProviderRequestAsFileParams(elementsOrVersion);
                result.sourceOffset = decoder0.readLong(8);
                result.sourceSize = decoder0.readLong(16);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.file = File.decode(decoder1);
                result.fileOffset = decoder0.readLong(32);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sourceOffset, 8);
            encoder0.encode(this.sourceSize, 16);
            encoder0.encode((Struct)this.file, 24, false);
            encoder0.encode(this.fileOffset, 32);
        }
    }

    static final class BytesProviderRequestAsFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Time timeFileModified;

        private BytesProviderRequestAsFileResponseParams(int version) {
            super(16, version);
        }

        public BytesProviderRequestAsFileResponseParams() {
            this(0);
        }

        public static BytesProviderRequestAsFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BytesProviderRequestAsFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BytesProviderRequestAsFileResponseParams decode(Decoder decoder0) {
            BytesProviderRequestAsFileResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BytesProviderRequestAsFileResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.timeFileModified = Time.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.timeFileModified, 8, true);
        }
    }

    static class BytesProviderRequestAsFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BytesProvider.RequestAsFileResponse mCallback;

        BytesProviderRequestAsFileResponseParamsForwardToCallback(BytesProvider.RequestAsFileResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                BytesProvider_Internal.BytesProviderRequestAsFileResponseParams response = BytesProvider_Internal.BytesProviderRequestAsFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.timeFileModified);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BytesProviderRequestAsFileResponseParamsProxyToResponder implements BytesProvider.RequestAsFileResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BytesProviderRequestAsFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Time timeFileModified) {
            BytesProvider_Internal.BytesProviderRequestAsFileResponseParams _response = new BytesProvider_Internal.BytesProviderRequestAsFileResponseParams();
            _response.timeFileModified = timeFileModified;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
