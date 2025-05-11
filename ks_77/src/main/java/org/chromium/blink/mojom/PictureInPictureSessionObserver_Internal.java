package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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

class PictureInPictureSessionObserver_Internal {
    public static final Interface.Manager<PictureInPictureSessionObserver, PictureInPictureSessionObserver.Proxy> MANAGER = new Interface.Manager<PictureInPictureSessionObserver, PictureInPictureSessionObserver.Proxy>() {
        public String getName() {
            return "blink.mojom.PictureInPictureSessionObserver";
        }

        public int getVersion() {
            return 0;
        }

        public PictureInPictureSessionObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PictureInPictureSessionObserver_Internal.Proxy(core, messageReceiver);
        }

        public PictureInPictureSessionObserver_Internal.Stub buildStub(Core core, PictureInPictureSessionObserver impl) {
            return new PictureInPictureSessionObserver_Internal.Stub(core, impl);
        }

        public PictureInPictureSessionObserver[] buildArray(int size) {
            return new PictureInPictureSessionObserver[size];
        }
    };

    private static final int ON_WINDOW_SIZE_CHANGED_ORDINAL = 0;

    private static final int ON_STOPPED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements PictureInPictureSessionObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onWindowSizeChanged(Size size) {
            PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnWindowSizeChangedParams _message = new PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnWindowSizeChangedParams();
            _message.size = size;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onStopped() {
            PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnStoppedParams _message = new PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnStoppedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<PictureInPictureSessionObserver> {
        Stub(Core core, PictureInPictureSessionObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnWindowSizeChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PictureInPictureSessionObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnWindowSizeChangedParams.deserialize(messageWithHeader.getPayload());
                        ((PictureInPictureSessionObserver)getImpl()).onWindowSizeChanged(data.size);
                        return true;
                    case 1:
                        PictureInPictureSessionObserver_Internal.PictureInPictureSessionObserverOnStoppedParams.deserialize(messageWithHeader.getPayload());
                        ((PictureInPictureSessionObserver)getImpl()).onStopped();
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PictureInPictureSessionObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PictureInPictureSessionObserverOnWindowSizeChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Size size;

        private PictureInPictureSessionObserverOnWindowSizeChangedParams(int version) {
            super(16, version);
        }

        public PictureInPictureSessionObserverOnWindowSizeChangedParams() {
            this(0);
        }

        public static PictureInPictureSessionObserverOnWindowSizeChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureSessionObserverOnWindowSizeChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureSessionObserverOnWindowSizeChangedParams decode(Decoder decoder0) {
            PictureInPictureSessionObserverOnWindowSizeChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureSessionObserverOnWindowSizeChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.size = Size.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.size, 8, false);
        }
    }

    static final class PictureInPictureSessionObserverOnStoppedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PictureInPictureSessionObserverOnStoppedParams(int version) {
            super(8, version);
        }

        public PictureInPictureSessionObserverOnStoppedParams() {
            this(0);
        }

        public static PictureInPictureSessionObserverOnStoppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureSessionObserverOnStoppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureSessionObserverOnStoppedParams decode(Decoder decoder0) {
            PictureInPictureSessionObserverOnStoppedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureSessionObserverOnStoppedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
