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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.network.mojom.CookieChangeListener;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieChangeListener_Internal.class */
class CookieChangeListener_Internal {
    public static final Interface.Manager<CookieChangeListener, CookieChangeListener.Proxy> MANAGER = new Interface.Manager<CookieChangeListener, CookieChangeListener.Proxy>() { // from class: org.chromium.network.mojom.CookieChangeListener_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "network.mojom.CookieChangeListener";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public CookieChangeListener.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, CookieChangeListener impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public CookieChangeListener[] buildArray(int size) {
            return new CookieChangeListener[size];
        }
    };
    private static final int ON_COOKIE_CHANGE_ORDINAL = 0;

    CookieChangeListener_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieChangeListener_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements CookieChangeListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.network.mojom.CookieChangeListener
        public void onCookieChange(CanonicalCookie cookie, int cause) {
            CookieChangeListenerOnCookieChangeParams _message = new CookieChangeListenerOnCookieChangeParams();
            _message.cookie = cookie;
            _message.cause = cause;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieChangeListener_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<CookieChangeListener> {
        Stub(Core core, CookieChangeListener impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CookieChangeListener_Internal.MANAGER, messageWithHeader);
                    case 0:
                        CookieChangeListenerOnCookieChangeParams data = CookieChangeListenerOnCookieChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onCookieChange(data.cookie, data.cause);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), CookieChangeListener_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieChangeListener_Internal$CookieChangeListenerOnCookieChangeParams.class */
    static final class CookieChangeListenerOnCookieChangeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CanonicalCookie cookie;
        public int cause;

        private CookieChangeListenerOnCookieChangeParams(int version) {
            super(24, version);
        }

        public CookieChangeListenerOnCookieChangeParams() {
            this(0);
        }

        public static CookieChangeListenerOnCookieChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieChangeListenerOnCookieChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieChangeListenerOnCookieChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CookieChangeListenerOnCookieChangeParams result = new CookieChangeListenerOnCookieChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cookie = CanonicalCookie.decode(decoder1);
                result.cause = decoder0.readInt(16);
                CookieChangeCause.validate(result.cause);
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
            encoder0.encode(this.cause, 16);
        }
    }
}
