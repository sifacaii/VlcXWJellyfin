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

class PeriodicBackgroundSyncService_Internal {
    public static final Interface.Manager<PeriodicBackgroundSyncService, PeriodicBackgroundSyncService.Proxy> MANAGER = new Interface.Manager<PeriodicBackgroundSyncService, PeriodicBackgroundSyncService.Proxy>() {
        public String getName() {
            return "blink.mojom.PeriodicBackgroundSyncService";
        }

        public int getVersion() {
            return 0;
        }

        public PeriodicBackgroundSyncService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PeriodicBackgroundSyncService_Internal.Proxy(core, messageReceiver);
        }

        public PeriodicBackgroundSyncService_Internal.Stub buildStub(Core core, PeriodicBackgroundSyncService impl) {
            return new PeriodicBackgroundSyncService_Internal.Stub(core, impl);
        }

        public PeriodicBackgroundSyncService[] buildArray(int size) {
            return new PeriodicBackgroundSyncService[size];
        }
    };

    private static final int REGISTER_ORDINAL = 0;

    private static final int UNREGISTER_ORDINAL = 1;

    private static final int GET_REGISTRATIONS_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements PeriodicBackgroundSyncService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void register(SyncRegistrationOptions options, long serviceWorkerRegistrationId, PeriodicBackgroundSyncService.RegisterResponse callback) {
            PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterParams _message = new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterParams();
            _message.options = options;
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterResponseParamsForwardToCallback(callback));
        }

        public void unregister(long serviceWorkerRegistrationId, String tag, PeriodicBackgroundSyncService.UnregisterResponse callback) {
            PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterParams _message = new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.tag = tag;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterResponseParamsForwardToCallback(callback));
        }

        public void getRegistrations(long serviceWorkerRegistrationId, PeriodicBackgroundSyncService.GetRegistrationsResponse callback) {
            PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsParams _message = new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<PeriodicBackgroundSyncService> {
        Stub(Core core, PeriodicBackgroundSyncService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PeriodicBackgroundSyncService_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterParams periodicBackgroundSyncServiceRegisterParams;
                PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterParams periodicBackgroundSyncServiceUnregisterParams;
                PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PeriodicBackgroundSyncService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        periodicBackgroundSyncServiceRegisterParams = PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterParams.deserialize(messageWithHeader.getPayload());
                        ((PeriodicBackgroundSyncService)getImpl()).register(periodicBackgroundSyncServiceRegisterParams.options, periodicBackgroundSyncServiceRegisterParams.serviceWorkerRegistrationId, new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        periodicBackgroundSyncServiceUnregisterParams = PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterParams.deserialize(messageWithHeader.getPayload());
                        ((PeriodicBackgroundSyncService)getImpl()).unregister(periodicBackgroundSyncServiceUnregisterParams.serviceWorkerRegistrationId, periodicBackgroundSyncServiceUnregisterParams.tag, new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsParams.deserialize(messageWithHeader.getPayload());
                        ((PeriodicBackgroundSyncService)getImpl()).getRegistrations(data.serviceWorkerRegistrationId, new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PeriodicBackgroundSyncServiceRegisterParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SyncRegistrationOptions options;

        public long serviceWorkerRegistrationId;

        private PeriodicBackgroundSyncServiceRegisterParams(int version) {
            super(24, version);
        }

        public PeriodicBackgroundSyncServiceRegisterParams() {
            this(0);
        }

        public static PeriodicBackgroundSyncServiceRegisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PeriodicBackgroundSyncServiceRegisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PeriodicBackgroundSyncServiceRegisterParams decode(Decoder decoder0) {
            PeriodicBackgroundSyncServiceRegisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PeriodicBackgroundSyncServiceRegisterParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = SyncRegistrationOptions.decode(decoder1);
                result.serviceWorkerRegistrationId = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, false);
            encoder0.encode(this.serviceWorkerRegistrationId, 16);
        }
    }

    static final class PeriodicBackgroundSyncServiceRegisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int err;

        public SyncRegistrationOptions options;

        private PeriodicBackgroundSyncServiceRegisterResponseParams(int version) {
            super(24, version);
        }

        public PeriodicBackgroundSyncServiceRegisterResponseParams() {
            this(0);
        }

        public static PeriodicBackgroundSyncServiceRegisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PeriodicBackgroundSyncServiceRegisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PeriodicBackgroundSyncServiceRegisterResponseParams decode(Decoder decoder0) {
            PeriodicBackgroundSyncServiceRegisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PeriodicBackgroundSyncServiceRegisterResponseParams(elementsOrVersion);
                result.err = decoder0.readInt(8);
                BackgroundSyncError.validate(result.err);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.options = SyncRegistrationOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.err, 8);
            encoder0.encode(this.options, 16, true);
        }
    }

    static class PeriodicBackgroundSyncServiceRegisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PeriodicBackgroundSyncService.RegisterResponse mCallback;

        PeriodicBackgroundSyncServiceRegisterResponseParamsForwardToCallback(PeriodicBackgroundSyncService.RegisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterResponseParams response = PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.err), response.options);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PeriodicBackgroundSyncServiceRegisterResponseParamsProxyToResponder implements PeriodicBackgroundSyncService.RegisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PeriodicBackgroundSyncServiceRegisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer err, SyncRegistrationOptions options) {
            PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterResponseParams _response = new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceRegisterResponseParams();
            _response.err = err.intValue();
            _response.options = options;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PeriodicBackgroundSyncServiceUnregisterParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public String tag;

        private PeriodicBackgroundSyncServiceUnregisterParams(int version) {
            super(24, version);
        }

        public PeriodicBackgroundSyncServiceUnregisterParams() {
            this(0);
        }

        public static PeriodicBackgroundSyncServiceUnregisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PeriodicBackgroundSyncServiceUnregisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PeriodicBackgroundSyncServiceUnregisterParams decode(Decoder decoder0) {
            PeriodicBackgroundSyncServiceUnregisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PeriodicBackgroundSyncServiceUnregisterParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                result.tag = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.tag, 16, false);
        }
    }

    static final class PeriodicBackgroundSyncServiceUnregisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int err;

        private PeriodicBackgroundSyncServiceUnregisterResponseParams(int version) {
            super(16, version);
        }

        public PeriodicBackgroundSyncServiceUnregisterResponseParams() {
            this(0);
        }

        public static PeriodicBackgroundSyncServiceUnregisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PeriodicBackgroundSyncServiceUnregisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PeriodicBackgroundSyncServiceUnregisterResponseParams decode(Decoder decoder0) {
            PeriodicBackgroundSyncServiceUnregisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PeriodicBackgroundSyncServiceUnregisterResponseParams(elementsOrVersion);
                result.err = decoder0.readInt(8);
                BackgroundSyncError.validate(result.err);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.err, 8);
        }
    }

    static class PeriodicBackgroundSyncServiceUnregisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PeriodicBackgroundSyncService.UnregisterResponse mCallback;

        PeriodicBackgroundSyncServiceUnregisterResponseParamsForwardToCallback(PeriodicBackgroundSyncService.UnregisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterResponseParams response = PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.err));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PeriodicBackgroundSyncServiceUnregisterResponseParamsProxyToResponder implements PeriodicBackgroundSyncService.UnregisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PeriodicBackgroundSyncServiceUnregisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer err) {
            PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterResponseParams _response = new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceUnregisterResponseParams();
            _response.err = err.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PeriodicBackgroundSyncServiceGetRegistrationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private PeriodicBackgroundSyncServiceGetRegistrationsParams(int version) {
            super(16, version);
        }

        public PeriodicBackgroundSyncServiceGetRegistrationsParams() {
            this(0);
        }

        public static PeriodicBackgroundSyncServiceGetRegistrationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PeriodicBackgroundSyncServiceGetRegistrationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PeriodicBackgroundSyncServiceGetRegistrationsParams decode(Decoder decoder0) {
            PeriodicBackgroundSyncServiceGetRegistrationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PeriodicBackgroundSyncServiceGetRegistrationsParams(elementsOrVersion);
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

    static final class PeriodicBackgroundSyncServiceGetRegistrationsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int err;

        public SyncRegistrationOptions[] registrations;

        private PeriodicBackgroundSyncServiceGetRegistrationsResponseParams(int version) {
            super(24, version);
        }

        public PeriodicBackgroundSyncServiceGetRegistrationsResponseParams() {
            this(0);
        }

        public static PeriodicBackgroundSyncServiceGetRegistrationsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PeriodicBackgroundSyncServiceGetRegistrationsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PeriodicBackgroundSyncServiceGetRegistrationsResponseParams decode(Decoder decoder0) {
            PeriodicBackgroundSyncServiceGetRegistrationsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PeriodicBackgroundSyncServiceGetRegistrationsResponseParams(elementsOrVersion);
                result.err = decoder0.readInt(8);
                BackgroundSyncError.validate(result.err);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.registrations = new SyncRegistrationOptions[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.registrations[i1] = SyncRegistrationOptions.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.err, 8);
            if (this.registrations == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.registrations.length, 16, -1);
                for (int i0 = 0; i0 < this.registrations.length; i0++)
                    encoder1.encode(this.registrations[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PeriodicBackgroundSyncService.GetRegistrationsResponse mCallback;

        PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(PeriodicBackgroundSyncService.GetRegistrationsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsResponseParams response = PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.err), response.registrations);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder implements PeriodicBackgroundSyncService.GetRegistrationsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PeriodicBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer err, SyncRegistrationOptions[] registrations) {
            PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsResponseParams _response = new PeriodicBackgroundSyncService_Internal.PeriodicBackgroundSyncServiceGetRegistrationsResponseParams();
            _response.err = err.intValue();
            _response.registrations = registrations;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
