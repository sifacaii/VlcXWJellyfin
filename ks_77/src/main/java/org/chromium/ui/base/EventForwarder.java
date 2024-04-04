package org.chromium.ui.base;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import org.chromium.base.TraceEvent;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/EventForwarder.class */
public class EventForwarder {
    private final boolean mIsDragDropEnabled;
    private long mNativeEventForwarder;
    private float mCurrentTouchOffsetX;
    private float mCurrentTouchOffsetY;
    private int mLastMouseButtonState;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native WindowAndroid nativeGetJavaWindowAndroid(long j);

    private native boolean nativeOnTouchEvent(long j, MotionEvent motionEvent, long j2, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, int i5, int i6, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, int i7, int i8, int i9, int i10, boolean z);

    private native void nativeOnMouseEvent(long j, long j2, int i, float f, float f2, int i2, float f3, float f4, float f5, int i3, int i4, int i5, int i6);

    private native void nativeOnDragEvent(long j, int i, int i2, int i3, int i4, int i5, String[] strArr, String str);

    private native boolean nativeOnGestureEvent(long j, int i, long j2, float f);

    private native boolean nativeOnGenericMotionEvent(long j, MotionEvent motionEvent, long j2);

    private native boolean nativeOnKeyUp(long j, KeyEvent keyEvent, int i);

    private native boolean nativeDispatchKeyEvent(long j, KeyEvent keyEvent);

    private native void nativeScrollBy(long j, float f, float f2);

    private native void nativeScrollTo(long j, float f, float f2);

    private native void nativeDoubleTap(long j, long j2, int i, int i2);

    private native void nativeStartFling(long j, long j2, float f, float f2, boolean z, boolean z2);

    private native void nativeCancelFling(long j, long j2, boolean z);

    static {
        $assertionsDisabled = !EventForwarder.class.desiredAssertionStatus();
    }

    @CalledByNative
    private static EventForwarder create(long nativeEventForwarder, boolean isDragDropEnabled) {
        return new EventForwarder(nativeEventForwarder, isDragDropEnabled);
    }

    private EventForwarder(long nativeEventForwarder, boolean isDragDropEnabled) {
        this.mNativeEventForwarder = nativeEventForwarder;
        this.mIsDragDropEnabled = isDragDropEnabled;
    }

    @CalledByNative
    private void destroy() {
        this.mNativeEventForwarder = 0L;
    }

    private float getEventSourceScaling() {
        return nativeGetJavaWindowAndroid(this.mNativeEventForwarder).getDisplay().getAndroidUIScaling();
    }

    private boolean hasTouchEventOffset() {
        return (this.mCurrentTouchOffsetX == 0.0f && this.mCurrentTouchOffsetY == 0.0f) ? false : true;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getToolType(0) == 3) {
            int apiVersion = Build.VERSION.SDK_INT;
            boolean isTouchpadScroll = event.getButtonState() == 0 && (event.getActionMasked() == 0 || event.getActionMasked() == 2 || event.getActionMasked() == 1);
            if (apiVersion >= 23 && !isTouchpadScroll) {
                return onMouseEvent(event);
            }
        }
        return sendTouchEvent(event, false);
    }

    public boolean onTouchHandleEvent(MotionEvent event) {
        return sendTouchEvent(event, true);
    }

    private boolean sendTouchEvent(MotionEvent event, boolean isTouchHandleEvent) {
        long eventTime;
        if ($assertionsDisabled || this.mNativeEventForwarder != 0) {
            TraceEvent.begin("sendTouchEvent");
            try {
                if (event.getHistorySize() > 0) {
                    eventTime = event.getHistoricalEventTime(0);
                } else {
                    eventTime = event.getEventTime();
                }
                long oldestEventTime = eventTime;
                int eventAction = SPenSupport.convertSPenEventAction(event.getActionMasked());
                if (isValidTouchEventActionForNative(eventAction)) {
                    boolean didOffsetEvent = false;
                    if (hasTouchEventOffset()) {
                        event = createOffsetMotionEventIfNeeded(event);
                        didOffsetEvent = true;
                    }
                    int pointerCount = event.getPointerCount();
                    float[] touchMajor = new float[2];
                    touchMajor[0] = event.getTouchMajor();
                    touchMajor[1] = pointerCount > 1 ? event.getTouchMajor(1) : 0.0f;
                    float[] touchMinor = new float[2];
                    touchMinor[0] = event.getTouchMinor();
                    touchMinor[1] = pointerCount > 1 ? event.getTouchMinor(1) : 0.0f;
                    for (int i = 0; i < 2; i++) {
                        if (touchMajor[i] < touchMinor[i]) {
                            float tmp = touchMajor[i];
                            touchMajor[i] = touchMinor[i];
                            touchMinor[i] = tmp;
                        }
                    }
                    float secondPointerX = pointerCount > 1 ? event.getX(1) : 0.0f;
                    float secondPointerY = pointerCount > 1 ? event.getY(1) : 0.0f;
                    float scale = getEventSourceScaling();
                    boolean consumed = nativeOnTouchEvent(this.mNativeEventForwarder, event, oldestEventTime, eventAction, pointerCount, event.getHistorySize(), event.getActionIndex(), event.getX() / scale, event.getY() / scale, secondPointerX / scale, secondPointerY / scale, event.getPointerId(0), pointerCount > 1 ? event.getPointerId(1) : -1, touchMajor[0] / scale, touchMajor[1] / scale, touchMinor[0] / scale, touchMinor[1] / scale, event.getOrientation(), pointerCount > 1 ? event.getOrientation(1) : 0.0f, event.getAxisValue(25), pointerCount > 1 ? event.getAxisValue(25, 1) : 0.0f, event.getRawX() / scale, event.getRawY() / scale, event.getToolType(0), pointerCount > 1 ? event.getToolType(1) : 0, event.getButtonState(), event.getMetaState(), isTouchHandleEvent);
                    if (didOffsetEvent) {
                        event.recycle();
                    }
                    TraceEvent.end("sendTouchEvent");
                    return consumed;
                }
                return false;
            } finally {
                TraceEvent.end("sendTouchEvent");
            }
        }
        throw new AssertionError();
    }

    public void setCurrentTouchEventOffsets(float dx, float dy) {
        this.mCurrentTouchOffsetX = dx;
        this.mCurrentTouchOffsetY = dy;
    }

    public MotionEvent createOffsetMotionEventIfNeeded(MotionEvent src) {
        if (hasTouchEventOffset()) {
            MotionEvent dst = MotionEvent.obtain(src);
            dst.offsetLocation(this.mCurrentTouchOffsetX, this.mCurrentTouchOffsetY);
            return dst;
        }
        return src;
    }

    private static boolean isValidTouchEventActionForNative(int eventAction) {
        return eventAction == 0 || eventAction == 1 || eventAction == 3 || eventAction == 2 || eventAction == 5 || eventAction == 6;
    }

    public boolean onHoverEvent(MotionEvent event) {
        TraceEvent.begin("onHoverEvent");
        boolean didOffsetEvent = false;
        try {
            if (hasTouchEventOffset()) {
                event = createOffsetMotionEventIfNeeded(event);
                didOffsetEvent = true;
            }
            int eventAction = event.getActionMasked();
            if (eventAction == 9) {
                if (this.mLastMouseButtonState == 1) {
                    float scale = getEventSourceScaling();
                    nativeOnMouseEvent(this.mNativeEventForwarder, event.getEventTime(), 12, event.getX() / scale, event.getY() / scale, event.getPointerId(0), event.getPressure(0), event.getOrientation(0), event.getAxisValue(25, 0), 1, event.getButtonState(), event.getMetaState(), event.getToolType(0));
                }
                this.mLastMouseButtonState = 0;
            }
            boolean sendNativeMouseEvent = sendNativeMouseEvent(event);
            if (didOffsetEvent) {
                event.recycle();
            }
            TraceEvent.end("onHoverEvent");
            return sendNativeMouseEvent;
        } catch (Throwable th) {
            if (didOffsetEvent) {
                event.recycle();
            }
            TraceEvent.end("onHoverEvent");
            throw th;
        }
    }

    public boolean onMouseEvent(MotionEvent event) {
        TraceEvent.begin("sendMouseEvent");
        boolean didOffsetEvent = false;
        try {
            if (hasTouchEventOffset()) {
                event = createOffsetMotionEventIfNeeded(event);
                didOffsetEvent = true;
            }
            updateMouseEventState(event);
            boolean sendNativeMouseEvent = sendNativeMouseEvent(event);
            if (didOffsetEvent) {
                event.recycle();
            }
            TraceEvent.end("sendMouseEvent");
            return sendNativeMouseEvent;
        } catch (Throwable th) {
            if (didOffsetEvent) {
                event.recycle();
            }
            TraceEvent.end("sendMouseEvent");
            throw th;
        }
    }

    private boolean sendNativeMouseEvent(MotionEvent event) {
        if ($assertionsDisabled || this.mNativeEventForwarder != 0) {
            int eventAction = event.getActionMasked();
            if (eventAction == 9 || eventAction == 10) {
                return false;
            }
            if (eventAction == 0 || eventAction == 1) {
                return true;
            }
            float scale = getEventSourceScaling();
            nativeOnMouseEvent(this.mNativeEventForwarder, event.getEventTime(), eventAction, event.getX() / scale, event.getY() / scale, event.getPointerId(0), event.getPressure(0), event.getOrientation(0), event.getAxisValue(25, 0), getMouseEventActionButton(event), event.getButtonState(), event.getMetaState(), event.getToolType(0));
            return true;
        }
        throw new AssertionError();
    }

    private void updateMouseEventState(MotionEvent event) {
        int eventAction = event.getActionMasked();
        if (eventAction == 11 || eventAction == 12) {
            this.mLastMouseButtonState = event.getButtonState();
        }
    }

    @TargetApi(23)
    public static int getMouseEventActionButton(MotionEvent event) {
        if (Build.VERSION.SDK_INT >= 23) {
            return event.getActionButton();
        }
        return 0;
    }

    @TargetApi(24)
    public boolean onDragEvent(DragEvent event, View containerView) {
        if (this.mNativeEventForwarder == 0 || Build.VERSION.SDK_INT <= 23) {
            return false;
        }
        ClipDescription clipDescription = event.getClipDescription();
        String[] mimeTypes = clipDescription == null ? new String[0] : clipDescription.filterMimeTypes("text/*");
        if (event.getAction() == 1) {
            return mimeTypes != null && mimeTypes.length > 0 && this.mIsDragDropEnabled;
        }
        StringBuilder content = new StringBuilder(CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE);
        if (event.getAction() == 3) {
            ClipData clipData = event.getClipData();
            int itemCount = clipData.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                ClipData.Item item = clipData.getItemAt(i);
                content.append(item.coerceToStyledText(containerView.getContext()));
            }
        }
        int[] locationOnScreen = new int[2];
        containerView.getLocationOnScreen(locationOnScreen);
        int x = (int) (event.getX() + this.mCurrentTouchOffsetX);
        int y = (int) (event.getY() + this.mCurrentTouchOffsetY);
        int screenX = x + locationOnScreen[0];
        int screenY = y + locationOnScreen[1];
        float scale = getEventSourceScaling();
        nativeOnDragEvent(this.mNativeEventForwarder, event.getAction(), (int) (x / scale), (int) (y / scale), (int) (screenX / scale), (int) (screenY / scale), mimeTypes, content.toString());
        return true;
    }

    public boolean onGestureEvent(int type, long timeMs, float delta) {
        if (this.mNativeEventForwarder == 0) {
            return false;
        }
        return nativeOnGestureEvent(this.mNativeEventForwarder, type, timeMs, delta);
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        if (this.mNativeEventForwarder == 0) {
            return false;
        }
        if ((event.getSource() & 2) != 0 && event.getToolType(0) == 3) {
            updateMouseEventState(event);
        }
        return nativeOnGenericMotionEvent(this.mNativeEventForwarder, event, event.getEventTime());
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.mNativeEventForwarder == 0) {
            return false;
        }
        return nativeOnKeyUp(this.mNativeEventForwarder, event, keyCode);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (this.mNativeEventForwarder == 0) {
            return false;
        }
        return nativeDispatchKeyEvent(this.mNativeEventForwarder, event);
    }

    public void scrollBy(float dxPix, float dyPix) {
        if (this.mNativeEventForwarder == 0) {
            return;
        }
        nativeScrollBy(this.mNativeEventForwarder, dxPix, dyPix);
    }

    public void scrollTo(float xPix, float yPix) {
        if (this.mNativeEventForwarder == 0) {
            return;
        }
        nativeScrollTo(this.mNativeEventForwarder, xPix, yPix);
    }

    @VisibleForTesting
    public void doubleTapForTest(long timeMs, int x, int y) {
        if (this.mNativeEventForwarder == 0) {
            return;
        }
        nativeDoubleTap(this.mNativeEventForwarder, timeMs, x, y);
    }

    public void startFling(long timeMs, float velocityX, float velocityY, boolean syntheticScroll, boolean preventBoosting) {
        if (this.mNativeEventForwarder == 0) {
            return;
        }
        nativeStartFling(this.mNativeEventForwarder, timeMs, velocityX, velocityY, syntheticScroll, preventBoosting);
    }

    public void cancelFling(long timeMs) {
        if (this.mNativeEventForwarder == 0) {
            return;
        }
        nativeCancelFling(this.mNativeEventForwarder, timeMs, true);
    }
}
