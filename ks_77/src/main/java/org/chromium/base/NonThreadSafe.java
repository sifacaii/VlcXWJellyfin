package org.chromium.base;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/NonThreadSafe.class */
public class NonThreadSafe {
    private Long mThreadId;

    public NonThreadSafe() {
        ensureThreadIdAssigned();
    }

    @VisibleForTesting
    public synchronized void detachFromThread() {
        this.mThreadId = null;
    }

    public synchronized boolean calledOnValidThread() {
        ensureThreadIdAssigned();
        return this.mThreadId.equals(Long.valueOf(Thread.currentThread().getId()));
    }

    private void ensureThreadIdAssigned() {
        if (this.mThreadId == null) {
            this.mThreadId = Long.valueOf(Thread.currentThread().getId());
        }
    }
}
