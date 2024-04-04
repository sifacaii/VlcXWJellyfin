package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.Checkable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/widget/CheckableImageView.class */
public class CheckableImageView extends ChromeImageView implements Checkable {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private boolean mChecked;

    public CheckableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int[] onCreateDrawableState(int extraSpace) {
        if (isChecked()) {
            int[] drawableState = super.onCreateDrawableState(extraSpace + CHECKED_STATE_SET.length);
            return mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return super.onCreateDrawableState(extraSpace);
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        if (drawable == getDrawable()) {
            return;
        }
        super.setImageDrawable(drawable);
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        if (this.mChecked == checked) {
            return;
        }
        this.mChecked = checked;
        refreshDrawableState();
    }
}
