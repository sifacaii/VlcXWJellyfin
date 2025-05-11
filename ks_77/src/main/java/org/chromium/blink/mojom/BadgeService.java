package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BadgeService.class */
public interface BadgeService extends Interface {
    public static final Interface.Manager<BadgeService, Proxy> MANAGER = BadgeService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BadgeService$Proxy.class */
    public interface Proxy extends BadgeService, Interface.Proxy {
    }

    void setInteger(long j);

    void setFlag();

    void clearBadge();
}
