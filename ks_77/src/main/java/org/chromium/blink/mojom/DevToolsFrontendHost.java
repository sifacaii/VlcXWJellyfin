package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsFrontendHost.class */
public interface DevToolsFrontendHost extends Interface {
    public static final Interface.Manager<DevToolsFrontendHost, Proxy> MANAGER = DevToolsFrontendHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsFrontendHost$Proxy.class */
    public interface Proxy extends DevToolsFrontendHost, Interface.Proxy {
    }

    void dispatchEmbedderMessage(String str);
}
