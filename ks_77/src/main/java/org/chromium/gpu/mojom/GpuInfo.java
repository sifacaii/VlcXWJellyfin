package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.HidConstants;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/GpuInfo.class */
public final class GpuInfo extends Struct {
    private static final int STRUCT_SIZE = 184;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(184, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TimeDelta initializationTime;
    public boolean optimus;
    public boolean amdSwitchable;
    public GpuDevice gpu;
    public GpuDevice[] secondaryGpus;
    public String pixelShaderVersion;
    public String vertexShaderVersion;
    public String maxMsaaSamples;
    public String machineModelName;
    public String machineModelVersion;
    public String glVersion;
    public String glVendor;
    public String glRenderer;
    public String glExtensions;
    public String glWsVendor;
    public String glWsVersion;
    public String glWsExtensions;
    public int glResetNotificationStrategy;
    public boolean softwareRendering;
    public String directRenderingVersion;
    public boolean sandboxed;
    public boolean inProcessGpu;
    public boolean passthroughCmdDecoder;
    public boolean canSupportThreadedTextureMailbox;
    public VideoDecodeAcceleratorCapabilities videoDecodeAcceleratorCapabilities;
    public VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfiles;
    public boolean jpegDecodeAcceleratorSupported;
    public ImageDecodeAcceleratorSupportedProfile[] imageDecodeAcceleratorSupportedProfiles;
    public long systemVisual;
    public long rgbaVisual;
    public boolean oopRasterizationSupported;

    private GpuInfo(int version) {
        super(184, version);
    }

    public GpuInfo() {
        this(0);
    }

    public static GpuInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GpuInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GpuInfo result = new GpuInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.initializationTime = TimeDelta.decode(decoder1);
            result.optimus = decoder0.readBoolean(16, 0);
            result.amdSwitchable = decoder0.readBoolean(16, 1);
            result.softwareRendering = decoder0.readBoolean(16, 2);
            result.sandboxed = decoder0.readBoolean(16, 3);
            result.inProcessGpu = decoder0.readBoolean(16, 4);
            result.passthroughCmdDecoder = decoder0.readBoolean(16, 5);
            result.canSupportThreadedTextureMailbox = decoder0.readBoolean(16, 6);
            result.jpegDecodeAcceleratorSupported = decoder0.readBoolean(16, 7);
            result.oopRasterizationSupported = decoder0.readBoolean(17, 0);
            result.glResetNotificationStrategy = decoder0.readInt(20);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.gpu = GpuDevice.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.secondaryGpus = new GpuDevice[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.secondaryGpus[i1] = GpuDevice.decode(decoder2);
            }
            result.pixelShaderVersion = decoder0.readString(40, false);
            result.vertexShaderVersion = decoder0.readString(48, false);
            result.maxMsaaSamples = decoder0.readString(56, false);
            result.machineModelName = decoder0.readString(64, false);
            result.machineModelVersion = decoder0.readString(72, false);
            result.glVersion = decoder0.readString(80, false);
            result.glVendor = decoder0.readString(88, false);
            result.glRenderer = decoder0.readString(96, false);
            result.glExtensions = decoder0.readString(104, false);
            result.glWsVendor = decoder0.readString(112, false);
            result.glWsVersion = decoder0.readString(120, false);
            result.glWsExtensions = decoder0.readString(128, false);
            result.directRenderingVersion = decoder0.readString(136, false);
            Decoder decoder14 = decoder0.readPointer(144, false);
            result.videoDecodeAcceleratorCapabilities = VideoDecodeAcceleratorCapabilities.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(152, false);
            DataHeader si12 = decoder15.readDataHeaderForPointerArray(-1);
            result.videoEncodeAcceleratorSupportedProfiles = new VideoEncodeAcceleratorSupportedProfile[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder15.readPointer(8 + (8 * i12), false);
                result.videoEncodeAcceleratorSupportedProfiles[i12] = VideoEncodeAcceleratorSupportedProfile.decode(decoder22);
            }
            Decoder decoder16 = decoder0.readPointer(HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK, false);
            DataHeader si13 = decoder16.readDataHeaderForPointerArray(-1);
            result.imageDecodeAcceleratorSupportedProfiles = new ImageDecodeAcceleratorSupportedProfile[si13.elementsOrVersion];
            for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                Decoder decoder23 = decoder16.readPointer(8 + (8 * i13), false);
                result.imageDecodeAcceleratorSupportedProfiles[i13] = ImageDecodeAcceleratorSupportedProfile.decode(decoder23);
            }
            result.systemVisual = decoder0.readLong(168);
            result.rgbaVisual = decoder0.readLong(176);
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
        encoder0.encode((Struct) this.initializationTime, 8, false);
        encoder0.encode(this.optimus, 16, 0);
        encoder0.encode(this.amdSwitchable, 16, 1);
        encoder0.encode(this.softwareRendering, 16, 2);
        encoder0.encode(this.sandboxed, 16, 3);
        encoder0.encode(this.inProcessGpu, 16, 4);
        encoder0.encode(this.passthroughCmdDecoder, 16, 5);
        encoder0.encode(this.canSupportThreadedTextureMailbox, 16, 6);
        encoder0.encode(this.jpegDecodeAcceleratorSupported, 16, 7);
        encoder0.encode(this.oopRasterizationSupported, 17, 0);
        encoder0.encode(this.glResetNotificationStrategy, 20);
        encoder0.encode((Struct) this.gpu, 24, false);
        if (this.secondaryGpus == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.secondaryGpus.length, 32, -1);
            for (int i0 = 0; i0 < this.secondaryGpus.length; i0++) {
                encoder1.encode((Struct) this.secondaryGpus[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.pixelShaderVersion, 40, false);
        encoder0.encode(this.vertexShaderVersion, 48, false);
        encoder0.encode(this.maxMsaaSamples, 56, false);
        encoder0.encode(this.machineModelName, 64, false);
        encoder0.encode(this.machineModelVersion, 72, false);
        encoder0.encode(this.glVersion, 80, false);
        encoder0.encode(this.glVendor, 88, false);
        encoder0.encode(this.glRenderer, 96, false);
        encoder0.encode(this.glExtensions, 104, false);
        encoder0.encode(this.glWsVendor, 112, false);
        encoder0.encode(this.glWsVersion, 120, false);
        encoder0.encode(this.glWsExtensions, 128, false);
        encoder0.encode(this.directRenderingVersion, 136, false);
        encoder0.encode((Struct) this.videoDecodeAcceleratorCapabilities, 144, false);
        if (this.videoEncodeAcceleratorSupportedProfiles == null) {
            encoder0.encodeNullPointer(152, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.videoEncodeAcceleratorSupportedProfiles.length, 152, -1);
            for (int i02 = 0; i02 < this.videoEncodeAcceleratorSupportedProfiles.length; i02++) {
                encoder12.encode((Struct) this.videoEncodeAcceleratorSupportedProfiles[i02], 8 + (8 * i02), false);
            }
        }
        if (this.imageDecodeAcceleratorSupportedProfiles == null) {
            encoder0.encodeNullPointer(HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK, false);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.imageDecodeAcceleratorSupportedProfiles.length, HidConstants.GENERIC_DESKTOP_SYSTEM_DOCK, -1);
            for (int i03 = 0; i03 < this.imageDecodeAcceleratorSupportedProfiles.length; i03++) {
                encoder13.encode((Struct) this.imageDecodeAcceleratorSupportedProfiles[i03], 8 + (8 * i03), false);
            }
        }
        encoder0.encode(this.systemVisual, 168);
        encoder0.encode(this.rgbaVisual, 176);
    }
}
