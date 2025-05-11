package org.chromium.content.browser;

import android.content.res.Configuration;
import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.UserData;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/WindowEventObserverManager.class */
public final class WindowEventObserverManager implements DisplayAndroid.DisplayAndroidObserver, UserData {
    private final ObserverList<WindowEventObserver> mWindowEventObservers;
    private WindowAndroid mWindowAndroid;
    private ViewEventSinkImpl mViewEventSink;
    private boolean mAttachedToWindow;
    private int mRotation;
    private float mDipScale;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !WindowEventObserverManager.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/WindowEventObserverManager$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<WindowEventObserverManager> INSTANCE = x$0 -> {
            return new WindowEventObserverManager(x$0);
        };

        private UserDataFactoryLazyHolder() {
        }
    }

    public static WindowEventObserverManager from(WebContents webContents) {
        return (WindowEventObserverManager) ((WebContentsImpl) webContents).getOrSetUserData(WindowEventObserverManager.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    private WindowEventObserverManager(WebContents webContents) {
        this.mWindowEventObservers = new ObserverList<>();
        this.mViewEventSink = ViewEventSinkImpl.from(webContents);
        WindowAndroid window = webContents.getTopLevelNativeWindow();
        if (window != null) {
            onWindowAndroidChanged(window);
        }
        addObserver((WebContentsImpl) webContents);
    }

    public void addObserver(WindowEventObserver observer) {
        if (!$assertionsDisabled && this.mWindowEventObservers.hasObserver(observer)) {
            throw new AssertionError();
        }
        this.mWindowEventObservers.addObserver(observer);
        if (this.mAttachedToWindow) {
            observer.onAttachedToWindow();
        }
    }

    public void removeObserver(WindowEventObserver observer) {
        if (!$assertionsDisabled && !this.mWindowEventObservers.hasObserver(observer)) {
            throw new AssertionError();
        }
        this.mWindowEventObservers.removeObserver(observer);
    }

    public void onAttachedToWindow() {
        this.mAttachedToWindow = true;
        addUiObservers();
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onAttachedToWindow();
        }
    }

    public void onDetachedFromWindow() {
        removeUiObservers();
        this.mAttachedToWindow = false;
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onDetachedFromWindow();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onWindowFocusChanged(hasWindowFocus);
        }
    }

    public void onWindowAndroidChanged(WindowAndroid windowAndroid) {
        if (windowAndroid == this.mWindowAndroid) {
            return;
        }
        removeUiObservers();
        this.mWindowAndroid = windowAndroid;
        addUiObservers();
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onWindowAndroidChanged(windowAndroid);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onConfigurationChanged(newConfig);
        }
    }

    public void onViewFocusChanged(boolean gainFocus, boolean hideKeyboardOnBlur) {
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onViewFocusChanged(gainFocus, hideKeyboardOnBlur);
        }
    }

    private void addDisplayAndroidObserverIfNeeded() {
        if (!this.mAttachedToWindow || this.mWindowAndroid == null) {
            return;
        }
        DisplayAndroid display = this.mWindowAndroid.getDisplay();
        display.addObserver(this);
        onRotationChanged(display.getRotation());
        onDIPScaleChanged(display.getDipScale());
    }

    private void addActivityStateObserver() {
        if (!this.mAttachedToWindow || this.mWindowAndroid == null) {
            return;
        }
        this.mWindowAndroid.addActivityStateObserver(this.mViewEventSink);
        if (this.mWindowAndroid.getActivityState() == 3) {
            this.mViewEventSink.onActivityResumed();
        }
    }

    private void addUiObservers() {
        addDisplayAndroidObserverIfNeeded();
        addActivityStateObserver();
    }

    private void removeUiObservers() {
        removeDisplayAndroidObserver();
        removeActivityStateObserver();
    }

    private void removeDisplayAndroidObserver() {
        if (this.mWindowAndroid == null) {
            return;
        }
        this.mWindowAndroid.getDisplay().removeObserver(this);
    }

    private void removeActivityStateObserver() {
        if (!this.mAttachedToWindow || this.mWindowAndroid == null) {
            return;
        }
        this.mWindowAndroid.removeActivityStateObserver(this.mViewEventSink);
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    public void onRotationChanged(int rotation) {
        if (this.mRotation == rotation) {
            return;
        }
        this.mRotation = rotation;
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onRotationChanged(rotation);
        }
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    public void onDIPScaleChanged(float dipScale) {
        if (this.mDipScale == dipScale) {
            return;
        }
        this.mDipScale = dipScale;
        Iterator<WindowEventObserver> it = this.mWindowEventObservers.iterator();
        while (it.hasNext()) {
            WindowEventObserver observer = it.next();
            observer.onDIPScaleChanged(dipScale);
        }
    }
}
