package org.chromium.content_public.browser;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/NavigationHandle.class */
public class NavigationHandle {
    private long mNativeNavigationHandleProxy;
    private final boolean mIsInMainFrame;
    private final boolean mIsRendererInitiated;
    private final boolean mIsSameDocument;
    private Integer mPageTransition;
    private String mUrl;
    private boolean mHasCommitted;
    private boolean mIsDownload;
    private boolean mIsErrorPage;
    private boolean mIsFragmentNavigation;
    private boolean mIsValidSearchFormUrl;
    private int mErrorCode;
    private int mHttpStatusCode;

    private static native void nativeSetRequestHeader(long j, String str, String str2);

    private static native void nativeRemoveRequestHeader(long j, String str);

    @CalledByNative
    public NavigationHandle(long nativeNavigationHandleProxy, String url, boolean isInMainFrame, boolean isSameDocument, boolean isRendererInitiated) {
        this.mNativeNavigationHandleProxy = nativeNavigationHandleProxy;
        this.mUrl = url;
        this.mIsInMainFrame = isInMainFrame;
        this.mIsSameDocument = isSameDocument;
        this.mIsRendererInitiated = isRendererInitiated;
    }

    @CalledByNative
    private void didRedirect(String url) {
        this.mUrl = url;
    }

    @CalledByNative
    public void didFinish(String url, boolean isErrorPage, boolean hasCommitted, boolean isFragmentNavigation, boolean isDownload, boolean isValidSearchFormUrl, int transition, int errorCode, int httpStatuscode) {
        this.mUrl = url;
        this.mIsErrorPage = isErrorPage;
        this.mHasCommitted = hasCommitted;
        this.mIsFragmentNavigation = isFragmentNavigation;
        this.mIsDownload = isDownload;
        this.mIsValidSearchFormUrl = isValidSearchFormUrl;
        this.mPageTransition = transition == -1 ? null : Integer.valueOf(transition);
        this.mErrorCode = errorCode;
        this.mHttpStatusCode = httpStatuscode;
    }

    @CalledByNative
    private void release() {
        this.mNativeNavigationHandleProxy = 0L;
    }

    public long nativePtr() {
        return this.mNativeNavigationHandleProxy;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isInMainFrame() {
        return this.mIsInMainFrame;
    }

    public boolean isRendererInitiated() {
        return this.mIsRendererInitiated;
    }

    public boolean isSameDocument() {
        return this.mIsSameDocument;
    }

    public String errorDescription() {
        return CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
    }

    public int errorCode() {
        return this.mErrorCode;
    }

    public boolean hasCommitted() {
        return this.mHasCommitted;
    }

    public int httpStatusCode() {
        return this.mHttpStatusCode;
    }

    public Integer pageTransition() {
        return this.mPageTransition;
    }

    public boolean isFragmentNavigation() {
        return this.mIsFragmentNavigation;
    }

    public boolean isErrorPage() {
        return this.mIsErrorPage;
    }

    public boolean isDownload() {
        return this.mIsDownload;
    }

    public boolean isValidSearchFormUrl() {
        return this.mIsValidSearchFormUrl;
    }

    public void setRequestHeader(String headerName, String headerValue) {
        nativeSetRequestHeader(this.mNativeNavigationHandleProxy, headerName, headerValue);
    }

    public void removeRequestHeader(String headerName) {
        nativeRemoveRequestHeader(this.mNativeNavigationHandleProxy, headerName);
    }
}
