package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StoragePartitionService.class */
public interface StoragePartitionService extends Interface {
    public static final Interface.Manager<StoragePartitionService, Proxy> MANAGER = StoragePartitionService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/StoragePartitionService$Proxy.class */
    public interface Proxy extends StoragePartitionService, Interface.Proxy {
    }

    void openLocalStorage(Origin origin, InterfaceRequest<StorageArea> interfaceRequest);

    void openSessionStorage(String str, InterfaceRequest<SessionStorageNamespace> interfaceRequest);
}
