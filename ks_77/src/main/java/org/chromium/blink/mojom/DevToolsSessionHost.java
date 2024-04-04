package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsSessionHost.class */
public interface DevToolsSessionHost extends Interface {
    public static final Interface.Manager<DevToolsSessionHost, Proxy> MANAGER = DevToolsSessionHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsSessionHost$Proxy.class */
    public interface Proxy extends DevToolsSessionHost, Interface.Proxy {
    }

    void dispatchProtocolResponse(DevToolsMessage devToolsMessage, int i, DevToolsSessionState devToolsSessionState);

    void dispatchProtocolNotification(DevToolsMessage devToolsMessage, DevToolsSessionState devToolsSessionState);
}
