package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ProgressClient.class */
public interface ProgressClient extends Interface {
    public static final Interface.Manager<ProgressClient, Proxy> MANAGER = ProgressClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ProgressClient$Proxy.class */
    public interface Proxy extends ProgressClient, Interface.Proxy {
    }

    void onProgress(long j);
}
