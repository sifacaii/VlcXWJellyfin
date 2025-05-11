package org.chromium.viz.mojom;

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
import org.chromium.viz.mojom.CompositingModeWatcher;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeWatcher_Internal.class */
class CompositingModeWatcher_Internal {
    public static final Interface.Manager<CompositingModeWatcher, CompositingModeWatcher.Proxy> MANAGER = new Interface.Manager<CompositingModeWatcher, CompositingModeWatcher.Proxy>() { // from class: org.chromium.viz.mojom.CompositingModeWatcher_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.CompositingModeWatcher";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public CompositingModeWatcher.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, CompositingModeWatcher impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public CompositingModeWatcher[] buildArray(int size) {
            return new CompositingModeWatcher[size];
        }
    };
    private static final int COMPOSITING_MODE_FALLBACK_TO_SOFTWARE_ORDINAL = 0;

    CompositingModeWatcher_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeWatcher_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements CompositingModeWatcher.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.CompositingModeWatcher
        public void compositingModeFallbackToSoftware() {
            CompositingModeWatcherCompositingModeFallbackToSoftwareParams _message = new CompositingModeWatcherCompositingModeFallbackToSoftwareParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeWatcher_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<CompositingModeWatcher> {
        Stub(Core core, CompositingModeWatcher impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CompositingModeWatcher_Internal.MANAGER, messageWithHeader);
                    case 0:
                        CompositingModeWatcherCompositingModeFallbackToSoftwareParams.deserialize(messageWithHeader.getPayload());
                        getImpl().compositingModeFallbackToSoftware();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), CompositingModeWatcher_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeWatcher_Internal$CompositingModeWatcherCompositingModeFallbackToSoftwareParams.class */
    static final class CompositingModeWatcherCompositingModeFallbackToSoftwareParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CompositingModeWatcherCompositingModeFallbackToSoftwareParams(int version) {
            super(8, version);
        }

        public CompositingModeWatcherCompositingModeFallbackToSoftwareParams() {
            this(0);
        }

        public static CompositingModeWatcherCompositingModeFallbackToSoftwareParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositingModeWatcherCompositingModeFallbackToSoftwareParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositingModeWatcherCompositingModeFallbackToSoftwareParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositingModeWatcherCompositingModeFallbackToSoftwareParams result = new CompositingModeWatcherCompositingModeFallbackToSoftwareParams(elementsOrVersion);
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
}
