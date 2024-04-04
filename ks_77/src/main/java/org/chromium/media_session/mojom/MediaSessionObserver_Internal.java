package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

class MediaSessionObserver_Internal {
    public static final Interface.Manager<MediaSessionObserver, MediaSessionObserver.Proxy> MANAGER = new Interface.Manager<MediaSessionObserver, MediaSessionObserver.Proxy>() {
        public String getName() {
            return "media_session.mojom.MediaSessionObserver";
        }

        public int getVersion() {
            return 0;
        }

        public MediaSessionObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaSessionObserver_Internal.Proxy(core, messageReceiver);
        }

        public MediaSessionObserver_Internal.Stub buildStub(Core core, MediaSessionObserver impl) {
            return new MediaSessionObserver_Internal.Stub(core, impl);
        }

        public MediaSessionObserver[] buildArray(int size) {
            return new MediaSessionObserver[size];
        }
    };

    private static final int MEDIA_SESSION_INFO_CHANGED_ORDINAL = 0;

    private static final int MEDIA_SESSION_METADATA_CHANGED_ORDINAL = 1;

    private static final int MEDIA_SESSION_ACTIONS_CHANGED_ORDINAL = 2;

    private static final int MEDIA_SESSION_IMAGES_CHANGED_ORDINAL = 3;

    private static final int MEDIA_SESSION_POSITION_CHANGED_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements MediaSessionObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void mediaSessionInfoChanged(MediaSessionInfo info) {
            MediaSessionObserver_Internal.MediaSessionObserverMediaSessionInfoChangedParams _message = new MediaSessionObserver_Internal.MediaSessionObserverMediaSessionInfoChangedParams();
            _message.info = info;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void mediaSessionMetadataChanged(MediaMetadata metadata) {
            MediaSessionObserver_Internal.MediaSessionObserverMediaSessionMetadataChangedParams _message = new MediaSessionObserver_Internal.MediaSessionObserverMediaSessionMetadataChangedParams();
            _message.metadata = metadata;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void mediaSessionActionsChanged(int[] action) {
            MediaSessionObserver_Internal.MediaSessionObserverMediaSessionActionsChangedParams _message = new MediaSessionObserver_Internal.MediaSessionObserverMediaSessionActionsChangedParams();
            _message.action = action;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void mediaSessionImagesChanged(Map<Integer, MediaImage[]> images) {
            MediaSessionObserver_Internal.MediaSessionObserverMediaSessionImagesChangedParams _message = new MediaSessionObserver_Internal.MediaSessionObserverMediaSessionImagesChangedParams();
            _message.images = images;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void mediaSessionPositionChanged(MediaPosition position) {
            MediaSessionObserver_Internal.MediaSessionObserverMediaSessionPositionChangedParams _message = new MediaSessionObserver_Internal.MediaSessionObserverMediaSessionPositionChangedParams();
            _message.position = position;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }
    }

    static final class Stub extends Interface.Stub<MediaSessionObserver> {
        Stub(Core core, MediaSessionObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaSessionObserver_Internal.MediaSessionObserverMediaSessionInfoChangedParams mediaSessionObserverMediaSessionInfoChangedParams;
                MediaSessionObserver_Internal.MediaSessionObserverMediaSessionMetadataChangedParams mediaSessionObserverMediaSessionMetadataChangedParams;
                MediaSessionObserver_Internal.MediaSessionObserverMediaSessionActionsChangedParams mediaSessionObserverMediaSessionActionsChangedParams;
                MediaSessionObserver_Internal.MediaSessionObserverMediaSessionImagesChangedParams mediaSessionObserverMediaSessionImagesChangedParams;
                MediaSessionObserver_Internal.MediaSessionObserverMediaSessionPositionChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaSessionObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        mediaSessionObserverMediaSessionInfoChangedParams = MediaSessionObserver_Internal.MediaSessionObserverMediaSessionInfoChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionObserver)getImpl()).mediaSessionInfoChanged(mediaSessionObserverMediaSessionInfoChangedParams.info);
                        return true;
                    case 1:
                        mediaSessionObserverMediaSessionMetadataChangedParams = MediaSessionObserver_Internal.MediaSessionObserverMediaSessionMetadataChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionObserver)getImpl()).mediaSessionMetadataChanged(mediaSessionObserverMediaSessionMetadataChangedParams.metadata);
                        return true;
                    case 2:
                        mediaSessionObserverMediaSessionActionsChangedParams = MediaSessionObserver_Internal.MediaSessionObserverMediaSessionActionsChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionObserver)getImpl()).mediaSessionActionsChanged(mediaSessionObserverMediaSessionActionsChangedParams.action);
                        return true;
                    case 3:
                        mediaSessionObserverMediaSessionImagesChangedParams = MediaSessionObserver_Internal.MediaSessionObserverMediaSessionImagesChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionObserver)getImpl()).mediaSessionImagesChanged(mediaSessionObserverMediaSessionImagesChangedParams.images);
                        return true;
                    case 4:
                        data = MediaSessionObserver_Internal.MediaSessionObserverMediaSessionPositionChangedParams.deserialize(messageWithHeader.getPayload());
                        ((MediaSessionObserver)getImpl()).mediaSessionPositionChanged(data.position);
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
                                getCore(), MediaSessionObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaSessionObserverMediaSessionInfoChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MediaSessionInfo info;

        private MediaSessionObserverMediaSessionInfoChangedParams(int version) {
            super(16, version);
        }

        public MediaSessionObserverMediaSessionInfoChangedParams() {
            this(0);
        }

        public static MediaSessionObserverMediaSessionInfoChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionObserverMediaSessionInfoChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionObserverMediaSessionInfoChangedParams decode(Decoder decoder0) {
            MediaSessionObserverMediaSessionInfoChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionObserverMediaSessionInfoChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = MediaSessionInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
        }
    }

    static final class MediaSessionObserverMediaSessionMetadataChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MediaMetadata metadata;

        private MediaSessionObserverMediaSessionMetadataChangedParams(int version) {
            super(16, version);
        }

        public MediaSessionObserverMediaSessionMetadataChangedParams() {
            this(0);
        }

        public static MediaSessionObserverMediaSessionMetadataChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionObserverMediaSessionMetadataChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionObserverMediaSessionMetadataChangedParams decode(Decoder decoder0) {
            MediaSessionObserverMediaSessionMetadataChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionObserverMediaSessionMetadataChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.metadata = MediaMetadata.decode(decoder1);
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

    static final class MediaSessionObserverMediaSessionActionsChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int[] action;

        private MediaSessionObserverMediaSessionActionsChangedParams(int version) {
            super(16, version);
        }

        public MediaSessionObserverMediaSessionActionsChangedParams() {
            this(0);
        }

        public static MediaSessionObserverMediaSessionActionsChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionObserverMediaSessionActionsChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionObserverMediaSessionActionsChangedParams decode(Decoder decoder0) {
            MediaSessionObserverMediaSessionActionsChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionObserverMediaSessionActionsChangedParams(elementsOrVersion);
                result.action = decoder0.readInts(8, 0, -1);
                for (int i0 = 0; i0 < result.action.length; i0++)
                    MediaSessionAction.validate(result.action[i0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.action, 8, 0, -1);
        }
    }

    static final class MediaSessionObserverMediaSessionImagesChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Map<Integer, MediaImage[]> images;

        private MediaSessionObserverMediaSessionImagesChangedParams(int version) {
            super(16, version);
        }

        public MediaSessionObserverMediaSessionImagesChangedParams() {
            this(0);
        }

        public static MediaSessionObserverMediaSessionImagesChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionObserverMediaSessionImagesChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionObserverMediaSessionImagesChangedParams decode(Decoder decoder0) {
            MediaSessionObserverMediaSessionImagesChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionObserverMediaSessionImagesChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                decoder1.readDataHeaderForMap();
                int[] keys0 = decoder1.readInts(8, 0, -1);
                for (int i1 = 0; i1 < keys0.length; i1++)
                    MediaSessionImageType.validate(keys0[i1]);
                Decoder decoder2 = decoder1.readPointer(16, false);
                DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
                MediaImage[][] values0 = new MediaImage[si2.elementsOrVersion][];
                for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                    Decoder decoder3 = decoder2.readPointer(8 + 8 * i2, false);
                    DataHeader si3 = decoder3.readDataHeaderForPointerArray(-1);
                    values0[i2] = new MediaImage[si3.elementsOrVersion];
                    for (int i3 = 0; i3 < si3.elementsOrVersion; i3++) {
                        Decoder decoder4 = decoder3.readPointer(8 + 8 * i3, false);
                        values0[i2][i3] = MediaImage.decode(decoder4);
                    }
                }
                result.images = (Map)new HashMap<>();
                for (int index0 = 0; index0 < keys0.length; index0++)
                    result.images.put(Integer.valueOf(keys0[index0]), values0[index0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.images == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encoderForMap(8);
                int size0 = this.images.size();
                int[] keys0 = new int[size0];
                MediaImage[][] values0 = new MediaImage[size0][];
                int index0 = 0;
                for (Map.Entry<Integer, MediaImage[]> entry0 : this.images.entrySet()) {
                    keys0[index0] = ((Integer)entry0.getKey()).intValue();
                    values0[index0] = entry0.getValue();
                    index0++;
                }
                encoder1.encode(keys0, 8, 0, -1);
                Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
                for (int i1 = 0; i1 < values0.length; i1++) {
                    if (values0[i1] == null) {
                        encoder2.encodeNullPointer(8 + 8 * i1, false);
                    } else {
                        Encoder encoder3 = encoder2.encodePointerArray((values0[i1]).length, 8 + 8 * i1, -1);
                        for (int i2 = 0; i2 < (values0[i1]).length; i2++)
                            encoder3.encode(values0[i1][i2], 8 + 8 * i2, false);
                    }
                }
            }
        }
    }

    static final class MediaSessionObserverMediaSessionPositionChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public MediaPosition position;

        private MediaSessionObserverMediaSessionPositionChangedParams(int version) {
            super(16, version);
        }

        public MediaSessionObserverMediaSessionPositionChangedParams() {
            this(0);
        }

        public static MediaSessionObserverMediaSessionPositionChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaSessionObserverMediaSessionPositionChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaSessionObserverMediaSessionPositionChangedParams decode(Decoder decoder0) {
            MediaSessionObserverMediaSessionPositionChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionObserverMediaSessionPositionChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.position = MediaPosition.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.position, 8, true);
        }
    }
}
