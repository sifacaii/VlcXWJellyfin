package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AnchorElementMetricsHost.class */
public interface AnchorElementMetricsHost extends Interface {
    public static final Interface.Manager<AnchorElementMetricsHost, Proxy> MANAGER = AnchorElementMetricsHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AnchorElementMetricsHost$Proxy.class */
    public interface Proxy extends AnchorElementMetricsHost, Interface.Proxy {
    }

    void reportAnchorElementMetricsOnClick(AnchorElementMetrics anchorElementMetrics);

    void reportAnchorElementMetricsOnLoad(AnchorElementMetrics[] anchorElementMetricsArr, Size size);
}
