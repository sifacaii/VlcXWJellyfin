package org.chromium.network.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.network.mojom.DataPipeGetter;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal.class */
class DataPipeGetter_Internal {
    public static final Interface.Manager<DataPipeGetter, DataPipeGetter.Proxy> MANAGER = new Interface.Manager<DataPipeGetter, DataPipeGetter.Proxy>() { // from class: org.chromium.network.mojom.DataPipeGetter_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.DataPipeGetter";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public DataPipeGetter.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, DataPipeGetter impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public DataPipeGetter[] buildArray(int size) {
            return new DataPipeGetter[size];
        }
    };
    private static final int READ_ORDINAL = 0;
    private static final int CLONE_ORDINAL = 1;

    DataPipeGetter_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements DataPipeGetter.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.DataPipeGetter
        public void read(DataPipe.ProducerHandle pipe, DataPipeGetter.ReadResponse callback) {
            DataPipeGetterReadParams _message = new DataPipeGetterReadParams();
            _message.pipe = pipe;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new DataPipeGetterReadResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.DataPipeGetter
        public void clone(InterfaceRequest<DataPipeGetter> request) {
            DataPipeGetterCloneParams _message = new DataPipeGetterCloneParams();
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<DataPipeGetter> {
        Stub(Core core, DataPipeGetter impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DataPipeGetter_Internal.MANAGER, messageWithHeader);
                    case 1:
                        DataPipeGetterCloneParams data = DataPipeGetterCloneParams.deserialize(messageWithHeader.getPayload());
                        getImpl().clone(data.request);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), DataPipeGetter_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        DataPipeGetterReadParams data = DataPipeGetterReadParams.deserialize(messageWithHeader.getPayload());
                        getImpl().read(data.pipe, new DataPipeGetterReadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$DataPipeGetterReadParams.class */
    static final class DataPipeGetterReadParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DataPipe.ProducerHandle pipe;

        private DataPipeGetterReadParams(int version) {
            super(16, version);
            this.pipe = InvalidHandle.INSTANCE;
        }

        public DataPipeGetterReadParams() {
            this(0);
        }

        public static DataPipeGetterReadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DataPipeGetterReadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DataPipeGetterReadParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DataPipeGetterReadParams result = new DataPipeGetterReadParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$DataPipeGetterReadResponseParams.class */
    public static final class DataPipeGetterReadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;
        public long size;

        private DataPipeGetterReadResponseParams(int version) {
            super(24, version);
        }

        public DataPipeGetterReadResponseParams() {
            this(0);
        }

        public static DataPipeGetterReadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DataPipeGetterReadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DataPipeGetterReadResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DataPipeGetterReadResponseParams result = new DataPipeGetterReadResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$DataPipeGetterReadResponseParamsForwardToCallback.class */
    static class DataPipeGetterReadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final DataPipeGetter.ReadResponse mCallback;

        DataPipeGetterReadResponseParamsForwardToCallback(DataPipeGetter.ReadResponse callback) {
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
                DataPipeGetterReadResponseParams response = DataPipeGetterReadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), Long.valueOf(response.size));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$DataPipeGetterReadResponseParamsProxyToResponder.class */
    static class DataPipeGetterReadResponseParamsProxyToResponder implements DataPipeGetter.ReadResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DataPipeGetterReadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer status, Long size) {
            DataPipeGetterReadResponseParams _response = new DataPipeGetterReadResponseParams();
            _response.status = status.intValue();
            _response.size = size.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter_Internal$DataPipeGetterCloneParams.class */
    static final class DataPipeGetterCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<DataPipeGetter> request;

        private DataPipeGetterCloneParams(int version) {
            super(16, version);
        }

        public DataPipeGetterCloneParams() {
            this(0);
        }

        public static DataPipeGetterCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DataPipeGetterCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DataPipeGetterCloneParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DataPipeGetterCloneParams result = new DataPipeGetterCloneParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.request, 8, false);
        }
    }
}
