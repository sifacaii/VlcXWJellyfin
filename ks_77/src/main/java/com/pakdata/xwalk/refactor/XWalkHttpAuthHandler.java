package com.pakdata.xwalk.refactor;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkHttpAuthHandler.class */
public class XWalkHttpAuthHandler implements XWalkHttpAuth {
    private long mNativeXWalkHttpAuthHandler;
    private final boolean mFirstAttempt;

    private native void nativeProceed(long j, String str, String str2);

    private native void nativeCancel(long j);

    @Override // com.pakdata.xwalk.refactor.XWalkHttpAuth
    public void proceed(String username, String password) {
        if (this.mNativeXWalkHttpAuthHandler != 0) {
            nativeProceed(this.mNativeXWalkHttpAuthHandler, username, password);
            this.mNativeXWalkHttpAuthHandler = 0L;
        }
    }

    @Override // com.pakdata.xwalk.refactor.XWalkHttpAuth
    public void cancel() {
        if (this.mNativeXWalkHttpAuthHandler != 0) {
            nativeCancel(this.mNativeXWalkHttpAuthHandler);
            this.mNativeXWalkHttpAuthHandler = 0L;
        }
    }

    @Override // com.pakdata.xwalk.refactor.XWalkHttpAuth
    public boolean isFirstAttempt() {
        return this.mFirstAttempt;
    }

    @CalledByNative
    public static XWalkHttpAuthHandler create(long nativeXWalkAuthHandler, boolean firstAttempt) {
        return new XWalkHttpAuthHandler(nativeXWalkAuthHandler, firstAttempt);
    }

    public XWalkHttpAuthHandler(long nativeXWalkHttpAuthHandler, boolean firstAttempt) {
        this.mNativeXWalkHttpAuthHandler = nativeXWalkHttpAuthHandler;
        this.mFirstAttempt = firstAttempt;
    }

    XWalkHttpAuthHandler() {
        this.mNativeXWalkHttpAuthHandler = 0L;
        this.mFirstAttempt = false;
    }

    @CalledByNative
    void handlerDestroyed() {
        this.mNativeXWalkHttpAuthHandler = 0L;
    }
}
