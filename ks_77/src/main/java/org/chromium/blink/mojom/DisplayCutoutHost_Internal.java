package org.chromium.blink.mojom;

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

class DisplayCutoutHost_Internal {
    public static final Interface.Manager<DisplayCutoutHost, DisplayCutoutHost.Proxy> MANAGER = new Interface.Manager<DisplayCutoutHost, DisplayCutoutHost.Proxy>() {
        public String getName() {
            return "blink.mojom.DisplayCutoutHost";
        }

        public int getVersion() {
            return 0;
        }

        public DisplayCutoutHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DisplayCutoutHost_Internal.Proxy(core, messageReceiver);
        }

        public DisplayCutoutHost_Internal.Stub buildStub(Core core, DisplayCutoutHost impl) {
            return new DisplayCutoutHost_Internal.Stub(core, impl);
        }

        public DisplayCutoutHost[] buildArray(int size) {
            return new DisplayCutoutHost[size];
        }
    };

    private static final int NOTIFY_VIEWPORT_FIT_CHANGED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements DisplayCutoutHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void notifyViewportFitChanged(int value) {
            DisplayCutoutHost_Internal.DisplayCutoutHostNotifyViewportFitChangedParams _message = new DisplayCutoutHost_Internal.DisplayCutoutHostNotifyViewportFitChangedParams();
            _message.value = value;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<DisplayCutoutHost> {
        Stub(Core core, DisplayCutoutHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DisplayCutoutHost_Internal.DisplayCutoutHostNotifyViewportFitChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DisplayCutoutHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = DisplayCutoutHost_Internal.DisplayCutoutHostNotifyViewportFitChangedParams.deserialize(messageWithHeader.getPayload());
                        ((DisplayCutoutHost)getImpl()).notifyViewportFitChanged(data.value);
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
                                getCore(), DisplayCutoutHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DisplayCutoutHostNotifyViewportFitChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int value;

        private DisplayCutoutHostNotifyViewportFitChangedParams(int version) {
            super(16, version);
        }

        public DisplayCutoutHostNotifyViewportFitChangedParams() {
            this(0);
        }

        public static DisplayCutoutHostNotifyViewportFitChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DisplayCutoutHostNotifyViewportFitChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DisplayCutoutHostNotifyViewportFitChangedParams decode(Decoder decoder0) {
            DisplayCutoutHostNotifyViewportFitChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DisplayCutoutHostNotifyViewportFitChangedParams(elementsOrVersion);
                result.value = decoder0.readInt(8);
                ViewportFit.validate(result.value);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.value, 8);
        }
    }
}
