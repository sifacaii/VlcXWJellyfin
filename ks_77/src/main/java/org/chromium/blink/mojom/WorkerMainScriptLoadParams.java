package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.network.mojom.UrlLoaderClientEndpoints;
import org.chromium.network.mojom.UrlRequestRedirectInfo;
import org.chromium.network.mojom.UrlResponseHead;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WorkerMainScriptLoadParams.class */
public final class WorkerMainScriptLoadParams extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public UrlResponseHead responseHead;
    public DataPipe.ConsumerHandle responseBody;
    public UrlLoaderClientEndpoints urlLoaderClientEndpoints;
    public UrlRequestRedirectInfo[] redirectInfos;
    public UrlResponseHead[] redirectResponseHeads;

    private WorkerMainScriptLoadParams(int version) {
        super(48, version);
        this.responseBody = InvalidHandle.INSTANCE;
    }

    public WorkerMainScriptLoadParams() {
        this(0);
    }

    public static WorkerMainScriptLoadParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static WorkerMainScriptLoadParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static WorkerMainScriptLoadParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            WorkerMainScriptLoadParams result = new WorkerMainScriptLoadParams(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.responseHead = UrlResponseHead.decode(decoder1);
            result.responseBody = decoder0.readConsumerHandle(16, true);
            Decoder decoder12 = decoder0.readPointer(24, true);
            result.urlLoaderClientEndpoints = UrlLoaderClientEndpoints.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.redirectInfos = new UrlRequestRedirectInfo[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.redirectInfos[i1] = UrlRequestRedirectInfo.decode(decoder2);
            }
            Decoder decoder14 = decoder0.readPointer(40, false);
            DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
            result.redirectResponseHeads = new UrlResponseHead[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder14.readPointer(8 + (8 * i12), false);
                result.redirectResponseHeads[i12] = UrlResponseHead.decode(decoder22);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode((Struct) this.responseHead, 8, false);
        encoder0.encode((Handle) this.responseBody, 16, true);
        encoder0.encode((Struct) this.urlLoaderClientEndpoints, 24, true);
        if (this.redirectInfos == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.redirectInfos.length, 32, -1);
            for (int i0 = 0; i0 < this.redirectInfos.length; i0++) {
                encoder1.encode((Struct) this.redirectInfos[i0], 8 + (8 * i0), false);
            }
        }
        if (this.redirectResponseHeads == null) {
            encoder0.encodeNullPointer(40, false);
            return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(this.redirectResponseHeads.length, 40, -1);
        for (int i02 = 0; i02 < this.redirectResponseHeads.length; i02++) {
            encoder12.encode((Struct) this.redirectResponseHeads[i02], 8 + (8 * i02), false);
        }
    }
}
