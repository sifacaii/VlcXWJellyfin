package org.chromium.page.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationState.class */
public final class SpatialNavigationState extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean canExitFocus;
    public boolean canSelectElement;
    public boolean isFormFocused;
    public boolean hasNextFormElement;
    public boolean hasDefaultVideoControls;

    private SpatialNavigationState(int version) {
        super(16, version);
    }

    public SpatialNavigationState() {
        this(0);
    }

    public static SpatialNavigationState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SpatialNavigationState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SpatialNavigationState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SpatialNavigationState result = new SpatialNavigationState(elementsOrVersion);
            result.canExitFocus = decoder0.readBoolean(8, 0);
            result.canSelectElement = decoder0.readBoolean(8, 1);
            result.isFormFocused = decoder0.readBoolean(8, 2);
            result.hasNextFormElement = decoder0.readBoolean(8, 3);
            result.hasDefaultVideoControls = decoder0.readBoolean(8, 4);
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
        encoder0.encode(this.canExitFocus, 8, 0);
        encoder0.encode(this.canSelectElement, 8, 1);
        encoder0.encode(this.isFormFocused, 8, 2);
        encoder0.encode(this.hasNextFormElement, 8, 3);
        encoder0.encode(this.hasDefaultVideoControls, 8, 4);
    }
}
