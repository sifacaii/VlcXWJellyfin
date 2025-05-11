package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerConnector.class */
public interface SharedWorkerConnector extends Interface {
    public static final Interface.Manager<SharedWorkerConnector, Proxy> MANAGER = SharedWorkerConnector_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerConnector$Proxy.class */
    public interface Proxy extends SharedWorkerConnector, Interface.Proxy {
    }

    void connect(SharedWorkerInfo sharedWorkerInfo, FetchClientSettingsObject fetchClientSettingsObject, SharedWorkerClient sharedWorkerClient, int i, MessagePipeHandle messagePipeHandle, BlobUrlToken blobUrlToken);
}
