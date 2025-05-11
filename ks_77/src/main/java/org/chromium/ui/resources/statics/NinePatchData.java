package org.chromium.ui.resources.statics;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/resources/statics/NinePatchData.class */
public class NinePatchData {
    private final int mWidth;
    private final int mHeight;
    private final Rect mPadding;
    private final int[] mDivX;
    private final int[] mDivY;
    private Rect mAperture;

    private NinePatchData(int width, int height, Rect padding, int[] divX, int[] divY) {
        this.mWidth = width;
        this.mHeight = height;
        this.mPadding = new Rect(padding.left, padding.top, this.mWidth - padding.right, this.mHeight - padding.bottom);
        this.mDivX = new int[divX.length];
        this.mDivY = new int[divY.length];
        System.arraycopy(divX, 0, this.mDivX, 0, divX.length);
        System.arraycopy(divY, 0, this.mDivY, 0, divY.length);
        this.mAperture = new Rect(this.mDivX[0], this.mDivY[0], this.mDivX[1], this.mDivY[1]);
    }

    public Rect getPadding() {
        return this.mPadding;
    }

    public Rect getAperture() {
        return this.mAperture;
    }

    public static NinePatchData create(Bitmap bitmap) {
        int numDivX;
        int numDivY;
        if (bitmap == null) {
            return null;
        }
        try {
            byte[] chunk = bitmap.getNinePatchChunk();
            if (chunk == null || !NinePatch.isNinePatchChunk(chunk)) {
                return null;
            }
            ByteBuffer buffer = ByteBuffer.wrap(chunk).order(ByteOrder.nativeOrder());
            if (buffer.get() == 0 || (numDivX = buffer.get()) == 0 || (numDivX & 1) != 0 || (numDivY = buffer.get()) == 0 || (numDivY & 1) != 0) {
                return null;
            }
            buffer.get();
            buffer.getInt();
            buffer.getInt();
            Rect padding = new Rect();
            padding.left = buffer.getInt();
            padding.right = buffer.getInt();
            padding.top = buffer.getInt();
            padding.bottom = buffer.getInt();
            buffer.getInt();
            int[] divX = new int[numDivX];
            for (int i = 0; i < numDivX; i++) {
                divX[i] = buffer.getInt();
            }
            int[] divY = new int[numDivY];
            for (int i2 = 0; i2 < numDivY; i2++) {
                divY[i2] = buffer.getInt();
            }
            return new NinePatchData(bitmap.getWidth(), bitmap.getHeight(), padding, divX, divY);
        } catch (BufferUnderflowException e) {
            return null;
        }
    }
}
