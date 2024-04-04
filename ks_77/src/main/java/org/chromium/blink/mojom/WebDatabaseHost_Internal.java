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
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Origin;

class WebDatabaseHost_Internal {
    public static final Interface.Manager<WebDatabaseHost, WebDatabaseHost.Proxy> MANAGER = new Interface.Manager<WebDatabaseHost, WebDatabaseHost.Proxy>() {
        public String getName() {
            return "blink.mojom.WebDatabaseHost";
        }

        public int getVersion() {
            return 0;
        }

        public WebDatabaseHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new WebDatabaseHost_Internal.Proxy(core, messageReceiver);
        }

        public WebDatabaseHost_Internal.Stub buildStub(Core core, WebDatabaseHost impl) {
            return new WebDatabaseHost_Internal.Stub(core, impl);
        }

        public WebDatabaseHost[] buildArray(int size) {
            return new WebDatabaseHost[size];
        }
    };

    private static final int OPEN_FILE_ORDINAL = 0;

    private static final int DELETE_FILE_ORDINAL = 1;

    private static final int GET_FILE_ATTRIBUTES_ORDINAL = 2;

    private static final int GET_FILE_SIZE_ORDINAL = 3;

    private static final int SET_FILE_SIZE_ORDINAL = 4;

    private static final int GET_SPACE_AVAILABLE_ORDINAL = 5;

    private static final int OPENED_ORDINAL = 6;

    private static final int MODIFIED_ORDINAL = 7;

    private static final int CLOSED_ORDINAL = 8;

    private static final int HANDLE_SQLITE_ERROR_ORDINAL = 9;

    static final class Proxy extends Interface.AbstractProxy implements WebDatabaseHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openFile(String16 vfsFileName, int desiredFlags, WebDatabaseHost.OpenFileResponse callback) {
            WebDatabaseHost_Internal.WebDatabaseHostOpenFileParams _message = new WebDatabaseHost_Internal.WebDatabaseHostOpenFileParams();
            _message.vfsFileName = vfsFileName;
            _message.desiredFlags = desiredFlags;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new WebDatabaseHost_Internal.WebDatabaseHostOpenFileResponseParamsForwardToCallback(callback));
        }

        public void deleteFile(String16 vfsFileName, boolean syncDir, WebDatabaseHost.DeleteFileResponse callback) {
            WebDatabaseHost_Internal.WebDatabaseHostDeleteFileParams _message = new WebDatabaseHost_Internal.WebDatabaseHostDeleteFileParams();
            _message.vfsFileName = vfsFileName;
            _message.syncDir = syncDir;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new WebDatabaseHost_Internal.WebDatabaseHostDeleteFileResponseParamsForwardToCallback(callback));
        }

        public void getFileAttributes(String16 vfsFileName, WebDatabaseHost.GetFileAttributesResponse callback) {
            WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesParams _message = new WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesParams();
            _message.vfsFileName = vfsFileName;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesResponseParamsForwardToCallback(callback));
        }

        public void getFileSize(String16 vfsFileName, WebDatabaseHost.GetFileSizeResponse callback) {
            WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeParams _message = new WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeParams();
            _message.vfsFileName = vfsFileName;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeResponseParamsForwardToCallback(callback));
        }

        public void setFileSize(String16 vfsFileName, long expectedSize, WebDatabaseHost.SetFileSizeResponse callback) {
            WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeParams _message = new WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeParams();
            _message.vfsFileName = vfsFileName;
            _message.expectedSize = expectedSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeResponseParamsForwardToCallback(callback));
        }

        public void getSpaceAvailable(Origin origin, WebDatabaseHost.GetSpaceAvailableResponse callback) {
            WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableParams _message = new WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableParams();
            _message.origin = origin;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableResponseParamsForwardToCallback(callback));
        }

        public void opened(Origin origin, String16 databaseName, String16 databaseDescription, long estimatedSize) {
            WebDatabaseHost_Internal.WebDatabaseHostOpenedParams _message = new WebDatabaseHost_Internal.WebDatabaseHostOpenedParams();
            _message.origin = origin;
            _message.databaseName = databaseName;
            _message.databaseDescription = databaseDescription;
            _message.estimatedSize = estimatedSize;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void modified(Origin origin, String16 databaseName) {
            WebDatabaseHost_Internal.WebDatabaseHostModifiedParams _message = new WebDatabaseHost_Internal.WebDatabaseHostModifiedParams();
            _message.origin = origin;
            _message.databaseName = databaseName;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }

        public void closed(Origin origin, String16 databaseName) {
            WebDatabaseHost_Internal.WebDatabaseHostClosedParams _message = new WebDatabaseHost_Internal.WebDatabaseHostClosedParams();
            _message.origin = origin;
            _message.databaseName = databaseName;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }

        public void handleSqliteError(Origin origin, String16 databaseName, int error) {
            WebDatabaseHost_Internal.WebDatabaseHostHandleSqliteErrorParams _message = new WebDatabaseHost_Internal.WebDatabaseHostHandleSqliteErrorParams();
            _message.origin = origin;
            _message.databaseName = databaseName;
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9)));
        }
    }

    static final class Stub extends Interface.Stub<WebDatabaseHost> {
        Stub(Core core, WebDatabaseHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                WebDatabaseHost_Internal.WebDatabaseHostOpenedParams webDatabaseHostOpenedParams;
                WebDatabaseHost_Internal.WebDatabaseHostModifiedParams webDatabaseHostModifiedParams;
                WebDatabaseHost_Internal.WebDatabaseHostClosedParams webDatabaseHostClosedParams;
                WebDatabaseHost_Internal.WebDatabaseHostHandleSqliteErrorParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(WebDatabaseHost_Internal.MANAGER, messageWithHeader);
                    case 6:
                        webDatabaseHostOpenedParams = WebDatabaseHost_Internal.WebDatabaseHostOpenedParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).opened(webDatabaseHostOpenedParams.origin, webDatabaseHostOpenedParams.databaseName, webDatabaseHostOpenedParams.databaseDescription, webDatabaseHostOpenedParams.estimatedSize);
                        return true;
                    case 7:
                        webDatabaseHostModifiedParams = WebDatabaseHost_Internal.WebDatabaseHostModifiedParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).modified(webDatabaseHostModifiedParams.origin, webDatabaseHostModifiedParams.databaseName);
                        return true;
                    case 8:
                        webDatabaseHostClosedParams = WebDatabaseHost_Internal.WebDatabaseHostClosedParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).closed(webDatabaseHostClosedParams.origin, webDatabaseHostClosedParams.databaseName);
                        return true;
                    case 9:
                        data = WebDatabaseHost_Internal.WebDatabaseHostHandleSqliteErrorParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).handleSqliteError(data.origin, data.databaseName, data.error);
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
                WebDatabaseHost_Internal.WebDatabaseHostOpenFileParams webDatabaseHostOpenFileParams;
                WebDatabaseHost_Internal.WebDatabaseHostDeleteFileParams webDatabaseHostDeleteFileParams;
                WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesParams webDatabaseHostGetFileAttributesParams;
                WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeParams webDatabaseHostGetFileSizeParams;
                WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeParams webDatabaseHostSetFileSizeParams;
                WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), WebDatabaseHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        webDatabaseHostOpenFileParams = WebDatabaseHost_Internal.WebDatabaseHostOpenFileParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).openFile(webDatabaseHostOpenFileParams.vfsFileName, webDatabaseHostOpenFileParams.desiredFlags, new WebDatabaseHost_Internal.WebDatabaseHostOpenFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        webDatabaseHostDeleteFileParams = WebDatabaseHost_Internal.WebDatabaseHostDeleteFileParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).deleteFile(webDatabaseHostDeleteFileParams.vfsFileName, webDatabaseHostDeleteFileParams.syncDir, new WebDatabaseHost_Internal.WebDatabaseHostDeleteFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        webDatabaseHostGetFileAttributesParams = WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).getFileAttributes(webDatabaseHostGetFileAttributesParams.vfsFileName, new WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        webDatabaseHostGetFileSizeParams = WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).getFileSize(webDatabaseHostGetFileSizeParams.vfsFileName, new WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        webDatabaseHostSetFileSizeParams = WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).setFileSize(webDatabaseHostSetFileSizeParams.vfsFileName, webDatabaseHostSetFileSizeParams.expectedSize, new WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        data = WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableParams.deserialize(messageWithHeader.getPayload());
                        ((WebDatabaseHost)getImpl()).getSpaceAvailable(data.origin, new WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class WebDatabaseHostOpenFileParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 vfsFileName;

        public int desiredFlags;

        private WebDatabaseHostOpenFileParams(int version) {
            super(24, version);
        }

        public WebDatabaseHostOpenFileParams() {
            this(0);
        }

        public static WebDatabaseHostOpenFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostOpenFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostOpenFileParams decode(Decoder decoder0) {
            WebDatabaseHostOpenFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostOpenFileParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.vfsFileName = String16.decode(decoder1);
                result.desiredFlags = decoder0.readInt(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.vfsFileName, 8, false);
            encoder0.encode(this.desiredFlags, 16);
        }
    }

    static final class WebDatabaseHostOpenFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public File file;

        private WebDatabaseHostOpenFileResponseParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostOpenFileResponseParams() {
            this(0);
        }

        public static WebDatabaseHostOpenFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostOpenFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostOpenFileResponseParams decode(Decoder decoder0) {
            WebDatabaseHostOpenFileResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostOpenFileResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.file = File.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.file, 8, true);
        }
    }

    static class WebDatabaseHostOpenFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebDatabaseHost.OpenFileResponse mCallback;

        WebDatabaseHostOpenFileResponseParamsForwardToCallback(WebDatabaseHost.OpenFileResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                WebDatabaseHost_Internal.WebDatabaseHostOpenFileResponseParams response = WebDatabaseHost_Internal.WebDatabaseHostOpenFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.file);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebDatabaseHostOpenFileResponseParamsProxyToResponder implements WebDatabaseHost.OpenFileResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebDatabaseHostOpenFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(File file) {
            WebDatabaseHost_Internal.WebDatabaseHostOpenFileResponseParams _response = new WebDatabaseHost_Internal.WebDatabaseHostOpenFileResponseParams();
            _response.file = file;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebDatabaseHostDeleteFileParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 vfsFileName;

        public boolean syncDir;

        private WebDatabaseHostDeleteFileParams(int version) {
            super(24, version);
        }

        public WebDatabaseHostDeleteFileParams() {
            this(0);
        }

        public static WebDatabaseHostDeleteFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostDeleteFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostDeleteFileParams decode(Decoder decoder0) {
            WebDatabaseHostDeleteFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostDeleteFileParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.vfsFileName = String16.decode(decoder1);
                result.syncDir = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.vfsFileName, 8, false);
            encoder0.encode(this.syncDir, 16, 0);
        }
    }

    static final class WebDatabaseHostDeleteFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int sqliteErrorCode;

        private WebDatabaseHostDeleteFileResponseParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostDeleteFileResponseParams() {
            this(0);
        }

        public static WebDatabaseHostDeleteFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostDeleteFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostDeleteFileResponseParams decode(Decoder decoder0) {
            WebDatabaseHostDeleteFileResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostDeleteFileResponseParams(elementsOrVersion);
                result.sqliteErrorCode = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sqliteErrorCode, 8);
        }
    }

    static class WebDatabaseHostDeleteFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebDatabaseHost.DeleteFileResponse mCallback;

        WebDatabaseHostDeleteFileResponseParamsForwardToCallback(WebDatabaseHost.DeleteFileResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                WebDatabaseHost_Internal.WebDatabaseHostDeleteFileResponseParams response = WebDatabaseHost_Internal.WebDatabaseHostDeleteFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.sqliteErrorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebDatabaseHostDeleteFileResponseParamsProxyToResponder implements WebDatabaseHost.DeleteFileResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebDatabaseHostDeleteFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer sqliteErrorCode) {
            WebDatabaseHost_Internal.WebDatabaseHostDeleteFileResponseParams _response = new WebDatabaseHost_Internal.WebDatabaseHostDeleteFileResponseParams();
            _response.sqliteErrorCode = sqliteErrorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebDatabaseHostGetFileAttributesParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 vfsFileName;

        private WebDatabaseHostGetFileAttributesParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostGetFileAttributesParams() {
            this(0);
        }

        public static WebDatabaseHostGetFileAttributesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostGetFileAttributesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostGetFileAttributesParams decode(Decoder decoder0) {
            WebDatabaseHostGetFileAttributesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostGetFileAttributesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.vfsFileName = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.vfsFileName, 8, false);
        }
    }

    static final class WebDatabaseHostGetFileAttributesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int attributes;

        private WebDatabaseHostGetFileAttributesResponseParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostGetFileAttributesResponseParams() {
            this(0);
        }

        public static WebDatabaseHostGetFileAttributesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostGetFileAttributesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostGetFileAttributesResponseParams decode(Decoder decoder0) {
            WebDatabaseHostGetFileAttributesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostGetFileAttributesResponseParams(elementsOrVersion);
                result.attributes = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.attributes, 8);
        }
    }

    static class WebDatabaseHostGetFileAttributesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebDatabaseHost.GetFileAttributesResponse mCallback;

        WebDatabaseHostGetFileAttributesResponseParamsForwardToCallback(WebDatabaseHost.GetFileAttributesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesResponseParams response = WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.attributes));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebDatabaseHostGetFileAttributesResponseParamsProxyToResponder implements WebDatabaseHost.GetFileAttributesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebDatabaseHostGetFileAttributesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer attributes) {
            WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesResponseParams _response = new WebDatabaseHost_Internal.WebDatabaseHostGetFileAttributesResponseParams();
            _response.attributes = attributes.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebDatabaseHostGetFileSizeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 vfsFileName;

        private WebDatabaseHostGetFileSizeParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostGetFileSizeParams() {
            this(0);
        }

        public static WebDatabaseHostGetFileSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostGetFileSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostGetFileSizeParams decode(Decoder decoder0) {
            WebDatabaseHostGetFileSizeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostGetFileSizeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.vfsFileName = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.vfsFileName, 8, false);
        }
    }

    static final class WebDatabaseHostGetFileSizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long size;

        private WebDatabaseHostGetFileSizeResponseParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostGetFileSizeResponseParams() {
            this(0);
        }

        public static WebDatabaseHostGetFileSizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostGetFileSizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostGetFileSizeResponseParams decode(Decoder decoder0) {
            WebDatabaseHostGetFileSizeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostGetFileSizeResponseParams(elementsOrVersion);
                result.size = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.size, 8);
        }
    }

    static class WebDatabaseHostGetFileSizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebDatabaseHost.GetFileSizeResponse mCallback;

        WebDatabaseHostGetFileSizeResponseParamsForwardToCallback(WebDatabaseHost.GetFileSizeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeResponseParams response = WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Long.valueOf(response.size));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebDatabaseHostGetFileSizeResponseParamsProxyToResponder implements WebDatabaseHost.GetFileSizeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebDatabaseHostGetFileSizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Long size) {
            WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeResponseParams _response = new WebDatabaseHost_Internal.WebDatabaseHostGetFileSizeResponseParams();
            _response.size = size.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebDatabaseHostSetFileSizeParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16 vfsFileName;

        public long expectedSize;

        private WebDatabaseHostSetFileSizeParams(int version) {
            super(24, version);
        }

        public WebDatabaseHostSetFileSizeParams() {
            this(0);
        }

        public static WebDatabaseHostSetFileSizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostSetFileSizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostSetFileSizeParams decode(Decoder decoder0) {
            WebDatabaseHostSetFileSizeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostSetFileSizeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.vfsFileName = String16.decode(decoder1);
                result.expectedSize = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.vfsFileName, 8, false);
            encoder0.encode(this.expectedSize, 16);
        }
    }

    static final class WebDatabaseHostSetFileSizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private WebDatabaseHostSetFileSizeResponseParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostSetFileSizeResponseParams() {
            this(0);
        }

        public static WebDatabaseHostSetFileSizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostSetFileSizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostSetFileSizeResponseParams decode(Decoder decoder0) {
            WebDatabaseHostSetFileSizeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostSetFileSizeResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class WebDatabaseHostSetFileSizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebDatabaseHost.SetFileSizeResponse mCallback;

        WebDatabaseHostSetFileSizeResponseParamsForwardToCallback(WebDatabaseHost.SetFileSizeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeResponseParams response = WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebDatabaseHostSetFileSizeResponseParamsProxyToResponder implements WebDatabaseHost.SetFileSizeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebDatabaseHostSetFileSizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeResponseParams _response = new WebDatabaseHost_Internal.WebDatabaseHostSetFileSizeResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebDatabaseHostGetSpaceAvailableParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        private WebDatabaseHostGetSpaceAvailableParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostGetSpaceAvailableParams() {
            this(0);
        }

        public static WebDatabaseHostGetSpaceAvailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostGetSpaceAvailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostGetSpaceAvailableParams decode(Decoder decoder0) {
            WebDatabaseHostGetSpaceAvailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostGetSpaceAvailableParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
        }
    }

    static final class WebDatabaseHostGetSpaceAvailableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long spaceAvailable;

        private WebDatabaseHostGetSpaceAvailableResponseParams(int version) {
            super(16, version);
        }

        public WebDatabaseHostGetSpaceAvailableResponseParams() {
            this(0);
        }

        public static WebDatabaseHostGetSpaceAvailableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostGetSpaceAvailableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostGetSpaceAvailableResponseParams decode(Decoder decoder0) {
            WebDatabaseHostGetSpaceAvailableResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostGetSpaceAvailableResponseParams(elementsOrVersion);
                result.spaceAvailable = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.spaceAvailable, 8);
        }
    }

    static class WebDatabaseHostGetSpaceAvailableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final WebDatabaseHost.GetSpaceAvailableResponse mCallback;

        WebDatabaseHostGetSpaceAvailableResponseParamsForwardToCallback(WebDatabaseHost.GetSpaceAvailableResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableResponseParams response = WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Long.valueOf(response.spaceAvailable));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class WebDatabaseHostGetSpaceAvailableResponseParamsProxyToResponder implements WebDatabaseHost.GetSpaceAvailableResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        WebDatabaseHostGetSpaceAvailableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Long spaceAvailable) {
            WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableResponseParams _response = new WebDatabaseHost_Internal.WebDatabaseHostGetSpaceAvailableResponseParams();
            _response.spaceAvailable = spaceAvailable.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class WebDatabaseHostOpenedParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public String16 databaseName;

        public String16 databaseDescription;

        public long estimatedSize;

        private WebDatabaseHostOpenedParams(int version) {
            super(40, version);
        }

        public WebDatabaseHostOpenedParams() {
            this(0);
        }

        public static WebDatabaseHostOpenedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostOpenedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostOpenedParams decode(Decoder decoder0) {
            WebDatabaseHostOpenedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostOpenedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.databaseName = String16.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.databaseDescription = String16.decode(decoder1);
                result.estimatedSize = decoder0.readLong(32);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode((Struct)this.databaseName, 16, false);
            encoder0.encode((Struct)this.databaseDescription, 24, false);
            encoder0.encode(this.estimatedSize, 32);
        }
    }

    static final class WebDatabaseHostModifiedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public String16 databaseName;

        private WebDatabaseHostModifiedParams(int version) {
            super(24, version);
        }

        public WebDatabaseHostModifiedParams() {
            this(0);
        }

        public static WebDatabaseHostModifiedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostModifiedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostModifiedParams decode(Decoder decoder0) {
            WebDatabaseHostModifiedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostModifiedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.databaseName = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode((Struct)this.databaseName, 16, false);
        }
    }

    static final class WebDatabaseHostClosedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public String16 databaseName;

        private WebDatabaseHostClosedParams(int version) {
            super(24, version);
        }

        public WebDatabaseHostClosedParams() {
            this(0);
        }

        public static WebDatabaseHostClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostClosedParams decode(Decoder decoder0) {
            WebDatabaseHostClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostClosedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.databaseName = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode((Struct)this.databaseName, 16, false);
        }
    }

    static final class WebDatabaseHostHandleSqliteErrorParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public String16 databaseName;

        public int error;

        private WebDatabaseHostHandleSqliteErrorParams(int version) {
            super(32, version);
        }

        public WebDatabaseHostHandleSqliteErrorParams() {
            this(0);
        }

        public static WebDatabaseHostHandleSqliteErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static WebDatabaseHostHandleSqliteErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static WebDatabaseHostHandleSqliteErrorParams decode(Decoder decoder0) {
            WebDatabaseHostHandleSqliteErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WebDatabaseHostHandleSqliteErrorParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.databaseName = String16.decode(decoder1);
                result.error = decoder0.readInt(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode((Struct)this.databaseName, 16, false);
            encoder0.encode(this.error, 24);
        }
    }
}
