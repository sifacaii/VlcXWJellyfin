package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
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
import org.chromium.viz.mojom.InputTargetClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal.class */
class InputTargetClient_Internal {
    public static final Interface.Manager<InputTargetClient, InputTargetClient.Proxy> MANAGER = new Interface.Manager<InputTargetClient, InputTargetClient.Proxy>() { // from class: org.chromium.viz.mojom.InputTargetClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.InputTargetClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public InputTargetClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, InputTargetClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public InputTargetClient[] buildArray(int size) {
            return new InputTargetClient[size];
        }
    };
    private static final int FRAME_SINK_ID_AT_ORDINAL = 0;

    InputTargetClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements InputTargetClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.InputTargetClient
        public void frameSinkIdAt(PointF point, long traceId, InputTargetClient.FrameSinkIdAtResponse callback) {
            InputTargetClientFrameSinkIdAtParams _message = new InputTargetClientFrameSinkIdAtParams();
            _message.point = point;
            _message.traceId = traceId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new InputTargetClientFrameSinkIdAtResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<InputTargetClient> {
        Stub(Core core, InputTargetClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InputTargetClient_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), InputTargetClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        InputTargetClientFrameSinkIdAtParams data = InputTargetClientFrameSinkIdAtParams.deserialize(messageWithHeader.getPayload());
                        getImpl().frameSinkIdAt(data.point, data.traceId, new InputTargetClientFrameSinkIdAtResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal$InputTargetClientFrameSinkIdAtParams.class */
    static final class InputTargetClientFrameSinkIdAtParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PointF point;
        public long traceId;

        private InputTargetClientFrameSinkIdAtParams(int version) {
            super(24, version);
        }

        public InputTargetClientFrameSinkIdAtParams() {
            this(0);
        }

        public static InputTargetClientFrameSinkIdAtParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputTargetClientFrameSinkIdAtParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputTargetClientFrameSinkIdAtParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InputTargetClientFrameSinkIdAtParams result = new InputTargetClientFrameSinkIdAtParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.point = PointF.decode(decoder1);
                result.traceId = decoder0.readLong(16);
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
            encoder0.encode((Struct) this.point, 8, false);
            encoder0.encode(this.traceId, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal$InputTargetClientFrameSinkIdAtResponseParams.class */
    public static final class InputTargetClientFrameSinkIdAtResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public FrameSinkId id;
        public PointF localPoint;

        private InputTargetClientFrameSinkIdAtResponseParams(int version) {
            super(24, version);
        }

        public InputTargetClientFrameSinkIdAtResponseParams() {
            this(0);
        }

        public static InputTargetClientFrameSinkIdAtResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InputTargetClientFrameSinkIdAtResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InputTargetClientFrameSinkIdAtResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InputTargetClientFrameSinkIdAtResponseParams result = new InputTargetClientFrameSinkIdAtResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.id = FrameSinkId.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.localPoint = PointF.decode(decoder12);
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
            encoder0.encode((Struct) this.id, 8, false);
            encoder0.encode((Struct) this.localPoint, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal$InputTargetClientFrameSinkIdAtResponseParamsForwardToCallback.class */
    static class InputTargetClientFrameSinkIdAtResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final InputTargetClient.FrameSinkIdAtResponse mCallback;

        InputTargetClientFrameSinkIdAtResponseParamsForwardToCallback(InputTargetClient.FrameSinkIdAtResponse callback) {
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
                InputTargetClientFrameSinkIdAtResponseParams response = InputTargetClientFrameSinkIdAtResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.id, response.localPoint);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient_Internal$InputTargetClientFrameSinkIdAtResponseParamsProxyToResponder.class */
    static class InputTargetClientFrameSinkIdAtResponseParamsProxyToResponder implements InputTargetClient.FrameSinkIdAtResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        InputTargetClientFrameSinkIdAtResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(FrameSinkId id, PointF localPoint) {
            InputTargetClientFrameSinkIdAtResponseParams _response = new InputTargetClientFrameSinkIdAtResponseParams();
            _response.id = id;
            _response.localPoint = localPoint;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
