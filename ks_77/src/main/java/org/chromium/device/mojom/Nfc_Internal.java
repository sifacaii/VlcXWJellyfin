package org.chromium.device.mojom;

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

class Nfc_Internal {
    public static final Interface.Manager<Nfc, Nfc.Proxy> MANAGER = new Interface.Manager<Nfc, Nfc.Proxy>() {
        public String getName() {
            return "device.mojom.NFC";
        }

        public int getVersion() {
            return 0;
        }

        public Nfc_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Nfc_Internal.Proxy(core, messageReceiver);
        }

        public Nfc_Internal.Stub buildStub(Core core, Nfc impl) {
            return new Nfc_Internal.Stub(core, impl);
        }

        public Nfc[] buildArray(int size) {
            return new Nfc[size];
        }
    };

    private static final int SET_CLIENT_ORDINAL = 0;

    private static final int PUSH_ORDINAL = 1;

    private static final int CANCEL_PUSH_ORDINAL = 2;

    private static final int WATCH_ORDINAL = 3;

    private static final int CANCEL_WATCH_ORDINAL = 4;

    private static final int CANCEL_ALL_WATCHES_ORDINAL = 5;

    private static final int SUSPEND_NFC_OPERATIONS_ORDINAL = 6;

    private static final int RESUME_NFC_OPERATIONS_ORDINAL = 7;

    static final class Proxy extends Interface.AbstractProxy implements Nfc.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setClient(NfcClient client) {
            Nfc_Internal.NfcSetClientParams _message = new Nfc_Internal.NfcSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void push(NdefMessage message, NfcPushOptions options, Nfc.PushResponse callback) {
            Nfc_Internal.NfcPushParams _message = new Nfc_Internal.NfcPushParams();
            _message.message = message;
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new Nfc_Internal.NfcPushResponseParamsForwardToCallback(callback));
        }

        public void cancelPush(int target, Nfc.CancelPushResponse callback) {
            Nfc_Internal.NfcCancelPushParams _message = new Nfc_Internal.NfcCancelPushParams();
            _message.target = target;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new Nfc_Internal.NfcCancelPushResponseParamsForwardToCallback(callback));
        }

        public void watch(NfcReaderOptions options, Nfc.WatchResponse callback) {
            Nfc_Internal.NfcWatchParams _message = new Nfc_Internal.NfcWatchParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new Nfc_Internal.NfcWatchResponseParamsForwardToCallback(callback));
        }

        public void cancelWatch(int id, Nfc.CancelWatchResponse callback) {
            Nfc_Internal.NfcCancelWatchParams _message = new Nfc_Internal.NfcCancelWatchParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new Nfc_Internal.NfcCancelWatchResponseParamsForwardToCallback(callback));
        }

        public void cancelAllWatches(Nfc.CancelAllWatchesResponse callback) {
            Nfc_Internal.NfcCancelAllWatchesParams _message = new Nfc_Internal.NfcCancelAllWatchesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new Nfc_Internal.NfcCancelAllWatchesResponseParamsForwardToCallback(callback));
        }

        public void suspendNfcOperations() {
            Nfc_Internal.NfcSuspendNfcOperationsParams _message = new Nfc_Internal.NfcSuspendNfcOperationsParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void resumeNfcOperations() {
            Nfc_Internal.NfcResumeNfcOperationsParams _message = new Nfc_Internal.NfcResumeNfcOperationsParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }
    }

    static final class Stub extends Interface.Stub<Nfc> {
        Stub(Core core, Nfc impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Nfc_Internal.NfcSetClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Nfc_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = Nfc_Internal.NfcSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).setClient(data.client);
                        return true;
                    case 6:
                        Nfc_Internal.NfcSuspendNfcOperationsParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).suspendNfcOperations();
                        return true;
                    case 7:
                        Nfc_Internal.NfcResumeNfcOperationsParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).resumeNfcOperations();
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
                Nfc_Internal.NfcPushParams nfcPushParams;
                Nfc_Internal.NfcCancelPushParams nfcCancelPushParams;
                Nfc_Internal.NfcWatchParams nfcWatchParams;
                Nfc_Internal.NfcCancelWatchParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Nfc_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        nfcPushParams = Nfc_Internal.NfcPushParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).push(nfcPushParams.message, nfcPushParams.options, new Nfc_Internal.NfcPushResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        nfcCancelPushParams = Nfc_Internal.NfcCancelPushParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).cancelPush(nfcCancelPushParams.target, new Nfc_Internal.NfcCancelPushResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        nfcWatchParams = Nfc_Internal.NfcWatchParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).watch(nfcWatchParams.options, new Nfc_Internal.NfcWatchResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        data = Nfc_Internal.NfcCancelWatchParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).cancelWatch(data.id, new Nfc_Internal.NfcCancelWatchResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        Nfc_Internal.NfcCancelAllWatchesParams.deserialize(messageWithHeader.getPayload());
                        ((Nfc)getImpl()).cancelAllWatches(new Nfc_Internal.NfcCancelAllWatchesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NfcSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NfcClient client;

        private NfcSetClientParams(int version) {
            super(16, version);
        }

        public NfcSetClientParams() {
            this(0);
        }

        public static NfcSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcSetClientParams decode(Decoder decoder0) {
            NfcSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcSetClientParams(elementsOrVersion);
                result.client = (NfcClient)decoder0.readServiceInterface(8, false, NfcClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false, NfcClient.MANAGER);
        }
    }

    static final class NfcPushParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NdefMessage message;

        public NfcPushOptions options;

        private NfcPushParams(int version) {
            super(24, version);
        }

        public NfcPushParams() {
            this(0);
        }

        public static NfcPushParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcPushParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcPushParams decode(Decoder decoder0) {
            NfcPushParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcPushParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = NdefMessage.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.options = NfcPushOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
            encoder0.encode(this.options, 16, true);
        }
    }

    static final class NfcPushResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NfcError error;

        private NfcPushResponseParams(int version) {
            super(16, version);
        }

        public NfcPushResponseParams() {
            this(0);
        }

        public static NfcPushResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcPushResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcPushResponseParams decode(Decoder decoder0) {
            NfcPushResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcPushResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.error = NfcError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8, true);
        }
    }

    static class NfcPushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Nfc.PushResponse mCallback;

        NfcPushResponseParamsForwardToCallback(Nfc.PushResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                Nfc_Internal.NfcPushResponseParams response = Nfc_Internal.NfcPushResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NfcPushResponseParamsProxyToResponder implements Nfc.PushResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NfcPushResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NfcError error) {
            Nfc_Internal.NfcPushResponseParams _response = new Nfc_Internal.NfcPushResponseParams();
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NfcCancelPushParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int target;

        private NfcCancelPushParams(int version) {
            super(16, version);
        }

        public NfcCancelPushParams() {
            this(0);
        }

        public static NfcCancelPushParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcCancelPushParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcCancelPushParams decode(Decoder decoder0) {
            NfcCancelPushParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcCancelPushParams(elementsOrVersion);
                result.target = decoder0.readInt(8);
                NfcPushTarget.validate(result.target);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.target, 8);
        }
    }

    static final class NfcCancelPushResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NfcError error;

        private NfcCancelPushResponseParams(int version) {
            super(16, version);
        }

        public NfcCancelPushResponseParams() {
            this(0);
        }

        public static NfcCancelPushResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcCancelPushResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcCancelPushResponseParams decode(Decoder decoder0) {
            NfcCancelPushResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcCancelPushResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.error = NfcError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8, true);
        }
    }

    static class NfcCancelPushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Nfc.CancelPushResponse mCallback;

        NfcCancelPushResponseParamsForwardToCallback(Nfc.CancelPushResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                Nfc_Internal.NfcCancelPushResponseParams response = Nfc_Internal.NfcCancelPushResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NfcCancelPushResponseParamsProxyToResponder implements Nfc.CancelPushResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NfcCancelPushResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NfcError error) {
            Nfc_Internal.NfcCancelPushResponseParams _response = new Nfc_Internal.NfcCancelPushResponseParams();
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NfcWatchParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NfcReaderOptions options;

        private NfcWatchParams(int version) {
            super(16, version);
        }

        public NfcWatchParams() {
            this(0);
        }

        public static NfcWatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcWatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcWatchParams decode(Decoder decoder0) {
            NfcWatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcWatchParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = NfcReaderOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, false);
        }
    }

    static final class NfcWatchResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int id;

        public NfcError error;

        private NfcWatchResponseParams(int version) {
            super(24, version);
        }

        public NfcWatchResponseParams() {
            this(0);
        }

        public static NfcWatchResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcWatchResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcWatchResponseParams decode(Decoder decoder0) {
            NfcWatchResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcWatchResponseParams(elementsOrVersion);
                result.id = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.error = NfcError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8);
            encoder0.encode(this.error, 16, true);
        }
    }

    static class NfcWatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Nfc.WatchResponse mCallback;

        NfcWatchResponseParamsForwardToCallback(Nfc.WatchResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                Nfc_Internal.NfcWatchResponseParams response = Nfc_Internal.NfcWatchResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.id), response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NfcWatchResponseParamsProxyToResponder implements Nfc.WatchResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NfcWatchResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer id, NfcError error) {
            Nfc_Internal.NfcWatchResponseParams _response = new Nfc_Internal.NfcWatchResponseParams();
            _response.id = id.intValue();
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NfcCancelWatchParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int id;

        private NfcCancelWatchParams(int version) {
            super(16, version);
        }

        public NfcCancelWatchParams() {
            this(0);
        }

        public static NfcCancelWatchParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcCancelWatchParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcCancelWatchParams decode(Decoder decoder0) {
            NfcCancelWatchParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcCancelWatchParams(elementsOrVersion);
                result.id = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8);
        }
    }

    static final class NfcCancelWatchResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NfcError error;

        private NfcCancelWatchResponseParams(int version) {
            super(16, version);
        }

        public NfcCancelWatchResponseParams() {
            this(0);
        }

        public static NfcCancelWatchResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcCancelWatchResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcCancelWatchResponseParams decode(Decoder decoder0) {
            NfcCancelWatchResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcCancelWatchResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.error = NfcError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8, true);
        }
    }

    static class NfcCancelWatchResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Nfc.CancelWatchResponse mCallback;

        NfcCancelWatchResponseParamsForwardToCallback(Nfc.CancelWatchResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                Nfc_Internal.NfcCancelWatchResponseParams response = Nfc_Internal.NfcCancelWatchResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NfcCancelWatchResponseParamsProxyToResponder implements Nfc.CancelWatchResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NfcCancelWatchResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NfcError error) {
            Nfc_Internal.NfcCancelWatchResponseParams _response = new Nfc_Internal.NfcCancelWatchResponseParams();
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NfcCancelAllWatchesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NfcCancelAllWatchesParams(int version) {
            super(8, version);
        }

        public NfcCancelAllWatchesParams() {
            this(0);
        }

        public static NfcCancelAllWatchesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcCancelAllWatchesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcCancelAllWatchesParams decode(Decoder decoder0) {
            NfcCancelAllWatchesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcCancelAllWatchesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NfcCancelAllWatchesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NfcError error;

        private NfcCancelAllWatchesResponseParams(int version) {
            super(16, version);
        }

        public NfcCancelAllWatchesResponseParams() {
            this(0);
        }

        public static NfcCancelAllWatchesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcCancelAllWatchesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcCancelAllWatchesResponseParams decode(Decoder decoder0) {
            NfcCancelAllWatchesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcCancelAllWatchesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.error = NfcError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8, true);
        }
    }

    static class NfcCancelAllWatchesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Nfc.CancelAllWatchesResponse mCallback;

        NfcCancelAllWatchesResponseParamsForwardToCallback(Nfc.CancelAllWatchesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                Nfc_Internal.NfcCancelAllWatchesResponseParams response = Nfc_Internal.NfcCancelAllWatchesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.error);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NfcCancelAllWatchesResponseParamsProxyToResponder implements Nfc.CancelAllWatchesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NfcCancelAllWatchesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NfcError error) {
            Nfc_Internal.NfcCancelAllWatchesResponseParams _response = new Nfc_Internal.NfcCancelAllWatchesResponseParams();
            _response.error = error;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NfcSuspendNfcOperationsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NfcSuspendNfcOperationsParams(int version) {
            super(8, version);
        }

        public NfcSuspendNfcOperationsParams() {
            this(0);
        }

        public static NfcSuspendNfcOperationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcSuspendNfcOperationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcSuspendNfcOperationsParams decode(Decoder decoder0) {
            NfcSuspendNfcOperationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcSuspendNfcOperationsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NfcResumeNfcOperationsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NfcResumeNfcOperationsParams(int version) {
            super(8, version);
        }

        public NfcResumeNfcOperationsParams() {
            this(0);
        }

        public static NfcResumeNfcOperationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NfcResumeNfcOperationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NfcResumeNfcOperationsParams decode(Decoder decoder0) {
            NfcResumeNfcOperationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NfcResumeNfcOperationsParams(elementsOrVersion);
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
