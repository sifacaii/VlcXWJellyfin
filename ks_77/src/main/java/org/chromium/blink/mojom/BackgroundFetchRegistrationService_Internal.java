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

class BackgroundFetchRegistrationService_Internal {
    public static final Interface.Manager<BackgroundFetchRegistrationService, BackgroundFetchRegistrationService.Proxy> MANAGER = new Interface.Manager<BackgroundFetchRegistrationService, BackgroundFetchRegistrationService.Proxy>() {
        public String getName() {
            return "blink.mojom.BackgroundFetchRegistrationService";
        }

        public int getVersion() {
            return 0;
        }

        public BackgroundFetchRegistrationService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BackgroundFetchRegistrationService_Internal.Proxy(core, messageReceiver);
        }

        public BackgroundFetchRegistrationService_Internal.Stub buildStub(Core core, BackgroundFetchRegistrationService impl) {
            return new BackgroundFetchRegistrationService_Internal.Stub(core, impl);
        }

        public BackgroundFetchRegistrationService[] buildArray(int size) {
            return new BackgroundFetchRegistrationService[size];
        }
    };

    private static final int UPDATE_UI_ORDINAL = 0;

    private static final int ABORT_ORDINAL = 1;

    private static final int MATCH_REQUESTS_ORDINAL = 2;

    private static final int ADD_REGISTRATION_OBSERVER_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements BackgroundFetchRegistrationService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void updateUi(String title, Bitmap icon, BackgroundFetchRegistrationService.UpdateUiResponse callback) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiParams _message = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiParams();
            _message.title = title;
            _message.icon = icon;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiResponseParamsForwardToCallback(callback));
        }

        public void abort(BackgroundFetchRegistrationService.AbortResponse callback) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortParams _message = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortResponseParamsForwardToCallback(callback));
        }

        public void matchRequests(FetchApiRequest requestToMatch, CacheQueryOptions cacheQueryOptions, boolean matchAll, BackgroundFetchRegistrationService.MatchRequestsResponse callback) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsParams _message = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsParams();
            _message.requestToMatch = requestToMatch;
            _message.cacheQueryOptions = cacheQueryOptions;
            _message.matchAll = matchAll;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsResponseParamsForwardToCallback(callback));
        }

        public void addRegistrationObserver(BackgroundFetchRegistrationObserver observer) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAddRegistrationObserverParams _message = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAddRegistrationObserverParams();
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<BackgroundFetchRegistrationService> {
        Stub(Core core, BackgroundFetchRegistrationService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAddRegistrationObserverParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BackgroundFetchRegistrationService_Internal.MANAGER, messageWithHeader);
                    case 3:
                        data = BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAddRegistrationObserverParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationService)getImpl()).addRegistrationObserver(data.observer);
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
                BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiParams backgroundFetchRegistrationServiceUpdateUiParams;
                BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BackgroundFetchRegistrationService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        backgroundFetchRegistrationServiceUpdateUiParams = BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationService)getImpl()).updateUi(backgroundFetchRegistrationServiceUpdateUiParams.title, backgroundFetchRegistrationServiceUpdateUiParams.icon, new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationService)getImpl()).abort(new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationService)getImpl()).matchRequests(data.requestToMatch, data.cacheQueryOptions, data.matchAll, new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BackgroundFetchRegistrationServiceUpdateUiParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String title;

        public Bitmap icon;

        private BackgroundFetchRegistrationServiceUpdateUiParams(int version) {
            super(24, version);
        }

        public BackgroundFetchRegistrationServiceUpdateUiParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceUpdateUiParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceUpdateUiParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceUpdateUiParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceUpdateUiParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceUpdateUiParams(elementsOrVersion);
                result.title = decoder0.readString(8, true);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.icon = Bitmap.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.title, 8, true);
            encoder0.encode((Struct)this.icon, 16, true);
        }
    }

    static final class BackgroundFetchRegistrationServiceUpdateUiResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private BackgroundFetchRegistrationServiceUpdateUiResponseParams(int version) {
            super(16, version);
        }

        public BackgroundFetchRegistrationServiceUpdateUiResponseParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceUpdateUiResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceUpdateUiResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceUpdateUiResponseParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceUpdateUiResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceUpdateUiResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                BackgroundFetchError.validate(result.error);
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

    static class BackgroundFetchRegistrationServiceUpdateUiResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchRegistrationService.UpdateUiResponse mCallback;

        BackgroundFetchRegistrationServiceUpdateUiResponseParamsForwardToCallback(BackgroundFetchRegistrationService.UpdateUiResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiResponseParams response = BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchRegistrationServiceUpdateUiResponseParamsProxyToResponder implements BackgroundFetchRegistrationService.UpdateUiResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchRegistrationServiceUpdateUiResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiResponseParams _response = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceUpdateUiResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BackgroundFetchRegistrationServiceAbortParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BackgroundFetchRegistrationServiceAbortParams(int version) {
            super(8, version);
        }

        public BackgroundFetchRegistrationServiceAbortParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceAbortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceAbortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceAbortParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceAbortParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceAbortParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BackgroundFetchRegistrationServiceAbortResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        private BackgroundFetchRegistrationServiceAbortResponseParams(int version) {
            super(16, version);
        }

        public BackgroundFetchRegistrationServiceAbortResponseParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceAbortResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceAbortResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceAbortResponseParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceAbortResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceAbortResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                BackgroundFetchError.validate(result.error);
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

    static class BackgroundFetchRegistrationServiceAbortResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchRegistrationService.AbortResponse mCallback;

        BackgroundFetchRegistrationServiceAbortResponseParamsForwardToCallback(BackgroundFetchRegistrationService.AbortResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortResponseParams response = BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchRegistrationServiceAbortResponseParamsProxyToResponder implements BackgroundFetchRegistrationService.AbortResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchRegistrationServiceAbortResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortResponseParams _response = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceAbortResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BackgroundFetchRegistrationServiceMatchRequestsParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiRequest requestToMatch;

        public CacheQueryOptions cacheQueryOptions;

        public boolean matchAll;

        private BackgroundFetchRegistrationServiceMatchRequestsParams(int version) {
            super(32, version);
        }

        public BackgroundFetchRegistrationServiceMatchRequestsParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceMatchRequestsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceMatchRequestsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceMatchRequestsParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceMatchRequestsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceMatchRequestsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.requestToMatch = FetchApiRequest.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.cacheQueryOptions = CacheQueryOptions.decode(decoder1);
                result.matchAll = decoder0.readBoolean(24, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.requestToMatch, 8, true);
            encoder0.encode(this.cacheQueryOptions, 16, true);
            encoder0.encode(this.matchAll, 24, 0);
        }
    }

    static final class BackgroundFetchRegistrationServiceMatchRequestsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundFetchSettledFetch[] fetches;

        private BackgroundFetchRegistrationServiceMatchRequestsResponseParams(int version) {
            super(16, version);
        }

        public BackgroundFetchRegistrationServiceMatchRequestsResponseParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceMatchRequestsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceMatchRequestsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceMatchRequestsResponseParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceMatchRequestsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceMatchRequestsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.fetches = new BackgroundFetchSettledFetch[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.fetches[i1] = BackgroundFetchSettledFetch.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.fetches == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.fetches.length, 8, -1);
                for (int i0 = 0; i0 < this.fetches.length; i0++)
                    encoder1.encode(this.fetches[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class BackgroundFetchRegistrationServiceMatchRequestsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BackgroundFetchRegistrationService.MatchRequestsResponse mCallback;

        BackgroundFetchRegistrationServiceMatchRequestsResponseParamsForwardToCallback(BackgroundFetchRegistrationService.MatchRequestsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsResponseParams response = BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.fetches);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BackgroundFetchRegistrationServiceMatchRequestsResponseParamsProxyToResponder implements BackgroundFetchRegistrationService.MatchRequestsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BackgroundFetchRegistrationServiceMatchRequestsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(BackgroundFetchSettledFetch[] fetches) {
            BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsResponseParams _response = new BackgroundFetchRegistrationService_Internal.BackgroundFetchRegistrationServiceMatchRequestsResponseParams();
            _response.fetches = fetches;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class BackgroundFetchRegistrationServiceAddRegistrationObserverParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundFetchRegistrationObserver observer;

        private BackgroundFetchRegistrationServiceAddRegistrationObserverParams(int version) {
            super(16, version);
        }

        public BackgroundFetchRegistrationServiceAddRegistrationObserverParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationServiceAddRegistrationObserverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationServiceAddRegistrationObserverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationServiceAddRegistrationObserverParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationServiceAddRegistrationObserverParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationServiceAddRegistrationObserverParams(elementsOrVersion);
                result.observer = (BackgroundFetchRegistrationObserver)decoder0.readServiceInterface(8, false, BackgroundFetchRegistrationObserver.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.observer, 8, false, BackgroundFetchRegistrationObserver.MANAGER);
        }
    }
}
