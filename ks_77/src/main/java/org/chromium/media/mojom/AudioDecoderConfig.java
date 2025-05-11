package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoderConfig.class */
public final class AudioDecoderConfig extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int codec;
    public int sampleFormat;
    public int channelLayout;
    public int samplesPerSecond;
    public byte[] extraData;
    public TimeDelta seekPreroll;
    public int codecDelay;
    public EncryptionScheme encryptionScheme;

    private AudioDecoderConfig(int version) {
        super(56, version);
    }

    public AudioDecoderConfig() {
        this(0);
    }

    public static AudioDecoderConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AudioDecoderConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioDecoderConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AudioDecoderConfig result = new AudioDecoderConfig(elementsOrVersion);
            result.codec = decoder0.readInt(8);
            AudioCodec.validate(result.codec);
            result.sampleFormat = decoder0.readInt(12);
            SampleFormat.validate(result.sampleFormat);
            result.channelLayout = decoder0.readInt(16);
            ChannelLayout.validate(result.channelLayout);
            result.samplesPerSecond = decoder0.readInt(20);
            result.extraData = decoder0.readBytes(24, 0, -1);
            Decoder decoder1 = decoder0.readPointer(32, false);
            result.seekPreroll = TimeDelta.decode(decoder1);
            result.codecDelay = decoder0.readInt(40);
            Decoder decoder12 = decoder0.readPointer(48, false);
            result.encryptionScheme = EncryptionScheme.decode(decoder12);
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
        encoder0.encode(this.codec, 8);
        encoder0.encode(this.sampleFormat, 12);
        encoder0.encode(this.channelLayout, 16);
        encoder0.encode(this.samplesPerSecond, 20);
        encoder0.encode(this.extraData, 24, 0, -1);
        encoder0.encode((Struct) this.seekPreroll, 32, false);
        encoder0.encode(this.codecDelay, 40);
        encoder0.encode((Struct) this.encryptionScheme, 48, false);
    }
}
