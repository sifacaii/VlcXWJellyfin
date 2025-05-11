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
import org.chromium.url.mojom.Origin;

class QuotaDispatcherHost_Internal {
    public static final Interface.Manager<QuotaDispatcherHost, QuotaDispatcherHost.Proxy> MANAGER = new Interface.Manager<QuotaDispatcherHost, QuotaDispatcherHost.Proxy>() {
        public String getName() {
            return "blink.mojom.QuotaDispatcherHost";
        }

        public int getVersion() {
            return 0;
        }

        public QuotaDispatcherHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new QuotaDispatcherHost_Internal.Proxy(core, messageReceiver);
        }

        public QuotaDispatcherHost_Internal.Stub buildStub(Core core, QuotaDispatcherHost impl) {
            return new QuotaDispatcherHost_Internal.Stub(core, impl);
        }

        public QuotaDispatcherHost[] buildArray(int size) {
            return new QuotaDispatcherHost[size];
        }
    };

    private static final int QUERY_STORAGE_USAGE_AND_QUOTA_ORDINAL = 0;

    private static final int REQUEST_STORAGE_QUOTA_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements QuotaDispatcherHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void queryStorageUsageAndQuota(Origin origin, int storageType, QuotaDispatcherHost.QueryStorageUsageAndQuotaResponse callback) {
            QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaParams _message = new QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaParams();
            _message.origin = origin;
            _message.storageType = storageType;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParamsForwardToCallback(callback));
        }

        public void requestStorageQuota(Origin origin, int storageType, long requestedSize, QuotaDispatcherHost.RequestStorageQuotaResponse callback) {
            QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaParams _message = new QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaParams();
            _message.origin = origin;
            _message.storageType = storageType;
            _message.requestedSize = requestedSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<QuotaDispatcherHost> {
        Stub(Core core, QuotaDispatcherHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(QuotaDispatcherHost_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaParams quotaDispatcherHostQueryStorageUsageAndQuotaParams;
                QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), QuotaDispatcherHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        quotaDispatcherHostQueryStorageUsageAndQuotaParams = QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaParams.deserialize(messageWithHeader.getPayload());
                        ((QuotaDispatcherHost)getImpl()).queryStorageUsageAndQuota(quotaDispatcherHostQueryStorageUsageAndQuotaParams.origin, quotaDispatcherHostQueryStorageUsageAndQuotaParams.storageType, new QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaParams.deserialize(messageWithHeader.getPayload());
                        ((QuotaDispatcherHost)getImpl()).requestStorageQuota(data.origin, data.storageType, data.requestedSize, new QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class QuotaDispatcherHostQueryStorageUsageAndQuotaParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public int storageType;

        private QuotaDispatcherHostQueryStorageUsageAndQuotaParams(int version) {
            super(24, version);
        }

        public QuotaDispatcherHostQueryStorageUsageAndQuotaParams() {
            this(0);
        }

        public static QuotaDispatcherHostQueryStorageUsageAndQuotaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static QuotaDispatcherHostQueryStorageUsageAndQuotaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static QuotaDispatcherHostQueryStorageUsageAndQuotaParams decode(Decoder decoder0) {
            QuotaDispatcherHostQueryStorageUsageAndQuotaParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new QuotaDispatcherHostQueryStorageUsageAndQuotaParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.storageType = decoder0.readInt(16);
                StorageType.validate(result.storageType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.storageType, 16);
        }
    }

    static final class QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public long currentUsage;

        public long currentQuota;

        public UsageBreakdown usageBreakdown;

        private QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams(int version) {
            super(40, version);
        }

        public QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams() {
            this(0);
        }

        public static QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams decode(Decoder decoder0) {
            QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                QuotaStatusCode.validate(result.error);
                result.currentUsage = decoder0.readLong(16);
                result.currentQuota = decoder0.readLong(24);
                Decoder decoder1 = decoder0.readPointer(32, false);
                result.usageBreakdown = UsageBreakdown.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.currentUsage, 16);
            encoder0.encode(this.currentQuota, 24);
            encoder0.encode(this.usageBreakdown, 32, false);
        }
    }

    static class QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final QuotaDispatcherHost.QueryStorageUsageAndQuotaResponse mCallback;

        QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParamsForwardToCallback(QuotaDispatcherHost.QueryStorageUsageAndQuotaResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams response = QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), Long.valueOf(response.currentUsage), Long.valueOf(response.currentQuota), response.usageBreakdown);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParamsProxyToResponder implements QuotaDispatcherHost.QueryStorageUsageAndQuotaResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, Long currentUsage, Long currentQuota, UsageBreakdown usageBreakdown) {
            QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams _response = new QuotaDispatcherHost_Internal.QuotaDispatcherHostQueryStorageUsageAndQuotaResponseParams();
            _response.error = error.intValue();
            _response.currentUsage = currentUsage.longValue();
            _response.currentQuota = currentQuota.longValue();
            _response.usageBreakdown = usageBreakdown;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class QuotaDispatcherHostRequestStorageQuotaParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public int storageType;

        public long requestedSize;

        private QuotaDispatcherHostRequestStorageQuotaParams(int version) {
            super(32, version);
        }

        public QuotaDispatcherHostRequestStorageQuotaParams() {
            this(0);
        }

        public static QuotaDispatcherHostRequestStorageQuotaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static QuotaDispatcherHostRequestStorageQuotaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static QuotaDispatcherHostRequestStorageQuotaParams decode(Decoder decoder0) {
            QuotaDispatcherHostRequestStorageQuotaParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new QuotaDispatcherHostRequestStorageQuotaParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.storageType = decoder0.readInt(16);
                StorageType.validate(result.storageType);
                result.requestedSize = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.storageType, 16);
            encoder0.encode(this.requestedSize, 24);
        }
    }

    static final class QuotaDispatcherHostRequestStorageQuotaResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public long currentUsage;

        public long grantedQuota;

        private QuotaDispatcherHostRequestStorageQuotaResponseParams(int version) {
            super(32, version);
        }

        public QuotaDispatcherHostRequestStorageQuotaResponseParams() {
            this(0);
        }

        public static QuotaDispatcherHostRequestStorageQuotaResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static QuotaDispatcherHostRequestStorageQuotaResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static QuotaDispatcherHostRequestStorageQuotaResponseParams decode(Decoder decoder0) {
            QuotaDispatcherHostRequestStorageQuotaResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new QuotaDispatcherHostRequestStorageQuotaResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                QuotaStatusCode.validate(result.error);
                result.currentUsage = decoder0.readLong(16);
                result.grantedQuota = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.currentUsage, 16);
            encoder0.encode(this.grantedQuota, 24);
        }
    }

    static class QuotaDispatcherHostRequestStorageQuotaResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final QuotaDispatcherHost.RequestStorageQuotaResponse mCallback;

        QuotaDispatcherHostRequestStorageQuotaResponseParamsForwardToCallback(QuotaDispatcherHost.RequestStorageQuotaResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaResponseParams response = QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), Long.valueOf(response.currentUsage), Long.valueOf(response.grantedQuota));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class QuotaDispatcherHostRequestStorageQuotaResponseParamsProxyToResponder implements QuotaDispatcherHost.RequestStorageQuotaResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        QuotaDispatcherHostRequestStorageQuotaResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, Long currentUsage, Long grantedQuota) {
            QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaResponseParams _response = new QuotaDispatcherHost_Internal.QuotaDispatcherHostRequestStorageQuotaResponseParams();
            _response.error = error.intValue();
            _response.currentUsage = currentUsage.longValue();
            _response.grantedQuota = grantedQuota.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
