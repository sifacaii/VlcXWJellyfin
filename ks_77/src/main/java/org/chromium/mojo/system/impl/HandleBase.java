package org.chromium.mojo.system.impl;

import org.chromium.base.Log;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.UntypedHandle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/HandleBase.class */
public abstract class HandleBase implements Handle {
    private static final String TAG = "HandleImpl";
    private int mMojoHandle;
    protected CoreImpl mCore;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandleBase(CoreImpl core, int mojoHandle) {
        this.mCore = core;
        this.mMojoHandle = mojoHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HandleBase(HandleBase other) {
        this.mCore = other.mCore;
        int mojoHandle = other.mMojoHandle;
        other.mMojoHandle = 0;
        this.mMojoHandle = mojoHandle;
    }

    @Override // org.chromium.mojo.system.Handle, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mMojoHandle != 0) {
            int handle = this.mMojoHandle;
            this.mMojoHandle = 0;
            this.mCore.close(handle);
        }
    }

    @Override // org.chromium.mojo.system.Handle
    public Core.HandleSignalsState querySignalsState() {
        return this.mCore.queryHandleSignalsState(this.mMojoHandle);
    }

    @Override // org.chromium.mojo.system.Handle
    public boolean isValid() {
        return this.mMojoHandle != 0;
    }

    @Override // org.chromium.mojo.system.Handle
    public UntypedHandle toUntypedHandle() {
        return new UntypedHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.Handle
    public Core getCore() {
        return this.mCore;
    }

    @Override // org.chromium.mojo.system.Handle
    public int releaseNativeHandle() {
        int result = this.mMojoHandle;
        this.mMojoHandle = 0;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMojoHandle() {
        return this.mMojoHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateHandle() {
        this.mMojoHandle = 0;
    }

    protected final void finalize() throws Throwable {
        if (isValid()) {
            Log.w(TAG, "Handle was not closed.", new Object[0]);
            this.mCore.closeWithResult(this.mMojoHandle);
        }
        super.finalize();
    }
}
