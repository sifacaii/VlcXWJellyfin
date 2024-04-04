package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.AudioParameters;
import org.chromium.media.mojom.DisplayMediaInformation;
import org.chromium.media.mojom.VideoFacingMode;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDevice.class */
public final class MediaStreamDevice extends Struct {
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(72, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public String id;
    public int videoFacing;
    public String groupId;
    public String matchedOutputDeviceId;
    public String name;
    public AudioParameters input;
    public int sessionId;
    public DisplayMediaInformation displayMediaInfo;

    private MediaStreamDevice(int version) {
        super(72, version);
    }

    public MediaStreamDevice() {
        this(0);
    }

    public static MediaStreamDevice deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaStreamDevice deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaStreamDevice decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaStreamDevice result = new MediaStreamDevice(elementsOrVersion);
            result.type = decoder0.readInt(8);
            MediaStreamType.validate(result.type);
            result.videoFacing = decoder0.readInt(12);
            VideoFacingMode.validate(result.videoFacing);
            result.id = decoder0.readString(16, false);
            result.groupId = decoder0.readString(24, true);
            result.matchedOutputDeviceId = decoder0.readString(32, true);
            result.name = decoder0.readString(40, false);
            Decoder decoder1 = decoder0.readPointer(48, false);
            result.input = AudioParameters.decode(decoder1);
            result.sessionId = decoder0.readInt(56);
            Decoder decoder12 = decoder0.readPointer(64, true);
            result.displayMediaInfo = DisplayMediaInformation.decode(decoder12);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.type, 8);
        encoder0.encode(this.videoFacing, 12);
        encoder0.encode(this.id, 16, false);
        encoder0.encode(this.groupId, 24, true);
        encoder0.encode(this.matchedOutputDeviceId, 32, true);
        encoder0.encode(this.name, 40, false);
        encoder0.encode((Struct) this.input, 48, false);
        encoder0.encode(this.sessionId, 56);
        encoder0.encode((Struct) this.displayMediaInfo, 64, true);
    }
}
