package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/LoadInfo.class */
public final class LoadInfo extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int processId;
    public int routingId;
    public String host;
    public int loadState;
    public String16 stateParam;
    public long uploadPosition;
    public long uploadSize;

    private LoadInfo(int version) {
        super(56, version);
    }

    public LoadInfo() {
        this(0);
    }

    public static LoadInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static LoadInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static LoadInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            LoadInfo result = new LoadInfo(elementsOrVersion);
            result.processId = decoder0.readInt(8);
            result.routingId = decoder0.readInt(12);
            result.host = decoder0.readString(16, false);
            result.loadState = decoder0.readInt(24);
            Decoder decoder1 = decoder0.readPointer(32, false);
            result.stateParam = String16.decode(decoder1);
            result.uploadPosition = decoder0.readLong(40);
            result.uploadSize = decoder0.readLong(48);
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
        encoder0.encode(this.processId, 8);
        encoder0.encode(this.routingId, 12);
        encoder0.encode(this.host, 16, false);
        encoder0.encode(this.loadState, 24);
        encoder0.encode((Struct) this.stateParam, 32, false);
        encoder0.encode(this.uploadPosition, 40);
        encoder0.encode(this.uploadSize, 48);
    }
}
