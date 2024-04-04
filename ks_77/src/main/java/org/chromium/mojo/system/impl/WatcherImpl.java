package org.chromium.mojo.system.impl;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.Watcher;

@JNINamespace("mojo::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/WatcherImpl.class */
class WatcherImpl implements Watcher {
    private long mImplPtr = nativeCreateWatcher();
    private Watcher.Callback mCallback;

    private native long nativeCreateWatcher();

    private native int nativeStart(long j, int i, int i2);

    private native void nativeCancel(long j);

    private native void nativeDelete(long j);

    @Override // org.chromium.mojo.system.Watcher
    public int start(Handle handle, Core.HandleSignals signals, Watcher.Callback callback) {
        if (this.mImplPtr == 0 || !(handle instanceof HandleBase)) {
            return 3;
        }
        int result = nativeStart(this.mImplPtr, ((HandleBase) handle).getMojoHandle(), signals.getFlags());
        if (result == 0) {
            this.mCallback = callback;
        }
        return result;
    }

    @Override // org.chromium.mojo.system.Watcher
    public void cancel() {
        if (this.mImplPtr == 0) {
            return;
        }
        this.mCallback = null;
        nativeCancel(this.mImplPtr);
    }

    @Override // org.chromium.mojo.system.Watcher
    public void destroy() {
        if (this.mImplPtr == 0) {
            return;
        }
        nativeDelete(this.mImplPtr);
        this.mImplPtr = 0L;
    }

    @CalledByNative
    private void onHandleReady(int result) {
        this.mCallback.onResult(result);
    }
}
