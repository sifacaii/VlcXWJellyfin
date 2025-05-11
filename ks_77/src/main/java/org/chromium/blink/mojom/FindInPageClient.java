package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindInPageClient.class */
public interface FindInPageClient extends Interface {
    public static final Interface.Manager<FindInPageClient, Proxy> MANAGER = FindInPageClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FindInPageClient$Proxy.class */
    public interface Proxy extends FindInPageClient, Interface.Proxy {
    }

    void setNumberOfMatches(int i, int i2, int i3);

    void setActiveMatch(int i, Rect rect, int i2, int i3);
}
