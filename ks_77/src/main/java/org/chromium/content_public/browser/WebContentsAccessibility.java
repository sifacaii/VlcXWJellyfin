package org.chromium.content_public.browser;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeProvider;
import org.chromium.base.VisibleForTesting;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/WebContentsAccessibility.class */
public interface WebContentsAccessibility {
    boolean supportsAction(int i);

    boolean isAccessibilityEnabled();

    @VisibleForTesting
    void setAccessibilityEnabledForTesting();

    boolean performAction(int i, Bundle bundle);

    AccessibilityNodeProvider getAccessibilityNodeProvider();

    @TargetApi(23)
    void onProvideVirtualStructure(ViewStructure viewStructure, boolean z);

    void setObscuredByAnotherView(boolean z);

    boolean isTouchExplorationEnabled();

    void setState(boolean z);

    void setShouldFocusOnPageLoad(boolean z);

    void onAutofillPopupDisplayed(View view);

    void onAutofillPopupDismissed();

    void onAutofillPopupAccessibilityFocusCleared();

    static WebContentsAccessibility fromWebContents(WebContents webContents) {
        return WebContentsAccessibilityImpl.fromWebContents(webContents);
    }
}
