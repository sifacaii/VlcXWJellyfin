package org.chromium.ui.resources;

import android.graphics.Rect;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.ui.resources.statics.NinePatchData;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/ResourceFactory.class */
public class ResourceFactory {
    private static native long nativeCreateBitmapResource();

    private static native long nativeCreateNinePatchBitmapResource(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static long createBitmapResource(NinePatchData ninePatchData) {
        return ninePatchData == null ? nativeCreateBitmapResource() : createNinePatchBitmapResource(ninePatchData.getPadding(), ninePatchData.getAperture());
    }

    private static long createNinePatchBitmapResource(Rect padding, Rect aperture) {
        return nativeCreateNinePatchBitmapResource(padding.left, padding.top, padding.right, padding.bottom, aperture.left, aperture.top, aperture.right, aperture.bottom);
    }
}
