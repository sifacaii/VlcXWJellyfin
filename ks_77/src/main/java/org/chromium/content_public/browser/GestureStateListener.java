package org.chromium.content_public.browser;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/GestureStateListener.class */
public interface GestureStateListener {
    default void onPinchStarted() {
    }

    default void onPinchEnded() {
    }

    default void onFlingStartGesture(int scrollOffsetY, int scrollExtentY) {
    }

    default void onFlingEndGesture(int scrollOffsetY, int scrollExtentY) {
    }

    default void onScrollUpdateGestureConsumed() {
    }

    default void onScrollStarted(int scrollOffsetY, int scrollExtentY) {
    }

    default void onScrollEnded(int scrollOffsetY, int scrollExtentY) {
    }

    default void onScaleLimitsChanged(float minPageScaleFactor, float maxPageScaleFactor) {
    }

    default void onScrollOffsetOrExtentChanged(int scrollOffsetY, int scrollExtentY) {
    }

    default void onTouchDown() {
    }

    default void onSingleTap(boolean consumed) {
    }

    default void onShowUnhandledTapUIIfNeeded(int x, int y) {
    }

    default void onWindowFocusChanged(boolean hasWindowFocus) {
    }

    default void onLongPress() {
    }

    default void onDestroyed() {
    }
}
