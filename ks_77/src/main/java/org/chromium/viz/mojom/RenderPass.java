package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.RRectF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/RenderPass.class */
public final class RenderPass extends Struct {
    private static final int STRUCT_SIZE = 96;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(96, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long id;
    public Rect outputRect;
    public Rect damageRect;
    public Transform transformToRootTarget;
    public FilterOperations filters;
    public FilterOperations backdropFilters;
    public RRectF backdropFilterBounds;
    public ColorSpace colorSpace;
    public boolean hasTransparentBackground;
    public boolean cacheRenderPass;
    public boolean hasDamageFromContributingContent;
    public boolean generateMipmap;
    public CopyOutputRequest[] copyRequests;
    public DrawQuad[] quadList;

    private RenderPass(int version) {
        super(96, version);
        this.cacheRenderPass = false;
        this.hasDamageFromContributingContent = false;
        this.generateMipmap = false;
    }

    public RenderPass() {
        this(0);
    }

    public static RenderPass deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static RenderPass deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderPass decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            RenderPass result = new RenderPass(elementsOrVersion);
            result.id = decoder0.readLong(8);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.outputRect = Rect.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.damageRect = Rect.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.transformToRootTarget = Transform.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, false);
            result.filters = FilterOperations.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(48, false);
            result.backdropFilters = FilterOperations.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(56, true);
            result.backdropFilterBounds = RRectF.decode(decoder16);
            Decoder decoder17 = decoder0.readPointer(64, false);
            result.colorSpace = ColorSpace.decode(decoder17);
            result.hasTransparentBackground = decoder0.readBoolean(72, 0);
            result.cacheRenderPass = decoder0.readBoolean(72, 1);
            result.hasDamageFromContributingContent = decoder0.readBoolean(72, 2);
            result.generateMipmap = decoder0.readBoolean(72, 3);
            Decoder decoder18 = decoder0.readPointer(80, false);
            DataHeader si1 = decoder18.readDataHeaderForPointerArray(-1);
            result.copyRequests = new CopyOutputRequest[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder18.readPointer(8 + (8 * i1), false);
                result.copyRequests[i1] = CopyOutputRequest.decode(decoder2);
            }
            Decoder decoder19 = decoder0.readPointer(88, false);
            DataHeader si12 = decoder19.readDataHeaderForPointerArray(-1);
            result.quadList = new DrawQuad[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder19.readPointer(8 + (8 * i12), false);
                result.quadList[i12] = DrawQuad.decode(decoder22);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.id, 8);
        encoder0.encode((Struct) this.outputRect, 16, false);
        encoder0.encode((Struct) this.damageRect, 24, false);
        encoder0.encode((Struct) this.transformToRootTarget, 32, false);
        encoder0.encode((Struct) this.filters, 40, false);
        encoder0.encode((Struct) this.backdropFilters, 48, false);
        encoder0.encode((Struct) this.backdropFilterBounds, 56, true);
        encoder0.encode((Struct) this.colorSpace, 64, false);
        encoder0.encode(this.hasTransparentBackground, 72, 0);
        encoder0.encode(this.cacheRenderPass, 72, 1);
        encoder0.encode(this.hasDamageFromContributingContent, 72, 2);
        encoder0.encode(this.generateMipmap, 72, 3);
        if (this.copyRequests == null) {
            encoder0.encodeNullPointer(80, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.copyRequests.length, 80, -1);
            for (int i0 = 0; i0 < this.copyRequests.length; i0++) {
                encoder1.encode((Struct) this.copyRequests[i0], 8 + (8 * i0), false);
            }
        }
        if (this.quadList == null) {
            encoder0.encodeNullPointer(88, false);
            return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(this.quadList.length, 88, -1);
        for (int i02 = 0; i02 < this.quadList.length; i02++) {
            encoder12.encode((Struct) this.quadList[i02], 8 + (8 * i02), false);
        }
    }
}
