package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioBuffer.class */
public final class AudioBuffer extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int sampleFormat;
    public int channelLayout;
    public int channelCount;
    public int sampleRate;
    public int frameCount;
    public boolean endOfStream;
    public TimeDelta timestamp;
    public byte[] data;

    private AudioBuffer(int version) {
        super(48, version);
    }

    public AudioBuffer() {
        this(0);
    }

    public static AudioBuffer deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AudioBuffer deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioBuffer decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AudioBuffer result = new AudioBuffer(elementsOrVersion);
            result.sampleFormat = decoder0.readInt(8);
            SampleFormat.validate(result.sampleFormat);
            result.channelLayout = decoder0.readInt(12);
            ChannelLayout.validate(result.channelLayout);
            result.channelCount = decoder0.readInt(16);
            result.sampleRate = decoder0.readInt(20);
            result.frameCount = decoder0.readInt(24);
            result.endOfStream = decoder0.readBoolean(28, 0);
            Decoder decoder1 = decoder0.readPointer(32, false);
            result.timestamp = TimeDelta.decode(decoder1);
            result.data = decoder0.readBytes(40, 0, -1);
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
        encoder0.encode(this.sampleFormat, 8);
        encoder0.encode(this.channelLayout, 12);
        encoder0.encode(this.channelCount, 16);
        encoder0.encode(this.sampleRate, 20);
        encoder0.encode(this.frameCount, 24);
        encoder0.encode(this.endOfStream, 28, 0);
        encoder0.encode((Struct) this.timestamp, 32, false);
        encoder0.encode(this.data, 40, 0, -1);
    }
}
