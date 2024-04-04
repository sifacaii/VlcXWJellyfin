package org.chromium.content.browser;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.base.UserData;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.WebContents;
import org.chromium.device.gamepad.GamepadList;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/Gamepad.class */
class Gamepad implements WindowEventObserver, UserData {
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/Gamepad$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<Gamepad> INSTANCE = Gamepad::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static Gamepad from(WebContents webContents) {
        return (Gamepad) ((WebContentsImpl) webContents).getOrSetUserData(Gamepad.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    public Gamepad(WebContents webContents) {
        this.mContext = ((WebContentsImpl) webContents).getContext();
        WindowEventObserverManager.from(webContents).addObserver(this);
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onAttachedToWindow() {
        GamepadList.onAttachedToWindow(this.mContext);
    }

    @Override // org.chromium.content.browser.WindowEventObserver
    public void onDetachedFromWindow() {
        GamepadList.onDetachedFromWindow();
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        return GamepadList.onGenericMotionEvent(event);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return GamepadList.dispatchKeyEvent(event);
    }
}
