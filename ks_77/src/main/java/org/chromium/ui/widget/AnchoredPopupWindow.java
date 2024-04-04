package org.chromium.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ObserverList;
import org.chromium.base.VisibleForTesting;
import org.chromium.ui.widget.RectProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/AnchoredPopupWindow.class */
public class AnchoredPopupWindow implements View.OnTouchListener, RectProvider.Observer {
    private final Context mContext;
    private final View mRootView;
    private final PopupWindow mPopupWindow;
    private final RectProvider mRectProvider;
    private boolean mDismissOnTouchInteraction;
    private View.OnTouchListener mTouchListener;
    private LayoutObserver mLayoutObserver;
    private int mX;
    private int mY;
    private int mWidth;
    private int mHeight;
    private int mMarginPx;
    private int mMaxWidthPx;
    private boolean mIgnoreDismissal;
    private boolean mPositionBelow;
    private boolean mPositionToLeft;
    private boolean mVerticalOverlapAnchor;
    private boolean mHorizontalOverlapAnchor;
    private boolean mUpdateOrientationOnChange;
    private final Rect mCachedPaddingRect = new Rect();
    private final Rect mCachedWindowRect = new Rect();
    private final Runnable mDismissRunnable = new Runnable() { // from class: org.chromium.ui.widget.AnchoredPopupWindow.1
        @Override // java.lang.Runnable
        public void run() {
            if (AnchoredPopupWindow.this.mPopupWindow.isShowing()) {
                AnchoredPopupWindow.this.dismiss();
            }
        }
    };
    private final PopupWindow.OnDismissListener mDismissListener = new PopupWindow.OnDismissListener() { // from class: org.chromium.ui.widget.AnchoredPopupWindow.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (AnchoredPopupWindow.this.mIgnoreDismissal) {
                return;
            }
            AnchoredPopupWindow.this.mHandler.removeCallbacks(AnchoredPopupWindow.this.mDismissRunnable);
            Iterator it = AnchoredPopupWindow.this.mDismissListeners.iterator();
            while (it.hasNext()) {
                PopupWindow.OnDismissListener listener = (PopupWindow.OnDismissListener) it.next();
                listener.onDismiss();
            }
            AnchoredPopupWindow.this.mRectProvider.stopObserving();
        }
    };
    private ObserverList<PopupWindow.OnDismissListener> mDismissListeners = new ObserverList<>();
    private int mPreferredVerticalOrientation = 0;
    private int mPreferredHorizontalOrientation = 0;
    private final Handler mHandler = new Handler();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/AnchoredPopupWindow$HorizontalOrientation.class */
    public @interface HorizontalOrientation {
        public static final int MAX_AVAILABLE_SPACE = 0;
        public static final int CENTER = 1;
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/AnchoredPopupWindow$LayoutObserver.class */
    public interface LayoutObserver {
        void onPreLayoutChange(boolean z, int i, int i2, int i3, int i4, Rect rect);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/AnchoredPopupWindow$VerticalOrientation.class */
    public @interface VerticalOrientation {
        public static final int MAX_AVAILABLE_SPACE = 0;
        public static final int BELOW = 1;
        public static final int ABOVE = 2;
    }

    public AnchoredPopupWindow(Context context, View rootView, Drawable background, View contentView, RectProvider anchorRectProvider) {
        this.mContext = context;
        this.mRootView = rootView.getRootView();
        this.mPopupWindow = UiWidgetFactory.getInstance().createPopupWindow(this.mContext);
        this.mRectProvider = anchorRectProvider;
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setBackgroundDrawable(background);
        this.mPopupWindow.setContentView(contentView);
        this.mPopupWindow.setTouchInterceptor(this);
        this.mPopupWindow.setOnDismissListener(this.mDismissListener);
    }

    public void show() {
        if (this.mPopupWindow.isShowing()) {
            return;
        }
        this.mRectProvider.startObserving(this);
        updatePopupLayout();
        showPopupWindow();
    }

    public void dismiss() {
        this.mPopupWindow.dismiss();
    }

    public boolean isShowing() {
        return this.mPopupWindow.isShowing();
    }

    public void setLayoutObserver(LayoutObserver layoutObserver) {
        this.mLayoutObserver = layoutObserver;
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.mTouchListener = onTouchListener;
    }

    public void addOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mDismissListeners.addObserver(onDismissListener);
    }

    public void removeOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mDismissListeners.removeObserver(onDismissListener);
    }

    public void setDismissOnTouchInteraction(boolean dismiss) {
        this.mDismissOnTouchInteraction = dismiss;
        this.mPopupWindow.setOutsideTouchable(this.mDismissOnTouchInteraction);
    }

    public void setOutsideTouchable(boolean touchable) {
        this.mPopupWindow.setOutsideTouchable(touchable);
    }

    public void setPreferredVerticalOrientation(int orientation) {
        this.mPreferredVerticalOrientation = orientation;
    }

    public void setPreferredHorizontalOrientation(int orientation) {
        this.mPreferredHorizontalOrientation = orientation;
    }

    public void setAnimationStyle(int animationStyleId) {
        this.mPopupWindow.setAnimationStyle(animationStyleId);
    }

    public void setUpdateOrientationOnChange(boolean updateOrientationOnChange) {
        this.mUpdateOrientationOnChange = updateOrientationOnChange;
    }

    public void setFocusable(boolean focusable) {
        this.mPopupWindow.setFocusable(focusable);
    }

    public void setMargin(int margin) {
        this.mMarginPx = margin;
    }

    public void setMaxWidth(int maxWidth) {
        this.mMaxWidthPx = maxWidth;
    }

    public void setHorizontalOverlapAnchor(boolean overlap) {
        this.mHorizontalOverlapAnchor = overlap;
    }

    public void setVerticalOverlapAnchor(boolean overlap) {
        this.mVerticalOverlapAnchor = overlap;
    }

    public void setBackgroundDrawable(Drawable background) {
        this.mPopupWindow.setBackgroundDrawable(background);
    }

    public void setElevation(float elevation) {
        ApiCompatibilityUtils.setElevation(this.mPopupWindow, elevation);
    }

    @Override // org.chromium.ui.widget.RectProvider.Observer
    public void onRectChanged() {
        updatePopupLayout();
    }

    @Override // org.chromium.ui.widget.RectProvider.Observer
    public void onRectHidden() {
        dismiss();
    }

    private void updatePopupLayout() {
        boolean currentPositionBelow = this.mPositionBelow;
        boolean currentPositionToLeft = this.mPositionToLeft;
        boolean preferCurrentOrientation = this.mPopupWindow.isShowing() && !this.mUpdateOrientationOnChange;
        this.mPopupWindow.getBackground().getPadding(this.mCachedPaddingRect);
        int paddingX = this.mCachedPaddingRect.left + this.mCachedPaddingRect.right;
        int paddingY = this.mCachedPaddingRect.top + this.mCachedPaddingRect.bottom;
        int maxContentWidth = getMaxContentWidth(this.mMaxWidthPx, this.mRootView.getWidth(), this.mMarginPx, paddingX);
        View contentView = this.mPopupWindow.getContentView();
        int widthSpec = View.MeasureSpec.makeMeasureSpec(maxContentWidth, Integer.MIN_VALUE);
        contentView.measure(widthSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
        int idealContentHeight = contentView.getMeasuredHeight();
        int idealContentWidth = contentView.getMeasuredWidth();
        this.mRootView.getWindowVisibleDisplayFrame(this.mCachedWindowRect);
        int[] rootCoordinates = new int[2];
        this.mRootView.getLocationOnScreen(rootCoordinates);
        this.mCachedWindowRect.offset(-rootCoordinates[0], -rootCoordinates[1]);
        Rect anchorRect = this.mRectProvider.getRect();
        int spaceAboveAnchor = (((this.mVerticalOverlapAnchor ? anchorRect.bottom : anchorRect.top) - this.mCachedWindowRect.top) - paddingY) - this.mMarginPx;
        int spaceBelowAnchor = ((this.mCachedWindowRect.bottom - (this.mVerticalOverlapAnchor ? anchorRect.top : anchorRect.bottom)) - paddingY) - this.mMarginPx;
        boolean idealFitsBelow = idealContentHeight <= spaceBelowAnchor;
        boolean idealFitsAbove = idealContentHeight <= spaceAboveAnchor;
        this.mPositionBelow = (idealFitsBelow && spaceBelowAnchor >= spaceAboveAnchor) || !idealFitsAbove;
        if (preferCurrentOrientation && currentPositionBelow != this.mPositionBelow) {
            if (currentPositionBelow && idealFitsBelow) {
                this.mPositionBelow = true;
            }
            if (!currentPositionBelow && idealFitsAbove) {
                this.mPositionBelow = false;
            }
        }
        if (this.mPreferredVerticalOrientation == 1 && idealFitsBelow) {
            this.mPositionBelow = true;
        }
        if (this.mPreferredVerticalOrientation == 2 && idealFitsAbove) {
            this.mPositionBelow = false;
        }
        if (this.mPreferredHorizontalOrientation == 0) {
            int spaceLeftOfAnchor = getSpaceLeftOfAnchor(anchorRect, this.mCachedWindowRect, this.mHorizontalOverlapAnchor);
            int spaceRightOfAnchor = getSpaceRightOfAnchor(anchorRect, this.mCachedWindowRect, this.mHorizontalOverlapAnchor);
            this.mPositionToLeft = shouldPositionLeftOfAnchor(spaceLeftOfAnchor, spaceRightOfAnchor, idealContentWidth + paddingY + this.mMarginPx, currentPositionToLeft, preferCurrentOrientation);
        }
        int maxContentHeight = this.mPositionBelow ? spaceBelowAnchor : spaceAboveAnchor;
        contentView.measure(widthSpec, View.MeasureSpec.makeMeasureSpec(maxContentHeight, Integer.MIN_VALUE));
        this.mWidth = contentView.getMeasuredWidth() + paddingX;
        this.mHeight = contentView.getMeasuredHeight() + paddingY;
        this.mX = getPopupX(anchorRect, this.mCachedWindowRect, this.mWidth, this.mMarginPx, this.mHorizontalOverlapAnchor, this.mPreferredHorizontalOrientation, this.mPositionToLeft);
        this.mY = getPopupY(anchorRect, this.mHeight, this.mVerticalOverlapAnchor, this.mPositionBelow);
        if (this.mLayoutObserver != null) {
            this.mLayoutObserver.onPreLayoutChange(this.mPositionBelow, this.mX, this.mY, this.mWidth, this.mHeight, anchorRect);
        }
        if (this.mPopupWindow.isShowing() && this.mPositionBelow != currentPositionBelow) {
            try {
                this.mIgnoreDismissal = true;
                this.mPopupWindow.dismiss();
                showPopupWindow();
                this.mIgnoreDismissal = false;
            } catch (Throwable th) {
                this.mIgnoreDismissal = false;
                throw th;
            }
        }
        this.mPopupWindow.update(this.mX, this.mY, this.mWidth, this.mHeight);
    }

    @VisibleForTesting
    static int getMaxContentWidth(int desiredMaxWidthPx, int rootViewWidth, int marginPx, int paddingX) {
        int maxWidth;
        int maxWidthBasedOnRootView = rootViewWidth - (marginPx * 2);
        if (desiredMaxWidthPx != 0 && desiredMaxWidthPx < maxWidthBasedOnRootView) {
            maxWidth = desiredMaxWidthPx;
        } else {
            maxWidth = maxWidthBasedOnRootView;
        }
        if (maxWidth > paddingX) {
            return maxWidth - paddingX;
        }
        return 0;
    }

    @VisibleForTesting
    static int getSpaceLeftOfAnchor(Rect anchorRect, Rect windowRect, boolean overlapAnchor) {
        return (overlapAnchor ? anchorRect.right : anchorRect.left) - windowRect.left;
    }

    @VisibleForTesting
    static int getSpaceRightOfAnchor(Rect anchorRect, Rect windowRect, boolean overlapAnchor) {
        return windowRect.right - (overlapAnchor ? anchorRect.left : anchorRect.right);
    }

    @VisibleForTesting
    static boolean shouldPositionLeftOfAnchor(int spaceToLeftOfAnchor, int spaceToRightOfAnchor, int idealPopupWidth, boolean currentPositionToLeft, boolean preferCurrentOrientation) {
        boolean positionToLeft = spaceToLeftOfAnchor >= spaceToRightOfAnchor;
        if (preferCurrentOrientation && positionToLeft != currentPositionToLeft) {
            if (currentPositionToLeft && idealPopupWidth <= spaceToLeftOfAnchor) {
                positionToLeft = true;
            }
            if (!currentPositionToLeft && idealPopupWidth <= spaceToRightOfAnchor) {
                positionToLeft = false;
            }
        }
        return positionToLeft;
    }

    @VisibleForTesting
    static int getPopupX(Rect anchorRect, Rect windowRect, int popupWidth, int marginPx, boolean overlapAnchor, int horizontalOrientation, boolean positionToLeft) {
        int x;
        if (horizontalOrientation == 1) {
            x = anchorRect.left + ((anchorRect.width() - popupWidth) / 2) + marginPx;
        } else if (positionToLeft) {
            x = (overlapAnchor ? anchorRect.right : anchorRect.left) - popupWidth;
        } else {
            x = overlapAnchor ? anchorRect.left : anchorRect.right;
        }
        return clamp(x, marginPx, (windowRect.right - popupWidth) - marginPx);
    }

    @VisibleForTesting
    static int getPopupY(Rect anchorRect, int popupHeight, boolean overlapAnchor, boolean positionBelow) {
        if (positionBelow) {
            return overlapAnchor ? anchorRect.top : anchorRect.bottom;
        }
        return (overlapAnchor ? anchorRect.bottom : anchorRect.top) - popupHeight;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View v, MotionEvent event) {
        boolean returnValue = this.mTouchListener != null && this.mTouchListener.onTouch(v, event);
        if (this.mDismissOnTouchInteraction) {
            dismiss();
        }
        return returnValue;
    }

    private static int clamp(int value, int a, int b) {
        int min = a > b ? b : a;
        int max = a > b ? a : b;
        if (value < min) {
            value = min;
        } else if (value > max) {
            value = max;
        }
        return value;
    }

    private void showPopupWindow() {
        try {
            this.mPopupWindow.showAtLocation(this.mRootView, 8388659, this.mX, this.mY);
        } catch (WindowManager.BadTokenException e) {
        }
    }
}
