package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManager.class */
public interface DnsConfigChangeManager extends Interface {
    public static final Interface.Manager<DnsConfigChangeManager, Proxy> MANAGER = DnsConfigChangeManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/DnsConfigChangeManager$Proxy.class */
    public interface Proxy extends DnsConfigChangeManager, Interface.Proxy {
    }

    void requestNotifications(DnsConfigChangeManagerClient dnsConfigChangeManagerClient);
}
