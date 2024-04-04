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

class PictureInPictureSession_Internal {
    public static final Interface.Manager<PictureInPictureSession, PictureInPictureSession.Proxy> MANAGER = new Interface.Manager<PictureInPictureSession, PictureInPictureSession.Proxy>() {
        public String getName() {
            return "blink.mojom.PictureInPictureSession";
        }

        public int getVersion() {
            return 0;
        }

        public PictureInPictureSession_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PictureInPictureSession_Internal.Proxy(core, messageReceiver);
        }

        public PictureInPictureSession_Internal.Stub buildStub(Core core, PictureInPictureSession impl) {
            return new PictureInPictureSession_Internal.Stub(core, impl);
        }

        public PictureInPictureSession[] buildArray(int size) {
            return new PictureInPictureSession[size];
        }
    };

    private static final int UPDATE_ORDINAL = 0;

    private static final int STOP_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements PictureInPictureSession.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void update(int playerId, SurfaceId surfaceId, Size naturalSize, boolean showPlayPauseButton, boolean showMuteButton) {
            PictureInPictureSession_Internal.PictureInPictureSessionUpdateParams _message = new PictureInPictureSession_Internal.PictureInPictureSessionUpdateParams();
            _message.playerId = playerId;
            _message.surfaceId = surfaceId;
            _message.naturalSize = naturalSize;
            _message.showPlayPauseButton = showPlayPauseButton;
            _message.showMuteButton = showMuteButton;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void stop(PictureInPictureSession.StopResponse callback) {
            PictureInPictureSession_Internal.PictureInPictureSessionStopParams _message = new PictureInPictureSession_Internal.PictureInPictureSessionStopParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new PictureInPictureSession_Internal.PictureInPictureSessionStopResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<PictureInPictureSession> {
        Stub(Core core, PictureInPictureSession impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PictureInPictureSession_Internal.PictureInPictureSessionUpdateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PictureInPictureSession_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PictureInPictureSession_Internal.PictureInPictureSessionUpdateParams.deserialize(messageWithHeader.getPayload());
                        ((PictureInPictureSession)getImpl()).update(data.playerId, data.surfaceId, data.naturalSize, data.showPlayPauseButton, data.showMuteButton);
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
                                getCore(), PictureInPictureSession_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        PictureInPictureSession_Internal.PictureInPictureSessionStopParams.deserialize(messageWithHeader.getPayload());
                        ((PictureInPictureSession)getImpl()).stop(new PictureInPictureSession_Internal.PictureInPictureSessionStopResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PictureInPictureSessionUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int playerId;

        public SurfaceId surfaceId;

        public Size naturalSize;

        public boolean showPlayPauseButton;

        public boolean showMuteButton;

        private PictureInPictureSessionUpdateParams(int version) {
            super(32, version);
        }

        public PictureInPictureSessionUpdateParams() {
            this(0);
        }

        public static PictureInPictureSessionUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureSessionUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureSessionUpdateParams decode(Decoder decoder0) {
            PictureInPictureSessionUpdateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureSessionUpdateParams(elementsOrVersion);
                result.playerId = decoder0.readInt(8);
                result.showPlayPauseButton = decoder0.readBoolean(12, 0);
                result.showMuteButton = decoder0.readBoolean(12, 1);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.surfaceId = SurfaceId.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.naturalSize = Size.decode(decoder1);
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
        }
    }

    static final class PictureInPictureSessionStopParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PictureInPictureSessionStopParams(int version) {
            super(8, version);
        }

        public PictureInPictureSessionStopParams() {
            this(0);
        }

        public static PictureInPictureSessionStopParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureSessionStopParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureSessionStopParams decode(Decoder decoder0) {
            PictureInPictureSessionStopParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureSessionStopParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class PictureInPictureSessionStopResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PictureInPictureSessionStopResponseParams(int version) {
            super(8, version);
        }

        public PictureInPictureSessionStopResponseParams() {
            this(0);
        }

        public static PictureInPictureSessionStopResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PictureInPictureSessionStopResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PictureInPictureSessionStopResponseParams decode(Decoder decoder0) {
            PictureInPictureSessionStopResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PictureInPictureSessionStopResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class PictureInPictureSessionStopResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PictureInPictureSession.StopResponse mCallback;

        PictureInPictureSessionStopResponseParamsForwardToCallback(PictureInPictureSession.StopResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PictureInPictureSessionStopResponseParamsProxyToResponder implements PictureInPictureSession.StopResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PictureInPictureSessionStopResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            PictureInPictureSession_Internal.PictureInPictureSessionStopResponseParams _response = new PictureInPictureSession_Internal.PictureInPictureSessionStopResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
