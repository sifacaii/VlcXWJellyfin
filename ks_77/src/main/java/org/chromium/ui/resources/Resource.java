package org.chromium.ui.resources;

import android.graphics.Bitmap;
import android.graphics.Rect;
import org.chromium.ui.resources.statics.NinePatchData;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/Resource.class */
public interface Resource {
    Bitmap getBitmap();

    Rect getBitmapSize();

    NinePatchData getNinePatchData();

    long createNativeResource();
}
