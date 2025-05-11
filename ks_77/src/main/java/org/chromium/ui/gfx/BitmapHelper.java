package org.chromium.ui.gfx;

import android.graphics.Bitmap;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("gfx")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/gfx/BitmapHelper.class */
public class BitmapHelper {
    @CalledByNative
    private static Bitmap createBitmap(int width, int height, int bitmapFormatValue) {
        Bitmap.Config bitmapConfig = getBitmapConfigForFormat(bitmapFormatValue);
        return Bitmap.createBitmap(width, height, bitmapConfig);
    }

    /* renamed from: org.chromium.ui.gfx.BitmapHelper$1  reason: invalid class name */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/gfx/BitmapHelper$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        static {
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @CalledByNative
    private static int getBitmapFormatForConfig(Bitmap.Config bitmapConfig) {
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[bitmapConfig.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 0;
        }
    }

    private static Bitmap.Config getBitmapConfigForFormat(int bitmapFormatValue) {
        switch (bitmapFormatValue) {
            case 1:
                return Bitmap.Config.ALPHA_8;
            case 2:
                return Bitmap.Config.ARGB_4444;
            case 3:
            default:
                return Bitmap.Config.ARGB_8888;
            case 4:
                return Bitmap.Config.RGB_565;
        }
    }

    @CalledByNative
    private static int getByteCount(Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
