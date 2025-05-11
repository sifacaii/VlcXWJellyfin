package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbConfigurationInfo.class */
public final class UsbConfigurationInfo extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public byte configurationValue;
    public String16 configurationName;
    public boolean selfPowered;
    public boolean remoteWakeup;
    public byte maximumPower;
    public UsbInterfaceInfo[] interfaces;
    public byte[] extraData;

    private UsbConfigurationInfo(int version) {
        super(40, version);
    }

    public UsbConfigurationInfo() {
        this(0);
    }

    public static UsbConfigurationInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UsbConfigurationInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UsbConfigurationInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            UsbConfigurationInfo result = new UsbConfigurationInfo(elementsOrVersion);
            result.configurationValue = decoder0.readByte(8);
            result.selfPowered = decoder0.readBoolean(9, 0);
            result.remoteWakeup = decoder0.readBoolean(9, 1);
            result.maximumPower = decoder0.readByte(10);
            result.configurationName = String16.decode(decoder0.readPointer(16, true));
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.interfaces = new UsbInterfaceInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.interfaces[i1] = UsbInterfaceInfo.decode(decoder2);
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
        encoder0.encode(this.configurationValue, 8);
        encoder0.encode(this.selfPowered, 9, 0);
        encoder0.encode(this.remoteWakeup, 9, 1);
        encoder0.encode(this.maximumPower, 10);
        encoder0.encode((Struct) this.configurationName, 16, true);
        if (this.interfaces == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.interfaces.length, 24, -1);
            for (int i0 = 0; i0 < this.interfaces.length; i0++) {
                encoder1.encode((Struct) this.interfaces[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.extraData, 32, 0, -1);
    }
}
