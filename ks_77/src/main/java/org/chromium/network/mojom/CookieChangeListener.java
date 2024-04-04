package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieChangeListener.class */
public interface CookieChangeListener extends Interface {
    public static final Interface.Manager<CookieChangeListener, Proxy> MANAGER = CookieChangeListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieChangeListener$Proxy.class */
    public interface Proxy extends CookieChangeListener, Interface.Proxy {
    }

    void onCookieChange(CanonicalCookie canonicalCookie, int i);
}
