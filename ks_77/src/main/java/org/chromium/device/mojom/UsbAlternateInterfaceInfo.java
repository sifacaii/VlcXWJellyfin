package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbAlternateInterfaceInfo.class */
public final class UsbAlternateInterfaceInfo extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public byte alternateSetting;
    public byte classCode;
    public byte subclassCode;
    public byte protocolCode;
    public String16 interfaceName;
    public UsbEndpointInfo[] endpoints;
    public byte[] extraData;

    private UsbAlternateInterfaceInfo(int version) {
        super(40, version);
    }

    public UsbAlternateInterfaceInfo() {
        this(0);
    }

    public static UsbAlternateInterfaceInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UsbAlternateInterfaceInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbAlternateInterfaceInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UsbAlternateInterfaceInfo result = new UsbAlternateInterfaceInfo(elementsOrVersion);
            result.alternateSetting = decoder0.readByte(8);
            result.classCode = decoder0.readByte(9);
            result.subclassCode = decoder0.readByte(10);
            result.protocolCode = decoder0.readByte(11);
            result.interfaceName = String16.decode(decoder0.readPointer(16, true));
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.endpoints = new UsbEndpointInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.endpoints[i1] = UsbEndpointInfo.decode(decoder2);
            }
            result.extraData = decoder0.readBytes(32, 0, -1);
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
        encoder0.encode(this.alternateSetting, 8);
        encoder0.encode(this.classCode, 9);
        encoder0.encode(this.subclassCode, 10);
        encoder0.encode(this.protocolCode, 11);
        encoder0.encode((Struct) this.interfaceName, 16, true);
        if (this.endpoints == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.endpoints.length, 24, -1);
            for (int i0 = 0; i0 < this.endpoints.length; i0++) {
                encoder1.encode((Struct) this.endpoints[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.extraData, 32, 0, -1);
    }
}
