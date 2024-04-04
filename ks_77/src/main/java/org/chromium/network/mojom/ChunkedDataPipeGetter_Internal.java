package org.chromium.network.mojom;

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
import org.chromium.network.mojom.ChunkedDataPipeGetter;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal.class */
class ChunkedDataPipeGetter_Internal {
    public static final Interface.Manager<ChunkedDataPipeGetter, ChunkedDataPipeGetter.Proxy> MANAGER = new Interface.Manager<ChunkedDataPipeGetter, ChunkedDataPipeGetter.Proxy>() { // from class: org.chromium.network.mojom.ChunkedDataPipeGetter_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.ChunkedDataPipeGetter";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public ChunkedDataPipeGetter.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, ChunkedDataPipeGetter impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public ChunkedDataPipeGetter[] buildArray(int size) {
            return new ChunkedDataPipeGetter[size];
        }
    };
    private static final int GET_SIZE_ORDINAL = 0;
    private static final int START_READING_ORDINAL = 1;

    ChunkedDataPipeGetter_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements ChunkedDataPipeGetter.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.ChunkedDataPipeGetter
        public void getSize(ChunkedDataPipeGetter.GetSizeResponse callback) {
            ChunkedDataPipeGetterGetSizeParams _message = new ChunkedDataPipeGetterGetSizeParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ChunkedDataPipeGetterGetSizeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.ChunkedDataPipeGetter
        public void startReading(DataPipe.ProducerHandle pipe) {
            ChunkedDataPipeGetterStartReadingParams _message = new ChunkedDataPipeGetterStartReadingParams();
            _message.pipe = pipe;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<ChunkedDataPipeGetter> {
        Stub(Core core, ChunkedDataPipeGetter impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ChunkedDataPipeGetter_Internal.MANAGER, messageWithHeader);
                    case 1:
                        ChunkedDataPipeGetterStartReadingParams data = ChunkedDataPipeGetterStartReadingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().startReading(data.pipe);
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), ChunkedDataPipeGetter_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ChunkedDataPipeGetterGetSizeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getSize(new ChunkedDataPipeGetterGetSizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$ChunkedDataPipeGetterGetSizeParams.class */
    static final class ChunkedDataPipeGetterGetSizeParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ChunkedDataPipeGetterGetSizeParams(int version) {
            super(8, version);
        }

        public ChunkedDataPipeGetterGetSizeParams() {
            this(0);
        }

        public static ChunkedDataPipeGetterGetSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ChunkedDataPipeGetterGetSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ChunkedDataPipeGetterGetSizeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ChunkedDataPipeGetterGetSizeParams result = new ChunkedDataPipeGetterGetSizeParams(elementsOrVersion);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$ChunkedDataPipeGetterGetSizeResponseParams.class */
    public static final class ChunkedDataPipeGetterGetSizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;
        public long size;

        private ChunkedDataPipeGetterGetSizeResponseParams(int version) {
            super(24, version);
        }

        public ChunkedDataPipeGetterGetSizeResponseParams() {
            this(0);
        }

        public static ChunkedDataPipeGetterGetSizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ChunkedDataPipeGetterGetSizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ChunkedDataPipeGetterGetSizeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ChunkedDataPipeGetterGetSizeResponseParams result = new ChunkedDataPipeGetterGetSizeResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                result.size = decoder0.readLong(16);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.size, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$ChunkedDataPipeGetterGetSizeResponseParamsForwardToCallback.class */
    static class ChunkedDataPipeGetterGetSizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ChunkedDataPipeGetter.GetSizeResponse mCallback;

        ChunkedDataPipeGetterGetSizeResponseParamsForwardToCallback(ChunkedDataPipeGetter.GetSizeResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                ChunkedDataPipeGetterGetSizeResponseParams response = ChunkedDataPipeGetterGetSizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), Long.valueOf(response.size));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$ChunkedDataPipeGetterGetSizeResponseParamsProxyToResponder.class */
    static class ChunkedDataPipeGetterGetSizeResponseParamsProxyToResponder implements ChunkedDataPipeGetter.GetSizeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ChunkedDataPipeGetterGetSizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer status, Long size) {
            ChunkedDataPipeGetterGetSizeResponseParams _response = new ChunkedDataPipeGetterGetSizeResponseParams();
            _response.status = status.intValue();
            _response.size = size.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter_Internal$ChunkedDataPipeGetterStartReadingParams.class */
    static final class ChunkedDataPipeGetterStartReadingParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DataPipe.ProducerHandle pipe;

        private ChunkedDataPipeGetterStartReadingParams(int version) {
            super(16, version);
            this.pipe = InvalidHandle.INSTANCE;
        }

        public ChunkedDataPipeGetterStartReadingParams() {
            this(0);
        }

        public static ChunkedDataPipeGetterStartReadingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ChunkedDataPipeGetterStartReadingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ChunkedDataPipeGetterStartReadingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ChunkedDataPipeGetterStartReadingParams result = new ChunkedDataPipeGetterStartReadingParams(elementsOrVersion);
                result.pipe = decoder0.readProducerHandle(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle) this.pipe, 8, false);
        }
    }
}
