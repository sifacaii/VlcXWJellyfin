package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSessionInfo.class */
public final class MediaSessionInfo extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0), new DataHeader(24, 1), new DataHeader(24, 2), new DataHeader(24, 4)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[3];
    public int state;
    public boolean forceDuck;
    public int playbackState;
    public boolean isControllable;
    public boolean preferStopForGainFocusLoss;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSessionInfo$SessionState.class */
    public static final class SessionState {
        private static final boolean IS_EXTENSIBLE = true;
        public static final int ACTIVE = 0;
        public static final int DUCKING = 1;
        public static final int SUSPENDED = 2;
        public static final int INACTIVE = 3;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 3;
        }

        public static void validate(int value) {
        }

        private SessionState() {
        }
    }

    private MediaSessionInfo(int version) {
        super(24, version);
    }

    public MediaSessionInfo() {
        this(4);
    }

    public static MediaSessionInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaSessionInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaSessionInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaSessionInfo result = new MediaSessionInfo(elementsOrVersion);
            result.state = decoder0.readInt(8);
            SessionState.validate(result.state);
            result.forceDuck = decoder0.readBoolean(12, 0);
            if (elementsOrVersion >= 2) {
                result.isControllable = decoder0.readBoolean(12, 1);
            }
            if (elementsOrVersion >= 4) {
                result.preferStopForGainFocusLoss = decoder0.readBoolean(12, 2);
            }
            if (elementsOrVersion >= 1) {
                result.playbackState = decoder0.readInt(16);
                MediaPlaybackState.validate(result.playbackState);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.state, 8);
        encoder0.encode(this.forceDuck, 12, 0);
        encoder0.encode(this.isControllable, 12, 1);
        encoder0.encode(this.preferStopForGainFocusLoss, 12, 2);
        encoder0.encode(this.playbackState, 16);
    }
}
