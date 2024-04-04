package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaSessionAction;
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

class MediaSessionService_Internal {
    public static final Interface.Manager<MediaSessionService, MediaSessionService.Proxy> MANAGER = new Interface.Manager<MediaSessionService, MediaSessionService.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaSessionService";
        }

        public int getVersion() {
            return 0;
        }

        public MediaSessionService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaSessionService_Internal.Proxy(core, messageReceiver);
        }

        public MediaSessionService_Internal.Stub buildStub(Core core, MediaSessionService impl) {
            return new MediaSessionService_Internal.Stub(core, impl);
        }

        public MediaSessionService[] buildArray(int size) {
            return new MediaSessionService[size];
        }
    };

    private static final int SET_CLIENT_ORDINAL = 0;

    private static final int SET_PLAYBACK_STATE_ORDINAL = 1;

    private static final int SET_METADATA_ORDINAL = 2;

    private static final int ENABLE_ACTION_ORDINAL = 3;

    private static final int DISABLE_ACTION_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements MediaSessionService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setClient(MediaSessionClient client) {
            MediaSessionService_Internal.MediaSessionServiceSetClientParams _message = new MediaSessionService_Internal.MediaSessionServiceSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setPlaybackState(int state) {
            MediaSessionService_Internal.MediaSessionServiceSetPlaybackStateParams _message = new MediaSessionService_Internal.MediaSessionServiceSetPlaybackStateParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void setMetadata(SpecMediaMetadata metadata) {
            MediaSessionService_Internal.MediaSessionServiceSetMetadataParams _message = new MediaSessionService_Internal.MediaSessionServiceSetMetadataParams();
            _message.metadata = metadata;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void enableAction(int action) {
            MediaSessionService_Internal.MediaSessionServiceEnableActionParams _message = new MediaSessionService_Internal.MediaSessionServiceEnableActionParams();
            _message.action = action;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void disableAction(int action) {
            MediaSessionService_Internal.MediaSessionServiceDisableActionParams _message = new MediaSessionService_Internal.MediaSessionServiceDisableActionParams();
            _message.action = action;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<MediaSessionService> {
        Stub(Core core, MediaSessionService impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaSessionService_Internal.MediaSessionServiceSetClientParams mediaSessionServiceSetClientParams;
                MediaSessionService_Internal.MediaSessionServiceSetPlaybackStateParams mediaSessionServiceSetPlaybackStateParams;
                MediaSessionService_Internal.MediaSessionServiceSetMetadataParams mediaSessionServiceSetMetadataParams;
                MediaSessionService_Internal.MediaSessionServiceEnableActionParams mediaSessionServiceEnableActionParams;
                MediaSessionService_Internal.MediaSessionServiceDisableActionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaSessionService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        mediaSessionServiceSetClientParams = MediaSessionService_Internal.MediaSessionServiceSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionService)getImpl()).setClient(mediaSessionServiceSetClientParams.client);
                        return true;
                    case 1:
                        mediaSessionServiceSetPlaybackStateParams = MediaSessionService_Internal.MediaSessionServiceSetPlaybackStateParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionService)getImpl()).setPlaybackState(mediaSessionServiceSetPlaybackStateParams.state);
                        return true;
                    case 2:
                        mediaSessionServiceSetMetadataParams = MediaSessionService_Internal.MediaSessionServiceSetMetadataParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionService)getImpl()).setMetadata(mediaSessionServiceSetMetadataParams.metadata);
                        return true;
                    case 3:
                        mediaSessionServiceEnableActionParams = MediaSessionService_Internal.MediaSessionServiceEnableActionParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionService)getImpl()).enableAction(mediaSessionServiceEnableActionParams.action);
                        return true;
                    case 4:
                        data = MediaSessionService_Internal.MediaSessionServiceDisableActionParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionService)getImpl()).disableAction(data.action);
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
                                getCore(), MediaSessionService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaSessionServiceSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MediaSessionClient client;

        private MediaSessionServiceSetClientParams(int version) {
            super(16, version);
        }

        public MediaSessionServiceSetClientParams() {
            this(0);
        }

        public static MediaSessionServiceSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionServiceSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionServiceSetClientParams decode(Decoder decoder0) {
            MediaSessionServiceSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceSetClientParams(elementsOrVersion);
                result.client = (MediaSessionClient)decoder0.readServiceInterface(8, false, MediaSessionClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false, MediaSessionClient.MANAGER);
        }
    }

    static final class MediaSessionServiceSetPlaybackStateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int state;

        private MediaSessionServiceSetPlaybackStateParams(int version) {
            super(16, version);
        }

        public MediaSessionServiceSetPlaybackStateParams() {
            this(0);
        }

        public static MediaSessionServiceSetPlaybackStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionServiceSetPlaybackStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionServiceSetPlaybackStateParams decode(Decoder decoder0) {
            MediaSessionServiceSetPlaybackStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceSetPlaybackStateParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                MediaSessionPlaybackState.validate(result.state);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.state, 8);
        }
    }

    static final class MediaSessionServiceSetMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SpecMediaMetadata metadata;

        private MediaSessionServiceSetMetadataParams(int version) {
            super(16, version);
        }

        public MediaSessionServiceSetMetadataParams() {
            this(0);
        }

        public static MediaSessionServiceSetMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionServiceSetMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionServiceSetMetadataParams decode(Decoder decoder0) {
            MediaSessionServiceSetMetadataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceSetMetadataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.metadata = SpecMediaMetadata.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.metadata, 8, true);
        }
    }

    static final class MediaSessionServiceEnableActionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int action;

        private MediaSessionServiceEnableActionParams(int version) {
            super(16, version);
        }

        public MediaSessionServiceEnableActionParams() {
            this(0);
        }

        public static MediaSessionServiceEnableActionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionServiceEnableActionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionServiceEnableActionParams decode(Decoder decoder0) {
            MediaSessionServiceEnableActionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceEnableActionParams(elementsOrVersion);
                result.action = decoder0.readInt(8);
                MediaSessionAction.validate(result.action);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.action, 8);
        }
    }

    static final class MediaSessionServiceDisableActionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int action;

        private MediaSessionServiceDisableActionParams(int version) {
            super(16, version);
        }

        public MediaSessionServiceDisableActionParams() {
            this(0);
        }

        public static MediaSessionServiceDisableActionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionServiceDisableActionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionServiceDisableActionParams decode(Decoder decoder0) {
            MediaSessionServiceDisableActionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceDisableActionParams(elementsOrVersion);
                result.action = decoder0.readInt(8);
                MediaSessionAction.validate(result.action);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.action, 8);
        }
    }
}
