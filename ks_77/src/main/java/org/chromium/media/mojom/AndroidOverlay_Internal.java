package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
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

class AndroidOverlay_Internal {
    public static final Interface.Manager<AndroidOverlay, AndroidOverlay.Proxy> MANAGER = new Interface.Manager<AndroidOverlay, AndroidOverlay.Proxy>() {
        public String getName() {
            return "media.mojom.AndroidOverlay";
        }

        public int getVersion() {
            return 0;
        }

        public AndroidOverlay_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AndroidOverlay_Internal.Proxy(core, messageReceiver);
        }

        public AndroidOverlay_Internal.Stub buildStub(Core core, AndroidOverlay impl) {
            return new AndroidOverlay_Internal.Stub(core, impl);
        }

        public AndroidOverlay[] buildArray(int size) {
            return new AndroidOverlay[size];
        }
    };

    private static final int SCHEDULE_LAYOUT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AndroidOverlay.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void scheduleLayout(Rect rect) {
            AndroidOverlay_Internal.AndroidOverlayScheduleLayoutParams _message = new AndroidOverlay_Internal.AndroidOverlayScheduleLayoutParams();
            _message.rect = rect;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AndroidOverlay> {
        Stub(Core core, AndroidOverlay impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AndroidOverlay_Internal.AndroidOverlayScheduleLayoutParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AndroidOverlay_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AndroidOverlay_Internal.AndroidOverlayScheduleLayoutParams.deserialize(messageWithHeader.getPayload());
                        ((AndroidOverlay)getImpl()).scheduleLayout(data.rect);
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
                                getCore(), AndroidOverlay_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AndroidOverlayScheduleLayoutParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Rect rect;

        private AndroidOverlayScheduleLayoutParams(int version) {
            super(16, version);
        }

        public AndroidOverlayScheduleLayoutParams() {
            this(0);
        }

        public static AndroidOverlayScheduleLayoutParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AndroidOverlayScheduleLayoutParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AndroidOverlayScheduleLayoutParams decode(Decoder decoder0) {
            AndroidOverlayScheduleLayoutParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AndroidOverlayScheduleLayoutParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.rect = Rect.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.rect, 8, false);
        }
    }
}
