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

class DisplayCutoutClient_Internal {
    public static final Interface.Manager<DisplayCutoutClient, DisplayCutoutClient.Proxy> MANAGER = new Interface.Manager<DisplayCutoutClient, DisplayCutoutClient.Proxy>() {
        public String getName() {
            return "blink.mojom.DisplayCutoutClient";
        }

        public int getVersion() {
            return 0;
        }

        public DisplayCutoutClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DisplayCutoutClient_Internal.Proxy(core, messageReceiver);
        }

        public DisplayCutoutClient_Internal.Stub buildStub(Core core, DisplayCutoutClient impl) {
            return new DisplayCutoutClient_Internal.Stub(core, impl);
        }

        public DisplayCutoutClient[] buildArray(int size) {
            return new DisplayCutoutClient[size];
        }
    };

    private static final int SET_SAFE_AREA_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements DisplayCutoutClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setSafeArea(DisplayCutoutSafeArea safeArea) {
            DisplayCutoutClient_Internal.DisplayCutoutClientSetSafeAreaParams _message = new DisplayCutoutClient_Internal.DisplayCutoutClientSetSafeAreaParams();
            _message.safeArea = safeArea;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<DisplayCutoutClient> {
        Stub(Core core, DisplayCutoutClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DisplayCutoutClient_Internal.DisplayCutoutClientSetSafeAreaParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DisplayCutoutClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = DisplayCutoutClient_Internal.DisplayCutoutClientSetSafeAreaParams.deserialize(messageWithHeader.getPayload());
                        ((DisplayCutoutClient)getImpl()).setSafeArea(data.safeArea);
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
                                getCore(), DisplayCutoutClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DisplayCutoutClientSetSafeAreaParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DisplayCutoutSafeArea safeArea;

        private DisplayCutoutClientSetSafeAreaParams(int version) {
            super(16, version);
        }

        public DisplayCutoutClientSetSafeAreaParams() {
            this(0);
        }

        public static DisplayCutoutClientSetSafeAreaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DisplayCutoutClientSetSafeAreaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DisplayCutoutClientSetSafeAreaParams decode(Decoder decoder0) {
            DisplayCutoutClientSetSafeAreaParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DisplayCutoutClientSetSafeAreaParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.safeArea = DisplayCutoutSafeArea.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.safeArea, 8, false);
        }
    }
}
