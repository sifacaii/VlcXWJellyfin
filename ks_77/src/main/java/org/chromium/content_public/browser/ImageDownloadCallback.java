package org.chromium.content_public.browser;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ImageDownloadCallback.class */
public interface ImageDownloadCallback {
    void onFinishDownloadImage(int i, int i2, String str, List<Bitmap> list, List<Rect> list2);
}
