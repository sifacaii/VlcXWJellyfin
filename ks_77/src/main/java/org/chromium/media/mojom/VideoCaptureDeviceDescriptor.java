package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureDeviceDescriptor.class */
public final class VideoCaptureDeviceDescriptor extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String displayName;
    public String deviceId;
    public String modelId;
    public int facingMode;
    public int captureApi;
    public int transportType;

    private VideoCaptureDeviceDescriptor(int version) {
        super(48, version);
    }

    public VideoCaptureDeviceDescriptor() {
        this(0);
    }

    public static VideoCaptureDeviceDescriptor deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoCaptureDeviceDescriptor deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureDeviceDescriptor decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoCaptureDeviceDescriptor result = new VideoCaptureDeviceDescriptor(elementsOrVersion);
            result.displayName = decoder0.readString(8, false);
            result.deviceId = decoder0.readString(16, false);
            result.modelId = decoder0.readString(24, false);
            result.facingMode = decoder0.readInt(32);
            VideoFacingMode.validate(result.facingMode);
            result.captureApi = decoder0.readInt(36);
            VideoCaptureApi.validate(result.captureApi);
            result.transportType = decoder0.readInt(40);
            VideoCaptureTransportType.validate(result.transportType);
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
        encoder0.encode(this.displayName, 8, false);
        encoder0.encode(this.deviceId, 16, false);
        encoder0.encode(this.modelId, 24, false);
        encoder0.encode(this.facingMode, 32);
        encoder0.encode(this.captureApi, 36);
        encoder0.encode(this.transportType, 40);
    }
}
