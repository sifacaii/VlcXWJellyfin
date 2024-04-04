package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AndroidOverlay.class */
public interface AndroidOverlay extends Interface {
    public static final Interface.Manager<AndroidOverlay, Proxy> MANAGER = AndroidOverlay_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AndroidOverlay$Proxy.class */
    public interface Proxy extends AndroidOverlay, Interface.Proxy {
    }

    void scheduleLayout(Rect rect);
}
