package com.pakdata.xwalk.refactor;

import com.pakdata.xwalk.refactor.XWalkContentsClient;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentsBackgroundThreadClient.class */
public abstract class XWalkContentsBackgroundThreadClient {
    public abstract XWalkWebResourceResponse shouldInterceptRequest(XWalkContentsClient.XWalkWebResourceRequest xWalkWebResourceRequest);

    @CalledByNative
    private XWalkWebResourceResponse shouldInterceptRequestFromNative(String url, boolean isMainFrame, boolean hasUserGesture, String method, String[] requestHeaderNames, String[] requestHeaderValues) {
        return shouldInterceptRequest(new XWalkContentsClient.XWalkWebResourceRequest(url, isMainFrame, hasUserGesture, method, requestHeaderNames, requestHeaderValues));
    }
}
