package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.AudioParameters;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AudioInputDeviceCapabilities.class */
public final class AudioInputDeviceCapabilities extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String deviceId;
    public String groupId;
    public AudioParameters parameters;
    public boolean isValid;
    public int channels;
    public int sampleRate;
    public TimeDelta latency;

    private AudioInputDeviceCapabilities(int version) {
        super(56, version);
    }

    public AudioInputDeviceCapabilities() {
        this(0);
    }

    public static AudioInputDeviceCapabilities deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AudioInputDeviceCapabilities deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AudioInputDeviceCapabilities decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AudioInputDeviceCapabilities result = new AudioInputDeviceCapabilities(elementsOrVersion);
            result.deviceId = decoder0.readString(8, false);
            result.groupId = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.parameters = AudioParameters.decode(decoder1);
            result.isValid = decoder0.readBoolean(32, 0);
            result.channels = decoder0.readInt(36);
            result.sampleRate = decoder0.readInt(40);
            Decoder decoder12 = decoder0.readPointer(48, false);
            result.latency = TimeDelta.decode(decoder12);
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
        encoder0.encode(this.deviceId, 8, false);
        encoder0.encode(this.groupId, 16, false);
        encoder0.encode((Struct) this.parameters, 24, false);
        encoder0.encode(this.isValid, 32, 0);
        encoder0.encode(this.channels, 36);
        encoder0.encode(this.sampleRate, 40);
        encoder0.encode((Struct) this.latency, 48, false);
    }
}
