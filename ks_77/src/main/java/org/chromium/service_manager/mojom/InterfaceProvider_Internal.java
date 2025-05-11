package org.chromium.service_manager.mojom;

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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.service_manager.mojom.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/InterfaceProvider_Internal.class */
class InterfaceProvider_Internal {
    public static final Interface.Manager<InterfaceProvider, InterfaceProvider.Proxy> MANAGER = new Interface.Manager<InterfaceProvider, InterfaceProvider.Proxy>() { // from class: org.chromium.service_manager.mojom.InterfaceProvider_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "service_manager.mojom.InterfaceProvider";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public InterfaceProvider.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, InterfaceProvider impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public InterfaceProvider[] buildArray(int size) {
            return new InterfaceProvider[size];
        }
    };
    private static final int GET_INTERFACE_ORDINAL = 0;

    InterfaceProvider_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/InterfaceProvider_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements InterfaceProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.service_manager.mojom.InterfaceProvider
        public void getInterface(String interfaceName, MessagePipeHandle pipe) {
            InterfaceProviderGetInterfaceParams _message = new InterfaceProviderGetInterfaceParams();
            _message.interfaceName = interfaceName;
            _message.pipe = pipe;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/InterfaceProvider_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<InterfaceProvider> {
        Stub(Core core, InterfaceProvider impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InterfaceProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        InterfaceProviderGetInterfaceParams data = InterfaceProviderGetInterfaceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getInterface(data.interfaceName, data.pipe);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), InterfaceProvider_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams.class */
    static final class InterfaceProviderGetInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String interfaceName;
        public MessagePipeHandle pipe;

        private InterfaceProviderGetInterfaceParams(int version) {
            super(24, version);
            this.pipe = InvalidHandle.INSTANCE;
        }

        public InterfaceProviderGetInterfaceParams() {
            this(0);
        }

        public static InterfaceProviderGetInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InterfaceProviderGetInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InterfaceProviderGetInterfaceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                InterfaceProviderGetInterfaceParams result = new InterfaceProviderGetInterfaceParams(elementsOrVersion);
                result.interfaceName = decoder0.readString(8, false);
                result.pipe = decoder0.readMessagePipeHandle(16, false);
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
            encoder0.encode(this.interfaceName, 8, false);
            encoder0.encode((Handle) this.pipe, 16, false);
        }
    }
}
