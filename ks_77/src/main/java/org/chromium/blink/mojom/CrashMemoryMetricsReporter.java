package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CrashMemoryMetricsReporter.class */
public interface CrashMemoryMetricsReporter extends Interface {
    public static final Interface.Manager<CrashMemoryMetricsReporter, Proxy> MANAGER = CrashMemoryMetricsReporter_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CrashMemoryMetricsReporter$Proxy.class */
    public interface Proxy extends CrashMemoryMetricsReporter, Interface.Proxy {
    }

    void setSharedMemory(UnsafeSharedMemoryRegion unsafeSharedMemoryRegion);
}
