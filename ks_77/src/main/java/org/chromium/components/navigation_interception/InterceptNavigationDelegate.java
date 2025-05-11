package org.chromium.components.navigation_interception;

import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/navigation_interception/InterceptNavigationDelegate.class */
public interface InterceptNavigationDelegate {
    @CalledByNative
    boolean shouldIgnoreNavigation(NavigationParams navigationParams);
}
