package org.chromium.ui.resources;

import android.graphics.Rect;
import android.graphics.RectF;
import org.chromium.ui.resources.statics.NinePatchData;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/LayoutResource.class */
public class LayoutResource {
    private final RectF mPadding;
    private final RectF mBitmapSize;
    private final RectF mAperture;

    public LayoutResource(float pxToDp, Resource resource) {
        Rect padding = new Rect();
        Rect aperture = new Rect();
        NinePatchData ninePatchData = resource.getNinePatchData();
        if (ninePatchData != null) {
            padding = ninePatchData.getPadding();
            aperture = ninePatchData.getAperture();
        }
        Rect bitmapSize = resource.getBitmapSize();
        this.mPadding = new RectF(padding.left * pxToDp, padding.top * pxToDp, padding.right * pxToDp, padding.bottom * pxToDp);
        this.mBitmapSize = new RectF(bitmapSize.left * pxToDp, bitmapSize.top * pxToDp, bitmapSize.right * pxToDp, bitmapSize.bottom * pxToDp);
        this.mAperture = new RectF(aperture.left * pxToDp, aperture.top * pxToDp, aperture.right * pxToDp, aperture.bottom * pxToDp);
    }

    public RectF getPadding() {
        return this.mPadding;
    }

    public RectF getBitmapSize() {
        return this.mBitmapSize;
    }

    public RectF getAperture() {
        return this.mAperture;
    }
}
