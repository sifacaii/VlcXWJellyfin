package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/LeakDetector.class */
public interface LeakDetector extends Interface {
    public static final Interface.Manager<LeakDetector, Proxy> MANAGER = LeakDetector_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/LeakDetector$PerformLeakDetectionResponse.class */
    public interface PerformLeakDetectionResponse extends Callbacks.Callback1<LeakDetectionResult> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/LeakDetector$Proxy.class */
    public interface Proxy extends LeakDetector, Interface.Proxy {
    }

    void performLeakDetection(PerformLeakDetectionResponse performLeakDetectionResponse);
}
