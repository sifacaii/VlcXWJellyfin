package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerHost.class */
public interface SharedWorkerHost extends Interface {
    public static final Interface.Manager<SharedWorkerHost, Proxy> MANAGER = SharedWorkerHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerHost$Proxy.class */
    public interface Proxy extends SharedWorkerHost, Interface.Proxy {
    }

    void onConnected(int i);

    void onContextClosed();

    void onReadyForInspection();

    void onScriptLoadFailed();

    void onFeatureUsed(int i);
}
