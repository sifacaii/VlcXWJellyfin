package org.chromium.shape_detection.mojom;

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
import org.chromium.shape_detection.mojom.BarcodeDetectionProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal.class */
class BarcodeDetectionProvider_Internal {
    public static final Interface.Manager<BarcodeDetectionProvider, BarcodeDetectionProvider.Proxy> MANAGER = new Interface.Manager<BarcodeDetectionProvider, BarcodeDetectionProvider.Proxy>() { // from class: org.chromium.shape_detection.mojom.BarcodeDetectionProvider_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "shape_detection.mojom.BarcodeDetectionProvider";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public BarcodeDetectionProvider.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, BarcodeDetectionProvider impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public BarcodeDetectionProvider[] buildArray(int size) {
            return new BarcodeDetectionProvider[size];
        }
    };
    private static final int CREATE_BARCODE_DETECTION_ORDINAL = 0;
    private static final int ENUMERATE_SUPPORTED_FORMATS_ORDINAL = 1;

    BarcodeDetectionProvider_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements BarcodeDetectionProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.shape_detection.mojom.BarcodeDetectionProvider
        public void createBarcodeDetection(InterfaceRequest<BarcodeDetection> request, BarcodeDetectorOptions options) {
            BarcodeDetectionProviderCreateBarcodeDetectionParams _message = new BarcodeDetectionProviderCreateBarcodeDetectionParams();
            _message.request = request;
            _message.options = options;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.shape_detection.mojom.BarcodeDetectionProvider
        public void enumerateSupportedFormats(BarcodeDetectionProvider.EnumerateSupportedFormatsResponse callback) {
            BarcodeDetectionProviderEnumerateSupportedFormatsParams _message = new BarcodeDetectionProviderEnumerateSupportedFormatsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<BarcodeDetectionProvider> {
        Stub(Core core, BarcodeDetectionProvider impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BarcodeDetectionProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        BarcodeDetectionProviderCreateBarcodeDetectionParams data = BarcodeDetectionProviderCreateBarcodeDetectionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createBarcodeDetection(data.request, data.options);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), BarcodeDetectionProvider_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        BarcodeDetectionProviderEnumerateSupportedFormatsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().enumerateSupportedFormats(new BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$BarcodeDetectionProviderCreateBarcodeDetectionParams.class */
    static final class BarcodeDetectionProviderCreateBarcodeDetectionParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<BarcodeDetection> request;
        public BarcodeDetectorOptions options;

        private BarcodeDetectionProviderCreateBarcodeDetectionParams(int version) {
            super(24, version);
        }

        public BarcodeDetectionProviderCreateBarcodeDetectionParams() {
            this(0);
        }

        public static BarcodeDetectionProviderCreateBarcodeDetectionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BarcodeDetectionProviderCreateBarcodeDetectionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BarcodeDetectionProviderCreateBarcodeDetectionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                BarcodeDetectionProviderCreateBarcodeDetectionParams result = new BarcodeDetectionProviderCreateBarcodeDetectionParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.options = BarcodeDetectorOptions.decode(decoder1);
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
            encoder0.encode((Struct) this.options, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsParams.class */
    static final class BarcodeDetectionProviderEnumerateSupportedFormatsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BarcodeDetectionProviderEnumerateSupportedFormatsParams(int version) {
            super(8, version);
        }

        public BarcodeDetectionProviderEnumerateSupportedFormatsParams() {
            this(0);
        }

        public static BarcodeDetectionProviderEnumerateSupportedFormatsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BarcodeDetectionProviderEnumerateSupportedFormatsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BarcodeDetectionProviderEnumerateSupportedFormatsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                BarcodeDetectionProviderEnumerateSupportedFormatsParams result = new BarcodeDetectionProviderEnumerateSupportedFormatsParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams.class */
    public static final class BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int[] supportedFormats;

        private BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams(int version) {
            super(16, version);
        }

        public BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams() {
            this(0);
        }

        public static BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams result = new BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams(elementsOrVersion);
                result.supportedFormats = decoder0.readInts(8, 0, -1);
                for (int i0 = 0; i0 < result.supportedFormats.length; i0++) {
                    BarcodeFormat.validate(result.supportedFormats[i0]);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.supportedFormats, 8, 0, -1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback.class */
    static class BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BarcodeDetectionProvider.EnumerateSupportedFormatsResponse mCallback;

        BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsForwardToCallback(BarcodeDetectionProvider.EnumerateSupportedFormatsResponse callback) {
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
                BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams response = BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.supportedFormats);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider_Internal$BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsProxyToResponder.class */
    static class BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsProxyToResponder implements BarcodeDetectionProvider.EnumerateSupportedFormatsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        BarcodeDetectionProviderEnumerateSupportedFormatsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(int[] supportedFormats) {
            BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams _response = new BarcodeDetectionProviderEnumerateSupportedFormatsResponseParams();
            _response.supportedFormats = supportedFormats;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
