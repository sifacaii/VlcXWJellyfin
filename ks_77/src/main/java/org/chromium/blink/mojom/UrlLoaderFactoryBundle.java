package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.UrlLoaderFactory;
import org.chromium.url.mojom.Origin;

public final class UrlLoaderFactoryBundle extends Struct {
    private static final int STRUCT_SIZE = 48;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public UrlLoaderFactory defaultFactory;

    public Map<String, UrlLoaderFactory> schemeSpecificFactories;

    public Map<Origin, UrlLoaderFactory> initiatorSpecificFactories;

    public UrlLoaderFactory appcacheFactory;

    public boolean bypassRedirectChecks;

    private UrlLoaderFactoryBundle(int version) {
        super(48, version);
        this.bypassRedirectChecks = false;
    }

    public UrlLoaderFactoryBundle() {
        this(0);
    }

    public static UrlLoaderFactoryBundle deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static UrlLoaderFactoryBundle deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static UrlLoaderFactoryBundle decode(Decoder decoder0) {
        UrlLoaderFactoryBundle result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new UrlLoaderFactoryBundle(elementsOrVersion);
            result.defaultFactory = (UrlLoaderFactory)decoder0.readServiceInterface(8, true, UrlLoaderFactory.MANAGER);
            Decoder decoder1 = decoder0.readPointer(16, false);
            decoder1.readDataHeaderForMap();
            Decoder decoder3 = decoder1.readPointer(8, false);
            DataHeader si2 = decoder3.readDataHeaderForPointerArray(-1);
            String[] arrayOfString = new String[si2.elementsOrVersion];
            int i2;
            for (i2 = 0; i2 < si2.elementsOrVersion; i2++)
                arrayOfString[i2] = decoder3.readString(8 + 8 * i2, false);
            UrlLoaderFactory[] values0 = (UrlLoaderFactory[])decoder1.readServiceInterfaces(16, 0, arrayOfString.length, UrlLoaderFactory.MANAGER);
            result.schemeSpecificFactories = new HashMap<>();
            for (int i = 0; i < arrayOfString.length; i++)
                result.schemeSpecificFactories.put(arrayOfString[i], values0[i]);
            decoder1 = decoder0.readPointer(24, false);
            decoder1.readDataHeaderForMap();
            Decoder decoder2 = decoder1.readPointer(8, false);
            si2 = decoder2.readDataHeaderForPointerArray(-1);
            Origin[] keys0 = new Origin[si2.elementsOrVersion];
            for (i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                Decoder decoder = decoder2.readPointer(8 + 8 * i2, false);
                keys0[i2] = Origin.decode(decoder);
            }
            values0 = (UrlLoaderFactory[])decoder1.readServiceInterfaces(16, 0, keys0.length, UrlLoaderFactory.MANAGER);
            result.initiatorSpecificFactories = new HashMap<>();
            for (int index0 = 0; index0 < keys0.length; index0++)
                result.initiatorSpecificFactories.put(keys0[index0], values0[index0]);
            result.appcacheFactory = (UrlLoaderFactory)decoder0.readServiceInterface(32, true, UrlLoaderFactory.MANAGER);
            result.bypassRedirectChecks = decoder0.readBoolean(40, 0);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.defaultFactory, 8, true, UrlLoaderFactory.MANAGER);
        if (this.schemeSpecificFactories == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(16);
            int size0 = this.schemeSpecificFactories.size();
            String[] keys0 = new String[size0];
            UrlLoaderFactory[] values0 = new UrlLoaderFactory[size0];
            int index0 = 0;
            for (Map.Entry<String, UrlLoaderFactory> entry0 : this.schemeSpecificFactories.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                index0++;
            }
            Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
            for (int i1 = 0; i1 < keys0.length; i1++)
                encoder2.encode(keys0[i1], 8 + 8 * i1, false);
            encoder1.encode(values0, 16, 0, -1, UrlLoaderFactory.MANAGER);
        }
        if (this.initiatorSpecificFactories == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(24);
            int size0 = this.initiatorSpecificFactories.size();
            Origin[] keys0 = new Origin[size0];
            UrlLoaderFactory[] values0 = new UrlLoaderFactory[size0];
            int index0 = 0;
            for (Map.Entry<Origin, UrlLoaderFactory> entry0 : this.initiatorSpecificFactories.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                index0++;
            }
            Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
            for (int i1 = 0; i1 < keys0.length; i1++)
                encoder2.encode((Struct)keys0[i1], 8 + 8 * i1, false);
            encoder1.encode(values0, 16, 0, -1, UrlLoaderFactory.MANAGER);
        }
        encoder0.encode(this.appcacheFactory, 32, true, UrlLoaderFactory.MANAGER);
        encoder0.encode(this.bypassRedirectChecks, 40, 0);
    }
}
