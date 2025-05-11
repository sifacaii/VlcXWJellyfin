package org.chromium.shape_detection;

import android.graphics.Bitmap;
import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;
import org.chromium.mojo_base.BigBufferUtil;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/BitmapUtils.class */
public class BitmapUtils {
    public static Bitmap convertToBitmap(org.chromium.skia.mojom.Bitmap bitmapData) {
        if (bitmapData.imageInfo == null) {
            return null;
        }
        int width = bitmapData.imageInfo.width;
        int height = bitmapData.imageInfo.height;
        long numPixels = width * height;
        if (bitmapData.pixelData == null || width <= 0 || height <= 0 || numPixels > 2305843009213693951L) {
            return null;
        }
        if (bitmapData.imageInfo.colorType != 4 && bitmapData.imageInfo.colorType != 5) {
            return null;
        }
        ByteBuffer imageBuffer = ByteBuffer.wrap(BigBufferUtil.getBytesFromBigBuffer(bitmapData.pixelData));
        if (imageBuffer.capacity() <= 0) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.copyPixelsFromBuffer(imageBuffer);
        return bitmap;
    }

    public static Frame convertToFrame(org.chromium.skia.mojom.Bitmap bitmapData) {
        Bitmap bitmap = convertToBitmap(bitmapData);
        if (bitmap == null) {
            return null;
        }
        return new Frame.Builder().setBitmap(bitmap).build();
    }
}
