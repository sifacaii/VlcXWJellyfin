package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.network.mojom.RequestContextFrameType;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerClientInfo.class */
public final class ServiceWorkerClientInfo extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url url;
    public int frameType;
    public String clientUuid;
    public int clientType;
    public boolean pageHidden;
    public boolean isFocused;
    public TimeTicks lastFocusTime;
    public TimeTicks creationTime;

    private ServiceWorkerClientInfo(int version) {
        super(56, version);
        this.frameType = 2;
        this.pageHidden = true;
        this.isFocused = false;
    }

    public ServiceWorkerClientInfo() {
        this(0);
    }

    public static ServiceWorkerClientInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerClientInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerClientInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ServiceWorkerClientInfo result = new ServiceWorkerClientInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.url = Url.decode(decoder1);
            result.frameType = decoder0.readInt(16);
            RequestContextFrameType.validate(result.frameType);
            result.clientType = decoder0.readInt(20);
            ServiceWorkerClientType.validate(result.clientType);
            result.clientUuid = decoder0.readString(24, false);
            result.pageHidden = decoder0.readBoolean(32, 0);
            result.isFocused = decoder0.readBoolean(32, 1);
            Decoder decoder12 = decoder0.readPointer(40, false);
            result.lastFocusTime = TimeTicks.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(48, false);
            result.creationTime = TimeTicks.decode(decoder13);
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
        encoder0.encode((Struct) this.url, 8, false);
        encoder0.encode(this.frameType, 16);
        encoder0.encode(this.clientType, 20);
        encoder0.encode(this.clientUuid, 24, false);
        encoder0.encode(this.pageHidden, 32, 0);
        encoder0.encode(this.isFocused, 32, 1);
        encoder0.encode((Struct) this.lastFocusTime, 40, false);
        encoder0.encode((Struct) this.creationTime, 48, false);
    }
}
