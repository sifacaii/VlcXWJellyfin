package org.chromium.content_public.browser;

import androidx.annotation.Nullable;
import org.chromium.base.VisibleForTesting;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/NavigationController.class */
public interface NavigationController {
    boolean canGoBack();

    boolean canGoForward();

    boolean canGoToOffset(int i);

    void goToOffset(int i);

    void goToNavigationIndex(int i);

    void goBack();

    void goForward();

    boolean isInitialNavigation();

    void loadIfNecessary();

    boolean needsReload();

    void setNeedsReload();

    void reload(boolean z);

    void reloadBypassingCache(boolean z);

    void cancelPendingReload();

    void continuePendingReload();

    void loadUrl(LoadUrlParams loadUrlParams);

    void clearHistory();

    NavigationHistory getNavigationHistory();

    NavigationHistory getDirectedNavigationHistory(boolean z, int i);

    void clearSslPreferences();

    boolean getUseDesktopUserAgent();

    void setUseDesktopUserAgent(boolean z, boolean z2);

    @VisibleForTesting
    NavigationEntry getEntryAtIndex(int i);

    @Nullable
    NavigationEntry getVisibleEntry();

    NavigationEntry getPendingEntry();

    int getLastCommittedEntryIndex();

    boolean removeEntryAtIndex(int i);

    String getEntryExtraData(int i, String str);

    void setEntryExtraData(int i, String str, String str2);

    boolean isEntryMarkedToBeSkipped(int i);
}
