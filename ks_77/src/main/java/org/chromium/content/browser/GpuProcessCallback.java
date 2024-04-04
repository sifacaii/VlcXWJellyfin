package org.chromium.content.browser;

import android.view.Surface;
import org.chromium.base.UnguessableToken;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.common.IGpuProcessCallback;
import org.chromium.content.common.SurfaceWrapper;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/GpuProcessCallback.class */
class GpuProcessCallback extends IGpuProcessCallback.Stub {
    private static native void nativeCompleteScopedSurfaceRequest(UnguessableToken unguessableToken, Surface surface);

    private static native SurfaceWrapper nativeGetViewSurface(int i);

    @Override // org.chromium.content.common.IGpuProcessCallback
    public void forwardSurfaceForSurfaceRequest(UnguessableToken requestToken, Surface surface) {
        nativeCompleteScopedSurfaceRequest(requestToken, surface);
    }

    @Override // org.chromium.content.common.IGpuProcessCallback
    public SurfaceWrapper getViewSurface(int surfaceId) {
        return nativeGetViewSurface(surfaceId);
    }
}
