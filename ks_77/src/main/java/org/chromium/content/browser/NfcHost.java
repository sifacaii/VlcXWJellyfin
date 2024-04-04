package org.chromium.content.browser;

import android.app.Activity;
import android.util.SparseArray;
import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/NfcHost.class */
class NfcHost extends WebContentsObserver implements WindowEventObserver {
    private static final SparseArray<NfcHost> sContextHostsMap;
    private final WebContents mWebContents;
    private final int mContextId;
    private Callback<Activity> mCallback;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !NfcHost.class.desiredAssertionStatus();
        sContextHostsMap = new SparseArray<>();
    }

    public static NfcHost fromContextId(int contextId) {
        return sContextHostsMap.get(contextId);
    }

    @CalledByNative
    private static NfcHost create(WebContents webContents, int contextId) {
        return new NfcHost(webContents, contextId);
    }

    NfcHost(WebContents webContents, int contextId) {
        super(webContents);
        this.mWebContents = webContents;
        if (!$assertionsDisabled && WindowEventObserverManager.from(this.mWebContents) == null) {
            throw new AssertionError();
        }
        this.mContextId = contextId;
        sContextHostsMap.put(this.mContextId, this);
    }

    public void trackActivityChanges(Callback<Activity> callback) {
        if (!$assertionsDisabled && this.mCallback != null) {
            throw new AssertionError("Unexpected request to track activity changes");
        }
        this.mCallback = callback;
        WindowEventObserverManager.from(this.mWebContents).addObserver(this);
        WindowAndroid window = this.mWebContents.getTopLevelNativeWindow();
        this.mCallback.onResult(window != null ? window.getActivity().get() : null);
    }

    public void stopTrackingActivityChanges() {
        this.mCallback = null;
        WindowEventObserverManager.from(this.mWebContents).removeObserver(this);
    }

    @Override // org.chromium.content_public.browser.WebContentsObserver
    public void destroy() {
        stopTrackingActivityChanges();
        sContextHostsMap.remove(this.mContextId);
        super.destroy();
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onWindowAndroidChanged(WindowAndroid newWindowAndroid) {
        Activity activity = null;
        if (newWindowAndroid != null) {
            activity = newWindowAndroid.getActivity().get();
        }
        if (!$assertionsDisabled && this.mCallback == null) {
            throw new AssertionError("should have callback");
        }
        this.mCallback.onResult(activity);
    }
}
