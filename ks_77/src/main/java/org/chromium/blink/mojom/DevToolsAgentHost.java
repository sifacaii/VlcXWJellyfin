package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsAgentHost.class */
public interface DevToolsAgentHost extends Interface {
    public static final Interface.Manager<DevToolsAgentHost, Proxy> MANAGER = DevToolsAgentHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsAgentHost$Proxy.class */
    public interface Proxy extends DevToolsAgentHost, Interface.Proxy {
    }

    void childWorkerCreated(DevToolsAgent devToolsAgent, InterfaceRequest<DevToolsAgentHost> interfaceRequest, Url url, String str, UnguessableToken unguessableToken, boolean z);
}
