package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PluginRegistry.class */
public interface PluginRegistry extends Interface {
    public static final Interface.Manager<PluginRegistry, Proxy> MANAGER = PluginRegistry_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PluginRegistry$GetPluginsResponse.class */
    public interface GetPluginsResponse extends Callbacks.Callback1<PluginInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PluginRegistry$Proxy.class */
    public interface Proxy extends PluginRegistry, Interface.Proxy {
    }

    void getPlugins(boolean z, Origin origin, GetPluginsResponse getPluginsResponse);
}
