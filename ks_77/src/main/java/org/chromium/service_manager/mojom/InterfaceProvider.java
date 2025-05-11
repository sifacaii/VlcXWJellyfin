package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/InterfaceProvider.class */
public interface InterfaceProvider extends Interface {
    public static final Interface.Manager<InterfaceProvider, Proxy> MANAGER = InterfaceProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/InterfaceProvider$Proxy.class */
    public interface Proxy extends InterfaceProvider, Interface.Proxy {
    }

    void getInterface(String str, MessagePipeHandle messagePipeHandle);
}
