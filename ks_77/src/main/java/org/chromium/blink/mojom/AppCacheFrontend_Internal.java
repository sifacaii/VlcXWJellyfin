//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.mojom.Url;

class AppCacheFrontend_Internal {
    public static final Interface.Manager<AppCacheFrontend, AppCacheFrontend.Proxy> MANAGER = new Interface.Manager<AppCacheFrontend, AppCacheFrontend.Proxy>() {
        public String getName() {
            return "blink.mojom.AppCacheFrontend";
        }

        public int getVersion() {
            return 0;
        }

        public Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        public Stub buildStub(Core core, AppCacheFrontend impl) {
            return new Stub(core, impl);
        }

        public AppCacheFrontend[] buildArray(int size) {
            return new AppCacheFrontend[size];
        }
    };
    private static final int CACHE_SELECTED_ORDINAL = 0;
    private static final int EVENT_RAISED_ORDINAL = 1;
    private static final int PROGRESS_EVENT_RAISED_ORDINAL = 2;
    private static final int ERROR_EVENT_RAISED_ORDINAL = 3;
    private static final int LOG_MESSAGE_ORDINAL = 4;
    private static final int SET_SUBRESOURCE_FACTORY_ORDINAL = 5;

    AppCacheFrontend_Internal() {
    }

    static final class AppCacheFrontendSetSubresourceFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public UrlLoaderFactory urlLoaderFactory;

        private AppCacheFrontendSetSubresourceFactoryParams(int version) {
            super(16, version);
        }

        public AppCacheFrontendSetSubresourceFactoryParams() {
            this(0);
        }

        public static AppCacheFrontendSetSubresourceFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheFrontendSetSubresourceFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheFrontendSetSubresourceFactoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AppCacheFrontendSetSubresourceFactoryParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AppCacheFrontendSetSubresourceFactoryParams(elementsOrVersion);
                    result.urlLoaderFactory = (UrlLoaderFactory)decoder0.readServiceInterface(8, false, UrlLoaderFactory.MANAGER);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.urlLoaderFactory, 8, false, UrlLoaderFactory.MANAGER);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class AppCacheFrontendLogMessageParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public int logLevel;
        public String message;

        private AppCacheFrontendLogMessageParams(int version) {
            super(24, version);
        }

        public AppCacheFrontendLogMessageParams() {
            this(0);
        }

        public static AppCacheFrontendLogMessageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheFrontendLogMessageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheFrontendLogMessageParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AppCacheFrontendLogMessageParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AppCacheFrontendLogMessageParams(elementsOrVersion);
                    result.logLevel = decoder0.readInt(8);
                    ConsoleMessageLevel.validate(result.logLevel);
                    result.message = decoder0.readString(16, false);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.logLevel, 8);
            encoder0.encode(this.message, 16, false);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class AppCacheFrontendErrorEventRaisedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public AppCacheErrorDetails errorDetails;

        private AppCacheFrontendErrorEventRaisedParams(int version) {
            super(16, version);
        }

        public AppCacheFrontendErrorEventRaisedParams() {
            this(0);
        }

        public static AppCacheFrontendErrorEventRaisedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheFrontendErrorEventRaisedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheFrontendErrorEventRaisedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AppCacheFrontendErrorEventRaisedParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AppCacheFrontendErrorEventRaisedParams(elementsOrVersion);
                    Decoder decoder1 = decoder0.readPointer(8, false);
                    result.errorDetails = AppCacheErrorDetails.decode(decoder1);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.errorDetails, 8, false);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class AppCacheFrontendProgressEventRaisedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public Url url;
        public int total;
        public int complete;

        private AppCacheFrontendProgressEventRaisedParams(int version) {
            super(24, version);
        }

        public AppCacheFrontendProgressEventRaisedParams() {
            this(0);
        }

        public static AppCacheFrontendProgressEventRaisedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheFrontendProgressEventRaisedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheFrontendProgressEventRaisedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AppCacheFrontendProgressEventRaisedParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AppCacheFrontendProgressEventRaisedParams(elementsOrVersion);
                    Decoder decoder1 = decoder0.readPointer(8, false);
                    result.url = Url.decode(decoder1);
                    result.total = decoder0.readInt(16);
                    result.complete = decoder0.readInt(20);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.url, 8, false);
            encoder0.encode(this.total, 16);
            encoder0.encode(this.complete, 20);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class AppCacheFrontendEventRaisedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public int eventId;

        private AppCacheFrontendEventRaisedParams(int version) {
            super(16, version);
        }

        public AppCacheFrontendEventRaisedParams() {
            this(0);
        }

        public static AppCacheFrontendEventRaisedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheFrontendEventRaisedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheFrontendEventRaisedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AppCacheFrontendEventRaisedParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AppCacheFrontendEventRaisedParams(elementsOrVersion);
                    result.eventId = decoder0.readInt(8);
                    AppCacheEventId.validate(result.eventId);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.eventId, 8);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class AppCacheFrontendCacheSelectedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = new DataHeader[]{new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO;
        public AppCacheInfo info;

        private AppCacheFrontendCacheSelectedParams(int version) {
            super(16, version);
        }

        public AppCacheFrontendCacheSelectedParams() {
            this(0);
        }

        public static AppCacheFrontendCacheSelectedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppCacheFrontendCacheSelectedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppCacheFrontendCacheSelectedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            } else {
                decoder0.increaseStackDepth();

                AppCacheFrontendCacheSelectedParams result;
                try {
                    DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                    int elementsOrVersion = mainDataHeader.elementsOrVersion;
                    result = new AppCacheFrontendCacheSelectedParams(elementsOrVersion);
                    Decoder decoder1 = decoder0.readPointer(8, false);
                    result.info = AppCacheInfo.decode(decoder1);
                } finally {
                    decoder0.decreaseStackDepth();
                }

                return result;
            }
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
        }

        static {
            DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        }
    }

    static final class Stub extends Interface.Stub<AppCacheFrontend> {
        Stub(Core core, AppCacheFrontend impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                } else {
                    switch (header.getType()) {
                        case -2:
                            return InterfaceControlMessagesHelper.handleRunOrClosePipe(AppCacheFrontend_Internal.MANAGER, messageWithHeader);
                        case -1:
                        default:
                            return false;
                        case 0:
                            AppCacheFrontendCacheSelectedParams data = AppCacheFrontend_Internal.AppCacheFrontendCacheSelectedParams.deserialize(messageWithHeader.getPayload());
                            ((AppCacheFrontend)this.getImpl()).cacheSelected(data.info);
                            return true;
                        case 1:
                            AppCacheFrontendEventRaisedParams dataa = AppCacheFrontend_Internal.AppCacheFrontendEventRaisedParams.deserialize(messageWithHeader.getPayload());
                            ((AppCacheFrontend)this.getImpl()).eventRaised(dataa.eventId);
                            return true;
                        case 2:
                            AppCacheFrontendProgressEventRaisedParams datab = AppCacheFrontend_Internal.AppCacheFrontendProgressEventRaisedParams.deserialize(messageWithHeader.getPayload());
                            ((AppCacheFrontend)this.getImpl()).progressEventRaised(datab.url, datab.total, datab.complete);
                            return true;
                        case 3:
                            AppCacheFrontendErrorEventRaisedParams datac = AppCacheFrontend_Internal.AppCacheFrontendErrorEventRaisedParams.deserialize(messageWithHeader.getPayload());
                            ((AppCacheFrontend)this.getImpl()).errorEventRaised(datac.errorDetails);
                            return true;
                        case 4:
                            AppCacheFrontendLogMessageParams datad = AppCacheFrontend_Internal.AppCacheFrontendLogMessageParams.deserialize(messageWithHeader.getPayload());
                            ((AppCacheFrontend)this.getImpl()).logMessage(datad.logLevel, datad.message);
                            return true;
                        case 5:
                            AppCacheFrontendSetSubresourceFactoryParams datae = AppCacheFrontend_Internal.AppCacheFrontendSetSubresourceFactoryParams.deserialize(messageWithHeader.getPayload());
                            ((AppCacheFrontend)this.getImpl()).setSubresourceFactory(datae.urlLoaderFactory);
                            return true;
                    }
                }
            } catch (DeserializationException var5) {
                System.err.println(var5.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                } else {
                    switch (header.getType()) {
                        case -1:
                            return InterfaceControlMessagesHelper.handleRun(this.getCore(), AppCacheFrontend_Internal.MANAGER, messageWithHeader, receiver);
                        default:
                            return false;
                    }
                }
            } catch (DeserializationException var5) {
                System.err.println(var5.toString());
                return false;
            }
        }
    }

    static final class Proxy extends Interface.AbstractProxy implements AppCacheFrontend.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void cacheSelected(AppCacheInfo info) {
            AppCacheFrontendCacheSelectedParams _message = new AppCacheFrontendCacheSelectedParams();
            _message.info = info;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void eventRaised(int eventId) {
            AppCacheFrontendEventRaisedParams _message = new AppCacheFrontendEventRaisedParams();
            _message.eventId = eventId;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void progressEventRaised(Url url, int total, int complete) {
            AppCacheFrontendProgressEventRaisedParams _message = new AppCacheFrontendProgressEventRaisedParams();
            _message.url = url;
            _message.total = total;
            _message.complete = complete;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void errorEventRaised(AppCacheErrorDetails errorDetails) {
            AppCacheFrontendErrorEventRaisedParams _message = new AppCacheFrontendErrorEventRaisedParams();
            _message.errorDetails = errorDetails;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void logMessage(int logLevel, String message) {
            AppCacheFrontendLogMessageParams _message = new AppCacheFrontendLogMessageParams();
            _message.logLevel = logLevel;
            _message.message = message;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void setSubresourceFactory(UrlLoaderFactory urlLoaderFactory) {
            AppCacheFrontendSetSubresourceFactoryParams _message = new AppCacheFrontendSetSubresourceFactoryParams();
            _message.urlLoaderFactory = urlLoaderFactory;
            this.getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(this.getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }
}
