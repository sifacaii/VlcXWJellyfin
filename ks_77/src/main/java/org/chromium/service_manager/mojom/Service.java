package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service.class */
public interface Service extends Interface {
    public static final Interface.Manager<Service, Proxy> MANAGER = Service_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service$OnBindInterfaceResponse.class */
    public interface OnBindInterfaceResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service$OnStartResponse.class */
    public interface OnStartResponse extends Callbacks.Callback2<InterfaceRequest<Connector>, AssociatedInterfaceRequestNotSupported> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service$Proxy.class */
    public interface Proxy extends Service, Interface.Proxy {
    }

    void onStart(Identity identity, OnStartResponse onStartResponse);

    void onBindInterface(BindSourceInfo bindSourceInfo, String str, MessagePipeHandle messagePipeHandle, OnBindInterfaceResponse onBindInterfaceResponse);

    void createPackagedServiceInstance(Identity identity, InterfaceRequest<Service> interfaceRequest, ProcessMetadata processMetadata);
}
