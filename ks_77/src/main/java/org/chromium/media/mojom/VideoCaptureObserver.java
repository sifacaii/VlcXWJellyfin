package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver.class */
public interface VideoCaptureObserver extends Interface {
    public static final Interface.Manager<VideoCaptureObserver, Proxy> MANAGER = VideoCaptureObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureObserver$Proxy.class */
    public interface Proxy extends VideoCaptureObserver, Interface.Proxy {
    }

    void onStateChanged(int i);

    void onNewBuffer(int i, VideoBufferHandle videoBufferHandle);

    void onBufferReady(int i, VideoFrameInfo videoFrameInfo);

    void onBufferDestroyed(int i);
}
