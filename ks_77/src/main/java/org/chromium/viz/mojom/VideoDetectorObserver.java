package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver.class */
public interface VideoDetectorObserver extends Interface {
    public static final Interface.Manager<VideoDetectorObserver, Proxy> MANAGER = VideoDetectorObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/VideoDetectorObserver$Proxy.class */
    public interface Proxy extends VideoDetectorObserver, Interface.Proxy {
    }

    void onVideoActivityStarted();

    void onVideoActivityEnded();
}
