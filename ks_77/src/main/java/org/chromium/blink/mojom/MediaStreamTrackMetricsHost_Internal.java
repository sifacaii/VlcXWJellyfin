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

class MediaStreamTrackMetricsHost_Internal {
    public static final Interface.Manager<MediaStreamTrackMetricsHost, MediaStreamTrackMetricsHost.Proxy> MANAGER = new Interface.Manager<MediaStreamTrackMetricsHost, MediaStreamTrackMetricsHost.Proxy>() {
        public String getName() {
            return "blink.mojom.MediaStreamTrackMetricsHost";
        }

        public int getVersion() {
            return 0;
        }

        public MediaStreamTrackMetricsHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new MediaStreamTrackMetricsHost_Internal.Proxy(core, messageReceiver);
        }

        public MediaStreamTrackMetricsHost_Internal.Stub buildStub(Core core, MediaStreamTrackMetricsHost impl) {
            return new MediaStreamTrackMetricsHost_Internal.Stub(core, impl);
        }

        public MediaStreamTrackMetricsHost[] buildArray(int size) {
            return new MediaStreamTrackMetricsHost[size];
        }
    };

    private static final int ADD_TRACK_ORDINAL = 0;

    private static final int REMOVE_TRACK_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements MediaStreamTrackMetricsHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void addTrack(long id, boolean isAudio, boolean isRemote) {
            MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostAddTrackParams _message = new MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostAddTrackParams();
            _message.id = id;
            _message.isAudio = isAudio;
            _message.isRemote = isRemote;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void removeTrack(long id) {
            MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostRemoveTrackParams _message = new MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostRemoveTrackParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<MediaStreamTrackMetricsHost> {
        Stub(Core core, MediaStreamTrackMetricsHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostAddTrackParams mediaStreamTrackMetricsHostAddTrackParams;
                MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostRemoveTrackParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaStreamTrackMetricsHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        mediaStreamTrackMetricsHostAddTrackParams = MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostAddTrackParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamTrackMetricsHost)getImpl()).addTrack(mediaStreamTrackMetricsHostAddTrackParams.id, mediaStreamTrackMetricsHostAddTrackParams.isAudio, mediaStreamTrackMetricsHostAddTrackParams.isRemote);
                        return true;
                    case 1:
                        data = MediaStreamTrackMetricsHost_Internal.MediaStreamTrackMetricsHostRemoveTrackParams.deserialize(messageWithHeader.getPayload());
                        ((MediaStreamTrackMetricsHost)getImpl()).removeTrack(data.id);
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
                                getCore(), MediaStreamTrackMetricsHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class MediaStreamTrackMetricsHostAddTrackParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long id;

        public boolean isAudio;

        public boolean isRemote;

        private MediaStreamTrackMetricsHostAddTrackParams(int version) {
            super(24, version);
        }

        public MediaStreamTrackMetricsHostAddTrackParams() {
            this(0);
        }

        public static MediaStreamTrackMetricsHostAddTrackParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamTrackMetricsHostAddTrackParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamTrackMetricsHostAddTrackParams decode(Decoder decoder0) {
            MediaStreamTrackMetricsHostAddTrackParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamTrackMetricsHostAddTrackParams(elementsOrVersion);
                result.id = decoder0.readLong(8);
                result.isAudio = decoder0.readBoolean(16, 0);
                result.isRemote = decoder0.readBoolean(16, 1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8);
            encoder0.encode(this.isAudio, 16, 0);
            encoder0.encode(this.isRemote, 16, 1);
        }
    }

    static final class MediaStreamTrackMetricsHostRemoveTrackParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long id;

        private MediaStreamTrackMetricsHostRemoveTrackParams(int version) {
            super(16, version);
        }

        public MediaStreamTrackMetricsHostRemoveTrackParams() {
            this(0);
        }

        public static MediaStreamTrackMetricsHostRemoveTrackParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaStreamTrackMetricsHostRemoveTrackParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaStreamTrackMetricsHostRemoveTrackParams decode(Decoder decoder0) {
            MediaStreamTrackMetricsHostRemoveTrackParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaStreamTrackMetricsHostRemoveTrackParams(elementsOrVersion);
                result.id = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8);
        }
    }
}
