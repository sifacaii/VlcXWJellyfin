package org.chromium.ui.gl;

import android.graphics.SurfaceTexture;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("gl")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/gl/SurfaceTextureListener.class */
class SurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {
    private final long mNativeSurfaceTextureListener;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native void nativeFrameAvailable(long j);

    private native void nativeDestroy(long j);

    static {
        $assertionsDisabled = !SurfaceTextureListener.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SurfaceTextureListener(long nativeSurfaceTextureListener) {
        if (!$assertionsDisabled && nativeSurfaceTextureListener == 0) {
            throw new AssertionError();
        }
        this.mNativeSurfaceTextureListener = nativeSurfaceTextureListener;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        nativeFrameAvailable(this.mNativeSurfaceTextureListener);
    }

    protected void finalize() throws Throwable {
        try {
            nativeDestroy(this.mNativeSurfaceTextureListener);
        } finally {
            super.finalize();
        }
    }
}
