package org.chromium.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/HorizontalListDividerDrawable.class */
public class HorizontalListDividerDrawable extends LayerDrawable {
    public static HorizontalListDividerDrawable create(Context context) {
        TypedArray a = context.obtainStyledAttributes(new int[]{16843284});
        Drawable listDivider = a.getDrawable(0);
        a.recycle();
        return new HorizontalListDividerDrawable(new Drawable[]{listDivider});
    }

    private HorizontalListDividerDrawable(Drawable[] layers) {
        super(layers);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        int listDividerHeight = getDrawable(0).getIntrinsicHeight();
        setLayerInset(0, 0, bounds.height() - listDividerHeight, 0, 0);
        super.onBoundsChange(bounds);
    }
}
