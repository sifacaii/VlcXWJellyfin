package org.chromium.shape_detection;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.FaceDetection;
import org.chromium.shape_detection.mojom.FaceDetectionResult;
import org.chromium.shape_detection.mojom.FaceDetectorOptions;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/FaceDetectionImplGmsCore.class */
public class FaceDetectionImplGmsCore implements FaceDetection {
    private static final String TAG = "FaceDetectionImpl";
    private static final int MAX_FACES = 32;
    private static final int MAX_EULER_Z = 15;
    private final int mMaxFaces;
    private final boolean mFastMode;
    private final FaceDetector mFaceDetector;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FaceDetectionImplGmsCore.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FaceDetectionImplGmsCore(FaceDetectorOptions options) {
        FaceDetector.Builder builder = new FaceDetector.Builder(ContextUtils.getApplicationContext());
        this.mMaxFaces = Math.min(options.maxDetectedFaces, 32);
        this.mFastMode = options.fastMode;
        try {
            builder.setMode(this.mFastMode ? 0 : 1);
            builder.setLandmarkType(1);
            if (this.mMaxFaces == 1) {
                builder.setProminentFaceOnly(true);
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Unexpected exception " + e, new Object[0]);
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        this.mFaceDetector = builder.build();
    }

    @Override // org.chromium.shape_detection.mojom.FaceDetection
    public void detect(Bitmap bitmapData, FaceDetection.DetectResponse callback) {
        float f;
        float f2;
        if (!this.mFaceDetector.isOperational()) {
            Log.e(TAG, "FaceDetector is not operational", new Object[0]);
            FaceDetectorOptions options = new FaceDetectorOptions();
            options.fastMode = this.mFastMode;
            options.maxDetectedFaces = this.mMaxFaces;
            FaceDetectionImpl detector = new FaceDetectionImpl(options);
            detector.detect(bitmapData, callback);
            return;
        }
        Frame frame = BitmapUtils.convertToFrame(bitmapData);
        if (frame == null) {
            Log.e(TAG, "Error converting Mojom Bitmap to Frame", new Object[0]);
            callback.call(new FaceDetectionResult[0]);
            return;
        }
        SparseArray<Face> faces = this.mFaceDetector.detect(frame);
        FaceDetectionResult[] faceArray = new FaceDetectionResult[faces.size()];
        for (int i = 0; i < faces.size(); i++) {
            faceArray[i] = new FaceDetectionResult();
            Face face = faces.valueAt(i);
            List<Landmark> landmarks = face.getLandmarks();
            ArrayList<org.chromium.shape_detection.mojom.Landmark> mojoLandmarks = new ArrayList<>(landmarks.size());
            int leftEyeIndex = -1;
            int rightEyeIndex = -1;
            int bottomMouthIndex = -1;
            for (int j = 0; j < landmarks.size(); j++) {
                Landmark landmark = landmarks.get(j);
                int landmarkType = landmark.getType();
                if (landmarkType == 4 || landmarkType == 10 || landmarkType == 0 || landmarkType == 6) {
                    org.chromium.shape_detection.mojom.Landmark mojoLandmark = new org.chromium.shape_detection.mojom.Landmark();
                    mojoLandmark.locations = new PointF[1];
                    mojoLandmark.locations[0] = new PointF();
                    mojoLandmark.locations[0].x = landmark.getPosition().x;
                    mojoLandmark.locations[0].y = landmark.getPosition().y;
                    if (landmarkType == 4) {
                        mojoLandmark.type = 1;
                        leftEyeIndex = j;
                    } else if (landmarkType == 10) {
                        mojoLandmark.type = 1;
                        rightEyeIndex = j;
                    } else if (landmarkType == 0) {
                        mojoLandmark.type = 0;
                        bottomMouthIndex = j;
                    } else if (!$assertionsDisabled && landmarkType != 6) {
                        throw new AssertionError();
                    } else {
                        mojoLandmark.type = 2;
                    }
                    mojoLandmarks.add(mojoLandmark);
                }
            }
            faceArray[i].landmarks = (org.chromium.shape_detection.mojom.Landmark[]) mojoLandmarks.toArray(new org.chromium.shape_detection.mojom.Landmark[mojoLandmarks.size()]);
            android.graphics.PointF corner = face.getPosition();
            faceArray[i].boundingBox = new RectF();
            if (leftEyeIndex != -1 && rightEyeIndex != -1 && Math.abs(face.getEulerZ()) < 15.0f) {
                android.graphics.PointF leftEyePoint = landmarks.get(leftEyeIndex).getPosition();
                android.graphics.PointF rightEyePoint = landmarks.get(rightEyeIndex).getPosition();
                float eyesDistance = leftEyePoint.x - rightEyePoint.x;
                if (bottomMouthIndex != -1) {
                    f = landmarks.get(bottomMouthIndex).getPosition().y - leftEyePoint.y;
                } else {
                    f = -1.0f;
                }
                float eyeMouthDistance = f;
                android.graphics.PointF midEyePoint = new android.graphics.PointF(corner.x + (face.getWidth() / 2.0f), leftEyePoint.y);
                faceArray[i].boundingBox.x = (2.0f * rightEyePoint.x) - midEyePoint.x;
                faceArray[i].boundingBox.y = midEyePoint.y - eyesDistance;
                faceArray[i].boundingBox.width = 2.0f * eyesDistance;
                RectF rectF = faceArray[i].boundingBox;
                if (eyeMouthDistance > eyesDistance) {
                    f2 = eyeMouthDistance + eyesDistance;
                } else {
                    f2 = 2.0f * eyesDistance;
                }
                rectF.height = f2;
            } else {
                faceArray[i].boundingBox.x = corner.x;
                faceArray[i].boundingBox.y = corner.y;
                faceArray[i].boundingBox.width = face.getWidth();
                faceArray[i].boundingBox.height = face.getHeight();
            }
        }
        callback.call(faceArray);
    }

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mFaceDetector.release();
    }

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
        close();
    }
}
