package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PresentationConnectionResult extends Struct {
    private static final int STRUCT_SIZE = 32;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public PresentationInfo presentationInfo;

    public PresentationConnection connectionPtr;

    public InterfaceRequest<PresentationConnection> connectionRequest;

    private PresentationConnectionResult(int version) {
        super(32, version);
    }

    public PresentationConnectionResult() {
        this(0);
    }

    public static PresentationConnectionResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PresentationConnectionResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationConnectionResult decode(Decoder decoder0) {
        PresentationConnectionResult result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new PresentationConnectionResult(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.presentationInfo = PresentationInfo.decode(decoder1);
            result.connectionPtr = (PresentationConnection)decoder0.readServiceInterface(16, false, PresentationConnection.MANAGER);
            result.connectionRequest = decoder0.readInterfaceRequest(24, false);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.presentationInfo, 8, false);
        encoder0.encode(this.connectionPtr, 16, false, PresentationConnection.MANAGER);
        encoder0.encode(this.connectionRequest, 24, false);
    }
}
