package org.chromium.content.browser;

import android.content.res.Configuration;
import org.chromium.base.TraceEvent;
import org.chromium.base.UserData;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ViewEventSinkImpl.class */
public final class ViewEventSinkImpl implements ViewEventSink, WindowAndroid.ActivityStateObserver, UserData {
    private final WebContentsImpl mWebContents;
    private Boolean mHasViewFocus;
    private boolean mPaused;
    private Boolean mHasInputFocus;
    private boolean mHideKeyboardOnBlur;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ViewEventSinkImpl$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<ViewEventSinkImpl> INSTANCE = ViewEventSinkImpl::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static ViewEventSinkImpl from(WebContents webContents) {
        return (ViewEventSinkImpl) ((WebContentsImpl) webContents).getOrSetUserData(ViewEventSinkImpl.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    public ViewEventSinkImpl(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void setAccessDelegate(ViewEventSink.InternalAccessDelegate accessDelegate) {
        GestureListenerManagerImpl.fromWebContents((WebContents) this.mWebContents).setScrollDelegate(accessDelegate);
        ContentUiEventHandler.fromWebContents(this.mWebContents).setEventDelegate(accessDelegate);
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onAttachedToWindow() {
        WindowEventObserverManager.from(this.mWebContents).onAttachedToWindow();
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onDetachedFromWindow() {
        WindowEventObserverManager.from(this.mWebContents).onDetachedFromWindow();
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        WindowEventObserverManager.from(this.mWebContents).onWindowFocusChanged(hasWindowFocus);
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onViewFocusChanged(boolean gainFocus) {
        if (this.mHasViewFocus == null || this.mHasViewFocus.booleanValue() != gainFocus) {
            this.mHasViewFocus = Boolean.valueOf(gainFocus);
            onFocusChanged();
        }
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void setHideKeyboardOnBlur(boolean hideKeyboardOnBlur) {
        this.mHideKeyboardOnBlur = hideKeyboardOnBlur;
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onConfigurationChanged(Configuration newConfig) {
        try {
            TraceEvent.begin("ViewEventSink.onConfigurationChanged");
            WindowEventObserverManager.from(this.mWebContents).onConfigurationChanged(newConfig);
            ViewAndroidDelegate delegate = this.mWebContents.getViewAndroidDelegate();
            if (delegate != null) {
                delegate.getContainerView().requestLayout();
            }
            TraceEvent.end("ViewEventSink.onConfigurationChanged");
        } catch (Throwable th) {
            TraceEvent.end("ViewEventSink.onConfigurationChanged");
            throw th;
        }
    }

    private void onFocusChanged() {
        if (this.mHasViewFocus == null) {
            return;
        }
        boolean hasInputFocus = this.mHasViewFocus.booleanValue() && !this.mPaused;
        if (this.mHasInputFocus == null || this.mHasInputFocus.booleanValue() != hasInputFocus) {
            this.mHasInputFocus = Boolean.valueOf(hasInputFocus);
            if (this.mWebContents == null) {
                return;
            }
            WindowEventObserverManager.from(this.mWebContents).onViewFocusChanged(this.mHasInputFocus.booleanValue(), this.mHideKeyboardOnBlur);
            this.mWebContents.setFocus(this.mHasInputFocus.booleanValue());
        }
    }

    @Override // org.chromium.ui.base.WindowAndroid.ActivityStateObserver
    public void onActivityPaused() {
        if (this.mPaused) {
            return;
        }
        this.mPaused = true;
        onFocusChanged();
    }

    @Override // org.chromium.ui.base.WindowAndroid.ActivityStateObserver
    public void onActivityResumed() {
        if (this.mPaused) {
            this.mPaused = false;
            onFocusChanged();
        }
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onPauseForTesting() {
        onActivityPaused();
    }

    @Override // org.chromium.content_public.browser.ViewEventSink
    public void onResumeForTesting() {
        onActivityResumed();
    }
}
