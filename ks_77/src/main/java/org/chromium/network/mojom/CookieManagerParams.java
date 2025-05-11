package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.content_settings.mojom.ContentSettingPatternSource;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieManagerParams.class */
public final class CookieManagerParams extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean blockThirdPartyCookies;
    public ContentSettingPatternSource[] settings;
    public String[] secureOriginCookiesAllowedSchemes;
    public String[] matchingSchemeCookiesAllowedSchemes;
    public String[] thirdPartyCookiesAllowedSchemes;
    public boolean allowFileSchemeCookies;

    private CookieManagerParams(int version) {
        super(48, version);
        this.blockThirdPartyCookies = false;
        this.allowFileSchemeCookies = false;
    }

    public CookieManagerParams() {
        this(0);
    }

    public static CookieManagerParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CookieManagerParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieManagerParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CookieManagerParams result = new CookieManagerParams(elementsOrVersion);
            result.blockThirdPartyCookies = decoder0.readBoolean(8, 0);
            result.allowFileSchemeCookies = decoder0.readBoolean(8, 1);
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.settings = new ContentSettingPatternSource[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.settings[i1] = ContentSettingPatternSource.decode(decoder2);
            }
            Decoder decoder12 = decoder0.readPointer(24, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.secureOriginCookiesAllowedSchemes = new String[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                result.secureOriginCookiesAllowedSchemes[i12] = decoder12.readString(8 + (8 * i12), false);
            }
            Decoder decoder13 = decoder0.readPointer(32, false);
            DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
            result.matchingSchemeCookiesAllowedSchemes = new String[si13.elementsOrVersion];
            for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                result.matchingSchemeCookiesAllowedSchemes[i13] = decoder13.readString(8 + (8 * i13), false);
            }
            Decoder decoder14 = decoder0.readPointer(40, false);
            DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
            result.thirdPartyCookiesAllowedSchemes = new String[si14.elementsOrVersion];
            for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
                result.thirdPartyCookiesAllowedSchemes[i14] = decoder14.readString(8 + (8 * i14), false);
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
        encoder0.encode(this.blockThirdPartyCookies, 8, 0);
        encoder0.encode(this.allowFileSchemeCookies, 8, 1);
        if (this.settings == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.settings.length, 16, -1);
            for (int i0 = 0; i0 < this.settings.length; i0++) {
                encoder1.encode((Struct) this.settings[i0], 8 + (8 * i0), false);
            }
        }
        if (this.secureOriginCookiesAllowedSchemes == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.secureOriginCookiesAllowedSchemes.length, 24, -1);
            for (int i02 = 0; i02 < this.secureOriginCookiesAllowedSchemes.length; i02++) {
                encoder12.encode(this.secureOriginCookiesAllowedSchemes[i02], 8 + (8 * i02), false);
            }
        }
        if (this.matchingSchemeCookiesAllowedSchemes == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.matchingSchemeCookiesAllowedSchemes.length, 32, -1);
            for (int i03 = 0; i03 < this.matchingSchemeCookiesAllowedSchemes.length; i03++) {
                encoder13.encode(this.matchingSchemeCookiesAllowedSchemes[i03], 8 + (8 * i03), false);
            }
        }
        if (this.thirdPartyCookiesAllowedSchemes == null) {
            encoder0.encodeNullPointer(40, false);
            return;
        }
        Encoder encoder14 = encoder0.encodePointerArray(this.thirdPartyCookiesAllowedSchemes.length, 40, -1);
        for (int i04 = 0; i04 < this.thirdPartyCookiesAllowedSchemes.length; i04++) {
            encoder14.encode(this.thirdPartyCookiesAllowedSchemes[i04], 8 + (8 * i04), false);
        }
    }
}
