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
import org.chromium.network.mojom.RestrictedCookieManager;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal.class */
class RestrictedCookieManager_Internal {
    public static final Interface.Manager<RestrictedCookieManager, RestrictedCookieManager.Proxy> MANAGER = new Interface.Manager<RestrictedCookieManager, RestrictedCookieManager.Proxy>() { // from class: org.chromium.network.mojom.RestrictedCookieManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.RestrictedCookieManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public RestrictedCookieManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, RestrictedCookieManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public RestrictedCookieManager[] buildArray(int size) {
            return new RestrictedCookieManager[size];
        }
    };
    private static final int GET_ALL_FOR_URL_ORDINAL = 0;
    private static final int SET_CANONICAL_COOKIE_ORDINAL = 1;
    private static final int ADD_CHANGE_LISTENER_ORDINAL = 2;
    private static final int SET_COOKIE_FROM_STRING_ORDINAL = 3;
    private static final int GET_COOKIES_STRING_ORDINAL = 4;
    private static final int COOKIES_ENABLED_FOR_ORDINAL = 5;

    RestrictedCookieManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements RestrictedCookieManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.RestrictedCookieManager
        public void getAllForUrl(Url url, Url siteForCookies, CookieManagerGetOptions options, RestrictedCookieManager.GetAllForUrlResponse callback) {
            RestrictedCookieManagerGetAllForUrlParams _message = new RestrictedCookieManagerGetAllForUrlParams();
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new RestrictedCookieManagerGetAllForUrlResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.RestrictedCookieManager
        public void setCanonicalCookie(CanonicalCookie cookie, Url url, Url siteForCookies, RestrictedCookieManager.SetCanonicalCookieResponse callback) {
            RestrictedCookieManagerSetCanonicalCookieParams _message = new RestrictedCookieManagerSetCanonicalCookieParams();
            _message.cookie = cookie;
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new RestrictedCookieManagerSetCanonicalCookieResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.RestrictedCookieManager
        public void addChangeListener(Url url, Url siteForCookies, CookieChangeListener listener, RestrictedCookieManager.AddChangeListenerResponse callback) {
            RestrictedCookieManagerAddChangeListenerParams _message = new RestrictedCookieManagerAddChangeListenerParams();
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            _message.listener = listener;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new RestrictedCookieManagerAddChangeListenerResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.RestrictedCookieManager
        public void setCookieFromString(Url url, Url siteForCookies, String cookie, RestrictedCookieManager.SetCookieFromStringResponse callback) {
            RestrictedCookieManagerSetCookieFromStringParams _message = new RestrictedCookieManagerSetCookieFromStringParams();
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            _message.cookie = cookie;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new RestrictedCookieManagerSetCookieFromStringResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.RestrictedCookieManager
        public void getCookiesString(Url url, Url siteForCookies, RestrictedCookieManager.GetCookiesStringResponse callback) {
            RestrictedCookieManagerGetCookiesStringParams _message = new RestrictedCookieManagerGetCookiesStringParams();
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new RestrictedCookieManagerGetCookiesStringResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.RestrictedCookieManager
        public void cookiesEnabledFor(Url url, Url siteForCookies, RestrictedCookieManager.CookiesEnabledForResponse callback) {
            RestrictedCookieManagerCookiesEnabledForParams _message = new RestrictedCookieManagerCookiesEnabledForParams();
            _message.url = url;
            _message.siteForCookies = siteForCookies;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new RestrictedCookieManagerCookiesEnabledForResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<RestrictedCookieManager> {
        Stub(Core core, RestrictedCookieManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(RestrictedCookieManager_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), RestrictedCookieManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        RestrictedCookieManagerGetAllForUrlParams data = RestrictedCookieManagerGetAllForUrlParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getAllForUrl(data.url, data.siteForCookies, data.options, new RestrictedCookieManagerGetAllForUrlResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        RestrictedCookieManagerSetCanonicalCookieParams data2 = RestrictedCookieManagerSetCanonicalCookieParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setCanonicalCookie(data2.cookie, data2.url, data2.siteForCookies, new RestrictedCookieManagerSetCanonicalCookieResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        RestrictedCookieManagerAddChangeListenerParams data3 = RestrictedCookieManagerAddChangeListenerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addChangeListener(data3.url, data3.siteForCookies, data3.listener, new RestrictedCookieManagerAddChangeListenerResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        RestrictedCookieManagerSetCookieFromStringParams data4 = RestrictedCookieManagerSetCookieFromStringParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setCookieFromString(data4.url, data4.siteForCookies, data4.cookie, new RestrictedCookieManagerSetCookieFromStringResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        RestrictedCookieManagerGetCookiesStringParams data5 = RestrictedCookieManagerGetCookiesStringParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getCookiesString(data5.url, data5.siteForCookies, new RestrictedCookieManagerGetCookiesStringResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        RestrictedCookieManagerCookiesEnabledForParams data6 = RestrictedCookieManagerCookiesEnabledForParams.deserialize(messageWithHeader.getPayload());
                        getImpl().cookiesEnabledFor(data6.url, data6.siteForCookies, new RestrictedCookieManagerCookiesEnabledForResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetAllForUrlParams.class */
    static final class RestrictedCookieManagerGetAllForUrlParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public Url siteForCookies;
        public CookieManagerGetOptions options;

        private RestrictedCookieManagerGetAllForUrlParams(int version) {
            super(32, version);
        }

        public RestrictedCookieManagerGetAllForUrlParams() {
            this(0);
        }

        public static RestrictedCookieManagerGetAllForUrlParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerGetAllForUrlParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerGetAllForUrlParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerGetAllForUrlParams result = new RestrictedCookieManagerGetAllForUrlParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.siteForCookies = Url.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, false);
                result.options = CookieManagerGetOptions.decode(decoder13);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode((Struct) this.siteForCookies, 16, false);
            encoder0.encode((Struct) this.options, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetAllForUrlResponseParams.class */
    public static final class RestrictedCookieManagerGetAllForUrlResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie[] cookies;

        private RestrictedCookieManagerGetAllForUrlResponseParams(int version) {
            super(16, version);
        }

        public RestrictedCookieManagerGetAllForUrlResponseParams() {
            this(0);
        }

        public static RestrictedCookieManagerGetAllForUrlResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerGetAllForUrlResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerGetAllForUrlResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerGetAllForUrlResponseParams result = new RestrictedCookieManagerGetAllForUrlResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.cookies = new CanonicalCookie[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.cookies[i1] = CanonicalCookie.decode(decoder2);
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
            if (this.cookies == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.cookies.length, 8, -1);
            for (int i0 = 0; i0 < this.cookies.length; i0++) {
                encoder1.encode((Struct) this.cookies[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetAllForUrlResponseParamsForwardToCallback.class */
    static class RestrictedCookieManagerGetAllForUrlResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RestrictedCookieManager.GetAllForUrlResponse mCallback;

        RestrictedCookieManagerGetAllForUrlResponseParamsForwardToCallback(RestrictedCookieManager.GetAllForUrlResponse callback) {
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
                RestrictedCookieManagerGetAllForUrlResponseParams response = RestrictedCookieManagerGetAllForUrlResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.cookies);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetAllForUrlResponseParamsProxyToResponder.class */
    static class RestrictedCookieManagerGetAllForUrlResponseParamsProxyToResponder implements RestrictedCookieManager.GetAllForUrlResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedCookieManagerGetAllForUrlResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(CanonicalCookie[] cookies) {
            RestrictedCookieManagerGetAllForUrlResponseParams _response = new RestrictedCookieManagerGetAllForUrlResponseParams();
            _response.cookies = cookies;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCanonicalCookieParams.class */
    static final class RestrictedCookieManagerSetCanonicalCookieParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie cookie;
        public Url url;
        public Url siteForCookies;

        private RestrictedCookieManagerSetCanonicalCookieParams(int version) {
            super(32, version);
        }

        public RestrictedCookieManagerSetCanonicalCookieParams() {
            this(0);
        }

        public static RestrictedCookieManagerSetCanonicalCookieParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerSetCanonicalCookieParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerSetCanonicalCookieParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerSetCanonicalCookieParams result = new RestrictedCookieManagerSetCanonicalCookieParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cookie = CanonicalCookie.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, false);
                result.siteForCookies = Url.decode(decoder13);
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
            encoder0.encode((Struct) this.cookie, 8, false);
            encoder0.encode((Struct) this.url, 16, false);
            encoder0.encode((Struct) this.siteForCookies, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCanonicalCookieResponseParams.class */
    public static final class RestrictedCookieManagerSetCanonicalCookieResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private RestrictedCookieManagerSetCanonicalCookieResponseParams(int version) {
            super(16, version);
        }

        public RestrictedCookieManagerSetCanonicalCookieResponseParams() {
            this(0);
        }

        public static RestrictedCookieManagerSetCanonicalCookieResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerSetCanonicalCookieResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerSetCanonicalCookieResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerSetCanonicalCookieResponseParams result = new RestrictedCookieManagerSetCanonicalCookieResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.success, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCanonicalCookieResponseParamsForwardToCallback.class */
    static class RestrictedCookieManagerSetCanonicalCookieResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RestrictedCookieManager.SetCanonicalCookieResponse mCallback;

        RestrictedCookieManagerSetCanonicalCookieResponseParamsForwardToCallback(RestrictedCookieManager.SetCanonicalCookieResponse callback) {
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
                RestrictedCookieManagerSetCanonicalCookieResponseParams response = RestrictedCookieManagerSetCanonicalCookieResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCanonicalCookieResponseParamsProxyToResponder.class */
    static class RestrictedCookieManagerSetCanonicalCookieResponseParamsProxyToResponder implements RestrictedCookieManager.SetCanonicalCookieResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedCookieManagerSetCanonicalCookieResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            RestrictedCookieManagerSetCanonicalCookieResponseParams _response = new RestrictedCookieManagerSetCanonicalCookieResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerAddChangeListenerParams.class */
    static final class RestrictedCookieManagerAddChangeListenerParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public Url siteForCookies;
        public CookieChangeListener listener;

        private RestrictedCookieManagerAddChangeListenerParams(int version) {
            super(32, version);
        }

        public RestrictedCookieManagerAddChangeListenerParams() {
            this(0);
        }

        public static RestrictedCookieManagerAddChangeListenerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerAddChangeListenerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerAddChangeListenerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerAddChangeListenerParams result = new RestrictedCookieManagerAddChangeListenerParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.siteForCookies = Url.decode(decoder12);
                result.listener = (CookieChangeListener) decoder0.readServiceInterface(24, false, CookieChangeListener.MANAGER);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode((Struct) this.siteForCookies, 16, false);
            encoder0.encode(this.listener,24,false, CookieChangeListener.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerAddChangeListenerResponseParams.class */
    static final class RestrictedCookieManagerAddChangeListenerResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RestrictedCookieManagerAddChangeListenerResponseParams(int version) {
            super(8, version);
        }

        public RestrictedCookieManagerAddChangeListenerResponseParams() {
            this(0);
        }

        public static RestrictedCookieManagerAddChangeListenerResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerAddChangeListenerResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerAddChangeListenerResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerAddChangeListenerResponseParams result = new RestrictedCookieManagerAddChangeListenerResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerAddChangeListenerResponseParamsForwardToCallback.class */
    static class RestrictedCookieManagerAddChangeListenerResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RestrictedCookieManager.AddChangeListenerResponse mCallback;

        RestrictedCookieManagerAddChangeListenerResponseParamsForwardToCallback(RestrictedCookieManager.AddChangeListenerResponse callback) {
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerAddChangeListenerResponseParamsProxyToResponder.class */
    static class RestrictedCookieManagerAddChangeListenerResponseParamsProxyToResponder implements RestrictedCookieManager.AddChangeListenerResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedCookieManagerAddChangeListenerResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            RestrictedCookieManagerAddChangeListenerResponseParams _response = new RestrictedCookieManagerAddChangeListenerResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCookieFromStringParams.class */
    static final class RestrictedCookieManagerSetCookieFromStringParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public Url siteForCookies;
        public String cookie;

        private RestrictedCookieManagerSetCookieFromStringParams(int version) {
            super(32, version);
        }

        public RestrictedCookieManagerSetCookieFromStringParams() {
            this(0);
        }

        public static RestrictedCookieManagerSetCookieFromStringParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerSetCookieFromStringParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerSetCookieFromStringParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerSetCookieFromStringParams result = new RestrictedCookieManagerSetCookieFromStringParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.siteForCookies = Url.decode(decoder12);
                result.cookie = decoder0.readString(24, false);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode((Struct) this.siteForCookies, 16, false);
            encoder0.encode(this.cookie, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCookieFromStringResponseParams.class */
    static final class RestrictedCookieManagerSetCookieFromStringResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RestrictedCookieManagerSetCookieFromStringResponseParams(int version) {
            super(8, version);
        }

        public RestrictedCookieManagerSetCookieFromStringResponseParams() {
            this(0);
        }

        public static RestrictedCookieManagerSetCookieFromStringResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerSetCookieFromStringResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerSetCookieFromStringResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerSetCookieFromStringResponseParams result = new RestrictedCookieManagerSetCookieFromStringResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCookieFromStringResponseParamsForwardToCallback.class */
    static class RestrictedCookieManagerSetCookieFromStringResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RestrictedCookieManager.SetCookieFromStringResponse mCallback;

        RestrictedCookieManagerSetCookieFromStringResponseParamsForwardToCallback(RestrictedCookieManager.SetCookieFromStringResponse callback) {
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
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerSetCookieFromStringResponseParamsProxyToResponder.class */
    static class RestrictedCookieManagerSetCookieFromStringResponseParamsProxyToResponder implements RestrictedCookieManager.SetCookieFromStringResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedCookieManagerSetCookieFromStringResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            RestrictedCookieManagerSetCookieFromStringResponseParams _response = new RestrictedCookieManagerSetCookieFromStringResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetCookiesStringParams.class */
    static final class RestrictedCookieManagerGetCookiesStringParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public Url siteForCookies;

        private RestrictedCookieManagerGetCookiesStringParams(int version) {
            super(24, version);
        }

        public RestrictedCookieManagerGetCookiesStringParams() {
            this(0);
        }

        public static RestrictedCookieManagerGetCookiesStringParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerGetCookiesStringParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerGetCookiesStringParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerGetCookiesStringParams result = new RestrictedCookieManagerGetCookiesStringParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.siteForCookies = Url.decode(decoder12);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode((Struct) this.siteForCookies, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetCookiesStringResponseParams.class */
    public static final class RestrictedCookieManagerGetCookiesStringResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String cookies;

        private RestrictedCookieManagerGetCookiesStringResponseParams(int version) {
            super(16, version);
        }

        public RestrictedCookieManagerGetCookiesStringResponseParams() {
            this(0);
        }

        public static RestrictedCookieManagerGetCookiesStringResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerGetCookiesStringResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerGetCookiesStringResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerGetCookiesStringResponseParams result = new RestrictedCookieManagerGetCookiesStringResponseParams(elementsOrVersion);
                result.cookies = decoder0.readString(8, false);
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
            encoder0.encode(this.cookies, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetCookiesStringResponseParamsForwardToCallback.class */
    static class RestrictedCookieManagerGetCookiesStringResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RestrictedCookieManager.GetCookiesStringResponse mCallback;

        RestrictedCookieManagerGetCookiesStringResponseParamsForwardToCallback(RestrictedCookieManager.GetCookiesStringResponse callback) {
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
                RestrictedCookieManagerGetCookiesStringResponseParams response = RestrictedCookieManagerGetCookiesStringResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.cookies);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerGetCookiesStringResponseParamsProxyToResponder.class */
    static class RestrictedCookieManagerGetCookiesStringResponseParamsProxyToResponder implements RestrictedCookieManager.GetCookiesStringResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedCookieManagerGetCookiesStringResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(String cookies) {
            RestrictedCookieManagerGetCookiesStringResponseParams _response = new RestrictedCookieManagerGetCookiesStringResponseParams();
            _response.cookies = cookies;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerCookiesEnabledForParams.class */
    static final class RestrictedCookieManagerCookiesEnabledForParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public Url siteForCookies;

        private RestrictedCookieManagerCookiesEnabledForParams(int version) {
            super(24, version);
        }

        public RestrictedCookieManagerCookiesEnabledForParams() {
            this(0);
        }

        public static RestrictedCookieManagerCookiesEnabledForParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerCookiesEnabledForParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerCookiesEnabledForParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerCookiesEnabledForParams result = new RestrictedCookieManagerCookiesEnabledForParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.siteForCookies = Url.decode(decoder12);
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
            encoder0.encode((Struct) this.url, 8, false);
            encoder0.encode((Struct) this.siteForCookies, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerCookiesEnabledForResponseParams.class */
    public static final class RestrictedCookieManagerCookiesEnabledForResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean cookiesEnabled;

        private RestrictedCookieManagerCookiesEnabledForResponseParams(int version) {
            super(16, version);
        }

        public RestrictedCookieManagerCookiesEnabledForResponseParams() {
            this(0);
        }

        public static RestrictedCookieManagerCookiesEnabledForResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RestrictedCookieManagerCookiesEnabledForResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RestrictedCookieManagerCookiesEnabledForResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RestrictedCookieManagerCookiesEnabledForResponseParams result = new RestrictedCookieManagerCookiesEnabledForResponseParams(elementsOrVersion);
                result.cookiesEnabled = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.cookiesEnabled, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerCookiesEnabledForResponseParamsForwardToCallback.class */
    static class RestrictedCookieManagerCookiesEnabledForResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final RestrictedCookieManager.CookiesEnabledForResponse mCallback;

        RestrictedCookieManagerCookiesEnabledForResponseParamsForwardToCallback(RestrictedCookieManager.CookiesEnabledForResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2)) {
                    return false;
                }
                RestrictedCookieManagerCookiesEnabledForResponseParams response = RestrictedCookieManagerCookiesEnabledForResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.cookiesEnabled));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManager_Internal$RestrictedCookieManagerCookiesEnabledForResponseParamsProxyToResponder.class */
    static class RestrictedCookieManagerCookiesEnabledForResponseParamsProxyToResponder implements RestrictedCookieManager.CookiesEnabledForResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        RestrictedCookieManagerCookiesEnabledForResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean cookiesEnabled) {
            RestrictedCookieManagerCookiesEnabledForResponseParams _response = new RestrictedCookieManagerCookiesEnabledForResponseParams();
            _response.cookiesEnabled = cookiesEnabled.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
