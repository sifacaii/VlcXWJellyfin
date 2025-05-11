package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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
import org.chromium.skia.mojom.Bitmap;
import org.chromium.url.mojom.Url;

class ImageDownloader_Internal {
    public static final Interface.Manager<ImageDownloader, ImageDownloader.Proxy> MANAGER = new Interface.Manager<ImageDownloader, ImageDownloader.Proxy>() {
        public String getName() {
            return "blink.mojom.ImageDownloader";
        }

        public int getVersion() {
            return 0;
        }

        public ImageDownloader_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ImageDownloader_Internal.Proxy(core, messageReceiver);
        }

        public ImageDownloader_Internal.Stub buildStub(Core core, ImageDownloader impl) {
            return new ImageDownloader_Internal.Stub(core, impl);
        }

        public ImageDownloader[] buildArray(int size) {
            return new ImageDownloader[size];
        }
    };

    private static final int DOWNLOAD_IMAGE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ImageDownloader.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void downloadImage(Url url, boolean isFavicon, int maxBitmapSize, boolean bypassCache, ImageDownloader.DownloadImageResponse callback) {
            ImageDownloader_Internal.ImageDownloaderDownloadImageParams _message = new ImageDownloader_Internal.ImageDownloaderDownloadImageParams();
            _message.url = url;
            _message.isFavicon = isFavicon;
            _message.maxBitmapSize = maxBitmapSize;
            _message.bypassCache = bypassCache;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ImageDownloader_Internal.ImageDownloaderDownloadImageResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ImageDownloader> {
        Stub(Core core, ImageDownloader impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ImageDownloader_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ImageDownloader_Internal.ImageDownloaderDownloadImageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ImageDownloader_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = ImageDownloader_Internal.ImageDownloaderDownloadImageParams.deserialize(messageWithHeader.getPayload());
                        ((ImageDownloader)getImpl()).downloadImage(data.url, data.isFavicon, data.maxBitmapSize, data.bypassCache, new ImageDownloader_Internal.ImageDownloaderDownloadImageResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ImageDownloaderDownloadImageParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public boolean isFavicon;

        public int maxBitmapSize;

        public boolean bypassCache;

        private ImageDownloaderDownloadImageParams(int version) {
            super(24, version);
        }

        public ImageDownloaderDownloadImageParams() {
            this(0);
        }

        public static ImageDownloaderDownloadImageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ImageDownloaderDownloadImageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ImageDownloaderDownloadImageParams decode(Decoder decoder0) {
            ImageDownloaderDownloadImageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ImageDownloaderDownloadImageParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.isFavicon = decoder0.readBoolean(16, 0);
                result.bypassCache = decoder0.readBoolean(16, 1);
                result.maxBitmapSize = decoder0.readInt(20);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.isFavicon, 16, 0);
            encoder0.encode(this.bypassCache, 16, 1);
            encoder0.encode(this.maxBitmapSize, 20);
        }
    }

    static final class ImageDownloaderDownloadImageResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int httpStatusCode;

        public Bitmap[] images;

        public Size[] originalImageSizes;

        private ImageDownloaderDownloadImageResponseParams(int version) {
            super(32, version);
        }

        public ImageDownloaderDownloadImageResponseParams() {
            this(0);
        }

        public static ImageDownloaderDownloadImageResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ImageDownloaderDownloadImageResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ImageDownloaderDownloadImageResponseParams decode(Decoder decoder0) {
            ImageDownloaderDownloadImageResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ImageDownloaderDownloadImageResponseParams(elementsOrVersion);
                result.httpStatusCode = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.images = new Bitmap[si1.elementsOrVersion];
                int i1;
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.images[i1] = Bitmap.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(24, false);
                si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.originalImageSizes = new Size[si1.elementsOrVersion];
                for (i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.originalImageSizes[i1] = Size.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.httpStatusCode, 8);
            if (this.images == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.images.length, 16, -1);
                for (int i0 = 0; i0 < this.images.length; i0++)
                    encoder1.encode((Struct)this.images[i0], 8 + 8 * i0, false);
            }
            if (this.originalImageSizes == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.originalImageSizes.length, 24, -1);
                for (int i0 = 0; i0 < this.originalImageSizes.length; i0++)
                    encoder1.encode((Struct)this.originalImageSizes[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class ImageDownloaderDownloadImageResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ImageDownloader.DownloadImageResponse mCallback;

        ImageDownloaderDownloadImageResponseParamsForwardToCallback(ImageDownloader.DownloadImageResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ImageDownloader_Internal.ImageDownloaderDownloadImageResponseParams response = ImageDownloader_Internal.ImageDownloaderDownloadImageResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.httpStatusCode), response.images, response.originalImageSizes);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ImageDownloaderDownloadImageResponseParamsProxyToResponder implements ImageDownloader.DownloadImageResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ImageDownloaderDownloadImageResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer httpStatusCode, Bitmap[] images, Size[] originalImageSizes) {
            ImageDownloader_Internal.ImageDownloaderDownloadImageResponseParams _response = new ImageDownloader_Internal.ImageDownloaderDownloadImageResponseParams();
            _response.httpStatusCode = httpStatusCode.intValue();
            _response.images = images;
            _response.originalImageSizes = originalImageSizes;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
