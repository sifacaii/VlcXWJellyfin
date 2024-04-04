package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDeviceObserver.class */
public interface MediaStreamDeviceObserver extends Interface {
    public static final Interface.Manager<MediaStreamDeviceObserver, Proxy> MANAGER = MediaStreamDeviceObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamDeviceObserver$Proxy.class */
    public interface Proxy extends MediaStreamDeviceObserver, Interface.Proxy {
    }

    void onDeviceStopped(String str, MediaStreamDevice mediaStreamDevice);

    void onDeviceChanged(String str, MediaStreamDevice mediaStreamDevice, MediaStreamDevice mediaStreamDevice2);
}
