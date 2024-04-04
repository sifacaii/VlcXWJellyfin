package org.chromium.shape_detection;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.BarcodeDetection;
import org.chromium.shape_detection.mojom.BarcodeDetectionResult;
import org.chromium.shape_detection.mojom.BarcodeDetectorOptions;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/BarcodeDetectionImpl.class */
public class BarcodeDetectionImpl implements BarcodeDetection {
    private static final String TAG = "BarcodeDetectionImpl";
    private BarcodeDetector mBarcodeDetector;

    public BarcodeDetectionImpl(BarcodeDetectorOptions options) {
        int formats = 0;
        if (options.formats != null && options.formats.length > 0) {
            formats = 0;
            for (int i = 0; i < options.formats.length; i++) {
                if (options.formats[i] == 0) {
                    formats |= 4096;
                } else if (options.formats[i] == 1) {
                    formats |= 1;
                } else if (options.formats[i] == 2) {
                    formats |= 2;
                } else if (options.formats[i] == 3) {
                    formats |= 4;
                } else if (options.formats[i] == 4) {
                    formats |= 8;
                } else if (options.formats[i] == 5) {
                    formats |= 16;
                } else if (options.formats[i] == 6) {
                    formats |= 32;
                } else if (options.formats[i] == 7) {
                    formats |= 64;
                } else if (options.formats[i] == 8) {
                    formats |= 128;
                } else if (options.formats[i] == 9) {
                    formats |= 2048;
                } else if (options.formats[i] == 10) {
                    formats |= 256;
                } else if (options.formats[i] == 12) {
                    formats |= 512;
                } else if (options.formats[i] == 13) {
                    formats |= 1024;
                } else {
                    Log.e(TAG, "Unsupported barcode format hint: " + options.formats[i], new Object[0]);
                }
            }
        }
        this.mBarcodeDetector = new BarcodeDetector.Builder(ContextUtils.getApplicationContext()).setBarcodeFormats(formats).build();
    }

    @Override // org.chromium.shape_detection.mojom.BarcodeDetection
    public void detect(Bitmap bitmapData, BarcodeDetection.DetectResponse callback) {
        if (!this.mBarcodeDetector.isOperational()) {
            Log.e(TAG, "BarcodeDetector is not operational", new Object[0]);
            callback.call(new BarcodeDetectionResult[0]);
            return;
        }
        Frame frame = BitmapUtils.convertToFrame(bitmapData);
        if (frame == null) {
            Log.e(TAG, "Error converting Mojom Bitmap to Frame", new Object[0]);
            callback.call(new BarcodeDetectionResult[0]);
            return;
        }
        SparseArray<Barcode> barcodes = this.mBarcodeDetector.detect(frame);
        BarcodeDetectionResult[] barcodeArray = new BarcodeDetectionResult[barcodes.size()];
        for (int i = 0; i < barcodes.size(); i++) {
            barcodeArray[i] = new BarcodeDetectionResult();
            Barcode barcode = barcodes.valueAt(i);
            barcodeArray[i].rawValue = barcode.rawValue;
            Rect rect = barcode.getBoundingBox();
            barcodeArray[i].boundingBox = new RectF();
            barcodeArray[i].boundingBox.x = rect.left;
            barcodeArray[i].boundingBox.y = rect.top;
            barcodeArray[i].boundingBox.width = rect.width();
            barcodeArray[i].boundingBox.height = rect.height();
            Point[] corners = barcode.cornerPoints;
            barcodeArray[i].cornerPoints = new PointF[corners.length];
            for (int j = 0; j < corners.length; j++) {
                barcodeArray[i].cornerPoints[j] = new PointF();
                barcodeArray[i].cornerPoints[j].x = corners[j].x;
                barcodeArray[i].cornerPoints[j].y = corners[j].y;
            }
            barcodeArray[i].format = toBarcodeFormat(barcode.format);
        }
        callback.call(barcodeArray);
    }

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mBarcodeDetector.release();
    }

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
        close();
    }

    private int toBarcodeFormat(int format) {
        switch (format) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 4:
                return 3;
            case 8:
                return 4;
            case 16:
                return 5;
            case 32:
                return 6;
            case 64:
                return 7;
            case 128:
                return 8;
            case 256:
                return 10;
            case 512:
                return 12;
            case 1024:
                return 13;
            case 2048:
                return 9;
            case 4096:
                return 0;
            default:
                return 11;
        }
    }
}
