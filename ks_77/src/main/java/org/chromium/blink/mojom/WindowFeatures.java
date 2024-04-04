package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WindowFeatures.class */
public final class WindowFeatures extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float x;
    public boolean hasX;
    public float y;
    public boolean hasY;
    public float width;
    public boolean hasWidth;
    public float height;
    public boolean hasHeight;
    public boolean menuBarVisible;
    public boolean statusBarVisible;
    public boolean toolBarVisible;
    public boolean scrollbarsVisible;

    private WindowFeatures(int version) {
        super(32, version);
        this.hasX = false;
        this.hasY = false;
        this.hasWidth = false;
        this.hasHeight = false;
        this.menuBarVisible = true;
        this.statusBarVisible = true;
        this.toolBarVisible = true;
        this.scrollbarsVisible = true;
    }

    public WindowFeatures() {
        this(0);
    }

    public static WindowFeatures deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static WindowFeatures deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static WindowFeatures decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            WindowFeatures result = new WindowFeatures(elementsOrVersion);
            result.x = decoder0.readFloat(8);
            result.hasX = decoder0.readBoolean(12, 0);
            result.hasY = decoder0.readBoolean(12, 1);
            result.hasWidth = decoder0.readBoolean(12, 2);
            result.hasHeight = decoder0.readBoolean(12, 3);
            result.menuBarVisible = decoder0.readBoolean(12, 4);
            result.statusBarVisible = decoder0.readBoolean(12, 5);
            result.toolBarVisible = decoder0.readBoolean(12, 6);
            result.scrollbarsVisible = decoder0.readBoolean(12, 7);
            result.y = decoder0.readFloat(16);
            result.width = decoder0.readFloat(20);
            result.height = decoder0.readFloat(24);
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
        encoder0.encode(this.x, 8);
        encoder0.encode(this.hasX, 12, 0);
        encoder0.encode(this.hasY, 12, 1);
        encoder0.encode(this.hasWidth, 12, 2);
        encoder0.encode(this.hasHeight, 12, 3);
        encoder0.encode(this.menuBarVisible, 12, 4);
        encoder0.encode(this.statusBarVisible, 12, 5);
        encoder0.encode(this.toolBarVisible, 12, 6);
        encoder0.encode(this.scrollbarsVisible, 12, 7);
        encoder0.encode(this.y, 16);
        encoder0.encode(this.width, 20);
        encoder0.encode(this.height, 24);
    }
}
