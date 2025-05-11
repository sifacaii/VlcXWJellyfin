package org.chromium.ui.resources;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/HandleViewResources.class */
public class HandleViewResources {
    private static final float HANDLE_HORIZONTAL_PADDING_RATIO = 0.25f;
    private static final int[] LEFT_HANDLE_ATTRS;
    private static final int[] CENTER_HANDLE_ATTRS;
    private static final int[] RIGHT_HANDLE_ATTRS;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !HandleViewResources.class.desiredAssertionStatus();
        LEFT_HANDLE_ATTRS = new int[]{16843461};
        CENTER_HANDLE_ATTRS = new int[]{16843463};
        RIGHT_HANDLE_ATTRS = new int[]{16843462};
    }

    public static Drawable getLeftHandleDrawable(Context context) {
        return getHandleDrawable(context, LEFT_HANDLE_ATTRS);
    }

    public static Drawable getCenterHandleDrawable(Context context) {
        return getHandleDrawable(context, CENTER_HANDLE_ATTRS);
    }

    public static Drawable getRightHandleDrawable(Context context) {
        return getHandleDrawable(context, RIGHT_HANDLE_ATTRS);
    }

    private static Drawable getHandleDrawable(Context context, int[] attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs);
        Drawable drawable = a.getDrawable(0);
        if (drawable == null) {
            try {
                drawable = ApiCompatibilityUtils.getDrawable(context.getResources(), a.getResourceId(0, 0));
            } catch (Resources.NotFoundException e) {
            }
        }
        a.recycle();
        return drawable;
    }

    private static Bitmap getHandleBitmap(Context activityContext, int[] attrs) {
        Bitmap bitmap;
        Context context = activityContext;
        if (context == null) {
            context = ContextUtils.getApplicationContext();
        }
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs);
        int resId = a.getResourceId(a.getIndex(0), 0);
        Resources res = a.getResources();
        a.recycle();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = config;
        Bitmap bitmap2 = BitmapFactory.decodeResource(res, resId, options);
        if (bitmap2 != null) {
            return bitmap2;
        }
        if (res == context.getResources() || (bitmap = BitmapFactory.decodeResource(context.getResources(), resId, options)) == null) {
            Drawable drawable = getHandleDrawable(context, attrs);
            if ($assertionsDisabled || drawable != null) {
                int width = drawable.getIntrinsicWidth();
                int height = drawable.getIntrinsicHeight();
                Bitmap canvasBitmap = Bitmap.createBitmap(width, height, config);
                Canvas canvas = new Canvas(canvasBitmap);
                drawable.setBounds(0, 0, width, height);
                drawable.draw(canvas);
                return canvasBitmap;
            }
            throw new AssertionError();
        }
        return bitmap;
    }

    @CalledByNative
    public static float getHandleHorizontalPaddingRatio() {
        return HANDLE_HORIZONTAL_PADDING_RATIO;
    }

    @CalledByNative
    private static Bitmap getLeftHandleBitmap(Context context) {
        return getHandleBitmap(context, LEFT_HANDLE_ATTRS);
    }

    @CalledByNative
    private static Bitmap getCenterHandleBitmap(Context context) {
        return getHandleBitmap(context, CENTER_HANDLE_ATTRS);
    }

    @CalledByNative
    private static Bitmap getRightHandleBitmap(Context context) {
        return getHandleBitmap(context, RIGHT_HANDLE_ATTRS);
    }
}
