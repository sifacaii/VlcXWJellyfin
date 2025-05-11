package org.chromium.components.navigation_interception;

import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/navigation_interception/NavigationParams.class */
public class NavigationParams {
    public final String url;
    public final String referrer;
    public final boolean isPost;
    public final boolean hasUserGesture;
    public final int pageTransitionType;
    public final boolean isRedirect;
    public final boolean isExternalProtocol;
    public final boolean hasUserGestureCarryover;
    public final boolean isMainFrame;
    public final boolean isRendererInitiated;

    public NavigationParams(String url, String referrer, boolean isPost, boolean hasUserGesture, int pageTransitionType, boolean isRedirect, boolean isExternalProtocol, boolean isMainFrame, boolean isRendererInitiated, boolean hasUserGestureCarryover) {
        this.url = url;
        this.referrer = TextUtils.isEmpty(referrer) ? null : referrer;
        this.isPost = isPost;
        this.hasUserGesture = hasUserGesture;
        this.pageTransitionType = pageTransitionType;
        this.isRedirect = isRedirect;
        this.isExternalProtocol = isExternalProtocol;
        this.isMainFrame = isMainFrame;
        this.isRendererInitiated = isRendererInitiated;
        this.hasUserGestureCarryover = hasUserGestureCarryover;
    }

    @CalledByNative
    public static NavigationParams create(String url, String referrer, boolean isPost, boolean hasUserGesture, int pageTransitionType, boolean isRedirect, boolean isExternalProtocol, boolean isMainFrame, boolean isRendererInitiated, boolean hasUserGestureCarryover) {
        return new NavigationParams(url, referrer, isPost, hasUserGesture, pageTransitionType, isRedirect, isExternalProtocol, isMainFrame, isRendererInitiated, hasUserGestureCarryover);
    }
}
