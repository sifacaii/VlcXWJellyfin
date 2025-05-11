package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.Bitmap;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetection.class */
public interface BarcodeDetection extends Interface {
    public static final Interface.Manager<BarcodeDetection, Proxy> MANAGER = BarcodeDetection_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetection$DetectResponse.class */
    public interface DetectResponse extends Callbacks.Callback1<BarcodeDetectionResult[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetection$Proxy.class */
    public interface Proxy extends BarcodeDetection, Interface.Proxy {
    }

    void detect(Bitmap bitmap, DetectResponse detectResponse);
}
