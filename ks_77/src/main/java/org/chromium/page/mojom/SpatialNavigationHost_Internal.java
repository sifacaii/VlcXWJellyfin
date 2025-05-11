package org.chromium.page.mojom;

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
import org.chromium.page.mojom.SpatialNavigationHost;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationHost_Internal.class */
class SpatialNavigationHost_Internal {
    public static final Interface.Manager<SpatialNavigationHost, SpatialNavigationHost.Proxy> MANAGER = new Interface.Manager<SpatialNavigationHost, SpatialNavigationHost.Proxy>() { // from class: org.chromium.page.mojom.SpatialNavigationHost_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "blink.mojom.SpatialNavigationHost";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public SpatialNavigationHost.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, SpatialNavigationHost impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public SpatialNavigationHost[] buildArray(int size) {
            return new SpatialNavigationHost[size];
        }
    };
    private static final int SPATIAL_NAVIGATION_STATE_CHANGED_ORDINAL = 0;

    SpatialNavigationHost_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationHost_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements SpatialNavigationHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.page.mojom.SpatialNavigationHost
        public void spatialNavigationStateChanged(SpatialNavigationState state) {
            SpatialNavigationHostSpatialNavigationStateChangedParams _message = new SpatialNavigationHostSpatialNavigationStateChangedParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationHost_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<SpatialNavigationHost> {
        Stub(Core core, SpatialNavigationHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SpatialNavigationHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        SpatialNavigationHostSpatialNavigationStateChangedParams data = SpatialNavigationHostSpatialNavigationStateChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().spatialNavigationStateChanged(data.state);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), SpatialNavigationHost_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationHost_Internal$SpatialNavigationHostSpatialNavigationStateChangedParams.class */
    static final class SpatialNavigationHostSpatialNavigationStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SpatialNavigationState state;

        private SpatialNavigationHostSpatialNavigationStateChangedParams(int version) {
            super(16, version);
        }

        public SpatialNavigationHostSpatialNavigationStateChangedParams() {
            this(0);
        }

        public static SpatialNavigationHostSpatialNavigationStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpatialNavigationHostSpatialNavigationStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpatialNavigationHostSpatialNavigationStateChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                SpatialNavigationHostSpatialNavigationStateChangedParams result = new SpatialNavigationHostSpatialNavigationStateChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.state = SpatialNavigationState.decode(decoder1);
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
            encoder0.encode((Struct) this.state, 8, true);
        }
    }
}
