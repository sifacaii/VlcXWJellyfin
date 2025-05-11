package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AppBannerController_Internal {
    public static final Interface.Manager<AppBannerController, AppBannerController.Proxy> MANAGER = new Interface.Manager<AppBannerController, AppBannerController.Proxy>() {
        public String getName() {
            return "blink.mojom.AppBannerController";
        }

        public int getVersion() {
            return 0;
        }

        public AppBannerController_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AppBannerController_Internal.Proxy(core, messageReceiver);
        }

        public AppBannerController_Internal.Stub buildStub(Core core, AppBannerController impl) {
            return new AppBannerController_Internal.Stub(core, impl);
        }

        public AppBannerController[] buildArray(int size) {
            return new AppBannerController[size];
        }
    };

    private static final int BANNER_PROMPT_REQUEST_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AppBannerController.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void bannerPromptRequest(AppBannerService service, InterfaceRequest<AppBannerEvent> event, String[] platform, boolean requireGesture, AppBannerController.BannerPromptRequestResponse callback) {
            AppBannerController_Internal.AppBannerControllerBannerPromptRequestParams _message = new AppBannerController_Internal.AppBannerControllerBannerPromptRequestParams();
            _message.service = service;
            _message.event = event;
            _message.platform = platform;
            _message.requireGesture = requireGesture;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new AppBannerController_Internal.AppBannerControllerBannerPromptRequestResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<AppBannerController> {
        Stub(Core core, AppBannerController impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AppBannerController_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                AppBannerController_Internal.AppBannerControllerBannerPromptRequestParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), AppBannerController_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = AppBannerController_Internal.AppBannerControllerBannerPromptRequestParams.deserialize(messageWithHeader.getPayload());
                        ((AppBannerController)getImpl()).bannerPromptRequest(data.service, data.event, data.platform, data.requireGesture, new AppBannerController_Internal.AppBannerControllerBannerPromptRequestResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AppBannerControllerBannerPromptRequestParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AppBannerService service;

        public InterfaceRequest<AppBannerEvent> event;

        public String[] platform;

        public boolean requireGesture;

        private AppBannerControllerBannerPromptRequestParams(int version) {
            super(32, version);
        }

        public AppBannerControllerBannerPromptRequestParams() {
            this(0);
        }

        public static AppBannerControllerBannerPromptRequestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppBannerControllerBannerPromptRequestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppBannerControllerBannerPromptRequestParams decode(Decoder decoder0) {
            AppBannerControllerBannerPromptRequestParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppBannerControllerBannerPromptRequestParams(elementsOrVersion);
                result.service = (AppBannerService)decoder0.readServiceInterface(8, false, AppBannerService.MANAGER);
                result.event = decoder0.readInterfaceRequest(16, false);
                result.requireGesture = decoder0.readBoolean(20, 0);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.platform = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++)
                    result.platform[i1] = decoder1.readString(8 + 8 * i1, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.service, 8, false, AppBannerService.MANAGER);
            encoder0.encode(this.event, 16, false);
            encoder0.encode(this.requireGesture, 20, 0);
            if (this.platform == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.platform.length, 24, -1);
                for (int i0 = 0; i0 < this.platform.length; i0++)
                    encoder1.encode(this.platform[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class AppBannerControllerBannerPromptRequestResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int reply;

        private AppBannerControllerBannerPromptRequestResponseParams(int version) {
            super(16, version);
        }

        public AppBannerControllerBannerPromptRequestResponseParams() {
            this(0);
        }

        public static AppBannerControllerBannerPromptRequestResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AppBannerControllerBannerPromptRequestResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AppBannerControllerBannerPromptRequestResponseParams decode(Decoder decoder0) {
            AppBannerControllerBannerPromptRequestResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AppBannerControllerBannerPromptRequestResponseParams(elementsOrVersion);
                result.reply = decoder0.readInt(8);
                AppBannerPromptReply.validate(result.reply);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reply, 8);
        }
    }

    static class AppBannerControllerBannerPromptRequestResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AppBannerController.BannerPromptRequestResponse mCallback;

        AppBannerControllerBannerPromptRequestResponseParamsForwardToCallback(AppBannerController.BannerPromptRequestResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                AppBannerController_Internal.AppBannerControllerBannerPromptRequestResponseParams response = AppBannerController_Internal.AppBannerControllerBannerPromptRequestResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.reply));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AppBannerControllerBannerPromptRequestResponseParamsProxyToResponder implements AppBannerController.BannerPromptRequestResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AppBannerControllerBannerPromptRequestResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer reply) {
            AppBannerController_Internal.AppBannerControllerBannerPromptRequestResponseParams _response = new AppBannerController_Internal.AppBannerControllerBannerPromptRequestResponseParams();
            _response.reply = reply.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
