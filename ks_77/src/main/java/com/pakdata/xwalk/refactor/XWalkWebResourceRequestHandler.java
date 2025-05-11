package com.pakdata.xwalk.refactor;

import android.net.Uri;
import com.pakdata.xwalk.refactor.XWalkContentsClient;
import java.util.Map;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkWebResourceRequestHandler.class */
public class XWalkWebResourceRequestHandler implements XWalkWebResourceRequest {
    private final XWalkContentsClient.XWalkWebResourceRequest mRequest;

    XWalkWebResourceRequestHandler() {
        this.mRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XWalkWebResourceRequestHandler(XWalkContentsClient.XWalkWebResourceRequest request) {
        this.mRequest = request;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkWebResourceRequest
    public Uri getUrl() {
        return Uri.parse(this.mRequest.url);
    }

    @Override // com.pakdata.xwalk.refactor.XWalkWebResourceRequest
    public boolean isForMainFrame() {
        return this.mRequest.isMainFrame;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkWebResourceRequest
    public boolean hasGesture() {
        return this.mRequest.hasUserGesture;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkWebResourceRequest
    public String getMethod() {
        return this.mRequest.method;
    }

    @Override // com.pakdata.xwalk.refactor.XWalkWebResourceRequest
    public Map<String, String> getRequestHeaders() {
        return this.mRequest.requestHeaders;
    }
}
