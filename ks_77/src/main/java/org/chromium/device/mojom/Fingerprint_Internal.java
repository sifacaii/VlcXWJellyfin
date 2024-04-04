package org.chromium.device.mojom;

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

class Fingerprint_Internal {
    public static final Interface.Manager<Fingerprint, Fingerprint.Proxy> MANAGER = new Interface.Manager<Fingerprint, Fingerprint.Proxy>() {
        public String getName() {
            return "device.mojom.Fingerprint";
        }

        public int getVersion() {
            return 0;
        }

        public Fingerprint_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Fingerprint_Internal.Proxy(core, messageReceiver);
        }

        public Fingerprint_Internal.Stub buildStub(Core core, Fingerprint impl) {
            return new Fingerprint_Internal.Stub(core, impl);
        }

        public Fingerprint[] buildArray(int size) {
            return new Fingerprint[size];
        }
    };

    private static final int GET_RECORDS_FOR_USER_ORDINAL = 0;

    private static final int START_ENROLL_SESSION_ORDINAL = 1;

    private static final int CANCEL_CURRENT_ENROLL_SESSION_ORDINAL = 2;

    private static final int REQUEST_RECORD_LABEL_ORDINAL = 3;

    private static final int SET_RECORD_LABEL_ORDINAL = 4;

    private static final int REMOVE_RECORD_ORDINAL = 5;

    private static final int START_AUTH_SESSION_ORDINAL = 6;

    private static final int END_CURRENT_AUTH_SESSION_ORDINAL = 7;

    private static final int DESTROY_ALL_RECORDS_ORDINAL = 8;

    private static final int ADD_FINGERPRINT_OBSERVER_ORDINAL = 9;

    private static final int REQUEST_TYPE_ORDINAL = 10;

    static final class Proxy extends Interface.AbstractProxy implements Fingerprint.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getRecordsForUser(String userId, Fingerprint.GetRecordsForUserResponse callback) {
            Fingerprint_Internal.FingerprintGetRecordsForUserParams _message = new Fingerprint_Internal.FingerprintGetRecordsForUserParams();
            _message.userId = userId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new Fingerprint_Internal.FingerprintGetRecordsForUserResponseParamsForwardToCallback(callback));
        }

        public void startEnrollSession(String userId, String label) {
            Fingerprint_Internal.FingerprintStartEnrollSessionParams _message = new Fingerprint_Internal.FingerprintStartEnrollSessionParams();
            _message.userId = userId;
            _message.label = label;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void cancelCurrentEnrollSession(Fingerprint.CancelCurrentEnrollSessionResponse callback) {
            Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionParams _message = new Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionResponseParamsForwardToCallback(callback));
        }

        public void requestRecordLabel(String recordPath, Fingerprint.RequestRecordLabelResponse callback) {
            Fingerprint_Internal.FingerprintRequestRecordLabelParams _message = new Fingerprint_Internal.FingerprintRequestRecordLabelParams();
            _message.recordPath = recordPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new Fingerprint_Internal.FingerprintRequestRecordLabelResponseParamsForwardToCallback(callback));
        }

        public void setRecordLabel(String recordPath, String newLabel, Fingerprint.SetRecordLabelResponse callback) {
            Fingerprint_Internal.FingerprintSetRecordLabelParams _message = new Fingerprint_Internal.FingerprintSetRecordLabelParams();
            _message.recordPath = recordPath;
            _message.newLabel = newLabel;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new Fingerprint_Internal.FingerprintSetRecordLabelResponseParamsForwardToCallback(callback));
        }

        public void removeRecord(String recordPath, Fingerprint.RemoveRecordResponse callback) {
            Fingerprint_Internal.FingerprintRemoveRecordParams _message = new Fingerprint_Internal.FingerprintRemoveRecordParams();
            _message.recordPath = recordPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new Fingerprint_Internal.FingerprintRemoveRecordResponseParamsForwardToCallback(callback));
        }

        public void startAuthSession() {
            Fingerprint_Internal.FingerprintStartAuthSessionParams _message = new Fingerprint_Internal.FingerprintStartAuthSessionParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void endCurrentAuthSession(Fingerprint.EndCurrentAuthSessionResponse callback) {
            Fingerprint_Internal.FingerprintEndCurrentAuthSessionParams _message = new Fingerprint_Internal.FingerprintEndCurrentAuthSessionParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new Fingerprint_Internal.FingerprintEndCurrentAuthSessionResponseParamsForwardToCallback(callback));
        }

        public void destroyAllRecords(Fingerprint.DestroyAllRecordsResponse callback) {
            Fingerprint_Internal.FingerprintDestroyAllRecordsParams _message = new Fingerprint_Internal.FingerprintDestroyAllRecordsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new Fingerprint_Internal.FingerprintDestroyAllRecordsResponseParamsForwardToCallback(callback));
        }

        public void addFingerprintObserver(FingerprintObserver observer) {
            Fingerprint_Internal.FingerprintAddFingerprintObserverParams _message = new Fingerprint_Internal.FingerprintAddFingerprintObserverParams();
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9)));
        }

        public void requestType(Fingerprint.RequestTypeResponse callback) {
            Fingerprint_Internal.FingerprintRequestTypeParams _message = new Fingerprint_Internal.FingerprintRequestTypeParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new Fingerprint_Internal.FingerprintRequestTypeResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<Fingerprint> {
        Stub(Core core, Fingerprint impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Fingerprint_Internal.FingerprintStartEnrollSessionParams fingerprintStartEnrollSessionParams;
                Fingerprint_Internal.FingerprintAddFingerprintObserverParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Fingerprint_Internal.MANAGER, messageWithHeader);
                    case 1:
                        fingerprintStartEnrollSessionParams = Fingerprint_Internal.FingerprintStartEnrollSessionParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).startEnrollSession(fingerprintStartEnrollSessionParams.userId, fingerprintStartEnrollSessionParams.label);
                        return true;
                    case 6:
                        Fingerprint_Internal.FingerprintStartAuthSessionParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).startAuthSession();
                        return true;
                    case 9:
                        data = Fingerprint_Internal.FingerprintAddFingerprintObserverParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).addFingerprintObserver(data.observer);
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
                Fingerprint_Internal.FingerprintGetRecordsForUserParams fingerprintGetRecordsForUserParams;
                Fingerprint_Internal.FingerprintRequestRecordLabelParams fingerprintRequestRecordLabelParams;
                Fingerprint_Internal.FingerprintSetRecordLabelParams fingerprintSetRecordLabelParams;
                Fingerprint_Internal.FingerprintRemoveRecordParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Fingerprint_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        fingerprintGetRecordsForUserParams = Fingerprint_Internal.FingerprintGetRecordsForUserParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).getRecordsForUser(fingerprintGetRecordsForUserParams.userId, new Fingerprint_Internal.FingerprintGetRecordsForUserResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).cancelCurrentEnrollSession(new Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        fingerprintRequestRecordLabelParams = Fingerprint_Internal.FingerprintRequestRecordLabelParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).requestRecordLabel(fingerprintRequestRecordLabelParams.recordPath, new Fingerprint_Internal.FingerprintRequestRecordLabelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        fingerprintSetRecordLabelParams = Fingerprint_Internal.FingerprintSetRecordLabelParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).setRecordLabel(fingerprintSetRecordLabelParams.recordPath, fingerprintSetRecordLabelParams.newLabel, new Fingerprint_Internal.FingerprintSetRecordLabelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        data = Fingerprint_Internal.FingerprintRemoveRecordParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).removeRecord(data.recordPath, new Fingerprint_Internal.FingerprintRemoveRecordResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        Fingerprint_Internal.FingerprintEndCurrentAuthSessionParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).endCurrentAuthSession(new Fingerprint_Internal.FingerprintEndCurrentAuthSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        Fingerprint_Internal.FingerprintDestroyAllRecordsParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).destroyAllRecords(new Fingerprint_Internal.FingerprintDestroyAllRecordsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        Fingerprint_Internal.FingerprintRequestTypeParams.deserialize(messageWithHeader.getPayload());
                        ((Fingerprint)getImpl()).requestType(new Fingerprint_Internal.FingerprintRequestTypeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FingerprintGetRecordsForUserParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String userId;

        private FingerprintGetRecordsForUserParams(int version) {
            super(16, version);
        }

        public FingerprintGetRecordsForUserParams() {
            this(0);
        }

        public static FingerprintGetRecordsForUserParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintGetRecordsForUserParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintGetRecordsForUserParams decode(Decoder decoder0) {
            FingerprintGetRecordsForUserParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintGetRecordsForUserParams(elementsOrVersion);
                result.userId = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.userId, 8, false);
        }
    }

    static final class FingerprintGetRecordsForUserResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Map<String, String> records;

        private FingerprintGetRecordsForUserResponseParams(int version) {
            super(16, version);
        }

        public FingerprintGetRecordsForUserResponseParams() {
            this(0);
        }

        public static FingerprintGetRecordsForUserResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintGetRecordsForUserResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintGetRecordsForUserResponseParams decode(Decoder decoder0) {
            FingerprintGetRecordsForUserResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintGetRecordsForUserResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                decoder1.readDataHeaderForMap();
                Decoder decoder2 = decoder1.readPointer(8, false);
                DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
                String[] keys0 = new String[si2.elementsOrVersion];
                int i2;
                for (i2 = 0; i2 < si2.elementsOrVersion; i2++)
                    keys0[i2] = decoder2.readString(8 + 8 * i2, false);
                decoder2 = decoder1.readPointer(16, false);
                si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
                String[] values0 = new String[si2.elementsOrVersion];
                for (i2 = 0; i2 < si2.elementsOrVersion; i2++)
                    values0[i2] = decoder2.readString(8 + 8 * i2, false);
                result.records = new HashMap<>();
                for (int index0 = 0; index0 < keys0.length; index0++)
                    result.records.put(keys0[index0], values0[index0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.records == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encoderForMap(8);
                int size0 = this.records.size();
                String[] keys0 = new String[size0];
                String[] values0 = new String[size0];
                int index0 = 0;
                for (Map.Entry<String, String> entry0 : this.records.entrySet()) {
                    keys0[index0] = entry0.getKey();
                    values0[index0] = entry0.getValue();
                    index0++;
                }
                Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
                int i1;
                for (i1 = 0; i1 < keys0.length; i1++)
                    encoder2.encode(keys0[i1], 8 + 8 * i1, false);
                encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
                for (i1 = 0; i1 < values0.length; i1++)
                    encoder2.encode(values0[i1], 8 + 8 * i1, false);
            }
        }
    }

    static class FingerprintGetRecordsForUserResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.GetRecordsForUserResponse mCallback;

        FingerprintGetRecordsForUserResponseParamsForwardToCallback(Fingerprint.GetRecordsForUserResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                Fingerprint_Internal.FingerprintGetRecordsForUserResponseParams response = Fingerprint_Internal.FingerprintGetRecordsForUserResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.records);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintGetRecordsForUserResponseParamsProxyToResponder implements Fingerprint.GetRecordsForUserResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintGetRecordsForUserResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Map<String, String> records) {
            Fingerprint_Internal.FingerprintGetRecordsForUserResponseParams _response = new Fingerprint_Internal.FingerprintGetRecordsForUserResponseParams();
            _response.records = records;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintStartEnrollSessionParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String userId;

        public String label;

        private FingerprintStartEnrollSessionParams(int version) {
            super(24, version);
        }

        public FingerprintStartEnrollSessionParams() {
            this(0);
        }

        public static FingerprintStartEnrollSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintStartEnrollSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintStartEnrollSessionParams decode(Decoder decoder0) {
            FingerprintStartEnrollSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintStartEnrollSessionParams(elementsOrVersion);
                result.userId = decoder0.readString(8, false);
                result.label = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.userId, 8, false);
            encoder0.encode(this.label, 16, false);
        }
    }

    static final class FingerprintCancelCurrentEnrollSessionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintCancelCurrentEnrollSessionParams(int version) {
            super(8, version);
        }

        public FingerprintCancelCurrentEnrollSessionParams() {
            this(0);
        }

        public static FingerprintCancelCurrentEnrollSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintCancelCurrentEnrollSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintCancelCurrentEnrollSessionParams decode(Decoder decoder0) {
            FingerprintCancelCurrentEnrollSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintCancelCurrentEnrollSessionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FingerprintCancelCurrentEnrollSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private FingerprintCancelCurrentEnrollSessionResponseParams(int version) {
            super(16, version);
        }

        public FingerprintCancelCurrentEnrollSessionResponseParams() {
            this(0);
        }

        public static FingerprintCancelCurrentEnrollSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintCancelCurrentEnrollSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintCancelCurrentEnrollSessionResponseParams decode(Decoder decoder0) {
            FingerprintCancelCurrentEnrollSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintCancelCurrentEnrollSessionResponseParams(elementsOrVersion);
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

    static class FingerprintCancelCurrentEnrollSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.CancelCurrentEnrollSessionResponse mCallback;

        FingerprintCancelCurrentEnrollSessionResponseParamsForwardToCallback(Fingerprint.CancelCurrentEnrollSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionResponseParams response = Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintCancelCurrentEnrollSessionResponseParamsProxyToResponder implements Fingerprint.CancelCurrentEnrollSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintCancelCurrentEnrollSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionResponseParams _response = new Fingerprint_Internal.FingerprintCancelCurrentEnrollSessionResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintRequestRecordLabelParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String recordPath;

        private FingerprintRequestRecordLabelParams(int version) {
            super(16, version);
        }

        public FingerprintRequestRecordLabelParams() {
            this(0);
        }

        public static FingerprintRequestRecordLabelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintRequestRecordLabelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintRequestRecordLabelParams decode(Decoder decoder0) {
            FingerprintRequestRecordLabelParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintRequestRecordLabelParams(elementsOrVersion);
                result.recordPath = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.recordPath, 8, false);
        }
    }

    static final class FingerprintRequestRecordLabelResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String label;

        private FingerprintRequestRecordLabelResponseParams(int version) {
            super(16, version);
        }

        public FingerprintRequestRecordLabelResponseParams() {
            this(0);
        }

        public static FingerprintRequestRecordLabelResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintRequestRecordLabelResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintRequestRecordLabelResponseParams decode(Decoder decoder0) {
            FingerprintRequestRecordLabelResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintRequestRecordLabelResponseParams(elementsOrVersion);
                result.label = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.label, 8, false);
        }
    }

    static class FingerprintRequestRecordLabelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.RequestRecordLabelResponse mCallback;

        FingerprintRequestRecordLabelResponseParamsForwardToCallback(Fingerprint.RequestRecordLabelResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                Fingerprint_Internal.FingerprintRequestRecordLabelResponseParams response = Fingerprint_Internal.FingerprintRequestRecordLabelResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.label);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintRequestRecordLabelResponseParamsProxyToResponder implements Fingerprint.RequestRecordLabelResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintRequestRecordLabelResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String label) {
            Fingerprint_Internal.FingerprintRequestRecordLabelResponseParams _response = new Fingerprint_Internal.FingerprintRequestRecordLabelResponseParams();
            _response.label = label;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintSetRecordLabelParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String recordPath;

        public String newLabel;

        private FingerprintSetRecordLabelParams(int version) {
            super(24, version);
        }

        public FingerprintSetRecordLabelParams() {
            this(0);
        }

        public static FingerprintSetRecordLabelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintSetRecordLabelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintSetRecordLabelParams decode(Decoder decoder0) {
            FingerprintSetRecordLabelParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintSetRecordLabelParams(elementsOrVersion);
                result.recordPath = decoder0.readString(8, false);
                result.newLabel = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.recordPath, 8, false);
            encoder0.encode(this.newLabel, 16, false);
        }
    }

    static final class FingerprintSetRecordLabelResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private FingerprintSetRecordLabelResponseParams(int version) {
            super(16, version);
        }

        public FingerprintSetRecordLabelResponseParams() {
            this(0);
        }

        public static FingerprintSetRecordLabelResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintSetRecordLabelResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintSetRecordLabelResponseParams decode(Decoder decoder0) {
            FingerprintSetRecordLabelResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintSetRecordLabelResponseParams(elementsOrVersion);
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

    static class FingerprintSetRecordLabelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.SetRecordLabelResponse mCallback;

        FingerprintSetRecordLabelResponseParamsForwardToCallback(Fingerprint.SetRecordLabelResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                Fingerprint_Internal.FingerprintSetRecordLabelResponseParams response = Fingerprint_Internal.FingerprintSetRecordLabelResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintSetRecordLabelResponseParamsProxyToResponder implements Fingerprint.SetRecordLabelResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintSetRecordLabelResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Fingerprint_Internal.FingerprintSetRecordLabelResponseParams _response = new Fingerprint_Internal.FingerprintSetRecordLabelResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintRemoveRecordParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String recordPath;

        private FingerprintRemoveRecordParams(int version) {
            super(16, version);
        }

        public FingerprintRemoveRecordParams() {
            this(0);
        }

        public static FingerprintRemoveRecordParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintRemoveRecordParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintRemoveRecordParams decode(Decoder decoder0) {
            FingerprintRemoveRecordParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintRemoveRecordParams(elementsOrVersion);
                result.recordPath = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.recordPath, 8, false);
        }
    }

    static final class FingerprintRemoveRecordResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private FingerprintRemoveRecordResponseParams(int version) {
            super(16, version);
        }

        public FingerprintRemoveRecordResponseParams() {
            this(0);
        }

        public static FingerprintRemoveRecordResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintRemoveRecordResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintRemoveRecordResponseParams decode(Decoder decoder0) {
            FingerprintRemoveRecordResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintRemoveRecordResponseParams(elementsOrVersion);
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

    static class FingerprintRemoveRecordResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.RemoveRecordResponse mCallback;

        FingerprintRemoveRecordResponseParamsForwardToCallback(Fingerprint.RemoveRecordResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                Fingerprint_Internal.FingerprintRemoveRecordResponseParams response = Fingerprint_Internal.FingerprintRemoveRecordResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintRemoveRecordResponseParamsProxyToResponder implements Fingerprint.RemoveRecordResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintRemoveRecordResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Fingerprint_Internal.FingerprintRemoveRecordResponseParams _response = new Fingerprint_Internal.FingerprintRemoveRecordResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintStartAuthSessionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintStartAuthSessionParams(int version) {
            super(8, version);
        }

        public FingerprintStartAuthSessionParams() {
            this(0);
        }

        public static FingerprintStartAuthSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintStartAuthSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintStartAuthSessionParams decode(Decoder decoder0) {
            FingerprintStartAuthSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintStartAuthSessionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FingerprintEndCurrentAuthSessionParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintEndCurrentAuthSessionParams(int version) {
            super(8, version);
        }

        public FingerprintEndCurrentAuthSessionParams() {
            this(0);
        }

        public static FingerprintEndCurrentAuthSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintEndCurrentAuthSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintEndCurrentAuthSessionParams decode(Decoder decoder0) {
            FingerprintEndCurrentAuthSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintEndCurrentAuthSessionParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FingerprintEndCurrentAuthSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private FingerprintEndCurrentAuthSessionResponseParams(int version) {
            super(16, version);
        }

        public FingerprintEndCurrentAuthSessionResponseParams() {
            this(0);
        }

        public static FingerprintEndCurrentAuthSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintEndCurrentAuthSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintEndCurrentAuthSessionResponseParams decode(Decoder decoder0) {
            FingerprintEndCurrentAuthSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintEndCurrentAuthSessionResponseParams(elementsOrVersion);
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

    static class FingerprintEndCurrentAuthSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.EndCurrentAuthSessionResponse mCallback;

        FingerprintEndCurrentAuthSessionResponseParamsForwardToCallback(Fingerprint.EndCurrentAuthSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                Fingerprint_Internal.FingerprintEndCurrentAuthSessionResponseParams response = Fingerprint_Internal.FingerprintEndCurrentAuthSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintEndCurrentAuthSessionResponseParamsProxyToResponder implements Fingerprint.EndCurrentAuthSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintEndCurrentAuthSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Fingerprint_Internal.FingerprintEndCurrentAuthSessionResponseParams _response = new Fingerprint_Internal.FingerprintEndCurrentAuthSessionResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintDestroyAllRecordsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintDestroyAllRecordsParams(int version) {
            super(8, version);
        }

        public FingerprintDestroyAllRecordsParams() {
            this(0);
        }

        public static FingerprintDestroyAllRecordsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintDestroyAllRecordsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintDestroyAllRecordsParams decode(Decoder decoder0) {
            FingerprintDestroyAllRecordsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintDestroyAllRecordsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FingerprintDestroyAllRecordsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private FingerprintDestroyAllRecordsResponseParams(int version) {
            super(16, version);
        }

        public FingerprintDestroyAllRecordsResponseParams() {
            this(0);
        }

        public static FingerprintDestroyAllRecordsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintDestroyAllRecordsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintDestroyAllRecordsResponseParams decode(Decoder decoder0) {
            FingerprintDestroyAllRecordsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintDestroyAllRecordsResponseParams(elementsOrVersion);
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

    static class FingerprintDestroyAllRecordsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.DestroyAllRecordsResponse mCallback;

        FingerprintDestroyAllRecordsResponseParamsForwardToCallback(Fingerprint.DestroyAllRecordsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2))
                    return false;
                Fingerprint_Internal.FingerprintDestroyAllRecordsResponseParams response = Fingerprint_Internal.FingerprintDestroyAllRecordsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintDestroyAllRecordsResponseParamsProxyToResponder implements Fingerprint.DestroyAllRecordsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintDestroyAllRecordsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Fingerprint_Internal.FingerprintDestroyAllRecordsResponseParams _response = new Fingerprint_Internal.FingerprintDestroyAllRecordsResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FingerprintAddFingerprintObserverParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FingerprintObserver observer;

        private FingerprintAddFingerprintObserverParams(int version) {
            super(16, version);
        }

        public FingerprintAddFingerprintObserverParams() {
            this(0);
        }

        public static FingerprintAddFingerprintObserverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintAddFingerprintObserverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintAddFingerprintObserverParams decode(Decoder decoder0) {
            FingerprintAddFingerprintObserverParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintAddFingerprintObserverParams(elementsOrVersion);
                result.observer = (FingerprintObserver)decoder0.readServiceInterface(8, false, FingerprintObserver.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.observer, 8, false, FingerprintObserver.MANAGER);
        }
    }

    static final class FingerprintRequestTypeParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FingerprintRequestTypeParams(int version) {
            super(8, version);
        }

        public FingerprintRequestTypeParams() {
            this(0);
        }

        public static FingerprintRequestTypeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintRequestTypeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintRequestTypeParams decode(Decoder decoder0) {
            FingerprintRequestTypeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintRequestTypeParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FingerprintRequestTypeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int type;

        private FingerprintRequestTypeResponseParams(int version) {
            super(16, version);
        }

        public FingerprintRequestTypeResponseParams() {
            this(0);
        }

        public static FingerprintRequestTypeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FingerprintRequestTypeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FingerprintRequestTypeResponseParams decode(Decoder decoder0) {
            FingerprintRequestTypeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FingerprintRequestTypeResponseParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                BiometricType.validate(result.type);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.type, 8);
        }
    }

    static class FingerprintRequestTypeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Fingerprint.RequestTypeResponse mCallback;

        FingerprintRequestTypeResponseParamsForwardToCallback(Fingerprint.RequestTypeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2))
                    return false;
                Fingerprint_Internal.FingerprintRequestTypeResponseParams response = Fingerprint_Internal.FingerprintRequestTypeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.type));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FingerprintRequestTypeResponseParamsProxyToResponder implements Fingerprint.RequestTypeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FingerprintRequestTypeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer type) {
            Fingerprint_Internal.FingerprintRequestTypeResponseParams _response = new Fingerprint_Internal.FingerprintRequestTypeResponseParams();
            _response.type = type.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
