package com.pakdata.xwalk.refactor;

import android.content.Context;
import android.net.http.SslError;
import android.os.Message;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkClient.class */
public class XWalkClient {
    private Context mContext;
    private XWalkView mXWalkView;

    public XWalkClient(XWalkView view) {
        this.mContext = view.getContext();
        this.mXWalkView = view;
    }

    public void onRendererUnresponsive(XWalkView view) {
    }

    public void onRendererResponsive(XWalkView view) {
    }

    @Deprecated
    public void onTooManyRedirects(XWalkView view, Message cancelMsg, Message continueMsg) {
        cancelMsg.sendToTarget();
    }

    public void onFormResubmission(XWalkView view, Message dontResend, Message resend) {
        dontResend.sendToTarget();
    }

    public void doUpdateVisitedHistory(XWalkView view, String url, boolean isReload) {
    }

    public void onProceededAfterSslError(XWalkView view, SslError error) {
    }

    public void onReceivedLoginRequest(XWalkView view, String realm, String account, String args) {
    }

    public void onLoadResource(XWalkView view, String url) {
    }
}
