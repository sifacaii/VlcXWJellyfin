package org.chromium.content.browser;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.base.UserData;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.EventForwarder;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentUiEventHandler.class */
public class ContentUiEventHandler implements UserData {
    private final WebContentsImpl mWebContents;
    private ViewEventSink.InternalAccessDelegate mEventDelegate;
    private long mNativeContentUiEventHandler;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native long nativeInit(WebContents webContents);

    private native void nativeSendMouseWheelEvent(long j, long j2, float f, float f2, float f3, float f4);

    private native void nativeSendMouseEvent(long j, long j2, int i, float f, float f2, int i2, float f3, float f4, float f5, int i3, int i4, int i5, int i6);

    private native void nativeSendScrollEvent(long j, long j2, float f, float f2);

    private native void nativeCancelFling(long j, long j2);

    static {
        $assertionsDisabled = !ContentUiEventHandler.class.desiredAssertionStatus();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentUiEventHandler$UserDataFactoryLazyHolder.class */
    private static final class UserDataFactoryLazyHolder {
        private static final WebContentsImpl.UserDataFactory<ContentUiEventHandler> INSTANCE = ContentUiEventHandler::new;

        private UserDataFactoryLazyHolder() {
        }
    }

    public static ContentUiEventHandler fromWebContents(WebContents webContents) {
        return (ContentUiEventHandler) ((WebContentsImpl) webContents).getOrSetUserData(ContentUiEventHandler.class, UserDataFactoryLazyHolder.INSTANCE);
    }

    public ContentUiEventHandler(WebContents webContents) {
        this.mWebContents = (WebContentsImpl) webContents;
        this.mNativeContentUiEventHandler = nativeInit(webContents);
    }

    public void setEventDelegate(ViewEventSink.InternalAccessDelegate delegate) {
        this.mEventDelegate = delegate;
    }

    private EventForwarder getEventForwarder() {
        return this.mWebContents.getEventForwarder();
    }

    private float getEventSourceScaling() {
        return this.mWebContents.getTopLevelNativeWindow().getDisplay().getAndroidUIScaling();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @CalledByNative
    private boolean onGenericMotionEvent(MotionEvent event) {
        if (Gamepad.from(this.mWebContents).onGenericMotionEvent(event) || JoystickHandler.fromWebContents(this.mWebContents).onGenericMotionEvent(event)) {
            return true;
        }
        if ((event.getSource() & 2) != 0) {
            switch (event.getActionMasked()) {
                case 8:
                    onMouseWheelEvent(event);
                    return true;
                case 11:
                case 12:
                    if (event.getToolType(0) == 3) {
                        return onMouseEvent(event);
                    }
                    break;
            }
        }
        return this.mEventDelegate.super_onGenericMotionEvent(event);
    }

    private void onMouseWheelEvent(MotionEvent event) {
        if (!$assertionsDisabled && this.mNativeContentUiEventHandler == 0) {
            throw new AssertionError();
        }
        float scale = getEventSourceScaling();
        nativeSendMouseWheelEvent(this.mNativeContentUiEventHandler, event.getEventTime(), event.getX() / scale, event.getY() / scale, event.getAxisValue(10), event.getAxisValue(9));
    }

    private boolean onMouseEvent(MotionEvent event) {
        if ($assertionsDisabled || this.mNativeContentUiEventHandler != 0) {
            EventForwarder eventForwarder = this.mWebContents.getEventForwarder();
            boolean didOffsetEvent = false;
            MotionEvent newEvent = eventForwarder.createOffsetMotionEventIfNeeded(event);
            if (newEvent != event) {
                didOffsetEvent = true;
                event = newEvent;
            }
            float scale = getEventSourceScaling();
            nativeSendMouseEvent(this.mNativeContentUiEventHandler, event.getEventTime(), event.getActionMasked(), event.getX() / scale, event.getY() / scale, event.getPointerId(0), event.getPressure(0), event.getOrientation(0), event.getAxisValue(25, 0), EventForwarder.getMouseEventActionButton(event), event.getButtonState(), event.getMetaState(), event.getToolType(0));
            if (didOffsetEvent) {
                event.recycle();
                return true;
            }
            return true;
        }
        throw new AssertionError();
    }

    @CalledByNative
    private boolean onKeyUp(int keyCode, KeyEvent event) {
        return this.mEventDelegate.super_onKeyUp(keyCode, event);
    }

    @CalledByNative
    private boolean dispatchKeyEvent(KeyEvent event) {
        if (Gamepad.from(this.mWebContents).dispatchKeyEvent(event)) {
            return true;
        }
        if (!shouldPropagateKeyEvent(event)) {
            return this.mEventDelegate.super_dispatchKeyEvent(event);
        }
        if (ImeAdapterImpl.fromWebContents((WebContents) this.mWebContents).dispatchKeyEvent(event)) {
            return true;
        }
        return this.mEventDelegate.super_dispatchKeyEvent(event);
    }

    private static boolean shouldPropagateKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == 82 || keyCode == 3 || keyCode == 4 || keyCode == 5 || keyCode == 6 || keyCode == 26 || keyCode == 79 || keyCode == 27 || keyCode == 80 || keyCode == 25 || keyCode == 164 || keyCode == 24) {
            return false;
        }
        return true;
    }

    @CalledByNative
    private void scrollBy(float dxPix, float dyPix) {
        if (dxPix == 0.0f && dyPix == 0.0f) {
            return;
        }
        long time = SystemClock.uptimeMillis();
        if (GestureListenerManagerImpl.fromWebContents((WebContents) this.mWebContents).hasActiveFlingScroll()) {
            nativeCancelFling(this.mNativeContentUiEventHandler, time);
        }
        nativeSendScrollEvent(this.mNativeContentUiEventHandler, time, dxPix, dyPix);
    }

    @CalledByNative
    private void scrollTo(float xPix, float yPix) {
        float xCurrentPix = this.mWebContents.getRenderCoordinates().getScrollXPix();
        float yCurrentPix = this.mWebContents.getRenderCoordinates().getScrollYPix();
        float dxPix = xPix - xCurrentPix;
        float dyPix = yPix - yCurrentPix;
        scrollBy(dxPix, dyPix);
    }
}
