package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ServiceWorkerInstalledScriptsInfo extends Struct {
    private static final int STRUCT_SIZE = 32;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public InterfaceRequest<ServiceWorkerInstalledScriptsManager> managerRequest;

    public ServiceWorkerInstalledScriptsManagerHost managerHostPtr;

    public Url[] installedUrls;

    private ServiceWorkerInstalledScriptsInfo(int version) {
        super(32, version);
    }

    public ServiceWorkerInstalledScriptsInfo() {
        this(0);
    }

    public static ServiceWorkerInstalledScriptsInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerInstalledScriptsInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerInstalledScriptsInfo decode(Decoder decoder0) {
        ServiceWorkerInstalledScriptsInfo result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ServiceWorkerInstalledScriptsInfo(elementsOrVersion);
            result.managerRequest = decoder0.readInterfaceRequest(8, false);
            result.managerHostPtr = (ServiceWorkerInstalledScriptsManagerHost)decoder0.readServiceInterface(12, false, ServiceWorkerInstalledScriptsManagerHost.MANAGER);
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.installedUrls = new Url[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                result.installedUrls[i1] = Url.decode(decoder2);
            }
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.managerRequest, 8, false);
        encoder0.encode(this.managerHostPtr, 12, false, ServiceWorkerInstalledScriptsManagerHost.MANAGER);
        if (this.installedUrls == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.installedUrls.length, 24, -1);
            for (int i0 = 0; i0 < this.installedUrls.length; i0++)
                encoder1.encode((Struct)this.installedUrls[i0], 8 + 8 * i0, false);
        }
    }
}
