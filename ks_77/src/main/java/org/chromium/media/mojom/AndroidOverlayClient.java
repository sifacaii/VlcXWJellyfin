package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AndroidOverlayClient.class */
public interface AndroidOverlayClient extends Interface {
    public static final Interface.Manager<AndroidOverlayClient, Proxy> MANAGER = AndroidOverlayClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AndroidOverlayClient$Proxy.class */
    public interface Proxy extends AndroidOverlayClient, Interface.Proxy {
    }

    void onSurfaceReady(long j);

    void onDestroyed();

    void onPowerEfficientState(boolean z);
}
