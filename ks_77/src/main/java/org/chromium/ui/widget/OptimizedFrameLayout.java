package org.chromium.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.chromium.ui.base.PageTransition;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/OptimizedFrameLayout.class */
public class OptimizedFrameLayout extends FrameLayout {
    private List<MeasurementState> mMatchParentChildren;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/OptimizedFrameLayout$MeasurementState.class */
    private class MeasurementState {
        final View mView;
        final int mWidthMeasureSpec;
        final int mHeightMeasureSpec;

        MeasurementState(View view, int widthMeasureSpec, int heightMeasureSpec) {
            this.mView = view;
            this.mWidthMeasureSpec = widthMeasureSpec;
            this.mHeightMeasureSpec = heightMeasureSpec;
        }
    }

    public OptimizedFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mMatchParentChildren = new ArrayList();
    }

    @Override // android.widget.FrameLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        int count = getChildCount();
        boolean measureMatchParentChildren = (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824 && View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) ? false : true;
        this.mMatchParentChildren.clear();
        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (getMeasureAllChildren() || child.getVisibility() != 8) {
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) child.getLayoutParams();
                int childWidthMeasureSpec2 = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight + lp.leftMargin + lp.rightMargin, lp.width);
                int childHeightMeasureSpec2 = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom + lp.topMargin + lp.bottomMargin, lp.height);
                child.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                maxWidth = Math.max(maxWidth, child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
                maxHeight = Math.max(maxHeight, child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                if (measureMatchParentChildren && (lp.width == -1 || lp.height == -1)) {
                    this.mMatchParentChildren.add(new MeasurementState(child, childWidthMeasureSpec2, childHeightMeasureSpec2));
                }
            }
        }
        int maxHeight2 = Math.max(maxHeight + paddingTop + paddingBottom, getSuggestedMinimumHeight());
        int maxWidth2 = Math.max(maxWidth + paddingLeft + paddingRight, getSuggestedMinimumWidth());
        Drawable drawable = getForeground();
        if (drawable != null) {
            maxHeight2 = Math.max(maxHeight2, drawable.getMinimumHeight());
            maxWidth2 = Math.max(maxWidth2, drawable.getMinimumWidth());
        }
        setMeasuredDimension(resolveSizeAndState(maxWidth2, widthMeasureSpec, childState), resolveSizeAndState(maxHeight2, heightMeasureSpec, childState << 16));
        int count2 = this.mMatchParentChildren.size();
        if (count2 > 1) {
            for (int i2 = 0; i2 < count2; i2++) {
                MeasurementState measurementState = this.mMatchParentChildren.get(i2);
                View child2 = measurementState.mView;
                ViewGroup.MarginLayoutParams lp2 = (ViewGroup.MarginLayoutParams) child2.getLayoutParams();
                if (lp2.width == -1) {
                    int width = Math.max(0, (((getMeasuredWidth() - paddingLeft) - paddingRight) - lp2.leftMargin) - lp2.rightMargin);
                    childWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, PageTransition.CLIENT_REDIRECT);
                } else {
                    childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight + lp2.leftMargin + lp2.rightMargin, lp2.width);
                }
                if (lp2.height == -1) {
                    int height = Math.max(0, (((getMeasuredHeight() - paddingTop) - paddingBottom) - lp2.topMargin) - lp2.bottomMargin);
                    childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, PageTransition.CLIENT_REDIRECT);
                } else {
                    childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom + lp2.topMargin + lp2.bottomMargin, lp2.height);
                }
                if (measurementState.mWidthMeasureSpec != childWidthMeasureSpec || measurementState.mHeightMeasureSpec != childHeightMeasureSpec) {
                    child2.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                }
            }
        }
        this.mMatchParentChildren.clear();
    }
}
