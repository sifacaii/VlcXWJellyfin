package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ExtendableMessageEvent.class */
public final class ExtendableMessageEvent extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TransferableMessage message;
    public Origin sourceOrigin;
    public ServiceWorkerClientInfo sourceInfoForClient;
    public ServiceWorkerObjectInfo sourceInfoForServiceWorker;

    private ExtendableMessageEvent(int version) {
        super(40, version);
    }

    public ExtendableMessageEvent() {
        this(0);
    }

    public static ExtendableMessageEvent deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ExtendableMessageEvent deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ExtendableMessageEvent decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ExtendableMessageEvent result = new ExtendableMessageEvent(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.message = TransferableMessage.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.sourceOrigin = Origin.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, true);
            result.sourceInfoForClient = ServiceWorkerClientInfo.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, true);
            result.sourceInfoForServiceWorker = ServiceWorkerObjectInfo.decode(decoder14);
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
        encoder0.encode((Struct) this.message, 8, false);
        encoder0.encode((Struct) this.sourceOrigin, 16, false);
        encoder0.encode((Struct) this.sourceInfoForClient, 24, true);
        encoder0.encode((Struct) this.sourceInfoForServiceWorker, 32, true);
    }
}
