package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider.class */
public interface BarcodeDetectionProvider extends Interface {
    public static final Interface.Manager<BarcodeDetectionProvider, Proxy> MANAGER = BarcodeDetectionProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider$EnumerateSupportedFormatsResponse.class */
    public interface EnumerateSupportedFormatsResponse extends Callbacks.Callback1<int[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/BarcodeDetectionProvider$Proxy.class */
    public interface Proxy extends BarcodeDetectionProvider, Interface.Proxy {
    }

    void createBarcodeDetection(InterfaceRequest<BarcodeDetection> interfaceRequest, BarcodeDetectorOptions barcodeDetectorOptions);

    void enumerateSupportedFormats(EnumerateSupportedFormatsResponse enumerateSupportedFormatsResponse);
}
