package com.pakdata.xwalk.refactor;

import org.chromium.components.navigation_interception.NavigationParams;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkNavigationHandler.class */
public interface XWalkNavigationHandler {
    boolean handleNavigation(NavigationParams navigationParams);

    String getFallbackUrl();

    void resetFallbackUrl();
}
