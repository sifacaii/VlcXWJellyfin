package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.device.mojom.ScreenOrientationLockType;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/Manifest_.class */
public final class Manifest_ extends Struct {
    private static final int STRUCT_SIZE = 104;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(104, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String16 name;
    public String16 shortName;
    public Url startUrl;
    public int display;
    public int orientation;
    public ManifestImageResource[] icons;
    public ManifestShareTarget shareTarget;
    public ManifestFileHandler fileHandler;
    public ManifestRelatedApplication[] relatedApplications;
    public boolean preferRelatedApplications;
    public boolean hasThemeColor;
    public int themeColor;
    public boolean hasBackgroundColor;
    public int backgroundColor;
    public String16 gcmSenderId;
    public Url scope;

    private Manifest_(int version) {
        super(104, version);
    }

    public Manifest_() {
        this(0);
    }

    public static Manifest_ deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static Manifest_ deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static Manifest_ decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            Manifest_ result = new Manifest_(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            result.name = String16.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, true);
            result.shortName = String16.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.startUrl = Url.decode(decoder13);
            result.display = decoder0.readInt(32);
            DisplayMode.validate(result.display);
            result.orientation = decoder0.readInt(36);
            ScreenOrientationLockType.validate(result.orientation);
            Decoder decoder14 = decoder0.readPointer(40, false);
            DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
            result.icons = new ManifestImageResource[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder14.readPointer(8 + (8 * i1), false);
                result.icons[i1] = ManifestImageResource.decode(decoder2);
            }
            Decoder decoder15 = decoder0.readPointer(48, true);
            result.shareTarget = ManifestShareTarget.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(56, true);
            result.fileHandler = ManifestFileHandler.decode(decoder16);
            Decoder decoder17 = decoder0.readPointer(64, false);
            DataHeader si12 = decoder17.readDataHeaderForPointerArray(-1);
            result.relatedApplications = new ManifestRelatedApplication[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder17.readPointer(8 + (8 * i12), false);
                result.relatedApplications[i12] = ManifestRelatedApplication.decode(decoder22);
            }
            result.preferRelatedApplications = decoder0.readBoolean(72, 0);
            result.hasThemeColor = decoder0.readBoolean(72, 1);
            result.hasBackgroundColor = decoder0.readBoolean(72, 2);
            result.themeColor = decoder0.readInt(76);
            result.backgroundColor = decoder0.readInt(80);
            Decoder decoder18 = decoder0.readPointer(88, true);
            result.gcmSenderId = String16.decode(decoder18);
            Decoder decoder19 = decoder0.readPointer(96, false);
            result.scope = Url.decode(decoder19);
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
        encoder0.encode((Struct) this.name, 8, true);
        encoder0.encode((Struct) this.shortName, 16, true);
        encoder0.encode((Struct) this.startUrl, 24, false);
        encoder0.encode(this.display, 32);
        encoder0.encode(this.orientation, 36);
        if (this.icons == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.icons.length, 40, -1);
            for (int i0 = 0; i0 < this.icons.length; i0++) {
                encoder1.encode((Struct) this.icons[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.shareTarget, 48, true);
        encoder0.encode((Struct) this.fileHandler, 56, true);
        if (this.relatedApplications == null) {
            encoder0.encodeNullPointer(64, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.relatedApplications.length, 64, -1);
            for (int i02 = 0; i02 < this.relatedApplications.length; i02++) {
                encoder12.encode((Struct) this.relatedApplications[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode(this.preferRelatedApplications, 72, 0);
        encoder0.encode(this.hasThemeColor, 72, 1);
        encoder0.encode(this.hasBackgroundColor, 72, 2);
        encoder0.encode(this.themeColor, 76);
        encoder0.encode(this.backgroundColor, 80);
        encoder0.encode((Struct) this.gcmSenderId, 88, true);
        encoder0.encode((Struct) this.scope, 96, false);
    }
}
