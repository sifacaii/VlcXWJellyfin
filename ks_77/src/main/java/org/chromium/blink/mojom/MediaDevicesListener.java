package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesListener.class */
public interface MediaDevicesListener extends Interface {
    public static final Interface.Manager<MediaDevicesListener, Proxy> MANAGER = MediaDevicesListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaDevicesListener$Proxy.class */
    public interface Proxy extends MediaDevicesListener, Interface.Proxy {
    }

    void onDevicesChanged(int i, MediaDeviceInfo[] mediaDeviceInfoArr);
}
