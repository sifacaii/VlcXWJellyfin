package org.chromium.ui.resources.system;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;
import org.chromium.ui.resources.statics.StaticResource;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/system/SystemResourceLoader.class */
public class SystemResourceLoader extends AsyncPreloadResourceLoader {
    private static final float SIN_PI_OVER_6 = 0.5f;
    private static final float COS_PI_OVER_6 = 0.866f;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SystemResourceLoader.class.desiredAssertionStatus();
    }

    public SystemResourceLoader(int resourceType, ResourceLoader.ResourceLoaderCallback callback, final int minScreenSideLengthPx) {
        super(resourceType, callback, new AsyncPreloadResourceLoader.ResourceCreator() { // from class: org.chromium.ui.resources.system.SystemResourceLoader.1
            @Override // org.chromium.ui.resources.async.AsyncPreloadResourceLoader.ResourceCreator
            public Resource create(int resId) {
                return SystemResourceLoader.createResource(minScreenSideLengthPx, resId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Resource createResource(int minScreenSideLengthPx, int resId) {
        switch (resId) {
            case 0:
                return StaticResource.create(Resources.getSystem(), getResourceId("android:drawable/overscroll_edge"), 128, 12);
            case 1:
                return StaticResource.create(Resources.getSystem(), getResourceId("android:drawable/overscroll_glow"), 128, 64);
            case 2:
                return createOverscrollGlowLBitmap(minScreenSideLengthPx);
            default:
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError();
        }
    }

    private static Resource createOverscrollGlowLBitmap(int minScreenSideLengthPx) {
        float arcWidth = (minScreenSideLengthPx * SIN_PI_OVER_6) / SIN_PI_OVER_6;
        float y = COS_PI_OVER_6 * arcWidth;
        float height = arcWidth - y;
        float arcRectX = (-arcWidth) / 2.0f;
        float arcRectY = (-arcWidth) - y;
        float arcRectWidth = arcWidth * 2.0f;
        float arcRectHeight = arcWidth * 2.0f;
        RectF arcRect = new RectF(arcRectX, arcRectY, arcRectX + arcRectWidth, arcRectY + arcRectHeight);
        Paint arcPaint = new Paint();
        arcPaint.setAntiAlias(true);
        arcPaint.setAlpha(187);
        arcPaint.setStyle(Paint.Style.FILL);
        Bitmap bitmap = Bitmap.createBitmap((int) arcWidth, (int) height, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawArc(arcRect, 45.0f, 90.0f, true, arcPaint);
        return new StaticResource(bitmap);
    }

    private static int getResourceId(String name) {
        Resources systemResources = Resources.getSystem();
        return systemResources.getIdentifier(name, null, null);
    }
}
