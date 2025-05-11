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
import org.chromium.mojo_base.mojom.File;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.NetworkServiceClient;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal.class */
class NetworkServiceClient_Internal {
    public static final Interface.Manager<NetworkServiceClient, NetworkServiceClient.Proxy> MANAGER = new Interface.Manager<NetworkServiceClient, NetworkServiceClient.Proxy>() { // from class: org.chromium.network.mojom.NetworkServiceClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.NetworkServiceClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public NetworkServiceClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, NetworkServiceClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public NetworkServiceClient[] buildArray(int size) {
            return new NetworkServiceClient[size];
        }
    };
    private static final int ON_AUTH_REQUIRED_ORDINAL = 0;
    private static final int ON_CERTIFICATE_REQUESTED_ORDINAL = 1;
    private static final int ON_SSL_CERTIFICATE_ERROR_ORDINAL = 2;
    private static final int ON_FILE_UPLOAD_REQUESTED_ORDINAL = 3;
    private static final int ON_LOADING_STATE_UPDATE_ORDINAL = 4;
    private static final int ON_DATA_USE_UPDATE_ORDINAL = 5;
    private static final int ON_GENERATE_HTTP_NEGOTIATE_AUTH_TOKEN_ORDINAL = 6;
    private static final int ON_RAW_REQUEST_ORDINAL = 7;
    private static final int ON_RAW_RESPONSE_ORDINAL = 8;

    NetworkServiceClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements NetworkServiceClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onAuthRequired(UnguessableToken windowId, int processId, int routingId, int requestId, Url url, boolean firstAuthAttempt, AuthChallengeInfo authInfo, UrlResponseHead head, AuthChallengeResponder authChallengeResponder) {
            NetworkServiceClientOnAuthRequiredParams _message = new NetworkServiceClientOnAuthRequiredParams();
            _message.windowId = windowId;
            _message.processId = processId;
            _message.routingId = routingId;
            _message.requestId = requestId;
            _message.url = url;
            _message.firstAuthAttempt = firstAuthAttempt;
            _message.authInfo = authInfo;
            _message.head = head;
            _message.authChallengeResponder = authChallengeResponder;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onCertificateRequested(UnguessableToken windowId, int processId, int routingId, int requestId, SslCertRequestInfo certInfo, ClientCertificateResponder certResponder) {
            NetworkServiceClientOnCertificateRequestedParams _message = new NetworkServiceClientOnCertificateRequestedParams();
            _message.windowId = windowId;
            _message.processId = processId;
            _message.routingId = routingId;
            _message.requestId = requestId;
            _message.certInfo = certInfo;
            _message.certResponder = certResponder;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onSslCertificateError(int processId, int routingId, Url url, int netError, SslInfo sslInfo, boolean fatal, NetworkServiceClient.OnSslCertificateErrorResponse callback) {
            NetworkServiceClientOnSslCertificateErrorParams _message = new NetworkServiceClientOnSslCertificateErrorParams();
            _message.processId = processId;
            _message.routingId = routingId;
            _message.url = url;
            _message.netError = netError;
            _message.sslInfo = sslInfo;
            _message.fatal = fatal;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NetworkServiceClientOnSslCertificateErrorResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onFileUploadRequested(int processId, boolean async, FilePath[] filePaths, NetworkServiceClient.OnFileUploadRequestedResponse callback) {
            NetworkServiceClientOnFileUploadRequestedParams _message = new NetworkServiceClientOnFileUploadRequestedParams();
            _message.processId = processId;
            _message.async = async;
            _message.filePaths = filePaths;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new NetworkServiceClientOnFileUploadRequestedResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onLoadingStateUpdate(LoadInfo[] infos, NetworkServiceClient.OnLoadingStateUpdateResponse callback) {
            NetworkServiceClientOnLoadingStateUpdateParams _message = new NetworkServiceClientOnLoadingStateUpdateParams();
            _message.infos = infos;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new NetworkServiceClientOnLoadingStateUpdateResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onDataUseUpdate(int networkTrafficAnnotationIdHash, long recvBytes, long sentBytes) {
            NetworkServiceClientOnDataUseUpdateParams _message = new NetworkServiceClientOnDataUseUpdateParams();
            _message.networkTrafficAnnotationIdHash = networkTrafficAnnotationIdHash;
            _message.recvBytes = recvBytes;
            _message.sentBytes = sentBytes;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onGenerateHttpNegotiateAuthToken(String serverAuthToken, boolean canDelegate, String authNegotiateAndroidAccountType, String spn, NetworkServiceClient.OnGenerateHttpNegotiateAuthTokenResponse callback) {
            NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams _message = new NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams();
            _message.serverAuthToken = serverAuthToken;
            _message.canDelegate = canDelegate;
            _message.authNegotiateAndroidAccountType = authNegotiateAndroidAccountType;
            _message.spn = spn;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onRawRequest(int processId, int routingId, String devtoolRequestId, CookieWithStatus[] cookiesWithStatus, HttpRawHeaderPair[] headers) {
            NetworkServiceClientOnRawRequestParams _message = new NetworkServiceClientOnRawRequestParams();
            _message.processId = processId;
            _message.routingId = routingId;
            _message.devtoolRequestId = devtoolRequestId;
            _message.cookiesWithStatus = cookiesWithStatus;
            _message.headers = headers;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.network.mojom.NetworkServiceClient
        public void onRawResponse(int processId, int routingId, String devtoolRequestId, CookieAndLineWithStatus[] cookiesWithStatus, HttpRawHeaderPair[] headers, String rawResponseHeaders) {
            NetworkServiceClientOnRawResponseParams _message = new NetworkServiceClientOnRawResponseParams();
            _message.processId = processId;
            _message.routingId = routingId;
            _message.devtoolRequestId = devtoolRequestId;
            _message.cookiesWithStatus = cookiesWithStatus;
            _message.headers = headers;
            _message.rawResponseHeaders = rawResponseHeaders;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<NetworkServiceClient> {
        Stub(Core core, NetworkServiceClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NetworkServiceClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    default:
                        return false;
                    case 0:
                        NetworkServiceClientOnAuthRequiredParams data = NetworkServiceClientOnAuthRequiredParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onAuthRequired(data.windowId, data.processId, data.routingId, data.requestId, data.url, data.firstAuthAttempt, data.authInfo, data.head, data.authChallengeResponder);
                        return true;
                    case 1:
                        NetworkServiceClientOnCertificateRequestedParams data2 = NetworkServiceClientOnCertificateRequestedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onCertificateRequested(data2.windowId, data2.processId, data2.routingId, data2.requestId, data2.certInfo, data2.certResponder);
                        return true;
                    case 5:
                        NetworkServiceClientOnDataUseUpdateParams data3 = NetworkServiceClientOnDataUseUpdateParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onDataUseUpdate(data3.networkTrafficAnnotationIdHash, data3.recvBytes, data3.sentBytes);
                        return true;
                    case 7:
                        NetworkServiceClientOnRawRequestParams data4 = NetworkServiceClientOnRawRequestParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onRawRequest(data4.processId, data4.routingId, data4.devtoolRequestId, data4.cookiesWithStatus, data4.headers);
                        return true;
                    case 8:
                        NetworkServiceClientOnRawResponseParams data5 = NetworkServiceClientOnRawResponseParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onRawResponse(data5.processId, data5.routingId, data5.devtoolRequestId, data5.cookiesWithStatus, data5.headers, data5.rawResponseHeaders);
                        return true;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), NetworkServiceClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                    case 1:
                    case 5:
                    default:
                        return false;
                    case 2:
                        NetworkServiceClientOnSslCertificateErrorParams data = NetworkServiceClientOnSslCertificateErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onSslCertificateError(data.processId, data.routingId, data.url, data.netError, data.sslInfo, data.fatal, new NetworkServiceClientOnSslCertificateErrorResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        NetworkServiceClientOnFileUploadRequestedParams data2 = NetworkServiceClientOnFileUploadRequestedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onFileUploadRequested(data2.processId, data2.async, data2.filePaths, new NetworkServiceClientOnFileUploadRequestedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        getImpl().onLoadingStateUpdate(NetworkServiceClientOnLoadingStateUpdateParams.deserialize(messageWithHeader.getPayload()).infos, new NetworkServiceClientOnLoadingStateUpdateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams data3 = NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onGenerateHttpNegotiateAuthToken(data3.serverAuthToken, data3.canDelegate, data3.authNegotiateAndroidAccountType, data3.spn, new NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnAuthRequiredParams.class */
    static final class NetworkServiceClientOnAuthRequiredParams extends Struct {
        private static final int STRUCT_SIZE = 64;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken windowId;
        public int processId;
        public int routingId;
        public int requestId;
        public Url url;
        public boolean firstAuthAttempt;
        public AuthChallengeInfo authInfo;
        public UrlResponseHead head;
        public AuthChallengeResponder authChallengeResponder;

        private NetworkServiceClientOnAuthRequiredParams(int version) {
            super(64, version);
        }

        public NetworkServiceClientOnAuthRequiredParams() {
            this(0);
        }

        public static NetworkServiceClientOnAuthRequiredParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnAuthRequiredParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnAuthRequiredParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnAuthRequiredParams result = new NetworkServiceClientOnAuthRequiredParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.windowId = UnguessableToken.decode(decoder1);
                result.processId = decoder0.readInt(16);
                result.routingId = decoder0.readInt(20);
                result.requestId = decoder0.readInt(24);
                result.firstAuthAttempt = decoder0.readBoolean(28, 0);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.url = Url.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(40, false);
                result.authInfo = AuthChallengeInfo.decode(decoder13);
                Decoder decoder14 = decoder0.readPointer(48, true);
                result.head = UrlResponseHead.decode(decoder14);
                result.authChallengeResponder = (AuthChallengeResponder) decoder0.readServiceInterface(56, false, AuthChallengeResponder.MANAGER);
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
            encoder0.encode((Struct) this.windowId, 8, true);
            encoder0.encode(this.processId, 16);
            encoder0.encode(this.routingId, 20);
            encoder0.encode(this.requestId, 24);
            encoder0.encode(this.firstAuthAttempt, 28, 0);
            encoder0.encode((Struct) this.url, 32, false);
            encoder0.encode((Struct) this.authInfo, 40, false);
            encoder0.encode((Struct) this.head, 48, true);
            encoder0.encode(this.authChallengeResponder,56,false, AuthChallengeResponder.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnCertificateRequestedParams.class */
    static final class NetworkServiceClientOnCertificateRequestedParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken windowId;
        public int processId;
        public int routingId;
        public int requestId;
        public SslCertRequestInfo certInfo;
        public ClientCertificateResponder certResponder;

        private NetworkServiceClientOnCertificateRequestedParams(int version) {
            super(48, version);
        }

        public NetworkServiceClientOnCertificateRequestedParams() {
            this(0);
        }

        public static NetworkServiceClientOnCertificateRequestedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnCertificateRequestedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnCertificateRequestedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnCertificateRequestedParams result = new NetworkServiceClientOnCertificateRequestedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.windowId = UnguessableToken.decode(decoder1);
                result.processId = decoder0.readInt(16);
                result.routingId = decoder0.readInt(20);
                result.requestId = decoder0.readInt(24);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.certInfo = SslCertRequestInfo.decode(decoder12);
                result.certResponder = (ClientCertificateResponder) decoder0.readServiceInterface(40, false, ClientCertificateResponder.MANAGER);
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
            encoder0.encode((Struct) this.windowId, 8, true);
            encoder0.encode(this.processId, 16);
            encoder0.encode(this.routingId, 20);
            encoder0.encode(this.requestId, 24);
            encoder0.encode((Struct) this.certInfo, 32, false);
            encoder0.encode(this.certResponder,40,false, ClientCertificateResponder.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnSslCertificateErrorParams.class */
    static final class NetworkServiceClientOnSslCertificateErrorParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public int routingId;
        public Url url;
        public int netError;
        public SslInfo sslInfo;
        public boolean fatal;

        private NetworkServiceClientOnSslCertificateErrorParams(int version) {
            super(40, version);
        }

        public NetworkServiceClientOnSslCertificateErrorParams() {
            this(0);
        }

        public static NetworkServiceClientOnSslCertificateErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnSslCertificateErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnSslCertificateErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnSslCertificateErrorParams result = new NetworkServiceClientOnSslCertificateErrorParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
                result.routingId = decoder0.readInt(12);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
                result.netError = decoder0.readInt(24);
                result.fatal = decoder0.readBoolean(28, 0);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.sslInfo = SslInfo.decode(decoder12);
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
            encoder0.encode(this.netError, 24);
            encoder0.encode(this.fatal, 28, 0);
            encoder0.encode((Struct) this.sslInfo, 32, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnSslCertificateErrorResponseParams.class */
    public static final class NetworkServiceClientOnSslCertificateErrorResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;

        private NetworkServiceClientOnSslCertificateErrorResponseParams(int version) {
            super(16, version);
        }

        public NetworkServiceClientOnSslCertificateErrorResponseParams() {
            this(0);
        }

        public static NetworkServiceClientOnSslCertificateErrorResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnSslCertificateErrorResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnSslCertificateErrorResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnSslCertificateErrorResponseParams result = new NetworkServiceClientOnSslCertificateErrorResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
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
            encoder0.encode(this.netError, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnSslCertificateErrorResponseParamsForwardToCallback.class */
    static class NetworkServiceClientOnSslCertificateErrorResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceClient.OnSslCertificateErrorResponse mCallback;

        NetworkServiceClientOnSslCertificateErrorResponseParamsForwardToCallback(NetworkServiceClient.OnSslCertificateErrorResponse callback) {
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
                NetworkServiceClientOnSslCertificateErrorResponseParams response = NetworkServiceClientOnSslCertificateErrorResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnSslCertificateErrorResponseParamsProxyToResponder.class */
    static class NetworkServiceClientOnSslCertificateErrorResponseParamsProxyToResponder implements NetworkServiceClient.OnSslCertificateErrorResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceClientOnSslCertificateErrorResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer netError) {
            NetworkServiceClientOnSslCertificateErrorResponseParams _response = new NetworkServiceClientOnSslCertificateErrorResponseParams();
            _response.netError = netError.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnFileUploadRequestedParams.class */
    static final class NetworkServiceClientOnFileUploadRequestedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public boolean async;
        public FilePath[] filePaths;

        private NetworkServiceClientOnFileUploadRequestedParams(int version) {
            super(24, version);
        }

        public NetworkServiceClientOnFileUploadRequestedParams() {
            this(0);
        }

        public static NetworkServiceClientOnFileUploadRequestedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnFileUploadRequestedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnFileUploadRequestedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnFileUploadRequestedParams result = new NetworkServiceClientOnFileUploadRequestedParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
                result.async = decoder0.readBoolean(12, 0);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.filePaths = new FilePath[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.filePaths[i1] = FilePath.decode(decoder2);
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
            encoder0.encode(this.processId, 8);
            encoder0.encode(this.async, 12, 0);
            if (this.filePaths == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.filePaths.length, 16, -1);
            for (int i0 = 0; i0 < this.filePaths.length; i0++) {
                encoder1.encode((Struct) this.filePaths[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnFileUploadRequestedResponseParams.class */
    public static final class NetworkServiceClientOnFileUploadRequestedResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public File[] files;

        private NetworkServiceClientOnFileUploadRequestedResponseParams(int version) {
            super(24, version);
        }

        public NetworkServiceClientOnFileUploadRequestedResponseParams() {
            this(0);
        }

        public static NetworkServiceClientOnFileUploadRequestedResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnFileUploadRequestedResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnFileUploadRequestedResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnFileUploadRequestedResponseParams result = new NetworkServiceClientOnFileUploadRequestedResponseParams(elementsOrVersion);
                result.netError = decoder0.readInt(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.files = new File[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.files[i1] = File.decode(decoder2);
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
            encoder0.encode(this.netError, 8);
            if (this.files == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.files.length, 16, -1);
            for (int i0 = 0; i0 < this.files.length; i0++) {
                encoder1.encode((Struct) this.files[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnFileUploadRequestedResponseParamsForwardToCallback.class */
    static class NetworkServiceClientOnFileUploadRequestedResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceClient.OnFileUploadRequestedResponse mCallback;

        NetworkServiceClientOnFileUploadRequestedResponseParamsForwardToCallback(NetworkServiceClient.OnFileUploadRequestedResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                NetworkServiceClientOnFileUploadRequestedResponseParams response = NetworkServiceClientOnFileUploadRequestedResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.netError), response.files);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnFileUploadRequestedResponseParamsProxyToResponder.class */
    static class NetworkServiceClientOnFileUploadRequestedResponseParamsProxyToResponder implements NetworkServiceClient.OnFileUploadRequestedResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceClientOnFileUploadRequestedResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer netError, File[] files) {
            NetworkServiceClientOnFileUploadRequestedResponseParams _response = new NetworkServiceClientOnFileUploadRequestedResponseParams();
            _response.netError = netError.intValue();
            _response.files = files;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnLoadingStateUpdateParams.class */
    static final class NetworkServiceClientOnLoadingStateUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public LoadInfo[] infos;

        private NetworkServiceClientOnLoadingStateUpdateParams(int version) {
            super(16, version);
        }

        public NetworkServiceClientOnLoadingStateUpdateParams() {
            this(0);
        }

        public static NetworkServiceClientOnLoadingStateUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnLoadingStateUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnLoadingStateUpdateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnLoadingStateUpdateParams result = new NetworkServiceClientOnLoadingStateUpdateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.infos = new LoadInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.infos[i1] = LoadInfo.decode(decoder2);
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
            if (this.infos == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.infos.length, 8, -1);
            for (int i0 = 0; i0 < this.infos.length; i0++) {
                encoder1.encode((Struct) this.infos[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnLoadingStateUpdateResponseParams.class */
    static final class NetworkServiceClientOnLoadingStateUpdateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceClientOnLoadingStateUpdateResponseParams(int version) {
            super(8, version);
        }

        public NetworkServiceClientOnLoadingStateUpdateResponseParams() {
            this(0);
        }

        public static NetworkServiceClientOnLoadingStateUpdateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnLoadingStateUpdateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnLoadingStateUpdateResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnLoadingStateUpdateResponseParams result = new NetworkServiceClientOnLoadingStateUpdateResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnLoadingStateUpdateResponseParamsForwardToCallback.class */
    static class NetworkServiceClientOnLoadingStateUpdateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceClient.OnLoadingStateUpdateResponse mCallback;

        NetworkServiceClientOnLoadingStateUpdateResponseParamsForwardToCallback(NetworkServiceClient.OnLoadingStateUpdateResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnLoadingStateUpdateResponseParamsProxyToResponder.class */
    static class NetworkServiceClientOnLoadingStateUpdateResponseParamsProxyToResponder implements NetworkServiceClient.OnLoadingStateUpdateResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceClientOnLoadingStateUpdateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            NetworkServiceClientOnLoadingStateUpdateResponseParams _response = new NetworkServiceClientOnLoadingStateUpdateResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnDataUseUpdateParams.class */
    static final class NetworkServiceClientOnDataUseUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int networkTrafficAnnotationIdHash;
        public long recvBytes;
        public long sentBytes;

        private NetworkServiceClientOnDataUseUpdateParams(int version) {
            super(32, version);
        }

        public NetworkServiceClientOnDataUseUpdateParams() {
            this(0);
        }

        public static NetworkServiceClientOnDataUseUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnDataUseUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnDataUseUpdateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnDataUseUpdateParams result = new NetworkServiceClientOnDataUseUpdateParams(elementsOrVersion);
                result.networkTrafficAnnotationIdHash = decoder0.readInt(8);
                result.recvBytes = decoder0.readLong(16);
                result.sentBytes = decoder0.readLong(24);
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
            encoder0.encode(this.networkTrafficAnnotationIdHash, 8);
            encoder0.encode(this.recvBytes, 16);
            encoder0.encode(this.sentBytes, 24);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams.class */
    static final class NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String serverAuthToken;
        public boolean canDelegate;
        public String authNegotiateAndroidAccountType;
        public String spn;

        private NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams(int version) {
            super(40, version);
        }

        public NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams() {
            this(0);
        }

        public static NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams result = new NetworkServiceClientOnGenerateHttpNegotiateAuthTokenParams(elementsOrVersion);
                result.serverAuthToken = decoder0.readString(8, false);
                result.canDelegate = decoder0.readBoolean(16, 0);
                result.authNegotiateAndroidAccountType = decoder0.readString(24, false);
                result.spn = decoder0.readString(32, false);
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
            encoder0.encode(this.serverAuthToken, 8, false);
            encoder0.encode(this.canDelegate, 16, 0);
            encoder0.encode(this.authNegotiateAndroidAccountType, 24, false);
            encoder0.encode(this.spn, 32, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams.class */
    public static final class NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public String authToken;

        private NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams(int version) {
            super(24, version);
        }

        public NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams() {
            this(0);
        }

        public static NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams result = new NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                result.authToken = decoder0.readString(16, false);
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
            encoder0.encode(this.result, 8);
            encoder0.encode(this.authToken, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback.class */
    static class NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NetworkServiceClient.OnGenerateHttpNegotiateAuthTokenResponse mCallback;

        NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsForwardToCallback(NetworkServiceClient.OnGenerateHttpNegotiateAuthTokenResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2)) {
                    return false;
                }
                NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams response = NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.authToken);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder.class */
    static class NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder implements NetworkServiceClient.OnGenerateHttpNegotiateAuthTokenResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, String authToken) {
            NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams _response = new NetworkServiceClientOnGenerateHttpNegotiateAuthTokenResponseParams();
            _response.result = result.intValue();
            _response.authToken = authToken;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnRawRequestParams.class */
    static final class NetworkServiceClientOnRawRequestParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public int routingId;
        public String devtoolRequestId;
        public CookieWithStatus[] cookiesWithStatus;
        public HttpRawHeaderPair[] headers;

        private NetworkServiceClientOnRawRequestParams(int version) {
            super(40, version);
        }

        public NetworkServiceClientOnRawRequestParams() {
            this(0);
        }

        public static NetworkServiceClientOnRawRequestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnRawRequestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnRawRequestParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnRawRequestParams result = new NetworkServiceClientOnRawRequestParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
                result.routingId = decoder0.readInt(12);
                result.devtoolRequestId = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.cookiesWithStatus = new CookieWithStatus[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.cookiesWithStatus[i1] = CookieWithStatus.decode(decoder2);
                }
                Decoder decoder12 = decoder0.readPointer(32, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.headers = new HttpRawHeaderPair[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                    result.headers[i12] = HttpRawHeaderPair.decode(decoder22);
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
            encoder0.encode(this.processId, 8);
            encoder0.encode(this.routingId, 12);
            encoder0.encode(this.devtoolRequestId, 16, false);
            if (this.cookiesWithStatus == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.cookiesWithStatus.length, 24, -1);
                for (int i0 = 0; i0 < this.cookiesWithStatus.length; i0++) {
                    encoder1.encode((Struct) this.cookiesWithStatus[i0], 8 + (8 * i0), false);
                }
            }
            if (this.headers == null) {
                encoder0.encodeNullPointer(32, false);
                return;
            }
            Encoder encoder12 = encoder0.encodePointerArray(this.headers.length, 32, -1);
            for (int i02 = 0; i02 < this.headers.length; i02++) {
                encoder12.encode((Struct) this.headers[i02], 8 + (8 * i02), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkServiceClient_Internal$NetworkServiceClientOnRawResponseParams.class */
    static final class NetworkServiceClientOnRawResponseParams extends Struct {
        private static final int STRUCT_SIZE = 48;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public int routingId;
        public String devtoolRequestId;
        public CookieAndLineWithStatus[] cookiesWithStatus;
        public HttpRawHeaderPair[] headers;
        public String rawResponseHeaders;

        private NetworkServiceClientOnRawResponseParams(int version) {
            super(48, version);
        }

        public NetworkServiceClientOnRawResponseParams() {
            this(0);
        }

        public static NetworkServiceClientOnRawResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NetworkServiceClientOnRawResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NetworkServiceClientOnRawResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                NetworkServiceClientOnRawResponseParams result = new NetworkServiceClientOnRawResponseParams(elementsOrVersion);
                result.processId = decoder0.readInt(8);
                result.routingId = decoder0.readInt(12);
                result.devtoolRequestId = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.cookiesWithStatus = new CookieAndLineWithStatus[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.cookiesWithStatus[i1] = CookieAndLineWithStatus.decode(decoder2);
                }
                Decoder decoder12 = decoder0.readPointer(32, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.headers = new HttpRawHeaderPair[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                    result.headers[i12] = HttpRawHeaderPair.decode(decoder22);
                }
                result.rawResponseHeaders = decoder0.readString(40, true);
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
            encoder0.encode(this.devtoolRequestId, 16, false);
            if (this.cookiesWithStatus == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.cookiesWithStatus.length, 24, -1);
                for (int i0 = 0; i0 < this.cookiesWithStatus.length; i0++) {
                    encoder1.encode((Struct) this.cookiesWithStatus[i0], 8 + (8 * i0), false);
                }
            }
            if (this.headers == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                Encoder encoder12 = encoder0.encodePointerArray(this.headers.length, 32, -1);
                for (int i02 = 0; i02 < this.headers.length; i02++) {
                    encoder12.encode((Struct) this.headers[i02], 8 + (8 * i02), false);
                }
            }
            encoder0.encode(this.rawResponseHeaders, 40, true);
        }
    }
}
