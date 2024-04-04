package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsSession.class */
public interface DevToolsSession extends Interface {
    public static final Interface.Manager<DevToolsSession, Proxy> MANAGER = DevToolsSession_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsSession$Proxy.class */
    public interface Proxy extends DevToolsSession, Interface.Proxy {
    }

    void dispatchProtocolCommand(int i, String str, DevToolsMessage devToolsMessage);
}
