package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetectionProvider.class */
public interface FaceDetectionProvider extends Interface {
    public static final Interface.Manager<FaceDetectionProvider, Proxy> MANAGER = FaceDetectionProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/FaceDetectionProvider$Proxy.class */
    public interface Proxy extends FaceDetectionProvider, Interface.Proxy {
    }

    void createFaceDetection(InterfaceRequest<FaceDetection> interfaceRequest, FaceDetectorOptions faceDetectorOptions);
}
