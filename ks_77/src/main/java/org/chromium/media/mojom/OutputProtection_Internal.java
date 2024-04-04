package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.OutputProtection;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal.class */
class OutputProtection_Internal {
    public static final Interface.Manager<OutputProtection, OutputProtection.Proxy> MANAGER = new Interface.Manager<OutputProtection, OutputProtection.Proxy>() { // from class: org.chromium.media.mojom.OutputProtection_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.OutputProtection";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public OutputProtection.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, OutputProtection impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public OutputProtection[] buildArray(int size) {
            return new OutputProtection[size];
        }
    };
    private static final int QUERY_STATUS_ORDINAL = 0;
    private static final int ENABLE_PROTECTION_ORDINAL = 1;

    OutputProtection_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements OutputProtection.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.OutputProtection
        public void queryStatus(OutputProtection.QueryStatusResponse callback) {
            OutputProtectionQueryStatusParams _message = new OutputProtectionQueryStatusParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new OutputProtectionQueryStatusResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.OutputProtection
        public void enableProtection(int desiredProtectionMask, OutputProtection.EnableProtectionResponse callback) {
            OutputProtectionEnableProtectionParams _message = new OutputProtectionEnableProtectionParams();
            _message.desiredProtectionMask = desiredProtectionMask;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new OutputProtectionEnableProtectionResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<OutputProtection> {
        Stub(Core core, OutputProtection impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(OutputProtection_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), OutputProtection_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        OutputProtectionQueryStatusParams.deserialize(messageWithHeader.getPayload());
                        getImpl().queryStatus(new OutputProtectionQueryStatusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        OutputProtectionEnableProtectionParams data = OutputProtectionEnableProtectionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().enableProtection(data.desiredProtectionMask, new OutputProtectionEnableProtectionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionQueryStatusParams.class */
    static final class OutputProtectionQueryStatusParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private OutputProtectionQueryStatusParams(int version) {
            super(8, version);
        }

        public OutputProtectionQueryStatusParams() {
            this(0);
        }

        public static OutputProtectionQueryStatusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OutputProtectionQueryStatusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OutputProtectionQueryStatusParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OutputProtectionQueryStatusParams result = new OutputProtectionQueryStatusParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionQueryStatusResponseParams.class */
    public static final class OutputProtectionQueryStatusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;
        public int linkMask;
        public int protectionMask;

        private OutputProtectionQueryStatusResponseParams(int version) {
            super(24, version);
        }

        public OutputProtectionQueryStatusResponseParams() {
            this(0);
        }

        public static OutputProtectionQueryStatusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OutputProtectionQueryStatusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OutputProtectionQueryStatusResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OutputProtectionQueryStatusResponseParams result = new OutputProtectionQueryStatusResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.linkMask = decoder0.readInt(12);
                result.protectionMask = decoder0.readInt(16);
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
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.linkMask, 12);
            encoder0.encode(this.protectionMask, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionQueryStatusResponseParamsForwardToCallback.class */
    static class OutputProtectionQueryStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final OutputProtection.QueryStatusResponse mCallback;

        OutputProtectionQueryStatusResponseParamsForwardToCallback(OutputProtection.QueryStatusResponse callback) {
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
                OutputProtectionQueryStatusResponseParams response = OutputProtectionQueryStatusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), Integer.valueOf(response.linkMask), Integer.valueOf(response.protectionMask));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionQueryStatusResponseParamsProxyToResponder.class */
    static class OutputProtectionQueryStatusResponseParamsProxyToResponder implements OutputProtection.QueryStatusResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        OutputProtectionQueryStatusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback3
        public void call(Boolean success, Integer linkMask, Integer protectionMask) {
            OutputProtectionQueryStatusResponseParams _response = new OutputProtectionQueryStatusResponseParams();
            _response.success = success.booleanValue();
            _response.linkMask = linkMask.intValue();
            _response.protectionMask = protectionMask.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionEnableProtectionParams.class */
    static final class OutputProtectionEnableProtectionParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int desiredProtectionMask;

        private OutputProtectionEnableProtectionParams(int version) {
            super(16, version);
        }

        public OutputProtectionEnableProtectionParams() {
            this(0);
        }

        public static OutputProtectionEnableProtectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OutputProtectionEnableProtectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OutputProtectionEnableProtectionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OutputProtectionEnableProtectionParams result = new OutputProtectionEnableProtectionParams(elementsOrVersion);
                result.desiredProtectionMask = decoder0.readInt(8);
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
            encoder0.encode(this.desiredProtectionMask, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionEnableProtectionResponseParams.class */
    public static final class OutputProtectionEnableProtectionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private OutputProtectionEnableProtectionResponseParams(int version) {
            super(16, version);
        }

        public OutputProtectionEnableProtectionResponseParams() {
            this(0);
        }

        public static OutputProtectionEnableProtectionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OutputProtectionEnableProtectionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OutputProtectionEnableProtectionResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                OutputProtectionEnableProtectionResponseParams result = new OutputProtectionEnableProtectionResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.success, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionEnableProtectionResponseParamsForwardToCallback.class */
    static class OutputProtectionEnableProtectionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final OutputProtection.EnableProtectionResponse mCallback;

        OutputProtectionEnableProtectionResponseParamsForwardToCallback(OutputProtection.EnableProtectionResponse callback) {
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
                OutputProtectionEnableProtectionResponseParams response = OutputProtectionEnableProtectionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/OutputProtection_Internal$OutputProtectionEnableProtectionResponseParamsProxyToResponder.class */
    static class OutputProtectionEnableProtectionResponseParamsProxyToResponder implements OutputProtection.EnableProtectionResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        OutputProtectionEnableProtectionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            OutputProtectionEnableProtectionResponseParams _response = new OutputProtectionEnableProtectionResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
