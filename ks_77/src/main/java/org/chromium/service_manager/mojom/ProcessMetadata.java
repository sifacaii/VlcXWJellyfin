package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ProcessId;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ProcessMetadata.class */
public interface ProcessMetadata extends Interface {
    public static final Interface.Manager<ProcessMetadata, Proxy> MANAGER = ProcessMetadata_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ProcessMetadata$Proxy.class */
    public interface Proxy extends ProcessMetadata, Interface.Proxy {
    }

    void setPid(ProcessId processId);
}
