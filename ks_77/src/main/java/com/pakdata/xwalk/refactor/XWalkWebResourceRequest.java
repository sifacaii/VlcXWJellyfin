package com.pakdata.xwalk.refactor;

import android.net.Uri;
import java.util.Map;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkWebResourceRequest.class */
public interface XWalkWebResourceRequest {
    Uri getUrl();

    boolean isForMainFrame();

    boolean hasGesture();

    String getMethod();

    Map<String, String> getRequestHeaders();
}
