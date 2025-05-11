package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class ControllerServiceWorkerInfo extends Struct {
    private static final int STRUCT_SIZE = 56;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public int mode;

    public ControllerServiceWorker remoteController;

    public String clientId;

    public UnguessableToken fetchRequestWindowId;

    public ServiceWorkerObjectInfo objectInfo;

    public int[] usedFeatures;

    private ControllerServiceWorkerInfo(int version) {
        super(56, version);
        this.mode = 0;
    }

    public ControllerServiceWorkerInfo() {
        this(0);
    }

    public static ControllerServiceWorkerInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ControllerServiceWorkerInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ControllerServiceWorkerInfo decode(Decoder decoder0) {
        ControllerServiceWorkerInfo result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ControllerServiceWorkerInfo(elementsOrVersion);
            result.mode = decoder0.readInt(8);
            ControllerServiceWorkerMode.validate(result.mode);
            result.remoteController = (ControllerServiceWorker)decoder0.readServiceInterface(12, true, ControllerServiceWorker.MANAGER);
            result.clientId = decoder0.readString(24, false);
            Decoder decoder1 = decoder0.readPointer(32, true);
            result.fetchRequestWindowId = UnguessableToken.decode(decoder1);
            decoder1 = decoder0.readPointer(40, true);
            result.objectInfo = ServiceWorkerObjectInfo.decode(decoder1);
            result.usedFeatures = decoder0.readInts(48, 0, -1);
            for (int i0 = 0; i0 < result.usedFeatures.length; i0++)
                WebFeature.validate(result.usedFeatures[i0]);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.mode, 8);
        encoder0.encode(this.remoteController, 12, true, ControllerServiceWorker.MANAGER);
        encoder0.encode(this.clientId, 24, false);
        encoder0.encode((Struct)this.fetchRequestWindowId, 32, true);
        encoder0.encode(this.objectInfo, 40, true);
        encoder0.encode(this.usedFeatures, 48, 0, -1);
    }
}
