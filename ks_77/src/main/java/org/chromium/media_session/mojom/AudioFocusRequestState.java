package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestState.class */
public final class AudioFocusRequestState extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0), new DataHeader(32, 2), new DataHeader(40, 3)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[2];
    public MediaSessionInfo sessionInfo;
    public int audioFocusType;
    public String sourceName;
    public UnguessableToken requestId;

    private AudioFocusRequestState(int version) {
        super(40, version);
    }

    public AudioFocusRequestState() {
        this(3);
    }

    public static AudioFocusRequestState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AudioFocusRequestState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioFocusRequestState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AudioFocusRequestState result = new AudioFocusRequestState(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.sessionInfo = MediaSessionInfo.decode(decoder1);
            result.audioFocusType = decoder0.readInt(16);
            AudioFocusType.validate(result.audioFocusType);
            if (elementsOrVersion >= 2) {
                result.sourceName = decoder0.readString(24, true);
            }
            if (elementsOrVersion >= 3) {
                Decoder decoder12 = decoder0.readPointer(32, true);
                result.requestId = UnguessableToken.decode(decoder12);
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
        encoder0.encode((Struct) this.sessionInfo, 8, false);
        encoder0.encode(this.audioFocusType, 16);
        encoder0.encode(this.sourceName, 24, true);
        encoder0.encode((Struct) this.requestId, 32, true);
    }
}
