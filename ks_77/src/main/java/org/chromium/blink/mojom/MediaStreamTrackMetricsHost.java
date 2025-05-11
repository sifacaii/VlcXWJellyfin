package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamTrackMetricsHost.class */
public interface MediaStreamTrackMetricsHost extends Interface {
    public static final Interface.Manager<MediaStreamTrackMetricsHost, Proxy> MANAGER = MediaStreamTrackMetricsHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamTrackMetricsHost$Proxy.class */
    public interface Proxy extends MediaStreamTrackMetricsHost, Interface.Proxy {
    }

    void addTrack(long j, boolean z, boolean z2);

    void removeTrack(long j);
}
