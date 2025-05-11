package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsAgent.class */
public interface DevToolsAgent extends Interface {
    public static final Interface.Manager<DevToolsAgent, Proxy> MANAGER = DevToolsAgent_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsAgent$Proxy.class */
    public interface Proxy extends DevToolsAgent, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsAgent$ReportChildWorkersResponse.class */
    public interface ReportChildWorkersResponse extends Callbacks.Callback0 {
    }

    void attachDevToolsSession(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported, InterfaceRequest<DevToolsSession> interfaceRequest, DevToolsSessionState devToolsSessionState, boolean z);

    void inspectElement(Point point);

    void reportChildWorkers(boolean z, boolean z2, ReportChildWorkersResponse reportChildWorkersResponse);
}
