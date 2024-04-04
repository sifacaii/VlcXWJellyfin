package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AnchorElementMetrics.class */
public final class AnchorElementMetrics extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float ratioArea;
    public float ratioVisibleArea;
    public float ratioDistanceTopToVisibleTop;
    public float ratioDistanceCenterToVisibleTop;
    public float ratioDistanceRootTop;
    public float ratioDistanceRootBottom;
    public boolean isInIframe;
    public boolean containsImage;
    public boolean isSameHost;
    public boolean isUrlIncrementedByOne;
    public Url sourceUrl;
    public Url targetUrl;

    private AnchorElementMetrics(int version) {
        super(56, version);
    }

    public AnchorElementMetrics() {
        this(0);
    }

    public static AnchorElementMetrics deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AnchorElementMetrics deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AnchorElementMetrics decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AnchorElementMetrics result = new AnchorElementMetrics(elementsOrVersion);
            result.ratioArea = decoder0.readFloat(8);
            result.ratioVisibleArea = decoder0.readFloat(12);
            result.ratioDistanceTopToVisibleTop = decoder0.readFloat(16);
            result.ratioDistanceCenterToVisibleTop = decoder0.readFloat(20);
            result.ratioDistanceRootTop = decoder0.readFloat(24);
            result.ratioDistanceRootBottom = decoder0.readFloat(28);
            result.isInIframe = decoder0.readBoolean(32, 0);
            result.containsImage = decoder0.readBoolean(32, 1);
            result.isSameHost = decoder0.readBoolean(32, 2);
            result.isUrlIncrementedByOne = decoder0.readBoolean(32, 3);
            Decoder decoder1 = decoder0.readPointer(40, false);
            result.sourceUrl = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(48, false);
            result.targetUrl = Url.decode(decoder12);
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
        encoder0.encode(this.ratioArea, 8);
        encoder0.encode(this.ratioVisibleArea, 12);
        encoder0.encode(this.ratioDistanceTopToVisibleTop, 16);
        encoder0.encode(this.ratioDistanceCenterToVisibleTop, 20);
        encoder0.encode(this.ratioDistanceRootTop, 24);
        encoder0.encode(this.ratioDistanceRootBottom, 28);
        encoder0.encode(this.isInIframe, 32, 0);
        encoder0.encode(this.containsImage, 32, 1);
        encoder0.encode(this.isSameHost, 32, 2);
        encoder0.encode(this.isUrlIncrementedByOne, 32, 3);
        encoder0.encode((Struct) this.sourceUrl, 40, false);
        encoder0.encode((Struct) this.targetUrl, 48, false);
    }
}
