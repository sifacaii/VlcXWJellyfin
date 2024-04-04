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
import org.chromium.skia.mojom.Bitmap;
import org.chromium.url.mojom.Url;

class ContentIndexService_Internal {
    public static final Interface.Manager<ContentIndexService, ContentIndexService.Proxy> MANAGER = new Interface.Manager<ContentIndexService, ContentIndexService.Proxy>() {
        public String getName() {
            return "blink.mojom.ContentIndexService";
        }

        public int getVersion() {
            return 0;
        }

        public ContentIndexService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ContentIndexService_Internal.Proxy(core, messageReceiver);
        }

        public ContentIndexService_Internal.Stub buildStub(Core core, ContentIndexService impl) {
            return new ContentIndexService_Internal.Stub(core, impl);
        }

        public ContentIndexService[] buildArray(int size) {
            return new ContentIndexService[size];
        }
    };

    private static final int ADD_ORDINAL = 0;

    private static final int DELETE_ORDINAL = 1;

    private static final int GET_DESCRIPTIONS_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements ContentIndexService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void add(long serviceWorkerRegistrationId, ContentDescription description, Bitmap icon, Url launchUrl, ContentIndexService.AddResponse callback) {
            ContentIndexService_Internal.ContentIndexServiceAddParams _message = new ContentIndexService_Internal.ContentIndexServiceAddParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.description = description;
            _message.icon = icon;
            _message.launchUrl = launchUrl;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ContentIndexService_Internal.ContentIndexServiceAddResponseParamsForwardToCallback(callback));
        }

        public void delete(long serviceWorkerRegistrationId, String id, ContentIndexService.DeleteResponse callback) {
            ContentIndexService_Internal.ContentIndexServiceDeleteParams _message = new ContentIndexService_Internal.ContentIndexServiceDeleteParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.id = id;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ContentIndexService_Internal.ContentIndexServiceDeleteResponseParamsForwardToCallback(callback));
        }

        public void getDescriptions(long serviceWorkerRegistrationId, ContentIndexService.GetDescriptionsResponse callback) {
            ContentIndexService_Internal.ContentIndexServiceGetDescriptionsParams _message = new ContentIndexService_Internal.ContentIndexServiceGetDescriptionsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ContentIndexService_Internal.ContentIndexServiceGetDescriptionsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ContentIndexService> {
        Stub(Core core, ContentIndexService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ContentIndexService_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ContentIndexService_Internal.ContentIndexServiceAddParams contentIndexServiceAddParams;
                ContentIndexService_Internal.ContentIndexServiceDeleteParams contentIndexServiceDeleteParams;
                ContentIndexService_Internal.ContentIndexServiceGetDescriptionsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ContentIndexService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        contentIndexServiceAddParams = ContentIndexService_Internal.ContentIndexServiceAddParams.deserialize(messageWithHeader.getPayload());
                        ((ContentIndexService)getImpl()).add(contentIndexServiceAddParams.serviceWorkerRegistrationId, contentIndexServiceAddParams.description, contentIndexServiceAddParams.icon, contentIndexServiceAddParams.launchUrl, new ContentIndexService_Internal.ContentIndexServiceAddResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        contentIndexServiceDeleteParams = ContentIndexService_Internal.ContentIndexServiceDeleteParams.deserialize(messageWithHeader.getPayload());
                        ((ContentIndexService)getImpl()).delete(contentIndexServiceDeleteParams.serviceWorkerRegistrationId, contentIndexServiceDeleteParams.id, new ContentIndexService_Internal.ContentIndexServiceDeleteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = ContentIndexService_Internal.ContentIndexServiceGetDescriptionsParams.deserialize(messageWithHeader.getPayload());
                        ((ContentIndexService)getImpl()).getDescriptions(data.serviceWorkerRegistrationId, new ContentIndexService_Internal.ContentIndexServiceGetDescriptionsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ContentIndexServiceAddParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public ContentDescription description;

        public Bitmap icon;

        public Url launchUrl;

        private ContentIndexServiceAddParams(int version) {
            super(40, version);
        }

        public ContentIndexServiceAddParams() {
            this(0);
        }

        public static ContentIndexServiceAddParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentIndexServiceAddParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentIndexServiceAddParams decode(Decoder decoder0) {
            ContentIndexServiceAddParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentIndexServiceAddParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.description = ContentDescription.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.icon = Bitmap.decode(decoder1);
                decoder1 = decoder0.readPointer(32, false);
                result.launchUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.description, 16, false);
            encoder0.encode((Struct)this.icon, 24, false);
            encoder0.encode((Struct)this.launchUrl, 32, false);
        }
    }

    static final class ContentIndexServiceAddResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private ContentIndexServiceAddResponseParams(int version) {
            super(16, version);
        }

        public ContentIndexServiceAddResponseParams() {
            this(0);
        }

        public static ContentIndexServiceAddResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentIndexServiceAddResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentIndexServiceAddResponseParams decode(Decoder decoder0) {
            ContentIndexServiceAddResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentIndexServiceAddResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ContentIndexError.validate(result.error);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    static class ContentIndexServiceAddResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentIndexService.AddResponse mCallback;

        ContentIndexServiceAddResponseParamsForwardToCallback(ContentIndexService.AddResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ContentIndexService_Internal.ContentIndexServiceAddResponseParams response = ContentIndexService_Internal.ContentIndexServiceAddResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentIndexServiceAddResponseParamsProxyToResponder implements ContentIndexService.AddResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentIndexServiceAddResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error) {
            ContentIndexService_Internal.ContentIndexServiceAddResponseParams _response = new ContentIndexService_Internal.ContentIndexServiceAddResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentIndexServiceDeleteParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public String id;

        private ContentIndexServiceDeleteParams(int version) {
            super(24, version);
        }

        public ContentIndexServiceDeleteParams() {
            this(0);
        }

        public static ContentIndexServiceDeleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentIndexServiceDeleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentIndexServiceDeleteParams decode(Decoder decoder0) {
            ContentIndexServiceDeleteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentIndexServiceDeleteParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                result.id = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.id, 16, false);
        }
    }

    static final class ContentIndexServiceDeleteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private ContentIndexServiceDeleteResponseParams(int version) {
            super(16, version);
        }

        public ContentIndexServiceDeleteResponseParams() {
            this(0);
        }

        public static ContentIndexServiceDeleteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentIndexServiceDeleteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentIndexServiceDeleteResponseParams decode(Decoder decoder0) {
            ContentIndexServiceDeleteResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentIndexServiceDeleteResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ContentIndexError.validate(result.error);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    static class ContentIndexServiceDeleteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentIndexService.DeleteResponse mCallback;

        ContentIndexServiceDeleteResponseParamsForwardToCallback(ContentIndexService.DeleteResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ContentIndexService_Internal.ContentIndexServiceDeleteResponseParams response = ContentIndexService_Internal.ContentIndexServiceDeleteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentIndexServiceDeleteResponseParamsProxyToResponder implements ContentIndexService.DeleteResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentIndexServiceDeleteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error) {
            ContentIndexService_Internal.ContentIndexServiceDeleteResponseParams _response = new ContentIndexService_Internal.ContentIndexServiceDeleteResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentIndexServiceGetDescriptionsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private ContentIndexServiceGetDescriptionsParams(int version) {
            super(16, version);
        }

        public ContentIndexServiceGetDescriptionsParams() {
            this(0);
        }

        public static ContentIndexServiceGetDescriptionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentIndexServiceGetDescriptionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentIndexServiceGetDescriptionsParams decode(Decoder decoder0) {
            ContentIndexServiceGetDescriptionsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentIndexServiceGetDescriptionsParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
        }
    }

    static final class ContentIndexServiceGetDescriptionsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public ContentDescription[] descriptions;

        private ContentIndexServiceGetDescriptionsResponseParams(int version) {
            super(24, version);
        }

        public ContentIndexServiceGetDescriptionsResponseParams() {
            this(0);
        }

        public static ContentIndexServiceGetDescriptionsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentIndexServiceGetDescriptionsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentIndexServiceGetDescriptionsResponseParams decode(Decoder decoder0) {
            ContentIndexServiceGetDescriptionsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentIndexServiceGetDescriptionsResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ContentIndexError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.descriptions = new ContentDescription[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.descriptions[i1] = ContentDescription.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            if (this.descriptions == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.descriptions.length, 16, -1);
                for (int i0 = 0; i0 < this.descriptions.length; i0++)
                    encoder1.encode(this.descriptions[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class ContentIndexServiceGetDescriptionsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentIndexService.GetDescriptionsResponse mCallback;

        ContentIndexServiceGetDescriptionsResponseParamsForwardToCallback(ContentIndexService.GetDescriptionsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ContentIndexService_Internal.ContentIndexServiceGetDescriptionsResponseParams response = ContentIndexService_Internal.ContentIndexServiceGetDescriptionsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.descriptions);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentIndexServiceGetDescriptionsResponseParamsProxyToResponder implements ContentIndexService.GetDescriptionsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentIndexServiceGetDescriptionsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, ContentDescription[] descriptions) {
            ContentIndexService_Internal.ContentIndexServiceGetDescriptionsResponseParams _response = new ContentIndexService_Internal.ContentIndexServiceGetDescriptionsResponseParams();
            _response.error = error.intValue();
            _response.descriptions = descriptions;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
