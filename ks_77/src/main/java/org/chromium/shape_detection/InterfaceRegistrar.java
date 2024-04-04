package org.chromium.shape_detection;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceRegistry;
import org.chromium.shape_detection.BarcodeDetectionProviderImpl;
import org.chromium.shape_detection.FaceDetectionProviderImpl;
import org.chromium.shape_detection.TextDetectionImpl;
import org.chromium.shape_detection.mojom.BarcodeDetectionProvider;
import org.chromium.shape_detection.mojom.ConstantsConstants;
import org.chromium.shape_detection.mojom.FaceDetectionProvider;
import org.chromium.shape_detection.mojom.TextDetection;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/InterfaceRegistrar.class */
class InterfaceRegistrar {
    InterfaceRegistrar() {
    }

    @CalledByNative
    static void createInterfaceRegistryForContext(int nativeHandle) {
        InterfaceRegistry registry = InterfaceRegistry.create(CoreImpl.getInstance().acquireNativeHandle(nativeHandle).toMessagePipeHandle());
        registry.addInterface(BarcodeDetectionProvider.MANAGER, new BarcodeDetectionProviderImpl.Factory());
        registry.addInterface(FaceDetectionProvider.MANAGER, new FaceDetectionProviderImpl.Factory());
        registry.addInterface(TextDetection.MANAGER, new TextDetectionImpl.Factory());
    }
}
