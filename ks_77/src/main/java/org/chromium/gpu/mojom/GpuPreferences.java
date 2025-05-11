package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferUsageAndFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.MessageLoopType;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/GpuPreferences.class */
public final class GpuPreferences extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean disableAcceleratedVideoDecode;
    public boolean disableAcceleratedVideoEncode;
    public boolean gpuStartupDialog;
    public boolean disableGpuWatchdog;
    public boolean gpuSandboxStartEarly;
    public boolean enableLowLatencyDxva;
    public boolean enableZeroCopyDxgiVideo;
    public boolean enableNv12DxgiVideo;
    public boolean enableMediaFoundationVeaOnWindows7;
    public boolean disableSoftwareRasterizer;
    public boolean logGpuControlListDecisions;
    public boolean compileShaderAlwaysSucceeds;
    public boolean disableGlErrorLimit;
    public boolean disableGlslTranslator;
    public boolean disableShaderNameHashing;
    public boolean enableGpuCommandLogging;
    public boolean enableGpuDebugging;
    public boolean enableGpuServiceLoggingGpu;
    public boolean enableGpuDriverDebugLogging;
    public boolean disableGpuProgramCache;
    public boolean enforceGlMinimums;
    public int forceGpuMemAvailable;
    public int gpuProgramCacheSize;
    public boolean disableGpuShaderDiskCache;
    public boolean enableThreadedTextureMailboxes;
    public boolean glShaderIntermOutput;
    public boolean emulateShaderPrecision;
    public boolean enableAndroidSurfaceControl;
    public boolean enableGpuServiceLogging;
    public boolean enableGpuServiceTracing;
    public boolean usePassthroughCmdDecoder;
    public boolean disableBiplanarGpuMemoryBuffersForVideoFrames;
    public BufferUsageAndFormat[] textureTargetExceptionList;
    public boolean disableGpuDriverBugWorkarounds;
    public boolean ignoreGpuBlacklist;
    public boolean enableOopRasterization;
    public boolean disableOopRasterization;
    public boolean enableOopRasterizationDdl;
    public boolean watchdogStartsBackgrounded;
    public int useVulkan;
    public boolean disableVulkanSurface;
    public boolean disableVulkanFallbackToGlForTesting;
    public boolean enableMetal;
    public boolean enableGpuBenchmarkingExtension;
    public boolean enableWebgpu;
    public int messageLoopType;

    private GpuPreferences(int version) {
        super(40, version);
    }

    public GpuPreferences() {
        this(0);
    }

    public static GpuPreferences deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GpuPreferences deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuPreferences decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GpuPreferences result = new GpuPreferences(elementsOrVersion);
            result.disableAcceleratedVideoDecode = decoder0.readBoolean(8, 0);
            result.disableAcceleratedVideoEncode = decoder0.readBoolean(8, 1);
            result.gpuStartupDialog = decoder0.readBoolean(8, 2);
            result.disableGpuWatchdog = decoder0.readBoolean(8, 3);
            result.gpuSandboxStartEarly = decoder0.readBoolean(8, 4);
            result.enableLowLatencyDxva = decoder0.readBoolean(8, 5);
            result.enableZeroCopyDxgiVideo = decoder0.readBoolean(8, 6);
            result.enableNv12DxgiVideo = decoder0.readBoolean(8, 7);
            result.enableMediaFoundationVeaOnWindows7 = decoder0.readBoolean(9, 0);
            result.disableSoftwareRasterizer = decoder0.readBoolean(9, 1);
            result.logGpuControlListDecisions = decoder0.readBoolean(9, 2);
            result.compileShaderAlwaysSucceeds = decoder0.readBoolean(9, 3);
            result.disableGlErrorLimit = decoder0.readBoolean(9, 4);
            result.disableGlslTranslator = decoder0.readBoolean(9, 5);
            result.disableShaderNameHashing = decoder0.readBoolean(9, 6);
            result.enableGpuCommandLogging = decoder0.readBoolean(9, 7);
            result.enableGpuDebugging = decoder0.readBoolean(10, 0);
            result.enableGpuServiceLoggingGpu = decoder0.readBoolean(10, 1);
            result.enableGpuDriverDebugLogging = decoder0.readBoolean(10, 2);
            result.disableGpuProgramCache = decoder0.readBoolean(10, 3);
            result.enforceGlMinimums = decoder0.readBoolean(10, 4);
            result.disableGpuShaderDiskCache = decoder0.readBoolean(10, 5);
            result.enableThreadedTextureMailboxes = decoder0.readBoolean(10, 6);
            result.glShaderIntermOutput = decoder0.readBoolean(10, 7);
            result.emulateShaderPrecision = decoder0.readBoolean(11, 0);
            result.enableAndroidSurfaceControl = decoder0.readBoolean(11, 1);
            result.enableGpuServiceLogging = decoder0.readBoolean(11, 2);
            result.enableGpuServiceTracing = decoder0.readBoolean(11, 3);
            result.usePassthroughCmdDecoder = decoder0.readBoolean(11, 4);
            result.disableBiplanarGpuMemoryBuffersForVideoFrames = decoder0.readBoolean(11, 5);
            result.disableGpuDriverBugWorkarounds = decoder0.readBoolean(11, 6);
            result.ignoreGpuBlacklist = decoder0.readBoolean(11, 7);
            result.forceGpuMemAvailable = decoder0.readInt(12);
            result.gpuProgramCacheSize = decoder0.readInt(16);
            result.enableOopRasterization = decoder0.readBoolean(20, 0);
            result.disableOopRasterization = decoder0.readBoolean(20, 1);
            result.enableOopRasterizationDdl = decoder0.readBoolean(20, 2);
            result.watchdogStartsBackgrounded = decoder0.readBoolean(20, 3);
            result.disableVulkanSurface = decoder0.readBoolean(20, 4);
            result.disableVulkanFallbackToGlForTesting = decoder0.readBoolean(20, 5);
            result.enableMetal = decoder0.readBoolean(20, 6);
            result.enableGpuBenchmarkingExtension = decoder0.readBoolean(20, 7);
            result.enableWebgpu = decoder0.readBoolean(21, 0);
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.textureTargetExceptionList = new BufferUsageAndFormat[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.textureTargetExceptionList[i1] = BufferUsageAndFormat.decode(decoder2);
            }
            result.useVulkan = decoder0.readInt(32);
            VulkanImplementationName.validate(result.useVulkan);
            result.messageLoopType = decoder0.readInt(36);
            MessageLoopType.validate(result.messageLoopType);
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
        encoder0.encode(this.disableAcceleratedVideoDecode, 8, 0);
        encoder0.encode(this.disableAcceleratedVideoEncode, 8, 1);
        encoder0.encode(this.gpuStartupDialog, 8, 2);
        encoder0.encode(this.disableGpuWatchdog, 8, 3);
        encoder0.encode(this.gpuSandboxStartEarly, 8, 4);
        encoder0.encode(this.enableLowLatencyDxva, 8, 5);
        encoder0.encode(this.enableZeroCopyDxgiVideo, 8, 6);
        encoder0.encode(this.enableNv12DxgiVideo, 8, 7);
        encoder0.encode(this.enableMediaFoundationVeaOnWindows7, 9, 0);
        encoder0.encode(this.disableSoftwareRasterizer, 9, 1);
        encoder0.encode(this.logGpuControlListDecisions, 9, 2);
        encoder0.encode(this.compileShaderAlwaysSucceeds, 9, 3);
        encoder0.encode(this.disableGlErrorLimit, 9, 4);
        encoder0.encode(this.disableGlslTranslator, 9, 5);
        encoder0.encode(this.disableShaderNameHashing, 9, 6);
        encoder0.encode(this.enableGpuCommandLogging, 9, 7);
        encoder0.encode(this.enableGpuDebugging, 10, 0);
        encoder0.encode(this.enableGpuServiceLoggingGpu, 10, 1);
        encoder0.encode(this.enableGpuDriverDebugLogging, 10, 2);
        encoder0.encode(this.disableGpuProgramCache, 10, 3);
        encoder0.encode(this.enforceGlMinimums, 10, 4);
        encoder0.encode(this.disableGpuShaderDiskCache, 10, 5);
        encoder0.encode(this.enableThreadedTextureMailboxes, 10, 6);
        encoder0.encode(this.glShaderIntermOutput, 10, 7);
        encoder0.encode(this.emulateShaderPrecision, 11, 0);
        encoder0.encode(this.enableAndroidSurfaceControl, 11, 1);
        encoder0.encode(this.enableGpuServiceLogging, 11, 2);
        encoder0.encode(this.enableGpuServiceTracing, 11, 3);
        encoder0.encode(this.usePassthroughCmdDecoder, 11, 4);
        encoder0.encode(this.disableBiplanarGpuMemoryBuffersForVideoFrames, 11, 5);
        encoder0.encode(this.disableGpuDriverBugWorkarounds, 11, 6);
        encoder0.encode(this.ignoreGpuBlacklist, 11, 7);
        encoder0.encode(this.forceGpuMemAvailable, 12);
        encoder0.encode(this.gpuProgramCacheSize, 16);
        encoder0.encode(this.enableOopRasterization, 20, 0);
        encoder0.encode(this.disableOopRasterization, 20, 1);
        encoder0.encode(this.enableOopRasterizationDdl, 20, 2);
        encoder0.encode(this.watchdogStartsBackgrounded, 20, 3);
        encoder0.encode(this.disableVulkanSurface, 20, 4);
        encoder0.encode(this.disableVulkanFallbackToGlForTesting, 20, 5);
        encoder0.encode(this.enableMetal, 20, 6);
        encoder0.encode(this.enableGpuBenchmarkingExtension, 20, 7);
        encoder0.encode(this.enableWebgpu, 21, 0);
        if (this.textureTargetExceptionList == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.textureTargetExceptionList.length, 24, -1);
            for (int i0 = 0; i0 < this.textureTargetExceptionList.length; i0++) {
                encoder1.encode((Struct) this.textureTargetExceptionList[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.useVulkan, 32);
        encoder0.encode(this.messageLoopType, 36);
    }
}
