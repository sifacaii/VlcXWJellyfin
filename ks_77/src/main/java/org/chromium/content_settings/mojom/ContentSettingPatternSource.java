package org.chromium.content_settings.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.Value;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_settings/mojom/ContentSettingPatternSource.class */
public final class ContentSettingPatternSource extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ContentSettingsPattern primaryPattern;
    public ContentSettingsPattern secondaryPattern;
    public Value settingValue;
    public String source;
    public boolean incognito;

    private ContentSettingPatternSource(int version) {
        super(56, version);
    }

    public ContentSettingPatternSource() {
        this(0);
    }

    public static ContentSettingPatternSource deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ContentSettingPatternSource deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ContentSettingPatternSource decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ContentSettingPatternSource result = new ContentSettingPatternSource(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.primaryPattern = ContentSettingsPattern.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.secondaryPattern = ContentSettingsPattern.decode(decoder12);
            result.settingValue = Value.decode(decoder0, 24);
            result.source = decoder0.readString(40, false);
            result.incognito = decoder0.readBoolean(48, 0);
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
        encoder0.encode((Struct) this.primaryPattern, 8, false);
        encoder0.encode((Struct) this.secondaryPattern, 16, false);
        encoder0.encode((Union) this.settingValue, 24, false);
        encoder0.encode(this.source, 40, false);
        encoder0.encode(this.incognito, 48, 0);
    }
}
