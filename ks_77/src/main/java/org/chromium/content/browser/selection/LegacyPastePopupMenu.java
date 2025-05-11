package org.chromium.content.browser.selection;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import org.chromium.content.browser.selection.PastePopupMenu;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/selection/LegacyPastePopupMenu.class */
public class LegacyPastePopupMenu implements View.OnClickListener, PastePopupMenu {
    private final View mParent;
    private final PastePopupMenu.PastePopupMenuDelegate mDelegate;
    private final Context mContext;
    private final PopupWindow mContainer;
    private int mRawPositionX;
    private int mRawPositionY;
    private int mStatusBarHeight;
    private View mPasteView;
    private final int mPasteViewLayout;
    private final int mLineOffsetY;
    private final int mWidthOffsetX;

    public LegacyPastePopupMenu(Context context, View parent, PastePopupMenu.PastePopupMenuDelegate delegate) {
        this.mParent = parent;
        this.mDelegate = delegate;
        this.mContext = context;
        this.mContainer = new PopupWindow(this.mContext, (AttributeSet) null, 16843464);
        this.mContainer.setSplitTouchEnabled(true);
        this.mContainer.setClippingEnabled(false);
        this.mContainer.setAnimationStyle(0);
        this.mContainer.setWidth(-2);
        this.mContainer.setHeight(-2);
        int[] popupLayoutAttrs = {16843540};
        TypedArray attrs = this.mContext.getTheme().obtainStyledAttributes(popupLayoutAttrs);
        this.mPasteViewLayout = attrs.getResourceId(attrs.getIndex(0), 0);
        attrs.recycle();
        this.mLineOffsetY = (int) TypedValue.applyDimension(1, 5.0f, this.mContext.getResources().getDisplayMetrics());
        this.mWidthOffsetX = (int) TypedValue.applyDimension(1, 30.0f, this.mContext.getResources().getDisplayMetrics());
        int statusBarHeightResourceId = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (statusBarHeightResourceId > 0) {
            this.mStatusBarHeight = this.mContext.getResources().getDimensionPixelSize(statusBarHeightResourceId);
        }
    }

    @Override // org.chromium.content.browser.selection.PastePopupMenu
    public void show(Rect selectionRect) {
        hide();
        updateContent();
        positionAt(selectionRect.left, selectionRect.bottom);
    }

    @Override // org.chromium.content.browser.selection.PastePopupMenu
    public void hide() {
        this.mContainer.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        paste();
        hide();
    }

    private void positionAt(int x, int y) {
        int positionX;
        if (this.mRawPositionX == x && this.mRawPositionY == y) {
            return;
        }
        this.mRawPositionX = x;
        this.mRawPositionY = y;
        View contentView = this.mContainer.getContentView();
        int width = contentView.getMeasuredWidth();
        int height = contentView.getMeasuredHeight();
        int positionX2 = (int) (x - (width / 2.0f));
        int positionY = (y - height) - this.mLineOffsetY;
        int minOffsetY = 0;
        if (this.mParent.getSystemUiVisibility() == 0) {
            minOffsetY = this.mStatusBarHeight;
        }
        int screenWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
        if (positionY < minOffsetY) {
            positionY = positionY + height + this.mLineOffsetY;
            int handleHalfWidth = this.mWidthOffsetX / 2;
            positionX = x + width < screenWidth ? positionX2 + handleHalfWidth + (width / 2) : positionX2 - (handleHalfWidth + (width / 2));
        } else {
            positionX = Math.min(screenWidth - width, Math.max(0, positionX2));
        }
        int[] coords = new int[2];
        this.mParent.getLocationInWindow(coords);
        this.mContainer.showAtLocation(this.mParent, 0, positionX + coords[0], positionY + coords[1]);
    }

    private void updateContent() {
        if (this.mPasteView == null) {
            LayoutInflater inflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            if (inflater != null) {
                this.mPasteView = inflater.inflate(this.mPasteViewLayout, (ViewGroup) null);
            }
            if (this.mPasteView == null) {
                throw new IllegalArgumentException("Unable to inflate TextEdit paste window");
            }
            int size = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.mPasteView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.mPasteView.measure(size, size);
            this.mPasteView.setOnClickListener(this);
        }
        this.mContainer.setContentView(this.mPasteView);
    }

    private void paste() {
        this.mDelegate.paste();
    }
}
