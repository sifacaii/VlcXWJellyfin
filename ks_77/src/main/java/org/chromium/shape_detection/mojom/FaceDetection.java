package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetection.class */
public interface FaceDetection extends Interface {
    public static final Interface.Manager<FaceDetection, Proxy> MANAGER = FaceDetection_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetection$DetectResponse.class */
    public interface DetectResponse extends Callbacks.Callback1<FaceDetectionResult[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetection$Proxy.class */
    public interface Proxy extends FaceDetection, Interface.Proxy {
    }

    void detect(Bitmap bitmap, DetectResponse detectResponse);
}
