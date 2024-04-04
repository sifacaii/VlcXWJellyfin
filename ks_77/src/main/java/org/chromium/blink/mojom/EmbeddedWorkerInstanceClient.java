package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/EmbeddedWorkerInstanceClient.class */
public interface EmbeddedWorkerInstanceClient extends Interface {
    public static final Interface.Manager<EmbeddedWorkerInstanceClient, Proxy> MANAGER = EmbeddedWorkerInstanceClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/EmbeddedWorkerInstanceClient$Proxy.class */
    public interface Proxy extends EmbeddedWorkerInstanceClient, Interface.Proxy {
    }

    void startWorker(EmbeddedWorkerStartParams embeddedWorkerStartParams);

    void stopWorker();

    void resumeAfterDownload();

    void addMessageToConsole(int i, String str);

    void bindDevToolsAgent(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
