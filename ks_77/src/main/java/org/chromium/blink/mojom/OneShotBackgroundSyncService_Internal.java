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

class OneShotBackgroundSyncService_Internal {
    public static final Interface.Manager<OneShotBackgroundSyncService, OneShotBackgroundSyncService.Proxy> MANAGER = new Interface.Manager<OneShotBackgroundSyncService, OneShotBackgroundSyncService.Proxy>() {
        public String getName() {
            return "blink.mojom.OneShotBackgroundSyncService";
        }

        public int getVersion() {
            return 0;
        }

        public OneShotBackgroundSyncService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new OneShotBackgroundSyncService_Internal.Proxy(core, messageReceiver);
        }

        public OneShotBackgroundSyncService_Internal.Stub buildStub(Core core, OneShotBackgroundSyncService impl) {
            return new OneShotBackgroundSyncService_Internal.Stub(core, impl);
        }

        public OneShotBackgroundSyncService[] buildArray(int size) {
            return new OneShotBackgroundSyncService[size];
        }
    };

    private static final int REGISTER_ORDINAL = 0;

    private static final int DID_RESOLVE_REGISTRATION_ORDINAL = 1;

    private static final int GET_REGISTRATIONS_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements OneShotBackgroundSyncService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void register(SyncRegistrationOptions options, long serviceWorkerRegistrationId, OneShotBackgroundSyncService.RegisterResponse callback) {
            OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterParams _message = new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterParams();
            _message.options = options;
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterResponseParamsForwardToCallback(callback));
        }

        public void didResolveRegistration(BackgroundSyncRegistrationInfo registrationInfo) {
            OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceDidResolveRegistrationParams _message = new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceDidResolveRegistrationParams();
            _message.registrationInfo = registrationInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void getRegistrations(long serviceWorkerRegistrationId, OneShotBackgroundSyncService.GetRegistrationsResponse callback) {
            OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsParams _message = new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<OneShotBackgroundSyncService> {
        Stub(Core core, OneShotBackgroundSyncService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceDidResolveRegistrationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(OneShotBackgroundSyncService_Internal.MANAGER, messageWithHeader);
                    case 1:
                        data = OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceDidResolveRegistrationParams.deserialize(messageWithHeader.getPayload());
                        ((OneShotBackgroundSyncService)getImpl()).didResolveRegistration(data.registrationInfo);
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
                OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterParams oneShotBackgroundSyncServiceRegisterParams;
                OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), OneShotBackgroundSyncService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        oneShotBackgroundSyncServiceRegisterParams = OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterParams.deserialize(messageWithHeader.getPayload());
                        ((OneShotBackgroundSyncService)getImpl()).register(oneShotBackgroundSyncServiceRegisterParams.options, oneShotBackgroundSyncServiceRegisterParams.serviceWorkerRegistrationId, new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsParams.deserialize(messageWithHeader.getPayload());
                        ((OneShotBackgroundSyncService)getImpl()).getRegistrations(data.serviceWorkerRegistrationId, new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class OneShotBackgroundSyncServiceRegisterParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SyncRegistrationOptions options;

        public long serviceWorkerRegistrationId;

        private OneShotBackgroundSyncServiceRegisterParams(int version) {
            super(24, version);
        }

        public OneShotBackgroundSyncServiceRegisterParams() {
            this(0);
        }

        public static OneShotBackgroundSyncServiceRegisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OneShotBackgroundSyncServiceRegisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OneShotBackgroundSyncServiceRegisterParams decode(Decoder decoder0) {
            OneShotBackgroundSyncServiceRegisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OneShotBackgroundSyncServiceRegisterParams(elementsOrVersion);
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

    static final class OneShotBackgroundSyncServiceRegisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int err;

        public SyncRegistrationOptions options;

        private OneShotBackgroundSyncServiceRegisterResponseParams(int version) {
            super(24, version);
        }

        public OneShotBackgroundSyncServiceRegisterResponseParams() {
            this(0);
        }

        public static OneShotBackgroundSyncServiceRegisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OneShotBackgroundSyncServiceRegisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OneShotBackgroundSyncServiceRegisterResponseParams decode(Decoder decoder0) {
            OneShotBackgroundSyncServiceRegisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OneShotBackgroundSyncServiceRegisterResponseParams(elementsOrVersion);
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

    static class OneShotBackgroundSyncServiceRegisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final OneShotBackgroundSyncService.RegisterResponse mCallback;

        OneShotBackgroundSyncServiceRegisterResponseParamsForwardToCallback(OneShotBackgroundSyncService.RegisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterResponseParams response = OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.err), response.options);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class OneShotBackgroundSyncServiceRegisterResponseParamsProxyToResponder implements OneShotBackgroundSyncService.RegisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        OneShotBackgroundSyncServiceRegisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer err, SyncRegistrationOptions options) {
            OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterResponseParams _response = new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceRegisterResponseParams();
            _response.err = err.intValue();
            _response.options = options;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class OneShotBackgroundSyncServiceDidResolveRegistrationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundSyncRegistrationInfo registrationInfo;

        private OneShotBackgroundSyncServiceDidResolveRegistrationParams(int version) {
            super(16, version);
        }

        public OneShotBackgroundSyncServiceDidResolveRegistrationParams() {
            this(0);
        }

        public static OneShotBackgroundSyncServiceDidResolveRegistrationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OneShotBackgroundSyncServiceDidResolveRegistrationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OneShotBackgroundSyncServiceDidResolveRegistrationParams decode(Decoder decoder0) {
            OneShotBackgroundSyncServiceDidResolveRegistrationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OneShotBackgroundSyncServiceDidResolveRegistrationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.registrationInfo = BackgroundSyncRegistrationInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.registrationInfo, 8, false);
        }
    }

    static final class OneShotBackgroundSyncServiceGetRegistrationsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private OneShotBackgroundSyncServiceGetRegistrationsParams(int version) {
            super(16, version);
        }

        public OneShotBackgroundSyncServiceGetRegistrationsParams() {
            this(0);
        }

        public static OneShotBackgroundSyncServiceGetRegistrationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OneShotBackgroundSyncServiceGetRegistrationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OneShotBackgroundSyncServiceGetRegistrationsParams decode(Decoder decoder0) {
            OneShotBackgroundSyncServiceGetRegistrationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OneShotBackgroundSyncServiceGetRegistrationsParams(elementsOrVersion);
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

    static final class OneShotBackgroundSyncServiceGetRegistrationsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int err;

        public SyncRegistrationOptions[] registrations;

        private OneShotBackgroundSyncServiceGetRegistrationsResponseParams(int version) {
            super(24, version);
        }

        public OneShotBackgroundSyncServiceGetRegistrationsResponseParams() {
            this(0);
        }

        public static OneShotBackgroundSyncServiceGetRegistrationsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OneShotBackgroundSyncServiceGetRegistrationsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OneShotBackgroundSyncServiceGetRegistrationsResponseParams decode(Decoder decoder0) {
            OneShotBackgroundSyncServiceGetRegistrationsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OneShotBackgroundSyncServiceGetRegistrationsResponseParams(elementsOrVersion);
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

    static class OneShotBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final OneShotBackgroundSyncService.GetRegistrationsResponse mCallback;

        OneShotBackgroundSyncServiceGetRegistrationsResponseParamsForwardToCallback(OneShotBackgroundSyncService.GetRegistrationsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsResponseParams response = OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.err), response.registrations);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class OneShotBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder implements OneShotBackgroundSyncService.GetRegistrationsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        OneShotBackgroundSyncServiceGetRegistrationsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer err, SyncRegistrationOptions[] registrations) {
            OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsResponseParams _response = new OneShotBackgroundSyncService_Internal.OneShotBackgroundSyncServiceGetRegistrationsResponseParams();
            _response.err = err.intValue();
            _response.registrations = registrations;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
