package org.chromium.base.library_loader;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/library_loader/ProcessInitException.class */
public class ProcessInitException extends Exception {
    private int mErrorCode;

    public ProcessInitException(int errorCode) {
        this.mErrorCode = 0;
        this.mErrorCode = errorCode;
    }

    public ProcessInitException(int errorCode, Throwable throwable) {
        super(null, throwable);
        this.mErrorCode = 0;
        this.mErrorCode = errorCode;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
