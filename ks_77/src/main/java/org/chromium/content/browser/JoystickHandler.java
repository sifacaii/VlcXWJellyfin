package org.chromium.content.browser;

import android.view.MotionEvent;
import org.chromium.base.UserData;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ImeEventObserver;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.EventForwarder;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/JoystickHandler.class */
public class JoystickHandler implements ImeEventObserver, UserData {
    private final EventForwarder mEventForwarder;
    private boolean mScrollEnabled;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/JoystickHandler$UserDataFactoryLazyHolder.class */
    public static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<JoystickHandler> INSTANCE = x$0 -> {
            return new JoystickHandler(x$0);
        };

        private UserDataFactoryLazyHolder() {
        }
    }

    public static JoystickHandler fromWebContents(WebContents webContents) {
        return (JoystickHandler) ((WebContentsImpl) webContents).getOrSetUserData(JoystickHandler.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    private JoystickHandler(WebContents webContents) {
        this.mScrollEnabled = true;
        this.mEventForwarder = webContents.getEventForwarder();
        ImeAdapterImpl.fromWebContents(webContents).addEventObserver(this);
    }

    public void setScrollEnabled(boolean enabled) {
        this.mScrollEnabled = enabled;
    }

    @Override // org.chromium.content_public.browser.ImeEventObserver
    public void onNodeAttributeUpdated(boolean editable, boolean password) {
        setScrollEnabled(!editable);
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        if (!this.mScrollEnabled || (event.getSource() & 16) == 0) {
            return false;
        }
        float velocityX = getVelocityFromJoystickAxis(event, 0);
        float velocityY = getVelocityFromJoystickAxis(event, 1);
        if (velocityX == 0.0f && velocityY == 0.0f) {
            return false;
        }
        this.mEventForwarder.startFling(event.getEventTime(), velocityX, velocityY, true, true);
        return true;
    }

    private static float getVelocityFromJoystickAxis(MotionEvent event, int axis) {
        float axisValWithNoise = event.getAxisValue(axis);
        if (Math.abs(axisValWithNoise) <= 0.2f) {
            return 0.0f;
        }
        return -axisValWithNoise;
    }
}
