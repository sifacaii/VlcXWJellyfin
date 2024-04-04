package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AutoplayConfigurationClient.class */
public interface AutoplayConfigurationClient extends Interface {
    public static final Interface.Manager<AutoplayConfigurationClient, Proxy> MANAGER = AutoplayConfigurationClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AutoplayConfigurationClient$Proxy.class */
    public interface Proxy extends AutoplayConfigurationClient, Interface.Proxy {
    }

    void addAutoplayFlags(Origin origin, int i);
}
