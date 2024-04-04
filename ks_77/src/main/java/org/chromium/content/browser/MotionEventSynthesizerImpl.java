package org.chromium.content.browser;

import android.view.MotionEvent;
import android.view.View;
import org.chromium.content_public.browser.MotionEventSynthesizer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/MotionEventSynthesizerImpl.class */
public class MotionEventSynthesizerImpl implements MotionEventSynthesizer {
    private static final int MAX_NUM_POINTERS = 16;
    private final MotionEvent.PointerProperties[] mPointerProperties;
    private final MotionEvent.PointerCoords[] mPointerCoords;
    private final View mTarget;
    private long mDownTimeInMs;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !MotionEventSynthesizerImpl.class.desiredAssertionStatus();
    }

    public static MotionEventSynthesizerImpl create(View target) {
        return new MotionEventSynthesizerImpl(target);
    }

    private MotionEventSynthesizerImpl(View target) {
        if (!$assertionsDisabled && target == null) {
            throw new AssertionError();
        }
        this.mTarget = target;
        this.mPointerProperties = new MotionEvent.PointerProperties[16];
        this.mPointerCoords = new MotionEvent.PointerCoords[16];
    }

    @Override // org.chromium.content_public.browser.MotionEventSynthesizer
    public void setPointer(int index, int x, int y, int id, int toolType) {
        if (!$assertionsDisabled && (0 > index || index >= 16)) {
            throw new AssertionError();
        }
        MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
        coords.x = x;
        coords.y = y;
        coords.pressure = 1.0f;
        this.mPointerCoords[index] = coords;
        MotionEvent.PointerProperties properties = new MotionEvent.PointerProperties();
        properties.id = id;
        properties.toolType = toolType;
        this.mPointerProperties[index] = properties;
    }

    public void setPointer(int index, int x, int y, int id) {
        setPointer(index, x, y, id, 0);
    }

    public void setScrollDeltas(int x, int y, int dx, int dy) {
        setPointer(0, x, y, 0);
        this.mPointerCoords[0].setAxisValue(10, dx);
        this.mPointerCoords[0].setAxisValue(9, dy);
    }

    @Override // org.chromium.content_public.browser.MotionEventSynthesizer
    public void inject(int action, int pointerCount, long timeInMs) {
        switch (action) {
            case 0:
                this.mDownTimeInMs = timeInMs;
                MotionEvent event = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 0, 1, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                this.mTarget.dispatchTouchEvent(event);
                event.recycle();
                if (pointerCount > 1) {
                    if (!$assertionsDisabled && pointerCount != 2) {
                        throw new AssertionError();
                    }
                    MotionEvent event2 = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 5 | 256, pointerCount, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                    this.mTarget.dispatchTouchEvent(event2);
                    event2.recycle();
                    return;
                }
                return;
            case 1:
                MotionEvent event3 = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 2, pointerCount, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                this.mTarget.dispatchTouchEvent(event3);
                event3.recycle();
                return;
            case 2:
                MotionEvent event4 = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 3, 1, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                this.mTarget.dispatchTouchEvent(event4);
                event4.recycle();
                return;
            case 3:
                if (pointerCount > 1) {
                    if (!$assertionsDisabled && pointerCount != 2) {
                        throw new AssertionError();
                    }
                    MotionEvent event5 = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 6 | 256, pointerCount, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                    this.mTarget.dispatchTouchEvent(event5);
                    event5.recycle();
                }
                MotionEvent event6 = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 1, 1, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                this.mTarget.dispatchTouchEvent(event6);
                event6.recycle();
                return;
            case 4:
                if (!$assertionsDisabled && pointerCount != 1) {
                    throw new AssertionError();
                }
                MotionEvent event7 = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, 8, pointerCount, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0);
                this.mTarget.dispatchGenericMotionEvent(event7);
                event7.recycle();
                return;
            case 5:
            case 6:
            case 7:
                injectHover(action, pointerCount, timeInMs);
                return;
            default:
                if (!$assertionsDisabled) {
                    throw new AssertionError("Unreached");
                }
                return;
        }
    }

    private void injectHover(int action, int pointerCount, long timeInMs) {
        if (!$assertionsDisabled && pointerCount != 1) {
            throw new AssertionError();
        }
        int androidAction = 9;
        if (6 == action) {
            androidAction = 10;
        }
        if (7 == action) {
            androidAction = 7;
        }
        MotionEvent event = MotionEvent.obtain(this.mDownTimeInMs, timeInMs, androidAction, pointerCount, this.mPointerProperties, this.mPointerCoords, 0, 0, 1.0f, 1.0f, 0, 0, 2, 0);
        this.mTarget.dispatchGenericMotionEvent(event);
        event.recycle();
    }
}
