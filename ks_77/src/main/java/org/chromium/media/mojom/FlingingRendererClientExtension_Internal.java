package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.FlingingRendererClientExtension;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/FlingingRendererClientExtension_Internal.class */
class FlingingRendererClientExtension_Internal {
    public static final Interface.Manager<FlingingRendererClientExtension, FlingingRendererClientExtension.Proxy> MANAGER = new Interface.Manager<FlingingRendererClientExtension, FlingingRendererClientExtension.Proxy>() { // from class: org.chromium.media.mojom.FlingingRendererClientExtension_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.FlingingRendererClientExtension";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public FlingingRendererClientExtension.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, FlingingRendererClientExtension impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public FlingingRendererClientExtension[] buildArray(int size) {
            return new FlingingRendererClientExtension[size];
        }
    };
    private static final int ON_REMOTE_PLAY_STATE_CHANGE_ORDINAL = 0;

    FlingingRendererClientExtension_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/FlingingRendererClientExtension_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements FlingingRendererClientExtension.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.FlingingRendererClientExtension
        public void onRemotePlayStateChange(int state) {
            FlingingRendererClientExtensionOnRemotePlayStateChangeParams _message = new FlingingRendererClientExtensionOnRemotePlayStateChangeParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/FlingingRendererClientExtension_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<FlingingRendererClientExtension> {
        Stub(Core core, FlingingRendererClientExtension impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FlingingRendererClientExtension_Internal.MANAGER, messageWithHeader);
                    case 0:
                        FlingingRendererClientExtensionOnRemotePlayStateChangeParams data = FlingingRendererClientExtensionOnRemotePlayStateChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onRemotePlayStateChange(data.state);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), FlingingRendererClientExtension_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/FlingingRendererClientExtension_Internal$FlingingRendererClientExtensionOnRemotePlayStateChangeParams.class */
    static final class FlingingRendererClientExtensionOnRemotePlayStateChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int state;

        private FlingingRendererClientExtensionOnRemotePlayStateChangeParams(int version) {
            super(16, version);
        }

        public FlingingRendererClientExtensionOnRemotePlayStateChangeParams() {
            this(0);
        }

        public static FlingingRendererClientExtensionOnRemotePlayStateChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FlingingRendererClientExtensionOnRemotePlayStateChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FlingingRendererClientExtensionOnRemotePlayStateChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                FlingingRendererClientExtensionOnRemotePlayStateChangeParams result = new FlingingRendererClientExtensionOnRemotePlayStateChangeParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                MediaStatusState.validate(result.state);
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
            encoder0.encode(this.state, 8);
        }
    }
}
