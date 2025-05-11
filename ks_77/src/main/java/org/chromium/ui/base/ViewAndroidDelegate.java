package org.chromium.ui.base;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.core.view.MarginLayoutParamsCompat;

import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.compat.ApiHelperForN;
import org.chromium.ui.touchless.TouchlessEventHandler;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ViewAndroidDelegate.class */
public class ViewAndroidDelegate {
    protected ViewGroup mContainerView;
    private int[] mTemporaryContainerLocation = new int[2];
    private ObserverList<ContainerViewObserver> mContainerViewObservers = new ObserverList<>();
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/ViewAndroidDelegate$ContainerViewObserver.class */
    public interface ContainerViewObserver {
        void onUpdateContainerView(ViewGroup viewGroup);
    }

    static {
        $assertionsDisabled = !ViewAndroidDelegate.class.desiredAssertionStatus();
    }

    public static ViewAndroidDelegate createBasicDelegate(ViewGroup containerView) {
        return new ViewAndroidDelegate(containerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewAndroidDelegate(ViewGroup containerView) {
        this.mContainerView = containerView;
    }

    public final void addObserver(ContainerViewObserver observer) {
        this.mContainerViewObservers.addObserver(observer);
    }

    public final void setContainerView(ViewGroup containerView) {
        ViewGroup oldContainerView = this.mContainerView;
        this.mContainerView = containerView;
        updateAnchorViews(oldContainerView);
        Iterator<ContainerViewObserver> it = this.mContainerViewObservers.iterator();
        while (it.hasNext()) {
            ContainerViewObserver observer = it.next();
            observer.onUpdateContainerView(containerView);
        }
    }

    public void updateAnchorViews(ViewGroup oldContainerView) {
    }

    @CalledByNative
    public View acquireView() {
        ViewGroup containerView = getContainerView();
        if (containerView == null || containerView.getParent() == null) {
            return null;
        }
        View anchorView = new View(containerView.getContext());
        containerView.addView(anchorView);
        return anchorView;
    }

    @CalledByNative
    public void removeView(View anchorView) {
        ViewGroup containerView = getContainerView();
        if (containerView == null) {
            return;
        }
        containerView.removeView(anchorView);
    }

    @CalledByNative
    public void setViewPosition(View view, float x, float y, float width, float height, int leftMargin, int topMargin) {
        int startMargin;
        ViewGroup containerView = getContainerView();
        if (containerView == null) {
            return;
        }
        int widthInt = Math.round(width);
        int heightInt = Math.round(height);
        if (containerView.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
            startMargin = containerView.getMeasuredWidth() - Math.round(width + x);
        } else {
            startMargin = leftMargin;
        }
        if (widthInt + startMargin > containerView.getWidth()) {
            widthInt = containerView.getWidth() - startMargin;
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(widthInt, heightInt);
        MarginLayoutParamsCompat.setMarginStart(lp, startMargin);
        lp.topMargin = topMargin;
        view.setLayoutParams(lp);
    }

    @TargetApi(24)
    @CalledByNative
    private boolean startDragAndDrop(String text, Bitmap shadowImage) {
        ViewGroup containerView;
        if (Build.VERSION.SDK_INT > 23 && (containerView = getContainerView()) != null) {
            ImageView imageView = new ImageView(containerView.getContext());
            imageView.setImageBitmap(shadowImage);
            imageView.layout(0, 0, shadowImage.getWidth(), shadowImage.getHeight());
            return ApiHelperForN.startDragAndDrop(containerView, ClipData.newPlainText(null, text), new View.DragShadowBuilder(imageView), null, 256);
        }
        return false;
    }

    @VisibleForTesting
    @CalledByNative
    public void onCursorChangedToCustom(Bitmap customCursorBitmap, int hotspotX, int hotspotY) {
        if (Build.VERSION.SDK_INT >= 24) {
            PointerIcon icon = ApiHelperForN.createPointerIcon(customCursorBitmap, hotspotX, hotspotY);
            ApiHelperForN.setPointerIcon(getContainerView(), icon);
        }
    }

    @VisibleForTesting
    @CalledByNative
    public void onCursorChanged(int cursorType) {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        int pointerIconType = 1000;
        switch (cursorType) {
            case 0:
                pointerIconType = 1000;
                break;
            case 1:
                pointerIconType = 1007;
                break;
            case 2:
                pointerIconType = 1002;
                break;
            case 3:
                pointerIconType = 1008;
                break;
            case 4:
                pointerIconType = 1004;
                break;
            case 5:
                pointerIconType = 1003;
                break;
            case 6:
                pointerIconType = 1014;
                break;
            case 7:
                pointerIconType = 1015;
                break;
            case 8:
                pointerIconType = 1016;
                break;
            case 9:
                pointerIconType = 1017;
                break;
            case 10:
                pointerIconType = 1015;
                break;
            case 11:
                pointerIconType = 1017;
                break;
            case 12:
                pointerIconType = 1016;
                break;
            case 13:
                pointerIconType = 1014;
                break;
            case 14:
                pointerIconType = 1015;
                break;
            case 15:
                pointerIconType = 1014;
                break;
            case 16:
                pointerIconType = 1016;
                break;
            case 17:
                pointerIconType = 1017;
                break;
            case 18:
                pointerIconType = 1014;
                break;
            case 19:
                pointerIconType = 1015;
                break;
            case 20:
            case 29:
                pointerIconType = 1013;
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                if (!$assertionsDisabled) {
                    throw new AssertionError("These pointer icon types are not supported");
                }
                break;
            case 30:
                pointerIconType = 1009;
                break;
            case 31:
                pointerIconType = 1006;
                break;
            case 32:
                pointerIconType = 1001;
                break;
            case 33:
                pointerIconType = 1010;
                break;
            case 34:
                pointerIconType = 1004;
                break;
            case 35:
                pointerIconType = 1012;
                break;
            case 36:
                pointerIconType = 1011;
                break;
            case 37:
                pointerIconType = 0;
                break;
            case 38:
                pointerIconType = 1012;
                break;
            case 39:
                pointerIconType = 1018;
                break;
            case 40:
                pointerIconType = 1019;
                break;
            case 41:
                pointerIconType = 1020;
                break;
            case 42:
                pointerIconType = 1021;
                break;
            case 45:
                if (!$assertionsDisabled) {
                    throw new AssertionError("onCursorChangedToCustom must be called instead");
                }
                break;
        }
        ViewGroup containerView = getContainerView();
        PointerIcon icon = PointerIcon.getSystemIcon(containerView.getContext(), pointerIconType);
        ApiHelperForN.setPointerIcon(containerView, icon);
    }

    @CalledByNative
    public void onBackgroundColorChanged(int color) {
    }

    @CalledByNative
    public void onTopControlsChanged(int topControlsOffsetY, int topContentOffsetY) {
    }

    @CalledByNative
    public void onBottomControlsChanged(int bottomControlsOffsetY, int bottomContentOffsetY) {
    }

    @CalledByNative
    public int getSystemWindowInsetBottom() {
        return 0;
    }

    @CalledByNative
    public final ViewGroup getContainerView() {
        return this.mContainerView;
    }

    @CalledByNative
    private int getXLocationOfContainerViewInWindow() {
        ViewGroup container = getContainerView();
        if (container == null) {
            return 0;
        }
        container.getLocationInWindow(this.mTemporaryContainerLocation);
        return this.mTemporaryContainerLocation[0];
    }

    @CalledByNative
    private int getYLocationOfContainerViewInWindow() {
        ViewGroup container = getContainerView();
        if (container == null) {
            return 0;
        }
        container.getLocationInWindow(this.mTemporaryContainerLocation);
        return this.mTemporaryContainerLocation[1];
    }

    @CalledByNative
    private int getXLocationOnScreen() {
        ViewGroup container = getContainerView();
        if (container == null) {
            return 0;
        }
        container.getLocationOnScreen(this.mTemporaryContainerLocation);
        return this.mTemporaryContainerLocation[0];
    }

    @CalledByNative
    private int getYLocationOnScreen() {
        ViewGroup container = getContainerView();
        if (container == null) {
            return 0;
        }
        container.getLocationOnScreen(this.mTemporaryContainerLocation);
        return this.mTemporaryContainerLocation[1];
    }

    @CalledByNative
    private void requestDisallowInterceptTouchEvent() {
        ViewGroup container = getContainerView();
        if (container != null) {
            container.requestDisallowInterceptTouchEvent(true);
        }
    }

    @CalledByNative
    @TargetApi(21)
    private void requestUnbufferedDispatch(MotionEvent event) {
        ViewGroup container = getContainerView();
        if (container != null) {
            container.requestUnbufferedDispatch(event);
        }
    }

    @CalledByNative
    private boolean hasFocus() {
        ViewGroup containerView = getContainerView();
        if (containerView == null) {
            return false;
        }
        return ViewUtils.hasFocus(containerView);
    }

    @CalledByNative
    private void requestFocus() {
        ViewGroup containerView = getContainerView();
        if (containerView != null) {
            ViewUtils.requestFocus(containerView);
        }
    }

    @CalledByNative
    private static boolean hasTouchlessEventHandler() {
        return TouchlessEventHandler.hasTouchlessEventHandler();
    }

    @CalledByNative
    private static boolean onUnconsumedKeyboardEventAck(int nativeCode) {
        return TouchlessEventHandler.onUnconsumedKeyboardEventAck(nativeCode);
    }

    @CalledByNative
    private static void fallbackCursorModeLockCursor(boolean left, boolean right, boolean up, boolean down) {
        TouchlessEventHandler.fallbackCursorModeLockCursor(left, right, up, down);
    }

    @CalledByNative
    private static void fallbackCursorModeSetCursorVisibility(boolean visible) {
        TouchlessEventHandler.fallbackCursorModeSetCursorVisibility(visible);
    }

    public void performPrivateImeCommand(String action, Bundle data) {
    }
}
