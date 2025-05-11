package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter.class */
public interface DataPipeGetter extends Interface {
    public static final Interface.Manager<DataPipeGetter, Proxy> MANAGER = DataPipeGetter_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter$Proxy.class */
    public interface Proxy extends DataPipeGetter, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DataPipeGetter$ReadResponse.class */
    public interface ReadResponse extends Callbacks.Callback2<Integer, Long> {
    }

    void read(DataPipe.ProducerHandle producerHandle, ReadResponse readResponse);

    void clone(InterfaceRequest<DataPipeGetter> interfaceRequest);
}
