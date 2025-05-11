package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerProviderInfoForClient.class */
public final class ServiceWorkerProviderInfoForClient extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public AssociatedInterfaceNotSupported hostPtrInfo;
    public AssociatedInterfaceRequestNotSupported clientRequest;

    private ServiceWorkerProviderInfoForClient(int version) {
        super(24, version);
    }

    public ServiceWorkerProviderInfoForClient() {
        this(0);
    }

    public static ServiceWorkerProviderInfoForClient deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerProviderInfoForClient deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerProviderInfoForClient decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ServiceWorkerProviderInfoForClient result = new ServiceWorkerProviderInfoForClient(elementsOrVersion);
            result.hostPtrInfo = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            result.clientRequest = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
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
        encoder0.encode(this.hostPtrInfo, 8, false);
        encoder0.encode(this.clientRequest, 16, false);
    }
}
