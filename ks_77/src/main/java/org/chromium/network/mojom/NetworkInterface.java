package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkInterface.class */
public final class NetworkInterface extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String name;
    public String friendlyName;
    public int interfaceIndex;
    public int type;
    public IpAddress address;
    public int prefixLength;
    public int ipAddressAttributes;

    private NetworkInterface(int version) {
        super(48, version);
    }

    public NetworkInterface() {
        this(0);
    }

    public static NetworkInterface deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NetworkInterface deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NetworkInterface decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NetworkInterface result = new NetworkInterface(elementsOrVersion);
            result.name = decoder0.readString(8, false);
            result.friendlyName = decoder0.readString(16, false);
            result.interfaceIndex = decoder0.readInt(24);
            result.type = decoder0.readInt(28);
            ConnectionType.validate(result.type);
            Decoder decoder1 = decoder0.readPointer(32, false);
            result.address = IpAddress.decode(decoder1);
            result.prefixLength = decoder0.readInt(40);
            result.ipAddressAttributes = decoder0.readInt(44);
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
        encoder0.encode(this.name, 8, false);
        encoder0.encode(this.friendlyName, 16, false);
        encoder0.encode(this.interfaceIndex, 24);
        encoder0.encode(this.type, 28);
        encoder0.encode((Struct) this.address, 32, false);
        encoder0.encode(this.prefixLength, 40);
        encoder0.encode(this.ipAddressAttributes, 44);
    }
}
