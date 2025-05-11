package com.pakdata.xwalk.refactor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.pakdata.xwalk.refactor.XWalkContentsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentsClientCallbackHelper.class */
public class XWalkContentsClientCallbackHelper {
    private static final int MSG_ON_LOAD_RESOURCE = 1;
    private static final int MSG_ON_PAGE_STARTED = 2;
    private static final int MSG_ON_RECEIVED_ERROR = 5;
    private static final int MSG_ON_RESOURCE_LOAD_STARTED = 6;
    private static final int MSG_ON_PAGE_FINISHED = 7;
    private static final int MSG_ON_RECEIVED_RESPONSE_HEADERS = 8;
    private static final int MSG_SYNTHESIZE_PAGE_LOADING = 9;
    private final XWalkContentsClient mContentsClient;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.pakdata.xwalk.refactor.XWalkContentsClientCallbackHelper.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onLoadResource((String) msg.obj);
                    return;
                case 2:
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onPageStarted((String) msg.obj);
                    return;
                case 3:
                case 4:
                default:
                    throw new IllegalStateException("XWalkContentsClientCallbackHelper: unhandled message " + msg.what);
                case 5:
                    OnReceivedErrorInfo info = (OnReceivedErrorInfo) msg.obj;
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onReceivedError(info.mErrorCode, info.mDescription, info.mFailingUrl);
                    return;
                case 6:
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onResourceLoadStarted((String) msg.obj);
                    return;
                case 7:
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onPageFinished((String) msg.obj);
                    return;
                case 8:
                    OnReceivedResponseHeadersInfo info2 = (OnReceivedResponseHeadersInfo) msg.obj;
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onReceivedResponseHeaders(info2.mRequest, info2.mResponse);
                    return;
                case 9:
                    String url = (String) msg.obj;
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onPageStarted(url);
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onLoadResource(url);
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onProgressChanged(100);
                    XWalkContentsClientCallbackHelper.this.mContentsClient.onPageFinished(url);
                    return;
            }
        }
    };

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentsClientCallbackHelper$OnReceivedErrorInfo.class */
    private static class OnReceivedErrorInfo {
        final int mErrorCode;
        final String mDescription;
        final String mFailingUrl;

        OnReceivedErrorInfo(int errorCode, String description, String failingUrl) {
            this.mErrorCode = errorCode;
            this.mDescription = description;
            this.mFailingUrl = failingUrl;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkContentsClientCallbackHelper$OnReceivedResponseHeadersInfo.class */
    private static class OnReceivedResponseHeadersInfo {
        final XWalkContentsClient.XWalkWebResourceRequest mRequest;
        final XWalkWebResourceResponse mResponse;

        OnReceivedResponseHeadersInfo(XWalkContentsClient.XWalkWebResourceRequest request, XWalkWebResourceResponse response) {
            this.mRequest = request;
            this.mResponse = response;
        }
    }

    public XWalkContentsClientCallbackHelper(XWalkContentsClient contentsClient) {
        this.mContentsClient = contentsClient;
    }

    public void postOnLoadResource(String url) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, url));
    }

    public void postSynthesizedPageLoadingForUrlBarUpdate(String url) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(9, url));
    }

    public void postOnPageStarted(String url) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, url));
    }

    public void postOnReceivedError(int errorCode, String description, String failingUrl) {
        OnReceivedErrorInfo info = new OnReceivedErrorInfo(errorCode, description, failingUrl);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, info));
    }

    public void postOnResourceLoadStarted(String url) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, url));
    }

    public void postOnPageFinished(String url) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, url));
    }

    public void postOnReceivedResponseHeaders(XWalkContentsClient.XWalkWebResourceRequest request, XWalkWebResourceResponse response) {
        OnReceivedResponseHeadersInfo info = new OnReceivedResponseHeadersInfo(request, response);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(8, info));
    }
}
