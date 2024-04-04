package org.chromium.content.browser.framehost;

import android.graphics.Bitmap;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.NavigationEntry;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.common.ResourceRequestBody;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/framehost/NavigationControllerImpl.class */
class NavigationControllerImpl implements NavigationController {
    private long mNativeNavigationControllerAndroid;

    private native boolean nativeCanGoBack(long j);

    private native boolean nativeCanGoForward(long j);

    private native boolean nativeIsInitialNavigation(long j);

    private native void nativeLoadIfNecessary(long j);

    private native boolean nativeNeedsReload(long j);

    private native void nativeSetNeedsReload(long j);

    private native boolean nativeCanGoToOffset(long j, int i);

    private native void nativeGoBack(long j);

    private native void nativeGoForward(long j);

    private native void nativeGoToOffset(long j, int i);

    private native void nativeGoToNavigationIndex(long j, int i);

    private native void nativeCancelPendingReload(long j);

    private native void nativeContinuePendingReload(long j);

    private native void nativeReload(long j, boolean z);

    private native void nativeReloadBypassingCache(long j, boolean z);

    private native void nativeLoadUrl(long j, String str, int i, int i2, String str2, int i3, int i4, String str3, ResourceRequestBody resourceRequestBody, String str4, String str5, String str6, boolean z, boolean z2, boolean z3);

    private native void nativeClearHistory(long j);

    private native int nativeGetNavigationHistory(long j, Object obj);

    private native void nativeGetDirectedNavigationHistory(long j, NavigationHistory navigationHistory, boolean z, int i);

    private native void nativeClearSslPreferences(long j);

    private native boolean nativeGetUseDesktopUserAgent(long j);

    private native void nativeSetUseDesktopUserAgent(long j, boolean z, boolean z2);

    private native NavigationEntry nativeGetEntryAtIndex(long j, int i);

    private native NavigationEntry nativeGetVisibleEntry(long j);

    private native NavigationEntry nativeGetPendingEntry(long j);

    private native int nativeGetLastCommittedEntryIndex(long j);

    private native boolean nativeRemoveEntryAtIndex(long j, int i);

    private native String nativeGetEntryExtraData(long j, int i, String str);

    private native void nativeSetEntryExtraData(long j, int i, String str, String str2);

    private native boolean nativeIsEntryMarkedToBeSkipped(long j, int i);

    private NavigationControllerImpl(long nativeNavigationControllerAndroid) {
        this.mNativeNavigationControllerAndroid = nativeNavigationControllerAndroid;
    }

    @CalledByNative
    private static NavigationControllerImpl create(long nativeNavigationControllerAndroid) {
        return new NavigationControllerImpl(nativeNavigationControllerAndroid);
    }

    @CalledByNative
    private void destroy() {
        this.mNativeNavigationControllerAndroid = 0L;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean canGoBack() {
        return this.mNativeNavigationControllerAndroid != 0 && nativeCanGoBack(this.mNativeNavigationControllerAndroid);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean canGoForward() {
        return this.mNativeNavigationControllerAndroid != 0 && nativeCanGoForward(this.mNativeNavigationControllerAndroid);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    @VisibleForTesting
    public boolean canGoToOffset(int offset) {
        return this.mNativeNavigationControllerAndroid != 0 && nativeCanGoToOffset(this.mNativeNavigationControllerAndroid, offset);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void goToOffset(int offset) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeGoToOffset(this.mNativeNavigationControllerAndroid, offset);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void goToNavigationIndex(int index) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeGoToNavigationIndex(this.mNativeNavigationControllerAndroid, index);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void goBack() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeGoBack(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void goForward() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeGoForward(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean isInitialNavigation() {
        return this.mNativeNavigationControllerAndroid != 0 && nativeIsInitialNavigation(this.mNativeNavigationControllerAndroid);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void loadIfNecessary() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeLoadIfNecessary(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean needsReload() {
        return this.mNativeNavigationControllerAndroid != 0 && nativeNeedsReload(this.mNativeNavigationControllerAndroid);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void setNeedsReload() {
        nativeSetNeedsReload(this.mNativeNavigationControllerAndroid);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void reload(boolean checkForRepost) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeReload(this.mNativeNavigationControllerAndroid, checkForRepost);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void reloadBypassingCache(boolean checkForRepost) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeReloadBypassingCache(this.mNativeNavigationControllerAndroid, checkForRepost);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void cancelPendingReload() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeCancelPendingReload(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void continuePendingReload() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeContinuePendingReload(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void loadUrl(LoadUrlParams params) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeLoadUrl(this.mNativeNavigationControllerAndroid, params.getUrl(), params.getLoadUrlType(), params.getTransitionType(), params.getReferrer() != null ? params.getReferrer().getUrl() : null, params.getReferrer() != null ? params.getReferrer().getPolicy() : 0, params.getUserAgentOverrideOption(), params.getExtraHeadersString(), params.getPostData(), params.getBaseUrl(), params.getVirtualUrlForDataUrl(), params.getDataUrlAsString(), params.getCanLoadLocalResources(), params.getIsRendererInitiated(), params.getShouldReplaceCurrentEntry());
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void clearHistory() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeClearHistory(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public NavigationHistory getNavigationHistory() {
        if (this.mNativeNavigationControllerAndroid == 0) {
            return null;
        }
        NavigationHistory history = new NavigationHistory();
        int currentIndex = nativeGetNavigationHistory(this.mNativeNavigationControllerAndroid, history);
        history.setCurrentEntryIndex(currentIndex);
        return history;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public NavigationHistory getDirectedNavigationHistory(boolean isForward, int itemLimit) {
        if (this.mNativeNavigationControllerAndroid == 0) {
            return null;
        }
        NavigationHistory history = new NavigationHistory();
        nativeGetDirectedNavigationHistory(this.mNativeNavigationControllerAndroid, history, isForward, itemLimit);
        return history;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void clearSslPreferences() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeClearSslPreferences(this.mNativeNavigationControllerAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean getUseDesktopUserAgent() {
        if (this.mNativeNavigationControllerAndroid == 0) {
            return false;
        }
        return nativeGetUseDesktopUserAgent(this.mNativeNavigationControllerAndroid);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void setUseDesktopUserAgent(boolean override, boolean reloadOnChange) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            nativeSetUseDesktopUserAgent(this.mNativeNavigationControllerAndroid, override, reloadOnChange);
        }
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public NavigationEntry getEntryAtIndex(int index) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            return nativeGetEntryAtIndex(this.mNativeNavigationControllerAndroid, index);
        }
        return null;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public NavigationEntry getVisibleEntry() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            return nativeGetVisibleEntry(this.mNativeNavigationControllerAndroid);
        }
        return null;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public NavigationEntry getPendingEntry() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            return nativeGetPendingEntry(this.mNativeNavigationControllerAndroid);
        }
        return null;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public int getLastCommittedEntryIndex() {
        if (this.mNativeNavigationControllerAndroid != 0) {
            return nativeGetLastCommittedEntryIndex(this.mNativeNavigationControllerAndroid);
        }
        return -1;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean removeEntryAtIndex(int index) {
        if (this.mNativeNavigationControllerAndroid != 0) {
            return nativeRemoveEntryAtIndex(this.mNativeNavigationControllerAndroid, index);
        }
        return false;
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public String getEntryExtraData(int index, String key) {
        if (this.mNativeNavigationControllerAndroid == 0) {
            return null;
        }
        return nativeGetEntryExtraData(this.mNativeNavigationControllerAndroid, index, key);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public void setEntryExtraData(int index, String key, String value) {
        if (this.mNativeNavigationControllerAndroid == 0) {
            return;
        }
        nativeSetEntryExtraData(this.mNativeNavigationControllerAndroid, index, key, value);
    }

    @Override // org.chromium.content_public.browser.NavigationController
    public boolean isEntryMarkedToBeSkipped(int index) {
        if (this.mNativeNavigationControllerAndroid == 0) {
            return false;
        }
        return nativeIsEntryMarkedToBeSkipped(this.mNativeNavigationControllerAndroid, index);
    }

    @CalledByNative
    private static void addToNavigationHistory(Object history, Object navigationEntry) {
        ((NavigationHistory) history).addEntry((NavigationEntry) navigationEntry);
    }

    @CalledByNative
    private static NavigationEntry createNavigationEntry(int index, String url, String virtualUrl, String originalUrl, String referrerUrl, String title, Bitmap favicon, int transition, long timestamp) {
        return new NavigationEntry(index, url, virtualUrl, originalUrl, referrerUrl, title, favicon, transition, timestamp);
    }
}
