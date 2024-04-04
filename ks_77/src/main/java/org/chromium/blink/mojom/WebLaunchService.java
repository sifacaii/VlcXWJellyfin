package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebLaunchService.class */
public interface WebLaunchService extends Interface {
    public static final Interface.Manager<WebLaunchService, Proxy> MANAGER = WebLaunchService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebLaunchService$Proxy.class */
    public interface Proxy extends WebLaunchService, Interface.Proxy {
    }

    void setLaunchFiles(NativeFileSystemEntry[] nativeFileSystemEntryArr);
}
