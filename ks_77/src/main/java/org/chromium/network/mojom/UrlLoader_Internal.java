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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.UrlLoader;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal.class */
class UrlLoader_Internal {
    public static final Interface.Manager<UrlLoader, UrlLoader.Proxy> MANAGER = new Interface.Manager<UrlLoader, UrlLoader.Proxy>() { // from class: org.chromium.network.mojom.UrlLoader_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.URLLoader";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public UrlLoader.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, UrlLoader impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public UrlLoader[] buildArray(int size) {
            return new UrlLoader[size];
        }
    };
    private static final int FOLLOW_REDIRECT_ORDINAL = 0;
    private static final int PROCEED_WITH_RESPONSE_ORDINAL = 1;
    private static final int SET_PRIORITY_ORDINAL = 2;
    private static final int PAUSE_READING_BODY_FROM_NET_ORDINAL = 3;
    private static final int RESUME_READING_BODY_FROM_NET_ORDINAL = 4;

    UrlLoader_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements UrlLoader.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.UrlLoader
        public void followRedirect(String[] removedHeaders, HttpRequestHeaders modifiedHeaders, Url newUrl) {
            UrlLoaderFollowRedirectParams _message = new UrlLoaderFollowRedirectParams();
            _message.removedHeaders = removedHeaders;
            _message.modifiedHeaders = modifiedHeaders;
            _message.newUrl = newUrl;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.UrlLoader
        public void proceedWithResponse() {
            UrlLoaderProceedWithResponseParams _message = new UrlLoaderProceedWithResponseParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.UrlLoader
        public void setPriority(int priority, int intraPriorityValue) {
            UrlLoaderSetPriorityParams _message = new UrlLoaderSetPriorityParams();
            _message.priority = priority;
            _message.intraPriorityValue = intraPriorityValue;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.network.mojom.UrlLoader
        public void pauseReadingBodyFromNet() {
            UrlLoaderPauseReadingBodyFromNetParams _message = new UrlLoaderPauseReadingBodyFromNetParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.network.mojom.UrlLoader
        public void resumeReadingBodyFromNet() {
            UrlLoaderResumeReadingBodyFromNetParams _message = new UrlLoaderResumeReadingBodyFromNetParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<UrlLoader> {
        Stub(Core core, UrlLoader impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UrlLoader_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        UrlLoaderFollowRedirectParams data = UrlLoaderFollowRedirectParams.deserialize(messageWithHeader.getPayload());
                        getImpl().followRedirect(data.removedHeaders, data.modifiedHeaders, data.newUrl);
                        return true;
                    case 1:
                        UrlLoaderProceedWithResponseParams.deserialize(messageWithHeader.getPayload());
                        getImpl().proceedWithResponse();
                        return true;
                    case 2:
                        UrlLoaderSetPriorityParams data2 = UrlLoaderSetPriorityParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setPriority(data2.priority, data2.intraPriorityValue);
                        return true;
                    case 3:
                        UrlLoaderPauseReadingBodyFromNetParams.deserialize(messageWithHeader.getPayload());
                        getImpl().pauseReadingBodyFromNet();
                        return true;
                    case 4:
                        UrlLoaderResumeReadingBodyFromNetParams.deserialize(messageWithHeader.getPayload());
                        getImpl().resumeReadingBodyFromNet();
                        return true;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), UrlLoader_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$UrlLoaderFollowRedirectParams.class */
    static final class UrlLoaderFollowRedirectParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String[] removedHeaders;
        public HttpRequestHeaders modifiedHeaders;
        public Url newUrl;

        private UrlLoaderFollowRedirectParams(int version) {
            super(32, version);
        }

        public UrlLoaderFollowRedirectParams() {
            this(0);
        }

        public static UrlLoaderFollowRedirectParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderFollowRedirectParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderFollowRedirectParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderFollowRedirectParams result = new UrlLoaderFollowRedirectParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.removedHeaders = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.removedHeaders[i1] = decoder1.readString(8 + (8 * i1), false);
                }
                result.modifiedHeaders = HttpRequestHeaders.decode(decoder0.readPointer(16, false));
                result.newUrl = Url.decode(decoder0.readPointer(24, true));
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
            if (this.removedHeaders == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.removedHeaders.length, 8, -1);
                for (int i0 = 0; i0 < this.removedHeaders.length; i0++) {
                    encoder1.encode(this.removedHeaders[i0], 8 + (8 * i0), false);
                }
            }
            encoder0.encode((Struct) this.modifiedHeaders, 16, false);
            encoder0.encode((Struct) this.newUrl, 24, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$UrlLoaderProceedWithResponseParams.class */
    static final class UrlLoaderProceedWithResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderProceedWithResponseParams(int version) {
            super(8, version);
        }

        public UrlLoaderProceedWithResponseParams() {
            this(0);
        }

        public static UrlLoaderProceedWithResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderProceedWithResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderProceedWithResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderProceedWithResponseParams result = new UrlLoaderProceedWithResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$UrlLoaderSetPriorityParams.class */
    static final class UrlLoaderSetPriorityParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int priority;
        public int intraPriorityValue;

        private UrlLoaderSetPriorityParams(int version) {
            super(16, version);
        }

        public UrlLoaderSetPriorityParams() {
            this(0);
        }

        public static UrlLoaderSetPriorityParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderSetPriorityParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderSetPriorityParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderSetPriorityParams result = new UrlLoaderSetPriorityParams(elementsOrVersion);
                result.priority = decoder0.readInt(8);
                RequestPriority.validate(result.priority);
                result.intraPriorityValue = decoder0.readInt(12);
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
            encoder0.encode(this.priority, 8);
            encoder0.encode(this.intraPriorityValue, 12);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$UrlLoaderPauseReadingBodyFromNetParams.class */
    static final class UrlLoaderPauseReadingBodyFromNetParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderPauseReadingBodyFromNetParams(int version) {
            super(8, version);
        }

        public UrlLoaderPauseReadingBodyFromNetParams() {
            this(0);
        }

        public static UrlLoaderPauseReadingBodyFromNetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderPauseReadingBodyFromNetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderPauseReadingBodyFromNetParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderPauseReadingBodyFromNetParams result = new UrlLoaderPauseReadingBodyFromNetParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UrlLoader_Internal$UrlLoaderResumeReadingBodyFromNetParams.class */
    static final class UrlLoaderResumeReadingBodyFromNetParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderResumeReadingBodyFromNetParams(int version) {
            super(8, version);
        }

        public UrlLoaderResumeReadingBodyFromNetParams() {
            this(0);
        }

        public static UrlLoaderResumeReadingBodyFromNetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UrlLoaderResumeReadingBodyFromNetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UrlLoaderResumeReadingBodyFromNetParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                UrlLoaderResumeReadingBodyFromNetParams result = new UrlLoaderResumeReadingBodyFromNetParams(elementsOrVersion);
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
}
