package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerClient.class */
public interface SharedWorkerClient extends Interface {
    public static final Interface.Manager<SharedWorkerClient, Proxy> MANAGER = SharedWorkerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerClient$Proxy.class */
    public interface Proxy extends SharedWorkerClient, Interface.Proxy {
    }

    void onCreated(int i);

    void onConnected(int[] iArr);

    void onScriptLoadFailed();

    void onFeatureUsed(int i);
}
