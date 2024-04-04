package org.chromium.shape_detection;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.services.service_manager.InterfaceFactory;
import org.chromium.shape_detection.mojom.TextDetection;
import org.chromium.shape_detection.mojom.TextDetectionResult;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/TextDetectionImpl.class */
public class TextDetectionImpl implements TextDetection {
    private static final String TAG = "TextDetectionImpl";
    private TextRecognizer mTextRecognizer = new TextRecognizer.Builder(ContextUtils.getApplicationContext()).build();

    @Override // org.chromium.shape_detection.mojom.TextDetection
    public void detect(Bitmap bitmapData, TextDetection.DetectResponse callback) {
        if (!this.mTextRecognizer.isOperational()) {
            Log.e(TAG, "TextDetector is not operational", new Object[0]);
            callback.call(new TextDetectionResult[0]);
            return;
        }
        Frame frame = BitmapUtils.convertToFrame(bitmapData);
        if (frame == null) {
            Log.e(TAG, "Error converting Mojom Bitmap to Frame", new Object[0]);
            callback.call(new TextDetectionResult[0]);
            return;
        }
        SparseArray<TextBlock> textBlocks = this.mTextRecognizer.detect(frame);
        TextDetectionResult[] detectedTextArray = new TextDetectionResult[textBlocks.size()];
        for (int i = 0; i < textBlocks.size(); i++) {
            detectedTextArray[i] = new TextDetectionResult();
            TextBlock textBlock = textBlocks.valueAt(i);
            detectedTextArray[i].rawValue = textBlock.getValue();
            Rect rect = textBlock.getBoundingBox();
            detectedTextArray[i].boundingBox = new RectF();
            detectedTextArray[i].boundingBox.x = rect.left;
            detectedTextArray[i].boundingBox.y = rect.top;
            detectedTextArray[i].boundingBox.width = rect.width();
            detectedTextArray[i].boundingBox.height = rect.height();
            Point[] corners = textBlock.getCornerPoints();
            detectedTextArray[i].cornerPoints = new PointF[corners.length];
            for (int j = 0; j < corners.length; j++) {
                detectedTextArray[i].cornerPoints[j] = new PointF();
                detectedTextArray[i].cornerPoints[j].x = corners[j].x;
                detectedTextArray[i].cornerPoints[j].y = corners[j].y;
            }
        }
        callback.call(detectedTextArray);
    }

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mTextRecognizer.release();
    }

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
        close();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/TextDetectionImpl$Factory.class */
    public static class Factory implements InterfaceFactory<TextDetection> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.services.service_manager.InterfaceFactory
        public TextDetection createImpl() {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ContextUtils.getApplicationContext()) != 0) {
                Log.e(TextDetectionImpl.TAG, "Google Play Services not available", new Object[0]);
                return null;
            }
            return new TextDetectionImpl();
        }
    }
}
