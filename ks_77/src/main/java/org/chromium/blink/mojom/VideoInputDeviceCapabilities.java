package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoCaptureFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/VideoInputDeviceCapabilities.class */
public final class VideoInputDeviceCapabilities extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String deviceId;
    public String groupId;
    public VideoCaptureFormat[] formats;
    public int facingMode;

    private VideoInputDeviceCapabilities(int version) {
        super(40, version);
    }

    public VideoInputDeviceCapabilities() {
        this(0);
    }

    public static VideoInputDeviceCapabilities deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoInputDeviceCapabilities deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoInputDeviceCapabilities decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoInputDeviceCapabilities result = new VideoInputDeviceCapabilities(elementsOrVersion);
            result.deviceId = decoder0.readString(8, false);
            result.groupId = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.formats = new VideoCaptureFormat[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.formats[i1] = VideoCaptureFormat.decode(decoder2);
            }
            result.facingMode = decoder0.readInt(32);
            FacingMode.validate(result.facingMode);
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
        if (this.formats == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.formats.length, 24, -1);
            for (int i0 = 0; i0 < this.formats.length; i0++) {
                encoder1.encode((Struct) this.formats[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.facingMode, 32);
    }
}
