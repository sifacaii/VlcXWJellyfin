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

class BackgroundFetchService_Internal {
    public static final Interface.Manager<BackgroundFetchService, BackgroundFetchService.Proxy> MANAGER = new Interface.Manager<BackgroundFetchService, BackgroundFetchService.Proxy>() {
        public String getName() {
            return "blink.mojom.BackgroundFetchService";
        }

        public int getVersion() {
            return 0;
        }

        public BackgroundFetchService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BackgroundFetchService_Internal.Proxy(core, messageReceiver);
        }

        public BackgroundFetchService_Internal.Stub buildStub(Core core, BackgroundFetchService impl) {
            return new BackgroundFetchService_Internal.Stub(core, impl);
        }

        public BackgroundFetchService[] buildArray(int size) {
            return new BackgroundFetchService[size];
        }
    };

    private static final int FETCH_ORDINAL = 0;

    private static final int GET_REGISTRATION_ORDINAL = 1;

    private static final int GET_DEVELOPER_IDS_ORDINAL = 2;

    private static final int GET_ICON_DISPLAY_SIZE_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements BackgroundFetchService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void fetch(long serviceWorkerRegistrationId, String developerId, FetchApiRequest[] requests, BackgroundFetchOptions options, Bitmap icon, BackgroundFetchUkmData ukmData, BackgroundFetchService.FetchResponse callback) {
            BackgroundFetchService_Internal.BackgroundFetchServiceFetchParams _message = new BackgroundFetchService_Internal.BackgroundFetchServiceFetchParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.developerId = developerId;
            _message.requests = requests;
            _message.options = options;
            _message.icon = icon;
            _message.ukmData = ukmData;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BackgroundFetchService_Internal.BackgroundFetchServiceFetchResponseParamsForwardToCallback(callback));
        }

        public void getRegistration(long serviceWorkerRegistrationId, String developerId, BackgroundFetchService.GetRegistrationResponse callback) {
            BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationParams _message = new BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.developerId = developerId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationResponseParamsForwardToCallback(callback));
        }

        public void getDeveloperIds(long serviceWorkerRegistrationId, BackgroundFetchService.GetDeveloperIdsResponse callback) {
            BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsParams _message = new BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsResponseParamsForwardToCallback(callback));
        }

        public void getIconDisplaySize(BackgroundFetchService.GetIconDisplaySizeResponse callback) {
            BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeParams _message = new BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<BackgroundFetchService> {
        Stub(Core core, BackgroundFetchService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BackgroundFetchService_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                BackgroundFetchService_Internal.BackgroundFetchServiceFetchParams backgroundFetchServiceFetchParams;
                BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationParams backgroundFetchServiceGetRegistrationParams;
                BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BackgroundFetchService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        backgroundFetchServiceFetchParams = BackgroundFetchService_Internal.BackgroundFetchServiceFetchParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchService)getImpl()).fetch(backgroundFetchServiceFetchParams.serviceWorkerRegistrationId, backgroundFetchServiceFetchParams.developerId, backgroundFetchServiceFetchParams.requests, backgroundFetchServiceFetchParams.options, backgroundFetchServiceFetchParams.icon, backgroundFetchServiceFetchParams.ukmData, new BackgroundFetchService_Internal.BackgroundFetchServiceFetchResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        backgroundFetchServiceGetRegistrationParams = BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchService)getImpl()).getRegistration(backgroundFetchServiceGetRegistrationParams.serviceWorkerRegistrationId, backgroundFetchServiceGetRegistrationParams.developerId, new BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchService)getImpl()).getDeveloperIds(data.serviceWorkerRegistrationId, new BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchService)getImpl()).getIconDisplaySize(new BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BackgroundFetchServiceFetchParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public String developerId;

        public FetchApiRequest[] requests;

        public BackgroundFetchOptions options;

        public Bitmap icon;

        public BackgroundFetchUkmData ukmData;

        private BackgroundFetchServiceFetchParams(int version) {
            super(56, version);
        }

        public BackgroundFetchServiceFetchParams() {
            this(0);
        }

        public static BackgroundFetchServiceFetchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceFetchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceFetchParams decode(Decoder decoder0) {
            BackgroundFetchServiceFetchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceFetchParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                result.developerId = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.requests = new FetchApiRequest[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.requests[i1] = FetchApiRequest.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(32, false);
                result.options = BackgroundFetchOptions.decode(decoder1);
                decoder1 = decoder0.readPointer(40, true);
                result.icon = Bitmap.decode(decoder1);
                decoder1 = decoder0.readPointer(48, false);
                result.ukmData = BackgroundFetchUkmData.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.developerId, 16, false);
            if (this.requests == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.requests.length, 24, -1);
                for (int i0 = 0; i0 < this.requests.length; i0++)
                    encoder1.encode(this.requests[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.options, 32, false);
            encoder0.encode((Struct)this.icon, 40, true);
            encoder0.encode(this.ukmData, 48, false);
        }
    }

    static final class BackgroundFetchServiceFetchResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public BackgroundFetchRegistration registration;

        private BackgroundFetchServiceFetchResponseParams(int version) {
            super(24, version);
        }

        public BackgroundFetchServiceFetchResponseParams() {
            this(0);
        }

        public static BackgroundFetchServiceFetchResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceFetchResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceFetchResponseParams decode(Decoder decoder0) {
            BackgroundFetchServiceFetchResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceFetchResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                BackgroundFetchError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.registration = BackgroundFetchRegistration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.registration, 16, true);
        }
    }

    static class BackgroundFetchServiceFetchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchService.FetchResponse mCallback;

        BackgroundFetchServiceFetchResponseParamsForwardToCallback(BackgroundFetchService.FetchResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                BackgroundFetchService_Internal.BackgroundFetchServiceFetchResponseParams response = BackgroundFetchService_Internal.BackgroundFetchServiceFetchResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.registration);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchServiceFetchResponseParamsProxyToResponder implements BackgroundFetchService.FetchResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchServiceFetchResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, BackgroundFetchRegistration registration) {
            BackgroundFetchService_Internal.BackgroundFetchServiceFetchResponseParams _response = new BackgroundFetchService_Internal.BackgroundFetchServiceFetchResponseParams();
            _response.error = error.intValue();
            _response.registration = registration;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BackgroundFetchServiceGetRegistrationParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public String developerId;

        private BackgroundFetchServiceGetRegistrationParams(int version) {
            super(24, version);
        }

        public BackgroundFetchServiceGetRegistrationParams() {
            this(0);
        }

        public static BackgroundFetchServiceGetRegistrationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceGetRegistrationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceGetRegistrationParams decode(Decoder decoder0) {
            BackgroundFetchServiceGetRegistrationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceGetRegistrationParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                result.developerId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.developerId, 16, false);
        }
    }

    static final class BackgroundFetchServiceGetRegistrationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public BackgroundFetchRegistration registration;

        private BackgroundFetchServiceGetRegistrationResponseParams(int version) {
            super(24, version);
        }

        public BackgroundFetchServiceGetRegistrationResponseParams() {
            this(0);
        }

        public static BackgroundFetchServiceGetRegistrationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceGetRegistrationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceGetRegistrationResponseParams decode(Decoder decoder0) {
            BackgroundFetchServiceGetRegistrationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceGetRegistrationResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                BackgroundFetchError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.registration = BackgroundFetchRegistration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.registration, 16, true);
        }
    }

    static class BackgroundFetchServiceGetRegistrationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchService.GetRegistrationResponse mCallback;

        BackgroundFetchServiceGetRegistrationResponseParamsForwardToCallback(BackgroundFetchService.GetRegistrationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationResponseParams response = BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.registration);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchServiceGetRegistrationResponseParamsProxyToResponder implements BackgroundFetchService.GetRegistrationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchServiceGetRegistrationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, BackgroundFetchRegistration registration) {
            BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationResponseParams _response = new BackgroundFetchService_Internal.BackgroundFetchServiceGetRegistrationResponseParams();
            _response.error = error.intValue();
            _response.registration = registration;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BackgroundFetchServiceGetDeveloperIdsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private BackgroundFetchServiceGetDeveloperIdsParams(int version) {
            super(16, version);
        }

        public BackgroundFetchServiceGetDeveloperIdsParams() {
            this(0);
        }

        public static BackgroundFetchServiceGetDeveloperIdsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceGetDeveloperIdsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceGetDeveloperIdsParams decode(Decoder decoder0) {
            BackgroundFetchServiceGetDeveloperIdsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceGetDeveloperIdsParams(elementsOrVersion);
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

    static final class BackgroundFetchServiceGetDeveloperIdsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String[] developerIds;

        private BackgroundFetchServiceGetDeveloperIdsResponseParams(int version) {
            super(24, version);
        }

        public BackgroundFetchServiceGetDeveloperIdsResponseParams() {
            this(0);
        }

        public static BackgroundFetchServiceGetDeveloperIdsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceGetDeveloperIdsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceGetDeveloperIdsResponseParams decode(Decoder decoder0) {
            BackgroundFetchServiceGetDeveloperIdsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceGetDeveloperIdsResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                BackgroundFetchError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.developerIds = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.developerIds[i1] = decoder1.readString(8 + 8 * i1, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            if (this.developerIds == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.developerIds.length, 16, -1);
                for (int i0 = 0; i0 < this.developerIds.length; i0++)
                    encoder1.encode(this.developerIds[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class BackgroundFetchServiceGetDeveloperIdsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchService.GetDeveloperIdsResponse mCallback;

        BackgroundFetchServiceGetDeveloperIdsResponseParamsForwardToCallback(BackgroundFetchService.GetDeveloperIdsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsResponseParams response = BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.developerIds);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchServiceGetDeveloperIdsResponseParamsProxyToResponder implements BackgroundFetchService.GetDeveloperIdsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchServiceGetDeveloperIdsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String[] developerIds) {
            BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsResponseParams _response = new BackgroundFetchService_Internal.BackgroundFetchServiceGetDeveloperIdsResponseParams();
            _response.error = error.intValue();
            _response.developerIds = developerIds;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BackgroundFetchServiceGetIconDisplaySizeParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BackgroundFetchServiceGetIconDisplaySizeParams(int version) {
            super(8, version);
        }

        public BackgroundFetchServiceGetIconDisplaySizeParams() {
            this(0);
        }

        public static BackgroundFetchServiceGetIconDisplaySizeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceGetIconDisplaySizeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceGetIconDisplaySizeParams decode(Decoder decoder0) {
            BackgroundFetchServiceGetIconDisplaySizeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceGetIconDisplaySizeParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BackgroundFetchServiceGetIconDisplaySizeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Size iconSizePixels;

        private BackgroundFetchServiceGetIconDisplaySizeResponseParams(int version) {
            super(16, version);
        }

        public BackgroundFetchServiceGetIconDisplaySizeResponseParams() {
            this(0);
        }

        public static BackgroundFetchServiceGetIconDisplaySizeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchServiceGetIconDisplaySizeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchServiceGetIconDisplaySizeResponseParams decode(Decoder decoder0) {
            BackgroundFetchServiceGetIconDisplaySizeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchServiceGetIconDisplaySizeResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.iconSizePixels = Size.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.iconSizePixels, 8, false);
        }
    }

    static class BackgroundFetchServiceGetIconDisplaySizeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchService.GetIconDisplaySizeResponse mCallback;

        BackgroundFetchServiceGetIconDisplaySizeResponseParamsForwardToCallback(BackgroundFetchService.GetIconDisplaySizeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeResponseParams response = BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.iconSizePixels);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchServiceGetIconDisplaySizeResponseParamsProxyToResponder implements BackgroundFetchService.GetIconDisplaySizeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchServiceGetIconDisplaySizeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Size iconSizePixels) {
            BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeResponseParams _response = new BackgroundFetchService_Internal.BackgroundFetchServiceGetIconDisplaySizeResponseParams();
            _response.iconSizePixels = iconSizePixels;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
