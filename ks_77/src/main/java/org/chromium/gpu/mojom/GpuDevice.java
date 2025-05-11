package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/GpuDevice.class */
public final class GpuDevice extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int vendorId;
    public int deviceId;
    public boolean active;
    public String vendorString;
    public String deviceString;
    public String driverVendor;
    public String driverVersion;
    public String driverDate;
    public int cudaComputeCapabilityMajor;

    private GpuDevice(int version) {
        super(64, version);
    }

    public GpuDevice() {
        this(0);
    }

    public static GpuDevice deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GpuDevice deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuDevice decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GpuDevice result = new GpuDevice(elementsOrVersion);
            result.vendorId = decoder0.readInt(8);
            result.deviceId = decoder0.readInt(12);
            result.active = decoder0.readBoolean(16, 0);
            result.cudaComputeCapabilityMajor = decoder0.readInt(20);
            result.vendorString = decoder0.readString(24, false);
            result.deviceString = decoder0.readString(32, false);
            result.driverVendor = decoder0.readString(40, false);
            result.driverVersion = decoder0.readString(48, false);
            result.driverDate = decoder0.readString(56, false);
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
        encoder0.encode(this.vendorId, 8);
        encoder0.encode(this.deviceId, 12);
        encoder0.encode(this.active, 16, 0);
        encoder0.encode(this.cudaComputeCapabilityMajor, 20);
        encoder0.encode(this.vendorString, 24, false);
        encoder0.encode(this.deviceString, 32, false);
        encoder0.encode(this.driverVendor, 40, false);
        encoder0.encode(this.driverVersion, 48, false);
        encoder0.encode(this.driverDate, 56, false);
    }
}
