package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/TextDetection.class */
public interface TextDetection extends Interface {
    public static final Interface.Manager<TextDetection, Proxy> MANAGER = TextDetection_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/TextDetection$DetectResponse.class */
    public interface DetectResponse extends Callbacks.Callback1<TextDetectionResult[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/TextDetection$Proxy.class */
    public interface Proxy extends TextDetection, Interface.Proxy {
    }

    void detect(Bitmap bitmap, DetectResponse detectResponse);
}
