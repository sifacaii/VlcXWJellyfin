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

class BackgroundFetchRegistrationObserver_Internal {
    public static final Interface.Manager<BackgroundFetchRegistrationObserver, BackgroundFetchRegistrationObserver.Proxy> MANAGER = new Interface.Manager<BackgroundFetchRegistrationObserver, BackgroundFetchRegistrationObserver.Proxy>() {
        public String getName() {
            return "blink.mojom.BackgroundFetchRegistrationObserver";
        }

        public int getVersion() {
            return 0;
        }

        public BackgroundFetchRegistrationObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BackgroundFetchRegistrationObserver_Internal.Proxy(core, messageReceiver);
        }

        public BackgroundFetchRegistrationObserver_Internal.Stub buildStub(Core core, BackgroundFetchRegistrationObserver impl) {
            return new BackgroundFetchRegistrationObserver_Internal.Stub(core, impl);
        }

        public BackgroundFetchRegistrationObserver[] buildArray(int size) {
            return new BackgroundFetchRegistrationObserver[size];
        }
    };

    private static final int ON_PROGRESS_ORDINAL = 0;

    private static final int ON_RECORDS_UNAVAILABLE_ORDINAL = 1;

    private static final int ON_REQUEST_COMPLETED_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements BackgroundFetchRegistrationObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onProgress(long uploadTotal, long uploaded, long downloadTotal, long downloaded, int result, int failureReason) {
            BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnProgressParams _message = new BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnProgressParams();
            _message.uploadTotal = uploadTotal;
            _message.uploaded = uploaded;
            _message.downloadTotal = downloadTotal;
            _message.downloaded = downloaded;
            _message.result = result;
            _message.failureReason = failureReason;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onRecordsUnavailable() {
            BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRecordsUnavailableParams _message = new BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRecordsUnavailableParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onRequestCompleted(FetchApiRequest request, FetchApiResponse response) {
            BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRequestCompletedParams _message = new BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRequestCompletedParams();
            _message.request = request;
            _message.response = response;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<BackgroundFetchRegistrationObserver> {
        Stub(Core core, BackgroundFetchRegistrationObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnProgressParams backgroundFetchRegistrationObserverOnProgressParams;
                BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRequestCompletedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BackgroundFetchRegistrationObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        backgroundFetchRegistrationObserverOnProgressParams = BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnProgressParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationObserver)getImpl()).onProgress(backgroundFetchRegistrationObserverOnProgressParams.uploadTotal, backgroundFetchRegistrationObserverOnProgressParams.uploaded, backgroundFetchRegistrationObserverOnProgressParams.downloadTotal, backgroundFetchRegistrationObserverOnProgressParams.downloaded, backgroundFetchRegistrationObserverOnProgressParams.result, backgroundFetchRegistrationObserverOnProgressParams.failureReason);
                        return true;
                    case 1:
                        BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRecordsUnavailableParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationObserver)getImpl()).onRecordsUnavailable();
                        return true;
                    case 2:
                        data = BackgroundFetchRegistrationObserver_Internal.BackgroundFetchRegistrationObserverOnRequestCompletedParams.deserialize(messageWithHeader.getPayload());
                        ((BackgroundFetchRegistrationObserver)getImpl()).onRequestCompleted(data.request, data.response);
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
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), BackgroundFetchRegistrationObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BackgroundFetchRegistrationObserverOnProgressParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long uploadTotal;

        public long uploaded;

        public long downloadTotal;

        public long downloaded;

        public int result;

        public int failureReason;

        private BackgroundFetchRegistrationObserverOnProgressParams(int version) {
            super(48, version);
        }

        public BackgroundFetchRegistrationObserverOnProgressParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationObserverOnProgressParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationObserverOnProgressParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationObserverOnProgressParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationObserverOnProgressParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationObserverOnProgressParams(elementsOrVersion);
                result.uploadTotal = decoder0.readLong(8);
                result.uploaded = decoder0.readLong(16);
                result.downloadTotal = decoder0.readLong(24);
                result.downloaded = decoder0.readLong(32);
                result.result = decoder0.readInt(40);
                BackgroundFetchResult.validate(result.result);
                result.failureReason = decoder0.readInt(44);
                BackgroundFetchFailureReason.validate(result.failureReason);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.uploadTotal, 8);
            encoder0.encode(this.uploaded, 16);
            encoder0.encode(this.downloadTotal, 24);
            encoder0.encode(this.downloaded, 32);
            encoder0.encode(this.result, 40);
            encoder0.encode(this.failureReason, 44);
        }
    }

    static final class BackgroundFetchRegistrationObserverOnRecordsUnavailableParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BackgroundFetchRegistrationObserverOnRecordsUnavailableParams(int version) {
            super(8, version);
        }

        public BackgroundFetchRegistrationObserverOnRecordsUnavailableParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationObserverOnRecordsUnavailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationObserverOnRecordsUnavailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationObserverOnRecordsUnavailableParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationObserverOnRecordsUnavailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationObserverOnRecordsUnavailableParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BackgroundFetchRegistrationObserverOnRequestCompletedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiRequest request;

        public FetchApiResponse response;

        private BackgroundFetchRegistrationObserverOnRequestCompletedParams(int version) {
            super(24, version);
        }

        public BackgroundFetchRegistrationObserverOnRequestCompletedParams() {
            this(0);
        }

        public static BackgroundFetchRegistrationObserverOnRequestCompletedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BackgroundFetchRegistrationObserverOnRequestCompletedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BackgroundFetchRegistrationObserverOnRequestCompletedParams decode(Decoder decoder0) {
            BackgroundFetchRegistrationObserverOnRequestCompletedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BackgroundFetchRegistrationObserverOnRequestCompletedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.request = FetchApiRequest.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.response = FetchApiResponse.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.request, 8, false);
            encoder0.encode(this.response, 16, true);
        }
    }
}
