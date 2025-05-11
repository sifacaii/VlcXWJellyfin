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
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.File;
import org.chromium.network.mojom.NetLogExporter;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal.class */
class NetLogExporter_Internal {
    public static final Interface.Manager<NetLogExporter, NetLogExporter.Proxy> MANAGER = new Interface.Manager<NetLogExporter, NetLogExporter.Proxy>() { // from class: org.chromium.network.mojom.NetLogExporter_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetLogExporter";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetLogExporter.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetLogExporter impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetLogExporter[] buildArray(int size) {
            return new NetLogExporter[size];
        }
    };
    private static final int START_ORDINAL = 0;
    private static final int STOP_ORDINAL = 1;

    NetLogExporter_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetLogExporter.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetLogExporter
        public void start(File destination, DictionaryValue extraConstants, int captureMode, long maxFileSize, NetLogExporter.StartResponse callback) {
            NetLogExporterStartParams _message = new NetLogExporterStartParams();
            _message.destination = destination;
            _message.extraConstants = extraConstants;
            _message.captureMode = captureMode;
            _message.maxFileSize = maxFileSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NetLogExporterStartResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetLogExporter
        public void stop(DictionaryValue polledValues, NetLogExporter.StopResponse callback) {
            NetLogExporterStopParams _message = new NetLogExporterStopParams();
            _message.polledValues = polledValues;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NetLogExporterStopResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetLogExporter> {
        Stub(Core core, NetLogExporter impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetLogExporter_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetLogExporter_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        NetLogExporterStartParams data = NetLogExporterStartParams.deserialize(messageWithHeader.getPayload());
                        getImpl().start(data.destination, data.extraConstants, data.captureMode, data.maxFileSize, new NetLogExporterStartResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        getImpl().stop(NetLogExporterStopParams.deserialize(messageWithHeader.getPayload()).polledValues, new NetLogExporterStopResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStartParams.class */
    static final class NetLogExporterStartParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public File destination;
        public DictionaryValue extraConstants;
        public int captureMode;
        public long maxFileSize;

        private NetLogExporterStartParams(int version) {
            super(40, version);
        }

        public NetLogExporterStartParams() {
            this(0);
        }

        public static NetLogExporterStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetLogExporterStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetLogExporterStartParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetLogExporterStartParams result = new NetLogExporterStartParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.destination = File.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.extraConstants = DictionaryValue.decode(decoder12);
                result.captureMode = decoder0.readInt(24);
                NetLogCaptureMode.validate(result.captureMode);
                result.maxFileSize = decoder0.readLong(32);
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
            encoder0.encode((Struct) this.destination, 8, false);
            encoder0.encode((Struct) this.extraConstants, 16, false);
            encoder0.encode(this.captureMode, 24);
            encoder0.encode(this.maxFileSize, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStartResponseParams.class */
    public static final class NetLogExporterStartResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;

        private NetLogExporterStartResponseParams(int version) {
            super(16, version);
        }

        public NetLogExporterStartResponseParams() {
            this(0);
        }

        public static NetLogExporterStartResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetLogExporterStartResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetLogExporterStartResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetLogExporterStartResponseParams result = new NetLogExporterStartResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
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
            encoder0.encode(this.netError, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStartResponseParamsForwardToCallback.class */
    static class NetLogExporterStartResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetLogExporter.StartResponse mCallback;

        NetLogExporterStartResponseParamsForwardToCallback(NetLogExporter.StartResponse callback) {
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
                NetLogExporterStartResponseParams response = NetLogExporterStartResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStartResponseParamsProxyToResponder.class */
    static class NetLogExporterStartResponseParamsProxyToResponder implements NetLogExporter.StartResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetLogExporterStartResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer netError) {
            NetLogExporterStartResponseParams _response = new NetLogExporterStartResponseParams();
            _response.netError = netError.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStopParams.class */
    static final class NetLogExporterStopParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public DictionaryValue polledValues;

        private NetLogExporterStopParams(int version) {
            super(16, version);
        }

        public NetLogExporterStopParams() {
            this(0);
        }

        public static NetLogExporterStopParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetLogExporterStopParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetLogExporterStopParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetLogExporterStopParams result = new NetLogExporterStopParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.polledValues = DictionaryValue.decode(decoder1);
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
            encoder0.encode((Struct) this.polledValues, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStopResponseParams.class */
    public static final class NetLogExporterStopResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;

        private NetLogExporterStopResponseParams(int version) {
            super(16, version);
        }

        public NetLogExporterStopResponseParams() {
            this(0);
        }

        public static NetLogExporterStopResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetLogExporterStopResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetLogExporterStopResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetLogExporterStopResponseParams result = new NetLogExporterStopResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
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
            encoder0.encode(this.netError, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStopResponseParamsForwardToCallback.class */
    static class NetLogExporterStopResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetLogExporter.StopResponse mCallback;

        NetLogExporterStopResponseParamsForwardToCallback(NetLogExporter.StopResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                NetLogExporterStopResponseParams response = NetLogExporterStopResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetLogExporter_Internal$NetLogExporterStopResponseParamsProxyToResponder.class */
    static class NetLogExporterStopResponseParamsProxyToResponder implements NetLogExporter.StopResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetLogExporterStopResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer netError) {
            NetLogExporterStopResponseParams _response = new NetLogExporterStopResponseParams();
            _response.netError = netError.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
