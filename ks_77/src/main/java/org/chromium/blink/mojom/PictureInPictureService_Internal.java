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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.viz.mojom.SurfaceId;

class PictureInPictureService_Internal {
    public static final Interface.Manager<PictureInPictureService, PictureInPictureService.Proxy> MANAGER = new Interface.Manager<PictureInPictureService, PictureInPictureService.Proxy>() {
        public String getName() {
            return "blink.mojom.PictureInPictureService";
        }

        public int getVersion() {
            return 0;
        }

        public PictureInPictureService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PictureInPictureService_Internal.Proxy(core, messageReceiver);
        }

        public PictureInPictureService_Internal.Stub buildStub(Core core, PictureInPictureService impl) {
            return new PictureInPictureService_Internal.Stub(core, impl);
        }

        public PictureInPictureService[] buildArray(int size) {
            return new PictureInPictureService[size];
        }
    };

    private static final int START_SESSION_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PictureInPictureService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void startSession(int playerId, SurfaceId surfaceId, Size naturalSize, boolean showPlayPauseButton, boolean showMuteButton, PictureInPictureSessionObserver observer, PictureInPictureService.StartSessionResponse callback) {
            PictureInPictureService_Internal.PictureInPictureServiceStartSessionParams _message = new PictureInPictureService_Internal.PictureInPictureServiceStartSessionParams();
            _message.playerId = playerId;
            _message.surfaceId = surfaceId;
            _message.naturalSize = naturalSize;
            _message.showPlayPauseButton = showPlayPauseButton;
            _message.showMuteButton = showMuteButton;
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PictureInPictureService_Internal.PictureInPictureServiceStartSessionResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<PictureInPictureService> {
        Stub(Core core, PictureInPictureService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PictureInPictureService_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                PictureInPictureService_Internal.PictureInPictureServiceStartSessionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PictureInPictureService_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = PictureInPictureService_Internal.PictureInPictureServiceStartSessionParams.deserialize(messageWithHeader.getPayload());
                        ((PictureInPictureService)getImpl()).startSession(data.playerId, data.surfaceId, data.naturalSize, data.showPlayPauseButton, data.showMuteButton, data.observer, new PictureInPictureService_Internal.PictureInPictureServiceStartSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PictureInPictureServiceStartSessionParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int playerId;

        public SurfaceId surfaceId;

        public Size naturalSize;

        public boolean showPlayPauseButton;

        public boolean showMuteButton;

        public PictureInPictureSessionObserver observer;

        private PictureInPictureServiceStartSessionParams(int version) {
            super(40, version);
        }

        public PictureInPictureServiceStartSessionParams() {
            this(0);
        }

        public static PictureInPictureServiceStartSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureServiceStartSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureServiceStartSessionParams decode(Decoder decoder0) {
            PictureInPictureServiceStartSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureServiceStartSessionParams(elementsOrVersion);
                result.playerId = decoder0.readInt(8);
                result.showPlayPauseButton = decoder0.readBoolean(12, 0);
                result.showMuteButton = decoder0.readBoolean(12, 1);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.surfaceId = SurfaceId.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.naturalSize = Size.decode(decoder1);
                result.observer = (PictureInPictureSessionObserver)decoder0.readServiceInterface(32, false, PictureInPictureSessionObserver.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.playerId, 8);
            encoder0.encode(this.showPlayPauseButton, 12, 0);
            encoder0.encode(this.showMuteButton, 12, 1);
            encoder0.encode((Struct)this.surfaceId, 16, true);
            encoder0.encode((Struct)this.naturalSize, 24, false);
            encoder0.encode(this.observer, 32, false, PictureInPictureSessionObserver.MANAGER);
        }
    }

    static final class PictureInPictureServiceStartSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PictureInPictureSession session;

        public Size size;

        private PictureInPictureServiceStartSessionResponseParams(int version) {
            super(24, version);
        }

        public PictureInPictureServiceStartSessionResponseParams() {
            this(0);
        }

        public static PictureInPictureServiceStartSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureServiceStartSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureServiceStartSessionResponseParams decode(Decoder decoder0) {
            PictureInPictureServiceStartSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureServiceStartSessionResponseParams(elementsOrVersion);
                result.session = (PictureInPictureSession)decoder0.readServiceInterface(8, true, PictureInPictureSession.MANAGER);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.size = Size.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.session, 8, true, PictureInPictureSession.MANAGER);
            encoder0.encode((Struct)this.size, 16, false);
        }
    }

    static class PictureInPictureServiceStartSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PictureInPictureService.StartSessionResponse mCallback;

        PictureInPictureServiceStartSessionResponseParamsForwardToCallback(PictureInPictureService.StartSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                PictureInPictureService_Internal.PictureInPictureServiceStartSessionResponseParams response = PictureInPictureService_Internal.PictureInPictureServiceStartSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.session, response.size);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PictureInPictureServiceStartSessionResponseParamsProxyToResponder implements PictureInPictureService.StartSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PictureInPictureServiceStartSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(PictureInPictureSession session, Size size) {
            PictureInPictureService_Internal.PictureInPictureServiceStartSessionResponseParams _response = new PictureInPictureService_Internal.PictureInPictureServiceStartSessionResponseParams();
            _response.session = session;
            _response.size = size;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
