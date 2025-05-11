package com.pakdata.xwalk.refactor;

import org.chromium.base.ThreadUtils;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkJavascriptResultHandler.class */
public class XWalkJavascriptResultHandler implements XWalkJavascriptResult {
    private XWalkContentsClientBridge mBridge;
    private final int mId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkJavascriptResultHandler(XWalkContentsClientBridge bridge, int id) {
        this.mBridge = bridge;
        this.mId = id;
    }

    XWalkJavascriptResultHandler() {
        this.mBridge = null;
        this.mId = -1;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkJavascriptResult
    public void confirm() {
        confirmWithResult(null);
    }

    @Override // com.pakdata.xwalk.refactor.XWalkJavascriptResult
    public void confirmWithResult(final String promptResult) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.pakdata.xwalk.refactor.XWalkJavascriptResultHandler.1
            @Override // java.lang.Runnable
            public void run() {
                if (XWalkJavascriptResultHandler.this.mBridge != null) {
                    XWalkJavascriptResultHandler.this.mBridge.confirmJsResult(XWalkJavascriptResultHandler.this.mId, promptResult);
                }
                XWalkJavascriptResultHandler.this.mBridge = null;
            }
        });
    }

    @Override // com.pakdata.xwalk.refactor.XWalkJavascriptResult
    public void cancel() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.pakdata.xwalk.refactor.XWalkJavascriptResultHandler.2
            @Override // java.lang.Runnable
            public void run() {
                if (XWalkJavascriptResultHandler.this.mBridge != null) {
                    XWalkJavascriptResultHandler.this.mBridge.cancelJsResult(XWalkJavascriptResultHandler.this.mId);
                }
                XWalkJavascriptResultHandler.this.mBridge = null;
            }
        });
    }
}
