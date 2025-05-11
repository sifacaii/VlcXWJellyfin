package org.chromium.ui.widget;

import android.graphics.Rect;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/RectProvider.class */
public class RectProvider {
    protected final Rect mRect = new Rect();
    private Observer mObserver;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/RectProvider$Observer.class */
    public interface Observer {
        void onRectChanged();

        void onRectHidden();
    }

    static {
        $assertionsDisabled = !RectProvider.class.desiredAssertionStatus();
    }

    public RectProvider() {
    }

    public RectProvider(Rect rect) {
        this.mRect.set(rect);
    }

    public void setRect(Rect rect) {
        this.mRect.set(rect);
        notifyRectChanged();
    }

    public void startObserving(Observer observer) {
        if (!$assertionsDisabled && this.mObserver != null && this.mObserver != observer) {
            throw new AssertionError();
        }
        this.mObserver = observer;
    }

    public void stopObserving() {
        this.mObserver = null;
    }

    public Rect getRect() {
        return this.mRect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyRectChanged() {
        if (this.mObserver != null) {
            this.mObserver.onRectChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyRectHidden() {
        if (this.mObserver != null) {
            this.mObserver.onRectHidden();
        }
    }
}
