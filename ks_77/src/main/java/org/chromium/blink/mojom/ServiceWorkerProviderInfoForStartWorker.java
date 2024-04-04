package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.service_manager.mojom.InterfaceProvider;

public final class ServiceWorkerProviderInfoForStartWorker extends Struct {
    private static final int STRUCT_SIZE = 40;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public AssociatedInterfaceNotSupported hostPtrInfo;

    public UrlLoaderFactory scriptLoaderFactoryPtrInfo;

    public CacheStorage cacheStorage;

    public InterfaceProvider interfaceProvider;

    private ServiceWorkerProviderInfoForStartWorker(int version) {
        super(40, version);
    }

    public ServiceWorkerProviderInfoForStartWorker() {
        this(0);
    }

    public static ServiceWorkerProviderInfoForStartWorker deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ServiceWorkerProviderInfoForStartWorker deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ServiceWorkerProviderInfoForStartWorker decode(Decoder decoder0) {
        ServiceWorkerProviderInfoForStartWorker result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new ServiceWorkerProviderInfoForStartWorker(elementsOrVersion);
            result.hostPtrInfo = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            result.scriptLoaderFactoryPtrInfo = (UrlLoaderFactory)decoder0.readServiceInterface(16, true, UrlLoaderFactory.MANAGER);
            result.cacheStorage = (CacheStorage)decoder0.readServiceInterface(24, true, CacheStorage.MANAGER);
            result.interfaceProvider = (InterfaceProvider)decoder0.readServiceInterface(32, false, InterfaceProvider.MANAGER);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.hostPtrInfo, 8, false);
        encoder0.encode(this.scriptLoaderFactoryPtrInfo, 16, true, UrlLoaderFactory.MANAGER);
        encoder0.encode(this.cacheStorage, 24, true, CacheStorage.MANAGER);
        encoder0.encode(this.interfaceProvider, 32, false, InterfaceProvider.MANAGER);
    }
}
