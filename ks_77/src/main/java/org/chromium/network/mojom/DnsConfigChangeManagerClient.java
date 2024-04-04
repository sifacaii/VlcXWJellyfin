package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManagerClient.class */
public interface DnsConfigChangeManagerClient extends Interface {
    public static final Interface.Manager<DnsConfigChangeManagerClient, Proxy> MANAGER = DnsConfigChangeManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManagerClient$Proxy.class */
    public interface Proxy extends DnsConfigChangeManagerClient, Interface.Proxy {
    }

    void onSystemDnsConfigChanged();
}
