package org.chromium.content_settings.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_settings/mojom/RendererContentSettingRules.class */
public final class RendererContentSettingRules extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ContentSettingPatternSource[] imageRules;
    public ContentSettingPatternSource[] scriptRules;
    public ContentSettingPatternSource[] autoplayRules;
    public ContentSettingPatternSource[] clientHintsRules;
    public ContentSettingPatternSource[] popupRedirectRules;

    private RendererContentSettingRules(int version) {
        super(48, version);
    }

    public RendererContentSettingRules() {
        this(0);
    }

    public static RendererContentSettingRules deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static RendererContentSettingRules deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static RendererContentSettingRules decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            RendererContentSettingRules result = new RendererContentSettingRules(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.imageRules = new ContentSettingPatternSource[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.imageRules[i1] = ContentSettingPatternSource.decode(decoder2);
            }
            Decoder decoder12 = decoder0.readPointer(16, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.scriptRules = new ContentSettingPatternSource[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                result.scriptRules[i12] = ContentSettingPatternSource.decode(decoder22);
            }
            Decoder decoder13 = decoder0.readPointer(24, false);
            DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
            result.autoplayRules = new ContentSettingPatternSource[si13.elementsOrVersion];
            for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                Decoder decoder23 = decoder13.readPointer(8 + (8 * i13), false);
                result.autoplayRules[i13] = ContentSettingPatternSource.decode(decoder23);
            }
            Decoder decoder14 = decoder0.readPointer(32, false);
            DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
            result.clientHintsRules = new ContentSettingPatternSource[si14.elementsOrVersion];
            for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
                Decoder decoder24 = decoder14.readPointer(8 + (8 * i14), false);
                result.clientHintsRules[i14] = ContentSettingPatternSource.decode(decoder24);
            }
            Decoder decoder15 = decoder0.readPointer(40, false);
            DataHeader si15 = decoder15.readDataHeaderForPointerArray(-1);
            result.popupRedirectRules = new ContentSettingPatternSource[si15.elementsOrVersion];
            for (int i15 = 0; i15 < si15.elementsOrVersion; i15++) {
                Decoder decoder25 = decoder15.readPointer(8 + (8 * i15), false);
                result.popupRedirectRules[i15] = ContentSettingPatternSource.decode(decoder25);
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
        if (this.imageRules == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.imageRules.length, 8, -1);
            for (int i0 = 0; i0 < this.imageRules.length; i0++) {
                encoder1.encode((Struct) this.imageRules[i0], 8 + (8 * i0), false);
            }
        }
        if (this.scriptRules == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.scriptRules.length, 16, -1);
            for (int i02 = 0; i02 < this.scriptRules.length; i02++) {
                encoder12.encode((Struct) this.scriptRules[i02], 8 + (8 * i02), false);
            }
        }
        if (this.autoplayRules == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.autoplayRules.length, 24, -1);
            for (int i03 = 0; i03 < this.autoplayRules.length; i03++) {
                encoder13.encode((Struct) this.autoplayRules[i03], 8 + (8 * i03), false);
            }
        }
        if (this.clientHintsRules == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder14 = encoder0.encodePointerArray(this.clientHintsRules.length, 32, -1);
            for (int i04 = 0; i04 < this.clientHintsRules.length; i04++) {
                encoder14.encode((Struct) this.clientHintsRules[i04], 8 + (8 * i04), false);
            }
        }
        if (this.popupRedirectRules == null) {
            encoder0.encodeNullPointer(40, false);
            return;
        }
        Encoder encoder15 = encoder0.encodePointerArray(this.popupRedirectRules.length, 40, -1);
        for (int i05 = 0; i05 < this.popupRedirectRules.length; i05++) {
            encoder15.encode((Struct) this.popupRedirectRules[i05], 8 + (8 * i05), false);
        }
    }
}
