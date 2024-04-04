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

class AppBannerEvent_Internal {
    public static final Interface.Manager<AppBannerEvent, AppBannerEvent.Proxy> MANAGER = new Interface.Manager<AppBannerEvent, AppBannerEvent.Proxy>() {
        public String getName() {
            return "blink.mojom.AppBannerEvent";
        }

        public int getVersion() {
            return 0;
        }

        public AppBannerEvent_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AppBannerEvent_Internal.Proxy(core, messageReceiver);
        }

        public AppBannerEvent_Internal.Stub buildStub(Core core, AppBannerEvent impl) {
            return new AppBannerEvent_Internal.Stub(core, impl);
        }

        public AppBannerEvent[] buildArray(int size) {
            return new AppBannerEvent[size];
        }
    };

    private static final int BANNER_ACCEPTED_ORDINAL = 0;

    private static final int BANNER_DISMISSED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements AppBannerEvent.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void bannerAccepted(String platform) {
            AppBannerEvent_Internal.AppBannerEventBannerAcceptedParams _message = new AppBannerEvent_Internal.AppBannerEventBannerAcceptedParams();
            _message.platform = platform;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void bannerDismissed() {
            AppBannerEvent_Internal.AppBannerEventBannerDismissedParams _message = new AppBannerEvent_Internal.AppBannerEventBannerDismissedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<AppBannerEvent> {
        Stub(Core core, AppBannerEvent impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AppBannerEvent_Internal.AppBannerEventBannerAcceptedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AppBannerEvent_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AppBannerEvent_Internal.AppBannerEventBannerAcceptedParams.deserialize(messageWithHeader.getPayload());
                        ((AppBannerEvent)getImpl()).bannerAccepted(data.platform);
                        return true;
                    case 1:
                        AppBannerEvent_Internal.AppBannerEventBannerDismissedParams.deserialize(messageWithHeader.getPayload());
                        ((AppBannerEvent)getImpl()).bannerDismissed();
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
                                getCore(), AppBannerEvent_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AppBannerEventBannerAcceptedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String platform;

        private AppBannerEventBannerAcceptedParams(int version) {
            super(16, version);
        }

        public AppBannerEventBannerAcceptedParams() {
            this(0);
        }

        public static AppBannerEventBannerAcceptedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppBannerEventBannerAcceptedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppBannerEventBannerAcceptedParams decode(Decoder decoder0) {
            AppBannerEventBannerAcceptedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppBannerEventBannerAcceptedParams(elementsOrVersion);
                result.platform = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.platform, 8, false);
        }
    }

    static final class AppBannerEventBannerDismissedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AppBannerEventBannerDismissedParams(int version) {
            super(8, version);
        }

        public AppBannerEventBannerDismissedParams() {
            this(0);
        }

        public static AppBannerEventBannerDismissedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppBannerEventBannerDismissedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppBannerEventBannerDismissedParams decode(Decoder decoder0) {
            AppBannerEventBannerDismissedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppBannerEventBannerDismissedParams(elementsOrVersion);
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
