package org.chromium.network.mojom;

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
import org.chromium.network.mojom.NetworkContextClient;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal.class */
class NetworkContextClient_Internal {
    public static final Interface.Manager<NetworkContextClient, NetworkContextClient.Proxy> MANAGER = new Interface.Manager<NetworkContextClient, NetworkContextClient.Proxy>() { // from class: org.chromium.network.mojom.NetworkContextClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkContextClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkContextClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkContextClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkContextClient[] buildArray(int size) {
            return new NetworkContextClient[size];
        }
    };
    private static final int ON_CAN_SEND_REPORTING_REPORTS_ORDINAL = 0;
    private static final int ON_CAN_SEND_DOMAIN_RELIABILITY_UPLOAD_ORDINAL = 1;
    private static final int ON_CLEAR_SITE_DATA_ORDINAL = 2;
    private static final int ON_COOKIES_CHANGED_ORDINAL = 3;
    private static final int ON_COOKIES_READ_ORDINAL = 4;

    NetworkContextClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkContextClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkContextClient
        public void onCanSendReportingReports(Origin[] origins, NetworkContextClient.OnCanSendReportingReportsResponse callback) {
            NetworkContextClientOnCanSendReportingReportsParams _message = new NetworkContextClientOnCanSendReportingReportsParams();
            _message.origins = origins;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContextClient
        public void onCanSendDomainReliabilityUpload(Url origin, NetworkContextClient.OnCanSendDomainReliabilityUploadResponse callback) {
            NetworkContextClientOnCanSendDomainReliabilityUploadParams _message = new NetworkContextClientOnCanSendDomainReliabilityUploadParams();
            _message.origin = origin;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContextClient
        public void onClearSiteData(int processId, int routingId, Url url, String headerValue, int loadFlags, NetworkContextClient.OnClearSiteDataResponse callback) {
            NetworkContextClientOnClearSiteDataParams _message = new NetworkContextClientOnClearSiteDataParams();
            _message.processId = processId;
            _message.routingId = routingId;
            _message.url = url;
            _message.headerValue = headerValue;
            _message.loadFlags = loadFlags;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NetworkContextClientOnClearSiteDataResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkContextClient
        public void onCookiesChanged(boolean isServiceWorker, int processId, int routingId, Url url, Url siteForCookies, CookieWithStatus[] cookieList) {
            NetworkContextClientOnCookiesChangedParams _message = new NetworkContextClientOnCookiesChangedParams();
            _message.isServiceWorker = isServiceWorker;
            _message.processId = processId;
            _message.routingId = routingId;
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            _message.cookieList = cookieList;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.network.mojom.NetworkContextClient
        public void onCookiesRead(boolean isServiceWorker, int processId, int routingId, Url url, Url siteForCookies, CookieWithStatus[] cookieList) {
            NetworkContextClientOnCookiesReadParams _message = new NetworkContextClientOnCookiesReadParams();
            _message.isServiceWorker = isServiceWorker;
            _message.processId = processId;
            _message.routingId = routingId;
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            _message.cookieList = cookieList;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkContextClient> {
        Stub(Core core, NetworkContextClient impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkContextClient_Internal.MANAGER, messageWithHeader);
                    case 3:
                        NetworkContextClientOnCookiesChangedParams data = NetworkContextClientOnCookiesChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onCookiesChanged(data.isServiceWorker, data.processId, data.routingId, data.url, data.siteForCookies, data.cookieList);
                        return true;
                    case 4:
                        NetworkContextClientOnCookiesReadParams data2 = NetworkContextClientOnCookiesReadParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onCookiesRead(data2.isServiceWorker, data2.processId, data2.routingId, data2.url, data2.siteForCookies, data2.cookieList);
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkContextClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        getImpl().onCanSendReportingReports(NetworkContextClientOnCanSendReportingReportsParams.deserialize(messageWithHeader.getPayload()).origins, new NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        getImpl().onCanSendDomainReliabilityUpload(NetworkContextClientOnCanSendDomainReliabilityUploadParams.deserialize(messageWithHeader.getPayload()).origin, new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        NetworkContextClientOnClearSiteDataParams data = NetworkContextClientOnClearSiteDataParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onClearSiteData(data.processId, data.routingId, data.url, data.headerValue, data.loadFlags, new NetworkContextClientOnClearSiteDataResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendReportingReportsParams.class */
    static final class NetworkContextClientOnCanSendReportingReportsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Origin[] origins;

        private NetworkContextClientOnCanSendReportingReportsParams(int version) {
            super(16, version);
        }

        public NetworkContextClientOnCanSendReportingReportsParams() {
            this(0);
        }

        public static NetworkContextClientOnCanSendReportingReportsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnCanSendReportingReportsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnCanSendReportingReportsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnCanSendReportingReportsParams result = new NetworkContextClientOnCanSendReportingReportsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.origins = new Origin[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.origins[i1] = Origin.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.origins == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.origins.length, 8, -1);
            for (int i0 = 0; i0 < this.origins.length; i0++) {
                encoder1.encode((Struct) this.origins[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendReportingReportsResponseParams.class */
    public static final class NetworkContextClientOnCanSendReportingReportsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Origin[] origins;

        private NetworkContextClientOnCanSendReportingReportsResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextClientOnCanSendReportingReportsResponseParams() {
            this(0);
        }

        public static NetworkContextClientOnCanSendReportingReportsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnCanSendReportingReportsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnCanSendReportingReportsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnCanSendReportingReportsResponseParams result = new NetworkContextClientOnCanSendReportingReportsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.origins = new Origin[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.origins[i1] = Origin.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.origins == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.origins.length, 8, -1);
            for (int i0 = 0; i0 < this.origins.length; i0++) {
                encoder1.encode((Struct) this.origins[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback.class */
    static class NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContextClient.OnCanSendReportingReportsResponse mCallback;

        NetworkContextClientOnCanSendReportingReportsResponseParamsForwardToCallback(NetworkContextClient.OnCanSendReportingReportsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                NetworkContextClientOnCanSendReportingReportsResponseParams response = NetworkContextClientOnCanSendReportingReportsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.origins);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder.class */
    static class NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder implements NetworkContextClient.OnCanSendReportingReportsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClientOnCanSendReportingReportsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Origin[] origins) {
            NetworkContextClientOnCanSendReportingReportsResponseParams _response = new NetworkContextClientOnCanSendReportingReportsResponseParams();
            _response.origins = origins;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendDomainReliabilityUploadParams.class */
    static final class NetworkContextClientOnCanSendDomainReliabilityUploadParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url origin;

        private NetworkContextClientOnCanSendDomainReliabilityUploadParams(int version) {
            super(16, version);
        }

        public NetworkContextClientOnCanSendDomainReliabilityUploadParams() {
            this(0);
        }

        public static NetworkContextClientOnCanSendDomainReliabilityUploadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnCanSendDomainReliabilityUploadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnCanSendDomainReliabilityUploadParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnCanSendDomainReliabilityUploadParams result = new NetworkContextClientOnCanSendDomainReliabilityUploadParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Url.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.origin, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams.class */
    public static final class NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean allowed;

        private NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams(int version) {
            super(16, version);
        }

        public NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams() {
            this(0);
        }

        public static NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams result = new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams(elementsOrVersion);
                result.allowed = decoder0.readBoolean(8, 0);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.allowed, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback.class */
    static class NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContextClient.OnCanSendDomainReliabilityUploadResponse mCallback;

        NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsForwardToCallback(NetworkContextClient.OnCanSendDomainReliabilityUploadResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams response = NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.allowed));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder.class */
    static class NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder implements NetworkContextClient.OnCanSendDomainReliabilityUploadResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClientOnCanSendDomainReliabilityUploadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean allowed) {
            NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams _response = new NetworkContextClientOnCanSendDomainReliabilityUploadResponseParams();
            _response.allowed = allowed.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnClearSiteDataParams.class */
    static final class NetworkContextClientOnClearSiteDataParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public int routingId;
        public Url url;
        public String headerValue;
        public int loadFlags;

        private NetworkContextClientOnClearSiteDataParams(int version) {
            super(40, version);
        }

        public NetworkContextClientOnClearSiteDataParams() {
            this(0);
        }

        public static NetworkContextClientOnClearSiteDataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnClearSiteDataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnClearSiteDataParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnClearSiteDataParams result = new NetworkContextClientOnClearSiteDataParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
                result.routingId = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
                result.headerValue = decoder0.readString(24, false);
                result.loadFlags = decoder0.readInt(32);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.processId, 8);
            encoder0.encode(this.routingId, 12);
            encoder0.encode((Struct) this.url, 16, false);
            encoder0.encode(this.headerValue, 24, false);
            encoder0.encode(this.loadFlags, 32);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnClearSiteDataResponseParams.class */
    static final class NetworkContextClientOnClearSiteDataResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkContextClientOnClearSiteDataResponseParams(int version) {
            super(8, version);
        }

        public NetworkContextClientOnClearSiteDataResponseParams() {
            this(0);
        }

        public static NetworkContextClientOnClearSiteDataResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnClearSiteDataResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnClearSiteDataResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnClearSiteDataResponseParams result = new NetworkContextClientOnClearSiteDataResponseParams(elementsOrVersion);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnClearSiteDataResponseParamsForwardToCallback.class */
    static class NetworkContextClientOnClearSiteDataResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkContextClient.OnClearSiteDataResponse mCallback;

        NetworkContextClientOnClearSiteDataResponseParamsForwardToCallback(NetworkContextClient.OnClearSiteDataResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnClearSiteDataResponseParamsProxyToResponder.class */
    static class NetworkContextClientOnClearSiteDataResponseParamsProxyToResponder implements NetworkContextClient.OnClearSiteDataResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkContextClientOnClearSiteDataResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkContextClientOnClearSiteDataResponseParams _response = new NetworkContextClientOnClearSiteDataResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCookiesChangedParams.class */
    static final class NetworkContextClientOnCookiesChangedParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isServiceWorker;
        public int processId;
        public int routingId;
        public Url url;
        public Url siteForCookies;
        public CookieWithStatus[] cookieList;

        private NetworkContextClientOnCookiesChangedParams(int version) {
            super(48, version);
        }

        public NetworkContextClientOnCookiesChangedParams() {
            this(0);
        }

        public static NetworkContextClientOnCookiesChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnCookiesChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnCookiesChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnCookiesChangedParams result = new NetworkContextClientOnCookiesChangedParams(elementsOrVersion);
                result.isServiceWorker = decoder0.readBoolean(8, 0);
                result.processId = decoder0.readInt(12);
                result.routingId = decoder0.readInt(16);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.siteForCookies = Url.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(40, false);
                DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
                result.cookieList = new CookieWithStatus[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                    result.cookieList[i1] = CookieWithStatus.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.isServiceWorker, 8, 0);
            encoder0.encode(this.processId, 12);
            encoder0.encode(this.routingId, 16);
            encoder0.encode((Struct) this.url, 24, false);
            encoder0.encode((Struct) this.siteForCookies, 32, false);
            if (this.cookieList == null) {
                encoder0.encodeNullPointer(40, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.cookieList.length, 40, -1);
            for (int i0 = 0; i0 < this.cookieList.length; i0++) {
                encoder1.encode((Struct) this.cookieList[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkContextClient_Internal$NetworkContextClientOnCookiesReadParams.class */
    static final class NetworkContextClientOnCookiesReadParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isServiceWorker;
        public int processId;
        public int routingId;
        public Url url;
        public Url siteForCookies;
        public CookieWithStatus[] cookieList;

        private NetworkContextClientOnCookiesReadParams(int version) {
            super(48, version);
        }

        public NetworkContextClientOnCookiesReadParams() {
            this(0);
        }

        public static NetworkContextClientOnCookiesReadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkContextClientOnCookiesReadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkContextClientOnCookiesReadParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkContextClientOnCookiesReadParams result = new NetworkContextClientOnCookiesReadParams(elementsOrVersion);
                result.isServiceWorker = decoder0.readBoolean(8, 0);
                result.processId = decoder0.readInt(12);
                result.routingId = decoder0.readInt(16);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.siteForCookies = Url.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(40, false);
                DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
                result.cookieList = new CookieWithStatus[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                    result.cookieList[i1] = CookieWithStatus.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.isServiceWorker, 8, 0);
            encoder0.encode(this.processId, 12);
            encoder0.encode(this.routingId, 16);
            encoder0.encode((Struct) this.url, 24, false);
            encoder0.encode((Struct) this.siteForCookies, 32, false);
            if (this.cookieList == null) {
                encoder0.encodeNullPointer(40, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.cookieList.length, 40, -1);
            for (int i0 = 0; i0 < this.cookieList.length; i0++) {
                encoder1.encode((Struct) this.cookieList[i0], 8 + (8 * i0), false);
            }
        }
    }
}
