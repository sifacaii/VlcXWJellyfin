package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.skia.mojom.Bitmap;
import org.chromium.url.mojom.Url;

class ClipboardHost_Internal {
    public static final Interface.Manager<ClipboardHost, ClipboardHost.Proxy> MANAGER = new Interface.Manager<ClipboardHost, ClipboardHost.Proxy>() {
        public String getName() {
            return "blink.mojom.ClipboardHost";
        }

        public int getVersion() {
            return 0;
        }

        public ClipboardHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ClipboardHost_Internal.Proxy(core, messageReceiver);
        }

        public ClipboardHost_Internal.Stub buildStub(Core core, ClipboardHost impl) {
            return new ClipboardHost_Internal.Stub(core, impl);
        }

        public ClipboardHost[] buildArray(int size) {
            return new ClipboardHost[size];
        }
    };

    private static final int GET_SEQUENCE_NUMBER_ORDINAL = 0;

    private static final int IS_FORMAT_AVAILABLE_ORDINAL = 1;

    private static final int READ_AVAILABLE_TYPES_ORDINAL = 2;

    private static final int READ_TEXT_ORDINAL = 3;

    private static final int READ_HTML_ORDINAL = 4;

    private static final int READ_RTF_ORDINAL = 5;

    private static final int READ_IMAGE_ORDINAL = 6;

    private static final int READ_CUSTOM_DATA_ORDINAL = 7;

    private static final int WRITE_TEXT_ORDINAL = 8;

    private static final int WRITE_HTML_ORDINAL = 9;

    private static final int WRITE_SMART_PASTE_MARKER_ORDINAL = 10;

    private static final int WRITE_CUSTOM_DATA_ORDINAL = 11;

    private static final int WRITE_BOOKMARK_ORDINAL = 12;

    private static final int WRITE_IMAGE_ORDINAL = 13;

    private static final int COMMIT_WRITE_ORDINAL = 14;

    static final class Proxy extends Interface.AbstractProxy implements ClipboardHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getSequenceNumber(int buffer, ClipboardHost.GetSequenceNumberResponse callback) {
            ClipboardHost_Internal.ClipboardHostGetSequenceNumberParams _message = new ClipboardHost_Internal.ClipboardHostGetSequenceNumberParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ClipboardHost_Internal.ClipboardHostGetSequenceNumberResponseParamsForwardToCallback(callback));
        }

        public void isFormatAvailable(int format, int buffer, ClipboardHost.IsFormatAvailableResponse callback) {
            ClipboardHost_Internal.ClipboardHostIsFormatAvailableParams _message = new ClipboardHost_Internal.ClipboardHostIsFormatAvailableParams();
            _message.format = format;
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ClipboardHost_Internal.ClipboardHostIsFormatAvailableResponseParamsForwardToCallback(callback));
        }

        public void readAvailableTypes(int buffer, ClipboardHost.ReadAvailableTypesResponse callback) {
            ClipboardHost_Internal.ClipboardHostReadAvailableTypesParams _message = new ClipboardHost_Internal.ClipboardHostReadAvailableTypesParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ClipboardHost_Internal.ClipboardHostReadAvailableTypesResponseParamsForwardToCallback(callback));
        }

        public void readText(int buffer, ClipboardHost.ReadTextResponse callback) {
            ClipboardHost_Internal.ClipboardHostReadTextParams _message = new ClipboardHost_Internal.ClipboardHostReadTextParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ClipboardHost_Internal.ClipboardHostReadTextResponseParamsForwardToCallback(callback));
        }

        public void readHtml(int buffer, ClipboardHost.ReadHtmlResponse callback) {
            ClipboardHost_Internal.ClipboardHostReadHtmlParams _message = new ClipboardHost_Internal.ClipboardHostReadHtmlParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new ClipboardHost_Internal.ClipboardHostReadHtmlResponseParamsForwardToCallback(callback));
        }

        public void readRtf(int buffer, ClipboardHost.ReadRtfResponse callback) {
            ClipboardHost_Internal.ClipboardHostReadRtfParams _message = new ClipboardHost_Internal.ClipboardHostReadRtfParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new ClipboardHost_Internal.ClipboardHostReadRtfResponseParamsForwardToCallback(callback));
        }

        public void readImage(int buffer, ClipboardHost.ReadImageResponse callback) {
            ClipboardHost_Internal.ClipboardHostReadImageParams _message = new ClipboardHost_Internal.ClipboardHostReadImageParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new ClipboardHost_Internal.ClipboardHostReadImageResponseParamsForwardToCallback(callback));
        }

        public void readCustomData(int buffer, String16 type, ClipboardHost.ReadCustomDataResponse callback) {
            ClipboardHost_Internal.ClipboardHostReadCustomDataParams _message = new ClipboardHost_Internal.ClipboardHostReadCustomDataParams();
            _message.buffer = buffer;
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new ClipboardHost_Internal.ClipboardHostReadCustomDataResponseParamsForwardToCallback(callback));
        }

        public void writeText(BigString16 text) {
            ClipboardHost_Internal.ClipboardHostWriteTextParams _message = new ClipboardHost_Internal.ClipboardHostWriteTextParams();
            _message.text = text;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }

        public void writeHtml(BigString16 markup, Url url) {
            ClipboardHost_Internal.ClipboardHostWriteHtmlParams _message = new ClipboardHost_Internal.ClipboardHostWriteHtmlParams();
            _message.markup = markup;
            _message.url = url;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9)));
        }

        public void writeSmartPasteMarker() {
            ClipboardHost_Internal.ClipboardHostWriteSmartPasteMarkerParams _message = new ClipboardHost_Internal.ClipboardHostWriteSmartPasteMarkerParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10)));
        }

        public void writeCustomData(Map<String16, BigString16> data) {
            ClipboardHost_Internal.ClipboardHostWriteCustomDataParams _message = new ClipboardHost_Internal.ClipboardHostWriteCustomDataParams();
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(11)));
        }

        public void writeBookmark(String url, String16 title) {
            ClipboardHost_Internal.ClipboardHostWriteBookmarkParams _message = new ClipboardHost_Internal.ClipboardHostWriteBookmarkParams();
            _message.url = url;
            _message.title = title;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(12)));
        }

        public void writeImage(Bitmap image) {
            ClipboardHost_Internal.ClipboardHostWriteImageParams _message = new ClipboardHost_Internal.ClipboardHostWriteImageParams();
            _message.image = image;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(13)));
        }

        public void commitWrite() {
            ClipboardHost_Internal.ClipboardHostCommitWriteParams _message = new ClipboardHost_Internal.ClipboardHostCommitWriteParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(14)));
        }
    }

    static final class Stub extends Interface.Stub<ClipboardHost> {
        Stub(Core core, ClipboardHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ClipboardHost_Internal.ClipboardHostWriteTextParams clipboardHostWriteTextParams;
                ClipboardHost_Internal.ClipboardHostWriteHtmlParams clipboardHostWriteHtmlParams;
                ClipboardHost_Internal.ClipboardHostWriteCustomDataParams clipboardHostWriteCustomDataParams;
                ClipboardHost_Internal.ClipboardHostWriteBookmarkParams clipboardHostWriteBookmarkParams;
                ClipboardHost_Internal.ClipboardHostWriteImageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ClipboardHost_Internal.MANAGER, messageWithHeader);
                    case 8:
                        clipboardHostWriteTextParams = ClipboardHost_Internal.ClipboardHostWriteTextParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).writeText(clipboardHostWriteTextParams.text);
                        return true;
                    case 9:
                        clipboardHostWriteHtmlParams = ClipboardHost_Internal.ClipboardHostWriteHtmlParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).writeHtml(clipboardHostWriteHtmlParams.markup, clipboardHostWriteHtmlParams.url);
                        return true;
                    case 10:
                        ClipboardHost_Internal.ClipboardHostWriteSmartPasteMarkerParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).writeSmartPasteMarker();
                        return true;
                    case 11:
                        clipboardHostWriteCustomDataParams = ClipboardHost_Internal.ClipboardHostWriteCustomDataParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).writeCustomData(clipboardHostWriteCustomDataParams.data);
                        return true;
                    case 12:
                        clipboardHostWriteBookmarkParams = ClipboardHost_Internal.ClipboardHostWriteBookmarkParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).writeBookmark(clipboardHostWriteBookmarkParams.url, clipboardHostWriteBookmarkParams.title);
                        return true;
                    case 13:
                        data = ClipboardHost_Internal.ClipboardHostWriteImageParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).writeImage(data.image);
                        return true;
                    case 14:
                        ClipboardHost_Internal.ClipboardHostCommitWriteParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).commitWrite();
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
                ClipboardHost_Internal.ClipboardHostGetSequenceNumberParams clipboardHostGetSequenceNumberParams;
                ClipboardHost_Internal.ClipboardHostIsFormatAvailableParams clipboardHostIsFormatAvailableParams;
                ClipboardHost_Internal.ClipboardHostReadAvailableTypesParams clipboardHostReadAvailableTypesParams;
                ClipboardHost_Internal.ClipboardHostReadTextParams clipboardHostReadTextParams;
                ClipboardHost_Internal.ClipboardHostReadHtmlParams clipboardHostReadHtmlParams;
                ClipboardHost_Internal.ClipboardHostReadRtfParams clipboardHostReadRtfParams;
                ClipboardHost_Internal.ClipboardHostReadImageParams clipboardHostReadImageParams;
                ClipboardHost_Internal.ClipboardHostReadCustomDataParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ClipboardHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        clipboardHostGetSequenceNumberParams = ClipboardHost_Internal.ClipboardHostGetSequenceNumberParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).getSequenceNumber(clipboardHostGetSequenceNumberParams.buffer, new ClipboardHost_Internal.ClipboardHostGetSequenceNumberResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        clipboardHostIsFormatAvailableParams = ClipboardHost_Internal.ClipboardHostIsFormatAvailableParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).isFormatAvailable(clipboardHostIsFormatAvailableParams.format, clipboardHostIsFormatAvailableParams.buffer, new ClipboardHost_Internal.ClipboardHostIsFormatAvailableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        clipboardHostReadAvailableTypesParams = ClipboardHost_Internal.ClipboardHostReadAvailableTypesParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).readAvailableTypes(clipboardHostReadAvailableTypesParams.buffer, new ClipboardHost_Internal.ClipboardHostReadAvailableTypesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        clipboardHostReadTextParams = ClipboardHost_Internal.ClipboardHostReadTextParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).readText(clipboardHostReadTextParams.buffer, new ClipboardHost_Internal.ClipboardHostReadTextResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        clipboardHostReadHtmlParams = ClipboardHost_Internal.ClipboardHostReadHtmlParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).readHtml(clipboardHostReadHtmlParams.buffer, new ClipboardHost_Internal.ClipboardHostReadHtmlResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        clipboardHostReadRtfParams = ClipboardHost_Internal.ClipboardHostReadRtfParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).readRtf(clipboardHostReadRtfParams.buffer, new ClipboardHost_Internal.ClipboardHostReadRtfResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        clipboardHostReadImageParams = ClipboardHost_Internal.ClipboardHostReadImageParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).readImage(clipboardHostReadImageParams.buffer, new ClipboardHost_Internal.ClipboardHostReadImageResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        data = ClipboardHost_Internal.ClipboardHostReadCustomDataParams.deserialize(messageWithHeader.getPayload());
                        ((ClipboardHost)getImpl()).readCustomData(data.buffer, data.type, new ClipboardHost_Internal.ClipboardHostReadCustomDataResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ClipboardHostGetSequenceNumberParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        private ClipboardHostGetSequenceNumberParams(int version) {
            super(16, version);
        }

        public ClipboardHostGetSequenceNumberParams() {
            this(0);
        }

        public static ClipboardHostGetSequenceNumberParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostGetSequenceNumberParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostGetSequenceNumberParams decode(Decoder decoder0) {
            ClipboardHostGetSequenceNumberParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostGetSequenceNumberParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
        }
    }

    static final class ClipboardHostGetSequenceNumberResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long result;

        private ClipboardHostGetSequenceNumberResponseParams(int version) {
            super(16, version);
        }

        public ClipboardHostGetSequenceNumberResponseParams() {
            this(0);
        }

        public static ClipboardHostGetSequenceNumberResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostGetSequenceNumberResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostGetSequenceNumberResponseParams decode(Decoder decoder0) {
            ClipboardHostGetSequenceNumberResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostGetSequenceNumberResponseParams(elementsOrVersion);
                result.result = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8);
        }
    }

    static class ClipboardHostGetSequenceNumberResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.GetSequenceNumberResponse mCallback;

        ClipboardHostGetSequenceNumberResponseParamsForwardToCallback(ClipboardHost.GetSequenceNumberResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostGetSequenceNumberResponseParams response = ClipboardHost_Internal.ClipboardHostGetSequenceNumberResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Long.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostGetSequenceNumberResponseParamsProxyToResponder implements ClipboardHost.GetSequenceNumberResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostGetSequenceNumberResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Long result) {
            ClipboardHost_Internal.ClipboardHostGetSequenceNumberResponseParams _response = new ClipboardHost_Internal.ClipboardHostGetSequenceNumberResponseParams();
            _response.result = result.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostIsFormatAvailableParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int format;

        public int buffer;

        private ClipboardHostIsFormatAvailableParams(int version) {
            super(16, version);
        }

        public ClipboardHostIsFormatAvailableParams() {
            this(0);
        }

        public static ClipboardHostIsFormatAvailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostIsFormatAvailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostIsFormatAvailableParams decode(Decoder decoder0) {
            ClipboardHostIsFormatAvailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostIsFormatAvailableParams(elementsOrVersion);
                result.format = decoder0.readInt(8);
                ClipboardFormat.validate(result.format);
                result.buffer = decoder0.readInt(12);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.format, 8);
            encoder0.encode(this.buffer, 12);
        }
    }

    static final class ClipboardHostIsFormatAvailableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean result;

        private ClipboardHostIsFormatAvailableResponseParams(int version) {
            super(16, version);
        }

        public ClipboardHostIsFormatAvailableResponseParams() {
            this(0);
        }

        public static ClipboardHostIsFormatAvailableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostIsFormatAvailableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostIsFormatAvailableResponseParams decode(Decoder decoder0) {
            ClipboardHostIsFormatAvailableResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostIsFormatAvailableResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, 0);
        }
    }

    static class ClipboardHostIsFormatAvailableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.IsFormatAvailableResponse mCallback;

        ClipboardHostIsFormatAvailableResponseParamsForwardToCallback(ClipboardHost.IsFormatAvailableResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostIsFormatAvailableResponseParams response = ClipboardHost_Internal.ClipboardHostIsFormatAvailableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostIsFormatAvailableResponseParamsProxyToResponder implements ClipboardHost.IsFormatAvailableResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostIsFormatAvailableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean result) {
            ClipboardHost_Internal.ClipboardHostIsFormatAvailableResponseParams _response = new ClipboardHost_Internal.ClipboardHostIsFormatAvailableResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostReadAvailableTypesParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        private ClipboardHostReadAvailableTypesParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadAvailableTypesParams() {
            this(0);
        }

        public static ClipboardHostReadAvailableTypesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadAvailableTypesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadAvailableTypesParams decode(Decoder decoder0) {
            ClipboardHostReadAvailableTypesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadAvailableTypesParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
        }
    }

    static final class ClipboardHostReadAvailableTypesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String16[] types;

        public boolean result;

        private ClipboardHostReadAvailableTypesResponseParams(int version) {
            super(24, version);
        }

        public ClipboardHostReadAvailableTypesResponseParams() {
            this(0);
        }

        public static ClipboardHostReadAvailableTypesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadAvailableTypesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadAvailableTypesResponseParams decode(Decoder decoder0) {
            ClipboardHostReadAvailableTypesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadAvailableTypesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.types = new String16[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.types[i1] = String16.decode(decoder2);
                }
                result.result = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.types == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.types.length, 8, -1);
                for (int i0 = 0; i0 < this.types.length; i0++)
                    encoder1.encode((Struct)this.types[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.result, 16, 0);
        }
    }

    static class ClipboardHostReadAvailableTypesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.ReadAvailableTypesResponse mCallback;

        ClipboardHostReadAvailableTypesResponseParamsForwardToCallback(ClipboardHost.ReadAvailableTypesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostReadAvailableTypesResponseParams response = ClipboardHost_Internal.ClipboardHostReadAvailableTypesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.types, Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostReadAvailableTypesResponseParamsProxyToResponder implements ClipboardHost.ReadAvailableTypesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostReadAvailableTypesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String16[] types, Boolean result) {
            ClipboardHost_Internal.ClipboardHostReadAvailableTypesResponseParams _response = new ClipboardHost_Internal.ClipboardHostReadAvailableTypesResponseParams();
            _response.types = types;
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostReadTextParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        private ClipboardHostReadTextParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadTextParams() {
            this(0);
        }

        public static ClipboardHostReadTextParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadTextParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadTextParams decode(Decoder decoder0) {
            ClipboardHostReadTextParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadTextParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
        }
    }

    static final class ClipboardHostReadTextResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BigString16 result;

        private ClipboardHostReadTextResponseParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadTextResponseParams() {
            this(0);
        }

        public static ClipboardHostReadTextResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadTextResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadTextResponseParams decode(Decoder decoder0) {
            ClipboardHostReadTextResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadTextResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = BigString16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.result, 8, false);
        }
    }

    static class ClipboardHostReadTextResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.ReadTextResponse mCallback;

        ClipboardHostReadTextResponseParamsForwardToCallback(ClipboardHost.ReadTextResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostReadTextResponseParams response = ClipboardHost_Internal.ClipboardHostReadTextResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostReadTextResponseParamsProxyToResponder implements ClipboardHost.ReadTextResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostReadTextResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BigString16 result) {
            ClipboardHost_Internal.ClipboardHostReadTextResponseParams _response = new ClipboardHost_Internal.ClipboardHostReadTextResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostReadHtmlParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        private ClipboardHostReadHtmlParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadHtmlParams() {
            this(0);
        }

        public static ClipboardHostReadHtmlParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadHtmlParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadHtmlParams decode(Decoder decoder0) {
            ClipboardHostReadHtmlParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadHtmlParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
        }
    }

    static final class ClipboardHostReadHtmlResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BigString16 markup;

        public Url url;

        public int fragmentStart;

        public int fragmentEnd;

        private ClipboardHostReadHtmlResponseParams(int version) {
            super(32, version);
        }

        public ClipboardHostReadHtmlResponseParams() {
            this(0);
        }

        public static ClipboardHostReadHtmlResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadHtmlResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadHtmlResponseParams decode(Decoder decoder0) {
            ClipboardHostReadHtmlResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadHtmlResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.markup = BigString16.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
                result.fragmentStart = decoder0.readInt(24);
                result.fragmentEnd = decoder0.readInt(28);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.markup, 8, false);
            encoder0.encode((Struct)this.url, 16, false);
            encoder0.encode(this.fragmentStart, 24);
            encoder0.encode(this.fragmentEnd, 28);
        }
    }

    static class ClipboardHostReadHtmlResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.ReadHtmlResponse mCallback;

        ClipboardHostReadHtmlResponseParamsForwardToCallback(ClipboardHost.ReadHtmlResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostReadHtmlResponseParams response = ClipboardHost_Internal.ClipboardHostReadHtmlResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.markup, response.url, Integer.valueOf(response.fragmentStart), Integer.valueOf(response.fragmentEnd));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostReadHtmlResponseParamsProxyToResponder implements ClipboardHost.ReadHtmlResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostReadHtmlResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BigString16 markup, Url url, Integer fragmentStart, Integer fragmentEnd) {
            ClipboardHost_Internal.ClipboardHostReadHtmlResponseParams _response = new ClipboardHost_Internal.ClipboardHostReadHtmlResponseParams();
            _response.markup = markup;
            _response.url = url;
            _response.fragmentStart = fragmentStart.intValue();
            _response.fragmentEnd = fragmentEnd.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostReadRtfParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        private ClipboardHostReadRtfParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadRtfParams() {
            this(0);
        }

        public static ClipboardHostReadRtfParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadRtfParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadRtfParams decode(Decoder decoder0) {
            ClipboardHostReadRtfParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadRtfParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
        }
    }

    static final class ClipboardHostReadRtfResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String result;

        private ClipboardHostReadRtfResponseParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadRtfResponseParams() {
            this(0);
        }

        public static ClipboardHostReadRtfResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadRtfResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadRtfResponseParams decode(Decoder decoder0) {
            ClipboardHostReadRtfResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadRtfResponseParams(elementsOrVersion);
                result.result = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class ClipboardHostReadRtfResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.ReadRtfResponse mCallback;

        ClipboardHostReadRtfResponseParamsForwardToCallback(ClipboardHost.ReadRtfResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostReadRtfResponseParams response = ClipboardHost_Internal.ClipboardHostReadRtfResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostReadRtfResponseParamsProxyToResponder implements ClipboardHost.ReadRtfResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostReadRtfResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String result) {
            ClipboardHost_Internal.ClipboardHostReadRtfResponseParams _response = new ClipboardHost_Internal.ClipboardHostReadRtfResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostReadImageParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        private ClipboardHostReadImageParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadImageParams() {
            this(0);
        }

        public static ClipboardHostReadImageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadImageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadImageParams decode(Decoder decoder0) {
            ClipboardHostReadImageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadImageParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
        }
    }

    static final class ClipboardHostReadImageResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Bitmap image;

        private ClipboardHostReadImageResponseParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadImageResponseParams() {
            this(0);
        }

        public static ClipboardHostReadImageResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadImageResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadImageResponseParams decode(Decoder decoder0) {
            ClipboardHostReadImageResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadImageResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.image = Bitmap.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.image, 8, true);
        }
    }

    static class ClipboardHostReadImageResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.ReadImageResponse mCallback;

        ClipboardHostReadImageResponseParamsForwardToCallback(ClipboardHost.ReadImageResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostReadImageResponseParams response = ClipboardHost_Internal.ClipboardHostReadImageResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.image);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostReadImageResponseParamsProxyToResponder implements ClipboardHost.ReadImageResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostReadImageResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Bitmap image) {
            ClipboardHost_Internal.ClipboardHostReadImageResponseParams _response = new ClipboardHost_Internal.ClipboardHostReadImageResponseParams();
            _response.image = image;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostReadCustomDataParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int buffer;

        public String16 type;

        private ClipboardHostReadCustomDataParams(int version) {
            super(24, version);
        }

        public ClipboardHostReadCustomDataParams() {
            this(0);
        }

        public static ClipboardHostReadCustomDataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadCustomDataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadCustomDataParams decode(Decoder decoder0) {
            ClipboardHostReadCustomDataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadCustomDataParams(elementsOrVersion);
                result.buffer = decoder0.readInt(8);
                ClipboardBuffer.validate(result.buffer);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.type = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8);
            encoder0.encode((Struct)this.type, 16, false);
        }
    }

    static final class ClipboardHostReadCustomDataResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BigString16 result;

        private ClipboardHostReadCustomDataResponseParams(int version) {
            super(16, version);
        }

        public ClipboardHostReadCustomDataResponseParams() {
            this(0);
        }

        public static ClipboardHostReadCustomDataResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostReadCustomDataResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostReadCustomDataResponseParams decode(Decoder decoder0) {
            ClipboardHostReadCustomDataResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostReadCustomDataResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = BigString16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.result, 8, false);
        }
    }

    static class ClipboardHostReadCustomDataResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ClipboardHost.ReadCustomDataResponse mCallback;

        ClipboardHostReadCustomDataResponseParamsForwardToCallback(ClipboardHost.ReadCustomDataResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                ClipboardHost_Internal.ClipboardHostReadCustomDataResponseParams response = ClipboardHost_Internal.ClipboardHostReadCustomDataResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ClipboardHostReadCustomDataResponseParamsProxyToResponder implements ClipboardHost.ReadCustomDataResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ClipboardHostReadCustomDataResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BigString16 result) {
            ClipboardHost_Internal.ClipboardHostReadCustomDataResponseParams _response = new ClipboardHost_Internal.ClipboardHostReadCustomDataResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ClipboardHostWriteTextParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BigString16 text;

        private ClipboardHostWriteTextParams(int version) {
            super(16, version);
        }

        public ClipboardHostWriteTextParams() {
            this(0);
        }

        public static ClipboardHostWriteTextParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostWriteTextParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostWriteTextParams decode(Decoder decoder0) {
            ClipboardHostWriteTextParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostWriteTextParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.text = BigString16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.text, 8, false);
        }
    }

    static final class ClipboardHostWriteHtmlParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BigString16 markup;

        public Url url;

        private ClipboardHostWriteHtmlParams(int version) {
            super(24, version);
        }

        public ClipboardHostWriteHtmlParams() {
            this(0);
        }

        public static ClipboardHostWriteHtmlParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostWriteHtmlParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostWriteHtmlParams decode(Decoder decoder0) {
            ClipboardHostWriteHtmlParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostWriteHtmlParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.markup = BigString16.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.markup, 8, false);
            encoder0.encode((Struct)this.url, 16, false);
        }
    }

    static final class ClipboardHostWriteSmartPasteMarkerParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ClipboardHostWriteSmartPasteMarkerParams(int version) {
            super(8, version);
        }

        public ClipboardHostWriteSmartPasteMarkerParams() {
            this(0);
        }

        public static ClipboardHostWriteSmartPasteMarkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostWriteSmartPasteMarkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostWriteSmartPasteMarkerParams decode(Decoder decoder0) {
            ClipboardHostWriteSmartPasteMarkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostWriteSmartPasteMarkerParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ClipboardHostWriteCustomDataParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Map<String16, BigString16> data;

        private ClipboardHostWriteCustomDataParams(int version) {
            super(16, version);
        }

        public ClipboardHostWriteCustomDataParams() {
            this(0);
        }

        public static ClipboardHostWriteCustomDataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostWriteCustomDataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostWriteCustomDataParams decode(Decoder decoder0) {
            ClipboardHostWriteCustomDataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostWriteCustomDataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                decoder1.readDataHeaderForMap();
                Decoder decoder2 = decoder1.readPointer(8, false);
                DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
                String16[] keys0 = new String16[si2.elementsOrVersion];
                int i2;
                for (i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                    Decoder decoder3 = decoder2.readPointer(8 + 8 * i2, false);
                    keys0[i2] = String16.decode(decoder3);
                }
                decoder2 = decoder1.readPointer(16, false);
                si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
                BigString16[] values0 = new BigString16[si2.elementsOrVersion];
                for (i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                    Decoder decoder3 = decoder2.readPointer(8 + 8 * i2, false);
                    values0[i2] = BigString16.decode(decoder3);
                }
                result.data = new HashMap<>();
                for (int index0 = 0; index0 < keys0.length; index0++)
                    result.data.put(keys0[index0], values0[index0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.data == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encoderForMap(8);
                int size0 = this.data.size();
                String16[] keys0 = new String16[size0];
                BigString16[] values0 = new BigString16[size0];
                int index0 = 0;
                for (Map.Entry<String16, BigString16> entry0 : this.data.entrySet()) {
                    keys0[index0] = entry0.getKey();
                    values0[index0] = entry0.getValue();
                    index0++;
                }
                Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
                int i1;
                for (i1 = 0; i1 < keys0.length; i1++)
                    encoder2.encode((Struct)keys0[i1], 8 + 8 * i1, false);
                encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
                for (i1 = 0; i1 < values0.length; i1++)
                    encoder2.encode((Struct)values0[i1], 8 + 8 * i1, false);
            }
        }
    }

    static final class ClipboardHostWriteBookmarkParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String url;

        public String16 title;

        private ClipboardHostWriteBookmarkParams(int version) {
            super(24, version);
        }

        public ClipboardHostWriteBookmarkParams() {
            this(0);
        }

        public static ClipboardHostWriteBookmarkParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostWriteBookmarkParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostWriteBookmarkParams decode(Decoder decoder0) {
            ClipboardHostWriteBookmarkParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostWriteBookmarkParams(elementsOrVersion);
                result.url = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.title = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.url, 8, false);
            encoder0.encode((Struct)this.title, 16, false);
        }
    }

    static final class ClipboardHostWriteImageParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Bitmap image;

        private ClipboardHostWriteImageParams(int version) {
            super(16, version);
        }

        public ClipboardHostWriteImageParams() {
            this(0);
        }

        public static ClipboardHostWriteImageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostWriteImageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostWriteImageParams decode(Decoder decoder0) {
            ClipboardHostWriteImageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostWriteImageParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.image = Bitmap.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.image, 8, false);
        }
    }

    static final class ClipboardHostCommitWriteParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ClipboardHostCommitWriteParams(int version) {
            super(8, version);
        }

        public ClipboardHostCommitWriteParams() {
            this(0);
        }

        public static ClipboardHostCommitWriteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ClipboardHostCommitWriteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ClipboardHostCommitWriteParams decode(Decoder decoder0) {
            ClipboardHostCommitWriteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ClipboardHostCommitWriteParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
