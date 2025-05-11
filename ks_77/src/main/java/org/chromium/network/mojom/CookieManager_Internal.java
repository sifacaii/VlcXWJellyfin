package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.content_settings.mojom.ContentSettingPatternSource;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.CookieManager;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal.class */
class CookieManager_Internal {
    public static final Interface.Manager<CookieManager, CookieManager.Proxy> MANAGER = new Interface.Manager<CookieManager, CookieManager.Proxy>() { // from class: org.chromium.network.mojom.CookieManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.CookieManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public CookieManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, CookieManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public CookieManager[] buildArray(int size) {
            return new CookieManager[size];
        }
    };
    private static final int GET_ALL_COOKIES_ORDINAL = 0;
    private static final int GET_COOKIE_LIST_ORDINAL = 1;
    private static final int SET_CANONICAL_COOKIE_ORDINAL = 2;
    private static final int DELETE_CANONICAL_COOKIE_ORDINAL = 3;
    private static final int DELETE_COOKIES_ORDINAL = 4;
    private static final int ADD_COOKIE_CHANGE_LISTENER_ORDINAL = 5;
    private static final int ADD_GLOBAL_CHANGE_LISTENER_ORDINAL = 6;
    private static final int CLONE_INTERFACE_ORDINAL = 7;
    private static final int FLUSH_COOKIE_STORE_ORDINAL = 8;
    private static final int ALLOW_FILE_SCHEME_COOKIES_ORDINAL = 9;
    private static final int SET_CONTENT_SETTINGS_ORDINAL = 10;
    private static final int SET_FORCE_KEEP_SESSION_STATE_ORDINAL = 11;
    private static final int BLOCK_THIRD_PARTY_COOKIES_ORDINAL = 12;

    CookieManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements CookieManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void getAllCookies(CookieManager.GetAllCookiesResponse callback) {
            CookieManagerGetAllCookiesParams _message = new CookieManagerGetAllCookiesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CookieManagerGetAllCookiesResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void getCookieList(Url url, CookieOptions cookieOptions, CookieManager.GetCookieListResponse callback) {
            CookieManagerGetCookieListParams _message = new CookieManagerGetCookieListParams();
            _message.url = url;
            _message.cookieOptions = cookieOptions;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CookieManagerGetCookieListResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void setCanonicalCookie(CanonicalCookie cookie, String sourceScheme, CookieOptions cookieOptions, CookieManager.SetCanonicalCookieResponse callback) {
            CookieManagerSetCanonicalCookieParams _message = new CookieManagerSetCanonicalCookieParams();
            _message.cookie = cookie;
            _message.sourceScheme = sourceScheme;
            _message.cookieOptions = cookieOptions;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new CookieManagerSetCanonicalCookieResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void deleteCanonicalCookie(CanonicalCookie cookie, CookieManager.DeleteCanonicalCookieResponse callback) {
            CookieManagerDeleteCanonicalCookieParams _message = new CookieManagerDeleteCanonicalCookieParams();
            _message.cookie = cookie;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void deleteCookies(CookieDeletionFilter filter, CookieManager.DeleteCookiesResponse callback) {
            CookieManagerDeleteCookiesParams _message = new CookieManagerDeleteCookiesParams();
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new CookieManagerDeleteCookiesResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void addCookieChangeListener(Url url, String name, CookieChangeListener listener) {
            CookieManagerAddCookieChangeListenerParams _message = new CookieManagerAddCookieChangeListenerParams();
            _message.url = url;
            _message.name = name;
            _message.listener = listener;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void addGlobalChangeListener(CookieChangeListener notificationPointer) {
            CookieManagerAddGlobalChangeListenerParams _message = new CookieManagerAddGlobalChangeListenerParams();
            _message.notificationPointer = notificationPointer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void cloneInterface(InterfaceRequest<CookieManager> newInterface) {
            CookieManagerCloneInterfaceParams _message = new CookieManagerCloneInterfaceParams();
            _message.newInterface = newInterface;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void flushCookieStore(CookieManager.FlushCookieStoreResponse callback) {
            CookieManagerFlushCookieStoreParams _message = new CookieManagerFlushCookieStoreParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new CookieManagerFlushCookieStoreResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void allowFileSchemeCookies(boolean allow, CookieManager.AllowFileSchemeCookiesResponse callback) {
            CookieManagerAllowFileSchemeCookiesParams _message = new CookieManagerAllowFileSchemeCookiesParams();
            _message.allow = allow;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void setContentSettings(ContentSettingPatternSource[] settings) {
            CookieManagerSetContentSettingsParams _message = new CookieManagerSetContentSettingsParams();
            _message.settings = settings;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void setForceKeepSessionState() {
            CookieManagerSetForceKeepSessionStateParams _message = new CookieManagerSetForceKeepSessionStateParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
        }

        @Override // org.chromium.network.mojom.CookieManager
        public void blockThirdPartyCookies(boolean block) {
            CookieManagerBlockThirdPartyCookiesParams _message = new CookieManagerBlockThirdPartyCookiesParams();
            _message.block = block;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<CookieManager> {
        Stub(Core core, CookieManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CookieManager_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 8:
                    case 9:
                    default:
                        return false;
                    case 5:
                        CookieManagerAddCookieChangeListenerParams data = CookieManagerAddCookieChangeListenerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addCookieChangeListener(data.url, data.name, data.listener);
                        return true;
                    case 6:
                        CookieManagerAddGlobalChangeListenerParams data2 = CookieManagerAddGlobalChangeListenerParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addGlobalChangeListener(data2.notificationPointer);
                        return true;
                    case 7:
                        CookieManagerCloneInterfaceParams data3 = CookieManagerCloneInterfaceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().cloneInterface(data3.newInterface);
                        return true;
                    case 10:
                        CookieManagerSetContentSettingsParams data4 = CookieManagerSetContentSettingsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setContentSettings(data4.settings);
                        return true;
                    case 11:
                        CookieManagerSetForceKeepSessionStateParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setForceKeepSessionState();
                        return true;
                    case 12:
                        CookieManagerBlockThirdPartyCookiesParams data5 = CookieManagerBlockThirdPartyCookiesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().blockThirdPartyCookies(data5.block);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), CookieManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        CookieManagerGetAllCookiesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getAllCookies(new CookieManagerGetAllCookiesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        CookieManagerGetCookieListParams data = CookieManagerGetCookieListParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getCookieList(data.url, data.cookieOptions, new CookieManagerGetCookieListResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        CookieManagerSetCanonicalCookieParams data2 = CookieManagerSetCanonicalCookieParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setCanonicalCookie(data2.cookie, data2.sourceScheme, data2.cookieOptions, new CookieManagerSetCanonicalCookieResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        CookieManagerDeleteCanonicalCookieParams data3 = CookieManagerDeleteCanonicalCookieParams.deserialize(messageWithHeader.getPayload());
                        getImpl().deleteCanonicalCookie(data3.cookie, new CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        CookieManagerDeleteCookiesParams data4 = CookieManagerDeleteCookiesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().deleteCookies(data4.filter, new CookieManagerDeleteCookiesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                    case 6:
                    case 7:
                    default:
                        return false;
                    case 8:
                        CookieManagerFlushCookieStoreParams.deserialize(messageWithHeader.getPayload());
                        getImpl().flushCookieStore(new CookieManagerFlushCookieStoreResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        CookieManagerAllowFileSchemeCookiesParams data5 = CookieManagerAllowFileSchemeCookiesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().allowFileSchemeCookies(data5.allow, new CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetAllCookiesParams.class */
    static final class CookieManagerGetAllCookiesParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CookieManagerGetAllCookiesParams(int version) {
            super(8, version);
        }

        public CookieManagerGetAllCookiesParams() {
            this(0);
        }

        public static CookieManagerGetAllCookiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerGetAllCookiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerGetAllCookiesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerGetAllCookiesParams result = new CookieManagerGetAllCookiesParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetAllCookiesResponseParams.class */
    public static final class CookieManagerGetAllCookiesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie[] cookies;

        private CookieManagerGetAllCookiesResponseParams(int version) {
            super(16, version);
        }

        public CookieManagerGetAllCookiesResponseParams() {
            this(0);
        }

        public static CookieManagerGetAllCookiesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerGetAllCookiesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerGetAllCookiesResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerGetAllCookiesResponseParams result = new CookieManagerGetAllCookiesResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetAllCookiesResponseParamsForwardToCallback.class */
    static class CookieManagerGetAllCookiesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.GetAllCookiesResponse mCallback;

        CookieManagerGetAllCookiesResponseParamsForwardToCallback(CookieManager.GetAllCookiesResponse callback) {
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
                CookieManagerGetAllCookiesResponseParams response = CookieManagerGetAllCookiesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.cookies);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetAllCookiesResponseParamsProxyToResponder.class */
    static class CookieManagerGetAllCookiesResponseParamsProxyToResponder implements CookieManager.GetAllCookiesResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerGetAllCookiesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(CanonicalCookie[] cookies) {
            CookieManagerGetAllCookiesResponseParams _response = new CookieManagerGetAllCookiesResponseParams();
            _response.cookies = cookies;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetCookieListParams.class */
    static final class CookieManagerGetCookieListParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public CookieOptions cookieOptions;

        private CookieManagerGetCookieListParams(int version) {
            super(24, version);
        }

        public CookieManagerGetCookieListParams() {
            this(0);
        }

        public static CookieManagerGetCookieListParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerGetCookieListParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerGetCookieListParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerGetCookieListParams result = new CookieManagerGetCookieListParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.cookieOptions = CookieOptions.decode(decoder12);
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
            encoder0.encode((Struct) this.cookieOptions, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetCookieListResponseParams.class */
    public static final class CookieManagerGetCookieListResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie[] cookies;
        public CookieWithStatus[] excludedCookies;

        private CookieManagerGetCookieListResponseParams(int version) {
            super(24, version);
        }

        public CookieManagerGetCookieListResponseParams() {
            this(0);
        }

        public static CookieManagerGetCookieListResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerGetCookieListResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerGetCookieListResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerGetCookieListResponseParams result = new CookieManagerGetCookieListResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.cookies = new CanonicalCookie[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.cookies[i1] = CanonicalCookie.decode(decoder2);
                }
                Decoder decoder12 = decoder0.readPointer(16, false);
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.excludedCookies = new CookieWithStatus[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                    result.excludedCookies[i12] = CookieWithStatus.decode(decoder22);
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
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.cookies.length, 8, -1);
                for (int i0 = 0; i0 < this.cookies.length; i0++) {
                    encoder1.encode((Struct) this.cookies[i0], 8 + (8 * i0), false);
                }
            }
            if (this.excludedCookies == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder12 = encoder0.encodePointerArray(this.excludedCookies.length, 16, -1);
            for (int i02 = 0; i02 < this.excludedCookies.length; i02++) {
                encoder12.encode((Struct) this.excludedCookies[i02], 8 + (8 * i02), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetCookieListResponseParamsForwardToCallback.class */
    static class CookieManagerGetCookieListResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.GetCookieListResponse mCallback;

        CookieManagerGetCookieListResponseParamsForwardToCallback(CookieManager.GetCookieListResponse callback) {
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
                CookieManagerGetCookieListResponseParams response = CookieManagerGetCookieListResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.cookies, response.excludedCookies);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerGetCookieListResponseParamsProxyToResponder.class */
    static class CookieManagerGetCookieListResponseParamsProxyToResponder implements CookieManager.GetCookieListResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerGetCookieListResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(CanonicalCookie[] cookies, CookieWithStatus[] excludedCookies) {
            CookieManagerGetCookieListResponseParams _response = new CookieManagerGetCookieListResponseParams();
            _response.cookies = cookies;
            _response.excludedCookies = excludedCookies;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerSetCanonicalCookieParams.class */
    static final class CookieManagerSetCanonicalCookieParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie cookie;
        public String sourceScheme;
        public CookieOptions cookieOptions;

        private CookieManagerSetCanonicalCookieParams(int version) {
            super(32, version);
        }

        public CookieManagerSetCanonicalCookieParams() {
            this(0);
        }

        public static CookieManagerSetCanonicalCookieParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerSetCanonicalCookieParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerSetCanonicalCookieParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerSetCanonicalCookieParams result = new CookieManagerSetCanonicalCookieParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cookie = CanonicalCookie.decode(decoder1);
                result.sourceScheme = decoder0.readString(16, false);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.cookieOptions = CookieOptions.decode(decoder12);
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
            encoder0.encode(this.sourceScheme, 16, false);
            encoder0.encode((Struct) this.cookieOptions, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerSetCanonicalCookieResponseParams.class */
    public static final class CookieManagerSetCanonicalCookieResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private CookieManagerSetCanonicalCookieResponseParams(int version) {
            super(16, version);
        }

        public CookieManagerSetCanonicalCookieResponseParams() {
            this(0);
        }

        public static CookieManagerSetCanonicalCookieResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerSetCanonicalCookieResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerSetCanonicalCookieResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerSetCanonicalCookieResponseParams result = new CookieManagerSetCanonicalCookieResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CookieInclusionStatus.validate(result.status);
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
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerSetCanonicalCookieResponseParamsForwardToCallback.class */
    static class CookieManagerSetCanonicalCookieResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.SetCanonicalCookieResponse mCallback;

        CookieManagerSetCanonicalCookieResponseParamsForwardToCallback(CookieManager.SetCanonicalCookieResponse callback) {
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
                CookieManagerSetCanonicalCookieResponseParams response = CookieManagerSetCanonicalCookieResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerSetCanonicalCookieResponseParamsProxyToResponder.class */
    static class CookieManagerSetCanonicalCookieResponseParamsProxyToResponder implements CookieManager.SetCanonicalCookieResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerSetCanonicalCookieResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer status) {
            CookieManagerSetCanonicalCookieResponseParams _response = new CookieManagerSetCanonicalCookieResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCanonicalCookieParams.class */
    static final class CookieManagerDeleteCanonicalCookieParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie cookie;

        private CookieManagerDeleteCanonicalCookieParams(int version) {
            super(16, version);
        }

        public CookieManagerDeleteCanonicalCookieParams() {
            this(0);
        }

        public static CookieManagerDeleteCanonicalCookieParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerDeleteCanonicalCookieParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerDeleteCanonicalCookieParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerDeleteCanonicalCookieParams result = new CookieManagerDeleteCanonicalCookieParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cookie = CanonicalCookie.decode(decoder1);
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
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCanonicalCookieResponseParams.class */
    public static final class CookieManagerDeleteCanonicalCookieResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private CookieManagerDeleteCanonicalCookieResponseParams(int version) {
            super(16, version);
        }

        public CookieManagerDeleteCanonicalCookieResponseParams() {
            this(0);
        }

        public static CookieManagerDeleteCanonicalCookieResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerDeleteCanonicalCookieResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerDeleteCanonicalCookieResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerDeleteCanonicalCookieResponseParams result = new CookieManagerDeleteCanonicalCookieResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback.class */
    static class CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.DeleteCanonicalCookieResponse mCallback;

        CookieManagerDeleteCanonicalCookieResponseParamsForwardToCallback(CookieManager.DeleteCanonicalCookieResponse callback) {
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
                CookieManagerDeleteCanonicalCookieResponseParams response = CookieManagerDeleteCanonicalCookieResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder.class */
    static class CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder implements CookieManager.DeleteCanonicalCookieResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerDeleteCanonicalCookieResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            CookieManagerDeleteCanonicalCookieResponseParams _response = new CookieManagerDeleteCanonicalCookieResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCookiesParams.class */
    static final class CookieManagerDeleteCookiesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CookieDeletionFilter filter;

        private CookieManagerDeleteCookiesParams(int version) {
            super(16, version);
        }

        public CookieManagerDeleteCookiesParams() {
            this(0);
        }

        public static CookieManagerDeleteCookiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerDeleteCookiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerDeleteCookiesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerDeleteCookiesParams result = new CookieManagerDeleteCookiesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filter = CookieDeletionFilter.decode(decoder1);
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
            encoder0.encode((Struct) this.filter, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCookiesResponseParams.class */
    public static final class CookieManagerDeleteCookiesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int numDeleted;

        private CookieManagerDeleteCookiesResponseParams(int version) {
            super(16, version);
        }

        public CookieManagerDeleteCookiesResponseParams() {
            this(0);
        }

        public static CookieManagerDeleteCookiesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerDeleteCookiesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerDeleteCookiesResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerDeleteCookiesResponseParams result = new CookieManagerDeleteCookiesResponseParams(elementsOrVersion);
                result.numDeleted = decoder0.readInt(8);
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
            encoder0.encode(this.numDeleted, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCookiesResponseParamsForwardToCallback.class */
    static class CookieManagerDeleteCookiesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.DeleteCookiesResponse mCallback;

        CookieManagerDeleteCookiesResponseParamsForwardToCallback(CookieManager.DeleteCookiesResponse callback) {
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
                CookieManagerDeleteCookiesResponseParams response = CookieManagerDeleteCookiesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.numDeleted));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerDeleteCookiesResponseParamsProxyToResponder.class */
    static class CookieManagerDeleteCookiesResponseParamsProxyToResponder implements CookieManager.DeleteCookiesResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerDeleteCookiesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer numDeleted) {
            CookieManagerDeleteCookiesResponseParams _response = new CookieManagerDeleteCookiesResponseParams();
            _response.numDeleted = numDeleted.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerAddCookieChangeListenerParams.class */
    static final class CookieManagerAddCookieChangeListenerParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Url url;
        public String name;
        public CookieChangeListener listener;

        private CookieManagerAddCookieChangeListenerParams(int version) {
            super(32, version);
        }

        public CookieManagerAddCookieChangeListenerParams() {
            this(0);
        }

        public static CookieManagerAddCookieChangeListenerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerAddCookieChangeListenerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerAddCookieChangeListenerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerAddCookieChangeListenerParams result = new CookieManagerAddCookieChangeListenerParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.name = decoder0.readString(16, false);
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
            encoder0.encode(this.name, 16, false);
            encoder0.encode(this.listener,24,false, CookieChangeListener.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerAddGlobalChangeListenerParams.class */
    static final class CookieManagerAddGlobalChangeListenerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CookieChangeListener notificationPointer;

        private CookieManagerAddGlobalChangeListenerParams(int version) {
            super(16, version);
        }

        public CookieManagerAddGlobalChangeListenerParams() {
            this(0);
        }

        public static CookieManagerAddGlobalChangeListenerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerAddGlobalChangeListenerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerAddGlobalChangeListenerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerAddGlobalChangeListenerParams result = new CookieManagerAddGlobalChangeListenerParams(elementsOrVersion);
                result.notificationPointer = (CookieChangeListener) decoder0.readServiceInterface(8, false, CookieChangeListener.MANAGER);
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
            encoder0.encode(this.notificationPointer,8,false, CookieChangeListener.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerCloneInterfaceParams.class */
    static final class CookieManagerCloneInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<CookieManager> newInterface;

        private CookieManagerCloneInterfaceParams(int version) {
            super(16, version);
        }

        public CookieManagerCloneInterfaceParams() {
            this(0);
        }

        public static CookieManagerCloneInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerCloneInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerCloneInterfaceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerCloneInterfaceParams result = new CookieManagerCloneInterfaceParams(elementsOrVersion);
                result.newInterface = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.newInterface, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerFlushCookieStoreParams.class */
    static final class CookieManagerFlushCookieStoreParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CookieManagerFlushCookieStoreParams(int version) {
            super(8, version);
        }

        public CookieManagerFlushCookieStoreParams() {
            this(0);
        }

        public static CookieManagerFlushCookieStoreParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerFlushCookieStoreParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerFlushCookieStoreParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerFlushCookieStoreParams result = new CookieManagerFlushCookieStoreParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerFlushCookieStoreResponseParams.class */
    static final class CookieManagerFlushCookieStoreResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CookieManagerFlushCookieStoreResponseParams(int version) {
            super(8, version);
        }

        public CookieManagerFlushCookieStoreResponseParams() {
            this(0);
        }

        public static CookieManagerFlushCookieStoreResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerFlushCookieStoreResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerFlushCookieStoreResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerFlushCookieStoreResponseParams result = new CookieManagerFlushCookieStoreResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerFlushCookieStoreResponseParamsForwardToCallback.class */
    static class CookieManagerFlushCookieStoreResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.FlushCookieStoreResponse mCallback;

        CookieManagerFlushCookieStoreResponseParamsForwardToCallback(CookieManager.FlushCookieStoreResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerFlushCookieStoreResponseParamsProxyToResponder.class */
    static class CookieManagerFlushCookieStoreResponseParamsProxyToResponder implements CookieManager.FlushCookieStoreResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerFlushCookieStoreResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            CookieManagerFlushCookieStoreResponseParams _response = new CookieManagerFlushCookieStoreResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerAllowFileSchemeCookiesParams.class */
    static final class CookieManagerAllowFileSchemeCookiesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean allow;

        private CookieManagerAllowFileSchemeCookiesParams(int version) {
            super(16, version);
        }

        public CookieManagerAllowFileSchemeCookiesParams() {
            this(0);
        }

        public static CookieManagerAllowFileSchemeCookiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerAllowFileSchemeCookiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerAllowFileSchemeCookiesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerAllowFileSchemeCookiesParams result = new CookieManagerAllowFileSchemeCookiesParams(elementsOrVersion);
                result.allow = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.allow, 8, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerAllowFileSchemeCookiesResponseParams.class */
    public static final class CookieManagerAllowFileSchemeCookiesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean success;

        private CookieManagerAllowFileSchemeCookiesResponseParams(int version) {
            super(16, version);
        }

        public CookieManagerAllowFileSchemeCookiesResponseParams() {
            this(0);
        }

        public static CookieManagerAllowFileSchemeCookiesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerAllowFileSchemeCookiesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerAllowFileSchemeCookiesResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerAllowFileSchemeCookiesResponseParams result = new CookieManagerAllowFileSchemeCookiesResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback.class */
    static class CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieManager.AllowFileSchemeCookiesResponse mCallback;

        CookieManagerAllowFileSchemeCookiesResponseParamsForwardToCallback(CookieManager.AllowFileSchemeCookiesResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2)) {
                    return false;
                }
                CookieManagerAllowFileSchemeCookiesResponseParams response = CookieManagerAllowFileSchemeCookiesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder.class */
    static class CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder implements CookieManager.AllowFileSchemeCookiesResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CookieManagerAllowFileSchemeCookiesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean success) {
            CookieManagerAllowFileSchemeCookiesResponseParams _response = new CookieManagerAllowFileSchemeCookiesResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerSetContentSettingsParams.class */
    static final class CookieManagerSetContentSettingsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ContentSettingPatternSource[] settings;

        private CookieManagerSetContentSettingsParams(int version) {
            super(16, version);
        }

        public CookieManagerSetContentSettingsParams() {
            this(0);
        }

        public static CookieManagerSetContentSettingsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerSetContentSettingsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerSetContentSettingsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerSetContentSettingsParams result = new CookieManagerSetContentSettingsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.settings = new ContentSettingPatternSource[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.settings[i1] = ContentSettingPatternSource.decode(decoder2);
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
            if (this.settings == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.settings.length, 8, -1);
            for (int i0 = 0; i0 < this.settings.length; i0++) {
                encoder1.encode((Struct) this.settings[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerSetForceKeepSessionStateParams.class */
    static final class CookieManagerSetForceKeepSessionStateParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CookieManagerSetForceKeepSessionStateParams(int version) {
            super(8, version);
        }

        public CookieManagerSetForceKeepSessionStateParams() {
            this(0);
        }

        public static CookieManagerSetForceKeepSessionStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerSetForceKeepSessionStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerSetForceKeepSessionStateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerSetForceKeepSessionStateParams result = new CookieManagerSetForceKeepSessionStateParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManager_Internal$CookieManagerBlockThirdPartyCookiesParams.class */
    static final class CookieManagerBlockThirdPartyCookiesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean block;

        private CookieManagerBlockThirdPartyCookiesParams(int version) {
            super(16, version);
        }

        public CookieManagerBlockThirdPartyCookiesParams() {
            this(0);
        }

        public static CookieManagerBlockThirdPartyCookiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieManagerBlockThirdPartyCookiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieManagerBlockThirdPartyCookiesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieManagerBlockThirdPartyCookiesParams result = new CookieManagerBlockThirdPartyCookiesParams(elementsOrVersion);
                result.block = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.block, 8, 0);
        }
    }
}
