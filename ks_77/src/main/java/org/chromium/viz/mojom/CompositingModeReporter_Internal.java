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
import org.chromium.viz.mojom.CompositingModeReporter;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeReporter_Internal.class */
class CompositingModeReporter_Internal {
    public static final Interface.Manager<CompositingModeReporter, CompositingModeReporter.Proxy> MANAGER = new Interface.Manager<CompositingModeReporter, CompositingModeReporter.Proxy>() { // from class: org.chromium.viz.mojom.CompositingModeReporter_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.CompositingModeReporter";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public CompositingModeReporter.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, CompositingModeReporter impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public CompositingModeReporter[] buildArray(int size) {
            return new CompositingModeReporter[size];
        }
    };
    private static final int ADD_COMPOSITING_MODE_WATCHER_ORDINAL = 0;

    CompositingModeReporter_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeReporter_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements CompositingModeReporter.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.CompositingModeReporter
        public void addCompositingModeWatcher(CompositingModeWatcher watcher) {
            CompositingModeReporterAddCompositingModeWatcherParams _message = new CompositingModeReporterAddCompositingModeWatcherParams();
            _message.watcher = watcher;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeReporter_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<CompositingModeReporter> {
        Stub(Core core, CompositingModeReporter impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CompositingModeReporter_Internal.MANAGER, messageWithHeader);
                    case 0:
                        CompositingModeReporterAddCompositingModeWatcherParams data = CompositingModeReporterAddCompositingModeWatcherParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addCompositingModeWatcher(data.watcher);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), CompositingModeReporter_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeReporter_Internal$CompositingModeReporterAddCompositingModeWatcherParams.class */
    static final class CompositingModeReporterAddCompositingModeWatcherParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public CompositingModeWatcher watcher;

        private CompositingModeReporterAddCompositingModeWatcherParams(int version) {
            super(16, version);
        }

        public CompositingModeReporterAddCompositingModeWatcherParams() {
            this(0);
        }

        public static CompositingModeReporterAddCompositingModeWatcherParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositingModeReporterAddCompositingModeWatcherParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositingModeReporterAddCompositingModeWatcherParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositingModeReporterAddCompositingModeWatcherParams result = new CompositingModeReporterAddCompositingModeWatcherParams(elementsOrVersion);
                result.watcher = (CompositingModeWatcher) decoder0.readServiceInterface(8, false, CompositingModeWatcher.MANAGER);
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
            encoder0.encode(this.watcher, 8, false, CompositingModeWatcher.MANAGER);
        }
    }
}
