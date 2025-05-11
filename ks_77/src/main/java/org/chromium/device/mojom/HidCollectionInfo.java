package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidCollectionInfo.class */
public final class HidCollectionInfo extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public HidUsageAndPage usage;
    public byte[] reportIds;
    public int collectionType;
    public HidReportDescription[] inputReports;
    public HidReportDescription[] outputReports;
    public HidReportDescription[] featureReports;
    public HidCollectionInfo[] children;

    private HidCollectionInfo(int version) {
        super(64, version);
    }

    public HidCollectionInfo() {
        this(0);
    }

    public static HidCollectionInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static HidCollectionInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static HidCollectionInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            HidCollectionInfo result = new HidCollectionInfo(elementsOrVersion);
            result.usage = HidUsageAndPage.decode(decoder0.readPointer(8, false));
            result.reportIds = decoder0.readBytes(16, 0, -1);
            result.collectionType = decoder0.readInt(24);
            Decoder decoder1 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.inputReports = new HidReportDescription[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.inputReports[i1] = HidReportDescription.decode(decoder2);
            }
            Decoder decoder12 = decoder0.readPointer(40, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.outputReports = new HidReportDescription[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                result.outputReports[i12] = HidReportDescription.decode(decoder22);
            }
            Decoder decoder13 = decoder0.readPointer(48, false);
            DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
            result.featureReports = new HidReportDescription[si13.elementsOrVersion];
            for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                Decoder decoder23 = decoder13.readPointer(8 + (8 * i13), false);
                result.featureReports[i13] = HidReportDescription.decode(decoder23);
            }
            Decoder decoder14 = decoder0.readPointer(56, false);
            DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
            result.children = new HidCollectionInfo[si14.elementsOrVersion];
            for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
                Decoder decoder24 = decoder14.readPointer(8 + (8 * i14), false);
                result.children[i14] = decode(decoder24);
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
        encoder0.encode((Struct) this.usage, 8, false);
        encoder0.encode(this.reportIds, 16, 0, -1);
        encoder0.encode(this.collectionType, 24);
        if (this.inputReports == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.inputReports.length, 32, -1);
            for (int i0 = 0; i0 < this.inputReports.length; i0++) {
                encoder1.encode((Struct) this.inputReports[i0], 8 + (8 * i0), false);
            }
        }
        if (this.outputReports == null) {
            encoder0.encodeNullPointer(40, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.outputReports.length, 40, -1);
            for (int i02 = 0; i02 < this.outputReports.length; i02++) {
                encoder12.encode((Struct) this.outputReports[i02], 8 + (8 * i02), false);
            }
        }
        if (this.featureReports == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.featureReports.length, 48, -1);
            for (int i03 = 0; i03 < this.featureReports.length; i03++) {
                encoder13.encode((Struct) this.featureReports[i03], 8 + (8 * i03), false);
            }
        }
        if (this.children == null) {
            encoder0.encodeNullPointer(56, false);
            return;
        }
        Encoder encoder14 = encoder0.encodePointerArray(this.children.length, 56, -1);
        for (int i04 = 0; i04 < this.children.length; i04++) {
            encoder14.encode((Struct) this.children[i04], 8 + (8 * i04), false);
        }
    }
}
