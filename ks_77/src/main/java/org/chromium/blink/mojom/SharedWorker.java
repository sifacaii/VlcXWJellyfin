package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorker.class */
public interface SharedWorker extends Interface {
    public static final Interface.Manager<SharedWorker, Proxy> MANAGER = SharedWorker_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorker$Proxy.class */
    public interface Proxy extends SharedWorker, Interface.Proxy {
    }

    void connect(int i, MessagePipeHandle messagePipeHandle);

    void terminate();

    void bindDevToolsAgent(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
