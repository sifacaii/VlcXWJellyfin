package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieDeletionFilter.class */
public final class CookieDeletionFilter extends Struct {
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(72, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Time createdAfterTime;
    public Time createdBeforeTime;
    public String[] excludingDomains;
    public String[] includingDomains;
    public String cookieName;
    public String hostName;
    public Url url;
    public int sessionControl;

    private CookieDeletionFilter(int version) {
        super(72, version);
        this.sessionControl = 0;
    }

    public CookieDeletionFilter() {
        this(0);
    }

    public static CookieDeletionFilter deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CookieDeletionFilter deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieDeletionFilter decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CookieDeletionFilter result = new CookieDeletionFilter(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            result.createdAfterTime = Time.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, true);
            result.createdBeforeTime = Time.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, true);
            if (decoder13 == null) {
                result.excludingDomains = null;
            } else {
                DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
                result.excludingDomains = new String[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    result.excludingDomains[i1] = decoder13.readString(8 + (8 * i1), false);
                }
            }
            Decoder decoder14 = decoder0.readPointer(32, true);
            if (decoder14 == null) {
                result.includingDomains = null;
            } else {
                DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
                result.includingDomains = new String[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    result.includingDomains[i12] = decoder14.readString(8 + (8 * i12), false);
                }
            }
            result.cookieName = decoder0.readString(40, true);
            result.hostName = decoder0.readString(48, true);
            Decoder decoder15 = decoder0.readPointer(56, true);
            result.url = Url.decode(decoder15);
            result.sessionControl = decoder0.readInt(64);
            CookieDeletionSessionControl.validate(result.sessionControl);
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
        encoder0.encode((Struct) this.createdAfterTime, 8, true);
        encoder0.encode((Struct) this.createdBeforeTime, 16, true);
        if (this.excludingDomains == null) {
            encoder0.encodeNullPointer(24, true);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.excludingDomains.length, 24, -1);
            for (int i0 = 0; i0 < this.excludingDomains.length; i0++) {
                encoder1.encode(this.excludingDomains[i0], 8 + (8 * i0), false);
            }
        }
        if (this.includingDomains == null) {
            encoder0.encodeNullPointer(32, true);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.includingDomains.length, 32, -1);
            for (int i02 = 0; i02 < this.includingDomains.length; i02++) {
                encoder12.encode(this.includingDomains[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode(this.cookieName, 40, true);
        encoder0.encode(this.hostName, 48, true);
        encoder0.encode((Struct) this.url, 56, true);
        encoder0.encode(this.sessionControl, 64);
    }
}
