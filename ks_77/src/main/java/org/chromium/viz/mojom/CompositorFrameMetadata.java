package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.SizeF;
import org.chromium.gfx.mojom.Vector2dF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.ui.mojom.LatencyInfo;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameMetadata.class */
public final class CompositorFrameMetadata extends Struct {
    private static final int STRUCT_SIZE = 152;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(STRUCT_SIZE, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float deviceScaleFactor;
    public Vector2dF rootScrollOffset;
    public float pageScaleFactor;
    public SizeF scrollableViewportSize;
    public boolean mayContainVideo;
    public boolean isResourcelessSoftwareDrawWithScrollOrAnimation;
    public int rootBackgroundColor;
    public LatencyInfo[] latencyInfo;
    public SurfaceRange[] referencedSurfaces;
    public FrameDeadline deadline;
    public SurfaceId[] activationDependencies;
    public BeginFrameAck beginFrameAck;
    public int frameToken;
    public boolean sendFrameTokenToEmbedder;
    public float minPageScaleFactor;
    public float maxPageScaleFactor;
    public SizeF rootLayerSize;
    public boolean rootOverflowYHidden;
    public float topControlsHeight;
    public float topControlsShownRatio;
    public TimeTicks localSurfaceIdAllocationTime;
    public TimeDelta preferredFrameInterval;
    public Rect mirrorRect;
    public float bottomControlsHeight;
    public float bottomControlsShownRatio;
    public Selection selection;

    private CompositorFrameMetadata(int version) {
        super(STRUCT_SIZE, version);
    }

    public CompositorFrameMetadata() {
        this(0);
    }

    public static CompositorFrameMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CompositorFrameMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrameMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CompositorFrameMetadata result = new CompositorFrameMetadata(elementsOrVersion);
            result.deviceScaleFactor = decoder0.readFloat(8);
            result.pageScaleFactor = decoder0.readFloat(12);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.rootScrollOffset = Vector2dF.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.scrollableViewportSize = SizeF.decode(decoder12);
            result.mayContainVideo = decoder0.readBoolean(32, 0);
            result.isResourcelessSoftwareDrawWithScrollOrAnimation = decoder0.readBoolean(32, 1);
            result.sendFrameTokenToEmbedder = decoder0.readBoolean(32, 2);
            result.rootOverflowYHidden = decoder0.readBoolean(32, 3);
            result.rootBackgroundColor = decoder0.readInt(36);
            Decoder decoder13 = decoder0.readPointer(40, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.latencyInfo = new LatencyInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.latencyInfo[i1] = LatencyInfo.decode(decoder2);
            }
            Decoder decoder14 = decoder0.readPointer(48, false);
            DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
            result.referencedSurfaces = new SurfaceRange[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder14.readPointer(8 + (8 * i12), false);
                result.referencedSurfaces[i12] = SurfaceRange.decode(decoder22);
            }
            Decoder decoder15 = decoder0.readPointer(56, false);
            result.deadline = FrameDeadline.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(64, false);
            DataHeader si13 = decoder16.readDataHeaderForPointerArray(-1);
            result.activationDependencies = new SurfaceId[si13.elementsOrVersion];
            for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                Decoder decoder23 = decoder16.readPointer(8 + (8 * i13), false);
                result.activationDependencies[i13] = SurfaceId.decode(decoder23);
            }
            Decoder decoder17 = decoder0.readPointer(72, false);
            result.beginFrameAck = BeginFrameAck.decode(decoder17);
            result.frameToken = decoder0.readInt(80);
            result.minPageScaleFactor = decoder0.readFloat(84);
            result.maxPageScaleFactor = decoder0.readFloat(88);
            result.topControlsHeight = decoder0.readFloat(92);
            Decoder decoder18 = decoder0.readPointer(96, false);
            result.rootLayerSize = SizeF.decode(decoder18);
            result.topControlsShownRatio = decoder0.readFloat(104);
            result.bottomControlsHeight = decoder0.readFloat(108);
            Decoder decoder19 = decoder0.readPointer(112, false);
            result.localSurfaceIdAllocationTime = TimeTicks.decode(decoder19);
            Decoder decoder110 = decoder0.readPointer(120, true);
            result.preferredFrameInterval = TimeDelta.decode(decoder110);
            Decoder decoder111 = decoder0.readPointer(128, false);
            result.mirrorRect = Rect.decode(decoder111);
            result.bottomControlsShownRatio = decoder0.readFloat(136);
            Decoder decoder112 = decoder0.readPointer(144, false);
            result.selection = Selection.decode(decoder112);
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
        encoder0.encode(this.deviceScaleFactor, 8);
        encoder0.encode(this.pageScaleFactor, 12);
        encoder0.encode((Struct) this.rootScrollOffset, 16, false);
        encoder0.encode((Struct) this.scrollableViewportSize, 24, false);
        encoder0.encode(this.mayContainVideo, 32, 0);
        encoder0.encode(this.isResourcelessSoftwareDrawWithScrollOrAnimation, 32, 1);
        encoder0.encode(this.sendFrameTokenToEmbedder, 32, 2);
        encoder0.encode(this.rootOverflowYHidden, 32, 3);
        encoder0.encode(this.rootBackgroundColor, 36);
        if (this.latencyInfo == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.latencyInfo.length, 40, -1);
            for (int i0 = 0; i0 < this.latencyInfo.length; i0++) {
                encoder1.encode((Struct) this.latencyInfo[i0], 8 + (8 * i0), false);
            }
        }
        if (this.referencedSurfaces == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.referencedSurfaces.length, 48, -1);
            for (int i02 = 0; i02 < this.referencedSurfaces.length; i02++) {
                encoder12.encode((Struct) this.referencedSurfaces[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode((Struct) this.deadline, 56, false);
        if (this.activationDependencies == null) {
            encoder0.encodeNullPointer(64, false);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.activationDependencies.length, 64, -1);
            for (int i03 = 0; i03 < this.activationDependencies.length; i03++) {
                encoder13.encode((Struct) this.activationDependencies[i03], 8 + (8 * i03), false);
            }
        }
        encoder0.encode((Struct) this.beginFrameAck, 72, false);
        encoder0.encode(this.frameToken, 80);
        encoder0.encode(this.minPageScaleFactor, 84);
        encoder0.encode(this.maxPageScaleFactor, 88);
        encoder0.encode(this.topControlsHeight, 92);
        encoder0.encode((Struct) this.rootLayerSize, 96, false);
        encoder0.encode(this.topControlsShownRatio, 104);
        encoder0.encode(this.bottomControlsHeight, 108);
        encoder0.encode((Struct) this.localSurfaceIdAllocationTime, 112, false);
        encoder0.encode((Struct) this.preferredFrameInterval, 120, true);
        encoder0.encode((Struct) this.mirrorRect, 128, false);
        encoder0.encode(this.bottomControlsShownRatio, 136);
        encoder0.encode((Struct) this.selection, 144, false);
    }
}
