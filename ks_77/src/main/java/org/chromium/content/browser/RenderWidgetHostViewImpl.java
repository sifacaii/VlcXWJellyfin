package org.chromium.content.browser;

import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.RenderWidgetHostView;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/RenderWidgetHostViewImpl.class */
public class RenderWidgetHostViewImpl implements RenderWidgetHostView {
    private long mNativeRenderWidgetHostView;
    private Throwable mNativeDestroyThrowable;

    private native boolean nativeIsReady(long j);

    private native int nativeGetBackgroundColor(long j);

    private native void nativeDismissTextHandles(long j);

    private native void nativeShowContextMenuAtTouchHandle(long j, int i, int i2);

    private native void nativeInsetViewportBottom(long j, int i);

    private native void nativeWriteContentBitmapToDiskAsync(long j, int i, int i2, String str, Callback<String> callback);

    @CalledByNative
    private static RenderWidgetHostViewImpl create(long renderWidgetHostViewLong) {
        return new RenderWidgetHostViewImpl(renderWidgetHostViewLong);
    }

    private RenderWidgetHostViewImpl(long renderWidgetHostViewLong) {
        this.mNativeRenderWidgetHostView = renderWidgetHostViewLong;
    }

    @Override // org.chromium.content_public.browser.RenderWidgetHostView
    public boolean isReady() {
        checkNotDestroyed();
        return nativeIsReady(getNativePtr());
    }

    @Override // org.chromium.content_public.browser.RenderWidgetHostView
    public int getBackgroundColor() {
        return nativeGetBackgroundColor(getNativePtr());
    }

    public void dismissTextHandles() {
        if (isDestroyed()) {
            return;
        }
        nativeDismissTextHandles(getNativePtr());
    }

    public void showContextMenuAtTouchHandle(int x, int y) {
        checkNotDestroyed();
        nativeShowContextMenuAtTouchHandle(getNativePtr(), x, y);
    }

    @Override // org.chromium.content_public.browser.RenderWidgetHostView
    public void insetViewportBottom(int bottomAdjustPx) {
        checkNotDestroyed();
        nativeInsetViewportBottom(getNativePtr(), bottomAdjustPx);
    }

    @Override // org.chromium.content_public.browser.RenderWidgetHostView
    public void writeContentBitmapToDiskAsync(int width, int height, String path, Callback<String> callback) {
        if (isDestroyed()) {
            callback.onResult("RWHVA already destroyed!");
        }
        nativeWriteContentBitmapToDiskAsync(getNativePtr(), width, height, path, callback);
    }

    public boolean isDestroyed() {
        return getNativePtr() == 0;
    }

    private long getNativePtr() {
        return this.mNativeRenderWidgetHostView;
    }

    @CalledByNative
    private void clearNativePtr() {
        this.mNativeRenderWidgetHostView = 0L;
        this.mNativeDestroyThrowable = new RuntimeException("clearNativePtr");
    }

    private void checkNotDestroyed() {
        if (getNativePtr() == 0) {
            throw new IllegalStateException("Native RenderWidgetHostViewAndroid already destroyed", this.mNativeDestroyThrowable);
        }
    }
}
