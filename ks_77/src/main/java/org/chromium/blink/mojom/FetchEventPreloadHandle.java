package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoader;
import org.chromium.network.mojom.UrlLoaderClient;

public final class FetchEventPreloadHandle extends Struct {
    private static final int STRUCT_SIZE = 24;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public UrlLoader urlLoader;

    public InterfaceRequest<UrlLoaderClient> urlLoaderClientRequest;

    private FetchEventPreloadHandle(int version) {
        super(24, version);
    }

    public FetchEventPreloadHandle() {
        this(0);
    }

    public static FetchEventPreloadHandle deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FetchEventPreloadHandle deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FetchEventPreloadHandle decode(Decoder decoder0) {
        FetchEventPreloadHandle result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new FetchEventPreloadHandle(elementsOrVersion);
            result.urlLoader = (UrlLoader)decoder0.readServiceInterface(8, false, UrlLoader.MANAGER);
            result.urlLoaderClientRequest = decoder0.readInterfaceRequest(16, false);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.urlLoader, 8, false, UrlLoader.MANAGER);
        encoder0.encode(this.urlLoaderClientRequest, 16, false);
    }
}
