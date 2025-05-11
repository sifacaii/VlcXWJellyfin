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

class AppBannerService_Internal {
    public static final Interface.Manager<AppBannerService, AppBannerService.Proxy> MANAGER = new Interface.Manager<AppBannerService, AppBannerService.Proxy>() {
        public String getName() {
            return "blink.mojom.AppBannerService";
        }

        public int getVersion() {
            return 0;
        }

        public AppBannerService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AppBannerService_Internal.Proxy(core, messageReceiver);
        }

        public AppBannerService_Internal.Stub buildStub(Core core, AppBannerService impl) {
            return new AppBannerService_Internal.Stub(core, impl);
        }

        public AppBannerService[] buildArray(int size) {
            return new AppBannerService[size];
        }
    };

    private static final int DISPLAY_APP_BANNER_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AppBannerService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void displayAppBanner() {
            AppBannerService_Internal.AppBannerServiceDisplayAppBannerParams _message = new AppBannerService_Internal.AppBannerServiceDisplayAppBannerParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AppBannerService> {
        Stub(Core core, AppBannerService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AppBannerService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AppBannerService_Internal.AppBannerServiceDisplayAppBannerParams.deserialize(messageWithHeader.getPayload());
                        ((AppBannerService)getImpl()).displayAppBanner();
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
                                getCore(), AppBannerService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AppBannerServiceDisplayAppBannerParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AppBannerServiceDisplayAppBannerParams(int version) {
            super(8, version);
        }

        public AppBannerServiceDisplayAppBannerParams() {
            this(0);
        }

        public static AppBannerServiceDisplayAppBannerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppBannerServiceDisplayAppBannerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppBannerServiceDisplayAppBannerParams decode(Decoder decoder0) {
            AppBannerServiceDisplayAppBannerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppBannerServiceDisplayAppBannerParams(elementsOrVersion);
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
