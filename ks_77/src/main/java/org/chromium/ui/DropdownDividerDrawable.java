package org.chromium.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/DropdownDividerDrawable.class */
public class DropdownDividerDrawable extends Drawable {
    private final Paint mPaint = new Paint();
    private final Rect mDividerRect = new Rect();
    private final Integer mBackgroundColor;

    public DropdownDividerDrawable(Integer backgroundColor) {
        this.mBackgroundColor = backgroundColor;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mBackgroundColor != null) {
            canvas.drawColor(this.mBackgroundColor.intValue());
        }
        canvas.drawRect(this.mDividerRect, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        this.mDividerRect.set(0, 0, bounds.width(), this.mDividerRect.height());
    }

    public void setHeight(int height) {
        this.mDividerRect.set(0, 0, this.mDividerRect.right, height);
    }

    public void setDividerColor(int color) {
        this.mPaint.setColor(color);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }
}
