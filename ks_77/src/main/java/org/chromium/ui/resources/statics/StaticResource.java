package org.chromium.ui.resources.statics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceFactory;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/statics/StaticResource.class */
public class StaticResource implements Resource {
    private Bitmap mBitmap;
    private final NinePatchData mNinePatchData;
    private final Rect mBitmapSize;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !StaticResource.class.desiredAssertionStatus();
    }

    public StaticResource(Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.mNinePatchData = NinePatchData.create(this.mBitmap);
        this.mBitmapSize = new Rect(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
    }

    @Override // org.chromium.ui.resources.Resource
    public NinePatchData getNinePatchData() {
        return this.mNinePatchData;
    }

    @Override // org.chromium.ui.resources.Resource
    public Bitmap getBitmap() {
        if ($assertionsDisabled || this.mBitmap != null) {
            Bitmap bitmap = this.mBitmap;
            this.mBitmap = null;
            return bitmap;
        }
        throw new AssertionError("StaticResource#getBitmap can only be called once per lifecycle");
    }

    @Override // org.chromium.ui.resources.Resource
    public Rect getBitmapSize() {
        return this.mBitmapSize;
    }

    @Override // org.chromium.ui.resources.Resource
    public long createNativeResource() {
        return ResourceFactory.createBitmapResource(this.mNinePatchData);
    }

    public static StaticResource create(Resources resources, int resId, int fitWidth, int fitHeight) {
        if (resId <= 0) {
            return null;
        }
        Bitmap bitmap = decodeBitmap(resources, resId, fitWidth, fitHeight);
        if (bitmap == null) {
            bitmap = decodeDrawable(resources, resId, fitWidth, fitHeight);
        }
        if (bitmap == null) {
            return null;
        }
        return new StaticResource(bitmap);
    }

    private static Bitmap decodeBitmap(Resources resources, int resId, int fitWidth, int fitHeight) {
        BitmapFactory.Options options = createOptions(resources, resId, fitWidth, fitHeight);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeResource(resources, resId, options);
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getConfig() == options.inPreferredConfig) {
            return bitmap;
        }
        Bitmap convertedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), options.inPreferredConfig);
        Canvas canvas = new Canvas(convertedBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        bitmap.recycle();
        return convertedBitmap;
    }

    private static Bitmap decodeDrawable(Resources resources, int resId, int fitWidth, int fitHeight) {
        try {
            Drawable drawable = ApiCompatibilityUtils.getDrawable(resources, resId);
            int width = Math.max(drawable.getMinimumWidth(), Math.max(fitWidth, 1));
            int height = Math.max(drawable.getMinimumHeight(), Math.max(fitHeight, 1));
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return bitmap;
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    private static BitmapFactory.Options createOptions(Resources resources, int resId, int fitWidth, int fitHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (fitWidth == 0 || fitHeight == 0) {
            return options;
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, resId, options);
        options.inJustDecodeBounds = false;
        if (options.outHeight > fitHeight || options.outWidth > fitWidth) {
            int heightRatio = Math.round(options.outHeight / fitHeight);
            int widthRatio = Math.round(options.outWidth / fitWidth);
            options.inSampleSize = Math.min(heightRatio, widthRatio);
            return options;
        }
        return options;
    }
}
