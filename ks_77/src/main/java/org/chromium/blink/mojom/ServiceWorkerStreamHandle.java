package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerStreamHandle.class */
public final class ServiceWorkerStreamHandle extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public DataPipe.ConsumerHandle stream;
    public InterfaceRequest<ServiceWorkerStreamCallback> callbackRequest;

    private ServiceWorkerStreamHandle(int version) {
        super(16, version);
        this.stream = InvalidHandle.INSTANCE;
    }

    public ServiceWorkerStreamHandle() {
        this(0);
    }

    public static ServiceWorkerStreamHandle deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerStreamHandle deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerStreamHandle decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ServiceWorkerStreamHandle result = new ServiceWorkerStreamHandle(elementsOrVersion);
            result.stream = decoder0.readConsumerHandle(8, false);
            result.callbackRequest = decoder0.readInterfaceRequest(12, false);
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
        encoder0.encode((Handle) this.stream, 8, false);
        encoder0.encode((InterfaceRequest) this.callbackRequest, 12, false);
    }
}
