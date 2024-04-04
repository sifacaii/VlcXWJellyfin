package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter.class */
public interface ChunkedDataPipeGetter extends Interface {
    public static final Interface.Manager<ChunkedDataPipeGetter, Proxy> MANAGER = ChunkedDataPipeGetter_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter$GetSizeResponse.class */
    public interface GetSizeResponse extends Callbacks.Callback2<Integer, Long> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ChunkedDataPipeGetter$Proxy.class */
    public interface Proxy extends ChunkedDataPipeGetter, Interface.Proxy {
    }

    void getSize(GetSizeResponse getSizeResponse);

    void startReading(DataPipe.ProducerHandle producerHandle);
}
